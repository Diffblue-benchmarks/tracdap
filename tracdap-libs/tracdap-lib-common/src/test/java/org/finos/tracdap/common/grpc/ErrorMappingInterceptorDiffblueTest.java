package org.finos.tracdap.common.grpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import org.finos.tracdap.common.grpc.DelayedExecutionInterceptor.DelayedExecutionCall;
import org.finos.tracdap.common.grpc.DelayedExecutionInterceptor.DelayedExecutionListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ErrorMappingInterceptorDiffblueTest {
  /**
   * Test {@link ErrorMappingInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}.
   *
   * <p>Method under test: {@link ErrorMappingInterceptor#interceptCall(ServerCall, Metadata,
   * ServerCallHandler)}
   */
  @Test
  @DisplayName("Test interceptCall(ServerCall, Metadata, ServerCallHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerCall.Listener ErrorMappingInterceptor.interceptCall(ServerCall, Metadata, ServerCallHandler)"
  })
  void testInterceptCall() {
    // Arrange
    ErrorMappingInterceptor errorMappingInterceptor = new ErrorMappingInterceptor();

    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> serverCall = new DelayedExecutionCall<>(delegate);
    Metadata headers = new Metadata();

    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate2);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call, new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);

    // Act
    errorMappingInterceptor.interceptCall(serverCall, headers, next);

    // Assert
    verify(delegate).request(1);
    verify(delegate2).request(1);
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
  }
}

package org.finos.tracdap.common.grpc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RequestMetadataInterceptorDiffblueTest {
  /**
   * Method under test:
   * {@link RequestMetadataInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  void testInterceptCall() {
    // Arrange
    RequestMetadataInterceptor requestMetadataInterceptor = new RequestMetadataInterceptor();
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    Metadata headers = new Metadata();
    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate2);
    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(new DelayedExecutionInterceptor.DelayedExecutionListener<>(call2, new Metadata(),
            mock(ServerCallHandler.class)));

    // Act
    requestMetadataInterceptor.interceptCall(call, headers, next);

    // Assert
    verify(delegate).request(eq(1));
    verify(delegate2).request(eq(1));
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
  }
}

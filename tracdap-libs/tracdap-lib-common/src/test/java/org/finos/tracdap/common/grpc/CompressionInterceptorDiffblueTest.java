package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import org.finos.tracdap.common.grpc.DelayedExecutionInterceptor.DelayedExecutionCall;
import org.finos.tracdap.common.grpc.DelayedExecutionInterceptor.DelayedExecutionListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CompressionInterceptorDiffblueTest {
  /**
   * Test {@link CompressionInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}.
   * <ul>
   *   <li>Then return {@link DelayedExecutionListener}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressionInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  @DisplayName("Test interceptCall(ServerCall, Metadata, ServerCallHandler); then return DelayedExecutionListener")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Listener CompressionInterceptor.interceptCall(ServerCall, Metadata, ServerCallHandler)"})
  void testInterceptCall_thenReturnDelayedExecutionListener() {
    // Arrange
    CompressionInterceptor compressionInterceptor = new CompressionInterceptor();
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    doNothing().when(delegate).setCompression(Mockito.<String>any());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);
    Metadata headers = new Metadata();
    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionCall<>(delegate2);
    DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionListener<>(call2,
        new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);

    // Act
    Listener<Object> actualInterceptCallResult = compressionInterceptor.interceptCall(call, headers, next);

    // Assert
    verify(delegate).request(eq(1));
    verify(delegate2).request(eq(1));
    verify(delegate).setCompression(eq("gzip"));
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionListener);
    assertSame(delayedExecutionListener, actualInterceptCallResult);
  }
}

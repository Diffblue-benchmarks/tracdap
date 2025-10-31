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
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CompressionInterceptorDiffblueTest {
  /**
   * Method under test:
   * {@link CompressionInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  void testInterceptCall() {
    // Arrange
    CompressionInterceptor compressionInterceptor = new CompressionInterceptor();
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    doNothing().when(delegate).setCompression(Mockito.<String>any());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    Metadata headers = new Metadata();
    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate2);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call2, new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);

    // Act
    ServerCall.Listener<Object> actualInterceptCallResult = compressionInterceptor.interceptCall(call, headers, next);

    // Assert
    verify(delegate).request(eq(1));
    verify(delegate2).request(eq(1));
    verify(delegate).setCompression(eq("gzip"));
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionInterceptor.DelayedExecutionListener);
    assertSame(delayedExecutionListener, actualInterceptCallResult);
  }
}

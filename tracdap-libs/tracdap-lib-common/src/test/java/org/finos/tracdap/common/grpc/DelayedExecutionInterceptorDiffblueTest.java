package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DelayedExecutionInterceptorDiffblueTest {
  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionCall#DelayedExecutionCall(ServerCall)}
   */
  @Test
  void testDelayedExecutionCallNewDelayedExecutionCall() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());

    // Act
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> actualDelayedExecutionCall = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);

    // Assert
    verify(delegate).request(eq(1));
    assertNull(actualDelayedExecutionCall.getMethodDescriptor());
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionCall#request(int)}
   */
  @Test
  void testDelayedExecutionCallRequest() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> delayedExecutionCall = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);

    // Act
    delayedExecutionCall.request(10);

    // Assert
    verify(delegate, atLeast(1)).request(anyInt());
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionCall#request(int)}
   */
  @Test
  void testDelayedExecutionCallRequest2() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> delayedExecutionCall = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);

    // Act
    delayedExecutionCall.request(1);

    // Assert
    verify(delegate).request(eq(1));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionCall#request(int)}
   */
  @Test
  void testDelayedExecutionCallRequest3() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());

    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> delayedExecutionCall = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    delayedExecutionCall.request(0);

    // Act
    delayedExecutionCall.request(1);

    // Assert
    verify(delegate, atLeast(1)).request(eq(1));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionListener#delegate()}
   */
  @Test
  void testDelayedExecutionListenerDelegate() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate2);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call2, new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener2 = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call, new Metadata(), next);

    // Act
    ServerCall.Listener<Object> actualDelegateResult = delayedExecutionListener2.delegate();

    // Assert
    verify(delegate).request(eq(1));
    verify(delegate2).request(eq(1));
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
    assertTrue(actualDelegateResult instanceof DelayedExecutionInterceptor.DelayedExecutionListener);
    assertSame(delayedExecutionListener, actualDelegateResult);
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionListener#onCancel()}
   */
  @Test
  void testDelayedExecutionListenerOnCancel() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onCancel();

    // Assert that nothing has changed
    verify(delegate).request(eq(1));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionListener#onHalfClose()}
   */
  @Test
  void testDelayedExecutionListenerOnHalfClose() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onHalfClose();

    // Assert that nothing has changed
    verify(delegate).request(eq(1));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionListener#onReady()}
   */
  @Test
  void testDelayedExecutionListenerOnReady() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onReady();

    // Assert that nothing has changed
    verify(delegate).request(eq(1));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor.DelayedExecutionListener#startCall()}
   */
  @Test
  void testDelayedExecutionListenerStartCall() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate2);
    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(new DelayedExecutionInterceptor.DelayedExecutionListener<>(call2, new Metadata(),
            mock(ServerCallHandler.class)));
    DelayedExecutionInterceptor.DelayedExecutionListener<Object, Object> delayedExecutionListener = new DelayedExecutionInterceptor.DelayedExecutionListener<>(
        call, new Metadata(), next);

    // Act
    delayedExecutionListener.startCall();

    // Assert
    verify(delegate).request(eq(1));
    verify(delegate2).request(eq(1));
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  void testInterceptCall() {
    // Arrange
    DelayedExecutionInterceptor delayedExecutionInterceptor = new DelayedExecutionInterceptor();
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);

    // Act
    ServerCall.Listener<Object> actualInterceptCallResult = delayedExecutionInterceptor.interceptCall(call,
        new Metadata(), mock(ServerCallHandler.class));

    // Assert
    verify(delegate).request(eq(1));
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionInterceptor.DelayedExecutionListener);
  }

  /**
   * Method under test:
   * {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  void testInterceptCall2() {
    // Arrange
    DelayedExecutionInterceptor delayedExecutionInterceptor = new DelayedExecutionInterceptor();
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());

    DelayedExecutionInterceptor.DelayedExecutionCall<Object, Object> call = new DelayedExecutionInterceptor.DelayedExecutionCall<>(
        delegate);
    call.request(10);

    // Act
    ServerCall.Listener<Object> actualInterceptCallResult = delayedExecutionInterceptor.interceptCall(call,
        new Metadata(), mock(ServerCallHandler.class));

    // Assert
    verify(delegate, atLeast(1)).request(anyInt());
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionInterceptor.DelayedExecutionListener);
  }
}

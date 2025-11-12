package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class DelayedExecutionInterceptorDiffblueTest {
  /**
   * Test DelayedExecutionCall {@link DelayedExecutionCall#DelayedExecutionCall(ServerCall)}.
   *
   * <p>Method under test: {@link DelayedExecutionCall#DelayedExecutionCall(ServerCall)}
   */
  @Test
  @DisplayName("Test DelayedExecutionCall new DelayedExecutionCall(ServerCall)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionCall.<init>(ServerCall)"})
  void testDelayedExecutionCallNewDelayedExecutionCall() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> delegate2 = new DelayedExecutionCall<>(delegate);

    // Act
    DelayedExecutionCall<Object, Object> actualDelayedExecutionCall =
        new DelayedExecutionCall<>(delegate2);

    // Assert
    verify(delegate).request(1);
    assertNull(actualDelayedExecutionCall.getAttributes());
    assertNull(actualDelayedExecutionCall.getMethodDescriptor());
    assertNull(actualDelayedExecutionCall.getSecurityLevel());
    assertNull(actualDelayedExecutionCall.getAuthority());
    assertFalse(actualDelayedExecutionCall.isCancelled());
    assertFalse(actualDelayedExecutionCall.isReady());
  }

  /**
   * Test DelayedExecutionCall {@link DelayedExecutionCall#DelayedExecutionCall(ServerCall)}.
   *
   * <ul>
   *   <li>When {@link ServerCall} {@link ServerCall#request(int)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DelayedExecutionCall#DelayedExecutionCall(ServerCall)}
   */
  @Test
  @DisplayName(
      "Test DelayedExecutionCall new DelayedExecutionCall(ServerCall); when ServerCall request(int) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionCall.<init>(ServerCall)"})
  void testDelayedExecutionCallNewDelayedExecutionCall_whenServerCallRequestDoesNothing() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());

    // Act
    DelayedExecutionCall<Object, Object> actualDelayedExecutionCall =
        new DelayedExecutionCall<>(delegate);

    // Assert
    verify(delegate).request(1);
    assertNull(actualDelayedExecutionCall.getAttributes());
    assertNull(actualDelayedExecutionCall.getMethodDescriptor());
    assertNull(actualDelayedExecutionCall.getSecurityLevel());
    assertNull(actualDelayedExecutionCall.getAuthority());
    assertFalse(actualDelayedExecutionCall.isCancelled());
    assertFalse(actualDelayedExecutionCall.isReady());
  }

  /**
   * Test DelayedExecutionCall {@link DelayedExecutionCall#request(int)}.
   *
   * <p>Method under test: {@link DelayedExecutionCall#request(int)}
   */
  @Test
  @DisplayName("Test DelayedExecutionCall request(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionCall.request(int)"})
  void testDelayedExecutionCallRequest() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> delegate2 = new DelayedExecutionCall<>(delegate);

    DelayedExecutionCall<Object, Object> delayedExecutionCall =
        new DelayedExecutionCall<>(delegate2);
    delayedExecutionCall.request(0);

    // Act
    delayedExecutionCall.request(1);

    // Assert
    verify(delegate, atLeast(1)).request(1);
  }

  /**
   * Test DelayedExecutionCall {@link DelayedExecutionCall#request(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DelayedExecutionCall#request(int)}
   */
  @Test
  @DisplayName("Test DelayedExecutionCall request(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionCall.request(int)"})
  void testDelayedExecutionCallRequest_whenOne() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> delayedExecutionCall =
        new DelayedExecutionCall<>(delegate);

    // Act
    delayedExecutionCall.request(1);

    // Assert
    verify(delegate).request(1);
  }

  /**
   * Test DelayedExecutionCall {@link DelayedExecutionCall#request(int)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link DelayedExecutionCall#request(int)}
   */
  @Test
  @DisplayName("Test DelayedExecutionCall request(int); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionCall.request(int)"})
  void testDelayedExecutionCallRequest_whenTen() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> delayedExecutionCall =
        new DelayedExecutionCall<>(delegate);

    // Act
    delayedExecutionCall.request(10);

    // Assert
    verify(delegate, atLeast(1)).request(anyInt());
  }

  /**
   * Test DelayedExecutionListener {@link DelayedExecutionListener#delegate()}.
   *
   * <p>Method under test: {@link DelayedExecutionListener#delegate()}
   */
  @Test
  @DisplayName("Test DelayedExecutionListener delegate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Listener DelayedExecutionListener.delegate()"})
  void testDelayedExecutionListenerDelegate() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);

    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionCall<>(delegate2);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call2, new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);

    DelayedExecutionListener<Object, Object> delayedExecutionListener2 =
        new DelayedExecutionListener<>(call, new Metadata(), next);

    // Act
    Listener<Object> actualDelegateResult = delayedExecutionListener2.delegate();

    // Assert
    verify(delegate).request(1);
    verify(delegate2).request(1);
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
    assertTrue(actualDelegateResult instanceof DelayedExecutionListener);
    assertSame(delayedExecutionListener, actualDelegateResult);
  }

  /**
   * Test DelayedExecutionListener {@link DelayedExecutionListener#onCancel()}.
   *
   * <p>Method under test: {@link DelayedExecutionListener#onCancel()}
   */
  @Test
  @DisplayName("Test DelayedExecutionListener onCancel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionListener.onCancel()"})
  void testDelayedExecutionListenerOnCancel() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onCancel();

    // Assert
    verify(delegate).request(1);
  }

  /**
   * Test DelayedExecutionListener {@link DelayedExecutionListener#onHalfClose()}.
   *
   * <p>Method under test: {@link DelayedExecutionListener#onHalfClose()}
   */
  @Test
  @DisplayName("Test DelayedExecutionListener onHalfClose()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionListener.onHalfClose()"})
  void testDelayedExecutionListenerOnHalfClose() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onHalfClose();

    // Assert
    verify(delegate).request(1);
  }

  /**
   * Test DelayedExecutionListener {@link DelayedExecutionListener#onReady()}.
   *
   * <p>Method under test: {@link DelayedExecutionListener#onReady()}
   */
  @Test
  @DisplayName("Test DelayedExecutionListener onReady()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionListener.onReady()"})
  void testDelayedExecutionListenerOnReady() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call, new Metadata(), mock(ServerCallHandler.class));

    // Act
    delayedExecutionListener.onReady();

    // Assert
    verify(delegate).request(1);
  }

  /**
   * Test DelayedExecutionListener {@link DelayedExecutionListener#startCall()}.
   *
   * <p>Method under test: {@link DelayedExecutionListener#startCall()}
   */
  @Test
  @DisplayName("Test DelayedExecutionListener startCall()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedExecutionListener.startCall()"})
  void testDelayedExecutionListenerStartCall() {
    // Arrange
    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);

    ServerCall<Object, Object> delegate2 = mock(ServerCall.class);
    doNothing().when(delegate2).request(anyInt());
    DelayedExecutionCall<Object, Object> call2 = new DelayedExecutionCall<>(delegate2);
    DelayedExecutionListener<Object, Object> delayedExecutionListener =
        new DelayedExecutionListener<>(call2, new Metadata(), mock(ServerCallHandler.class));

    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any()))
        .thenReturn(delayedExecutionListener);

    DelayedExecutionListener<Object, Object> delayedExecutionListener2 =
        new DelayedExecutionListener<>(call, new Metadata(), next);

    // Act
    delayedExecutionListener2.startCall();

    // Assert
    verify(delegate).request(1);
    verify(delegate2).request(1);
    verify(next).startCall(isA(ServerCall.class), isA(Metadata.class));
  }

  /**
   * Test {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata,
   * ServerCallHandler)}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata,
   * ServerCallHandler)}
   */
  @Test
  @DisplayName("Test interceptCall(ServerCall, Metadata, ServerCallHandler); given ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Listener DelayedExecutionInterceptor.interceptCall(ServerCall, Metadata, ServerCallHandler)"
  })
  void testInterceptCall_givenTen() {
    // Arrange
    DelayedExecutionInterceptor delayedExecutionInterceptor = new DelayedExecutionInterceptor();

    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());

    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);
    call.request(10);

    // Act
    Listener<Object> actualInterceptCallResult =
        delayedExecutionInterceptor.interceptCall(
            call, new Metadata(), mock(ServerCallHandler.class));

    // Assert
    verify(delegate, atLeast(1)).request(anyInt());
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionListener);
  }

  /**
   * Test {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata,
   * ServerCallHandler)}.
   *
   * <ul>
   *   <li>When {@link DelayedExecutionCall#DelayedExecutionCall(ServerCall)} with delegate is
   *       {@link ServerCall}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedExecutionInterceptor#interceptCall(ServerCall, Metadata,
   * ServerCallHandler)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(ServerCall, Metadata, ServerCallHandler); when DelayedExecutionCall(ServerCall) with delegate is ServerCall")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Listener DelayedExecutionInterceptor.interceptCall(ServerCall, Metadata, ServerCallHandler)"
  })
  void testInterceptCall_whenDelayedExecutionCallWithDelegateIsServerCall() {
    // Arrange
    DelayedExecutionInterceptor delayedExecutionInterceptor = new DelayedExecutionInterceptor();

    ServerCall<Object, Object> delegate = mock(ServerCall.class);
    doNothing().when(delegate).request(anyInt());
    DelayedExecutionCall<Object, Object> call = new DelayedExecutionCall<>(delegate);

    // Act
    Listener<Object> actualInterceptCallResult =
        delayedExecutionInterceptor.interceptCall(
            call, new Metadata(), mock(ServerCallHandler.class));

    // Assert
    verify(delegate).request(1);
    assertTrue(actualInterceptCallResult instanceof DelayedExecutionListener);
  }
}

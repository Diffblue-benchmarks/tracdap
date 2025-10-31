package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.TranslatingUnaryCallable;
import com.google.api.gax.rpc.UnaryCallable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GcpUtilsDiffblueTest {
  /**
   * Test {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  @DisplayName("Test unaryCall(UnaryCallable, Object, Executor); then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.unaryCall(UnaryCallable, Object, Executor)"})
  void testUnaryCall_thenReturnCompletableFuture() {
    // Arrange
    new CancellationException("foo");
    new CancellationException("foo");
    TranslatingUnaryCallable<Object, Object, Object, Object> callable = mock(TranslatingUnaryCallable.class);
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    when(callable.futureCall(Mockito.<Object>any(), Mockito.<ApiCallContext>any())).thenReturn(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))));

    // Act
    CompletionStage<Object> actualUnaryCallResult = GcpUtils.unaryCall(callable, "Request", mock(Executor.class));

    // Assert
    verify(callable).futureCall(isA(Object.class), isA(ApiCallContext.class));
    assertTrue(actualUnaryCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture, Executor)} with {@code gcpFuture}, {@code executor}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture, Executor)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture, Executor) with 'gcpFuture', 'executor'; then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture, Executor)"})
  void testGcpCallbackWithGcpFutureExecutor_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
        mock(Executor.class));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture)} with {@code gcpFuture}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture) with 'gcpFuture'; then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture)"})
  void testGcpCallbackWithGcpFuture_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }
}

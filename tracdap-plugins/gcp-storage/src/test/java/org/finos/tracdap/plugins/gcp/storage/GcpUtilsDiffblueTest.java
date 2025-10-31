package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GcpUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  void testUnaryCall() {
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
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture)}
   */
  @Test
  void testGcpCallback() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture, Executor)}
   */
  @Test
  void testGcpCallback2() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
        mock(Executor.class));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }
}

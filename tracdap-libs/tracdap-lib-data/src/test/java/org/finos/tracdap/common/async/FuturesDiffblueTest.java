package org.finos.tracdap.common.async;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FuturesDiffblueTest {
  /**
   * Method under test: {@link Futures#javaFuture(ListenableFuture)}
   */
  @Test
  void testJavaFuture() {
    // Arrange
    SettableFuture<Object> guavaFuture = SettableFuture.create();

    // Act
    CompletionStage<Object> actualJavaFutureResult = Futures.javaFuture(guavaFuture);

    // Assert
    assertTrue(actualJavaFutureResult instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link Futures#javaFuture(ListenableFuture)}
   */
  @Test
  void testJavaFuture2() {
    // Arrange
    ListenableFutureTask<Object> guavaFuture = mock(ListenableFutureTask.class);
    doNothing().when(guavaFuture).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    CompletionStage<Object> actualJavaFutureResult = Futures.javaFuture(guavaFuture);

    // Assert
    verify(guavaFuture).addListener(isA(Runnable.class), isA(Executor.class));
    assertTrue(actualJavaFutureResult instanceof CompletableFuture);
  }
}

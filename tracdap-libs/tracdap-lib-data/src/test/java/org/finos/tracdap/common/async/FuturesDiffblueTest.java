package org.finos.tracdap.common.async;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FuturesDiffblueTest {
  /**
   * Test {@link Futures#javaFuture(ListenableFuture)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link Futures#javaFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test javaFuture(ListenableFuture); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage Futures.javaFuture(ListenableFuture)"})
  void testJavaFuture_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> guavaFuture = mock(ListenableFutureTask.class);
    doNothing().when(guavaFuture).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    CompletionStage<Object> actualJavaFutureResult = Futures.javaFuture(guavaFuture);

    // Assert
    verify(guavaFuture).addListener(isA(Runnable.class), isA(Executor.class));
    assertTrue(actualJavaFutureResult instanceof CompletableFuture);
  }

  /**
   * Test {@link Futures#javaFuture(ListenableFuture)}.
   *
   * <ul>
   *   <li>When create.
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link Futures#javaFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test javaFuture(ListenableFuture); when create; then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage Futures.javaFuture(ListenableFuture)"})
  void testJavaFuture_whenCreate_thenReturnCompletableFuture() {
    // Arrange
    SettableFuture<Object> guavaFuture = SettableFuture.create();

    // Act
    CompletionStage<Object> actualJavaFutureResult = Futures.javaFuture(guavaFuture);

    // Assert
    assertTrue(actualJavaFutureResult instanceof CompletableFuture);
  }
}

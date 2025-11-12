package org.finos.tracdap.svc.data.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpersDiffblueTest {
  /**
   * Test {@link Helpers#reportError(Throwable, CompletableFuture, Subscriber)}.
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Helpers#reportError(Throwable, CompletableFuture, Subscriber)}
   */
  @Test
  @DisplayName(
      "Test reportError(Throwable, CompletableFuture, Subscriber); when CompletableFuture(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void Helpers.reportError(Throwable, CompletableFuture, Subscriber)"})
  void testReportError_whenCompletableFuture_thenReturnNull() {
    // Arrange
    Throwable error = new Throwable();
    CompletableFuture<?> definition = new CompletableFuture<>();
    FutureFirstItemSubscriber<?> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<?> content = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    Void actualReportErrorResult = Helpers.reportError(error, definition, content);

    // Assert
    assertNull(actualReportErrorResult);
    assertTrue(definition.isDone());
  }
}

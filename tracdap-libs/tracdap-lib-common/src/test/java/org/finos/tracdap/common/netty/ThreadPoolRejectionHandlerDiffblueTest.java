package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThreadPoolRejectionHandlerDiffblueTest {
  /**
   * Test {@link ThreadPoolRejectionHandler#rejectedExecution(Runnable, ThreadPoolExecutor)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link UnorderedThreadPoolEventExecutor#isShutdown()}.
   * </ul>
   *
   * <p>Method under test: {@link ThreadPoolRejectionHandler#rejectedExecution(Runnable,
   * ThreadPoolExecutor)}
   */
  @Test
  @DisplayName(
      "Test rejectedExecution(Runnable, ThreadPoolExecutor); given 'true'; then calls isShutdown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThreadPoolRejectionHandler.rejectedExecution(Runnable, ThreadPoolExecutor)"
  })
  void testRejectedExecution_givenTrue_thenCallsIsShutdown() {
    // Arrange
    ThreadPoolRejectionHandler threadPoolRejectionHandler =
        new ThreadPoolRejectionHandler("Thread Pool Name");
    Runnable task = mock(Runnable.class);

    UnorderedThreadPoolEventExecutor executor = mock(UnorderedThreadPoolEventExecutor.class);
    when(executor.isShutdown()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RejectedExecutionException.class,
        () -> threadPoolRejectionHandler.rejectedExecution(task, executor));
    verify(executor).isShutdown();
  }
}

package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThreadPoolRejectionHandlerDiffblueTest {
  /**
   * Test {@link ThreadPoolRejectionHandler#rejectedExecution(Runnable, ThreadPoolExecutor)}.
   * <ul>
   *   <li>Then throw {@link RejectedExecutionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThreadPoolRejectionHandler#rejectedExecution(Runnable, ThreadPoolExecutor)}
   */
  @Test
  @DisplayName("Test rejectedExecution(Runnable, ThreadPoolExecutor); then throw RejectedExecutionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThreadPoolRejectionHandler.rejectedExecution(Runnable, ThreadPoolExecutor)"})
  void testRejectedExecution_thenThrowRejectedExecutionException() {
    // Arrange
    ThreadPoolRejectionHandler threadPoolRejectionHandler = new ThreadPoolRejectionHandler("Thread Pool Name");
    Runnable task = mock(Runnable.class);

    // Act and Assert
    assertThrows(RejectedExecutionException.class, () -> threadPoolRejectionHandler.rejectedExecution(task,
        NettyHelpers.threadPoolExecutor("Thread Pool Name", 1, 3, 3, 1L)));
  }
}

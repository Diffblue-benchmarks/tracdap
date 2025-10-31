package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;

class ThreadPoolRejectionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ThreadPoolRejectionHandler#rejectedExecution(Runnable, ThreadPoolExecutor)}
   */
  @Test
  void testRejectedExecution() {
    // Arrange
    ThreadPoolRejectionHandler threadPoolRejectionHandler = new ThreadPoolRejectionHandler("Thread Pool Name");
    Runnable task = mock(Runnable.class);

    // Act and Assert
    assertThrows(RejectedExecutionException.class, () -> threadPoolRejectionHandler.rejectedExecution(task,
        NettyHelpers.threadPoolExecutor("Thread Pool Name", 1, 3, 3, 1L)));
  }
}

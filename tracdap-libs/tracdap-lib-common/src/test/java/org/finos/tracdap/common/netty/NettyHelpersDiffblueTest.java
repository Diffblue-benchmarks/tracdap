package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;

class NettyHelpersDiffblueTest {
  /**
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  void testEventLoopExecutor() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("Thread Pool Name");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }

  /**
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  void testEventLoopExecutor2() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("Thread Pool Name");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }

  /**
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  void testEventLoopExecutor3() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("1.99*");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }
}

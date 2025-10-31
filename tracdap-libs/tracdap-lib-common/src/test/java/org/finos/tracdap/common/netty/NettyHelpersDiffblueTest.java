package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NettyHelpersDiffblueTest {
  /**
   * Test {@link NettyHelpers#eventLoopExecutor(String)}.
   * <ul>
   *   <li>Then return {@link ThreadPerTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  @DisplayName("Test eventLoopExecutor(String); then return ThreadPerTaskExecutor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Executor NettyHelpers.eventLoopExecutor(String)"})
  void testEventLoopExecutor_thenReturnThreadPerTaskExecutor() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("Thread Pool Name");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }

  /**
   * Test {@link NettyHelpers#eventLoopExecutor(String)}.
   * <ul>
   *   <li>When {@code 1.99*}.</li>
   *   <li>Then return {@link ThreadPerTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  @DisplayName("Test eventLoopExecutor(String); when '1.99*'; then return ThreadPerTaskExecutor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Executor NettyHelpers.eventLoopExecutor(String)"})
  void testEventLoopExecutor_when199_thenReturnThreadPerTaskExecutor() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("1.99*");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }

  /**
   * Test {@link NettyHelpers#eventLoopExecutor(String)}.
   * <ul>
   *   <li>When {@code Thread Pool Name}.</li>
   *   <li>Then return {@link ThreadPerTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  @DisplayName("Test eventLoopExecutor(String); when 'Thread Pool Name'; then return ThreadPerTaskExecutor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Executor NettyHelpers.eventLoopExecutor(String)"})
  void testEventLoopExecutor_whenThreadPoolName_thenReturnThreadPerTaskExecutor() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("Thread Pool Name");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }
}

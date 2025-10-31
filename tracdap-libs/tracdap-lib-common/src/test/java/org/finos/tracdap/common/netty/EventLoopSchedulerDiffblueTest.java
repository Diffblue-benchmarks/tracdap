package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultEventExecutorChooserFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.api.Test;

class EventLoopSchedulerDiffblueTest {
  /**
   * Method under test: {@link EventLoopScheduler#roundRobin()}
   */
  @Test
  void testRoundRobin() {
    // Arrange and Act
    EventExecutorChooserFactory actualRoundRobinResult = EventLoopScheduler.roundRobin();
    actualRoundRobinResult.newChooser(new EventExecutor[]{new DefaultEventLoop()});

    // Assert
    assertTrue(actualRoundRobinResult instanceof DefaultEventExecutorChooserFactory);
  }

  /**
   * Method under test: {@link EventLoopScheduler#roundRobin()}
   */
  @Test
  void testRoundRobin2() {
    // Arrange and Act
    EventExecutorChooserFactory actualRoundRobinResult = EventLoopScheduler.roundRobin();
    actualRoundRobinResult.newChooser(new EventExecutor[]{new DefaultEventExecutor(mock(ThreadFactory.class))});

    // Assert
    assertTrue(actualRoundRobinResult instanceof DefaultEventExecutorChooserFactory);
  }

  /**
   * Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  void testNewChooser() {
    // Arrange
    EventLoopScheduler preferLoopAffinityResult = EventLoopScheduler.preferLoopAffinity();
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();

    // Act and Assert
    assertSame(defaultEventLoop, preferLoopAffinityResult.newChooser(new EventExecutor[]{defaultEventLoop}).next());
  }

  /**
   * Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  void testNewChooser2() {
    // Arrange
    EventLoopScheduler preferLoopAffinityResult = EventLoopScheduler.preferLoopAffinity(new EventLoopOffloadTracker());
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();

    // Act and Assert
    assertSame(defaultEventLoop, preferLoopAffinityResult.newChooser(new EventExecutor[]{defaultEventLoop}).next());
  }

  /**
   * Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  void testNewChooser3() {
    // Arrange
    EventLoopScheduler preferLoopAffinityResult = EventLoopScheduler.preferLoopAffinity();
    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor(mock(ThreadFactory.class));

    // Act and Assert
    assertSame(defaultEventExecutor,
        preferLoopAffinityResult.newChooser(new EventExecutor[]{defaultEventExecutor}).next());
  }
}

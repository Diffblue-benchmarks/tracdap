package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutorChooserFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventLoopSchedulerDiffblueTest {
  /**
   * Test {@link EventLoopScheduler#roundRobin()}.
   *
   * <p>Method under test: {@link EventLoopScheduler#roundRobin()}
   */
  @Test
  @DisplayName("Test roundRobin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventExecutorChooserFactory EventLoopScheduler.roundRobin()"})
  void testRoundRobin() {
    // Arrange and Act
    EventExecutorChooserFactory actualRoundRobinResult = EventLoopScheduler.roundRobin();
    actualRoundRobinResult.newChooser(new EventExecutor[] {new DefaultEventLoop()});

    // Assert
    assertTrue(actualRoundRobinResult instanceof DefaultEventExecutorChooserFactory);
  }

  /**
   * Test {@link EventLoopScheduler#newChooser(EventExecutor[])}.
   *
   * <ul>
   *   <li>Given preferLoopAffinity {@link EventLoopOffloadTracker} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  @DisplayName(
      "Test newChooser(EventExecutor[]); given preferLoopAffinity EventLoopOffloadTracker (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventExecutorChooserFactory.EventExecutorChooser EventLoopScheduler.newChooser(EventExecutor[])"
  })
  void testNewChooser_givenPreferLoopAffinityEventLoopOffloadTracker() {
    // Arrange
    EventLoopScheduler preferLoopAffinityResult =
        EventLoopScheduler.preferLoopAffinity(new EventLoopOffloadTracker());
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    EventExecutor[] eventExecutors = new EventExecutor[] {defaultEventLoop};

    // Act and Assert
    assertEquals(1, eventExecutors.length);
    assertSame(defaultEventLoop, preferLoopAffinityResult.newChooser(eventExecutors).next());
    assertSame(defaultEventLoop, eventExecutors[0]);
  }

  /**
   * Test {@link EventLoopScheduler#newChooser(EventExecutor[])}.
   *
   * <ul>
   *   <li>Given preferLoopAffinity.
   *   <li>Then return next is {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  @DisplayName(
      "Test newChooser(EventExecutor[]); given preferLoopAffinity; then return next is DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventExecutorChooserFactory.EventExecutorChooser EventLoopScheduler.newChooser(EventExecutor[])"
  })
  void testNewChooser_givenPreferLoopAffinity_thenReturnNextIsDefaultEventLoop() {
    // Arrange
    EventLoopScheduler preferLoopAffinityResult = EventLoopScheduler.preferLoopAffinity();
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    EventExecutor[] eventExecutors = new EventExecutor[] {defaultEventLoop};

    // Act and Assert
    assertEquals(1, eventExecutors.length);
    assertSame(defaultEventLoop, preferLoopAffinityResult.newChooser(eventExecutors).next());
    assertSame(defaultEventLoop, eventExecutors[0]);
  }

  /**
   * Test {@link EventLoopScheduler#newChooser(EventExecutor[])}.
   *
   * <ul>
   *   <li>Given requireLoopAffinity.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopScheduler#newChooser(EventExecutor[])}
   */
  @Test
  @DisplayName(
      "Test newChooser(EventExecutor[]); given requireLoopAffinity; then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EventExecutorChooserFactory.EventExecutorChooser EventLoopScheduler.newChooser(EventExecutor[])"
  })
  void testNewChooser_givenRequireLoopAffinity_thenArrayLengthIsOne() {
    // Arrange
    EventLoopScheduler requireLoopAffinityResult = EventLoopScheduler.requireLoopAffinity();
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    EventExecutor[] eventExecutors = new EventExecutor[] {defaultEventLoop};

    // Act
    requireLoopAffinityResult.newChooser(eventExecutors);

    // Assert that nothing has changed
    assertEquals(1, eventExecutors.length);
    assertSame(defaultEventLoop, eventExecutors[0]);
  }
}

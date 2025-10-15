package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.FastThreadLocalThread;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventLoopOffloadTrackerDiffblueTest {
  /**
   * Test {@link EventLoopOffloadTracker#wrappExecutor(Executor)}.
   *
   * <p>Method under test: {@link EventLoopOffloadTracker#wrappExecutor(Executor)}
   */
  @Test
  @DisplayName("Test wrappExecutor(Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Executor EventLoopOffloadTracker.wrappExecutor(Executor)"})
  void testWrappExecutor() {
    // Arrange
    EventLoopOffloadTracker eventLoopOffloadTracker = new EventLoopOffloadTracker();
    DefaultEventLoopGroup baseExecutor = new DefaultEventLoopGroup();

    // Act
    Executor actualWrappExecutorResult = eventLoopOffloadTracker.wrappExecutor(baseExecutor);
    FastThreadLocalThread fastThreadLocalThread =
        new FastThreadLocalThread(mock(Runnable.class), "Name");
    actualWrappExecutorResult.execute(fastThreadLocalThread);

    // Assert that nothing has changed
    assertTrue(baseExecutor.next() instanceof DefaultEventLoop);
    assertTrue(baseExecutor.terminationFuture() instanceof DefaultPromise);
    assertFalse(fastThreadLocalThread.permitBlockingCalls());
    assertFalse(baseExecutor.isShutdown());
    assertFalse(baseExecutor.isShuttingDown());
    assertFalse(baseExecutor.isTerminated());
    assertTrue(fastThreadLocalThread.willCleanupFastThreadLocals());
    assertTrue(baseExecutor.iterator().hasNext());
  }

  /**
   * Test {@link EventLoopOffloadTracker#wrappExecutor(Executor)}.
   *
   * <ul>
   *   <li>Then {@link EventLoopOffloadTracker} (default constructor) offloadCallingThread is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopOffloadTracker#wrappExecutor(Executor)}
   */
  @Test
  @DisplayName(
      "Test wrappExecutor(Executor); then EventLoopOffloadTracker (default constructor) offloadCallingThread is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Executor EventLoopOffloadTracker.wrappExecutor(Executor)"})
  void testWrappExecutor_thenEventLoopOffloadTrackerOffloadCallingThreadIsNull() {
    // Arrange
    EventLoopOffloadTracker eventLoopOffloadTracker = new EventLoopOffloadTracker();

    // Act
    eventLoopOffloadTracker.wrappExecutor(mock(Executor.class));

    // Assert that nothing has changed
    assertNull(eventLoopOffloadTracker.offloadCallingThread());
  }

  /**
   * Test {@link EventLoopOffloadTracker#wrappExecutor(Executor)}.
   *
   * <ul>
   *   <li>Then not {@link FastThreadLocalThread#FastThreadLocalThread(String)} with {@code Name}
   *       permitBlockingCalls.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopOffloadTracker#wrappExecutor(Executor)}
   */
  @Test
  @DisplayName(
      "Test wrappExecutor(Executor); then not FastThreadLocalThread(String) with 'Name' permitBlockingCalls")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Executor EventLoopOffloadTracker.wrappExecutor(Executor)"})
  void testWrappExecutor_thenNotFastThreadLocalThreadWithNamePermitBlockingCalls() {
    // Arrange
    EventLoopOffloadTracker eventLoopOffloadTracker = new EventLoopOffloadTracker();
    DefaultEventLoopGroup baseExecutor = new DefaultEventLoopGroup();

    // Act
    Executor actualWrappExecutorResult = eventLoopOffloadTracker.wrappExecutor(baseExecutor);
    FastThreadLocalThread fastThreadLocalThread = new FastThreadLocalThread("Name");
    actualWrappExecutorResult.execute(fastThreadLocalThread);

    // Assert that nothing has changed
    assertTrue(baseExecutor.next() instanceof DefaultEventLoop);
    assertTrue(baseExecutor.terminationFuture() instanceof DefaultPromise);
    assertFalse(fastThreadLocalThread.permitBlockingCalls());
    assertFalse(fastThreadLocalThread.willCleanupFastThreadLocals());
    assertFalse(baseExecutor.isShutdown());
    assertFalse(baseExecutor.isShuttingDown());
    assertFalse(baseExecutor.isTerminated());
    assertTrue(baseExecutor.iterator().hasNext());
  }

  /**
   * Test {@link EventLoopOffloadTracker#offloadCallingThread()}.
   *
   * <p>Method under test: {@link EventLoopOffloadTracker#offloadCallingThread()}
   */
  @Test
  @DisplayName("Test offloadCallingThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Thread EventLoopOffloadTracker.offloadCallingThread()"})
  void testOffloadCallingThread() {
    // Arrange, Act and Assert
    assertNull(new EventLoopOffloadTracker().offloadCallingThread());
  }

  /**
   * Test {@link EventLoopOffloadTracker#offloadCallingThread()}.
   *
   * <p>Method under test: {@link EventLoopOffloadTracker#offloadCallingThread()}
   */
  @Test
  @DisplayName("Test offloadCallingThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Thread EventLoopOffloadTracker.offloadCallingThread()"})
  void testOffloadCallingThread2() {
    // Arrange, Act and Assert
    assertNull(new EventLoopOffloadTracker().offloadCallingThread());
  }
}

package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventLoopResolverDiffblueTest {
  /**
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}.
   *
   * <p>Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup,
   * EventLoopOffloadTracker)}
   */
  @Test
  @DisplayName("Test new EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup, EventLoopOffloadTracker)"})
  void testNewEventLoopResolver() {
    // Arrange
    UnorderedThreadPoolEventExecutor eventLoopGroup =
        new UnorderedThreadPoolEventExecutor(3, mock(RejectedExecutionHandler.class));

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    assertEquals(1, eventLoopGroup.getLargestPoolSize());
    assertEquals(1, eventLoopGroup.getPoolSize());
  }

  /**
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}.
   *
   * <ul>
   *   <li>Given {@link Thread#Thread()}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  @DisplayName(
      "Test new EventLoopResolver(EventExecutorGroup); given Thread(); then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup)"})
  void testNewEventLoopResolver_givenThread_thenCallsNewThread() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoopGroup = new DefaultEventExecutor(threadFactory);

    // Act
    new EventLoopResolver(eventLoopGroup);

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}.
   *
   * <ul>
   *   <li>Then {@link DefaultEventLoopGroup#DefaultEventLoopGroup()} iterator next {@link
   *       DefaultEventLoop}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  @DisplayName(
      "Test new EventLoopResolver(EventExecutorGroup); then DefaultEventLoopGroup() iterator next DefaultEventLoop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup)"})
  void testNewEventLoopResolver_thenDefaultEventLoopGroupIteratorNextDefaultEventLoop() {
    // Arrange
    DefaultEventLoopGroup eventLoopGroup = new DefaultEventLoopGroup();

    // Act
    new EventLoopResolver(eventLoopGroup);

    // Assert
    Iterator<EventExecutor> iteratorResult = eventLoopGroup.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop() {
    // Arrange
    EventExecutor[] eventExecutors = new EventExecutor[] {new DefaultEventLoop()};
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventExecutors, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop2() {
    // Arrange
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop3() {
    // Arrange, Act and Assert
    assertNull(new EventLoopResolver(new DefaultEventExecutor()).currentEventLoop(false));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop4() {
    // Arrange
    EventLoopResolver eventLoopResolver = new EventLoopResolver(new DefaultEventLoop(), null);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <ul>
   *   <li>Given {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)} with eventLoopGroup
   *       is {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName(
      "Test currentEventLoop(boolean); given EventLoopResolver(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop_givenEventLoopResolverWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> new EventLoopResolver(new DefaultEventLoop()).currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new EventLoopResolver(new DefaultEventLoop()).currentEventLoop(false));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop2() {
    // Arrange
    EventExecutor[] eventExecutors = new EventExecutor[] {new DefaultEventLoop()};
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventExecutors, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop3() {
    // Arrange
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop4() {
    // Arrange
    EventExecutor[] eventExecutors = new EventExecutor[] {new DefaultEventLoop()};
    EventLoopResolver eventLoopResolver = new EventLoopResolver(eventExecutors, null);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop5() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> new EventLoopResolver(new DefaultEventExecutor()).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <ul>
   *   <li>Given {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)} with eventLoopGroup
   *       is {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName(
      "Test callingEvnetLoop(boolean); given EventLoopResolver(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop_givenEventLoopResolverWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> new EventLoopResolver(new DefaultEventLoop()).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean); when 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"
  })
  void testCallingEvnetLoop_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new EventLoopResolver(new DefaultEventLoop()).callingEvnetLoop(false));
  }
}

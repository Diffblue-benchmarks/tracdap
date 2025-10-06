package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventLoopResolverDiffblueTest {
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
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultEventExecutor#forEach(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup,
   * EventLoopOffloadTracker)}
   */
  @Test
  @DisplayName(
      "Test new EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker); then calls forEach(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup, EventLoopOffloadTracker)"})
  void testNewEventLoopResolver_thenCallsForEach() {
    // Arrange
    DefaultEventExecutor eventLoopGroup = mock(DefaultEventExecutor.class);
    doNothing().when(eventLoopGroup).forEach(Mockito.<Consumer<EventExecutor>>any());

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    verify(eventLoopGroup).forEach(isA(Consumer.class));
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
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

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
  void testCurrentEventLoop3() {
    // Arrange
    DefaultEventExecutor eventLoopGroup = new DefaultEventExecutor();
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

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
  void testCurrentEventLoop4() {
    // Arrange
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker());

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
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean); when 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"
  })
  void testCurrentEventLoop_whenFalse_thenReturnNull() {
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
    // Arrange
    EventLoopResolver eventLoopResolver = new EventLoopResolver(new DefaultEventExecutor(), null);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopResolver.callingEvnetLoop(true));
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

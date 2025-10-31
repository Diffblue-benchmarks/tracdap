package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.ThreadPerChannelEventLoop;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventLoopResolverDiffblueTest {
  /**
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}.
   * <ul>
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  @DisplayName("Test new EventLoopResolver(EventExecutorGroup); when DefaultEventLoop(); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup)"})
  void testNewEventLoopResolver_whenDefaultEventLoop_thenNotDefaultEventLoopTerminated() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act
    new EventLoopResolver(eventLoopGroup);

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }

  /**
   * Test {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}.
   * <ul>
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}
   */
  @Test
  @DisplayName("Test new EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker); when DefaultEventLoop(); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EventLoopResolver.<init>(EventExecutorGroup, EventLoopOffloadTracker)"})
  void testNewEventLoopResolver_whenDefaultEventLoop_thenNotDefaultEventLoopTerminated2() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"})
  void testCurrentEventLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, new EventLoopOffloadTracker()))
            .currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"})
  void testCurrentEventLoop2() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker())).currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   * <ul>
   *   <li>Given {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)} with eventLoopGroup is {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean); given EventLoopResolver(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"})
  void testCurrentEventLoop_givenEventLoopResolverWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> (new EventLoopResolver(new DefaultEventLoop())).currentEventLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#currentEventLoop(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  @DisplayName("Test currentEventLoop(boolean); when 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.currentEventLoop(boolean)"})
  void testCurrentEventLoop_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EventLoopResolver(new DefaultEventLoop())).currentEventLoop(false));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker())).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop2() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, new EventLoopOffloadTracker()))
            .callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop3() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker())).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop4() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, null)).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop5() {
    // Arrange, Act and Assert
    assertNull((new EventLoopResolver(new DefaultEventExecutor())).callingEvnetLoop(false));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <ul>
   *   <li>Given {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)} with eventLoopGroup is {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean); given EventLoopResolver(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop_givenEventLoopResolverWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> (new EventLoopResolver(new DefaultEventLoop())).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <ul>
   *   <li>Given {@link ThreadPerChannelEventLoop#ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup)} with parent is {@link OioEventLoopGroup#OioEventLoopGroup()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean); given ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup) with parent is OioEventLoopGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop_givenThreadPerChannelEventLoopWithParentIsOioEventLoopGroup() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new ThreadPerChannelEventLoop(new OioEventLoopGroup()))).callingEvnetLoop(true));
  }

  /**
   * Test {@link EventLoopResolver#callingEvnetLoop(boolean)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  @DisplayName("Test callingEvnetLoop(boolean); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.netty.util.concurrent.OrderedEventExecutor EventLoopResolver.callingEvnetLoop(boolean)"})
  void testCallingEvnetLoop_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EventLoopResolver(new DefaultEventLoop())).callingEvnetLoop(false));
  }
}

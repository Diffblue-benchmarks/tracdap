package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.OrderedEventExecutor;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventLoopResolverDiffblueTest {
  /**
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  void testCurrentEventLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> (new EventLoopResolver(new DefaultEventLoop())).currentEventLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, new EventLoopOffloadTracker()))
            .currentEventLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new DefaultEventExecutorGroup(1))).currentEventLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker())).currentEventLoop(true));
  }

  /**
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  void testCurrentEventLoop2() {
    // Arrange
    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    // Act
    OrderedEventExecutor actualCurrentEventLoopResult = (new EventLoopResolver(
        new DefaultEventLoop(new DefaultEventLoop(), executor))).currentEventLoop(false);

    // Assert
    verify(executor).execute(isA(Runnable.class));
    assertNull(actualCurrentEventLoopResult);
  }

  /**
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  void testCurrentEventLoop3() {
    // Arrange
    new ETracInternal("Not all who wander are lost");

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new UnorderedThreadPoolEventExecutor(3))).currentEventLoop(true));
  }

  /**
   * Method under test: {@link EventLoopResolver#currentEventLoop(boolean)}
   */
  @Test
  void testCurrentEventLoop4() {
    // Arrange
    new EUnexpected();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> (new EventLoopResolver(new NioEventLoopGroup(1))).currentEventLoop(true));
  }

  /**
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  void testCallingEvnetLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> (new EventLoopResolver(new DefaultEventLoop())).callingEvnetLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, new EventLoopOffloadTracker()))
            .callingEvnetLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new DefaultEventExecutorGroup(1))).callingEvnetLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker())).callingEvnetLoop(true));
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, null)).callingEvnetLoop(true));
  }

  /**
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  void testCallingEvnetLoop2() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker())).callingEvnetLoop(true));
  }

  /**
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  void testCallingEvnetLoop3() {
    // Arrange
    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    // Act
    OrderedEventExecutor actualCallingEvnetLoopResult = (new EventLoopResolver(
        new DefaultEventLoop(new DefaultEventLoop(), executor))).callingEvnetLoop(false);

    // Assert
    verify(executor).execute(isA(Runnable.class));
    assertNull(actualCallingEvnetLoopResult);
  }

  /**
   * Method under test: {@link EventLoopResolver#callingEvnetLoop(boolean)}
   */
  @Test
  void testCallingEvnetLoop4() {
    // Arrange
    new EUnexpected();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopResolver(new UnorderedThreadPoolEventExecutor(3))).callingEvnetLoop(true));
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  void testNewEventLoopResolver() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act
    new EventLoopResolver(eventLoopGroup);

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  void testNewEventLoopResolver2() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

    // Act
    new EventLoopResolver(new DefaultEventExecutor(threadFactory));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup)}
   */
  @Test
  void testNewEventLoopResolver3() {
    // Arrange
    DefaultEventLoopGroup eventLoopGroup = new DefaultEventLoopGroup();

    // Act
    new EventLoopResolver(eventLoopGroup);

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}
   */
  @Test
  void testNewEventLoopResolver4() {
    // Arrange
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}
   */
  @Test
  void testNewEventLoopResolver5() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoopGroup = new DefaultEventExecutor(threadFactory);

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link EventLoopResolver#EventLoopResolver(EventExecutorGroup, EventLoopOffloadTracker)}
   */
  @Test
  void testNewEventLoopResolver6() {
    // Arrange
    DefaultEventLoopGroup eventLoopGroup = new DefaultEventLoopGroup();

    // Act
    new EventLoopResolver(eventLoopGroup, new EventLoopOffloadTracker());

    // Assert
    assertFalse(eventLoopGroup.isTerminated());
  }
}

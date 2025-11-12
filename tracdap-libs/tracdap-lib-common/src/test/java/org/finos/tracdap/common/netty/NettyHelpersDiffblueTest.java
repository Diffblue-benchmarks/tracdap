package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory.EventExecutorChooser;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NettyHelpersDiffblueTest {
  /**
   * Test {@link NettyHelpers#threadFactory(String)}.
   *
   * <ul>
   *   <li>Then newThread {@link Runnable} return {@link FastThreadLocalThread}.
   * </ul>
   *
   * <p>Method under test: {@link NettyHelpers#threadFactory(String)}
   */
  @Test
  @DisplayName("Test threadFactory(String); then newThread Runnable return FastThreadLocalThread")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThreadFactory NettyHelpers.threadFactory(String)"})
  void testThreadFactory_thenNewThreadRunnableReturnFastThreadLocalThread() {
    // Arrange and Act
    ThreadFactory actualThreadFactoryResult = NettyHelpers.threadFactory("Thread Pool Name");
    Thread actualNewThreadResult = actualThreadFactoryResult.newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertTrue(actualThreadFactoryResult instanceof NettyThreadFactoryWrapper);
    assertEquals("Thread Pool Name-0", actualNewThreadResult.getName());
  }

  /**
   * Test {@link NettyHelpers#eventLoopExecutor(String)}.
   *
   * <ul>
   *   <li>When {@code Thread Pool Name}.
   *   <li>Then return {@link ThreadPerTaskExecutor}.
   * </ul>
   *
   * <p>Method under test: {@link NettyHelpers#eventLoopExecutor(String)}
   */
  @Test
  @DisplayName(
      "Test eventLoopExecutor(String); when 'Thread Pool Name'; then return ThreadPerTaskExecutor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Executor NettyHelpers.eventLoopExecutor(String)"})
  void testEventLoopExecutor_whenThreadPoolName_thenReturnThreadPerTaskExecutor() {
    // Arrange and Act
    Executor actualEventLoopExecutorResult = NettyHelpers.eventLoopExecutor("Thread Pool Name");
    actualEventLoopExecutorResult.execute(mock(Runnable.class));

    // Assert
    assertTrue(actualEventLoopExecutorResult instanceof ThreadPerTaskExecutor);
  }

  /**
   * Test {@link NettyHelpers#threadPoolExecutor(String)} with {@code threadPoolName}.
   *
   * <p>Method under test: {@link NettyHelpers#threadPoolExecutor(String)}
   */
  @Test
  @DisplayName("Test threadPoolExecutor(String) with 'threadPoolName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThreadPoolExecutor NettyHelpers.threadPoolExecutor(String)"})
  void testThreadPoolExecutorWithThreadPoolName() {
    // Arrange and Act
    ThreadPoolExecutor actualThreadPoolExecutorResult =
        NettyHelpers.threadPoolExecutor("Thread Pool Name");

    // Assert
    assertTrue(
        actualThreadPoolExecutorResult.getThreadFactory() instanceof NettyThreadFactoryWrapper);
    assertTrue(
        actualThreadPoolExecutorResult.getRejectedExecutionHandler()
            instanceof ThreadPoolRejectionHandler);
    assertEquals(0, actualThreadPoolExecutorResult.getActiveCount());
    assertEquals(0, actualThreadPoolExecutorResult.getCorePoolSize());
    assertEquals(0, actualThreadPoolExecutorResult.getLargestPoolSize());
    assertEquals(0, actualThreadPoolExecutorResult.getPoolSize());
    assertEquals(0L, actualThreadPoolExecutorResult.getCompletedTaskCount());
    assertEquals(0L, actualThreadPoolExecutorResult.getTaskCount());
    assertEquals(10, actualThreadPoolExecutorResult.getMaximumPoolSize());
    assertTrue(actualThreadPoolExecutorResult.getQueue().isEmpty());
  }

  /**
   * Test {@link NettyHelpers#threadPoolExecutor(String, int, int)} with {@code threadPoolName},
   * {@code minSize}, {@code maxSize}.
   *
   * <p>Method under test: {@link NettyHelpers#threadPoolExecutor(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test threadPoolExecutor(String, int, int) with 'threadPoolName', 'minSize', 'maxSize'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThreadPoolExecutor NettyHelpers.threadPoolExecutor(String, int, int)"})
  void testThreadPoolExecutorWithThreadPoolNameMinSizeMaxSize() {
    // Arrange and Act
    ThreadPoolExecutor actualThreadPoolExecutorResult =
        NettyHelpers.threadPoolExecutor("Thread Pool Name", 1, 3);

    // Assert
    assertTrue(
        actualThreadPoolExecutorResult.getThreadFactory() instanceof NettyThreadFactoryWrapper);
    assertTrue(
        actualThreadPoolExecutorResult.getRejectedExecutionHandler()
            instanceof ThreadPoolRejectionHandler);
    assertEquals(0, actualThreadPoolExecutorResult.getActiveCount());
    assertEquals(0, actualThreadPoolExecutorResult.getLargestPoolSize());
    assertEquals(0, actualThreadPoolExecutorResult.getPoolSize());
    assertEquals(0L, actualThreadPoolExecutorResult.getCompletedTaskCount());
    assertEquals(0L, actualThreadPoolExecutorResult.getTaskCount());
    assertEquals(1, actualThreadPoolExecutorResult.getCorePoolSize());
    assertEquals(3, actualThreadPoolExecutorResult.getMaximumPoolSize());
    assertTrue(actualThreadPoolExecutorResult.getQueue().isEmpty());
  }

  /**
   * Test {@link NettyHelpers#threadPoolExecutor(String, int, int, int)} with {@code
   * threadPoolName}, {@code minSize}, {@code maxSize}, {@code overflowSize}.
   *
   * <p>Method under test: {@link NettyHelpers#threadPoolExecutor(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test threadPoolExecutor(String, int, int, int) with 'threadPoolName', 'minSize', 'maxSize', 'overflowSize'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThreadPoolExecutor NettyHelpers.threadPoolExecutor(String, int, int, int)"})
  void testThreadPoolExecutorWithThreadPoolNameMinSizeMaxSizeOverflowSize() {
    // Arrange and Act
    ThreadPoolExecutor actualThreadPoolExecutorResult =
        NettyHelpers.threadPoolExecutor("Thread Pool Name", 1, 3, 3);

    // Assert
    assertTrue(
        actualThreadPoolExecutorResult.getThreadFactory() instanceof NettyThreadFactoryWrapper);
    assertTrue(
        actualThreadPoolExecutorResult.getRejectedExecutionHandler()
            instanceof ThreadPoolRejectionHandler);
    assertEquals(0, actualThreadPoolExecutorResult.getActiveCount());
    assertEquals(0, actualThreadPoolExecutorResult.getLargestPoolSize());
    assertEquals(0, actualThreadPoolExecutorResult.getPoolSize());
    assertEquals(0L, actualThreadPoolExecutorResult.getCompletedTaskCount());
    assertEquals(0L, actualThreadPoolExecutorResult.getTaskCount());
    assertEquals(1, actualThreadPoolExecutorResult.getCorePoolSize());
    assertEquals(3, actualThreadPoolExecutorResult.getMaximumPoolSize());
    assertTrue(actualThreadPoolExecutorResult.getQueue().isEmpty());
  }

  /**
   * Test {@link NettyHelpers#threadPoolExecutor(String, int, int, int, long)} with {@code
   * threadPoolName}, {@code minSize}, {@code maxSize}, {@code overflowSize}, {@code idleMs}.
   *
   * <p>Method under test: {@link NettyHelpers#threadPoolExecutor(String, int, int, int, long)}
   */
  @Test
  @DisplayName(
      "Test threadPoolExecutor(String, int, int, int, long) with 'threadPoolName', 'minSize', 'maxSize', 'overflowSize', 'idleMs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ThreadPoolExecutor NettyHelpers.threadPoolExecutor(String, int, int, int, long)"
  })
  void testThreadPoolExecutorWithThreadPoolNameMinSizeMaxSizeOverflowSizeIdleMs() {
    // Arrange and Act
    ThreadPoolExecutor actualThreadPoolExecutorResult =
        NettyHelpers.threadPoolExecutor("Thread Pool Name", 1, 3, 3, 1L);

    // Assert
    assertTrue(
        actualThreadPoolExecutorResult.getThreadFactory() instanceof NettyThreadFactoryWrapper);
    assertTrue(
        actualThreadPoolExecutorResult.getRejectedExecutionHandler()
            instanceof ThreadPoolRejectionHandler);
    assertEquals(0, actualThreadPoolExecutorResult.getActiveCount());
    assertEquals(0, actualThreadPoolExecutorResult.getLargestPoolSize());
    assertEquals(0, actualThreadPoolExecutorResult.getPoolSize());
    assertEquals(0L, actualThreadPoolExecutorResult.getCompletedTaskCount());
    assertEquals(0L, actualThreadPoolExecutorResult.getTaskCount());
    assertEquals(1, actualThreadPoolExecutorResult.getCorePoolSize());
    assertEquals(3, actualThreadPoolExecutorResult.getMaximumPoolSize());
    assertTrue(actualThreadPoolExecutorResult.getQueue().isEmpty());
  }

  /**
   * Test {@link NettyHelpers#nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link NettyHelpers#nioEventLoopGroup(Executor,
   * EventExecutorChooserFactory, int)}
   */
  @Test
  @DisplayName(
      "Test nioEventLoopGroup(Executor, EventExecutorChooserFactory, int); when 'null'; then return iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NioEventLoopGroup NettyHelpers.nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)"
  })
  void testNioEventLoopGroup_whenNull_thenReturnIteratorHasNext() {
    // Arrange
    EventExecutorChooserFactory scheduler = mock(EventExecutorChooserFactory.class);
    when(scheduler.newChooser(Mockito.<EventExecutor[]>any()))
        .thenReturn(mock(EventExecutorChooser.class));

    // Act
    NioEventLoopGroup actualNioEventLoopGroupResult =
        NettyHelpers.nioEventLoopGroup(null, scheduler, 0);

    // Assert
    verify(scheduler).newChooser(isA(EventExecutor[].class));
    Iterator<EventExecutor> iteratorResult = actualNioEventLoopGroupResult.iterator();
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NettyHelpers#nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link NettyHelpers#nioEventLoopGroup(Executor,
   * EventExecutorChooserFactory, int)}
   */
  @Test
  @DisplayName(
      "Test nioEventLoopGroup(Executor, EventExecutorChooserFactory, int); when one; then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NioEventLoopGroup NettyHelpers.nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)"
  })
  void testNioEventLoopGroup_whenOne_thenReturnNotIteratorHasNext() {
    // Arrange
    Executor executor = mock(Executor.class);

    EventExecutorChooserFactory scheduler = mock(EventExecutorChooserFactory.class);
    when(scheduler.newChooser(Mockito.<EventExecutor[]>any()))
        .thenReturn(mock(EventExecutorChooser.class));

    // Act
    NioEventLoopGroup actualNioEventLoopGroupResult =
        NettyHelpers.nioEventLoopGroup(executor, scheduler, 1);

    // Assert
    Iterator<EventExecutor> iteratorResult = actualNioEventLoopGroupResult.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof NioEventLoop);
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(actualNioEventLoopGroupResult, nextResult.parent());
    verify(scheduler).newChooser(isA(EventExecutor[].class));
  }

  /**
   * Test {@link NettyHelpers#nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link NettyHelpers#nioEventLoopGroup(Executor,
   * EventExecutorChooserFactory, int)}
   */
  @Test
  @DisplayName(
      "Test nioEventLoopGroup(Executor, EventExecutorChooserFactory, int); when zero; then return iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NioEventLoopGroup NettyHelpers.nioEventLoopGroup(Executor, EventExecutorChooserFactory, int)"
  })
  void testNioEventLoopGroup_whenZero_thenReturnIteratorHasNext() {
    // Arrange
    Executor executor = mock(Executor.class);

    EventExecutorChooserFactory scheduler = mock(EventExecutorChooserFactory.class);
    when(scheduler.newChooser(Mockito.<EventExecutor[]>any()))
        .thenReturn(mock(EventExecutorChooser.class));

    // Act
    NioEventLoopGroup actualNioEventLoopGroupResult =
        NettyHelpers.nioEventLoopGroup(executor, scheduler, 0);

    // Assert
    verify(scheduler).newChooser(isA(EventExecutor[].class));
    Iterator<EventExecutor> iteratorResult = actualNioEventLoopGroupResult.iterator();
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(iteratorResult.hasNext());
  }
}

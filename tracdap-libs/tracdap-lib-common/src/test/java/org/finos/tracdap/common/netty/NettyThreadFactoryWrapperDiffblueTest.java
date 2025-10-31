package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.util.concurrent.FastThreadLocalThread;
import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NettyThreadFactoryWrapperDiffblueTest {
  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  void testNewThread() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  void testNewThread2() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 1))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  void testNewThread3() {
    // Arrange
    ThreadFactory internalFactory = mock(ThreadFactory.class);
    Thread thread = new Thread();
    when(internalFactory.newThread(Mockito.<Runnable>any())).thenReturn(thread);

    // Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", internalFactory))
        .newThread(mock(Runnable.class));

    // Assert
    verify(internalFactory).newThread(isA(Runnable.class));
    assertSame(thread, actualNewThreadResult);
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper2() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("1.99*")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, ThreadFactory)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper3() {
    // Arrange
    ThreadFactory internalFactory = mock(ThreadFactory.class);
    Thread thread = new Thread();
    when(internalFactory.newThread(Mockito.<Runnable>any())).thenReturn(thread);

    // Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", internalFactory))
        .newThread(mock(Runnable.class));

    // Assert
    verify(internalFactory).newThread(isA(Runnable.class));
    assertSame(thread, actualNewThreadResult);
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper4() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 1))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper5() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", false, 1))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper6() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 5))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper7() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 1, new ThreadGroup("foo")))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper8() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", false, 1, new ThreadGroup("foo")))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Method under test:
   * {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  void testNewNettyThreadFactoryWrapper9() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 5, new ThreadGroup("foo")))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }
}

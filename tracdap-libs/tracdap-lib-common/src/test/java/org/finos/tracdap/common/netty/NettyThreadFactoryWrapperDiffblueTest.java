package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.util.concurrent.FastThreadLocalThread;
import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NettyThreadFactoryWrapperDiffblueTest {
  /**
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, ThreadFactory)}.
   * <ul>
   *   <li>Given {@link Thread#Thread()}.</li>
   *   <li>Then return newThread {@link Runnable} is {@link Thread#Thread()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, ThreadFactory)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, ThreadFactory); given Thread(); then return newThread Runnable is Thread()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, ThreadFactory)"})
  void testNewNettyThreadFactoryWrapper_givenThread_thenReturnNewThreadRunnableIsThread() {
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
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}.
   * <ul>
   *   <li>When {@code 1.99*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String); when '1.99*'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String)"})
  void testNewNettyThreadFactoryWrapper_when199() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("1.99*")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int)"})
  void testNewNettyThreadFactoryWrapper_whenFalse() {
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
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int, ThreadGroup)"})
  void testNewNettyThreadFactoryWrapper_whenFalse2() {
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
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}.
   * <ul>
   *   <li>When five.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int); when five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int)"})
  void testNewNettyThreadFactoryWrapper_whenFive() {
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
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}.
   * <ul>
   *   <li>When five.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup); when five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int, ThreadGroup)"})
  void testNewNettyThreadFactoryWrapper_whenFive2() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name", true, 5, new ThreadGroup("foo")))
        .newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}.
   * <ul>
   *   <li>When {@code Pool Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String); when 'Pool Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String)"})
  void testNewNettyThreadFactoryWrapper_whenPoolName() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int)"})
  void testNewNettyThreadFactoryWrapper_whenTrue() {
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
   * Test {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup)}
   */
  @Test
  @DisplayName("Test new NettyThreadFactoryWrapper(String, boolean, int, ThreadGroup); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NettyThreadFactoryWrapper.<init>(String, boolean, int, ThreadGroup)"})
  void testNewNettyThreadFactoryWrapper_whenTrue2() {
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
   * Test {@link NettyThreadFactoryWrapper#newThread(Runnable)}.
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  @DisplayName("Test newThread(Runnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Thread NettyThreadFactoryWrapper.newThread(Runnable)"})
  void testNewThread() {
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
   * Test {@link NettyThreadFactoryWrapper#newThread(Runnable)}.
   * <ul>
   *   <li>Given {@link NettyThreadFactoryWrapper#NettyThreadFactoryWrapper(String)} with {@code Pool Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  @DisplayName("Test newThread(Runnable); given NettyThreadFactoryWrapper(String) with 'Pool Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Thread NettyThreadFactoryWrapper.newThread(Runnable)"})
  void testNewThread_givenNettyThreadFactoryWrapperWithPoolName() {
    // Arrange and Act
    Thread actualNewThreadResult = (new NettyThreadFactoryWrapper("Pool Name")).newThread(mock(Runnable.class));

    // Assert
    assertTrue(actualNewThreadResult instanceof FastThreadLocalThread);
    assertNull(((FastThreadLocalThread) actualNewThreadResult).threadLocalMap());
    assertFalse(((FastThreadLocalThread) actualNewThreadResult).permitBlockingCalls());
    assertTrue(((FastThreadLocalThread) actualNewThreadResult).willCleanupFastThreadLocals());
  }

  /**
   * Test {@link NettyThreadFactoryWrapper#newThread(Runnable)}.
   * <ul>
   *   <li>Given {@link ThreadFactory} {@link ThreadFactory#newThread(Runnable)} return {@link Thread#Thread()}.</li>
   *   <li>Then return {@link Thread#Thread()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NettyThreadFactoryWrapper#newThread(Runnable)}
   */
  @Test
  @DisplayName("Test newThread(Runnable); given ThreadFactory newThread(Runnable) return Thread(); then return Thread()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Thread NettyThreadFactoryWrapper.newThread(Runnable)"})
  void testNewThread_givenThreadFactoryNewThreadReturnThread_thenReturnThread() {
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
}

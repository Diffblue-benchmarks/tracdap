package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.logging.slf4j.Log4jLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class LoggingHelpersDiffblueTest {
  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When {@code 1024}.
   *   <li>Then return {@code 1.0 KB}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when '1024'; then return '1.0 KB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_when1024_thenReturn10Kb() {
    // Arrange, Act and Assert
    assertEquals("1.0 KB", LoggingHelpers.formatFileSize(1024L));
  }

  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When {@code 1048576}.
   *   <li>Then return {@code 1.0 MB}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when '1048576'; then return '1.0 MB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_when1048576_thenReturn10Mb() {
    // Arrange, Act and Assert
    assertEquals("1.0 MB", LoggingHelpers.formatFileSize(1048576L));
  }

  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When {@code 1073741824}.
   *   <li>Then return {@code 1.0 GB}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when '1073741824'; then return '1.0 GB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_when1073741824_thenReturn10Gb() {
    // Arrange, Act and Assert
    assertEquals("1.0 GB", LoggingHelpers.formatFileSize(1073741824L));
  }

  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 1 byte}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when one; then return '1 byte'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_whenOne_thenReturn1Byte() {
    // Arrange, Act and Assert
    assertEquals("1 byte", LoggingHelpers.formatFileSize(1L));
  }

  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 3 bytes}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when three; then return '3 bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_whenThree_thenReturn3Bytes() {
    // Arrange, Act and Assert
    assertEquals("3 bytes", LoggingHelpers.formatFileSize(3L));
  }

  /**
   * Test {@link LoggingHelpers#formatFileSize(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 0 bytes}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  @DisplayName("Test formatFileSize(long); when zero; then return '0 bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LoggingHelpers.formatFileSize(long)"})
  void testFormatFileSize_whenZero_thenReturn0Bytes() {
    // Arrange, Act and Assert
    assertEquals("0 bytes", LoggingHelpers.formatFileSize(0L));
  }

  /**
   * Test {@link LoggingHelpers#threadLocalLogger(Object, ThreadLocal)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@link Log4jLogger}.
   * </ul>
   *
   * <p>Method under test: {@link LoggingHelpers#threadLocalLogger(Object, ThreadLocal)}
   */
  @Test
  @DisplayName("Test threadLocalLogger(Object, ThreadLocal); when 'Obj'; then return Log4jLogger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Logger LoggingHelpers.threadLocalLogger(Object, ThreadLocal)"})
  void testThreadLocalLogger_whenObj_thenReturnLog4jLogger() {
    // Arrange and Act
    Logger actualThreadLocalLoggerResult =
        LoggingHelpers.threadLocalLogger("Obj", new ThreadLocal<>());

    // Assert
    assertTrue(actualThreadLocalLoggerResult instanceof Log4jLogger);
    assertEquals("java.lang.String", actualThreadLocalLoggerResult.getName());
    assertFalse(actualThreadLocalLoggerResult.isDebugEnabled());
    assertFalse(actualThreadLocalLoggerResult.isTraceEnabled());
    assertTrue(actualThreadLocalLoggerResult.isErrorEnabled());
    assertTrue(actualThreadLocalLoggerResult.isInfoEnabled());
    assertTrue(actualThreadLocalLoggerResult.isWarnEnabled());
  }
}

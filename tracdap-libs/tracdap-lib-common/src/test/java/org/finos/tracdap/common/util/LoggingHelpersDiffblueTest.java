package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.logging.slf4j.Log4jLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class LoggingHelpersDiffblueTest {
  /**
   * Method under test: {@link LoggingHelpers#formatFileSize(long)}
   */
  @Test
  void testFormatFileSize() {
    // Arrange, Act and Assert
    assertEquals("3 bytes", LoggingHelpers.formatFileSize(3L));
    assertEquals("1.0 KB", LoggingHelpers.formatFileSize(1024L));
    assertEquals("0 bytes", LoggingHelpers.formatFileSize(0L));
    assertEquals("1 byte", LoggingHelpers.formatFileSize(1L));
    assertEquals("1.0 MB", LoggingHelpers.formatFileSize(1048576L));
    assertEquals("1.0 GB", LoggingHelpers.formatFileSize(1073741824L));
  }

  /**
   * Method under test:
   * {@link LoggingHelpers#threadLocalLogger(Object, ThreadLocal)}
   */
  @Test
  void testThreadLocalLogger() {
    // Arrange and Act
    Logger actualThreadLocalLoggerResult = LoggingHelpers.threadLocalLogger("Obj", new ThreadLocal<>());

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

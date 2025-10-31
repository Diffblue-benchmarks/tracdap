package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheDiffblueTest {
  /**
   * Method under test: {@link ECache#ECache(String)}
   */
  @Test
  void testNewECache() {
    // Arrange and Act
    ECache actualECache = new ECache("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECache.getMessage());
    assertNull(actualECache.getCause());
    assertEquals(0, actualECache.getSuppressed().length);
  }

  /**
   * Method under test: {@link ECache#ECache(String, Throwable)}
   */
  @Test
  void testNewECache2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECache actualECache = new ECache("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECache.getMessage());
    assertEquals(0, actualECache.getSuppressed().length);
    assertSame(cause, actualECache.getCause());
  }
}

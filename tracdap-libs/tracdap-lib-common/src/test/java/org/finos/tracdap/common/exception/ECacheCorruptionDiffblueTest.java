package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheCorruptionDiffblueTest {
  /**
   * Method under test: {@link ECacheCorruption#ECacheCorruption(String)}
   */
  @Test
  void testNewECacheCorruption() {
    // Arrange and Act
    ECacheCorruption actualECacheCorruption = new ECacheCorruption("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheCorruption.getMessage());
    assertNull(actualECacheCorruption.getCause());
    assertEquals(0, actualECacheCorruption.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ECacheCorruption#ECacheCorruption(String, Throwable)}
   */
  @Test
  void testNewECacheCorruption2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheCorruption actualECacheCorruption = new ECacheCorruption("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheCorruption.getMessage());
    assertEquals(0, actualECacheCorruption.getSuppressed().length);
    assertSame(cause, actualECacheCorruption.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageConfigDiffblueTest {
  /**
   * Method under test: {@link EStorageConfig#EStorageConfig(String)}
   */
  @Test
  void testNewEStorageConfig() {
    // Arrange and Act
    EStorageConfig actualEStorageConfig = new EStorageConfig("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageConfig.getMessage());
    assertNull(actualEStorageConfig.getCause());
    assertEquals(0, actualEStorageConfig.getSuppressed().length);
  }

  /**
   * Method under test: {@link EStorageConfig#EStorageConfig(String, Throwable)}
   */
  @Test
  void testNewEStorageConfig2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageConfig actualEStorageConfig = new EStorageConfig("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageConfig.getMessage());
    assertEquals(0, actualEStorageConfig.getSuppressed().length);
    assertSame(cause, actualEStorageConfig.getCause());
  }
}

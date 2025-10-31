package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EConfigDiffblueTest {
  /**
   * Method under test: {@link EConfig#EConfig(String)}
   */
  @Test
  void testNewEConfig() {
    // Arrange and Act
    EConfig actualEConfig = new EConfig("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfig.getMessage());
    assertNull(actualEConfig.getCause());
    assertNull(actualEConfig.getDetails());
    assertEquals(0, actualEConfig.getSuppressed().length);
  }

  /**
   * Method under test: {@link EConfig#EConfig(String, Throwable)}
   */
  @Test
  void testNewEConfig2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfig actualEConfig = new EConfig("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfig.getMessage());
    assertNull(actualEConfig.getDetails());
    assertEquals(0, actualEConfig.getSuppressed().length);
    assertSame(cause, actualEConfig.getCause());
  }
}

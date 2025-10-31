package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EPluginNotAvailableDiffblueTest {
  /**
   * Method under test: {@link EPluginNotAvailable#EPluginNotAvailable(String)}
   */
  @Test
  void testNewEPluginNotAvailable() {
    // Arrange and Act
    EPluginNotAvailable actualEPluginNotAvailable = new EPluginNotAvailable("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEPluginNotAvailable.getMessage());
    assertNull(actualEPluginNotAvailable.getCause());
    assertNull(actualEPluginNotAvailable.getDetails());
    assertEquals(0, actualEPluginNotAvailable.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EPluginNotAvailable#EPluginNotAvailable(String, Throwable)}
   */
  @Test
  void testNewEPluginNotAvailable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EPluginNotAvailable actualEPluginNotAvailable = new EPluginNotAvailable("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEPluginNotAvailable.getMessage());
    assertNull(actualEPluginNotAvailable.getDetails());
    assertEquals(0, actualEPluginNotAvailable.getSuppressed().length);
    assertSame(cause, actualEPluginNotAvailable.getCause());
  }
}

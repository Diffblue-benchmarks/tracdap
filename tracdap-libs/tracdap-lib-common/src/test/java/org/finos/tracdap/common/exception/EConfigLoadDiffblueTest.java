package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EConfigLoadDiffblueTest {
  /**
   * Method under test: {@link EConfigLoad#EConfigLoad(String)}
   */
  @Test
  void testNewEConfigLoad() {
    // Arrange and Act
    EConfigLoad actualEConfigLoad = new EConfigLoad("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigLoad.getMessage());
    assertNull(actualEConfigLoad.getCause());
    assertNull(actualEConfigLoad.getDetails());
    assertEquals(0, actualEConfigLoad.getSuppressed().length);
  }

  /**
   * Method under test: {@link EConfigLoad#EConfigLoad(String, Throwable)}
   */
  @Test
  void testNewEConfigLoad2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfigLoad actualEConfigLoad = new EConfigLoad("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigLoad.getMessage());
    assertNull(actualEConfigLoad.getDetails());
    assertEquals(0, actualEConfigLoad.getSuppressed().length);
    assertSame(cause, actualEConfigLoad.getCause());
  }
}

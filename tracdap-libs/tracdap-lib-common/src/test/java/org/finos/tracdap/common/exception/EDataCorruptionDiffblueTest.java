package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EDataCorruptionDiffblueTest {
  /**
   * Method under test: {@link EDataCorruption#EDataCorruption(String)}
   */
  @Test
  void testNewEDataCorruption() {
    // Arrange and Act
    EDataCorruption actualEDataCorruption = new EDataCorruption("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataCorruption.getMessage());
    assertNull(actualEDataCorruption.getCause());
    assertNull(actualEDataCorruption.getDetails());
    assertEquals(0, actualEDataCorruption.getSuppressed().length);
  }

  /**
   * Method under test: {@link EDataCorruption#EDataCorruption(String, Throwable)}
   */
  @Test
  void testNewEDataCorruption2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataCorruption actualEDataCorruption = new EDataCorruption("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataCorruption.getMessage());
    assertNull(actualEDataCorruption.getDetails());
    assertEquals(0, actualEDataCorruption.getSuppressed().length);
    assertSame(cause, actualEDataCorruption.getCause());
  }
}

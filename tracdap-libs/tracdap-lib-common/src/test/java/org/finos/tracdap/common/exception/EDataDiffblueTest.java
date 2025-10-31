package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EDataDiffblueTest {
  /**
   * Method under test: {@link EData#EData(String)}
   */
  @Test
  void testNewEData() {
    // Arrange and Act
    EData actualEData = new EData("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEData.getMessage());
    assertNull(actualEData.getCause());
    assertNull(actualEData.getDetails());
    assertEquals(0, actualEData.getSuppressed().length);
  }

  /**
   * Method under test: {@link EData#EData(String, Throwable)}
   */
  @Test
  void testNewEData2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EData actualEData = new EData("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEData.getMessage());
    assertNull(actualEData.getDetails());
    assertEquals(0, actualEData.getSuppressed().length);
    assertSame(cause, actualEData.getCause());
  }
}

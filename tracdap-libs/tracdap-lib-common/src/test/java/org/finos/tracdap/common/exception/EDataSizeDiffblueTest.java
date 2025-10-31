package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EDataSizeDiffblueTest {
  /**
   * Method under test: {@link EDataSize#EDataSize(String)}
   */
  @Test
  void testNewEDataSize() {
    // Arrange and Act
    EDataSize actualEDataSize = new EDataSize("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataSize.getMessage());
    assertNull(actualEDataSize.getCause());
    assertNull(actualEDataSize.getDetails());
    assertEquals(0, actualEDataSize.getSuppressed().length);
  }

  /**
   * Method under test: {@link EDataSize#EDataSize(String, Throwable)}
   */
  @Test
  void testNewEDataSize2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataSize actualEDataSize = new EDataSize("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataSize.getMessage());
    assertNull(actualEDataSize.getDetails());
    assertEquals(0, actualEDataSize.getSuppressed().length);
    assertSame(cause, actualEDataSize.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EDataTypeNotSupportedDiffblueTest {
  /**
   * Method under test:
   * {@link EDataTypeNotSupported#EDataTypeNotSupported(String)}
   */
  @Test
  void testNewEDataTypeNotSupported() {
    // Arrange and Act
    EDataTypeNotSupported actualEDataTypeNotSupported = new EDataTypeNotSupported("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataTypeNotSupported.getMessage());
    assertNull(actualEDataTypeNotSupported.getCause());
    assertNull(actualEDataTypeNotSupported.getDetails());
    assertEquals(0, actualEDataTypeNotSupported.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EDataTypeNotSupported#EDataTypeNotSupported(String, Throwable)}
   */
  @Test
  void testNewEDataTypeNotSupported2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataTypeNotSupported actualEDataTypeNotSupported = new EDataTypeNotSupported("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataTypeNotSupported.getMessage());
    assertNull(actualEDataTypeNotSupported.getDetails());
    assertEquals(0, actualEDataTypeNotSupported.getSuppressed().length);
    assertSame(cause, actualEDataTypeNotSupported.getCause());
  }
}

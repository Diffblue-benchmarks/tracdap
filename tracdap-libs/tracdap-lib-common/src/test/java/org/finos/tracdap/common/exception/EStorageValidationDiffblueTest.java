package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageValidationDiffblueTest {
  /**
   * Method under test: {@link EStorageValidation#EStorageValidation(String)}
   */
  @Test
  void testNewEStorageValidation() {
    // Arrange and Act
    EStorageValidation actualEStorageValidation = new EStorageValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageValidation.getMessage());
    assertNull(actualEStorageValidation.getCause());
    assertEquals(0, actualEStorageValidation.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EStorageValidation#EStorageValidation(String, Throwable)}
   */
  @Test
  void testNewEStorageValidation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageValidation actualEStorageValidation = new EStorageValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageValidation.getMessage());
    assertEquals(0, actualEStorageValidation.getSuppressed().length);
    assertSame(cause, actualEStorageValidation.getCause());
  }
}

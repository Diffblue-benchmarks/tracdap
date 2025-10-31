package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.tracdap.api.TracErrorDetails;
import org.junit.jupiter.api.Test;

class EInputValidationDiffblueTest {
  /**
   * Method under test: {@link EInputValidation#EInputValidation(String)}
   */
  @Test
  void testNewEInputValidation() {
    // Arrange and Act
    EInputValidation actualEInputValidation = new EInputValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEInputValidation.getMessage());
    assertNull(actualEInputValidation.getCause());
    assertNull(actualEInputValidation.getDetails());
    assertEquals(0, actualEInputValidation.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EInputValidation#EInputValidation(String, Throwable)}
   */
  @Test
  void testNewEInputValidation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EInputValidation actualEInputValidation = new EInputValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEInputValidation.getMessage());
    assertNull(actualEInputValidation.getDetails());
    assertEquals(0, actualEInputValidation.getSuppressed().length);
    assertSame(cause, actualEInputValidation.getCause());
  }

  /**
   * Method under test:
   * {@link EInputValidation#EInputValidation(String, TracErrorDetails)}
   */
  @Test
  void testNewEInputValidation3() {
    // Arrange
    TracErrorDetails details = TracErrorDetails.getDefaultInstance();

    // Act
    EInputValidation actualEInputValidation = new EInputValidation("Not all who wander are lost", details);

    // Assert
    assertEquals("Not all who wander are lost", actualEInputValidation.getMessage());
    assertNull(actualEInputValidation.getCause());
    assertEquals(0, actualEInputValidation.getSuppressed().length);
    assertSame(details, actualEInputValidation.getDetails());
  }
}

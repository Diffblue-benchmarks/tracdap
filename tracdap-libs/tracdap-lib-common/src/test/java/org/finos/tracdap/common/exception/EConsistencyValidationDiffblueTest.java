package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.tracdap.api.TracErrorDetails;
import org.junit.jupiter.api.Test;

class EConsistencyValidationDiffblueTest {
  /**
   * Method under test:
   * {@link EConsistencyValidation#EConsistencyValidation(String)}
   */
  @Test
  void testNewEConsistencyValidation() {
    // Arrange and Act
    EConsistencyValidation actualEConsistencyValidation = new EConsistencyValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConsistencyValidation.getMessage());
    assertNull(actualEConsistencyValidation.getCause());
    assertNull(actualEConsistencyValidation.getDetails());
    assertEquals(0, actualEConsistencyValidation.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EConsistencyValidation#EConsistencyValidation(String, Throwable)}
   */
  @Test
  void testNewEConsistencyValidation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConsistencyValidation actualEConsistencyValidation = new EConsistencyValidation("Not all who wander are lost",
        cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConsistencyValidation.getMessage());
    assertNull(actualEConsistencyValidation.getDetails());
    assertEquals(0, actualEConsistencyValidation.getSuppressed().length);
    assertSame(cause, actualEConsistencyValidation.getCause());
  }

  /**
   * Method under test:
   * {@link EConsistencyValidation#EConsistencyValidation(String, TracErrorDetails)}
   */
  @Test
  void testNewEConsistencyValidation3() {
    // Arrange
    TracErrorDetails details = TracErrorDetails.getDefaultInstance();

    // Act
    EConsistencyValidation actualEConsistencyValidation = new EConsistencyValidation("Not all who wander are lost",
        details);

    // Assert
    assertEquals("Not all who wander are lost", actualEConsistencyValidation.getMessage());
    assertNull(actualEConsistencyValidation.getCause());
    assertEquals(0, actualEConsistencyValidation.getSuppressed().length);
    assertSame(details, actualEConsistencyValidation.getDetails());
  }
}

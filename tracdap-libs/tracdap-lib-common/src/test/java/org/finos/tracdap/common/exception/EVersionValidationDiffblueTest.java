package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.tracdap.api.TracErrorDetails;
import org.junit.jupiter.api.Test;

class EVersionValidationDiffblueTest {
  /**
   * Method under test: {@link EVersionValidation#EVersionValidation(String)}
   */
  @Test
  void testNewEVersionValidation() {
    // Arrange and Act
    EVersionValidation actualEVersionValidation = new EVersionValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEVersionValidation.getMessage());
    assertNull(actualEVersionValidation.getCause());
    assertNull(actualEVersionValidation.getDetails());
    assertEquals(0, actualEVersionValidation.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EVersionValidation#EVersionValidation(String, Throwable)}
   */
  @Test
  void testNewEVersionValidation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EVersionValidation actualEVersionValidation = new EVersionValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEVersionValidation.getMessage());
    assertNull(actualEVersionValidation.getDetails());
    assertEquals(0, actualEVersionValidation.getSuppressed().length);
    assertSame(cause, actualEVersionValidation.getCause());
  }

  /**
   * Method under test:
   * {@link EVersionValidation#EVersionValidation(String, TracErrorDetails)}
   */
  @Test
  void testNewEVersionValidation3() {
    // Arrange
    TracErrorDetails details = TracErrorDetails.getDefaultInstance();

    // Act
    EVersionValidation actualEVersionValidation = new EVersionValidation("Not all who wander are lost", details);

    // Assert
    assertEquals("Not all who wander are lost", actualEVersionValidation.getMessage());
    assertNull(actualEVersionValidation.getCause());
    assertEquals(0, actualEVersionValidation.getSuppressed().length);
    assertSame(details, actualEVersionValidation.getDetails());
  }
}

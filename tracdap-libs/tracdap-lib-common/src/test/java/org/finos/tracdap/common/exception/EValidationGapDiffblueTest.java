package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EValidationGapDiffblueTest {
  /**
   * Method under test: {@link EValidationGap#EValidationGap(String)}
   */
  @Test
  void testNewEValidationGap() {
    // Arrange and Act
    EValidationGap actualEValidationGap = new EValidationGap("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEValidationGap.getMessage());
    assertNull(actualEValidationGap.getCause());
    assertEquals(0, actualEValidationGap.getSuppressed().length);
  }

  /**
   * Method under test: {@link EValidationGap#EValidationGap(String, Throwable)}
   */
  @Test
  void testNewEValidationGap2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EValidationGap actualEValidationGap = new EValidationGap("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEValidationGap.getMessage());
    assertEquals(0, actualEValidationGap.getSuppressed().length);
    assertSame(cause, actualEValidationGap.getCause());
  }
}

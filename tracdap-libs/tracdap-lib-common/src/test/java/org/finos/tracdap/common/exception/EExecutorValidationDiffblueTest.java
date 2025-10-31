package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorValidationDiffblueTest {
  /**
   * Method under test: {@link EExecutorValidation#EExecutorValidation(String)}
   */
  @Test
  void testNewEExecutorValidation() {
    // Arrange and Act
    EExecutorValidation actualEExecutorValidation = new EExecutorValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorValidation.getMessage());
    assertNull(actualEExecutorValidation.getCause());
    assertEquals(0, actualEExecutorValidation.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EExecutorValidation#EExecutorValidation(String, Throwable)}
   */
  @Test
  void testNewEExecutorValidation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorValidation actualEExecutorValidation = new EExecutorValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorValidation.getMessage());
    assertEquals(0, actualEExecutorValidation.getSuppressed().length);
    assertSame(cause, actualEExecutorValidation.getCause());
  }
}

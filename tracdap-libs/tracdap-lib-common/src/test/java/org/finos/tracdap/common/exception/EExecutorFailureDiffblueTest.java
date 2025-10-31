package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorFailureDiffblueTest {
  /**
   * Method under test: {@link EExecutorFailure#EExecutorFailure(String)}
   */
  @Test
  void testNewEExecutorFailure() {
    // Arrange and Act
    EExecutorFailure actualEExecutorFailure = new EExecutorFailure("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorFailure.getMessage());
    assertNull(actualEExecutorFailure.getCause());
    assertEquals(0, actualEExecutorFailure.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EExecutorFailure#EExecutorFailure(String, Throwable)}
   */
  @Test
  void testNewEExecutorFailure2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorFailure actualEExecutorFailure = new EExecutorFailure("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorFailure.getMessage());
    assertEquals(0, actualEExecutorFailure.getSuppressed().length);
    assertSame(cause, actualEExecutorFailure.getCause());
  }
}

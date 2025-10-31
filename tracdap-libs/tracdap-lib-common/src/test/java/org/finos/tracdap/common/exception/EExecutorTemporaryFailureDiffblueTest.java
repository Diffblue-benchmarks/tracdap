package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorTemporaryFailureDiffblueTest {
  /**
   * Method under test:
   * {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String)}
   */
  @Test
  void testNewEExecutorTemporaryFailure() {
    // Arrange and Act
    EExecutorTemporaryFailure actualEExecutorTemporaryFailure = new EExecutorTemporaryFailure(
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorTemporaryFailure.getMessage());
    assertNull(actualEExecutorTemporaryFailure.getCause());
    assertEquals(0, actualEExecutorTemporaryFailure.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String, Throwable)}
   */
  @Test
  void testNewEExecutorTemporaryFailure2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorTemporaryFailure actualEExecutorTemporaryFailure = new EExecutorTemporaryFailure(
        "Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorTemporaryFailure.getMessage());
    assertEquals(0, actualEExecutorTemporaryFailure.getSuppressed().length);
    assertSame(cause, actualEExecutorTemporaryFailure.getCause());
  }
}

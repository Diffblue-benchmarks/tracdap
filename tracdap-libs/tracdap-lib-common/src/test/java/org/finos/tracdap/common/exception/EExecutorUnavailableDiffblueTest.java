package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorUnavailableDiffblueTest {
  /**
   * Method under test: {@link EExecutorUnavailable#EExecutorUnavailable(String)}
   */
  @Test
  void testNewEExecutorUnavailable() {
    // Arrange and Act
    EExecutorUnavailable actualEExecutorUnavailable = new EExecutorUnavailable("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorUnavailable.getMessage());
    assertNull(actualEExecutorUnavailable.getCause());
    assertEquals(0, actualEExecutorUnavailable.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EExecutorUnavailable#EExecutorUnavailable(String, Throwable)}
   */
  @Test
  void testNewEExecutorUnavailable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorUnavailable actualEExecutorUnavailable = new EExecutorUnavailable("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorUnavailable.getMessage());
    assertEquals(0, actualEExecutorUnavailable.getSuppressed().length);
    assertSame(cause, actualEExecutorUnavailable.getCause());
  }
}

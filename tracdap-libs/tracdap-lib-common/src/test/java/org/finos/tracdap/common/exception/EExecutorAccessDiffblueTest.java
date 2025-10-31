package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorAccessDiffblueTest {
  /**
   * Method under test: {@link EExecutorAccess#EExecutorAccess(String)}
   */
  @Test
  void testNewEExecutorAccess() {
    // Arrange and Act
    EExecutorAccess actualEExecutorAccess = new EExecutorAccess("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorAccess.getMessage());
    assertNull(actualEExecutorAccess.getCause());
    assertEquals(0, actualEExecutorAccess.getSuppressed().length);
  }

  /**
   * Method under test: {@link EExecutorAccess#EExecutorAccess(String, Throwable)}
   */
  @Test
  void testNewEExecutorAccess2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorAccess actualEExecutorAccess = new EExecutorAccess("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorAccess.getMessage());
    assertEquals(0, actualEExecutorAccess.getSuppressed().length);
    assertSame(cause, actualEExecutorAccess.getCause());
  }
}

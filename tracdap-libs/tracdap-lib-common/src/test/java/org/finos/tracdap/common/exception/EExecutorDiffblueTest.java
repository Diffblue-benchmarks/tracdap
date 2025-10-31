package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EExecutorDiffblueTest {
  /**
   * Method under test: {@link EExecutor#EExecutor(String)}
   */
  @Test
  void testNewEExecutor() {
    // Arrange and Act
    EExecutor actualEExecutor = new EExecutor("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutor.getMessage());
    assertNull(actualEExecutor.getCause());
    assertEquals(0, actualEExecutor.getSuppressed().length);
  }

  /**
   * Method under test: {@link EExecutor#EExecutor(String, Throwable)}
   */
  @Test
  void testNewEExecutor2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutor actualEExecutor = new EExecutor("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutor.getMessage());
    assertEquals(0, actualEExecutor.getSuppressed().length);
    assertSame(cause, actualEExecutor.getCause());
  }
}

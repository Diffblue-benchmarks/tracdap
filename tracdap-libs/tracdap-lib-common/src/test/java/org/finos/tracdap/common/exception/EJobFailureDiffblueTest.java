package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EJobFailureDiffblueTest {
  /**
   * Method under test: {@link EJobFailure#EJobFailure(String)}
   */
  @Test
  void testNewEJobFailure() {
    // Arrange and Act
    EJobFailure actualEJobFailure = new EJobFailure("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEJobFailure.getMessage());
    assertNull(actualEJobFailure.getCause());
    assertNull(actualEJobFailure.getDetails());
    assertEquals(0, actualEJobFailure.getSuppressed().length);
  }

  /**
   * Method under test: {@link EJobFailure#EJobFailure(String, Throwable)}
   */
  @Test
  void testNewEJobFailure2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EJobFailure actualEJobFailure = new EJobFailure("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEJobFailure.getMessage());
    assertNull(actualEJobFailure.getDetails());
    assertEquals(0, actualEJobFailure.getSuppressed().length);
    assertSame(cause, actualEJobFailure.getCause());
  }
}

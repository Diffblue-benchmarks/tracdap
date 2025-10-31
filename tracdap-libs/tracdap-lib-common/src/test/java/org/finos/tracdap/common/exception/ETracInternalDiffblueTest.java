package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ETracInternalDiffblueTest {
  /**
   * Method under test: {@link ETracInternal#ETracInternal(String)}
   */
  @Test
  void testNewETracInternal() {
    // Arrange and Act
    ETracInternal actualETracInternal = new ETracInternal("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualETracInternal.getMessage());
    assertNull(actualETracInternal.getCause());
    assertEquals(0, actualETracInternal.getSuppressed().length);
  }

  /**
   * Method under test: {@link ETracInternal#ETracInternal(String, Throwable)}
   */
  @Test
  void testNewETracInternal2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ETracInternal actualETracInternal = new ETracInternal("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualETracInternal.getMessage());
    assertEquals(0, actualETracInternal.getSuppressed().length);
    assertSame(cause, actualETracInternal.getCause());
  }
}

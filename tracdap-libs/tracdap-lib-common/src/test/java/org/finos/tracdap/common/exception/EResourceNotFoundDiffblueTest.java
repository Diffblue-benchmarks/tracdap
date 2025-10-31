package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EResourceNotFoundDiffblueTest {
  /**
   * Method under test: {@link EResourceNotFound#EResourceNotFound(String)}
   */
  @Test
  void testNewEResourceNotFound() {
    // Arrange and Act
    EResourceNotFound actualEResourceNotFound = new EResourceNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEResourceNotFound.getMessage());
    assertNull(actualEResourceNotFound.getCause());
    assertNull(actualEResourceNotFound.getDetails());
    assertEquals(0, actualEResourceNotFound.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EResourceNotFound#EResourceNotFound(String, Throwable)}
   */
  @Test
  void testNewEResourceNotFound2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EResourceNotFound actualEResourceNotFound = new EResourceNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEResourceNotFound.getMessage());
    assertNull(actualEResourceNotFound.getDetails());
    assertEquals(0, actualEResourceNotFound.getSuppressed().length);
    assertSame(cause, actualEResourceNotFound.getCause());
  }
}

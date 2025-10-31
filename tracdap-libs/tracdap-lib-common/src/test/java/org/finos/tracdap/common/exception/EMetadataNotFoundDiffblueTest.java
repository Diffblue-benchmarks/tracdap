package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataNotFoundDiffblueTest {
  /**
   * Method under test: {@link EMetadataNotFound#EMetadataNotFound(String)}
   */
  @Test
  void testNewEMetadataNotFound() {
    // Arrange and Act
    EMetadataNotFound actualEMetadataNotFound = new EMetadataNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataNotFound.getMessage());
    assertNull(actualEMetadataNotFound.getCause());
    assertNull(actualEMetadataNotFound.getDetails());
    assertEquals(0, actualEMetadataNotFound.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EMetadataNotFound#EMetadataNotFound(String, Throwable)}
   */
  @Test
  void testNewEMetadataNotFound2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataNotFound actualEMetadataNotFound = new EMetadataNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataNotFound.getMessage());
    assertNull(actualEMetadataNotFound.getDetails());
    assertEquals(0, actualEMetadataNotFound.getSuppressed().length);
    assertSame(cause, actualEMetadataNotFound.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataDuplicateDiffblueTest {
  /**
   * Method under test: {@link EMetadataDuplicate#EMetadataDuplicate(String)}
   */
  @Test
  void testNewEMetadataDuplicate() {
    // Arrange and Act
    EMetadataDuplicate actualEMetadataDuplicate = new EMetadataDuplicate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataDuplicate.getMessage());
    assertNull(actualEMetadataDuplicate.getCause());
    assertNull(actualEMetadataDuplicate.getDetails());
    assertEquals(0, actualEMetadataDuplicate.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EMetadataDuplicate#EMetadataDuplicate(String, Throwable)}
   */
  @Test
  void testNewEMetadataDuplicate2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataDuplicate actualEMetadataDuplicate = new EMetadataDuplicate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataDuplicate.getMessage());
    assertNull(actualEMetadataDuplicate.getDetails());
    assertEquals(0, actualEMetadataDuplicate.getSuppressed().length);
    assertSame(cause, actualEMetadataDuplicate.getCause());
  }
}

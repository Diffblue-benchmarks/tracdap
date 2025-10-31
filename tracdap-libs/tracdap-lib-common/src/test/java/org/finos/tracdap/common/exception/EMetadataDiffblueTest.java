package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataDiffblueTest {
  /**
   * Method under test: {@link EMetadata#EMetadata(String)}
   */
  @Test
  void testNewEMetadata() {
    // Arrange and Act
    EMetadata actualEMetadata = new EMetadata("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadata.getMessage());
    assertNull(actualEMetadata.getCause());
    assertNull(actualEMetadata.getDetails());
    assertEquals(0, actualEMetadata.getSuppressed().length);
  }

  /**
   * Method under test: {@link EMetadata#EMetadata(String, Throwable)}
   */
  @Test
  void testNewEMetadata2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadata actualEMetadata = new EMetadata("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadata.getMessage());
    assertNull(actualEMetadata.getDetails());
    assertEquals(0, actualEMetadata.getSuppressed().length);
    assertSame(cause, actualEMetadata.getCause());
  }
}

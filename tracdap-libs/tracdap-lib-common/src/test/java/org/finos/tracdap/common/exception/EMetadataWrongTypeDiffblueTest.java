package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataWrongTypeDiffblueTest {
  /**
   * Method under test: {@link EMetadataWrongType#EMetadataWrongType(String)}
   */
  @Test
  void testNewEMetadataWrongType() {
    // Arrange and Act
    EMetadataWrongType actualEMetadataWrongType = new EMetadataWrongType("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataWrongType.getMessage());
    assertNull(actualEMetadataWrongType.getCause());
    assertNull(actualEMetadataWrongType.getDetails());
    assertEquals(0, actualEMetadataWrongType.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EMetadataWrongType#EMetadataWrongType(String, Throwable)}
   */
  @Test
  void testNewEMetadataWrongType2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataWrongType actualEMetadataWrongType = new EMetadataWrongType("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataWrongType.getMessage());
    assertNull(actualEMetadataWrongType.getDetails());
    assertEquals(0, actualEMetadataWrongType.getSuppressed().length);
    assertSame(cause, actualEMetadataWrongType.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataCorruptDiffblueTest {
  /**
   * Method under test: {@link EMetadataCorrupt#EMetadataCorrupt(String)}
   */
  @Test
  void testNewEMetadataCorrupt() {
    // Arrange and Act
    EMetadataCorrupt actualEMetadataCorrupt = new EMetadataCorrupt("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataCorrupt.getMessage());
    assertNull(actualEMetadataCorrupt.getCause());
    assertNull(actualEMetadataCorrupt.getDetails());
    assertEquals(0, actualEMetadataCorrupt.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EMetadataCorrupt#EMetadataCorrupt(String, Throwable)}
   */
  @Test
  void testNewEMetadataCorrupt2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataCorrupt actualEMetadataCorrupt = new EMetadataCorrupt("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataCorrupt.getMessage());
    assertNull(actualEMetadataCorrupt.getDetails());
    assertEquals(0, actualEMetadataCorrupt.getSuppressed().length);
    assertSame(cause, actualEMetadataCorrupt.getCause());
  }
}

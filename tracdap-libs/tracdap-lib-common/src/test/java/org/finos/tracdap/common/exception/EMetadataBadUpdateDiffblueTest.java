package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EMetadataBadUpdateDiffblueTest {
  /**
   * Method under test: {@link EMetadataBadUpdate#EMetadataBadUpdate(String)}
   */
  @Test
  void testNewEMetadataBadUpdate() {
    // Arrange and Act
    EMetadataBadUpdate actualEMetadataBadUpdate = new EMetadataBadUpdate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataBadUpdate.getMessage());
    assertNull(actualEMetadataBadUpdate.getCause());
    assertNull(actualEMetadataBadUpdate.getDetails());
    assertEquals(0, actualEMetadataBadUpdate.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EMetadataBadUpdate#EMetadataBadUpdate(String, Throwable)}
   */
  @Test
  void testNewEMetadataBadUpdate2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataBadUpdate actualEMetadataBadUpdate = new EMetadataBadUpdate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataBadUpdate.getMessage());
    assertNull(actualEMetadataBadUpdate.getDetails());
    assertEquals(0, actualEMetadataBadUpdate.getSuppressed().length);
    assertSame(cause, actualEMetadataBadUpdate.getCause());
  }
}

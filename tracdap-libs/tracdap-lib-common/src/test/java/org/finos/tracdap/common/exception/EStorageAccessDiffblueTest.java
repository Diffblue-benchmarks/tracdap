package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageAccessDiffblueTest {
  /**
   * Method under test: {@link EStorageAccess#EStorageAccess(String)}
   */
  @Test
  void testNewEStorageAccess() {
    // Arrange and Act
    EStorageAccess actualEStorageAccess = new EStorageAccess("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageAccess.getMessage());
    assertNull(actualEStorageAccess.getCause());
    assertEquals(0, actualEStorageAccess.getSuppressed().length);
  }

  /**
   * Method under test: {@link EStorageAccess#EStorageAccess(String, Throwable)}
   */
  @Test
  void testNewEStorageAccess2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageAccess actualEStorageAccess = new EStorageAccess("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageAccess.getMessage());
    assertEquals(0, actualEStorageAccess.getSuppressed().length);
    assertSame(cause, actualEStorageAccess.getCause());
  }
}

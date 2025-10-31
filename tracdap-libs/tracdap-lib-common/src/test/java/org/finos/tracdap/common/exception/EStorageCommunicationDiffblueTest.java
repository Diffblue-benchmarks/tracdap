package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageCommunicationDiffblueTest {
  /**
   * Method under test:
   * {@link EStorageCommunication#EStorageCommunication(String)}
   */
  @Test
  void testNewEStorageCommunication() {
    // Arrange and Act
    EStorageCommunication actualEStorageCommunication = new EStorageCommunication("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageCommunication.getMessage());
    assertNull(actualEStorageCommunication.getCause());
    assertEquals(0, actualEStorageCommunication.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EStorageCommunication#EStorageCommunication(String, Throwable)}
   */
  @Test
  void testNewEStorageCommunication2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageCommunication actualEStorageCommunication = new EStorageCommunication("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageCommunication.getMessage());
    assertEquals(0, actualEStorageCommunication.getSuppressed().length);
    assertSame(cause, actualEStorageCommunication.getCause());
  }
}

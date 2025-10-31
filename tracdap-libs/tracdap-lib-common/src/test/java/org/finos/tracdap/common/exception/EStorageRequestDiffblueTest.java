package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageRequestDiffblueTest {
  /**
   * Method under test: {@link EStorageRequest#EStorageRequest(String)}
   */
  @Test
  void testNewEStorageRequest() {
    // Arrange and Act
    EStorageRequest actualEStorageRequest = new EStorageRequest("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageRequest.getMessage());
    assertNull(actualEStorageRequest.getCause());
    assertEquals(0, actualEStorageRequest.getSuppressed().length);
  }

  /**
   * Method under test: {@link EStorageRequest#EStorageRequest(String, Throwable)}
   */
  @Test
  void testNewEStorageRequest2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageRequest actualEStorageRequest = new EStorageRequest("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageRequest.getMessage());
    assertEquals(0, actualEStorageRequest.getSuppressed().length);
    assertSame(cause, actualEStorageRequest.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheOperationDiffblueTest {
  /**
   * Method under test: {@link ECacheOperation#ECacheOperation(String)}
   */
  @Test
  void testNewECacheOperation() {
    // Arrange and Act
    ECacheOperation actualECacheOperation = new ECacheOperation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheOperation.getMessage());
    assertNull(actualECacheOperation.getCause());
    assertEquals(0, actualECacheOperation.getSuppressed().length);
  }

  /**
   * Method under test: {@link ECacheOperation#ECacheOperation(String, Throwable)}
   */
  @Test
  void testNewECacheOperation2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheOperation actualECacheOperation = new ECacheOperation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheOperation.getMessage());
    assertEquals(0, actualECacheOperation.getSuppressed().length);
    assertSame(cause, actualECacheOperation.getCause());
  }
}

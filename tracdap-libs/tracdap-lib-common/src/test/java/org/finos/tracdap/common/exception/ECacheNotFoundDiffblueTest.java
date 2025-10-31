package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheNotFoundDiffblueTest {
  /**
   * Method under test: {@link ECacheNotFound#ECacheNotFound(String)}
   */
  @Test
  void testNewECacheNotFound() {
    // Arrange and Act
    ECacheNotFound actualECacheNotFound = new ECacheNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheNotFound.getMessage());
    assertNull(actualECacheNotFound.getCause());
    assertEquals(0, actualECacheNotFound.getSuppressed().length);
  }

  /**
   * Method under test: {@link ECacheNotFound#ECacheNotFound(String, Throwable)}
   */
  @Test
  void testNewECacheNotFound2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheNotFound actualECacheNotFound = new ECacheNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheNotFound.getMessage());
    assertEquals(0, actualECacheNotFound.getSuppressed().length);
    assertSame(cause, actualECacheNotFound.getCause());
  }
}

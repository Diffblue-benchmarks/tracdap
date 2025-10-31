package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ETenantNotFoundDiffblueTest {
  /**
   * Method under test: {@link ETenantNotFound#ETenantNotFound(String)}
   */
  @Test
  void testNewETenantNotFound() {
    // Arrange and Act
    ETenantNotFound actualETenantNotFound = new ETenantNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualETenantNotFound.getMessage());
    assertNull(actualETenantNotFound.getCause());
    assertNull(actualETenantNotFound.getDetails());
    assertEquals(0, actualETenantNotFound.getSuppressed().length);
  }

  /**
   * Method under test: {@link ETenantNotFound#ETenantNotFound(String, Throwable)}
   */
  @Test
  void testNewETenantNotFound2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ETenantNotFound actualETenantNotFound = new ETenantNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualETenantNotFound.getMessage());
    assertNull(actualETenantNotFound.getDetails());
    assertEquals(0, actualETenantNotFound.getSuppressed().length);
    assertSame(cause, actualETenantNotFound.getCause());
  }
}

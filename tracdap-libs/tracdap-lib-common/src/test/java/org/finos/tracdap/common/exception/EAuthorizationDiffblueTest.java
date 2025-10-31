package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EAuthorizationDiffblueTest {
  /**
   * Method under test: {@link EAuthorization#EAuthorization(String)}
   */
  @Test
  void testNewEAuthorization() {
    // Arrange and Act
    EAuthorization actualEAuthorization = new EAuthorization("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEAuthorization.getMessage());
    assertNull(actualEAuthorization.getCause());
    assertNull(actualEAuthorization.getDetails());
    assertEquals(0, actualEAuthorization.getSuppressed().length);
  }

  /**
   * Method under test: {@link EAuthorization#EAuthorization(String, Throwable)}
   */
  @Test
  void testNewEAuthorization2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EAuthorization actualEAuthorization = new EAuthorization("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEAuthorization.getMessage());
    assertNull(actualEAuthorization.getDetails());
    assertEquals(0, actualEAuthorization.getSuppressed().length);
    assertSame(cause, actualEAuthorization.getCause());
  }
}

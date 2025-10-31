package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheTicketDiffblueTest {
  /**
   * Method under test: {@link ECacheTicket#ECacheTicket(String)}
   */
  @Test
  void testNewECacheTicket() {
    // Arrange and Act
    ECacheTicket actualECacheTicket = new ECacheTicket("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheTicket.getMessage());
    assertNull(actualECacheTicket.getCause());
    assertEquals(0, actualECacheTicket.getSuppressed().length);
  }

  /**
   * Method under test: {@link ECacheTicket#ECacheTicket(String, Throwable)}
   */
  @Test
  void testNewECacheTicket2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheTicket actualECacheTicket = new ECacheTicket("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheTicket.getMessage());
    assertEquals(0, actualECacheTicket.getSuppressed().length);
    assertSame(cause, actualECacheTicket.getCause());
  }
}

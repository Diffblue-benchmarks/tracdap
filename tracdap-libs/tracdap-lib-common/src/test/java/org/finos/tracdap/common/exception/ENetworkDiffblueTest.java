package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ENetworkDiffblueTest {
  /**
   * Method under test: {@link ENetwork#ENetwork(String)}
   */
  @Test
  void testNewENetwork() {
    // Arrange and Act
    ENetwork actualENetwork = new ENetwork("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualENetwork.getMessage());
    assertNull(actualENetwork.getCause());
    assertEquals(0, actualENetwork.getSuppressed().length);
  }

  /**
   * Method under test: {@link ENetwork#ENetwork(String, Throwable)}
   */
  @Test
  void testNewENetwork2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ENetwork actualENetwork = new ENetwork("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualENetwork.getMessage());
    assertEquals(0, actualENetwork.getSuppressed().length);
    assertSame(cause, actualENetwork.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ENetworkHttpDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ENetworkHttp#ENetworkHttp(int, String)}
   *   <li>{@link ENetworkHttp#getStatusCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ENetworkHttp actualENetworkHttp = new ENetworkHttp(1, "https://example.org/example");
    int actualStatusCode = actualENetworkHttp.getStatusCode();

    // Assert
    assertEquals("https://example.org/example", actualENetworkHttp.getMessage());
    assertNull(actualENetworkHttp.getCause());
    assertEquals(0, actualENetworkHttp.getSuppressed().length);
    assertEquals(1, actualStatusCode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ENetworkHttp#ENetworkHttp(int, String, Throwable)}
   *   <li>{@link ENetworkHttp#getStatusCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ENetworkHttp actualENetworkHttp = new ENetworkHttp(1, "https://example.org/example", cause);
    int actualStatusCode = actualENetworkHttp.getStatusCode();

    // Assert
    assertEquals("https://example.org/example", actualENetworkHttp.getMessage());
    assertEquals(0, actualENetworkHttp.getSuppressed().length);
    assertEquals(1, actualStatusCode);
    assertSame(cause, actualENetworkHttp.getCause());
  }
}

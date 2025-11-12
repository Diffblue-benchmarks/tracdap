package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ENetworkHttpDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ENetworkHttp#ENetworkHttp(int, String)}
   *   <li>{@link ENetworkHttp#getStatusCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'https://example.org/example'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ENetworkHttp.<init>(int, String)",
    "void ENetworkHttp.<init>(int, String, Throwable)",
    "int ENetworkHttp.getStatusCode()"
  })
  void testGettersAndSetters_whenHttpsExampleOrgExample_thenReturnCauseIsNull() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ENetworkHttp#ENetworkHttp(int, String, Throwable)}
   *   <li>{@link ENetworkHttp#getStatusCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ENetworkHttp.<init>(int, String)",
    "void ENetworkHttp.<init>(int, String, Throwable)",
    "int ENetworkHttp.getStatusCode()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
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

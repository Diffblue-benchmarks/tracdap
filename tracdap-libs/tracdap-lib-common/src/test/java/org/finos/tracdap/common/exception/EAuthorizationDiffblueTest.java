package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EAuthorizationDiffblueTest {
  /**
   * Test {@link EAuthorization#EAuthorization(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EAuthorization#EAuthorization(String)}
   */
  @Test
  @DisplayName(
      "Test new EAuthorization(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EAuthorization.<init>(String)",
    "void EAuthorization.<init>(String, Throwable)"
  })
  void testNewEAuthorization_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EAuthorization actualEAuthorization = new EAuthorization("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEAuthorization.getMessage());
    assertNull(actualEAuthorization.getCause());
    assertNull(actualEAuthorization.getDetails());
    assertEquals(0, actualEAuthorization.getSuppressed().length);
  }

  /**
   * Test {@link EAuthorization#EAuthorization(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EAuthorization#EAuthorization(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EAuthorization(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EAuthorization.<init>(String)",
    "void EAuthorization.<init>(String, Throwable)"
  })
  void testNewEAuthorization_whenThrowable_thenReturnCauseIsThrowable() {
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

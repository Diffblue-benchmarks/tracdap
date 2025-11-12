package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheCorruptionDiffblueTest {
  /**
   * Test {@link ECacheCorruption#ECacheCorruption(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECacheCorruption#ECacheCorruption(String)}
   */
  @Test
  @DisplayName(
      "Test new ECacheCorruption(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ECacheCorruption.<init>(String)",
    "void ECacheCorruption.<init>(String, Throwable)"
  })
  void testNewECacheCorruption_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECacheCorruption actualECacheCorruption = new ECacheCorruption("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheCorruption.getMessage());
    assertNull(actualECacheCorruption.getCause());
    assertEquals(0, actualECacheCorruption.getSuppressed().length);
  }

  /**
   * Test {@link ECacheCorruption#ECacheCorruption(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ECacheCorruption#ECacheCorruption(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ECacheCorruption(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ECacheCorruption.<init>(String)",
    "void ECacheCorruption.<init>(String, Throwable)"
  })
  void testNewECacheCorruption_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheCorruption actualECacheCorruption =
        new ECacheCorruption("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheCorruption.getMessage());
    assertEquals(0, actualECacheCorruption.getSuppressed().length);
    assertSame(cause, actualECacheCorruption.getCause());
  }
}

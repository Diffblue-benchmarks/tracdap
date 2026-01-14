package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EDataCorruptionDiffblueTest {
  /**
   * Test {@link EDataCorruption#EDataCorruption(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EDataCorruption#EDataCorruption(String)}
   */
  @Test
  @DisplayName(
      "Test new EDataCorruption(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EDataCorruption.<init>(String)",
    "void EDataCorruption.<init>(String, Throwable)"
  })
  void testNewEDataCorruption_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EDataCorruption actualEDataCorruption = new EDataCorruption("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataCorruption.getMessage());
    assertNull(actualEDataCorruption.getCause());
    assertNull(actualEDataCorruption.getDetails());
    assertEquals(0, actualEDataCorruption.getSuppressed().length);
  }

  /**
   * Test {@link EDataCorruption#EDataCorruption(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EDataCorruption#EDataCorruption(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EDataCorruption(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EDataCorruption.<init>(String)",
    "void EDataCorruption.<init>(String, Throwable)"
  })
  void testNewEDataCorruption_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataCorruption actualEDataCorruption =
        new EDataCorruption("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataCorruption.getMessage());
    assertNull(actualEDataCorruption.getDetails());
    assertEquals(0, actualEDataCorruption.getSuppressed().length);
    assertSame(cause, actualEDataCorruption.getCause());
  }
}

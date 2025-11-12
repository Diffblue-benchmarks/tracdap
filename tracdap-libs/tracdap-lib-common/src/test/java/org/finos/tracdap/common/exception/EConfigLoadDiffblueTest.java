package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EConfigLoadDiffblueTest {
  /**
   * Test {@link EConfigLoad#EConfigLoad(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EConfigLoad#EConfigLoad(String)}
   */
  @Test
  @DisplayName(
      "Test new EConfigLoad(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EConfigLoad.<init>(String)",
    "void EConfigLoad.<init>(String, Throwable)"
  })
  void testNewEConfigLoad_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EConfigLoad actualEConfigLoad = new EConfigLoad("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigLoad.getMessage());
    assertNull(actualEConfigLoad.getCause());
    assertNull(actualEConfigLoad.getDetails());
    assertEquals(0, actualEConfigLoad.getSuppressed().length);
  }

  /**
   * Test {@link EConfigLoad#EConfigLoad(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EConfigLoad#EConfigLoad(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EConfigLoad(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EConfigLoad.<init>(String)",
    "void EConfigLoad.<init>(String, Throwable)"
  })
  void testNewEConfigLoad_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfigLoad actualEConfigLoad = new EConfigLoad("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigLoad.getMessage());
    assertNull(actualEConfigLoad.getDetails());
    assertEquals(0, actualEConfigLoad.getSuppressed().length);
    assertSame(cause, actualEConfigLoad.getCause());
  }
}

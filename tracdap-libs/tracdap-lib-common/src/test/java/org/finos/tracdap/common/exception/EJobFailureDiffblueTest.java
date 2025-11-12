package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EJobFailureDiffblueTest {
  /**
   * Test {@link EJobFailure#EJobFailure(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EJobFailure#EJobFailure(String)}
   */
  @Test
  @DisplayName(
      "Test new EJobFailure(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EJobFailure.<init>(String)",
    "void EJobFailure.<init>(String, Throwable)"
  })
  void testNewEJobFailure_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EJobFailure actualEJobFailure = new EJobFailure("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEJobFailure.getMessage());
    assertNull(actualEJobFailure.getCause());
    assertNull(actualEJobFailure.getDetails());
    assertEquals(0, actualEJobFailure.getSuppressed().length);
  }

  /**
   * Test {@link EJobFailure#EJobFailure(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EJobFailure#EJobFailure(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EJobFailure(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EJobFailure.<init>(String)",
    "void EJobFailure.<init>(String, Throwable)"
  })
  void testNewEJobFailure_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EJobFailure actualEJobFailure = new EJobFailure("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEJobFailure.getMessage());
    assertNull(actualEJobFailure.getDetails());
    assertEquals(0, actualEJobFailure.getSuppressed().length);
    assertSame(cause, actualEJobFailure.getCause());
  }
}

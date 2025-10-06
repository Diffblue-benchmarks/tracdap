package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorUnavailableDiffblueTest {
  /**
   * Test {@link EExecutorUnavailable#EExecutorUnavailable(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorUnavailable#EExecutorUnavailable(String)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorUnavailable(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorUnavailable.<init>(String)",
    "void EExecutorUnavailable.<init>(String, Throwable)"
  })
  void testNewEExecutorUnavailable_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutorUnavailable actualEExecutorUnavailable =
        new EExecutorUnavailable("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorUnavailable.getMessage());
    assertNull(actualEExecutorUnavailable.getCause());
    assertEquals(0, actualEExecutorUnavailable.getSuppressed().length);
  }

  /**
   * Test {@link EExecutorUnavailable#EExecutorUnavailable(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorUnavailable#EExecutorUnavailable(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorUnavailable(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorUnavailable.<init>(String)",
    "void EExecutorUnavailable.<init>(String, Throwable)"
  })
  void testNewEExecutorUnavailable_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorUnavailable actualEExecutorUnavailable =
        new EExecutorUnavailable("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorUnavailable.getMessage());
    assertEquals(0, actualEExecutorUnavailable.getSuppressed().length);
    assertSame(cause, actualEExecutorUnavailable.getCause());
  }
}

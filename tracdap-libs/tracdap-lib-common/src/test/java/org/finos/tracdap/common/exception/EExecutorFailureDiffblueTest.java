package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorFailureDiffblueTest {
  /**
   * Test {@link EExecutorFailure#EExecutorFailure(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorFailure#EExecutorFailure(String)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorFailure(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorFailure.<init>(String)",
    "void EExecutorFailure.<init>(String, Throwable)"
  })
  void testNewEExecutorFailure_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutorFailure actualEExecutorFailure = new EExecutorFailure("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorFailure.getMessage());
    assertNull(actualEExecutorFailure.getCause());
    assertEquals(0, actualEExecutorFailure.getSuppressed().length);
  }

  /**
   * Test {@link EExecutorFailure#EExecutorFailure(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorFailure#EExecutorFailure(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorFailure(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorFailure.<init>(String)",
    "void EExecutorFailure.<init>(String, Throwable)"
  })
  void testNewEExecutorFailure_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorFailure actualEExecutorFailure =
        new EExecutorFailure("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorFailure.getMessage());
    assertEquals(0, actualEExecutorFailure.getSuppressed().length);
    assertSame(cause, actualEExecutorFailure.getCause());
  }
}

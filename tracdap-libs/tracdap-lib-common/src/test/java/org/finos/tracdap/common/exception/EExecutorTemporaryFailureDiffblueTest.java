package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorTemporaryFailureDiffblueTest {
  /**
   * Test {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String)}
   */
  @Test
  @DisplayName("Test new EExecutorTemporaryFailure(String); then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorTemporaryFailure.<init>(String)",
    "void EExecutorTemporaryFailure.<init>(String, Throwable)"
  })
  void testNewEExecutorTemporaryFailure_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutorTemporaryFailure actualEExecutorTemporaryFailure =
        new EExecutorTemporaryFailure("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorTemporaryFailure.getMessage());
    assertNull(actualEExecutorTemporaryFailure.getCause());
    assertEquals(0, actualEExecutorTemporaryFailure.getSuppressed().length);
  }

  /**
   * Test {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorTemporaryFailure#EExecutorTemporaryFailure(String,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorTemporaryFailure(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorTemporaryFailure.<init>(String)",
    "void EExecutorTemporaryFailure.<init>(String, Throwable)"
  })
  void testNewEExecutorTemporaryFailure_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorTemporaryFailure actualEExecutorTemporaryFailure =
        new EExecutorTemporaryFailure("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorTemporaryFailure.getMessage());
    assertEquals(0, actualEExecutorTemporaryFailure.getSuppressed().length);
    assertSame(cause, actualEExecutorTemporaryFailure.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorDiffblueTest {
  /**
   * Test {@link EExecutor#EExecutor(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutor#EExecutor(String)}
   */
  @Test
  @DisplayName(
      "Test new EExecutor(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EExecutor.<init>(String)", "void EExecutor.<init>(String, Throwable)"})
  void testNewEExecutor_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutor actualEExecutor = new EExecutor("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutor.getMessage());
    assertNull(actualEExecutor.getCause());
    assertEquals(0, actualEExecutor.getSuppressed().length);
  }

  /**
   * Test {@link EExecutor#EExecutor(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutor#EExecutor(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutor(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EExecutor.<init>(String)", "void EExecutor.<init>(String, Throwable)"})
  void testNewEExecutor_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutor actualEExecutor = new EExecutor("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutor.getMessage());
    assertEquals(0, actualEExecutor.getSuppressed().length);
    assertSame(cause, actualEExecutor.getCause());
  }
}

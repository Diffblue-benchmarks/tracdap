package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorAccessDiffblueTest {
  /**
   * Test {@link EExecutorAccess#EExecutorAccess(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorAccess#EExecutorAccess(String)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorAccess(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorAccess.<init>(String)",
    "void EExecutorAccess.<init>(String, Throwable)"
  })
  void testNewEExecutorAccess_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutorAccess actualEExecutorAccess = new EExecutorAccess("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorAccess.getMessage());
    assertNull(actualEExecutorAccess.getCause());
    assertEquals(0, actualEExecutorAccess.getSuppressed().length);
  }

  /**
   * Test {@link EExecutorAccess#EExecutorAccess(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorAccess#EExecutorAccess(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorAccess(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorAccess.<init>(String)",
    "void EExecutorAccess.<init>(String, Throwable)"
  })
  void testNewEExecutorAccess_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorAccess actualEExecutorAccess =
        new EExecutorAccess("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorAccess.getMessage());
    assertEquals(0, actualEExecutorAccess.getSuppressed().length);
    assertSame(cause, actualEExecutorAccess.getCause());
  }
}

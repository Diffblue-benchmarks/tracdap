package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EExecutorValidationDiffblueTest {
  /**
   * Test {@link EExecutorValidation#EExecutorValidation(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorValidation#EExecutorValidation(String)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorValidation(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorValidation.<init>(String)",
    "void EExecutorValidation.<init>(String, Throwable)"
  })
  void testNewEExecutorValidation_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EExecutorValidation actualEExecutorValidation =
        new EExecutorValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorValidation.getMessage());
    assertNull(actualEExecutorValidation.getCause());
    assertEquals(0, actualEExecutorValidation.getSuppressed().length);
  }

  /**
   * Test {@link EExecutorValidation#EExecutorValidation(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EExecutorValidation#EExecutorValidation(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EExecutorValidation(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EExecutorValidation.<init>(String)",
    "void EExecutorValidation.<init>(String, Throwable)"
  })
  void testNewEExecutorValidation_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EExecutorValidation actualEExecutorValidation =
        new EExecutorValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEExecutorValidation.getMessage());
    assertEquals(0, actualEExecutorValidation.getSuppressed().length);
    assertSame(cause, actualEExecutorValidation.getCause());
  }
}

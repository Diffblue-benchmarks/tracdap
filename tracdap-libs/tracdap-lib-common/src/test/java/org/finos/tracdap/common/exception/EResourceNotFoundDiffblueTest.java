package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EResourceNotFoundDiffblueTest {
  /**
   * Test {@link EResourceNotFound#EResourceNotFound(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EResourceNotFound#EResourceNotFound(String)}
   */
  @Test
  @DisplayName(
      "Test new EResourceNotFound(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EResourceNotFound.<init>(String)",
    "void EResourceNotFound.<init>(String, Throwable)"
  })
  void testNewEResourceNotFound_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EResourceNotFound actualEResourceNotFound =
        new EResourceNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEResourceNotFound.getMessage());
    assertNull(actualEResourceNotFound.getCause());
    assertNull(actualEResourceNotFound.getDetails());
    assertEquals(0, actualEResourceNotFound.getSuppressed().length);
  }

  /**
   * Test {@link EResourceNotFound#EResourceNotFound(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EResourceNotFound#EResourceNotFound(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EResourceNotFound(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EResourceNotFound.<init>(String)",
    "void EResourceNotFound.<init>(String, Throwable)"
  })
  void testNewEResourceNotFound_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EResourceNotFound actualEResourceNotFound =
        new EResourceNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEResourceNotFound.getMessage());
    assertNull(actualEResourceNotFound.getDetails());
    assertEquals(0, actualEResourceNotFound.getSuppressed().length);
    assertSame(cause, actualEResourceNotFound.getCause());
  }
}

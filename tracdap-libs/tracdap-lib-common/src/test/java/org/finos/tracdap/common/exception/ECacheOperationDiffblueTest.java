package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheOperationDiffblueTest {
  /**
   * Test {@link ECacheOperation#ECacheOperation(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ECacheOperation#ECacheOperation(String)}
   */
  @Test
  @DisplayName(
      "Test new ECacheOperation(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ECacheOperation.<init>(String)",
    "void ECacheOperation.<init>(String, Throwable)"
  })
  void testNewECacheOperation_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECacheOperation actualECacheOperation = new ECacheOperation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheOperation.getMessage());
    assertNull(actualECacheOperation.getCause());
    assertEquals(0, actualECacheOperation.getSuppressed().length);
  }

  /**
   * Test {@link ECacheOperation#ECacheOperation(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ECacheOperation#ECacheOperation(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ECacheOperation(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ECacheOperation.<init>(String)",
    "void ECacheOperation.<init>(String, Throwable)"
  })
  void testNewECacheOperation_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheOperation actualECacheOperation =
        new ECacheOperation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheOperation.getMessage());
    assertEquals(0, actualECacheOperation.getSuppressed().length);
    assertSame(cause, actualECacheOperation.getCause());
  }
}

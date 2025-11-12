package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EPluginNotAvailableDiffblueTest {
  /**
   * Test {@link EPluginNotAvailable#EPluginNotAvailable(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EPluginNotAvailable#EPluginNotAvailable(String)}
   */
  @Test
  @DisplayName(
      "Test new EPluginNotAvailable(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EPluginNotAvailable.<init>(String)",
    "void EPluginNotAvailable.<init>(String, Throwable)"
  })
  void testNewEPluginNotAvailable_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EPluginNotAvailable actualEPluginNotAvailable =
        new EPluginNotAvailable("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEPluginNotAvailable.getMessage());
    assertNull(actualEPluginNotAvailable.getCause());
    assertNull(actualEPluginNotAvailable.getDetails());
    assertEquals(0, actualEPluginNotAvailable.getSuppressed().length);
  }

  /**
   * Test {@link EPluginNotAvailable#EPluginNotAvailable(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EPluginNotAvailable#EPluginNotAvailable(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EPluginNotAvailable(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EPluginNotAvailable.<init>(String)",
    "void EPluginNotAvailable.<init>(String, Throwable)"
  })
  void testNewEPluginNotAvailable_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EPluginNotAvailable actualEPluginNotAvailable =
        new EPluginNotAvailable("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEPluginNotAvailable.getMessage());
    assertNull(actualEPluginNotAvailable.getDetails());
    assertEquals(0, actualEPluginNotAvailable.getSuppressed().length);
    assertSame(cause, actualEPluginNotAvailable.getCause());
  }
}

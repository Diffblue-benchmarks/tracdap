package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EDataSizeDiffblueTest {
  /**
   * Test {@link EDataSize#EDataSize(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EDataSize#EDataSize(String)}
   */
  @Test
  @DisplayName(
      "Test new EDataSize(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EDataSize.<init>(String)", "void EDataSize.<init>(String, Throwable)"})
  void testNewEDataSize_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EDataSize actualEDataSize = new EDataSize("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataSize.getMessage());
    assertNull(actualEDataSize.getCause());
    assertNull(actualEDataSize.getDetails());
    assertEquals(0, actualEDataSize.getSuppressed().length);
  }

  /**
   * Test {@link EDataSize#EDataSize(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EDataSize#EDataSize(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EDataSize(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EDataSize.<init>(String)", "void EDataSize.<init>(String, Throwable)"})
  void testNewEDataSize_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataSize actualEDataSize = new EDataSize("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataSize.getMessage());
    assertNull(actualEDataSize.getDetails());
    assertEquals(0, actualEDataSize.getSuppressed().length);
    assertSame(cause, actualEDataSize.getCause());
  }
}

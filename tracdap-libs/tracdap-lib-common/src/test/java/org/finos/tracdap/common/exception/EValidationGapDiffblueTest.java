package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EValidationGapDiffblueTest {
  /**
   * Test {@link EValidationGap#EValidationGap(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EValidationGap#EValidationGap(String)}
   */
  @Test
  @DisplayName("Test new EValidationGap(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EValidationGap.<init>(String)", "void EValidationGap.<init>(String, Throwable)"})
  void testNewEValidationGap_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EValidationGap actualEValidationGap = new EValidationGap("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEValidationGap.getMessage());
    assertNull(actualEValidationGap.getCause());
    assertEquals(0, actualEValidationGap.getSuppressed().length);
  }

  /**
   * Test {@link EValidationGap#EValidationGap(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EValidationGap#EValidationGap(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EValidationGap(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EValidationGap.<init>(String)", "void EValidationGap.<init>(String, Throwable)"})
  void testNewEValidationGap_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EValidationGap actualEValidationGap = new EValidationGap("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEValidationGap.getMessage());
    assertEquals(0, actualEValidationGap.getSuppressed().length);
    assertSame(cause, actualEValidationGap.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EConfigParseDiffblueTest {
  /**
   * Test {@link EConfigParse#EConfigParse(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EConfigParse#EConfigParse(String)}
   */
  @Test
  @DisplayName("Test new EConfigParse(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EConfigParse.<init>(String)", "void EConfigParse.<init>(String, Throwable)"})
  void testNewEConfigParse_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EConfigParse actualEConfigParse = new EConfigParse("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigParse.getMessage());
    assertNull(actualEConfigParse.getCause());
    assertNull(actualEConfigParse.getDetails());
    assertEquals(0, actualEConfigParse.getSuppressed().length);
  }

  /**
   * Test {@link EConfigParse#EConfigParse(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EConfigParse#EConfigParse(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EConfigParse(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EConfigParse.<init>(String)", "void EConfigParse.<init>(String, Throwable)"})
  void testNewEConfigParse_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfigParse actualEConfigParse = new EConfigParse("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigParse.getMessage());
    assertNull(actualEConfigParse.getDetails());
    assertEquals(0, actualEConfigParse.getSuppressed().length);
    assertSame(cause, actualEConfigParse.getCause());
  }
}

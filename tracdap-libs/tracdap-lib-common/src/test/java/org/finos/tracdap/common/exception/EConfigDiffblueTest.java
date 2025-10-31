package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EConfigDiffblueTest {
  /**
   * Test {@link EConfig#EConfig(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EConfig#EConfig(String)}
   */
  @Test
  @DisplayName("Test new EConfig(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EConfig.<init>(String)", "void EConfig.<init>(String, Throwable)"})
  void testNewEConfig_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EConfig actualEConfig = new EConfig("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfig.getMessage());
    assertNull(actualEConfig.getCause());
    assertNull(actualEConfig.getDetails());
    assertEquals(0, actualEConfig.getSuppressed().length);
  }

  /**
   * Test {@link EConfig#EConfig(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EConfig#EConfig(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EConfig(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EConfig.<init>(String)", "void EConfig.<init>(String, Throwable)"})
  void testNewEConfig_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfig actualEConfig = new EConfig("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfig.getMessage());
    assertNull(actualEConfig.getDetails());
    assertEquals(0, actualEConfig.getSuppressed().length);
    assertSame(cause, actualEConfig.getCause());
  }
}

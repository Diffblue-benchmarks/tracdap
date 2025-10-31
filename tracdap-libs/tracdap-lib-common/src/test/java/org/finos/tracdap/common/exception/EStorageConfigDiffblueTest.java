package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageConfigDiffblueTest {
  /**
   * Test {@link EStorageConfig#EStorageConfig(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageConfig#EStorageConfig(String)}
   */
  @Test
  @DisplayName("Test new EStorageConfig(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageConfig.<init>(String)", "void EStorageConfig.<init>(String, Throwable)"})
  void testNewEStorageConfig_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorageConfig actualEStorageConfig = new EStorageConfig("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageConfig.getMessage());
    assertNull(actualEStorageConfig.getCause());
    assertEquals(0, actualEStorageConfig.getSuppressed().length);
  }

  /**
   * Test {@link EStorageConfig#EStorageConfig(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageConfig#EStorageConfig(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EStorageConfig(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageConfig.<init>(String)", "void EStorageConfig.<init>(String, Throwable)"})
  void testNewEStorageConfig_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageConfig actualEStorageConfig = new EStorageConfig("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageConfig.getMessage());
    assertEquals(0, actualEStorageConfig.getSuppressed().length);
    assertSame(cause, actualEStorageConfig.getCause());
  }
}

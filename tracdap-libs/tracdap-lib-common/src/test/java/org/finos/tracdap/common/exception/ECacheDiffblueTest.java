package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheDiffblueTest {
  /**
   * Test {@link ECache#ECache(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECache#ECache(String)}
   */
  @Test
  @DisplayName("Test new ECache(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECache.<init>(String)", "void ECache.<init>(String, Throwable)"})
  void testNewECache_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECache actualECache = new ECache("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECache.getMessage());
    assertNull(actualECache.getCause());
    assertEquals(0, actualECache.getSuppressed().length);
  }

  /**
   * Test {@link ECache#ECache(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECache#ECache(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ECache(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECache.<init>(String)", "void ECache.<init>(String, Throwable)"})
  void testNewECache_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECache actualECache = new ECache("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECache.getMessage());
    assertEquals(0, actualECache.getSuppressed().length);
    assertSame(cause, actualECache.getCause());
  }
}

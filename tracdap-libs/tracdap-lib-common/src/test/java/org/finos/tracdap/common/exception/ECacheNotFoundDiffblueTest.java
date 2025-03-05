package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheNotFoundDiffblueTest {
  /**
   * Test {@link ECacheNotFound#ECacheNotFound(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheNotFound#ECacheNotFound(String)}
   */
  @Test
  @DisplayName("Test new ECacheNotFound(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheNotFound.<init>(String)", "void ECacheNotFound.<init>(String, Throwable)"})
  void testNewECacheNotFound_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECacheNotFound actualECacheNotFound = new ECacheNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheNotFound.getMessage());
    assertNull(actualECacheNotFound.getCause());
    assertEquals(0, actualECacheNotFound.getSuppressed().length);
  }

  /**
   * Test {@link ECacheNotFound#ECacheNotFound(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheNotFound#ECacheNotFound(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ECacheNotFound(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheNotFound.<init>(String)", "void ECacheNotFound.<init>(String, Throwable)"})
  void testNewECacheNotFound_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheNotFound actualECacheNotFound = new ECacheNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheNotFound.getMessage());
    assertEquals(0, actualECacheNotFound.getSuppressed().length);
    assertSame(cause, actualECacheNotFound.getCause());
  }
}

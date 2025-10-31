package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheDuplicateDiffblueTest {
  /**
   * Test {@link ECacheDuplicate#ECacheDuplicate(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheDuplicate#ECacheDuplicate(String)}
   */
  @Test
  @DisplayName("Test new ECacheDuplicate(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheDuplicate.<init>(String)", "void ECacheDuplicate.<init>(String, Throwable)"})
  void testNewECacheDuplicate_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECacheDuplicate actualECacheDuplicate = new ECacheDuplicate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheDuplicate.getMessage());
    assertNull(actualECacheDuplicate.getCause());
    assertEquals(0, actualECacheDuplicate.getSuppressed().length);
  }

  /**
   * Test {@link ECacheDuplicate#ECacheDuplicate(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheDuplicate#ECacheDuplicate(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ECacheDuplicate(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheDuplicate.<init>(String)", "void ECacheDuplicate.<init>(String, Throwable)"})
  void testNewECacheDuplicate_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheDuplicate actualECacheDuplicate = new ECacheDuplicate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheDuplicate.getMessage());
    assertEquals(0, actualECacheDuplicate.getSuppressed().length);
    assertSame(cause, actualECacheDuplicate.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ETracInternalDiffblueTest {
  /**
   * Test {@link ETracInternal#ETracInternal(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ETracInternal#ETracInternal(String)}
   */
  @Test
  @DisplayName("Test new ETracInternal(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ETracInternal.<init>(String)", "void ETracInternal.<init>(String, Throwable)"})
  void testNewETracInternal_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ETracInternal actualETracInternal = new ETracInternal("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualETracInternal.getMessage());
    assertNull(actualETracInternal.getCause());
    assertEquals(0, actualETracInternal.getSuppressed().length);
  }

  /**
   * Test {@link ETracInternal#ETracInternal(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ETracInternal#ETracInternal(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ETracInternal(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ETracInternal.<init>(String)", "void ETracInternal.<init>(String, Throwable)"})
  void testNewETracInternal_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ETracInternal actualETracInternal = new ETracInternal("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualETracInternal.getMessage());
    assertEquals(0, actualETracInternal.getSuppressed().length);
    assertSame(cause, actualETracInternal.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EUnexpectedDiffblueTest {
  /**
   * Test {@link EUnexpected#EUnexpected()}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EUnexpected#EUnexpected()}
   */
  @Test
  @DisplayName("Test new EUnexpected(); then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EUnexpected.<init>()", "void EUnexpected.<init>(Throwable)"})
  void testNewEUnexpected_thenReturnCauseIsNull() {
    // Arrange and Act
    EUnexpected actualEUnexpected = new EUnexpected();

    // Assert
    assertEquals("Unexpected internal error (this is a bug)", actualEUnexpected.getMessage());
    assertNull(actualEUnexpected.getCause());
    assertEquals(0, actualEUnexpected.getSuppressed().length);
  }

  /**
   * Test {@link EUnexpected#EUnexpected(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EUnexpected#EUnexpected(Throwable)}
   */
  @Test
  @DisplayName("Test new EUnexpected(Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EUnexpected.<init>()", "void EUnexpected.<init>(Throwable)"})
  void testNewEUnexpected_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EUnexpected actualEUnexpected = new EUnexpected(cause);

    // Assert
    assertEquals("Unexpected internal error (this is a bug)", actualEUnexpected.getMessage());
    assertEquals(0, actualEUnexpected.getSuppressed().length);
    assertSame(cause, actualEUnexpected.getCause());
  }
}

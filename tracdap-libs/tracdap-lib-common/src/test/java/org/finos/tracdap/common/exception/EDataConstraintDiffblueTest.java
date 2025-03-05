package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EDataConstraintDiffblueTest {
  /**
   * Test {@link EDataConstraint#EDataConstraint(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EDataConstraint#EDataConstraint(String)}
   */
  @Test
  @DisplayName("Test new EDataConstraint(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EDataConstraint.<init>(String)", "void EDataConstraint.<init>(String, Throwable)"})
  void testNewEDataConstraint_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EDataConstraint actualEDataConstraint = new EDataConstraint("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataConstraint.getMessage());
    assertNull(actualEDataConstraint.getCause());
    assertNull(actualEDataConstraint.getDetails());
    assertEquals(0, actualEDataConstraint.getSuppressed().length);
  }

  /**
   * Test {@link EDataConstraint#EDataConstraint(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EDataConstraint#EDataConstraint(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EDataConstraint(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EDataConstraint.<init>(String)", "void EDataConstraint.<init>(String, Throwable)"})
  void testNewEDataConstraint_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataConstraint actualEDataConstraint = new EDataConstraint("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataConstraint.getMessage());
    assertNull(actualEDataConstraint.getDetails());
    assertEquals(0, actualEDataConstraint.getSuppressed().length);
    assertSame(cause, actualEDataConstraint.getCause());
  }
}

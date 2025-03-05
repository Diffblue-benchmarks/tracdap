package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EDataDiffblueTest {
  /**
   * Test {@link EData#EData(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EData#EData(String)}
   */
  @Test
  @DisplayName("Test new EData(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EData.<init>(String)", "void EData.<init>(String, Throwable)"})
  void testNewEData_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EData actualEData = new EData("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEData.getMessage());
    assertNull(actualEData.getCause());
    assertNull(actualEData.getDetails());
    assertEquals(0, actualEData.getSuppressed().length);
  }

  /**
   * Test {@link EData#EData(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EData#EData(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EData(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EData.<init>(String)", "void EData.<init>(String, Throwable)"})
  void testNewEData_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EData actualEData = new EData("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEData.getMessage());
    assertNull(actualEData.getDetails());
    assertEquals(0, actualEData.getSuppressed().length);
    assertSame(cause, actualEData.getCause());
  }
}

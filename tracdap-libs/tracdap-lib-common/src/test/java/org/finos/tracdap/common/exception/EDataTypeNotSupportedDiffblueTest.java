package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EDataTypeNotSupportedDiffblueTest {
  /**
   * Test {@link EDataTypeNotSupported#EDataTypeNotSupported(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EDataTypeNotSupported#EDataTypeNotSupported(String)}
   */
  @Test
  @DisplayName("Test new EDataTypeNotSupported(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EDataTypeNotSupported.<init>(String)",
      "void EDataTypeNotSupported.<init>(String, Throwable)"})
  void testNewEDataTypeNotSupported_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EDataTypeNotSupported actualEDataTypeNotSupported = new EDataTypeNotSupported("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataTypeNotSupported.getMessage());
    assertNull(actualEDataTypeNotSupported.getCause());
    assertNull(actualEDataTypeNotSupported.getDetails());
    assertEquals(0, actualEDataTypeNotSupported.getSuppressed().length);
  }

  /**
   * Test {@link EDataTypeNotSupported#EDataTypeNotSupported(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EDataTypeNotSupported#EDataTypeNotSupported(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EDataTypeNotSupported(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EDataTypeNotSupported.<init>(String)",
      "void EDataTypeNotSupported.<init>(String, Throwable)"})
  void testNewEDataTypeNotSupported_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataTypeNotSupported actualEDataTypeNotSupported = new EDataTypeNotSupported("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataTypeNotSupported.getMessage());
    assertNull(actualEDataTypeNotSupported.getDetails());
    assertEquals(0, actualEDataTypeNotSupported.getSuppressed().length);
    assertSame(cause, actualEDataTypeNotSupported.getCause());
  }
}

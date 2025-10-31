package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageValidationDiffblueTest {
  /**
   * Test {@link EStorageValidation#EStorageValidation(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageValidation#EStorageValidation(String)}
   */
  @Test
  @DisplayName("Test new EStorageValidation(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageValidation.<init>(String)", "void EStorageValidation.<init>(String, Throwable)"})
  void testNewEStorageValidation_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorageValidation actualEStorageValidation = new EStorageValidation("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageValidation.getMessage());
    assertNull(actualEStorageValidation.getCause());
    assertEquals(0, actualEStorageValidation.getSuppressed().length);
  }

  /**
   * Test {@link EStorageValidation#EStorageValidation(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageValidation#EStorageValidation(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EStorageValidation(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageValidation.<init>(String)", "void EStorageValidation.<init>(String, Throwable)"})
  void testNewEStorageValidation_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageValidation actualEStorageValidation = new EStorageValidation("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageValidation.getMessage());
    assertEquals(0, actualEStorageValidation.getSuppressed().length);
    assertSame(cause, actualEStorageValidation.getCause());
  }
}

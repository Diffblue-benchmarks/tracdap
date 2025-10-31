package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageAccessDiffblueTest {
  /**
   * Test {@link EStorageAccess#EStorageAccess(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageAccess#EStorageAccess(String)}
   */
  @Test
  @DisplayName("Test new EStorageAccess(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageAccess.<init>(String)", "void EStorageAccess.<init>(String, Throwable)"})
  void testNewEStorageAccess_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorageAccess actualEStorageAccess = new EStorageAccess("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageAccess.getMessage());
    assertNull(actualEStorageAccess.getCause());
    assertEquals(0, actualEStorageAccess.getSuppressed().length);
  }

  /**
   * Test {@link EStorageAccess#EStorageAccess(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageAccess#EStorageAccess(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EStorageAccess(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageAccess.<init>(String)", "void EStorageAccess.<init>(String, Throwable)"})
  void testNewEStorageAccess_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageAccess actualEStorageAccess = new EStorageAccess("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageAccess.getMessage());
    assertEquals(0, actualEStorageAccess.getSuppressed().length);
    assertSame(cause, actualEStorageAccess.getCause());
  }
}

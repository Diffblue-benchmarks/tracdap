package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageDiffblueTest {
  /**
   * Test {@link EStorage#EStorage(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorage#EStorage(String)}
   */
  @Test
  @DisplayName("Test new EStorage(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorage.<init>(String)", "void EStorage.<init>(String, Throwable)"})
  void testNewEStorage_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorage actualEStorage = new EStorage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorage.getMessage());
    assertNull(actualEStorage.getCause());
    assertEquals(0, actualEStorage.getSuppressed().length);
  }

  /**
   * Test {@link EStorage#EStorage(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorage#EStorage(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EStorage(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorage.<init>(String)", "void EStorage.<init>(String, Throwable)"})
  void testNewEStorage_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorage actualEStorage = new EStorage("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorage.getMessage());
    assertEquals(0, actualEStorage.getSuppressed().length);
    assertSame(cause, actualEStorage.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataNotFoundDiffblueTest {
  /**
   * Test {@link EMetadataNotFound#EMetadataNotFound(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataNotFound#EMetadataNotFound(String)}
   */
  @Test
  @DisplayName("Test new EMetadataNotFound(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataNotFound.<init>(String)", "void EMetadataNotFound.<init>(String, Throwable)"})
  void testNewEMetadataNotFound_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadataNotFound actualEMetadataNotFound = new EMetadataNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataNotFound.getMessage());
    assertNull(actualEMetadataNotFound.getCause());
    assertNull(actualEMetadataNotFound.getDetails());
    assertEquals(0, actualEMetadataNotFound.getSuppressed().length);
  }

  /**
   * Test {@link EMetadataNotFound#EMetadataNotFound(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataNotFound#EMetadataNotFound(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EMetadataNotFound(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataNotFound.<init>(String)", "void EMetadataNotFound.<init>(String, Throwable)"})
  void testNewEMetadataNotFound_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataNotFound actualEMetadataNotFound = new EMetadataNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataNotFound.getMessage());
    assertNull(actualEMetadataNotFound.getDetails());
    assertEquals(0, actualEMetadataNotFound.getSuppressed().length);
    assertSame(cause, actualEMetadataNotFound.getCause());
  }
}

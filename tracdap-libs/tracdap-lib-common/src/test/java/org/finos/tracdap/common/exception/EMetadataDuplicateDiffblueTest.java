package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataDuplicateDiffblueTest {
  /**
   * Test {@link EMetadataDuplicate#EMetadataDuplicate(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataDuplicate#EMetadataDuplicate(String)}
   */
  @Test
  @DisplayName("Test new EMetadataDuplicate(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataDuplicate.<init>(String)", "void EMetadataDuplicate.<init>(String, Throwable)"})
  void testNewEMetadataDuplicate_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadataDuplicate actualEMetadataDuplicate = new EMetadataDuplicate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataDuplicate.getMessage());
    assertNull(actualEMetadataDuplicate.getCause());
    assertNull(actualEMetadataDuplicate.getDetails());
    assertEquals(0, actualEMetadataDuplicate.getSuppressed().length);
  }

  /**
   * Test {@link EMetadataDuplicate#EMetadataDuplicate(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataDuplicate#EMetadataDuplicate(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EMetadataDuplicate(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataDuplicate.<init>(String)", "void EMetadataDuplicate.<init>(String, Throwable)"})
  void testNewEMetadataDuplicate_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataDuplicate actualEMetadataDuplicate = new EMetadataDuplicate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataDuplicate.getMessage());
    assertNull(actualEMetadataDuplicate.getDetails());
    assertEquals(0, actualEMetadataDuplicate.getSuppressed().length);
    assertSame(cause, actualEMetadataDuplicate.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataCorruptDiffblueTest {
  /**
   * Test {@link EMetadataCorrupt#EMetadataCorrupt(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataCorrupt#EMetadataCorrupt(String)}
   */
  @Test
  @DisplayName("Test new EMetadataCorrupt(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataCorrupt.<init>(String)", "void EMetadataCorrupt.<init>(String, Throwable)"})
  void testNewEMetadataCorrupt_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadataCorrupt actualEMetadataCorrupt = new EMetadataCorrupt("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataCorrupt.getMessage());
    assertNull(actualEMetadataCorrupt.getCause());
    assertNull(actualEMetadataCorrupt.getDetails());
    assertEquals(0, actualEMetadataCorrupt.getSuppressed().length);
  }

  /**
   * Test {@link EMetadataCorrupt#EMetadataCorrupt(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataCorrupt#EMetadataCorrupt(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EMetadataCorrupt(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataCorrupt.<init>(String)", "void EMetadataCorrupt.<init>(String, Throwable)"})
  void testNewEMetadataCorrupt_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataCorrupt actualEMetadataCorrupt = new EMetadataCorrupt("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataCorrupt.getMessage());
    assertNull(actualEMetadataCorrupt.getDetails());
    assertEquals(0, actualEMetadataCorrupt.getSuppressed().length);
    assertSame(cause, actualEMetadataCorrupt.getCause());
  }
}

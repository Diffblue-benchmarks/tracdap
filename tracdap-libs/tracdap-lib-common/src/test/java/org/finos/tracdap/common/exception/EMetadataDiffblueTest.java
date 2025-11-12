package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataDiffblueTest {
  /**
   * Test {@link EMetadata#EMetadata(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EMetadata#EMetadata(String)}
   */
  @Test
  @DisplayName(
      "Test new EMetadata(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EMetadata.<init>(String)", "void EMetadata.<init>(String, Throwable)"})
  void testNewEMetadata_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadata actualEMetadata = new EMetadata("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadata.getMessage());
    assertNull(actualEMetadata.getCause());
    assertNull(actualEMetadata.getDetails());
    assertEquals(0, actualEMetadata.getSuppressed().length);
  }

  /**
   * Test {@link EMetadata#EMetadata(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EMetadata#EMetadata(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EMetadata(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EMetadata.<init>(String)", "void EMetadata.<init>(String, Throwable)"})
  void testNewEMetadata_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadata actualEMetadata = new EMetadata("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadata.getMessage());
    assertNull(actualEMetadata.getDetails());
    assertEquals(0, actualEMetadata.getSuppressed().length);
    assertSame(cause, actualEMetadata.getCause());
  }
}

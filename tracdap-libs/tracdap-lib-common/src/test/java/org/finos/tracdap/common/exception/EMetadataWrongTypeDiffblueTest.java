package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataWrongTypeDiffblueTest {
  /**
   * Test {@link EMetadataWrongType#EMetadataWrongType(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EMetadataWrongType#EMetadataWrongType(String)}
   */
  @Test
  @DisplayName(
      "Test new EMetadataWrongType(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EMetadataWrongType.<init>(String)",
    "void EMetadataWrongType.<init>(String, Throwable)"
  })
  void testNewEMetadataWrongType_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadataWrongType actualEMetadataWrongType =
        new EMetadataWrongType("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataWrongType.getMessage());
    assertNull(actualEMetadataWrongType.getCause());
    assertNull(actualEMetadataWrongType.getDetails());
    assertEquals(0, actualEMetadataWrongType.getSuppressed().length);
  }

  /**
   * Test {@link EMetadataWrongType#EMetadataWrongType(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EMetadataWrongType#EMetadataWrongType(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EMetadataWrongType(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EMetadataWrongType.<init>(String)",
    "void EMetadataWrongType.<init>(String, Throwable)"
  })
  void testNewEMetadataWrongType_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataWrongType actualEMetadataWrongType =
        new EMetadataWrongType("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataWrongType.getMessage());
    assertNull(actualEMetadataWrongType.getDetails());
    assertEquals(0, actualEMetadataWrongType.getSuppressed().length);
    assertSame(cause, actualEMetadataWrongType.getCause());
  }
}

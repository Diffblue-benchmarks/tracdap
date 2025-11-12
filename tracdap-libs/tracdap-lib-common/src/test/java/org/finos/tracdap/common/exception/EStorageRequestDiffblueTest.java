package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageRequestDiffblueTest {
  /**
   * Test {@link EStorageRequest#EStorageRequest(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EStorageRequest#EStorageRequest(String)}
   */
  @Test
  @DisplayName(
      "Test new EStorageRequest(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EStorageRequest.<init>(String)",
    "void EStorageRequest.<init>(String, Throwable)"
  })
  void testNewEStorageRequest_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorageRequest actualEStorageRequest = new EStorageRequest("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageRequest.getMessage());
    assertNull(actualEStorageRequest.getCause());
    assertEquals(0, actualEStorageRequest.getSuppressed().length);
  }

  /**
   * Test {@link EStorageRequest#EStorageRequest(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link EStorageRequest#EStorageRequest(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new EStorageRequest(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EStorageRequest.<init>(String)",
    "void EStorageRequest.<init>(String, Throwable)"
  })
  void testNewEStorageRequest_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageRequest actualEStorageRequest =
        new EStorageRequest("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageRequest.getMessage());
    assertEquals(0, actualEStorageRequest.getSuppressed().length);
    assertSame(cause, actualEStorageRequest.getCause());
  }
}

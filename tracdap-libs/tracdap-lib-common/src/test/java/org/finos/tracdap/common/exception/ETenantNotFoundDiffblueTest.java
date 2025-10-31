package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ETenantNotFoundDiffblueTest {
  /**
   * Test {@link ETenantNotFound#ETenantNotFound(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ETenantNotFound#ETenantNotFound(String)}
   */
  @Test
  @DisplayName("Test new ETenantNotFound(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ETenantNotFound.<init>(String)", "void ETenantNotFound.<init>(String, Throwable)"})
  void testNewETenantNotFound_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ETenantNotFound actualETenantNotFound = new ETenantNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualETenantNotFound.getMessage());
    assertNull(actualETenantNotFound.getCause());
    assertNull(actualETenantNotFound.getDetails());
    assertEquals(0, actualETenantNotFound.getSuppressed().length);
  }

  /**
   * Test {@link ETenantNotFound#ETenantNotFound(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ETenantNotFound#ETenantNotFound(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ETenantNotFound(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ETenantNotFound.<init>(String)", "void ETenantNotFound.<init>(String, Throwable)"})
  void testNewETenantNotFound_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ETenantNotFound actualETenantNotFound = new ETenantNotFound("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualETenantNotFound.getMessage());
    assertNull(actualETenantNotFound.getDetails());
    assertEquals(0, actualETenantNotFound.getSuppressed().length);
    assertSame(cause, actualETenantNotFound.getCause());
  }
}

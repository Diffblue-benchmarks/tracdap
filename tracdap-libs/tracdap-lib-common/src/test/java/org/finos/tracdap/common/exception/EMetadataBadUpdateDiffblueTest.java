package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EMetadataBadUpdateDiffblueTest {
  /**
   * Test {@link EMetadataBadUpdate#EMetadataBadUpdate(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataBadUpdate#EMetadataBadUpdate(String)}
   */
  @Test
  @DisplayName("Test new EMetadataBadUpdate(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataBadUpdate.<init>(String)", "void EMetadataBadUpdate.<init>(String, Throwable)"})
  void testNewEMetadataBadUpdate_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EMetadataBadUpdate actualEMetadataBadUpdate = new EMetadataBadUpdate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataBadUpdate.getMessage());
    assertNull(actualEMetadataBadUpdate.getCause());
    assertNull(actualEMetadataBadUpdate.getDetails());
    assertEquals(0, actualEMetadataBadUpdate.getSuppressed().length);
  }

  /**
   * Test {@link EMetadataBadUpdate#EMetadataBadUpdate(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EMetadataBadUpdate#EMetadataBadUpdate(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EMetadataBadUpdate(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EMetadataBadUpdate.<init>(String)", "void EMetadataBadUpdate.<init>(String, Throwable)"})
  void testNewEMetadataBadUpdate_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EMetadataBadUpdate actualEMetadataBadUpdate = new EMetadataBadUpdate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEMetadataBadUpdate.getMessage());
    assertNull(actualEMetadataBadUpdate.getDetails());
    assertEquals(0, actualEMetadataBadUpdate.getSuppressed().length);
    assertSame(cause, actualEMetadataBadUpdate.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStorageCommunicationDiffblueTest {
  /**
   * Test {@link EStorageCommunication#EStorageCommunication(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageCommunication#EStorageCommunication(String)}
   */
  @Test
  @DisplayName("Test new EStorageCommunication(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageCommunication.<init>(String)",
      "void EStorageCommunication.<init>(String, Throwable)"})
  void testNewEStorageCommunication_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    EStorageCommunication actualEStorageCommunication = new EStorageCommunication("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageCommunication.getMessage());
    assertNull(actualEStorageCommunication.getCause());
    assertEquals(0, actualEStorageCommunication.getSuppressed().length);
  }

  /**
   * Test {@link EStorageCommunication#EStorageCommunication(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EStorageCommunication#EStorageCommunication(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EStorageCommunication(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStorageCommunication.<init>(String)",
      "void EStorageCommunication.<init>(String, Throwable)"})
  void testNewEStorageCommunication_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorageCommunication actualEStorageCommunication = new EStorageCommunication("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorageCommunication.getMessage());
    assertEquals(0, actualEStorageCommunication.getSuppressed().length);
    assertSame(cause, actualEStorageCommunication.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ENetworkDiffblueTest {
  /**
   * Test {@link ENetwork#ENetwork(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ENetwork#ENetwork(String)}
   */
  @Test
  @DisplayName("Test new ENetwork(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ENetwork.<init>(String)", "void ENetwork.<init>(String, Throwable)"})
  void testNewENetwork_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ENetwork actualENetwork = new ENetwork("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualENetwork.getMessage());
    assertNull(actualENetwork.getCause());
    assertEquals(0, actualENetwork.getSuppressed().length);
  }

  /**
   * Test {@link ENetwork#ENetwork(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ENetwork#ENetwork(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ENetwork(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ENetwork.<init>(String)", "void ENetwork.<init>(String, Throwable)"})
  void testNewENetwork_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ENetwork actualENetwork = new ENetwork("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualENetwork.getMessage());
    assertEquals(0, actualENetwork.getSuppressed().length);
    assertSame(cause, actualENetwork.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ECacheTicketDiffblueTest {
  /**
   * Test {@link ECacheTicket#ECacheTicket(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheTicket#ECacheTicket(String)}
   */
  @Test
  @DisplayName("Test new ECacheTicket(String); when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheTicket.<init>(String)", "void ECacheTicket.<init>(String, Throwable)"})
  void testNewECacheTicket_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
    // Arrange and Act
    ECacheTicket actualECacheTicket = new ECacheTicket("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheTicket.getMessage());
    assertNull(actualECacheTicket.getCause());
    assertEquals(0, actualECacheTicket.getSuppressed().length);
  }

  /**
   * Test {@link ECacheTicket#ECacheTicket(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ECacheTicket#ECacheTicket(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ECacheTicket(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ECacheTicket.<init>(String)", "void ECacheTicket.<init>(String, Throwable)"})
  void testNewECacheTicket_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheTicket actualECacheTicket = new ECacheTicket("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheTicket.getMessage());
    assertEquals(0, actualECacheTicket.getSuppressed().length);
    assertSame(cause, actualECacheTicket.getCause());
  }
}

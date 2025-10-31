package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EConfigParseDiffblueTest {
  /**
   * Method under test: {@link EConfigParse#EConfigParse(String)}
   */
  @Test
  void testNewEConfigParse() {
    // Arrange and Act
    EConfigParse actualEConfigParse = new EConfigParse("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigParse.getMessage());
    assertNull(actualEConfigParse.getCause());
    assertNull(actualEConfigParse.getDetails());
    assertEquals(0, actualEConfigParse.getSuppressed().length);
  }

  /**
   * Method under test: {@link EConfigParse#EConfigParse(String, Throwable)}
   */
  @Test
  void testNewEConfigParse2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EConfigParse actualEConfigParse = new EConfigParse("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEConfigParse.getMessage());
    assertNull(actualEConfigParse.getDetails());
    assertEquals(0, actualEConfigParse.getSuppressed().length);
    assertSame(cause, actualEConfigParse.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ECacheDuplicateDiffblueTest {
  /**
   * Method under test: {@link ECacheDuplicate#ECacheDuplicate(String)}
   */
  @Test
  void testNewECacheDuplicate() {
    // Arrange and Act
    ECacheDuplicate actualECacheDuplicate = new ECacheDuplicate("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualECacheDuplicate.getMessage());
    assertNull(actualECacheDuplicate.getCause());
    assertEquals(0, actualECacheDuplicate.getSuppressed().length);
  }

  /**
   * Method under test: {@link ECacheDuplicate#ECacheDuplicate(String, Throwable)}
   */
  @Test
  void testNewECacheDuplicate2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ECacheDuplicate actualECacheDuplicate = new ECacheDuplicate("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualECacheDuplicate.getMessage());
    assertEquals(0, actualECacheDuplicate.getSuppressed().length);
    assertSame(cause, actualECacheDuplicate.getCause());
  }
}

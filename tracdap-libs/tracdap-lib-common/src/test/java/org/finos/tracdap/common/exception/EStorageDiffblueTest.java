package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EStorageDiffblueTest {
  /**
   * Method under test: {@link EStorage#EStorage(String)}
   */
  @Test
  void testNewEStorage() {
    // Arrange and Act
    EStorage actualEStorage = new EStorage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEStorage.getMessage());
    assertNull(actualEStorage.getCause());
    assertEquals(0, actualEStorage.getSuppressed().length);
  }

  /**
   * Method under test: {@link EStorage#EStorage(String, Throwable)}
   */
  @Test
  void testNewEStorage2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStorage actualEStorage = new EStorage("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEStorage.getMessage());
    assertEquals(0, actualEStorage.getSuppressed().length);
    assertSame(cause, actualEStorage.getCause());
  }
}

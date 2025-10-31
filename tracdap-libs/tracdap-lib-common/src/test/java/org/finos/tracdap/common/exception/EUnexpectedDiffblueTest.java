package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EUnexpectedDiffblueTest {
  /**
   * Method under test: {@link EUnexpected#EUnexpected()}
   */
  @Test
  void testNewEUnexpected() {
    // Arrange and Act
    EUnexpected actualEUnexpected = new EUnexpected();

    // Assert
    assertEquals("Unexpected internal error (this is a bug)", actualEUnexpected.getMessage());
    assertNull(actualEUnexpected.getCause());
    assertEquals(0, actualEUnexpected.getSuppressed().length);
  }

  /**
   * Method under test: {@link EUnexpected#EUnexpected(Throwable)}
   */
  @Test
  void testNewEUnexpected2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EUnexpected actualEUnexpected = new EUnexpected(cause);

    // Assert
    assertEquals("Unexpected internal error (this is a bug)", actualEUnexpected.getMessage());
    assertEquals(0, actualEUnexpected.getSuppressed().length);
    assertSame(cause, actualEUnexpected.getCause());
  }
}

package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EDataConstraintDiffblueTest {
  /**
   * Method under test: {@link EDataConstraint#EDataConstraint(String)}
   */
  @Test
  void testNewEDataConstraint() {
    // Arrange and Act
    EDataConstraint actualEDataConstraint = new EDataConstraint("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEDataConstraint.getMessage());
    assertNull(actualEDataConstraint.getCause());
    assertNull(actualEDataConstraint.getDetails());
    assertEquals(0, actualEDataConstraint.getSuppressed().length);
  }

  /**
   * Method under test: {@link EDataConstraint#EDataConstraint(String, Throwable)}
   */
  @Test
  void testNewEDataConstraint2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EDataConstraint actualEDataConstraint = new EDataConstraint("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualEDataConstraint.getMessage());
    assertNull(actualEDataConstraint.getDetails());
    assertEquals(0, actualEDataConstraint.getSuppressed().length);
    assertSame(cause, actualEDataConstraint.getCause());
  }
}

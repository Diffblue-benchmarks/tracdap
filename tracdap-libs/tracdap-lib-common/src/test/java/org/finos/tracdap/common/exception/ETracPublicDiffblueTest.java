package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.tracdap.api.TracErrorDetails;
import org.junit.jupiter.api.Test;

class ETracPublicDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ETracPublic#ETracPublic(String)}
   *   <li>{@link ETracPublic#getDetails()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ETracPublic actualETracPublic = new ETracPublic("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualETracPublic.getMessage());
    assertNull(actualETracPublic.getCause());
    assertNull(actualETracPublic.getDetails());
    assertEquals(0, actualETracPublic.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ETracPublic#ETracPublic(String, Throwable)}
   *   <li>{@link ETracPublic#getDetails()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ETracPublic actualETracPublic = new ETracPublic("Not all who wander are lost", cause);

    // Assert
    assertEquals("Not all who wander are lost", actualETracPublic.getMessage());
    assertNull(actualETracPublic.getDetails());
    assertEquals(0, actualETracPublic.getSuppressed().length);
    assertSame(cause, actualETracPublic.getCause());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ETracPublic#ETracPublic(String, TracErrorDetails)}
   *   <li>{@link ETracPublic#getDetails()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    TracErrorDetails details = TracErrorDetails.getDefaultInstance();

    // Act
    ETracPublic actualETracPublic = new ETracPublic("Not all who wander are lost", details);
    TracErrorDetails actualDetails = actualETracPublic.getDetails();

    // Assert
    assertEquals("Not all who wander are lost", actualETracPublic.getMessage());
    assertNull(actualETracPublic.getCause());
    assertEquals(0, actualETracPublic.getSuppressed().length);
    assertSame(details, actualDetails);
  }
}

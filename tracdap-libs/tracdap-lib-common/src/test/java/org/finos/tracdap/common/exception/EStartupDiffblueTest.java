package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EStartupDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EStartup actualEStartup = new EStartup("Not all who wander are lost");
    int actualExitCode = actualEStartup.getExitCode();
    boolean actualIsQuietResult = actualEStartup.isQuiet();

    // Assert
    assertEquals("Not all who wander are lost", actualEStartup.getMessage());
    assertNull(actualEStartup.getCause());
    assertNull(actualEStartup.getDetails());
    assertEquals(-1, actualExitCode);
    assertEquals(0, actualEStartup.getSuppressed().length);
    assertFalse(actualIsQuietResult);
  }

  /**
   * Method under test: {@link EStartup#quietShutdown(int)}
   */
  @Test
  void testQuietShutdown() {
    // Arrange and Act
    EStartup actualQuietShutdownResult = EStartup.quietShutdown(1);

    // Assert
    assertEquals("Quiet shutdown", actualQuietShutdownResult.getLocalizedMessage());
    assertEquals("Quiet shutdown", actualQuietShutdownResult.getMessage());
    assertNull(actualQuietShutdownResult.getCause());
    assertNull(actualQuietShutdownResult.getDetails());
    assertEquals(0, actualQuietShutdownResult.getSuppressed().length);
    assertEquals(1, actualQuietShutdownResult.getExitCode());
    assertTrue(actualQuietShutdownResult.isQuiet());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, int)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EStartup actualEStartup = new EStartup("Not all who wander are lost", 1);
    int actualExitCode = actualEStartup.getExitCode();
    boolean actualIsQuietResult = actualEStartup.isQuiet();

    // Assert
    assertEquals("Not all who wander are lost", actualEStartup.getMessage());
    assertNull(actualEStartup.getCause());
    assertNull(actualEStartup.getDetails());
    assertEquals(0, actualEStartup.getSuppressed().length);
    assertEquals(1, actualExitCode);
    assertFalse(actualIsQuietResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, int, Throwable)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStartup actualEStartup = new EStartup("Not all who wander are lost", 1, cause);
    int actualExitCode = actualEStartup.getExitCode();
    boolean actualIsQuietResult = actualEStartup.isQuiet();

    // Assert
    assertEquals("Not all who wander are lost", actualEStartup.getMessage());
    assertNull(actualEStartup.getDetails());
    assertEquals(0, actualEStartup.getSuppressed().length);
    assertEquals(1, actualExitCode);
    assertFalse(actualIsQuietResult);
    assertSame(cause, actualEStartup.getCause());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, Throwable)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  void testGettersAndSetters4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EStartup actualEStartup = new EStartup("Not all who wander are lost", cause);
    int actualExitCode = actualEStartup.getExitCode();
    boolean actualIsQuietResult = actualEStartup.isQuiet();

    // Assert
    assertEquals("Not all who wander are lost", actualEStartup.getMessage());
    assertNull(actualEStartup.getDetails());
    assertEquals(-1, actualExitCode);
    assertEquals(0, actualEStartup.getSuppressed().length);
    assertFalse(actualIsQuietResult);
    assertSame(cause, actualEStartup.getCause());
  }
}

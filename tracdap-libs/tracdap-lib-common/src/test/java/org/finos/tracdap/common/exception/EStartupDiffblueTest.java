package org.finos.tracdap.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EStartupDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Not all who wander are lost'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStartup.<init>(String)", "void EStartup.<init>(String, int)",
      "void EStartup.<init>(String, int, Throwable)", "void EStartup.<init>(String, Throwable)",
      "int EStartup.getExitCode()", "boolean EStartup.isQuiet()"})
  void testGettersAndSetters_whenNotAllWhoWanderAreLost_thenReturnCauseIsNull() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, int)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStartup.<init>(String)", "void EStartup.<init>(String, int)",
      "void EStartup.<init>(String, int, Throwable)", "void EStartup.<init>(String, Throwable)",
      "int EStartup.getExitCode()", "boolean EStartup.isQuiet()"})
  void testGettersAndSetters_whenOne_thenReturnCauseIsNull() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return ExitCode is one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, int, Throwable)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return ExitCode is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStartup.<init>(String)", "void EStartup.<init>(String, int)",
      "void EStartup.<init>(String, int, Throwable)", "void EStartup.<init>(String, Throwable)",
      "int EStartup.getExitCode()", "boolean EStartup.isQuiet()"})
  void testGettersAndSetters_whenOne_thenReturnExitCodeIsOne() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return ExitCode is minus one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EStartup#EStartup(String, Throwable)}
   *   <li>{@link EStartup#getExitCode()}
   *   <li>{@link EStartup#isQuiet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return ExitCode is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EStartup.<init>(String)", "void EStartup.<init>(String, int)",
      "void EStartup.<init>(String, int, Throwable)", "void EStartup.<init>(String, Throwable)",
      "int EStartup.getExitCode()", "boolean EStartup.isQuiet()"})
  void testGettersAndSetters_whenThrowable_thenReturnExitCodeIsMinusOne() {
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

  /**
   * Test {@link EStartup#quietShutdown(int)}.
   * <p>
   * Method under test: {@link EStartup#quietShutdown(int)}
   */
  @Test
  @DisplayName("Test quietShutdown(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EStartup EStartup.quietShutdown(int)"})
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
}

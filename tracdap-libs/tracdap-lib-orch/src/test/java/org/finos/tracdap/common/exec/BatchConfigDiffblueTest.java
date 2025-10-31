package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class BatchConfigDiffblueTest {
  /**
   * Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  void testForCommand() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    ArrayList<LaunchArg> launchArgs = new ArrayList<>();

    // Act
    BatchConfig actualForCommandResult = BatchConfig.forCommand(launchCmd, launchArgs);

    // Assert
    assertNull(actualForCommandResult.getStdErr());
    assertNull(actualForCommandResult.getStdOut());
    assertFalse(actualForCommandResult.isRedirectOutput());
    List<LaunchArg> launchArgs2 = actualForCommandResult.getLaunchArgs();
    assertTrue(launchArgs2.isEmpty());
    assertSame(launchArgs, launchArgs2);
    assertSame(launchCmd, actualForCommandResult.getLaunchCmd());
  }

  /**
   * Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  void testForCommand2() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();

    ArrayList<LaunchArg> launchArgs = new ArrayList<>();
    launchArgs.add(LaunchArg.string("Arg"));

    // Act
    BatchConfig actualForCommandResult = BatchConfig.forCommand(launchCmd, launchArgs);

    // Assert
    assertNull(actualForCommandResult.getStdErr());
    assertNull(actualForCommandResult.getStdOut());
    assertFalse(actualForCommandResult.isRedirectOutput());
    assertSame(launchArgs, actualForCommandResult.getLaunchArgs());
    assertSame(launchCmd, actualForCommandResult.getLaunchCmd());
  }

  /**
   * Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  void testForCommand3() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();

    ArrayList<LaunchArg> launchArgs = new ArrayList<>();
    launchArgs.add(LaunchArg.string("Arg"));
    launchArgs.add(LaunchArg.string("Arg"));

    // Act
    BatchConfig actualForCommandResult = BatchConfig.forCommand(launchCmd, launchArgs);

    // Assert
    assertNull(actualForCommandResult.getStdErr());
    assertNull(actualForCommandResult.getStdOut());
    assertFalse(actualForCommandResult.isRedirectOutput());
    assertSame(launchArgs, actualForCommandResult.getLaunchArgs());
    assertSame(launchCmd, actualForCommandResult.getLaunchCmd());
  }

  /**
   * Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  void testAddExtraArgs() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    // Act
    forCommandResult.addExtraArgs(new ArrayList<>());

    // Assert
    assertTrue(forCommandResult.getLaunchArgs().isEmpty());
  }

  /**
   * Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  void testAddExtraArgs2() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    ArrayList<LaunchArg> extraArgs = new ArrayList<>();
    extraArgs.add(LaunchArg.string("Arg"));

    // Act
    forCommandResult.addExtraArgs(extraArgs);

    // Assert
    assertEquals(extraArgs, forCommandResult.getLaunchArgs());
  }

  /**
   * Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  void testAddExtraArgs3() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    ArrayList<LaunchArg> extraArgs = new ArrayList<>();
    extraArgs.add(LaunchArg.string("Arg"));
    extraArgs.add(LaunchArg.string("Arg"));

    // Act
    forCommandResult.addExtraArgs(extraArgs);

    // Assert
    assertEquals(extraArgs, forCommandResult.getLaunchArgs());
  }

  /**
   * Method under test:
   * {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  void testAddLoggingRedirect() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut = LaunchArg.string("Arg");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> forCommandResult.addLoggingRedirect(stdOut, LaunchArg.string("Arg")));
  }

  /**
   * Method under test:
   * {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  void testAddLoggingRedirect2() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut = LaunchArg.path("Batch config for stdOut and stdErr must have arg type PATH",
        "Batch config for stdOut and stdErr must have arg type PATH");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> forCommandResult.addLoggingRedirect(stdOut, LaunchArg.string("Arg")));
  }

  /**
   * Method under test:
   * {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  void testAddLoggingRedirect3() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut = LaunchArg.path("Batch config for stdOut and stdErr must have arg type PATH",
        "Batch config for stdOut and stdErr must have arg type PATH");
    LaunchArg stdErr = LaunchArg.path("Batch config for stdOut and stdErr must have arg type PATH",
        "Batch config for stdOut and stdErr must have arg type PATH");

    // Act
    forCommandResult.addLoggingRedirect(stdOut, stdErr);

    // Assert
    assertTrue(forCommandResult.isRedirectOutput());
    assertSame(stdErr, forCommandResult.getStdErr());
    assertSame(stdOut, forCommandResult.getStdOut());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BatchConfig#getLaunchArgs()}
   *   <li>{@link BatchConfig#getLaunchCmd()}
   *   <li>{@link BatchConfig#getStdErr()}
   *   <li>{@link BatchConfig#getStdOut()}
   *   <li>{@link BatchConfig#isRedirectOutput()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    ArrayList<LaunchArg> launchArgs = new ArrayList<>();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, launchArgs);

    // Act
    List<LaunchArg> actualLaunchArgs = forCommandResult.getLaunchArgs();
    LaunchCmd actualLaunchCmd = forCommandResult.getLaunchCmd();
    LaunchArg actualStdErr = forCommandResult.getStdErr();
    LaunchArg actualStdOut = forCommandResult.getStdOut();

    // Assert
    assertNull(actualStdErr);
    assertNull(actualStdOut);
    assertFalse(forCommandResult.isRedirectOutput());
    assertTrue(actualLaunchArgs.isEmpty());
    assertSame(launchArgs, actualLaunchArgs);
    assertSame(launchCmd, actualLaunchCmd);
  }
}

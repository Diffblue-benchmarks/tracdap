package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BatchConfigDiffblueTest {
  /**
   * Test {@link BatchConfig#forCommand(LaunchCmd, List)}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then return LaunchArgs is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  @DisplayName(
      "Test forCommand(LaunchCmd, List); given string 'Arg'; then return LaunchArgs is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchConfig BatchConfig.forCommand(LaunchCmd, List)"})
  void testForCommand_givenStringArg_thenReturnLaunchArgsIsArrayList() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();

    ArrayList<LaunchArg> launchArgs = new ArrayList<>();
    launchArgs.add(LaunchArg.string("Arg"));

    // Act and Assert
    assertSame(launchArgs, BatchConfig.forCommand(launchCmd, launchArgs).getLaunchArgs());
  }

  /**
   * Test {@link BatchConfig#forCommand(LaunchCmd, List)}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then return LaunchArgs size is two.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  @DisplayName(
      "Test forCommand(LaunchCmd, List); given string 'Arg'; then return LaunchArgs size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchConfig BatchConfig.forCommand(LaunchCmd, List)"})
  void testForCommand_givenStringArg_thenReturnLaunchArgsSizeIsTwo() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();

    ArrayList<LaunchArg> launchArgs = new ArrayList<>();
    launchArgs.add(LaunchArg.string("Arg"));
    LaunchArg stringResult = LaunchArg.string("Arg");
    launchArgs.add(stringResult);

    // Act and Assert
    List<LaunchArg> launchArgs2 = BatchConfig.forCommand(launchCmd, launchArgs).getLaunchArgs();
    assertEquals(2, launchArgs2.size());
    assertSame(stringResult, launchArgs2.get(1));
  }

  /**
   * Test {@link BatchConfig#forCommand(LaunchCmd, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return StdErr is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#forCommand(LaunchCmd, List)}
   */
  @Test
  @DisplayName("Test forCommand(LaunchCmd, List); when ArrayList(); then return StdErr is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchConfig BatchConfig.forCommand(LaunchCmd, List)"})
  void testForCommand_whenArrayList_thenReturnStdErrIsNull() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();

    // Act
    BatchConfig actualForCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    // Assert
    assertNull(actualForCommandResult.getStdErr());
    assertNull(actualForCommandResult.getStdOut());
    assertFalse(actualForCommandResult.isRedirectOutput());
    assertTrue(actualForCommandResult.getLaunchArgs().isEmpty());
    assertSame(launchCmd, actualForCommandResult.getLaunchCmd());
  }

  /**
   * Test {@link BatchConfig#addExtraArgs(List)}.
   *
   * <ul>
   *   <li>Then forCommand trac and {@link ArrayList#ArrayList()} LaunchArgs is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  @DisplayName(
      "Test addExtraArgs(List); then forCommand trac and ArrayList() LaunchArgs is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addExtraArgs(List)"})
  void testAddExtraArgs_thenForCommandTracAndArrayListLaunchArgsIsArrayList() {
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
   * Test {@link BatchConfig#addExtraArgs(List)}.
   *
   * <ul>
   *   <li>Then forCommand trac and {@link ArrayList#ArrayList()} LaunchArgs size is one.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  @DisplayName(
      "Test addExtraArgs(List); then forCommand trac and ArrayList() LaunchArgs size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addExtraArgs(List)"})
  void testAddExtraArgs_thenForCommandTracAndArrayListLaunchArgsSizeIsOne() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    ArrayList<LaunchArg> extraArgs = new ArrayList<>();
    LaunchArg stringResult = LaunchArg.string("Arg");
    extraArgs.add(stringResult);

    // Act
    forCommandResult.addExtraArgs(extraArgs);

    // Assert
    List<LaunchArg> launchArgs = forCommandResult.getLaunchArgs();
    assertEquals(1, launchArgs.size());
    assertSame(stringResult, launchArgs.get(0));
  }

  /**
   * Test {@link BatchConfig#addExtraArgs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then forCommand trac and {@link ArrayList#ArrayList()} LaunchArgs Empty.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addExtraArgs(List)}
   */
  @Test
  @DisplayName(
      "Test addExtraArgs(List); when ArrayList(); then forCommand trac and ArrayList() LaunchArgs Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addExtraArgs(List)"})
  void testAddExtraArgs_whenArrayList_thenForCommandTracAndArrayListLaunchArgsEmpty() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());

    // Act
    forCommandResult.addExtraArgs(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(forCommandResult.getLaunchArgs().isEmpty());
  }

  /**
   * Test {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}.
   *
   * <ul>
   *   <li>Then forCommand trac and {@link ArrayList#ArrayList()} RedirectOutput.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  @DisplayName(
      "Test addLoggingRedirect(LaunchArg, LaunchArg); then forCommand trac and ArrayList() RedirectOutput")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addLoggingRedirect(LaunchArg, LaunchArg)"})
  void testAddLoggingRedirect_thenForCommandTracAndArrayListRedirectOutput() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut =
        LaunchArg.path(
            "Batch config for stdOut and stdErr must have arg type PATH",
            "Batch config for stdOut and stdErr must have arg type PATH");
    LaunchArg stdErr =
        LaunchArg.path(
            "Batch config for stdOut and stdErr must have arg type PATH",
            "Batch config for stdOut and stdErr must have arg type PATH");

    // Act
    forCommandResult.addLoggingRedirect(stdOut, stdErr);

    // Assert
    assertTrue(forCommandResult.isRedirectOutput());
    assertSame(stdErr, forCommandResult.getStdErr());
    assertSame(stdOut, forCommandResult.getStdOut());
  }

  /**
   * Test {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  @DisplayName("Test addLoggingRedirect(LaunchArg, LaunchArg); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addLoggingRedirect(LaunchArg, LaunchArg)"})
  void testAddLoggingRedirect_thenThrowETracInternal() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut =
        LaunchArg.path(
            "Batch config for stdOut and stdErr must have arg type PATH",
            "Batch config for stdOut and stdErr must have arg type PATH");

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> forCommandResult.addLoggingRedirect(stdOut, LaunchArg.string("Arg")));
  }

  /**
   * Test {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}.
   *
   * <ul>
   *   <li>When string {@code Arg}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchConfig#addLoggingRedirect(LaunchArg, LaunchArg)}
   */
  @Test
  @DisplayName(
      "Test addLoggingRedirect(LaunchArg, LaunchArg); when string 'Arg'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchConfig.addLoggingRedirect(LaunchArg, LaunchArg)"})
  void testAddLoggingRedirect_whenStringArg_thenThrowETracInternal() {
    // Arrange
    LaunchCmd launchCmd = LaunchCmd.trac();
    BatchConfig forCommandResult = BatchConfig.forCommand(launchCmd, new ArrayList<>());
    LaunchArg stdOut = LaunchArg.string("Arg");

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> forCommandResult.addLoggingRedirect(stdOut, LaunchArg.string("Arg")));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchConfig#getLaunchArgs()}
   *   <li>{@link BatchConfig#getLaunchCmd()}
   *   <li>{@link BatchConfig#getStdErr()}
   *   <li>{@link BatchConfig#getStdOut()}
   *   <li>{@link BatchConfig#isRedirectOutput()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BatchConfig.getLaunchArgs()",
    "LaunchCmd BatchConfig.getLaunchCmd()",
    "LaunchArg BatchConfig.getStdErr()",
    "LaunchArg BatchConfig.getStdOut()",
    "boolean BatchConfig.isRedirectOutput()"
  })
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

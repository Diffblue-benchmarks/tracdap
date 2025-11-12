package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LaunchCmdDiffblueTest {
  /**
   * Test {@link LaunchCmd#trac()}.
   *
   * <p>Method under test: {@link LaunchCmd#trac()}
   */
  @Test
  @DisplayName("Test trac()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchCmd LaunchCmd.trac()"})
  void testTrac() {
    // Arrange and Act
    LaunchCmd actualTracResult = LaunchCmd.trac();

    // Assert
    List<LaunchArg> commandArgsResult = actualTracResult.commandArgs();
    assertEquals(2, commandArgsResult.size());
    LaunchArg getResult = commandArgsResult.get(0);
    assertEquals("-m", getResult.getStringArg());
    assertEquals("python", actualTracResult.command());
    LaunchArg getResult2 = commandArgsResult.get(1);
    assertEquals("tracdap.rt.launch", getResult2.getStringArg());
    assertEquals(LaunchArgType.STRING, getResult.getArgType());
    assertEquals(LaunchArgType.STRING, getResult2.getArgType());
    assertTrue(actualTracResult.isTrac());
  }

  /**
   * Test {@link LaunchCmd#custom(String)} with {@code command}.
   *
   * <p>Method under test: {@link LaunchCmd#custom(String)}
   */
  @Test
  @DisplayName("Test custom(String) with 'command'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchCmd LaunchCmd.custom(String)"})
  void testCustomWithCommand() {
    // Arrange and Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command");

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    assertTrue(actualCustomResult.commandArgs().isEmpty());
  }

  /**
   * Test {@link LaunchCmd#custom(String, List)} with {@code command}, {@code args}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then return commandArgs is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  @DisplayName(
      "Test custom(String, List) with 'command', 'args'; given string 'Arg'; then return commandArgs is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchCmd LaunchCmd.custom(String, List)"})
  void testCustomWithCommandArgs_givenStringArg_thenReturnCommandArgsIsArrayList() {
    // Arrange
    ArrayList<LaunchArg> args = new ArrayList<>();
    args.add(LaunchArg.string("Arg"));

    // Act and Assert
    assertSame(args, LaunchCmd.custom("Command", args).commandArgs());
  }

  /**
   * Test {@link LaunchCmd#custom(String, List)} with {@code command}, {@code args}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then return commandArgs size is two.
   * </ul>
   *
   * <p>Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  @DisplayName(
      "Test custom(String, List) with 'command', 'args'; given string 'Arg'; then return commandArgs size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchCmd LaunchCmd.custom(String, List)"})
  void testCustomWithCommandArgs_givenStringArg_thenReturnCommandArgsSizeIsTwo() {
    // Arrange
    ArrayList<LaunchArg> args = new ArrayList<>();
    args.add(LaunchArg.string("Arg"));
    LaunchArg stringResult = LaunchArg.string("Arg");
    args.add(stringResult);

    // Act and Assert
    List<LaunchArg> commandArgsResult = LaunchCmd.custom("Command", args).commandArgs();
    assertEquals(2, commandArgsResult.size());
    assertSame(stringResult, commandArgsResult.get(1));
  }

  /**
   * Test {@link LaunchCmd#custom(String, List)} with {@code command}, {@code args}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Command}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  @DisplayName(
      "Test custom(String, List) with 'command', 'args'; when ArrayList(); then return 'Command'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchCmd LaunchCmd.custom(String, List)"})
  void testCustomWithCommandArgs_whenArrayList_thenReturnCommand() {
    // Arrange and Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command", new ArrayList<>());

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    assertTrue(actualCustomResult.commandArgs().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LaunchCmd#command()}
   *   <li>{@link LaunchCmd#commandArgs()}
   *   <li>{@link LaunchCmd#isTrac()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LaunchCmd.command()",
    "List LaunchCmd.commandArgs()",
    "boolean LaunchCmd.isTrac()"
  })
  void testGettersAndSetters() {
    // Arrange
    LaunchCmd tracResult = LaunchCmd.trac();

    // Act
    String actualCommandResult = tracResult.command();
    List<LaunchArg> actualCommandArgsResult = tracResult.commandArgs();

    // Assert
    assertEquals(2, actualCommandArgsResult.size());
    LaunchArg getResult = actualCommandArgsResult.get(0);
    assertEquals("-m", getResult.getStringArg());
    assertEquals("python", actualCommandResult);
    LaunchArg getResult2 = actualCommandArgsResult.get(1);
    assertEquals("tracdap.rt.launch", getResult2.getStringArg());
    assertEquals(LaunchArgType.STRING, getResult.getArgType());
    assertEquals(LaunchArgType.STRING, getResult2.getArgType());
    assertTrue(tracResult.isTrac());
  }
}

package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LaunchCmdDiffblueTest {
  /**
   * Method under test: {@link LaunchCmd#trac()}
   */
  @Test
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
   * Method under test: {@link LaunchCmd#custom(String)}
   */
  @Test
  void testCustom() {
    // Arrange and Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command");

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    assertTrue(actualCustomResult.commandArgs().isEmpty());
  }

  /**
   * Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  void testCustom2() {
    // Arrange
    ArrayList<LaunchArg> args = new ArrayList<>();

    // Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command", args);

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    List<LaunchArg> commandArgsResult = actualCustomResult.commandArgs();
    assertTrue(commandArgsResult.isEmpty());
    assertSame(args, commandArgsResult);
  }

  /**
   * Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  void testCustom3() {
    // Arrange
    ArrayList<LaunchArg> args = new ArrayList<>();
    args.add(LaunchArg.string("Arg"));

    // Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command", args);

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    assertSame(args, actualCustomResult.commandArgs());
  }

  /**
   * Method under test: {@link LaunchCmd#custom(String, List)}
   */
  @Test
  void testCustom4() {
    // Arrange
    ArrayList<LaunchArg> args = new ArrayList<>();
    args.add(LaunchArg.string("Arg"));
    args.add(LaunchArg.string("Arg"));

    // Act
    LaunchCmd actualCustomResult = LaunchCmd.custom("Command", args);

    // Assert
    assertEquals("Command", actualCustomResult.command());
    assertFalse(actualCustomResult.isTrac());
    assertSame(args, actualCustomResult.commandArgs());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LaunchCmd#command()}
   *   <li>{@link LaunchCmd#commandArgs()}
   *   <li>{@link LaunchCmd#isTrac()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LaunchCmd tracResult = LaunchCmd.trac();

    // Act
    String actualCommandResult = tracResult.command();
    List<LaunchArg> actualCommandArgsResult = tracResult.commandArgs();
    boolean actualIsTracResult = tracResult.isTrac();

    // Assert
    assertEquals(2, actualCommandArgsResult.size());
    LaunchArg getResult = actualCommandArgsResult.get(0);
    assertEquals("-m", getResult.getStringArg());
    assertEquals("python", actualCommandResult);
    LaunchArg getResult2 = actualCommandArgsResult.get(1);
    assertEquals("tracdap.rt.launch", getResult2.getStringArg());
    assertEquals(LaunchArgType.STRING, getResult.getArgType());
    assertEquals(LaunchArgType.STRING, getResult2.getArgType());
    assertTrue(actualIsTracResult);
  }
}

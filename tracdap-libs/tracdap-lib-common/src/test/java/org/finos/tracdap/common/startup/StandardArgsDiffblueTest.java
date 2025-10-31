package org.finos.tracdap.common.startup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.startup.StandardArgs.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StandardArgsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardArgs#StandardArgs(Path, String, String, List)}
   *   <li>{@link StandardArgs#getConfigFile()}
   *   <li>{@link StandardArgs#getSecretKey()}
   *   <li>{@link StandardArgs#getTasks()}
   *   <li>{@link StandardArgs#getWorkingDir()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StandardArgs.<init>(Path, String, String, List)", "String StandardArgs.getConfigFile()",
      "String StandardArgs.getSecretKey()", "List StandardArgs.getTasks()", "Path StandardArgs.getWorkingDir()"})
  void testGettersAndSetters() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ArrayList<Task> tasks = new ArrayList<>();

    // Act
    StandardArgs actualStandardArgs = new StandardArgs(workingDir, "Config File",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", tasks);
    String actualConfigFile = actualStandardArgs.getConfigFile();
    String actualSecretKey = actualStandardArgs.getSecretKey();
    List<Task> actualTasks = actualStandardArgs.getTasks();
    Path actualWorkingDir = actualStandardArgs.getWorkingDir();

    // Assert
    assertEquals("Config File", actualConfigFile);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualSecretKey);
    assertTrue(actualTasks.isEmpty());
    assertSame(tasks, actualTasks);
    assertSame(workingDir, actualWorkingDir);
  }

  /**
   * Test {@link StandardArgs#StandardArgs(Path, String, String)}.
   * <p>
   * Method under test: {@link StandardArgs#StandardArgs(Path, String, String)}
   */
  @Test
  @DisplayName("Test new StandardArgs(Path, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StandardArgs.<init>(Path, String, String)"})
  void testNewStandardArgs() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    StandardArgs actualStandardArgs = new StandardArgs(workingDir, "Config File", "Keystore Key");

    // Assert
    assertEquals("Config File", actualStandardArgs.getConfigFile());
    assertEquals("Keystore Key", actualStandardArgs.getSecretKey());
    assertTrue(actualStandardArgs.getTasks().isEmpty());
    assertSame(workingDir, actualStandardArgs.getWorkingDir());
  }

  /**
   * Test Task {@link Task#argCount()}.
   * <p>
   * Method under test: {@link Task#argCount()}
   */
  @Test
  @DisplayName("Test Task argCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Task.argCount()"})
  void testTaskArgCount() {
    // Arrange, Act and Assert
    assertEquals(0, StandardArgs.task("Task Name", "Task Description").argCount());
  }

  /**
   * Test Task {@link Task#getTaskArg(int)} with {@code int}.
   * <ul>
   *   <li>Then return {@code Task Arg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#getTaskArg(int)}
   */
  @Test
  @DisplayName("Test Task getTaskArg(int) with 'int'; then return 'Task Arg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Task.getTaskArg(int)"})
  void testTaskGetTaskArgWithInt_thenReturnTaskArg() {
    // Arrange, Act and Assert
    assertEquals("Task Arg", StandardArgs.task("Task Name", "Task Arg", "Task Description").getTaskArg(0));
  }

  /**
   * Test Task {@link Task#getTaskArg()}.
   * <ul>
   *   <li>Given task {@code Task Name} and {@code Task Description}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#getTaskArg()}
   */
  @Test
  @DisplayName("Test Task getTaskArg(); given task 'Task Name' and 'Task Description'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Task.getTaskArg()"})
  void testTaskGetTaskArg_givenTaskTaskNameAndTaskDescription_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StandardArgs.task("Task Name", "Task Description").getTaskArg());
  }

  /**
   * Test Task {@link Task#getTaskArg()}.
   * <ul>
   *   <li>Then return {@code Task Arg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#getTaskArg()}
   */
  @Test
  @DisplayName("Test Task getTaskArg(); then return 'Task Arg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Task.getTaskArg()"})
  void testTaskGetTaskArg_thenReturnTaskArg() {
    // Arrange, Act and Assert
    assertEquals("Task Arg", StandardArgs.task("Task Name", "Task Arg", "Task Description").getTaskArg());
  }

  /**
   * Test Task getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Task#getTaskArgList()}
   *   <li>{@link Task#getTaskDescription()}
   *   <li>{@link Task#getTaskName()}
   * </ul>
   */
  @Test
  @DisplayName("Test Task getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Task.getTaskArgList()", "String Task.getTaskDescription()", "String Task.getTaskName()"})
  void testTaskGettersAndSetters() {
    // Arrange
    Task task = new Task("Task Name");

    // Act
    List<String> actualTaskArgList = task.getTaskArgList();
    String actualTaskDescription = task.getTaskDescription();

    // Assert
    assertEquals("Task Name", task.getTaskName());
    assertNull(actualTaskDescription);
    assertTrue(actualTaskArgList.isEmpty());
  }

  /**
   * Test Task {@link Task#hasArg()}.
   * <ul>
   *   <li>Given task {@code Task Name} and {@code Task Description}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#hasArg()}
   */
  @Test
  @DisplayName("Test Task hasArg(); given task 'Task Name' and 'Task Description'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Task.hasArg()"})
  void testTaskHasArg_givenTaskTaskNameAndTaskDescription_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StandardArgs.task("Task Name", "Task Description").hasArg());
  }

  /**
   * Test Task {@link Task#hasArg()}.
   * <ul>
   *   <li>Given {@link StandardArgs#task(String, String, String)} with {@code Task Name} and {@code Task Arg} and {@code Task Description}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#hasArg()}
   */
  @Test
  @DisplayName("Test Task hasArg(); given task(String, String, String) with 'Task Name' and 'Task Arg' and 'Task Description'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Task.hasArg()"})
  void testTaskHasArg_givenTaskWithTaskNameAndTaskArgAndTaskDescription_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StandardArgs.task("Task Name", "Task Arg", "Task Description").hasArg());
  }

  /**
   * Test Task {@link Task#Task(String)}.
   * <p>
   * Method under test: {@link Task#Task(String)}
   */
  @Test
  @DisplayName("Test Task new Task(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String)"})
  void testTaskNewTask() {
    // Arrange and Act
    Task actualTask = new Task("Task Name");

    // Assert
    assertEquals("Task Name", actualTask.getTaskName());
    assertNull(actualTask.getTaskArg());
    assertNull(actualTask.getTaskDescription());
    assertFalse(actualTask.hasArg());
    assertTrue(actualTask.getTaskArgList().isEmpty());
  }

  /**
   * Test Task {@link Task#Task(String, List, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return TaskArg is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, List, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, List, String); given '42'; when ArrayList() add '42'; then return TaskArg is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, List, String)"})
  void testTaskNewTask_given42_whenArrayListAdd42_thenReturnTaskArgIs42() {
    // Arrange
    ArrayList<String> taskArgs = new ArrayList<>();
    taskArgs.add("42");
    taskArgs.add("foo");

    // Act
    Task actualTask = new Task("Task Name", taskArgs, "Task Description");

    // Assert
    assertEquals("42", actualTask.getTaskArg());
    assertEquals("Task Description", actualTask.getTaskDescription());
    assertEquals("Task Name", actualTask.getTaskName());
    assertTrue(actualTask.hasArg());
    assertSame(taskArgs, actualTask.getTaskArgList());
  }

  /**
   * Test Task {@link Task#Task(String, List, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return TaskArg is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, List, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, List, String); given 'foo'; when ArrayList() add 'foo'; then return TaskArg is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, List, String)"})
  void testTaskNewTask_givenFoo_whenArrayListAddFoo_thenReturnTaskArgIsFoo() {
    // Arrange
    ArrayList<String> taskArgs = new ArrayList<>();
    taskArgs.add("foo");

    // Act
    Task actualTask = new Task("Task Name", taskArgs, "Task Description");

    // Assert
    assertEquals("Task Description", actualTask.getTaskDescription());
    assertEquals("Task Name", actualTask.getTaskName());
    assertEquals("foo", actualTask.getTaskArg());
    assertTrue(actualTask.hasArg());
    assertSame(taskArgs, actualTask.getTaskArgList());
  }

  /**
   * Test Task {@link Task#Task(String, List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return TaskArg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, List, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, List, String); when ArrayList(); then return TaskArg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, List, String)"})
  void testTaskNewTask_whenArrayList_thenReturnTaskArgIsNull() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", new ArrayList<>(), "Task Description");

    // Assert
    assertEquals("Task Description", actualTask.getTaskDescription());
    assertEquals("Task Name", actualTask.getTaskName());
    assertNull(actualTask.getTaskArg());
    assertFalse(actualTask.hasArg());
    assertTrue(actualTask.getTaskArgList().isEmpty());
  }

  /**
   * Test Task {@link Task#Task(String, List, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return TaskArg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, List, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, List, String); when 'null'; then return TaskArg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, List, String)"})
  void testTaskNewTask_whenNull_thenReturnTaskArgIsNull() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", (List<String>) null, "Task Description");

    // Assert
    assertEquals("Task Description", actualTask.getTaskDescription());
    assertEquals("Task Name", actualTask.getTaskName());
    assertNull(actualTask.getTaskArg());
    assertFalse(actualTask.hasArg());
    assertTrue(actualTask.getTaskArgList().isEmpty());
  }

  /**
   * Test Task {@link Task#Task(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Task Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, String, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, String, String); when 'null'; then return 'Task Description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, String, String)"})
  void testTaskNewTask_whenNull_thenReturnTaskDescription() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", (String) null, "Task Description");

    // Assert
    assertEquals("Task Description", actualTask.getTaskDescription());
    assertEquals("Task Name", actualTask.getTaskName());
    assertNull(actualTask.getTaskArg());
    assertFalse(actualTask.hasArg());
    assertTrue(actualTask.getTaskArgList().isEmpty());
  }

  /**
   * Test Task {@link Task#Task(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Task Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, String); when 'null'; then return 'Task Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, String)"})
  void testTaskNewTask_whenNull_thenReturnTaskName() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", null);

    // Assert
    assertEquals("Task Name", actualTask.getTaskName());
    assertNull(actualTask.getTaskArg());
    assertNull(actualTask.getTaskDescription());
    assertFalse(actualTask.hasArg());
    assertTrue(actualTask.getTaskArgList().isEmpty());
  }

  /**
   * Test Task {@link Task#Task(String, String)}.
   * <ul>
   *   <li>When {@code Task Arg}.</li>
   *   <li>Then return TaskArgList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, String); when 'Task Arg'; then return TaskArgList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, String)"})
  void testTaskNewTask_whenTaskArg_thenReturnTaskArgListSizeIsOne() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", "Task Arg");

    // Assert
    List<String> taskArgList = actualTask.getTaskArgList();
    assertEquals(1, taskArgList.size());
    assertEquals("Task Arg", taskArgList.get(0));
    assertEquals("Task Arg", actualTask.getTaskArg());
    assertTrue(actualTask.hasArg());
  }

  /**
   * Test Task {@link Task#Task(String, String, String)}.
   * <ul>
   *   <li>When {@code Task Arg}.</li>
   *   <li>Then return TaskArgList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Task#Task(String, String, String)}
   */
  @Test
  @DisplayName("Test Task new Task(String, String, String); when 'Task Arg'; then return TaskArgList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Task.<init>(String, String, String)"})
  void testTaskNewTask_whenTaskArg_thenReturnTaskArgListSizeIsOne2() {
    // Arrange and Act
    Task actualTask = new Task("Task Name", "Task Arg", "Task Description");

    // Assert
    List<String> taskArgList = actualTask.getTaskArgList();
    assertEquals(1, taskArgList.size());
    assertEquals("Task Arg", taskArgList.get(0));
    assertEquals("Task Arg", actualTask.getTaskArg());
    assertTrue(actualTask.hasArg());
  }

  /**
   * Test {@link StandardArgs#task(String, String, String)} with {@code taskName}, {@code taskArg}, {@code taskDescription}.
   * <ul>
   *   <li>Then return TaskArgList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, String, String)}
   */
  @Test
  @DisplayName("Test task(String, String, String) with 'taskName', 'taskArg', 'taskDescription'; then return TaskArgList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, String, String)"})
  void testTaskWithTaskNameTaskArgTaskDescription_thenReturnTaskArgListSizeIsOne() {
    // Arrange and Act
    Task actualTaskResult = StandardArgs.task("Task Name", "Task Arg", "Task Description");

    // Assert
    List<String> taskArgList = actualTaskResult.getTaskArgList();
    assertEquals(1, taskArgList.size());
    assertEquals("Task Arg", taskArgList.get(0));
    assertEquals("Task Arg", actualTaskResult.getTaskArg());
    assertTrue(actualTaskResult.hasArg());
  }

  /**
   * Test {@link StandardArgs#task(String, String, String)} with {@code taskName}, {@code taskArg}, {@code taskDescription}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Task Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, String, String)}
   */
  @Test
  @DisplayName("Test task(String, String, String) with 'taskName', 'taskArg', 'taskDescription'; when 'null'; then return 'Task Description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, String, String)"})
  void testTaskWithTaskNameTaskArgTaskDescription_whenNull_thenReturnTaskDescription() {
    // Arrange and Act
    Task actualTaskResult = StandardArgs.task("Task Name", (String) null, "Task Description");

    // Assert
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertNull(actualTaskResult.getTaskArg());
    assertFalse(actualTaskResult.hasArg());
    assertTrue(actualTaskResult.getTaskArgList().isEmpty());
  }

  /**
   * Test {@link StandardArgs#task(String, List, String)} with {@code taskName}, {@code taskArgs}, {@code taskDescription}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return TaskArg is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, List, String)}
   */
  @Test
  @DisplayName("Test task(String, List, String) with 'taskName', 'taskArgs', 'taskDescription'; given '42'; then return TaskArg is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, List, String)"})
  void testTaskWithTaskNameTaskArgsTaskDescription_given42_thenReturnTaskArgIs42() {
    // Arrange
    ArrayList<String> taskArgs = new ArrayList<>();
    taskArgs.add("42");
    taskArgs.add("foo");

    // Act
    Task actualTaskResult = StandardArgs.task("Task Name", taskArgs, "Task Description");

    // Assert
    assertEquals("42", actualTaskResult.getTaskArg());
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertTrue(actualTaskResult.hasArg());
    assertSame(taskArgs, actualTaskResult.getTaskArgList());
  }

  /**
   * Test {@link StandardArgs#task(String, List, String)} with {@code taskName}, {@code taskArgs}, {@code taskDescription}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return TaskArg is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, List, String)}
   */
  @Test
  @DisplayName("Test task(String, List, String) with 'taskName', 'taskArgs', 'taskDescription'; given 'foo'; then return TaskArg is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, List, String)"})
  void testTaskWithTaskNameTaskArgsTaskDescription_givenFoo_thenReturnTaskArgIsFoo() {
    // Arrange
    ArrayList<String> taskArgs = new ArrayList<>();
    taskArgs.add("foo");

    // Act
    Task actualTaskResult = StandardArgs.task("Task Name", taskArgs, "Task Description");

    // Assert
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertEquals("foo", actualTaskResult.getTaskArg());
    assertTrue(actualTaskResult.hasArg());
    assertSame(taskArgs, actualTaskResult.getTaskArgList());
  }

  /**
   * Test {@link StandardArgs#task(String, List, String)} with {@code taskName}, {@code taskArgs}, {@code taskDescription}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, List, String)}
   */
  @Test
  @DisplayName("Test task(String, List, String) with 'taskName', 'taskArgs', 'taskDescription'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, List, String)"})
  void testTaskWithTaskNameTaskArgsTaskDescription_whenArrayList() {
    // Arrange and Act
    Task actualTaskResult = StandardArgs.task("Task Name", new ArrayList<>(), "Task Description");

    // Assert
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertNull(actualTaskResult.getTaskArg());
    assertFalse(actualTaskResult.hasArg());
    assertTrue(actualTaskResult.getTaskArgList().isEmpty());
  }

  /**
   * Test {@link StandardArgs#task(String, List, String)} with {@code taskName}, {@code taskArgs}, {@code taskDescription}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return TaskArg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StandardArgs#task(String, List, String)}
   */
  @Test
  @DisplayName("Test task(String, List, String) with 'taskName', 'taskArgs', 'taskDescription'; when 'null'; then return TaskArg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, List, String)"})
  void testTaskWithTaskNameTaskArgsTaskDescription_whenNull_thenReturnTaskArgIsNull() {
    // Arrange and Act
    Task actualTaskResult = StandardArgs.task("Task Name", (List<String>) null, "Task Description");

    // Assert
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertNull(actualTaskResult.getTaskArg());
    assertFalse(actualTaskResult.hasArg());
    assertTrue(actualTaskResult.getTaskArgList().isEmpty());
  }

  /**
   * Test {@link StandardArgs#task(String, String)} with {@code taskName}, {@code taskDescription}.
   * <p>
   * Method under test: {@link StandardArgs#task(String, String)}
   */
  @Test
  @DisplayName("Test task(String, String) with 'taskName', 'taskDescription'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Task StandardArgs.task(String, String)"})
  void testTaskWithTaskNameTaskDescription() {
    // Arrange and Act
    Task actualTaskResult = StandardArgs.task("Task Name", "Task Description");

    // Assert
    assertEquals("Task Description", actualTaskResult.getTaskDescription());
    assertEquals("Task Name", actualTaskResult.getTaskName());
    assertNull(actualTaskResult.getTaskArg());
    assertFalse(actualTaskResult.hasArg());
    assertTrue(actualTaskResult.getTaskArgList().isEmpty());
  }
}

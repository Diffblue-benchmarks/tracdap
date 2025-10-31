package org.finos.tracdap.test.concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConcurrentTestHelpersDiffblueTest {
  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)} with {@code task}, {@code unwrap}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)}
   */
  @Test
  @DisplayName("Test getResultOf(CompletionStage, boolean) with 'task', 'unwrap'; given '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage, boolean)"})
  void testGetResultOfWithTaskUnwrap_given42_thenReturn42() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task, true));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)} with {@code task}, {@code unwrap}.
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)}
   */
  @Test
  @DisplayName("Test getResultOf(CompletionStage, boolean) with 'task', 'unwrap'; when CompletableFuture(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage, boolean)"})
  void testGetResultOfWithTaskUnwrap_whenCompletableFuture_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>(), true));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage)} with {@code task}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeValue {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  @DisplayName("Test getResultOf(CompletionStage) with 'task'; given '42'; when CompletableFuture() obtrudeValue '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage)"})
  void testGetResultOfWithTask_given42_whenCompletableFutureObtrudeValue42_thenReturn42() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage)} with {@code task}.
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  @DisplayName("Test getResultOf(CompletionStage) with 'task'; when CompletableFuture(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage)"})
  void testGetResultOfWithTask_whenCompletableFuture_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>()));
  }

  /**
   * Test {@link ConcurrentTestHelpers#resultOf(CompletionStage)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeValue {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  @DisplayName("Test resultOf(CompletionStage); given '42'; when CompletableFuture() obtrudeValue '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.resultOf(CompletionStage)"})
  void testResultOf_given42_whenCompletableFutureObtrudeValue42_thenReturn42() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.resultOf(task));
  }

  /**
   * Test {@link ConcurrentTestHelpers#resultOf(CompletionStage)}.
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  @DisplayName("Test resultOf(CompletionStage); when CompletableFuture(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ConcurrentTestHelpers.resultOf(CompletionStage)"})
  void testResultOf_whenCompletableFuture_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.resultOf(new CompletableFuture<>()));
  }
}

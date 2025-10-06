package org.finos.tracdap.test.concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConcurrentTestHelpersDiffblueTest {
  /**
   * Test {@link ConcurrentTestHelpers#waitFor(Duration, CompletionStage[])} with {@code Duration},
   * {@code CompletionStage[]}.
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#waitFor(Duration, CompletionStage[])}
   */
  @Test
  @DisplayName("Test waitFor(Duration, CompletionStage[]) with 'Duration', 'CompletionStage[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConcurrentTestHelpers.waitFor(Duration, CompletionStage[])"})
  void testWaitForWithDurationCompletionStage() {
    // Arrange
    Duration timeout = Duration.ofSeconds(1L);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ConcurrentTestHelpers.waitFor(timeout, new CompletableFuture<>()));
  }

  /**
   * Test {@link ConcurrentTestHelpers#waitFor(Duration, List)} with {@code Duration}, {@code List}.
   *
   * <ul>
   *   <li>Given {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#waitFor(Duration, List)}
   */
  @Test
  @DisplayName(
      "Test waitFor(Duration, List) with 'Duration', 'List'; given CompletableFuture(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConcurrentTestHelpers.waitFor(Duration, List)"})
  void testWaitForWithDurationList_givenCompletableFuture_thenThrowRuntimeException() {
    // Arrange
    Duration timeout = Duration.ofSeconds(1L);

    ArrayList<CompletionStage<?>> tasks = new ArrayList<>();
    tasks.add(new CompletableFuture<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.waitFor(timeout, tasks));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)} with {@code task},
   * {@code unwrap}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)}
   */
  @Test
  @DisplayName(
      "Test getResultOf(CompletionStage, boolean) with 'task', 'unwrap'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage, boolean)"})
  void testGetResultOfWithTaskUnwrap_given42_thenReturn42() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task, true));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)} with {@code task},
   * {@code unwrap}.
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)}
   */
  @Test
  @DisplayName(
      "Test getResultOf(CompletionStage, boolean) with 'task', 'unwrap'; when CompletableFuture(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage, boolean)"})
  void testGetResultOfWithTaskUnwrap_whenCompletableFuture_thenThrowRuntimeException()
      throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>(), true));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage)} with {@code task}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeValue {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test getResultOf(CompletionStage) with 'task'; given '42'; when CompletableFuture() obtrudeValue '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage)"})
  void testGetResultOfWithTask_given42_whenCompletableFutureObtrudeValue42_thenReturn42()
      throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task));
  }

  /**
   * Test {@link ConcurrentTestHelpers#getResultOf(CompletionStage)} with {@code task}.
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test getResultOf(CompletionStage) with 'task'; when CompletableFuture(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConcurrentTestHelpers.getResultOf(CompletionStage)"})
  void testGetResultOfWithTask_whenCompletableFuture_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>()));
  }

  /**
   * Test {@link ConcurrentTestHelpers#resultOf(CompletionStage)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeValue {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test resultOf(CompletionStage); given '42'; when CompletableFuture() obtrudeValue '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test resultOf(CompletionStage); when CompletableFuture(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConcurrentTestHelpers.resultOf(CompletionStage)"})
  void testResultOf_whenCompletableFuture_thenThrowRuntimeException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ConcurrentTestHelpers.resultOf(new CompletableFuture<>()));
  }
}

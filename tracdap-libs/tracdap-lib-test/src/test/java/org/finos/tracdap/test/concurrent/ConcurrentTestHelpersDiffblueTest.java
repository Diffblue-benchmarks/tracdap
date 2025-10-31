package org.finos.tracdap.test.concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.Test;

class ConcurrentTestHelpersDiffblueTest {
  /**
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  void testGetResultOf() throws Exception {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>()));
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.getResultOf(new CompletableFuture<>(), true));
  }

  /**
   * Method under test: {@link ConcurrentTestHelpers#getResultOf(CompletionStage)}
   */
  @Test
  void testGetResultOf2() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task));
  }

  /**
   * Method under test:
   * {@link ConcurrentTestHelpers#getResultOf(CompletionStage, boolean)}
   */
  @Test
  void testGetResultOf3() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.getResultOf(task, true));
  }

  /**
   * Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  void testResultOf() throws Exception {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ConcurrentTestHelpers.resultOf(new CompletableFuture<>()));
  }

  /**
   * Method under test: {@link ConcurrentTestHelpers#resultOf(CompletionStage)}
   */
  @Test
  void testResultOf2() throws Exception {
    // Arrange
    CompletableFuture<Object> task = new CompletableFuture<>();
    task.obtrudeValue("42");

    // Act and Assert
    assertEquals("42", ConcurrentTestHelpers.resultOf(task));
  }
}

package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GcpUnaryResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GcpUnaryResponse}
   *   <li>{@link GcpUnaryResponse#getResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GcpUnaryResponse.<init>()", "CompletionStage GcpUnaryResponse.getResult()"})
  void testGettersAndSetters() {
    // Arrange and Act
    GcpUnaryResponse<Object> actualGcpUnaryResponse = new GcpUnaryResponse<>();

    // Assert
    assertTrue(actualGcpUnaryResponse.getResult() instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUnaryResponse#onError(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then {@link GcpUnaryResponse} (default constructor) Result {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUnaryResponse#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); when Throwable(); then GcpUnaryResponse (default constructor) Result CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GcpUnaryResponse.onError(Throwable)"})
  void testOnError_whenThrowable_thenGcpUnaryResponseResultCompletableFuture() {
    // Arrange
    GcpUnaryResponse<Object> gcpUnaryResponse = new GcpUnaryResponse<>();

    // Act
    gcpUnaryResponse.onError(new Throwable());

    // Assert
    CompletionStage<Object> result = gcpUnaryResponse.getResult();
    assertTrue(result instanceof CompletableFuture);
    assertTrue(((CompletableFuture<Object>) result).isDone());
  }

  /**
   * Test {@link GcpUnaryResponse#onCompleted()}.
   * <p>
   * Method under test: {@link GcpUnaryResponse#onCompleted()}
   */
  @Test
  @DisplayName("Test onCompleted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GcpUnaryResponse.onCompleted()"})
  void testOnCompleted() {
    // Arrange
    GcpUnaryResponse<Object> gcpUnaryResponse = new GcpUnaryResponse<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> gcpUnaryResponse.onCompleted());
  }
}

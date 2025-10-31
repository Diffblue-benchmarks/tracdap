package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.Test;

class GcpUnaryResponseDiffblueTest {
  /**
   * Method under test: {@link GcpUnaryResponse#onError(Throwable)}
   */
  @Test
  void testOnError() {
    // Arrange
    GcpUnaryResponse<Object> gcpUnaryResponse = new GcpUnaryResponse<>();

    // Act
    gcpUnaryResponse.onError(new Throwable());

    // Assert that nothing has changed
    CompletionStage<Object> result = gcpUnaryResponse.getResult();
    assertTrue(result instanceof CompletableFuture);
    assertTrue(((CompletableFuture<Object>) result).isDone());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GcpUnaryResponse}
   *   <li>{@link GcpUnaryResponse#getResult()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GcpUnaryResponse<Object> actualGcpUnaryResponse = new GcpUnaryResponse<>();

    // Assert
    assertTrue(actualGcpUnaryResponse.getResult() instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link GcpUnaryResponse#onCompleted()}
   */
  @Test
  void testOnCompleted() {
    // Arrange
    GcpUnaryResponse<Object> gcpUnaryResponse = new GcpUnaryResponse<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> gcpUnaryResponse.onCompleted());
  }
}

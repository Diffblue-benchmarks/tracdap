package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class GcsStorageErrorsDiffblueTest {
  /**
   * Method under test: {@link GcsStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions() {
    // Arrange
    GcsStorageErrors gcsStorageErrors = new GcsStorageErrors("Storage Key");

    // Act and Assert
    assertNull(gcsStorageErrors.checkKnownExceptions(new Throwable()));
  }
}

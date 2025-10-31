package org.finos.tracdap.plugins.azure.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AzureStorageErrorsDiffblueTest {
  /**
   * Method under test: {@link AzureStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions() {
    // Arrange
    AzureStorageErrors azureStorageErrors = new AzureStorageErrors("Storage Key");

    // Act and Assert
    assertNull(azureStorageErrors.checkKnownExceptions(new Throwable()));
  }
}

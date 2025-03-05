package org.finos.tracdap.plugins.azure.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AzureStorageErrorsDiffblueTest {
  /**
   * Test {@link AzureStorageErrors#checkKnownExceptions(Throwable)}.
   * <p>
   * Method under test: {@link AzureStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  @DisplayName("Test checkKnownExceptions(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.tracdap.common.storage.StorageErrors.ExplicitError AzureStorageErrors.checkKnownExceptions(Throwable)"})
  void testCheckKnownExceptions() {
    // Arrange
    AzureStorageErrors azureStorageErrors = new AzureStorageErrors("Storage Key");

    // Act and Assert
    assertNull(azureStorageErrors.checkKnownExceptions(new Throwable()));
  }
}

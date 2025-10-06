package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GcsStorageErrorsDiffblueTest {
  /**
   * Test {@link GcsStorageErrors#checkKnownExceptions(Throwable)}.
   *
   * <p>Method under test: {@link GcsStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  @DisplayName("Test checkKnownExceptions(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.storage.StorageErrors.ExplicitError GcsStorageErrors.checkKnownExceptions(Throwable)"
  })
  void testCheckKnownExceptions() {
    // Arrange
    GcsStorageErrors gcsStorageErrors = new GcsStorageErrors("Storage Key");

    // Act and Assert
    assertNull(gcsStorageErrors.checkKnownExceptions(new Throwable()));
  }
}

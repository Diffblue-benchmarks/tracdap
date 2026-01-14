package org.finos.tracdap.plugins.aws.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class S3StorageErrorsDiffblueTest {
  /**
   * Test {@link S3StorageErrors#checkKnownExceptions(Throwable)}.
   *
   * <p>Method under test: {@link S3StorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  @DisplayName("Test checkKnownExceptions(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.storage.StorageErrors.ExplicitError S3StorageErrors.checkKnownExceptions(Throwable)"
  })
  void testCheckKnownExceptions() {
    // Arrange
    S3StorageErrors s3StorageErrors = new S3StorageErrors("Storage Key");

    // Act and Assert
    assertNull(s3StorageErrors.checkKnownExceptions(new Throwable()));
  }
}

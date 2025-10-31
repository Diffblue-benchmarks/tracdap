package org.finos.tracdap.plugins.aws.storage;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.s3.model.S3Exception;

class S3StorageErrorsDiffblueTest {
  /**
   * Method under test: {@link S3StorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions() {
    // Arrange
    S3StorageErrors s3StorageErrors = new S3StorageErrors("Storage Key");

    // Act and Assert
    assertNull(s3StorageErrors.checkKnownExceptions(new Throwable()));
  }

  /**
   * Method under test: {@link S3StorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions2() {
    // Arrange
    S3StorageErrors s3StorageErrors = new S3StorageErrors("Storage Key");

    Throwable e = new Throwable();
    e.initCause(mock(S3Exception.class));

    // Act and Assert
    assertNull(s3StorageErrors.checkKnownExceptions(e));
  }
}

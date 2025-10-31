package org.finos.tracdap.common.storage.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.finos.tracdap.common.storage.StorageErrors;
import org.junit.jupiter.api.Test;

class LocalStorageErrorsDiffblueTest {
  /**
   * Method under test: {@link LocalStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    // Act and Assert
    assertNull(localStorageErrors.checkKnownExceptions(new Throwable()));
  }

  /**
   * Method under test: {@link LocalStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  void testCheckKnownExceptions2() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    IOException e = new IOException("foo");
    e.addSuppressed(new Throwable());

    // Act and Assert
    assertEquals(StorageErrors.ExplicitError.IO_ERROR, localStorageErrors.checkKnownExceptions(e));
  }
}

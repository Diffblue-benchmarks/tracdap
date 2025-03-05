package org.finos.tracdap.common.storage.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.finos.tracdap.common.storage.StorageErrors;
import org.finos.tracdap.common.storage.StorageErrors.ExplicitError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalStorageErrorsDiffblueTest {
  /**
   * Test {@link LocalStorageErrors#checkKnownExceptions(Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return {@code IO_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  @DisplayName("Test checkKnownExceptions(Throwable); given Throwable(); then return 'IO_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageErrors.ExplicitError LocalStorageErrors.checkKnownExceptions(Throwable)"})
  void testCheckKnownExceptions_givenThrowable_thenReturnIoError() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    IOException e = new IOException("foo");
    e.addSuppressed(new Throwable());

    // Act and Assert
    assertEquals(ExplicitError.IO_ERROR, localStorageErrors.checkKnownExceptions(e));
  }

  /**
   * Test {@link LocalStorageErrors#checkKnownExceptions(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalStorageErrors#checkKnownExceptions(Throwable)}
   */
  @Test
  @DisplayName("Test checkKnownExceptions(Throwable); when Throwable(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageErrors.ExplicitError LocalStorageErrors.checkKnownExceptions(Throwable)"})
  void testCheckKnownExceptions_whenThrowable_thenReturnNull() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    // Act and Assert
    assertNull(localStorageErrors.checkKnownExceptions(new Throwable()));
  }
}

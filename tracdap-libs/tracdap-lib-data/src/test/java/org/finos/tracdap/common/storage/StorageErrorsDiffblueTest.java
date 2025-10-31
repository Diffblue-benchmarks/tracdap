package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.finos.tracdap.common.exception.EStorage;
import org.finos.tracdap.common.exception.EStorageCommunication;
import org.finos.tracdap.common.exception.ETrac;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.common.storage.local.LocalStorageErrors;
import org.junit.jupiter.api.Test;

class StorageErrorsDiffblueTest {
  /**
   * Method under test:
   * {@link StorageErrors#handleException(String, String, Throwable)}
   */
  @Test
  void testHandleException() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");
    Throwable error = new Throwable();

    // Act
    ETrac actualHandleExceptionResult = localStorageErrors.handleException("Operation", "Path", error);

    // Assert
    assertTrue(actualHandleExceptionResult instanceof ETracInternal);
    assertEquals("An unexpected error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getLocalizedMessage());
    assertEquals("An unexpected error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getMessage());
    assertEquals(0, actualHandleExceptionResult.getSuppressed().length);
    assertSame(error, actualHandleExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link StorageErrors#handleException(String, String, Throwable)}
   */
  @Test
  void testHandleException2() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    IOException error = new IOException("foo");
    error.addSuppressed(new Throwable());

    // Act
    ETrac actualHandleExceptionResult = localStorageErrors.handleException("Operation", "Path", error);

    // Assert
    assertTrue(actualHandleExceptionResult instanceof EStorage);
    assertEquals("An IO error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getLocalizedMessage());
    assertEquals("An IO error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getMessage());
    assertEquals(0, actualHandleExceptionResult.getSuppressed().length);
    assertSame(error, actualHandleExceptionResult.getCause());
  }

  /**
   * Method under test:
   * {@link StorageErrors#explicitError(String, String, StorageErrors.ExplicitError)}
   */
  @Test
  void testExplicitError() {
    // Arrange and Act
    ETrac actualExplicitErrorResult = (new LocalStorageErrors("Storage Key")).explicitError("Operation", "Path",
        StorageErrors.ExplicitError.STORAGE_PATH_NULL_OR_BLANK);

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getMessage());
    assertNull(actualExplicitErrorResult.getCause());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link StorageErrors#explicitError(String, String, StorageErrors.ExplicitError, String)}
   */
  @Test
  void testExplicitError2() {
    // Arrange and Act
    ETrac actualExplicitErrorResult = (new LocalStorageErrors("Storage Key")).explicitError("Operation", "Path",
        StorageErrors.ExplicitError.STORAGE_PATH_NULL_OR_BLANK, "Detail");

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Operation]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Operation]",
        actualExplicitErrorResult.getMessage());
    assertNull(actualExplicitErrorResult.getCause());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link StorageErrors#explicitError(String, String, StorageErrors.ExplicitError, Throwable)}
   */
  @Test
  void testExplicitError3() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");
    Throwable cause = new Throwable();

    // Act
    ETrac actualExplicitErrorResult = localStorageErrors.explicitError("Operation", "Path",
        StorageErrors.ExplicitError.STORAGE_PATH_NULL_OR_BLANK, cause);

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals("Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getMessage());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
    assertSame(cause, actualExplicitErrorResult.getCause());
  }

  /**
   * Method under test: {@link StorageErrors#chunkNotFullyWritten(long, long)}
   */
  @Test
  void testChunkNotFullyWritten() {
    // Arrange and Act
    ETrac actualChunkNotFullyWrittenResult = (new LocalStorageErrors("Storage Key")).chunkNotFullyWritten(1L, 1L);

    // Assert
    assertTrue(actualChunkNotFullyWrittenResult instanceof EStorageCommunication);
    assertEquals("Chunk was not fully written, chunk size = 1 B, written = 1 B",
        actualChunkNotFullyWrittenResult.getLocalizedMessage());
    assertEquals("Chunk was not fully written, chunk size = 1 B, written = 1 B",
        actualChunkNotFullyWrittenResult.getMessage());
    assertNull(actualChunkNotFullyWrittenResult.getCause());
    assertEquals(0, actualChunkNotFullyWrittenResult.getSuppressed().length);
  }
}

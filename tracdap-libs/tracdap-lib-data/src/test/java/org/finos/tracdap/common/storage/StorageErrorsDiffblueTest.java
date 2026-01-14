package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.finos.tracdap.common.exception.EStorage;
import org.finos.tracdap.common.exception.EStorageCommunication;
import org.finos.tracdap.common.exception.ETrac;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.common.storage.StorageErrors.ExplicitError;
import org.finos.tracdap.common.storage.local.LocalStorageErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StorageErrorsDiffblueTest {
  /**
   * Test {@link StorageErrors#handleException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then return {@link EStorage}.
   * </ul>
   *
   * <p>Method under test: {@link StorageErrors#handleException(String, String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test handleException(String, String, Throwable); given Throwable(); then return EStorage")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.handleException(String, String, Throwable)"})
  void testHandleException_givenThrowable_thenReturnEStorage() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");

    IOException error = new IOException();
    error.addSuppressed(new Throwable());

    // Act
    ETrac actualHandleExceptionResult =
        localStorageErrors.handleException("Operation", "Path", error);

    // Assert
    assertTrue(actualHandleExceptionResult instanceof EStorage);
    assertEquals(
        "An IO error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getLocalizedMessage());
    assertEquals(
        "An IO error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getMessage());
    assertSame(error, actualHandleExceptionResult.getCause());
  }

  /**
   * Test {@link StorageErrors#handleException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link StorageErrors#handleException(String, String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test handleException(String, String, Throwable); when Throwable(); then return ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.handleException(String, String, Throwable)"})
  void testHandleException_whenThrowable_thenReturnETracInternal() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");
    Throwable error = new Throwable();

    // Act
    ETrac actualHandleExceptionResult =
        localStorageErrors.handleException("Operation", "Path", error);

    // Assert
    assertTrue(actualHandleExceptionResult instanceof ETracInternal);
    assertEquals(
        "An unexpected error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getLocalizedMessage());
    assertEquals(
        "An unexpected error occurred in the storage layer: Operation Storage Key [Path]",
        actualHandleExceptionResult.getMessage());
    assertSame(error, actualHandleExceptionResult.getCause());
  }

  /**
   * Test {@link StorageErrors#explicitError(String, String, ExplicitError, Throwable)} with {@code
   * operation}, {@code path}, {@code error}, {@code cause}.
   *
   * <ul>
   *   <li>Then return {@link EValidationGap}.
   * </ul>
   *
   * <p>Method under test: {@link StorageErrors#explicitError(String, String, ExplicitError,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test explicitError(String, String, ExplicitError, Throwable) with 'operation', 'path', 'error', 'cause'; then return EValidationGap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.explicitError(String, String, ExplicitError, Throwable)"})
  void testExplicitErrorWithOperationPathErrorCause_thenReturnEValidationGap() {
    // Arrange
    LocalStorageErrors localStorageErrors = new LocalStorageErrors("Storage Key");
    Throwable cause = new Throwable();

    // Act
    ETrac actualExplicitErrorResult =
        localStorageErrors.explicitError(
            "Operation", "Path", ExplicitError.STORAGE_PATH_NULL_OR_BLANK, cause);

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getMessage());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
    assertSame(cause, actualExplicitErrorResult.getCause());
  }

  /**
   * Test {@link StorageErrors#explicitError(String, String, ExplicitError, String)} with {@code
   * operation}, {@code path}, {@code error}, {@code detail}.
   *
   * <p>Method under test: {@link StorageErrors#explicitError(String, String, ExplicitError,
   * String)}
   */
  @Test
  @DisplayName(
      "Test explicitError(String, String, ExplicitError, String) with 'operation', 'path', 'error', 'detail'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.explicitError(String, String, ExplicitError, String)"})
  void testExplicitErrorWithOperationPathErrorDetail() {
    // Arrange and Act
    ETrac actualExplicitErrorResult =
        new LocalStorageErrors("Storage Key")
            .explicitError("Operation", "Path", ExplicitError.STORAGE_PATH_NULL_OR_BLANK, "Detail");

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Operation]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Operation]",
        actualExplicitErrorResult.getMessage());
    assertNull(actualExplicitErrorResult.getCause());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
  }

  /**
   * Test {@link StorageErrors#explicitError(String, String, ExplicitError)} with {@code operation},
   * {@code path}, {@code error}.
   *
   * <ul>
   *   <li>Then return {@link EValidationGap}.
   * </ul>
   *
   * <p>Method under test: {@link StorageErrors#explicitError(String, String, ExplicitError)}
   */
  @Test
  @DisplayName(
      "Test explicitError(String, String, ExplicitError) with 'operation', 'path', 'error'; then return EValidationGap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.explicitError(String, String, ExplicitError)"})
  void testExplicitErrorWithOperationPathError_thenReturnEValidationGap() {
    // Arrange and Act
    ETrac actualExplicitErrorResult =
        new LocalStorageErrors("Storage Key")
            .explicitError("Operation", "Path", ExplicitError.STORAGE_PATH_NULL_OR_BLANK);

    // Assert
    assertTrue(actualExplicitErrorResult instanceof EValidationGap);
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getLocalizedMessage());
    assertEquals(
        "Requested storage path is null or blank: Operation Storage Key [Path]",
        actualExplicitErrorResult.getMessage());
    assertNull(actualExplicitErrorResult.getCause());
    assertEquals(0, actualExplicitErrorResult.getSuppressed().length);
  }

  /**
   * Test {@link StorageErrors#chunkNotFullyWritten(long, long)}.
   *
   * <p>Method under test: {@link StorageErrors#chunkNotFullyWritten(long, long)}
   */
  @Test
  @DisplayName("Test chunkNotFullyWritten(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETrac StorageErrors.chunkNotFullyWritten(long, long)"})
  void testChunkNotFullyWritten() {
    // Arrange and Act
    ETrac actualChunkNotFullyWrittenResult =
        new LocalStorageErrors("Storage Key").chunkNotFullyWritten(1L, 1L);

    // Assert
    assertTrue(actualChunkNotFullyWrittenResult instanceof EStorageCommunication);
    assertEquals(
        "Chunk was not fully written, chunk size = 1 B, written = 1 B",
        actualChunkNotFullyWrittenResult.getLocalizedMessage());
    assertEquals(
        "Chunk was not fully written, chunk size = 1 B, written = 1 B",
        actualChunkNotFullyWrittenResult.getMessage());
    assertNull(actualChunkNotFullyWrittenResult.getCause());
    assertEquals(0, actualChunkNotFullyWrittenResult.getSuppressed().length);
  }
}

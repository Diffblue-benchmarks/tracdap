package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import com.google.api.gax.httpjson.HttpJsonStatusCode;
import com.google.api.gax.rpc.NotFoundException;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import org.finos.tracdap.common.data.IExecutionContext;
import org.finos.tracdap.common.storage.FileStat;
import org.finos.tracdap.common.storage.FileType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GcsObjectStorageDiffblueTest {
  @InjectMocks private GcsObjectStorage gcsObjectStorage;

  @Mock private Properties properties;

  /**
   * Test {@link GcsObjectStorage#GcsObjectStorage(String, Properties)}.
   *
   * <ul>
   *   <li>Then exists {@code Storage Path} and {@code null} return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#GcsObjectStorage(String, Properties)}
   */
  @Test
  @DisplayName(
      "Test new GcsObjectStorage(String, Properties); then exists 'Storage Path' and 'null' return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GcsObjectStorage.<init>(String, Properties)"})
  void testNewGcsObjectStorage_thenExistsStoragePathAndNullReturnCompletableFuture() {
    // Arrange and Act
    GcsObjectStorage actualGcsObjectStorage = new GcsObjectStorage("Storage Key", new Properties());

    // Assert
    CompletionStage<Boolean> existsResult = actualGcsObjectStorage.exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Test {@link GcsObjectStorage#fsExistsCallback(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#fsExistsCallback(String, Throwable)}
   */
  @Test
  @DisplayName("Test fsExistsCallback(String, Throwable); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GcsObjectStorage.fsExistsCallback(String, Throwable)"})
  void testFsExistsCallback_thenReturnFalse() {
    // Arrange
    Builder builder = new Builder(1, "https://example.org/example", new HttpHeaders());

    Builder setContentResult = builder.setAttemptCount(3).setContent("https://example.org/example");
    HttpResponseException cause =
        setContentResult
            .setHeaders(new HttpHeaders())
            .setMessage("https://example.org/example")
            .setStatusCode(1)
            .setStatusMessage("https://example.org/example")
            .build();
    NotFoundException error = new NotFoundException(cause, HttpJsonStatusCode.of(1), true);

    // Act
    boolean actualFsExistsCallbackResult = gcsObjectStorage.fsExistsCallback("Storage Path", error);

    // Assert
    assertFalse(actualFsExistsCallbackResult);
  }

  /**
   * Test {@link GcsObjectStorage#fsExistsCallback(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#fsExistsCallback(String, Throwable)}
   */
  @Test
  @DisplayName("Test fsExistsCallback(String, Throwable); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GcsObjectStorage.fsExistsCallback(String, Throwable)"})
  void testFsExistsCallback_thenReturnTrue() {
    // Arrange
    GcsObjectStorage gcsObjectStorage = new GcsObjectStorage("Storage Key", new Properties());

    // Act and Assert
    assertTrue(gcsObjectStorage.fsExistsCallback("Storage Path", null));
  }

  /**
   * Test {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}.
   *
   * <ul>
   *   <li>When {@code /directory}.
   *   <li>Then return {@link CompletableFuture#get()} {@link FileStat#storagePath} is {@code
   *       /directory}.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test fsGetDirInfo(String, IExecutionContext); when '/directory'; then return get() storagePath is '/directory'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcsObjectStorage.fsGetDirInfo(String, IExecutionContext)"})
  void testFsGetDirInfo_whenDirectory_thenReturnGetStoragePathIsDirectory()
      throws InterruptedException, ExecutionException {
    // Arrange
    GcsObjectStorage gcsObjectStorage = new GcsObjectStorage("Storage Key", new Properties());

    // Act
    CompletionStage<FileStat> actualFsGetDirInfoResult =
        gcsObjectStorage.fsGetDirInfo("/directory", mock(IExecutionContext.class));

    // Assert
    assertTrue(actualFsGetDirInfoResult instanceof CompletableFuture);
    FileStat getResult = ((CompletableFuture<FileStat>) actualFsGetDirInfoResult).get();
    assertEquals("/directory", getResult.storagePath);
    assertEquals("directory", getResult.fileName);
    assertNull(getResult.atime);
    assertNull(getResult.mtime);
    assertEquals(0L, getResult.size);
    assertEquals(FileType.DIRECTORY, getResult.fileType);
    assertTrue(((CompletableFuture<FileStat>) actualFsGetDirInfoResult).isDone());
  }

  /**
   * Test {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link CompletableFuture#get()} {@link FileStat#fileName} is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test fsGetDirInfo(String, IExecutionContext); when empty string; then return get() fileName is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcsObjectStorage.fsGetDirInfo(String, IExecutionContext)"})
  void testFsGetDirInfo_whenEmptyString_thenReturnGetFileNameIsDot()
      throws InterruptedException, ExecutionException {
    // Arrange
    GcsObjectStorage gcsObjectStorage = new GcsObjectStorage("Storage Key", new Properties());

    // Act
    CompletionStage<FileStat> actualFsGetDirInfoResult =
        gcsObjectStorage.fsGetDirInfo("", mock(IExecutionContext.class));

    // Assert
    assertTrue(actualFsGetDirInfoResult instanceof CompletableFuture);
    FileStat getResult = ((CompletableFuture<FileStat>) actualFsGetDirInfoResult).get();
    assertEquals(".", getResult.fileName);
    assertEquals(".", getResult.storagePath);
    assertNull(getResult.atime);
    assertNull(getResult.mtime);
    assertEquals(0L, getResult.size);
    assertEquals(FileType.DIRECTORY, getResult.fileType);
    assertTrue(((CompletableFuture<FileStat>) actualFsGetDirInfoResult).isDone());
  }

  /**
   * Test {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@link CompletableFuture#get()} {@link FileStat#fileName} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link GcsObjectStorage#fsGetDirInfo(String, IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test fsGetDirInfo(String, IExecutionContext); when '/'; then return get() fileName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcsObjectStorage.fsGetDirInfo(String, IExecutionContext)"})
  void testFsGetDirInfo_whenSlash_thenReturnGetFileNameIsEmptyString()
      throws InterruptedException, ExecutionException {
    // Arrange
    GcsObjectStorage gcsObjectStorage = new GcsObjectStorage("Storage Key", new Properties());

    // Act
    CompletionStage<FileStat> actualFsGetDirInfoResult =
        gcsObjectStorage.fsGetDirInfo("/", mock(IExecutionContext.class));

    // Assert
    assertTrue(actualFsGetDirInfoResult instanceof CompletableFuture);
    FileStat getResult = ((CompletableFuture<FileStat>) actualFsGetDirInfoResult).get();
    assertEquals("", getResult.fileName);
    assertEquals("", getResult.storagePath);
    assertNull(getResult.atime);
    assertNull(getResult.mtime);
    assertEquals(0L, getResult.size);
    assertEquals(FileType.DIRECTORY, getResult.fileType);
    assertTrue(((CompletableFuture<FileStat>) actualFsGetDirInfoResult).isDone());
  }
}

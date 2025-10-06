package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GcsObjectStorageDiffblueTest {
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
}

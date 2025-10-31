package org.finos.tracdap.plugins.aws.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class S3ObjectStorageDiffblueTest {
  /**
   * Test {@link S3ObjectStorage#S3ObjectStorage(String, Properties)}.
   * <ul>
   *   <li>Then exists {@code Storage Path} and {@code null} return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link S3ObjectStorage#S3ObjectStorage(String, Properties)}
   */
  @Test
  @DisplayName("Test new S3ObjectStorage(String, Properties); then exists 'Storage Path' and 'null' return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void S3ObjectStorage.<init>(String, Properties)"})
  void testNewS3ObjectStorage_thenExistsStoragePathAndNullReturnCompletableFuture() {
    // Arrange, Act and Assert
    CompletionStage<Boolean> existsResult = (new S3ObjectStorage("Storage Key", new Properties()))
        .exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }
}

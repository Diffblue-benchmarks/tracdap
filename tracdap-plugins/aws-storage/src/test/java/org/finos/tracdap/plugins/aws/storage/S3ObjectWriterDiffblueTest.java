package org.finos.tracdap.plugins.aws.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.finos.tracdap.common.data.IDataContext;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.storage.StorageErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@ExtendWith(MockitoExtension.class)
class S3ObjectWriterDiffblueTest {
  @Mock private CompletableFuture<Long> completableFuture;

  @Mock private IDataContext iDataContext;

  @Mock private S3AsyncClient s3AsyncClient;

  @InjectMocks private S3ObjectWriter s3ObjectWriter;

  @Mock private StorageErrors storageErrors;

  /**
   * Test {@link S3ObjectWriter#onError(Throwable)}.
   *
   * <p>Method under test: {@link S3ObjectWriter#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onError(Throwable)"})
  void testOnError() {
    // Arrange
    when(completableFuture.completeExceptionally(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    when(storageErrors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> s3ObjectWriter.onError(new Throwable()));
    verify(completableFuture).completeExceptionally(isA(Throwable.class));
    verify(storageErrors).handleException(eq("WRITE"), isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link S3ObjectWriter#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link StorageErrors} {@link StorageErrors#handleException(String, String,
   *       Throwable)} throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link S3ObjectWriter#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given StorageErrors handleException(String, String, Throwable) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onError(Throwable)"})
  void testOnError_givenStorageErrorsHandleExceptionThrowIllegalStateException() {
    // Arrange
    when(storageErrors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> s3ObjectWriter.onError(new Throwable()));
    verify(storageErrors).handleException(eq("WRITE"), isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link S3ObjectWriter#onError(Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link CompletableFuture#completeExceptionally(Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link S3ObjectWriter#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); then calls completeExceptionally(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onError(Throwable)"})
  void testOnError_thenCallsCompleteExceptionally() {
    // Arrange
    when(completableFuture.completeExceptionally(Mockito.<Throwable>any())).thenReturn(true);
    when(storageErrors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());

    // Act
    s3ObjectWriter.onError(new Throwable());

    // Assert
    verify(completableFuture).completeExceptionally(isA(Throwable.class));
    verify(storageErrors).handleException(eq("WRITE"), isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link S3ObjectWriter#onComplete()}.
   *
   * <ul>
   *   <li>Given {@link StorageErrors} {@link StorageErrors#handleException(String, String,
   *       Throwable)} throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link S3ObjectWriter#onComplete()}
   */
  @Test
  @DisplayName(
      "Test onComplete(); given StorageErrors handleException(String, String, Throwable) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onComplete()"})
  void testOnComplete_givenStorageErrorsHandleExceptionThrowIllegalStateException() {
    // Arrange
    when(s3AsyncClient.putObject(Mockito.<PutObjectRequest>any(), Mockito.<AsyncRequestBody>any()))
        .thenReturn(new CompletableFuture<>());

    CompletableFuture<Object> completableFuture = new CompletableFuture<>();
    completableFuture.obtrudeException(new Throwable());
    when(iDataContext.toContext(Mockito.<CompletionStage<Object>>any()))
        .thenReturn(completableFuture);
    when(storageErrors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());

    // Act
    s3ObjectWriter.onComplete();

    // Assert
    verify(iDataContext).toContext(isA(CompletionStage.class));
    verify(storageErrors).handleException(eq("WRITE"), isNull(), isA(Throwable.class));
    verify(s3AsyncClient).putObject(isA(PutObjectRequest.class), isA(AsyncRequestBody.class));
  }

  /**
   * Test {@link S3ObjectWriter#onComplete()}.
   *
   * <ul>
   *   <li>Then calls {@link IDataContext#toContext(CompletionStage)}.
   * </ul>
   *
   * <p>Method under test: {@link S3ObjectWriter#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); then calls toContext(CompletionStage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onComplete()"})
  void testOnComplete_thenCallsToContext() {
    // Arrange
    when(s3AsyncClient.putObject(Mockito.<PutObjectRequest>any(), Mockito.<AsyncRequestBody>any()))
        .thenReturn(new CompletableFuture<>());
    when(iDataContext.toContext(Mockito.<CompletionStage<Object>>any()))
        .thenReturn(new CompletableFuture<>());

    // Act
    s3ObjectWriter.onComplete();

    // Assert
    verify(iDataContext).toContext(isA(CompletionStage.class));
    verify(s3AsyncClient).putObject(isA(PutObjectRequest.class), isA(AsyncRequestBody.class));
  }

  /**
   * Test {@link S3ObjectWriter#onComplete()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link S3ObjectWriter#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void S3ObjectWriter.onComplete()"})
  void testOnComplete_thenThrowIllegalStateException() {
    // Arrange
    when(s3AsyncClient.putObject(Mockito.<PutObjectRequest>any(), Mockito.<AsyncRequestBody>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> s3ObjectWriter.onComplete());
    verify(s3AsyncClient).putObject(isA(PutObjectRequest.class), isA(AsyncRequestBody.class));
  }
}

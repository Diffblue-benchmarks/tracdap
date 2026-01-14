package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CompletableFuture;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcUploadSourceDiffblueTest {
  /**
   * Test {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}.
   *
   * <p>Method under test: {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  @DisplayName("Test new GrpcUploadSource(Class, StreamObserver)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcUploadSource.<init>(Class, StreamObserver)"})
  void testNewGrpcUploadSource() {
    // Arrange
    Class<Object> requestClass = Object.class;
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> new GrpcUploadSource<>(requestClass, new ClientResponseStream<>(subscriber2)));
  }

  /**
   * Test {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  @DisplayName("Test new GrpcUploadSource(Class, StreamObserver); given EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcUploadSource.<init>(Class, StreamObserver)"})
  void testNewGrpcUploadSource_givenEUnexpected() {
    // Arrange
    Class<Object> requestClass = Object.class;

    ServerCallStreamObserver<Object> response = mock(ServerCallStreamObserver.class);
    doThrow(new EUnexpected()).when(response).disableAutoInboundFlowControl();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> new GrpcUploadSource<>(requestClass, response));
    verify(response).disableAutoInboundFlowControl();
  }

  /**
   * Test {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}.
   *
   * <ul>
   *   <li>Then firstMessage return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  @DisplayName(
      "Test new GrpcUploadSource(Class, StreamObserver); then firstMessage return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcUploadSource.<init>(Class, StreamObserver)"})
  void testNewGrpcUploadSource_thenFirstMessageReturnCompletableFuture() {
    // Arrange
    Class<Object> requestClass = Object.class;

    ServerCallStreamObserver<Object> response = mock(ServerCallStreamObserver.class);
    doNothing().when(response).disableAutoInboundFlowControl();
    doNothing().when(response).setOnCancelHandler(Mockito.<Runnable>any());

    // Act
    GrpcUploadSource<Object, Object> actualGrpcUploadSource =
        new GrpcUploadSource<>(requestClass, response);

    // Assert
    verify(response).disableAutoInboundFlowControl();
    verify(response).setOnCancelHandler(isA(Runnable.class));
    assertTrue(actualGrpcUploadSource.firstMessage() instanceof CompletableFuture);
  }
}

package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CompletableFuture;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcUploadSourceDiffblueTest {
  /**
   * Method under test:
   * {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  void testNewGrpcUploadSource() {
    // Arrange
    Class<Object> requestClass = Object.class;
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> new GrpcUploadSource<>(requestClass,
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

  }

  /**
   * Method under test:
   * {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  void testNewGrpcUploadSource2() {
    // Arrange
    Class<Object> requestClass = Object.class;
    ServerCallStreamObserver<Object> response = mock(ServerCallStreamObserver.class);
    doNothing().when(response).disableAutoInboundFlowControl();
    doNothing().when(response).setOnCancelHandler(Mockito.<Runnable>any());

    // Act
    GrpcUploadSource<Object, Object> actualGrpcUploadSource = new GrpcUploadSource<>(requestClass, response);

    // Assert
    verify(response).disableAutoInboundFlowControl();
    verify(response).setOnCancelHandler(isA(Runnable.class));
    assertTrue(actualGrpcUploadSource.firstMessage() instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link GrpcUploadSource#GrpcUploadSource(Class, StreamObserver)}
   */
  @Test
  void testNewGrpcUploadSource3() {
    // Arrange
    Class<Object> requestClass = Object.class;
    ServerCallStreamObserver<Object> response = mock(ServerCallStreamObserver.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(response).disableAutoInboundFlowControl();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> new GrpcUploadSource<>(requestClass, response));

    verify(response).disableAutoInboundFlowControl();
  }
}

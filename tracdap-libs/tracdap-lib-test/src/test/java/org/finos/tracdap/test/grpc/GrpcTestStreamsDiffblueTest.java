package org.finos.tracdap.test.grpc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientRequestStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResultHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcTestStreamsDiffblueTest {
  /**
   * Test {@link GrpcTestStreams#clientRequestStream(StreamObserver)}.
   * <p>
   * Method under test: {@link GrpcTestStreams#clientRequestStream(StreamObserver)}
   */
  @Test
  @DisplayName("Test clientRequestStream(StreamObserver)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Flow.Subscriber GrpcTestStreams.clientRequestStream(StreamObserver)"})
  void testClientRequestStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    Subscriber<Object> actualClientRequestStreamResult = GrpcTestStreams.clientRequestStream(
        new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    assertTrue(actualClientRequestStreamResult instanceof ClientRequestStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   * <p>
   * Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult = GrpcTestStreams
        .clientResponseStream(new ClientRequestStream<>(
            new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   * <ul>
   *   <li>Then return {@link ClientResponseStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber); then return ClientResponseStream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream_thenReturnClientResponseStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult = GrpcTestStreams
        .clientResponseStream(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseHandler(CompletableFuture)}.
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.</li>
   *   <li>Then return {@link ClientResultHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcTestStreams#clientResponseHandler(CompletableFuture)}
   */
  @Test
  @DisplayName("Test clientResponseHandler(CompletableFuture); when CompletableFuture(); then return ClientResultHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseHandler(CompletableFuture)"})
  void testClientResponseHandler_whenCompletableFuture_thenReturnClientResultHandler() {
    // Arrange and Act
    StreamObserver<Object> actualClientResponseHandlerResult = GrpcTestStreams
        .clientResponseHandler(new CompletableFuture<>());

    // Assert
    assertTrue(actualClientResponseHandlerResult instanceof ClientResultHandler);
  }

  /**
   * Test ClientResultHandler {@link ClientResultHandler#ClientResultHandler(CompletableFuture)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClientResultHandler#ClientResultHandler(CompletableFuture)}
   */
  @Test
  @DisplayName("Test ClientResultHandler new ClientResultHandler(CompletableFuture); given '42'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ClientResultHandler.<init>(CompletableFuture)"})
  void testClientResultHandlerNewClientResultHandler_given42_thenThrowEUnexpected() {
    // Arrange
    CompletableFuture<Object> result = new CompletableFuture<>();
    result.obtrudeValue("42");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> new ClientResultHandler<>(result));
  }

  /**
   * Test ClientResultHandler {@link ClientResultHandler#onCompleted()}.
   * <p>
   * Method under test: {@link ClientResultHandler#onCompleted()}
   */
  @Test
  @DisplayName("Test ClientResultHandler onCompleted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ClientResultHandler.onCompleted()"})
  void testClientResultHandlerOnCompleted() {
    // Arrange
    ClientResultHandler<Object> clientResultHandler = new ClientResultHandler<>(new CompletableFuture<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> clientResultHandler.onCompleted());
  }
}

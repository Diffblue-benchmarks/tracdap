package org.finos.tracdap.test.grpc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientRequestStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResultHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcTestStreamsDiffblueTest {
  /**
   * Test {@link GrpcTestStreams#clientRequestStream(StreamObserver)}.
   *
   * <p>Method under test: {@link GrpcTestStreams#clientRequestStream(StreamObserver)}
   */
  @Test
  @DisplayName("Test clientRequestStream(StreamObserver)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flow.Subscriber GrpcTestStreams.clientRequestStream(StreamObserver)"})
  void testClientRequestStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    Subscriber<Object> actualClientRequestStreamResult =
        GrpcTestStreams.clientRequestStream(new ClientResponseStream<>(subscriber2));

    // Assert
    assertTrue(actualClientRequestStreamResult instanceof ClientRequestStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(
            new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream2() {
    // Arrange
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    ClientRequestStream<Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));

    DelayedSubscriber<Object> subscriber4 = new DelayedSubscriber<>(subscriber3, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber4);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream3() {
    // Arrange
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    ClientRequestStream<Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));
    DelayedSubscriber<Object> subscriber4 =
        new DelayedSubscriber<>(subscriber3, new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber5 =
        new DelayedSubscriber<>(subscriber4, new CompletableFuture<>());
    ClientRequestStream<Object> subscriber6 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber5));

    DelayedSubscriber<Object> subscriber7 = new DelayedSubscriber<>(subscriber6, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber7);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream4() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ClientRequestStream<Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));
    subscriber3.onSubscribe(new Subscription());
    DelayedSubscriber<Object> subscriber4 =
        new DelayedSubscriber<>(subscriber3, new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber5 =
        new DelayedSubscriber<>(subscriber4, new CompletableFuture<>());
    ClientRequestStream<Object> subscriber6 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber5));

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<Object> subscriber7 = new DelayedSubscriber<>(subscriber6, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber7);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link ClientResponseStream.Subscription} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber); given Subscription (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream_givenSubscription() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ClientRequestStream<Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));
    subscriber3.onSubscribe(new Subscription());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<Object> subscriber4 = new DelayedSubscriber<>(subscriber3, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber4);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <ul>
   *   <li>Then return {@link ClientResponseStream}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test clientResponseStream(Subscriber); then return ClientResponseStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream_thenReturnClientResponseStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber2);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link ClientResultHandler#ClientResultHandler(CompletableFuture)} with result is
   *       {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test clientResponseStream(Subscriber); when ClientResultHandler(CompletableFuture) with result is CompletableFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream_whenClientResultHandlerWithResultIsCompletableFuture() {
    // Arrange
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    ClientRequestStream<Object> subscriber =
        new ClientRequestStream<>(new ClientResultHandler<>(new CompletableFuture<>()));

    DelayedSubscriber<Object> subscriber2 = new DelayedSubscriber<>(subscriber, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber2);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseStream(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link FutureFirstItemSubscriber#FutureFirstItemSubscriber(CompletableFuture)} with
   *       firstFuture is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test clientResponseStream(Subscriber); when FutureFirstItemSubscriber(CompletableFuture) with firstFuture is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseStream(Flow.Subscriber)"})
  void testClientResponseStream_whenFutureFirstItemSubscriberWithFirstFutureIsNull() {
    // Arrange
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(null);
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    ClientRequestStream<Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));

    DelayedSubscriber<Object> subscriber4 = new DelayedSubscriber<>(subscriber3, signal);

    // Act
    StreamObserver<Object> actualClientResponseStreamResult =
        GrpcTestStreams.clientResponseStream(subscriber4);

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof ClientResponseStream);
  }

  /**
   * Test {@link GrpcTestStreams#clientResponseHandler(CompletableFuture)}.
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   *   <li>Then return {@link ClientResultHandler}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcTestStreams#clientResponseHandler(CompletableFuture)}
   */
  @Test
  @DisplayName(
      "Test clientResponseHandler(CompletableFuture); when CompletableFuture(); then return ClientResultHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamObserver GrpcTestStreams.clientResponseHandler(CompletableFuture)"})
  void testClientResponseHandler_whenCompletableFuture_thenReturnClientResultHandler() {
    // Arrange and Act
    StreamObserver<Object> actualClientResponseHandlerResult =
        GrpcTestStreams.clientResponseHandler(new CompletableFuture<>());

    // Assert
    assertTrue(actualClientResponseHandlerResult instanceof ClientResultHandler);
  }
}

package org.finos.tracdap.test.grpc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import io.grpc.stub.StreamObserver;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.async.flow.HubProcessor;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcTestStreamsDiffblueTest {
  /**
   * Method under test:
   * {@link GrpcTestStreams#clientRequestStream(StreamObserver)}
   */
  @Test
  void testClientRequestStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    Flow.Subscriber<Object> actualClientRequestStreamResult = GrpcTestStreams.clientRequestStream(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    assertTrue(actualClientRequestStreamResult instanceof GrpcTestStreams.ClientRequestStream);
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams#clientRequestStream(StreamObserver)}
   */
  @Test
  void testClientRequestStream2() {
    // Arrange
    HubProcessor<Object> subscriber = new HubProcessor<>(new DefaultEventLoop(), mock(Consumer.class));

    // Act
    Flow.Subscriber<Object> actualClientRequestStreamResult = GrpcTestStreams.clientRequestStream(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    assertTrue(actualClientRequestStreamResult instanceof GrpcTestStreams.ClientRequestStream);
  }

  /**
   * Method under test: {@link GrpcTestStreams.ClientRequestStream#onComplete()}
   */
  @Test
  void testClientRequestStreamOnComplete() {
    // Arrange
    DelayedSubscriber<Object> subscriber = mock(DelayedSubscriber.class);
    doNothing().when(subscriber).onComplete();
    doNothing().when(subscriber).onSubscribe(Mockito.<Flow.Subscription>any());
    GrpcTestStreams.ClientRequestStream<Object> clientRequestStream = new GrpcTestStreams.ClientRequestStream<>(
        new GrpcTestStreams.ClientResponseStream<>(subscriber));

    // Act
    clientRequestStream.onComplete();

    // Assert
    verify(subscriber).onComplete();
    verify(subscriber).onSubscribe(isA(Flow.Subscription.class));
  }

  /**
   * Method under test: {@link GrpcTestStreams.ClientRequestStream#onNext(Object)}
   */
  @Test
  void testClientRequestStreamOnNext() {
    // Arrange
    DelayedSubscriber<Object> subscriber = mock(DelayedSubscriber.class);
    doNothing().when(subscriber).onNext(Mockito.<Object>any());
    doNothing().when(subscriber).onSubscribe(Mockito.<Flow.Subscription>any());

    GrpcTestStreams.ClientRequestStream<Object> clientRequestStream = new GrpcTestStreams.ClientRequestStream<>(
        new GrpcTestStreams.ClientResponseStream<>(subscriber));
    clientRequestStream.onSubscribe(new GrpcTestStreams.ClientResponseStream.Subscription());

    // Act
    clientRequestStream.onNext("Item");

    // Assert that nothing has changed
    verify(subscriber).onNext(isA(Object.class));
    verify(subscriber).onSubscribe(isA(Flow.Subscription.class));
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  void testClientResponseStream() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult = GrpcTestStreams
        .clientResponseStream(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof GrpcTestStreams.ClientResponseStream);
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  void testClientResponseStream2() {
    // Arrange
    HubProcessor<Object> subscriber = new HubProcessor<>(new DefaultEventLoop(), mock(Consumer.class));

    // Act
    StreamObserver<Object> actualClientResponseStreamResult = GrpcTestStreams
        .clientResponseStream(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof GrpcTestStreams.ClientResponseStream);
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams#clientResponseStream(Flow.Subscriber)}
   */
  @Test
  void testClientResponseStream3() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    StreamObserver<Object> actualClientResponseStreamResult = GrpcTestStreams
        .clientResponseStream(new GrpcTestStreams.ClientRequestStream<>(new GrpcTestStreams.ClientResponseStream<>(
            new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

    // Assert
    assertTrue(actualClientResponseStreamResult instanceof GrpcTestStreams.ClientResponseStream);
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams#clientResponseHandler(CompletableFuture)}
   */
  @Test
  void testClientResponseHandler() {
    // Arrange and Act
    StreamObserver<Object> actualClientResponseHandlerResult = GrpcTestStreams
        .clientResponseHandler(new CompletableFuture<>());

    // Assert
    assertTrue(actualClientResponseHandlerResult instanceof GrpcTestStreams.ClientResultHandler);
  }

  /**
   * Method under test: {@link GrpcTestStreams.ClientResponseStream#onCompleted()}
   */
  @Test
  void testClientResponseStreamOnCompleted() {
    // Arrange
    GrpcTestStreams.ClientRequestStream<Object> subscriber = mock(GrpcTestStreams.ClientRequestStream.class);
    doNothing().when(subscriber).onComplete();
    GrpcTestStreams.ClientResponseStream<Object> clientResponseStream = new GrpcTestStreams.ClientResponseStream<>(
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    clientResponseStream.onCompleted();

    // Assert
    verify(subscriber).onComplete();
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams.ClientResponseStream#onNext(Object)}
   */
  @Test
  void testClientResponseStreamOnNext() {
    // Arrange
    GrpcTestStreams.ClientRequestStream<Object> subscriber = mock(GrpcTestStreams.ClientRequestStream.class);
    doNothing().when(subscriber).onNext(Mockito.<Object>any());
    GrpcTestStreams.ClientResponseStream<Object> clientResponseStream = new GrpcTestStreams.ClientResponseStream<>(
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    clientResponseStream.onNext("Value");

    // Assert that nothing has changed
    verify(subscriber).onNext(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams.ClientResponseStream#onNext(Object)}
   */
  @Test
  void testClientResponseStreamOnNext2() {
    // Arrange
    GrpcTestStreams.ClientRequestStream<Object> subscriber = mock(GrpcTestStreams.ClientRequestStream.class);
    doNothing().when(subscriber).onNext(Mockito.<Object>any());
    GrpcTestStreams.ClientResponseStream<Object> clientResponseStream = new GrpcTestStreams.ClientResponseStream<>(
        new GrpcTestStreams.ClientRequestStream<>(new GrpcTestStreams.ClientResponseStream<>(
            new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

    // Act
    clientResponseStream.onNext("Value");

    // Assert that nothing has changed
    verify(subscriber).onNext(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link GrpcTestStreams.ClientResultHandler#ClientResultHandler(CompletableFuture)}
   */
  @Test
  void testClientResultHandlerNewClientResultHandler() {
    // Arrange
    CompletableFuture<Object> result = new CompletableFuture<>();
    result.obtrudeValue("42");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> new GrpcTestStreams.ClientResultHandler<>(result));
  }

  /**
   * Method under test: {@link GrpcTestStreams.ClientResultHandler#onCompleted()}
   */
  @Test
  void testClientResultHandlerOnCompleted() {
    // Arrange
    GrpcTestStreams.ClientResultHandler<Object> clientResultHandler = new GrpcTestStreams.ClientResultHandler<>(
        new CompletableFuture<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> clientResultHandler.onCompleted());
  }
}

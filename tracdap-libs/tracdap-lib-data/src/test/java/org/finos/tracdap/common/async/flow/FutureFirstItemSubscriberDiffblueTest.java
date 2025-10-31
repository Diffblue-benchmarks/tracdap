package org.finos.tracdap.common.async.flow;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.junit.jupiter.api.Test;

class FutureFirstItemSubscriberDiffblueTest {
  /**
   * Method under test:
   * {@link FutureFirstItemSubscriber#onSubscribe(Flow.Subscription)}
   */
  @Test
  void testOnSubscribe() {
    // Arrange
    FutureFirstItemSubscriber<Object> futureFirstItemSubscriber = new FutureFirstItemSubscriber<>(
        new CompletableFuture<>());
    GrpcTestStreams.ClientResponseStream.Subscription subscription = mock(
        GrpcTestStreams.ClientResponseStream.Subscription.class);
    doNothing().when(subscription).request(anyLong());

    // Act
    futureFirstItemSubscriber.onSubscribe(subscription);

    // Assert
    verify(subscription).request(eq(1L));
  }

  /**
   * Method under test: {@link FutureFirstItemSubscriber#onNext(Object)}
   */
  @Test
  void testOnNext() {
    // Arrange
    GrpcTestStreams.ClientResponseStream.Subscription subscription = mock(
        GrpcTestStreams.ClientResponseStream.Subscription.class);
    doNothing().when(subscription).cancel();
    doNothing().when(subscription).request(anyLong());

    FutureFirstItemSubscriber<Object> futureFirstItemSubscriber = new FutureFirstItemSubscriber<>(
        new CompletableFuture<>());
    futureFirstItemSubscriber.onSubscribe(subscription);

    // Act
    futureFirstItemSubscriber.onNext("Item");

    // Assert that nothing has changed
    verify(subscription).cancel();
    verify(subscription).request(eq(1L));
  }

  /**
   * Method under test: {@link FutureFirstItemSubscriber#onComplete()}
   */
  @Test
  void testOnComplete() {
    // Arrange
    GrpcTestStreams.ClientResponseStream.Subscription subscription = mock(
        GrpcTestStreams.ClientResponseStream.Subscription.class);
    doNothing().when(subscription).request(anyLong());

    FutureFirstItemSubscriber<Object> futureFirstItemSubscriber = new FutureFirstItemSubscriber<>(
        new CompletableFuture<>());
    futureFirstItemSubscriber.onSubscribe(subscription);

    // Act
    futureFirstItemSubscriber.onComplete();

    // Assert that nothing has changed
    verify(subscription).request(eq(1L));
  }
}

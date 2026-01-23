package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HubProcessorDiffblueTest {
  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link HubProcessor#HubProcessor(OrderedEventExecutor)} with eventLoop is {@link
   *       DefaultEventExecutor#DefaultEventExecutor()}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given HubProcessor(OrderedEventExecutor) with eventLoop is DefaultEventExecutor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenHubProcessorWithEventLoopIsDefaultEventExecutor() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventExecutor());

    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, signal);

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber2));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link Runnable}.
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given Runnable; when DefaultEventLoop() addShutdownHook Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenRunnable_whenDefaultEventLoopAddShutdownHookRunnable() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, signal);

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber2));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link Thread#Thread(Runnable, String)} with {@link Runnable} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given Thread(Runnable, String) with Runnable and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenThreadWithRunnableAndName() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventExecutor());

    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(new Thread(mock(Runnable.class), "Name"));
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, signal);

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber2));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeException {@link
   *       Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given Throwable(); when CompletableFuture() obtrudeException Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenThrowable_whenCompletableFutureObtrudeExceptionThrowable() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> subscriber =
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal);

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>When {@link HubProcessor#HubProcessor(OrderedEventExecutor)} with eventLoop is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given Throwable(); when HubProcessor(OrderedEventExecutor) with eventLoop is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenThrowable_whenHubProcessorWithEventLoopIsNull() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> subscriber =
        new DelayedSubscriber<>(new HubProcessor<>(null), signal);

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_thenThrowIllegalStateException() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> hubProcessor.subscribe(new HubProcessor<>(new DefaultEventLoop())));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link FutureFirstItemSubscriber#FutureFirstItemSubscriber(CompletableFuture)} with
   *       firstFuture is {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); when FutureFirstItemSubscriber(CompletableFuture) with firstFuture is CompletableFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_whenFutureFirstItemSubscriberWithFirstFutureIsCompletableFuture() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertDoesNotThrow(() -> hubProcessor.subscribe(subscriber2));
  }

  /**
   * Test {@link HubProcessor#onSubscribe(Subscription)}.
   *
   * <p>Method under test: {@link HubProcessor#onSubscribe(java.util.concurrent.Flow.Subscription)}
   */
  @Test
  @DisplayName("Test onSubscribe(Subscription)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.onSubscribe(java.util.concurrent.Flow.Subscription)"})
  void testOnSubscribe() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> hubProcessor.onSubscribe(new Subscription()));
  }
}

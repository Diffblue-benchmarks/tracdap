package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.Function;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapProcessorDiffblueTest {
  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe() {
    // Arrange
    MapProcessor<Object, Object> mapProcessor =
        new MapProcessor<>(mock(Function.class), (Publisher<Object>) null);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    mapProcessor.subscribe(subscriber2);
    mapProcessor.onError(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber3 =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber4 =
        new DelayedSubscriber<>(subscriber3, new CompletableFuture<>());

    // Act and Assert
    assertDoesNotThrow(() -> mapProcessor.subscribe(subscriber4));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe2() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mapping, target);
    FutureFirstItemSubscriber<? super Object> subscriber2 =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());

    // Act and Assert
    assertDoesNotThrow(() -> mapProcessor.subscribe(subscriber3));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe3() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe4() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    mapProcessor.subscribe(subscriber2);
    mapProcessor.onError(new Throwable());
    MapProcessor<? super Object, Object> subscriber3 =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber4 =
        new DelayedSubscriber<>(subscriber3, new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(subscriber4);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe5() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping, target);

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link
   *       Function} and source is {@link Publisher}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenMapProcessorWithMappingIsFunctionAndSourceIsPublisher() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link
   *       Function} and source is {@link Publisher}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenMapProcessorWithMappingIsFunctionAndSourceIsPublisher2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping, target);

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeException {@link
   *       Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given Throwable(); when CompletableFuture() obtrudeException Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenThrowable_whenCompletableFutureObtrudeExceptionThrowable() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    DelayedSubscriber<? super Object> target = new DelayedSubscriber<>(subscriber, signal);
    MapProcessor<? super Object, Object> subscriber2 =
        new MapProcessor<>(mock(Function.class), target);

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_thenThrowIllegalStateException() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doThrow(new IllegalStateException()).when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mapProcessor.subscribe(subscriber2));
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link
   *       Function} and source is {@link Publisher}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); when MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndSourceIsPublisher() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    // Act
    mapProcessor.subscribe(subscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link
   *       Function} and source is {@link Publisher}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); when MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndSourceIsPublisher2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    // Act
    mapProcessor.subscribe(subscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Subscriber)} with mapping is {@link
   *       Function} and target is {@link DelayedSubscriber#DelayedSubscriber(Subscriber,
   *       CompletionStage)}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); when MapProcessor(Function, Subscriber) with mapping is Function and target is DelayedSubscriber(Subscriber, CompletionStage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndTargetIsDelayedSubscriber() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping, target);

    // Act
    mapProcessor.subscribe(subscriber2);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onNext(Object)}.
   *
   * <p>Method under test: {@link MapProcessor#onNext(Object)}
   */
  @Test
  @DisplayName("Test onNext(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onNext(Object)"})
  void testOnNext() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");

    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new Subscription());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mapping, source);
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onNext("Item");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link MapProcessor#onNext(Object)}.
   *
   * <p>Method under test: {@link MapProcessor#onNext(Object)}
   */
  @Test
  @DisplayName("Test onNext(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onNext(Object)"})
  void testOnNext2() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");

    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    Function<Object, Object> mapping2 = mock(Function.class);
    when(mapping2.apply(Mockito.<Object>any())).thenReturn("Apply");
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping2, target);

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mapping, source);
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onNext("Item");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    verify(mapping).apply(isA(Object.class));
    verify(mapping2).apply(isA(Object.class));
  }

  /**
   * Test {@link MapProcessor#onNext(Object)}.
   *
   * <p>Method under test: {@link MapProcessor#onNext(Object)}
   */
  @Test
  @DisplayName("Test onNext(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onNext(Object)"})
  void testOnNext3() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");

    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    Function<Object, Object> mapping2 = mock(Function.class);
    when(mapping2.apply(Mockito.<Object>any())).thenThrow(new IllegalStateException());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping2, target);

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mapping, source);
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onNext("Item");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    verify(mapping).apply(isA(Object.class));
    verify(mapping2).apply(isA(Object.class));
  }

  /**
   * Test {@link MapProcessor#onError(Throwable)}.
   *
   * <p>Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onError(Throwable)"})
  void testOnError() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onError(new Throwable());

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link FutureFirstItemSubscriber#FutureFirstItemSubscriber(CompletableFuture)} with
   *       firstFuture is {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given FutureFirstItemSubscriber(CompletableFuture) with firstFuture is CompletableFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onError(Throwable)"})
  void testOnError_givenFutureFirstItemSubscriberWithFirstFutureIsCompletableFuture() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onError(new Throwable());

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onComplete()}.
   *
   * <p>Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onComplete()"})
  void testOnComplete() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onComplete();

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onComplete()}.
   *
   * <p>Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapProcessor.onComplete()"})
  void testOnComplete2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    MapProcessor<? super Object, Object> subscriber2 = new MapProcessor<>(mapping, target);
    mapProcessor.subscribe(subscriber2);

    // Act
    mapProcessor.onComplete();

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }
}

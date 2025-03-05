package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapProcessorDiffblueTest {
  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>Given {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link Function} and source is {@link Publisher}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); given MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenMapProcessorWithMappingIsFunctionAndSourceIsPublisher() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>Given {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link Function} and source is {@link Publisher}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); given MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenMapProcessorWithMappingIsFunctionAndSourceIsPublisher2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>When {@link CompletableFuture#CompletableFuture()} obtrudeException {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); given Throwable(); when CompletableFuture() obtrudeException Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_givenThrowable_whenCompletableFutureObtrudeExceptionThrowable() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class),
        new DelayedSubscriber<>(new MapProcessor<>(mock(Function.class), mock(Publisher.class)), signal)));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_thenThrowIllegalStateException() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doThrow(new IllegalStateException("foo")).when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link Function} and source is {@link Publisher}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); when MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndSourceIsPublisher() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class), mock(Publisher.class)));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Publisher)} with mapping is {@link Function} and source is {@link Publisher}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); when MapProcessor(Function, Publisher) with mapping is Function and source is Publisher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndSourceIsPublisher2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class), mock(Publisher.class)));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#subscribe(Subscriber)}.
   * <ul>
   *   <li>When {@link MapProcessor#MapProcessor(Function, Subscriber)} with mapping is {@link Function} and target is {@link DelayedSubscriber#DelayedSubscriber(Subscriber, CompletionStage)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); when MapProcessor(Function, Subscriber) with mapping is Function and target is DelayedSubscriber(Subscriber, CompletionStage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.subscribe(Flow.Subscriber)"})
  void testSubscribe_whenMapProcessorWithMappingIsFunctionAndTargetIsDelayedSubscriber() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onError(Throwable)}.
   * <p>
   * Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.onError(Throwable)"})
  void testOnError() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onError(new Throwable());

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link FutureFirstItemSubscriber#FutureFirstItemSubscriber(CompletableFuture)} with firstFuture is {@link CompletableFuture#CompletableFuture()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given FutureFirstItemSubscriber(CompletableFuture) with firstFuture is CompletableFuture()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.onError(Throwable)"})
  void testOnError_givenFutureFirstItemSubscriberWithFirstFutureIsCompletableFuture() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onError(new Throwable());

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onComplete()}.
   * <p>
   * Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.onComplete()"})
  void testOnComplete() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onComplete();

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link MapProcessor#onComplete()}.
   * <p>
   * Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapProcessor.onComplete()"})
  void testOnComplete2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    mapProcessor.onComplete();

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
  }
}

package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapProcessorDiffblueTest {
  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe2() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class), mock(Flow.Publisher.class)));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe3() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe4() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe5() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doThrow(new IllegalStateException("foo")).when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());
    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe6() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class), mock(Flow.Publisher.class)));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe7() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe8() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());
    Function<Object, Object> mapping = mock(Function.class);
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class),
        mock(Flow.Publisher.class));

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#subscribe(Flow.Subscriber)}
   */
  @Test
  void testSubscribe9() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    mapProcessor.onError(new Throwable());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    // Act
    mapProcessor.subscribe(new MapProcessor<>(mock(Function.class),
        new DelayedSubscriber<>(new MapProcessor<>(mock(Function.class), mock(Flow.Publisher.class)), signal)));

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  void testOnError() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onError(new Throwable());

    // Assert that nothing has changed
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#onError(Throwable)}
   */
  @Test
  void testOnError2() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class),
        mock(Flow.Publisher.class));

    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onError(new Throwable());

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  void testOnComplete() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Act
    mapProcessor.onComplete();

    // Assert that nothing has changed
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }

  /**
   * Method under test: {@link MapProcessor#onComplete()}
   */
  @Test
  void testOnComplete2() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    MapProcessor<Object, Object> mapProcessor = new MapProcessor<>(mock(Function.class), source);
    Function<Object, Object> mapping = mock(Function.class);
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    mapProcessor.subscribe(new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    mapProcessor.onComplete();

    // Assert that nothing has changed
    verify(source).subscribe(isA(Flow.Subscriber.class));
  }
}

package org.finos.tracdap.common.async;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.OrderedEventExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ThreadFactory;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.finos.tracdap.common.async.flow.DelayedPublisher;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.async.flow.HubProcessor;
import org.finos.tracdap.common.async.flow.MapProcessor;
import org.finos.tracdap.common.async.flow.SourcePublisher;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientRequestStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowsDiffblueTest {
  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName(
      "Test publish(List) with 'List'; given '42'; when ArrayList() add '42'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_given42_whenArrayListAdd42_thenCallsNewThread() {
    // Arrange
    ArrayList<Object> source = new ArrayList<>();
    source.add("42");

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoop = new DefaultEventExecutor(threadFactory);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName(
      "Test publish(List) with 'List'; given '42'; when ArrayList() add '42'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_given42_whenArrayListAdd42_thenCallsNewThread2() {
    // Arrange
    ArrayList<Object> source = new ArrayList<>();
    source.add("42");
    source.add("42");

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoop = new DefaultEventExecutor(threadFactory);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName(
      "Test publish(List) with 'List'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_given42_whenArrayListAdd42_thenReturnSourcePublisher() {
    // Arrange
    ArrayList<Object> source = new ArrayList<>();
    source.add("42");

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventExecutor());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName(
      "Test publish(List) with 'List'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_given42_whenArrayListAdd42_thenReturnSourcePublisher2() {
    // Arrange
    ArrayList<Object> source = new ArrayList<>();
    source.add("42");

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName(
      "Test publish(List) with 'List'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_given42_whenArrayListAdd42_thenReturnSourcePublisher3() {
    // Arrange
    ArrayList<Object> source = new ArrayList<>();
    source.add("42");

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher2() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    actualPublishResult.subscribe(new FutureFirstItemSubscriber<>(new CompletableFuture<>()));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher3() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher4() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>()), signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher5() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher6() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher7() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher8() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(null), signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher9() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber2, signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(List)}
   */
  @Test
  @DisplayName("Test publish(List) with 'List'; when ArrayList(); then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(List)"})
  void testPublishWithList_whenArrayList_thenReturnSourcePublisher10() {
    // Arrange and Act
    Publisher<Object> actualPublishResult = Flows.publish(new ArrayList<>());
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenCallsAccept() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    Consumer<Object> releaseFunc = mock(Consumer.class);
    doNothing().when(releaseFunc).accept(Mockito.<Object>any());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop, releaseFunc);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(releaseFunc).accept(isA(Object.class));
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenCallsAccept2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    Consumer<Object> releaseFunc = mock(Consumer.class);
    doNothing().when(releaseFunc).accept(Mockito.<Object>any());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop, releaseFunc);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
    verify(releaseFunc, atLeast(1)).accept(isA(Object.class));
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenCallsNewThread() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoop = new DefaultEventExecutor(threadFactory);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenCallsNewThread2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor eventLoop = new DefaultEventExecutor(threadFactory);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenReturnSourcePublisher() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventExecutor());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenReturnSourcePublisher2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenReturnSourcePublisher3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> subscriber =
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal);
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; given '42'; when ArrayList() add '42'; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_given42_whenArrayListAdd42_thenReturnSourcePublisher4() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new IllegalStateException());
    DelayedSubscriber<? super Object> subscriber =
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal);
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    actualPublishResult.subscribe(new FutureFirstItemSubscriber<>(new CompletableFuture<>()));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher4() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>()), signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher5() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher6() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher7() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher8() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(null), signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher9() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber2, signal);
    actualPublishResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#publish(Stream)} with {@code Stream}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.
   *   <li>Then return {@link SourcePublisher}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#publish(Stream)}
   */
  @Test
  @DisplayName(
      "Test publish(Stream) with 'Stream'; when ArrayList() stream; then return SourcePublisher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.publish(Stream)"})
  void testPublishWithStream_whenArrayListStream_thenReturnSourcePublisher10() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> source = objectList.stream();

    // Act
    Publisher<Object> actualPublishResult = Flows.publish(source);
    MapProcessor<? super Object, Object> subscriber =
        new MapProcessor<>(mock(Function.class), mock(Publisher.class));
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    actualPublishResult.subscribe(
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber3)));

    // Assert
    assertTrue(actualPublishResult instanceof SourcePublisher);
  }

  /**
   * Test {@link Flows#waitForSignal(Publisher, CompletionStage)} with {@code Publisher}, {@code
   * CompletionStage}.
   *
   * <ul>
   *   <li>When {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#waitForSignal(Publisher, CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test waitForSignal(Publisher, CompletionStage) with 'Publisher', 'CompletionStage'; when CompletableFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.waitForSignal(Publisher, CompletionStage)"})
  void testWaitForSignalWithPublisherCompletionStage_whenCompletableFuture() {
    // Arrange
    Publisher<Object> target = mock(Publisher.class);

    // Act
    Publisher<Object> actualWaitForSignalResult =
        Flows.waitForSignal(target, new CompletableFuture<>());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualWaitForSignalResult.subscribe(delayedSubscriber);

    // Assert
    assertTrue(actualWaitForSignalResult instanceof DelayedPublisher);
  }

  /**
   * Test {@link Flows#waitForSignal(Subscriber, CompletionStage)} with {@code Subscriber}, {@code
   * CompletionStage}.
   *
   * <p>Method under test: {@link Flows#waitForSignal(Subscriber, CompletionStage)}
   */
  @Test
  @DisplayName(
      "Test waitForSignal(Subscriber, CompletionStage) with 'Subscriber', 'CompletionStage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Subscriber Flows.waitForSignal(Subscriber, CompletionStage)"})
  void testWaitForSignalWithSubscriberCompletionStage() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    Subscriber<Object> actualWaitForSignalResult =
        Flows.waitForSignal(target, new CompletableFuture<>());

    // Assert
    assertTrue(actualWaitForSignalResult instanceof DelayedSubscriber);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>()), signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe3() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(null), signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe4() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber2, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe5() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe6() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    ClientRequestStream<? super Object> subscriber3 =
        new ClientRequestStream<>(new ClientResponseStream<>(subscriber2));
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber3, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe7() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(null);
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber2, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe8() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<? super Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber3, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe9() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   *   <li>Then calls {@link Publisher#subscribe(Subscriber)}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher subscribe(Subscriber) does nothing; then calls subscribe(Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisherSubscribeDoesNothing_thenCallsSubscribe10() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    Publisher<Object> actualMapResult = Flows.map(source, mock(Function.class));
    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    DelayedSubscriber<? super Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<? super Object> delayedSubscriber =
        new DelayedSubscriber<>(subscriber2, signal);
    actualMapResult.subscribe(delayedSubscriber);

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Publisher, Function)} with {@code source}, {@code mapping}.
   *
   * <ul>
   *   <li>When {@link Publisher}.
   *   <li>Then return {@link MapProcessor}.
   * </ul>
   *
   * <p>Method under test: {@link Flows#map(Publisher, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Publisher, Function) with 'source', 'mapping'; when Publisher; then return MapProcessor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Publisher Flows.map(Publisher, Function)"})
  void testMapWithSourceMapping_whenPublisher_thenReturnMapProcessor() {
    // Arrange and Act
    Publisher<Object> actualMapResult = Flows.map(mock(Publisher.class), mock(Function.class));

    // Assert
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#map(Subscriber, Function)} with {@code target}, {@code mapping}.
   *
   * <p>Method under test: {@link Flows#map(Subscriber, Function)}
   */
  @Test
  @DisplayName("Test map(Subscriber, Function) with 'target', 'mapping'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Subscriber Flows.map(Subscriber, Function)"})
  void testMapWithTargetMapping() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> target =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    Subscriber<Object> actualMapResult = Flows.map(target, mock(Function.class));

    // Assert
    assertTrue(actualMapResult instanceof MapProcessor);
  }

  /**
   * Test {@link Flows#fold(Publisher, BiFunction, Object)}.
   *
   * <p>Method under test: {@link Flows#fold(Publisher, BiFunction, Object)}
   */
  @Test
  @DisplayName("Test fold(Publisher, BiFunction, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage Flows.fold(Publisher, BiFunction, Object)"})
  void testFold() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFoldResult = Flows.fold(source, mock(BiFunction.class), "Acc");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualFoldResult instanceof CompletableFuture);
  }

  /**
   * Test {@link Flows#hub(OrderedEventExecutor)}.
   *
   * <p>Method under test: {@link Flows#hub(OrderedEventExecutor)}
   */
  @Test
  @DisplayName("Test hub(OrderedEventExecutor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Processor Flows.hub(OrderedEventExecutor)"})
  void testHub() {
    // Arrange and Act
    Processor<Object, Object> actualHubResult = Flows.hub(new DefaultEventLoop());

    // Assert
    assertTrue(actualHubResult instanceof HubProcessor);
  }

  /**
   * Test {@link Flows#first(Publisher)}.
   *
   * <p>Method under test: {@link Flows#first(Publisher)}
   */
  @Test
  @DisplayName("Test first(Publisher)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage Flows.first(Publisher)"})
  void testFirst() {
    // Arrange
    Publisher<Object> publisher = mock(Publisher.class);
    doNothing().when(publisher).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFirstResult = Flows.first(publisher);

    // Assert
    verify(publisher).subscribe(isA(Subscriber.class));
    assertTrue(actualFirstResult instanceof CompletableFuture);
  }
}

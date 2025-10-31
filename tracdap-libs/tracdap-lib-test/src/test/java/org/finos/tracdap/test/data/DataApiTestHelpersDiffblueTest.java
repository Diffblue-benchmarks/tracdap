package org.finos.tracdap.test.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.stub.StreamObserver;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultEventExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.ThreadFactory;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.async.flow.HubProcessor;
import org.finos.tracdap.common.async.flow.MapProcessor;
import org.finos.tracdap.common.async.flow.ReduceProcessor;
import org.finos.tracdap.common.data.IExecutionContext;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataApiTestHelpersDiffblueTest {
  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>()));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming2() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new FutureFirstItemSubscriber<>(new CompletableFuture<>()));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming3() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", new GrpcTestStreams.ClientRequestStream<>(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming4() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>()), signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming5() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException("foo")).when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming6() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(null), signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming7() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()), signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming8() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Flow.Subscriber)}
   */
  @Test
  void testServerStreaming9() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request",
        new DelayedSubscriber<>(new GrpcTestStreams.ClientRequestStream<>(
            new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))),
            signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreaming10() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult = DataApiTestHelpers.serverStreaming(grpcMethod,
        "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreaming11() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException("foo")).when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreaming12() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new EUnexpected()).when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard2() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException("foo")).when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard3() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard4() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod, 1,
        execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard5() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        defaultEventExecutor, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard6() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();

    DefaultEventLoop defaultEventLoop2 = new DefaultEventLoop();
    defaultEventLoop2.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop2);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        defaultEventLoop, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard7() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();
    defaultEventExecutor.addShutdownHook(mock(Runnable.class));
    defaultEventExecutor.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        defaultEventExecutor, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard8() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();

    DefaultEventExecutor defaultEventExecutor2 = new DefaultEventExecutor();
    defaultEventExecutor2.addShutdownHook(mock(Runnable.class));
    defaultEventExecutor2.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventExecutor2);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        defaultEventExecutor, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  void testServerStreamingDiscard9() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop(new NioEventLoopGroup(mock(ThreadFactory.class)),
        mock(Executor.class));

    DefaultEventLoop defaultEventLoop2 = new DefaultEventLoop();
    defaultEventLoop2.addShutdownHook(mock(Runnable.class));
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop2);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult = DataApiTestHelpers.serverStreamingDiscard(grpcMethod,
        defaultEventLoop, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming2() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new GrpcTestStreams.ClientResponseStream.Subscription());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming3() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(
        new GrpcTestStreams.ClientResponseStream<>(new DelayedSubscriber<>(subscriber2, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming4() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(
        new GrpcTestStreams.ClientResponseStream<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming5() {
    // Arrange
    BiFunction<Object, Object, Object> func = mock(BiFunction.class);
    when(func.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(
        new GrpcTestStreams.ClientResponseStream<>(new ReduceProcessor<>(func, new CompletableFuture<>(), "Acc")));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(func).apply(isA(Object.class), isA(Object.class));
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming6() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new GrpcTestStreams.ClientResultHandler<>(new CompletableFuture<>()));
    new RuntimeException("foo");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming7() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new GrpcTestStreams.ClientResultHandler<>(new CompletableFuture<>()));
    new RuntimeException("foo");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, (Object) null);

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming8() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming9() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber2, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming10() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("1.99*"));
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming11() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming12() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop(), mock(Consumer.class));

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming13() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class),
        mock(Flow.Publisher.class));

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming14() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new GrpcTestStreams.ClientResponseStream<>(new MapProcessor<>(mapping,
            new GrpcTestStreams.ClientRequestStream<>(new GrpcTestStreams.ClientResponseStream<>(
                new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming15() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new GrpcTestStreams.ClientRequestStream<>(new GrpcTestStreams.ClientResponseStream<>(
            new DelayedSubscriber<>(subscriber, new CompletableFuture<>())))));
    new RuntimeException("An unhandled error has reached the top level error handler");
    new EUnexpected();

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming16() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");

    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new GrpcTestStreams.ClientResponseStream.Subscription());
    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber2, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  void testClientStreaming17() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventExecutor());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new GrpcTestStreams.ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  void testDecodeCsv() {
    // Arrange and Act
    List<Vector<Object>> actualDecodeCsvResult = DataApiTestHelpers.decodeCsv(SampleData.ALT_TABLE_SCHEMA,
        new ArrayList<>());

    // Assert
    assertEquals(5, actualDecodeCsvResult.size());
    assertTrue(actualDecodeCsvResult.get(0).isEmpty());
    assertTrue(actualDecodeCsvResult.get(1).isEmpty());
    assertTrue(actualDecodeCsvResult.get(2).isEmpty());
    assertTrue(actualDecodeCsvResult.get(3).isEmpty());
    assertTrue(actualDecodeCsvResult.get(4).isEmpty());
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  void testDecodeCsv2() {
    // Arrange and Act
    List<Vector<Object>> actualDecodeCsvResult = DataApiTestHelpers.decodeCsv(SampleData.ALT_TABLE_SCHEMA_V2,
        new ArrayList<>());

    // Assert
    assertEquals(6, actualDecodeCsvResult.size());
    assertTrue(actualDecodeCsvResult.get(0).isEmpty());
    assertTrue(actualDecodeCsvResult.get(1).isEmpty());
    assertTrue(actualDecodeCsvResult.get(2).isEmpty());
    assertTrue(actualDecodeCsvResult.get(3).isEmpty());
    assertTrue(actualDecodeCsvResult.get(4).isEmpty());
    assertTrue(actualDecodeCsvResult.get(5).isEmpty());
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  void testDecodeCsv3() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    // Act
    List<Vector<Object>> actualDecodeCsvResult = DataApiTestHelpers.decodeCsv(schema, new ArrayList<>());

    // Assert
    assertTrue(actualDecodeCsvResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  void testDecodeJson() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA, new ArrayList<>()));
    assertThrows(RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA_V2, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  void testDecodeJson2() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataApiTestHelpers.decodeJson(schema, new ArrayList<>()));
  }
}

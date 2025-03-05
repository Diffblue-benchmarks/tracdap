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
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.stub.StreamObserver;
import io.netty.channel.DefaultEventLoop;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.finos.tracdap.api.FileReadRequest;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.async.flow.HubProcessor;
import org.finos.tracdap.common.async.flow.MapProcessor;
import org.finos.tracdap.common.async.flow.ReduceProcessor;
import org.finos.tracdap.common.data.IExecutionContext;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientRequestStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResultHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataApiTestHelpersDiffblueTest {
  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with {@code grpcMethod}, {@code request}, {@code execCtx}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingWithGrpcMethodRequestExecCtx() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop(new DefaultEventLoop(), mock(Executor.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult = DataApiTestHelpers.serverStreaming(grpcMethod,
        defaultEventLoop, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with {@code grpcMethod}, {@code request}, {@code execCtx}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; given RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingWithGrpcMethodRequestExecCtx_givenRuntimeExceptionWithFoo() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());
    new RuntimeException("foo");

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult = DataApiTestHelpers.serverStreaming(grpcMethod,
        "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with {@code grpcMethod}, {@code request}, {@code execCtx}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingWithGrpcMethodRequestExecCtx_thenReturnCompletableFuture() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with {@code grpcMethod}, {@code request}, {@code execCtx}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingWithGrpcMethodRequestExecCtx_thenThrowRuntimeException() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse2() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse3() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", new ClientRequestStream<>(
        new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse4() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse5() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse6() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse7() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing().when(grpcMethod).accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());

    // Act
    DataApiTestHelpers
        .serverStreaming(grpcMethod, "Request",
            new DelayedSubscriber<>(
                new ClientRequestStream<>(
                    new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))),
                signal));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; given Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_givenThrowable() {
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code grpcMethod}, {@code request}, {@code response}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)}
   */
  @Test
  @DisplayName("Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_thenThrowRuntimeException() {
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
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); given DefaultEventLoop(); then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingDiscard_givenDefaultEventLoop_thenReturnCompletableFuture() {
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
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}
   */
  @Test
  @DisplayName("Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"})
  void testServerStreamingDiscard_thenThrowRuntimeException() {
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
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest2() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new Subscription());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest3() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new DelayedSubscriber<>(subscriber2, new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest4() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest5() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResultHandler<>(new CompletableFuture<>()));
    new RuntimeException("foo");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest6() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("1.99*"));
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest7() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest8() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop(), mock(Consumer.class));

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest9() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    MapProcessor<? super Object, Object> subscriber = new MapProcessor<>(mock(Function.class), mock(Publisher.class));

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest10() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new MapProcessor<>(mapping, new ClientRequestStream<>(
            new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest11() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new ClientRequestStream<>(
            new ClientResponseStream<>(new DelayedSubscriber<>(subscriber, new CompletableFuture<>())))));
    new RuntimeException("An unhandled error has reached the top level error handler");
    new EUnexpected();

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest12() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");

    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new Subscription());
    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber2, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; given Function apply(Object) return 'Apply'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_givenFunctionApplyReturnApply() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; given Function apply(Object) return 'Apply'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_givenFunctionApplyReturnApply2() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenReturn("Apply");
    FutureFirstItemSubscriber<? super Object> subscriber = new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber2, new CompletableFuture<>()))));
    new RuntimeException("An unhandled error has reached the top level error handler");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; given RuntimeException(String) with empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_givenRuntimeExceptionWithEmptyString() {
    // Arrange
    Function<Object, Object> mapping = mock(Function.class);
    when(mapping.apply(Mockito.<Object>any())).thenThrow(new EUnexpected());
    HubProcessor<? super Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenReturn(new ClientResponseStream<>(
        new MapProcessor<>(mapping, new DelayedSubscriber<>(subscriber, new CompletableFuture<>()))));
    new RuntimeException("");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
    verify(mapping).apply(isA(Object.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_thenCallsApply() {
    // Arrange
    BiFunction<Object, Object, Object> func = mock(BiFunction.class);
    when(func.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(new ReduceProcessor<>(func, new CompletableFuture<>(), "Acc")));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(func).apply(isA(Object.class), isA(Object.class));
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod}, {@code request}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_whenNull() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResultHandler<>(new CompletableFuture<>()));
    new RuntimeException("foo");

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, (Object) null);

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#readRequest(String, TagHeader)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Tenant is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#readRequest(String, TagHeader)}
   */
  @Test
  @DisplayName("Test readRequest(String, TagHeader); when empty string; then return Tenant is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FileReadRequest DataApiTestHelpers.readRequest(String, TagHeader)"})
  void testReadRequest_whenEmptyString_thenReturnTenantIsEmptyString() {
    // Arrange and Act
    FileReadRequest actualReadRequestResult = DataApiTestHelpers.readRequest("", TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualReadRequestResult.getTenant());
    assertEquals(1, actualReadRequestResult.getAllFields().size());
    assertEquals(6, actualReadRequestResult.getSerializedSize());
  }

  /**
   * Test {@link DataApiTestHelpers#readRequest(String, TagHeader)}.
   * <ul>
   *   <li>When {@code Tenant}.</li>
   *   <li>Then return {@code Tenant}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#readRequest(String, TagHeader)}
   */
  @Test
  @DisplayName("Test readRequest(String, TagHeader); when 'Tenant'; then return 'Tenant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FileReadRequest DataApiTestHelpers.readRequest(String, TagHeader)"})
  void testReadRequest_whenTenant_thenReturnTenant() {
    // Arrange and Act
    FileReadRequest actualReadRequestResult = DataApiTestHelpers.readRequest("Tenant", TagHeader.getDefaultInstance());

    // Assert
    assertEquals("Tenant", actualReadRequestResult.getTenant());
    assertEquals(14, actualReadRequestResult.getSerializedSize());
    assertEquals(2, actualReadRequestResult.getAllFields().size());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}.
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeCsv(SchemaDefinition, List); when ALT_TABLE_SCHEMA; then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_whenAlt_table_schema_thenReturnSizeIsFive() {
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
   * Test {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}.
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA_V2}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeCsv(SchemaDefinition, List); when ALT_TABLE_SCHEMA_V2; then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_whenAlt_table_schema_v2_thenReturnSizeIsSix() {
    // Arrange and Act
    List<Vector<Object>> actualDecodeCsvResult = DataApiTestHelpers.decodeCsv(SampleData.ALT_TABLE_SCHEMA_V2,
        new ArrayList<>());

    // Assert
    assertEquals(6, actualDecodeCsvResult.size());
    assertTrue(actualDecodeCsvResult.get(5).isEmpty());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeCsv(SchemaDefinition, List); when DefaultInstance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_whenDefaultInstance_thenReturnEmpty() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    // Act
    List<Vector<Object>> actualDecodeCsvResult = DataApiTestHelpers.decodeCsv(schema, new ArrayList<>());

    // Assert
    assertTrue(actualDecodeCsvResult.isEmpty());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeJson(SchemaDefinition, List); when ALT_TABLE_SCHEMA; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_whenAlt_table_schema_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA, new ArrayList<>()));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA_V2}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeJson(SchemaDefinition, List); when ALT_TABLE_SCHEMA_V2; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_whenAlt_table_schema_v2_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA_V2, new ArrayList<>()));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName("Test decodeJson(SchemaDefinition, List); when DefaultInstance; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_whenDefaultInstance_thenThrowRuntimeException() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataApiTestHelpers.decodeJson(schema, new ArrayList<>()));
  }
}

package org.finos.tracdap.test.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import io.grpc.stub.StreamObserver;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ThreadFactory;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.finos.tracdap.api.FileReadRequest;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.async.flow.HubProcessor;
import org.finos.tracdap.common.async.flow.ReduceProcessor;
import org.finos.tracdap.common.data.IExecutionContext;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.SchemaDefinition.Builder;
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
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx2() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();
    defaultEventExecutor.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventExecutor);

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult =
        DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx3() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult =
        DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx4() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor(mock(ThreadFactory.class));

    DefaultEventExecutor defaultEventExecutor2 = new DefaultEventExecutor();
    defaultEventExecutor2.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventExecutor2);

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult =
        DataApiTestHelpers.serverStreaming(grpcMethod, defaultEventExecutor, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; given DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx_givenDefaultEventLoop() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult =
        DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx_whenArrayList() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    ArrayList<Object> objectList = new ArrayList<>();

    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();
    defaultEventExecutor.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventExecutor);

    // Act
    CompletionStage<List<Object>> actualServerStreamingResult =
        DataApiTestHelpers.serverStreaming(grpcMethod, objectList, execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, IExecutionContext)} with
   * {@code grpcMethod}, {@code request}, {@code execCtx}.
   *
   * <ul>
   *   <li>When {@link BiConsumer}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, IExecutionContext) with 'grpcMethod', 'request', 'execCtx'; when BiConsumer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreaming(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingWithGrpcMethodRequestExecCtx_whenBiConsumer() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request", execCtx));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> response =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse2() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    // Act
    DataApiTestHelpers.serverStreaming(
        grpcMethod, "Request", new FutureFirstItemSubscriber<>(new CompletableFuture<>()));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse3() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    DataApiTestHelpers.serverStreaming(
        grpcMethod, "Request", new ClientRequestStream<>(new ClientResponseStream<>(subscriber2)));

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse4() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<Object> response =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(null), signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse5() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber2, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse6() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<Object> response =
        new DelayedSubscriber<>(new HubProcessor<>(new DefaultEventLoop()), signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse7() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    HubProcessor<Object> subscriber =
        new HubProcessor<>(new DefaultEventLoop(), mock(Consumer.class));

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse8() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber = new FutureFirstItemSubscriber<>(null);
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber2, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse9() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber3, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse10() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    HubProcessor<Object> subscriber = new HubProcessor<>(new DefaultEventLoop());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber2, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <ul>
   *   <li>Given {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; given Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_givenRunnable() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    HubProcessor<Object> subscriber = new HubProcessor<>(eventLoop);

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <ul>
   *   <li>Given {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; given Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_givenRunnable2() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    HubProcessor<Object> subscriber = new HubProcessor<>(eventLoop, mock(Consumer.class));

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<Object> response = new DelayedSubscriber<>(subscriber, signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; given Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_givenThrowable() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());
    DelayedSubscriber<Object> response =
        new DelayedSubscriber<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>()), signal);

    // Act
    DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object, Subscriber)} with {@code
   * grpcMethod}, {@code request}, {@code response}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreaming(BiConsumer, Object,
   * Subscriber)}
   */
  @Test
  @DisplayName(
      "Test serverStreaming(BiConsumer, Object, Subscriber) with 'grpcMethod', 'request', 'response'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataApiTestHelpers.serverStreaming(BiConsumer, Object, Subscriber)"})
  void testServerStreamingWithGrpcMethodRequestResponse_thenThrowRuntimeException() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> response =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.serverStreaming(grpcMethod, "Request", response));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventExecutor#DefaultEventExecutor()} addShutdownHook {@link
   *       Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); given DefaultEventExecutor() addShutdownHook Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_givenDefaultEventExecutorAddShutdownHookRunnable() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventExecutor defaultEventExecutor = new DefaultEventExecutor();
    defaultEventExecutor.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventExecutor);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult =
        DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_givenDefaultEventLoopAddShutdownHookRunnable() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(defaultEventLoop);

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult =
        DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); given DefaultEventLoop(); then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_givenDefaultEventLoop_thenReturnCompletableFuture() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doNothing()
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    CompletionStage<Void> actualServerStreamingDiscardResult =
        DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx);

    // Assert
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
    assertTrue(actualServerStreamingDiscardResult instanceof CompletableFuture);
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new EUnexpected())
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>When {@link BiConsumer} {@link BiConsumer#accept(Object, Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); when BiConsumer accept(Object, Object) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_whenBiConsumerAcceptThrowRuntimeException() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(grpcMethod)
        .accept(Mockito.<Object>any(), Mockito.<StreamObserver<Object>>any());

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx));
    verify(grpcMethod).accept(isA(Object.class), isA(StreamObserver.class));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Test {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object, IExecutionContext)}.
   *
   * <ul>
   *   <li>When {@link BiConsumer}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#serverStreamingDiscard(BiConsumer, Object,
   * IExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test serverStreamingDiscard(BiConsumer, Object, IExecutionContext); when BiConsumer; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage DataApiTestHelpers.serverStreamingDiscard(BiConsumer, Object, IExecutionContext)"
  })
  void testServerStreamingDiscard_whenBiConsumer_thenThrowRuntimeException() {
    // Arrange
    BiConsumer<Object, StreamObserver<Object>> grpcMethod = mock(BiConsumer.class);

    IExecutionContext execCtx = mock(IExecutionContext.class);
    when(execCtx.eventLoopExecutor()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.serverStreamingDiscard(grpcMethod, "Request", execCtx));
    verify(execCtx).eventLoopExecutor();
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(subscriber2));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest2() {
    // Arrange
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    subscriber.onSubscribe(new Subscription());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(subscriber2));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest3() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    FutureFirstItemSubscriber<Object> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());
    DelayedSubscriber<Object> subscriber3 =
        new DelayedSubscriber<>(subscriber2, new CompletableFuture<>());
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(subscriber3));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest4() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(
            new ClientResponseStream<>(new FutureFirstItemSubscriber<>(new CompletableFuture<>())));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest5() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResultHandler<>(new CompletableFuture<>()));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName(
      "Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_thenCallsApply() {
    // Arrange
    BiFunction<Object, Object, Object> func = mock(BiFunction.class);
    when(func.apply(Mockito.<Object>any(), Mockito.<Object>any()))
        .thenThrow(new RuntimeException());
    ReduceProcessor<Object, Object> subscriber =
        new ReduceProcessor<>(func, new CompletableFuture<>(), "Acc");

    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResponseStream<>(subscriber));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, "Request");

    // Assert
    verify(func).apply(isA(Object.class), isA(Object.class));
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName(
      "Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_thenThrowRuntimeException() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> DataApiTestHelpers.clientStreaming(grpcMethod, "Request"));
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#clientStreaming(Function, Object)} with {@code grpcMethod},
   * {@code request}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#clientStreaming(Function, Object)}
   */
  @Test
  @DisplayName("Test clientStreaming(Function, Object) with 'grpcMethod', 'request'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture DataApiTestHelpers.clientStreaming(Function, Object)"})
  void testClientStreamingWithGrpcMethodRequest_whenNull() {
    // Arrange
    Function<StreamObserver<Object>, StreamObserver<Object>> grpcMethod = mock(Function.class);
    when(grpcMethod.apply(Mockito.<StreamObserver<Object>>any()))
        .thenReturn(new ClientResultHandler<>(new CompletableFuture<>()));

    // Act
    DataApiTestHelpers.clientStreaming(grpcMethod, (Object) null);

    // Assert
    verify(grpcMethod).apply(isA(StreamObserver.class));
  }

  /**
   * Test {@link DataApiTestHelpers#readRequest(String, TagHeader)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Tenant is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#readRequest(String, TagHeader)}
   */
  @Test
  @DisplayName(
      "Test readRequest(String, TagHeader); when empty string; then return Tenant is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileReadRequest DataApiTestHelpers.readRequest(String, TagHeader)"})
  void testReadRequest_whenEmptyString_thenReturnTenantIsEmptyString() {
    // Arrange and Act
    FileReadRequest actualReadRequestResult =
        DataApiTestHelpers.readRequest("", TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualReadRequestResult.getTenant());
    assertEquals(1, actualReadRequestResult.getAllFields().size());
    assertEquals(6, actualReadRequestResult.getSerializedSize());
  }

  /**
   * Test {@link DataApiTestHelpers#readRequest(String, TagHeader)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return {@code Tenant}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#readRequest(String, TagHeader)}
   */
  @Test
  @DisplayName("Test readRequest(String, TagHeader); when 'Tenant'; then return 'Tenant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileReadRequest DataApiTestHelpers.readRequest(String, TagHeader)"})
  void testReadRequest_whenTenant_thenReturnTenant() {
    // Arrange and Act
    FileReadRequest actualReadRequestResult =
        DataApiTestHelpers.readRequest("Tenant", TagHeader.getDefaultInstance());

    // Assert
    assertEquals("Tenant", actualReadRequestResult.getTenant());
    assertEquals(14, actualReadRequestResult.getSerializedSize());
    assertEquals(2, actualReadRequestResult.getAllFields().size());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}.
   *
   * <ul>
   *   <li>Given {@link Builder} {@link Builder#build()} return DefaultInstance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeCsv(SchemaDefinition, List); given Builder build() return DefaultInstance; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_givenBuilderBuildReturnDefaultInstance_thenReturnEmpty() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.build()).thenReturn(SchemaDefinition.getDefaultInstance());

    Builder builder2 = mock(Builder.class);
    when(builder2.mergeUnknownFields(Mockito.<UnknownFieldSet>any())).thenReturn(builder);
    SchemaDefinition schema =
        builder2.mergeUnknownFields(UnknownFieldSet.newBuilder().build()).build();

    // Act
    List<Vector<Object>> actualDecodeCsvResult =
        DataApiTestHelpers.decodeCsv(schema, new ArrayList<>());

    // Assert
    verify(builder2).mergeUnknownFields(isA(UnknownFieldSet.class));
    verify(builder).build();
    assertTrue(actualDecodeCsvResult.isEmpty());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}.
   *
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA}.
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeCsv(SchemaDefinition, List); when ALT_TABLE_SCHEMA; then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_whenAlt_table_schema_thenReturnSizeIsFive() {
    // Arrange and Act
    List<Vector<Object>> actualDecodeCsvResult =
        DataApiTestHelpers.decodeCsv(SampleData.ALT_TABLE_SCHEMA, new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA_V2}.
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeCsv(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeCsv(SchemaDefinition, List); when ALT_TABLE_SCHEMA_V2; then return size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeCsv(SchemaDefinition, List)"})
  void testDecodeCsv_whenAlt_table_schema_v2_thenReturnSizeIsSix() {
    // Arrange and Act
    List<Vector<Object>> actualDecodeCsvResult =
        DataApiTestHelpers.decodeCsv(SampleData.ALT_TABLE_SCHEMA_V2, new ArrayList<>());

    // Assert
    assertEquals(6, actualDecodeCsvResult.size());
    assertTrue(actualDecodeCsvResult.get(5).isEmpty());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   *
   * <ul>
   *   <li>Then calls {@link Builder#mergeUnknownFields(UnknownFieldSet)}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeJson(SchemaDefinition, List); then calls mergeUnknownFields(UnknownFieldSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_thenCallsMergeUnknownFields() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.build()).thenReturn(SchemaDefinition.getDefaultInstance());

    Builder builder2 = mock(Builder.class);
    when(builder2.mergeUnknownFields(Mockito.<UnknownFieldSet>any())).thenReturn(builder);
    SchemaDefinition schema =
        builder2.mergeUnknownFields(UnknownFieldSet.newBuilder().build()).build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> DataApiTestHelpers.decodeJson(schema, new ArrayList<>()));
    verify(builder2).mergeUnknownFields(isA(UnknownFieldSet.class));
    verify(builder).build();
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   *
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeJson(SchemaDefinition, List); when ALT_TABLE_SCHEMA; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_whenAlt_table_schema_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA, new ArrayList<>()));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}.
   *
   * <ul>
   *   <li>When {@link SampleData#ALT_TABLE_SCHEMA_V2}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJson(SchemaDefinition, List)}
   */
  @Test
  @DisplayName(
      "Test decodeJson(SchemaDefinition, List); when ALT_TABLE_SCHEMA_V2; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataApiTestHelpers.decodeJson(SchemaDefinition, List)"})
  void testDecodeJson_whenAlt_table_schema_v2_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataApiTestHelpers.decodeJson(SampleData.ALT_TABLE_SCHEMA_V2, new ArrayList<>()));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>Then return toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); then return toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_thenReturnToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.DATETIME, ofResult.atStartOfDay());

    // Assert
    assertEquals("00:00", ((LocalDateTime) actualDecodeJavaObjectResult).toLocalTime().toString());
    LocalDate toLocalDateResult = ((LocalDateTime) actualDecodeJavaObjectResult).toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>Then return toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); then return toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_thenReturnToStringIs19700101() {
    // Arrange, Act and Assert
    assertEquals(
        "1970-01-01",
        DataApiTestHelpers.decodeJavaObject(BasicType.DATE, LocalDate.of(1970, 1, 1)).toString());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_when42_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> DataApiTestHelpers.decodeJavaObject(BasicType.DECIMAL, "42"));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); when '42'; then return doubleValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_when42_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42.0d, ((Double) DataApiTestHelpers.decodeJavaObject(BasicType.FLOAT, "42")).doubleValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); when '42'; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L, ((Long) DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, "42")).longValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); when 'A'; then return longValue is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenA_thenReturnLongValueIsSixtyFive() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, (byte) 'A');

    // Assert
    assertEquals(65L, ((Long) actualDecodeJavaObjectResult).longValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); when 'BASIC_TYPE_NOT_SET'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenBasicTypeNotSet_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> DataApiTestHelpers.decodeJavaObject(BasicType.BASIC_TYPE_NOT_SET, "Raw Object"));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName(
      "Test decodeJavaObject(BasicType, Object); when BigDecimal(String) with '2.3'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenBigDecimalWith23_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> DataApiTestHelpers.decodeJavaObject(BasicType.DECIMAL, new BigDecimal("2.3")));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'BOOLEAN'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) DataApiTestHelpers.decodeJavaObject(BasicType.BOOLEAN, "Raw Object"));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'BOOLEAN'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenBoolean_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) DataApiTestHelpers.decodeJavaObject(BasicType.BOOLEAN, true));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'BOOLEAN'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenBoolean_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.BOOLEAN, 1L));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'DATE'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenDate_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.DATE, 1));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code DATETIME}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'DATETIME'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenDatetime_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.DATETIME, 1));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'DECIMAL'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenDecimal_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.DECIMAL, true));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'FLOAT'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenFloat_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.FLOAT, true));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenOne_thenReturnLongValueIsOne() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, 1L);

    // Assert
    assertEquals(1L, ((Long) actualDecodeJavaObjectResult).longValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenOne_thenReturnLongValueIsOne2() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult = DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, 1);

    // Assert
    assertEquals(1L, ((Long) actualDecodeJavaObjectResult).longValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenOne_thenReturnLongValueIsOne3() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, (short) 1);

    // Assert
    assertEquals(1L, ((Long) actualDecodeJavaObjectResult).longValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'STRING'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenString_thenReturnTrueToString() {
    // Arrange, Act and Assert
    assertEquals(
        Boolean.TRUE.toString(), DataApiTestHelpers.decodeJavaObject(BasicType.STRING, true));
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenTen_thenReturnDoubleValueIsTen() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.FLOAT, 10.0d);

    // Assert
    assertEquals(10.0d, ((Double) actualDecodeJavaObjectResult).doubleValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenTen_thenReturnFloatValueIsTen() {
    // Arrange and Act
    Object actualDecodeJavaObjectResult =
        DataApiTestHelpers.decodeJavaObject(BasicType.FLOAT, 10.0f);

    // Assert
    assertEquals(10.0f, ((Float) actualDecodeJavaObjectResult).floatValue());
  }

  /**
   * Test {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link DataApiTestHelpers#decodeJavaObject(BasicType, Object)}
   */
  @Test
  @DisplayName("Test decodeJavaObject(BasicType, Object); when 'true'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataApiTestHelpers.decodeJavaObject(BasicType, Object)"})
  void testDecodeJavaObject_whenTrue_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> DataApiTestHelpers.decodeJavaObject(BasicType.INTEGER, true));
  }
}

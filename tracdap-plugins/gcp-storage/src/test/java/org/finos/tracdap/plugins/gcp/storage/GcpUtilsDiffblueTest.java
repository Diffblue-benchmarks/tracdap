package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.DynamicFlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BatcherFactory;
import com.google.api.gax.rpc.BatchingCallable;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.PagedCallable;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.TranslatingUnaryCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.api.gax.tracing.MethodName;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedClientStreamingCallable;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

class GcpUtilsDiffblueTest {
  /**
   * Test {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  @DisplayName(
      "Test unaryCall(UnaryCallable, Object, Executor); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcpUtils.unaryCall(UnaryCallable, Object, Executor)"})
  void testUnaryCall_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    TranslatingUnaryCallable<Object, Object, Object, Object> callable =
        mock(TranslatingUnaryCallable.class);
    when(callable.futureCall(Mockito.<Object>any(), Mockito.<ApiCallContext>any()))
        .thenThrow(new IllegalStateException());
    PagedCallable<Object, Object, Object> callable2 =
        new PagedCallable<>(callable, mock(PagedListResponseFactory.class));

    RequestBuilder<Object> requestBuilder = mock(RequestBuilder.class);
    when(requestBuilder.build()).thenReturn("Build");
    doNothing().when(requestBuilder).appendRequest(Mockito.<Object>any());

    BatchingDescriptor<Object, Object> batchingDescriptor = mock(BatchingDescriptor.class);
    when(batchingDescriptor.getBatchPartitionKey(Mockito.<Object>any()))
        .thenReturn(new PartitionKey("Keys"));
    when(batchingDescriptor.countBytes(Mockito.<Object>any())).thenReturn(3L);
    when(batchingDescriptor.countElements(Mockito.<Object>any())).thenReturn(3L);
    when(batchingDescriptor.getRequestBuilder()).thenReturn(requestBuilder);

    BatchingDescriptor<Object, Object> batchingDescriptor2 = mock(BatchingDescriptor.class);
    when(batchingDescriptor2.getBatchPartitionKey(Mockito.<Object>any()))
        .thenReturn(new PartitionKey("Keys"));
    when(batchingDescriptor2.countElements(Mockito.<Object>any())).thenReturn(3L);

    BatchingSettings batchingSettings = mock(BatchingSettings.class);
    when(batchingSettings.getElementCountThreshold()).thenReturn(3L);
    when(batchingSettings.getRequestByteThreshold()).thenReturn(1L);
    when(batchingSettings.getDelayThreshold()).thenReturn(mock(Duration.class));
    when(batchingSettings.getIsEnabled()).thenReturn(true);

    DynamicFlowControlSettings settings = mock(DynamicFlowControlSettings.class);
    when(settings.getInitialOutstandingElementCount()).thenReturn(3L);
    when(settings.getInitialOutstandingRequestBytes()).thenReturn(1L);
    when(settings.getMaxOutstandingElementCount()).thenReturn(3L);
    when(settings.getMaxOutstandingRequestBytes()).thenReturn(1L);
    when(settings.getMinOutstandingElementCount()).thenReturn(3L);
    when(settings.getMinOutstandingRequestBytes()).thenReturn(1L);
    when(settings.getLimitExceededBehavior()).thenReturn(LimitExceededBehavior.ThrowException);
    FlowController flowController = new FlowController(settings);

    BatcherFactory<Object, Object> batcherFactory =
        new BatcherFactory<>(
            batchingDescriptor2, batchingSettings, new DefaultEventLoop(), flowController);

    BatchingCallable<Object, Object> callable3 =
        new BatchingCallable<>(callable2, batchingDescriptor, batcherFactory);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> GcpUtils.unaryCall(callable3, "Request", mock(Executor.class)));
    verify(batchingSettings).getDelayThreshold();
    verify(batchingSettings, atLeast(1)).getElementCountThreshold();
    verify(batchingSettings).getIsEnabled();
    verify(batchingSettings, atLeast(1)).getRequestByteThreshold();
    verify(settings).getInitialOutstandingElementCount();
    verify(settings).getInitialOutstandingRequestBytes();
    verify(settings, atLeast(1)).getLimitExceededBehavior();
    verify(settings).getMaxOutstandingElementCount();
    verify(settings).getMaxOutstandingRequestBytes();
    verify(settings).getMinOutstandingElementCount();
    verify(settings).getMinOutstandingRequestBytes();
    verify(requestBuilder).appendRequest(isA(Object.class));
    verify(requestBuilder, atLeast(1)).build();
    verify(batchingDescriptor).countBytes(isA(Object.class));
    verify(batchingDescriptor).countElements(isA(Object.class));
    verify(batchingDescriptor2, atLeast(1)).countElements(isA(Object.class));
    verify(batchingDescriptor).getBatchPartitionKey(isA(Object.class));
    verify(batchingDescriptor2).getBatchPartitionKey(isA(Object.class));
    verify(batchingDescriptor).getRequestBuilder();
    verify(callable).futureCall(isA(Object.class), isA(ApiCallContext.class));
  }

  /**
   * Test {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  @DisplayName("Test unaryCall(UnaryCallable, Object, Executor); then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcpUtils.unaryCall(UnaryCallable, Object, Executor)"})
  void testUnaryCall_thenReturnCompletableFuture() {
    // Arrange
    TranslatingUnaryCallable<Object, Object, Object, Object> callable =
        mock(TranslatingUnaryCallable.class);
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    ListenableFutureToApiFuture<Object> delegate =
        new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture));
    when(callable.futureCall(Mockito.<Object>any(), Mockito.<ApiCallContext>any()))
        .thenReturn(new ForwardingApiFuture<>(delegate));

    // Act
    CompletionStage<Object> actualUnaryCallResult =
        GcpUtils.unaryCall(callable, "Request", mock(Executor.class));

    // Assert
    verify(callable).futureCall(isA(Object.class), isA(ApiCallContext.class));
    assertTrue(actualUnaryCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#clientStreamingCall(ClientStreamingCallable, Object, Executor)}.
   *
   * <ul>
   *   <li>Given {@link GcpUnaryResponse} (default constructor).
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GcpUtils#clientStreamingCall(ClientStreamingCallable, Object,
   * Executor)}
   */
  @Test
  @DisplayName(
      "Test clientStreamingCall(ClientStreamingCallable, Object, Executor); given GcpUnaryResponse (default constructor); then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletionStage GcpUtils.clientStreamingCall(ClientStreamingCallable, Object, Executor)"
  })
  void testClientStreamingCall_givenGcpUnaryResponse_thenReturnCompletableFuture() {
    // Arrange
    ClientStreamingCallable<Object, Object> innerCallable = mock(ClientStreamingCallable.class);
    when(innerCallable.clientStreamingCall(
            Mockito.<ApiStreamObserver<Object>>any(), Mockito.<ApiCallContext>any()))
        .thenReturn(new GcpUnaryResponse<>());

    ApiTracerFactory tracerFactory = mock(ApiTracerFactory.class);
    MetricsTracer metricsTracer = new MetricsTracer(mock(MethodName.class), null);
    when(tracerFactory.newTracer(
            Mockito.<ApiTracer>any(), Mockito.<SpanName>any(), Mockito.<OperationType>any()))
        .thenReturn(metricsTracer);

    TracedClientStreamingCallable<Object, Object> callable =
        new TracedClientStreamingCallable<>(innerCallable, tracerFactory, mock(SpanName.class));

    // Act
    CompletionStage<Object> actualClientStreamingCallResult =
        GcpUtils.clientStreamingCall(callable, "Request", mock(Executor.class));

    // Assert
    verify(innerCallable)
        .clientStreamingCall(isA(ApiStreamObserver.class), isA(ApiCallContext.class));
    verify(tracerFactory)
        .newTracer(isA(ApiTracer.class), isA(SpanName.class), eq(OperationType.ClientStreaming));
    assertTrue(actualClientStreamingCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture, Executor)} with {@code gcpFuture}, {@code
   * executor}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GcpUtils#gcpCallback(ApiFuture, Executor)}
   */
  @Test
  @DisplayName(
      "Test gcpCallback(ApiFuture, Executor) with 'gcpFuture', 'executor'; then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture, Executor)"})
  void testGcpCallbackWithGcpFutureExecutor_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    ListenableFutureToApiFuture<Object> delegate =
        new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture));

    // Act
    CompletionStage<Object> actualGcpCallbackResult =
        GcpUtils.gcpCallback(new ForwardingApiFuture<>(delegate), mock(Executor.class));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture)} with {@code gcpFuture}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link GcpUtils#gcpCallback(ApiFuture)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture) with 'gcpFuture'; then return CompletableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture)"})
  void testGcpCallbackWithGcpFuture_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    ListenableFutureToApiFuture<Object> delegate =
        new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture));

    // Act
    CompletionStage<Object> actualGcpCallbackResult =
        GcpUtils.gcpCallback(new ForwardingApiFuture<>(delegate));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }
}

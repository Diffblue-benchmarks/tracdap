package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.TranslatingUnaryCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.api.gax.tracing.MethodName;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedClientStreamingCallable;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongCounterBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GcpUtilsDiffblueTest {
  /**
   * Test {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}.
   * <ul>
   *   <li>Given {@link RetryingFuture} {@link ApiFuture#addListener(Runnable, Executor)} does nothing.</li>
   *   <li>Then calls {@link ApiFuture#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  @DisplayName("Test unaryCall(UnaryCallable, Object, Executor); given RetryingFuture addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.unaryCall(UnaryCallable, Object, Executor)"})
  void testUnaryCall_givenRetryingFutureAddListenerDoesNothing_thenCallsAddListener() {
    // Arrange
    new CancellationException("foo");
    new CancellationException("foo");
    RetryingFuture<OperationSnapshot> pollingFuture = mock(RetryingFuture.class);
    doNothing().when(pollingFuture).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    TranslatingUnaryCallable<Object, Object, Object, Object> callable = mock(TranslatingUnaryCallable.class);
    when(callable.futureCall(Mockito.<Object>any(), Mockito.<ApiCallContext>any()))
        .thenReturn(new ForwardingApiFuture<>(
            new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(new OperationFutureImpl<>(pollingFuture,
                new ForwardingApiFuture<>(
                    new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
                mock(ApiFunction.class), mock(ApiFunction.class))))));

    // Act
    CompletionStage<Object> actualUnaryCallResult = GcpUtils.unaryCall(callable, "Request", mock(Executor.class));

    // Assert
    verify(pollingFuture, atLeast(1)).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    verify(callable).futureCall(isA(Object.class), isA(ApiCallContext.class));
    assertTrue(actualUnaryCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#unaryCall(UnaryCallable, Object, Executor)}
   */
  @Test
  @DisplayName("Test unaryCall(UnaryCallable, Object, Executor); then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.unaryCall(UnaryCallable, Object, Executor)"})
  void testUnaryCall_thenReturnCompletableFuture() {
    // Arrange
    new CancellationException("foo");
    new CancellationException("foo");
    TranslatingUnaryCallable<Object, Object, Object, Object> callable = mock(TranslatingUnaryCallable.class);
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    when(callable.futureCall(Mockito.<Object>any(), Mockito.<ApiCallContext>any())).thenReturn(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))));

    // Act
    CompletionStage<Object> actualUnaryCallResult = GcpUtils.unaryCall(callable, "Request", mock(Executor.class));

    // Assert
    verify(callable).futureCall(isA(Object.class), isA(ApiCallContext.class));
    assertTrue(actualUnaryCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#clientStreamingCall(ClientStreamingCallable, Object, Executor)}.
   * <ul>
   *   <li>Given {@link GcpUnaryResponse} (default constructor).</li>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#clientStreamingCall(ClientStreamingCallable, Object, Executor)}
   */
  @Test
  @DisplayName("Test clientStreamingCall(ClientStreamingCallable, Object, Executor); given GcpUnaryResponse (default constructor); then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.clientStreamingCall(ClientStreamingCallable, Object, Executor)"})
  void testClientStreamingCall_givenGcpUnaryResponse_thenReturnCompletableFuture() {
    // Arrange
    ClientStreamingCallable<Object, Object> innerCallable = mock(ClientStreamingCallable.class);
    when(innerCallable.clientStreamingCall(Mockito.<ApiStreamObserver<Object>>any(), Mockito.<ApiCallContext>any()))
        .thenReturn(new GcpUnaryResponse<>());
    DoubleHistogramBuilder doubleHistogramBuilder = mock(DoubleHistogramBuilder.class);
    when(doubleHistogramBuilder.build()).thenReturn(mock(DoubleHistogram.class));
    DoubleHistogramBuilder doubleHistogramBuilder2 = mock(DoubleHistogramBuilder.class);
    when(doubleHistogramBuilder2.setUnit(Mockito.<String>any())).thenReturn(doubleHistogramBuilder);
    DoubleHistogramBuilder doubleHistogramBuilder3 = mock(DoubleHistogramBuilder.class);
    when(doubleHistogramBuilder3.setDescription(Mockito.<String>any())).thenReturn(doubleHistogramBuilder2);
    LongCounterBuilder longCounterBuilder = mock(LongCounterBuilder.class);
    when(longCounterBuilder.build()).thenReturn(mock(LongCounter.class));
    LongCounterBuilder longCounterBuilder2 = mock(LongCounterBuilder.class);
    when(longCounterBuilder2.setUnit(Mockito.<String>any())).thenReturn(longCounterBuilder);
    LongCounterBuilder longCounterBuilder3 = mock(LongCounterBuilder.class);
    when(longCounterBuilder3.setDescription(Mockito.<String>any())).thenReturn(longCounterBuilder2);
    Meter meter = mock(Meter.class);
    when(meter.counterBuilder(Mockito.<String>any())).thenReturn(longCounterBuilder3);
    when(meter.histogramBuilder(Mockito.<String>any())).thenReturn(doubleHistogramBuilder3);
    MeterBuilder meterBuilder = mock(MeterBuilder.class);
    when(meterBuilder.build()).thenReturn(meter);
    MeterBuilder meterBuilder2 = mock(MeterBuilder.class);
    when(meterBuilder2.setInstrumentationVersion(Mockito.<String>any())).thenReturn(meterBuilder);
    OpenTelemetry openTelemetry = mock(OpenTelemetry.class);
    when(openTelemetry.meterBuilder(Mockito.<String>any())).thenReturn(meterBuilder2);
    ApiTracerFactory tracerFactory = mock(ApiTracerFactory.class);
    when(tracerFactory.newTracer(Mockito.<ApiTracer>any(), Mockito.<SpanName>any(), Mockito.<OperationType>any()))
        .thenReturn(
            new MetricsTracer(mock(MethodName.class), new OpenTelemetryMetricsRecorder(openTelemetry, "Service Name")));

    // Act
    CompletionStage<Object> actualClientStreamingCallResult = GcpUtils.clientStreamingCall(
        new TracedClientStreamingCallable<>(innerCallable, tracerFactory, mock(SpanName.class)), "Request",
        mock(Executor.class));

    // Assert
    verify(innerCallable).clientStreamingCall(isA(ApiStreamObserver.class), isA(ApiCallContext.class));
    verify(tracerFactory).newTracer(isA(ApiTracer.class), isA(SpanName.class), eq(OperationType.ClientStreaming));
    verify(openTelemetry).meterBuilder(eq("gax-java"));
    verify(doubleHistogramBuilder, atLeast(1)).build();
    verify(doubleHistogramBuilder3, atLeast(1)).setDescription(Mockito.<String>any());
    verify(doubleHistogramBuilder2, atLeast(1)).setUnit(eq("ms"));
    verify(longCounterBuilder, atLeast(1)).build();
    verify(longCounterBuilder3, atLeast(1)).setDescription(Mockito.<String>any());
    verify(longCounterBuilder2, atLeast(1)).setUnit(eq("1"));
    verify(meter, atLeast(1)).counterBuilder(Mockito.<String>any());
    verify(meter, atLeast(1)).histogramBuilder(Mockito.<String>any());
    verify(meterBuilder).build();
    verify(meterBuilder2).setInstrumentationVersion(eq("2.46.1"));
    assertTrue(actualClientStreamingCallResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture, Executor)} with {@code gcpFuture}, {@code executor}.
   * <ul>
   *   <li>Then calls {@link ApiFuture#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture, Executor)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture, Executor) with 'gcpFuture', 'executor'; then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture, Executor)"})
  void testGcpCallbackWithGcpFutureExecutor_thenCallsAddListener() {
    // Arrange
    RetryingFuture<OperationSnapshot> pollingFuture = mock(RetryingFuture.class);
    doNothing().when(pollingFuture).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(new ForwardingApiFuture<>(
        new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(new OperationFutureImpl<>(pollingFuture,
            new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
            mock(ApiFunction.class), mock(ApiFunction.class))))),
        mock(Executor.class));

    // Assert
    verify(pollingFuture, atLeast(1)).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture, Executor)} with {@code gcpFuture}, {@code executor}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture, Executor)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture, Executor) with 'gcpFuture', 'executor'; then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture, Executor)"})
  void testGcpCallbackWithGcpFutureExecutor_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
        mock(Executor.class));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture)} with {@code gcpFuture}.
   * <ul>
   *   <li>Then calls {@link ApiFuture#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture) with 'gcpFuture'; then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture)"})
  void testGcpCallbackWithGcpFuture_thenCallsAddListener() {
    // Arrange
    RetryingFuture<OperationSnapshot> pollingFuture = mock(RetryingFuture.class);
    doNothing().when(pollingFuture).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(new ForwardingApiFuture<>(
        new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(new OperationFutureImpl<>(pollingFuture,
            new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))),
            mock(ApiFunction.class), mock(ApiFunction.class))))));

    // Assert
    verify(pollingFuture, atLeast(1)).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }

  /**
   * Test {@link GcpUtils#gcpCallback(ApiFuture)} with {@code gcpFuture}.
   * <ul>
   *   <li>Then return {@link CompletableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GcpUtils#gcpCallback(ApiFuture)}
   */
  @Test
  @DisplayName("Test gcpCallback(ApiFuture) with 'gcpFuture'; then return CompletableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage GcpUtils.gcpCallback(ApiFuture)"})
  void testGcpCallbackWithGcpFuture_thenReturnCompletableFuture() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();

    // Act
    CompletionStage<Object> actualGcpCallbackResult = GcpUtils.gcpCallback(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture))));

    // Assert
    assertTrue(actualGcpCallbackResult instanceof CompletableFuture);
  }
}

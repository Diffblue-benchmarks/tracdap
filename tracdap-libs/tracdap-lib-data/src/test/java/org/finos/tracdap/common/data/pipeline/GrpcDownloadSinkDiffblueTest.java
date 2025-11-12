package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.UnknownFieldSet;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcDownloadSinkDiffblueTest {
  /**
   * Test {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier, boolean)}.
   *
   * <p>Method under test: {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier,
   * boolean)}
   */
  @Test
  @DisplayName("Test new GrpcDownloadSink(StreamObserver, Supplier, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcDownloadSink.<init>(StreamObserver, Supplier, boolean)"})
  void testNewGrpcDownloadSink() {
    // Arrange
    FutureFirstItemSubscriber<MessageLite> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<MessageLite> subscriber2 =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            new GrpcDownloadSink<>(
                new ClientResponseStream<>(subscriber2), mock(Supplier.class), true));
  }

  /**
   * Test {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier, boolean)}.
   *
   * <p>Method under test: {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier,
   * boolean)}
   */
  @Test
  @DisplayName("Test new GrpcDownloadSink(StreamObserver, Supplier, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcDownloadSink.<init>(StreamObserver, Supplier, boolean)"})
  void testNewGrpcDownloadSink2() {
    // Arrange
    ServerCallStreamObserver<MessageLite> response = mock(ServerCallStreamObserver.class);
    doThrow(new EUnexpected()).when(response).setOnCancelHandler(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> new GrpcDownloadSink<>(response, mock(Supplier.class), false));
    verify(response).setOnCancelHandler(isA(Runnable.class));
  }

  /**
   * Test {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier, boolean)}.
   *
   * <ul>
   *   <li>Given newBuilder.
   *   <li>When {@link Supplier} {@link Supplier#get()} return newBuilder.
   * </ul>
   *
   * <p>Method under test: {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new GrpcDownloadSink(StreamObserver, Supplier, boolean); given newBuilder; when Supplier get() return newBuilder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcDownloadSink.<init>(StreamObserver, Supplier, boolean)"})
  void testNewGrpcDownloadSink_givenNewBuilder_whenSupplierGetReturnNewBuilder() {
    // Arrange
    ServerCallStreamObserver<MessageLite> response = mock(ServerCallStreamObserver.class);
    doNothing().when(response).setOnCancelHandler(Mockito.<Runnable>any());
    doNothing().when(response).setOnReadyHandler(Mockito.<Runnable>any());

    Supplier<Builder> builder = mock(Supplier.class);
    when(builder.get()).thenReturn(UnknownFieldSet.newBuilder());

    // Act
    new GrpcDownloadSink<>(response, builder, false);

    // Assert
    verify(response).setOnCancelHandler(isA(Runnable.class));
    verify(response).setOnReadyHandler(isA(Runnable.class));
    verify(builder).get();
  }

  /**
   * Test {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier, boolean)}.
   *
   * <ul>
   *   <li>When {@link Supplier} {@link Supplier#get()} throw {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new GrpcDownloadSink(StreamObserver, Supplier, boolean); when Supplier get() throw EUnexpected(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcDownloadSink.<init>(StreamObserver, Supplier, boolean)"})
  void testNewGrpcDownloadSink_whenSupplierGetThrowEUnexpected_thenCallsGet() {
    // Arrange
    ServerCallStreamObserver<MessageLite> response = mock(ServerCallStreamObserver.class);
    doNothing().when(response).setOnCancelHandler(Mockito.<Runnable>any());
    doNothing().when(response).setOnReadyHandler(Mockito.<Runnable>any());

    Supplier<Builder> builder = mock(Supplier.class);
    when(builder.get()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> new GrpcDownloadSink<>(response, builder, false));
    verify(response).setOnCancelHandler(isA(Runnable.class));
    verify(response).setOnReadyHandler(isA(Runnable.class));
    verify(builder).get();
  }

  /**
   * Test {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then calls {@link ServerCallStreamObserver#setOnReadyHandler(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcDownloadSink#GrpcDownloadSink(StreamObserver, Supplier,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new GrpcDownloadSink(StreamObserver, Supplier, boolean); when 'true'; then calls setOnReadyHandler(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcDownloadSink.<init>(StreamObserver, Supplier, boolean)"})
  void testNewGrpcDownloadSink_whenTrue_thenCallsSetOnReadyHandler() {
    // Arrange
    ServerCallStreamObserver<MessageLite> response = mock(ServerCallStreamObserver.class);
    doNothing().when(response).setOnCancelHandler(Mockito.<Runnable>any());
    doNothing().when(response).setOnReadyHandler(Mockito.<Runnable>any());

    // Act
    new GrpcDownloadSink<>(response, mock(Supplier.class), true);

    // Assert
    verify(response).setOnCancelHandler(isA(Runnable.class));
    verify(response).setOnReadyHandler(isA(Runnable.class));
  }
}

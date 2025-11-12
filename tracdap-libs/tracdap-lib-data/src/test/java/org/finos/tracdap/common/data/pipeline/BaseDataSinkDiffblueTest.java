package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseDataSinkDiffblueTest {
  @Mock private DataPipelineImpl dataPipelineImpl;

  /**
   * Test {@link BaseDataSink#reportComplete()}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl} {@link DataPipelineImpl#reportComplete()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportComplete()}
   */
  @Test
  @DisplayName("Test reportComplete(); given DataPipelineImpl reportComplete() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportComplete()"})
  void testReportComplete_givenDataPipelineImplReportCompleteDoesNothing() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportComplete();
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    new ReactiveByteSink(dataPipelineImpl, sink).reportComplete();

    // Assert
    verify(dataPipelineImpl).reportComplete();
  }

  /**
   * Test {@link BaseDataSink#reportComplete()}.
   *
   * <ul>
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportComplete()}
   */
  @Test
  @DisplayName("Test reportComplete(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportComplete()"})
  void testReportComplete_thenThrowEUnexpected() {
    // Arrange
    doThrow(new EUnexpected()).when(dataPipelineImpl).reportComplete();
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> new ReactiveByteSink(dataPipelineImpl, sink).reportComplete());
    verify(dataPipelineImpl).reportComplete();
  }

  /**
   * Test {@link BaseDataSink#reportRegularError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl} {@link DataPipelineImpl#reportRegularError(Throwable)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportRegularError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test reportRegularError(Throwable); given DataPipelineImpl reportRegularError(Throwable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportRegularError(Throwable)"})
  void testReportRegularError_givenDataPipelineImplReportRegularErrorDoesNothing() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportRegularError(Mockito.<Throwable>any());
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ReactiveByteSink reactiveByteSink = new ReactiveByteSink(dataPipelineImpl, sink);

    // Act
    reactiveByteSink.reportRegularError(new Throwable());

    // Assert
    verify(dataPipelineImpl).reportRegularError(isA(Throwable.class));
  }

  /**
   * Test {@link BaseDataSink#reportRegularError(Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportRegularError(Throwable)}
   */
  @Test
  @DisplayName("Test reportRegularError(Throwable); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportRegularError(Throwable)"})
  void testReportRegularError_thenThrowEUnexpected() {
    // Arrange
    doThrow(new EUnexpected()).when(dataPipelineImpl).reportRegularError(Mockito.<Throwable>any());
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ReactiveByteSink reactiveByteSink = new ReactiveByteSink(dataPipelineImpl, sink);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> reactiveByteSink.reportRegularError(new Throwable()));
    verify(dataPipelineImpl).reportRegularError(isA(Throwable.class));
  }

  /**
   * Test {@link BaseDataSink#reportUnhandledError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl} {@link DataPipelineImpl#reportUnhandledError(Throwable)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportUnhandledError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test reportUnhandledError(Throwable); given DataPipelineImpl reportUnhandledError(Throwable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportUnhandledError(Throwable)"})
  void testReportUnhandledError_givenDataPipelineImplReportUnhandledErrorDoesNothing() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ReactiveByteSink reactiveByteSink = new ReactiveByteSink(dataPipelineImpl, sink);

    // Act
    reactiveByteSink.reportUnhandledError(new Throwable());

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }

  /**
   * Test {@link BaseDataSink#reportUnhandledError(Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataSink#reportUnhandledError(Throwable)}
   */
  @Test
  @DisplayName("Test reportUnhandledError(Throwable); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataSink.reportUnhandledError(Throwable)"})
  void testReportUnhandledError_thenThrowEUnexpected() {
    // Arrange
    doThrow(new EUnexpected())
        .when(dataPipelineImpl)
        .reportUnhandledError(Mockito.<Throwable>any());
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    ReactiveByteSink reactiveByteSink = new ReactiveByteSink(dataPipelineImpl, sink);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> reactiveByteSink.reportUnhandledError(new Throwable()));
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }
}

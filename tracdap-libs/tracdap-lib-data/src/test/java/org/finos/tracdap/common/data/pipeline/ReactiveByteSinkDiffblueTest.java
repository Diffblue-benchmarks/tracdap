package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReactiveByteSinkDiffblueTest {
  @Mock private DataPipelineImpl dataPipelineImpl;

  @InjectMocks private ReactiveByteSink reactiveByteSink;

  @Mock private Subscriber<ArrowBuf> subscriber;

  /**
   * Test {@link ReactiveByteSink#ReactiveByteSink(DataPipelineImpl, Subscriber)}.
   *
   * <p>Method under test: {@link ReactiveByteSink#ReactiveByteSink(DataPipelineImpl,
   * Flow.Subscriber)}
   */
  @Test
  @DisplayName("Test new ReactiveByteSink(DataPipelineImpl, Subscriber)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.<init>(DataPipelineImpl, Flow.Subscriber)"})
  void testNewReactiveByteSink() {
    // Arrange
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act
    ReactiveByteSink actualReactiveByteSink = new ReactiveByteSink(dataPipelineImpl, sink);

    // Assert
    assertFalse(actualReactiveByteSink.isDone());
    assertFalse(actualReactiveByteSink.isReady());
  }

  /**
   * Test {@link ReactiveByteSink#dataInterface()}.
   *
   * <p>Method under test: {@link ReactiveByteSink#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.StreamApi ReactiveByteSink.dataInterface()"})
  void testDataInterface() {
    // Arrange and Act
    StreamApi actualDataInterfaceResult = reactiveByteSink.dataInterface();

    // Assert
    assertSame(reactiveByteSink, actualDataInterfaceResult);
  }

  /**
   * Test {@link ReactiveByteSink#connect()}.
   *
   * <ul>
   *   <li>Given {@link Flow.Subscriber} {@link Flow.Subscriber#onSubscribe(Subscription)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#connect()}
   */
  @Test
  @DisplayName("Test connect(); given Subscriber onSubscribe(Subscription) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.connect()"})
  void testConnect_givenSubscriberOnSubscribeDoesNothing() {
    // Arrange
    doNothing().when(subscriber).onSubscribe(Mockito.<Subscription>any());

    // Act
    reactiveByteSink.connect();

    // Assert
    verify(subscriber).onSubscribe(isA(Subscription.class));
  }

  /**
   * Test {@link ReactiveByteSink#connect()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#connect()}
   */
  @Test
  @DisplayName("Test connect(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.connect()"})
  void testConnect_thenThrowETracInternal() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(subscriber)
        .onSubscribe(Mockito.<Subscription>any());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.connect());
    verify(subscriber).onSubscribe(isA(Subscription.class));
  }

  /**
   * Test {@link ReactiveByteSink#doCancel()}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl} {@link DataPipelineImpl#requestCancel()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#doCancel()}
   */
  @Test
  @DisplayName("Test doCancel(); given DataPipelineImpl requestCancel() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.doCancel()"})
  void testDoCancel_givenDataPipelineImplRequestCancelDoesNothing() {
    // Arrange
    doNothing().when(dataPipelineImpl).requestCancel();

    // Act
    reactiveByteSink.doCancel();

    // Assert
    verify(dataPipelineImpl).requestCancel();
  }

  /**
   * Test {@link ReactiveByteSink#doCancel()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#doCancel()}
   */
  @Test
  @DisplayName("Test doCancel(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.doCancel()"})
  void testDoCancel_thenThrowETracInternal() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .requestCancel();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.doCancel());
    verify(dataPipelineImpl).requestCancel();
  }

  /**
   * Test {@link ReactiveByteSink#isReady()}.
   *
   * <p>Method under test: {@link ReactiveByteSink#isReady()}
   */
  @Test
  @DisplayName("Test isReady()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReactiveByteSink.isReady()"})
  void testIsReady() {
    // Arrange, Act and Assert
    assertFalse(reactiveByteSink.isReady());
  }

  /**
   * Test {@link ReactiveByteSink#terminate(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Flow.Subscriber} {@link Flow.Subscriber#onError(Throwable)} does nothing.
   *   <li>Then {@link ReactiveByteSink} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#terminate(Throwable)}
   */
  @Test
  @DisplayName(
      "Test terminate(Throwable); given Subscriber onError(Throwable) does nothing; then ReactiveByteSink Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.terminate(Throwable)"})
  void testTerminate_givenSubscriberOnErrorDoesNothing_thenReactiveByteSinkDone() {
    // Arrange
    doNothing().when(subscriber).onError(Mockito.<Throwable>any());

    // Act
    reactiveByteSink.terminate(new Throwable());

    // Assert
    verify(subscriber).onError(isA(Throwable.class));
    assertTrue(reactiveByteSink.isDone());
  }

  /**
   * Test {@link ReactiveByteSink#terminate(Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#terminate(Throwable)}
   */
  @Test
  @DisplayName("Test terminate(Throwable); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.terminate(Throwable)"})
  void testTerminate_thenThrowETracInternal() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(subscriber)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.terminate(new Throwable()));
    verify(subscriber).onError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSink#onNext(ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#onNext(ArrowBuf)}
   */
  @Test
  @DisplayName("Test onNext(ArrowBuf); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onNext(ArrowBuf)"})
  void testOnNext_whenNull_thenThrowETracInternal() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.onNext(null));
  }

  /**
   * Test {@link ReactiveByteSink#onComplete()}.
   *
   * <p>Method under test: {@link ReactiveByteSink#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onComplete()"})
  void testOnComplete() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportComplete();
    doNothing().when(subscriber).onComplete();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.onComplete());
    verify(subscriber).onComplete();
    verify(dataPipelineImpl).reportComplete();
  }

  /**
   * Test {@link ReactiveByteSink#onComplete()}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); given DataPipelineImpl; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onComplete()"})
  void testOnComplete_givenDataPipelineImpl_thenThrowETracInternal() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost")).when(subscriber).onComplete();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.onComplete());
    verify(subscriber).onComplete();
  }

  /**
   * Test {@link ReactiveByteSink#onComplete()}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSink} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); then ReactiveByteSink Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onComplete()"})
  void testOnComplete_thenReactiveByteSinkDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportComplete();
    doNothing().when(subscriber).onComplete();

    // Act
    reactiveByteSink.onComplete();

    // Assert
    verify(subscriber).onComplete();
    verify(dataPipelineImpl).reportComplete();
    assertTrue(reactiveByteSink.isDone());
  }

  /**
   * Test {@link ReactiveByteSink#onError(Throwable)}.
   *
   * <p>Method under test: {@link ReactiveByteSink#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onError(Throwable)"})
  void testOnError() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportRegularError(Mockito.<Throwable>any());
    doNothing().when(subscriber).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.onError(new Throwable()));
    verify(subscriber).onError(isA(Throwable.class));
    verify(dataPipelineImpl).reportRegularError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSink#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link DataPipelineImpl}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given DataPipelineImpl; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onError(Throwable)"})
  void testOnError_givenDataPipelineImpl_thenThrowETracInternal() {
    // Arrange
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(subscriber)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> reactiveByteSink.onError(new Throwable()));
    verify(subscriber).onError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSink#onError(Throwable)}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSink} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSink#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); then ReactiveByteSink Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSink.onError(Throwable)"})
  void testOnError_thenReactiveByteSinkDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportRegularError(Mockito.<Throwable>any());
    doNothing().when(subscriber).onError(Mockito.<Throwable>any());

    // Act
    reactiveByteSink.onError(new Throwable());

    // Assert
    verify(subscriber).onError(isA(Throwable.class));
    verify(dataPipelineImpl).reportRegularError(isA(Throwable.class));
    assertTrue(reactiveByteSink.isDone());
  }
}

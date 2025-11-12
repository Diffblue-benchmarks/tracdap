package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.finos.tracdap.common.exception.ETracPublic;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReactiveByteSourceDiffblueTest {
  @Mock private DataPipelineImpl dataPipelineImpl;

  @Mock private Publisher<ArrowBuf> publisher;

  @InjectMocks private ReactiveByteSource reactiveByteSource;

  /**
   * Test {@link ReactiveByteSource#ReactiveByteSource(DataPipelineImpl, Publisher)}.
   *
   * <p>Method under test: {@link ReactiveByteSource#ReactiveByteSource(DataPipelineImpl,
   * Publisher)}
   */
  @Test
  @DisplayName("Test new ReactiveByteSource(DataPipelineImpl, Publisher)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.<init>(DataPipelineImpl, Publisher)"})
  void testNewReactiveByteSource() {
    // Arrange and Act
    ReactiveByteSource actualReactiveByteSource =
        new ReactiveByteSource(dataPipelineImpl, mock(Publisher.class));

    // Assert
    assertFalse(actualReactiveByteSource.isDone());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualReactiveByteSource.consumerType());
  }

  /**
   * Test {@link ReactiveByteSource#connect()}.
   *
   * <ul>
   *   <li>Given {@link Publisher} {@link Publisher#subscribe(Subscriber)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#connect()}
   */
  @Test
  @DisplayName("Test connect(); given Publisher subscribe(Subscriber) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.connect()"})
  void testConnect_givenPublisherSubscribeDoesNothing() {
    // Arrange
    doNothing().when(publisher).subscribe(Mockito.<Subscriber<ArrowBuf>>any());

    // Act
    reactiveByteSource.connect();

    // Assert
    verify(publisher).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link ReactiveByteSource#connect()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracPublic}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#connect()}
   */
  @Test
  @DisplayName("Test connect(); then throw ETracPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.connect()"})
  void testConnect_thenThrowETracPublic() {
    // Arrange
    doThrow(new ETracPublic("Not all who wander are lost"))
        .when(publisher)
        .subscribe(Mockito.<Subscriber<ArrowBuf>>any());

    // Act and Assert
    assertThrows(ETracPublic.class, () -> reactiveByteSource.connect());
    verify(publisher).subscribe(isA(Subscriber.class));
  }

  /**
   * Test {@link ReactiveByteSource#cancel()}.
   *
   * <p>Method under test: {@link ReactiveByteSource#cancel()}
   */
  @Test
  @DisplayName("Test cancel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.cancel()"})
  void testCancel() {
    // Arrange and Act
    reactiveByteSource.cancel();

    // Assert
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onSubscribe(Subscription)}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSource} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onSubscribe(Subscription)}
   */
  @Test
  @DisplayName("Test onSubscribe(Subscription); then ReactiveByteSource Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onSubscribe(Subscription)"})
  void testOnSubscribe_thenReactiveByteSourceDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());

    // Act
    reactiveByteSource.onSubscribe(new ClientResponseStream.Subscription());

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onSubscribe(Subscription)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracPublic}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onSubscribe(Subscription)}
   */
  @Test
  @DisplayName("Test onSubscribe(Subscription); then throw ETracPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onSubscribe(Subscription)"})
  void testOnSubscribe_thenThrowETracPublic() {
    // Arrange
    doThrow(new ETracPublic("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportUnhandledError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        ETracPublic.class,
        () -> reactiveByteSource.onSubscribe(new ClientResponseStream.Subscription()));
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSource#onSubscribe(Subscription)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ReactiveByteSource} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onSubscribe(Subscription)}
   */
  @Test
  @DisplayName("Test onSubscribe(Subscription); when 'null'; then ReactiveByteSource Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onSubscribe(Subscription)"})
  void testOnSubscribe_whenNull_thenReactiveByteSourceDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());

    // Act
    reactiveByteSource.onSubscribe(null);

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onNext(ArrowBuf)} with {@code ArrowBuf}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSource} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onNext(ArrowBuf)}
   */
  @Test
  @DisplayName("Test onNext(ArrowBuf) with 'ArrowBuf'; then ReactiveByteSource Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onNext(ArrowBuf)"})
  void testOnNextWithArrowBuf_thenReactiveByteSourceDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());

    // Act
    reactiveByteSource.onNext(null);

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onNext(ArrowBuf)} with {@code ArrowBuf}.
   *
   * <ul>
   *   <li>Then throw {@link ETracPublic}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onNext(ArrowBuf)}
   */
  @Test
  @DisplayName("Test onNext(ArrowBuf) with 'ArrowBuf'; then throw ETracPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onNext(ArrowBuf)"})
  void testOnNextWithArrowBuf_thenThrowETracPublic() {
    // Arrange
    doThrow(new ETracPublic("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportUnhandledError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracPublic.class, () -> reactiveByteSource.onNext(null));
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSource#onComplete()}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSource} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); then ReactiveByteSource Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onComplete()"})
  void testOnComplete_thenReactiveByteSourceDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());

    // Act
    reactiveByteSource.onComplete();

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onComplete()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracPublic}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete(); then throw ETracPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onComplete()"})
  void testOnComplete_thenThrowETracPublic() {
    // Arrange
    doThrow(new ETracPublic("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportUnhandledError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracPublic.class, () -> reactiveByteSource.onComplete());
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }

  /**
   * Test {@link ReactiveByteSource#onError(Throwable)}.
   *
   * <ul>
   *   <li>Then {@link ReactiveByteSource} Done.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); then ReactiveByteSource Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onError(Throwable)"})
  void testOnError_thenReactiveByteSourceDone() {
    // Arrange
    doNothing().when(dataPipelineImpl).reportUnhandledError(Mockito.<Throwable>any());

    // Act
    reactiveByteSource.onError(new Throwable());

    // Assert
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
    assertTrue(reactiveByteSource.isDone());
  }

  /**
   * Test {@link ReactiveByteSource#onError(Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracPublic}.
   * </ul>
   *
   * <p>Method under test: {@link ReactiveByteSource#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); then throw ETracPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReactiveByteSource.onError(Throwable)"})
  void testOnError_thenThrowETracPublic() {
    // Arrange
    doThrow(new ETracPublic("Not all who wander are lost"))
        .when(dataPipelineImpl)
        .reportUnhandledError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(ETracPublic.class, () -> reactiveByteSource.onError(new Throwable()));
    verify(dataPipelineImpl).reportUnhandledError(isA(Throwable.class));
  }
}

package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultEventExecutor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HubProcessorDiffblueTest {
  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Executor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName(
      "Test subscribe(Subscriber); given IllegalStateException(); then calls execute(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_givenIllegalStateException_thenCallsExecute() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventExecutor());

    Executor executor = mock(Executor.class);
    doThrow(new IllegalStateException()).when(executor).execute(Mockito.<Runnable>any());
    DefaultEventExecutor eventLoop = new DefaultEventExecutor(new DefaultEventLoop(), executor);
    HubProcessor<? super Object> subscriber = new HubProcessor<>(eventLoop);

    CompletableFuture<?> signal = new CompletableFuture<>();
    signal.obtrudeException(new Throwable());

    DelayedSubscriber<? super Object> subscriber2 = new DelayedSubscriber<>(subscriber, signal);

    // Act
    hubProcessor.subscribe(subscriber2);

    // Assert
    verify(executor).execute(isA(Runnable.class));
  }

  /**
   * Test {@link HubProcessor#subscribe(Subscriber)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HubProcessor#subscribe(Subscriber)}
   */
  @Test
  @DisplayName("Test subscribe(Subscriber); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.subscribe(Subscriber)"})
  void testSubscribe_thenThrowIllegalStateException() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> hubProcessor.subscribe(new HubProcessor<>(new DefaultEventLoop())));
  }

  /**
   * Test {@link HubProcessor#onSubscribe(Subscription)}.
   *
   * <p>Method under test: {@link HubProcessor#onSubscribe(java.util.concurrent.Flow.Subscription)}
   */
  @Test
  @DisplayName("Test onSubscribe(Subscription)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HubProcessor.onSubscribe(java.util.concurrent.Flow.Subscription)"})
  void testOnSubscribe() {
    // Arrange
    HubProcessor<Object> hubProcessor = new HubProcessor<>(new DefaultEventLoop());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> hubProcessor.onSubscribe(new Subscription()));
  }
}

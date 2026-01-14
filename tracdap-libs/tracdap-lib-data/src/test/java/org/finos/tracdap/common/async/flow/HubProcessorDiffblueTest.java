package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.Flow.Subscriber;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream;
import org.finos.tracdap.test.grpc.GrpcTestStreams.ClientResponseStream.Subscription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HubProcessorDiffblueTest {
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

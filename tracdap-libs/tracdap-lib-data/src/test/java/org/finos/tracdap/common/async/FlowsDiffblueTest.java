package org.finos.tracdap.common.async;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowsDiffblueTest {
  /**
   * Method under test: {@link Flows#fold(Flow.Publisher, BiFunction, Object)}
   */
  @Test
  void testFold() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFoldResult = Flows.fold(source, mock(BiFunction.class), "Acc");

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
    assertTrue(actualFoldResult instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link Flows#fold(Flow.Publisher, BiFunction, Object)}
   */
  @Test
  void testFold2() {
    // Arrange
    Flow.Publisher<Object> source = mock(Flow.Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFoldResult = Flows.fold(source, mock(BiFunction.class), "Acc");

    // Assert
    verify(source).subscribe(isA(Flow.Subscriber.class));
    assertTrue(actualFoldResult instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link Flows#first(Flow.Publisher)}
   */
  @Test
  void testFirst() {
    // Arrange
    Flow.Publisher<Object> publisher = mock(Flow.Publisher.class);
    doNothing().when(publisher).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFirstResult = Flows.first(publisher);

    // Assert
    verify(publisher).subscribe(isA(Flow.Subscriber.class));
    assertTrue(actualFirstResult instanceof CompletableFuture);
  }

  /**
   * Method under test: {@link Flows#first(Flow.Publisher)}
   */
  @Test
  void testFirst2() {
    // Arrange
    Flow.Publisher<Object> publisher = mock(Flow.Publisher.class);
    doNothing().when(publisher).subscribe(Mockito.<Flow.Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFirstResult = Flows.first(publisher);

    // Assert
    verify(publisher).subscribe(isA(Flow.Subscriber.class));
    assertTrue(actualFirstResult instanceof CompletableFuture);
  }
}

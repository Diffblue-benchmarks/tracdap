package org.finos.tracdap.common.async;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowsDiffblueTest {
  /**
   * Test {@link Flows#fold(Publisher, BiFunction, Object)}.
   * <p>
   * Method under test: {@link Flows#fold(Publisher, BiFunction, Object)}
   */
  @Test
  @DisplayName("Test fold(Publisher, BiFunction, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage Flows.fold(Publisher, BiFunction, Object)"})
  void testFold() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFoldResult = Flows.fold(source, mock(BiFunction.class), "Acc");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualFoldResult instanceof CompletableFuture);
  }

  /**
   * Test {@link Flows#fold(Publisher, BiFunction, Object)}.
   * <p>
   * Method under test: {@link Flows#fold(Publisher, BiFunction, Object)}
   */
  @Test
  @DisplayName("Test fold(Publisher, BiFunction, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage Flows.fold(Publisher, BiFunction, Object)"})
  void testFold2() {
    // Arrange
    Publisher<Object> source = mock(Publisher.class);
    doNothing().when(source).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFoldResult = Flows.fold(source, mock(BiFunction.class), "Acc");

    // Assert
    verify(source).subscribe(isA(Subscriber.class));
    assertTrue(actualFoldResult instanceof CompletableFuture);
  }

  /**
   * Test {@link Flows#first(Publisher)}.
   * <p>
   * Method under test: {@link Flows#first(Publisher)}
   */
  @Test
  @DisplayName("Test first(Publisher)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage Flows.first(Publisher)"})
  void testFirst() {
    // Arrange
    Publisher<Object> publisher = mock(Publisher.class);
    doNothing().when(publisher).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFirstResult = Flows.first(publisher);

    // Assert
    verify(publisher).subscribe(isA(Subscriber.class));
    assertTrue(actualFirstResult instanceof CompletableFuture);
  }

  /**
   * Test {@link Flows#first(Publisher)}.
   * <p>
   * Method under test: {@link Flows#first(Publisher)}
   */
  @Test
  @DisplayName("Test first(Publisher)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletionStage Flows.first(Publisher)"})
  void testFirst2() {
    // Arrange
    Publisher<Object> publisher = mock(Publisher.class);
    doNothing().when(publisher).subscribe(Mockito.<Subscriber<Object>>any());

    // Act
    CompletionStage<Object> actualFirstResult = Flows.first(publisher);

    // Assert
    verify(publisher).subscribe(isA(Subscriber.class));
    assertTrue(actualFirstResult instanceof CompletableFuture);
  }
}

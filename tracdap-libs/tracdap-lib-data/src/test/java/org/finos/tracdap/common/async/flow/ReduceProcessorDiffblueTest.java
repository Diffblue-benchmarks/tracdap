package org.finos.tracdap.common.async.flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReduceProcessorDiffblueTest {
  /**
   * Test {@link ReduceProcessor#onNext(Object)}.
   * <ul>
   *   <li>Given {@link CompletionException#CompletionException(String, Throwable)} with {@code foo} and {@link Throwable#Throwable()}.</li>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReduceProcessor#onNext(Object)}
   */
  @Test
  @DisplayName("Test onNext(Object); given CompletionException(String, Throwable) with 'foo' and Throwable(); then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReduceProcessor.onNext(Object)"})
  void testOnNext_givenCompletionExceptionWithFooAndThrowable_thenCallsApply() {
    // Arrange
    new CompletionException("foo", new Throwable());

    BiFunction<Object, Object, Object> func = mock(BiFunction.class);
    when(func.apply(Mockito.<Object>any(), Mockito.<Object>any()))
        .thenThrow(new CompletionException("foo", new Throwable()));
    ReduceProcessor<Object, Object> reduceProcessor = new ReduceProcessor<>(func, new CompletableFuture<>(), "Acc");

    // Act and Assert
    assertThrows(CompletionException.class, () -> reduceProcessor.onNext("42"));
    verify(func).apply(isA(Object.class), isA(Object.class));
  }
}

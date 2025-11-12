package org.finos.tracdap.plugins.azure.storage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reactor.core.scheduler.Scheduler;

class AzureSchedulingDiffblueTest {
  /**
   * Test {@link AzureScheduling#schedulerFor(ExecutorService)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When commonPool awaitTermination ten and {@code NANOSECONDS}.
   * </ul>
   *
   * <p>Method under test: {@link AzureScheduling#schedulerFor(ExecutorService)}
   */
  @Test
  @DisplayName(
      "Test schedulerFor(ExecutorService); given ten; when commonPool awaitTermination ten and 'NANOSECONDS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scheduler AzureScheduling.schedulerFor(ExecutorService)"})
  void testSchedulerFor_givenTen_whenCommonPoolAwaitTerminationTenAndNanoseconds()
      throws InterruptedException {
    // Arrange
    ForkJoinPool executor = ForkJoinPool.commonPool();
    executor.awaitTermination(10L, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertFalse(AzureScheduling.schedulerFor(executor).isDisposed());
  }

  /**
   * Test {@link AzureScheduling#schedulerFor(ExecutorService)}.
   *
   * <ul>
   *   <li>When commonPool.
   *   <li>Then return not Disposed.
   * </ul>
   *
   * <p>Method under test: {@link AzureScheduling#schedulerFor(ExecutorService)}
   */
  @Test
  @DisplayName("Test schedulerFor(ExecutorService); when commonPool; then return not Disposed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scheduler AzureScheduling.schedulerFor(ExecutorService)"})
  void testSchedulerFor_whenCommonPool_thenReturnNotDisposed() {
    // Arrange, Act and Assert
    assertFalse(AzureScheduling.schedulerFor(ForkJoinPool.commonPool()).isDisposed());
  }

  /**
   * Test {@link AzureScheduling#schedulerFor(ExecutorService)}.
   *
   * <ul>
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()}.
   *   <li>Then return not Disposed.
   * </ul>
   *
   * <p>Method under test: {@link AzureScheduling#schedulerFor(ExecutorService)}
   */
  @Test
  @DisplayName(
      "Test schedulerFor(ExecutorService); when DefaultEventLoop(); then return not Disposed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scheduler AzureScheduling.schedulerFor(ExecutorService)"})
  void testSchedulerFor_whenDefaultEventLoop_thenReturnNotDisposed() {
    // Arrange and Act
    Scheduler actualSchedulerForResult = AzureScheduling.schedulerFor(new DefaultEventLoop());

    // Assert
    assertFalse(actualSchedulerForResult.isDisposed());
  }
}

package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.ScheduledExecutorService;
import org.finos.tracdap.common.cache.IJobCache;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobManagerDiffblueTest {
  /**
   * Test {@link JobManager#JobManager(PlatformConfig, JobProcessor, IJobCache, ScheduledExecutorService)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return not queryJob {@code Job Key} Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobManager#JobManager(PlatformConfig, JobProcessor, IJobCache, ScheduledExecutorService)}
   */
  @Test
  @DisplayName("Test new JobManager(PlatformConfig, JobProcessor, IJobCache, ScheduledExecutorService); when DefaultInstance; then return not queryJob 'Job Key' Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobManager.<init>(PlatformConfig, JobProcessor, IJobCache, ScheduledExecutorService)"})
  void testNewJobManager_whenDefaultInstance_thenReturnNotQueryJobJobKeyPresent() {
    // Arrange
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    IJobCache<JobState> cache = mock(IJobCache.class);

    // Act and Assert
    assertFalse((new JobManager(config, null, cache, new DefaultEventLoop())).queryJob("Job Key").isPresent());
  }
}

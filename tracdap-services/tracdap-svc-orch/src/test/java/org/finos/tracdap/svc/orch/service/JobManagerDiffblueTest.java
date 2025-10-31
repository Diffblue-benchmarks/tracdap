package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.DefaultEventLoop;
import java.io.Serializable;
import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import org.finos.tracdap.common.cache.CacheEntry;
import org.finos.tracdap.common.cache.IJobCache;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.exec.BatchJobExecutor;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobManagerDiffblueTest {
  /**
   * Method under test: {@link JobManager#start()}
   */
  @Test
  void testStart() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenThrow(new RejectedExecutionException("foo"));
    ScheduledThreadPoolExecutor javaExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);

    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new JobManager(config,
            new JobProcessor(platformConfig, null, commonConcerns, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
            mock(IJobCache.class), javaExecutor)).start());
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link JobManager#JobManager(PlatformConfig, JobProcessor, IJobCache, ScheduledExecutorService)}
   */
  @Test
  void testNewJobManager() {
    // Arrange
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);

    // Act and Assert
    assertFalse((new JobManager(config, processor, cache, new DefaultEventLoop())).queryJob("Job Key").isPresent());
  }

  /**
   * Method under test: {@link JobManager#queryJob(String)}
   */
  @Test
  void testQueryJob() {
    // Arrange
    IJobCache<JobState> cache = mock(IJobCache.class);
    Optional<CacheEntry<JobState>> emptyResult = Optional.empty();
    when(cache.queryKey(Mockito.<String>any())).thenReturn(emptyResult);
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act
    Optional<JobState> actualQueryJobResult = (new JobManager(config, processor, cache, new DefaultEventLoop()))
        .queryJob("Job Key");

    // Assert
    verify(cache).queryKey(eq("Job Key"));
    assertFalse(actualQueryJobResult.isPresent());
    assertSame(emptyResult, actualQueryJobResult);
  }

  /**
   * Method under test: {@link JobManager#queryJob(String)}
   */
  @Test
  void testQueryJob2() {
    // Arrange
    IJobCache<JobState> cache = mock(IJobCache.class);
    when(cache.queryKey(Mockito.<String>any())).thenThrow(new NumberFormatException("foo"));
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new JobManager(config, processor, cache, new DefaultEventLoop())).queryJob("Job Key"));
    verify(cache).queryKey(eq("Job Key"));
  }
}

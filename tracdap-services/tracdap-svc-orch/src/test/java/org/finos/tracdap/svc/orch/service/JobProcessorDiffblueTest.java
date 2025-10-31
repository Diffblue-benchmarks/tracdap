package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EConsistencyValidation;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exec.BatchJobExecutor;
import org.finos.tracdap.common.exec.BatchJobState;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.config.RuntimeConfig;
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobProcessorDiffblueTest {
  /**
   * Method under test: {@link JobProcessor#launchJob(JobState)}
   */
  @Test
  void testLaunchJob() {
    // Arrange
    BatchJobExecutor<Serializable> jobExecutor = mock(BatchJobExecutor.class);
    when(jobExecutor.submitOneshotJob(Mockito.<TagHeader>any(), Mockito.<JobConfig>any(), Mockito.<RuntimeConfig>any()))
        .thenReturn(new BatchJobState<>());
    JobProcessor jobProcessor = new JobProcessor(PlatformConfig.getDefaultInstance(), null, mock(GrpcConcern.class),
        jobExecutor);

    // Act
    JobState actualLaunchJobResult = jobProcessor.launchJob(new JobState());

    // Assert
    verify(jobExecutor).submitOneshotJob(isNull(), isNull(), isNull());
    assertTrue(actualLaunchJobResult.executorState instanceof BatchJobState);
    assertNull(actualLaunchJobResult.errorDetail);
    assertNull(actualLaunchJobResult.jobKey);
    assertNull(actualLaunchJobResult.statusMessage);
    assertNull(actualLaunchJobResult.tenant);
    assertNull(actualLaunchJobResult.jobRequest);
    assertNull(actualLaunchJobResult.executorResult);
    assertNull(actualLaunchJobResult.executorStatus);
    assertNull(actualLaunchJobResult.requestMetadata);
    assertNull(actualLaunchJobResult.userMetadata);
    assertNull(actualLaunchJobResult.clientConfig);
    assertNull(actualLaunchJobResult.clientState);
    assertNull(actualLaunchJobResult.jobConfig);
    assertNull(actualLaunchJobResult.sysConfig);
    assertNull(actualLaunchJobResult.definition);
    assertNull(actualLaunchJobResult.jobType);
    assertNull(actualLaunchJobResult.jobId);
    assertEquals(0, actualLaunchJobResult.retries);
    assertEquals(JobStatusCode.SUBMITTED, actualLaunchJobResult.tracStatus);
    assertTrue(actualLaunchJobResult.resourceMapping.isEmpty());
    assertTrue(actualLaunchJobResult.resources.isEmpty());
    assertTrue(actualLaunchJobResult.resultMapping.isEmpty());
    assertEquals(CacheStatus.SENT_TO_EXECUTOR, actualLaunchJobResult.cacheStatus);
  }

  /**
   * Method under test: {@link JobProcessor#launchJob(JobState)}
   */
  @Test
  void testLaunchJob2() {
    // Arrange
    BatchJobExecutor<Serializable> jobExecutor = mock(BatchJobExecutor.class);
    when(jobExecutor.submitOneshotJob(Mockito.<TagHeader>any(), Mockito.<JobConfig>any(), Mockito.<RuntimeConfig>any()))
        .thenReturn(new BatchJobState<>());
    JobProcessor jobProcessor = new JobProcessor(PlatformConfig.getDefaultInstance(), null, mock(GrpcConcern.class),
        jobExecutor);
    JobState jobState = mock(JobState.class);
    JobState jobState2 = new JobState();
    when(jobState.clone()).thenReturn(jobState2);

    // Act
    JobState actualLaunchJobResult = jobProcessor.launchJob(jobState);

    // Assert
    verify(jobExecutor).submitOneshotJob(isNull(), isNull(), isNull());
    verify(jobState).clone();
    assertSame(jobState2, actualLaunchJobResult);
  }

  /**
   * Method under test: {@link JobProcessor#launchJob(JobState)}
   */
  @Test
  void testLaunchJob3() {
    // Arrange
    BatchJobExecutor<Serializable> jobExecutor = mock(BatchJobExecutor.class);
    when(jobExecutor.submitOneshotJob(Mockito.<TagHeader>any(), Mockito.<JobConfig>any(), Mockito.<RuntimeConfig>any()))
        .thenReturn(new BatchJobState<>());
    JobProcessor jobProcessor = new JobProcessor(PlatformConfig.getDefaultInstance(), null, mock(GrpcConcern.class),
        jobExecutor);
    JobState jobState = mock(JobState.class);
    when(jobState.clone()).thenThrow(new EConsistencyValidation("Not all who wander are lost"));

    // Act and Assert
    assertThrows(EConsistencyValidation.class, () -> jobProcessor.launchJob(jobState));
    verify(jobExecutor).submitOneshotJob(isNull(), isNull(), isNull());
    verify(jobState).clone();
  }

  /**
   * Method under test: {@link JobProcessor#pollExecutorJobs(List)}
   */
  @Test
  void testPollExecutorJobs() {
    // Arrange
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor jobProcessor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act and Assert
    assertTrue(jobProcessor.pollExecutorJobs(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link JobProcessor#fetchJobResult(JobState)}
   */
  @Test
  void testFetchJobResult() {
    // Arrange
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor jobProcessor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> jobProcessor.fetchJobResult(new JobState()));
  }

  /**
   * Method under test: {@link JobProcessor#cleanUpJob(JobState)}
   */
  @Test
  void testCleanUpJob() {
    // Arrange
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor jobProcessor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act
    JobState actualCleanUpJobResult = jobProcessor.cleanUpJob(new JobState());

    // Assert
    assertNull(actualCleanUpJobResult.executorState);
    assertNull(actualCleanUpJobResult.errorDetail);
    assertNull(actualCleanUpJobResult.jobKey);
    assertNull(actualCleanUpJobResult.statusMessage);
    assertNull(actualCleanUpJobResult.tenant);
    assertNull(actualCleanUpJobResult.jobRequest);
    assertNull(actualCleanUpJobResult.executorResult);
    assertNull(actualCleanUpJobResult.executorStatus);
    assertNull(actualCleanUpJobResult.requestMetadata);
    assertNull(actualCleanUpJobResult.userMetadata);
    assertNull(actualCleanUpJobResult.clientConfig);
    assertNull(actualCleanUpJobResult.clientState);
    assertNull(actualCleanUpJobResult.jobConfig);
    assertNull(actualCleanUpJobResult.sysConfig);
    assertNull(actualCleanUpJobResult.definition);
    assertNull(actualCleanUpJobResult.tracStatus);
    assertNull(actualCleanUpJobResult.jobType);
    assertNull(actualCleanUpJobResult.jobId);
    assertEquals(0, actualCleanUpJobResult.retries);
    assertTrue(actualCleanUpJobResult.resourceMapping.isEmpty());
    assertTrue(actualCleanUpJobResult.resources.isEmpty());
    assertTrue(actualCleanUpJobResult.resultMapping.isEmpty());
    assertEquals(CacheStatus.READY_TO_REMOVE, actualCleanUpJobResult.cacheStatus);
  }

  /**
   * Method under test: {@link JobProcessor#scheduleRemoval(JobState)}
   */
  @Test
  void testScheduleRemoval() {
    // Arrange
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor jobProcessor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    // Act
    JobState actualScheduleRemovalResult = jobProcessor.scheduleRemoval(new JobState());

    // Assert
    assertNull(actualScheduleRemovalResult.executorState);
    assertNull(actualScheduleRemovalResult.errorDetail);
    assertNull(actualScheduleRemovalResult.jobKey);
    assertNull(actualScheduleRemovalResult.statusMessage);
    assertNull(actualScheduleRemovalResult.tenant);
    assertNull(actualScheduleRemovalResult.jobRequest);
    assertNull(actualScheduleRemovalResult.executorResult);
    assertNull(actualScheduleRemovalResult.executorStatus);
    assertNull(actualScheduleRemovalResult.requestMetadata);
    assertNull(actualScheduleRemovalResult.userMetadata);
    assertNull(actualScheduleRemovalResult.clientConfig);
    assertNull(actualScheduleRemovalResult.clientState);
    assertNull(actualScheduleRemovalResult.jobConfig);
    assertNull(actualScheduleRemovalResult.sysConfig);
    assertNull(actualScheduleRemovalResult.definition);
    assertNull(actualScheduleRemovalResult.tracStatus);
    assertNull(actualScheduleRemovalResult.jobType);
    assertNull(actualScheduleRemovalResult.jobId);
    assertEquals(0, actualScheduleRemovalResult.retries);
    assertTrue(actualScheduleRemovalResult.resourceMapping.isEmpty());
    assertTrue(actualScheduleRemovalResult.resources.isEmpty());
    assertTrue(actualScheduleRemovalResult.resultMapping.isEmpty());
    assertEquals(CacheStatus.REMOVAL_SCHEDULED, actualScheduleRemovalResult.cacheStatus);
  }
}

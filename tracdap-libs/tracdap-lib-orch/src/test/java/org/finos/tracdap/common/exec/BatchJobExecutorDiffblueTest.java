package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.grpc.GrpcChannelFactory;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.config.RuntimeConfig;
import org.finos.tracdap.config.StorageConfig;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BatchJobExecutorDiffblueTest {
  /**
   * Method under test: {@link BatchJobExecutor#start(GrpcChannelFactory)}
   */
  @Test
  void testStart() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).start();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    batchJobExecutor.start(mock(GrpcChannelFactory.class));

    // Assert
    verify(batchExecutor).start();
  }

  /**
   * Method under test: {@link BatchJobExecutor#start(GrpcChannelFactory)}
   */
  @Test
  void testStart2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor).start();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.start(mock(GrpcChannelFactory.class)));
    verify(batchExecutor).start();
  }

  /**
   * Method under test: {@link BatchJobExecutor#stop()}
   */
  @Test
  void testStop() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).stop();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    batchJobExecutor.stop();

    // Assert that nothing has changed
    verify(batchExecutor).stop();
  }

  /**
   * Method under test: {@link BatchJobExecutor#stop()}
   */
  @Test
  void testStop2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor).stop();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.stop());
    verify(batchExecutor).stop();
  }

  /**
   * Method under test: {@link BatchJobExecutor#stateClass()}
   */
  @Test
  void testStateClass() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act
    Class<BatchJobState<Serializable>> actualStateClassResult = batchJobExecutor.stateClass();

    // Assert
    Class<BatchJobState> expectedStateClassResult = BatchJobState.class;
    assertEquals(expectedStateClassResult, actualStateClassResult);
  }

  /**
   * Method under test: {@link BatchJobExecutor#submitJob()}
   */
  @Test
  void testSubmitJob() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.submitJob());
  }

  /**
   * Method under test:
   * {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}
   */
  @Test
  void testSubmitOneshotJob() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(batchExecutor.configureBatchStorage(Mockito.<String>any(), Mockito.<Serializable>any(),
        Mockito.<StorageConfig>any(), Mockito.<Consumer<StorageConfig>>any())).thenReturn(simpleDateFormat);
    when(batchExecutor.hasFeature(Mockito.<IBatchExecutor.Feature>any())).thenReturn(true);
    when(batchExecutor.addFile(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<byte[]>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.addVolume(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<String>any(),
        Mockito.<BatchVolumeType>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.createBatch(Mockito.<String>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.submitBatch(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<BatchConfig>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);
    TagHeader jobId = TagHeader.getDefaultInstance();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act
    BatchJobState<Serializable> actualSubmitOneshotJobResult = batchJobExecutor.submitOneshotJob(jobId, jobConfig,
        RuntimeConfig.getDefaultInstance());

    // Assert
    verify(batchExecutor, atLeast(1)).addFile(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class), eq("config"),
        Mockito.<String>any(), Mockito.<byte[]>any());
    verify(batchExecutor, atLeast(1)).addVolume(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class),
        Mockito.<String>any(), Mockito.<BatchVolumeType>any());
    verify(batchExecutor).configureBatchStorage(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class),
        isA(StorageConfig.class), isA(Consumer.class));
    verify(batchExecutor).createBatch(eq("OBJECT_TYPE_NOT_SET--v0"));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<IBatchExecutor.Feature>any());
    verify(batchExecutor).submitBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class), isA(BatchConfig.class));
    Serializable serializable = actualSubmitOneshotJobResult.batchState;
    assertTrue(serializable instanceof SimpleDateFormat);
    assertEquals("OBJECT_TYPE_NOT_SET--v0", actualSubmitOneshotJobResult.batchKey);
    assertTrue(actualSubmitOneshotJobResult.logVolumeEnabled);
    assertTrue(actualSubmitOneshotJobResult.resultVolumeEnabled);
    assertTrue(actualSubmitOneshotJobResult.runtimeApiEnabled);
    assertEquals(simpleDateFormat, serializable);
  }

  /**
   * Method under test:
   * {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}
   */
  @Test
  void testSubmitOneshotJob2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    when(batchExecutor.configureBatchStorage(Mockito.<String>any(), Mockito.<Serializable>any(),
        Mockito.<StorageConfig>any(), Mockito.<Consumer<StorageConfig>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    when(batchExecutor.hasFeature(Mockito.<IBatchExecutor.Feature>any())).thenReturn(true);
    when(batchExecutor.createBatch(Mockito.<String>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);
    TagHeader jobId = TagHeader.getDefaultInstance();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> batchJobExecutor.submitOneshotJob(jobId, jobConfig, RuntimeConfig.getDefaultInstance()));
    verify(batchExecutor).configureBatchStorage(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class),
        isA(StorageConfig.class), isA(Consumer.class));
    verify(batchExecutor).createBatch(eq("OBJECT_TYPE_NOT_SET--v0"));
    verify(batchExecutor).deleteBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<IBatchExecutor.Feature>any());
  }

  /**
   * Method under test:
   * {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}
   */
  @Test
  void testSubmitOneshotJob3() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor)
        .deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    when(batchExecutor.configureBatchStorage(Mockito.<String>any(), Mockito.<Serializable>any(),
        Mockito.<StorageConfig>any(), Mockito.<Consumer<StorageConfig>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    when(batchExecutor.hasFeature(Mockito.<IBatchExecutor.Feature>any())).thenReturn(true);
    when(batchExecutor.createBatch(Mockito.<String>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);
    TagHeader jobId = TagHeader.getDefaultInstance();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> batchJobExecutor.submitOneshotJob(jobId, jobConfig, RuntimeConfig.getDefaultInstance()));
    verify(batchExecutor).configureBatchStorage(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class),
        isA(StorageConfig.class), isA(Consumer.class));
    verify(batchExecutor).createBatch(eq("OBJECT_TYPE_NOT_SET--v0"));
    verify(batchExecutor).deleteBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<IBatchExecutor.Feature>any());
  }

  /**
   * Method under test:
   * {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}
   */
  @Test
  void testSubmitOneshotJob4() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.hasFeature(Mockito.<IBatchExecutor.Feature>any())).thenReturn(false);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(batchExecutor.addFile(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<byte[]>any())).thenReturn(simpleDateFormat);
    when(batchExecutor.addVolume(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<String>any(),
        Mockito.<BatchVolumeType>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.createBatch(Mockito.<String>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.submitBatch(Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<BatchConfig>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);
    TagHeader jobId = TagHeader.getDefaultInstance();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act
    BatchJobState<Serializable> actualSubmitOneshotJobResult = batchJobExecutor.submitOneshotJob(jobId, jobConfig,
        RuntimeConfig.getDefaultInstance());

    // Assert
    verify(batchExecutor, atLeast(1)).addFile(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class), eq("config"),
        Mockito.<String>any(), Mockito.<byte[]>any());
    verify(batchExecutor, atLeast(1)).addVolume(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class),
        Mockito.<String>any(), Mockito.<BatchVolumeType>any());
    verify(batchExecutor).createBatch(eq("OBJECT_TYPE_NOT_SET--v0"));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<IBatchExecutor.Feature>any());
    verify(batchExecutor).submitBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class), isA(BatchConfig.class));
    Serializable serializable = actualSubmitOneshotJobResult.batchState;
    assertTrue(serializable instanceof SimpleDateFormat);
    assertEquals("OBJECT_TYPE_NOT_SET--v0", actualSubmitOneshotJobResult.batchKey);
    assertFalse(actualSubmitOneshotJobResult.logVolumeEnabled);
    assertFalse(actualSubmitOneshotJobResult.resultVolumeEnabled);
    assertFalse(actualSubmitOneshotJobResult.runtimeApiEnabled);
    assertEquals(simpleDateFormat, serializable);
  }

  /**
   * Method under test: {@link BatchJobExecutor#submitExternalJob()}
   */
  @Test
  void testSubmitExternalJob() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.submitExternalJob());
  }

  /**
   * Method under test: {@link BatchJobExecutor#cancelJob(BatchJobState)}
   */
  @Test
  void testCancelJob() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.cancelBatch(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.cancelJob(new BatchJobState<>()));
    verify(batchExecutor).cancelBatch(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#deleteJob(BatchJobState)}
   */
  @Test
  void testDeleteJob() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    batchJobExecutor.deleteJob(new BatchJobState<>());

    // Assert
    verify(batchExecutor).deleteBatch(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#deleteJob(BatchJobState)}
   */
  @Test
  void testDeleteJob2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor)
        .deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.deleteJob(new BatchJobState<>()));
    verify(batchExecutor).deleteBatch(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#listJobs()}
   */
  @Test
  void testListJobs() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.listJobs());
  }

  /**
   * Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  void testGetJobStatus() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.getJobStatus(new BatchJobState<>()));
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#getJobResult(BatchJobState)}
   */
  @Test
  void testGetJobResult() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.STATUS_UNKNOWN));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.getJobResult(new BatchJobState<>()));
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#getJobResult(BatchJobState)}
   */
  @Test
  void testGetJobResult2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.getJobResult(new BatchJobState<>()));
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
  }

  /**
   * Method under test: {@link BatchJobExecutor#BatchJobExecutor(IBatchExecutor)}
   */
  @Test
  void testNewBatchJobExecutor() {
    // Arrange and Act
    BatchJobExecutor<Serializable> actualBatchJobExecutor = new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Assert
    Class<BatchJobState> expectedStateClassResult = BatchJobState.class;
    assertEquals(expectedStateClassResult, actualBatchJobExecutor.stateClass());
  }

  /**
   * Method under test: {@link BatchJobExecutor#BatchJobExecutor(IBatchExecutor)}
   */
  @Test
  void testNewBatchJobExecutor2() {
    // Arrange and Act
    BatchJobExecutor<Serializable> actualBatchJobExecutor = new BatchJobExecutor<>(null);

    // Assert
    Class<BatchJobState> expectedStateClassResult = BatchJobState.class;
    assertEquals(expectedStateClassResult, actualBatchJobExecutor.stateClass());
  }
}

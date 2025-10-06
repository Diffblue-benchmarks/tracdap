package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import org.finos.tracdap.api.internal.RuntimeJobStatus;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exec.IBatchExecutor.Feature;
import org.finos.tracdap.common.grpc.GrpcChannelFactory;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.config.RuntimeConfig;
import org.finos.tracdap.config.StorageConfig;
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BatchJobExecutorDiffblueTest {
  /**
   * Test {@link BatchJobExecutor#BatchJobExecutor(IBatchExecutor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return stateClass is {@link BatchJobState}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#BatchJobExecutor(IBatchExecutor)}
   */
  @Test
  @DisplayName(
      "Test new BatchJobExecutor(IBatchExecutor); when 'null'; then return stateClass is BatchJobState")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.<init>(IBatchExecutor)"})
  void testNewBatchJobExecutor_whenNull_thenReturnStateClassIsBatchJobState() {
    // Arrange and Act
    BatchJobExecutor<Serializable> actualBatchJobExecutor = new BatchJobExecutor<>(null);

    // Assert
    Class<BatchJobState> expectedStateClassResult = BatchJobState.class;
    assertEquals(expectedStateClassResult, actualBatchJobExecutor.stateClass());
  }

  /**
   * Test {@link BatchJobExecutor#start(GrpcChannelFactory)}.
   *
   * <ul>
   *   <li>Given {@link IBatchExecutor} {@link IBatchExecutor#start()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#start(GrpcChannelFactory)}
   */
  @Test
  @DisplayName("Test start(GrpcChannelFactory); given IBatchExecutor start() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.start(GrpcChannelFactory)"})
  void testStart_givenIBatchExecutorStartDoesNothing() {
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
   * Test {@link BatchJobExecutor#start(GrpcChannelFactory)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#start(GrpcChannelFactory)}
   */
  @Test
  @DisplayName("Test start(GrpcChannelFactory); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.start(GrpcChannelFactory)"})
  void testStart_thenThrowETracInternal() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor).start();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.start(mock(GrpcChannelFactory.class)));
    verify(batchExecutor).start();
  }

  /**
   * Test {@link BatchJobExecutor#stop()}.
   *
   * <ul>
   *   <li>Given {@link IBatchExecutor} {@link IBatchExecutor#stop()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#stop()}
   */
  @Test
  @DisplayName("Test stop(); given IBatchExecutor stop() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.stop()"})
  void testStop_givenIBatchExecutorStopDoesNothing() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).stop();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    batchJobExecutor.stop();

    // Assert
    verify(batchExecutor).stop();
  }

  /**
   * Test {@link BatchJobExecutor#stop()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#stop()}
   */
  @Test
  @DisplayName("Test stop(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.stop()"})
  void testStop_thenThrowETracInternal() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost")).when(batchExecutor).stop();
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.stop());
    verify(batchExecutor).stop();
  }

  /**
   * Test {@link BatchJobExecutor#stateClass()}.
   *
   * <p>Method under test: {@link BatchJobExecutor#stateClass()}
   */
  @Test
  @DisplayName("Test stateClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BatchJobExecutor.stateClass()"})
  void testStateClass() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor =
        new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act
    Class<BatchJobState<Serializable>> actualStateClassResult = batchJobExecutor.stateClass();

    // Assert
    Class<BatchJobState> expectedStateClassResult = BatchJobState.class;
    assertEquals(expectedStateClassResult, actualStateClassResult);
  }

  /**
   * Test {@link BatchJobExecutor#submitJob()}.
   *
   * <p>Method under test: {@link BatchJobExecutor#submitJob()}
   */
  @Test
  @DisplayName("Test submitJob()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchJobState BatchJobExecutor.submitJob()"})
  void testSubmitJob() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor =
        new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.submitJob());
  }

  /**
   * Test {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}.
   *
   * <p>Method under test: {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig,
   * RuntimeConfig)}
   */
  @Test
  @DisplayName("Test submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BatchJobState BatchJobExecutor.submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)"
  })
  void testSubmitOneshotJob() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.createBatch(Mockito.<String>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            batchJobExecutor.submitOneshotJob(
                TagHeader.getDefaultInstance(),
                JobConfig.getDefaultInstance(),
                RuntimeConfig.getDefaultInstance()));
    verify(batchExecutor).createBatch("OBJECT_TYPE_NOT_SET--v0");
  }

  /**
   * Test {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}.
   *
   * <p>Method under test: {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig,
   * RuntimeConfig)}
   */
  @Test
  @DisplayName("Test submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BatchJobState BatchJobExecutor.submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)"
  })
  void testSubmitOneshotJob2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(batchExecutor)
        .deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    when(batchExecutor.configureBatchStorage(
            Mockito.<String>any(),
            Mockito.<Serializable>any(),
            Mockito.<StorageConfig>any(),
            Mockito.<Consumer<StorageConfig>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    when(batchExecutor.hasFeature(Mockito.<Feature>any())).thenReturn(true);
    when(batchExecutor.createBatch(Mockito.<String>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            batchJobExecutor.submitOneshotJob(
                TagHeader.getDefaultInstance(),
                JobConfig.getDefaultInstance(),
                RuntimeConfig.getDefaultInstance()));
    verify(batchExecutor)
        .configureBatchStorage(
            eq("OBJECT_TYPE_NOT_SET--v0"),
            isA(Serializable.class),
            isA(StorageConfig.class),
            isA(Consumer.class));
    verify(batchExecutor).createBatch("OBJECT_TYPE_NOT_SET--v0");
    verify(batchExecutor).deleteBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<Feature>any());
  }

  /**
   * Test {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}.
   *
   * <ul>
   *   <li>Given {@link IBatchExecutor} {@link IBatchExecutor#deleteBatch(String, Serializable)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig,
   * RuntimeConfig)}
   */
  @Test
  @DisplayName(
      "Test submitOneshotJob(TagHeader, JobConfig, RuntimeConfig); given IBatchExecutor deleteBatch(String, Serializable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BatchJobState BatchJobExecutor.submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)"
  })
  void testSubmitOneshotJob_givenIBatchExecutorDeleteBatchDoesNothing() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doNothing().when(batchExecutor).deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    when(batchExecutor.configureBatchStorage(
            Mockito.<String>any(),
            Mockito.<Serializable>any(),
            Mockito.<StorageConfig>any(),
            Mockito.<Consumer<StorageConfig>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    when(batchExecutor.hasFeature(Mockito.<Feature>any())).thenReturn(true);
    when(batchExecutor.createBatch(Mockito.<String>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            batchJobExecutor.submitOneshotJob(
                TagHeader.getDefaultInstance(),
                JobConfig.getDefaultInstance(),
                RuntimeConfig.getDefaultInstance()));
    verify(batchExecutor)
        .configureBatchStorage(
            eq("OBJECT_TYPE_NOT_SET--v0"),
            isA(Serializable.class),
            isA(StorageConfig.class),
            isA(Consumer.class));
    verify(batchExecutor).createBatch("OBJECT_TYPE_NOT_SET--v0");
    verify(batchExecutor).deleteBatch(eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class));
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<Feature>any());
  }

  /**
   * Test {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)}.
   *
   * <ul>
   *   <li>Then {@link BatchJobState#batchState} return {@link SimpleDateFormat}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#submitOneshotJob(TagHeader, JobConfig,
   * RuntimeConfig)}
   */
  @Test
  @DisplayName(
      "Test submitOneshotJob(TagHeader, JobConfig, RuntimeConfig); then batchState return SimpleDateFormat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BatchJobState BatchJobExecutor.submitOneshotJob(TagHeader, JobConfig, RuntimeConfig)"
  })
  void testSubmitOneshotJob_thenBatchStateReturnSimpleDateFormat() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    when(batchExecutor.configureBatchStorage(
            Mockito.<String>any(),
            Mockito.<Serializable>any(),
            Mockito.<StorageConfig>any(),
            Mockito.<Consumer<StorageConfig>>any()))
        .thenReturn(simpleDateFormat);
    when(batchExecutor.hasFeature(Mockito.<Feature>any())).thenReturn(true);
    when(batchExecutor.addFile(
            Mockito.<String>any(),
            Mockito.<Serializable>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<byte[]>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.addVolume(
            Mockito.<String>any(),
            Mockito.<Serializable>any(),
            Mockito.<String>any(),
            Mockito.<BatchVolumeType>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.createBatch(Mockito.<String>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(batchExecutor.submitBatch(
            Mockito.<String>any(), Mockito.<Serializable>any(), Mockito.<BatchConfig>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    BatchJobState<Serializable> actualSubmitOneshotJobResult =
        batchJobExecutor.submitOneshotJob(
            TagHeader.getDefaultInstance(),
            JobConfig.getDefaultInstance(),
            RuntimeConfig.getDefaultInstance());

    // Assert
    verify(batchExecutor, atLeast(1))
        .addFile(
            eq("OBJECT_TYPE_NOT_SET--v0"),
            isA(Serializable.class),
            eq("config"),
            Mockito.<String>any(),
            Mockito.<byte[]>any());
    verify(batchExecutor, atLeast(1))
        .addVolume(
            eq("OBJECT_TYPE_NOT_SET--v0"),
            isA(Serializable.class),
            Mockito.<String>any(),
            Mockito.<BatchVolumeType>any());
    verify(batchExecutor)
        .configureBatchStorage(
            eq("OBJECT_TYPE_NOT_SET--v0"),
            isA(Serializable.class),
            isA(StorageConfig.class),
            isA(Consumer.class));
    verify(batchExecutor).createBatch("OBJECT_TYPE_NOT_SET--v0");
    verify(batchExecutor, atLeast(1)).hasFeature(Mockito.<Feature>any());
    verify(batchExecutor)
        .submitBatch(
            eq("OBJECT_TYPE_NOT_SET--v0"), isA(Serializable.class), isA(BatchConfig.class));
    Serializable serializable = actualSubmitOneshotJobResult.batchState;
    assertTrue(serializable instanceof SimpleDateFormat);
    assertEquals("OBJECT_TYPE_NOT_SET--v0", actualSubmitOneshotJobResult.batchKey);
    assertTrue(actualSubmitOneshotJobResult.logVolumeEnabled);
    assertTrue(actualSubmitOneshotJobResult.resultVolumeEnabled);
    assertTrue(actualSubmitOneshotJobResult.runtimeApiEnabled);
    assertEquals(simpleDateFormat, serializable);
  }

  /**
   * Test {@link BatchJobExecutor#submitExternalJob()}.
   *
   * <p>Method under test: {@link BatchJobExecutor#submitExternalJob()}
   */
  @Test
  @DisplayName("Test submitExternalJob()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchJobState BatchJobExecutor.submitExternalJob()"})
  void testSubmitExternalJob() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor =
        new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.submitExternalJob());
  }

  /**
   * Test {@link BatchJobExecutor#cancelJob(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then {@link BatchJobState} (default constructor) {@link BatchJobState#batchState} {@link
   *       SimpleDateFormat}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#cancelJob(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test cancelJob(BatchJobState) with 'BatchJobState'; then BatchJobState (default constructor) batchState SimpleDateFormat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchJobState BatchJobExecutor.cancelJob(BatchJobState)"})
  void testCancelJobWithBatchJobState_thenBatchJobStateBatchStateSimpleDateFormat() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.cancelBatch(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);
    BatchJobState<Serializable> jobState = new BatchJobState<>();

    // Act
    BatchJobState<Serializable> actualCancelJobResult = batchJobExecutor.cancelJob(jobState);

    // Assert
    verify(batchExecutor).cancelBatch(isNull(), isNull());
    Serializable serializable = jobState.batchState;
    assertTrue(serializable instanceof SimpleDateFormat);
    assertEquals("yyyy/mm/dd", ((SimpleDateFormat) serializable).toPattern());
    assertTrue(((SimpleDateFormat) serializable).isLenient());
    assertSame(jobState, actualCancelJobResult);
  }

  /**
   * Test {@link BatchJobExecutor#cancelJob(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#cancelJob(BatchJobState)}
   */
  @Test
  @DisplayName("Test cancelJob(BatchJobState) with 'BatchJobState'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BatchJobState BatchJobExecutor.cancelJob(BatchJobState)"})
  void testCancelJobWithBatchJobState_thenThrowETracInternal() {
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
   * Test {@link BatchJobExecutor#deleteJob(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Given {@link IBatchExecutor} {@link IBatchExecutor#deleteBatch(String, Serializable)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#deleteJob(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test deleteJob(BatchJobState) with 'BatchJobState'; given IBatchExecutor deleteBatch(String, Serializable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.deleteJob(BatchJobState)"})
  void testDeleteJobWithBatchJobState_givenIBatchExecutorDeleteBatchDoesNothing() {
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
   * Test {@link BatchJobExecutor#deleteJob(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#deleteJob(BatchJobState)}
   */
  @Test
  @DisplayName("Test deleteJob(BatchJobState) with 'BatchJobState'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BatchJobExecutor.deleteJob(BatchJobState)"})
  void testDeleteJobWithBatchJobState_thenThrowETracInternal() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    doThrow(new ETracInternal("Not all who wander are lost"))
        .when(batchExecutor)
        .deleteBatch(Mockito.<String>any(), Mockito.<Serializable>any());
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.deleteJob(new BatchJobState<>()));
    verify(batchExecutor).deleteBatch(isNull(), isNull());
  }

  /**
   * Test {@link BatchJobExecutor#listJobs()}.
   *
   * <p>Method under test: {@link BatchJobExecutor#listJobs()}
   */
  @Test
  @DisplayName("Test listJobs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List BatchJobExecutor.listJobs()"})
  void testListJobs() {
    // Arrange
    BatchJobExecutor<Serializable> batchJobExecutor =
        new BatchJobExecutor<>(mock(IBatchExecutor.class));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.listJobs());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsEight() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.SUCCEEDED));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(8, actualJobStatus.getStatusCodeValue());
    assertEquals(JobStatusCode.SUCCEEDED, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is five.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsFive() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.QUEUED));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(5, actualJobStatus.getStatusCodeValue());
    assertEquals(JobStatusCode.SUBMITTED, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is nine.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsNine() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.FAILED));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(9, actualJobStatus.getStatusCodeValue());
    assertEquals(JobStatusCode.FAILED, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is seven.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsSeven() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.COMPLETE));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(7, actualJobStatus.getStatusCodeValue());
    assertEquals(JobStatusCode.FINISHING, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is six.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsSix() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.RUNNING));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(6, actualJobStatus.getStatusCodeValue());
    assertEquals(JobStatusCode.RUNNING, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then return StatusCodeValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName(
      "Test getJobStatus(BatchJobState) with 'BatchJobState'; then return StatusCodeValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenReturnStatusCodeValueIsTen() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenReturn(new BatchStatus(BatchStatusCode.CANCELLED));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act
    RuntimeJobStatus actualJobStatus = batchJobExecutor.getJobStatus(new BatchJobState<>());

    // Assert
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
    assertEquals("", actualJobStatus.getInitializationErrorString());
    assertEquals("", actualJobStatus.getErrorDetail());
    assertEquals("", actualJobStatus.getStatusMessage());
    assertEquals(1, actualJobStatus.getAllFields().size());
    assertEquals(10, actualJobStatus.getStatusCodeValue());
    assertEquals(2, actualJobStatus.getSerializedSize());
    assertEquals(JobStatusCode.CANCELLED, actualJobStatus.getStatusCode());
    assertFalse(actualJobStatus.hasJobId());
    assertTrue(actualJobStatus.findInitializationErrors().isEmpty());
    assertTrue(actualJobStatus.isInitialized());
  }

  /**
   * Test {@link BatchJobExecutor#getJobStatus(BatchJobState)} with {@code BatchJobState}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobStatus(BatchJobState)}
   */
  @Test
  @DisplayName("Test getJobStatus(BatchJobState) with 'BatchJobState'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuntimeJobStatus BatchJobExecutor.getJobStatus(BatchJobState)"})
  void testGetJobStatusWithBatchJobState_thenThrowETracInternal() {
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
   * Test {@link BatchJobExecutor#getJobResult(BatchJobState)} with {@code BatchJobState}.
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobResult(BatchJobState)}
   */
  @Test
  @DisplayName("Test getJobResult(BatchJobState) with 'BatchJobState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.api.internal.RuntimeJobResult BatchJobExecutor.getJobResult(BatchJobState)"
  })
  void testGetJobResultWithBatchJobState() {
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
   * Test {@link BatchJobExecutor#getJobResult(BatchJobState)} with {@code BatchJobState}.
   *
   * <p>Method under test: {@link BatchJobExecutor#getJobResult(BatchJobState)}
   */
  @Test
  @DisplayName("Test getJobResult(BatchJobState) with 'BatchJobState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.api.internal.RuntimeJobResult BatchJobExecutor.getJobResult(BatchJobState)"
  })
  void testGetJobResultWithBatchJobState2() {
    // Arrange
    IBatchExecutor<Serializable> batchExecutor = mock(IBatchExecutor.class);
    when(batchExecutor.getBatchStatus(Mockito.<String>any(), Mockito.<Serializable>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    BatchJobExecutor<Serializable> batchJobExecutor = new BatchJobExecutor<>(batchExecutor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> batchJobExecutor.getJobResult(new BatchJobState<>()));
    verify(batchExecutor).getBatchStatus(isNull(), isNull());
  }
}

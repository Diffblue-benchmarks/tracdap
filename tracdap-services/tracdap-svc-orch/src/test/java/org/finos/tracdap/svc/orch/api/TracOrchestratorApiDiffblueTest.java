package org.finos.tracdap.svc.orch.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.internal.testing.StreamRecorder;
import io.grpc.stub.StreamObserver;
import io.netty.channel.DefaultEventLoop;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.finos.tracdap.api.JobRequest;
import org.finos.tracdap.api.JobStatus;
import org.finos.tracdap.api.JobStatusRequest;
import org.finos.tracdap.common.cache.IJobCache;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.exec.BatchJobExecutor;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.middleware.GrpcClientState;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.svc.orch.service.JobManager;
import org.finos.tracdap.svc.orch.service.JobProcessor;
import org.finos.tracdap.svc.orch.service.JobState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TracOrchestratorApiDiffblueTest {
  /**
   * Method under test:
   * {@link TracOrchestratorApi#validateJob(JobRequest, StreamObserver)}
   */
  @Test
  void testValidateJob() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenReturn(mock(GrpcClientState.class));
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns3 = mock(GrpcConcern.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns3, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.validateJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#validateJob(JobRequest, StreamObserver)}
   */
  @Test
  void testValidateJob2() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenReturn(mock(GrpcClientState.class));
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(
        new JobManager(config, processor, cache, new DefaultEventLoop()), null, commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.validateJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#validateJob(JobRequest, StreamObserver)}
   */
  @Test
  void testValidateJob3() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenThrow(new EUnexpected());
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns3 = mock(GrpcConcern.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns3, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.validateJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#submitJob(JobRequest, StreamObserver)}
   */
  @Test
  void testSubmitJob() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenReturn(mock(GrpcClientState.class));
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns3 = mock(GrpcConcern.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns3, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.submitJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#submitJob(JobRequest, StreamObserver)}
   */
  @Test
  void testSubmitJob2() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenReturn(mock(GrpcClientState.class));
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(
        new JobManager(config, processor, cache, new DefaultEventLoop()), null, commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.submitJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#submitJob(JobRequest, StreamObserver)}
   */
  @Test
  void testSubmitJob3() {
    // Arrange
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    when(commonConcerns.prepareClientCall(Mockito.<Context>any())).thenThrow(new EUnexpected());
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns2,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns3 = mock(GrpcConcern.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns3, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        commonConcerns);
    JobRequest request = JobRequest.getDefaultInstance();
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.submitJob(request, response);

    // Assert
    verify(commonConcerns).prepareClientCall(isA(Context.class));
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#checkJob(JobStatusRequest, StreamObserver)}
   */
  @Test
  void testCheckJob() {
    // Arrange
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);
    TracOrchestratorApi tracOrchestratorApi = new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns2, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        mock(GrpcConcern.class));
    StreamRecorder<JobStatus> response = StreamRecorder.create();

    // Act
    tracOrchestratorApi.checkJob(null, response);

    // Assert
    ListenableFuture<JobStatus> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.JobStatusRequest.getSelector()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.JobStatusRequest.getSelector()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApi#TracOrchestratorApi(JobManager, JobProcessor, GrpcConcern)}
   */
  @Test
  void testNewTracOrchestratorApi() {
    // Arrange
    PlatformConfig config = PlatformConfig.getDefaultInstance();
    PlatformConfig platformConfig = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns = mock(GrpcConcern.class);
    JobProcessor processor = new JobProcessor(platformConfig, null, commonConcerns,
        new BatchJobExecutor<>(mock(IBatchExecutor.class)));

    IJobCache<JobState> cache = mock(IJobCache.class);
    JobManager jobManager = new JobManager(config, processor, cache, new DefaultEventLoop());

    PlatformConfig platformConfig2 = PlatformConfig.getDefaultInstance();
    GrpcConcern commonConcerns2 = mock(GrpcConcern.class);

    // Act and Assert
    ServerServiceDefinition bindServiceResult = (new TracOrchestratorApi(jobManager,
        new JobProcessor(platformConfig2, null, commonConcerns2, new BatchJobExecutor<>(mock(IBatchExecutor.class))),
        mock(GrpcConcern.class))).bindService();
    ServiceDescriptor serviceDescriptor = bindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(4);
    assertEquals("cancelJob", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("followJob", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("submitJob", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("tracdap.api.TracOrchestratorApi", getResult4.getServiceName());
    assertEquals("tracdap.api.TracOrchestratorApi", getResult3.getServiceName());
    assertEquals("tracdap.api.TracOrchestratorApi", getResult2.getServiceName());
    assertEquals("tracdap.api.TracOrchestratorApi", getResult.getServiceName());
    assertEquals("tracdap.api.TracOrchestratorApi", serviceDescriptor.getName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", getResult4.getFullMethodName());
    assertEquals("validateJob", getResult4.getBareMethodName());
    assertEquals(5, bindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
  }
}

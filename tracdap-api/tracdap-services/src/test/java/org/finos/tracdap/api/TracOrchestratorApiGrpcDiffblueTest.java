package org.finos.tracdap.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

class TracOrchestratorApiGrpcDiffblueTest {
  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getValidateJobMethod()}
   */
  @Test
  void testGetValidateJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobRequest, JobStatus> actualValidateJobMethod = TracOrchestratorApiGrpc.getValidateJobMethod();

    // Assert
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", actualValidateJobMethod.getFullMethodName());
    assertEquals("validateJob", actualValidateJobMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualValidateJobMethod.getType());
    assertFalse(actualValidateJobMethod.isIdempotent());
    assertFalse(actualValidateJobMethod.isSafe());
    assertTrue(actualValidateJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualValidateJobMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getSubmitJobMethod()}
   */
  @Test
  void testGetSubmitJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobRequest, JobStatus> actualSubmitJobMethod = TracOrchestratorApiGrpc.getSubmitJobMethod();

    // Assert
    assertEquals("submitJob", actualSubmitJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", actualSubmitJobMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualSubmitJobMethod.getType());
    assertFalse(actualSubmitJobMethod.isIdempotent());
    assertFalse(actualSubmitJobMethod.isSafe());
    assertTrue(actualSubmitJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualSubmitJobMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getCheckJobMethod()}
   */
  @Test
  void testGetCheckJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualCheckJobMethod = TracOrchestratorApiGrpc.getCheckJobMethod();

    // Assert
    assertEquals("checkJob", actualCheckJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/checkJob", actualCheckJobMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCheckJobMethod.getType());
    assertFalse(actualCheckJobMethod.isIdempotent());
    assertFalse(actualCheckJobMethod.isSafe());
    assertTrue(actualCheckJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualCheckJobMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getFollowJobMethod()}
   */
  @Test
  void testGetFollowJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualFollowJobMethod = TracOrchestratorApiGrpc.getFollowJobMethod();

    // Assert
    assertEquals("followJob", actualFollowJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", actualFollowJobMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, actualFollowJobMethod.getType());
    assertFalse(actualFollowJobMethod.isIdempotent());
    assertFalse(actualFollowJobMethod.isSafe());
    assertTrue(actualFollowJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualFollowJobMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getCancelJobMethod()}
   */
  @Test
  void testGetCancelJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualCancelJobMethod = TracOrchestratorApiGrpc.getCancelJobMethod();

    // Assert
    assertEquals("cancelJob", actualCancelJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", actualCancelJobMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCancelJobMethod.getType());
    assertFalse(actualCancelJobMethod.isIdempotent());
    assertFalse(actualCancelJobMethod.isSafe());
    assertTrue(actualCancelJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualCancelJobMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#newStub(Channel)}
   */
  @Test
  void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiGrpc.TracOrchestratorApiStub actualNewStubResult = TracOrchestratorApiGrpc.newStub(channel);

    // Assert
    CallOptions callOptions = actualNewStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewStubResult.getChannel());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  void testNewBlockingV2Stub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiGrpc.TracOrchestratorApiBlockingV2Stub actualNewBlockingV2StubResult = TracOrchestratorApiGrpc
        .newBlockingV2Stub(channel);

    // Assert
    CallOptions callOptions = actualNewBlockingV2StubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewBlockingV2StubResult.getChannel());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiGrpc.TracOrchestratorApiBlockingStub actualNewBlockingStubResult = TracOrchestratorApiGrpc
        .newBlockingStub(channel);

    // Assert
    CallOptions callOptions = actualNewBlockingStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewBlockingStubResult.getChannel());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#newFutureStub(Channel)}
   */
  @Test
  void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiGrpc.TracOrchestratorApiFutureStub actualNewFutureStubResult = TracOrchestratorApiGrpc
        .newFutureStub(channel);

    // Assert
    CallOptions callOptions = actualNewFutureStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getOnReadyThreshold());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewFutureStubResult.getChannel());
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApiGrpc#bindService(TracOrchestratorApiGrpc.AsyncService)}
   */
  @Test
  void testBindService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracOrchestratorApiGrpc
        .bindService(mock(TracOrchestratorApiGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(4);
    assertEquals("cancelJob", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("followJob", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("submitJob", getResult3.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", getResult3.getFullMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", getResult4.getFullMethodName());
    assertEquals("validateJob", getResult4.getBareMethodName());
    assertEquals(5, actualBindServiceResult.getMethods().size());
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
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test:
   * {@link TracOrchestratorApiGrpc#bindService(TracOrchestratorApiGrpc.AsyncService)}
   */
  @Test
  void testBindService2() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracOrchestratorApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(4);
    assertEquals("cancelJob", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("followJob", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("submitJob", getResult3.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", getResult3.getFullMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", getResult4.getFullMethodName());
    assertEquals("validateJob", getResult4.getBareMethodName());
    assertEquals(5, actualBindServiceResult.getMethods().size());
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
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test: {@link TracOrchestratorApiGrpc#getServiceDescriptor()}
   */
  @Test
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracOrchestratorApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(4);
    assertEquals("cancelJob", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("checkJob", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("followJob", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("submitJob", getResult4.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/checkJob", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", getResult4.getFullMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", getResult5.getFullMethodName());
    assertEquals("validateJob", getResult5.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult5.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

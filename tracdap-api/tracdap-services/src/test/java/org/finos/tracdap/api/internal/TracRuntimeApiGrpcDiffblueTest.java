package org.finos.tracdap.api.internal;

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

class TracRuntimeApiGrpcDiffblueTest {
  /**
   * Method under test: {@link TracRuntimeApiGrpc#getListJobsMethod()}
   */
  @Test
  void testGetListJobsMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeListJobsRequest, RuntimeListJobsResponse> actualListJobsMethod = TracRuntimeApiGrpc
        .getListJobsMethod();

    // Assert
    assertEquals("listJobs", actualListJobsMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/listJobs", actualListJobsMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListJobsMethod.getType());
    assertFalse(actualListJobsMethod.isIdempotent());
    assertFalse(actualListJobsMethod.isSafe());
    assertTrue(actualListJobsMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualListJobsMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracRuntimeApiGrpc#getGetJobStatusMethod()}
   */
  @Test
  void testGetGetJobStatusMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeJobInfoRequest, RuntimeJobStatus> actualGetJobStatusMethod = TracRuntimeApiGrpc
        .getGetJobStatusMethod();

    // Assert
    assertEquals("getJobStatus", actualGetJobStatusMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobStatus", actualGetJobStatusMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetJobStatusMethod.getType());
    assertFalse(actualGetJobStatusMethod.isIdempotent());
    assertFalse(actualGetJobStatusMethod.isSafe());
    assertTrue(actualGetJobStatusMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualGetJobStatusMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracRuntimeApiGrpc#getGetJobResultMethod()}
   */
  @Test
  void testGetGetJobResultMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeJobInfoRequest, RuntimeJobResult> actualGetJobResultMethod = TracRuntimeApiGrpc
        .getGetJobResultMethod();

    // Assert
    assertEquals("getJobResult", actualGetJobResultMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobResult", actualGetJobResultMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetJobResultMethod.getType());
    assertFalse(actualGetJobResultMethod.isIdempotent());
    assertFalse(actualGetJobResultMethod.isSafe());
    assertTrue(actualGetJobResultMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualGetJobResultMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracRuntimeApiGrpc#newStub(Channel)}
   */
  @Test
  void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiGrpc.TracRuntimeApiStub actualNewStubResult = TracRuntimeApiGrpc.newStub(channel);

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
   * Method under test: {@link TracRuntimeApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  void testNewBlockingV2Stub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiGrpc.TracRuntimeApiBlockingV2Stub actualNewBlockingV2StubResult = TracRuntimeApiGrpc
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
   * Method under test: {@link TracRuntimeApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiGrpc.TracRuntimeApiBlockingStub actualNewBlockingStubResult = TracRuntimeApiGrpc
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
   * Method under test: {@link TracRuntimeApiGrpc#newFutureStub(Channel)}
   */
  @Test
  void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiGrpc.TracRuntimeApiFutureStub actualNewFutureStubResult = TracRuntimeApiGrpc.newFutureStub(channel);

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
   * {@link TracRuntimeApiGrpc#bindService(TracRuntimeApiGrpc.AsyncService)}
   */
  @Test
  void testBindService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracRuntimeApiGrpc
        .bindService(mock(TracRuntimeApiGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("getJobResult", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("getJobStatus", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("listJobs", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobResult", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobStatus", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/listJobs", getResult3.getFullMethodName());
    assertEquals(3, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test:
   * {@link TracRuntimeApiGrpc#bindService(TracRuntimeApiGrpc.AsyncService)}
   */
  @Test
  void testBindService2() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracRuntimeApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("getJobResult", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("getJobStatus", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("listJobs", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobResult", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobStatus", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/listJobs", getResult3.getFullMethodName());
    assertEquals(3, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test: {@link TracRuntimeApiGrpc#getServiceDescriptor()}
   */
  @Test
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracRuntimeApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("getJobResult", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("getJobStatus", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("listJobs", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobResult", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobStatus", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/listJobs", getResult3.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

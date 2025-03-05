package org.finos.tracdap.api.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.finos.tracdap.api.internal.TracRuntimeApiGrpc.AsyncService;
import org.finos.tracdap.api.internal.TracRuntimeApiGrpc.TracRuntimeApiBlockingStub;
import org.finos.tracdap.api.internal.TracRuntimeApiGrpc.TracRuntimeApiBlockingV2Stub;
import org.finos.tracdap.api.internal.TracRuntimeApiGrpc.TracRuntimeApiFutureStub;
import org.finos.tracdap.api.internal.TracRuntimeApiGrpc.TracRuntimeApiStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracRuntimeApiGrpcDiffblueTest {
  /**
   * Test {@link TracRuntimeApiGrpc#getListJobsMethod()}.
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#getListJobsMethod()}
   */
  @Test
  @DisplayName("Test getListJobsMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracRuntimeApiGrpc.getListJobsMethod()"})
  void testGetListJobsMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeListJobsRequest, RuntimeListJobsResponse> actualListJobsMethod = TracRuntimeApiGrpc
        .getListJobsMethod();

    // Assert
    assertEquals("listJobs", actualListJobsMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/listJobs", actualListJobsMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListJobsMethod.getType());
    assertFalse(actualListJobsMethod.isIdempotent());
    assertFalse(actualListJobsMethod.isSafe());
    assertTrue(actualListJobsMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualListJobsMethod.getServiceName());
  }

  /**
   * Test {@link TracRuntimeApiGrpc#getGetJobStatusMethod()}.
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#getGetJobStatusMethod()}
   */
  @Test
  @DisplayName("Test getGetJobStatusMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracRuntimeApiGrpc.getGetJobStatusMethod()"})
  void testGetGetJobStatusMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeJobInfoRequest, RuntimeJobStatus> actualGetJobStatusMethod = TracRuntimeApiGrpc
        .getGetJobStatusMethod();

    // Assert
    assertEquals("getJobStatus", actualGetJobStatusMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobStatus", actualGetJobStatusMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetJobStatusMethod.getType());
    assertFalse(actualGetJobStatusMethod.isIdempotent());
    assertFalse(actualGetJobStatusMethod.isSafe());
    assertTrue(actualGetJobStatusMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualGetJobStatusMethod.getServiceName());
  }

  /**
   * Test {@link TracRuntimeApiGrpc#getGetJobResultMethod()}.
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#getGetJobResultMethod()}
   */
  @Test
  @DisplayName("Test getGetJobResultMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracRuntimeApiGrpc.getGetJobResultMethod()"})
  void testGetGetJobResultMethod() {
    // Arrange and Act
    MethodDescriptor<RuntimeJobInfoRequest, RuntimeJobResult> actualGetJobResultMethod = TracRuntimeApiGrpc
        .getGetJobResultMethod();

    // Assert
    assertEquals("getJobResult", actualGetJobResultMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TracRuntimeApi/getJobResult", actualGetJobResultMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetJobResultMethod.getType());
    assertFalse(actualGetJobResultMethod.isIdempotent());
    assertFalse(actualGetJobResultMethod.isSafe());
    assertTrue(actualGetJobResultMethod.isSampledToLocalTracing());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualGetJobResultMethod.getServiceName());
  }

  /**
   * Test {@link TracRuntimeApiGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracRuntimeApiStub TracRuntimeApiGrpc.newStub(Channel)"})
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiStub actualNewStubResult = TracRuntimeApiGrpc.newStub(channel);

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
   * Test {@link TracRuntimeApiGrpc#newBlockingV2Stub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingV2Stub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracRuntimeApiBlockingV2Stub TracRuntimeApiGrpc.newBlockingV2Stub(Channel)"})
  void testNewBlockingV2Stub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiBlockingV2Stub actualNewBlockingV2StubResult = TracRuntimeApiGrpc.newBlockingV2Stub(channel);

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
   * Test {@link TracRuntimeApiGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracRuntimeApiBlockingStub TracRuntimeApiGrpc.newBlockingStub(Channel)"})
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiBlockingStub actualNewBlockingStubResult = TracRuntimeApiGrpc.newBlockingStub(channel);

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
   * Test {@link TracRuntimeApiGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracRuntimeApiFutureStub TracRuntimeApiGrpc.newFutureStub(Channel)"})
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracRuntimeApiFutureStub actualNewFutureStubResult = TracRuntimeApiGrpc.newFutureStub(channel);

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
   * Test {@link TracRuntimeApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracRuntimeApiGrpc.bindService(AsyncService)"})
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracRuntimeApiGrpc.bindService(mock(AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(3, actualBindServiceResult.getMethods().size());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracRuntimeApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracRuntimeApiGrpc.bindService(AsyncService)"})
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracRuntimeApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(3, actualBindServiceResult.getMethods().size());
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracRuntimeApiGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TracRuntimeApiGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceDescriptor TracRuntimeApiGrpc.getServiceDescriptor()"})
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracRuntimeApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(3, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(TracRuntimeApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

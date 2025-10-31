package org.finos.tracdap.api;

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
import org.finos.tracdap.api.TracOrchestratorApiGrpc.AsyncService;
import org.finos.tracdap.api.TracOrchestratorApiGrpc.TracOrchestratorApiBlockingStub;
import org.finos.tracdap.api.TracOrchestratorApiGrpc.TracOrchestratorApiBlockingV2Stub;
import org.finos.tracdap.api.TracOrchestratorApiGrpc.TracOrchestratorApiFutureStub;
import org.finos.tracdap.api.TracOrchestratorApiGrpc.TracOrchestratorApiStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracOrchestratorApiGrpcDiffblueTest {
  /**
   * Test {@link TracOrchestratorApiGrpc#getValidateJobMethod()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getValidateJobMethod()}
   */
  @Test
  @DisplayName("Test getValidateJobMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracOrchestratorApiGrpc.getValidateJobMethod()"})
  void testGetValidateJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobRequest, JobStatus> actualValidateJobMethod = TracOrchestratorApiGrpc.getValidateJobMethod();

    // Assert
    assertEquals("tracdap.api.TracOrchestratorApi/validateJob", actualValidateJobMethod.getFullMethodName());
    assertEquals("validateJob", actualValidateJobMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualValidateJobMethod.getType());
    assertFalse(actualValidateJobMethod.isIdempotent());
    assertFalse(actualValidateJobMethod.isSafe());
    assertTrue(actualValidateJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualValidateJobMethod.getServiceName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#getSubmitJobMethod()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getSubmitJobMethod()}
   */
  @Test
  @DisplayName("Test getSubmitJobMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracOrchestratorApiGrpc.getSubmitJobMethod()"})
  void testGetSubmitJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobRequest, JobStatus> actualSubmitJobMethod = TracOrchestratorApiGrpc.getSubmitJobMethod();

    // Assert
    assertEquals("submitJob", actualSubmitJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/submitJob", actualSubmitJobMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualSubmitJobMethod.getType());
    assertFalse(actualSubmitJobMethod.isIdempotent());
    assertFalse(actualSubmitJobMethod.isSafe());
    assertTrue(actualSubmitJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualSubmitJobMethod.getServiceName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#getCheckJobMethod()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getCheckJobMethod()}
   */
  @Test
  @DisplayName("Test getCheckJobMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracOrchestratorApiGrpc.getCheckJobMethod()"})
  void testGetCheckJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualCheckJobMethod = TracOrchestratorApiGrpc.getCheckJobMethod();

    // Assert
    assertEquals("checkJob", actualCheckJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/checkJob", actualCheckJobMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCheckJobMethod.getType());
    assertFalse(actualCheckJobMethod.isIdempotent());
    assertFalse(actualCheckJobMethod.isSafe());
    assertTrue(actualCheckJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualCheckJobMethod.getServiceName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#getFollowJobMethod()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getFollowJobMethod()}
   */
  @Test
  @DisplayName("Test getFollowJobMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracOrchestratorApiGrpc.getFollowJobMethod()"})
  void testGetFollowJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualFollowJobMethod = TracOrchestratorApiGrpc.getFollowJobMethod();

    // Assert
    assertEquals("followJob", actualFollowJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/followJob", actualFollowJobMethod.getFullMethodName());
    assertEquals(MethodType.SERVER_STREAMING, actualFollowJobMethod.getType());
    assertFalse(actualFollowJobMethod.isIdempotent());
    assertFalse(actualFollowJobMethod.isSafe());
    assertTrue(actualFollowJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualFollowJobMethod.getServiceName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#getCancelJobMethod()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getCancelJobMethod()}
   */
  @Test
  @DisplayName("Test getCancelJobMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracOrchestratorApiGrpc.getCancelJobMethod()"})
  void testGetCancelJobMethod() {
    // Arrange and Act
    MethodDescriptor<JobStatusRequest, JobStatus> actualCancelJobMethod = TracOrchestratorApiGrpc.getCancelJobMethod();

    // Assert
    assertEquals("cancelJob", actualCancelJobMethod.getBareMethodName());
    assertEquals("tracdap.api.TracOrchestratorApi/cancelJob", actualCancelJobMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCancelJobMethod.getType());
    assertFalse(actualCancelJobMethod.isIdempotent());
    assertFalse(actualCancelJobMethod.isSafe());
    assertTrue(actualCancelJobMethod.isSampledToLocalTracing());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualCancelJobMethod.getServiceName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracOrchestratorApiStub TracOrchestratorApiGrpc.newStub(Channel)"})
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiStub actualNewStubResult = TracOrchestratorApiGrpc.newStub(channel);

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
   * Test {@link TracOrchestratorApiGrpc#newBlockingV2Stub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingV2Stub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracOrchestratorApiBlockingV2Stub TracOrchestratorApiGrpc.newBlockingV2Stub(Channel)"})
  void testNewBlockingV2Stub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiBlockingV2Stub actualNewBlockingV2StubResult = TracOrchestratorApiGrpc
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
   * Test {@link TracOrchestratorApiGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracOrchestratorApiBlockingStub TracOrchestratorApiGrpc.newBlockingStub(Channel)"})
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiBlockingStub actualNewBlockingStubResult = TracOrchestratorApiGrpc.newBlockingStub(channel);

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
   * Test {@link TracOrchestratorApiGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracOrchestratorApiFutureStub TracOrchestratorApiGrpc.newFutureStub(Channel)"})
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracOrchestratorApiFutureStub actualNewFutureStubResult = TracOrchestratorApiGrpc.newFutureStub(channel);

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
   * Test {@link TracOrchestratorApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracOrchestratorApiGrpc.bindService(AsyncService)"})
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracOrchestratorApiGrpc.bindService(mock(AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(5, actualBindServiceResult.getMethods().size());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracOrchestratorApiGrpc.bindService(AsyncService)"})
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracOrchestratorApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(5, actualBindServiceResult.getMethods().size());
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracOrchestratorApiGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TracOrchestratorApiGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceDescriptor TracOrchestratorApiGrpc.getServiceDescriptor()"})
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracOrchestratorApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(5, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(TracOrchestratorApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

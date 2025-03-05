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
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataSearchResponse;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.api.internal.TrustedMetadataApiGrpc.AsyncService;
import org.finos.tracdap.api.internal.TrustedMetadataApiGrpc.TrustedMetadataApiBlockingStub;
import org.finos.tracdap.api.internal.TrustedMetadataApiGrpc.TrustedMetadataApiBlockingV2Stub;
import org.finos.tracdap.api.internal.TrustedMetadataApiGrpc.TrustedMetadataApiFutureStub;
import org.finos.tracdap.api.internal.TrustedMetadataApiGrpc.TrustedMetadataApiStub;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TrustedMetadataApiGrpcDiffblueTest {
  /**
   * Test {@link TrustedMetadataApiGrpc#getCreateObjectMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getCreateObjectMethod()}
   */
  @Test
  @DisplayName("Test getCreateObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getCreateObjectMethod()"})
  void testGetCreateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreateObjectMethod = TrustedMetadataApiGrpc
        .getCreateObjectMethod();

    // Assert
    assertEquals("createObject", actualCreateObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", actualCreateObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateObjectMethod.getType());
    assertFalse(actualCreateObjectMethod.isIdempotent());
    assertFalse(actualCreateObjectMethod.isSafe());
    assertTrue(actualCreateObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualCreateObjectMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getUpdateObjectMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getUpdateObjectMethod()}
   */
  @Test
  @DisplayName("Test getUpdateObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getUpdateObjectMethod()"})
  void testGetUpdateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateObjectMethod = TrustedMetadataApiGrpc
        .getUpdateObjectMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", actualUpdateObjectMethod.getFullMethodName());
    assertEquals("updateObject", actualUpdateObjectMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateObjectMethod.getType());
    assertFalse(actualUpdateObjectMethod.isIdempotent());
    assertFalse(actualUpdateObjectMethod.isSafe());
    assertTrue(actualUpdateObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualUpdateObjectMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getUpdateTagMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getUpdateTagMethod()}
   */
  @Test
  @DisplayName("Test getUpdateTagMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getUpdateTagMethod()"})
  void testGetUpdateTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateTagMethod = TrustedMetadataApiGrpc
        .getUpdateTagMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateTag", actualUpdateTagMethod.getFullMethodName());
    assertEquals("updateTag", actualUpdateTagMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateTagMethod.getType());
    assertFalse(actualUpdateTagMethod.isIdempotent());
    assertFalse(actualUpdateTagMethod.isSafe());
    assertTrue(actualUpdateTagMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualUpdateTagMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getPreallocateIdMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getPreallocateIdMethod()}
   */
  @Test
  @DisplayName("Test getPreallocateIdMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getPreallocateIdMethod()"})
  void testGetPreallocateIdMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualPreallocateIdMethod = TrustedMetadataApiGrpc
        .getPreallocateIdMethod();

    // Assert
    assertEquals("preallocateId", actualPreallocateIdMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/preallocateId",
        actualPreallocateIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualPreallocateIdMethod.getType());
    assertFalse(actualPreallocateIdMethod.isIdempotent());
    assertFalse(actualPreallocateIdMethod.isSafe());
    assertTrue(actualPreallocateIdMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualPreallocateIdMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getCreatePreallocatedObjectMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getCreatePreallocatedObjectMethod()}
   */
  @Test
  @DisplayName("Test getCreatePreallocatedObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getCreatePreallocatedObjectMethod()"})
  void testGetCreatePreallocatedObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreatePreallocatedObjectMethod = TrustedMetadataApiGrpc
        .getCreatePreallocatedObjectMethod();

    // Assert
    assertEquals("createPreallocatedObject", actualCreatePreallocatedObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createPreallocatedObject",
        actualCreatePreallocatedObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreatePreallocatedObjectMethod.getType());
    assertFalse(actualCreatePreallocatedObjectMethod.isIdempotent());
    assertFalse(actualCreatePreallocatedObjectMethod.isSafe());
    assertTrue(actualCreatePreallocatedObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualCreatePreallocatedObjectMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getWriteBatchMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getWriteBatchMethod()}
   */
  @Test
  @DisplayName("Test getWriteBatchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getWriteBatchMethod()"})
  void testGetWriteBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteBatchRequest, MetadataWriteBatchResponse> actualWriteBatchMethod = TrustedMetadataApiGrpc
        .getWriteBatchMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/writeBatch", actualWriteBatchMethod.getFullMethodName());
    assertEquals("writeBatch", actualWriteBatchMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualWriteBatchMethod.getType());
    assertFalse(actualWriteBatchMethod.isIdempotent());
    assertFalse(actualWriteBatchMethod.isSafe());
    assertTrue(actualWriteBatchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualWriteBatchMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getReadObjectMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getReadObjectMethod()}
   */
  @Test
  @DisplayName("Test getReadObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getReadObjectMethod()"})
  void testGetReadObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataReadRequest, org.finos.tracdap.metadata.Tag> actualReadObjectMethod = TrustedMetadataApiGrpc
        .getReadObjectMethod();

    // Assert
    assertEquals("readObject", actualReadObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readObject", actualReadObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadObjectMethod.getType());
    assertFalse(actualReadObjectMethod.isIdempotent());
    assertFalse(actualReadObjectMethod.isSafe());
    assertTrue(actualReadObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualReadObjectMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getReadBatchMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getReadBatchMethod()}
   */
  @Test
  @DisplayName("Test getReadBatchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getReadBatchMethod()"})
  void testGetReadBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataBatchRequest, MetadataBatchResponse> actualReadBatchMethod = TrustedMetadataApiGrpc
        .getReadBatchMethod();

    // Assert
    assertEquals("readBatch", actualReadBatchMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", actualReadBatchMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadBatchMethod.getType());
    assertFalse(actualReadBatchMethod.isIdempotent());
    assertFalse(actualReadBatchMethod.isSafe());
    assertTrue(actualReadBatchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualReadBatchMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getSearchMethod()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getSearchMethod()}
   */
  @Test
  @DisplayName("Test getSearchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TrustedMetadataApiGrpc.getSearchMethod()"})
  void testGetSearchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataSearchRequest, MetadataSearchResponse> actualSearchMethod = TrustedMetadataApiGrpc
        .getSearchMethod();

    // Assert
    assertEquals("search", actualSearchMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", actualSearchMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualSearchMethod.getType());
    assertFalse(actualSearchMethod.isIdempotent());
    assertFalse(actualSearchMethod.isSafe());
    assertTrue(actualSearchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualSearchMethod.getServiceName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustedMetadataApiStub TrustedMetadataApiGrpc.newStub(Channel)"})
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiStub actualNewStubResult = TrustedMetadataApiGrpc.newStub(channel);

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
   * Test {@link TrustedMetadataApiGrpc#newBlockingV2Stub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingV2Stub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustedMetadataApiBlockingV2Stub TrustedMetadataApiGrpc.newBlockingV2Stub(Channel)"})
  void testNewBlockingV2Stub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiBlockingV2Stub actualNewBlockingV2StubResult = TrustedMetadataApiGrpc.newBlockingV2Stub(channel);

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
   * Test {@link TrustedMetadataApiGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustedMetadataApiBlockingStub TrustedMetadataApiGrpc.newBlockingStub(Channel)"})
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiBlockingStub actualNewBlockingStubResult = TrustedMetadataApiGrpc.newBlockingStub(channel);

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
   * Test {@link TrustedMetadataApiGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustedMetadataApiFutureStub TrustedMetadataApiGrpc.newFutureStub(Channel)"})
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiFutureStub actualNewFutureStubResult = TrustedMetadataApiGrpc.newFutureStub(channel);

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
   * Test {@link TrustedMetadataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TrustedMetadataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TrustedMetadataApiGrpc.bindService(mock(AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(9, actualBindServiceResult.getMethods().size());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TrustedMetadataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TrustedMetadataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(9, actualBindServiceResult.getMethods().size());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TrustedMetadataApiGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TrustedMetadataApiGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceDescriptor TrustedMetadataApiGrpc.getServiceDescriptor()"})
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TrustedMetadataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

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
import org.finos.tracdap.api.TracMetadataApiGrpc.AsyncService;
import org.finos.tracdap.api.TracMetadataApiGrpc.TracMetadataApiBlockingStub;
import org.finos.tracdap.api.TracMetadataApiGrpc.TracMetadataApiBlockingV2Stub;
import org.finos.tracdap.api.TracMetadataApiGrpc.TracMetadataApiFutureStub;
import org.finos.tracdap.api.TracMetadataApiGrpc.TracMetadataApiStub;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracMetadataApiGrpcDiffblueTest {
  /**
   * Test {@link TracMetadataApiGrpc#getPlatformInfoMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getPlatformInfoMethod()}
   */
  @Test
  @DisplayName("Test getPlatformInfoMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getPlatformInfoMethod()"})
  void testGetPlatformInfoMethod() {
    // Arrange and Act
    MethodDescriptor<PlatformInfoRequest, PlatformInfoResponse> actualPlatformInfoMethod = TracMetadataApiGrpc
        .getPlatformInfoMethod();

    // Assert
    assertEquals("platformInfo", actualPlatformInfoMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", actualPlatformInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualPlatformInfoMethod.getType());
    assertFalse(actualPlatformInfoMethod.isIdempotent());
    assertFalse(actualPlatformInfoMethod.isSafe());
    assertTrue(actualPlatformInfoMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualPlatformInfoMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getListTenantsMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getListTenantsMethod()}
   */
  @Test
  @DisplayName("Test getListTenantsMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getListTenantsMethod()"})
  void testGetListTenantsMethod() {
    // Arrange and Act
    MethodDescriptor<ListTenantsRequest, ListTenantsResponse> actualListTenantsMethod = TracMetadataApiGrpc
        .getListTenantsMethod();

    // Assert
    assertEquals("listTenants", actualListTenantsMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", actualListTenantsMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListTenantsMethod.getType());
    assertFalse(actualListTenantsMethod.isIdempotent());
    assertFalse(actualListTenantsMethod.isSafe());
    assertTrue(actualListTenantsMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualListTenantsMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getClientConfigMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getClientConfigMethod()}
   */
  @Test
  @DisplayName("Test getClientConfigMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getClientConfigMethod()"})
  void testGetClientConfigMethod() {
    // Arrange and Act
    MethodDescriptor<ClientConfigRequest, ClientConfigResponse> actualClientConfigMethod = TracMetadataApiGrpc
        .getClientConfigMethod();

    // Assert
    assertEquals("clientConfig", actualClientConfigMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/clientConfig", actualClientConfigMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualClientConfigMethod.getType());
    assertFalse(actualClientConfigMethod.isIdempotent());
    assertFalse(actualClientConfigMethod.isSafe());
    assertTrue(actualClientConfigMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualClientConfigMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getListResourcesMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getListResourcesMethod()}
   */
  @Test
  @DisplayName("Test getListResourcesMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getListResourcesMethod()"})
  void testGetListResourcesMethod() {
    // Arrange and Act
    MethodDescriptor<ListResourcesRequest, ListResourcesResponse> actualListResourcesMethod = TracMetadataApiGrpc
        .getListResourcesMethod();

    // Assert
    assertEquals("listResources", actualListResourcesMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listResources", actualListResourcesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListResourcesMethod.getType());
    assertFalse(actualListResourcesMethod.isIdempotent());
    assertFalse(actualListResourcesMethod.isSafe());
    assertTrue(actualListResourcesMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualListResourcesMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getResourceInfoMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getResourceInfoMethod()}
   */
  @Test
  @DisplayName("Test getResourceInfoMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getResourceInfoMethod()"})
  void testGetResourceInfoMethod() {
    // Arrange and Act
    MethodDescriptor<ResourceInfoRequest, ResourceInfoResponse> actualResourceInfoMethod = TracMetadataApiGrpc
        .getResourceInfoMethod();

    // Assert
    assertEquals("resourceInfo", actualResourceInfoMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/resourceInfo", actualResourceInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualResourceInfoMethod.getType());
    assertFalse(actualResourceInfoMethod.isIdempotent());
    assertFalse(actualResourceInfoMethod.isSafe());
    assertTrue(actualResourceInfoMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualResourceInfoMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getCreateObjectMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getCreateObjectMethod()}
   */
  @Test
  @DisplayName("Test getCreateObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getCreateObjectMethod()"})
  void testGetCreateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreateObjectMethod = TracMetadataApiGrpc
        .getCreateObjectMethod();

    // Assert
    assertEquals("createObject", actualCreateObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/createObject", actualCreateObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateObjectMethod.getType());
    assertFalse(actualCreateObjectMethod.isIdempotent());
    assertFalse(actualCreateObjectMethod.isSafe());
    assertTrue(actualCreateObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualCreateObjectMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getUpdateObjectMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getUpdateObjectMethod()}
   */
  @Test
  @DisplayName("Test getUpdateObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getUpdateObjectMethod()"})
  void testGetUpdateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateObjectMethod = TracMetadataApiGrpc
        .getUpdateObjectMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/updateObject", actualUpdateObjectMethod.getFullMethodName());
    assertEquals("updateObject", actualUpdateObjectMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateObjectMethod.getType());
    assertFalse(actualUpdateObjectMethod.isIdempotent());
    assertFalse(actualUpdateObjectMethod.isSafe());
    assertTrue(actualUpdateObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualUpdateObjectMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getUpdateTagMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getUpdateTagMethod()}
   */
  @Test
  @DisplayName("Test getUpdateTagMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getUpdateTagMethod()"})
  void testGetUpdateTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateTagMethod = TracMetadataApiGrpc.getUpdateTagMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/updateTag", actualUpdateTagMethod.getFullMethodName());
    assertEquals("updateTag", actualUpdateTagMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateTagMethod.getType());
    assertFalse(actualUpdateTagMethod.isIdempotent());
    assertFalse(actualUpdateTagMethod.isSafe());
    assertTrue(actualUpdateTagMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualUpdateTagMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getWriteBatchMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getWriteBatchMethod()}
   */
  @Test
  @DisplayName("Test getWriteBatchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getWriteBatchMethod()"})
  void testGetWriteBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteBatchRequest, MetadataWriteBatchResponse> actualWriteBatchMethod = TracMetadataApiGrpc
        .getWriteBatchMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/writeBatch", actualWriteBatchMethod.getFullMethodName());
    assertEquals("writeBatch", actualWriteBatchMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualWriteBatchMethod.getType());
    assertFalse(actualWriteBatchMethod.isIdempotent());
    assertFalse(actualWriteBatchMethod.isSafe());
    assertTrue(actualWriteBatchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualWriteBatchMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getReadObjectMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getReadObjectMethod()}
   */
  @Test
  @DisplayName("Test getReadObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getReadObjectMethod()"})
  void testGetReadObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataReadRequest, org.finos.tracdap.metadata.Tag> actualReadObjectMethod = TracMetadataApiGrpc
        .getReadObjectMethod();

    // Assert
    assertEquals("readObject", actualReadObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/readObject", actualReadObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadObjectMethod.getType());
    assertFalse(actualReadObjectMethod.isIdempotent());
    assertFalse(actualReadObjectMethod.isSafe());
    assertTrue(actualReadObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualReadObjectMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getReadBatchMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getReadBatchMethod()}
   */
  @Test
  @DisplayName("Test getReadBatchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getReadBatchMethod()"})
  void testGetReadBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataBatchRequest, MetadataBatchResponse> actualReadBatchMethod = TracMetadataApiGrpc
        .getReadBatchMethod();

    // Assert
    assertEquals("readBatch", actualReadBatchMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/readBatch", actualReadBatchMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadBatchMethod.getType());
    assertFalse(actualReadBatchMethod.isIdempotent());
    assertFalse(actualReadBatchMethod.isSafe());
    assertTrue(actualReadBatchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualReadBatchMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getSearchMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getSearchMethod()}
   */
  @Test
  @DisplayName("Test getSearchMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getSearchMethod()"})
  void testGetSearchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataSearchRequest, MetadataSearchResponse> actualSearchMethod = TracMetadataApiGrpc
        .getSearchMethod();

    // Assert
    assertEquals("search", actualSearchMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/search", actualSearchMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualSearchMethod.getType());
    assertFalse(actualSearchMethod.isIdempotent());
    assertFalse(actualSearchMethod.isSafe());
    assertTrue(actualSearchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualSearchMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getGetObjectMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getGetObjectMethod()}
   */
  @Test
  @DisplayName("Test getGetObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getGetObjectMethod()"})
  void testGetGetObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, org.finos.tracdap.metadata.Tag> actualGetObjectMethod = TracMetadataApiGrpc
        .getGetObjectMethod();

    // Assert
    assertEquals("getObject", actualGetObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getObject", actualGetObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetObjectMethod.getType());
    assertFalse(actualGetObjectMethod.isIdempotent());
    assertFalse(actualGetObjectMethod.isSafe());
    assertTrue(actualGetObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetObjectMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getGetLatestObjectMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getGetLatestObjectMethod()}
   */
  @Test
  @DisplayName("Test getGetLatestObjectMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getGetLatestObjectMethod()"})
  void testGetGetLatestObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, org.finos.tracdap.metadata.Tag> actualGetLatestObjectMethod = TracMetadataApiGrpc
        .getGetLatestObjectMethod();

    // Assert
    assertEquals("getLatestObject", actualGetLatestObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", actualGetLatestObjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetLatestObjectMethod.getType());
    assertFalse(actualGetLatestObjectMethod.isIdempotent());
    assertFalse(actualGetLatestObjectMethod.isSafe());
    assertTrue(actualGetLatestObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetLatestObjectMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getGetLatestTagMethod()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getGetLatestTagMethod()}
   */
  @Test
  @DisplayName("Test getGetLatestTagMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracMetadataApiGrpc.getGetLatestTagMethod()"})
  void testGetGetLatestTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, org.finos.tracdap.metadata.Tag> actualGetLatestTagMethod = TracMetadataApiGrpc
        .getGetLatestTagMethod();

    // Assert
    assertEquals("getLatestTag", actualGetLatestTagMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", actualGetLatestTagMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetLatestTagMethod.getType());
    assertFalse(actualGetLatestTagMethod.isIdempotent());
    assertFalse(actualGetLatestTagMethod.isSafe());
    assertTrue(actualGetLatestTagMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetLatestTagMethod.getServiceName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracMetadataApiStub TracMetadataApiGrpc.newStub(Channel)"})
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiStub actualNewStubResult = TracMetadataApiGrpc.newStub(channel);

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
   * Test {@link TracMetadataApiGrpc#newBlockingV2Stub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingV2Stub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracMetadataApiBlockingV2Stub TracMetadataApiGrpc.newBlockingV2Stub(Channel)"})
  void testNewBlockingV2Stub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiBlockingV2Stub actualNewBlockingV2StubResult = TracMetadataApiGrpc.newBlockingV2Stub(channel);

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
   * Test {@link TracMetadataApiGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracMetadataApiBlockingStub TracMetadataApiGrpc.newBlockingStub(Channel)"})
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiBlockingStub actualNewBlockingStubResult = TracMetadataApiGrpc.newBlockingStub(channel);

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
   * Test {@link TracMetadataApiGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracMetadataApiFutureStub TracMetadataApiGrpc.newFutureStub(Channel)"})
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiFutureStub actualNewFutureStubResult = TracMetadataApiGrpc.newFutureStub(channel);

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
   * Test {@link TracMetadataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracMetadataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracMetadataApiGrpc.bindService(mock(AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(15, actualBindServiceResult.getMethods().size());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracMetadataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracMetadataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(15, actualBindServiceResult.getMethods().size());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracMetadataApiGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TracMetadataApiGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceDescriptor TracMetadataApiGrpc.getServiceDescriptor()"})
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracMetadataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

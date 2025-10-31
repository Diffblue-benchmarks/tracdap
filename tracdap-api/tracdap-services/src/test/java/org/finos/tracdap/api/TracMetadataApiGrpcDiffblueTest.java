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
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;

class TracMetadataApiGrpcDiffblueTest {
  /**
   * Method under test: {@link TracMetadataApiGrpc#getPlatformInfoMethod()}
   */
  @Test
  void testGetPlatformInfoMethod() {
    // Arrange and Act
    MethodDescriptor<PlatformInfoRequest, PlatformInfoResponse> actualPlatformInfoMethod = TracMetadataApiGrpc
        .getPlatformInfoMethod();

    // Assert
    assertEquals("platformInfo", actualPlatformInfoMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", actualPlatformInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualPlatformInfoMethod.getType());
    assertFalse(actualPlatformInfoMethod.isIdempotent());
    assertFalse(actualPlatformInfoMethod.isSafe());
    assertTrue(actualPlatformInfoMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualPlatformInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getListTenantsMethod()}
   */
  @Test
  void testGetListTenantsMethod() {
    // Arrange and Act
    MethodDescriptor<ListTenantsRequest, ListTenantsResponse> actualListTenantsMethod = TracMetadataApiGrpc
        .getListTenantsMethod();

    // Assert
    assertEquals("listTenants", actualListTenantsMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", actualListTenantsMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListTenantsMethod.getType());
    assertFalse(actualListTenantsMethod.isIdempotent());
    assertFalse(actualListTenantsMethod.isSafe());
    assertTrue(actualListTenantsMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualListTenantsMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getClientConfigMethod()}
   */
  @Test
  void testGetClientConfigMethod() {
    // Arrange and Act
    MethodDescriptor<ClientConfigRequest, ClientConfigResponse> actualClientConfigMethod = TracMetadataApiGrpc
        .getClientConfigMethod();

    // Assert
    assertEquals("clientConfig", actualClientConfigMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/clientConfig", actualClientConfigMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualClientConfigMethod.getType());
    assertFalse(actualClientConfigMethod.isIdempotent());
    assertFalse(actualClientConfigMethod.isSafe());
    assertTrue(actualClientConfigMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualClientConfigMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getListResourcesMethod()}
   */
  @Test
  void testGetListResourcesMethod() {
    // Arrange and Act
    MethodDescriptor<ListResourcesRequest, ListResourcesResponse> actualListResourcesMethod = TracMetadataApiGrpc
        .getListResourcesMethod();

    // Assert
    assertEquals("listResources", actualListResourcesMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listResources", actualListResourcesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListResourcesMethod.getType());
    assertFalse(actualListResourcesMethod.isIdempotent());
    assertFalse(actualListResourcesMethod.isSafe());
    assertTrue(actualListResourcesMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualListResourcesMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getResourceInfoMethod()}
   */
  @Test
  void testGetResourceInfoMethod() {
    // Arrange and Act
    MethodDescriptor<ResourceInfoRequest, ResourceInfoResponse> actualResourceInfoMethod = TracMetadataApiGrpc
        .getResourceInfoMethod();

    // Assert
    assertEquals("resourceInfo", actualResourceInfoMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/resourceInfo", actualResourceInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualResourceInfoMethod.getType());
    assertFalse(actualResourceInfoMethod.isIdempotent());
    assertFalse(actualResourceInfoMethod.isSafe());
    assertTrue(actualResourceInfoMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualResourceInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getCreateObjectMethod()}
   */
  @Test
  void testGetCreateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreateObjectMethod = TracMetadataApiGrpc
        .getCreateObjectMethod();

    // Assert
    assertEquals("createObject", actualCreateObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/createObject", actualCreateObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateObjectMethod.getType());
    assertFalse(actualCreateObjectMethod.isIdempotent());
    assertFalse(actualCreateObjectMethod.isSafe());
    assertTrue(actualCreateObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualCreateObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getUpdateObjectMethod()}
   */
  @Test
  void testGetUpdateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateObjectMethod = TracMetadataApiGrpc
        .getUpdateObjectMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/updateObject", actualUpdateObjectMethod.getFullMethodName());
    assertEquals("updateObject", actualUpdateObjectMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateObjectMethod.getType());
    assertFalse(actualUpdateObjectMethod.isIdempotent());
    assertFalse(actualUpdateObjectMethod.isSafe());
    assertTrue(actualUpdateObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualUpdateObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getUpdateTagMethod()}
   */
  @Test
  void testGetUpdateTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateTagMethod = TracMetadataApiGrpc.getUpdateTagMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/updateTag", actualUpdateTagMethod.getFullMethodName());
    assertEquals("updateTag", actualUpdateTagMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateTagMethod.getType());
    assertFalse(actualUpdateTagMethod.isIdempotent());
    assertFalse(actualUpdateTagMethod.isSafe());
    assertTrue(actualUpdateTagMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualUpdateTagMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getWriteBatchMethod()}
   */
  @Test
  void testGetWriteBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteBatchRequest, MetadataWriteBatchResponse> actualWriteBatchMethod = TracMetadataApiGrpc
        .getWriteBatchMethod();

    // Assert
    assertEquals("tracdap.api.TracMetadataApi/writeBatch", actualWriteBatchMethod.getFullMethodName());
    assertEquals("writeBatch", actualWriteBatchMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualWriteBatchMethod.getType());
    assertFalse(actualWriteBatchMethod.isIdempotent());
    assertFalse(actualWriteBatchMethod.isSafe());
    assertTrue(actualWriteBatchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualWriteBatchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getReadObjectMethod()}
   */
  @Test
  void testGetReadObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataReadRequest, Tag> actualReadObjectMethod = TracMetadataApiGrpc.getReadObjectMethod();

    // Assert
    assertEquals("readObject", actualReadObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/readObject", actualReadObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadObjectMethod.getType());
    assertFalse(actualReadObjectMethod.isIdempotent());
    assertFalse(actualReadObjectMethod.isSafe());
    assertTrue(actualReadObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualReadObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getReadBatchMethod()}
   */
  @Test
  void testGetReadBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataBatchRequest, MetadataBatchResponse> actualReadBatchMethod = TracMetadataApiGrpc
        .getReadBatchMethod();

    // Assert
    assertEquals("readBatch", actualReadBatchMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/readBatch", actualReadBatchMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadBatchMethod.getType());
    assertFalse(actualReadBatchMethod.isIdempotent());
    assertFalse(actualReadBatchMethod.isSafe());
    assertTrue(actualReadBatchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualReadBatchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getSearchMethod()}
   */
  @Test
  void testGetSearchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataSearchRequest, MetadataSearchResponse> actualSearchMethod = TracMetadataApiGrpc
        .getSearchMethod();

    // Assert
    assertEquals("search", actualSearchMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/search", actualSearchMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualSearchMethod.getType());
    assertFalse(actualSearchMethod.isIdempotent());
    assertFalse(actualSearchMethod.isSafe());
    assertTrue(actualSearchMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualSearchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getGetObjectMethod()}
   */
  @Test
  void testGetGetObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, Tag> actualGetObjectMethod = TracMetadataApiGrpc.getGetObjectMethod();

    // Assert
    assertEquals("getObject", actualGetObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getObject", actualGetObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetObjectMethod.getType());
    assertFalse(actualGetObjectMethod.isIdempotent());
    assertFalse(actualGetObjectMethod.isSafe());
    assertTrue(actualGetObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getGetLatestObjectMethod()}
   */
  @Test
  void testGetGetLatestObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, Tag> actualGetLatestObjectMethod = TracMetadataApiGrpc
        .getGetLatestObjectMethod();

    // Assert
    assertEquals("getLatestObject", actualGetLatestObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", actualGetLatestObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetLatestObjectMethod.getType());
    assertFalse(actualGetLatestObjectMethod.isIdempotent());
    assertFalse(actualGetLatestObjectMethod.isSafe());
    assertTrue(actualGetLatestObjectMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetLatestObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getGetLatestTagMethod()}
   */
  @Test
  void testGetGetLatestTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataGetRequest, Tag> actualGetLatestTagMethod = TracMetadataApiGrpc.getGetLatestTagMethod();

    // Assert
    assertEquals("getLatestTag", actualGetLatestTagMethod.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", actualGetLatestTagMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetLatestTagMethod.getType());
    assertFalse(actualGetLatestTagMethod.isIdempotent());
    assertFalse(actualGetLatestTagMethod.isSafe());
    assertTrue(actualGetLatestTagMethod.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualGetLatestTagMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#newStub(Channel)}
   */
  @Test
  void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiGrpc.TracMetadataApiStub actualNewStubResult = TracMetadataApiGrpc.newStub(channel);

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
   * Method under test: {@link TracMetadataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  void testNewBlockingV2Stub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiGrpc.TracMetadataApiBlockingV2Stub actualNewBlockingV2StubResult = TracMetadataApiGrpc
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
   * Method under test: {@link TracMetadataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiGrpc.TracMetadataApiBlockingStub actualNewBlockingStubResult = TracMetadataApiGrpc
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
   * Method under test: {@link TracMetadataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracMetadataApiGrpc.TracMetadataApiFutureStub actualNewFutureStubResult = TracMetadataApiGrpc
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
   * {@link TracMetadataApiGrpc#bindService(TracMetadataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracMetadataApiGrpc
        .bindService(mock(TracMetadataApiGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("getLatestObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(14);
    assertEquals("getLatestTag", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("listTenants", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("platformInfo", getResult4.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", getResult4.getFullMethodName());
    assertEquals(15, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test:
   * {@link TracMetadataApiGrpc#bindService(TracMetadataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService2() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracMetadataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("getLatestObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(14);
    assertEquals("getLatestTag", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("listTenants", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("platformInfo", getResult4.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", getResult4.getFullMethodName());
    assertEquals(15, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test: {@link TracMetadataApiGrpc#getServiceDescriptor()}
   */
  @Test
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracMetadataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(15, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("clientConfig", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("getLatestObject", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(14);
    assertEquals("getLatestTag", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(12);
    assertEquals("getObject", getResult4.getBareMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("listTenants", getResult5.getBareMethodName());
    MethodDescriptor<?, ?> getResult6 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("platformInfo", getResult6.getBareMethodName());
    assertEquals("tracdap.api.TracMetadataApi/clientConfig", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getObject", getResult4.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", getResult5.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", getResult6.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult6.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult6.isIdempotent());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult6.isSafe());
    assertFalse(getResult5.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult6.isSampledToLocalTracing());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult6.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracMetadataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

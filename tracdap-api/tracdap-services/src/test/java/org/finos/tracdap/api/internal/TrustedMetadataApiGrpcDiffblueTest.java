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
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataSearchResponse;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;

class TrustedMetadataApiGrpcDiffblueTest {
  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getCreateObjectMethod()}
   */
  @Test
  void testGetCreateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreateObjectMethod = TrustedMetadataApiGrpc
        .getCreateObjectMethod();

    // Assert
    assertEquals("createObject", actualCreateObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", actualCreateObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateObjectMethod.getType());
    assertFalse(actualCreateObjectMethod.isIdempotent());
    assertFalse(actualCreateObjectMethod.isSafe());
    assertTrue(actualCreateObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualCreateObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getUpdateObjectMethod()}
   */
  @Test
  void testGetUpdateObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateObjectMethod = TrustedMetadataApiGrpc
        .getUpdateObjectMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", actualUpdateObjectMethod.getFullMethodName());
    assertEquals("updateObject", actualUpdateObjectMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateObjectMethod.getType());
    assertFalse(actualUpdateObjectMethod.isIdempotent());
    assertFalse(actualUpdateObjectMethod.isSafe());
    assertTrue(actualUpdateObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualUpdateObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getUpdateTagMethod()}
   */
  @Test
  void testGetUpdateTagMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualUpdateTagMethod = TrustedMetadataApiGrpc
        .getUpdateTagMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateTag", actualUpdateTagMethod.getFullMethodName());
    assertEquals("updateTag", actualUpdateTagMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateTagMethod.getType());
    assertFalse(actualUpdateTagMethod.isIdempotent());
    assertFalse(actualUpdateTagMethod.isSafe());
    assertTrue(actualUpdateTagMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualUpdateTagMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getPreallocateIdMethod()}
   */
  @Test
  void testGetPreallocateIdMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualPreallocateIdMethod = TrustedMetadataApiGrpc
        .getPreallocateIdMethod();

    // Assert
    assertEquals("preallocateId", actualPreallocateIdMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/preallocateId",
        actualPreallocateIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualPreallocateIdMethod.getType());
    assertFalse(actualPreallocateIdMethod.isIdempotent());
    assertFalse(actualPreallocateIdMethod.isSafe());
    assertTrue(actualPreallocateIdMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualPreallocateIdMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link TrustedMetadataApiGrpc#getCreatePreallocatedObjectMethod()}
   */
  @Test
  void testGetCreatePreallocatedObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteRequest, TagHeader> actualCreatePreallocatedObjectMethod = TrustedMetadataApiGrpc
        .getCreatePreallocatedObjectMethod();

    // Assert
    assertEquals("createPreallocatedObject", actualCreatePreallocatedObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createPreallocatedObject",
        actualCreatePreallocatedObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreatePreallocatedObjectMethod.getType());
    assertFalse(actualCreatePreallocatedObjectMethod.isIdempotent());
    assertFalse(actualCreatePreallocatedObjectMethod.isSafe());
    assertTrue(actualCreatePreallocatedObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualCreatePreallocatedObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getWriteBatchMethod()}
   */
  @Test
  void testGetWriteBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataWriteBatchRequest, MetadataWriteBatchResponse> actualWriteBatchMethod = TrustedMetadataApiGrpc
        .getWriteBatchMethod();

    // Assert
    assertEquals("tracdap.api.internal.TrustedMetadataApi/writeBatch", actualWriteBatchMethod.getFullMethodName());
    assertEquals("writeBatch", actualWriteBatchMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualWriteBatchMethod.getType());
    assertFalse(actualWriteBatchMethod.isIdempotent());
    assertFalse(actualWriteBatchMethod.isSafe());
    assertTrue(actualWriteBatchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualWriteBatchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getReadObjectMethod()}
   */
  @Test
  void testGetReadObjectMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataReadRequest, Tag> actualReadObjectMethod = TrustedMetadataApiGrpc.getReadObjectMethod();

    // Assert
    assertEquals("readObject", actualReadObjectMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readObject", actualReadObjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadObjectMethod.getType());
    assertFalse(actualReadObjectMethod.isIdempotent());
    assertFalse(actualReadObjectMethod.isSafe());
    assertTrue(actualReadObjectMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualReadObjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getReadBatchMethod()}
   */
  @Test
  void testGetReadBatchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataBatchRequest, MetadataBatchResponse> actualReadBatchMethod = TrustedMetadataApiGrpc
        .getReadBatchMethod();

    // Assert
    assertEquals("readBatch", actualReadBatchMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", actualReadBatchMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadBatchMethod.getType());
    assertFalse(actualReadBatchMethod.isIdempotent());
    assertFalse(actualReadBatchMethod.isSafe());
    assertTrue(actualReadBatchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualReadBatchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getSearchMethod()}
   */
  @Test
  void testGetSearchMethod() {
    // Arrange and Act
    MethodDescriptor<MetadataSearchRequest, MetadataSearchResponse> actualSearchMethod = TrustedMetadataApiGrpc
        .getSearchMethod();

    // Assert
    assertEquals("search", actualSearchMethod.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", actualSearchMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualSearchMethod.getType());
    assertFalse(actualSearchMethod.isIdempotent());
    assertFalse(actualSearchMethod.isSafe());
    assertTrue(actualSearchMethod.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualSearchMethod.getServiceName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#newStub(Channel)}
   */
  @Test
  void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiGrpc.TrustedMetadataApiStub actualNewStubResult = TrustedMetadataApiGrpc.newStub(channel);

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
   * Method under test: {@link TrustedMetadataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  void testNewBlockingV2Stub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiGrpc.TrustedMetadataApiBlockingV2Stub actualNewBlockingV2StubResult = TrustedMetadataApiGrpc
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
   * Method under test: {@link TrustedMetadataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiGrpc.TrustedMetadataApiBlockingStub actualNewBlockingStubResult = TrustedMetadataApiGrpc
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
   * Method under test: {@link TrustedMetadataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TrustedMetadataApiGrpc.TrustedMetadataApiFutureStub actualNewFutureStubResult = TrustedMetadataApiGrpc
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
   * {@link TrustedMetadataApiGrpc#bindService(TrustedMetadataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TrustedMetadataApiGrpc
        .bindService(mock(TrustedMetadataApiGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(7);
    assertEquals("readBatch", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(8);
    assertEquals("search", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", getResult3.getFullMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", getResult4.getFullMethodName());
    assertEquals("updateObject", getResult4.getBareMethodName());
    assertEquals(9, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test:
   * {@link TrustedMetadataApiGrpc#bindService(TrustedMetadataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService2() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TrustedMetadataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(7);
    assertEquals("readBatch", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(8);
    assertEquals("search", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", getResult3.getFullMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", getResult4.getFullMethodName());
    assertEquals("updateObject", getResult4.getBareMethodName());
    assertEquals(9, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test: {@link TrustedMetadataApiGrpc#getServiceDescriptor()}
   */
  @Test
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TrustedMetadataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(7);
    assertEquals("readBatch", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(6);
    assertEquals("readObject", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(8);
    assertEquals("search", getResult4.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readObject", getResult3.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", getResult4.getFullMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", getResult5.getFullMethodName());
    MethodDescriptor<?, ?> getResult6 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateTag", getResult6.getFullMethodName());
    assertEquals("updateObject", getResult5.getBareMethodName());
    assertEquals("updateTag", getResult6.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult6.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult6.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult5.isSafe());
    assertFalse(getResult6.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult4.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertTrue(getResult6.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult6.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TrustedMetadataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

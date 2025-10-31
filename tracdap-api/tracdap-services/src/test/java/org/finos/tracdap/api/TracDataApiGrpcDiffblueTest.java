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
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;

class TracDataApiGrpcDiffblueTest {
  /**
   * Method under test: {@link TracDataApiGrpc#getCreateDatasetMethod()}
   */
  @Test
  void testGetCreateDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualCreateDatasetMethod = TracDataApiGrpc.getCreateDatasetMethod();

    // Assert
    assertEquals("createDataset", actualCreateDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createDataset", actualCreateDatasetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, actualCreateDatasetMethod.getType());
    assertFalse(actualCreateDatasetMethod.isIdempotent());
    assertFalse(actualCreateDatasetMethod.isSafe());
    assertTrue(actualCreateDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getCreateSmallDatasetMethod()}
   */
  @Test
  void testGetCreateSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualCreateSmallDatasetMethod = TracDataApiGrpc
        .getCreateSmallDatasetMethod();

    // Assert
    assertEquals("createSmallDataset", actualCreateSmallDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallDataset", actualCreateSmallDatasetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateSmallDatasetMethod.getType());
    assertFalse(actualCreateSmallDatasetMethod.isIdempotent());
    assertFalse(actualCreateSmallDatasetMethod.isSafe());
    assertTrue(actualCreateSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateSmallDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getUpdateDatasetMethod()}
   */
  @Test
  void testGetUpdateDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualUpdateDatasetMethod = TracDataApiGrpc.getUpdateDatasetMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateDataset", actualUpdateDatasetMethod.getFullMethodName());
    assertEquals("updateDataset", actualUpdateDatasetMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, actualUpdateDatasetMethod.getType());
    assertFalse(actualUpdateDatasetMethod.isIdempotent());
    assertFalse(actualUpdateDatasetMethod.isSafe());
    assertTrue(actualUpdateDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getUpdateSmallDatasetMethod()}
   */
  @Test
  void testGetUpdateSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualUpdateSmallDatasetMethod = TracDataApiGrpc
        .getUpdateSmallDatasetMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateSmallDataset", actualUpdateSmallDatasetMethod.getFullMethodName());
    assertEquals("updateSmallDataset", actualUpdateSmallDatasetMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateSmallDatasetMethod.getType());
    assertFalse(actualUpdateSmallDatasetMethod.isIdempotent());
    assertFalse(actualUpdateSmallDatasetMethod.isSafe());
    assertTrue(actualUpdateSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateSmallDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getReadDatasetMethod()}
   */
  @Test
  void testGetReadDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataReadRequest, DataReadResponse> actualReadDatasetMethod = TracDataApiGrpc
        .getReadDatasetMethod();

    // Assert
    assertEquals("readDataset", actualReadDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readDataset", actualReadDatasetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, actualReadDatasetMethod.getType());
    assertFalse(actualReadDatasetMethod.isIdempotent());
    assertFalse(actualReadDatasetMethod.isSafe());
    assertTrue(actualReadDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getReadSmallDatasetMethod()}
   */
  @Test
  void testGetReadSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataReadRequest, DataReadResponse> actualReadSmallDatasetMethod = TracDataApiGrpc
        .getReadSmallDatasetMethod();

    // Assert
    assertEquals("readSmallDataset", actualReadSmallDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readSmallDataset", actualReadSmallDatasetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadSmallDatasetMethod.getType());
    assertFalse(actualReadSmallDatasetMethod.isIdempotent());
    assertFalse(actualReadSmallDatasetMethod.isSafe());
    assertTrue(actualReadSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadSmallDatasetMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getCreateFileMethod()}
   */
  @Test
  void testGetCreateFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualCreateFileMethod = TracDataApiGrpc.getCreateFileMethod();

    // Assert
    assertEquals("createFile", actualCreateFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createFile", actualCreateFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, actualCreateFileMethod.getType());
    assertFalse(actualCreateFileMethod.isIdempotent());
    assertFalse(actualCreateFileMethod.isSafe());
    assertTrue(actualCreateFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getCreateSmallFileMethod()}
   */
  @Test
  void testGetCreateSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualCreateSmallFileMethod = TracDataApiGrpc
        .getCreateSmallFileMethod();

    // Assert
    assertEquals("createSmallFile", actualCreateSmallFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallFile", actualCreateSmallFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateSmallFileMethod.getType());
    assertFalse(actualCreateSmallFileMethod.isIdempotent());
    assertFalse(actualCreateSmallFileMethod.isSafe());
    assertTrue(actualCreateSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateSmallFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getUpdateFileMethod()}
   */
  @Test
  void testGetUpdateFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualUpdateFileMethod = TracDataApiGrpc.getUpdateFileMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateFile", actualUpdateFileMethod.getFullMethodName());
    assertEquals("updateFile", actualUpdateFileMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, actualUpdateFileMethod.getType());
    assertFalse(actualUpdateFileMethod.isIdempotent());
    assertFalse(actualUpdateFileMethod.isSafe());
    assertTrue(actualUpdateFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getUpdateSmallFileMethod()}
   */
  @Test
  void testGetUpdateSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualUpdateSmallFileMethod = TracDataApiGrpc
        .getUpdateSmallFileMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateSmallFile", actualUpdateSmallFileMethod.getFullMethodName());
    assertEquals("updateSmallFile", actualUpdateSmallFileMethod.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateSmallFileMethod.getType());
    assertFalse(actualUpdateSmallFileMethod.isIdempotent());
    assertFalse(actualUpdateSmallFileMethod.isSafe());
    assertTrue(actualUpdateSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateSmallFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getReadFileMethod()}
   */
  @Test
  void testGetReadFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileReadRequest, FileReadResponse> actualReadFileMethod = TracDataApiGrpc.getReadFileMethod();

    // Assert
    assertEquals("readFile", actualReadFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readFile", actualReadFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, actualReadFileMethod.getType());
    assertFalse(actualReadFileMethod.isIdempotent());
    assertFalse(actualReadFileMethod.isSafe());
    assertTrue(actualReadFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getReadSmallFileMethod()}
   */
  @Test
  void testGetReadSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileReadRequest, FileReadResponse> actualReadSmallFileMethod = TracDataApiGrpc
        .getReadSmallFileMethod();

    // Assert
    assertEquals("readSmallFile", actualReadSmallFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readSmallFile", actualReadSmallFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualReadSmallFileMethod.getType());
    assertFalse(actualReadSmallFileMethod.isIdempotent());
    assertFalse(actualReadSmallFileMethod.isSafe());
    assertTrue(actualReadSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadSmallFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getDownloadFileMethod()}
   */
  @Test
  void testGetDownloadFileMethod() {
    // Arrange and Act
    MethodDescriptor<DownloadRequest, DownloadResponse> actualDownloadFileMethod = TracDataApiGrpc
        .getDownloadFileMethod();

    // Assert
    assertEquals("downloadFile", actualDownloadFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadFile", actualDownloadFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, actualDownloadFileMethod.getType());
    assertFalse(actualDownloadFileMethod.isIdempotent());
    assertFalse(actualDownloadFileMethod.isSafe());
    assertTrue(actualDownloadFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualDownloadFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getDownloadLatestFileMethod()}
   */
  @Test
  void testGetDownloadLatestFileMethod() {
    // Arrange and Act
    MethodDescriptor<DownloadRequest, DownloadResponse> actualDownloadLatestFileMethod = TracDataApiGrpc
        .getDownloadLatestFileMethod();

    // Assert
    assertEquals("downloadLatestFile", actualDownloadLatestFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadLatestFile", actualDownloadLatestFileMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, actualDownloadLatestFileMethod.getType());
    assertFalse(actualDownloadLatestFileMethod.isIdempotent());
    assertFalse(actualDownloadLatestFileMethod.isSafe());
    assertTrue(actualDownloadLatestFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualDownloadLatestFileMethod.getServiceName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#newStub(Channel)}
   */
  @Test
  void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiGrpc.TracDataApiStub actualNewStubResult = TracDataApiGrpc.newStub(channel);

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
   * Method under test: {@link TracDataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  void testNewBlockingV2Stub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiGrpc.TracDataApiBlockingV2Stub actualNewBlockingV2StubResult = TracDataApiGrpc
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
   * Method under test: {@link TracDataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiGrpc.TracDataApiBlockingStub actualNewBlockingStubResult = TracDataApiGrpc.newBlockingStub(channel);

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
   * Method under test: {@link TracDataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiGrpc.TracDataApiFutureStub actualNewFutureStubResult = TracDataApiGrpc.newFutureStub(channel);

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
   * {@link TracDataApiGrpc#bindService(TracDataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracDataApiGrpc
        .bindService(mock(TracDataApiGrpc.AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createDataset", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("createSmallDataset", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(12);
    assertEquals("downloadFile", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("downloadLatestFile", getResult4.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createDataset", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallDataset", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadFile", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadLatestFile", getResult4.getFullMethodName());
    assertEquals(14, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult4.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test:
   * {@link TracDataApiGrpc#bindService(TracDataApiGrpc.AsyncService)}
   */
  @Test
  void testBindService2() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracDataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createDataset", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("createSmallDataset", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(12);
    assertEquals("downloadFile", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("downloadLatestFile", getResult4.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createDataset", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallDataset", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadFile", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadLatestFile", getResult4.getFullMethodName());
    assertEquals(14, actualBindServiceResult.getMethods().size());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult4.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Method under test: {@link TracDataApiGrpc#getServiceDescriptor()}
   */
  @Test
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracDataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createDataset", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("createSmallDataset", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(12);
    assertEquals("downloadFile", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(13);
    assertEquals("downloadLatestFile", getResult4.getBareMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(11);
    assertEquals("readSmallFile", getResult5.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createDataset", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallDataset", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadFile", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadLatestFile", getResult4.getFullMethodName());
    assertEquals("tracdap.api.TracDataApi/readSmallFile", getResult5.getFullMethodName());
    MethodDescriptor<?, ?> getResult6 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("tracdap.api.TracDataApi/updateDataset", getResult6.getFullMethodName());
    assertEquals("updateDataset", getResult6.getBareMethodName());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.CLIENT_STREAMING, getResult6.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.SERVER_STREAMING, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult6.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult5.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult6.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult6.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, getResult6.getServiceName());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

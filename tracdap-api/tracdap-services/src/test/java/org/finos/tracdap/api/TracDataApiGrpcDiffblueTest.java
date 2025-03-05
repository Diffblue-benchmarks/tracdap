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
import org.finos.tracdap.api.TracDataApiGrpc.AsyncService;
import org.finos.tracdap.api.TracDataApiGrpc.TracDataApiBlockingStub;
import org.finos.tracdap.api.TracDataApiGrpc.TracDataApiBlockingV2Stub;
import org.finos.tracdap.api.TracDataApiGrpc.TracDataApiFutureStub;
import org.finos.tracdap.api.TracDataApiGrpc.TracDataApiStub;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracDataApiGrpcDiffblueTest {
  /**
   * Test {@link TracDataApiGrpc#getCreateDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getCreateDatasetMethod()}
   */
  @Test
  @DisplayName("Test getCreateDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getCreateDatasetMethod()"})
  void testGetCreateDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualCreateDatasetMethod = TracDataApiGrpc.getCreateDatasetMethod();

    // Assert
    assertEquals("createDataset", actualCreateDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createDataset", actualCreateDatasetMethod.getFullMethodName());
    assertEquals(MethodType.CLIENT_STREAMING, actualCreateDatasetMethod.getType());
    assertFalse(actualCreateDatasetMethod.isIdempotent());
    assertFalse(actualCreateDatasetMethod.isSafe());
    assertTrue(actualCreateDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getCreateSmallDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getCreateSmallDatasetMethod()}
   */
  @Test
  @DisplayName("Test getCreateSmallDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getCreateSmallDatasetMethod()"})
  void testGetCreateSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualCreateSmallDatasetMethod = TracDataApiGrpc
        .getCreateSmallDatasetMethod();

    // Assert
    assertEquals("createSmallDataset", actualCreateSmallDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallDataset", actualCreateSmallDatasetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateSmallDatasetMethod.getType());
    assertFalse(actualCreateSmallDatasetMethod.isIdempotent());
    assertFalse(actualCreateSmallDatasetMethod.isSafe());
    assertTrue(actualCreateSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateSmallDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getUpdateDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getUpdateDatasetMethod()}
   */
  @Test
  @DisplayName("Test getUpdateDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getUpdateDatasetMethod()"})
  void testGetUpdateDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualUpdateDatasetMethod = TracDataApiGrpc.getUpdateDatasetMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateDataset", actualUpdateDatasetMethod.getFullMethodName());
    assertEquals("updateDataset", actualUpdateDatasetMethod.getBareMethodName());
    assertEquals(MethodType.CLIENT_STREAMING, actualUpdateDatasetMethod.getType());
    assertFalse(actualUpdateDatasetMethod.isIdempotent());
    assertFalse(actualUpdateDatasetMethod.isSafe());
    assertTrue(actualUpdateDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getUpdateSmallDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getUpdateSmallDatasetMethod()}
   */
  @Test
  @DisplayName("Test getUpdateSmallDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getUpdateSmallDatasetMethod()"})
  void testGetUpdateSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataWriteRequest, TagHeader> actualUpdateSmallDatasetMethod = TracDataApiGrpc
        .getUpdateSmallDatasetMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateSmallDataset", actualUpdateSmallDatasetMethod.getFullMethodName());
    assertEquals("updateSmallDataset", actualUpdateSmallDatasetMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateSmallDatasetMethod.getType());
    assertFalse(actualUpdateSmallDatasetMethod.isIdempotent());
    assertFalse(actualUpdateSmallDatasetMethod.isSafe());
    assertTrue(actualUpdateSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateSmallDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getReadDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getReadDatasetMethod()}
   */
  @Test
  @DisplayName("Test getReadDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getReadDatasetMethod()"})
  void testGetReadDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataReadRequest, DataReadResponse> actualReadDatasetMethod = TracDataApiGrpc
        .getReadDatasetMethod();

    // Assert
    assertEquals("readDataset", actualReadDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readDataset", actualReadDatasetMethod.getFullMethodName());
    assertEquals(MethodType.SERVER_STREAMING, actualReadDatasetMethod.getType());
    assertFalse(actualReadDatasetMethod.isIdempotent());
    assertFalse(actualReadDatasetMethod.isSafe());
    assertTrue(actualReadDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getReadSmallDatasetMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getReadSmallDatasetMethod()}
   */
  @Test
  @DisplayName("Test getReadSmallDatasetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getReadSmallDatasetMethod()"})
  void testGetReadSmallDatasetMethod() {
    // Arrange and Act
    MethodDescriptor<DataReadRequest, DataReadResponse> actualReadSmallDatasetMethod = TracDataApiGrpc
        .getReadSmallDatasetMethod();

    // Assert
    assertEquals("readSmallDataset", actualReadSmallDatasetMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readSmallDataset", actualReadSmallDatasetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadSmallDatasetMethod.getType());
    assertFalse(actualReadSmallDatasetMethod.isIdempotent());
    assertFalse(actualReadSmallDatasetMethod.isSafe());
    assertTrue(actualReadSmallDatasetMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadSmallDatasetMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getCreateFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getCreateFileMethod()}
   */
  @Test
  @DisplayName("Test getCreateFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getCreateFileMethod()"})
  void testGetCreateFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualCreateFileMethod = TracDataApiGrpc.getCreateFileMethod();

    // Assert
    assertEquals("createFile", actualCreateFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createFile", actualCreateFileMethod.getFullMethodName());
    assertEquals(MethodType.CLIENT_STREAMING, actualCreateFileMethod.getType());
    assertFalse(actualCreateFileMethod.isIdempotent());
    assertFalse(actualCreateFileMethod.isSafe());
    assertTrue(actualCreateFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getCreateSmallFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getCreateSmallFileMethod()}
   */
  @Test
  @DisplayName("Test getCreateSmallFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getCreateSmallFileMethod()"})
  void testGetCreateSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualCreateSmallFileMethod = TracDataApiGrpc
        .getCreateSmallFileMethod();

    // Assert
    assertEquals("createSmallFile", actualCreateSmallFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/createSmallFile", actualCreateSmallFileMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateSmallFileMethod.getType());
    assertFalse(actualCreateSmallFileMethod.isIdempotent());
    assertFalse(actualCreateSmallFileMethod.isSafe());
    assertTrue(actualCreateSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualCreateSmallFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getUpdateFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getUpdateFileMethod()}
   */
  @Test
  @DisplayName("Test getUpdateFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getUpdateFileMethod()"})
  void testGetUpdateFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualUpdateFileMethod = TracDataApiGrpc.getUpdateFileMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateFile", actualUpdateFileMethod.getFullMethodName());
    assertEquals("updateFile", actualUpdateFileMethod.getBareMethodName());
    assertEquals(MethodType.CLIENT_STREAMING, actualUpdateFileMethod.getType());
    assertFalse(actualUpdateFileMethod.isIdempotent());
    assertFalse(actualUpdateFileMethod.isSafe());
    assertTrue(actualUpdateFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getUpdateSmallFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getUpdateSmallFileMethod()}
   */
  @Test
  @DisplayName("Test getUpdateSmallFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getUpdateSmallFileMethod()"})
  void testGetUpdateSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileWriteRequest, TagHeader> actualUpdateSmallFileMethod = TracDataApiGrpc
        .getUpdateSmallFileMethod();

    // Assert
    assertEquals("tracdap.api.TracDataApi/updateSmallFile", actualUpdateSmallFileMethod.getFullMethodName());
    assertEquals("updateSmallFile", actualUpdateSmallFileMethod.getBareMethodName());
    assertEquals(MethodType.UNARY, actualUpdateSmallFileMethod.getType());
    assertFalse(actualUpdateSmallFileMethod.isIdempotent());
    assertFalse(actualUpdateSmallFileMethod.isSafe());
    assertTrue(actualUpdateSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualUpdateSmallFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getReadFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getReadFileMethod()}
   */
  @Test
  @DisplayName("Test getReadFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getReadFileMethod()"})
  void testGetReadFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileReadRequest, FileReadResponse> actualReadFileMethod = TracDataApiGrpc.getReadFileMethod();

    // Assert
    assertEquals("readFile", actualReadFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readFile", actualReadFileMethod.getFullMethodName());
    assertEquals(MethodType.SERVER_STREAMING, actualReadFileMethod.getType());
    assertFalse(actualReadFileMethod.isIdempotent());
    assertFalse(actualReadFileMethod.isSafe());
    assertTrue(actualReadFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getReadSmallFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getReadSmallFileMethod()}
   */
  @Test
  @DisplayName("Test getReadSmallFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getReadSmallFileMethod()"})
  void testGetReadSmallFileMethod() {
    // Arrange and Act
    MethodDescriptor<FileReadRequest, FileReadResponse> actualReadSmallFileMethod = TracDataApiGrpc
        .getReadSmallFileMethod();

    // Assert
    assertEquals("readSmallFile", actualReadSmallFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/readSmallFile", actualReadSmallFileMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualReadSmallFileMethod.getType());
    assertFalse(actualReadSmallFileMethod.isIdempotent());
    assertFalse(actualReadSmallFileMethod.isSafe());
    assertTrue(actualReadSmallFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualReadSmallFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getDownloadFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getDownloadFileMethod()}
   */
  @Test
  @DisplayName("Test getDownloadFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getDownloadFileMethod()"})
  void testGetDownloadFileMethod() {
    // Arrange and Act
    MethodDescriptor<DownloadRequest, DownloadResponse> actualDownloadFileMethod = TracDataApiGrpc
        .getDownloadFileMethod();

    // Assert
    assertEquals("downloadFile", actualDownloadFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadFile", actualDownloadFileMethod.getFullMethodName());
    assertEquals(MethodType.SERVER_STREAMING, actualDownloadFileMethod.getType());
    assertFalse(actualDownloadFileMethod.isIdempotent());
    assertFalse(actualDownloadFileMethod.isSafe());
    assertTrue(actualDownloadFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualDownloadFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#getDownloadLatestFileMethod()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getDownloadLatestFileMethod()}
   */
  @Test
  @DisplayName("Test getDownloadLatestFileMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodDescriptor TracDataApiGrpc.getDownloadLatestFileMethod()"})
  void testGetDownloadLatestFileMethod() {
    // Arrange and Act
    MethodDescriptor<DownloadRequest, DownloadResponse> actualDownloadLatestFileMethod = TracDataApiGrpc
        .getDownloadLatestFileMethod();

    // Assert
    assertEquals("downloadLatestFile", actualDownloadLatestFileMethod.getBareMethodName());
    assertEquals("tracdap.api.TracDataApi/downloadLatestFile", actualDownloadLatestFileMethod.getFullMethodName());
    assertEquals(MethodType.SERVER_STREAMING, actualDownloadLatestFileMethod.getType());
    assertFalse(actualDownloadLatestFileMethod.isIdempotent());
    assertFalse(actualDownloadLatestFileMethod.isSafe());
    assertTrue(actualDownloadLatestFileMethod.isSampledToLocalTracing());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualDownloadLatestFileMethod.getServiceName());
  }

  /**
   * Test {@link TracDataApiGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#newStub(Channel)}
   */
  @Test
  @DisplayName("Test newStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracDataApiStub TracDataApiGrpc.newStub(Channel)"})
  void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiStub actualNewStubResult = TracDataApiGrpc.newStub(channel);

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
   * Test {@link TracDataApiGrpc#newBlockingV2Stub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#newBlockingV2Stub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingV2Stub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracDataApiBlockingV2Stub TracDataApiGrpc.newBlockingV2Stub(Channel)"})
  void testNewBlockingV2Stub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiBlockingV2Stub actualNewBlockingV2StubResult = TracDataApiGrpc.newBlockingV2Stub(channel);

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
   * Test {@link TracDataApiGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#newBlockingStub(Channel)}
   */
  @Test
  @DisplayName("Test newBlockingStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracDataApiBlockingStub TracDataApiGrpc.newBlockingStub(Channel)"})
  void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiBlockingStub actualNewBlockingStubResult = TracDataApiGrpc.newBlockingStub(channel);

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
   * Test {@link TracDataApiGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#newFutureStub(Channel)}
   */
  @Test
  @DisplayName("Test newFutureStub(Channel); when Channel; then return CallOptions Credentials is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracDataApiFutureStub TracDataApiGrpc.newFutureStub(Channel)"})
  void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TracDataApiFutureStub actualNewFutureStubResult = TracDataApiGrpc.newFutureStub(channel);

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
   * Test {@link TracDataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@link AsyncService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when AsyncService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracDataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenAsyncService() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracDataApiGrpc.bindService(mock(AsyncService.class));

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(14, actualBindServiceResult.getMethods().size());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracDataApiGrpc#bindService(AsyncService)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracDataApiGrpc#bindService(AsyncService)}
   */
  @Test
  @DisplayName("Test bindService(AsyncService); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServerServiceDefinition TracDataApiGrpc.bindService(AsyncService)"})
  void testBindService_whenNull() {
    // Arrange and Act
    ServerServiceDefinition actualBindServiceResult = TracDataApiGrpc.bindService(null);

    // Assert
    ServiceDescriptor serviceDescriptor = actualBindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(14, actualBindServiceResult.getMethods().size());
    assertEquals(TracDataApiGrpc.SERVICE_NAME, serviceDescriptor.getName());
  }

  /**
   * Test {@link TracDataApiGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TracDataApiGrpc#getServiceDescriptor()}
   */
  @Test
  @DisplayName("Test getServiceDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceDescriptor TracDataApiGrpc.getServiceDescriptor()"})
  void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TracDataApiGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(14, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(TracDataApiGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}

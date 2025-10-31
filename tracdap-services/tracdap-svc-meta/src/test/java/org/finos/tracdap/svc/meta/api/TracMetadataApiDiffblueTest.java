package org.finos.tracdap.svc.meta.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.internal.testing.StreamRecorder;
import io.grpc.stub.StreamObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.sql.DataSource;
import org.finos.tracdap.api.ClientConfigRequest;
import org.finos.tracdap.api.ClientConfigResponse;
import org.finos.tracdap.api.ListResourcesRequest;
import org.finos.tracdap.api.ListResourcesResponse;
import org.finos.tracdap.api.ListTenantsRequest;
import org.finos.tracdap.api.ListTenantsResponse;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataGetRequest;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataSearchResponse;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.api.PlatformInfoRequest;
import org.finos.tracdap.api.PlatformInfoResponse;
import org.finos.tracdap.api.ResourceInfoRequest;
import org.finos.tracdap.api.ResourceInfoResponse;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.finos.tracdap.svc.meta.services.MetadataReadService;
import org.finos.tracdap.svc.meta.services.MetadataSearchService;
import org.finos.tracdap.svc.meta.services.MetadataWriteService;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TracMetadataApiDiffblueTest {
  /**
   * Method under test:
   * {@link TracMetadataApi#platformInfo(PlatformInfoRequest, StreamObserver)}
   */
  @Test
  void testPlatformInfo() {
    // Arrange
    MetadataReadService readService = mock(MetadataReadService.class);
    when(readService.platformInfo()).thenReturn(PlatformInfoResponse.getDefaultInstance());
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    PlatformInfoRequest request = PlatformInfoRequest.getDefaultInstance();
    StreamRecorder<PlatformInfoResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.platformInfo(request, response);

    // Assert
    verify(readService).platformInfo();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#platformInfo(PlatformInfoRequest, StreamObserver)}
   */
  @Test
  void testPlatformInfo2() {
    // Arrange
    MetadataReadService readService = mock(MetadataReadService.class);
    when(readService.platformInfo()).thenReturn(null);
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    PlatformInfoRequest request = PlatformInfoRequest.getDefaultInstance();

    // Act
    tracMetadataApi.platformInfo(request, new GrpcTestStreams.ClientResultHandler<>(new CompletableFuture<>()));

    // Assert
    verify(readService).platformInfo();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#listTenants(ListTenantsRequest, StreamObserver)}
   */
  @Test
  void testListTenants() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ListTenantsRequest request = ListTenantsRequest.getDefaultInstance();
    StreamRecorder<ListTenantsResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.listTenants(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#clientConfig(ClientConfigRequest, StreamObserver)}
   */
  @Test
  void testClientConfig() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<ClientConfigResponse> responseObserver = StreamRecorder.create();

    // Act
    tracMetadataApi.clientConfig(null, responseObserver);

    // Assert
    ListenableFuture<ClientConfigResponse> firstValueResult = responseObserver.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = responseObserver.getError();
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.ClientConfigRequest.getApplication()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.ClientConfigRequest.getApplication()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#listResources(ListResourcesRequest, StreamObserver)}
   */
  @Test
  void testListResources() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.listResources(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#listResources(ListResourcesRequest, StreamObserver)}
   */
  @Test
  void testListResources2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.listResources(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#listResources(ListResourcesRequest, StreamObserver)}
   */
  @Test
  void testListResources3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.listResources(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#resourceInfo(ResourceInfoRequest, StreamObserver)}
   */
  @Test
  void testResourceInfo() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.resourceInfo(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#resourceInfo(ResourceInfoRequest, StreamObserver)}
   */
  @Test
  void testResourceInfo2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.resourceInfo(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#resourceInfo(ResourceInfoRequest, StreamObserver)}
   */
  @Test
  void testResourceInfo3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.resourceInfo(request, response);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#writeBatch(MetadataWriteBatchRequest, StreamObserver)}
   */
  @Test
  void testWriteBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    MetadataWriteService writeService = new MetadataWriteService(new JdbcMetadataDal(JdbcDialect.H2, dataSource));
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteBatchRequest request = MetadataWriteBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataWriteBatchResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.writeBatch(request, response);

    // Assert
    verify(connection).close();
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#createObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testCreateObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    tracMetadataApi.createObject(null, response);

    // Assert
    ListenableFuture<TagHeader> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getObjectType()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getObjectType()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    tracMetadataApi.updateObject(null, response);

    // Assert
    ListenableFuture<TagHeader> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getObjectType()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals(
        "Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getObjectType()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateTag() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    MetadataWriteService writeService = new MetadataWriteService(new JdbcMetadataDal(JdbcDialect.H2, dataSource));
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    tracMetadataApi.updateTag(request, response);

    // Assert
    verify(connection).close();
    verify(connection).createStatement();
    verify(connection).setAutoCommit(eq(false));
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateTag2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    tracMetadataApi.updateTag(null, response);

    // Assert
    ListenableFuture<TagHeader> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataWriteRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  void testReadObject() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataReadRequest request = MetadataReadRequest.getDefaultInstance();
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    tracMetadataApi.readObject(request, response);

    // Assert
    verify(connection).close();
    verify(connection).setAutoCommit(eq(false));
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  void testReadObject2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    tracMetadataApi.readObject(null, response);

    // Assert
    ListenableFuture<Tag> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataReadRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataReadRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#readBatch(MetadataBatchRequest, StreamObserver)}
   */
  @Test
  void testReadBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataBatchRequest request = MetadataBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataBatchResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.readBatch(request, response);

    // Assert
    verify(connection).close();
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#search(MetadataSearchRequest, StreamObserver)}
   */
  @Test
  void testSearch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    MetadataSearchService searchService = new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, dataSource));
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService,
        new MetadataWriteService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), searchService);
    MetadataSearchRequest request = MetadataSearchRequest.getDefaultInstance();
    StreamRecorder<MetadataSearchResponse> response = StreamRecorder.create();

    // Act
    tracMetadataApi.search(request, response);

    // Assert
    verify(connection).close();
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#getObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    tracMetadataApi.getObject(null, response);

    // Assert
    ListenableFuture<Tag> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#getLatestObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetLatestObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    tracMetadataApi.getLatestObject(null, response);

    // Assert
    ListenableFuture<Tag> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#getLatestTag(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetLatestTag() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TracMetadataApi tracMetadataApi = new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    tracMetadataApi.getLatestTag(null, response);

    // Assert
    ListenableFuture<Tag> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataGetRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Method under test:
   * {@link TracMetadataApi#TracMetadataApi(MetadataReadService, MetadataWriteService, MetadataSearchService)}
   */
  @Test
  void testNewTracMetadataApi() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));

    // Act and Assert
    ServerServiceDefinition bindServiceResult = (new TracMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))))).bindService();
    ServiceDescriptor serviceDescriptor = bindServiceResult.getServiceDescriptor();
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
    assertEquals("tracdap.api.TracMetadataApi", getResult4.getServiceName());
    assertEquals("tracdap.api.TracMetadataApi", getResult3.getServiceName());
    assertEquals("tracdap.api.TracMetadataApi", getResult.getServiceName());
    assertEquals("tracdap.api.TracMetadataApi", getResult2.getServiceName());
    assertEquals("tracdap.api.TracMetadataApi", serviceDescriptor.getName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/getLatestTag", getResult2.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/listTenants", getResult3.getFullMethodName());
    assertEquals("tracdap.api.TracMetadataApi/platformInfo", getResult4.getFullMethodName());
    assertEquals(15, bindServiceResult.getMethods().size());
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
  }
}

package org.finos.tracdap.svc.meta.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import io.grpc.internal.testing.StreamRecorder;
import io.grpc.stub.StreamObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.finos.tracdap.common.exception.EAuthorization;
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

class MetadataApiImplDiffblueTest {
  /**
   * Method under test:
   * {@link MetadataApiImpl#platformInfo(PlatformInfoRequest, StreamObserver)}
   */
  @Test
  void testPlatformInfo() {
    // Arrange
    MetadataReadService readService = mock(MetadataReadService.class);
    when(readService.platformInfo()).thenReturn(PlatformInfoResponse.getDefaultInstance());
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    PlatformInfoRequest request = PlatformInfoRequest.getDefaultInstance();
    StreamRecorder<PlatformInfoResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.platformInfo(request, response);

    // Assert
    verify(readService).platformInfo();
  }

  /**
   * Method under test:
   * {@link MetadataApiImpl#platformInfo(PlatformInfoRequest, StreamObserver)}
   */
  @Test
  void testPlatformInfo2() {
    // Arrange
    MetadataReadService readService = mock(MetadataReadService.class);
    when(readService.platformInfo()).thenReturn(null);
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    PlatformInfoRequest request = PlatformInfoRequest.getDefaultInstance();

    // Act
    metadataApiImpl.platformInfo(request, new GrpcTestStreams.ClientResultHandler<>(new CompletableFuture<>()));

    // Assert
    verify(readService).platformInfo();
  }

  /**
   * Method under test:
   * {@link MetadataApiImpl#listTenants(ListTenantsRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListTenantsRequest request = ListTenantsRequest.getDefaultInstance();
    StreamRecorder<ListTenantsResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listTenants(request, response);

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
   * {@link MetadataApiImpl#listTenants(ListTenantsRequest, StreamObserver)}
   */
  @Test
  void testListTenants2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenThrow(new EAuthorization("Not all who wander are lost"));
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListTenantsRequest request = ListTenantsRequest.getDefaultInstance();
    StreamRecorder<ListTenantsResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listTenants(request, response);

    // Assert
    verify(connection).close();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).getString(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataApiImpl#listTenants(ListTenantsRequest, StreamObserver)}
   */
  @Test
  void testListTenants3() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListTenantsRequest request = ListTenantsRequest.getDefaultInstance();
    StreamRecorder<ListTenantsResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listTenants(request, response);

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
   * {@link MetadataApiImpl#clientConfig(ClientConfigRequest, StreamObserver)}
   */
  @Test
  void testClientConfig() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<ClientConfigResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.clientConfig(null, response);

    // Assert
    ListenableFuture<ClientConfigResponse> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
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
   * {@link MetadataApiImpl#listResources(ListResourcesRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listResources(request, response);

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
   * {@link MetadataApiImpl#listResources(ListResourcesRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listResources(request, response);

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
   * {@link MetadataApiImpl#listResources(ListResourcesRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ListResourcesRequest request = ListResourcesRequest.getDefaultInstance();
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listResources(request, response);

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
   * {@link MetadataApiImpl#resourceInfo(ResourceInfoRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.resourceInfo(request, response);

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
   * {@link MetadataApiImpl#resourceInfo(ResourceInfoRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.resourceInfo(request, response);

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
   * {@link MetadataApiImpl#resourceInfo(ResourceInfoRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    ResourceInfoRequest request = ResourceInfoRequest.getDefaultInstance();
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.resourceInfo(request, response);

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
   * {@link MetadataApiImpl#createObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testCreateObject() throws SQLException {
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.createObject(request, response);

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
   * {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateObject() throws SQLException {
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.updateObject(request, response);

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
   * {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateObject2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.updateObject(null, response);

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
   * {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.updateTag(request, response);

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
   * {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateTag2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.updateTag(null, response);

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
   * {@link MetadataApiImpl#preallocateId(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testPreallocateId() throws SQLException {
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.preallocateId(request, response);

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
   * {@link MetadataApiImpl#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testCreatePreallocatedObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    metadataApiImpl.createPreallocatedObject(null, response);

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
   * {@link MetadataApiImpl#writeBatch(MetadataWriteBatchRequest, StreamObserver)}
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataWriteBatchRequest request = MetadataWriteBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataWriteBatchResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.writeBatch(request, response);

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
   * {@link MetadataApiImpl#readObject(MetadataReadRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataReadRequest request = MetadataReadRequest.getDefaultInstance();
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.readObject(request, response);

    // Assert
    verify(connection).close();
    verify(connection).setAutoCommit(eq(false));
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataApiImpl#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  void testReadObject2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.readObject(null, response);

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
   * {@link MetadataApiImpl#readBatch(MetadataBatchRequest, StreamObserver)}
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    MetadataBatchRequest request = MetadataBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataBatchResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.readBatch(request, response);

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
   * {@link MetadataApiImpl#search(MetadataSearchRequest, StreamObserver)}
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

    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService,
        new MetadataWriteService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), searchService, true);
    MetadataSearchRequest request = MetadataSearchRequest.getDefaultInstance();
    StreamRecorder<MetadataSearchResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.search(request, response);

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
   * {@link MetadataApiImpl#getObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getObject(null, response);

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
   * {@link MetadataApiImpl#getLatestObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetLatestObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getLatestObject(null, response);

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
   * {@link MetadataApiImpl#getLatestTag(MetadataGetRequest, StreamObserver)}
   */
  @Test
  void testGetLatestTag() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getLatestTag(null, response);

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
}

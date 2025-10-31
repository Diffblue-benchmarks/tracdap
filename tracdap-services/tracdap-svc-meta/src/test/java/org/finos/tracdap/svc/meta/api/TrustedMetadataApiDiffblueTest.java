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
import javax.sql.DataSource;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataSearchResponse;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.finos.tracdap.svc.meta.services.MetadataReadService;
import org.finos.tracdap.svc.meta.services.MetadataSearchService;
import org.finos.tracdap.svc.meta.services.MetadataWriteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TrustedMetadataApiDiffblueTest {
  /**
   * Method under test:
   * {@link TrustedMetadataApi#writeBatch(MetadataWriteBatchRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteBatchRequest request = MetadataWriteBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataWriteBatchResponse> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.writeBatch(request, response);

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
   * {@link TrustedMetadataApi#createObject(MetadataWriteRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.createObject(request, response);

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
   * {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.updateObject(request, response);

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
   * {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateObject2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.updateObject(null, response);

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
   * {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.updateTag(request, response);

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
   * {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testUpdateTag2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.updateTag(null, response);

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
   * {@link TrustedMetadataApi#preallocateId(MetadataWriteRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataWriteRequest request = MetadataWriteRequest.getDefaultInstance();
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.preallocateId(request, response);

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
   * {@link TrustedMetadataApi#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  void testCreatePreallocatedObject() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<TagHeader> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.createPreallocatedObject(null, response);

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
   * {@link TrustedMetadataApi#readObject(MetadataReadRequest, StreamObserver)}
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataReadRequest request = MetadataReadRequest.getDefaultInstance();
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.readObject(request, response);

    // Assert
    verify(connection).close();
    verify(connection).setAutoCommit(eq(false));
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link TrustedMetadataApi#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  void testReadObject2() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<Tag> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.readObject(null, response);

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
   * {@link TrustedMetadataApi#readBatch(MetadataBatchRequest, StreamObserver)}
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    MetadataBatchRequest request = MetadataBatchRequest.getDefaultInstance();
    StreamRecorder<MetadataBatchResponse> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.readBatch(request, response);

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
   * {@link TrustedMetadataApi#search(MetadataSearchRequest, StreamObserver)}
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

    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(readService,
        new MetadataWriteService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), searchService);
    MetadataSearchRequest request = MetadataSearchRequest.getDefaultInstance();
    StreamRecorder<MetadataSearchResponse> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.search(request, response);

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
   * {@link TrustedMetadataApi#TrustedMetadataApi(MetadataReadService, MetadataWriteService, MetadataSearchService)}
   */
  @Test
  void testNewTrustedMetadataApi() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService readService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));

    // Act and Assert
    ServerServiceDefinition bindServiceResult = (new TrustedMetadataApi(readService, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))))).bindService();
    ServiceDescriptor serviceDescriptor = bindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("createObject", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(7);
    assertEquals("readBatch", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(8);
    assertEquals("search", getResult3.getBareMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi", getResult.getServiceName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("tracdap.api.internal.TrustedMetadataApi", getResult4.getServiceName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi", getResult2.getServiceName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi", getResult3.getServiceName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi", serviceDescriptor.getName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/createObject", getResult.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/readBatch", getResult2.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/search", getResult3.getFullMethodName());
    assertEquals("tracdap.api.internal.TrustedMetadataApi/updateObject", getResult4.getFullMethodName());
    assertEquals("updateObject", getResult4.getBareMethodName());
    assertEquals(9, bindServiceResult.getMethods().size());
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
  }
}

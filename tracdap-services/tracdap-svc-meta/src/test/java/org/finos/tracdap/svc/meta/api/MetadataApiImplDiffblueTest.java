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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.internal.testing.StreamRecorder;
import io.grpc.stub.StreamObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.finos.tracdap.api.ListResourcesRequest;
import org.finos.tracdap.api.ListResourcesResponse;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataGetRequest;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataSearchResponse;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.api.ResourceInfoRequest;
import org.finos.tracdap.api.ResourceInfoResponse;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.finos.tracdap.svc.meta.services.MetadataSearchService;
import org.finos.tracdap.svc.meta.services.MetadataWriteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataApiImplDiffblueTest {
  /**
   * Test {@link MetadataApiImpl#listResources(ListResourcesRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#listResources(ListResourcesRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test listResources(ListResourcesRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.listResources(ListResourcesRequest, StreamObserver)"})
  void testListResources_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<ListResourcesResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.listResources(null, response);

    // Assert
    ListenableFuture<ListResourcesResponse> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.ListResourcesRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.ListResourcesRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Test {@link MetadataApiImpl#resourceInfo(ResourceInfoRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#resourceInfo(ResourceInfoRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test resourceInfo(ResourceInfoRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.resourceInfo(ResourceInfoRequest, StreamObserver)"})
  void testResourceInfo_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<ResourceInfoResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.resourceInfo(null, response);

    // Assert
    ListenableFuture<ResourceInfoResponse> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.ResourceInfoRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.ResourceInfoRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Test {@link MetadataApiImpl#createObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#createObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.createObject(MetadataWriteRequest, StreamObserver)"})
  void testCreateObject_givenStatementExecuteReturnTrue_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.updateObject(MetadataWriteRequest, StreamObserver)"})
  void testUpdateObject_givenStatementExecuteReturnTrue_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.updateObject(MetadataWriteRequest, StreamObserver)"})
  void testUpdateObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; when DefaultInstance; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.updateTag(MetadataWriteRequest, StreamObserver)"})
  void testUpdateTag_givenStatementExecuteReturnTrue_whenDefaultInstance_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.updateTag(MetadataWriteRequest, StreamObserver)"})
  void testUpdateTag_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#preallocateId(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#preallocateId(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test preallocateId(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.preallocateId(MetadataWriteRequest, StreamObserver)"})
  void testPreallocateId_givenStatementExecuteReturnTrue_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test createPreallocatedObject(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.createPreallocatedObject(MetadataWriteRequest, StreamObserver)"})
  void testCreatePreallocatedObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#writeBatch(MetadataWriteBatchRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#writeBatch(MetadataWriteBatchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test writeBatch(MetadataWriteBatchRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.writeBatch(MetadataWriteBatchRequest, StreamObserver)"})
  void testWriteBatch_givenStatementExecuteReturnTrue_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
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
   * Test {@link MetadataApiImpl#readObject(MetadataReadRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test readObject(MetadataReadRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.readObject(MetadataReadRequest, StreamObserver)"})
  void testReadObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<org.finos.tracdap.metadata.Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.readObject(null, response);

    // Assert
    ListenableFuture<org.finos.tracdap.metadata.Tag> firstValueResult = response.firstValue();
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
   * Test {@link MetadataApiImpl#readBatch(MetadataBatchRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#readBatch(MetadataBatchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test readBatch(MetadataBatchRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.readBatch(MetadataBatchRequest, StreamObserver)"})
  void testReadBatch_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<MetadataBatchResponse> response = StreamRecorder.create();

    // Act
    metadataApiImpl.readBatch(null, response);

    // Assert
    ListenableFuture<MetadataBatchResponse> firstValueResult = response.firstValue();
    assertTrue(firstValueResult instanceof SettableFuture);
    Throwable error = response.getError();
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataBatchRequest.getTenant()\" because \"request\" is null",
        error.getLocalizedMessage());
    assertEquals("Cannot invoke \"org.finos.tracdap.api.MetadataBatchRequest.getTenant()\" because \"request\" is null",
        error.getMessage());
    assertNull(error.getCause());
    assertEquals(0, error.getSuppressed().length);
    assertTrue(firstValueResult.isDone());
  }

  /**
   * Test {@link MetadataApiImpl#search(MetadataSearchRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#search(MetadataSearchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test search(MetadataSearchRequest, StreamObserver); given Statement execute(String) return 'true'; when DefaultInstance; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.search(MetadataSearchRequest, StreamObserver)"})
  void testSearch_givenStatementExecuteReturnTrue_whenDefaultInstance_thenCallsClose() throws SQLException {
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
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null,
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
   * Test {@link MetadataApiImpl#getObject(MetadataGetRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#getObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test getObject(MetadataGetRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.getObject(MetadataGetRequest, StreamObserver)"})
  void testGetObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<org.finos.tracdap.metadata.Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getObject(null, response);

    // Assert
    ListenableFuture<org.finos.tracdap.metadata.Tag> firstValueResult = response.firstValue();
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
   * Test {@link MetadataApiImpl#getLatestObject(MetadataGetRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#getLatestObject(MetadataGetRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test getLatestObject(MetadataGetRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.getLatestObject(MetadataGetRequest, StreamObserver)"})
  void testGetLatestObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<org.finos.tracdap.metadata.Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getLatestObject(null, response);

    // Assert
    ListenableFuture<org.finos.tracdap.metadata.Tag> firstValueResult = response.firstValue();
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
   * Test {@link MetadataApiImpl#getLatestTag(MetadataGetRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiImpl#getLatestTag(MetadataGetRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test getLatestTag(MetadataGetRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataApiImpl.getLatestTag(MetadataGetRequest, StreamObserver)"})
  void testGetLatestTag_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    MetadataApiImpl metadataApiImpl = new MetadataApiImpl(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))), true);
    StreamRecorder<org.finos.tracdap.metadata.Tag> response = StreamRecorder.create();

    // Act
    metadataApiImpl.getLatestTag(null, response);

    // Assert
    ListenableFuture<org.finos.tracdap.metadata.Tag> firstValueResult = response.firstValue();
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

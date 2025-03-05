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
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.finos.tracdap.svc.meta.services.MetadataReadService;
import org.finos.tracdap.svc.meta.services.MetadataSearchService;
import org.finos.tracdap.svc.meta.services.MetadataWriteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TrustedMetadataApiDiffblueTest {
  /**
   * Test {@link TrustedMetadataApi#TrustedMetadataApi(MetadataReadService, MetadataWriteService, MetadataSearchService)}.
   * <p>
   * Method under test: {@link TrustedMetadataApi#TrustedMetadataApi(MetadataReadService, MetadataWriteService, MetadataSearchService)}
   */
  @Test
  @DisplayName("Test new TrustedMetadataApi(MetadataReadService, MetadataWriteService, MetadataSearchService)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TrustedMetadataApi.<init>(MetadataReadService, MetadataWriteService, MetadataSearchService)"})
  void testNewTrustedMetadataApi() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));

    // Act and Assert
    ServerServiceDefinition bindServiceResult = (new TrustedMetadataApi(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))))).bindService();
    ServiceDescriptor serviceDescriptor = bindServiceResult.getServiceDescriptor();
    Collection<MethodDescriptor<?, ?>> methods = serviceDescriptor.getMethods();
    assertEquals(9, methods.size());
    assertTrue(methods instanceof List);
    assertEquals("tracdap.api.internal.TrustedMetadataApi", serviceDescriptor.getName());
    assertEquals(9, bindServiceResult.getMethods().size());
  }

  /**
   * Test {@link TrustedMetadataApi#writeBatch(MetadataWriteBatchRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#writeBatch(MetadataWriteBatchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test writeBatch(MetadataWriteBatchRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.writeBatch(MetadataWriteBatchRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#createObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#createObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.createObject(MetadataWriteRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.updateObject(MetadataWriteRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#updateObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.updateObject(MetadataWriteRequest, StreamObserver)"})
  void testUpdateObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; when DefaultInstance; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.updateTag(MetadataWriteRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#updateTag(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.updateTag(MetadataWriteRequest, StreamObserver)"})
  void testUpdateTag_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#preallocateId(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#preallocateId(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test preallocateId(MetadataWriteRequest, StreamObserver); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.preallocateId(MetadataWriteRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#createPreallocatedObject(MetadataWriteRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test createPreallocatedObject(MetadataWriteRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.createPreallocatedObject(MetadataWriteRequest, StreamObserver)"})
  void testCreatePreallocatedObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
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
   * Test {@link TrustedMetadataApi#readObject(MetadataReadRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#readObject(MetadataReadRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test readObject(MetadataReadRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.readObject(MetadataReadRequest, StreamObserver)"})
  void testReadObject_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<org.finos.tracdap.metadata.Tag> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.readObject(null, response);

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
   * Test {@link TrustedMetadataApi#readBatch(MetadataBatchRequest, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then create firstValue {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#readBatch(MetadataBatchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test readBatch(MetadataBatchRequest, StreamObserver); when 'null'; then create firstValue SettableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.readBatch(MetadataBatchRequest, StreamObserver)"})
  void testReadBatch_whenNull_thenCreateFirstValueSettableFuture() {
    // Arrange
    MetadataWriteService writeService = new MetadataWriteService(
        new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class)));
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null, writeService,
        new MetadataSearchService(new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class))));
    StreamRecorder<MetadataBatchResponse> response = StreamRecorder.create();

    // Act
    trustedMetadataApi.readBatch(null, response);

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
   * Test {@link TrustedMetadataApi#search(MetadataSearchRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link Connection#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrustedMetadataApi#search(MetadataSearchRequest, StreamObserver)}
   */
  @Test
  @DisplayName("Test search(MetadataSearchRequest, StreamObserver); given Statement execute(String) return 'true'; when DefaultInstance; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrustedMetadataApi.search(MetadataSearchRequest, StreamObserver)"})
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
    TrustedMetadataApi trustedMetadataApi = new TrustedMetadataApi(null,
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
}

package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.UUID;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.Value;
import org.h2.tools.SimpleResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadImplDiffblueTest {
  /**
   * Test {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readObjectTypeById(Connection, short, UUID)"
  })
  void testReadObjectTypeById() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadImpl.readObjectTypeById(conn, (short) 1, UUID.randomUUID()));
    verify(conn)
        .prepareStatement(
            "select object_pk, object_type\nfrom object_id\nwhere tenant_id = ?\nand object_id_hi = ?\nand object_id_lo = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  @DisplayName(
      "Test readObjectTypeById(Connection, short, UUID); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readObjectTypeById(Connection, short, UUID)"
  })
  void testReadObjectTypeById_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadImpl.readObjectTypeById(conn, (short) 1, UUID.randomUUID()));
    verify(conn)
        .prepareStatement(
            "select object_pk, object_type\nfrom object_id\nwhere tenant_id = ?\nand object_id_hi = ?\nand object_id_lo = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readObjectTypeById(Connection, short, UUID)"
  })
  void testReadObjectTypeById_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadImpl.readObjectTypeById(conn, (short) 1, UUID.randomUUID()));
    verify(conn)
        .prepareStatement(
            "select object_pk, object_type\nfrom object_id\nwhere tenant_id = ?\nand object_id_hi = ?\nand object_id_lo = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinition(Connection, short, long, TagSelector)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EValidationGap}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinition(Connection, short, long, TagSelector)}
   */
  @Test
  @DisplayName(
      "Test readDefinition(Connection, short, long, TagSelector); when DefaultInstance; then throw EValidationGap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinition(Connection, short, long, TagSelector)"
  })
  void testReadDefinition_whenDefaultInstance_thenThrowEValidationGap() throws SQLException {
    // Arrange, Act and Assert
    assertThrows(
        EValidationGap.class,
        () ->
            new JdbcReadImpl()
                .readDefinition(
                    mock(Connection.class), (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long,
   * int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"
  })
  void testReadDefinitionByVersion() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long,
   * int)}
   */
  @Test
  @DisplayName(
      "Test readDefinitionByVersion(Connection, short, long, int); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"
  })
  void testReadDefinitionByVersion_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long,
   * int)}
   */
  @Test
  @DisplayName(
      "Test readDefinitionByVersion(Connection, short, long, int); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"
  })
  void testReadDefinitionByVersion_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"
  })
  void testReadDefinitionByAsOf() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readDefinitionByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test readDefinitionByAsOf(Connection, short, long, Instant); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"
  })
  void testReadDefinitionByAsOf_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readDefinitionByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n");
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test readDefinitionByAsOf(Connection, short, long, Instant); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"
  })
  void testReadDefinitionByAsOf_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readDefinitionByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"
  })
  void testReadDefinitionByLatest() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName(
      "Test readDefinitionByLatest(Connection, short, long); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"
  })
  void testReadDefinitionByLatest_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"
  })
  void testReadDefinitionByLatest_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(3, true);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecord(Connection, short, long, TagSelector)} with {@code
   * conn}, {@code tenantId}, {@code definitionPk}, {@code selector}.
   *
   * <ul>
   *   <li>Then throw {@link EValidationGap}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecord(Connection, short, long, TagSelector)}
   */
  @Test
  @DisplayName(
      "Test readTagRecord(Connection, short, long, TagSelector) with 'conn', 'tenantId', 'definitionPk', 'selector'; then throw EValidationGap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecord(Connection, short, long, TagSelector)"
  })
  void testReadTagRecordWithConnTenantIdDefinitionPkSelector_thenThrowEValidationGap()
      throws SQLException {
    // Arrange, Act and Assert
    assertThrows(
        EValidationGap.class,
        () ->
            new JdbcReadImpl()
                .readTagRecord(
                    mock(Connection.class), (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readTagRecordByVersion(Connection, short, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"
  })
  void testReadTagRecordByVersion() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName(
      "Test readTagRecordByVersion(Connection, short, long, int); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"
  })
  void testReadTagRecordByVersion_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName(
      "Test readTagRecordByVersion(Connection, short, long, int); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"
  })
  void testReadTagRecordByVersion_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName("Test readTagRecordByAsOf(Connection, short, long, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"
  })
  void testReadTagRecordByAsOf() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readTagRecordByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test readTagRecordByAsOf(Connection, short, long, Instant); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"
  })
  void testReadTagRecordByAsOf_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readTagRecordByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n");
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test readTagRecordByAsOf(Connection, short, long, Instant); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"
  })
  void testReadTagRecordByAsOf_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadImpl.readTagRecordByAsOf(
                conn,
                (short) 1,
                1L,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"
  })
  void testReadTagRecordByLatest() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName(
      "Test readTagRecordByLatest(Connection, short, long); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"
  })
  void testReadTagRecordByLatest_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"
  })
  void testReadTagRecordByLatest_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn)
        .prepareStatement(
            "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(3, true);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}.
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagAttrs(Connection, short, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JdbcReadImpl.readTagAttrs(Connection, short, long)"})
  void testReadTagAttrs() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .setShort(anyInt(), anyShort());
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagAttrs(conn, (short) 1, 1L));
    verify(conn).prepareStatement("select * from tag_attr\nwhere tenant_id = ?\nand tag_fk = ?");
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  @DisplayName(
      "Test readTagAttrs(Connection, short, long); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JdbcReadImpl.readTagAttrs(Connection, short, long)"})
  void testReadTagAttrs_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagAttrs(conn, (short) 1, 1L));
    verify(conn).prepareStatement("select * from tag_attr\nwhere tenant_id = ?\nand tag_fk = ?");
  }

  /**
   * Test {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagAttrs(Connection, short, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JdbcReadImpl.readTagAttrs(Connection, short, long)"})
  void testReadTagAttrs_thenReturnEmpty() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, Value> actualReadTagAttrsResult = jdbcReadImpl.readTagAttrs(conn, (short) 1, 1L);

    // Assert
    verify(conn).prepareStatement("select * from tag_attr\nwhere tenant_id = ?\nand tag_fk = ?");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).close();
    assertTrue(actualReadTagAttrsResult.isEmpty());
  }
}

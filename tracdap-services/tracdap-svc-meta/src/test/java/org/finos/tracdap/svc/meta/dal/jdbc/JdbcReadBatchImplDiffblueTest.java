package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.UUID;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.h2.jdbc.JdbcResultSet;
import org.h2.tools.SimpleResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadBatchImplDiffblueTest {
  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .clearParameters();
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (pk, mapping_stage, ordering)\nvalues (?, ?, ?)");
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader2() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.next()).thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader3() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getLong(anyInt()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet).getLong(1);
    verify(jdbcResultSet).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader4() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet).getBoolean(4);
    verify(jdbcResultSet).getInt(2);
    verify(jdbcResultSet).getLong(1);
    verify(jdbcResultSet).getTimestamp(3);
    verify(jdbcResultSet).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader5() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName())
        .thenReturn("insert into key_mapping (pk, mapping_stage, ordering)\nvalues (?, ?, ?)");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (pk, mapping_stage, ordering)\nvalues (?, ?, ?)");
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link JdbcReadBatchImpl#JdbcReadBatchImpl(IDialect)} with dialect is {@link
   *       OracleDialect} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given JdbcReadBatchImpl(IDialect) with dialect is OracleDialect (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenJdbcReadBatchImplWithDialectIsOracleDialect()
      throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturn42() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("42");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return a string.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturnAString() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName())
        .thenReturn(
            "update key_mapping\n"
                + "set fk = (\n"
                + "  select definition_fk from tag t1\n"
                + "  where t1.tenant_id = ?\n"
                + "  and t1.tag_pk = key_mapping.pk),\n"
                + "ver = (\n"
                + "  select tag_version from tag t2\n"
                + "  where t2.tenant_id = ?\n"
                + "  and t2.tag_pk = key_mapping.pk)\n"
                + "where mapping_stage = ?");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return a string.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturnAString2()
      throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName())
        .thenReturn(
            "select tag.tag_pk, tag.tag_version, tag.tag_timestamp, tag.tag_is_latest\n"
                + "from tag\n"
                + "join key_mapping km\n"
                + "  on tag.tag_pk = km.pk\n"
                + "where tag.tenant_id = ?\n"
                + "  and km.mapping_stage = ?\n"
                + "order by km.ordering");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturnEmptyString()
      throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturnFoo() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("foo");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link OracleDialect} {@link OracleDialect#mappingTableName()} return {@link
   *       JdbcException#SYNTHETIC_ERROR}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given OracleDialect mappingTableName() return SYNTHETIC_ERROR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenOracleDialectMappingTableNameReturnSynthetic_error()
      throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn(JdbcException.SYNTHETIC_ERROR);
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#executeQuery()} return {@link
   *       SimpleResultSet#SimpleResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName(
      "Test readTagWithHeader(Connection, short, long[]); given PreparedStatement executeQuery() return SimpleResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_givenPreparedStatementExecuteQueryReturnSimpleResultSet()
      throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>Then calls {@link JdbcResultSet#getBoolean(int)}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[]); then calls getBoolean(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_thenCallsGetBoolean() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.getBoolean(anyInt())).thenReturn(true);
    when(jdbcResultSet.getInt(anyInt())).thenReturn(1);
    when(jdbcResultSet.getTimestamp(anyInt())).thenReturn(new Timestamp(10L));
    when(jdbcResultSet.getLong(anyInt())).thenReturn(1L);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet, atLeast(1)).getBoolean(4);
    verify(jdbcResultSet, atLeast(1)).getInt(2);
    verify(jdbcResultSet, atLeast(1)).getLong(1);
    verify(jdbcResultSet, atLeast(1)).getTimestamp(3);
    verify(jdbcResultSet, atLeast(1)).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   *
   * <ul>
   *   <li>When empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[]); when empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"
  })
  void testReadTagWithHeader_whenEmptyArrayOfLong() throws SQLException {
    // Arrange
    OracleDialect dialect = mock(OracleDialect.class);
    when(dialect.mappingTableName()).thenReturn("Mapping Table Name");
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(dialect);

    JdbcResultSet jdbcResultSet = mock(JdbcResultSet.class);
    when(jdbcResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(jdbcResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(jdbcResultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[] {}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(dialect, atLeast(1)).mappingTableName();
    verify(jdbcResultSet).close();
    verify(jdbcResultSet).next();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .clearParameters();
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {UUID.randomUUID()}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (id_hi, id_lo, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks2() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (id_hi, id_lo, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code 42}.
   *   <li>When empty array of {@link UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName(
      "Test lookupObjectPks(Connection, short, UUID[]); given array of Object with '42'; when empty array of UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenArrayOfObjectWith42_whenEmptyArrayOfUuid() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName(
      "Test lookupObjectPks(Connection, short, UUID[]); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {UUID.randomUUID()}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (id_hi, id_lo, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#SimpleResultSet()} addRow.
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName(
      "Test lookupObjectPks(Connection, short, UUID[]); given SimpleResultSet() addRow; then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenSimpleResultSetAddRow_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (id_hi, id_lo, mapping_stage, ordering)\nvalues (?, ?, ?, ?)",
        1,
        1,
        1);
    simpleResultSet.addRow();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>Then return array of {@code long} with forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName(
      "Test lookupObjectPks(Connection, short, UUID[]); then return array of long with forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_thenReturnArrayOfLongWithFortyTwo() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (id_hi, id_lo, mapping_stage, ordering)\nvalues (?, ?, ?, ?)",
        1,
        1,
        1);
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupObjectPksResult =
        jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {UUID.randomUUID()});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[] {42L}, actualLookupObjectPksResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   *
   * <ul>
   *   <li>When empty array of {@link UUID}.
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName(
      "Test lookupObjectPks(Connection, short, UUID[]); when empty array of UUID; then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_whenEmptyArrayOfUuid_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupObjectPksResult =
        jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[] {});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[] {}, actualLookupObjectPksResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .clearParameters();
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk2() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk3() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)", 4, 4, 4);
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code 42}.
   *   <li>When empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName(
      "Test lookupDefinitionPk(Connection, short, long[], int[]); given array of Object with '42'; when empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk_givenArrayOfObjectWith42_whenEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName(
      "Test lookupDefinitionPk(Connection, short, long[], int[]); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode()
      throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#SimpleResultSet()} addRow.
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName(
      "Test lookupDefinitionPk(Connection, short, long[], int[]); given SimpleResultSet() addRow; then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk_givenSimpleResultSetAddRow_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)", 4, 4, 4);
    simpleResultSet.addRow();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupDefinitionPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>When empty array of {@code long}.
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[],
   * int[])}
   */
  @Test
  @DisplayName(
      "Test lookupDefinitionPk(Connection, short, long[], int[]); when empty array of long; then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"
  })
  void testLookupDefinitionPk_whenEmptyArrayOfLong_thenReturnEmptyArrayOfLong()
      throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupDefinitionPkResult =
        jdbcReadBatchImpl.lookupDefinitionPk(
            conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[] {}, actualLookupDefinitionPkResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE))
        .when(preparedStatement)
        .clearParameters();
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk2() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    doThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE)).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk3() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)", 4, 4, 4);
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code 42}.
   *   <li>When empty array of {@code long}.
   *   <li>Then calls {@link PreparedStatement#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName(
      "Test lookupTagPk(Connection, short, long[], int[]); given array of Object with '42'; when empty array of long; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenArrayOfObjectWith42_whenEmptyArrayOfLong_thenCallsExecute()
      throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given {@link JdbcException#JdbcException(JdbcErrorCode)} with errorCode is {@code
   *       UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName(
      "Test lookupTagPk(Connection, short, long[], int[]); given JdbcException(JdbcErrorCode) with errorCode is 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenJdbcExceptionWithErrorCodeIsUnknownErrorCode() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn)
        .prepareStatement(
            "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)");
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#SimpleResultSet()} addRow.
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName(
      "Test lookupTagPk(Connection, short, long[], int[]); given SimpleResultSet() addRow; then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenSimpleResultSetAddRow_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn(
        "insert into key_mapping (fk, ver, mapping_stage, ordering)\nvalues (?, ?, ?, ?)", 4, 4, 4);
    simpleResultSet.addRow();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_thenCallsAddBatch() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcReadBatchImpl.lookupTagPk(
                conn, (short) 1, new long[] {1L, -1L, 1L, -1L}, new int[] {1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   *
   * <ul>
   *   <li>When empty array of {@code long}.
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName(
      "Test lookupTagPk(Connection, short, long[], int[]); when empty array of long; then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_whenEmptyArrayOfLong_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupTagPkResult =
        jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[] {}, new int[] {1, 0, 1, 0});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[] {}, actualLookupTagPkResult);
  }
}

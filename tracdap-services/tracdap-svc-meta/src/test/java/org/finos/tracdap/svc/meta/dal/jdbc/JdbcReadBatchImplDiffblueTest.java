package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.Tag.Builder;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItems;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadBatchImplDiffblueTest {
  /**
   * Test {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@link KeyedItems#versions} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID[]); given ResultSet next() return 'false'; then return versions is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readObjectTypeById(Connection, short, UUID[])"})
  void testReadObjectTypeById_givenResultSetNextReturnFalse_thenReturnVersionsIsNull() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItems<ObjectType> actualReadObjectTypeByIdResult = jdbcReadBatchImpl.readObjectTypeById(conn, (short) 1,
        new UUID[]{});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertNull(actualReadObjectTypeByIdResult.versions);
    assertNull(actualReadObjectTypeByIdResult.timestamps);
    assertNull(actualReadObjectTypeByIdResult.isLatest);
    assertEquals(0, actualReadObjectTypeByIdResult.items.length);
    assertArrayEquals(new long[]{}, actualReadObjectTypeByIdResult.keys);
  }

  /**
   * Test {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID[]); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readObjectTypeById(Connection, short, UUID[])"})
  void testReadObjectTypeById_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.readObjectTypeById(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID[]); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readObjectTypeById(Connection, short, UUID[])"})
  void testReadObjectTypeById_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcReadBatchImpl.readObjectTypeById(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}.
   * <ul>
   *   <li>When empty array of {@link UUID}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID[]); when empty array of UUID; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readObjectTypeById(Connection, short, UUID[])"})
  void testReadObjectTypeById_whenEmptyArrayOfUuid_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadBatchImpl.readObjectTypeById(conn, (short) 1, new UUID[]{}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#clearParameters()} throw {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long[], TagSelector[]); given PreparedStatement clearParameters() throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readDefinition(Connection, short, long[], TagSelector[])"})
  void testReadDefinition_givenPreparedStatementClearParametersThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(preparedStatement).clearParameters();
    doThrow(new SQLException()).when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.readDefinition(conn, (short) 1,
        new long[]{1L, -1L, 1L, -1L}, new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn).prepareStatement(eq(
        "insert into key_mapping (\n  fk, ver, as_of, is_latest,\n  mapping_stage, ordering)\nvalues (?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long[], TagSelector[]); given ResultSet next() return 'false'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readDefinition(Connection, short, long[], TagSelector[])"})
  void testReadDefinition_givenResultSetNextReturnFalse_thenReturnArrayLengthIsZero() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItems<ObjectDefinition> actualReadDefinitionResult = jdbcReadBatchImpl.readDefinition(conn, (short) 1,
        new long[]{}, new TagSelector[]{TagSelector.getDefaultInstance()});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertEquals(0, actualReadDefinitionResult.items.length);
    assertEquals(0, actualReadDefinitionResult.timestamps.length);
    assertArrayEquals(new int[]{}, actualReadDefinitionResult.versions);
    assertArrayEquals(new long[]{}, actualReadDefinitionResult.keys);
    assertArrayEquals(new boolean[]{}, actualReadDefinitionResult.isLatest);
  }

  /**
   * Test {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code true}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long[], TagSelector[]); given ResultSet next() return 'true'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readDefinition(Connection, short, long[], TagSelector[])"})
  void testReadDefinition_givenResultSetNextReturnTrue_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadBatchImpl.readDefinition(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long[], TagSelector[]); given ResultSet next() throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readDefinition(Connection, short, long[], TagSelector[])"})
  void testReadDefinition_givenResultSetNextThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
    doThrow(new SQLException()).when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.readDefinition(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long[], TagSelector[]); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readDefinition(Connection, short, long[], TagSelector[])"})
  void testReadDefinition_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadBatchImpl.readDefinition(conn, (short) 1,
        new long[]{1L, -1L, 1L, -1L}, new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn).prepareStatement(eq(
        "insert into key_mapping (\n  fk, ver, as_of, is_latest,\n  mapping_stage, ordering)\nvalues (?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), anyInt());
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#clearParameters()} throw {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); given PreparedStatement clearParameters() throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_givenPreparedStatementClearParametersThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(preparedStatement).clearParameters();
    doThrow(new SQLException()).when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{1L, -1L, 1L, -1L},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn).prepareStatement(eq(
        "insert into key_mapping (\n  fk, ver, as_of, is_latest,\n  mapping_stage, ordering)\nvalues (?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(String)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then calls {@link ResultSet#getInt(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); given ResultSet getInt(String) throw SQLException(); then calls getInt(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_givenResultSetGetIntThrowSQLException_thenCallsGetInt() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(Mockito.<String>any())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getInt(eq("tag_index"));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); given ResultSet next() return 'false'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_givenResultSetNextReturnFalse_thenReturnArrayLengthIsZero() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItems<Builder> actualReadTagResult = jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertEquals(0, actualReadTagResult.items.length);
    assertEquals(0, actualReadTagResult.timestamps.length);
    assertArrayEquals(new int[]{}, actualReadTagResult.versions);
    assertArrayEquals(new long[]{}, actualReadTagResult.keys);
    assertArrayEquals(new boolean[]{}, actualReadTagResult.isLatest);
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code true}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); given ResultSet next() return 'true'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_givenResultSetNextReturnTrue_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); given ResultSet next() throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_givenResultSetNextThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
    doThrow(new SQLException()).when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}.
   * <ul>
   *   <li>When array of {@code long} with one and minus one.</li>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  @DisplayName("Test readTag(Connection, short, long[], TagSelector[]); when array of long with one and minus one; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTag(Connection, short, long[], TagSelector[])"})
  void testReadTag_whenArrayOfLongWithOneAndMinusOne_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{1L, -1L, 1L, -1L},
        new TagSelector[]{TagSelector.getDefaultInstance()}));
    verify(conn).prepareStatement(eq(
        "insert into key_mapping (\n  fk, ver, as_of, is_latest,\n  mapping_stage, ordering)\nvalues (?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), anyInt());
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[]); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"})
  void testReadTagWithHeader_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   * <ul>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[]); then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"})
  void testReadTagWithHeader_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(timestamp, atLeast(1)).toInstant();
  }

  /**
   * Test {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}.
   * <ul>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  @DisplayName("Test readTagWithHeader(Connection, short, long[]); then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItems JdbcReadBatchImpl.readTagWithHeader(Connection, short, long[])"})
  void testReadTagWithHeader_thenThrowJdbcException2() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.readTagWithHeader(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement, atLeast(1)).setShort(anyInt(), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(timestamp, atLeast(1)).toInstant();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); given ResultSet getLong(int) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenResultSetGetLongThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); given ResultSet wasNull() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenResultSetWasNullReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); given ResultSet wasNull() return 'true'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_givenResultSetWasNullReturnTrue_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1, new UUID[]{UUID.randomUUID()}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(resultSet).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}.
   * <ul>
   *   <li>Then return array of {@code long} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  @DisplayName("Test lookupObjectPks(Connection, short, UUID[]); then return array of long with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupObjectPks(Connection, short, UUID[])"})
  void testLookupObjectPks_thenReturnArrayOfLongWithOne() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupObjectPksResult = jdbcReadBatchImpl.lookupObjectPks(conn, (short) 1,
        new UUID[]{UUID.randomUUID()});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[]{1L}, actualLookupObjectPksResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return empty array of {@code long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); given ResultSet next() return 'false'; then return empty array of long")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"})
  void testLookupDefinitionPk_givenResultSetNextReturnFalse_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupDefinitionPkResult = jdbcReadBatchImpl.lookupDefinitionPk(conn, (short) 1, new long[]{},
        new int[]{1, 0, 1, 0});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[]{}, actualLookupDefinitionPkResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code false}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); given ResultSet wasNull() return 'false'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"})
  void testLookupDefinitionPk_givenResultSetWasNullReturnFalse_thenCallsWasNull() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadBatchImpl.lookupDefinitionPk(conn, (short) 1,
        new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); given ResultSet wasNull() return 'true'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"})
  void testLookupDefinitionPk_givenResultSetWasNullReturnTrue_thenCallsWasNull() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadBatchImpl.lookupDefinitionPk(conn, (short) 1,
        new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(resultSet).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"})
  void testLookupDefinitionPk_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadBatchImpl.lookupDefinitionPk(conn, (short) 1,
        new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>When empty array of {@code long}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupDefinitionPk(Connection, short, long[], int[]); when empty array of long; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupDefinitionPk(Connection, short, long[], int[])"})
  void testLookupDefinitionPk_whenEmptyArrayOfLong_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupDefinitionPk(conn, (short) 1, new long[]{}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); given ResultSet getLong(int) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenResultSetGetLongThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return empty array of {@code long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); given ResultSet next() return 'false'; then return empty array of long")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenResultSetNextReturnFalse_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualLookupTagPkResult = jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[]{},
        new int[]{1, 0, 1, 0});

    // Assert
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    assertArrayEquals(new long[]{}, actualLookupTagPkResult);
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code false}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); given ResultSet wasNull() return 'false'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenResultSetWasNullReturnFalse_thenCallsWasNull() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); given ResultSet wasNull() return 'true'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_givenResultSetWasNullReturnTrue_thenCallsWasNull() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).clearParameters();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[]{1L, -1L, 1L, -1L}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).clearParameters();
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(eq(1), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(resultSet).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}.
   * <ul>
   *   <li>When empty array of {@code long}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  @DisplayName("Test lookupTagPk(Connection, short, long[], int[]); when empty array of long; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcReadBatchImpl.lookupTagPk(Connection, short, long[], int[])"})
  void testLookupTagPk_whenEmptyArrayOfLong_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadBatchImpl jdbcReadBatchImpl = new JdbcReadBatchImpl(new OracleDialect());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcReadBatchImpl.lookupTagPk(conn, (short) 1, new long[]{}, new int[]{1, 0, 1, 0}));
    verify(conn, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
  }
}

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
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadBatchImplDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  void testReadObjectTypeById() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  void testReadObjectTypeById2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  void testReadObjectTypeById3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readObjectTypeById(Connection, short, UUID[])}
   */
  @Test
  void testReadObjectTypeById4() throws SQLException {
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
    JdbcBaseDal.KeyedItems<ObjectType> actualReadObjectTypeByIdResult = jdbcReadBatchImpl.readObjectTypeById(conn,
        (short) 1, new UUID[]{});

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
    assertEquals(0, actualReadObjectTypeByIdResult.keys.length);
  }

  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadDefinition() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadDefinition2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadDefinition3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadDefinition4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readDefinition(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadDefinition5() throws SQLException {
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
    JdbcBaseDal.KeyedItems<ObjectDefinition> actualReadDefinitionResult = jdbcReadBatchImpl.readDefinition(conn,
        (short) 1, new long[]{}, new TagSelector[]{TagSelector.getDefaultInstance()});

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
    assertEquals(0, actualReadDefinitionResult.isLatest.length);
    assertEquals(0, actualReadDefinitionResult.items.length);
    assertEquals(0, actualReadDefinitionResult.keys.length);
    assertEquals(0, actualReadDefinitionResult.timestamps.length);
    assertEquals(0, actualReadDefinitionResult.versions.length);
  }

  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag5() throws SQLException {
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
    JdbcBaseDal.KeyedItems<Tag.Builder> actualReadTagResult = jdbcReadBatchImpl.readTag(conn, (short) 1, new long[]{},
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
    assertEquals(0, actualReadTagResult.isLatest.length);
    assertEquals(0, actualReadTagResult.items.length);
    assertEquals(0, actualReadTagResult.keys.length);
    assertEquals(0, actualReadTagResult.timestamps.length);
    assertEquals(0, actualReadTagResult.versions.length);
  }

  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#readTag(Connection, short, long[], TagSelector[])}
   */
  @Test
  void testReadTag6() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  void testReadTagWithHeader() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  void testReadTagWithHeader2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#readTagWithHeader(Connection, short, long[])}
   */
  @Test
  void testReadTagWithHeader3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  void testLookupObjectPks() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  void testLookupObjectPks2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  void testLookupObjectPks3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  void testLookupObjectPks4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupObjectPks(Connection, short, UUID[])}
   */
  @Test
  void testLookupObjectPks5() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupDefinitionPk() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupDefinitionPk2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupDefinitionPk3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupDefinitionPk4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupDefinitionPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupDefinitionPk5() throws SQLException {
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
    assertEquals(0, actualLookupDefinitionPkResult.length);
  }

  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupTagPk() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupTagPk2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupTagPk3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupTagPk4() throws SQLException {
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

  /**
   * Method under test:
   * {@link JdbcReadBatchImpl#lookupTagPk(Connection, short, long[], int[])}
   */
  @Test
  void testLookupTagPk5() throws SQLException {
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
    assertEquals(0, actualLookupTagPkResult.length);
  }
}

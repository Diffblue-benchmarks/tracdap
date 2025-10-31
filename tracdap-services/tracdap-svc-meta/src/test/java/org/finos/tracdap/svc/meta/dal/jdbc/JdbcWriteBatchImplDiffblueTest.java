package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal.ObjectParts;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcWriteBatchImplDiffblueTest {
  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code true}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeObjectDefinition(Connection, short, long[], ObjectParts); given ResultSet next() return 'true'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"})
  void testWriteObjectDefinition_givenResultSetNextReturnTrue_thenThrowJdbcException() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcWriteBatchImpl.writeObjectDefinition(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then return empty array of {@code long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeObjectDefinition(Connection, short, long[], ObjectParts); then return empty array of long")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"})
  void testWriteObjectDefinition_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act
    long[] actualWriteObjectDefinitionResult = jdbcWriteBatchImpl.writeObjectDefinition(conn, (short) 291, new long[]{},
        new ObjectParts());

    // Assert
    verify(conn).prepareStatement(eq(
        "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
    assertArrayEquals(new long[]{}, actualWriteObjectDefinitionResult);
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeObjectDefinition(Connection, short, long[], ObjectParts); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"})
  void testWriteObjectDefinition_thenThrowSQLException() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
    doThrow(new SQLException()).when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcWriteBatchImpl.writeObjectDefinition(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return empty array of {@code long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagRecord(Connection, short, long[], ObjectParts); given ResultSet next() return 'false'; then return empty array of long")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"})
  void testWriteTagRecord_givenResultSetNextReturnFalse_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act
    long[] actualWriteTagRecordResult = jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[]{},
        new ObjectParts());

    // Assert
    verify(conn).prepareStatement(eq(
        "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
    assertArrayEquals(new long[]{}, actualWriteTagRecordResult);
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code true}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagRecord(Connection, short, long[], ObjectParts); given ResultSet next() return 'true'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"})
  void testWriteTagRecord_givenResultSetNextReturnTrue_thenThrowJdbcException() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class,
        () -> jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagRecord(Connection, short, long[], ObjectParts); given ResultSet next() throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"})
  void testWriteTagRecord_givenResultSetNextThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
    doThrow(new SQLException()).when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}.
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagAttrs(Connection, short, long[], ObjectParts)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.writeTagAttrs(Connection, short, long[], ObjectParts)"})
  void testWriteTagAttrs() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), anyInt())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.writeTagAttrs(conn, (short) 291, new long[]{}, new ObjectParts());

    // Assert
    verify(conn).prepareStatement(eq(
        "insert into tag_attr (\n  tenant_id,\n  tag_fk,\n  attr_name,\n  attr_type,\n  attr_index,\n  attr_value_boolean,\n  attr_value_integer,\n  attr_value_float,\n  attr_value_string,\n  attr_value_decimal,\n  attr_value_date,\n  attr_value_datetime\n)\nvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        eq(1));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagAttrs(Connection, short, long[], ObjectParts); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.writeTagAttrs(Connection, short, long[], ObjectParts)"})
  void testWriteTagAttrs_thenThrowETracInternal() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), anyInt())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> jdbcWriteBatchImpl.writeTagAttrs(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "insert into tag_attr (\n  tenant_id,\n  tag_fk,\n  attr_name,\n  attr_type,\n  attr_index,\n  attr_value_boolean,\n  attr_value_integer,\n  attr_value_float,\n  attr_value_string,\n  attr_value_decimal,\n  attr_value_date,\n  attr_value_datetime\n)\nvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        eq(1));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeObjectDefinition(Connection, short, long[], ObjectParts); then calls prepareStatement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.closeObjectDefinition(Connection, short, long[], ObjectParts)"})
  void testCloseObjectDefinition_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.closeObjectDefinition(conn, (short) 291, new long[]{}, new ObjectParts());

    // Assert
    verify(conn).prepareStatement(eq(
        "update object_definition \nset\n  object_superseded = ?,\n  object_is_latest = ?\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeObjectDefinition(Connection, short, long[], ObjectParts); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.closeObjectDefinition(Connection, short, long[], ObjectParts)"})
  void testCloseObjectDefinition_thenThrowETracInternal() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> jdbcWriteBatchImpl.closeObjectDefinition(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "update object_definition \nset\n  object_superseded = ?,\n  object_is_latest = ?\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeTagRecord(Connection, short, long[], ObjectParts); then calls prepareStatement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.closeTagRecord(Connection, short, long[], ObjectParts)"})
  void testCloseTagRecord_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.closeTagRecord(conn, (short) 291, new long[]{}, new ObjectParts());

    // Assert
    verify(conn).prepareStatement(eq(
        "update tag \nset\n  tag_superseded = ?,\n  tag_is_latest = ?\nwhere tenant_id = ?\n  and definition_fk = ?\n  and tag_is_latest = ?"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeTagRecord(Connection, short, long[], ObjectParts); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcWriteBatchImpl.closeTagRecord(Connection, short, long[], ObjectParts)"})
  void testCloseTagRecord_thenThrowETracInternal() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl = new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> jdbcWriteBatchImpl.closeTagRecord(conn, (short) 291, new long[]{}, new ObjectParts()));
    verify(conn).prepareStatement(eq(
        "update tag \nset\n  tag_superseded = ?,\n  tag_is_latest = ?\nwhere tenant_id = ?\n  and definition_fk = ?\n  and tag_is_latest = ?"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }
}

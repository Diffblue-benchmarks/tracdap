package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal.ObjectParts;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.h2.tools.SimpleResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcWriteBatchImplDiffblueTest {
  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectId(Connection, short, ObjectParts)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeObjectId(Connection, short, ObjectParts)}
   */
  @Test
  @DisplayName("Test writeObjectId(Connection, short, ObjectParts); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcWriteBatchImpl.writeObjectId(Connection, short, ObjectParts)"})
  void testWriteObjectId_thenThrowETracInternal() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> jdbcWriteBatchImpl.writeObjectId(conn, (short) 291, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into object_id (\n  tenant_id,\n  object_type,\n  object_id_hi,\n  object_id_lo\n)\nvalues (?, ?, ?, ?)"),
            isA(String[].class));
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test writeObjectDefinition(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testWriteObjectDefinition() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeObjectDefinition(
                conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Row}.
   *   <li>Then throw {@link JdbcException}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeObjectDefinition(Connection, short, long[], ObjectParts); given array of Object with 'Row'; then throw JdbcException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testWriteObjectDefinition_givenArrayOfObjectWithRow_thenThrowJdbcException()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addRow("Row");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcWriteBatchImpl.writeObjectDefinition(
                conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeObjectDefinition(Connection, short, long[], ObjectParts); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testWriteObjectDefinition_givenETracInternalWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeObjectDefinition(
                conn,
                (short) 291,
                new long[] {81985529216486895L, 1L, 81985529216486895L, 1L},
                new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeObjectDefinition(Connection, short, long[], ObjectParts); then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testWriteObjectDefinition_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act
    long[] actualWriteObjectDefinitionResult =
        jdbcWriteBatchImpl.writeObjectDefinition(
            conn, (short) 291, new long[] {}, new ObjectParts());

    // Assert
    verify(conn)
        .prepareStatement(
            eq(
                "insert into object_definition (\n  tenant_id,\n  object_fk,\n  object_version,\n  object_timestamp,\n  object_is_latest,\n  meta_format,\n  meta_version,\n  definition)\nvalues (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
    assertArrayEquals(new long[] {}, actualWriteObjectDefinitionResult);
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagRecord(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagRecord() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Row}.
   *   <li>Then throw {@link JdbcException}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeTagRecord(Connection, short, long[], ObjectParts); given array of Object with 'Row'; then throw JdbcException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagRecord_givenArrayOfObjectWithRow_thenThrowJdbcException() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addRow("Row");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        JdbcException.class,
        () ->
            jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeTagRecord(Connection, short, long[], ObjectParts); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagRecord_givenETracInternalWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeTagRecord(
                conn,
                (short) 291,
                new long[] {81985529216486895L, 1L, 81985529216486895L, 1L},
                new ObjectParts()));
    verify(conn)
        .prepareStatement(
            eq(
                "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeTagRecord(Connection, short, long[], ObjectParts); then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long[] JdbcWriteBatchImpl.writeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagRecord_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getGeneratedKeys()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);

    // Act
    long[] actualWriteTagRecordResult =
        jdbcWriteBatchImpl.writeTagRecord(conn, (short) 291, new long[] {}, new ObjectParts());

    // Assert
    verify(conn)
        .prepareStatement(
            eq(
                "insert into tag (\n  tenant_id,\n  definition_fk,\n  tag_version,\n  tag_timestamp,\n  tag_is_latest,\n  object_type)\nvalues (?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getGeneratedKeys();
    assertArrayEquals(new long[] {}, actualWriteTagRecordResult);
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagAttrs(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.writeTagAttrs(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagAttrs() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), anyInt())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.writeTagAttrs(conn, (short) 291, new long[] {}, new ObjectParts());

    // Assert
    verify(conn)
        .prepareStatement(
            "insert into tag_attr (\n  tenant_id,\n  tag_fk,\n  attr_name,\n  attr_type,\n  attr_index,\n  attr_value_boolean,\n  attr_value_integer,\n  attr_value_float,\n  attr_value_string,\n  attr_value_decimal,\n  attr_value_date,\n  attr_value_datetime\n)\nvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            1);
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName("Test writeTagAttrs(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.writeTagAttrs(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagAttrs2() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), anyInt())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeTagAttrs(conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "insert into tag_attr (\n  tenant_id,\n  tag_fk,\n  attr_name,\n  attr_type,\n  attr_index,\n  attr_value_boolean,\n  attr_value_integer,\n  attr_value_float,\n  attr_value_string,\n  attr_value_decimal,\n  attr_value_date,\n  attr_value_datetime\n)\nvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            1);
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#writeTagAttrs(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test writeTagAttrs(Connection, short, long[], ObjectParts); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.writeTagAttrs(Connection, short, long[], ObjectParts)"
  })
  void testWriteTagAttrs_givenETracInternalWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any(), anyInt()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.writeTagAttrs(
                conn,
                (short) 291,
                new long[] {81985529216486895L, 1L, 81985529216486895L, 1L},
                new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "insert into tag_attr (\n  tenant_id,\n  tag_fk,\n  attr_name,\n  attr_type,\n  attr_index,\n  attr_value_boolean,\n  attr_value_integer,\n  attr_value_float,\n  attr_value_string,\n  attr_value_decimal,\n  attr_value_date,\n  attr_value_datetime\n)\nvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            1);
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeObjectDefinition(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testCloseObjectDefinition() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.closeObjectDefinition(conn, (short) 291, new long[] {}, new ObjectParts());

    // Assert
    verify(conn)
        .prepareStatement(
            "update object_definition \nset\n  object_superseded = ?,\n  object_is_latest = ?\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName("Test closeObjectDefinition(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testCloseObjectDefinition2() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.closeObjectDefinition(
                conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "update object_definition \nset\n  object_superseded = ?,\n  object_is_latest = ?\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeObjectDefinition(Connection, short,
   * long[], ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test closeObjectDefinition(Connection, short, long[], ObjectParts); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeObjectDefinition(Connection, short, long[], ObjectParts)"
  })
  void testCloseObjectDefinition_givenETracInternalWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.closeObjectDefinition(
                conn, (short) 291, new long[] {1L, -1L, 1L, -1L}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "update object_definition \nset\n  object_superseded = ?,\n  object_is_latest = ?\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?");
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName("Test closeTagRecord(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testCloseTagRecord() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcWriteBatchImpl.closeTagRecord(conn, (short) 291, new long[] {}, new ObjectParts());

    // Assert
    verify(conn)
        .prepareStatement(
            "update tag \nset\n  tag_superseded = ?,\n  tag_is_latest = ?\nwhere tenant_id = ?\n  and definition_fk = ?\n  and tag_is_latest = ?");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName("Test closeTagRecord(Connection, short, long[], ObjectParts)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testCloseTagRecord2() throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch())
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.closeTagRecord(conn, (short) 291, new long[] {}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "update tag \nset\n  tag_superseded = ?,\n  tag_is_latest = ?\nwhere tenant_id = ?\n  and definition_fk = ?\n  and tag_is_latest = ?");
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
  }

  /**
   * Test {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[], ObjectParts)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcWriteBatchImpl#closeTagRecord(Connection, short, long[],
   * ObjectParts)}
   */
  @Test
  @DisplayName(
      "Test closeTagRecord(Connection, short, long[], ObjectParts); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JdbcWriteBatchImpl.closeTagRecord(Connection, short, long[], ObjectParts)"
  })
  void testCloseTagRecord_givenETracInternalWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    OracleDialect dialect = new OracleDialect();
    JdbcWriteBatchImpl jdbcWriteBatchImpl =
        new JdbcWriteBatchImpl(dialect, new JdbcReadBatchImpl(new OracleDialect()));

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            jdbcWriteBatchImpl.closeTagRecord(
                conn, (short) 291, new long[] {1L, -1L, 1L, -1L}, new ObjectParts()));
    verify(conn)
        .prepareStatement(
            "update tag \nset\n  tag_superseded = ?,\n  tag_is_latest = ?\nwhere tenant_id = ?\n  and definition_fk = ?\n  and tag_is_latest = ?");
  }
}

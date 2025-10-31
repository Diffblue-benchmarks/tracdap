package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import javax.sql.DataSource;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.H2SqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.MariaDbDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.MySqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.PostgreSqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.SqlServerDialect;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcBaseDalDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcBaseDal.KeyedItem#KeyedItem(long, int, Instant, Object, boolean)}
   */
  @Test
  void testKeyedItemNewKeyedItem() {
    // Arrange and Act
    JdbcBaseDal.KeyedItem<Object> actualKeyedItem = new JdbcBaseDal.KeyedItem<>(1L, 1,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), "Item", true);

    // Assert
    assertEquals("Item", actualKeyedItem.item);
    Instant instant = actualKeyedItem.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, actualKeyedItem.version);
    assertEquals(1L, actualKeyedItem.key);
    assertTrue(actualKeyedItem.isLatest);
  }

  /**
   * Method under test: {@link JdbcBaseDal.KeyedItem#KeyedItem(long, Object)}
   */
  @Test
  void testKeyedItemNewKeyedItem2() {
    // Arrange and Act
    JdbcBaseDal.KeyedItem<Object> actualKeyedItem = new JdbcBaseDal.KeyedItem<>(1L, "Item");

    // Assert
    assertEquals("Item", actualKeyedItem.item);
    assertNull(actualKeyedItem.timestamp);
    assertEquals(0, actualKeyedItem.version);
    assertEquals(1L, actualKeyedItem.key);
    assertFalse(actualKeyedItem.isLatest);
  }

  /**
   * Method under test:
   * {@link JdbcBaseDal.KeyedItems#KeyedItems(long[], int[], Object[])}
   */
  @Test
  void testKeyedItemsNewKeyedItems() {
    // Arrange and Act
    JdbcBaseDal.KeyedItems<Object> actualKeyedItems = new JdbcBaseDal.KeyedItems<>(new long[]{1L, -1L, 1L, -1L},
        new int[]{1, -1, 1, -1}, new Object[]{"Items"});

    // Assert
    Object[] objectArray = actualKeyedItems.items;
    assertEquals("Items", objectArray[0]);
    assertNull(actualKeyedItems.timestamps);
    assertNull(actualKeyedItems.isLatest);
    assertEquals(1, objectArray.length);
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualKeyedItems.versions);
    assertArrayEquals(new long[]{1L, -1L, 1L, -1L}, actualKeyedItems.keys);
  }

  /**
   * Method under test:
   * {@link JdbcBaseDal.KeyedItems#KeyedItems(long[], int[], Instant[], Object[], boolean[])}
   */
  @Test
  void testKeyedItemsNewKeyedItems2() {
    // Arrange and Act
    JdbcBaseDal.KeyedItems<Object> actualKeyedItems = new JdbcBaseDal.KeyedItems<>(new long[]{1L, -1L, 1L, -1L},
        new int[]{1, -1, 1, -1},
        new Instant[]{LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()},
        new Object[]{"Items"}, new boolean[]{true, false, true, false});

    // Assert
    Object[] objectArray = actualKeyedItems.items;
    assertEquals("Items", objectArray[0]);
    Instant[] instantArray = actualKeyedItems.timestamps;
    Instant instant = instantArray[0];
    assertEquals(0, instant.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, objectArray.length);
    assertEquals(1, instantArray.length);
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualKeyedItems.versions);
    assertArrayEquals(new long[]{1L, -1L, 1L, -1L}, actualKeyedItems.keys);
    assertArrayEquals(new boolean[]{true, false, true, false}, actualKeyedItems.isLatest);
  }

  /**
   * Method under test:
   * {@link JdbcBaseDal.KeyedItems#KeyedItems(long[], Object[])}
   */
  @Test
  void testKeyedItemsNewKeyedItems3() {
    // Arrange and Act
    JdbcBaseDal.KeyedItems<Object> actualKeyedItems = new JdbcBaseDal.KeyedItems<>(new long[]{1L, -1L, 1L, -1L},
        new Object[]{"Items"});

    // Assert
    Object[] objectArray = actualKeyedItems.items;
    assertEquals("Items", objectArray[0]);
    assertNull(actualKeyedItems.versions);
    assertNull(actualKeyedItems.timestamps);
    assertNull(actualKeyedItems.isLatest);
    assertEquals(1, objectArray.length);
    assertArrayEquals(new long[]{1L, -1L, 1L, -1L}, actualKeyedItems.keys);
  }

  /**
   * Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.H2);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MYSQL);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable3() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.POSTGRESQL);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq(
        "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;"));
  }

  /**
   * Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable4() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.SQLSERVER);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link JdbcBaseDal#executeDirect(JdbcBaseDal.JdbcAction)}
   */
  @Test
  void testExecuteDirect() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);
    JdbcBaseDal.JdbcAction func = mock(JdbcBaseDal.JdbcAction.class);
    doNothing().when(func).apply(Mockito.<Connection>any());

    // Act
    jdbcBaseDal.executeDirect(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(eq(false));
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Method under test: {@link JdbcBaseDal#executeDirect(JdbcBaseDal.JdbcAction)}
   */
  @Test
  void testExecuteDirect2() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);
    JdbcBaseDal.JdbcAction func = mock(JdbcBaseDal.JdbcAction.class);
    doThrow(new SQLException()).when(func).apply(Mockito.<Connection>any());

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcBaseDal.executeDirect(func));
    verify(connection).close();
    verify(connection).setAutoCommit(eq(false));
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Method under test: {@link JdbcBaseDal#executeDirect(JdbcBaseDal.JdbcAction)}
   */
  @Test
  void testExecuteDirect3() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doThrow(new SQLException()).when(connection).close();
    doThrow(new SQLException()).when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new JdbcMetadataDal(JdbcDialect.H2, dataSource)).executeDirect(mock(JdbcBaseDal.JdbcAction.class)));
    verify(connection).close();
    verify(connection).setAutoCommit(eq(false));
    verify(dataSource).getConnection();
  }

  /**
   * Method under test: {@link JdbcBaseDal#executeDirect(JdbcBaseDal.JdbcAction)}
   */
  @Test
  void testExecuteDirect4() throws SQLException {
    // Arrange
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new JdbcMetadataDal(JdbcDialect.H2, dataSource)).executeDirect(mock(JdbcBaseDal.JdbcAction.class)));
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link JdbcBaseDal#wrapTransaction(JdbcBaseDal.JdbcAction)}
   */
  @Test
  void testWrapTransaction() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);
    JdbcBaseDal.JdbcAction func = mock(JdbcBaseDal.JdbcAction.class);
    doNothing().when(func).apply(Mockito.<Connection>any());

    // Act
    jdbcBaseDal.wrapTransaction(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(eq(false));
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Method under test:
   * {@link JdbcBaseDal#wrapTransaction(JdbcBaseDal.JdbcFunction)}
   */
  @Test
  void testWrapTransaction2() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);
    JdbcBaseDal.JdbcFunction<Object> func = mock(JdbcBaseDal.JdbcFunction.class);
    when(func.apply(Mockito.<Connection>any())).thenReturn("Apply");

    // Act
    Object actualWrapTransactionResult = jdbcBaseDal.wrapTransaction(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(eq(false));
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
    assertEquals("Apply", actualWrapTransactionResult);
  }

  /**
   * Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  void testNewJdbcBaseDal() {
    // Arrange, Act and Assert
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.H2)).dialect instanceof H2SqlDialect);
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MYSQL)).dialect instanceof MySqlDialect);
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MARIADB)).dialect instanceof MariaDbDialect);
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.POSTGRESQL)).dialect instanceof PostgreSqlDialect);
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.SQLSERVER)).dialect instanceof SqlServerDialect);
    assertTrue((new JdbcBaseDal(mock(DataSource.class), JdbcDialect.ORACLE)).dialect instanceof OracleDialect);
  }
}

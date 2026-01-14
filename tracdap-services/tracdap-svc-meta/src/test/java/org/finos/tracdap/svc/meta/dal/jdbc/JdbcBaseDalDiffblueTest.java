package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import javax.sql.DataSource;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.JdbcAction;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.JdbcFunction;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.H2SqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.MariaDbDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.MySqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.PostgreSqlDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.SqlServerDialect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcBaseDalDiffblueTest {
  /**
   * Test KeyedItem {@link KeyedItem#KeyedItem(long, int, Instant, Object, boolean)}.
   *
   * <p>Method under test: {@link KeyedItem#KeyedItem(long, int, Instant, Object, boolean)}
   */
  @Test
  @DisplayName("Test KeyedItem new KeyedItem(long, int, Instant, Object, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyedItem.<init>(long, int, Instant, Object, boolean)"})
  void testKeyedItemNewKeyedItem() {
    // Arrange and Act
    KeyedItem<Object> actualKeyedItem =
        new KeyedItem<>(
            1L,
            1,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            "Item",
            true);

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
   * Test KeyedItem {@link KeyedItem#KeyedItem(long, Object)}.
   *
   * <p>Method under test: {@link KeyedItem#KeyedItem(long, Object)}
   */
  @Test
  @DisplayName("Test KeyedItem new KeyedItem(long, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyedItem.<init>(long, Object)"})
  void testKeyedItemNewKeyedItem2() {
    // Arrange and Act
    KeyedItem<Object> actualKeyedItem = new KeyedItem<>(1L, "Item");

    // Assert
    assertEquals("Item", actualKeyedItem.item);
    assertNull(actualKeyedItem.timestamp);
    assertEquals(0, actualKeyedItem.version);
    assertEquals(1L, actualKeyedItem.key);
    assertFalse(actualKeyedItem.isLatest);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code H2}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link H2SqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'H2'; then dialect return H2SqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenH2_thenDialectReturnH2SqlDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.H2).dialect instanceof H2SqlDialect);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code MARIADB}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link MariaDbDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'MARIADB'; then dialect return MariaDbDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenMariadb_thenDialectReturnMariaDbDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MARIADB).dialect
            instanceof MariaDbDialect);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code MYSQL}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link MySqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'MYSQL'; then dialect return MySqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenMysql_thenDialectReturnMySqlDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MYSQL).dialect instanceof MySqlDialect);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code ORACLE}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link OracleDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'ORACLE'; then dialect return OracleDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenOracle_thenDialectReturnOracleDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.ORACLE).dialect
            instanceof OracleDialect);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code POSTGRESQL}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link PostgreSqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'POSTGRESQL'; then dialect return PostgreSqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenPostgresql_thenDialectReturnPostgreSqlDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.POSTGRESQL).dialect
            instanceof PostgreSqlDialect);
  }

  /**
   * Test {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code SQLSERVER}.
   *   <li>Then {@link JdbcBaseDal#dialect} return {@link SqlServerDialect}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)}
   */
  @Test
  @DisplayName(
      "Test new JdbcBaseDal(DataSource, JdbcDialect); when 'SQLSERVER'; then dialect return SqlServerDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.<init>(DataSource, JdbcDialect)"})
  void testNewJdbcBaseDal_whenSqlserver_thenDialectReturnSqlServerDialect() {
    // Arrange, Act and Assert
    assertTrue(
        new JdbcBaseDal(mock(DataSource.class), JdbcDialect.SQLSERVER).dialect
            instanceof SqlServerDialect);
  }

  /**
   * Test {@link JdbcBaseDal#prepareMappingTable(Connection)}.
   *
   * <p>Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.prepareMappingTable(Connection)"})
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.POSTGRESQL);

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement)
        .execute(
            "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;");
  }

  /**
   * Test {@link JdbcBaseDal#prepareMappingTable(Connection)}.
   *
   * <p>Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.prepareMappingTable(Connection)"})
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.SQLSERVER);

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link JdbcBaseDal#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)} with source is {@link
   *       DataSource} and dialect is {@code H2}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given JdbcBaseDal(DataSource, JdbcDialect) with source is DataSource and dialect is 'H2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenJdbcBaseDalWithSourceIsDataSourceAndDialectIsH2()
      throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.H2);

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link JdbcBaseDal#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link JdbcBaseDal#JdbcBaseDal(DataSource, JdbcDialect)} with source is {@link
   *       DataSource} and dialect is {@code MYSQL}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given JdbcBaseDal(DataSource, JdbcDialect) with source is DataSource and dialect is 'MYSQL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenJdbcBaseDalWithSourceIsDataSourceAndDialectIsMysql()
      throws SQLException {
    // Arrange
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(mock(DataSource.class), JdbcDialect.MYSQL);

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    jdbcBaseDal.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link JdbcBaseDal#executeDirect(JdbcAction)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#close()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>When {@link JdbcAction}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#executeDirect(JdbcAction)}
   */
  @Test
  @DisplayName(
      "Test executeDirect(JdbcAction); given Connection close() throw SQLException(); when JdbcAction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.executeDirect(JdbcAction)"})
  void testExecuteDirect_givenConnectionCloseThrowSQLException_whenJdbcAction()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doThrow(new SQLException()).when(connection).close();
    doThrow(new SQLException()).when(connection).setAutoCommit(anyBoolean());

    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> new JdbcBaseDal(source, JdbcDialect.H2).executeDirect(mock(JdbcAction.class)));
    verify(connection).close();
    verify(connection).setAutoCommit(false);
    verify(source).getConnection();
  }

  /**
   * Test {@link JdbcBaseDal#executeDirect(JdbcAction)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#executeDirect(JdbcAction)}
   */
  @Test
  @DisplayName(
      "Test executeDirect(JdbcAction); given Connection commit() does nothing; then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.executeDirect(JdbcAction)"})
  void testExecuteDirect_givenConnectionCommitDoesNothing_thenCallsCommit() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());

    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);

    JdbcAction func = mock(JdbcAction.class);
    doNothing().when(func).apply(Mockito.<Connection>any());

    // Act
    jdbcBaseDal.executeDirect(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(false);
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Test {@link JdbcBaseDal#executeDirect(JdbcAction)}.
   *
   * <ul>
   *   <li>Given {@link DataSource} {@link DataSource#getConnection()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>When {@link JdbcAction}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#executeDirect(JdbcAction)}
   */
  @Test
  @DisplayName(
      "Test executeDirect(JdbcAction); given DataSource getConnection() throw SQLException(); when JdbcAction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.executeDirect(JdbcAction)"})
  void testExecuteDirect_givenDataSourceGetConnectionThrowSQLException_whenJdbcAction()
      throws SQLException {
    // Arrange
    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> new JdbcBaseDal(source, JdbcDialect.H2).executeDirect(mock(JdbcAction.class)));
    verify(source).getConnection();
  }

  /**
   * Test {@link JdbcBaseDal#executeDirect(JdbcAction)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   *   <li>When {@link JdbcAction} {@link JdbcAction#apply(Connection)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#executeDirect(JdbcAction)}
   */
  @Test
  @DisplayName(
      "Test executeDirect(JdbcAction); given SQLException(); when JdbcAction apply(Connection) throw SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.executeDirect(JdbcAction)"})
  void testExecuteDirect_givenSQLException_whenJdbcActionApplyThrowSQLException()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());

    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);

    JdbcAction func = mock(JdbcAction.class);
    doThrow(new SQLException()).when(func).apply(Mockito.<Connection>any());

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcBaseDal.executeDirect(func));
    verify(connection).close();
    verify(connection).setAutoCommit(false);
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Test {@link JdbcBaseDal#wrapTransaction(JdbcAction)} with {@code JdbcAction}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#close()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#wrapTransaction(JdbcAction)}
   */
  @Test
  @DisplayName("Test wrapTransaction(JdbcAction) with 'JdbcAction'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcBaseDal.wrapTransaction(JdbcAction)"})
  void testWrapTransactionWithJdbcAction_thenCallsClose() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());

    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);

    JdbcAction func = mock(JdbcAction.class);
    doNothing().when(func).apply(Mockito.<Connection>any());

    // Act
    jdbcBaseDal.wrapTransaction(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(false);
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
  }

  /**
   * Test {@link JdbcBaseDal#wrapTransaction(JdbcFunction)} with {@code JdbcFunction}.
   *
   * <ul>
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcBaseDal#wrapTransaction(JdbcFunction)}
   */
  @Test
  @DisplayName("Test wrapTransaction(JdbcFunction) with 'JdbcFunction'; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JdbcBaseDal.wrapTransaction(JdbcFunction)"})
  void testWrapTransactionWithJdbcFunction_thenReturnApply() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());

    DataSource source = mock(DataSource.class);
    when(source.getConnection()).thenReturn(connection);
    JdbcBaseDal jdbcBaseDal = new JdbcBaseDal(source, JdbcDialect.H2);

    JdbcFunction<Object> func = mock(JdbcFunction.class);
    when(func.apply(Mockito.<Connection>any())).thenReturn("Apply");

    // Act
    Object actualWrapTransactionResult = jdbcBaseDal.wrapTransaction(func);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).setAutoCommit(false);
    verify(source).getConnection();
    verify(func).apply(isA(Connection.class));
    assertEquals("Apply", actualWrapTransactionResult);
  }
}

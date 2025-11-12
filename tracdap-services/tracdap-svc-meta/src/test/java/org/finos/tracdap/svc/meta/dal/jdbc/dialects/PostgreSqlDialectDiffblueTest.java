package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.Statement;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PostgreSqlDialectDiffblueTest {
  /**
   * Test {@link PostgreSqlDialect#PostgreSqlDialect()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PostgreSqlDialect}
   */
  @Test
  @DisplayName("Test new PostgreSqlDialect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostgreSqlDialect.<init>()"})
  void testNewPostgreSqlDialect() {
    // Arrange and Act
    PostgreSqlDialect actualPostgreSqlDialect = new PostgreSqlDialect();

    // Assert
    assertEquals("key_mapping", actualPostgreSqlDialect.mappingTableName());
    assertEquals(JdbcDialect.POSTGRESQL, actualPostgreSqlDialect.dialectCode());
    assertTrue(actualPostgreSqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualPostgreSqlDialect.booleanType());
  }

  /**
   * Test {@link PostgreSqlDialect#dialectCode()}.
   *
   * <p>Method under test: {@link PostgreSqlDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcDialect PostgreSqlDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.POSTGRESQL, new PostgreSqlDialect().dialectCode());
  }

  /**
   * Test {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}.
   *
   * <p>Method under test: {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName("Test mapDialectErrorCode(SQLException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode PostgreSqlDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode() {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();
    DataTruncation error = new DataTruncation(1, true, true, 3, 3);

    // Act
    JdbcErrorCode actualMapDialectErrorCodeResult = postgreSqlDialect.mapDialectErrorCode(error);

    // Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, actualMapDialectErrorCodeResult);
  }

  /**
   * Test {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}.
   *
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName(
      "Test mapDialectErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode PostgreSqlDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    // Act and Assert
    assertEquals(
        JdbcErrorCode.UNKNOWN_ERROR_CODE,
        postgreSqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Test {@link PostgreSqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostgreSqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenSQLException() throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> postgreSqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Test {@link PostgreSqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) return 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostgreSqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteReturnTrue_thenCallsClose()
      throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    postgreSqlDialect.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement)
        .execute(
            "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;");
  }

  /**
   * Test {@link PostgreSqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) throw SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostgreSqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteThrowSQLException() throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new SQLException());
    doThrow(new SQLException()).when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(SQLException.class, () -> postgreSqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement)
        .execute(
            "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;");
  }

  /**
   * Test {@link PostgreSqlDialect#mappingTableName()}.
   *
   * <p>Method under test: {@link PostgreSqlDialect#mappingTableName()}
   */
  @Test
  @DisplayName("Test mappingTableName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PostgreSqlDialect.mappingTableName()"})
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", new PostgreSqlDialect().mappingTableName());
  }

  /**
   * Test {@link PostgreSqlDialect#supportsGeneratedKeys()}.
   *
   * <p>Method under test: {@link PostgreSqlDialect#supportsGeneratedKeys()}
   */
  @Test
  @DisplayName("Test supportsGeneratedKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PostgreSqlDialect.supportsGeneratedKeys()"})
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue(new PostgreSqlDialect().supportsGeneratedKeys());
  }

  /**
   * Test {@link PostgreSqlDialect#booleanType()}.
   *
   * <p>Method under test: {@link PostgreSqlDialect#booleanType()}
   */
  @Test
  @DisplayName("Test booleanType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PostgreSqlDialect.booleanType()"})
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, new PostgreSqlDialect().booleanType());
  }
}

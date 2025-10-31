package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.Statement;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PostgreSqlDialectDiffblueTest {
  /**
   * Method under test: {@link PostgreSqlDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.POSTGRESQL, (new PostgreSqlDialect()).dialectCode());
  }

  /**
   * Method under test:
   * {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode() {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, postgreSqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Method under test:
   * {@link PostgreSqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode2() {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE,
        postgreSqlDialect.mapDialectErrorCode(new DataTruncation(1, true, true, 3, 3)));
  }

  /**
   * Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    postgreSqlDialect.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq(
        "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;"));
  }

  /**
   * Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new NumberFormatException("foo"));
    doThrow(new NumberFormatException("foo")).when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> postgreSqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq(
        "-- Licensed to the Fintech Open Source Foundation (FINOS) under one or\n-- more contributor license agreements. See the NOTICE file distributed\n-- with this work for additional information regarding copyright ownership.\n-- FINOS licenses this file to you under the Apache License, Version 2.0\n-- (the \"License\"); you may not use this file except in compliance with the\n-- License. You may obtain a copy of the License at\n--\n--      http://www.apache.org/licenses/LICENSE-2.0\n--\n--  Unless required by applicable law or agreed to in writing, software\n--  distributed under the License is distributed on an \"AS IS\" BASIS,\n--  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n--  See the License for the specific language governing permissions and\n--  limitations under the License.\n\n\ncreate temporary table key_mapping (\n\n    pk bigint,\n\n    id_hi bigint,\n    id_lo bigint,\n\n    fk bigint,\n    ver int,\n    as_of timestamp (6),\n    is_latest boolean,\n\n    mapping_stage int,\n    ordering int\n)\non commit drop;"));
  }

  /**
   * Method under test: {@link PostgreSqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable3() throws SQLException {
    // Arrange
    PostgreSqlDialect postgreSqlDialect = new PostgreSqlDialect();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> postgreSqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Method under test: {@link PostgreSqlDialect#mappingTableName()}
   */
  @Test
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new PostgreSqlDialect()).mappingTableName());
  }

  /**
   * Method under test: {@link PostgreSqlDialect#supportsGeneratedKeys()}
   */
  @Test
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new PostgreSqlDialect()).supportsGeneratedKeys());
  }

  /**
   * Method under test: {@link PostgreSqlDialect#booleanType()}
   */
  @Test
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, (new PostgreSqlDialect()).booleanType());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PostgreSqlDialect}
   */
  @Test
  void testNewPostgreSqlDialect() {
    // Arrange and Act
    PostgreSqlDialect actualPostgreSqlDialect = new PostgreSqlDialect();

    // Assert
    assertEquals("key_mapping", actualPostgreSqlDialect.mappingTableName());
    assertEquals(JdbcDialect.POSTGRESQL, actualPostgreSqlDialect.dialectCode());
    assertTrue(actualPostgreSqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualPostgreSqlDialect.booleanType());
  }
}

package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerDialectDiffblueTest {
  /**
   * Method under test: {@link SqlServerDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.SQLSERVER, (new SqlServerDialect()).dialectCode());
  }

  /**
   * Method under test: {@link SqlServerDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode() {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, sqlServerDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    sqlServerDialect.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new SQLException());
    doThrow(new SQLException()).when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(SQLException.class, () -> sqlServerDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq("drop table if exists #key_mapping;"));
  }

  /**
   * Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable3() throws SQLException {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sqlServerDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Method under test: {@link SqlServerDialect#mappingTableName()}
   */
  @Test
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("#key_mapping", (new SqlServerDialect()).mappingTableName());
  }

  /**
   * Method under test: {@link SqlServerDialect#supportsGeneratedKeys()}
   */
  @Test
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertFalse((new SqlServerDialect()).supportsGeneratedKeys());
  }

  /**
   * Method under test: {@link SqlServerDialect#booleanType()}
   */
  @Test
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, (new SqlServerDialect()).booleanType());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SqlServerDialect}
   */
  @Test
  void testNewSqlServerDialect() {
    // Arrange and Act
    SqlServerDialect actualSqlServerDialect = new SqlServerDialect();

    // Assert
    assertEquals("#key_mapping", actualSqlServerDialect.mappingTableName());
    assertEquals(JdbcDialect.SQLSERVER, actualSqlServerDialect.dialectCode());
    assertFalse(actualSqlServerDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualSqlServerDialect.booleanType());
  }
}

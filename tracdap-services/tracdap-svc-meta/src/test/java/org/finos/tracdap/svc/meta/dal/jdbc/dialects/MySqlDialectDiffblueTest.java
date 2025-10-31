package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class MySqlDialectDiffblueTest {
  /**
   * Method under test: {@link MySqlDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.MYSQL, (new MySqlDialect()).dialectCode());
  }

  /**
   * Method under test: {@link MySqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode() {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, mySqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    mySqlDialect.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new SQLException());
    doThrow(new SQLException()).when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(SQLException.class, () -> mySqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq("drop temporary table if exists key_mapping;"));
  }

  /**
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable3() throws SQLException {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> mySqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Method under test: {@link MySqlDialect#mappingTableName()}
   */
  @Test
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new MySqlDialect()).mappingTableName());
  }

  /**
   * Method under test: {@link MySqlDialect#supportsGeneratedKeys()}
   */
  @Test
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new MySqlDialect()).supportsGeneratedKeys());
  }

  /**
   * Method under test: {@link MySqlDialect#booleanType()}
   */
  @Test
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, (new MySqlDialect()).booleanType());
  }

  /**
   * Method under test: {@link MySqlDialect#MySqlDialect()}
   */
  @Test
  void testNewMySqlDialect() {
    // Arrange and Act
    MySqlDialect actualMySqlDialect = new MySqlDialect();

    // Assert
    assertEquals("key_mapping", actualMySqlDialect.mappingTableName());
    assertEquals(JdbcDialect.MYSQL, actualMySqlDialect.dialectCode());
    assertTrue(actualMySqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualMySqlDialect.booleanType());
  }

  /**
   * Method under test: {@link MySqlDialect#MySqlDialect(String)}
   */
  @Test
  void testNewMySqlDialect2() {
    // Arrange and Act
    MySqlDialect actualMySqlDialect = new MySqlDialect("jdbc/mysql/key_mapping.ddl");

    // Assert
    assertEquals("key_mapping", actualMySqlDialect.mappingTableName());
    assertEquals(JdbcDialect.MYSQL, actualMySqlDialect.dialectCode());
    assertTrue(actualMySqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualMySqlDialect.booleanType());
  }
}

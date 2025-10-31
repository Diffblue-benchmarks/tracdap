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

class H2SqlDialectDiffblueTest {
  /**
   * Method under test: {@link H2SqlDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.H2, (new H2SqlDialect()).dialectCode());
  }

  /**
   * Method under test: {@link H2SqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, h2SqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable() throws SQLException {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    h2SqlDialect.prepareMappingTable(conn);

    // Assert that nothing has changed
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable2() throws SQLException {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new SQLException());
    doThrow(new SQLException()).when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(SQLException.class, () -> h2SqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement).execute(eq("drop table if exists key_mapping;"));
  }

  /**
   * Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  void testPrepareMappingTable3() throws SQLException {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> h2SqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Method under test: {@link H2SqlDialect#mappingTableName()}
   */
  @Test
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new H2SqlDialect()).mappingTableName());
  }

  /**
   * Method under test: {@link H2SqlDialect#supportsGeneratedKeys()}
   */
  @Test
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new H2SqlDialect()).supportsGeneratedKeys());
  }

  /**
   * Method under test: {@link H2SqlDialect#booleanType()}
   */
  @Test
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, (new H2SqlDialect()).booleanType());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link H2SqlDialect}
   */
  @Test
  void testNewH2SqlDialect() {
    // Arrange and Act
    H2SqlDialect actualH2SqlDialect = new H2SqlDialect();

    // Assert
    assertEquals("key_mapping", actualH2SqlDialect.mappingTableName());
    assertEquals(JdbcDialect.H2, actualH2SqlDialect.dialectCode());
    assertTrue(actualH2SqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualH2SqlDialect.booleanType());
  }
}

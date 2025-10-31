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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MySqlDialectDiffblueTest {
  /**
   * Test {@link MySqlDialect#MySqlDialect()}.
   * <p>
   * Method under test: {@link MySqlDialect#MySqlDialect()}
   */
  @Test
  @DisplayName("Test new MySqlDialect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MySqlDialect.<init>()"})
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
   * Test {@link MySqlDialect#MySqlDialect(String)}.
   * <ul>
   *   <li>Then return mappingTableName is {@code key_mapping}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MySqlDialect#MySqlDialect(String)}
   */
  @Test
  @DisplayName("Test new MySqlDialect(String); then return mappingTableName is 'key_mapping'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MySqlDialect.<init>(String)"})
  void testNewMySqlDialect_thenReturnMappingTableNameIsKeyMapping() {
    // Arrange and Act
    MySqlDialect actualMySqlDialect = new MySqlDialect("jdbc/mysql/key_mapping.ddl");

    // Assert
    assertEquals("key_mapping", actualMySqlDialect.mappingTableName());
    assertEquals(JdbcDialect.MYSQL, actualMySqlDialect.dialectCode());
    assertTrue(actualMySqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualMySqlDialect.booleanType());
  }

  /**
   * Test {@link MySqlDialect#dialectCode()}.
   * <p>
   * Method under test: {@link MySqlDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcDialect MySqlDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.MYSQL, (new MySqlDialect()).dialectCode());
  }

  /**
   * Test {@link MySqlDialect#mapDialectErrorCode(SQLException)}.
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.</li>
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MySqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName("Test mapDialectErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcErrorCode MySqlDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, mySqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Test {@link MySqlDialect#prepareMappingTable(Connection)}.
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MySqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenSQLException() throws SQLException {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> mySqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Test {@link MySqlDialect#prepareMappingTable(Connection)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.</li>
   *   <li>Then calls {@link Statement#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given Statement execute(String) return 'true'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MySqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteReturnTrue_thenCallsClose() throws SQLException {
    // Arrange
    MySqlDialect mySqlDialect = new MySqlDialect();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    mySqlDialect.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link MySqlDialect#prepareMappingTable(Connection)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} throw {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MySqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given Statement execute(String) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MySqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteThrowSQLException() throws SQLException {
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
   * Test {@link MySqlDialect#mappingTableName()}.
   * <p>
   * Method under test: {@link MySqlDialect#mappingTableName()}
   */
  @Test
  @DisplayName("Test mappingTableName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MySqlDialect.mappingTableName()"})
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new MySqlDialect()).mappingTableName());
  }

  /**
   * Test {@link MySqlDialect#supportsGeneratedKeys()}.
   * <p>
   * Method under test: {@link MySqlDialect#supportsGeneratedKeys()}
   */
  @Test
  @DisplayName("Test supportsGeneratedKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MySqlDialect.supportsGeneratedKeys()"})
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new MySqlDialect()).supportsGeneratedKeys());
  }

  /**
   * Test {@link MySqlDialect#booleanType()}.
   * <p>
   * Method under test: {@link MySqlDialect#booleanType()}
   */
  @Test
  @DisplayName("Test booleanType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MySqlDialect.booleanType()"})
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, (new MySqlDialect()).booleanType());
  }
}

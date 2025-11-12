package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerDialectDiffblueTest {
  /**
   * Test {@link SqlServerDialect#SqlServerDialect()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link SqlServerDialect}
   */
  @Test
  @DisplayName("Test new SqlServerDialect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlServerDialect.<init>()"})
  void testNewSqlServerDialect() {
    // Arrange and Act
    SqlServerDialect actualSqlServerDialect = new SqlServerDialect();

    // Assert
    assertEquals("#key_mapping", actualSqlServerDialect.mappingTableName());
    assertEquals(JdbcDialect.SQLSERVER, actualSqlServerDialect.dialectCode());
    assertFalse(actualSqlServerDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualSqlServerDialect.booleanType());
  }

  /**
   * Test {@link SqlServerDialect#dialectCode()}.
   *
   * <p>Method under test: {@link SqlServerDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcDialect SqlServerDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.SQLSERVER, new SqlServerDialect().dialectCode());
  }

  /**
   * Test {@link SqlServerDialect#mapDialectErrorCode(SQLException)}.
   *
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName(
      "Test mapDialectErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode SqlServerDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();

    // Act and Assert
    assertEquals(
        JdbcErrorCode.UNKNOWN_ERROR_CODE, sqlServerDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Test {@link SqlServerDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlServerDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenSQLException() throws SQLException {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sqlServerDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Test {@link SqlServerDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) return 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlServerDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteReturnTrue_thenCallsClose()
      throws SQLException {
    // Arrange
    SqlServerDialect sqlServerDialect = new SqlServerDialect();

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    sqlServerDialect.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link SqlServerDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) throw SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlServerDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteThrowSQLException() throws SQLException {
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
    verify(statement).execute("drop table if exists #key_mapping;");
  }

  /**
   * Test {@link SqlServerDialect#mappingTableName()}.
   *
   * <p>Method under test: {@link SqlServerDialect#mappingTableName()}
   */
  @Test
  @DisplayName("Test mappingTableName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SqlServerDialect.mappingTableName()"})
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("#key_mapping", new SqlServerDialect().mappingTableName());
  }

  /**
   * Test {@link SqlServerDialect#supportsGeneratedKeys()}.
   *
   * <p>Method under test: {@link SqlServerDialect#supportsGeneratedKeys()}
   */
  @Test
  @DisplayName("Test supportsGeneratedKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SqlServerDialect.supportsGeneratedKeys()"})
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertFalse(new SqlServerDialect().supportsGeneratedKeys());
  }

  /**
   * Test {@link SqlServerDialect#booleanType()}.
   *
   * <p>Method under test: {@link SqlServerDialect#booleanType()}
   */
  @Test
  @DisplayName("Test booleanType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SqlServerDialect.booleanType()"})
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, new SqlServerDialect().booleanType());
  }
}

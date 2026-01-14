package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class H2SqlDialectDiffblueTest {
  /**
   * Test {@link H2SqlDialect#H2SqlDialect()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link H2SqlDialect}
   */
  @Test
  @DisplayName("Test new H2SqlDialect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void H2SqlDialect.<init>()"})
  void testNewH2SqlDialect() {
    // Arrange and Act
    H2SqlDialect actualH2SqlDialect = new H2SqlDialect();

    // Assert
    assertEquals("key_mapping", actualH2SqlDialect.mappingTableName());
    assertEquals(JdbcDialect.H2, actualH2SqlDialect.dialectCode());
    assertTrue(actualH2SqlDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualH2SqlDialect.booleanType());
  }

  /**
   * Test {@link H2SqlDialect#dialectCode()}.
   *
   * <p>Method under test: {@link H2SqlDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcDialect H2SqlDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.H2, new H2SqlDialect().dialectCode());
  }

  /**
   * Test {@link H2SqlDialect#mapDialectErrorCode(SQLException)}.
   *
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link H2SqlDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName(
      "Test mapDialectErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode H2SqlDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act and Assert
    assertEquals(
        JdbcErrorCode.UNKNOWN_ERROR_CODE, h2SqlDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Test {@link H2SqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName("Test prepareMappingTable(Connection); given SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void H2SqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenSQLException() throws SQLException {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> h2SqlDialect.prepareMappingTable(conn));
    verify(conn).createStatement();
  }

  /**
   * Test {@link H2SqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} return {@code true}.
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) return 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void H2SqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteReturnTrue_thenCallsClose()
      throws SQLException {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    doNothing().when(statement).close();

    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    h2SqlDialect.prepareMappingTable(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
  }

  /**
   * Test {@link H2SqlDialect#prepareMappingTable(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link H2SqlDialect#prepareMappingTable(Connection)}
   */
  @Test
  @DisplayName(
      "Test prepareMappingTable(Connection); given Statement execute(String) throw SQLException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void H2SqlDialect.prepareMappingTable(Connection)"})
  void testPrepareMappingTable_givenStatementExecuteThrowSQLException() throws SQLException {
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
    verify(statement).execute("drop table if exists key_mapping;");
  }

  /**
   * Test {@link H2SqlDialect#mappingTableName()}.
   *
   * <p>Method under test: {@link H2SqlDialect#mappingTableName()}
   */
  @Test
  @DisplayName("Test mappingTableName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String H2SqlDialect.mappingTableName()"})
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", new H2SqlDialect().mappingTableName());
  }

  /**
   * Test {@link H2SqlDialect#supportsGeneratedKeys()}.
   *
   * <p>Method under test: {@link H2SqlDialect#supportsGeneratedKeys()}
   */
  @Test
  @DisplayName("Test supportsGeneratedKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean H2SqlDialect.supportsGeneratedKeys()"})
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue(new H2SqlDialect().supportsGeneratedKeys());
  }

  /**
   * Test {@link H2SqlDialect#booleanType()}.
   *
   * <p>Method under test: {@link H2SqlDialect#booleanType()}
   */
  @Test
  @DisplayName("Test booleanType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int H2SqlDialect.booleanType()"})
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, new H2SqlDialect().booleanType());
  }
}

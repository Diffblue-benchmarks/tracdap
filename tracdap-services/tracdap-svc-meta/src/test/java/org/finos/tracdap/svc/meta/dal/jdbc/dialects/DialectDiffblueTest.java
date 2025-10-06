package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DialectDiffblueTest {
  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code H2}.
   *   <li>Then return {@link H2SqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'H2'; then return H2SqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenH2_thenReturnH2SqlDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.H2);

    // Assert
    assertTrue(actualDialectForResult instanceof H2SqlDialect);
    assertEquals("key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(JdbcDialect.H2, actualDialectForResult.dialectCode());
    assertTrue(actualDialectForResult.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualDialectForResult.booleanType());
  }

  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code MARIADB}.
   *   <li>Then return {@link MariaDbDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'MARIADB'; then return MariaDbDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenMariadb_thenReturnMariaDbDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.MARIADB);

    // Assert
    assertTrue(actualDialectForResult instanceof MariaDbDialect);
    assertEquals("key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(JdbcDialect.MARIADB, actualDialectForResult.dialectCode());
    assertTrue(actualDialectForResult.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualDialectForResult.booleanType());
  }

  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code MYSQL}.
   *   <li>Then return {@link MySqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'MYSQL'; then return MySqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenMysql_thenReturnMySqlDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.MYSQL);

    // Assert
    assertTrue(actualDialectForResult instanceof MySqlDialect);
    assertEquals("key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(JdbcDialect.MYSQL, actualDialectForResult.dialectCode());
    assertTrue(actualDialectForResult.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualDialectForResult.booleanType());
  }

  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code ORACLE}.
   *   <li>Then return {@link OracleDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'ORACLE'; then return OracleDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenOracle_thenReturnOracleDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.ORACLE);

    // Assert
    assertTrue(actualDialectForResult instanceof OracleDialect);
    assertEquals("key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(2, actualDialectForResult.booleanType());
    assertEquals(JdbcDialect.ORACLE, actualDialectForResult.dialectCode());
    assertTrue(actualDialectForResult.supportsGeneratedKeys());
  }

  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code POSTGRESQL}.
   *   <li>Then return {@link PostgreSqlDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'POSTGRESQL'; then return PostgreSqlDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenPostgresql_thenReturnPostgreSqlDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.POSTGRESQL);

    // Assert
    assertTrue(actualDialectForResult instanceof PostgreSqlDialect);
    assertEquals("key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(JdbcDialect.POSTGRESQL, actualDialectForResult.dialectCode());
    assertTrue(actualDialectForResult.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualDialectForResult.booleanType());
  }

  /**
   * Test {@link Dialect#dialectFor(JdbcDialect)}.
   *
   * <ul>
   *   <li>When {@code SQLSERVER}.
   *   <li>Then return {@link SqlServerDialect}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  @DisplayName("Test dialectFor(JdbcDialect); when 'SQLSERVER'; then return SqlServerDialect")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IDialect Dialect.dialectFor(JdbcDialect)"})
  void testDialectFor_whenSqlserver_thenReturnSqlServerDialect() {
    // Arrange and Act
    IDialect actualDialectForResult = Dialect.dialectFor(JdbcDialect.SQLSERVER);

    // Assert
    assertTrue(actualDialectForResult instanceof SqlServerDialect);
    assertEquals("#key_mapping", actualDialectForResult.mappingTableName());
    assertEquals(JdbcDialect.SQLSERVER, actualDialectForResult.dialectCode());
    assertFalse(actualDialectForResult.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualDialectForResult.booleanType());
  }

  /**
   * Test {@link Dialect#mapErrorCode(SQLException)}.
   *
   * <p>Method under test: {@link Dialect#mapErrorCode(SQLException)}
   */
  @Test
  @DisplayName("Test mapErrorCode(SQLException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode Dialect.mapErrorCode(SQLException)"})
  void testMapErrorCode() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act
    JdbcErrorCode actualMapErrorCodeResult =
        h2SqlDialect.mapErrorCode(new SQLException("Just cause", "SYNTHETIC_ERROR"));

    // Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, actualMapErrorCodeResult);
  }

  /**
   * Test {@link Dialect#mapErrorCode(SQLException)}.
   *
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#mapErrorCode(SQLException)}
   */
  @Test
  @DisplayName(
      "Test mapErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcErrorCode Dialect.mapErrorCode(SQLException)"})
  void testMapErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, h2SqlDialect.mapErrorCode(new SQLException()));
  }

  /**
   * Test {@link Dialect#loadKeyMappingDdl(String)}.
   *
   * <ul>
   *   <li>When {@code Key Mapping Ddl}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link Dialect#loadKeyMappingDdl(String)}
   */
  @Test
  @DisplayName("Test loadKeyMappingDdl(String); when 'Key Mapping Ddl'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Dialect.loadKeyMappingDdl(String)"})
  void testLoadKeyMappingDdl_whenKeyMappingDdl_thenThrowETracInternal() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class, () -> new H2SqlDialect().loadKeyMappingDdl("Key Mapping Ddl"));
  }
}

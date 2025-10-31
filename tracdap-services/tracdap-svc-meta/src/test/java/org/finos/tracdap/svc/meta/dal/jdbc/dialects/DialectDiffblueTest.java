package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.Test;

class DialectDiffblueTest {
  /**
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor() {
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
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor2() {
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
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor3() {
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
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor4() {
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
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor5() {
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
   * Method under test: {@link Dialect#dialectFor(JdbcDialect)}
   */
  @Test
  void testDialectFor6() {
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
   * Method under test: {@link Dialect#mapErrorCode(SQLException)}
   */
  @Test
  void testMapErrorCode() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, h2SqlDialect.mapErrorCode(new SQLException()));
  }

  /**
   * Method under test: {@link Dialect#mapErrorCode(SQLException)}
   */
  @Test
  void testMapErrorCode2() {
    // Arrange
    H2SqlDialect h2SqlDialect = new H2SqlDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE,
        h2SqlDialect.mapErrorCode(new SQLException("Just cause", "SYNTHETIC_ERROR")));
  }

  /**
   * Method under test: {@link Dialect#loadKeyMappingDdl(String)}
   */
  @Test
  void testLoadKeyMappingDdl() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> (new H2SqlDialect()).loadKeyMappingDdl("Key Mapping Ddl"));
  }
}

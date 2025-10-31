package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.Test;

class OracleDialectDiffblueTest {
  /**
   * Method under test: {@link OracleDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.ORACLE, (new OracleDialect()).dialectCode());
  }

  /**
   * Method under test: {@link OracleDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  void testMapDialectErrorCode() {
    // Arrange
    OracleDialect oracleDialect = new OracleDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, oracleDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Method under test: {@link OracleDialect#mappingTableName()}
   */
  @Test
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new OracleDialect()).mappingTableName());
  }

  /**
   * Method under test: {@link OracleDialect#supportsGeneratedKeys()}
   */
  @Test
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new OracleDialect()).supportsGeneratedKeys());
  }

  /**
   * Method under test: {@link OracleDialect#booleanType()}
   */
  @Test
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(2, (new OracleDialect()).booleanType());
  }
}

package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OracleDialectDiffblueTest {
  /**
   * Test {@link OracleDialect#dialectCode()}.
   * <p>
   * Method under test: {@link OracleDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcDialect OracleDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.ORACLE, (new OracleDialect()).dialectCode());
  }

  /**
   * Test {@link OracleDialect#mapDialectErrorCode(SQLException)}.
   * <ul>
   *   <li>When {@link SQLException#SQLException()}.</li>
   *   <li>Then return {@code UNKNOWN_ERROR_CODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OracleDialect#mapDialectErrorCode(SQLException)}
   */
  @Test
  @DisplayName("Test mapDialectErrorCode(SQLException); when SQLException(); then return 'UNKNOWN_ERROR_CODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcErrorCode OracleDialect.mapDialectErrorCode(SQLException)"})
  void testMapDialectErrorCode_whenSQLException_thenReturnUnknownErrorCode() {
    // Arrange
    OracleDialect oracleDialect = new OracleDialect();

    // Act and Assert
    assertEquals(JdbcErrorCode.UNKNOWN_ERROR_CODE, oracleDialect.mapDialectErrorCode(new SQLException()));
  }

  /**
   * Test {@link OracleDialect#mappingTableName()}.
   * <p>
   * Method under test: {@link OracleDialect#mappingTableName()}
   */
  @Test
  @DisplayName("Test mappingTableName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String OracleDialect.mappingTableName()"})
  void testMappingTableName() {
    // Arrange, Act and Assert
    assertEquals("key_mapping", (new OracleDialect()).mappingTableName());
  }

  /**
   * Test {@link OracleDialect#supportsGeneratedKeys()}.
   * <p>
   * Method under test: {@link OracleDialect#supportsGeneratedKeys()}
   */
  @Test
  @DisplayName("Test supportsGeneratedKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OracleDialect.supportsGeneratedKeys()"})
  void testSupportsGeneratedKeys() {
    // Arrange, Act and Assert
    assertTrue((new OracleDialect()).supportsGeneratedKeys());
  }

  /**
   * Test {@link OracleDialect#booleanType()}.
   * <p>
   * Method under test: {@link OracleDialect#booleanType()}
   */
  @Test
  @DisplayName("Test booleanType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OracleDialect.booleanType()"})
  void testBooleanType() {
    // Arrange, Act and Assert
    assertEquals(2, (new OracleDialect()).booleanType());
  }
}

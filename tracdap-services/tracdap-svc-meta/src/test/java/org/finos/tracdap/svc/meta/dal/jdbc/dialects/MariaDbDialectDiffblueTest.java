package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.common.db.JdbcDialect;
import org.junit.jupiter.api.Test;

class MariaDbDialectDiffblueTest {
  /**
   * Method under test: {@link MariaDbDialect#dialectCode()}
   */
  @Test
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.MARIADB, (new MariaDbDialect()).dialectCode());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MariaDbDialect}
   */
  @Test
  void testNewMariaDbDialect() {
    // Arrange and Act
    MariaDbDialect actualMariaDbDialect = new MariaDbDialect();

    // Assert
    assertEquals("key_mapping", actualMariaDbDialect.mappingTableName());
    assertEquals(JdbcDialect.MARIADB, actualMariaDbDialect.dialectCode());
    assertTrue(actualMariaDbDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualMariaDbDialect.booleanType());
  }
}

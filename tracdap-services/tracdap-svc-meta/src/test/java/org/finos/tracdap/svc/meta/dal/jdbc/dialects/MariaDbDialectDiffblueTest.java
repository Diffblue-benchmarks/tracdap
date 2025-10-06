package org.finos.tracdap.svc.meta.dal.jdbc.dialects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.db.JdbcDialect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MariaDbDialectDiffblueTest {
  /**
   * Test {@link MariaDbDialect#MariaDbDialect()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link MariaDbDialect}
   */
  @Test
  @DisplayName("Test new MariaDbDialect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MariaDbDialect.<init>()"})
  void testNewMariaDbDialect() {
    // Arrange and Act
    MariaDbDialect actualMariaDbDialect = new MariaDbDialect();

    // Assert
    assertEquals("key_mapping", actualMariaDbDialect.mappingTableName());
    assertEquals(JdbcDialect.MARIADB, actualMariaDbDialect.dialectCode());
    assertTrue(actualMariaDbDialect.supportsGeneratedKeys());
    assertEquals(Short.SIZE, actualMariaDbDialect.booleanType());
  }

  /**
   * Test {@link MariaDbDialect#dialectCode()}.
   *
   * <p>Method under test: {@link MariaDbDialect#dialectCode()}
   */
  @Test
  @DisplayName("Test dialectCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcDialect MariaDbDialect.dialectCode()"})
  void testDialectCode() {
    // Arrange, Act and Assert
    assertEquals(JdbcDialect.MARIADB, new MariaDbDialect().dialectCode());
  }
}

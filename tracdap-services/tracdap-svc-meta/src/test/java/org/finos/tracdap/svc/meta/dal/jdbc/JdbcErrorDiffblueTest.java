package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.IDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JdbcErrorDiffblueTest {
  /**
   * Test {@link JdbcError#catchAll(SQLException, IDialect)}.
   *
   * <p>Method under test: {@link JdbcError#catchAll(SQLException, IDialect)}
   */
  @Test
  @DisplayName("Test catchAll(SQLException, IDialect)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ETracInternal JdbcError.catchAll(SQLException, IDialect)"})
  void testCatchAll() {
    // Arrange
    SQLException error = new SQLException();

    // Act
    ETracInternal actualCatchAllResult = JdbcError.catchAll(error, new OracleDialect());

    // Assert
    assertEquals(
        "Unrecognised SQL Error code: ORACLE, sqlstate = null, error code = 0",
        actualCatchAllResult.getLocalizedMessage());
    assertEquals(
        "Unrecognised SQL Error code: ORACLE, sqlstate = null, error code = 0",
        actualCatchAllResult.getMessage());
    assertEquals(0, actualCatchAllResult.getSuppressed().length);
    assertSame(error, actualCatchAllResult.getCause());
  }
}

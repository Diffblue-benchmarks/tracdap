package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JdbcExceptionDiffblueTest {
  /**
   * Test {@link JdbcException#JdbcException(JdbcErrorCode)}.
   *
   * <p>Method under test: {@link JdbcException#JdbcException(JdbcErrorCode)}
   */
  @Test
  @DisplayName("Test new JdbcException(JdbcErrorCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcException.<init>(JdbcErrorCode)"})
  void testNewJdbcException() {
    // Arrange and Act
    JdbcException actualJdbcException = new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Assert
    assertNull(actualJdbcException.getCause());
    assertEquals(0, actualJdbcException.getErrorCode());
    assertEquals("UNKNOWN_ERROR_CODE", actualJdbcException.getLocalizedMessage());
    assertEquals("UNKNOWN_ERROR_CODE", actualJdbcException.getMessage());
    assertNull(actualJdbcException.getNextException());
    assertEquals(JdbcException.SYNTHETIC_ERROR, actualJdbcException.getSQLState());
    assertEquals(0, actualJdbcException.getSuppressed().length);
    Iterator<Throwable> iteratorResult = actualJdbcException.iterator();
    Throwable actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(actualJdbcException, actualNextResult);
  }
}

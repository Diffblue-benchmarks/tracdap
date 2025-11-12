package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.finos.tracdap.metadata.SearchParameters;
import org.h2.tools.SimpleResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcSearchImplDiffblueTest {
  /**
   * Test {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  @DisplayName(
      "Test search(Connection, short, SearchParameters); given SQLException(); then throw SQLException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcSearchImpl.search(Connection, short, SearchParameters)"})
  void testSearch_givenSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcSearchImpl jdbcSearchImpl = new JdbcSearchImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> jdbcSearchImpl.search(conn, (short) 1, SearchParameters.getDefaultInstance()));
    verify(conn)
        .prepareStatement(
            "select t0.tag_pk\nfrom tag t0\njoin object_definition od0\n  on od0.tenant_id = t0.tenant_id\n  and od0.definition_pk = t0.definition_fk\nwhere t0.tenant_id = ?\n  and t0.object_type = ?\n  and od0.object_is_latest = ? and t0.tag_is_latest = ?\ngroup by t0.tag_pk\norder by max(t0.tag_timestamp) desc");
  }

  /**
   * Test {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  @DisplayName("Test search(Connection, short, SearchParameters); then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JdbcSearchImpl.search(Connection, short, SearchParameters)"})
  void testSearch_thenReturnEmptyArrayOfLong() throws SQLException {
    // Arrange
    JdbcSearchImpl jdbcSearchImpl = new JdbcSearchImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualSearchResult =
        jdbcSearchImpl.search(conn, (short) 1, SearchParameters.getDefaultInstance());

    // Assert
    verify(conn)
        .prepareStatement(
            "select t0.tag_pk\nfrom tag t0\njoin object_definition od0\n  on od0.tenant_id = t0.tenant_id\n  and od0.definition_pk = t0.definition_fk\nwhere t0.tenant_id = ?\n  and t0.object_type = ?\n  and od0.object_is_latest = ? and t0.tag_is_latest = ?\ngroup by t0.tag_pk\norder by max(t0.tag_timestamp) desc");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setShort(1, (short) 1);
    verify(preparedStatement).setString(2, "OBJECT_TYPE_NOT_SET");
    verify(preparedStatement).close();
    assertArrayEquals(new long[] {}, actualSearchResult);
  }
}

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.finos.tracdap.metadata.SearchParameters;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcSearchImplDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  void testSearch() throws SQLException {
    // Arrange
    JdbcSearchImpl jdbcSearchImpl = new JdbcSearchImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(Mockito.<String>any())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long[] actualSearchResult = jdbcSearchImpl.search(conn, (short) 1, SearchParameters.getDefaultInstance());

    // Assert
    verify(conn).prepareStatement(eq(
        "select t0.tag_pk\nfrom tag t0\njoin object_definition od0\n  on od0.tenant_id = t0.tenant_id\n  and od0.definition_pk = t0.definition_fk\nwhere t0.tenant_id = ?\n  and t0.object_type = ?\n  and od0.object_is_latest = ? and t0.tag_is_latest = ?\ngroup by t0.tag_pk\norder by max(t0.tag_timestamp) desc"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement).setString(eq(2), eq("OBJECT_TYPE_NOT_SET"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq("tag_pk"));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    assertArrayEquals(new long[]{1L, 1L}, actualSearchResult);
  }

  /**
   * Method under test:
   * {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  void testSearch2() throws SQLException {
    // Arrange
    JdbcSearchImpl jdbcSearchImpl = new JdbcSearchImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(Mockito.<String>any())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> jdbcSearchImpl.search(conn, (short) 1, SearchParameters.getDefaultInstance()));
    verify(conn).prepareStatement(eq(
        "select t0.tag_pk\nfrom tag t0\njoin object_definition od0\n  on od0.tenant_id = t0.tenant_id\n  and od0.definition_pk = t0.definition_fk\nwhere t0.tenant_id = ?\n  and t0.object_type = ?\n  and od0.object_is_latest = ? and t0.tag_is_latest = ?\ngroup by t0.tag_pk\norder by max(t0.tag_timestamp) desc"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement).setString(eq(2), eq("OBJECT_TYPE_NOT_SET"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq("tag_pk"));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }
}

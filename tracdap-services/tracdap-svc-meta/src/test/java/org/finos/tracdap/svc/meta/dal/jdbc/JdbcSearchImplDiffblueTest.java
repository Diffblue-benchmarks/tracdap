package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.finos.tracdap.metadata.SearchParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcSearchImplDiffblueTest {
  /**
   * Test {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(String)} return one.</li>
   *   <li>Then return array length is one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  @DisplayName("Test search(Connection, short, SearchParameters); given ResultSet getLong(String) return one; then return array length is one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcSearchImpl.search(Connection, short, SearchParameters)"})
  void testSearch_givenResultSetGetLongReturnOne_thenReturnArrayLengthIsOneHundred() throws SQLException {
    // Arrange
    JdbcSearchImpl jdbcSearchImpl = new JdbcSearchImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(Mockito.<String>any())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true);
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
    assertEquals(100, actualSearchResult.length);
    assertEquals(1L, actualSearchResult[0]);
    assertEquals(1L, actualSearchResult[1]);
    assertEquals(1L, actualSearchResult[10]);
    assertEquals(1L, actualSearchResult[11]);
    assertEquals(1L, actualSearchResult[12]);
    assertEquals(1L, actualSearchResult[13]);
    assertEquals(1L, actualSearchResult[14]);
    assertEquals(1L, actualSearchResult[15]);
    assertEquals(1L, actualSearchResult[17]);
    assertEquals(1L, actualSearchResult[18]);
    assertEquals(1L, actualSearchResult[19]);
    assertEquals(1L, actualSearchResult[2]);
    assertEquals(1L, actualSearchResult[20]);
    assertEquals(1L, actualSearchResult[21]);
    assertEquals(1L, actualSearchResult[22]);
    assertEquals(1L, actualSearchResult[23]);
    assertEquals(1L, actualSearchResult[24]);
    assertEquals(1L, actualSearchResult[3]);
    assertEquals(1L, actualSearchResult[4]);
    assertEquals(1L, actualSearchResult[5]);
    assertEquals(1L, actualSearchResult[6]);
    assertEquals(1L, actualSearchResult[7]);
    assertEquals(1L, actualSearchResult[75]);
    assertEquals(1L, actualSearchResult[76]);
    assertEquals(1L, actualSearchResult[77]);
    assertEquals(1L, actualSearchResult[78]);
    assertEquals(1L, actualSearchResult[79]);
    assertEquals(1L, actualSearchResult[8]);
    assertEquals(1L, actualSearchResult[80]);
    assertEquals(1L, actualSearchResult[81]);
    assertEquals(1L, actualSearchResult[82]);
    assertEquals(1L, actualSearchResult[83]);
    assertEquals(1L, actualSearchResult[84]);
    assertEquals(1L, actualSearchResult[85]);
    assertEquals(1L, actualSearchResult[86]);
    assertEquals(1L, actualSearchResult[87]);
    assertEquals(1L, actualSearchResult[88]);
    assertEquals(1L, actualSearchResult[89]);
    assertEquals(1L, actualSearchResult[9]);
    assertEquals(1L, actualSearchResult[90]);
    assertEquals(1L, actualSearchResult[91]);
    assertEquals(1L, actualSearchResult[92]);
    assertEquals(1L, actualSearchResult[93]);
    assertEquals(1L, actualSearchResult[94]);
    assertEquals(1L, actualSearchResult[95]);
    assertEquals(1L, actualSearchResult[96]);
    assertEquals(1L, actualSearchResult[97]);
    assertEquals(1L, actualSearchResult[98]);
    assertEquals(1L, actualSearchResult[99]);
    assertEquals(1L, actualSearchResult[Short.SIZE]);
  }

  /**
   * Test {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(String)} return one.</li>
   *   <li>Then return array of {@code long} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  @DisplayName("Test search(Connection, short, SearchParameters); given ResultSet getLong(String) return one; then return array of long with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcSearchImpl.search(Connection, short, SearchParameters)"})
  void testSearch_givenResultSetGetLongReturnOne_thenReturnArrayOfLongWithOneAndOne() throws SQLException {
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
   * Test {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(String)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchImpl#search(Connection, short, SearchParameters)}
   */
  @Test
  @DisplayName("Test search(Connection, short, SearchParameters); given ResultSet getLong(String) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long[] JdbcSearchImpl.search(Connection, short, SearchParameters)"})
  void testSearch_givenResultSetGetLongThrowSQLException_thenThrowSQLException() throws SQLException {
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

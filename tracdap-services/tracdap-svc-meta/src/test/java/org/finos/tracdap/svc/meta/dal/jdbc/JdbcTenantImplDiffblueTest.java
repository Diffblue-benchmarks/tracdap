package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.finos.tracdap.common.exception.ETenantNotFound;
import org.finos.tracdap.metadata.TenantInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcTenantImplDiffblueTest {
  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getShort(int)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName("Test loadTenantMap(Connection); given ResultSet getShort(int) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap_givenResultSetGetShortThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getShort(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcTenantImpl.loadTenantMap(conn));
    verify(conn).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).getShort(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then calls {@link ResultSet#getString(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName("Test loadTenantMap(Connection); given ResultSet getString(int) return 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap_givenResultSetGetStringReturnString_thenCallsGetString() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcTenantImpl.loadTenantMap(conn);

    // Assert
    verify(conn).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getShort(int)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName("Test getTenantId(Connection, String); given ResultSet getShort(int) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId_givenResultSetGetShortThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getShort(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).getShort(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then throw {@link ETenantNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName("Test getTenantId(Connection, String); given ResultSet getString(int) return 'String'; then throw ETenantNotFound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId_givenResultSetGetStringReturnString_thenThrowETenantNotFound() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName("Test listTenants(Connection); given ResultSet getString(int) return 'String'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants_givenResultSetGetStringReturnString_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<TenantInfo> actualListTenantsResult = jdbcTenantImpl.listTenants(conn);

    // Assert
    verify(conn).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    assertEquals(2, actualListTenantsResult.size());
    TenantInfo getResult = actualListTenantsResult.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("String", getResult.getDescription());
    assertEquals("String", getResult.getTenantCode());
    assertEquals(2, getResult.getAllFields().size());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, actualListTenantsResult.get(1));
    assertEquals(Short.SIZE, getResult.getSerializedSize());
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   * <ul>
   *   <li>Then throw {@link ETenantNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName("Test listTenants(Connection); then throw ETenantNotFound")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants_thenThrowETenantNotFound() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenThrow(new ETenantNotFound("Not all who wander are lost"));
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.listTenants(conn));
    verify(conn).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).getString(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }
}

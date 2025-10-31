package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.finos.tracdap.common.exception.ETenantNotFound;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcTenantImplDiffblueTest {
  /**
   * Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  void testLoadTenantMap() throws SQLException {
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
   * Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  void testLoadTenantMap2() throws SQLException {
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
   * Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  void testGetTenantId() throws SQLException {
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
   * Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  void testGetTenantId2() throws SQLException {
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
   * Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  void testListTenants() throws SQLException {
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

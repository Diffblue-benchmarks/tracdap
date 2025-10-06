package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.finos.tracdap.common.exception.ETenantNotFound;
import org.finos.tracdap.metadata.TenantInfo;
import org.h2.tools.SimpleResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcTenantImplDiffblueTest {
  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   *
   * <p>Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName("Test loadTenantMap(Connection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery())
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));
    doThrow(new ETenantNotFound("Not all who wander are lost")).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.loadTenantMap(conn));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#addColumn(String, int, int, int)} with {@code 42} and zero
   *       and zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName(
      "Test loadTenantMap(Connection); given addColumn(String, int, int, int) with '42' and zero and zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap_givenAddColumnWith42AndZeroAndZeroAndZero() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn("42", 0, 0, 0);
    simpleResultSet.addColumn("foo", 1, 1, 1);
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcTenantImpl.loadTenantMap(conn);

    // Assert
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   *
   * <ul>
   *   <li>Given {@link ETenantNotFound#ETenantNotFound(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName(
      "Test loadTenantMap(Connection); given ETenantNotFound(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap_givenETenantNotFoundWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.loadTenantMap(conn));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
  }

  /**
   * Test {@link JdbcTenantImpl#loadTenantMap(Connection)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#loadTenantMap(Connection)}
   */
  @Test
  @DisplayName("Test loadTenantMap(Connection); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcTenantImpl.loadTenantMap(Connection)"})
  void testLoadTenantMap_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    jdbcTenantImpl.loadTenantMap(conn);

    // Assert
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   *
   * <p>Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName("Test getTenantId(Connection, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery())
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));
    doThrow(new ETenantNotFound("Not all who wander are lost")).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#addColumn(String, int, int, int)} with {@code 42} and zero
   *       and zero and zero.
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantId(Connection, String); given addColumn(String, int, int, int) with '42' and zero and zero and zero; then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId_givenAddColumnWith42AndZeroAndZeroAndZero_thenCallsExecuteQuery()
      throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn("42", 0, 0, 0);
    simpleResultSet.addColumn("foo", 1, 1, 1);
    simpleResultSet.addRow("42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   *
   * <ul>
   *   <li>Given {@link ETenantNotFound#ETenantNotFound(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantId(Connection, String); given ETenantNotFound(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId_givenETenantNotFoundWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
  }

  /**
   * Test {@link JdbcTenantImpl#getTenantId(Connection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#getTenantId(Connection, String)}
   */
  @Test
  @DisplayName("Test getTenantId(Connection, String); then calls executeQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JdbcTenantImpl.getTenantId(Connection, String)"})
  void testGetTenantId_thenCallsExecuteQuery() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.getTenantId(conn, "Tenant"));
    verify(conn).prepareStatement("select tenant_id, tenant_code from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   *
   * <p>Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName("Test listTenants(Connection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery())
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));
    doThrow(new ETenantNotFound("Not all who wander are lost")).when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.listTenants(conn));
    verify(conn).prepareStatement("select tenant_code, description from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   *
   * <ul>
   *   <li>Given {@link ETenantNotFound#ETenantNotFound(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName(
      "Test listTenants(Connection); given ETenantNotFound(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants_givenETenantNotFoundWithMessageIsNotAllWhoWanderAreLost()
      throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any()))
        .thenThrow(new ETenantNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> jdbcTenantImpl.listTenants(conn));
    verify(conn).prepareStatement("select tenant_code, description from tenant");
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   *
   * <ul>
   *   <li>Given {@link SimpleResultSet#SimpleResultSet()} addRow {@code 42} and {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName(
      "Test listTenants(Connection); given SimpleResultSet() addRow '42' and '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants_givenSimpleResultSetAddRow42And42_thenReturnSizeIsOne() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    SimpleResultSet simpleResultSet = new SimpleResultSet();
    simpleResultSet.addColumn("42", 0, 0, 0);
    simpleResultSet.addColumn("foo", 1, 1, 1);
    simpleResultSet.addRow("42", "42");

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(simpleResultSet);
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<TenantInfo> actualListTenantsResult = jdbcTenantImpl.listTenants(conn);

    // Assert
    verify(conn).prepareStatement("select tenant_code, description from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
    assertEquals(1, actualListTenantsResult.size());
    TenantInfo getResult = actualListTenantsResult.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("42", getResult.getDescription());
    assertEquals("42", getResult.getTenantCode());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(8, getResult.getSerializedSize());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
  }

  /**
   * Test {@link JdbcTenantImpl#listTenants(Connection)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JdbcTenantImpl#listTenants(Connection)}
   */
  @Test
  @DisplayName("Test listTenants(Connection); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JdbcTenantImpl.listTenants(Connection)"})
  void testListTenants_thenReturnEmpty() throws SQLException {
    // Arrange
    JdbcTenantImpl jdbcTenantImpl = new JdbcTenantImpl();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(new SimpleResultSet());
    doNothing().when(preparedStatement).close();

    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<TenantInfo> actualListTenantsResult = jdbcTenantImpl.listTenants(conn);

    // Assert
    verify(conn).prepareStatement("select tenant_code, description from tenant");
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).close();
    assertTrue(actualListTenantsResult.isEmpty());
  }
}

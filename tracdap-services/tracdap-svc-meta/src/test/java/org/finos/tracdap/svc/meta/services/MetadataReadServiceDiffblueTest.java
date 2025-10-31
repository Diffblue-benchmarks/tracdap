package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import javax.sql.DataSource;
import org.finos.tracdap.api.ClientConfigRequest;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.common.exception.EResourceNotFound;
import org.finos.tracdap.common.exception.ETenantNotFound;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.ResourceType;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.svc.meta.dal.IMetadataDal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataReadServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MetadataReadService#clientConfig(ClientConfigRequest)}
   */
  @Test
  void testClientConfig() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    MetadataReadService metadataReadService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    // Act and Assert
    assertThrows(EResourceNotFound.class,
        () -> metadataReadService.clientConfig(ClientConfigRequest.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link MetadataReadService#listResources(String, ResourceType)}
   */
  @Test
  void testListResources() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .listResources("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#listResources(String, ResourceType)}
   */
  @Test
  void testListResources2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("Tenant Code");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(EResourceNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .listResources("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#listResources(String, ResourceType)}
   */
  @Test
  void testListResources3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .listResources("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#resourceInfo(String, ResourceType, String)}
   */
  @Test
  void testResourceInfo() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .resourceInfo("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET, "Resource Key"));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#resourceInfo(String, ResourceType, String)}
   */
  @Test
  void testResourceInfo2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("Tenant Code");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(EResourceNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .resourceInfo("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET, "Resource Key"));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#resourceInfo(String, ResourceType, String)}
   */
  @Test
  void testResourceInfo3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    // Act and Assert
    assertThrows(ETenantNotFound.class, () -> (new MetadataReadService(dal, PlatformConfig.getDefaultInstance()))
        .resourceInfo("Tenant Code", ResourceType.RESOURCE_TYPE_NOT_SET, "Resource Key"));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_code, description from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Method under test:
   * {@link MetadataReadService#readObject(String, TagSelector)}
   */
  @Test
  void testReadObject() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    Tag defaultInstance = Tag.getDefaultInstance();
    when(dal.loadObject(Mockito.<String>any(), Mockito.<TagSelector>any())).thenReturn(defaultInstance);
    MetadataReadService metadataReadService = new MetadataReadService(dal, PlatformConfig.getDefaultInstance());

    // Act
    Tag actualReadObjectResult = metadataReadService.readObject("Tenant", TagSelector.getDefaultInstance());

    // Assert
    verify(dal).loadObject(eq("Tenant"), isA(TagSelector.class));
    assertSame(defaultInstance, actualReadObjectResult);
  }
}

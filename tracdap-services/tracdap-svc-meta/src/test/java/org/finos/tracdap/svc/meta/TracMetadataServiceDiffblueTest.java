package org.finos.tracdap.svc.meta;

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
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import javax.sql.DataSource;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.middleware.CommonConcerns;
import org.finos.tracdap.common.middleware.CommonGrpcConcerns;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.common.plugin.ITracExtension;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.config.PluginConfig;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TracMetadataServiceDiffblueTest {
  /**
   * Method under test: {@link TracMetadataService#doStartup(Duration)}
   */
  @Test
  void testDoStartup() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(Mockito.<Class<IConfigLoader>>any(), Mockito.<String>any(),
        Mockito.<Properties>any())).thenThrow(EStartup.quietShutdown(1));
    when(plugins.isServiceAvailable(Mockito.<Class<Object>>any(), Mockito.<String>any())).thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());
    ConfigManager configManager = new ConfigManager("https://example.org/example",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins);

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracMetadataService(new PluginManager(), configManager)).doStartup(null));
    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }

  /**
   * Method under test: {@link TracMetadataService#doStartup(Duration)}
   */
  @Test
  void testDoStartup2() throws SQLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getShort(anyInt())).thenReturn((short) 1);
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
    JdbcMetadataDal jdbcMetadataDal = new JdbcMetadataDal(JdbcDialect.H2, dataSource);

    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.addServiceConcerns(Mockito.<CommonConcerns<GrpcConcern>>any(), Mockito.<ConfigManager>any(),
        Mockito.<String>any())).thenReturn(new CommonGrpcConcerns("Concern Name"));
    ITracExtension iTracExtension2 = mock(ITracExtension.class);
    when(iTracExtension2.addServiceConcerns(Mockito.<CommonConcerns<GrpcConcern>>any(), Mockito.<ConfigManager>any(),
        Mockito.<String>any())).thenThrow(EStartup.quietShutdown(1));

    ArrayList<ITracExtension> iTracExtensionList = new ArrayList<>();
    iTracExtensionList.add(iTracExtension2);
    iTracExtensionList.add(iTracExtension);
    PluginManager pluginManager = mock(PluginManager.class);
    when(pluginManager.getExtensions()).thenReturn(iTracExtensionList);
    when(pluginManager.createService(Mockito.<Class<Object>>any(), Mockito.<PluginConfig>any(),
        Mockito.<ConfigManager>any())).thenReturn(jdbcMetadataDal);
    ConfigManager configManager = mock(ConfigManager.class);
    when(configManager.loadRootConfigObject(Mockito.<Class<PlatformConfig>>any()))
        .thenReturn(PlatformConfig.getDefaultInstance());

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracMetadataService(pluginManager, configManager)).doStartup(null));
    verify(connection).close();
    verify(connection).commit();
    verify(connection).prepareStatement(eq("select tenant_id, tenant_code from tenant"));
    verify(connection).setAutoCommit(eq(false));
    verify(preparedStatement).executeQuery();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getShort(eq(1));
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
    verify(configManager).loadRootConfigObject(isA(Class.class));
    verify(iTracExtension2).addServiceConcerns(isA(CommonConcerns.class), isA(ConfigManager.class), eq("metadata"));
    verify(pluginManager).createService(isA(Class.class), isA(PluginConfig.class), isA(ConfigManager.class));
    verify(pluginManager).getExtensions();
  }
}

package org.finos.tracdap.common.db;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.zaxxer.hikari.HikariDataSource;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.sql.DataSource;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcSetupDiffblueTest {
  /**
   * Method under test: {@link JdbcSetup#getSqlDialect(Properties)}
   */
  @Test
  void testGetSqlDialect() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(new Properties()));
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(PluginConfig.getDefaultInstance()));
  }

  /**
   * Method under test: {@link JdbcSetup#createDatasource(Properties)}
   */
  @Test
  void testCreateDatasource() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(new Properties()));
  }

  /**
   * Method under test:
   * {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  void testCreateDatasource2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  void testCreateDatasource3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("dialect", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  void testDestroyDatasource() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcSetup.destroyDatasource(mock(DataSource.class)));
  }

  /**
   * Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  void testDestroyDatasource2() {
    // Arrange
    HikariDataSource source = mock(HikariDataSource.class);
    doNothing().when(source).close();
    doNothing().when(source).setMetricRegistry(Mockito.<Object>any());
    source.setMetricRegistry(null);

    // Act
    JdbcSetup.destroyDatasource(source);

    // Assert that nothing has changed
    verify(source).close();
    verify(source).setMetricRegistry((Object) isNull());
  }

  /**
   * Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  void testDestroyDatasource3() {
    // Arrange
    HikariDataSource source = mock(HikariDataSource.class);
    doThrow(EStartup.quietShutdown(1)).when(source).close();

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.destroyDatasource(source));
    verify(source).close();
  }
}

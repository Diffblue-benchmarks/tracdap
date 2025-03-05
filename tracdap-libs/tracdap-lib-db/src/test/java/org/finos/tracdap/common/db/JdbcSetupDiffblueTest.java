package org.finos.tracdap.common.db;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.sql.DataSource;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JdbcSetupDiffblueTest {
  /**
   * Test {@link JdbcSetup#getSqlDialect(PluginConfig)} with {@code config}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSetup#getSqlDialect(PluginConfig)}
   */
  @Test
  @DisplayName("Test getSqlDialect(PluginConfig) with 'config'; when DefaultInstance; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.db.JdbcDialect JdbcSetup.getSqlDialect(PluginConfig)"})
  void testGetSqlDialectWithConfig_whenDefaultInstance_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#getSqlDialect(Properties)} with {@code properties}.
   * <p>
   * Method under test: {@link JdbcSetup#getSqlDialect(Properties)}
   */
  @Test
  @DisplayName("Test getSqlDialect(Properties) with 'properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.db.JdbcDialect JdbcSetup.getSqlDialect(Properties)"})
  void testGetSqlDialectWithProperties() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(new Properties()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)} with {@code configManager}, {@code config}.
   * <p>
   * Method under test: {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  @DisplayName("Test createDatasource(ConfigManager, PluginConfig) with 'configManager', 'config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(ConfigManager, PluginConfig)"})
  void testCreateDatasourceWithConfigManagerConfig() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)} with {@code configManager}, {@code config}.
   * <p>
   * Method under test: {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  @DisplayName("Test createDatasource(ConfigManager, PluginConfig) with 'configManager', 'config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(ConfigManager, PluginConfig)"})
  void testCreateDatasourceWithConfigManagerConfig2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("dialect", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(Properties)} with {@code properties}.
   * <p>
   * Method under test: {@link JdbcSetup#createDatasource(Properties)}
   */
  @Test
  @DisplayName("Test createDatasource(Properties) with 'properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(Properties)"})
  void testCreateDatasourceWithProperties() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(new Properties()));
  }

  /**
   * Test {@link JdbcSetup#destroyDatasource(DataSource)}.
   * <p>
   * Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  @DisplayName("Test destroyDatasource(DataSource)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSetup.destroyDatasource(DataSource)"})
  void testDestroyDatasource() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcSetup.destroyDatasource(mock(DataSource.class)));
  }
}

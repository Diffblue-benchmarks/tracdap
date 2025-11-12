package org.finos.tracdap.common.db;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcSetupDiffblueTest {
  /**
   * Test {@link JdbcSetup#getSqlDialect(PluginConfig)} with {@code config}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSetup#getSqlDialect(PluginConfig)}
   */
  @Test
  @DisplayName(
      "Test getSqlDialect(PluginConfig) with 'config'; when DefaultInstance; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.db.JdbcDialect JdbcSetup.getSqlDialect(PluginConfig)"
  })
  void testGetSqlDialectWithConfig_whenDefaultInstance_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#getSqlDialect(Properties)} with {@code properties}.
   *
   * <p>Method under test: {@link JdbcSetup#getSqlDialect(Properties)}
   */
  @Test
  @DisplayName("Test getSqlDialect(Properties) with 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.tracdap.common.db.JdbcDialect JdbcSetup.getSqlDialect(Properties)"})
  void testGetSqlDialectWithProperties() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.getSqlDialect(new Properties()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)} with {@code
   * configManager}, {@code config}.
   *
   * <p>Method under test: {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  @DisplayName("Test createDatasource(ConfigManager, PluginConfig) with 'configManager', 'config'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(ConfigManager, PluginConfig)"})
  void testCreateDatasourceWithConfigManagerConfig() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EStartup.class,
        () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)} with {@code
   * configManager}, {@code config}.
   *
   * <p>Method under test: {@link JdbcSetup#createDatasource(ConfigManager, PluginConfig)}
   */
  @Test
  @DisplayName("Test createDatasource(ConfigManager, PluginConfig) with 'configManager', 'config'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(ConfigManager, PluginConfig)"})
  void testCreateDatasourceWithConfigManagerConfig2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("dialect", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EStartup.class,
        () -> JdbcSetup.createDatasource(configManager, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSetup#createDatasource(Properties)} with {@code properties}.
   *
   * <p>Method under test: {@link JdbcSetup#createDatasource(Properties)}
   */
  @Test
  @DisplayName("Test createDatasource(Properties) with 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSource JdbcSetup.createDatasource(Properties)"})
  void testCreateDatasourceWithProperties() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.createDatasource(new Properties()));
  }

  /**
   * Test {@link JdbcSetup#destroyDatasource(DataSource)}.
   *
   * <ul>
   *   <li>Given quietShutdown one.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  @DisplayName("Test destroyDatasource(DataSource); given quietShutdown one; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcSetup.destroyDatasource(DataSource)"})
  void testDestroyDatasource_givenQuietShutdownOne_thenThrowEStartup() {
    // Arrange
    HikariDataSource source = mock(HikariDataSource.class);
    doThrow(EStartup.quietShutdown(1)).when(source).close();

    // Act and Assert
    assertThrows(EStartup.class, () -> JdbcSetup.destroyDatasource(source));
    verify(source).close();
  }

  /**
   * Test {@link JdbcSetup#destroyDatasource(DataSource)}.
   *
   * <ul>
   *   <li>Given {@code Source}.
   *   <li>Then calls {@link HikariDataSource#setMetricRegistry(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  @DisplayName(
      "Test destroyDatasource(DataSource); given 'Source'; then calls setMetricRegistry(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcSetup.destroyDatasource(DataSource)"})
  void testDestroyDatasource_givenSource_thenCallsSetMetricRegistry() {
    // Arrange
    HikariDataSource source = mock(HikariDataSource.class);
    doNothing().when(source).close();
    doNothing().when(source).setMetricRegistry(Mockito.<Object>any());
    source.setMetricRegistry("Source");

    // Act
    JdbcSetup.destroyDatasource(source);

    // Assert
    verify(source).close();
    verify(source).setMetricRegistry(isA(Object.class));
  }

  /**
   * Test {@link JdbcSetup#destroyDatasource(DataSource)}.
   *
   * <ul>
   *   <li>When {@link DataSource}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link JdbcSetup#destroyDatasource(DataSource)}
   */
  @Test
  @DisplayName("Test destroyDatasource(DataSource); when DataSource; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JdbcSetup.destroyDatasource(DataSource)"})
  void testDestroyDatasource_whenDataSource_thenThrowETracInternal() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcSetup.destroyDatasource(mock(DataSource.class)));
  }
}

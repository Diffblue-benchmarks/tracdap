package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.test.TestConfigExtension;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.Test;

class PluginManagerDiffblueTest {
  /**
   * Method under test: {@link PluginManager#registerExtensions()}
   */
  @Test
  void testRegisterExtensions() {
    // Arrange
    PluginManager pluginManager = new PluginManager();

    // Act
    pluginManager.registerExtensions();

    // Assert
    List<ITracExtension> extensions = pluginManager.getExtensions();
    assertEquals(1, extensions.size());
    assertTrue(extensions.get(0) instanceof TestConfigExtension);
  }

  /**
   * Method under test: {@link PluginManager#getExtensions()}
   */
  @Test
  void testGetExtensions() {
    // Arrange, Act and Assert
    assertTrue((new PluginManager()).getExtensions().isEmpty());
  }

  /**
   * Method under test: {@link PluginManager#availableProtocols(Class)}
   */
  @Test
  void testAvailableProtocols() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertTrue(pluginManager.availableProtocols(serviceClass).isEmpty());
  }

  /**
   * Method under test: {@link PluginManager#isServiceAvailable(Class, String)}
   */
  @Test
  void testIsServiceAvailable() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertFalse(pluginManager.isServiceAvailable(serviceClass, "Protocol"));
  }

  /**
   * Method under test:
   * {@link PluginManager#createService(Class, String, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> pluginManager.createService(serviceClass, "Protocol",
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link PluginManager#createService(Class, PluginConfig, ConfigManager)}
   */
  @Test
  void testCreateService2() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;
    PluginConfig pluginConfig = PluginConfig.getDefaultInstance();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> pluginManager.createService(serviceClass, pluginConfig,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link PluginManager#createConfigService(Class, String, Properties)}
   */
  @Test
  void testCreateConfigService() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, "Protocol", new Properties()));
  }

  /**
   * Method under test:
   * {@link PluginManager#createConfigService(Class, String, Properties)}
   */
  @Test
  void testCreateConfigService2() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<String> serviceClass = String.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, "Protocol", new Properties()));
  }

  /**
   * Method under test:
   * {@link PluginManager#createConfigService(Class, PluginConfig)}
   */
  @Test
  void testCreateConfigService3() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, PluginConfig.getDefaultInstance()));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PluginManager}
   */
  @Test
  void testNewPluginManager() {
    // Arrange, Act and Assert
    assertTrue((new PluginManager()).getExtensions().isEmpty());
  }
}

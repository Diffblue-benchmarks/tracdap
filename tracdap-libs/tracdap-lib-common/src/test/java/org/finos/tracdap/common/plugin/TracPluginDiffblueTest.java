package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.local.LocalConfigPlugin;
import org.finos.tracdap.common.data.CoreDataPlugin;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.Test;

class TracPluginDiffblueTest {
  /**
   * Method under test:
   * {@link TracPlugin#createService(Class, PluginConfig, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Class<Object> serviceClass = Object.class;
    PluginConfig config = PluginConfig.getDefaultInstance();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localConfigPlugin.createService(serviceClass, config,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link TracPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService2() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> localConfigPlugin.createService("Service Name", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link TracPlugin#createConfigService(Class, PluginConfig)}
   */
  @Test
  void testCreateConfigService() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localConfigPlugin.createConfigService(serviceClass, PluginConfig.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TracPlugin#createConfigService(String, Properties)}
   */
  @Test
  void testCreateConfigService2() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> coreDataPlugin.createConfigService("Service Name", new Properties()));
  }

  /**
   * Method under test: {@link TracPlugin#protocols(Class)}
   */
  @Test
  void testProtocols() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Class<Object> service = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localConfigPlugin.protocols(service));
  }
}

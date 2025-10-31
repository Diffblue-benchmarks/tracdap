package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.local.LocalConfigPlugin;
import org.finos.tracdap.common.data.CoreDataPlugin;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracPluginDiffblueTest {
  /**
   * Test {@link TracPlugin#createService(Class, PluginConfig, ConfigManager)} with {@code serviceClass}, {@code config}, {@code configManager}.
   * <p>
   * Method under test: {@link TracPlugin#createService(Class, PluginConfig, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(Class, PluginConfig, ConfigManager) with 'serviceClass', 'config', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TracPlugin.createService(Class, PluginConfig, ConfigManager)"})
  void testCreateServiceWithServiceClassConfigConfigManager() {
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
   * Test {@link TracPlugin#createService(String, Properties, ConfigManager)} with {@code serviceName}, {@code properties}, {@code configManager}.
   * <p>
   * Method under test: {@link TracPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TracPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> localConfigPlugin.createService("Service Name", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Test {@link TracPlugin#createConfigService(Class, PluginConfig)} with {@code serviceClass}, {@code config}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracPlugin#createConfigService(Class, PluginConfig)}
   */
  @Test
  @DisplayName("Test createConfigService(Class, PluginConfig) with 'serviceClass', 'config'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TracPlugin.createConfigService(Class, PluginConfig)"})
  void testCreateConfigServiceWithServiceClassConfig_thenThrowIllegalArgumentException() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localConfigPlugin.createConfigService(serviceClass, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link TracPlugin#createConfigService(String, Properties)} with {@code serviceName}, {@code properties}.
   * <p>
   * Method under test: {@link TracPlugin#createConfigService(String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(String, Properties) with 'serviceName', 'properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TracPlugin.createConfigService(String, Properties)"})
  void testCreateConfigServiceWithServiceNameProperties() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> coreDataPlugin.createConfigService("Service Name", new Properties()));
  }

  /**
   * Test {@link TracPlugin#protocols(Class)}.
   * <p>
   * Method under test: {@link TracPlugin#protocols(Class)}
   */
  @Test
  @DisplayName("Test protocols(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List TracPlugin.protocols(Class)"})
  void testProtocols() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();
    Class<Object> service = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localConfigPlugin.protocols(service));
  }
}

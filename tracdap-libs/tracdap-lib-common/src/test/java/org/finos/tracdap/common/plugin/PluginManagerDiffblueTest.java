package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.test.TestConfigExtension;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginManagerDiffblueTest {
  /**
   * Test new {@link PluginManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PluginManager}
   */
  @Test
  @DisplayName("Test new PluginManager (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PluginManager.<init>()"})
  void testNewPluginManager() {
    // Arrange, Act and Assert
    assertTrue((new PluginManager()).getExtensions().isEmpty());
  }

  /**
   * Test {@link PluginManager#registerExtensions()}.
   * <p>
   * Method under test: {@link PluginManager#registerExtensions()}
   */
  @Test
  @DisplayName("Test registerExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PluginManager.registerExtensions()"})
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
   * Test {@link PluginManager#getExtensions()}.
   * <p>
   * Method under test: {@link PluginManager#getExtensions()}
   */
  @Test
  @DisplayName("Test getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PluginManager.getExtensions()"})
  void testGetExtensions() {
    // Arrange, Act and Assert
    assertTrue((new PluginManager()).getExtensions().isEmpty());
  }

  /**
   * Test {@link PluginManager#availableProtocols(Class)}.
   * <p>
   * Method under test: {@link PluginManager#availableProtocols(Class)}
   */
  @Test
  @DisplayName("Test availableProtocols(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PluginManager.availableProtocols(Class)"})
  void testAvailableProtocols() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertTrue(pluginManager.availableProtocols(serviceClass).isEmpty());
  }

  /**
   * Test {@link PluginManager#isServiceAvailable(Class, String)}.
   * <p>
   * Method under test: {@link PluginManager#isServiceAvailable(Class, String)}
   */
  @Test
  @DisplayName("Test isServiceAvailable(Class, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginManager.isServiceAvailable(Class, String)"})
  void testIsServiceAvailable() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertFalse(pluginManager.isServiceAvailable(serviceClass, "Protocol"));
  }

  /**
   * Test {@link PluginManager#createService(Class, PluginConfig, ConfigManager)} with {@code serviceClass}, {@code pluginConfig}, {@code configManager}.
   * <ul>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginManager#createService(Class, PluginConfig, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(Class, PluginConfig, ConfigManager) with 'serviceClass', 'pluginConfig', 'configManager'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PluginManager.createService(Class, PluginConfig, ConfigManager)"})
  void testCreateServiceWithServiceClassPluginConfigConfigManager_thenThrowEUnexpected() {
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
   * Test {@link PluginManager#createService(Class, String, ConfigManager)} with {@code serviceClass}, {@code protocol}, {@code configManager}.
   * <p>
   * Method under test: {@link PluginManager#createService(Class, String, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(Class, String, ConfigManager) with 'serviceClass', 'protocol', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PluginManager.createService(Class, String, ConfigManager)"})
  void testCreateServiceWithServiceClassProtocolConfigManager() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> pluginManager.createService(serviceClass, "Protocol",
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Test {@link PluginManager#createConfigService(Class, PluginConfig)} with {@code serviceClass}, {@code pluginConfig}.
   * <ul>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginManager#createConfigService(Class, PluginConfig)}
   */
  @Test
  @DisplayName("Test createConfigService(Class, PluginConfig) with 'serviceClass', 'pluginConfig'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PluginManager.createConfigService(Class, PluginConfig)"})
  void testCreateConfigServiceWithServiceClassPluginConfig_thenThrowEUnexpected() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, PluginConfig.getDefaultInstance()));
  }

  /**
   * Test {@link PluginManager#createConfigService(Class, String, Properties)} with {@code serviceClass}, {@code protocol}, {@code properties}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginManager#createConfigService(Class, String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(Class, String, Properties) with 'serviceClass', 'protocol', 'properties'; when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PluginManager.createConfigService(Class, String, Properties)"})
  void testCreateConfigServiceWithServiceClassProtocolProperties_whenJavaLangObject() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<Object> serviceClass = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, "Protocol", new Properties()));
  }

  /**
   * Test {@link PluginManager#createConfigService(Class, String, Properties)} with {@code serviceClass}, {@code protocol}, {@code properties}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginManager#createConfigService(Class, String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(Class, String, Properties) with 'serviceClass', 'protocol', 'properties'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PluginManager.createConfigService(Class, String, Properties)"})
  void testCreateConfigServiceWithServiceClassProtocolProperties_whenJavaLangString() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Class<String> serviceClass = String.class;

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> pluginManager.createConfigService(serviceClass, "Protocol", new Properties()));
  }
}

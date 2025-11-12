package org.finos.tracdap.svc.meta.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataDalPluginDiffblueTest {
  /**
   * Test {@link MetadataDalPlugin#pluginName()}.
   *
   * <p>Method under test: {@link MetadataDalPlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetadataDalPlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("CORE_METADATA", new MetadataDalPlugin().pluginName());
  }

  /**
   * Test {@link MetadataDalPlugin#serviceInfo()}.
   *
   * <p>Method under test: {@link MetadataDalPlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MetadataDalPlugin.serviceInfo()"})
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = new MetadataDalPlugin().serviceInfo();

    // Assert
    assertEquals(1, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    List<String> protocolsResult = getResult.protocols();
    assertEquals(2, protocolsResult.size());
    assertEquals("JDBC", protocolsResult.get(0));
    assertEquals("JDBC_METADATA_DAL", getResult.serviceName());
    assertEquals("SQL", protocolsResult.get(1));
    Class<IMetadataDal> expectedServiceClassResult = IMetadataDal.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }

  /**
   * Test {@link MetadataDalPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <p>Method under test: {@link MetadataDalPlugin#createService(String, Properties,
   * ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object MetadataDalPlugin.createService(String, Properties, ConfigManager)"
  })
  void testCreateServiceWithServiceNamePropertiesConfigManager() {
    // Arrange
    MetadataDalPlugin metadataDalPlugin = new MetadataDalPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EPluginNotAvailable.class,
        () -> metadataDalPlugin.createService("Service Name", properties, configManager));
  }

  /**
   * Test new {@link MetadataDalPlugin} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MetadataDalPlugin}
   */
  @Test
  @DisplayName("Test new MetadataDalPlugin (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataDalPlugin.<init>()"})
  void testNewMetadataDalPlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = new MetadataDalPlugin().serviceInfo();
    assertEquals(1, serviceInfoResult.size());
    PluginServiceInfo getResult = serviceInfoResult.get(0);
    List<String> protocolsResult = getResult.protocols();
    assertEquals(2, protocolsResult.size());
    assertEquals("JDBC", protocolsResult.get(0));
    assertEquals("JDBC_METADATA_DAL", getResult.serviceName());
    assertEquals("SQL", protocolsResult.get(1));
    Class<IMetadataDal> expectedServiceClassResult = IMetadataDal.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }
}

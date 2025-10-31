package org.finos.tracdap.svc.meta.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.Test;

class MetadataDalPluginDiffblueTest {
  /**
   * Method under test: {@link MetadataDalPlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("CORE_METADATA", (new MetadataDalPlugin()).pluginName());
  }

  /**
   * Method under test: {@link MetadataDalPlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new MetadataDalPlugin()).serviceInfo();

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
   * Method under test:
   * {@link MetadataDalPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    MetadataDalPlugin metadataDalPlugin = new MetadataDalPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> metadataDalPlugin.createService("Service Name", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MetadataDalPlugin}
   */
  @Test
  void testNewMetadataDalPlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = (new MetadataDalPlugin()).serviceInfo();
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

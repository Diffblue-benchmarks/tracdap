package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.config.ISecretLoader;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.Test;

class LocalConfigPluginDiffblueTest {
  /**
   * Method under test: {@link LocalConfigPlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("LOCAL_CONFIG", (new LocalConfigPlugin()).pluginName());
  }

  /**
   * Method under test: {@link LocalConfigPlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new LocalConfigPlugin()).serviceInfo();

    // Assert
    assertEquals(2, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    assertEquals("FILE_LOADER", getResult.serviceName());
    PluginServiceInfo getResult2 = actualServiceInfoResult.get(1);
    List<String> protocolsResult = getResult2.protocols();
    assertEquals(2, protocolsResult.size());
    assertEquals("JCEKS", protocolsResult.get(1));
    assertEquals("JKS_SECRET_LOADER", getResult2.serviceName());
    List<String> protocolsResult2 = getResult.protocols();
    assertEquals(2, protocolsResult2.size());
    assertEquals("LOCAL", protocolsResult2.get(0));
    assertEquals("file", protocolsResult2.get(1));
    Class<IConfigLoader> expectedServiceClassResult = IConfigLoader.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
    Class<ISecretLoader> expectedServiceClassResult2 = ISecretLoader.class;
    assertEquals(expectedServiceClassResult2, getResult2.serviceClass());
    assertEquals(JksSecretLoader.DEFAULT_KEYSTORE_TYPE, protocolsResult.get(0));
  }

  /**
   * Method under test:
   * {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  void testCreateConfigService() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();

    // Act and Assert
    assertThrows(EPluginNotAvailable.class,
        () -> localConfigPlugin.createConfigService("Service Name", new Properties()));
  }

  /**
   * Method under test:
   * {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  void testCreateConfigService2() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();

    // Act and Assert
    assertTrue(localConfigPlugin.createConfigService("FILE_LOADER", new Properties()) instanceof LocalConfigLoader);
  }

  /**
   * Method under test:
   * {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  void testCreateConfigService3() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();

    // Act
    Object actualCreateConfigServiceResult = localConfigPlugin.createConfigService("JKS_SECRET_LOADER",
        new Properties());

    // Assert
    assertTrue(actualCreateConfigServiceResult instanceof JksSecretLoader);
    assertNull(((JksSecretLoader) actualCreateConfigServiceResult).secretKey);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LocalConfigPlugin}
   */
  @Test
  void testNewLocalConfigPlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = (new LocalConfigPlugin()).serviceInfo();
    assertEquals(2, serviceInfoResult.size());
    PluginServiceInfo getResult = serviceInfoResult.get(0);
    assertEquals("FILE_LOADER", getResult.serviceName());
    PluginServiceInfo getResult2 = serviceInfoResult.get(1);
    List<String> protocolsResult = getResult2.protocols();
    assertEquals(2, protocolsResult.size());
    assertEquals("JCEKS", protocolsResult.get(1));
    assertEquals("JKS_SECRET_LOADER", getResult2.serviceName());
    List<String> protocolsResult2 = getResult.protocols();
    assertEquals(2, protocolsResult2.size());
    assertEquals("LOCAL", protocolsResult2.get(0));
    assertEquals("file", protocolsResult2.get(1));
    Class<IConfigLoader> expectedServiceClassResult = IConfigLoader.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
    Class<ISecretLoader> expectedServiceClassResult2 = ISecretLoader.class;
    assertEquals(expectedServiceClassResult2, getResult2.serviceClass());
    assertEquals(JksSecretLoader.DEFAULT_KEYSTORE_TYPE, protocolsResult.get(0));
  }
}

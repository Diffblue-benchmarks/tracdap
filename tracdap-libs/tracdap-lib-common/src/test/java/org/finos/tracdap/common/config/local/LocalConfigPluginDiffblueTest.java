package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.config.ISecretLoader;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalConfigPluginDiffblueTest {
  /**
   * Test {@link LocalConfigPlugin#pluginName()}.
   * <p>
   * Method under test: {@link LocalConfigPlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LocalConfigPlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("LOCAL_CONFIG", (new LocalConfigPlugin()).pluginName());
  }

  /**
   * Test {@link LocalConfigPlugin#serviceInfo()}.
   * <p>
   * Method under test: {@link LocalConfigPlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalConfigPlugin.serviceInfo()"})
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
   * Test {@link LocalConfigPlugin#createConfigService(String, Properties)} with {@code serviceName}, {@code properties}.
   * <ul>
   *   <li>Then return {@link JksSecretLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(String, Properties) with 'serviceName', 'properties'; then return JksSecretLoader")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LocalConfigPlugin.createConfigService(String, Properties)"})
  void testCreateConfigServiceWithServiceNameProperties_thenReturnJksSecretLoader() {
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
   * Test {@link LocalConfigPlugin#createConfigService(String, Properties)} with {@code serviceName}, {@code properties}.
   * <ul>
   *   <li>Then return {@link LocalConfigLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(String, Properties) with 'serviceName', 'properties'; then return LocalConfigLoader")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LocalConfigPlugin.createConfigService(String, Properties)"})
  void testCreateConfigServiceWithServiceNameProperties_thenReturnLocalConfigLoader() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();

    // Act and Assert
    assertTrue(localConfigPlugin.createConfigService("FILE_LOADER", new Properties()) instanceof LocalConfigLoader);
  }

  /**
   * Test {@link LocalConfigPlugin#createConfigService(String, Properties)} with {@code serviceName}, {@code properties}.
   * <ul>
   *   <li>Then throw {@link EPluginNotAvailable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigPlugin#createConfigService(String, Properties)}
   */
  @Test
  @DisplayName("Test createConfigService(String, Properties) with 'serviceName', 'properties'; then throw EPluginNotAvailable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LocalConfigPlugin.createConfigService(String, Properties)"})
  void testCreateConfigServiceWithServiceNameProperties_thenThrowEPluginNotAvailable() {
    // Arrange
    LocalConfigPlugin localConfigPlugin = new LocalConfigPlugin();

    // Act and Assert
    assertThrows(EPluginNotAvailable.class,
        () -> localConfigPlugin.createConfigService("Service Name", new Properties()));
  }

  /**
   * Test new {@link LocalConfigPlugin} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LocalConfigPlugin}
   */
  @Test
  @DisplayName("Test new LocalConfigPlugin (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalConfigPlugin.<init>()"})
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

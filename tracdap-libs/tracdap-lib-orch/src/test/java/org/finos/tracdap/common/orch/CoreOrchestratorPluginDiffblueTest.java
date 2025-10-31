package org.finos.tracdap.common.orch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.cache.IJobCacheManager;
import org.finos.tracdap.common.cache.local.LocalJobCacheManager;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.Test;

class CoreOrchestratorPluginDiffblueTest {
  /**
   * Method under test: {@link CoreOrchestratorPlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("CORE_ORCHESTRATOR", (new CoreOrchestratorPlugin()).pluginName());
  }

  /**
   * Method under test: {@link CoreOrchestratorPlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new CoreOrchestratorPlugin()).serviceInfo();

    // Assert
    assertEquals(2, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("LOCAL", protocolsResult.get(0));
    PluginServiceInfo getResult2 = actualServiceInfoResult.get(1);
    List<String> protocolsResult2 = getResult2.protocols();
    assertEquals(1, protocolsResult2.size());
    assertEquals("LOCAL", protocolsResult2.get(0));
    assertEquals("LOCAL_EXECUTOR", getResult.serviceName());
    assertEquals("LOCAL_JOB_CACHE", getResult2.serviceName());
    Class<IJobCacheManager> expectedServiceClassResult = IJobCacheManager.class;
    assertEquals(expectedServiceClassResult, getResult2.serviceClass());
    Class<IBatchExecutor> expectedServiceClassResult2 = IBatchExecutor.class;
    assertEquals(expectedServiceClassResult2, getResult.serviceClass());
  }

  /**
   * Method under test:
   * {@link CoreOrchestratorPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    CoreOrchestratorPlugin coreOrchestratorPlugin = new CoreOrchestratorPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> coreOrchestratorPlugin.createService("Service Name", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link CoreOrchestratorPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService2() {
    // Arrange
    CoreOrchestratorPlugin coreOrchestratorPlugin = new CoreOrchestratorPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertTrue(coreOrchestratorPlugin.createService("LOCAL_JOB_CACHE", properties, new ConfigManager(
        "https://example.org/example", workingDir, new PluginManager())) instanceof LocalJobCacheManager);
  }
}

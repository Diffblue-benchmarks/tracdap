package org.finos.tracdap.plugins.gcp.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.finos.tracdap.common.storage.IFileStorage;
import org.junit.jupiter.api.Test;

class GcpStoragePluginDiffblueTest {
  /**
   * Method under test: {@link GcpStoragePlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("GCP_STORAGE", (new GcpStoragePlugin()).pluginName());
  }

  /**
   * Method under test: {@link GcpStoragePlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new GcpStoragePlugin()).serviceInfo();

    // Assert
    assertEquals(1, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    assertEquals("GCS_OBJECT_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("gcs", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }

  /**
   * Method under test:
   * {@link GcpStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    GcpStoragePlugin gcpStoragePlugin = new GcpStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> gcpStoragePlugin.createService("Service", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link GcpStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService2() {
    // Arrange
    GcpStoragePlugin gcpStoragePlugin = new GcpStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = gcpStoragePlugin.createService("GCS_OBJECT_STORAGE", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    CompletionStage<Boolean> existsResult = ((GcsObjectStorage) actualCreateServiceResult).exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(actualCreateServiceResult instanceof GcsObjectStorage);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Method under test:
   * {@link GcpStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService3() {
    // Arrange
    GcpStoragePlugin gcpStoragePlugin = new GcpStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = gcpStoragePlugin.createService("GCS_OBJECT_STORAGE", properties,
        new ConfigManager("1.99*", workingDir, new PluginManager()));

    // Assert
    CompletionStage<Boolean> existsResult = ((GcsObjectStorage) actualCreateServiceResult).exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(actualCreateServiceResult instanceof GcsObjectStorage);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GcpStoragePlugin}
   */
  @Test
  void testNewGcpStoragePlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = (new GcpStoragePlugin()).serviceInfo();
    assertEquals(1, serviceInfoResult.size());
    PluginServiceInfo getResult = serviceInfoResult.get(0);
    assertEquals("GCS_OBJECT_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("gcs", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }
}

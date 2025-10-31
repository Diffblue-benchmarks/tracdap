package org.finos.tracdap.plugins.aws.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AwsStoragePluginDiffblueTest {
  /**
   * Test {@link AwsStoragePlugin#pluginName()}.
   * <p>
   * Method under test: {@link AwsStoragePlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AwsStoragePlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("AWS_STORAGE", (new AwsStoragePlugin()).pluginName());
  }

  /**
   * Test {@link AwsStoragePlugin#serviceInfo()}.
   * <p>
   * Method under test: {@link AwsStoragePlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AwsStoragePlugin.serviceInfo()"})
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new AwsStoragePlugin()).serviceInfo();

    // Assert
    assertEquals(1, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    assertEquals("S3_OBJECT_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("s3", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }

  /**
   * Test {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)} with {@code service}, {@code properties}, {@code configManager}.
   * <p>
   * Method under test: {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'service', 'properties', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AwsStoragePlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServicePropertiesConfigManager() {
    // Arrange
    AwsStoragePlugin awsStoragePlugin = new AwsStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = awsStoragePlugin.createService("S3_OBJECT_STORAGE", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    CompletionStage<Boolean> existsResult = ((S3ObjectStorage) actualCreateServiceResult).exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(actualCreateServiceResult instanceof S3ObjectStorage);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Test {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)} with {@code service}, {@code properties}, {@code configManager}.
   * <p>
   * Method under test: {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'service', 'properties', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AwsStoragePlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServicePropertiesConfigManager2() {
    // Arrange
    AwsStoragePlugin awsStoragePlugin = new AwsStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = awsStoragePlugin.createService("S3_OBJECT_STORAGE", properties,
        new ConfigManager("1.99*", workingDir, new PluginManager()));

    // Assert
    CompletionStage<Boolean> existsResult = ((S3ObjectStorage) actualCreateServiceResult).exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(actualCreateServiceResult instanceof S3ObjectStorage);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Test {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)} with {@code service}, {@code properties}, {@code configManager}.
   * <ul>
   *   <li>Then throw {@link EPluginNotAvailable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'service', 'properties', 'configManager'; then throw EPluginNotAvailable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AwsStoragePlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServicePropertiesConfigManager_thenThrowEPluginNotAvailable() {
    // Arrange
    AwsStoragePlugin awsStoragePlugin = new AwsStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> awsStoragePlugin.createService("Service", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Test new {@link AwsStoragePlugin} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AwsStoragePlugin}
   */
  @Test
  @DisplayName("Test new AwsStoragePlugin (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AwsStoragePlugin.<init>()"})
  void testNewAwsStoragePlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = (new AwsStoragePlugin()).serviceInfo();
    assertEquals(1, serviceInfoResult.size());
    PluginServiceInfo getResult = serviceInfoResult.get(0);
    assertEquals("S3_OBJECT_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("s3", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }
}

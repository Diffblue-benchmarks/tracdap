package org.finos.tracdap.plugins.azure.storage;

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

class AzureStoragePluginDiffblueTest {
  /**
   * Test {@link AzureStoragePlugin#pluginName()}.
   * <p>
   * Method under test: {@link AzureStoragePlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureStoragePlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("AZURE_STORAGE", (new AzureStoragePlugin()).pluginName());
  }

  /**
   * Test {@link AzureStoragePlugin#serviceInfo()}.
   * <p>
   * Method under test: {@link AzureStoragePlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AzureStoragePlugin.serviceInfo()"})
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new AzureStoragePlugin()).serviceInfo();

    // Assert
    assertEquals(1, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    assertEquals("AZURE_BLOB_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("blob", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }

  /**
   * Test {@link AzureStoragePlugin#createService(String, Properties, ConfigManager)} with {@code service}, {@code properties}, {@code configManager}.
   * <p>
   * Method under test: {@link AzureStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'service', 'properties', 'configManager'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AzureStoragePlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServicePropertiesConfigManager() {
    // Arrange
    AzureStoragePlugin azureStoragePlugin = new AzureStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = azureStoragePlugin.createService("AZURE_BLOB_STORAGE", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    CompletionStage<Boolean> existsResult = ((AzureBlobStorage) actualCreateServiceResult).exists("Storage Path", null);
    assertTrue(existsResult instanceof CompletableFuture);
    assertTrue(actualCreateServiceResult instanceof AzureBlobStorage);
    assertTrue(((CompletableFuture<Boolean>) existsResult).isDone());
  }

  /**
   * Test {@link AzureStoragePlugin#createService(String, Properties, ConfigManager)} with {@code service}, {@code properties}, {@code configManager}.
   * <ul>
   *   <li>Then throw {@link EPluginNotAvailable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureStoragePlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName("Test createService(String, Properties, ConfigManager) with 'service', 'properties', 'configManager'; then throw EPluginNotAvailable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AzureStoragePlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServicePropertiesConfigManager_thenThrowEPluginNotAvailable() {
    // Arrange
    AzureStoragePlugin azureStoragePlugin = new AzureStoragePlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> azureStoragePlugin.createService("Service", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Test new {@link AzureStoragePlugin} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AzureStoragePlugin}
   */
  @Test
  @DisplayName("Test new AzureStoragePlugin (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AzureStoragePlugin.<init>()"})
  void testNewAzureStoragePlugin() {
    // Arrange, Act and Assert
    List<PluginServiceInfo> serviceInfoResult = (new AzureStoragePlugin()).serviceInfo();
    assertEquals(1, serviceInfoResult.size());
    PluginServiceInfo getResult = serviceInfoResult.get(0);
    assertEquals("AZURE_BLOB_STORAGE", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("blob", protocolsResult.get(0));
    Class<IFileStorage> expectedServiceClassResult = IFileStorage.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }
}

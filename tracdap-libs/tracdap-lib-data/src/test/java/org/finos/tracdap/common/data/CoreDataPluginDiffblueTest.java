package org.finos.tracdap.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.codec.ICodec;
import org.finos.tracdap.common.codec.arrow.ArrowFileCodec;
import org.finos.tracdap.common.codec.arrow.ArrowStreamCodec;
import org.finos.tracdap.common.codec.csv.CsvCodec;
import org.finos.tracdap.common.codec.json.JsonCodec;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.finos.tracdap.common.storage.IFileStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoreDataPluginDiffblueTest {
  /**
   * Test {@link CoreDataPlugin#pluginName()}.
   *
   * <p>Method under test: {@link CoreDataPlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CoreDataPlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("CORE_DATA", new CoreDataPlugin().pluginName());
  }

  /**
   * Test {@link CoreDataPlugin#serviceInfo()}.
   *
   * <p>Method under test: {@link CoreDataPlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CoreDataPlugin.serviceInfo()"})
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = new CoreDataPlugin().serviceInfo();

    // Assert
    assertEquals(5, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(2);
    assertEquals("ARROW_FILE", getResult.serviceName());
    PluginServiceInfo getResult2 = actualServiceInfoResult.get(1);
    assertEquals("ARROW_STREAM", getResult2.serviceName());
    PluginServiceInfo getResult3 = actualServiceInfoResult.get(3);
    assertEquals("CSV_CODEC", getResult3.serviceName());
    PluginServiceInfo getResult4 = actualServiceInfoResult.get(4);
    assertEquals("JSON_CODEC", getResult4.serviceName());
    PluginServiceInfo getResult5 = actualServiceInfoResult.get(0);
    assertEquals("LOCAL_STORAGE", getResult5.serviceName());
    assertEquals(2, getResult5.protocols().size());
    assertEquals(2, getResult3.protocols().size());
    assertEquals(2, getResult4.protocols().size());
    assertEquals(3, getResult2.protocols().size());
    assertEquals(3, getResult.protocols().size());
    Class<ICodec> expectedServiceClassResult = ICodec.class;
    Class<?> serviceClassResult = getResult2.serviceClass();
    assertEquals(expectedServiceClassResult, serviceClassResult);
    Class<IFileStorage> expectedServiceClassResult2 = IFileStorage.class;
    assertEquals(expectedServiceClassResult2, getResult5.serviceClass());
    assertSame(serviceClassResult, getResult.serviceClass());
    assertSame(serviceClassResult, getResult3.serviceClass());
    assertSame(serviceClassResult, getResult4.serviceClass());
  }

  /**
   * Test {@link CoreDataPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <p>Method under test: {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CoreDataPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EPluginNotAvailable.class,
        () -> coreDataPlugin.createService("Service Name", properties, configManager));
  }

  /**
   * Test {@link CoreDataPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <p>Method under test: {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CoreDataPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager2() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    Object actualCreateServiceResult =
        coreDataPlugin.createService("ARROW_STREAM", properties, configManager);

    // Assert
    assertTrue(actualCreateServiceResult instanceof ArrowStreamCodec);
    assertEquals("arrows", ((ArrowStreamCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((ArrowStreamCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Test {@link CoreDataPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <ul>
   *   <li>Then return {@link ArrowFileCodec}.
   * </ul>
   *
   * <p>Method under test: {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'; then return ArrowFileCodec")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CoreDataPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager_thenReturnArrowFileCodec() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    Object actualCreateServiceResult =
        coreDataPlugin.createService("ARROW_FILE", properties, configManager);

    // Assert
    assertTrue(actualCreateServiceResult instanceof ArrowFileCodec);
    assertEquals("arrow", ((ArrowFileCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((ArrowFileCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Test {@link CoreDataPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <ul>
   *   <li>Then return {@link CsvCodec}.
   * </ul>
   *
   * <p>Method under test: {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'; then return CsvCodec")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CoreDataPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager_thenReturnCsvCodec() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    Object actualCreateServiceResult =
        coreDataPlugin.createService("CSV_CODEC", properties, configManager);

    // Assert
    assertTrue(actualCreateServiceResult instanceof CsvCodec);
    assertEquals("csv", ((CsvCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((CsvCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Test {@link CoreDataPlugin#createService(String, Properties, ConfigManager)} with {@code
   * serviceName}, {@code properties}, {@code configManager}.
   *
   * <ul>
   *   <li>Then return {@link JsonCodec}.
   * </ul>
   *
   * <p>Method under test: {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test createService(String, Properties, ConfigManager) with 'serviceName', 'properties', 'configManager'; then return JsonCodec")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CoreDataPlugin.createService(String, Properties, ConfigManager)"})
  void testCreateServiceWithServiceNamePropertiesConfigManager_thenReturnJsonCodec() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    Object actualCreateServiceResult =
        coreDataPlugin.createService("JSON_CODEC", properties, configManager);

    // Assert
    assertTrue(actualCreateServiceResult instanceof JsonCodec);
    assertEquals("json", ((JsonCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((JsonCodec) actualCreateServiceResult).options().isEmpty());
  }
}

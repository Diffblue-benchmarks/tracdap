package org.finos.tracdap.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.Test;

class CoreDataPluginDiffblueTest {
  /**
   * Method under test: {@link CoreDataPlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("CORE_DATA", (new CoreDataPlugin()).pluginName());
  }

  /**
   * Method under test: {@link CoreDataPlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new CoreDataPlugin()).serviceInfo();

    // Assert
    assertEquals(5, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(2);
    List<String> protocolsResult = getResult.protocols();
    assertEquals(3, protocolsResult.size());
    assertEquals("ARROW_FILE", protocolsResult.get(0));
    assertEquals("ARROW_FILE", getResult.serviceName());
    PluginServiceInfo getResult2 = actualServiceInfoResult.get(1);
    List<String> protocolsResult2 = getResult2.protocols();
    assertEquals(3, protocolsResult2.size());
    assertEquals("ARROW_STREAM", protocolsResult2.get(0));
    assertEquals("ARROW_STREAM", getResult2.serviceName());
    PluginServiceInfo getResult3 = actualServiceInfoResult.get(3);
    List<String> protocolsResult3 = getResult3.protocols();
    assertEquals(2, protocolsResult3.size());
    assertEquals("CSV", protocolsResult3.get(0));
    assertEquals("CSV_CODEC", getResult3.serviceName());
    PluginServiceInfo getResult4 = actualServiceInfoResult.get(4);
    List<String> protocolsResult4 = getResult4.protocols();
    assertEquals(2, protocolsResult4.size());
    assertEquals("JSON", protocolsResult4.get(0));
    assertEquals("JSON_CODEC", getResult4.serviceName());
    PluginServiceInfo getResult5 = actualServiceInfoResult.get(0);
    List<String> protocolsResult5 = getResult5.protocols();
    assertEquals(2, protocolsResult5.size());
    assertEquals("LOCAL", protocolsResult5.get(0));
    assertEquals("LOCAL_STORAGE", getResult5.serviceName());
    assertEquals("application/vnd.apache.arrow.file", protocolsResult.get(1));
    assertEquals("application/vnd.apache.arrow.stream", protocolsResult2.get(1));
    assertEquals("application/x-apache-arrow-file", protocolsResult.get(2));
    assertEquals("application/x-apache-arrow-stream", protocolsResult2.get(2));
    assertEquals("file", protocolsResult5.get(1));
    assertEquals("text/csv", protocolsResult3.get(1));
    assertEquals("text/json", protocolsResult4.get(1));
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
   * Method under test:
   * {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> coreDataPlugin.createService("Service Name", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test:
   * {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService2() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = coreDataPlugin.createService("ARROW_FILE", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    assertTrue(actualCreateServiceResult instanceof ArrowFileCodec);
    assertEquals("arrow", ((ArrowFileCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((ArrowFileCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Method under test:
   * {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService3() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = coreDataPlugin.createService("ARROW_STREAM", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    assertTrue(actualCreateServiceResult instanceof ArrowStreamCodec);
    assertEquals("arrows", ((ArrowStreamCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((ArrowStreamCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Method under test:
   * {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService4() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = coreDataPlugin.createService("CSV_CODEC", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    assertTrue(actualCreateServiceResult instanceof CsvCodec);
    assertEquals("csv", ((CsvCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((CsvCodec) actualCreateServiceResult).options().isEmpty());
  }

  /**
   * Method under test:
   * {@link CoreDataPlugin#createService(String, Properties, ConfigManager)}
   */
  @Test
  void testCreateService5() {
    // Arrange
    CoreDataPlugin coreDataPlugin = new CoreDataPlugin();
    Properties properties = new Properties();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Object actualCreateServiceResult = coreDataPlugin.createService("JSON_CODEC", properties,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    assertTrue(actualCreateServiceResult instanceof JsonCodec);
    assertEquals("json", ((JsonCodec) actualCreateServiceResult).defaultFileExtension());
    assertTrue(((JsonCodec) actualCreateServiceResult).options().isEmpty());
  }
}

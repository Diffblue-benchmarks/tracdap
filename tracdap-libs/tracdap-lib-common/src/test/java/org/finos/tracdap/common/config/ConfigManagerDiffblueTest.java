package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Message;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.IPluginManager;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class ConfigManagerDiffblueTest {
  /**
   * Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  void testPrepareSecrets() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).prepareSecrets());
  }

  /**
   * Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  void testPrepareSecrets2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> (new ConfigManager("/", workingDir, new PluginManager())).prepareSecrets());
  }

  /**
   * Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  void testGetUserDb() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).getUserDb());
  }

  /**
   * Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  void testGetUserDb2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> (new ConfigManager("/", workingDir, new PluginManager())).getUserDb());
  }

  /**
   * Method under test: {@link ConfigManager#configRoot()}
   */
  @Test
  void testConfigRoot() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/",
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("https://example.org/example"));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("/"));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("\\"));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig4() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig(":\\"));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig5() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("file"));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig6() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig(null));
  }

  /**
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  void testLoadBinaryConfig7() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadBinaryConfig(""));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig("https://example.org/example"));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig("/"));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig("\\"));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig4() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig(":\\"));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig5() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig("file"));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig6() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig(null));
  }

  /**
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  void testLoadTextConfig7() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig(""));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("https://example.org/example", configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject4() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject5() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject6() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  void testLoadConfigObject7() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("", configClass));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject8() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> configManager.loadConfigObject("https://example.org/example", configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject9() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject10() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject11() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject12() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject13() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass, true));
  }

  /**
   * Method under test:
   * {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  void testLoadConfigObject14() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("", configClass, true));
  }

  /**
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  void testLoadRootConfigObject() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  void testLoadRootConfigObject2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass));
  }

  /**
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  void testLoadRootConfigObject3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass, true));
  }

  /**
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  void testLoadRootConfigObject4() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass, true));
  }

  /**
   * Method under test: {@link ConfigManager#hasSecret(String)}
   */
  @Test
  void testHasSecret() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertFalse(
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).hasSecret("Secret Name"));
  }

  /**
   * Method under test: {@link ConfigManager#loadPassword(String)}
   */
  @Test
  void testLoadPassword() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPassword("Secret Name"));
  }

  /**
   * Method under test: {@link ConfigManager#loadPublicKey(String)}
   */
  @Test
  void testLoadPublicKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPublicKey("Secret Name"));
  }

  /**
   * Method under test: {@link ConfigManager#loadPrivateKey(String)}
   */
  @Test
  void testLoadPrivateKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPrivateKey("Secret Name"));
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  void testNewConfigManager() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/",
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  void testNewConfigManager2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("file:/", (new ConfigManager("/", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  void testNewConfigManager3() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager = new ConfigManager("file", workingDir, new PluginManager());

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString().concat(File.separator));
    assertEquals(expectedToStringResult, actualConfigManager.configRoot().toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  void testNewConfigManager4() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager(null, workingDir, new PluginManager()));

  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  void testNewConfigManager5() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager("", workingDir, new PluginManager()));

  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  void testNewConfigManager6() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/", (new ConfigManager("https://example.org/example", workingDir,
        new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")).configRoot().toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  void testNewConfigManager7() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("file:/",
        (new ConfigManager("/", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"))
            .configRoot()
            .toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  void testNewConfigManager8() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager = new ConfigManager("file", workingDir, new PluginManager(),
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString().concat(File.separator));
    assertEquals(expectedToStringResult, actualConfigManager.configRoot().toString());
  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  void testNewConfigManager9() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> new ConfigManager(null, workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));

  }

  /**
   * Method under test:
   * {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  void testNewConfigManager10() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> new ConfigManager("", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));

  }
}

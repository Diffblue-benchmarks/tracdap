package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Message;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.IPluginManager;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigManagerDiffblueTest {
  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager() {
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
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager2() {
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
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   * <ul>
   *   <li>Then return configRoot toString is {@code https://example.org/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager); then return configRoot toString is 'https://example.org/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_thenReturnConfigRootToStringIsHttpsExampleOrg() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/",
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   * <ul>
   *   <li>Then return configRoot toString is {@code https://example.org/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String); then return configRoot toString is 'https://example.org/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_thenReturnConfigRootToStringIsHttpsExampleOrg2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/", (new ConfigManager("https://example.org/example", workingDir,
        new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")).configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager); when empty string; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenEmptyString_thenThrowEConfigLoad() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager("", workingDir, new PluginManager()));

  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String); when empty string; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenEmptyString_thenThrowEConfigLoad2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> new ConfigManager("", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));

  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager); when 'null'; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenNull_thenThrowEConfigLoad() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager(null, workingDir, new PluginManager()));

  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String); when 'null'; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenNull_thenThrowEConfigLoad2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> new ConfigManager(null, workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));

  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return configRoot toString is {@code file:/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager); when '/'; then return configRoot toString is 'file:/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenSlash_thenReturnConfigRootToStringIsFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("file:/", (new ConfigManager("/", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return configRoot toString is {@code file:/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String); when '/'; then return configRoot toString is 'file:/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenSlash_thenReturnConfigRootToStringIsFile2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("file:/",
        (new ConfigManager("/", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"))
            .configRoot()
            .toString());
  }

  /**
   * Test {@link ConfigManager#prepareSecrets()}.
   * <p>
   * Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  @DisplayName("Test prepareSecrets()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.prepareSecrets()"})
  void testPrepareSecrets() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).prepareSecrets());
  }

  /**
   * Test {@link ConfigManager#prepareSecrets()}.
   * <p>
   * Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  @DisplayName("Test prepareSecrets()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigManager.prepareSecrets()"})
  void testPrepareSecrets2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> (new ConfigManager("/", workingDir, new PluginManager())).prepareSecrets());
  }

  /**
   * Test {@link ConfigManager#getUserDb()}.
   * <p>
   * Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  @DisplayName("Test getUserDb()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.config.ISecretLoader ConfigManager.getUserDb()"})
  void testGetUserDb() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).getUserDb());
  }

  /**
   * Test {@link ConfigManager#getUserDb()}.
   * <p>
   * Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  @DisplayName("Test getUserDb()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.config.ISecretLoader ConfigManager.getUserDb()"})
  void testGetUserDb2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> (new ConfigManager("/", workingDir, new PluginManager())).getUserDb());
  }

  /**
   * Test {@link ConfigManager#configRoot()}.
   * <p>
   * Method under test: {@link ConfigManager#configRoot()}
   */
  @Test
  @DisplayName("Test configRoot()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"URI ConfigManager.configRoot()"})
  void testConfigRoot() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertEquals("https://example.org/",
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#resolveConfigFile(URI)}.
   * <p>
   * Method under test: {@link ConfigManager#resolveConfigFile(URI)}
   */
  @Test
  @DisplayName("Test resolveConfigFile(URI)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"URI ConfigManager.resolveConfigFile(URI)"})
  void testResolveConfigFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    URI relativePath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertSame(relativePath, (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
        .resolveConfigFile(relativePath));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when '\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("\\"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code :\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when ':\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig(":\\"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenEmptyString() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadBinaryConfig(""));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code file}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'file'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("file"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("https://example.org/example"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig(null));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadBinaryConfig("/"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when '\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig("\\"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code :\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when ':\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig(":\\"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenEmptyString() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig(""));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code file}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'file'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig("file"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadTextConfig("https://example.org/example"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig(null));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).loadTextConfig("/"));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when '\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code :\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when ':\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenEmptyString() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code file}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'file'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class,
        () -> configManager.loadConfigObject("https://example.org/example", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl}, {@code configClass}, {@code leniency}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when '\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code :\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when ':\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenEmptyString() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code file}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'file'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("https://example.org/example", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code configClass}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class)} with {@code configClass}.
   * <p>
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class) with 'configClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class)"})
  void testLoadRootConfigObjectWithConfigClass() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class)} with {@code configClass}.
   * <p>
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class) with 'configClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class)"})
  void testLoadRootConfigObjectWithConfigClass2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class, boolean)} with {@code configClass}, {@code leniency}.
   * <p>
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class, boolean) with 'configClass', 'leniency'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class, boolean)"})
  void testLoadRootConfigObjectWithConfigClassLeniency() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class, boolean)} with {@code configClass}, {@code leniency}.
   * <p>
   * Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class, boolean) with 'configClass', 'leniency'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class, boolean)"})
  void testLoadRootConfigObjectWithConfigClassLeniency2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass, true));
  }

  /**
   * Test {@link ConfigManager#hasSecret(String)}.
   * <p>
   * Method under test: {@link ConfigManager#hasSecret(String)}
   */
  @Test
  @DisplayName("Test hasSecret(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConfigManager.hasSecret(String)"})
  void testHasSecret() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertFalse(
        (new ConfigManager("https://example.org/example", workingDir, new PluginManager())).hasSecret("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPassword(String)}.
   * <p>
   * Method under test: {@link ConfigManager#loadPassword(String)}
   */
  @Test
  @DisplayName("Test loadPassword(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigManager.loadPassword(String)"})
  void testLoadPassword() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPassword("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPublicKey(String)}.
   * <p>
   * Method under test: {@link ConfigManager#loadPublicKey(String)}
   */
  @Test
  @DisplayName("Test loadPublicKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey ConfigManager.loadPublicKey(String)"})
  void testLoadPublicKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPublicKey("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPrivateKey(String)}.
   * <p>
   * Method under test: {@link ConfigManager#loadPrivateKey(String)}
   */
  @Test
  @DisplayName("Test loadPrivateKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey ConfigManager.loadPrivateKey(String)"})
  void testLoadPrivateKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new ConfigManager("https://example.org/example", workingDir, new PluginManager()))
            .loadPrivateKey("Secret Name"));
  }
}

package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager = new ConfigManager("file", workingDir, new PluginManager());

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            "file:",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                .toString()
                .concat(File.separator));
    assertEquals(expectedToStringResult, actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName("Test new ConfigManager(String, Path, IPluginManager, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager =
        new ConfigManager(
            "file", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            "file:",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                .toString()
                .concat(File.separator));
    assertEquals(expectedToStringResult, actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   *
   * <ul>
   *   <li>Then return configRoot toString is {@code https://example.org/}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager); then return configRoot toString is 'https://example.org/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_thenReturnConfigRootToStringIsHttpsExampleOrg() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "/");

    // Act
    ConfigManager actualConfigManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Assert
    assertEquals("https://example.org/", actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   *
   * <ul>
   *   <li>Then return configRoot toString is {@code https://example.org/}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager, String); then return configRoot toString is 'https://example.org/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_thenReturnConfigRootToStringIsHttpsExampleOrg2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager =
        new ConfigManager(
            "https://example.org/example",
            workingDir,
            new PluginManager(),
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Assert
    assertEquals("https://example.org/", actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link EConfigLoad}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager); when empty string; then throw EConfigLoad")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenEmptyString_thenThrowEConfigLoad() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager("", workingDir, new PluginManager()));
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link EConfigLoad}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager, String); when empty string; then throw EConfigLoad")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenEmptyString_thenThrowEConfigLoad2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(
        EConfigLoad.class,
        () ->
            new ConfigManager(
                "", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link EConfigLoad}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager); when 'null'; then throw EConfigLoad")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenNull_thenThrowEConfigLoad() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> new ConfigManager(null, workingDir, new PluginManager()));
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link EConfigLoad}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager, String); when 'null'; then throw EConfigLoad")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenNull_thenThrowEConfigLoad2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(
        EConfigLoad.class,
        () ->
            new ConfigManager(
                null, workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return configRoot toString is {@code file:/}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager); when '/'; then return configRoot toString is 'file:/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager)"})
  void testNewConfigManager_whenSlash_thenReturnConfigRootToStringIsFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager = new ConfigManager("/", workingDir, new PluginManager());

    // Assert
    assertEquals("file:/", actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return configRoot toString is {@code file:/}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#ConfigManager(String, Path, IPluginManager, String)}
   */
  @Test
  @DisplayName(
      "Test new ConfigManager(String, Path, IPluginManager, String); when '/'; then return configRoot toString is 'file:/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.<init>(String, Path, IPluginManager, String)"})
  void testNewConfigManager_whenSlash_thenReturnConfigRootToStringIsFile2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    ConfigManager actualConfigManager =
        new ConfigManager(
            "/", workingDir, new PluginManager(), "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Assert
    assertEquals("file:/", actualConfigManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#prepareSecrets()}.
   *
   * <p>Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  @DisplayName("Test prepareSecrets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.prepareSecrets()"})
  void testPrepareSecrets() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.prepareSecrets());
  }

  /**
   * Test {@link ConfigManager#prepareSecrets()}.
   *
   * <p>Method under test: {@link ConfigManager#prepareSecrets()}
   */
  @Test
  @DisplayName("Test prepareSecrets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigManager.prepareSecrets()"})
  void testPrepareSecrets2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.prepareSecrets());
  }

  /**
   * Test {@link ConfigManager#getUserDb()}.
   *
   * <p>Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  @DisplayName("Test getUserDb()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.tracdap.common.config.ISecretLoader ConfigManager.getUserDb()"})
  void testGetUserDb() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.getUserDb());
  }

  /**
   * Test {@link ConfigManager#getUserDb()}.
   *
   * <p>Method under test: {@link ConfigManager#getUserDb()}
   */
  @Test
  @DisplayName("Test getUserDb()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.tracdap.common.config.ISecretLoader ConfigManager.getUserDb()"})
  void testGetUserDb2() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("/", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.getUserDb());
  }

  /**
   * Test {@link ConfigManager#configRoot()}.
   *
   * <p>Method under test: {@link ConfigManager#configRoot()}
   */
  @Test
  @DisplayName("Test configRoot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI ConfigManager.configRoot()"})
  void testConfigRoot() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertEquals("https://example.org/", configManager.configRoot().toString());
  }

  /**
   * Test {@link ConfigManager#resolveConfigFile(URI)}.
   *
   * <p>Method under test: {@link ConfigManager#resolveConfigFile(URI)}
   */
  @Test
  @DisplayName("Test resolveConfigFile(URI)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI ConfigManager.resolveConfigFile(URI)"})
  void testResolveConfigFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    URI relativePath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    URI actualResolveConfigFileResult = configManager.resolveConfigFile(relativePath);

    // Assert
    assertSame(relativePath, actualResolveConfigFileResult);
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when '\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig("\\"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code :\}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when ':\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig(":\\"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code file}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'file'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig("file"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EConfigLoad.class, () -> configManager.loadBinaryConfig("https://example.org/example"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig(null));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig("/"));
  }

  /**
   * Test {@link ConfigManager#loadBinaryConfig(String)}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadBinaryConfig(String)}
   */
  @Test
  @DisplayName("Test loadBinaryConfig(String); when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigManager.loadBinaryConfig(String)"})
  void testLoadBinaryConfig_whenSpace() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadBinaryConfig(" "));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when '\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig("\\"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code :\}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when ':\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig(":\\"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code file}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'file'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig("file"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(
        EConfigLoad.class, () -> configManager.loadTextConfig("https://example.org/example"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig(null));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig("/"));
  }

  /**
   * Test {@link ConfigManager#loadTextConfig(String)}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadTextConfig(String)}
   */
  @Test
  @DisplayName("Test loadTextConfig(String); when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadTextConfig(String)"})
  void testLoadTextConfig_whenSpace() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadTextConfig(" "));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when '\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code :\}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when ':\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code file}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'file'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(
        EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(
        EConfigLoad.class,
        () -> configManager.loadConfigObject("https://example.org/example", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class, boolean)} with {@code configUrl},
   * {@code configClass}, {@code leniency}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class, boolean) with 'configUrl', 'configClass', 'leniency'; when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class, boolean)"})
  void testLoadConfigObjectWithConfigUrlConfigClassLeniency_whenSpace() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(" ", configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when '\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("\\", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code :\}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when ':\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenColonBackslash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(":\\", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code file}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'file'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("file", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName(
      "Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenHttpsExampleOrgExample() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(
        EConfigLoad.class,
        () -> configManager.loadConfigObject("https://example.org/example", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenNull() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(null, configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenSlash() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject("/", configClass));
  }

  /**
   * Test {@link ConfigManager#loadConfigObject(String, Class)} with {@code configUrl}, {@code
   * configClass}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link ConfigManager#loadConfigObject(String, Class)}
   */
  @Test
  @DisplayName("Test loadConfigObject(String, Class) with 'configUrl', 'configClass'; when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadConfigObject(String, Class)"})
  void testLoadConfigObjectWithConfigUrlConfigClass_whenSpace() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadConfigObject(" ", configClass));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class)} with {@code configClass}.
   *
   * <p>Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class) with 'configClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class)"})
  void testLoadRootConfigObjectWithConfigClass() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class)} with {@code configClass}.
   *
   * <p>Method under test: {@link ConfigManager#loadRootConfigObject(Class)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class) with 'configClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ConfigManager#loadRootConfigObject(Class, boolean)} with {@code configClass},
   * {@code leniency}.
   *
   * <p>Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class, boolean) with 'configClass', 'leniency'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigManager.loadRootConfigObject(Class, boolean)"})
  void testLoadRootConfigObjectWithConfigClassLeniency() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EConfigLoad.class, () -> configManager.loadRootConfigObject(configClass, true));
  }

  /**
   * Test {@link ConfigManager#loadRootConfigObject(Class, boolean)} with {@code configClass},
   * {@code leniency}.
   *
   * <p>Method under test: {@link ConfigManager#loadRootConfigObject(Class, boolean)}
   */
  @Test
  @DisplayName("Test loadRootConfigObject(Class, boolean) with 'configClass', 'leniency'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link ConfigManager#hasSecret(String)}
   */
  @Test
  @DisplayName("Test hasSecret(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConfigManager.hasSecret(String)"})
  void testHasSecret() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertFalse(configManager.hasSecret("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPassword(String)}.
   *
   * <p>Method under test: {@link ConfigManager#loadPassword(String)}
   */
  @Test
  @DisplayName("Test loadPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigManager.loadPassword(String)"})
  void testLoadPassword() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> configManager.loadPassword("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPublicKey(String)}.
   *
   * <p>Method under test: {@link ConfigManager#loadPublicKey(String)}
   */
  @Test
  @DisplayName("Test loadPublicKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PublicKey ConfigManager.loadPublicKey(String)"})
  void testLoadPublicKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> configManager.loadPublicKey("Secret Name"));
  }

  /**
   * Test {@link ConfigManager#loadPrivateKey(String)}.
   *
   * <p>Method under test: {@link ConfigManager#loadPrivateKey(String)}
   */
  @Test
  @DisplayName("Test loadPrivateKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey ConfigManager.loadPrivateKey(String)"})
  void testLoadPrivateKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> configManager.loadPrivateKey("Secret Name"));
  }
}

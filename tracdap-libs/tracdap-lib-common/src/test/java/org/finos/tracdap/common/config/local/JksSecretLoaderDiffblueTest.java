package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JksSecretLoaderDiffblueTest {
  @InjectMocks private JksSecretLoader jksSecretLoader;

  @Mock private Properties properties;

  /**
   * Test {@link JksSecretLoader#JksSecretLoader(Properties)}.
   *
   * <p>Method under test: {@link JksSecretLoader#JksSecretLoader(Properties)}
   */
  @Test
  @DisplayName("Test new JksSecretLoader(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JksSecretLoader.<init>(Properties)"})
  void testNewJksSecretLoader() {
    // Arrange, Act and Assert
    assertNull(new JksSecretLoader(new Properties()).secretKey);
  }

  /**
   * Test {@link JksSecretLoader#init(ConfigManager)}.
   *
   * <ul>
   *   <li>Given {@link JksSecretLoader#JksSecretLoader(Properties)} with properties is {@link
   *       Properties#Properties()}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test init(ConfigManager); given JksSecretLoader(Properties) with properties is Properties(); then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JksSecretLoader.init(ConfigManager)"})
  void testInit_givenJksSecretLoaderWithPropertiesIsProperties_thenThrowEStartup() {
    // Arrange
    JksSecretLoader jksSecretLoader = new JksSecretLoader(new Properties());
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> jksSecretLoader.init(configManager));
  }

  /**
   * Test {@link JksSecretLoader#init(ConfigManager)}.
   *
   * <ul>
   *   <li>Given {@link Properties} {@link Properties#getProperty(String, String)} return {@code
   *       Property}.
   *   <li>Then calls {@link Properties#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test init(ConfigManager); given Properties getProperty(String, String) return 'Property'; then calls getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JksSecretLoader.init(ConfigManager)"})
  void testInit_givenPropertiesGetPropertyReturnProperty_thenCallsGetProperty() {
    // Arrange
    when(properties.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(properties.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> jksSecretLoader.init(configManager));
    verify(properties, atLeast(1)).getProperty(Mockito.<String>any());
    verify(properties).getProperty("secret.type", "PKCS12");
  }

  /**
   * Test {@link JksSecretLoader#init(ConfigManager)}.
   *
   * <ul>
   *   <li>Given {@link Properties} {@link Properties#getProperty(String)} return space.
   *   <li>Then calls {@link Properties#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test init(ConfigManager); given Properties getProperty(String) return space; then calls getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JksSecretLoader.init(ConfigManager)"})
  void testInit_givenPropertiesGetPropertyReturnSpace_thenCallsGetProperty() {
    // Arrange
    when(properties.getProperty(Mockito.<String>any())).thenReturn(" ");
    when(properties.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> jksSecretLoader.init(configManager));
    verify(properties, atLeast(1)).getProperty(Mockito.<String>any());
    verify(properties).getProperty("secret.type", "PKCS12");
  }

  /**
   * Test {@link JksSecretLoader#init(ConfigManager)}.
   *
   * <ul>
   *   <li>Given {@link Properties} {@link Properties#getProperty(String, String)} throw
   *       quietShutdown twenty.
   *   <li>Then calls {@link Properties#getProperty(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  @DisplayName(
      "Test init(ConfigManager); given Properties getProperty(String, String) throw quietShutdown twenty; then calls getProperty(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JksSecretLoader.init(ConfigManager)"})
  void testInit_givenPropertiesGetPropertyThrowQuietShutdownTwenty_thenCallsGetProperty() {
    // Arrange
    when(properties.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(EStartup.quietShutdown(20));
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act and Assert
    assertThrows(EStartup.class, () -> jksSecretLoader.init(configManager));
    verify(properties).getProperty("secret.type", "PKCS12");
  }
}

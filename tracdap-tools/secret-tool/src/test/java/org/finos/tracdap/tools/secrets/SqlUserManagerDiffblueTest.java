package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.EAuthorization;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlUserManagerDiffblueTest {
  /**
   * Test {@link SqlUserManager#SqlUserManager(ConfigManager)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigManager#prepareSecrets()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlUserManager#SqlUserManager(ConfigManager)}
   */
  @Test
  @DisplayName("Test new SqlUserManager(ConfigManager); then calls prepareSecrets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlUserManager.<init>(ConfigManager)"})
  void testNewSqlUserManager_thenCallsPrepareSecrets() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    ConfigManager configManager = mock(ConfigManager.class);
    doNothing().when(configManager).prepareSecrets();

    // Act
    new SqlUserManager(configManager);

    // Assert
    verify(configManager).prepareSecrets();
  }

  /**
   * Test {@link SqlUserManager#SqlUserManager(ConfigManager)}.
   *
   * <ul>
   *   <li>Then throw {@link EAuthorization}.
   * </ul>
   *
   * <p>Method under test: {@link SqlUserManager#SqlUserManager(ConfigManager)}
   */
  @Test
  @DisplayName("Test new SqlUserManager(ConfigManager); then throw EAuthorization")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlUserManager.<init>(ConfigManager)"})
  void testNewSqlUserManager_thenThrowEAuthorization() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(
            eq(IConfigLoader.class), Mockito.<String>any(), Mockito.<Properties>any()))
        .thenThrow(new EAuthorization("Not all who wander are lost"));
    when(plugins.isServiceAvailable(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, plugins);

    // Act and Assert
    assertThrows(EAuthorization.class, () -> new SqlUserManager(configManager));
    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }
}

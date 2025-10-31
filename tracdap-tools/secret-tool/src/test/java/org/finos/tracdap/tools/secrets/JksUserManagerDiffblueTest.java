package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.ETracPublic;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JksUserManagerDiffblueTest {
  /**
   * Method under test: {@link JksUserManager#addUser(String, String, String)}
   */
  @Test
  void testAddUser() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = mock(ConfigManager.class);
    when(configManager.loadRootConfigObject(Mockito.<Class<PlatformConfig>>any()))
        .thenReturn(PlatformConfig.getDefaultInstance());
    doNothing().when(configManager).prepareSecrets();

    // Act and Assert
    assertThrows(ETracPublic.class,
        () -> (new JksUserManager(configManager)).addUser("42", "janedoe", "Password Hash"));
    verify(configManager).loadRootConfigObject(isA(Class.class));
    verify(configManager).prepareSecrets();
  }

  /**
   * Method under test: {@link JksUserManager#addUser(String, String, String)}
   */
  @Test
  void testAddUser2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "displayName");
    ConfigManager configManager = mock(ConfigManager.class);
    when(configManager.loadRootConfigObject(Mockito.<Class<PlatformConfig>>any()))
        .thenReturn(PlatformConfig.getDefaultInstance());
    doNothing().when(configManager).prepareSecrets();

    // Act and Assert
    assertThrows(ETracPublic.class,
        () -> (new JksUserManager(configManager)).addUser("42", "janedoe", "Password Hash"));
    verify(configManager).loadRootConfigObject(isA(Class.class));
    verify(configManager).prepareSecrets();
  }

  /**
   * Method under test: {@link JksUserManager#deleteUser(String)}
   */
  @Test
  void testDeleteUser() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = mock(ConfigManager.class);
    when(configManager.loadRootConfigObject(Mockito.<Class<PlatformConfig>>any()))
        .thenReturn(PlatformConfig.getDefaultInstance());
    doNothing().when(configManager).prepareSecrets();

    // Act and Assert
    assertThrows(ETracPublic.class, () -> (new JksUserManager(configManager)).deleteUser("42"));
    verify(configManager).loadRootConfigObject(isA(Class.class));
    verify(configManager).prepareSecrets();
  }

  /**
   * Method under test: {@link JksUserManager#JksUserManager(ConfigManager)}
   */
  @Test
  void testNewJksUserManager() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(Mockito.<Class<IConfigLoader>>any(), Mockito.<String>any(),
        Mockito.<Properties>any())).thenThrow(new ETracPublic("Not all who wander are lost"));
    when(plugins.isServiceAvailable(Mockito.<Class<Object>>any(), Mockito.<String>any())).thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(ETracPublic.class, () -> new JksUserManager(new ConfigManager("https://example.org/example",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins)));
    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }

  /**
   * Method under test: {@link JksUserManager#JksUserManager(ConfigManager)}
   */
  @Test
  void testNewJksUserManager2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = mock(ConfigManager.class);
    doNothing().when(configManager).prepareSecrets();

    // Act
    new JksUserManager(configManager);

    // Assert
    verify(configManager).prepareSecrets();
  }
}

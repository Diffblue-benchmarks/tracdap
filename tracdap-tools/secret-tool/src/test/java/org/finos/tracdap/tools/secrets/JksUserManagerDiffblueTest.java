package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.ETracPublic;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JksUserManagerDiffblueTest {
  /**
   * Test {@link JksUserManager#JksUserManager(ConfigManager)}.
   * <ul>
   *   <li>Then calls {@link ConfigManager#prepareSecrets()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JksUserManager#JksUserManager(ConfigManager)}
   */
  @Test
  @DisplayName("Test new JksUserManager(ConfigManager); then calls prepareSecrets()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JksUserManager.<init>(ConfigManager)"})
  void testNewJksUserManager_thenCallsPrepareSecrets() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = mock(ConfigManager.class);
    doNothing().when(configManager).prepareSecrets();

    // Act
    new JksUserManager(configManager);

    // Assert
    verify(configManager).prepareSecrets();
  }

  /**
   * Test {@link JksUserManager#JksUserManager(ConfigManager)}.
   * <ul>
   *   <li>Then throw {@link ETracPublic}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JksUserManager#JksUserManager(ConfigManager)}
   */
  @Test
  @DisplayName("Test new JksUserManager(ConfigManager); then throw ETracPublic")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JksUserManager.<init>(ConfigManager)"})
  void testNewJksUserManager_thenThrowETracPublic() {
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
}

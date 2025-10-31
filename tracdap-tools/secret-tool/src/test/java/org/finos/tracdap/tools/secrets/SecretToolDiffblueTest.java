package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SecretToolDiffblueTest {
  /**
   * Test {@link SecretTool#SecretTool(ConfigManager, String)}.
   * <ul>
   *   <li>Given quietShutdown one.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecretTool#SecretTool(ConfigManager, String)}
   */
  @Test
  @DisplayName("Test new SecretTool(ConfigManager, String); given quietShutdown one; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SecretTool.<init>(ConfigManager, String)"})
  void testNewSecretTool_givenQuietShutdownOne_thenThrowEStartup() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(Mockito.<Class<IConfigLoader>>any(), Mockito.<String>any(),
        Mockito.<Properties>any())).thenThrow(EStartup.quietShutdown(1));
    when(plugins.isServiceAvailable(Mockito.<Class<Object>>any(), Mockito.<String>any())).thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(EStartup.class,
        () -> new SecretTool(
            new ConfigManager("https://example.org/example",
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins),
            "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));

    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }
}

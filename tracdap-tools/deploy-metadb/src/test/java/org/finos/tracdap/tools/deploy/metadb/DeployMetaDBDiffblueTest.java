package org.finos.tracdap.tools.deploy.metadb;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeployMetaDBDiffblueTest {
  /**
   * Method under test: {@link DeployMetaDB#DeployMetaDB(ConfigManager)}
   */
  @Test
  void testNewDeployMetaDB() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());

    // Act
    new DeployMetaDB(new ConfigManager("https://example.org/example",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins));

    // Assert
    verify(plugins).getExtensions();
  }

  /**
   * Method under test: {@link DeployMetaDB#runDeployment(List)}
   */
  @Test
  void testRunDeployment() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(Mockito.<Class<IConfigLoader>>any(), Mockito.<String>any(),
        Mockito.<Properties>any())).thenThrow(EStartup.quietShutdown(1));
    when(plugins.isServiceAvailable(Mockito.<Class<Object>>any(), Mockito.<String>any())).thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());
    DeployMetaDB deployMetaDB = new DeployMetaDB(new ConfigManager("https://example.org/example",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins));

    // Act and Assert
    assertThrows(EStartup.class, () -> deployMetaDB.runDeployment(new ArrayList<>()));
    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }
}

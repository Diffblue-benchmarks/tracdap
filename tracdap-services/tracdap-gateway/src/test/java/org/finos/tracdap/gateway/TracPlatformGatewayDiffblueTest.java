package org.finos.tracdap.gateway;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class TracPlatformGatewayDiffblueTest {
  /**
   * Method under test: {@link TracPlatformGateway#doStartup(Duration)}
   */
  @Test
  void testDoStartup() throws InterruptedException {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracPlatformGateway(pluginManager,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()))).doStartup(null));
  }

  /**
   * Method under test: {@link TracPlatformGateway#doStartup(Duration)}
   */
  @Test
  void testDoStartup2() throws InterruptedException {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracPlatformGateway(pluginManager,
        new ConfigManager("Preparing gateway config...", workingDir, new PluginManager()))).doStartup(null));
  }
}

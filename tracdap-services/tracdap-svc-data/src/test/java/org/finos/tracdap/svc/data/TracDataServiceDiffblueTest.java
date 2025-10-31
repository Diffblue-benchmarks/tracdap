package org.finos.tracdap.svc.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class TracDataServiceDiffblueTest {
  /**
   * Method under test: {@link TracDataService#doStartup(Duration)}
   */
  @Test
  void testDoStartup() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracDataService(plugins,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()))).doStartup(null));
  }

  /**
   * Method under test: {@link TracDataService#doStartup(Duration)}
   */
  @Test
  void testDoStartup2() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new TracDataService(plugins, new ConfigManager("log4j", workingDir, new PluginManager())))
            .doStartup(null));
  }
}

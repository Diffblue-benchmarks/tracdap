package org.finos.tracdap.svc.orch;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.svc.orch.service.JobManager;
import org.junit.jupiter.api.Test;

class TracOrchestratorServiceDiffblueTest {
  /**
   * Method under test: {@link TracOrchestratorService#doStartup(Duration)}
   */
  @Test
  void testDoStartup() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new TracOrchestratorService(pluginManager,
            new ConfigManager("https://example.org/example", workingDir, new PluginManager())))
            .doStartup(JobManager.SCHEDULED_REMOVAL_DURATION));
  }

  /**
   * Method under test: {@link TracOrchestratorService#doStartup(Duration)}
   */
  @Test
  void testDoStartup2() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> (new TracOrchestratorService(pluginManager, new ConfigManager("log4j", workingDir, new PluginManager())))
            .doStartup(JobManager.SCHEDULED_REMOVAL_DURATION));
  }
}

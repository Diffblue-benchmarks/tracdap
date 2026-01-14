package org.finos.tracdap.svc.orch;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracOrchestratorServiceDiffblueTest {
  /**
   * Test {@link TracOrchestratorService#doStartup(Duration)}.
   *
   * <p>Method under test: {@link TracOrchestratorService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracOrchestratorService.doStartup(Duration)"})
  void testDoStartup() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    TracOrchestratorService tracOrchestratorService =
        new TracOrchestratorService(pluginManager, configManager);

    // Act and Assert
    assertThrows(EStartup.class, () -> tracOrchestratorService.doStartup(Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link TracOrchestratorService#doStartup(Duration)}.
   *
   * <p>Method under test: {@link TracOrchestratorService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracOrchestratorService.doStartup(Duration)"})
  void testDoStartup2() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager = new ConfigManager("log4j", workingDir, new PluginManager());

    TracOrchestratorService tracOrchestratorService =
        new TracOrchestratorService(pluginManager, configManager);

    // Act and Assert
    assertThrows(EStartup.class, () -> tracOrchestratorService.doStartup(Duration.ofSeconds(1L)));
  }
}

package org.finos.tracdap.gateway;

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

class TracPlatformGatewayDiffblueTest {
  /**
   * Test {@link TracPlatformGateway#doStartup(Duration)}.
   *
   * <p>Method under test: {@link TracPlatformGateway#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracPlatformGateway.doStartup(Duration)"})
  void testDoStartup() throws InterruptedException {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    TracPlatformGateway tracPlatformGateway = new TracPlatformGateway(pluginManager, configManager);

    // Act and Assert
    assertThrows(EStartup.class, () -> tracPlatformGateway.doStartup(Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link TracPlatformGateway#doStartup(Duration)}.
   *
   * <p>Method under test: {@link TracPlatformGateway#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracPlatformGateway.doStartup(Duration)"})
  void testDoStartup2() throws InterruptedException {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("Preparing gateway config...", workingDir, new PluginManager());

    TracPlatformGateway tracPlatformGateway = new TracPlatformGateway(pluginManager, configManager);

    // Act and Assert
    assertThrows(EStartup.class, () -> tracPlatformGateway.doStartup(Duration.ofSeconds(1L)));
  }
}

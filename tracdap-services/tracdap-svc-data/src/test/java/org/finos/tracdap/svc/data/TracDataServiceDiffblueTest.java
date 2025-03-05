package org.finos.tracdap.svc.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class TracDataServiceDiffblueTest {
  /**
   * Test {@link TracDataService#doStartup(Duration)}.
   * <p>
   * Method under test: {@link TracDataService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracDataService.doStartup(Duration)"})
  void testDoStartup() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracDataService(plugins,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()))).doStartup(null));
  }

  /**
   * Test {@link TracDataService#doStartup(Duration)}.
   * <p>
   * Method under test: {@link TracDataService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracDataService.doStartup(Duration)"})
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

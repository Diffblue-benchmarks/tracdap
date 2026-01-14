package org.finos.tracdap.common.startup;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StartupSequenceDiffblueTest {
  /**
   * Test {@link StartupSequence#getPlugins()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link StartupSequence#getPlugins()}
   */
  @Test
  @DisplayName("Test getPlugins(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.tracdap.common.plugin.PluginManager StartupSequence.getPlugins()"})
  void testGetPlugins_thenThrowETracInternal() {
    // Arrange
    StartupSequence useConfigFileResult =
        Startup.useConfigFile(
            null,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            "Config File",
            "Keystore Key");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> useConfigFileResult.getPlugins());
  }

  /**
   * Test {@link StartupSequence#getConfig()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link StartupSequence#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.tracdap.common.config.ConfigManager StartupSequence.getConfig()"})
  void testGetConfig_thenThrowETracInternal() {
    // Arrange
    StartupSequence useConfigFileResult =
        Startup.useConfigFile(
            null,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            "Config File",
            "Keystore Key");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> useConfigFileResult.getConfig());
  }
}

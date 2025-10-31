package org.finos.tracdap.common.startup;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class StartupSequenceDiffblueTest {
  /**
   * Method under test: {@link StartupSequence#getPlugins()}
   */
  @Test
  void testGetPlugins() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> Startup
            .useConfigFile(null, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Config File",
                "Keystore Key")
            .getPlugins());
  }

  /**
   * Method under test: {@link StartupSequence#getConfig()}
   */
  @Test
  void testGetConfig() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> Startup
            .useConfigFile(null, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Config File",
                "Keystore Key")
            .getConfig());
  }
}

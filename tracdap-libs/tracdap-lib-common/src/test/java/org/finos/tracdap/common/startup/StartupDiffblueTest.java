package org.finos.tracdap.common.startup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class StartupDiffblueTest {
  /**
   * Method under test: {@link Startup#useConfigFile(Class, Path, String, String)}
   */
  @Test
  void testUseConfigFile() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    StandardArgs args = Startup.useConfigFile(null, workingDir, "Config File", "Keystore Key").getArgs();
    assertEquals("Config File", args.getConfigFile());
    assertEquals("Keystore Key", args.getSecretKey());
    assertTrue(args.getTasks().isEmpty());
    assertSame(workingDir, args.getWorkingDir());
  }
}

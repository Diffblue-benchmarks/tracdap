package org.finos.tracdap.common.startup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StartupDiffblueTest {
  /**
   * Test {@link Startup#useConfigFile(Class, Path, String, String)} with {@code serviceClass},
   * {@code workingDir}, {@code configFile}, {@code keystoreKey}.
   *
   * <p>Method under test: {@link Startup#useConfigFile(Class, Path, String, String)}
   */
  @Test
  @DisplayName(
      "Test useConfigFile(Class, Path, String, String) with 'serviceClass', 'workingDir', 'configFile', 'keystoreKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StartupSequence Startup.useConfigFile(Class, Path, String, String)"})
  void testUseConfigFileWithServiceClassWorkingDirConfigFileKeystoreKey() {
    // Arrange
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    StartupSequence actualUseConfigFileResult =
        Startup.useConfigFile(null, workingDir, "Config File", "Keystore Key");

    // Assert
    StandardArgs args = actualUseConfigFileResult.getArgs();
    assertEquals("Config File", args.getConfigFile());
    assertEquals("Keystore Key", args.getSecretKey());
    assertTrue(args.getTasks().isEmpty());
    assertSame(workingDir, args.getWorkingDir());
  }
}

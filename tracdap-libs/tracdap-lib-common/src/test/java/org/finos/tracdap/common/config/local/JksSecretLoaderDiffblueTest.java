package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JksSecretLoaderDiffblueTest {
  /**
   * Test {@link JksSecretLoader#JksSecretLoader(Properties)}.
   * <p>
   * Method under test: {@link JksSecretLoader#JksSecretLoader(Properties)}
   */
  @Test
  @DisplayName("Test new JksSecretLoader(Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JksSecretLoader.<init>(Properties)"})
  void testNewJksSecretLoader() {
    // Arrange, Act and Assert
    assertNull((new JksSecretLoader(new Properties())).secretKey);
  }

  /**
   * Test {@link JksSecretLoader#init(ConfigManager)}.
   * <p>
   * Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  @DisplayName("Test init(ConfigManager)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JksSecretLoader.init(ConfigManager)"})
  void testInit() {
    // Arrange
    JksSecretLoader jksSecretLoader = new JksSecretLoader(new Properties());
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> jksSecretLoader.init(new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }
}

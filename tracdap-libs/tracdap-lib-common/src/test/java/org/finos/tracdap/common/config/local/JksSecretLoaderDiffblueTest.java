package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class JksSecretLoaderDiffblueTest {
  /**
   * Method under test: {@link JksSecretLoader#init(ConfigManager)}
   */
  @Test
  void testInit() {
    // Arrange
    JksSecretLoader jksSecretLoader = new JksSecretLoader(new Properties());
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStartup.class,
        () -> jksSecretLoader.init(new ConfigManager("https://example.org/example", workingDir, new PluginManager())));
  }

  /**
   * Method under test: {@link JksSecretLoader#JksSecretLoader(Properties)}
   */
  @Test
  void testNewJksSecretLoader() {
    // Arrange, Act and Assert
    assertNull((new JksSecretLoader(new Properties())).secretKey);
  }
}

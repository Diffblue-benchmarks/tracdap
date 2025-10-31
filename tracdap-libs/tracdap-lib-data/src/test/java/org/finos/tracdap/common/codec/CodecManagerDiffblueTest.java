package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class CodecManagerDiffblueTest {
  /**
   * Method under test: {@link CodecManager#getCodec(String)}
   */
  @Test
  void testGetCodec() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> (new CodecManager(plugins,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()))).getCodec("Format"));
  }
}

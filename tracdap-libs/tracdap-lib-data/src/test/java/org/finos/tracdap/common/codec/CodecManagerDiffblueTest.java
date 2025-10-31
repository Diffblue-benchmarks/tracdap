package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CodecManagerDiffblueTest {
  /**
   * Test {@link CodecManager#getCodec(String)}.
   * <ul>
   *   <li>Then throw {@link EPluginNotAvailable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodecManager#getCodec(String)}
   */
  @Test
  @DisplayName("Test getCodec(String); then throw EPluginNotAvailable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.codec.ICodec CodecManager.getCodec(String)"})
  void testGetCodec_thenThrowEPluginNotAvailable() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> (new CodecManager(plugins,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()))).getCodec("Format"));
  }
}

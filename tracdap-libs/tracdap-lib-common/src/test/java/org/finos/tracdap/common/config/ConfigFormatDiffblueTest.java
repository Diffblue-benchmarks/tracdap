package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.net.URI;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;

class ConfigFormatDiffblueTest {
  /**
   * Method under test: {@link ConfigFormat#fromExtension(URI)}
   */
  @Test
  void testFromExtension() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class,
        () -> ConfigFormat.fromExtension(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
    assertThrows(EStartup.class, () -> ConfigFormat.fromExtension(
        Paths.get(System.getProperty("java.io.tmpdir"), "Unknown config format for file: [%s]").toUri()));
  }
}

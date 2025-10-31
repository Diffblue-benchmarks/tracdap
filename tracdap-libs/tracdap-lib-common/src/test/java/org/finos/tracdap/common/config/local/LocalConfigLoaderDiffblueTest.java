package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.net.URI;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.junit.jupiter.api.Test;

class LocalConfigLoaderDiffblueTest {
  /**
   * Method under test: {@link LocalConfigLoader#loadTextFile(URI)}
   */
  @Test
  void testLoadTextFile() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader())
        .loadTextFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader()).loadTextFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "Failed to load config file: %2$s [%1$s]").toUri()));
  }

  /**
   * Method under test: {@link LocalConfigLoader#loadBinaryFile(URI)}
   */
  @Test
  void testLoadBinaryFile() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader())
        .loadBinaryFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader()).loadBinaryFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "Failed to load config file: %2$s [%1$s]").toUri()));
  }
}

package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;

class JksHelpersDiffblueTest {
  /**
   * Method under test:
   * {@link JksHelpers#loadKeystore(String, Path, String, boolean)}
   */
  @Test
  void testLoadKeystore() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JksHelpers.loadKeystore("Keystore Type",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Keystore Key", true));
  }

  /**
   * Method under test: {@link JksHelpers#saveKeystore(Path, String, KeyStore)}
   */
  @Test
  void testSaveKeystore() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JksHelpers
        .saveKeystore(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Keystore Key", null));
  }
}

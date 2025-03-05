package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JksHelpersDiffblueTest {
  /**
   * Test {@link JksHelpers#loadKeystore(String, Path, String, boolean)}.
   * <p>
   * Method under test: {@link JksHelpers#loadKeystore(String, Path, String, boolean)}
   */
  @Test
  @DisplayName("Test loadKeystore(String, Path, String, boolean)")
  @Tag("MaintainedByDiffblue")
  void testLoadKeystore() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JksHelpers.loadKeystore("Keystore Type",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Keystore Key", true));
  }

  /**
   * Test {@link JksHelpers#saveKeystore(Path, String, KeyStore)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} and {@code 42}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JksHelpers#saveKeystore(Path, String, KeyStore)}
   */
  @Test
  @DisplayName("Test saveKeystore(Path, String, KeyStore); when Property is 'java.io.tmpdir' is 'foo' and '42'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  void testSaveKeystore_whenPropertyIsJavaIoTmpdirIsFooAnd42_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JksHelpers
        .saveKeystore(Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42"), "Keystore Key", null));
  }

  /**
   * Test {@link JksHelpers#saveKeystore(Path, String, KeyStore)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JksHelpers#saveKeystore(Path, String, KeyStore)}
   */
  @Test
  @DisplayName("Test saveKeystore(Path, String, KeyStore); when Property is 'java.io.tmpdir' is 'test.txt'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  void testSaveKeystore_whenPropertyIsJavaIoTmpdirIsTestTxt_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> JksHelpers
        .saveKeystore(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "Keystore Key", null));
  }
}

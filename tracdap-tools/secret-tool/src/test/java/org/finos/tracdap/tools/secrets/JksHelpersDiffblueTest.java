package org.finos.tracdap.tools.secrets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JksHelpersDiffblueTest {
  /**
   * Test {@link JksHelpers#loadKeystore(String, Path, String, boolean)}.
   *
   * <p>Method under test: {@link JksHelpers#loadKeystore(String, Path, String, boolean)}
   */
  @Test
  @DisplayName("Test loadKeystore(String, Path, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.security.KeyStore JksHelpers.loadKeystore(String, Path, String, boolean)"
  })
  void testLoadKeystore() {
    // Arrange, Act and Assert
    assertThrows(
        EStartup.class,
        () ->
            JksHelpers.loadKeystore(
                "Keystore Type",
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
                "Keystore Key",
                true));
  }
}

package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.URI;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigFormatDiffblueTest {
  /**
   * Test {@link ConfigFormat#fromExtension(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigFormat#fromExtension(URI)}
   */
  @Test
  @DisplayName("Test fromExtension(URI); when Property is 'java.io.tmpdir' is 'test.txt' toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConfigFormat ConfigFormat.fromExtension(URI)"})
  void testFromExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToUri() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class,
        () -> ConfigFormat.fromExtension(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test {@link ConfigFormat#fromExtension(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code Unknown config format for file: [%s]} toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigFormat#fromExtension(URI)}
   */
  @Test
  @DisplayName("Test fromExtension(URI); when Property is 'java.io.tmpdir' is 'Unknown config format for file: [%s]' toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConfigFormat ConfigFormat.fromExtension(URI)"})
  void testFromExtension_whenPropertyIsJavaIoTmpdirIsUnknownConfigFormatForFileSToUri() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigFormat.fromExtension(
        Paths.get(System.getProperty("java.io.tmpdir"), "Unknown config format for file: [%s]").toUri()));
  }
}

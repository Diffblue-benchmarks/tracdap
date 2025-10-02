package org.finos.tracdap.common.config.local;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.URI;
import java.nio.file.Paths;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalConfigLoaderDiffblueTest {
  /**
   * Test {@link LocalConfigLoader#loadTextFile(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code 42} toUri.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadTextFile(URI)}
   */
  @Test
  @DisplayName("Test loadTextFile(URI); when Property is 'java.io.tmpdir' is '42' toUri; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String LocalConfigLoader.loadTextFile(URI)"})
  void testLoadTextFile_whenPropertyIsJavaIoTmpdirIs42ToUri_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("",
        (new LocalConfigLoader()).loadTextFile(Paths.get(System.getProperty("java.io.tmpdir"), "42").toUri()));
  }

  /**
   * Test {@link LocalConfigLoader#loadTextFile(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code Failed to load config file: %2$s [%1$s]} toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadTextFile(URI)}
   */
  @Test
  @DisplayName("Test loadTextFile(URI); when Property is 'java.io.tmpdir' is 'Failed to load config file: %2$s [%1$s]' toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String LocalConfigLoader.loadTextFile(URI)"})
  void testLoadTextFile_whenPropertyIsJavaIoTmpdirIsFailedToLoadConfigFile2S1SToUri() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader()).loadTextFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "Failed to load config file: %2$s [%1$s]").toUri()));
  }

  /**
   * Test {@link LocalConfigLoader#loadTextFile(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadTextFile(URI)}
   */
  @Test
  @DisplayName("Test loadTextFile(URI); when Property is 'java.io.tmpdir' is 'test.txt' toUri; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String LocalConfigLoader.loadTextFile(URI)"})
  void testLoadTextFile_whenPropertyIsJavaIoTmpdirIsTestTxtToUri_thenThrowEConfigLoad() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader())
        .loadTextFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test {@link LocalConfigLoader#loadBinaryFile(URI)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadBinaryFile(URI)}
   */
  @Test
  @DisplayName("Test loadBinaryFile(URI); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LocalConfigLoader.loadBinaryFile(URI)"})
  void testLoadBinaryFile_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{},
        (new LocalConfigLoader()).loadBinaryFile(Paths.get(System.getProperty("java.io.tmpdir"), "42").toUri()));
  }

  /**
   * Test {@link LocalConfigLoader#loadBinaryFile(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code Failed to load config file: %2$s [%1$s]} toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadBinaryFile(URI)}
   */
  @Test
  @DisplayName("Test loadBinaryFile(URI); when Property is 'java.io.tmpdir' is 'Failed to load config file: %2$s [%1$s]' toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LocalConfigLoader.loadBinaryFile(URI)"})
  void testLoadBinaryFile_whenPropertyIsJavaIoTmpdirIsFailedToLoadConfigFile2S1SToUri() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader()).loadBinaryFile(
        Paths.get(System.getProperty("java.io.tmpdir"), "Failed to load config file: %2$s [%1$s]").toUri()));
  }

  /**
   * Test {@link LocalConfigLoader#loadBinaryFile(URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri.</li>
   *   <li>Then throw {@link EConfigLoad}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalConfigLoader#loadBinaryFile(URI)}
   */
  @Test
  @DisplayName("Test loadBinaryFile(URI); when Property is 'java.io.tmpdir' is 'test.txt' toUri; then throw EConfigLoad")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LocalConfigLoader.loadBinaryFile(URI)"})
  void testLoadBinaryFile_whenPropertyIsJavaIoTmpdirIsTestTxtToUri_thenThrowEConfigLoad() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> (new LocalConfigLoader())
        .loadBinaryFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }
}

package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CryptoHelpersDiffblueTest {
  /**
   * Test {@link CryptoHelpers#encodeSSHA512(String, byte[])}.
   * <p>
   * Method under test: {@link CryptoHelpers#encodeSSHA512(String, byte[])}
   */
  @Test
  @DisplayName("Test encodeSSHA512(String, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CryptoHelpers.encodeSSHA512(String, byte[])"})
  void testEncodeSSHA512() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "$6$QVhBWEFYQVg$Ab3M1MyeAzap5V6DRP/xyuv8ueTXFv2Z3OuNTr6tGGHBGGzk1OQz42dwqMGG+fWsgaOkOHvpmQJZ" + "CQCoEq8r2Q",
        CryptoHelpers.encodeSSHA512("iloveyou", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CryptoHelpers#validateSSHA512(String, String)}.
   * <p>
   * Method under test: {@link CryptoHelpers#validateSSHA512(String, String)}
   */
  @Test
  @DisplayName("Test validateSSHA512(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CryptoHelpers.validateSSHA512(String, String)"})
  void testValidateSSHA512() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> CryptoHelpers.validateSSHA512("Phc", "iloveyou"));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenCr() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\r", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenCr2() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\r", false));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenKey() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("Key", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenKey2() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("Key", false));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenLf() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\n", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePublicKey(String, boolean)}.
   * <ul>
   *   <li>When {@code \r}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePublicKey(String, boolean); when '\\r'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey CryptoHelpers.decodePublicKey(String, boolean)"})
  void testDecodePublicKey_whenR() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\\r", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenCr() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\r", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenCr2() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\r", false));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenKey() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("Key", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenKey2() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("Key", false));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenLf() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\n", true));
  }

  /**
   * Test {@link CryptoHelpers#decodePrivateKey(String, boolean)}.
   * <ul>
   *   <li>When {@code \r}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  @DisplayName("Test decodePrivateKey(String, boolean); when '\\r'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey CryptoHelpers.decodePrivateKey(String, boolean)"})
  void testDecodePrivateKey_whenR() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\\r", true));
  }
}

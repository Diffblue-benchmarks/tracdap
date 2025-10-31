package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import org.finos.tracdap.common.exception.EConfigLoad;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class CryptoHelpersDiffblueTest {
  /**
   * Method under test: {@link CryptoHelpers#encodeSSHA512(String, byte[])}
   */
  @Test
  void testEncodeSSHA512() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "$6$QVhBWEFYQVg$Ab3M1MyeAzap5V6DRP/xyuv8ueTXFv2Z3OuNTr6tGGHBGGzk1OQz42dwqMGG+fWsgaOkOHvpmQJZ" + "CQCoEq8r2Q",
        CryptoHelpers.encodeSSHA512("iloveyou", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CryptoHelpers#validateSSHA512(String, String)}
   */
  @Test
  void testValidateSSHA512() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> CryptoHelpers.validateSSHA512("Phc", "iloveyou"));
  }

  /**
   * Method under test: {@link CryptoHelpers#decodePublicKey(String, boolean)}
   */
  @Test
  void testDecodePublicKey() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("Key", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("Key", false));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\r", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\n", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\\r", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePublicKey("\r", false));
  }

  /**
   * Method under test: {@link CryptoHelpers#decodePrivateKey(String, boolean)}
   */
  @Test
  void testDecodePrivateKey() {
    // Arrange, Act and Assert
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("Key", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("Key", false));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\r", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\n", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\\r", true));
    assertThrows(EConfigLoad.class, () -> CryptoHelpers.decodePrivateKey("\r", false));
  }
}

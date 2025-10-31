package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class JsonCodecDiffblueTest {
  /**
   * Method under test: {@link JsonCodec#options()}
   */
  @Test
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new JsonCodec()).options().isEmpty());
  }

  /**
   * Method under test: {@link JsonCodec#defaultFileExtension()}
   */
  @Test
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("json", (new JsonCodec()).defaultFileExtension());
  }
}

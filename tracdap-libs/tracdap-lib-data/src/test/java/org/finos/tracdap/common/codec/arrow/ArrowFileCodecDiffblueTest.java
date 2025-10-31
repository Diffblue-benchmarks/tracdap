package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ArrowFileCodecDiffblueTest {
  /**
   * Method under test: {@link ArrowFileCodec#options()}
   */
  @Test
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new ArrowFileCodec()).options().isEmpty());
  }

  /**
   * Method under test: {@link ArrowFileCodec#defaultFileExtension()}
   */
  @Test
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("arrow", (new ArrowFileCodec()).defaultFileExtension());
  }
}

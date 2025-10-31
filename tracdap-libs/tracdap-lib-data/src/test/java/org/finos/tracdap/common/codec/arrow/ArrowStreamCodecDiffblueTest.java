package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ArrowStreamCodecDiffblueTest {
  /**
   * Method under test: {@link ArrowStreamCodec#options()}
   */
  @Test
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new ArrowStreamCodec()).options().isEmpty());
  }

  /**
   * Method under test: {@link ArrowStreamCodec#defaultFileExtension()}
   */
  @Test
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("arrows", (new ArrowStreamCodec()).defaultFileExtension());
  }
}

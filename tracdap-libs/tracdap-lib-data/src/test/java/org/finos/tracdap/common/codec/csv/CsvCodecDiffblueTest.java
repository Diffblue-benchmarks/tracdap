package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CsvCodecDiffblueTest {
  /**
   * Method under test: {@link CsvCodec#options()}
   */
  @Test
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new CsvCodec()).options().isEmpty());
  }

  /**
   * Method under test: {@link CsvCodec#defaultFileExtension()}
   */
  @Test
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("csv", (new CsvCodec()).defaultFileExtension());
  }
}

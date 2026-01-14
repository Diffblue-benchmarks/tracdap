package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CsvCodecDiffblueTest {
  /**
   * Test {@link CsvCodec#options()}.
   *
   * <p>Method under test: {@link CsvCodec#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CsvCodec.options()"})
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue(new CsvCodec().options().isEmpty());
  }

  /**
   * Test {@link CsvCodec#defaultFileExtension()}.
   *
   * <p>Method under test: {@link CsvCodec#defaultFileExtension()}
   */
  @Test
  @DisplayName("Test defaultFileExtension()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CsvCodec.defaultFileExtension()"})
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("csv", new CsvCodec().defaultFileExtension());
  }
}

package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrowFileCodecDiffblueTest {
  /**
   * Test {@link ArrowFileCodec#options()}.
   * <p>
   * Method under test: {@link ArrowFileCodec#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ArrowFileCodec.options()"})
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new ArrowFileCodec()).options().isEmpty());
  }

  /**
   * Test {@link ArrowFileCodec#defaultFileExtension()}.
   * <p>
   * Method under test: {@link ArrowFileCodec#defaultFileExtension()}
   */
  @Test
  @DisplayName("Test defaultFileExtension()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ArrowFileCodec.defaultFileExtension()"})
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("arrow", (new ArrowFileCodec()).defaultFileExtension());
  }
}

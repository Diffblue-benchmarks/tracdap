package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonCodecDiffblueTest {
  /**
   * Test {@link JsonCodec#options()}.
   * <p>
   * Method under test: {@link JsonCodec#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List JsonCodec.options()"})
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue((new JsonCodec()).options().isEmpty());
  }

  /**
   * Test {@link JsonCodec#defaultFileExtension()}.
   * <p>
   * Method under test: {@link JsonCodec#defaultFileExtension()}
   */
  @Test
  @DisplayName("Test defaultFileExtension()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsonCodec.defaultFileExtension()"})
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("json", (new JsonCodec()).defaultFileExtension());
  }
}

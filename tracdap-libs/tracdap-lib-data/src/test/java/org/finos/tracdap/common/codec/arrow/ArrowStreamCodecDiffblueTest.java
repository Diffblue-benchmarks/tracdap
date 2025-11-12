package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrowStreamCodecDiffblueTest {
  /**
   * Test {@link ArrowStreamCodec#options()}.
   *
   * <p>Method under test: {@link ArrowStreamCodec#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ArrowStreamCodec.options()"})
  void testOptions() {
    // Arrange, Act and Assert
    assertTrue(new ArrowStreamCodec().options().isEmpty());
  }

  /**
   * Test {@link ArrowStreamCodec#defaultFileExtension()}.
   *
   * <p>Method under test: {@link ArrowStreamCodec#defaultFileExtension()}
   */
  @Test
  @DisplayName("Test defaultFileExtension()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ArrowStreamCodec.defaultFileExtension()"})
  void testDefaultFileExtension() {
    // Arrange, Act and Assert
    assertEquals("arrows", new ArrowStreamCodec().defaultFileExtension());
  }
}

package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedirectBuilderDiffblueTest {
  /**
   * Test {@link RedirectBuilder#buildRedirects(PlatformConfig)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedirectBuilder#buildRedirects(PlatformConfig)}
   */
  @Test
  @DisplayName("Test buildRedirects(PlatformConfig); when DefaultInstance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RedirectBuilder.buildRedirects(PlatformConfig)"})
  void testBuildRedirects_whenDefaultInstance_thenReturnEmpty() {
    // Arrange
    RedirectBuilder redirectBuilder = new RedirectBuilder();

    // Act and Assert
    assertTrue(redirectBuilder.buildRedirects(PlatformConfig.getDefaultInstance()).isEmpty());
  }
}

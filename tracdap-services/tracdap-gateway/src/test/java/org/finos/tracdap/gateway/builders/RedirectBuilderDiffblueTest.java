package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedirectBuilderDiffblueTest {
  /**
   * Test {@link RedirectBuilder#buildRedirects(PlatformConfig)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RedirectBuilder#buildRedirects(PlatformConfig)}
   */
  @Test
  @DisplayName("Test buildRedirects(PlatformConfig); when DefaultInstance; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List RedirectBuilder.buildRedirects(PlatformConfig)"})
  void testBuildRedirects_whenDefaultInstance_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new RedirectBuilder().buildRedirects(PlatformConfig.getDefaultInstance()).isEmpty());
  }
}

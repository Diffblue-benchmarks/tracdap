package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RouteBuilderDiffblueTest {
  /**
   * Test {@link RouteBuilder#buildRoutes(PlatformConfig)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RouteBuilder#buildRoutes(PlatformConfig)}
   */
  @Test
  @DisplayName("Test buildRoutes(PlatformConfig); when DefaultInstance; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List RouteBuilder.buildRoutes(PlatformConfig)"})
  void testBuildRoutes_whenDefaultInstance_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new RouteBuilder().buildRoutes(PlatformConfig.getDefaultInstance()).isEmpty());
  }
}

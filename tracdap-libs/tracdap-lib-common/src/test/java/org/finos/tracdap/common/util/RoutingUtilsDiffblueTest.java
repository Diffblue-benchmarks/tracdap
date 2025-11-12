package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.EConfig;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoutingUtilsDiffblueTest {
  /**
   * Test {@link RoutingUtils#serviceTarget(PlatformConfig, String)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EConfig}.
   * </ul>
   *
   * <p>Method under test: {@link RoutingUtils#serviceTarget(PlatformConfig, String)}
   */
  @Test
  @DisplayName(
      "Test serviceTarget(PlatformConfig, String); when DefaultInstance; then throw EConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.config.RoutingTarget RoutingUtils.serviceTarget(PlatformConfig, String)"
  })
  void testServiceTarget_whenDefaultInstance_thenThrowEConfig() {
    // Arrange, Act and Assert
    assertThrows(
        EConfig.class,
        () -> RoutingUtils.serviceTarget(PlatformConfig.getDefaultInstance(), "Service Key"));
  }

  /**
   * Test {@link RoutingUtils#serviceTarget(PlatformConfig, String)}.
   *
   * <ul>
   *   <li>When {@code Missing or invalid config: services.%s}.
   *   <li>Then throw {@link EConfig}.
   * </ul>
   *
   * <p>Method under test: {@link RoutingUtils#serviceTarget(PlatformConfig, String)}
   */
  @Test
  @DisplayName(
      "Test serviceTarget(PlatformConfig, String); when 'Missing or invalid config: services.%s'; then throw EConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.config.RoutingTarget RoutingUtils.serviceTarget(PlatformConfig, String)"
  })
  void testServiceTarget_whenMissingOrInvalidConfigServicesS_thenThrowEConfig() {
    // Arrange, Act and Assert
    assertThrows(
        EConfig.class,
        () ->
            RoutingUtils.serviceTarget(
                PlatformConfig.getDefaultInstance(), "Missing or invalid config: services.%s"));
  }
}

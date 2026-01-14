package org.finos.tracdap.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.middleware.CommonConcerns;
import org.finos.tracdap.common.middleware.CommonNettyConcerns;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.finos.tracdap.common.service.TracGatewayConfig.IdleHandling;
import org.finos.tracdap.config.ServiceConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TracGatewayConfigDiffblueTest {
  /**
   * Test {@link TracGatewayConfig#emptyConfig()}.
   *
   * <p>Method under test: {@link TracGatewayConfig#emptyConfig()}
   */
  @Test
  @DisplayName("Test emptyConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonConcerns TracGatewayConfig.emptyConfig()"})
  void testEmptyConfig() {
    // Arrange and Act
    CommonConcerns<NettyConcern> actualEmptyConfigResult = TracGatewayConfig.emptyConfig();

    // Assert
    assertTrue(actualEmptyConfigResult instanceof CommonNettyConcerns);
    assertEquals(TracGatewayConfig.TRAC_GATEWAY_CONCERNS, actualEmptyConfigResult.concernName());
  }

  /**
   * Test {@link TracGatewayConfig#coreConcerns(String, ServiceConfig)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@link CommonNettyConcerns}.
   * </ul>
   *
   * <p>Method under test: {@link TracGatewayConfig#coreConcerns(String, ServiceConfig)}
   */
  @Test
  @DisplayName(
      "Test coreConcerns(String, ServiceConfig); when DefaultInstance; then return CommonNettyConcerns")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonConcerns TracGatewayConfig.coreConcerns(String, ServiceConfig)"})
  void testCoreConcerns_whenDefaultInstance_thenReturnCommonNettyConcerns() {
    // Arrange and Act
    CommonConcerns<NettyConcern> actualCoreConcernsResult =
        TracGatewayConfig.coreConcerns("Service Name", ServiceConfig.getDefaultInstance());

    // Assert
    assertTrue(actualCoreConcernsResult instanceof CommonNettyConcerns);
    assertEquals(TracGatewayConfig.TRAC_GATEWAY_CONCERNS, actualCoreConcernsResult.concernName());
  }

  /**
   * Test IdleHandling {@link IdleHandling#IdleHandling(String, ServiceConfig)}.
   *
   * <ul>
   *   <li>Then return concernName is {@link TracGatewayConfig#TRAC_IDLE_STATE}.
   * </ul>
   *
   * <p>Method under test: {@link IdleHandling#IdleHandling(String, ServiceConfig)}
   */
  @Test
  @DisplayName(
      "Test IdleHandling new IdleHandling(String, ServiceConfig); then return concernName is TRAC_IDLE_STATE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IdleHandling.<init>(String, ServiceConfig)"})
  void testIdleHandlingNewIdleHandling_thenReturnConcernNameIsTrac_idle_state() {
    // Arrange, Act and Assert
    assertEquals(
        TracGatewayConfig.TRAC_IDLE_STATE,
        new IdleHandling("Service Name", ServiceConfig.getDefaultInstance()).concernName());
  }
}

package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.finos.tracdap.common.exception.EConfig;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;

class RoutingUtilsDiffblueTest {
  /**
   * Method under test: {@link RoutingUtils#serviceTarget(PlatformConfig, String)}
   */
  @Test
  void testServiceTarget() {
    // Arrange, Act and Assert
    assertThrows(EConfig.class, () -> RoutingUtils.serviceTarget(PlatformConfig.getDefaultInstance(), "Service Key"));
    assertThrows(EConfig.class, () -> RoutingUtils.serviceTarget(PlatformConfig.getDefaultInstance(),
        "Missing or invalid config: services.%s"));
  }
}

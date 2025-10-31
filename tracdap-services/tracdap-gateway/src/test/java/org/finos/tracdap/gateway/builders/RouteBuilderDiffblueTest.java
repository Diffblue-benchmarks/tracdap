package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;

class RouteBuilderDiffblueTest {
  /**
   * Method under test: {@link RouteBuilder#buildRoutes(PlatformConfig)}
   */
  @Test
  void testBuildRoutes() {
    // Arrange
    RouteBuilder routeBuilder = new RouteBuilder();

    // Act and Assert
    assertTrue(routeBuilder.buildRoutes(PlatformConfig.getDefaultInstance()).isEmpty());
  }
}

package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;

class RedirectBuilderDiffblueTest {
  /**
   * Method under test: {@link RedirectBuilder#buildRedirects(PlatformConfig)}
   */
  @Test
  void testBuildRedirects() {
    // Arrange
    RedirectBuilder redirectBuilder = new RedirectBuilder();

    // Act and Assert
    assertTrue(redirectBuilder.buildRedirects(PlatformConfig.getDefaultInstance()).isEmpty());
  }
}

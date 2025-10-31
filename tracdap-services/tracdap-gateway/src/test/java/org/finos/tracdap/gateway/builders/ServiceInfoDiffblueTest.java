package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;

class ServiceInfoDiffblueTest {
  /**
   * Method under test: {@link ServiceInfo#buildServiceInfo(PlatformConfig)}
   */
  @Test
  void testBuildServiceInfo() {
    // Arrange and Act
    List<ServiceInfo> actualBuildServiceInfoResult = ServiceInfo.buildServiceInfo(PlatformConfig.getDefaultInstance());

    // Assert
    assertTrue(actualBuildServiceInfoResult.isEmpty());
  }
}

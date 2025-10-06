package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceInfoDiffblueTest {
  /**
   * Test {@link ServiceInfo#buildServiceInfo(PlatformConfig)} with {@code platformConfig}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ServiceInfo#buildServiceInfo(PlatformConfig)}
   */
  @Test
  @DisplayName(
      "Test buildServiceInfo(PlatformConfig) with 'platformConfig'; when DefaultInstance; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServiceInfo.buildServiceInfo(PlatformConfig)"})
  void testBuildServiceInfoWithPlatformConfig_whenDefaultInstance_thenReturnEmpty() {
    // Arrange and Act
    List<ServiceInfo> actualBuildServiceInfoResult =
        ServiceInfo.buildServiceInfo(PlatformConfig.getDefaultInstance());

    // Assert
    assertTrue(actualBuildServiceInfoResult.isEmpty());
  }
}

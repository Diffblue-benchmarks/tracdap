package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.config.RouteConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Http1ProxyDiffblueTest {
  /**
   * Test {@link Http1Proxy#Http1Proxy(RouteConfig, long)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return not Sharable.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Proxy#Http1Proxy(RouteConfig, long)}
   */
  @Test
  @DisplayName("Test new Http1Proxy(RouteConfig, long); when DefaultInstance; then return not Sharable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Proxy.<init>(RouteConfig, long)"})
  void testNewHttp1Proxy_whenDefaultInstance_thenReturnNotSharable() {
    // Arrange, Act and Assert
    assertFalse((new Http1Proxy(RouteConfig.getDefaultInstance(), 1L)).isSharable());
  }
}

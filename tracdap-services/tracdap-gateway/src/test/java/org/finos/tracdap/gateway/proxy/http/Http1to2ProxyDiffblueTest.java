package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.config.RouteConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Http1to2ProxyDiffblueTest {
  /**
   * Test {@link Http1to2Proxy#Http1to2Proxy(RouteConfig, int)}.
   * <p>
   * Method under test: {@link Http1to2Proxy#Http1to2Proxy(RouteConfig, int)}
   */
  @Test
  @DisplayName("Test new Http1to2Proxy(RouteConfig, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1to2Proxy.<init>(RouteConfig, int)"})
  void testNewHttp1to2Proxy() {
    // Arrange, Act and Assert
    assertFalse((new Http1to2Proxy(RouteConfig.getDefaultInstance(), 1)).isSharable());
  }
}

package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelDuplexHandler;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.proxy.http.HttpProtocol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcProxyBuilderDiffblueTest {
  /**
   * Test {@link GrpcProxyBuilder#GrpcProxyBuilder(RouteConfig, ChannelDuplexHandler, int, HttpProtocol, GrpcProtocol)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Sharable.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxyBuilder#GrpcProxyBuilder(RouteConfig, ChannelDuplexHandler, int, HttpProtocol, GrpcProtocol)}
   */
  @Test
  @DisplayName("Test new GrpcProxyBuilder(RouteConfig, ChannelDuplexHandler, int, HttpProtocol, GrpcProtocol); when DefaultInstance; then return Sharable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void GrpcProxyBuilder.<init>(RouteConfig, ChannelDuplexHandler, int, HttpProtocol, GrpcProtocol)"})
  void testNewGrpcProxyBuilder_whenDefaultInstance_thenReturnSharable() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();

    // Act and Assert
    assertTrue(
        (new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1, HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC))
            .isSharable());
  }
}

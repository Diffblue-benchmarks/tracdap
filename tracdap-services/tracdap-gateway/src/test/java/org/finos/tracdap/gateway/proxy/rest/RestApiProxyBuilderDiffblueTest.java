package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.ArrayList;
import org.finos.tracdap.gateway.exec.Route;
import org.finos.tracdap.gateway.proxy.http.HttpProtocol;
import org.finos.tracdap.gateway.routing.CoreRouterLink;
import org.finos.tracdap.gateway.routing.WebSocketsRouter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiProxyBuilderDiffblueTest {
  /**
   * Test {@link RestApiProxyBuilder#RestApiProxyBuilder(Route, CoreRouterLink, int, HttpProtocol)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Sharable.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxyBuilder#RestApiProxyBuilder(Route, CoreRouterLink,
   * int, HttpProtocol)}
   */
  @Test
  @DisplayName(
      "Test new RestApiProxyBuilder(Route, CoreRouterLink, int, HttpProtocol); when 'null'; then return Sharable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxyBuilder.<init>(Route, CoreRouterLink, int, HttpProtocol)"})
  void testNewRestApiProxyBuilder_whenNull_thenReturnSharable() {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    CoreRouterLink routerLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act
    RestApiProxyBuilder actualRestApiProxyBuilder =
        new RestApiProxyBuilder(null, routerLink, 1, HttpProtocol.HTTP_1_0);

    // Assert
    assertTrue(actualRestApiProxyBuilder.isSharable());
  }
}

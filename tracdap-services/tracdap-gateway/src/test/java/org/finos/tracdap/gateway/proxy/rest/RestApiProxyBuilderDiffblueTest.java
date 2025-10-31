package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.ArrayList;
import org.finos.tracdap.common.exception.ENetworkHttp;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.exec.IRouteMatcher;
import org.finos.tracdap.gateway.exec.Route;
import org.finos.tracdap.gateway.proxy.http.HttpProtocol;
import org.finos.tracdap.gateway.routing.CoreRouterLink;
import org.finos.tracdap.gateway.routing.WebSocketsRouter;
import org.junit.jupiter.api.Test;

class RestApiProxyBuilderDiffblueTest {
  /**
   * Method under test: {@link RestApiProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel() {
    // Arrange
    Route routeConfig = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    RestApiProxyBuilder restApiProxyBuilder = new RestApiProxyBuilder(routeConfig,
        new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1), 1,
        HttpProtocol.HTTP_1_0);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    restApiProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link RestApiProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel2() {
    // Arrange
    Route routeConfig = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    RestApiProxyBuilder restApiProxyBuilder = new RestApiProxyBuilder(routeConfig,
        new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1), 1,
        HttpProtocol.HTTP_1_1);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    restApiProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link RestApiProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel3() {
    // Arrange
    Route routeConfig = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    RestApiProxyBuilder restApiProxyBuilder = new RestApiProxyBuilder(routeConfig,
        new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1), 1,
        HttpProtocol.HTTP_2_0);

    // Act and Assert
    assertThrows(ENetworkHttp.class, () -> restApiProxyBuilder.initChannel(new EmbeddedChannel()));
  }

  /**
   * Method under test:
   * {@link RestApiProxyBuilder#RestApiProxyBuilder(Route, CoreRouterLink, int, HttpProtocol)}
   */
  @Test
  void testNewRestApiProxyBuilder() {
    // Arrange
    Route routeConfig = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertTrue((new RestApiProxyBuilder(routeConfig,
        new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1), 1,
        HttpProtocol.HTTP_1_0)).isSharable());
  }
}

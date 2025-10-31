package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.exec.IRouteMatcher;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WebSocketsRouterDiffblueTest {
  /**
   * Method under test:
   * {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext, Object)}
   */
  @Test
  void testUserEventTriggered() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.userEventTriggered(ctx, "Evt");

    // Assert
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, "Msg");

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new BinaryWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead3() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new TextWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead4() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new CloseWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead5() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new DefaultLastHttpContent());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    webSocketsRouter.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame();

    // Act
    webSocketsRouter.write(ctx, binaryWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    CloseWebSocketFrame closeWebSocketFrame = new CloseWebSocketFrame();

    // Act
    webSocketsRouter.write(ctx, closeWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite4() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act
    webSocketsRouter.write(ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught2() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new IOException("conn = {}, sending close request with code [{}, {}]: {}"));

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught3() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.newPromise()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.exceptionCaught(ctx, new Throwable()));
    verify(ctx).newPromise();
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#initializeProxyRoute(ChannelHandlerContext, CoreRouterLink, Route)}
   */
  @Test
  void testInitializeProxyRoute() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    CoreRouterLink link = new CoreRouterLink(router, routerCtx,
        new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.initializeProxyRoute(ctx, link,
        new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class))));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  void testReportProxyRouteError() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  void testReportProxyRouteError2() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx,
        new IOException("conn = {}, sending close request with code [{}, {}]: {}"), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  void testReportProxyRouteError3() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.newPromise()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).newPromise();
  }

  /**
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  void testNewWebSocketsRouter() {
    // Arrange and Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    assertEquals(1, actualWebSocketsRouter.connId);
    assertTrue(actualWebSocketsRouter.routes.isEmpty());
  }

  /**
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  void testNewWebSocketsRouter2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Route route = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route);

    // Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(routes, 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    List<Route> routeList = actualWebSocketsRouter.routes;
    assertEquals(1, routeList.size());
    assertEquals(1, actualWebSocketsRouter.connId);
    assertSame(route, routeList.get(0));
  }

  /**
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  void testNewWebSocketsRouter3() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Route route = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route);
    Route route2 = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route2);

    // Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(routes, 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    assertEquals(1, actualWebSocketsRouter.connId);
    List<Route> routeList = actualWebSocketsRouter.routes;
    assertEquals(2, routeList.size());
    assertSame(route, routeList.get(0));
    assertSame(route2, routeList.get(1));
  }
}

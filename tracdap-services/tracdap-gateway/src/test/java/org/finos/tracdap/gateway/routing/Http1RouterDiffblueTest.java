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
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.GatewayRedirect;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.exec.IRouteMatcher;
import org.finos.tracdap.gateway.exec.Redirect;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http1RouterDiffblueTest {
  /**
   * Method under test:
   * {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new Http1Router(routes, new ArrayList<>(), 1)).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Method under test:
   * {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.channelRead(ctx,
        new DefaultHttpContent(new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())))));
  }

  /**
   * Method under test:
   * {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http1Router.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act
    http1Router.write(ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.write(ctx, defaultLastHttpContent,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    http1Router.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).close();
  }

  /**
   * Method under test:
   * {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.exceptionCaught(ctx, new Throwable()));
    verify(ctx).close();
  }

  /**
   * Method under test:
   * {@link Http1Router#initializeProxyRoute(ChannelHandlerContext, CoreRouterLink, Route)}
   */
  @Test
  void testInitializeProxyRoute() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    CoreRouterLink link = new CoreRouterLink(router, routerCtx,
        new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.initializeProxyRoute(ctx, link,
        new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class))));
  }

  /**
   * Method under test:
   * {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  void testReportProxyRouteError() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    http1Router.reportProxyRouteError(ctx, new Throwable(), true);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  void testReportProxyRouteError2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  void testNewHttp1Router() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<Redirect> redirects = new ArrayList<>();

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    assertEquals(1, actualHttp1Router.connId);
    assertTrue(redirects.isEmpty());
    assertTrue(actualHttp1Router.redirects.isEmpty());
    assertTrue(actualHttp1Router.routes.isEmpty());
  }

  /**
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  void testNewHttp1Router2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Route route = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, new ArrayList<>(), 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    List<Route> routeList = actualHttp1Router.routes;
    assertEquals(1, routeList.size());
    assertEquals(1, actualHttp1Router.connId);
    assertTrue(actualHttp1Router.redirects.isEmpty());
    assertSame(route, routeList.get(0));
  }

  /**
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  void testNewHttp1Router3() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Route route = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route);
    Route route2 = new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class));

    routes.add(route2);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, new ArrayList<>(), 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    assertEquals(1, actualHttp1Router.connId);
    List<Route> routeList = actualHttp1Router.routes;
    assertEquals(2, routeList.size());
    assertTrue(actualHttp1Router.redirects.isEmpty());
    assertSame(route, routeList.get(0));
    assertSame(route2, routeList.get(1));
  }

  /**
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  void testNewHttp1Router4() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    ArrayList<Redirect> redirects = new ArrayList<>();
    Redirect redirect = new Redirect(1, GatewayRedirect.getDefaultInstance(), mock(IRouteMatcher.class));

    redirects.add(redirect);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    List<Redirect> redirectList = actualHttp1Router.redirects;
    assertEquals(1, redirectList.size());
    assertEquals(1, actualHttp1Router.connId);
    assertTrue(actualHttp1Router.routes.isEmpty());
    assertSame(redirect, redirectList.get(0));
  }

  /**
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  void testNewHttp1Router5() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    ArrayList<Redirect> redirects = new ArrayList<>();
    Redirect redirect = new Redirect(1, GatewayRedirect.getDefaultInstance(), mock(IRouteMatcher.class));

    redirects.add(redirect);
    Redirect redirect2 = new Redirect(1, GatewayRedirect.getDefaultInstance(), mock(IRouteMatcher.class));

    redirects.add(redirect2);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    assertEquals(1, actualHttp1Router.connId);
    List<Redirect> redirectList = actualHttp1Router.redirects;
    assertEquals(2, redirectList.size());
    assertTrue(actualHttp1Router.routes.isEmpty());
    assertSame(redirect, redirectList.get(0));
    assertSame(redirect2, redirectList.get(1));
  }
}

package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.codec.http.HttpMethod;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.exec.IRouteMatcher;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoreRouterDiffblueTest {
  /**
   * Method under test: {@link CoreRouter#lookupRedirect(URI, HttpMethod, long)}
   */
  @Test
  void testLookupRedirect() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(routes, 1);
    URI uri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertNull(webSocketsRouter.lookupRedirect(uri, HttpMethod.valueOf("Name"), 1L));
  }

  /**
   * Method under test: {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}
   */
  @Test
  void testLookupRoute() {
    // Arrange
    IRouteMatcher matcher = mock(IRouteMatcher.class);
    when(matcher.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route = new Route(1, RouteConfig.getDefaultInstance(), matcher);

    ArrayList<Route> routes = new ArrayList<>();
    routes.add(route);
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(routes, 1);
    URI uri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    Route actualLookupRouteResult = webSocketsRouter.lookupRoute(uri, HttpMethod.valueOf("Name"), 1L);

    // Assert
    verify(matcher).matches(isA(HttpMethod.class), isA(URI.class));
    assertSame(route, actualLookupRouteResult);
  }

  /**
   * Method under test: {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}
   */
  @Test
  void testLookupRoute2() {
    // Arrange
    IRouteMatcher matcher = mock(IRouteMatcher.class);
    when(matcher.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route = new Route(1, RouteConfig.getDefaultInstance(), matcher);

    IRouteMatcher matcher2 = mock(IRouteMatcher.class);
    when(matcher2.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route2 = new Route(1, RouteConfig.getDefaultInstance(), matcher2);

    IRouteMatcher matcher3 = mock(IRouteMatcher.class);
    when(matcher3.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route3 = new Route(1, RouteConfig.getDefaultInstance(), matcher3);

    IRouteMatcher matcher4 = mock(IRouteMatcher.class);
    when(matcher4.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route4 = new Route(1, RouteConfig.getDefaultInstance(), matcher4);

    IRouteMatcher matcher5 = mock(IRouteMatcher.class);
    when(matcher5.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route5 = new Route(1, RouteConfig.getDefaultInstance(), matcher5);

    IRouteMatcher matcher6 = mock(IRouteMatcher.class);
    when(matcher6.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route6 = new Route(1, RouteConfig.getDefaultInstance(), matcher6);

    IRouteMatcher matcher7 = mock(IRouteMatcher.class);
    when(matcher7.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route7 = new Route(1, RouteConfig.getDefaultInstance(), matcher7);

    IRouteMatcher matcher8 = mock(IRouteMatcher.class);
    when(matcher8.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route8 = new Route(1, RouteConfig.getDefaultInstance(), matcher8);

    IRouteMatcher matcher9 = mock(IRouteMatcher.class);
    when(matcher9.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route9 = new Route(1, RouteConfig.getDefaultInstance(), matcher9);

    IRouteMatcher matcher10 = mock(IRouteMatcher.class);
    when(matcher10.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route10 = new Route(1, RouteConfig.getDefaultInstance(), matcher10);

    IRouteMatcher matcher11 = mock(IRouteMatcher.class);
    when(matcher11.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route11 = new Route(1, RouteConfig.getDefaultInstance(), matcher11);

    IRouteMatcher matcher12 = mock(IRouteMatcher.class);
    when(matcher12.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route12 = new Route(1, RouteConfig.getDefaultInstance(), matcher12);

    IRouteMatcher matcher13 = mock(IRouteMatcher.class);
    when(matcher13.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route13 = new Route(1, RouteConfig.getDefaultInstance(), matcher13);

    IRouteMatcher matcher14 = mock(IRouteMatcher.class);
    when(matcher14.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route14 = new Route(1, RouteConfig.getDefaultInstance(), matcher14);

    IRouteMatcher matcher15 = mock(IRouteMatcher.class);
    when(matcher15.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route15 = new Route(1, RouteConfig.getDefaultInstance(), matcher15);

    IRouteMatcher matcher16 = mock(IRouteMatcher.class);
    when(matcher16.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route16 = new Route(1, RouteConfig.getDefaultInstance(), matcher16);

    IRouteMatcher matcher17 = mock(IRouteMatcher.class);
    when(matcher17.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route17 = new Route(1, RouteConfig.getDefaultInstance(), matcher17);

    IRouteMatcher matcher18 = mock(IRouteMatcher.class);
    when(matcher18.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route18 = new Route(1, RouteConfig.getDefaultInstance(), matcher18);

    IRouteMatcher matcher19 = mock(IRouteMatcher.class);
    when(matcher19.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route19 = new Route(1, RouteConfig.getDefaultInstance(), matcher19);

    IRouteMatcher matcher20 = mock(IRouteMatcher.class);
    when(matcher20.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route20 = new Route(1, RouteConfig.getDefaultInstance(), matcher20);

    IRouteMatcher matcher21 = mock(IRouteMatcher.class);
    when(matcher21.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route21 = new Route(1, RouteConfig.getDefaultInstance(), matcher21);

    IRouteMatcher matcher22 = mock(IRouteMatcher.class);
    when(matcher22.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route22 = new Route(1, RouteConfig.getDefaultInstance(), matcher22);

    IRouteMatcher matcher23 = mock(IRouteMatcher.class);
    when(matcher23.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route23 = new Route(1, RouteConfig.getDefaultInstance(), matcher23);

    IRouteMatcher matcher24 = mock(IRouteMatcher.class);
    when(matcher24.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route24 = new Route(1, RouteConfig.getDefaultInstance(), matcher24);

    IRouteMatcher matcher25 = mock(IRouteMatcher.class);
    when(matcher25.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route25 = new Route(1, RouteConfig.getDefaultInstance(), matcher25);

    IRouteMatcher matcher26 = mock(IRouteMatcher.class);
    when(matcher26.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route26 = new Route(1, RouteConfig.getDefaultInstance(), matcher26);

    IRouteMatcher matcher27 = mock(IRouteMatcher.class);
    when(matcher27.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route27 = new Route(1, RouteConfig.getDefaultInstance(), matcher27);

    IRouteMatcher matcher28 = mock(IRouteMatcher.class);
    when(matcher28.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route28 = new Route(1, RouteConfig.getDefaultInstance(), matcher28);

    IRouteMatcher matcher29 = mock(IRouteMatcher.class);
    when(matcher29.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route29 = new Route(1, RouteConfig.getDefaultInstance(), matcher29);

    IRouteMatcher matcher30 = mock(IRouteMatcher.class);
    when(matcher30.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route30 = new Route(1, RouteConfig.getDefaultInstance(), matcher30);

    IRouteMatcher matcher31 = mock(IRouteMatcher.class);
    when(matcher31.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route31 = new Route(1, RouteConfig.getDefaultInstance(), matcher31);

    IRouteMatcher matcher32 = mock(IRouteMatcher.class);
    when(matcher32.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route32 = new Route(1, RouteConfig.getDefaultInstance(), matcher32);

    IRouteMatcher matcher33 = mock(IRouteMatcher.class);
    when(matcher33.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route33 = new Route(1, RouteConfig.getDefaultInstance(), matcher33);

    IRouteMatcher matcher34 = mock(IRouteMatcher.class);
    when(matcher34.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route34 = new Route(1, RouteConfig.getDefaultInstance(), matcher34);

    IRouteMatcher matcher35 = mock(IRouteMatcher.class);
    when(matcher35.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route35 = new Route(1, RouteConfig.getDefaultInstance(), matcher35);

    IRouteMatcher matcher36 = mock(IRouteMatcher.class);
    when(matcher36.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route36 = new Route(1, RouteConfig.getDefaultInstance(), matcher36);

    IRouteMatcher matcher37 = mock(IRouteMatcher.class);
    when(matcher37.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route37 = new Route(1, RouteConfig.getDefaultInstance(), matcher37);

    IRouteMatcher matcher38 = mock(IRouteMatcher.class);
    when(matcher38.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route38 = new Route(1, RouteConfig.getDefaultInstance(), matcher38);

    IRouteMatcher matcher39 = mock(IRouteMatcher.class);
    when(matcher39.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route39 = new Route(1, RouteConfig.getDefaultInstance(), matcher39);

    IRouteMatcher matcher40 = mock(IRouteMatcher.class);
    when(matcher40.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route40 = new Route(1, RouteConfig.getDefaultInstance(), matcher40);

    IRouteMatcher matcher41 = mock(IRouteMatcher.class);
    when(matcher41.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route41 = new Route(1, RouteConfig.getDefaultInstance(), matcher41);

    IRouteMatcher matcher42 = mock(IRouteMatcher.class);
    when(matcher42.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route42 = new Route(1, RouteConfig.getDefaultInstance(), matcher42);

    IRouteMatcher matcher43 = mock(IRouteMatcher.class);
    when(matcher43.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route43 = new Route(1, RouteConfig.getDefaultInstance(), matcher43);

    IRouteMatcher matcher44 = mock(IRouteMatcher.class);
    when(matcher44.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route44 = new Route(1, RouteConfig.getDefaultInstance(), matcher44);

    IRouteMatcher matcher45 = mock(IRouteMatcher.class);
    when(matcher45.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route45 = new Route(1, RouteConfig.getDefaultInstance(), matcher45);

    IRouteMatcher matcher46 = mock(IRouteMatcher.class);
    when(matcher46.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route46 = new Route(1, RouteConfig.getDefaultInstance(), matcher46);

    IRouteMatcher matcher47 = mock(IRouteMatcher.class);
    when(matcher47.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route47 = new Route(1, RouteConfig.getDefaultInstance(), matcher47);

    IRouteMatcher matcher48 = mock(IRouteMatcher.class);
    when(matcher48.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route48 = new Route(1, RouteConfig.getDefaultInstance(), matcher48);

    IRouteMatcher matcher49 = mock(IRouteMatcher.class);
    when(matcher49.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route49 = new Route(1, RouteConfig.getDefaultInstance(), matcher49);

    IRouteMatcher matcher50 = mock(IRouteMatcher.class);
    when(matcher50.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route50 = new Route(1, RouteConfig.getDefaultInstance(), matcher50);

    IRouteMatcher matcher51 = mock(IRouteMatcher.class);
    when(matcher51.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route51 = new Route(1, RouteConfig.getDefaultInstance(), matcher51);

    IRouteMatcher matcher52 = mock(IRouteMatcher.class);
    when(matcher52.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route52 = new Route(1, RouteConfig.getDefaultInstance(), matcher52);

    IRouteMatcher matcher53 = mock(IRouteMatcher.class);
    when(matcher53.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route53 = new Route(1, RouteConfig.getDefaultInstance(), matcher53);

    IRouteMatcher matcher54 = mock(IRouteMatcher.class);
    when(matcher54.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(true);
    Route route54 = new Route(1, RouteConfig.getDefaultInstance(), matcher54);

    IRouteMatcher matcher55 = mock(IRouteMatcher.class);
    when(matcher55.matches(Mockito.<HttpMethod>any(), Mockito.<URI>any())).thenReturn(false);
    Route route55 = new Route(1, RouteConfig.getDefaultInstance(), matcher55);

    ArrayList<Route> routes = new ArrayList<>();
    routes.add(route55);
    routes.add(route54);
    routes.add(route53);
    routes.add(route52);
    routes.add(route51);
    routes.add(route50);
    routes.add(route49);
    routes.add(route48);
    routes.add(route47);
    routes.add(route46);
    routes.add(route45);
    routes.add(route44);
    routes.add(route43);
    routes.add(route42);
    routes.add(route41);
    routes.add(route40);
    routes.add(route39);
    routes.add(route38);
    routes.add(route37);
    routes.add(route36);
    routes.add(route35);
    routes.add(route34);
    routes.add(route33);
    routes.add(route32);
    routes.add(route31);
    routes.add(route30);
    routes.add(route29);
    routes.add(route28);
    routes.add(route27);
    routes.add(route26);
    routes.add(route25);
    routes.add(route24);
    routes.add(route23);
    routes.add(route22);
    routes.add(route21);
    routes.add(route20);
    routes.add(route19);
    routes.add(route18);
    routes.add(route17);
    routes.add(route16);
    routes.add(route15);
    routes.add(route14);
    routes.add(route13);
    routes.add(route12);
    routes.add(route11);
    routes.add(route10);
    routes.add(route9);
    routes.add(route8);
    routes.add(route7);
    routes.add(route6);
    routes.add(route5);
    routes.add(route4);
    routes.add(route3);
    routes.add(route2);
    routes.add(route);
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(routes, 1);
    URI uri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    Route actualLookupRouteResult = webSocketsRouter.lookupRoute(uri, HttpMethod.valueOf("Name"), 1L);

    // Assert
    verify(matcher55).matches(isA(HttpMethod.class), isA(URI.class));
    verify(matcher54).matches(isA(HttpMethod.class), isA(URI.class));
    assertSame(route54, actualLookupRouteResult);
  }

  /**
   * Method under test: {@link CoreRouter#getTarget(int)}
   */
  @Test
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new WebSocketsRouter(new ArrayList<>(), 1)).getTarget(1));
  }

  /**
   * Method under test: {@link CoreRouter#getTarget(int)}
   */
  @Test
  void testGetTarget2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));

    // Act and Assert
    assertNull((new WebSocketsRouter(routes, 1)).getTarget(1));
  }

  /**
   * Method under test: {@link CoreRouter#getAssociatedRoute(Object)}
   */
  @Test
  void testGetAssociatedRoute() {
    // Arrange, Act and Assert
    assertNull((new WebSocketsRouter(new ArrayList<>(), 1)).getAssociatedRoute("Msg"));
  }

  /**
   * Method under test: {@link CoreRouter#getAssociatedRoute(Object)}
   */
  @Test
  void testGetAssociatedRoute2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));

    // Act and Assert
    assertNull((new WebSocketsRouter(routes, 1)).getAssociatedRoute("Msg"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CoreRouter.TargetChannelState}
   */
  @Test
  void testTargetChannelStateNewTargetChannelState() {
    // Arrange and Act
    CoreRouter.TargetChannelState actualTargetChannelState = new CoreRouter.TargetChannelState();

    // Assert
    Queue<Object> queue = actualTargetChannelState.outboundQueue;
    assertTrue(queue instanceof List);
    assertNull(actualTargetChannelState.channel);
    assertNull(actualTargetChannelState.channelActiveFuture);
    assertNull(actualTargetChannelState.channelCloseFuture);
    assertNull(actualTargetChannelState.channelOpenFuture);
    assertEquals(0, actualTargetChannelState.routeIndex);
    assertTrue(queue.isEmpty());
  }
}

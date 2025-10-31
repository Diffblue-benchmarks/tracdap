package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.exec.IRouteMatcher;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.Test;

class Http2RouterDiffblueTest {
  /**
   * Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  void testNewHttp2Router() {
    // Arrange, Act and Assert
    assertFalse((new Http2Router(new ArrayList<>())).isSharable());
  }

  /**
   * Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  void testNewHttp2Router2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));

    // Act and Assert
    assertFalse((new Http2Router(routes)).isSharable());
  }

  /**
   * Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  void testNewHttp2Router3() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));
    routes.add(new Route(1, RouteConfig.getDefaultInstance(), mock(IRouteMatcher.class)));

    // Act and Assert
    assertFalse((new Http2Router(routes)).isSharable());
  }
}

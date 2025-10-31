package org.finos.tracdap.gateway.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.proxy.rest.RestApiMethod;
import org.junit.jupiter.api.Test;

class RouteDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Route#Route(int, RouteConfig, IRouteMatcher)}
   *   <li>{@link Route#getConfig()}
   *   <li>{@link Route#getIndex()}
   *   <li>{@link Route#getMatcher()}
   *   <li>{@link Route#getRestMethods()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RouteConfig config = RouteConfig.getDefaultInstance();
    IRouteMatcher matcher = mock(IRouteMatcher.class);

    // Act
    Route actualRoute = new Route(1, config, matcher);
    RouteConfig actualConfig = actualRoute.getConfig();
    int actualIndex = actualRoute.getIndex();
    IRouteMatcher actualMatcher = actualRoute.getMatcher();

    // Assert
    assertNull(actualRoute.getRestMethods());
    assertEquals(1, actualIndex);
    assertSame(config, actualConfig);
    assertSame(matcher, actualMatcher);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Route#Route(int, RouteConfig, IRouteMatcher, List)}
   *   <li>{@link Route#getConfig()}
   *   <li>{@link Route#getIndex()}
   *   <li>{@link Route#getMatcher()}
   *   <li>{@link Route#getRestMethods()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    RouteConfig config = RouteConfig.getDefaultInstance();
    IRouteMatcher matcher = mock(IRouteMatcher.class);
    ArrayList<RestApiMethod<?, ?>> restMethods = new ArrayList<>();

    // Act
    Route actualRoute = new Route(1, config, matcher, restMethods);
    RouteConfig actualConfig = actualRoute.getConfig();
    int actualIndex = actualRoute.getIndex();
    IRouteMatcher actualMatcher = actualRoute.getMatcher();

    // Assert
    assertEquals(1, actualIndex);
    assertSame(restMethods, actualRoute.getRestMethods());
    assertSame(config, actualConfig);
    assertSame(matcher, actualMatcher);
  }
}

package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.http.HttpMethod;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.finos.tracdap.gateway.routing.CoreRouter.TargetChannelState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoreRouterDiffblueTest {
  /**
   * Test {@link CoreRouter#lookupRedirect(URI, HttpMethod, long)}.
   * <ul>
   *   <li>When valueOf {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreRouter#lookupRedirect(URI, HttpMethod, long)}
   */
  @Test
  @DisplayName("Test lookupRedirect(URI, HttpMethod, long); when valueOf 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.gateway.exec.Redirect CoreRouter.lookupRedirect(URI, HttpMethod, long)"})
  void testLookupRedirect_whenValueOfName_thenReturnNull() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    URI uri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertNull(webSocketsRouter.lookupRedirect(uri, HttpMethod.valueOf("Name"), 1L));
  }

  /**
   * Test {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}.
   * <ul>
   *   <li>When valueOf {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}
   */
  @Test
  @DisplayName("Test lookupRoute(URI, HttpMethod, long); when valueOf 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.gateway.exec.Route CoreRouter.lookupRoute(URI, HttpMethod, long)"})
  void testLookupRoute_whenValueOfName_thenReturnNull() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    URI uri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertNull(webSocketsRouter.lookupRoute(uri, HttpMethod.valueOf("Name"), 1L));
  }

  /**
   * Test {@link CoreRouter#getTarget(int)}.
   * <p>
   * Method under test: {@link CoreRouter#getTarget(int)}
   */
  @Test
  @DisplayName("Test getTarget(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TargetChannelState CoreRouter.getTarget(int)"})
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new WebSocketsRouter(new ArrayList<>(), 1)).getTarget(1));
  }

  /**
   * Test {@link CoreRouter#getAssociatedRoute(Object)}.
   * <p>
   * Method under test: {@link CoreRouter#getAssociatedRoute(Object)}
   */
  @Test
  @DisplayName("Test getAssociatedRoute(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer CoreRouter.getAssociatedRoute(Object)"})
  void testGetAssociatedRoute() {
    // Arrange, Act and Assert
    assertNull((new WebSocketsRouter(new ArrayList<>(), 1)).getAssociatedRoute("Msg"));
  }

  /**
   * Test TargetChannelState new {@link TargetChannelState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TargetChannelState}
   */
  @Test
  @DisplayName("Test TargetChannelState new TargetChannelState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TargetChannelState.<init>()"})
  void testTargetChannelStateNewTargetChannelState() {
    // Arrange and Act
    TargetChannelState actualTargetChannelState = new TargetChannelState();

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

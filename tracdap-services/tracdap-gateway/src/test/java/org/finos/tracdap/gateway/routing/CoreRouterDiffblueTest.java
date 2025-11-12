package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.BootstrapConfig;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.resolver.DefaultAddressResolverGroup;
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
   * Test {@link CoreRouter#handlerAdded(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link CoreRouter#handlerAdded(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test handlerAdded(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouter.handlerAdded(ChannelHandlerContext)"})
  void testHandlerAdded() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    // Act
    webSocketsRouter.handlerAdded(ctx);

    // Assert
    verify(ctx).alloc();
    verify(ctx).channel();
    BootstrapConfig configResult = webSocketsRouter.bootstrap.config();
    assertTrue(configResult.resolver() instanceof DefaultAddressResolverGroup);
    assertNull(configResult.handler());
    assertEquals(1, configResult.options().size());
    assertTrue(configResult.attrs().isEmpty());
  }

  /**
   * Test {@link CoreRouter#handlerAdded(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link CoreRouter#handlerAdded(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test handlerAdded(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouter.handlerAdded(ChannelHandlerContext)"})
  void testHandlerAdded2() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    Channel channel = mock(Channel.class);
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    when(channel.eventLoop()).thenReturn(defaultEventLoop);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(null);
    when(ctx.channel()).thenReturn(channel);

    // Act
    webSocketsRouter.handlerAdded(ctx);

    // Assert
    verify(channel).eventLoop();
    verify(ctx).alloc();
    verify(ctx).channel();
    Bootstrap bootstrap = webSocketsRouter.bootstrap;
    assertSame(defaultEventLoop, bootstrap.group());
    assertSame(defaultEventLoop, bootstrap.config().group());
  }

  /**
   * Test {@link CoreRouter#lookupRedirect(URI, HttpMethod, long)}.
   *
   * <ul>
   *   <li>When valueOf {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouter#lookupRedirect(URI, HttpMethod, long)}
   */
  @Test
  @DisplayName(
      "Test lookupRedirect(URI, HttpMethod, long); when valueOf 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.gateway.exec.Redirect CoreRouter.lookupRedirect(URI, HttpMethod, long)"
  })
  void testLookupRedirect_whenValueOfName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new WebSocketsRouter(new ArrayList<>(), 1)
            .lookupRedirect(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(),
                HttpMethod.valueOf("Name"),
                1L));
  }

  /**
   * Test {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}.
   *
   * <ul>
   *   <li>When valueOf {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouter#lookupRoute(URI, HttpMethod, long)}
   */
  @Test
  @DisplayName("Test lookupRoute(URI, HttpMethod, long); when valueOf 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.gateway.exec.Route CoreRouter.lookupRoute(URI, HttpMethod, long)"
  })
  void testLookupRoute_whenValueOfName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new WebSocketsRouter(new ArrayList<>(), 1)
            .lookupRoute(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(),
                HttpMethod.valueOf("Name"),
                1L));
  }

  /**
   * Test {@link CoreRouter#getTarget(int)}.
   *
   * <p>Method under test: {@link CoreRouter#getTarget(int)}
   */
  @Test
  @DisplayName("Test getTarget(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TargetChannelState CoreRouter.getTarget(int)"})
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull(new WebSocketsRouter(new ArrayList<>(), 1).getTarget(1));
  }

  /**
   * Test {@link CoreRouter#getAssociatedRoute(Object)}.
   *
   * <p>Method under test: {@link CoreRouter#getAssociatedRoute(Object)}
   */
  @Test
  @DisplayName("Test getAssociatedRoute(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer CoreRouter.getAssociatedRoute(Object)"})
  void testGetAssociatedRoute() {
    // Arrange, Act and Assert
    assertNull(new WebSocketsRouter(new ArrayList<>(), 1).getAssociatedRoute("Msg"));
  }

  /**
   * Test TargetChannelState new {@link TargetChannelState} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TargetChannelState}
   */
  @Test
  @DisplayName("Test TargetChannelState new TargetChannelState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

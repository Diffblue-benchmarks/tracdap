package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoreRouterLinkDiffblueTest {
  /**
   * Test {@link CoreRouterLink#CoreRouterLink(CoreRouter, ChannelHandlerContext, ChannelPromise,
   * int, int)}.
   *
   * <ul>
   *   <li>When {@link WebSocketsRouter#WebSocketsRouter(List, int)} with routes is {@link
   *       ArrayList#ArrayList()} and connId is one.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#CoreRouterLink(CoreRouter, ChannelHandlerContext,
   * ChannelPromise, int, int)}
   */
  @Test
  @DisplayName(
      "Test new CoreRouterLink(CoreRouter, ChannelHandlerContext, ChannelPromise, int, int); when WebSocketsRouter(List, int) with routes is ArrayList() and connId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoreRouterLink.<init>(CoreRouter, ChannelHandlerContext, ChannelPromise, int, int)"
  })
  void testNewCoreRouterLink_whenWebSocketsRouterWithRoutesIsArrayListAndConnIdIsOne() {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    // Act
    CoreRouterLink actualCoreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Assert
    assertFalse(actualCoreRouterLink.isSharable());
  }

  /**
   * Test {@link CoreRouterLink#CoreRouterLink(CoreRouter, ChannelHandlerContext, ChannelPromise,
   * int, int)}.
   *
   * <ul>
   *   <li>When {@link WebSocketsRouter#WebSocketsRouter(List, int)} with routes is {@link
   *       ArrayList#ArrayList()} and connId is two.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#CoreRouterLink(CoreRouter, ChannelHandlerContext,
   * ChannelPromise, int, int)}
   */
  @Test
  @DisplayName(
      "Test new CoreRouterLink(CoreRouter, ChannelHandlerContext, ChannelPromise, int, int); when WebSocketsRouter(List, int) with routes is ArrayList() and connId is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoreRouterLink.<init>(CoreRouter, ChannelHandlerContext, ChannelPromise, int, int)"
  })
  void testNewCoreRouterLink_whenWebSocketsRouterWithRoutesIsArrayListAndConnIdIsTwo() {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 2);
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    // Act
    CoreRouterLink actualCoreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Assert
    assertFalse(actualCoreRouterLink.isSharable());
  }

  /**
   * Test {@link CoreRouterLink#channelActive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelActive()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext); then calls fireChannelActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.channelActive(ChannelHandlerContext)"})
  void testChannelActive_thenCallsFireChannelActive() throws Exception {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelActive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    coreRouterLink.channelActive(ctx);

    // Assert
    verify(ctx).fireChannelActive();
  }

  /**
   * Test {@link CoreRouterLink#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#write(Object, ChannelPromise)}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); then calls write(Object, ChannelPromise)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_thenCallsWrite() throws Exception {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    coreRouterLink.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link CoreRouterLink#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#pipeline()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); then calls pipeline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_thenCallsPipeline() {
    // Arrange
    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.write(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.pipeline()).thenReturn(channelPipeline);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act
    coreRouterLink.channelRead(mock(ChannelHandlerContext.class), "Msg");

    // Assert
    verify(routerCtx).pipeline();
    verify(channelPipeline).write(isA(Object.class));
  }

  /**
   * Test {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()} write {@code Msg}.
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelReadComplete(ChannelHandlerContext); given EmbeddedChannel() write 'Msg'; then calls channel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_givenEmbeddedChannelWriteMsg_thenCallsChannel() {
    // Arrange
    EmbeddedChannel embeddedChannel = new EmbeddedChannel();
    embeddedChannel.write("Msg");

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.channel()).thenReturn(embeddedChannel);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act
    coreRouterLink.channelReadComplete(mock(ChannelHandlerContext.class));

    // Assert
    verify(routerCtx).channel();
  }

  /**
   * Test {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext); then calls channel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_thenCallsChannel() {
    // Arrange
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.channel()).thenReturn(new EmbeddedChannel());
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    // Act
    coreRouterLink.channelReadComplete(mock(ChannelHandlerContext.class));

    // Assert
    verify(routerCtx).channel();
  }

  /**
   * Test {@link CoreRouterLink#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#executor()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreRouterLink#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); then calls executor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreRouterLink.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_thenCallsExecutor() {
    // Arrange
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(routerCtx.newPromise())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(routerCtx.executor()).thenReturn(new DefaultEventLoop());
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    CoreRouterLink coreRouterLink =
        new CoreRouterLink(
            router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    coreRouterLink.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(routerCtx).executor();
    verify(ctx).close();
    verify(routerCtx).newPromise();
    verify(routerCtx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }
}

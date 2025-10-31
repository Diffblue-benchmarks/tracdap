package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoreRouterLinkDiffblueTest {
  /**
   * Method under test:
   * {@link CoreRouterLink#channelActive(ChannelHandlerContext)}
   */
  @Test
  void testChannelActive() throws Exception {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    CoreRouterLink coreRouterLink = new CoreRouterLink(router, routerCtx,
        new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelActive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    coreRouterLink.channelActive(ctx);

    // Assert
    verify(ctx).fireChannelActive();
  }

  /**
   * Method under test:
   * {@link CoreRouterLink#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    CoreRouterLink coreRouterLink = new CoreRouterLink(router, routerCtx,
        new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    coreRouterLink.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link CoreRouterLink#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() {
    // Arrange
    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.write(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.pipeline()).thenReturn(channelPipeline);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    // Act
    (new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1))
        .channelRead(mock(ChannelHandlerContext.class), "Msg");

    // Assert
    verify(routerCtx).pipeline();
    verify(channelPipeline).write(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  void testChannelReadComplete() {
    // Arrange
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.channel()).thenReturn(new EmbeddedChannel());
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    // Act
    (new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1))
        .channelReadComplete(mock(ChannelHandlerContext.class));

    // Assert
    verify(routerCtx).channel();
  }

  /**
   * Method under test:
   * {@link CoreRouterLink#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  void testChannelReadComplete2() {
    // Arrange
    EmbeddedChannel embeddedChannel = new EmbeddedChannel();
    embeddedChannel.write("Msg");
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.channel()).thenReturn(embeddedChannel);
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    // Act
    (new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1))
        .channelReadComplete(mock(ChannelHandlerContext.class));

    // Assert
    verify(routerCtx).channel();
  }

  /**
   * Method under test:
   * {@link CoreRouterLink#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught() {
    // Arrange
    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);
    when(routerCtx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(routerCtx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(routerCtx.executor()).thenReturn(new DefaultEventLoop());
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    CoreRouterLink coreRouterLink = new CoreRouterLink(router, routerCtx,
        new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1);
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

  /**
   * Method under test:
   * {@link CoreRouterLink#CoreRouterLink(CoreRouter, ChannelHandlerContext, ChannelPromise, int, int)}
   */
  @Test
  void testNewCoreRouterLink() {
    // Arrange
    WebSocketsRouter router = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext routerCtx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertFalse(
        (new CoreRouterLink(router, routerCtx, new DefaultChannelProgressivePromise(new EmbeddedChannel()), 1, 1))
            .isSharable());
  }
}

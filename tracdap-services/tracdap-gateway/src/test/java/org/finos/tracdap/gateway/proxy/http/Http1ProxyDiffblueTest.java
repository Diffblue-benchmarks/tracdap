package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.RouteConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http1ProxyDiffblueTest {
  /**
   * Method under test: {@link Http1Proxy#Http1Proxy(RouteConfig, long)}
   */
  @Test
  void testNewHttp1Proxy() {
    // Arrange, Act and Assert
    assertFalse((new Http1Proxy(RouteConfig.getDefaultInstance(), 1L)).isSharable());
  }

  /**
   * Method under test:
   * {@link Http1Proxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() {
    // Arrange
    Http1Proxy http1Proxy = new Http1Proxy(RouteConfig.getDefaultInstance(), 1L);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http1Proxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link Http1Proxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() {
    // Arrange
    Http1Proxy http1Proxy = new Http1Proxy(RouteConfig.getDefaultInstance(), 1L);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttpContent defaultHttpContent = new DefaultHttpContent(
        new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())));

    // Act
    http1Proxy.write(ctx, defaultHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link Http1Proxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() {
    // Arrange
    Http1Proxy http1Proxy = new Http1Proxy(RouteConfig.getDefaultInstance(), 1L);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultHttpContent defaultHttpContent = new DefaultHttpContent(
        new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())));

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http1Proxy.write(ctx, defaultHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }
}

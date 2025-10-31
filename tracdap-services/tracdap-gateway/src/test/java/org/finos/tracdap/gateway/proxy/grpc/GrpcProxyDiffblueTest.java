package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.Http2Frame;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcProxyDiffblueTest {
  /**
   * Method under test:
   * {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> grpcProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    Http2Frame http2Frame = mock(Http2Frame.class);

    // Act
    grpcProxy.write(ctx, http2Frame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    Http2Frame http2Frame = mock(Http2Frame.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> grpcProxy.write(ctx, http2Frame, new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite4() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());

    // Act
    grpcProxy.write(ctx, defaultHttp2HeadersFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() throws Exception {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> (new GrpcProxy(1)).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    grpcProxy.channelRead(ctx, new DefaultHttp2DataFrame(true));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead3() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    grpcProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers()));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead4() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcProxy.channelRead(ctx, new DefaultHttp2DataFrame(true)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test: {@link GrpcProxy#GrpcProxy(int)}
   */
  @Test
  void testNewGrpcProxy() {
    // Arrange, Act and Assert
    assertFalse((new GrpcProxy(1)).isSharable());
  }
}

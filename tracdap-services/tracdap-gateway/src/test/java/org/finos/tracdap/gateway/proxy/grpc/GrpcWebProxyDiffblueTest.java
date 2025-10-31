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
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcWebProxyDiffblueTest {
  /**
   * Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  void testNewGrpcWebProxy() {
    // Arrange, Act and Assert
    assertFalse((new GrpcWebProxy(1)).isSharable());
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> grpcWebProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);

    // Act
    grpcWebProxy.write(ctx, defaultHttp2DataFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());

    // Act
    grpcWebProxy.write(ctx, defaultHttp2HeadersFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite4() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act
    grpcWebProxy.write(ctx, defaultHttp2GoAwayFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite5() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcWebProxy.write(ctx, defaultHttp2DataFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite6() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcWebProxy.write(ctx, defaultHttp2HeadersFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Method under test:
   * {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite7() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcWebProxy.write(ctx, defaultHttp2GoAwayFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }
}

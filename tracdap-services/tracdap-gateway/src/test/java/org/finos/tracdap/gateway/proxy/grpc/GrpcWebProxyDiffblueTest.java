package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcWebProxyDiffblueTest {
  /**
   * Test {@link GrpcWebProxy#GrpcWebProxy(int)}.
   * <p>
   * Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcWebProxy(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.<init>(int)"})
  void testNewGrpcWebProxy() {
    // Arrange, Act and Assert
    assertFalse((new GrpcWebProxy(1)).isSharable());
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelOutboundInvoker#write(Object, ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected() {
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
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link DefaultHttp2DataFrame#DefaultHttp2DataFrame(boolean)} with endStream is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when DefaultHttp2DataFrame(boolean) with endStream is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenDefaultHttp2DataFrameWithEndStreamIsTrue() {
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
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link DefaultHttp2GoAwayFrame#DefaultHttp2GoAwayFrame(long)} with errorCode is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when DefaultHttp2GoAwayFrame(long) with errorCode is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenDefaultHttp2GoAwayFrameWithErrorCodeIsMinusOne() {
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

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> grpcWebProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2DataFrame#DefaultHttp2DataFrame(boolean)} with endStream is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2DataFrame(boolean) with endStream is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2DataFrameWithEndStreamIsTrue() {
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
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2GoAwayFrame#DefaultHttp2GoAwayFrame(long)} with errorCode is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2GoAwayFrame(long) with errorCode is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2GoAwayFrameWithErrorCodeIsMinusOne() {
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
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers() {
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
}

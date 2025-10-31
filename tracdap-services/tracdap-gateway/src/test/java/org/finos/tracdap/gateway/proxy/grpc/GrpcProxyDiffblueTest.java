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
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.Http2Frame;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcProxyDiffblueTest {
  /**
   * Test {@link GrpcProxy#GrpcProxy(int)}.
   * <p>
   * Method under test: {@link GrpcProxy#GrpcProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcProxy(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.<init>(int)"})
  void testNewGrpcProxy() {
    // Arrange, Act and Assert
    assertFalse((new GrpcProxy(1)).isSharable());
  }

  /**
   * Test {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)} with channel is {@link EmbeddedChannel#EmbeddedChannel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given DefaultChannelProgressivePromise(Channel) with channel is EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenDefaultChannelProgressivePromiseWithChannelIsEmbeddedChannel() throws Exception {
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
   * Test {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelOutboundInvoker#write(Object, ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected() throws Exception {
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
   * Test {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> grpcProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers() throws Exception {
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
   * Test {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext() throws Exception {
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
   * Test {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcProxy.channelRead(ctx, new DefaultHttp2DataFrame(true)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContext_thenThrowEUnexpected() throws Exception {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> (new GrpcProxy(1)).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GrpcProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers() throws Exception {
    // Arrange
    GrpcProxy grpcProxy = new GrpcProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    grpcProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers()));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }
}

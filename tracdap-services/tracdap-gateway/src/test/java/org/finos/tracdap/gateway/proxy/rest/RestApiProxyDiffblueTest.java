package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.DefaultHttp2PingFrame;
import io.netty.handler.codec.http2.DefaultHttp2PriorityFrame;
import io.netty.handler.codec.http2.DefaultHttp2PushPromiseFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RestApiProxyDiffblueTest {
  /**
   * Test {@link RestApiProxy#RestApiProxy(List)}.
   * <p>
   * Method under test: {@link RestApiProxy#RestApiProxy(List)}
   */
  @Test
  @DisplayName("Test new RestApiProxy(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.<init>(List)"})
  void testNewRestApiProxy() {
    // Arrange, Act and Assert
    assertFalse((new RestApiProxy(new ArrayList<>())).isSharable());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite() throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ByteBufAllocator byteBufAllocator = mock(ByteBufAllocator.class);
    when(byteBufAllocator.compositeBuffer()).thenReturn(mock(CompositeByteBuf.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(byteBufAllocator);
    DefaultHttp2PriorityFrame defaultHttp2PriorityFrame = new DefaultHttp2PriorityFrame(3, (short) 1, true);

    DefaultChannelProgressivePromise promise = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2PriorityFrame, promise);

    // Assert
    verify(byteBufAllocator, atLeast(1)).compositeBuffer();
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)} with channel is {@link EmbeddedChannel#EmbeddedChannel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given DefaultChannelProgressivePromise(Channel) with channel is EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenDefaultChannelProgressivePromiseWithChannelIsEmbeddedChannel() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act
    restApiProxy.write(ctx, defaultHttp2GoAwayFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelOutboundInvoker#write(Object, ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> restApiProxy.write(ctx, defaultHttp2GoAwayFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> restApiProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers()
      throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ByteBufAllocator byteBufAllocator = mock(ByteBufAllocator.class);
    when(byteBufAllocator.compositeBuffer()).thenReturn(mock(CompositeByteBuf.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(byteBufAllocator);
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());
    DefaultChannelProgressivePromise promise = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2HeadersFrame, promise);

    // Assert
    verify(byteBufAllocator, atLeast(1)).compositeBuffer();
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2PingFrame#DefaultHttp2PingFrame(long)} with content is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2PingFrame(long) with content is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2PingFrameWithContentIsOne() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2PingFrame defaultHttp2PingFrame = new DefaultHttp2PingFrame(1L);

    // Act
    restApiProxy.write(ctx, defaultHttp2PingFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultHttp2PushPromiseFrame#DefaultHttp2PushPromiseFrame(Http2Headers)} with http2Headers is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2PushPromiseFrame(Http2Headers) with http2Headers is DefaultHttp2Headers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2PushPromiseFrameWithHttp2HeadersIsDefaultHttp2Headers()
      throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ByteBufAllocator byteBufAllocator = mock(ByteBufAllocator.class);
    when(byteBufAllocator.compositeBuffer()).thenReturn(mock(CompositeByteBuf.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(byteBufAllocator);
    DefaultHttp2PushPromiseFrame defaultHttp2PushPromiseFrame = new DefaultHttp2PushPromiseFrame(
        new DefaultHttp2Headers());
    DefaultChannelProgressivePromise promise = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2PushPromiseFrame, promise);

    // Assert
    verify(byteBufAllocator, atLeast(1)).compositeBuffer();
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link AdaptiveByteBufAllocator#AdaptiveByteBufAllocator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when EmptyByteBuf(ByteBufAllocator) with alloc is AdaptiveByteBufAllocator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenEmptyByteBufWithAllocIsAdaptiveByteBufAllocator() throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ByteBufAllocator byteBufAllocator = mock(ByteBufAllocator.class);
    when(byteBufAllocator.compositeBuffer()).thenReturn(mock(CompositeByteBuf.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(byteBufAllocator);
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(
        new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())));
    DefaultChannelProgressivePromise promise = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2DataFrame, promise);

    // Assert
    verify(byteBufAllocator, atLeast(1)).compositeBuffer();
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> restApiProxy.channelRead(ctx, new DefaultHttp2GoAwayFrame(-1L)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link DefaultHttp2GoAwayFrame#DefaultHttp2GoAwayFrame(long)} with errorCode is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2GoAwayFrame(long) with errorCode is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2GoAwayFrameWithErrorCodeIsMinusOne() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.channelRead(ctx, new DefaultHttp2GoAwayFrame(-1L));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link DefaultHttp2PingFrame#DefaultHttp2PingFrame(long)} with content is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2PingFrame(long) with content is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2PingFrameWithContentIsOne() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.channelRead(ctx, new DefaultHttp2PingFrame(1L));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when 'Msg'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new RestApiProxy(new ArrayList<>())).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}.
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireExceptionCaught(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given ChannelHandlerContext; then calls fireExceptionCaught(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiProxy.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenChannelHandlerContext_thenCallsFireExceptionCaught() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireExceptionCaught(Mockito.<Throwable>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).fireExceptionCaught(isA(Throwable.class));
  }
}

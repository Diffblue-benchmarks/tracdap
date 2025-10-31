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
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RestApiProxyDiffblueTest {
  /**
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> restApiProxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() throws InterruptedException, ExecutionException {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() throws InterruptedException, ExecutionException {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite4() {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite5() throws InterruptedException, ExecutionException {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite6() {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite7() throws InterruptedException, ExecutionException {
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
   * Method under test:
   * {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite8() {
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
   * Method under test:
   * {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() throws Exception {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new RestApiProxy(new ArrayList<>())).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Method under test:
   * {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() throws Exception {
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
   * Method under test:
   * {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead3() throws Exception {
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
   * Method under test:
   * {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead4() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> restApiProxy.channelRead(ctx, new DefaultHttp2GoAwayFrame(-1L)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireExceptionCaught(Mockito.<Throwable>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).fireExceptionCaught(isA(Throwable.class));
  }

  /**
   * Method under test: {@link RestApiProxy#RestApiProxy(List)}
   */
  @Test
  void testNewRestApiProxy() {
    // Arrange, Act and Assert
    assertFalse((new RestApiProxy(new ArrayList<>())).isSharable());
  }
}

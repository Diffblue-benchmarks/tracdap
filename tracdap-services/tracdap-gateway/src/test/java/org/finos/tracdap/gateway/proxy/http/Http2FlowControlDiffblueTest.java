package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import io.netty.handler.codec.http2.Http2FrameStream;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http2FlowControlDiffblueTest {
  /**
   * Method under test:
   * {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}
   */
  @Test
  void testChannelInactive() {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    http2FlowControl.channelInactive(ctx);

    // Assert that nothing has changed
    verify(ctx).fireChannelInactive();
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}
   */
  @Test
  void testChannelInactive2() {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2FlowControl.channelInactive(ctx));
    verify(ctx).fireChannelInactive();
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http2FlowControl.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2FlowControl.write(ctx, defaultHttp2GoAwayFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite3() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.id()).thenReturn(1);

    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);
    defaultHttp2DataFrame.stream(stream);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> http2FlowControl.write(ctx, defaultHttp2DataFrame,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(stream).id();
  }

  /**
   * Method under test: {@link Http2FlowControl#flush(ChannelHandlerContext)}
   */
  @Test
  void testFlush() {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    http2FlowControl.flush(ctx);

    // Assert that nothing has changed
    verify(ctx).flush();
  }

  /**
   * Method under test: {@link Http2FlowControl#flush(ChannelHandlerContext)}
   */
  @Test
  void testFlush2() {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2FlowControl.flush(ctx));
    verify(ctx).flush();
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() throws Exception {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> (new Http2FlowControl(1, "https://example.org/example", new Http2Settings()))
        .channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl = new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any())).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.state()).thenReturn(Http2Stream.State.IDLE);

    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);
    defaultHttp2DataFrame.stream(stream);

    // Act
    http2FlowControl.channelRead(ctx, defaultHttp2DataFrame);

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
    verify(ctx).write(isA(Object.class));
    verify(stream).state();
  }

  /**
   * Method under test:
   * {@link Http2FlowControl#Http2FlowControl(int, String, Http2Settings)}
   */
  @Test
  void testNewHttp2FlowControl() {
    // Arrange
    Http2Settings inboundSettings = new Http2Settings();

    // Act
    Http2FlowControl actualHttp2FlowControl = new Http2FlowControl(1, "https://example.org/example", inboundSettings);

    // Assert
    assertEquals(2, inboundSettings.size());
    assertEquals(16384L, inboundSettings.get((Object) '\u0005').longValue());
    assertEquals(65535L, inboundSettings.get((Object) '\u0004').longValue());
    assertFalse(actualHttp2FlowControl.isSharable());
  }
}

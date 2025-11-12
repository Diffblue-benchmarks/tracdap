package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.Http2FrameStream;
import io.netty.handler.codec.http2.Http2Settings;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http2FlowControlDiffblueTest {
  /**
   * Test {@link Http2FlowControl#Http2FlowControl(int, String, Http2Settings)}.
   *
   * <ul>
   *   <li>When {@link Http2Settings#Http2Settings()}.
   *   <li>Then {@link Http2Settings#Http2Settings()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#Http2FlowControl(int, String, Http2Settings)}
   */
  @Test
  @DisplayName(
      "Test new Http2FlowControl(int, String, Http2Settings); when Http2Settings(); then Http2Settings() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.<init>(int, String, Http2Settings)"})
  void testNewHttp2FlowControl_whenHttp2Settings_thenHttp2SettingsSizeIsTwo() {
    // Arrange
    Http2Settings inboundSettings = new Http2Settings();

    // Act
    Http2FlowControl actualHttp2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", inboundSettings);

    // Assert
    assertEquals(2, inboundSettings.size());
    assertEquals(16384L, inboundSettings.get((Object) '\u0005').longValue());
    assertEquals(65535L, inboundSettings.get((Object) '\u0004').longValue());
    assertFalse(actualHttp2FlowControl.isSharable());
  }

  /**
   * Test {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelInactive(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.channelInactive(ChannelHandlerContext)"})
  void testChannelInactive_givenChannelHandlerContext() {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    http2FlowControl.channelInactive(ctx);

    // Assert
    verify(ctx).fireChannelInactive();
  }

  /**
   * Test {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#channelInactive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelInactive(ChannelHandlerContext); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.channelInactive(ChannelHandlerContext)"})
  void testChannelInactive_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2FlowControl.channelInactive(ctx));
    verify(ctx).fireChannelInactive();
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.id()).thenReturn(1);

    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());
    defaultHttp2HeadersFrame.stream(stream);

    // Act
    http2FlowControl.write(
        ctx, defaultHttp2HeadersFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(stream).id();
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>Then calls {@link ChannelHandlerContext#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given ChannelHandlerContext; then calls flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenChannelHandlerContext_thenCallsFlush() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.id()).thenReturn(1);

    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers(), true);
    defaultHttp2HeadersFrame.stream(stream);

    // Act
    http2FlowControl.write(
        ctx, defaultHttp2HeadersFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).flush();
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(stream).id();
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#write(Object,
   *       ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected()
      throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());

    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.id()).thenReturn(1);

    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());
    defaultHttp2HeadersFrame.stream(stream);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http2FlowControl.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(stream).id();
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#flush()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ChannelHandlerContext#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext flush() throw EUnexpected(); then calls flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContextFlushThrowEUnexpected_thenCallsFlush() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new EUnexpected());
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    Http2FrameStream stream = mock(Http2FrameStream.class);
    when(stream.id()).thenReturn(1);

    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers(), true);
    defaultHttp2HeadersFrame.stream(stream);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http2FlowControl.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).flush();
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(stream).id();
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2GoAwayFrame#DefaultHttp2GoAwayFrame(long)} with errorCode is
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2GoAwayFrame(long) with errorCode is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2GoAwayFrameWithErrorCodeIsMinusOne() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = new DefaultHttp2GoAwayFrame(-1L);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http2FlowControl.write(
                ctx,
                defaultHttp2GoAwayFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link Http2FlowControl#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http2FlowControl.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link Http2FlowControl#flush(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#flush(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test flush(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.flush(ChannelHandlerContext)"})
  void testFlush_givenChannelHandlerContext() {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    http2FlowControl.flush(ctx);

    // Assert
    verify(ctx).flush();
  }

  /**
   * Test {@link Http2FlowControl#flush(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#flush(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test flush(ChannelHandlerContext); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.flush(ChannelHandlerContext)"})
  void testFlush_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2FlowControl.flush(ctx));
    verify(ctx).flush();
  }

  /**
   * Test {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ChannelHandlerContext#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given EUnexpected(); then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected_thenCallsWrite() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> http2FlowControl.channelRead(ctx, new DefaultHttp2DataFrame(false)));
    verify(ctx).write(isA(Object.class));
  }

  /**
   * Test {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http2FlowControl#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2FlowControl.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContext_thenThrowEUnexpected() throws Exception {
    // Arrange
    Http2FlowControl http2FlowControl =
        new Http2FlowControl(1, "https://example.org/example", new Http2Settings());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> http2FlowControl.channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }
}

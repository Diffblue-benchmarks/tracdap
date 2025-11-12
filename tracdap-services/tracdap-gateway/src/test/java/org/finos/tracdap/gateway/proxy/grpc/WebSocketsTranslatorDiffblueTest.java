package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WebSocketsTranslatorDiffblueTest {
  /**
   * Test {@link WebSocketsTranslator#WebSocketsTranslator(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#WebSocketsTranslator(int)}
   */
  @Test
  @DisplayName("Test new WebSocketsTranslator(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.<init>(int)"})
  void testNewWebSocketsTranslator_whenOne() {
    // Arrange, Act and Assert
    assertFalse(new WebSocketsTranslator(1).isSharable());
  }

  /**
   * Test {@link WebSocketsTranslator#WebSocketsTranslator(int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#WebSocketsTranslator(int)}
   */
  @Test
  @DisplayName("Test new WebSocketsTranslator(int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.<init>(int)"})
  void testNewWebSocketsTranslator_whenTwo() {
    // Arrange, Act and Assert
    assertFalse(new WebSocketsTranslator(2).isSharable());
  }

  /**
   * Test {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link BinaryWebSocketFrame#BinaryWebSocketFrame()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when BinaryWebSocketFrame(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"
  })
  void testWrite_whenBinaryWebSocketFrame_thenThrowIllegalStateException() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            webSocketsTranslator.write(
                ctx,
                binaryWebSocketFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link CloseWebSocketFrame#CloseWebSocketFrame()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when CloseWebSocketFrame(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"
  })
  void testWrite_whenCloseWebSocketFrame_thenDoesNotThrow() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    CloseWebSocketFrame closeWebSocketFrame = new CloseWebSocketFrame();

    // Act and Assert
    assertDoesNotThrow(
        () ->
            webSocketsTranslator.write(
                ctx,
                closeWebSocketFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ContinuationWebSocketFrame#ContinuationWebSocketFrame()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ContinuationWebSocketFrame(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"
  })
  void testWrite_whenContinuationWebSocketFrame_thenDoesNotThrow() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    ContinuationWebSocketFrame continuationWebSocketFrame = new ContinuationWebSocketFrame();

    // Act and Assert
    assertDoesNotThrow(
        () ->
            webSocketsTranslator.write(
                ctx,
                continuationWebSocketFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"
  })
  void testWrite_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            webSocketsTranslator.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#fireChannelRead(Object)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext fireChannelRead(Object) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContextFireChannelReadThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> webSocketsTranslator.channelRead(ctx, new DefaultHttp2DataFrame(false)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#flush()} return {@link
   *       ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext flush() return ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContextFlushReturnChannelHandlerContext()
      throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsTranslator.channelRead(ctx, new DefaultHttp2DataFrame(true));

    // Assert
    verify(ctx, atLeast(1)).fireChannelRead(Mockito.<Object>any());
    verify(ctx).flush();
  }

  /**
   * Test {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#flush()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ChannelHandlerContext#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext flush() throw EUnexpected(); then calls flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContextFlushThrowEUnexpected_thenCallsFlush()
      throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new EUnexpected());
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> webSocketsTranslator.channelRead(ctx, new DefaultHttp2DataFrame(true)));
    verify(ctx, atLeast(1)).fireChannelRead(Mockito.<Object>any());
    verify(ctx).flush();
  }

  /**
   * Test {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContext_thenThrowEUnexpected() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> new WebSocketsTranslator(1).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2DataFrame#DefaultHttp2DataFrame(boolean)} with endStream is
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2DataFrame(boolean) with endStream is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsTranslator.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2DataFrameWithEndStreamIsFalse() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsTranslator.channelRead(ctx, new DefaultHttp2DataFrame(false));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }
}

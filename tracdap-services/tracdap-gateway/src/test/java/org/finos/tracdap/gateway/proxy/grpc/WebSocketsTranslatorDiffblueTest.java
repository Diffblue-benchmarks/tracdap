package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link BinaryWebSocketFrame#release()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); then calls release()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"
  })
  void testWrite_givenEUnexpected_thenCallsRelease() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    BinaryWebSocketFrame binaryWebSocketFrame = mock(BinaryWebSocketFrame.class);
    when(binaryWebSocketFrame.release()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            webSocketsTranslator.write(
                ctx,
                binaryWebSocketFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(binaryWebSocketFrame).release();
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
}

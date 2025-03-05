package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WebSocketsTranslatorDiffblueTest {
  /**
   * Test {@link WebSocketsTranslator#WebSocketsTranslator(int)}.
   * <p>
   * Method under test: {@link WebSocketsTranslator#WebSocketsTranslator(int)}
   */
  @Test
  @DisplayName("Test new WebSocketsTranslator(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsTranslator.<init>(int)"})
  void testNewWebSocketsTranslator() {
    // Arrange, Act and Assert
    assertFalse((new WebSocketsTranslator(1)).isSharable());
  }

  /**
   * Test {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsTranslator.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> webSocketsTranslator.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }
}

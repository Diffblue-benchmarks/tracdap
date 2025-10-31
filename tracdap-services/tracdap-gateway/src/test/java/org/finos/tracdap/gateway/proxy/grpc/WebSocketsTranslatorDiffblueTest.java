package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;

class WebSocketsTranslatorDiffblueTest {
  /**
   * Method under test: {@link WebSocketsTranslator#WebSocketsTranslator(int)}
   */
  @Test
  void testNewWebSocketsTranslator() {
    // Arrange, Act and Assert
    assertFalse((new WebSocketsTranslator(1)).isSharable());
  }

  /**
   * Method under test:
   * {@link WebSocketsTranslator#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    WebSocketsTranslator webSocketsTranslator = new WebSocketsTranslator(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> webSocketsTranslator.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }
}

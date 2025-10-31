package org.finos.tracdap.gateway.proxy.http;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.config.RouteConfig;
import org.junit.jupiter.api.Test;

class Http1to2ProxyDiffblueTest {
  /**
   * Method under test: {@link Http1to2Proxy#Http1to2Proxy(RouteConfig, int)}
   */
  @Test
  void testNewHttp1to2Proxy() {
    // Arrange, Act and Assert
    assertFalse((new Http1to2Proxy(RouteConfig.getDefaultInstance(), 1)).isSharable());
  }

  /**
   * Method under test:
   * {@link Http1to2Proxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite() throws Exception {
    // Arrange
    Http1to2Proxy http1to2Proxy = new Http1to2Proxy(RouteConfig.getDefaultInstance(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http1to2Proxy.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Method under test:
   * {@link Http1to2Proxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  void testWrite2() throws Exception {
    // Arrange
    Http1to2Proxy http1to2Proxy = new Http1to2Proxy(null, 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1to2Proxy.write(ctx, defaultLastHttpContent,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }
}

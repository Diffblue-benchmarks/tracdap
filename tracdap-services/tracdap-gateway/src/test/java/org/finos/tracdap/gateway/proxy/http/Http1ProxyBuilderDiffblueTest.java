package org.finos.tracdap.gateway.proxy.http;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalChannel;
import org.finos.tracdap.config.RouteConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http1ProxyBuilderDiffblueTest {
  /**
   * Method under test: {@link Http1ProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel() throws Exception {
    // Arrange
    ChannelDuplexHandler routerLink = mock(ChannelDuplexHandler.class);
    when(routerLink.isSharable()).thenReturn(true);
    doNothing().when(routerLink).handlerAdded(Mockito.<ChannelHandlerContext>any());
    Http1ProxyBuilder http1ProxyBuilder = new Http1ProxyBuilder(RouteConfig.getDefaultInstance(), routerLink, 1L);

    // Act
    http1ProxyBuilder.initChannel(new EmbeddedChannel());

    // Assert
    verify(routerLink).handlerAdded(isA(ChannelHandlerContext.class));
    verify(routerLink).isSharable();
  }

  /**
   * Method under test: {@link Http1ProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel2() {
    // Arrange
    ChannelDuplexHandler routerLink = mock(ChannelDuplexHandler.class);
    when(routerLink.isSharable()).thenReturn(true);
    Http1ProxyBuilder http1ProxyBuilder = new Http1ProxyBuilder(RouteConfig.getDefaultInstance(), routerLink, 1L);

    // Act
    http1ProxyBuilder.initChannel(new LocalChannel());

    // Assert
    verify(routerLink).isSharable();
  }
}

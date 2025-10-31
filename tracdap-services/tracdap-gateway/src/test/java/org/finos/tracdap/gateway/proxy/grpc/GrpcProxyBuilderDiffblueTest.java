package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel;
import org.finos.tracdap.common.exception.ENetworkHttp;
import org.finos.tracdap.config.RouteConfig;
import org.finos.tracdap.gateway.proxy.http.HttpProtocol;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcProxyBuilderDiffblueTest {
  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    grpcProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel2() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.HTTP_2_0, GrpcProtocol.GRPC);

    // Act and Assert
    assertThrows(ENetworkHttp.class, () -> grpcProxyBuilder.initChannel(new EmbeddedChannel()));
  }

  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel3() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.WEBSOCKETS, GrpcProtocol.GRPC);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    grpcProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel4() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC_WEB);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    grpcProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel5() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC_WEBSOCKETS);
    EmbeddedChannel channel = new EmbeddedChannel();

    // Act
    grpcProxyBuilder.initChannel(channel);

    // Assert
    ByteBufAllocator allocResult = channel.alloc();
    assertTrue(allocResult instanceof PooledByteBufAllocator);
    assertTrue(((PooledByteBufAllocator) allocResult).hasThreadLocalCache());
  }

  /**
   * Method under test: {@link GrpcProxyBuilder#initChannel(Channel)}
   */
  @Test
  void testInitChannel6() throws Exception {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();
    GrpcProxyBuilder grpcProxyBuilder = new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1,
        HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC);
    ChannelHandlerContext channelHandlerContext = mock(ChannelHandlerContext.class);
    when(channelHandlerContext.handler()).thenReturn(null);
    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.context(Mockito.<Class<ChannelHandler>>any())).thenReturn(channelHandlerContext);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.pipeline()).thenReturn(channelPipeline);

    GrpcProxy grpcProxy = new GrpcProxy(1);
    grpcProxy.handlerAdded(ctx);

    // Act
    grpcProxyBuilder.initChannel(new EmbeddedChannel(grpcProxy));

    // Assert
    verify(channelHandlerContext).handler();
    verify(ctx).pipeline();
    verify(channelPipeline).context(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link GrpcProxyBuilder#GrpcProxyBuilder(RouteConfig, ChannelDuplexHandler, int, HttpProtocol, GrpcProtocol)}
   */
  @Test
  void testNewGrpcProxyBuilder() {
    // Arrange
    RouteConfig routeConfig = RouteConfig.getDefaultInstance();

    // Act and Assert
    assertTrue(
        (new GrpcProxyBuilder(routeConfig, new ChannelDuplexHandler(), 1, HttpProtocol.HTTP_1_0, GrpcProtocol.GRPC))
            .isSharable());
  }
}

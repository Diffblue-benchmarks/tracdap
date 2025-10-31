package org.finos.tracdap.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import org.finos.tracdap.common.middleware.CommonConcerns;
import org.finos.tracdap.common.middleware.CommonNettyConcerns;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.finos.tracdap.common.middleware.SupportedProtocol;
import org.finos.tracdap.config.ServiceConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TracGatewayConfigDiffblueTest {
  /**
   * Method under test: {@link TracGatewayConfig#emptyConfig()}
   */
  @Test
  void testEmptyConfig() {
    // Arrange and Act
    CommonConcerns<NettyConcern> actualEmptyConfigResult = TracGatewayConfig.emptyConfig();

    // Assert
    assertTrue(actualEmptyConfigResult instanceof CommonNettyConcerns);
    assertEquals(TracGatewayConfig.TRAC_GATEWAY_CONCERNS, actualEmptyConfigResult.concernName());
  }

  /**
   * Method under test:
   * {@link TracGatewayConfig#coreConcerns(String, ServiceConfig)}
   */
  @Test
  void testCoreConcerns() {
    // Arrange and Act
    CommonConcerns<NettyConcern> actualCoreConcernsResult = TracGatewayConfig.coreConcerns("Service Name",
        ServiceConfig.getDefaultInstance());

    // Assert
    assertTrue(actualCoreConcernsResult instanceof CommonNettyConcerns);
    assertEquals(TracGatewayConfig.TRAC_GATEWAY_CONCERNS, actualCoreConcernsResult.concernName());
  }

  /**
   * Method under test: {@link TracGatewayConfig.IdleHandling#concernName()}
   */
  @Test
  void testIdleHandlingConcernName() {
    // Arrange, Act and Assert
    assertEquals(TracGatewayConfig.TRAC_IDLE_STATE,
        (new TracGatewayConfig.IdleHandling("Service Name", ServiceConfig.getDefaultInstance())).concernName());
  }

  /**
   * Method under test:
   * {@link TracGatewayConfig.IdleHandling#configureInboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  void testIdleHandlingConfigureInboundChannel() {
    // Arrange
    TracGatewayConfig.IdleHandling idleHandling = new TracGatewayConfig.IdleHandling("Service Name",
        ServiceConfig.getDefaultInstance());
    ChannelHandlerContext channelHandlerContext = mock(ChannelHandlerContext.class);
    when(channelHandlerContext.name()).thenReturn("Name");
    ChannelPipeline pipeline = mock(ChannelPipeline.class);
    when(pipeline.addAfter(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));
    when(pipeline.context(Mockito.<Class<ChannelHandler>>any())).thenReturn(channelHandlerContext);

    // Act
    idleHandling.configureInboundChannel(pipeline, SupportedProtocol.HTTP);

    // Assert
    verify(channelHandlerContext).name();
    verify(pipeline, atLeast(1)).addAfter(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(pipeline).context(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TracGatewayConfig.IdleHandling#configureInboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  void testIdleHandlingConfigureInboundChannel2() {
    // Arrange
    TracGatewayConfig.IdleHandling idleHandling = new TracGatewayConfig.IdleHandling("Service Name",
        ServiceConfig.getDefaultInstance());
    ChannelHandlerContext channelHandlerContext = mock(ChannelHandlerContext.class);
    when(channelHandlerContext.name()).thenReturn("Name");
    ChannelPipeline pipeline = mock(ChannelPipeline.class);
    when(pipeline.addAfter(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));
    when(pipeline.context(Mockito.<Class<ChannelHandler>>any())).thenReturn(channelHandlerContext);

    // Act
    idleHandling.configureInboundChannel(pipeline, SupportedProtocol.WEB_SOCKETS);

    // Assert
    verify(channelHandlerContext).name();
    verify(pipeline, atLeast(1)).addAfter(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(pipeline).context(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TracGatewayConfig.IdleHandling#IdleHandling(String, ServiceConfig)}
   */
  @Test
  void testIdleHandlingNewIdleHandling() {
    // Arrange, Act and Assert
    assertEquals(TracGatewayConfig.TRAC_IDLE_STATE,
        (new TracGatewayConfig.IdleHandling("Service Name", ServiceConfig.getDefaultInstance())).concernName());
  }
}

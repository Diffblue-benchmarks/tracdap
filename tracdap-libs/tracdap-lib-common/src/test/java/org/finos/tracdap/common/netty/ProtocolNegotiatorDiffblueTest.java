package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProtocolNegotiatorDiffblueTest {
  /**
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  void testInitChannel() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(true);
    when(mainHandler.websocketSupported()).thenReturn(true);
    ProtocolNegotiator protocolNegotiator = new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));

    // Act
    protocolNegotiator.initChannel(new NioSocketChannel());

    // Assert
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  void testInitChannel2() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(true);
    when(mainHandler.websocketSupported()).thenReturn(false);
    ProtocolNegotiator protocolNegotiator = new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));

    // Act
    protocolNegotiator.initChannel(new NioSocketChannel());

    // Assert
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  void testInitChannel3() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(true);
    when(mainHandler.websocketSupported()).thenReturn(true);
    ProtocolNegotiator protocolNegotiator = new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));
    Attribute<Object> attribute = mock(Attribute.class);
    doNothing().when(attribute).set(Mockito.<Object>any());
    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));
    NioSocketChannel channel = mock(NioSocketChannel.class);
    when(channel.pipeline()).thenReturn(channelPipeline);
    when(channel.attr(Mockito.<AttributeKey<Object>>any())).thenReturn(attribute);

    // Act
    protocolNegotiator.initChannel(channel);

    // Assert
    verify(channel).pipeline();
    verify(channelPipeline, atLeast(1)).addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  void testInitChannel4() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(false);
    when(mainHandler.websocketSupported()).thenReturn(true);
    ProtocolNegotiator protocolNegotiator = new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));
    Attribute<Object> attribute = mock(Attribute.class);
    doNothing().when(attribute).set(Mockito.<Object>any());
    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));
    NioSocketChannel channel = mock(NioSocketChannel.class);
    when(channel.pipeline()).thenReturn(channelPipeline);
    when(channel.attr(Mockito.<AttributeKey<Object>>any())).thenReturn(attribute);

    // Act
    protocolNegotiator.initChannel(channel);

    // Assert
    verify(channel).pipeline();
    verify(channelPipeline, atLeast(1)).addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Method under test:
   * {@link ProtocolNegotiator#ProtocolNegotiator(ProtocolHandler, NettyConcern)}
   */
  @Test
  void testNewProtocolNegotiator() {
    // Arrange, Act and Assert
    assertTrue((new ProtocolNegotiator(ProtocolHandler.create(), mock(NettyConcern.class))).isSharable());
  }
}

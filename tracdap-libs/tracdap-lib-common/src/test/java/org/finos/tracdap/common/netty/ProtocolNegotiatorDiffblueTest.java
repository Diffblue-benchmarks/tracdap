package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProtocolNegotiatorDiffblueTest {
  /**
   * Test {@link ProtocolNegotiator#ProtocolNegotiator(ProtocolHandler, NettyConcern)}.
   * <ul>
   *   <li>When create.</li>
   *   <li>Then return Sharable.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtocolNegotiator#ProtocolNegotiator(ProtocolHandler, NettyConcern)}
   */
  @Test
  @DisplayName("Test new ProtocolNegotiator(ProtocolHandler, NettyConcern); when create; then return Sharable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProtocolNegotiator.<init>(ProtocolHandler, NettyConcern)"})
  void testNewProtocolNegotiator_whenCreate_thenReturnSharable() {
    // Arrange, Act and Assert
    assertTrue((new ProtocolNegotiator(ProtocolHandler.create(), mock(NettyConcern.class))).isSharable());
  }

  /**
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   * <p>
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel() {
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
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   * <ul>
   *   <li>Given {@link Attribute} {@link Attribute#set(Object)} does nothing.</li>
   *   <li>Then calls {@link AbstractChannel#pipeline()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'; given Attribute set(Object) does nothing; then calls pipeline()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel_givenAttributeSetDoesNothing_thenCallsPipeline() {
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
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   * <ul>
   *   <li>Given {@link ProtocolHandler} {@link ProtocolHandler#http2Supported()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'; given ProtocolHandler http2Supported() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel_givenProtocolHandlerHttp2SupportedReturnFalse() {
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
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   * <ul>
   *   <li>When {@link NioSocketChannel#NioSocketChannel()}.</li>
   *   <li>Then calls {@link ProtocolHandler#http2Supported()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'; when NioSocketChannel(); then calls http2Supported()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel_whenNioSocketChannel_thenCallsHttp2Supported() {
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
}

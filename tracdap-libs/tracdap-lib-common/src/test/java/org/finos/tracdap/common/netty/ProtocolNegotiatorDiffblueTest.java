package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.finos.tracdap.common.middleware.CommonNettyConcerns;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProtocolNegotiatorDiffblueTest {
  /**
   * Test {@link ProtocolNegotiator#ProtocolNegotiator(ProtocolHandler, NettyConcern)}.
   *
   * <ul>
   *   <li>Then return Sharable.
   * </ul>
   *
   * <p>Method under test: {@link ProtocolNegotiator#ProtocolNegotiator(ProtocolHandler,
   * NettyConcern)}
   */
  @Test
  @DisplayName("Test new ProtocolNegotiator(ProtocolHandler, NettyConcern); then return Sharable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtocolNegotiator.<init>(ProtocolHandler, NettyConcern)"})
  void testNewProtocolNegotiator_thenReturnSharable() {
    // Arrange
    ProtocolHandler mainHandler = ProtocolHandler.create();

    // Act
    ProtocolNegotiator actualProtocolNegotiator =
        new ProtocolNegotiator(
            mainHandler, new CommonNettyConcerns(" -XX:MaxDirectMemorySize = 9  "));

    // Assert
    assertTrue(actualProtocolNegotiator.isSharable());
  }

  /**
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   *
   * <p>Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(true);
    when(mainHandler.websocketSupported()).thenReturn(true);
    ProtocolNegotiator protocolNegotiator =
        new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));

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
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   *
   * <p>Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel2() {
    // Arrange
    ProtocolHandler mainHandler = mock(ProtocolHandler.class);
    when(mainHandler.http2Supported()).thenReturn(true);
    when(mainHandler.websocketSupported()).thenReturn(false);
    ProtocolNegotiator protocolNegotiator =
        new ProtocolNegotiator(mainHandler, mock(NettyConcern.class));

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
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
    verify(mainHandler, atLeast(1)).http2Supported();
    verify(mainHandler).websocketSupported();
  }

  /**
   * Test {@link ProtocolNegotiator#initChannel(SocketChannel)} with {@code SocketChannel}.
   *
   * <ul>
   *   <li>Then calls {@link NioSocketChannel#pipeline()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtocolNegotiator#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'; then calls pipeline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProtocolNegotiator.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel_thenCallsPipeline() {
    // Arrange
    ProtocolNegotiator protocolNegotiator =
        new ProtocolNegotiator(ProtocolHandler.create(), mock(NettyConcern.class));

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
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
  }
}

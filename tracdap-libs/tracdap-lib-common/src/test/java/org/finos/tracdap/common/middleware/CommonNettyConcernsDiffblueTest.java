package org.finos.tracdap.common.middleware;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelPipeline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonNettyConcernsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CommonNettyConcerns#build()}
   *   <li>{@link CommonNettyConcerns#CommonNettyConcerns(String)}
   * </ul>
   */
  @Test
  void testBuild() {
    // Arrange and Act
    NettyConcern actualBuildResult = (new CommonNettyConcerns("Concern Name")).build();

    // Assert
    assertTrue(actualBuildResult instanceof CommonNettyConcerns);
    assertTrue(((CommonNettyConcerns) actualBuildResult).stageOrder.isEmpty());
    assertTrue(((CommonNettyConcerns) actualBuildResult).stages.isEmpty());
  }

  /**
   * Method under test:
   * {@link CommonNettyConcerns#configureInboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  void testConfigureInboundChannel() {
    // Arrange
    NettyConcern nettyConcern = mock(NettyConcern.class);
    when(nettyConcern.concernName()).thenReturn("Concern Name");
    doNothing().when(nettyConcern)
        .configureInboundChannel(Mockito.<ChannelPipeline>any(), Mockito.<SupportedProtocol>any());

    CommonNettyConcerns commonNettyConcerns = new CommonNettyConcerns("Concern Name");
    commonNettyConcerns.addFirst(nettyConcern);

    // Act
    commonNettyConcerns.configureInboundChannel(mock(ChannelPipeline.class), SupportedProtocol.UNKNOWN);

    // Assert that nothing has changed
    verify(nettyConcern, atLeast(1)).concernName();
    verify(nettyConcern).configureInboundChannel(isA(ChannelPipeline.class), eq(SupportedProtocol.UNKNOWN));
  }

  /**
   * Method under test:
   * {@link CommonNettyConcerns#configureOutboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  void testConfigureOutboundChannel() {
    // Arrange
    NettyConcern nettyConcern = mock(NettyConcern.class);
    when(nettyConcern.concernName()).thenReturn("Concern Name");
    doNothing().when(nettyConcern)
        .configureOutboundChannel(Mockito.<ChannelPipeline>any(), Mockito.<SupportedProtocol>any());

    CommonNettyConcerns commonNettyConcerns = new CommonNettyConcerns("Concern Name");
    commonNettyConcerns.addFirst(nettyConcern);

    // Act
    commonNettyConcerns.configureOutboundChannel(mock(ChannelPipeline.class), SupportedProtocol.UNKNOWN);

    // Assert that nothing has changed
    verify(nettyConcern, atLeast(1)).concernName();
    verify(nettyConcern).configureOutboundChannel(isA(ChannelPipeline.class), eq(SupportedProtocol.UNKNOWN));
  }
}

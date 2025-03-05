package org.finos.tracdap.common.middleware;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelPipeline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonNettyConcernsDiffblueTest {
  /**
   * Test {@link CommonNettyConcerns#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CommonNettyConcerns#build()}
   *   <li>{@link CommonNettyConcerns#CommonNettyConcerns(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommonNettyConcerns.<init>(String)", "NettyConcern CommonNettyConcerns.build()"})
  void testBuild() {
    // Arrange and Act
    NettyConcern actualBuildResult = (new CommonNettyConcerns("Concern Name")).build();

    // Assert
    assertTrue(actualBuildResult instanceof CommonNettyConcerns);
    assertTrue(((CommonNettyConcerns) actualBuildResult).stageOrder.isEmpty());
    assertTrue(((CommonNettyConcerns) actualBuildResult).stages.isEmpty());
  }

  /**
   * Test {@link CommonNettyConcerns#configureInboundChannel(ChannelPipeline, SupportedProtocol)}.
   * <ul>
   *   <li>Then calls {@link BaseConcern#concernName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonNettyConcerns#configureInboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  @DisplayName("Test configureInboundChannel(ChannelPipeline, SupportedProtocol); then calls concernName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommonNettyConcerns.configureInboundChannel(ChannelPipeline, SupportedProtocol)"})
  void testConfigureInboundChannel_thenCallsConcernName() {
    // Arrange
    NettyConcern nettyConcern = mock(NettyConcern.class);
    when(nettyConcern.concernName()).thenReturn("Concern Name");
    doNothing().when(nettyConcern)
        .configureInboundChannel(Mockito.<ChannelPipeline>any(), Mockito.<SupportedProtocol>any());

    CommonNettyConcerns commonNettyConcerns = new CommonNettyConcerns("Concern Name");
    commonNettyConcerns.addFirst(nettyConcern);

    // Act
    commonNettyConcerns.configureInboundChannel(mock(ChannelPipeline.class), SupportedProtocol.UNKNOWN);

    // Assert
    verify(nettyConcern, atLeast(1)).concernName();
    verify(nettyConcern).configureInboundChannel(isA(ChannelPipeline.class), eq(SupportedProtocol.UNKNOWN));
  }

  /**
   * Test {@link CommonNettyConcerns#configureOutboundChannel(ChannelPipeline, SupportedProtocol)}.
   * <ul>
   *   <li>Then calls {@link BaseConcern#concernName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonNettyConcerns#configureOutboundChannel(ChannelPipeline, SupportedProtocol)}
   */
  @Test
  @DisplayName("Test configureOutboundChannel(ChannelPipeline, SupportedProtocol); then calls concernName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommonNettyConcerns.configureOutboundChannel(ChannelPipeline, SupportedProtocol)"})
  void testConfigureOutboundChannel_thenCallsConcernName() {
    // Arrange
    NettyConcern nettyConcern = mock(NettyConcern.class);
    when(nettyConcern.concernName()).thenReturn("Concern Name");
    doNothing().when(nettyConcern)
        .configureOutboundChannel(Mockito.<ChannelPipeline>any(), Mockito.<SupportedProtocol>any());

    CommonNettyConcerns commonNettyConcerns = new CommonNettyConcerns("Concern Name");
    commonNettyConcerns.addFirst(nettyConcern);

    // Act
    commonNettyConcerns.configureOutboundChannel(mock(ChannelPipeline.class), SupportedProtocol.UNKNOWN);

    // Assert
    verify(nettyConcern, atLeast(1)).concernName();
    verify(nettyConcern).configureOutboundChannel(isA(ChannelPipeline.class), eq(SupportedProtocol.UNKNOWN));
  }
}

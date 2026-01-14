package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConnectionIdDiffblueTest {
  /**
   * Test {@link ConnectionId#get(Channel)}.
   *
   * <ul>
   *   <li>When {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionId#get(Channel)}
   */
  @Test
  @DisplayName("Test get(Channel); when EmbeddedChannel(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ConnectionId.get(Channel)"})
  void testGet_whenEmbeddedChannel_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, ConnectionId.get(new EmbeddedChannel()));
  }
}

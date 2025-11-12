package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConnectionIdDiffblueTest {
  /**
   * Test {@link ConnectionId#assign(Channel)}.
   *
   * <ul>
   *   <li>Given {@link Attribute} {@link Attribute#set(Object)} does nothing.
   *   <li>Then calls {@link Attribute#set(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionId#assign(Channel)}
   */
  @Test
  @DisplayName(
      "Test assign(Channel); given Attribute set(Object) does nothing; then calls set(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectionId.assign(Channel)"})
  void testAssign_givenAttributeSetDoesNothing_thenCallsSet() {
    // Arrange
    ConnectionId connectionId = new ConnectionId();

    Attribute<Object> attribute = mock(Attribute.class);
    doNothing().when(attribute).set(Mockito.<Object>any());

    EmbeddedChannel channel = mock(EmbeddedChannel.class);
    when(channel.attr(Mockito.<AttributeKey<Object>>any())).thenReturn(attribute);

    // Act
    connectionId.assign(channel);

    // Assert
    verify(attribute).set(isA(Object.class));
    verify(channel).attr(isA(AttributeKey.class));
  }

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

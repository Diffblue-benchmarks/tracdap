package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Frame;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Http2RouterDiffblueTest {
  /**
   * Test {@link Http2Router#Http2Router(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  @DisplayName("Test new Http2Router(List); given ArrayList(); when ArrayList() addAll ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.<init>(List)"})
  void testNewHttp2Router_givenArrayList_whenArrayListAddAllArrayList() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.addAll(new ArrayList<>());

    // Act and Assert
    assertFalse(new Http2Router(routes).isSharable());
  }

  /**
   * Test {@link Http2Router#Http2Router(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  @DisplayName("Test new Http2Router(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.<init>(List)"})
  void testNewHttp2Router_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);

    // Act and Assert
    assertFalse(new Http2Router(routes).isSharable());
  }

  /**
   * Test {@link Http2Router#Http2Router(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  @DisplayName("Test new Http2Router(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.<init>(List)"})
  void testNewHttp2Router_givenNull_whenArrayListAddNull2() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);
    routes.add(null);

    // Act and Assert
    assertFalse(new Http2Router(routes).isSharable());
  }

  /**
   * Test {@link Http2Router#Http2Router(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#Http2Router(List)}
   */
  @Test
  @DisplayName("Test new Http2Router(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.<init>(List)"})
  void testNewHttp2Router_whenArrayList() {
    // Arrange, Act and Assert
    assertFalse(new Http2Router(new ArrayList<>()).isSharable());
  }

  /**
   * Test {@link Http2Router#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link Http2Frame} {@link Http2Frame#name()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given EUnexpected(); when Http2Frame name() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected_whenHttp2FrameNameThrowEUnexpected() throws Exception {
    // Arrange
    Http2Router http2Router = new Http2Router(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http2Router.channelRead(ctx, http2Frame));
    verify(http2Frame).name();
  }

  /**
   * Test {@link Http2Router#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    Http2Router http2Router = new Http2Router(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenReturn("https://example.org/example");

    // Act
    http2Router.channelRead(ctx, http2Frame);

    // Assert
    verify(http2Frame).name();
  }

  /**
   * Test {@link Http2Router#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http2Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http2Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            new Http2Router(new ArrayList<>())
                .channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }
}

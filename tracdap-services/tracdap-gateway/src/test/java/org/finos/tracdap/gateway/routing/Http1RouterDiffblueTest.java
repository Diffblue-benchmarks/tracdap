package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.gateway.exec.Redirect;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Http1RouterDiffblueTest {
  /**
   * Test {@link Http1Router#Http1Router(List, List, int)}.
   *
   * <p>Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<Redirect> redirects = new ArrayList<>();

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    assertEquals("HTTP/1", actualHttp1Router.protocol);
    assertNull(actualHttp1Router.bootstrap);
    assertEquals(1, actualHttp1Router.connId);
    assertTrue(redirects.isEmpty());
    assertTrue(actualHttp1Router.redirects.isEmpty());
    assertTrue(actualHttp1Router.routes.isEmpty());
  }

  /**
   * Test {@link Http1Router#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when DefaultLastHttpContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultLastHttpContent() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> http1Router.channelRead(ctx, new DefaultLastHttpContent()));
  }

  /**
   * Test {@link Http1Router#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> http1Router.channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)}
   *       with channel is {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given DefaultChannelProgressivePromise(Channel) with channel is EmbeddedChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenDefaultChannelProgressivePromiseWithChannelIsEmbeddedChannel() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act
    http1Router.write(
        ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#write(Object,
   *       ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http1Router.write(
                ctx,
                defaultLastHttpContent,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            http1Router.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <p>Method under test: {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    http1Router.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).close();
  }

  /**
   * Test {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Http1Router.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.exceptionCaught(ctx, new Throwable()));
    verify(ctx).close();
  }

  /**
   * Test {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <p>Method under test: {@link Http1Router#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Http1Router.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    http1Router.reportProxyRouteError(ctx, new Throwable(), true);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Http1Router#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName(
      "Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Http1Router.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> http1Router.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).writeAndFlush(isA(Object.class));
  }
}

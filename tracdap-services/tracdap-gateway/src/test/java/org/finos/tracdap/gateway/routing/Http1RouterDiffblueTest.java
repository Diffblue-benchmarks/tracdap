package org.finos.tracdap.gateway.routing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultHttpContent;
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int); given 'null'; when ArrayList() add 'null'; then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router_givenNull_whenArrayListAddNull_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    ArrayList<Redirect> redirects = new ArrayList<>();
    redirects.add(null);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    assertEquals(1, redirects.size());
    List<Redirect> redirectList = actualHttp1Router.redirects;
    assertEquals(1, redirectList.size());
    assertNull(redirectList.get(0));
    assertTrue(actualHttp1Router.routes.isEmpty());
  }

  /**
   * Test {@link Http1Router#Http1Router(List, List, int)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link CoreRouter#redirects} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int); given 'null'; when ArrayList() add 'null'; then return redirects size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router_givenNull_whenArrayListAddNull_thenReturnRedirectsSizeIsTwo() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    ArrayList<Redirect> redirects = new ArrayList<>();
    redirects.add(null);
    redirects.add(null);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    List<Redirect> redirectList = actualHttp1Router.redirects;
    assertEquals(2, redirectList.size());
    assertNull(redirectList.get(0));
    assertNull(redirectList.get(1));
    assertTrue(actualHttp1Router.routes.isEmpty());
  }

  /**
   * Test {@link Http1Router#Http1Router(List, List, int)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link CoreRouter#routes} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int); given 'null'; when ArrayList() add 'null'; then return routes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router_givenNull_whenArrayListAddNull_thenReturnRoutesSizeIsOne() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);
    ArrayList<Redirect> redirects = new ArrayList<>();

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, redirects, 1);

    // Assert
    List<Route> routeList = actualHttp1Router.routes;
    assertEquals(1, routeList.size());
    assertNull(routeList.get(0));
    assertTrue(redirects.isEmpty());
    assertTrue(actualHttp1Router.redirects.isEmpty());
  }

  /**
   * Test {@link Http1Router#Http1Router(List, List, int)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link CoreRouter#routes} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int); given 'null'; when ArrayList() add 'null'; then return routes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router_givenNull_whenArrayListAddNull_thenReturnRoutesSizeIsTwo() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);
    routes.add(null);

    // Act
    Http1Router actualHttp1Router = new Http1Router(routes, new ArrayList<>(), 1);

    // Assert
    List<Route> routeList = actualHttp1Router.routes;
    assertEquals(2, routeList.size());
    assertNull(routeList.get(0));
    assertNull(routeList.get(1));
    assertTrue(actualHttp1Router.redirects.isEmpty());
  }

  /**
   * Test {@link Http1Router#Http1Router(List, List, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#Http1Router(List, List, int)}
   */
  @Test
  @DisplayName("Test new Http1Router(List, List, int); when ArrayList(); then ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.<init>(List, List, int)"})
  void testNewHttp1Router_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<Redirect> redirects = new ArrayList<>();

    // Act
    new Http1Router(routes, redirects, 1);

    // Assert
    assertTrue(redirects.isEmpty());
  }

  /**
   * Test {@link Http1Router#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link AdaptiveByteBufAllocator#AdaptiveByteBufAllocator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when EmptyByteBuf(ByteBufAllocator) with alloc is AdaptiveByteBufAllocator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenEmptyByteBufWithAllocIsAdaptiveByteBufAllocator() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.channelRead(ctx,
        new DefaultHttpContent(new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())))));
  }

  /**
   * Test {@link Http1Router#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when 'Msg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new Http1Router(routes, new ArrayList<>(), 1)).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)} with channel is {@link EmbeddedChannel#EmbeddedChannel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given DefaultChannelProgressivePromise(Channel) with channel is EmbeddedChannel()")
  @Tag("MaintainedByDiffblue")
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
    http1Router.write(ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelOutboundInvoker#write(Object, ChannelPromise)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when ChannelHandlerContext write(Object, ChannelPromise) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenChannelHandlerContextWriteThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenThrow(new EUnexpected());
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.write(ctx, defaultLastHttpContent,
        new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> http1Router.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}.
   * <p>
   * Method under test: {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"})
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
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Http1Router#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Http1Router.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"})
  void testReportProxyRouteError_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    Http1Router http1Router = new Http1Router(routes, new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> http1Router.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).writeAndFlush(isA(Object.class));
  }
}

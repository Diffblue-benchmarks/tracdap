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
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.socket.nio.NioServerDomainSocketChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.gateway.exec.Route;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WebSocketsRouterDiffblueTest {
  /**
   * Test {@link WebSocketsRouter#WebSocketsRouter(List, int)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link CoreRouter#routes} size is one.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName(
      "Test new WebSocketsRouter(List, int); given 'null'; when ArrayList() add 'null'; then return routes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.<init>(List, int)"})
  void testNewWebSocketsRouter_givenNull_whenArrayListAddNull_thenReturnRoutesSizeIsOne() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);

    // Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(routes, 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    List<Route> routeList = actualWebSocketsRouter.routes;
    assertEquals(1, routeList.size());
    assertNull(routeList.get(0));
    assertEquals(1, actualWebSocketsRouter.connId);
  }

  /**
   * Test {@link WebSocketsRouter#WebSocketsRouter(List, int)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link CoreRouter#routes} size is two.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName(
      "Test new WebSocketsRouter(List, int); given 'null'; when ArrayList() add 'null'; then return routes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.<init>(List, int)"})
  void testNewWebSocketsRouter_givenNull_whenArrayListAddNull_thenReturnRoutesSizeIsTwo() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);
    routes.add(null);

    // Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(routes, 1);

    // Assert
    List<Route> routeList = actualWebSocketsRouter.routes;
    assertEquals(2, routeList.size());
    assertNull(routeList.get(0));
    assertNull(routeList.get(1));
    assertEquals(1, actualWebSocketsRouter.connId);
  }

  /**
   * Test {@link WebSocketsRouter#WebSocketsRouter(List, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link CoreRouter#routes} Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName("Test new WebSocketsRouter(List, int); when ArrayList(); then return routes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.<init>(List, int)"})
  void testNewWebSocketsRouter_whenArrayList_thenReturnRoutesEmpty() {
    // Arrange and Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    assertEquals(1, actualWebSocketsRouter.connId);
    assertTrue(actualWebSocketsRouter.routes.isEmpty());
  }

  /**
   * Test {@link WebSocketsRouter#WebSocketsRouter(List, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@link CoreRouter#connId} is two.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName("Test new WebSocketsRouter(List, int); when two; then return connId is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.<init>(List, int)"})
  void testNewWebSocketsRouter_whenTwo_thenReturnConnIdIsTwo() {
    // Arrange and Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 2);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    assertEquals(2, actualWebSocketsRouter.connId);
    assertTrue(actualWebSocketsRouter.routes.isEmpty());
  }

  /**
   * Test {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test userEventTriggered(ChannelHandlerContext, Object); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.userEventTriggered(ChannelHandlerContext, Object)"})
  void testUserEventTriggered_givenChannelHandlerContext() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any()))
        .thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.userEventTriggered(ctx, "Evt");

    // Assert
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test userEventTriggered(ChannelHandlerContext, Object); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.userEventTriggered(ChannelHandlerContext, Object)"})
  void testUserEventTriggered_givenEUnexpected_thenThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.userEventTriggered(ctx, "Evt"));
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>When {@link BinaryWebSocketFrame#BinaryWebSocketFrame()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when BinaryWebSocketFrame()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenBinaryWebSocketFrame() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new BinaryWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>When {@link CloseWebSocketFrame#CloseWebSocketFrame()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when CloseWebSocketFrame()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenCloseWebSocketFrame() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new CloseWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when DefaultLastHttpContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenDefaultLastHttpContent() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new DefaultLastHttpContent());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>When {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenMsg() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, "Msg");

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected_thenThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.channelRead(ctx, "Msg"));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_thenThrowEUnexpected() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            webSocketsRouter.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link BinaryWebSocketFrame#BinaryWebSocketFrame()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when BinaryWebSocketFrame()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenBinaryWebSocketFrame() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame();

    // Act
    webSocketsRouter.write(
        ctx, binaryWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link CloseWebSocketFrame#CloseWebSocketFrame()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when CloseWebSocketFrame()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenCloseWebSocketFrame() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    CloseWebSocketFrame closeWebSocketFrame = new CloseWebSocketFrame();

    // Act
    webSocketsRouter.write(
        ctx, closeWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultLastHttpContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultLastHttpContent() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act
    webSocketsRouter.write(
        ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object,
   * ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenMsg() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    webSocketsRouter.write(ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)}
   *       with channel is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given DefaultChannelProgressivePromise(Channel) with channel is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenDefaultChannelProgressivePromiseWithChannelIsNull() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(null));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)}
   *       with channel is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given DefaultChannelProgressivePromise(Channel) with channel is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenDefaultChannelProgressivePromiseWithChannelIsNull2() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(null));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.newPromise()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.exceptionCaught(ctx, new Throwable()));
    verify(ctx).newPromise();
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()} writeAndFlush {@code Msg}.
   *   <li>When {@link Throwable#Throwable(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EmbeddedChannel() writeAndFlush 'Msg'; when Throwable(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEmbeddedChannelWriteAndFlushMsg_whenThrowableWithFoo() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    EmbeddedChannel channel = new EmbeddedChannel();
    channel.writeAndFlush("Msg");
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        new DefaultChannelProgressivePromise(channel);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable("foo"));

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link WebSocketsRouter#WebSocketsRouter(List, int)} with routes is {@link
   *       ArrayList#ArrayList()} and connId is ten.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given WebSocketsRouter(List, int) with routes is ArrayList() and connId is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenWebSocketsRouterWithRoutesIsArrayListAndConnIdIsTen() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 10);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code conn = {}, sending close request
   *       with code [{}, {}]: {}}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); when IOException(String) with 'conn = {}, sending close request with code [{}, {}]: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_whenIOExceptionWithConnSendingCloseRequestWithCode() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.exceptionCaught(
        ctx, new IOException("conn = {}, sending close request with code [{}, {}]: {}"));

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError2() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new NioServerDomainSocketChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName(
      "Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.newPromise()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).newPromise();
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#writeAndFlush(Object,
   *       ChannelPromise)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName(
      "Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); when ChannelHandlerContext writeAndFlush(Object, ChannelPromise) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError_whenChannelHandlerContextWriteAndFlushReturnNull() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenReturn(null);
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx, new Throwable("foo"), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#writeAndFlush(Object,
   *       ChannelPromise)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName(
      "Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); when ChannelHandlerContext writeAndFlush(Object, ChannelPromise) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError_whenChannelHandlerContextWriteAndFlushReturnNull2() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any())).thenReturn(null);
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx, new Throwable("foo"), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code conn = {}, sending close request
   *       with code [{}, {}]: {}}.
   * </ul>
   *
   * <p>Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext,
   * Throwable, boolean)}
   */
  @Test
  @DisplayName(
      "Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); when IOException(String) with 'conn = {}, sending close request with code [{}, {}]: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"
  })
  void testReportProxyRouteError_whenIOExceptionWithConnSendingCloseRequestWithCode() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(
        ctx, new IOException("conn = {}, sending close request with code [{}, {}]: {}"), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }
}

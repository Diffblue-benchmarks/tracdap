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
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link CoreRouter#routes} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName("Test new WebSocketsRouter(List, int); given 'null'; when ArrayList() add 'null'; then return routes size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link CoreRouter#routes} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName("Test new WebSocketsRouter(List, int); given 'null'; when ArrayList() add 'null'; then return routes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.<init>(List, int)"})
  void testNewWebSocketsRouter_givenNull_whenArrayListAddNull_thenReturnRoutesSizeIsTwo() {
    // Arrange
    ArrayList<Route> routes = new ArrayList<>();
    routes.add(null);
    routes.add(null);

    // Act
    WebSocketsRouter actualWebSocketsRouter = new WebSocketsRouter(routes, 1);

    // Assert
    assertEquals("websockets", actualWebSocketsRouter.protocol);
    assertNull(actualWebSocketsRouter.bootstrap);
    assertNull(actualWebSocketsRouter.redirects);
    List<Route> routeList = actualWebSocketsRouter.routes;
    assertEquals(2, routeList.size());
    assertNull(routeList.get(0));
    assertNull(routeList.get(1));
    assertEquals(1, actualWebSocketsRouter.connId);
  }

  /**
   * Test {@link WebSocketsRouter#WebSocketsRouter(List, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link CoreRouter#routes} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#WebSocketsRouter(List, int)}
   */
  @Test
  @DisplayName("Test new WebSocketsRouter(List, int); when ArrayList(); then return routes Empty")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#userEventTriggered(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test userEventTriggered(ChannelHandlerContext, Object); then calls fireUserEventTriggered(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.userEventTriggered(ChannelHandlerContext, Object)"})
  void testUserEventTriggered_thenCallsFireUserEventTriggered() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.userEventTriggered(ctx, "Evt");

    // Assert
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.</li>
   *   <li>When {@code Msg}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when 'Msg'; then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenMsg_thenCallsFireChannelRead() throws Exception {
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
   * <ul>
   *   <li>When {@link BinaryWebSocketFrame#BinaryWebSocketFrame()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when BinaryWebSocketFrame(); then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenBinaryWebSocketFrame_thenCallsFireChannelRead() throws Exception {
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
   * <ul>
   *   <li>When {@link CloseWebSocketFrame#CloseWebSocketFrame()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when CloseWebSocketFrame(); then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenCloseWebSocketFrame_thenCallsFireChannelRead() throws Exception {
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
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when DefaultLastHttpContent(); then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultLastHttpContent_thenCallsFireChannelRead() throws Exception {
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
   * <ul>
   *   <li>When {@link TextWebSocketFrame#TextWebSocketFrame()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when TextWebSocketFrame(); then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenTextWebSocketFrame_thenCallsFireChannelRead() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    webSocketsRouter.channelRead(ctx, new TextWebSocketFrame());

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link BinaryWebSocketFrame#BinaryWebSocketFrame()}.</li>
   *   <li>Then calls {@link ChannelOutboundInvoker#write(Object, ChannelPromise)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when BinaryWebSocketFrame(); then calls write(Object, ChannelPromise)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenBinaryWebSocketFrame_thenCallsWrite() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame();

    // Act
    webSocketsRouter.write(ctx, binaryWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link CloseWebSocketFrame#CloseWebSocketFrame()}.</li>
   *   <li>Then calls {@link ChannelOutboundInvoker#write(Object, ChannelPromise)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when CloseWebSocketFrame(); then calls write(Object, ChannelPromise)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenCloseWebSocketFrame_thenCallsWrite() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    CloseWebSocketFrame closeWebSocketFrame = new CloseWebSocketFrame();

    // Act
    webSocketsRouter.write(ctx, closeWebSocketFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.</li>
   *   <li>Then calls {@link ChannelOutboundInvoker#write(Object, ChannelPromise)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultLastHttpContent(); then calls write(Object, ChannelPromise)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultLastHttpContent_thenCallsWrite() throws Exception {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act
    webSocketsRouter.write(ctx, defaultLastHttpContent, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then calls {@link ChannelOutboundInvoker#write(Object, ChannelPromise)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'; then calls write(Object, ChannelPromise)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenMsg_thenCallsWrite() throws Exception {
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
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#executor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given DefaultEventLoop(); then calls executor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenDefaultEventLoop_thenCallsExecutor() {
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
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code conn = {}, sending close request with code [{}, {}]: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); when IOException(String) with 'conn = {}, sending close request with code [{}, {}]: {}'")
  @Tag("MaintainedByDiffblue")
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
    webSocketsRouter.exceptionCaught(ctx, new IOException("conn = {}, sending close request with code [{}, {}]: {}"));

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#executor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); given DefaultEventLoop(); then calls executor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"})
  void testReportProxyRouteError_givenDefaultEventLoop_thenCallsExecutor() {
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
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"})
  void testReportProxyRouteError_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.newPromise()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> webSocketsRouter.reportProxyRouteError(ctx, new Throwable(), true));
    verify(ctx).newPromise();
  }

  /**
   * Test {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code conn = {}, sending close request with code [{}, {}]: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketsRouter#reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)}
   */
  @Test
  @DisplayName("Test reportProxyRouteError(ChannelHandlerContext, Throwable, boolean); when IOException(String) with 'conn = {}, sending close request with code [{}, {}]: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketsRouter.reportProxyRouteError(ChannelHandlerContext, Throwable, boolean)"})
  void testReportProxyRouteError_whenIOExceptionWithConnSendingCloseRequestWithCode() {
    // Arrange
    WebSocketsRouter webSocketsRouter = new WebSocketsRouter(new ArrayList<>(), 1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.newPromise()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.executor()).thenReturn(new DefaultEventLoop());

    // Act
    webSocketsRouter.reportProxyRouteError(ctx,
        new IOException("conn = {}, sending close request with code [{}, {}]: {}"), true);

    // Assert
    verify(ctx).executor();
    verify(ctx).newPromise();
    verify(ctx).writeAndFlush(isA(Object.class), isA(ChannelPromise.class));
  }
}

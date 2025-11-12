package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalServerChannel;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.DefaultHttp2PingFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RestApiProxyDiffblueTest {
  /**
   * Test {@link RestApiProxy#RestApiProxy(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#RestApiProxy(List)}
   */
  @Test
  @DisplayName(
      "Test new RestApiProxy(List); given ArrayList(); when ArrayList() addAll ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.<init>(List)"})
  void testNewRestApiProxy_givenArrayList_whenArrayListAddAllArrayList() {
    // Arrange
    ArrayList<RestApiMethod<?, ?>> methods = new ArrayList<>();
    methods.addAll(new ArrayList<>());

    // Act and Assert
    assertFalse(new RestApiProxy(methods).isSharable());
  }

  /**
   * Test {@link RestApiProxy#RestApiProxy(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#RestApiProxy(List)}
   */
  @Test
  @DisplayName("Test new RestApiProxy(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.<init>(List)"})
  void testNewRestApiProxy_whenArrayList() {
    // Arrange, Act and Assert
    assertFalse(new RestApiProxy(new ArrayList<>()).isSharable());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <p>Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName("Test write(ChannelHandlerContext, Object, ChannelPromise)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite() throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(false);
    DefaultChannelProgressivePromise promise =
        new DefaultChannelProgressivePromise(new LocalServerChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2DataFrame, promise);

    // Assert
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Then {@link DefaultChannelProgressivePromise#DefaultChannelProgressivePromise(Channel)}
   *       with channel is {@link EmbeddedChannel#EmbeddedChannel()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); then DefaultChannelProgressivePromise(Channel) with channel is EmbeddedChannel() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_thenDefaultChannelProgressivePromiseWithChannelIsEmbeddedChannelIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(false);
    DefaultChannelProgressivePromise promise =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    restApiProxy.write(ctx, defaultHttp2DataFrame, promise);

    // Assert
    verify(ctx, atLeast(1)).alloc();
    assertNull(promise.get());
    assertTrue(promise.isDone());
  }

  /**
   * Test {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ChannelHandlerContext; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenChannelHandlerContext_thenThrowEUnexpected() {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            restApiProxy.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEUnexpected() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> restApiProxy.channelRead(ctx, new DefaultHttp2GoAwayFrame(-1L)));
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2GoAwayFrame#DefaultHttp2GoAwayFrame(long)} with errorCode is
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2GoAwayFrame(long) with errorCode is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2GoAwayFrameWithErrorCodeIsMinusOne() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.channelRead(ctx, new DefaultHttp2GoAwayFrame(-1L));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2PingFrame#DefaultHttp2PingFrame(long)} with content is one.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when DefaultHttp2PingFrame(long) with content is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultHttp2PingFrameWithContentIsOne() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.channelRead(ctx, new DefaultHttp2PingFrame(1L));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg_thenThrowEUnexpected() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            new RestApiProxy(new ArrayList<>())
                .channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenChannelHandlerContext() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireExceptionCaught(Mockito.<Throwable>any()))
        .thenReturn(mock(ChannelHandlerContext.class));

    // Act
    restApiProxy.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).fireExceptionCaught(isA(Throwable.class));
  }

  /**
   * Test {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiProxy#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RestApiProxy.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEUnexpected_thenThrowEUnexpected() throws Exception {
    // Arrange
    RestApiProxy restApiProxy = new RestApiProxy(new ArrayList<>());

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireExceptionCaught(Mockito.<Throwable>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> restApiProxy.exceptionCaught(ctx, new Throwable()));
    verify(ctx).fireExceptionCaught(isA(Throwable.class));
  }
}

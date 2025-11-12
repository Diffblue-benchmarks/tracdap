package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.Http2Frame;
import io.netty.handler.codec.http2.ReadOnlyHttp2Headers;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcWebProxyDiffblueTest {
  /**
   * Test {@link GrpcWebProxy#GrpcWebProxy(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcWebProxy(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.<init>(int)"})
  void testNewGrpcWebProxy_whenOne() {
    // Arrange, Act and Assert
    assertFalse(new GrpcWebProxy(1).isSharable());
  }

  /**
   * Test {@link GrpcWebProxy#GrpcWebProxy(int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcWebProxy(int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.<init>(int)"})
  void testNewGrpcWebProxy_whenTwo() {
    // Arrange, Act and Assert
    assertFalse(new GrpcWebProxy(2).isSharable());
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link DefaultHttp2DataFrame#DefaultHttp2DataFrame(boolean)} with endStream is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when DefaultHttp2DataFrame(boolean) with endStream is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenDefaultHttp2DataFrameWithEndStreamIsTrue() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2DataFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link Http2Frame} {@link Http2Frame#name()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link Http2Frame#name()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given EUnexpected(); when Http2Frame name() throw EUnexpected(); then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenEUnexpected_whenHttp2FrameNameThrowEUnexpected_thenCallsName() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx, http2Frame, new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(http2Frame).name();
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenHttpsExampleOrgExample() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenReturn("https://example.org/example");

    // Act
    grpcWebProxy.write(
        ctx, http2Frame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(http2Frame).name();
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenHttpsExampleOrgExample2() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx, http2Frame, new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(http2Frame).name();
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given lineSeparator.
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#get(CharSequence)} return
   *       lineSeparator.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given lineSeparator; when ReadOnlyHttp2Headers get(CharSequence) return lineSeparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenLineSeparator_whenReadOnlyHttp2HeadersGetReturnLineSeparator() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new RuntimeException());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.get(Mockito.<CharSequence>any())).thenReturn(System.lineSeparator());
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(headers);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(headers).get(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#remove(CharSequence)}
   *       return {@code true}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#add(CharSequence, CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); given 'true'; when ReadOnlyHttp2Headers remove(CharSequence) return 'true'; then calls add(CharSequence, CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_givenTrue_whenReadOnlyHttp2HeadersRemoveReturnTrue_thenCallsAdd() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new RuntimeException());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.remove(Mockito.<CharSequence>any())).thenReturn(true);
    when(headers.add(Mockito.<CharSequence>any(), Mockito.<CharSequence>any()))
        .thenReturn(new DefaultHttp2Headers());
    when(headers.get(Mockito.<CharSequence>any())).thenReturn("application/grpc-web");
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(headers);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
    verify(headers, atLeast(1)).add(Mockito.<CharSequence>any(), Mockito.<CharSequence>any());
    verify(headers).get(isA(CharSequence.class));
    verify(headers).remove(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2DataFrame#DefaultHttp2DataFrame(boolean)} with endStream is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2DataFrame(boolean) with endStream is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2DataFrameWithEndStreamIsTrue() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(true);

    // Act
    grpcWebProxy.write(
        ctx, defaultHttp2DataFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers
   *       is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());

    // Act
    grpcWebProxy.write(
        ctx, defaultHttp2HeadersFrame, new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2HeadersFrame#DefaultHttp2HeadersFrame(Http2Headers)} with headers
   *       is {@link DefaultHttp2Headers#DefaultHttp2Headers()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultHttp2HeadersFrame(Http2Headers) with headers is DefaultHttp2Headers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultHttp2HeadersFrameWithHeadersIsDefaultHttp2Headers2() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.write(Mockito.<Object>any(), Mockito.<ChannelPromise>any()))
        .thenThrow(new EUnexpected());
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame =
        new DefaultHttp2HeadersFrame(new DefaultHttp2Headers());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(ctx).write(isA(Object.class), isA(ChannelPromise.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when DefaultLastHttpContent(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenDefaultLastHttpContent_thenThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent();

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultLastHttpContent,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenMsg_thenThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx, "Msg", new DefaultChannelProgressivePromise(new EmbeddedChannel())));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#get(CharSequence)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#get(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ReadOnlyHttp2Headers get(CharSequence) throw EUnexpected(); then calls get(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenReadOnlyHttp2HeadersGetThrowEUnexpected_thenCallsGet() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.get(Mockito.<CharSequence>any())).thenThrow(new EUnexpected());
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(headers);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(headers).get(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#remove(CharSequence)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#remove(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#write(ChannelHandlerContext, Object, ChannelPromise)}
   */
  @Test
  @DisplayName(
      "Test write(ChannelHandlerContext, Object, ChannelPromise); when ReadOnlyHttp2Headers remove(CharSequence) throw EUnexpected(); then calls remove(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.write(ChannelHandlerContext, Object, ChannelPromise)"})
  void testWrite_whenReadOnlyHttp2HeadersRemoveThrowEUnexpected_thenCallsRemove() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.remove(Mockito.<CharSequence>any())).thenThrow(new EUnexpected());
    when(headers.get(Mockito.<CharSequence>any())).thenReturn("application/grpc-web");
    DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(headers);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.write(
                ctx,
                defaultHttp2HeadersFrame,
                new DefaultChannelProgressivePromise(new EmbeddedChannel())));
    verify(headers).get(isA(CharSequence.class));
    verify(headers).remove(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());

    // Act
    grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers()));

    // Assert
    verify(ctx).alloc();
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link DefaultHttp2Headers#DefaultHttp2Headers()}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#add(CharSequence, CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given DefaultHttp2Headers(); then calls add(CharSequence, CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenDefaultHttp2Headers_thenCallsAdd() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new RuntimeException());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.remove(Mockito.<CharSequence>any())).thenReturn(true);
    when(headers.add(Mockito.<CharSequence>any(), Mockito.<CharSequence>any()))
        .thenReturn(new DefaultHttp2Headers());
    when(headers.get(Mockito.<CharSequence>any())).thenReturn("application/grpc");
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(ctx).fireChannelRead(isA(Object.class));
    verify(headers).add(isA(CharSequence.class), isA(CharSequence.class));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).get(isA(CharSequence.class));
    verify(headers).remove(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given 'false'; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenFalse_thenCallsIterator() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new RuntimeException());
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(false);

    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(ctx).alloc();
    verify(ctx).fireChannelRead(isA(Object.class));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).iterator();
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenHttpsExampleOrgExample() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenReturn("https://example.org/example");

    // Act
    grpcWebProxy.channelRead(ctx, http2Frame);

    // Assert
    verify(http2Frame).name();
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#get(CharSequence)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given 'null'; when ReadOnlyHttp2Headers get(CharSequence) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenNull_whenReadOnlyHttp2HeadersGetReturnNull() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new RuntimeException());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.get(Mockito.<CharSequence>any())).thenReturn(null);
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(ctx).fireChannelRead(isA(Object.class));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).get(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link PooledByteBufAllocator#PooledByteBufAllocator()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given PooledByteBufAllocator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenPooledByteBufAllocator() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    when(ctx.alloc()).thenReturn(new PooledByteBufAllocator());

    // Act
    grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers()));

    // Assert
    verify(ctx).alloc();
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#alloc()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ChannelHandlerContext#alloc()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext alloc() throw EUnexpected(); then calls alloc()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContextAllocThrowEUnexpected_thenCallsAlloc() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.alloc()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers())));
    verify(ctx).alloc();
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#fireChannelRead(Object)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ChannelHandlerContext fireChannelRead(Object) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenChannelHandlerContextFireChannelReadThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new EUnexpected());
    when(ctx.alloc()).thenReturn(new AdaptiveByteBufAllocator());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(new DefaultHttp2Headers())));
    verify(ctx).alloc();
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link DefaultLastHttpContent#DefaultLastHttpContent()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when DefaultLastHttpContent(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenDefaultLastHttpContent_thenThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> grpcWebProxy.channelRead(ctx, new DefaultLastHttpContent()));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link Http2Frame} {@link Http2Frame#name()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link Http2Frame#name()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when Http2Frame name() throw EUnexpected(); then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenHttp2FrameNameThrowEUnexpected_thenCallsName() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    Http2Frame http2Frame = mock(Http2Frame.class);
    when(http2Frame.name()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> grpcWebProxy.channelRead(ctx, http2Frame));
    verify(http2Frame).name();
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when 'Msg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> new GrpcWebProxy(1).channelRead(mock(ChannelHandlerContext.class), "Msg"));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#contains(CharSequence)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ReadOnlyHttp2Headers contains(CharSequence) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenReadOnlyHttp2HeadersContainsThrowEUnexpected() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.contains(Mockito.<CharSequence>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(headers).contains(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#get(CharSequence)} return
   *       lineSeparator.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ReadOnlyHttp2Headers get(CharSequence) return lineSeparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenReadOnlyHttp2HeadersGetReturnLineSeparator() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenThrow(new RuntimeException());

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.get(Mockito.<CharSequence>any())).thenReturn(System.lineSeparator());
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(ctx).fireChannelRead(isA(Object.class));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).get(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#get(CharSequence)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#get(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ReadOnlyHttp2Headers get(CharSequence) throw EUnexpected(); then calls get(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenReadOnlyHttp2HeadersGetThrowEUnexpected_thenCallsGet() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.get(Mockito.<CharSequence>any())).thenThrow(new EUnexpected());
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).get(isA(CharSequence.class));
  }

  /**
   * Test {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#remove(CharSequence)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ReadOnlyHttp2Headers#remove(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when ReadOnlyHttp2Headers remove(CharSequence) throw EUnexpected(); then calls remove(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenReadOnlyHttp2HeadersRemoveThrowEUnexpected_thenCallsRemove() {
    // Arrange
    GrpcWebProxy grpcWebProxy = new GrpcWebProxy(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.remove(Mockito.<CharSequence>any())).thenThrow(new EUnexpected());
    when(headers.get(Mockito.<CharSequence>any())).thenReturn("application/grpc");
    when(headers.contains(Mockito.<CharSequence>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> grpcWebProxy.channelRead(ctx, new DefaultHttp2HeadersFrame(headers)));
    verify(headers).contains(isA(CharSequence.class));
    verify(headers).get(isA(CharSequence.class));
    verify(headers).remove(isA(CharSequence.class));
  }
}

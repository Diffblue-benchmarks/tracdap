package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.RemovalNotification;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.ReadOnlyHttp2Headers;
import io.netty.util.AsciiString;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcUtilsDiffblueTest {
  /**
   * Test {@link GrpcUtils#encodeLpm(Message, ByteBufAllocator)}.
   *
   * <p>Method under test: {@link GrpcUtils#encodeLpm(Message, ByteBufAllocator)}
   */
  @Test
  @DisplayName("Test encodeLpm(Message, ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.encodeLpm(Message, ByteBufAllocator)"})
  void testEncodeLpm() {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    // Act and Assert
    assertTrue(GrpcUtils.encodeLpm(defaultInstance, new AdaptiveByteBufAllocator()).isContiguous());
  }

  /**
   * Test {@link GrpcUtils#decodeLpm(Message, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#decodeLpm(Message, ByteBuf)}
   */
  @Test
  @DisplayName("Test decodeLpm(Message, ByteBuf); given '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message GrpcUtils.decodeLpm(Message, ByteBuf)"})
  void testDecodeLpm_given81985529216486895() throws InvalidProtocolBufferException {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    CompositeByteBuf buffer = Unpooled.compositeBuffer(3);
    buffer.writeLong(81985529216486895L);

    // Act and Assert
    assertThrows(
        InvalidProtocolBufferException.class, () -> GrpcUtils.decodeLpm(defaultInstance, buffer));
  }

  /**
   * Test {@link GrpcUtils#decodeLpm(Message, ByteBuf)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return {@link DescriptorProtos.FileOptions}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#decodeLpm(Message, ByteBuf)}
   */
  @Test
  @DisplayName("Test decodeLpm(Message, ByteBuf); given forty-two; then return FileOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message GrpcUtils.decodeLpm(Message, ByteBuf)"})
  void testDecodeLpm_givenFortyTwo_thenReturnFileOptions() throws InvalidProtocolBufferException {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    CompositeByteBuf buffer = Unpooled.compositeBuffer(3);
    buffer.writeLong(42L);

    // Act
    Message actualDecodeLpmResult = GrpcUtils.decodeLpm(defaultInstance, buffer);

    // Assert
    assertTrue(actualDecodeLpmResult instanceof FileOptions);
    assertEquals(defaultInstance, actualDecodeLpmResult);
  }

  /**
   * Test {@link GrpcUtils#decodeLpm(Message, ByteBuf)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#decodeLpm(Message, ByteBuf)}
   */
  @Test
  @DisplayName("Test decodeLpm(Message, ByteBuf); given minus one; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message GrpcUtils.decodeLpm(Message, ByteBuf)"})
  void testDecodeLpm_givenMinusOne_thenThrowETracInternal() throws InvalidProtocolBufferException {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    CompositeByteBuf buffer = Unpooled.compositeBuffer(3);
    buffer.writeLong(-1L);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> GrpcUtils.decodeLpm(defaultInstance, buffer));
  }

  /**
   * Test {@link GrpcUtils#decodeLpm(Message, ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       AdaptiveByteBufAllocator#AdaptiveByteBufAllocator()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#decodeLpm(Message, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test decodeLpm(Message, ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is AdaptiveByteBufAllocator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message GrpcUtils.decodeLpm(Message, ByteBuf)"})
  void testDecodeLpm_whenEmptyByteBufWithAllocIsAdaptiveByteBufAllocator()
      throws InvalidProtocolBufferException {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    // Act and Assert
    assertThrows(
        InvalidProtocolBufferException.class,
        () ->
            GrpcUtils.decodeLpm(
                defaultInstance,
                new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator()))));
  }

  /**
   * Test {@link GrpcUtils#canDecodeLpm(ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#canDecodeLpm(ByteBuf)}
   */
  @Test
  @DisplayName("Test canDecodeLpm(ByteBuf); given '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GrpcUtils.canDecodeLpm(ByteBuf)"})
  void testCanDecodeLpm_given81985529216486895() {
    // Arrange
    CompositeByteBuf buffer = Unpooled.compositeBuffer(3);
    buffer.writeLong(81985529216486895L);

    // Act and Assert
    assertFalse(GrpcUtils.canDecodeLpm(buffer));
  }

  /**
   * Test {@link GrpcUtils#canDecodeLpm(ByteBuf)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#canDecodeLpm(ByteBuf)}
   */
  @Test
  @DisplayName("Test canDecodeLpm(ByteBuf); given forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GrpcUtils.canDecodeLpm(ByteBuf)"})
  void testCanDecodeLpm_givenFortyTwo_thenReturnTrue() {
    // Arrange
    CompositeByteBuf buffer = Unpooled.compositeBuffer(3);
    buffer.writeLong(42L);

    // Act and Assert
    assertTrue(GrpcUtils.canDecodeLpm(buffer));
  }

  /**
   * Test {@link GrpcUtils#canDecodeLpm(ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       AdaptiveByteBufAllocator#AdaptiveByteBufAllocator()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#canDecodeLpm(ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test canDecodeLpm(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is AdaptiveByteBufAllocator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GrpcUtils.canDecodeLpm(ByteBuf)"})
  void testCanDecodeLpm_whenEmptyByteBufWithAllocIsAdaptiveByteBufAllocator() {
    // Arrange, Act and Assert
    assertFalse(
        GrpcUtils.canDecodeLpm(
            new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator()))));
  }

  /**
   * Test {@link GrpcUtils#decodeHeadersFrame(ByteBuf)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultHttp2Headers}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#decodeHeadersFrame(ByteBuf)}
   */
  @Test
  @DisplayName("Test decodeHeadersFrame(ByteBuf); then return DefaultHttp2Headers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Http2Headers GrpcUtils.decodeHeadersFrame(ByteBuf)"})
  void testDecodeHeadersFrame_thenReturnDefaultHttp2Headers() {
    // Arrange and Act
    Http2Headers actualDecodeHeadersFrameResult =
        GrpcUtils.decodeHeadersFrame(
            new DuplicatedByteBuf(new EmptyByteBuf(new AdaptiveByteBufAllocator())));

    // Assert
    assertTrue(actualDecodeHeadersFrameResult instanceof DefaultHttp2Headers);
    assertEquals(0, actualDecodeHeadersFrameResult.size());
    assertFalse(actualDecodeHeadersFrameResult.iterator().hasNext());
    assertTrue(actualDecodeHeadersFrameResult.isEmpty());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with cached {@code :} and
   *       lineSeparator.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given ArrayList() add SimpleEntry(Object, Object) with cached ':' and lineSeparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenArrayListAddSimpleEntryWithCachedColonAndLineSeparator() {
    // Arrange
    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    AsciiString cachedResult = AsciiString.cached(": ");
    entryList.add(new SimpleEntry<>(cachedResult, System.lineSeparator()));

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act
    ByteBuf actualLpmHeadersResult = GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator());

    // Assert
    verify(headers).iterator();
    assertTrue(actualLpmHeadersResult.isContiguous());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with lineSeparator and cached {@code
   *       :}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given ArrayList() add SimpleEntry(Object, Object) with lineSeparator and cached ':'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenArrayListAddSimpleEntryWithLineSeparatorAndCachedColon() {
    // Arrange
    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    String lineSeparatorResult = System.lineSeparator();
    SimpleEntry<CharSequence, CharSequence> simpleEntry =
        new SimpleEntry<>(lineSeparatorResult, AsciiString.cached(": "));
    entryList.add(simpleEntry);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act
    ByteBuf actualLpmHeadersResult = GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator());

    // Assert
    verify(headers).iterator();
    assertTrue(actualLpmHeadersResult.isContiguous());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with lineSeparator and
   *       lineSeparator.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given ArrayList() add SimpleEntry(Object, Object) with lineSeparator and lineSeparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenArrayListAddSimpleEntryWithLineSeparatorAndLineSeparator() {
    // Arrange
    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    String lineSeparatorResult = System.lineSeparator();
    entryList.add(new SimpleEntry<>(lineSeparatorResult, System.lineSeparator()));

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act
    ByteBuf actualLpmHeadersResult = GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator());

    // Assert
    verify(headers).iterator();
    assertTrue(actualLpmHeadersResult.isContiguous());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then return Contiguous.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given ArrayList() iterator; then return Contiguous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenArrayListIterator_thenReturnContiguous() {
    // Arrange
    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);

    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act
    ByteBuf actualLpmHeadersResult = GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator());

    // Assert
    verify(headers).iterator();
    assertTrue(actualLpmHeadersResult.isContiguous());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ReadOnlyHttp2Headers} {@link ReadOnlyHttp2Headers#iterator()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given EUnexpected(); when ReadOnlyHttp2Headers iterator() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenEUnexpected_whenReadOnlyHttp2HeadersIteratorThrowEUnexpected() {
    // Arrange
    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.iterator()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator()));
    verify(headers).iterator();
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>Given {@link RemovalNotification} {@link RemovalNotification#getKey()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link RemovalNotification#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); given RemovalNotification getKey() throw EUnexpected(); then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_givenRemovalNotificationGetKeyThrowEUnexpected_thenCallsGetKey() {
    // Arrange
    RemovalNotification<CharSequence, CharSequence> removalNotification =
        mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new EUnexpected());

    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    entryList.add(removalNotification);

    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator()));
    verify(headers).iterator();
    verify(removalNotification).getKey();
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>When {@link DefaultHttp2Headers#DefaultHttp2Headers()}.
   *   <li>Then return Contiguous.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); when DefaultHttp2Headers(); then return Contiguous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_whenDefaultHttp2Headers_thenReturnContiguous() {
    // Arrange
    DefaultHttp2Headers headers = new DefaultHttp2Headers();

    // Act and Assert
    assertTrue(GrpcUtils.lpmHeaders(headers, new AdaptiveByteBufAllocator()).isContiguous());
  }

  /**
   * Test {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}.
   *
   * <ul>
   *   <li>When {@link PooledByteBufAllocator#PooledByteBufAllocator()}.
   *   <li>Then return Contiguous.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#lpmHeaders(Http2Headers, ByteBufAllocator)}
   */
  @Test
  @DisplayName(
      "Test lpmHeaders(Http2Headers, ByteBufAllocator); when PooledByteBufAllocator(); then return Contiguous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuf GrpcUtils.lpmHeaders(Http2Headers, ByteBufAllocator)"})
  void testLpmHeaders_whenPooledByteBufAllocator_thenReturnContiguous() {
    // Arrange
    ReadOnlyHttp2Headers headers = mock(ReadOnlyHttp2Headers.class);

    ArrayList<Entry<CharSequence, CharSequence>> entryList = new ArrayList<>();
    when(headers.iterator()).thenReturn(entryList.iterator());

    // Act
    ByteBuf actualLpmHeadersResult = GrpcUtils.lpmHeaders(headers, new PooledByteBufAllocator());

    // Assert
    verify(headers).iterator();
    assertTrue(actualLpmHeadersResult.isContiguous());
  }

  /**
   * Test {@link GrpcUtils#readLpmFlag(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#readLpmFlag(byte[])}
   */
  @Test
  @DisplayName("Test readLpmFlag(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GrpcUtils.readLpmFlag(byte[])"})
  void testReadLpmFlag_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 65, GrpcUtils.readLpmFlag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link GrpcUtils#readLpmLength(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1480677441}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#readLpmLength(byte[])}
   */
  @Test
  @DisplayName(
      "Test readLpmLength(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1480677441'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long GrpcUtils.readLpmLength(byte[])"})
  void testReadLpmLength_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441L, GrpcUtils.readLpmLength("AXAXAXAX".getBytes("UTF-8")));
  }
}

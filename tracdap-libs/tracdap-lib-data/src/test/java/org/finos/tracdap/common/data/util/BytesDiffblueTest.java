package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BytesDiffblueTest {
  /**
   * Test {@link Bytes#copyFromBuffer(ArrowBuf)} with {@code ArrowBuf}.
   *
   * <ul>
   *   <li>Given {@code 2147483648}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#copyFromBuffer(ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test copyFromBuffer(ArrowBuf) with 'ArrowBuf'; given '2147483648'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Bytes.copyFromBuffer(ArrowBuf)"})
  void testCopyFromBufferWithArrowBuf_given2147483648_thenThrowEUnexpected() {
    // Arrange
    ArrowBuf src = mock(ArrowBuf.class);
    when(src.readableBytes()).thenReturn(2147483648L);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> Bytes.copyFromBuffer(src));
    verify(src).readableBytes();
  }

  /**
   * Test {@link Bytes#copyFromBuffer(ArrowBuf)} with {@code ArrowBuf}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#copyFromBuffer(ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test copyFromBuffer(ArrowBuf) with 'ArrowBuf'; given one; then return array of byte with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Bytes.copyFromBuffer(ArrowBuf)"})
  void testCopyFromBufferWithArrowBuf_givenOne_thenReturnArrayOfByteWithZero() {
    // Arrange
    ArrowBuf src = mock(ArrowBuf.class);
    when(src.readableBytes()).thenReturn(1L);
    when(src.readerIndex()).thenReturn(1L);
    doNothing().when(src).getBytes(anyLong(), Mockito.<byte[]>any());

    // Act
    byte[] actualCopyFromBufferResult = Bytes.copyFromBuffer(src);

    // Assert
    verify(src).getBytes(eq(1L), isA(byte[].class));
    verify(src, atLeast(1)).readableBytes();
    verify(src).readerIndex();
    assertArrayEquals(new byte[] {0}, actualCopyFromBufferResult);
  }

  /**
   * Test {@link Bytes#copyFromBuffer(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#copyFromBuffer(List)}
   */
  @Test
  @DisplayName(
      "Test copyFromBuffer(List) with 'List'; when ArrayList(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Bytes.copyFromBuffer(List)"})
  void testCopyFromBufferWithList_whenArrayList_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, Bytes.copyFromBuffer(new ArrayList<>()));
  }

  /**
   * Test {@link Bytes#flushStream(ArrowBuf, Consumer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#flushStream(ArrowBuf, Consumer)}
   */
  @Test
  @DisplayName("Test flushStream(ArrowBuf, Consumer); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrowBuf Bytes.flushStream(ArrowBuf, Consumer)"})
  void testFlushStream_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Bytes.flushStream(null, mock(Consumer.class)));
  }

  /**
   * Test {@link Bytes#closeStream(ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#closeStream(ArrowBuf)}
   */
  @Test
  @DisplayName("Test closeStream(ArrowBuf); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrowBuf Bytes.closeStream(ArrowBuf)"})
  void testCloseStream_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Bytes.closeStream(null));
  }

  /**
   * Test {@link Bytes#readFromStream(ArrowBuf, Consumer)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#readableBytes()} return zero.
   *   <li>Then calls {@link ArrowBuf#close()}.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#readFromStream(ArrowBuf, Consumer)}
   */
  @Test
  @DisplayName(
      "Test readFromStream(ArrowBuf, Consumer); given zero; when ArrowBuf readableBytes() return zero; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bytes.readFromStream(ArrowBuf, Consumer)"})
  void testReadFromStream_givenZero_whenArrowBufReadableBytesReturnZero_thenCallsClose() {
    // Arrange
    ArrowBuf src = mock(ArrowBuf.class);
    when(src.readableBytes()).thenReturn(0L);
    doNothing().when(src).close();

    // Act
    Bytes.readFromStream(src, mock(Consumer.class));

    // Assert
    verify(src).close();
    verify(src).readableBytes();
  }

  /**
   * Test {@link Bytes#readFromBuffer(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return capacity is zero.
   * </ul>
   *
   * <p>Method under test: {@link Bytes#readFromBuffer(List)}
   */
  @Test
  @DisplayName("Test readFromBuffer(List); when ArrayList(); then return capacity is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteBuffer Bytes.readFromBuffer(List)"})
  void testReadFromBuffer_whenArrayList_thenReturnCapacityIsZero() {
    // Arrange and Act
    ByteBuffer actualReadFromBufferResult = Bytes.readFromBuffer(new ArrayList<>());

    // Assert
    assertEquals(0, actualReadFromBufferResult.capacity());
    assertEquals(0, actualReadFromBufferResult.limit());
    assertEquals(0, actualReadFromBufferResult.position());
    assertFalse(actualReadFromBufferResult.hasRemaining());
    assertTrue(actualReadFromBufferResult.hasArray());
    ByteBuffer actualFlipResult = actualReadFromBufferResult.flip();
    assertSame(actualReadFromBufferResult, actualFlipResult);
    assertArrayEquals(new byte[] {}, actualReadFromBufferResult.array());
  }

  /**
   * Test {@link Bytes#readableBytes(List)}.
   *
   * <p>Method under test: {@link Bytes#readableBytes(List)}
   */
  @Test
  @DisplayName("Test readableBytes(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Bytes.readableBytes(List)"})
  void testReadableBytes() {
    // Arrange, Act and Assert
    assertEquals(0L, Bytes.readableBytes(new ArrayList<>()));
  }
}

package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteSeekableChannelDiffblueTest {
  /**
   * Test {@link ByteSeekableChannel#ByteSeekableChannel(List)}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#ByteSeekableChannel(List)}
   */
  @Test
  @DisplayName("Test new ByteSeekableChannel(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteSeekableChannel.<init>(List)"})
  void testNewByteSeekableChannel() throws IOException {
    // Arrange and Act
    ByteSeekableChannel actualByteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Assert
    assertEquals(0L, actualByteSeekableChannel.position());
    assertEquals(0L, actualByteSeekableChannel.size());
    assertTrue(actualByteSeekableChannel.isOpen());
  }

  /**
   * Test {@link ByteSeekableChannel#size()}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteSeekableChannel.size()"})
  void testSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, new ByteSeekableChannel(new ArrayList<>()).size());
  }

  /**
   * Test {@link ByteSeekableChannel#position()}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteSeekableChannel.position()"})
  void testPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, new ByteSeekableChannel(new ArrayList<>()).position());
  }

  /**
   * Test {@link ByteSeekableChannel#position(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then {@link ByteSeekableChannel#ByteSeekableChannel(List)} with buffers is {@link
   *       ArrayList#ArrayList()} position is one.
   * </ul>
   *
   * <p>Method under test: {@link ByteSeekableChannel#position(long)}
   */
  @Test
  @DisplayName(
      "Test position(long) with 'long'; then ByteSeekableChannel(List) with buffers is ArrayList() position is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SeekableByteChannel ByteSeekableChannel.position(long)"})
  void testPositionWithLong_thenByteSeekableChannelWithBuffersIsArrayListPositionIsOne()
      throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act
    SeekableByteChannel actualPositionResult = byteSeekableChannel.position(1L);

    // Assert
    assertEquals(1L, byteSeekableChannel.position());
    assertSame(byteSeekableChannel, actualPositionResult);
  }

  /**
   * Test {@link ByteSeekableChannel#position(long)} with {@code long}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteSeekableChannel#position(long)}
   */
  @Test
  @DisplayName(
      "Test position(long) with 'long'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SeekableByteChannel ByteSeekableChannel.position(long)"})
  void testPositionWithLong_whenMinusOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ByteSeekableChannel(new ArrayList<>()).position(-1L));
  }

  /**
   * Test {@link ByteSeekableChannel#read(ByteBuffer)}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#read(ByteBuffer)}
   */
  @Test
  @DisplayName("Test read(ByteBuffer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteSeekableChannel.read(ByteBuffer)"})
  void testRead() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act and Assert
    assertEquals(-1, byteSeekableChannel.read(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ByteSeekableChannel#write(ByteBuffer)}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#write(ByteBuffer)}
   */
  @Test
  @DisplayName("Test write(ByteBuffer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteSeekableChannel.write(ByteBuffer)"})
  void testWrite() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> byteSeekableChannel.write(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ByteSeekableChannel#truncate(long)}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#truncate(long)}
   */
  @Test
  @DisplayName("Test truncate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SeekableByteChannel ByteSeekableChannel.truncate(long)"})
  void testTruncate() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ByteSeekableChannel(new ArrayList<>()).truncate(3L));
  }

  /**
   * Test {@link ByteSeekableChannel#isOpen()}.
   *
   * <p>Method under test: {@link ByteSeekableChannel#isOpen()}
   */
  @Test
  @DisplayName("Test isOpen()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteSeekableChannel.close()", "boolean ByteSeekableChannel.isOpen()"})
  void testIsOpen() {
    // Arrange, Act and Assert
    assertTrue(new ByteSeekableChannel(new ArrayList<>()).isOpen());
  }
}

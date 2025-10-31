package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ByteSeekableChannelDiffblueTest {
  /**
   * Method under test: {@link ByteSeekableChannel#size()}
   */
  @Test
  void testSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new ByteSeekableChannel(new ArrayList<>())).size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ByteSeekableChannel#close()}
   *   <li>{@link ByteSeekableChannel#isOpen()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act
    byteSeekableChannel.close();

    // Assert that nothing has changed
    assertFalse(byteSeekableChannel.isOpen());
  }

  /**
   * Method under test: {@link ByteSeekableChannel#position()}
   */
  @Test
  void testPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new ByteSeekableChannel(new ArrayList<>())).position());
    assertThrows(IllegalArgumentException.class, () -> (new ByteSeekableChannel(new ArrayList<>())).position(-1L));
  }

  /**
   * Method under test: {@link ByteSeekableChannel#position(long)}
   */
  @Test
  void testPosition2() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act
    SeekableByteChannel actualPositionResult = byteSeekableChannel.position(1L);

    // Assert
    assertEquals(1L, byteSeekableChannel.position());
    assertSame(byteSeekableChannel, actualPositionResult);
  }

  /**
   * Method under test: {@link ByteSeekableChannel#read(ByteBuffer)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act and Assert
    assertEquals(-1, byteSeekableChannel.read(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link ByteSeekableChannel#write(ByteBuffer)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    ByteSeekableChannel byteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> byteSeekableChannel.write(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link ByteSeekableChannel#truncate(long)}
   */
  @Test
  void testTruncate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ByteSeekableChannel(new ArrayList<>())).truncate(3L));
  }

  /**
   * Method under test: {@link ByteSeekableChannel#ByteSeekableChannel(List)}
   */
  @Test
  void testNewByteSeekableChannel() throws IOException {
    // Arrange and Act
    ByteSeekableChannel actualByteSeekableChannel = new ByteSeekableChannel(new ArrayList<>());

    // Assert
    assertEquals(0L, actualByteSeekableChannel.position());
    assertEquals(0L, actualByteSeekableChannel.size());
    assertTrue(actualByteSeekableChannel.isOpen());
  }
}

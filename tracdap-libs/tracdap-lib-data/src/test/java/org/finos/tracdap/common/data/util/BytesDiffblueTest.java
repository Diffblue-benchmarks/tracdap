package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.arrow.memory.ArrowBuf;
import org.junit.jupiter.api.Test;

class BytesDiffblueTest {
  /**
   * Method under test: {@link Bytes#copyFromBuffer(List)}
   */
  @Test
  void testCopyFromBuffer() {
    // Arrange, Act and Assert
    assertEquals(0, Bytes.copyFromBuffer(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link Bytes#flushStream(ArrowBuf, Consumer)}
   */
  @Test
  void testFlushStream() {
    // Arrange, Act and Assert
    assertNull(Bytes.flushStream(null, mock(Consumer.class)));
  }

  /**
   * Method under test: {@link Bytes#closeStream(ArrowBuf)}
   */
  @Test
  void testCloseStream() {
    // Arrange, Act and Assert
    assertNull(Bytes.closeStream(null));
  }

  /**
   * Method under test: {@link Bytes#readFromBuffer(List)}
   */
  @Test
  void testReadFromBuffer() {
    // Arrange and Act
    ByteBuffer actualReadFromBufferResult = Bytes.readFromBuffer(new ArrayList<>());

    // Assert
    assertEquals(0, actualReadFromBufferResult.capacity());
    assertEquals(0, actualReadFromBufferResult.limit());
    assertEquals(0, actualReadFromBufferResult.position());
    assertEquals(0, actualReadFromBufferResult.array().length);
    assertFalse(actualReadFromBufferResult.hasRemaining());
    assertTrue(actualReadFromBufferResult.hasArray());
  }

  /**
   * Method under test: {@link Bytes#readableBytes(List)}
   */
  @Test
  void testReadableBytes() {
    // Arrange, Act and Assert
    assertEquals(0L, Bytes.readableBytes(new ArrayList<>()));
  }
}

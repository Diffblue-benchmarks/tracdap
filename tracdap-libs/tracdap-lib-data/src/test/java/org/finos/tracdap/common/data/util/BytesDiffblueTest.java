package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.arrow.memory.ArrowBuf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BytesDiffblueTest {
  /**
   * Test {@link Bytes#copyFromBuffer(List)} with {@code List}.
   * <p>
   * Method under test: {@link Bytes#copyFromBuffer(List)}
   */
  @Test
  @DisplayName("Test copyFromBuffer(List) with 'List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Bytes.copyFromBuffer(List)"})
  void testCopyFromBufferWithList() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, Bytes.copyFromBuffer(new ArrayList<>()));
  }

  /**
   * Test {@link Bytes#flushStream(ArrowBuf, Consumer)}.
   * <p>
   * Method under test: {@link Bytes#flushStream(ArrowBuf, Consumer)}
   */
  @Test
  @DisplayName("Test flushStream(ArrowBuf, Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrowBuf Bytes.flushStream(ArrowBuf, Consumer)"})
  void testFlushStream() {
    // Arrange, Act and Assert
    assertNull(Bytes.flushStream(null, mock(Consumer.class)));
  }

  /**
   * Test {@link Bytes#closeStream(ArrowBuf)}.
   * <p>
   * Method under test: {@link Bytes#closeStream(ArrowBuf)}
   */
  @Test
  @DisplayName("Test closeStream(ArrowBuf)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrowBuf Bytes.closeStream(ArrowBuf)"})
  void testCloseStream() {
    // Arrange, Act and Assert
    assertNull(Bytes.closeStream(null));
  }

  /**
   * Test {@link Bytes#readFromBuffer(List)}.
   * <p>
   * Method under test: {@link Bytes#readFromBuffer(List)}
   */
  @Test
  @DisplayName("Test readFromBuffer(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteBuffer Bytes.readFromBuffer(List)"})
  void testReadFromBuffer() {
    // Arrange and Act
    ByteBuffer actualReadFromBufferResult = Bytes.readFromBuffer(new ArrayList<>());

    // Assert
    assertEquals(0, actualReadFromBufferResult.capacity());
    assertEquals(0, actualReadFromBufferResult.limit());
    assertEquals(0, actualReadFromBufferResult.position());
    assertFalse(actualReadFromBufferResult.hasRemaining());
    assertTrue(actualReadFromBufferResult.hasArray());
    assertArrayEquals(new byte[]{}, actualReadFromBufferResult.array());
  }

  /**
   * Test {@link Bytes#readableBytes(List)}.
   * <p>
   * Method under test: {@link Bytes#readableBytes(List)}
   */
  @Test
  @DisplayName("Test readableBytes(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Bytes.readableBytes(List)"})
  void testReadableBytes() {
    // Arrange, Act and Assert
    assertEquals(0L, Bytes.readableBytes(new ArrayList<>()));
  }
}

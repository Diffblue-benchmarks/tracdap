package org.apache.arrow.vector.ipc.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.EOFException;
import java.io.IOException;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.vector.ipc.InvalidArrowFileException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageStreamReaderDiffblueTest {
  @InjectMocks private MessageStreamReader messageStreamReader;

  /**
   * Test {@link MessageStreamReader#feedBytes(ArrowBuf)}.
   *
   * <p>Method under test: {@link MessageStreamReader#feedBytes(ArrowBuf)}
   */
  @Test
  @DisplayName("Test feedBytes(ArrowBuf)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageStreamReader.feedBytes(ArrowBuf)"})
  void testFeedBytes() throws IOException {
    // Arrange
    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.readableBytes()).thenThrow(new InvalidArrowFileException("An error occurred"));

    // Act and Assert
    assertThrows(InvalidArrowFileException.class, () -> messageStreamReader.feedBytes(chunk));
    verify(chunk).readableBytes();
  }

  /**
   * Test {@link MessageStreamReader#feedBytes(ArrowBuf)}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>Then calls {@link ArrowBuf#readerIndex()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageStreamReader#feedBytes(ArrowBuf)}
   */
  @Test
  @DisplayName("Test feedBytes(ArrowBuf); given four; then calls readerIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageStreamReader.feedBytes(ArrowBuf)"})
  void testFeedBytes_givenFour_thenCallsReaderIndex() throws IOException {
    // Arrange
    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.readerIndex()).thenThrow(new InvalidArrowFileException("An error occurred"));
    when(chunk.readableBytes()).thenReturn(4L);

    // Act and Assert
    assertThrows(InvalidArrowFileException.class, () -> messageStreamReader.feedBytes(chunk));
    verify(chunk, atLeast(1)).readableBytes();
    verify(chunk).readerIndex();
  }

  /**
   * Test {@link MessageStreamReader#feedBytes(ArrowBuf)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#readableBytes()} return one.
   *   <li>Then calls {@link ArrowBuf#readableBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageStreamReader#feedBytes(ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test feedBytes(ArrowBuf); given one; when ArrowBuf readableBytes() return one; then calls readableBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageStreamReader.feedBytes(ArrowBuf)"})
  void testFeedBytes_givenOne_whenArrowBufReadableBytesReturnOne_thenCallsReadableBytes()
      throws IOException {
    // Arrange
    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.readableBytes()).thenReturn(1L);

    // Act
    messageStreamReader.feedBytes(chunk);

    // Assert
    verify(chunk).readableBytes();
  }

  /**
   * Test {@link MessageStreamReader#hasMessage()}.
   *
   * <p>Method under test: {@link MessageStreamReader#hasMessage()}
   */
  @Test
  @DisplayName("Test hasMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageStreamReader.hasMessage()"})
  void testHasMessage() {
    // Arrange, Act and Assert
    assertFalse(messageStreamReader.hasMessage());
  }

  /**
   * Test {@link MessageStreamReader#hasMessage(byte)} with {@code byte}.
   *
   * <p>Method under test: {@link MessageStreamReader#hasMessage(byte)}
   */
  @Test
  @DisplayName("Test hasMessage(byte) with 'byte'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageStreamReader.hasMessage(byte)"})
  void testHasMessageWithByte() {
    // Arrange, Act and Assert
    assertFalse(messageStreamReader.hasMessage((byte) 'A'));
  }

  /**
   * Test {@link MessageStreamReader#readNext()}.
   *
   * <p>Method under test: {@link MessageStreamReader#readNext()}
   */
  @Test
  @DisplayName("Test readNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.arrow.vector.ipc.message.MessageResult MessageStreamReader.readNext()"
  })
  void testReadNext() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class, () -> messageStreamReader.readNext());
  }

  /**
   * Test {@link MessageStreamReader#bytesRead()}.
   *
   * <p>Method under test: {@link MessageStreamReader#bytesRead()}
   */
  @Test
  @DisplayName("Test bytesRead()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MessageStreamReader.bytesRead()"})
  void testBytesRead() {
    // Arrange, Act and Assert
    assertEquals(0L, messageStreamReader.bytesRead());
  }
}

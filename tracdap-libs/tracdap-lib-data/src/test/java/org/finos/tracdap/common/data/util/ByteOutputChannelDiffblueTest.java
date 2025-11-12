package org.finos.tracdap.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ByteOutputChannelDiffblueTest {
  @InjectMocks private ByteOutputChannel byteOutputChannel;

  /**
   * Test {@link ByteOutputChannel#write(ByteBuffer)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteOutputChannel#write(ByteBuffer)}
   */
  @Test
  @DisplayName("Test write(ByteBuffer); given 'A'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteOutputChannel.write(ByteBuffer)"})
  void testWrite_givenA_thenReturnZero() throws IOException {
    // Arrange
    ByteBuffer src = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    src.put(ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act and Assert
    assertEquals(0, byteOutputChannel.write(src));
  }

  /**
   * Test {@link ByteOutputChannel#close()}.
   *
   * <p>Method under test: {@link ByteOutputChannel#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteOutputChannel.close()"})
  void testClose() throws IOException {
    // Arrange and Act
    byteOutputChannel.close();

    // Assert
    assertFalse(byteOutputChannel.isOpen());
  }
}

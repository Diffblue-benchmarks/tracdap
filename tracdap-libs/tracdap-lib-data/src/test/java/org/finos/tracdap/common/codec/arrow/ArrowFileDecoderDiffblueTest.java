package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.ipc.ArrowFileReader;
import org.apache.arrow.vector.ipc.ArrowReader;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArrowFileDecoderDiffblueTest {
  @InjectMocks private ArrowFileDecoder arrowFileDecoder;

  @Mock private BufferAllocator bufferAllocator;

  /**
   * Test {@link ArrowFileDecoder#ArrowFileDecoder(BufferAllocator)}.
   *
   * <p>Method under test: {@link ArrowFileDecoder#ArrowFileDecoder(BufferAllocator)}
   */
  @Test
  @DisplayName("Test new ArrowFileDecoder(BufferAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowFileDecoder.<init>(BufferAllocator)"})
  void testNewArrowFileDecoder() {
    // Arrange and Act
    ArrowFileDecoder actualArrowFileDecoder = new ArrowFileDecoder(bufferAllocator);

    // Assert
    assertFalse(actualArrowFileDecoder.isDone());
    assertTrue(actualArrowFileDecoder.isReady());
    Class<ArrowApi> expectedConsumerTypeResult = ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualArrowFileDecoder.consumerType());
  }

  /**
   * Test {@link ArrowFileDecoder#createReader(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowFileDecoder#createReader(List)}
   */
  @Test
  @DisplayName("Test createReader(List); given ArrayList(); when ArrayList() addAll ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrowReader ArrowFileDecoder.createReader(List)"})
  void testCreateReader_givenArrayList_whenArrayListAddAllArrayList() {
    // Arrange
    ArrayList<ArrowBuf> buffer = new ArrayList<>();
    buffer.addAll(new ArrayList<>());

    // Act
    ArrowReader actualCreateReaderResult = arrowFileDecoder.createReader(buffer);

    // Assert
    assertTrue(actualCreateReaderResult instanceof ArrowFileReader);
    assertTrue(((ArrowFileReader) actualCreateReaderResult).getMetaData().isEmpty());
  }

  /**
   * Test {@link ArrowFileDecoder#createReader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowFileDecoder#createReader(List)}
   */
  @Test
  @DisplayName("Test createReader(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrowReader ArrowFileDecoder.createReader(List)"})
  void testCreateReader_whenArrayList() {
    // Arrange and Act
    ArrowReader actualCreateReaderResult = arrowFileDecoder.createReader(new ArrayList<>());

    // Assert
    assertTrue(actualCreateReaderResult instanceof ArrowFileReader);
    assertTrue(((ArrowFileReader) actualCreateReaderResult).getMetaData().isEmpty());
  }
}

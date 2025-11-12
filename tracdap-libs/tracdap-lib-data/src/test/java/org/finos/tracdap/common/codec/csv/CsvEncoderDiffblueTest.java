package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.arrow.memory.BufferAllocator;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CsvEncoderDiffblueTest {
  @Mock private BufferAllocator bufferAllocator;

  /**
   * Test {@link CsvEncoder#CsvEncoder(BufferAllocator)}.
   *
   * <p>Method under test: {@link CsvEncoder#CsvEncoder(BufferAllocator)}
   */
  @Test
  @DisplayName("Test new CsvEncoder(BufferAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvEncoder.<init>(BufferAllocator)"})
  void testNewCsvEncoder() {
    // Arrange and Act
    CsvEncoder actualCsvEncoder = new CsvEncoder(bufferAllocator);

    // Assert
    assertFalse(actualCsvEncoder.isDone());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualCsvEncoder.consumerType());
  }
}

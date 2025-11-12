package org.finos.tracdap.common.codec.arrow;

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
class ArrowFileEncoderDiffblueTest {
  @Mock private BufferAllocator bufferAllocator;

  /**
   * Test {@link ArrowFileEncoder#ArrowFileEncoder(BufferAllocator)}.
   *
   * <p>Method under test: {@link ArrowFileEncoder#ArrowFileEncoder(BufferAllocator)}
   */
  @Test
  @DisplayName("Test new ArrowFileEncoder(BufferAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowFileEncoder.<init>(BufferAllocator)"})
  void testNewArrowFileEncoder() {
    // Arrange and Act
    ArrowFileEncoder actualArrowFileEncoder = new ArrowFileEncoder(bufferAllocator);

    // Assert
    assertFalse(actualArrowFileEncoder.isDone());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualArrowFileEncoder.consumerType());
  }
}

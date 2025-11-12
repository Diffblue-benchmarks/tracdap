package org.finos.tracdap.common.codec.json;

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
class JsonEncoderDiffblueTest {
  @Mock private BufferAllocator bufferAllocator;

  /**
   * Test {@link JsonEncoder#JsonEncoder(BufferAllocator)}.
   *
   * <p>Method under test: {@link JsonEncoder#JsonEncoder(BufferAllocator)}
   */
  @Test
  @DisplayName("Test new JsonEncoder(BufferAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonEncoder.<init>(BufferAllocator)"})
  void testNewJsonEncoder() {
    // Arrange and Act
    JsonEncoder actualJsonEncoder = new JsonEncoder(bufferAllocator);

    // Assert
    assertFalse(actualJsonEncoder.isDone());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualJsonEncoder.consumerType());
  }
}

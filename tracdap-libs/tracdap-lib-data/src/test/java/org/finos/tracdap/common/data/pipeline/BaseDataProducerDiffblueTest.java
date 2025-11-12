package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.BufferApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseDataProducerDiffblueTest {
  /**
   * Test {@link BaseDataProducer#consumerType()}.
   *
   * <p>Method under test: {@link BaseDataProducer#consumerType()}
   */
  @Test
  @DisplayName("Test consumerType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BaseDataProducer.consumerType()"})
  void testConsumerType() {
    // Arrange and Act
    Class<BufferApi> actualConsumerTypeResult = new BufferingStage().consumerType();

    // Assert
    Class<BufferApi> expectedConsumerTypeResult = BufferApi.class;
    assertEquals(expectedConsumerTypeResult, actualConsumerTypeResult);
  }
}

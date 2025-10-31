package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.finos.tracdap.common.data.DataPipeline;
import org.junit.jupiter.api.Test;

class RangeSelectorDiffblueTest {
  /**
   * Method under test: {@link RangeSelector#RangeSelector(long, long)}
   */
  @Test
  void testNewRangeSelector() {
    // Arrange and Act
    RangeSelector actualRangeSelector = new RangeSelector(1L, 1L);

    // Assert
    assertFalse(actualRangeSelector.isDone());
    Class<DataPipeline.ArrowApi> expectedConsumerTypeResult = DataPipeline.ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualRangeSelector.consumerType());
  }
}

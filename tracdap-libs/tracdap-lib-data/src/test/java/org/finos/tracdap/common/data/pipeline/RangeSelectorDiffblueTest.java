package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeSelectorDiffblueTest {
  /**
   * Test {@link RangeSelector#RangeSelector(long, long)}.
   *
   * <p>Method under test: {@link RangeSelector#RangeSelector(long, long)}
   */
  @Test
  @DisplayName("Test new RangeSelector(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.<init>(long, long)"})
  void testNewRangeSelector() {
    // Arrange and Act
    RangeSelector actualRangeSelector = new RangeSelector(1L, 1L);

    // Assert
    assertFalse(actualRangeSelector.isDone());
    Class<ArrowApi> expectedConsumerTypeResult = ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualRangeSelector.consumerType());
  }
}

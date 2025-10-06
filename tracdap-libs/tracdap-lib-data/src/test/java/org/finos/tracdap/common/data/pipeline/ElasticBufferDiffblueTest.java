package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElasticBufferDiffblueTest {
  /**
   * Test new {@link ElasticBuffer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElasticBuffer}
   */
  @Test
  @DisplayName("Test new ElasticBuffer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticBuffer.<init>()"})
  void testNewElasticBuffer() {
    // Arrange and Act
    ElasticBuffer actualElasticBuffer = new ElasticBuffer();

    // Assert
    assertFalse(actualElasticBuffer.isDone());
    assertTrue(actualElasticBuffer.isReady());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualElasticBuffer.consumerType());
  }
}

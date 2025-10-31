package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.common.data.DataPipeline;
import org.junit.jupiter.api.Test;

class ElasticBufferDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ElasticBuffer}
   */
  @Test
  void testNewElasticBuffer() {
    // Arrange and Act
    ElasticBuffer actualElasticBuffer = new ElasticBuffer();

    // Assert
    assertFalse(actualElasticBuffer.isDone());
    assertTrue(actualElasticBuffer.isReady());
    Class<DataPipeline.StreamApi> expectedConsumerTypeResult = DataPipeline.StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualElasticBuffer.consumerType());
  }
}

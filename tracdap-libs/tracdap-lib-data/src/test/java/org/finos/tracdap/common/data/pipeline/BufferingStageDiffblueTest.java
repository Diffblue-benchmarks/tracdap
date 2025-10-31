package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.common.data.DataPipeline;
import org.junit.jupiter.api.Test;

class BufferingStageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BufferingStage#pump()}
   *   <li>{@link BufferingStage#isReady()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    BufferingStage bufferingStage = new BufferingStage();

    // Act
    bufferingStage.pump();

    // Assert that nothing has changed
    assertTrue(bufferingStage.isReady());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BufferingStage}
   */
  @Test
  void testNewBufferingStage() {
    // Arrange and Act
    BufferingStage actualBufferingStage = new BufferingStage();

    // Assert
    assertFalse(actualBufferingStage.isDone());
    assertTrue(actualBufferingStage.isReady());
    Class<DataPipeline.BufferApi> expectedConsumerTypeResult = DataPipeline.BufferApi.class;
    assertEquals(expectedConsumerTypeResult, actualBufferingStage.consumerType());
  }
}

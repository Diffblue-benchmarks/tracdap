package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.Serializable;
import org.junit.jupiter.api.Test;

class BatchJobStateDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BatchJobState}
   */
  @Test
  void testNewBatchJobState() {
    // Arrange and Act
    BatchJobState<Serializable> actualBatchJobState = new BatchJobState<>();

    // Assert
    assertNull(actualBatchJobState.batchState);
    assertNull(actualBatchJobState.batchKey);
    assertFalse(actualBatchJobState.logVolumeEnabled);
    assertFalse(actualBatchJobState.resultVolumeEnabled);
    assertFalse(actualBatchJobState.runtimeApiEnabled);
  }
}

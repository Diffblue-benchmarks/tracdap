package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BatchJobStateDiffblueTest {
  /**
   * Test new {@link BatchJobState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BatchJobState}
   */
  @Test
  @DisplayName("Test new BatchJobState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BatchJobState.<init>()"})
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

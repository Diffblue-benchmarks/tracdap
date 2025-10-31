package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BatchStatusDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BatchStatus#BatchStatus(BatchStatusCode)}
   *   <li>{@link BatchStatus#getStatusCode()}
   *   <li>{@link BatchStatus#getStatusMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BatchStatus actualBatchStatus = new BatchStatus(BatchStatusCode.STATUS_UNKNOWN);
    BatchStatusCode actualStatusCode = actualBatchStatus.getStatusCode();

    // Assert
    assertEquals("", actualBatchStatus.getStatusMessage());
    assertEquals(BatchStatusCode.STATUS_UNKNOWN, actualStatusCode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BatchStatus#BatchStatus(BatchStatusCode, String)}
   *   <li>{@link BatchStatus#getStatusCode()}
   *   <li>{@link BatchStatus#getStatusMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    BatchStatus actualBatchStatus = new BatchStatus(BatchStatusCode.STATUS_UNKNOWN, "Status Message");
    BatchStatusCode actualStatusCode = actualBatchStatus.getStatusCode();

    // Assert
    assertEquals("Status Message", actualBatchStatus.getStatusMessage());
    assertEquals(BatchStatusCode.STATUS_UNKNOWN, actualStatusCode);
  }
}

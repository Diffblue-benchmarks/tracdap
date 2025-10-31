package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class JobOperationDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link JobOperation}
   */
  @Test
  void testNewJobOperation() {
    // Arrange and Act
    JobOperation actualJobOperation = new JobOperation();

    // Assert
    assertNull(actualJobOperation.cacheStatus);
    assertNull(actualJobOperation.jobKey);
    assertNull(actualJobOperation.operationName);
    assertNull(actualJobOperation.timeout);
    assertNull(actualJobOperation.operation);
    assertEquals(0, actualJobOperation.revision);
  }
}

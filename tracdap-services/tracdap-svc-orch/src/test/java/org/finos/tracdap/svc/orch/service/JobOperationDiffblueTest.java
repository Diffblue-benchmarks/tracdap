package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobOperationDiffblueTest {
  /**
   * Test new {@link JobOperation} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link JobOperation}
   */
  @Test
  @DisplayName("Test new JobOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobOperation.<init>()"})
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

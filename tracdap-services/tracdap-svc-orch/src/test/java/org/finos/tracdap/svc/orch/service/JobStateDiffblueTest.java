package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class JobStateDiffblueTest {
  /**
   * Method under test: {@link JobState#clone()}
   */
  @Test
  void testClone() {
    // Arrange and Act
    JobState actualCloneResult = (new JobState()).clone();

    // Assert
    assertNull(actualCloneResult.executorState);
    assertNull(actualCloneResult.cacheStatus);
    assertNull(actualCloneResult.errorDetail);
    assertNull(actualCloneResult.jobKey);
    assertNull(actualCloneResult.statusMessage);
    assertNull(actualCloneResult.tenant);
    assertNull(actualCloneResult.jobRequest);
    assertNull(actualCloneResult.executorResult);
    assertNull(actualCloneResult.executorStatus);
    assertNull(actualCloneResult.requestMetadata);
    assertNull(actualCloneResult.userMetadata);
    assertNull(actualCloneResult.clientConfig);
    assertNull(actualCloneResult.clientState);
    assertNull(actualCloneResult.jobConfig);
    assertNull(actualCloneResult.sysConfig);
    assertNull(actualCloneResult.definition);
    assertNull(actualCloneResult.tracStatus);
    assertNull(actualCloneResult.jobType);
    assertNull(actualCloneResult.jobId);
    assertEquals(0, actualCloneResult.retries);
    assertTrue(actualCloneResult.resourceMapping.isEmpty());
    assertTrue(actualCloneResult.resources.isEmpty());
    assertTrue(actualCloneResult.resultMapping.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link JobState}
   */
  @Test
  void testNewJobState() {
    // Arrange and Act
    JobState actualJobState = new JobState();

    // Assert
    assertTrue(actualJobState.resourceMapping.isEmpty());
    assertTrue(actualJobState.resources.isEmpty());
    assertTrue(actualJobState.resultMapping.isEmpty());
  }
}

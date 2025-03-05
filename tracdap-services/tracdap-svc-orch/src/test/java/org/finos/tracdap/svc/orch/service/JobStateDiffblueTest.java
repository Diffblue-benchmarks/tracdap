package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobStateDiffblueTest {
  /**
   * Test {@link JobState#clone()}.
   * <p>
   * Method under test: {@link JobState#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobState JobState.clone()"})
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
   * Test new {@link JobState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link JobState}
   */
  @Test
  @DisplayName("Test new JobState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobState.<init>()"})
  void testNewJobState() {
    // Arrange and Act
    JobState actualJobState = new JobState();

    // Assert
    assertTrue(actualJobState.resourceMapping.isEmpty());
    assertTrue(actualJobState.resources.isEmpty());
    assertTrue(actualJobState.resultMapping.isEmpty());
  }
}

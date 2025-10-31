package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.JobType;
import org.junit.jupiter.api.Test;

class JobLogicDiffblueTest {
  /**
   * Method under test: {@link JobLogic#forJobType(JobType)}
   */
  @Test
  void testForJobType() {
    // Arrange, Act and Assert
    assertThrows(EValidationGap.class, () -> JobLogic.forJobType(JobType.JOB_TYPE_NOT_SET));
    assertTrue(JobLogic.forJobType(JobType.RUN_MODEL) instanceof RunModelJob);
  }
}

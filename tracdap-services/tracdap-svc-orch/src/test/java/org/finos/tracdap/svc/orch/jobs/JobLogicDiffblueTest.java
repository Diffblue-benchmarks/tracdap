package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.JobType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobLogicDiffblueTest {
  /**
   * Test {@link JobLogic#forJobType(JobType)}.
   * <ul>
   *   <li>When {@code JOB_TYPE_NOT_SET}.</li>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobLogic#forJobType(JobType)}
   */
  @Test
  @DisplayName("Test forJobType(JobType); when 'JOB_TYPE_NOT_SET'; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.svc.orch.jobs.IJobLogic JobLogic.forJobType(JobType)"})
  void testForJobType_whenJobTypeNotSet_thenThrowEValidationGap() {
    // Arrange, Act and Assert
    assertThrows(EValidationGap.class, () -> JobLogic.forJobType(JobType.JOB_TYPE_NOT_SET));
  }

  /**
   * Test {@link JobLogic#forJobType(JobType)}.
   * <ul>
   *   <li>When {@code RUN_MODEL}.</li>
   *   <li>Then return {@link RunModelJob}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobLogic#forJobType(JobType)}
   */
  @Test
  @DisplayName("Test forJobType(JobType); when 'RUN_MODEL'; then return RunModelJob")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.svc.orch.jobs.IJobLogic JobLogic.forJobType(JobType)"})
  void testForJobType_whenRunModel_thenReturnRunModelJob() {
    // Arrange, Act and Assert
    assertTrue(JobLogic.forJobType(JobType.RUN_MODEL) instanceof RunModelJob);
  }
}

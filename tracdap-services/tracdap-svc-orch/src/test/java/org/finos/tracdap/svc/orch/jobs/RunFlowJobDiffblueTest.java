package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RunFlowJobDiffblueTest {
  /**
   * Test {@link RunFlowJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}.
   * <p>
   * Method under test: {@link RunFlowJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyTransform(JobDefinition, MetadataBundle, PlatformConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition RunFlowJob.applyTransform(JobDefinition, MetadataBundle, PlatformConfig)"})
  void testApplyTransform() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(job, runFlowJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Test {@link RunFlowJob#requiredMetadata(JobDefinition)} with {@code job}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#requiredMetadata(JobDefinition)}
   */
  @Test
  @DisplayName("Test requiredMetadata(JobDefinition) with 'job'; when DefaultInstance; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RunFlowJob.requiredMetadata(JobDefinition)"})
  void testRequiredMetadataWithJob_whenDefaultInstance_thenThrowEUnexpected() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> runFlowJob.requiredMetadata(JobDefinition.getDefaultInstance()));
  }
}

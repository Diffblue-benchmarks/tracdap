package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.Test;

class RunModelJobDiffblueTest {
  /**
   * Method under test:
   * {@link RunModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyTransform() {
    // Arrange
    RunModelJob runModelJob = new RunModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(job, runModelJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link RunModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyTransform2() {
    // Arrange
    RunModelJob runModelJob = new RunModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(job, runModelJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link RunModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyMetadataTransform() {
    // Arrange
    RunModelJob runModelJob = new RunModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(metadata, runModelJob.applyMetadataTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link RunModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyMetadataTransform2() {
    // Arrange
    RunModelJob runModelJob = new RunModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(metadata, runModelJob.applyMetadataTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Method under test: {@link RunModelJob#requiredMetadata(JobDefinition)}
   */
  @Test
  void testRequiredMetadata() {
    // Arrange
    RunModelJob runModelJob = new RunModelJob();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> runModelJob.requiredMetadata(JobDefinition.getDefaultInstance()));
  }
}

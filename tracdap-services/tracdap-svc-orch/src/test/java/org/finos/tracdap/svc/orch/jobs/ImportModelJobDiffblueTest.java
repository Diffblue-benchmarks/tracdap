package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.tracdap.api.internal.RuntimeJobResult;
import org.finos.tracdap.common.exception.EExecutorValidation;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImportModelJobDiffblueTest {
  /**
   * Test {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}.
   *
   * <p>Method under test: {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle,
   * PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyTransform(JobDefinition, MetadataBundle, PlatformConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JobDefinition ImportModelJob.applyTransform(JobDefinition, MetadataBundle, PlatformConfig)"
  })
  void testApplyTransform() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertThrows(
        EExecutorValidation.class,
        () -> importModelJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Test {@link ImportModelJob#applyMetadataTransform(JobDefinition, MetadataBundle,
   * PlatformConfig)}.
   *
   * <p>Method under test: {@link ImportModelJob#applyMetadataTransform(JobDefinition,
   * MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataBundle ImportModelJob.applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)"
  })
  void testApplyMetadataTransform() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act
    MetadataBundle actualApplyMetadataTransformResult =
        importModelJob.applyMetadataTransform(job, metadata, PlatformConfig.getDefaultInstance());

    // Assert
    assertSame(metadata, actualApplyMetadataTransformResult);
  }

  /**
   * Test {@link ImportModelJob#requiredMetadata(JobDefinition)} with {@code job}.
   *
   * <p>Method under test: {@link ImportModelJob#requiredMetadata(JobDefinition)}
   */
  @Test
  @DisplayName("Test requiredMetadata(JobDefinition) with 'job'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ImportModelJob.requiredMetadata(JobDefinition)"})
  void testRequiredMetadataWithJob() {
    // Arrange, Act and Assert
    assertTrue(new ImportModelJob().requiredMetadata(JobDefinition.getDefaultInstance()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#requiredMetadata(Map)} with {@code newResources}.
   *
   * <p>Method under test: {@link ImportModelJob#requiredMetadata(Map)}
   */
  @Test
  @DisplayName("Test requiredMetadata(Map) with 'newResources'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ImportModelJob.requiredMetadata(Map)"})
  void testRequiredMetadataWithNewResources() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}.
   *
   * <p>Method under test: {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, JobDefinition, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ImportModelJob.newResultIds(String, JobDefinition, Map, Map)"})
  void testNewResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(importModelJob.newResultIds("Tenant", job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#priorResultIds(JobDefinition, Map, Map)}.
   *
   * <p>Method under test: {@link ImportModelJob#priorResultIds(JobDefinition, Map, Map)}
   */
  @Test
  @DisplayName("Test priorResultIds(JobDefinition, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ImportModelJob.priorResultIds(JobDefinition, Map, Map)"})
  void testPriorResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(importModelJob.priorResultIds(job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#setResultIds(JobDefinition, Map, Map, Map)}.
   *
   * <p>Method under test: {@link ImportModelJob#setResultIds(JobDefinition, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test setResultIds(JobDefinition, Map, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDefinition ImportModelJob.setResultIds(JobDefinition, Map, Map, Map)"})
  void testSetResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, TagHeader> resultMapping = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act
    JobDefinition actualSetResultIdsResult =
        importModelJob.setResultIds(job, resultMapping, resources, new HashMap<>());

    // Assert
    assertSame(job, actualSetResultIdsResult);
  }

  /**
   * Test {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}.
   *
   * <p>Method under test: {@link ImportModelJob#buildResultMetadata(String, JobConfig,
   * RuntimeJobResult)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ImportModelJob.buildResultMetadata(String, JobConfig, RuntimeJobResult)"
  })
  void testBuildResultMetadata() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            new ImportModelJob()
                .buildResultMetadata(
                    "Tenant",
                    JobConfig.getDefaultInstance(),
                    RuntimeJobResult.getDefaultInstance()));
  }
}

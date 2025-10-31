package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyTransform(JobDefinition, MetadataBundle, PlatformConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition ImportModelJob.applyTransform(JobDefinition, MetadataBundle, PlatformConfig)"})
  void testApplyTransform() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.put("Import job refers to model repository [%s] which is not defined in the platform configuration",
        ObjectDefinition.getDefaultInstance());
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertThrows(EExecutorValidation.class,
        () -> importModelJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Test {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}.
   * <ul>
   *   <li>Then throw {@link EExecutorValidation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyTransform(JobDefinition, MetadataBundle, PlatformConfig); then throw EExecutorValidation")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition ImportModelJob.applyTransform(JobDefinition, MetadataBundle, PlatformConfig)"})
  void testApplyTransform_thenThrowEExecutorValidation() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertThrows(EExecutorValidation.class,
        () -> importModelJob.applyTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Test {@link ImportModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}.
   * <p>
   * Method under test: {@link ImportModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataBundle ImportModelJob.applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)"})
  void testApplyMetadataTransform() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(metadata, importModelJob.applyMetadataTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Test {@link ImportModelJob#requiredMetadata(JobDefinition)} with {@code job}.
   * <p>
   * Method under test: {@link ImportModelJob#requiredMetadata(JobDefinition)}
   */
  @Test
  @DisplayName("Test requiredMetadata(JobDefinition) with 'job'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ImportModelJob.requiredMetadata(JobDefinition)"})
  void testRequiredMetadataWithJob() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(JobDefinition.getDefaultInstance()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#requiredMetadata(Map)} with {@code newResources}.
   * <p>
   * Method under test: {@link ImportModelJob#requiredMetadata(Map)}
   */
  @Test
  @DisplayName("Test requiredMetadata(Map) with 'newResources'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ImportModelJob.requiredMetadata(Map)"})
  void testRequiredMetadataWithNewResources() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}.
   * <p>
   * Method under test: {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, JobDefinition, Map, Map)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link ImportModelJob#priorResultIds(JobDefinition, Map, Map)}
   */
  @Test
  @DisplayName("Test priorResultIds(JobDefinition, Map, Map)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link ImportModelJob#setResultIds(JobDefinition, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test setResultIds(JobDefinition, Map, Map, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition ImportModelJob.setResultIds(JobDefinition, Map, Map, Map)"})
  void testSetResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, TagHeader> resultMapping = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertSame(job, importModelJob.setResultIds(job, resultMapping, resources, new HashMap<>()));
  }

  /**
   * Test {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}.
   * <ul>
   *   <li>When {@code Tenant}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult); when 'Tenant'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ImportModelJob.buildResultMetadata(String, JobConfig, RuntimeJobResult)"})
  void testBuildResultMetadata_whenTenant_thenThrowEUnexpected() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> importModelJob.buildResultMetadata("Tenant", jobConfig, RuntimeJobResult.getDefaultInstance()));
  }

  /**
   * Test {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}.
   * <ul>
   *   <li>When {@code Unexpected internal error (this is a bug)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult); when 'Unexpected internal error (this is a bug)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ImportModelJob.buildResultMetadata(String, JobConfig, RuntimeJobResult)"})
  void testBuildResultMetadata_whenUnexpectedInternalErrorThisIsABug() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> importModelJob.buildResultMetadata("Unexpected internal error (this is a bug)", jobConfig,
            RuntimeJobResult.getDefaultInstance()));
  }
}

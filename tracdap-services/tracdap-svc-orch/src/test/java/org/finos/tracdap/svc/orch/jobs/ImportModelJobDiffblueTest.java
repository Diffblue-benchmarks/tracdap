package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.finos.tracdap.api.internal.RuntimeJobResult;
import org.finos.tracdap.common.exception.EExecutorValidation;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;

class ImportModelJobDiffblueTest {
  /**
   * Method under test:
   * {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyTransform() {
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
   * Method under test:
   * {@link ImportModelJob#applyTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyTransform2() {
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
   * Method under test:
   * {@link ImportModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
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
   * Method under test:
   * {@link ImportModelJob#applyMetadataTransform(JobDefinition, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testApplyMetadataTransform2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertSame(metadata, importModelJob.applyMetadataTransform(job, metadata, PlatformConfig.getDefaultInstance()));
  }

  /**
   * Method under test: {@link ImportModelJob#requiredMetadata(Map)}
   */
  @Test
  void testRequiredMetadata() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link ImportModelJob#requiredMetadata(Map)}
   */
  @Test
  void testRequiredMetadata2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    HashMap<String, ObjectDefinition> newResources = new HashMap<>();
    newResources.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(newResources).isEmpty());
  }

  /**
   * Method under test: {@link ImportModelJob#requiredMetadata(JobDefinition)}
   */
  @Test
  void testRequiredMetadata3() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();

    // Act and Assert
    assertTrue(importModelJob.requiredMetadata(JobDefinition.getDefaultInstance()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}
   */
  @Test
  void testNewResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(importModelJob.newResultIds("Tenant", job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportModelJob#newResultIds(String, JobDefinition, Map, Map)}
   */
  @Test
  void testNewResultIds2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(importModelJob.newResultIds("Tenant", job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportModelJob#priorResultIds(JobDefinition, Map, Map)}
   */
  @Test
  void testPriorResultIds() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(importModelJob.priorResultIds(job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportModelJob#priorResultIds(JobDefinition, Map, Map)}
   */
  @Test
  void testPriorResultIds2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(importModelJob.priorResultIds(job, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportModelJob#setResultIds(JobDefinition, Map, Map, Map)}
   */
  @Test
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
   * Method under test:
   * {@link ImportModelJob#setResultIds(JobDefinition, Map, Map, Map)}
   */
  @Test
  void testSetResultIds2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobDefinition job = JobDefinition.getDefaultInstance();

    HashMap<String, TagHeader> resultMapping = new HashMap<>();
    resultMapping.computeIfPresent("foo", mock(BiFunction.class));
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertSame(job, importModelJob.setResultIds(job, resultMapping, resources, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}
   */
  @Test
  void testBuildResultMetadata() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> importModelJob.buildResultMetadata("Tenant", jobConfig, RuntimeJobResult.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link ImportModelJob#buildResultMetadata(String, JobConfig, RuntimeJobResult)}
   */
  @Test
  void testBuildResultMetadata2() {
    // Arrange
    ImportModelJob importModelJob = new ImportModelJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> importModelJob.buildResultMetadata("Unexpected internal error (this is a bug)", jobConfig,
            RuntimeJobResult.getDefaultInstance()));
  }
}

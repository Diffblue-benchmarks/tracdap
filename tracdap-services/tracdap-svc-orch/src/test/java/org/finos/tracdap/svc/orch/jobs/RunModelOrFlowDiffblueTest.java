package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.finos.tracdap.api.internal.RuntimeJobResult;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.Test;

class RunModelOrFlowDiffblueTest {
  /**
   * Method under test: {@link RunModelOrFlow#requiredMetadata(Map)}
   */
  @Test
  void testRequiredMetadata() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    // Act and Assert
    assertTrue(runFlowJob.requiredMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#requiredMetadata(Map)}
   */
  @Test
  void testRequiredMetadata2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ObjectDefinition> newResources = new HashMap<>();
    newResources.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob.requiredMetadata(newResources).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#requiredMetadata(Map)}
   */
  @Test
  void testRequiredMetadata3() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ObjectDefinition> newResources = new HashMap<>();
    newResources.computeIfPresent("foo", mock(BiFunction.class));
    newResources.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob.requiredMetadata(newResources).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  void testNewResultIds() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashMap<String, ModelOutputSchema> outputRequirements = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.newResultIds("Tenant", outputRequirements, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  void testNewResultIds2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ModelOutputSchema> outputRequirements = new HashMap<>();
    outputRequirements.put("foo", ModelOutputSchema.getDefaultInstance());

    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    priorOutputsMap.put("foo", TagSelector.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob.newResultIds("Tenant", outputRequirements, priorOutputsMap).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  void testPriorResultIds() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();
    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  void testPriorResultIds2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    LinkedHashSet<String> outputKeys = new LinkedHashSet<>();
    outputKeys.add("Output Keys");
    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  void testPriorResultIds3() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();

    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    priorOutputsMap.computeIfPresent("foo", mock(BiFunction.class));
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  void testPriorResultIds4() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashSet<String> outputKeys = new HashSet<>();
    outputKeys.add("");
    outputKeys.add("foo");
    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#setResultIds(Set, Map)}
   */
  @Test
  void testSetResultIds() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();

    // Act and Assert
    assertTrue(runFlowJob.setResultIds(outputKeys, new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link RunModelOrFlow#setResultIds(Set, Map)}
   */
  @Test
  void testSetResultIds2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();

    HashMap<String, TagHeader> resultMapping = new HashMap<>();
    resultMapping.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(runFlowJob.setResultIds(outputKeys, resultMapping).isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  void testBuildResultMetadata() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();
    RuntimeJobResult jobResult = RuntimeJobResult.getDefaultInstance();
    HashMap<String, ModelOutputSchema> expectedOutputs = new HashMap<>();
    HashMap<String, TagSelector> outputs = new HashMap<>();
    HashMap<String, TagSelector> priorOutputs = new HashMap<>();
    ArrayList<TagUpdate> outputAttrs = new ArrayList<>();

    // Act and Assert
    assertTrue(runFlowJob
        .buildResultMetadata("Tenant", jobConfig, jobResult, expectedOutputs, outputs, priorOutputs, outputAttrs,
            new HashMap<>())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  void testBuildResultMetadata2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();
    RuntimeJobResult jobResult = RuntimeJobResult.getDefaultInstance();
    HashMap<String, ModelOutputSchema> expectedOutputs = new HashMap<>();
    HashMap<String, TagSelector> outputs = new HashMap<>();
    HashMap<String, TagSelector> priorOutputs = new HashMap<>();

    ArrayList<TagUpdate> outputAttrs = new ArrayList<>();
    outputAttrs.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob
        .buildResultMetadata("Tenant", jobConfig, jobResult, expectedOutputs, outputs, priorOutputs, outputAttrs,
            new HashMap<>())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  void testBuildResultMetadata3() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    JobConfig jobConfig = JobConfig.getDefaultInstance();
    RuntimeJobResult jobResult = RuntimeJobResult.getDefaultInstance();
    HashMap<String, ModelOutputSchema> expectedOutputs = new HashMap<>();
    HashMap<String, TagSelector> outputs = new HashMap<>();
    HashMap<String, TagSelector> priorOutputs = new HashMap<>();

    ArrayList<TagUpdate> outputAttrs = new ArrayList<>();
    outputAttrs.add(TagUpdate.getDefaultInstance());
    outputAttrs.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob
        .buildResultMetadata("Tenant", jobConfig, jobResult, expectedOutputs, outputs, priorOutputs, outputAttrs,
            new HashMap<>())
        .isEmpty());
  }
}

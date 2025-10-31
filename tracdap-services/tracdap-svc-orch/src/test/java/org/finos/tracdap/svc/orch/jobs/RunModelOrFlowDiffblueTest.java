package org.finos.tracdap.svc.orch.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.api.internal.RuntimeJobResult;
import org.finos.tracdap.config.JobConfig;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RunModelOrFlowDiffblueTest {
  /**
   * Test {@link RunModelOrFlow#requiredMetadata(Map)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#requiredMetadata(Map)}
   */
  @Test
  @DisplayName("Test requiredMetadata(Map); given DefaultInstance; when HashMap() 'foo' is DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RunModelOrFlow.requiredMetadata(Map)"})
  void testRequiredMetadata_givenDefaultInstance_whenHashMapFooIsDefaultInstance() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ObjectDefinition> newResources = new HashMap<>();
    newResources.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertTrue(runFlowJob.requiredMetadata(newResources).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#requiredMetadata(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#requiredMetadata(Map)}
   */
  @Test
  @DisplayName("Test requiredMetadata(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RunModelOrFlow.requiredMetadata(Map)"})
  void testRequiredMetadata_whenHashMap_thenReturnEmpty() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    // Act and Assert
    assertTrue(runFlowJob.requiredMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#newResultIds(String, Map, Map)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, Map, Map); given DefaultInstance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.newResultIds(String, Map, Map)"})
  void testNewResultIds_givenDefaultInstance_thenReturnEmpty() {
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
   * Test {@link RunModelOrFlow#newResultIds(String, Map, Map)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, Map, Map); given DefaultInstance; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.newResultIds(String, Map, Map)"})
  void testNewResultIds_givenDefaultInstance_thenReturnSizeIsTwo() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ModelOutputSchema> outputRequirements = new HashMap<>();
    outputRequirements.put("foo", ModelOutputSchema.getDefaultInstance());

    // Act
    Map<String, MetadataWriteRequest> actualNewResultIdsResult = runFlowJob.newResultIds("Tenant", outputRequirements,
        new HashMap<>());

    // Assert
    assertEquals(2, actualNewResultIdsResult.size());
    MetadataWriteRequest getResult = actualNewResultIdsResult.get("foo");
    assertEquals("", getResult.getInitializationErrorString());
    MetadataWriteRequest getResult2 = actualNewResultIdsResult.get("foo:STORAGE");
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("Tenant", getResult.getTenant());
    assertEquals("Tenant", getResult2.getTenant());
    assertEquals(0, getResult.getObjectTypeValue());
    assertEquals(0, getResult.getTagUpdatesCount());
    assertEquals(0, getResult2.getTagUpdatesCount());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(7, getResult2.getObjectTypeValue());
    assertEquals(8, getResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, getResult.getObjectType());
    assertEquals(ObjectType.STORAGE, getResult2.getObjectType());
    assertFalse(getResult.hasDefinition());
    assertFalse(getResult2.hasDefinition());
    assertFalse(getResult.hasPriorVersion());
    assertFalse(getResult2.hasPriorVersion());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = getResult2.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    assertSame(tagUpdatesList, getResult.getTagUpdatesList());
    assertSame(tagUpdatesList, getResult.getTagUpdatesOrBuilderList());
    assertSame(tagUpdatesList, getResult2.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link RunModelOrFlow#newResultIds(String, Map, Map)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, Map, Map); given DefaultInstance; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.newResultIds(String, Map, Map)"})
  void testNewResultIds_givenDefaultInstance_thenReturnSizeIsTwo2() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashMap<String, ModelOutputSchema> outputRequirements = new HashMap<>();
    outputRequirements.put("foo", ModelOutputSchema.getDefaultInstance());
    outputRequirements.put("foo", ModelOutputSchema.getDefaultInstance());

    // Act
    Map<String, MetadataWriteRequest> actualNewResultIdsResult = runFlowJob.newResultIds("Tenant", outputRequirements,
        new HashMap<>());

    // Assert
    assertEquals(2, actualNewResultIdsResult.size());
    MetadataWriteRequest getResult = actualNewResultIdsResult.get("foo");
    assertEquals("", getResult.getInitializationErrorString());
    MetadataWriteRequest getResult2 = actualNewResultIdsResult.get("foo:STORAGE");
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("Tenant", getResult.getTenant());
    assertEquals("Tenant", getResult2.getTenant());
    assertEquals(0, getResult.getObjectTypeValue());
    assertEquals(0, getResult.getTagUpdatesCount());
    assertEquals(0, getResult2.getTagUpdatesCount());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(7, getResult2.getObjectTypeValue());
    assertEquals(8, getResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, getResult.getObjectType());
    assertEquals(ObjectType.STORAGE, getResult2.getObjectType());
    assertFalse(getResult.hasDefinition());
    assertFalse(getResult2.hasDefinition());
    assertFalse(getResult.hasPriorVersion());
    assertFalse(getResult2.hasPriorVersion());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = getResult2.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    assertSame(tagUpdatesList, getResult.getTagUpdatesList());
    assertSame(tagUpdatesList, getResult.getTagUpdatesOrBuilderList());
    assertSame(tagUpdatesList, getResult2.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link RunModelOrFlow#newResultIds(String, Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#newResultIds(String, Map, Map)}
   */
  @Test
  @DisplayName("Test newResultIds(String, Map, Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.newResultIds(String, Map, Map)"})
  void testNewResultIds_whenHashMap_thenReturnEmpty() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashMap<String, ModelOutputSchema> outputRequirements = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.newResultIds("Tenant", outputRequirements, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test priorResultIds(Set, Map, Map, Map); given '42'; when HashSet() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.priorResultIds(Set, Map, Map, Map)"})
  void testPriorResultIds_given42_whenHashSetAdd42_thenReturnEmpty() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();

    HashSet<String> outputKeys = new HashSet<>();
    outputKeys.add("42");
    outputKeys.add("foo");
    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}.
   * <ul>
   *   <li>Given {@code Output Keys}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Output Keys}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test priorResultIds(Set, Map, Map, Map); given 'Output Keys'; when LinkedHashSet() add 'Output Keys'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.priorResultIds(Set, Map, Map, Map)"})
  void testPriorResultIds_givenOutputKeys_whenLinkedHashSetAddOutputKeys() {
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
   * Test {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#priorResultIds(Set, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test priorResultIds(Set, Map, Map, Map); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.priorResultIds(Set, Map, Map, Map)"})
  void testPriorResultIds_whenHashSet_thenReturnEmpty() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();
    HashMap<String, TagSelector> priorOutputsMap = new HashMap<>();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();

    // Act and Assert
    assertTrue(runFlowJob.priorResultIds(outputKeys, priorOutputsMap, resources, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#setResultIds(Set, Map)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#setResultIds(Set, Map)}
   */
  @Test
  @DisplayName("Test setResultIds(Set, Map); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RunModelOrFlow.setResultIds(Set, Map)"})
  void testSetResultIds_whenHashSet_thenReturnEmpty() {
    // Arrange
    RunFlowJob runFlowJob = new RunFlowJob();
    HashSet<String> outputKeys = new HashSet<>();

    // Act and Assert
    assertTrue(runFlowJob.setResultIds(outputKeys, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map); when ArrayList() add DefaultInstance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List RunModelOrFlow.buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)"})
  void testBuildResultMetadata_whenArrayListAddDefaultInstance_thenReturnEmpty() {
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
   * Test {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map); when ArrayList() add DefaultInstance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List RunModelOrFlow.buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)"})
  void testBuildResultMetadata_whenArrayListAddDefaultInstance_thenReturnEmpty2() {
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

  /**
   * Test {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelOrFlow#buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)}
   */
  @Test
  @DisplayName("Test buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List RunModelOrFlow.buildResultMetadata(String, JobConfig, RuntimeJobResult, Map, Map, Map, List, Map)"})
  void testBuildResultMetadata_whenArrayList_thenReturnEmpty() {
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
}

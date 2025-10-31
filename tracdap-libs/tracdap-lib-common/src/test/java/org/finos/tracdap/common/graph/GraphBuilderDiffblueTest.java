package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.metadata.FlowDefinition;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.finos.tracdap.metadata.RunModelJob;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphBuilderDiffblueTest {
  /**
   * Test {@link GraphBuilder#buildJob(JobDefinition)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#buildJob(JobDefinition)}
   */
  @Test
  @DisplayName("Test buildJob(JobDefinition); when DefaultInstance; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.buildJob(JobDefinition)"})
  void testBuildJob_whenDefaultInstance_thenThrowETracInternal() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.buildJob(JobDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link GraphBuilder#buildRunFlowJob(RunFlowJob)}.
   * <ul>
   *   <li>Given {@link GraphBuilder#GraphBuilder(NodeNamespace)} with namespace is {@link NodeNamespace#ROOT}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#buildRunFlowJob(RunFlowJob)}
   */
  @Test
  @DisplayName("Test buildRunFlowJob(RunFlowJob); given GraphBuilder(NodeNamespace) with namespace is ROOT; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.buildRunFlowJob(RunFlowJob)"})
  void testBuildRunFlowJob_givenGraphBuilderWithNamespaceIsRoot_thenThrowETracInternal() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.buildRunFlowJob(RunFlowJob.getDefaultInstance()));
  }

  /**
   * Test {@link GraphBuilder#buildFlow(FlowDefinition)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#buildFlow(FlowDefinition)}
   */
  @Test
  @DisplayName("Test buildFlow(FlowDefinition); when DefaultInstance; then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.buildFlow(FlowDefinition)"})
  void testBuildFlow_whenDefaultInstance_thenReturnInputsEmpty() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    // Act
    GraphSection<NodeMetadata> actualBuildFlowResult = graphBuilder.buildFlow(FlowDefinition.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualBuildFlowResult.inputs();
    assertTrue(inputsResult.isEmpty());
    assertTrue(actualBuildFlowResult.nodes().isEmpty());
    assertSame(inputsResult, actualBuildFlowResult.outputs());
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)} with {@code GraphSection}, {@code Map}, {@code Map}, {@code Map}, {@code Map}.
   * <ul>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, Map, Map, Map, Map) with 'GraphSection', 'Map', 'Map', 'Map', 'Map'; then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, Map, Map, Map, Map)"})
  void testAddJobMetadataWithGraphSectionMapMapMapMap_thenReturnInputsEmpty() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs = new HashMap<>();

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph, params, inputs2, outputs,
        new HashMap<>());

    // Assert
    assertTrue(actualAddJobMetadataResult.inputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.outputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)} with {@code GraphSection}, {@code Map}, {@code Map}, {@code Map}, {@code Map}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, Map, Map, Map, Map) with 'GraphSection', 'Map', 'Map', 'Map', 'Map'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, Map, Map, Map, Map)"})
  void testAddJobMetadataWithGraphSectionMapMapMapMap_thenThrowETracInternal() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs = new HashMap<>();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> graphBuilder.addJobMetadata(graph, params, inputs2, outputs, new HashMap<>()));
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)} with {@code GraphSection}, {@code RunFlowJob}.
   * <ul>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, RunFlowJob) with 'GraphSection', 'RunFlowJob'; then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, RunFlowJob)"})
  void testAddJobMetadataWithGraphSectionRunFlowJob_thenReturnInputsEmpty() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunFlowJob.getDefaultInstance());

    // Assert
    assertTrue(actualAddJobMetadataResult.inputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.outputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)} with {@code GraphSection}, {@code RunFlowJob}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, RunFlowJob) with 'GraphSection', 'RunFlowJob'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, RunFlowJob)"})
  void testAddJobMetadataWithGraphSectionRunFlowJob_thenThrowETracInternal() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.addJobMetadata(graph, RunFlowJob.getDefaultInstance()));
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)} with {@code GraphSection}, {@code RunModelJob}.
   * <ul>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, RunModelJob) with 'GraphSection', 'RunModelJob'; then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, RunModelJob)"})
  void testAddJobMetadataWithGraphSectionRunModelJob_thenReturnInputsEmpty() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunModelJob.getDefaultInstance());

    // Assert
    assertTrue(actualAddJobMetadataResult.inputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.outputs().isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)} with {@code GraphSection}, {@code RunModelJob}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  @DisplayName("Test addJobMetadata(GraphSection, RunModelJob) with 'GraphSection', 'RunModelJob'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.addJobMetadata(GraphSection, RunModelJob)"})
  void testAddJobMetadataWithGraphSectionRunModelJob_thenThrowETracInternal() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.addJobMetadata(graph, RunModelJob.getDefaultInstance()));
  }

  /**
   * Test {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}.
   * <ul>
   *   <li>Given {@link NodeNamespace#NodeNamespace(String)} with {@code Name}.</li>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  @DisplayName("Test autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob); given NodeNamespace(String) with 'Name'; then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)"})
  void testAutowireFlowParameters_givenNodeNamespaceWithName_thenReturnInputsEmpty() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(new NodeNamespace("Name"));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    assertTrue(actualAutowireFlowParametersResult.inputs().isEmpty());
    assertTrue(actualAutowireFlowParametersResult.outputs().isEmpty());
    assertTrue(actualAutowireFlowParametersResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}.
   * <ul>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  @DisplayName("Test autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob); then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)"})
  void testAutowireFlowParameters_thenReturnInputsEmpty() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    assertTrue(actualAutowireFlowParametersResult.inputs().isEmpty());
    assertTrue(actualAutowireFlowParametersResult.outputs().isEmpty());
    assertTrue(actualAutowireFlowParametersResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#applyTypeInference(GraphSection)}.
   * <ul>
   *   <li>Then return inputs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  @DisplayName("Test applyTypeInference(GraphSection); then return inputs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphSection GraphBuilder.applyTypeInference(GraphSection)"})
  void testApplyTypeInference_thenReturnInputsEmpty() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, new ArrayList<>()));

    // Assert
    assertTrue(actualApplyTypeInferenceResult.inputs().isEmpty());
    assertTrue(actualApplyTypeInferenceResult.outputs().isEmpty());
    assertTrue(actualApplyTypeInferenceResult.nodes().isEmpty());
  }

  /**
   * Test {@link GraphBuilder#exportFlow(GraphSection)}.
   * <ul>
   *   <li>Given {@link NodeNamespace#NodeNamespace(String)} with {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#exportFlow(GraphSection)}
   */
  @Test
  @DisplayName("Test exportFlow(GraphSection); given NodeNamespace(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowDefinition GraphBuilder.exportFlow(GraphSection)"})
  void testExportFlow_givenNodeNamespaceWithName() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(new NodeNamespace("Name"));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();

    // Act
    FlowDefinition actualExportFlowResult = graphBuilder
        .exportFlow(new GraphSection<>(nodes, inputs, new ArrayList<>()));

    // Assert
    Descriptor descriptorForType = actualExportFlowResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getNestedTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    assertEquals(actualExportFlowResult, actualExportFlowResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualExportFlowResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link GraphBuilder#exportFlow(GraphSection)}.
   * <ul>
   *   <li>Then return DescriptorForType NestedTypes size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphBuilder#exportFlow(GraphSection)}
   */
  @Test
  @DisplayName("Test exportFlow(GraphSection); then return DescriptorForType NestedTypes size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowDefinition GraphBuilder.exportFlow(GraphSection)"})
  void testExportFlow_thenReturnDescriptorForTypeNestedTypesSizeIsFour() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();

    // Act
    FlowDefinition actualExportFlowResult = graphBuilder
        .exportFlow(new GraphSection<>(nodes, inputs, new ArrayList<>()));

    // Assert
    Descriptor descriptorForType = actualExportFlowResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getNestedTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    assertEquals(actualExportFlowResult, actualExportFlowResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualExportFlowResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}

package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.metadata.FlowDefinition;
import org.finos.tracdap.metadata.FlowNode;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.ModelInputSchema;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ModelParameter;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.finos.tracdap.metadata.RunModelJob;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;

class GraphBuilderDiffblueTest {
  /**
   * Method under test: {@link GraphBuilder#buildJob(JobDefinition)}
   */
  @Test
  void testBuildJob() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.buildJob(JobDefinition.getDefaultInstance()));
  }

  /**
   * Method under test: {@link GraphBuilder#buildRunFlowJob(RunFlowJob)}
   */
  @Test
  void testBuildRunFlowJob() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.buildRunFlowJob(RunFlowJob.getDefaultInstance()));
  }

  /**
   * Method under test: {@link GraphBuilder#buildFlow(FlowDefinition)}
   */
  @Test
  void testBuildFlow() {
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
   * Method under test: {@link GraphBuilder#buildFlow(FlowDefinition)}
   */
  @Test
  void testBuildFlow2() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));

    // Act
    GraphSection<NodeMetadata> actualBuildFlowResult = graphBuilder.buildFlow(FlowDefinition.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualBuildFlowResult.inputs();
    assertTrue(inputsResult.isEmpty());
    assertTrue(actualBuildFlowResult.nodes().isEmpty());
    assertSame(inputsResult, actualBuildFlowResult.outputs());
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  void testAddJobMetadata() {
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
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  void testAddJobMetadata2() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs2 = new HashMap<>();

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph, params, inputs2,
        outputs2, new HashMap<>());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  void testAddJobMetadata3() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs2 = new HashMap<>();

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph, params, inputs2,
        outputs2, new HashMap<>());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  void testAddJobMetadata4() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("No metadata bundle supplied, job metadata cannot be added to the graph",
        NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs2 = new HashMap<>();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> graphBuilder.addJobMetadata(graph, params, inputs2, outputs2, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, Map, Map, Map, Map)}
   */
  @Test
  void testAddJobMetadata5() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("No metadata bundle supplied, job metadata cannot be added to the graph",
        NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.putIfAbsent(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    HashMap<String, Value> params = new HashMap<>();
    HashMap<String, TagSelector> inputs2 = new HashMap<>();
    HashMap<String, TagSelector> outputs2 = new HashMap<>();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> graphBuilder.addJobMetadata(graph, params, inputs2, outputs2, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  void testAddJobMetadata6() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.addJobMetadata(graph, RunFlowJob.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  void testAddJobMetadata7() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunFlowJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  void testAddJobMetadata8() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunFlowJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunFlowJob)}
   */
  @Test
  void testAddJobMetadata9() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("No metadata bundle supplied, job metadata cannot be added to the graph",
        NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> graphBuilder.addJobMetadata(graph, RunFlowJob.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  void testAddJobMetadata10() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> graphBuilder.addJobMetadata(graph, RunModelJob.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  void testAddJobMetadata11() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunModelJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  void testAddJobMetadata12() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    // Act
    GraphSection<NodeMetadata> actualAddJobMetadataResult = graphBuilder.addJobMetadata(graph,
        RunModelJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAddJobMetadataResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAddJobMetadataResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAddJobMetadataResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#addJobMetadata(GraphSection, RunModelJob)}
   */
  @Test
  void testAddJobMetadata13() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("trac_model", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("trac_model", NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, new ArrayList<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> graphBuilder.addJobMetadata(graph, RunModelJob.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  void testAutowireFlowParameters() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAutowireFlowParametersResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAutowireFlowParametersResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAutowireFlowParametersResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  void testAutowireFlowParameters2() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(new NodeNamespace("Name"));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAutowireFlowParametersResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAutowireFlowParametersResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAutowireFlowParametersResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  void testAutowireFlowParameters3() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs);

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    List<NodeId> inputsResult = actualAutowireFlowParametersResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAutowireFlowParametersResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualAutowireFlowParametersResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  void testAutowireFlowParameters4() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("Name", NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs2 = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs2);

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    assertEquals(1, actualAutowireFlowParametersResult.nodes().size());
    List<NodeId> inputsResult = actualAutowireFlowParametersResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAutowireFlowParametersResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs2, outputsResult);
  }

  /**
   * Method under test:
   * {@link GraphBuilder#autowireFlowParameters(GraphSection, FlowDefinition, RunFlowJob)}
   */
  @Test
  void testAutowireFlowParameters5() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("Name", NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, null, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs2 = new ArrayList<>();
    GraphSection<NodeMetadata> graph = new GraphSection<>(nodes, inputs, outputs2);

    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    // Act
    GraphSection<NodeMetadata> actualAutowireFlowParametersResult = graphBuilder.autowireFlowParameters(graph, flow,
        RunFlowJob.getDefaultInstance());

    // Assert
    assertEquals(1, actualAutowireFlowParametersResult.nodes().size());
    List<NodeId> inputsResult = actualAutowireFlowParametersResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualAutowireFlowParametersResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs2, outputsResult);
  }

  /**
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  void testApplyTypeInference() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, outputs));

    // Assert
    List<NodeId> inputsResult = actualApplyTypeInferenceResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualApplyTypeInferenceResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualApplyTypeInferenceResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  void testApplyTypeInference2() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT, new MetadataBundle(resources, new HashMap<>()),
        mock(GraphBuilder.ErrorHandler.class));
    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, outputs));

    // Assert
    List<NodeId> inputsResult = actualApplyTypeInferenceResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualApplyTypeInferenceResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertTrue(actualApplyTypeInferenceResult.nodes().isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs, outputsResult);
  }

  /**
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  void testApplyTypeInference3() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    NodeId nodeId2 = new NodeId("Name", NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    nodes.put(nodeId, new Node<>(nodeId2, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance())));
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs2 = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, outputs2));

    // Assert
    assertEquals(1, actualApplyTypeInferenceResult.nodes().size());
    List<NodeId> inputsResult = actualApplyTypeInferenceResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualApplyTypeInferenceResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs2, outputsResult);
  }

  /**
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  void testApplyTypeInference4() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    dependencies.put("foo", new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Node<NodeMetadata> node = new Node<>(nodeId, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    nodes.put(new NodeId("Name", NodeNamespace.ROOT), node);
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs2 = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, outputs2));

    // Assert
    assertEquals(1, actualApplyTypeInferenceResult.nodes().size());
    List<NodeId> inputsResult = actualApplyTypeInferenceResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualApplyTypeInferenceResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs2, outputsResult);
  }

  /**
   * Method under test: {@link GraphBuilder#applyTypeInference(GraphSection)}
   */
  @Test
  void testApplyTypeInference5() {
    // Arrange
    GraphBuilder graphBuilder = new GraphBuilder(NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    dependencies.put("42", new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
    dependencies.put("foo", new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    ArrayList<String> outputs = new ArrayList<>();
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Node<NodeMetadata> node = new Node<>(nodeId, dependencies, outputs, new NodeMetadata(flowNode, modelParameter,
        modelInputSchema, modelOutputSchema, runtimeObject, Value.getDefaultInstance()));

    HashMap<NodeId, Node<NodeMetadata>> nodes = new HashMap<>();
    nodes.put(new NodeId("Name", NodeNamespace.ROOT), node);
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs2 = new ArrayList<>();

    // Act
    GraphSection<NodeMetadata> actualApplyTypeInferenceResult = graphBuilder
        .applyTypeInference(new GraphSection<>(nodes, inputs, outputs2));

    // Assert
    assertEquals(1, actualApplyTypeInferenceResult.nodes().size());
    List<NodeId> inputsResult = actualApplyTypeInferenceResult.inputs();
    assertTrue(inputsResult.isEmpty());
    List<NodeId> outputsResult = actualApplyTypeInferenceResult.outputs();
    assertTrue(outputsResult.isEmpty());
    assertSame(inputs, inputsResult);
    assertSame(outputs2, outputsResult);
  }
}

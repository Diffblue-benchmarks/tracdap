package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.tracdap.metadata.FlowNode;
import org.finos.tracdap.metadata.ModelInputSchema;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ModelParameter;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;

class NodeMetadataDiffblueTest {
  /**
   * Method under test: {@link NodeMetadata#withFlowNode(FlowNode)}
   */
  @Test
  void testWithFlowNode() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    FlowNode flowNode2 = FlowNode.getDefaultInstance();

    // Act
    NodeMetadata actualWithFlowNodeResult = nodeMetadata.withFlowNode(flowNode2);

    // Assert
    assertSame(flowNode2, actualWithFlowNodeResult.flowNode());
    assertSame(modelInputSchema, actualWithFlowNodeResult.modelInputSchema());
    assertSame(modelOutputSchema, actualWithFlowNodeResult.modelOutputSchema());
    assertSame(modelParameter, actualWithFlowNodeResult.modelParameter());
    assertSame(runtimeObject, actualWithFlowNodeResult.runtimeObject());
    assertSame(runtimeValue, actualWithFlowNodeResult.runtimeValue());
  }

  /**
   * Method under test: {@link NodeMetadata#withModelParameter(ModelParameter)}
   */
  @Test
  void testWithModelParameter() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    ModelParameter modelParameter2 = ModelParameter.getDefaultInstance();

    // Act
    NodeMetadata actualWithModelParameterResult = nodeMetadata.withModelParameter(modelParameter2);

    // Assert
    assertSame(flowNode, actualWithModelParameterResult.flowNode());
    assertSame(modelInputSchema, actualWithModelParameterResult.modelInputSchema());
    assertSame(modelOutputSchema, actualWithModelParameterResult.modelOutputSchema());
    assertSame(modelParameter2, actualWithModelParameterResult.modelParameter());
    assertSame(runtimeObject, actualWithModelParameterResult.runtimeObject());
    assertSame(runtimeValue, actualWithModelParameterResult.runtimeValue());
  }

  /**
   * Method under test:
   * {@link NodeMetadata#withModelInputSchema(ModelInputSchema)}
   */
  @Test
  void testWithModelInputSchema() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    ModelInputSchema modelInputSchema2 = ModelInputSchema.getDefaultInstance();

    // Act
    NodeMetadata actualWithModelInputSchemaResult = nodeMetadata.withModelInputSchema(modelInputSchema2);

    // Assert
    assertSame(flowNode, actualWithModelInputSchemaResult.flowNode());
    assertSame(modelInputSchema2, actualWithModelInputSchemaResult.modelInputSchema());
    assertSame(modelOutputSchema, actualWithModelInputSchemaResult.modelOutputSchema());
    assertSame(modelParameter, actualWithModelInputSchemaResult.modelParameter());
    assertSame(runtimeObject, actualWithModelInputSchemaResult.runtimeObject());
    assertSame(runtimeValue, actualWithModelInputSchemaResult.runtimeValue());
  }

  /**
   * Method under test:
   * {@link NodeMetadata#withModelOutputSchema(ModelOutputSchema)}
   */
  @Test
  void testWithModelOutputSchema() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    ModelOutputSchema modelOutputSchema2 = ModelOutputSchema.getDefaultInstance();

    // Act
    NodeMetadata actualWithModelOutputSchemaResult = nodeMetadata.withModelOutputSchema(modelOutputSchema2);

    // Assert
    assertSame(flowNode, actualWithModelOutputSchemaResult.flowNode());
    assertSame(modelInputSchema, actualWithModelOutputSchemaResult.modelInputSchema());
    assertSame(modelOutputSchema2, actualWithModelOutputSchemaResult.modelOutputSchema());
    assertSame(modelParameter, actualWithModelOutputSchemaResult.modelParameter());
    assertSame(runtimeObject, actualWithModelOutputSchemaResult.runtimeObject());
    assertSame(runtimeValue, actualWithModelOutputSchemaResult.runtimeValue());
  }

  /**
   * Method under test: {@link NodeMetadata#withRuntimeObject(ObjectDefinition)}
   */
  @Test
  void testWithRuntimeObject() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    ObjectDefinition runtimeObject2 = ObjectDefinition.getDefaultInstance();

    // Act
    NodeMetadata actualWithRuntimeObjectResult = nodeMetadata.withRuntimeObject(runtimeObject2);

    // Assert
    assertSame(flowNode, actualWithRuntimeObjectResult.flowNode());
    assertSame(modelInputSchema, actualWithRuntimeObjectResult.modelInputSchema());
    assertSame(modelOutputSchema, actualWithRuntimeObjectResult.modelOutputSchema());
    assertSame(modelParameter, actualWithRuntimeObjectResult.modelParameter());
    assertSame(runtimeObject2, actualWithRuntimeObjectResult.runtimeObject());
    assertSame(runtimeValue, actualWithRuntimeObjectResult.runtimeValue());
  }

  /**
   * Method under test: {@link NodeMetadata#withRuntimeValue(Value)}
   */
  @Test
  void testWithRuntimeValue() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    NodeMetadata nodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, Value.getDefaultInstance());
    Value runtimeValue = Value.getDefaultInstance();

    // Act
    NodeMetadata actualWithRuntimeValueResult = nodeMetadata.withRuntimeValue(runtimeValue);

    // Assert
    assertSame(flowNode, actualWithRuntimeValueResult.flowNode());
    assertSame(modelInputSchema, actualWithRuntimeValueResult.modelInputSchema());
    assertSame(modelOutputSchema, actualWithRuntimeValueResult.modelOutputSchema());
    assertSame(modelParameter, actualWithRuntimeValueResult.modelParameter());
    assertSame(runtimeObject, actualWithRuntimeValueResult.runtimeObject());
    assertSame(runtimeValue, actualWithRuntimeValueResult.runtimeValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NodeMetadata#NodeMetadata(FlowNode, ModelParameter, ModelInputSchema, ModelOutputSchema, ObjectDefinition, Value)}
   *   <li>{@link NodeMetadata#flowNode()}
   *   <li>{@link NodeMetadata#modelInputSchema()}
   *   <li>{@link NodeMetadata#modelOutputSchema()}
   *   <li>{@link NodeMetadata#modelParameter()}
   *   <li>{@link NodeMetadata#runtimeObject()}
   *   <li>{@link NodeMetadata#runtimeValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();
    Value runtimeValue = Value.getDefaultInstance();

    // Act
    NodeMetadata actualNodeMetadata = new NodeMetadata(flowNode, modelParameter, modelInputSchema, modelOutputSchema,
        runtimeObject, runtimeValue);
    FlowNode actualFlowNodeResult = actualNodeMetadata.flowNode();
    ModelInputSchema actualModelInputSchemaResult = actualNodeMetadata.modelInputSchema();
    ModelOutputSchema actualModelOutputSchemaResult = actualNodeMetadata.modelOutputSchema();
    ModelParameter actualModelParameterResult = actualNodeMetadata.modelParameter();
    ObjectDefinition actualRuntimeObjectResult = actualNodeMetadata.runtimeObject();

    // Assert
    assertSame(flowNode, actualFlowNodeResult);
    assertSame(modelInputSchema, actualModelInputSchemaResult);
    assertSame(modelOutputSchema, actualModelOutputSchemaResult);
    assertSame(modelParameter, actualModelParameterResult);
    assertSame(runtimeObject, actualRuntimeObjectResult);
    assertSame(runtimeValue, actualNodeMetadata.runtimeValue());
  }

  /**
   * Method under test: {@link NodeMetadata#runtimeObjectType()}
   */
  @Test
  void testRuntimeObjectType() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();
    ObjectDefinition runtimeObject = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, (new NodeMetadata(flowNode, modelParameter, modelInputSchema,
        modelOutputSchema, runtimeObject, Value.getDefaultInstance())).runtimeObjectType());
  }

  /**
   * Method under test: {@link NodeMetadata#runtimeObjectType()}
   */
  @Test
  void testRuntimeObjectType2() {
    // Arrange
    FlowNode flowNode = FlowNode.getDefaultInstance();
    ModelParameter modelParameter = ModelParameter.getDefaultInstance();
    ModelInputSchema modelInputSchema = ModelInputSchema.getDefaultInstance();
    ModelOutputSchema modelOutputSchema = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, (new NodeMetadata(flowNode, modelParameter, modelInputSchema,
        modelOutputSchema, null, Value.getDefaultInstance())).runtimeObjectType());
  }
}

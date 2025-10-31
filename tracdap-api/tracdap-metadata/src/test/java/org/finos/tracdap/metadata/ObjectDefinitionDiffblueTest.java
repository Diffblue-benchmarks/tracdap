package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.DataDefinition.SchemaSpecifierCase;
import org.finos.tracdap.metadata.JobDefinition.JobDetailsCase;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectDefinitionDiffblueTest {
  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code RESULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when CANCELLED_VALUE; then return 'RESULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenCancelled_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.RESULT, DefinitionCase.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when eight; then return 'STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenEight_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.STORAGE, DefinitionCase.forNumber(8));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code JOB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when five; then return 'JOB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFive_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.JOB, DefinitionCase.forNumber(5));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefinitionCase.forNumber(42));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when four; then return 'FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFour_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FLOW, DefinitionCase.forNumber(4));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when MAP_VALUE; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenMap_value_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.SCHEMA, DefinitionCase.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when seven; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenSeven_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.CUSTOM, DefinitionCase.forNumber(7));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code FILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when six; then return 'FILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenSix_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FILE, DefinitionCase.forNumber(6));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when three; then return 'MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenThree_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.MODEL, DefinitionCase.forNumber(3));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when two; then return 'DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenTwo_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DATA, DefinitionCase.forNumber(2));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code DEFINITION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when zero; then return 'DEFINITION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenZero_thenReturnDefinitionNotSet() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, DefinitionCase.forNumber(0));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#getNumber()}.
   * <p>
   * Method under test: {@link DefinitionCase#getNumber()}
   */
  @Test
  @DisplayName("Test DefinitionCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefinitionCase.getNumber()"})
  void testDefinitionCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, DefinitionCase.valueOf("DATA").getNumber());
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code RESULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when CANCELLED_VALUE; then return 'RESULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenCancelled_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.RESULT, DefinitionCase.valueOf(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when eight; then return 'STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenEight_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.STORAGE, DefinitionCase.valueOf(8));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code JOB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when five; then return 'JOB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFive_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.JOB, DefinitionCase.valueOf(5));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefinitionCase.valueOf(42));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when four; then return 'FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFour_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FLOW, DefinitionCase.valueOf(4));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when MAP_VALUE; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenMap_value_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.SCHEMA, DefinitionCase.valueOf(BasicType.MAP_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when seven; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenSeven_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.CUSTOM, DefinitionCase.valueOf(7));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code FILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when six; then return 'FILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenSix_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FILE, DefinitionCase.valueOf(6));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when three; then return 'MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenThree_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.MODEL, DefinitionCase.valueOf(3));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when two; then return 'DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenTwo_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DATA, DefinitionCase.valueOf(2));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code DEFINITION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when zero; then return 'DEFINITION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenZero_thenReturnDefinitionNotSet() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, DefinitionCase.valueOf(0));
  }

  /**
   * Test {@link ObjectDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ObjectDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ObjectDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ObjectDefinition.OBJECTPROPS_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ObjectDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ObjectDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ObjectDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ObjectDefinition.RESULT_FIELD_NUMBER));
  }

  /**
   * Test {@link ObjectDefinition#getDefinitionCase()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getDefinitionCase()}
   */
  @Test
  @DisplayName("Test getDefinitionCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefinitionCase ObjectDefinition.getDefinitionCase()"})
  void testGetDefinitionCase() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, ObjectDefinition.getDefaultInstance().getDefinitionCase());
  }

  /**
   * Test {@link ObjectDefinition#getObjectType()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectType()}
   */
  @Test
  @DisplayName("Test getObjectType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectDefinition.getObjectType()"})
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ObjectDefinition.getDefaultInstance().getObjectType());
  }

  /**
   * Test {@link ObjectDefinition#hasData()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasData()}
   */
  @Test
  @DisplayName("Test hasData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasData()"})
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasData());
  }

  /**
   * Test {@link ObjectDefinition#getData()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition ObjectDefinition.getData()"})
  void testGetData() {
    // Arrange and Act
    DataDefinition actualData = ObjectDefinition.getDefaultInstance().getData();

    // Assert
    assertEquals("", actualData.getInitializationErrorString());
    assertEquals(0, actualData.getPartsCount());
    assertEquals(0, actualData.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualData.getSchemaSpecifierCase());
    assertFalse(actualData.hasSchema());
    assertFalse(actualData.hasSchemaId());
    assertFalse(actualData.hasStorageId());
    assertTrue(actualData.findInitializationErrors().isEmpty());
    assertTrue(actualData.getAllFields().isEmpty());
    assertTrue(actualData.getParts().isEmpty());
    assertTrue(actualData.getPartsMap().isEmpty());
    assertTrue(actualData.isInitialized());
    assertSame(actualData, actualData.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasModel()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasModel()}
   */
  @Test
  @DisplayName("Test hasModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasModel()"})
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasModel());
  }

  /**
   * Test {@link ObjectDefinition#getModel()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getModel()}
   */
  @Test
  @DisplayName("Test getModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ObjectDefinition.getModel()"})
  void testGetModel() {
    // Arrange and Act
    ModelDefinition actualModel = ObjectDefinition.getDefaultInstance().getModel();

    // Assert
    assertEquals("", actualModel.getInitializationErrorString());
    assertEquals("", actualModel.getEntryPoint());
    assertEquals("", actualModel.getLanguage());
    assertEquals("", actualModel.getPackage());
    assertEquals("", actualModel.getPackageGroup());
    assertEquals("", actualModel.getPath());
    assertEquals("", actualModel.getRepository());
    assertEquals("", actualModel.getVersion());
    assertEquals(0, actualModel.getInputsCount());
    assertEquals(0, actualModel.getModelTypeValue());
    assertEquals(0, actualModel.getOutputsCount());
    assertEquals(0, actualModel.getParametersCount());
    assertEquals(0, actualModel.getSerializedSize());
    assertEquals(0, actualModel.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualModel.getModelType());
    assertFalse(actualModel.hasPackageGroup());
    assertFalse(actualModel.hasPath());
    assertTrue(actualModel.findInitializationErrors().isEmpty());
    assertTrue(actualModel.getAllFields().isEmpty());
    assertTrue(actualModel.getInputs().isEmpty());
    assertTrue(actualModel.getInputsMap().isEmpty());
    assertTrue(actualModel.getOutputs().isEmpty());
    assertTrue(actualModel.getOutputsMap().isEmpty());
    assertTrue(actualModel.getParameters().isEmpty());
    assertTrue(actualModel.getParametersMap().isEmpty());
    assertTrue(actualModel.getStaticAttributes().isEmpty());
    assertTrue(actualModel.getStaticAttributesMap().isEmpty());
    assertTrue(actualModel.isInitialized());
    assertSame(actualModel, actualModel.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasFlow()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasFlow()}
   */
  @Test
  @DisplayName("Test hasFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasFlow()"})
  void testHasFlow() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasFlow());
  }

  /**
   * Test {@link ObjectDefinition#getFlow()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getFlow()}
   */
  @Test
  @DisplayName("Test getFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowDefinition ObjectDefinition.getFlow()"})
  void testGetFlow() {
    // Arrange and Act
    FlowDefinition actualFlow = ObjectDefinition.getDefaultInstance().getFlow();

    // Assert
    assertEquals("", actualFlow.getInitializationErrorString());
    assertEquals(0, actualFlow.getEdgesCount());
    assertEquals(0, actualFlow.getInputsCount());
    assertEquals(0, actualFlow.getNodesCount());
    assertEquals(0, actualFlow.getOutputsCount());
    assertEquals(0, actualFlow.getParametersCount());
    assertEquals(0, actualFlow.getSerializedSize());
    assertTrue(actualFlow.findInitializationErrors().isEmpty());
    List<FlowEdge> edgesList = actualFlow.getEdgesList();
    assertTrue(edgesList.isEmpty());
    assertTrue(actualFlow.getAllFields().isEmpty());
    assertTrue(actualFlow.getInputs().isEmpty());
    assertTrue(actualFlow.getInputsMap().isEmpty());
    assertTrue(actualFlow.getNodes().isEmpty());
    assertTrue(actualFlow.getNodesMap().isEmpty());
    assertTrue(actualFlow.getOutputs().isEmpty());
    assertTrue(actualFlow.getOutputsMap().isEmpty());
    assertTrue(actualFlow.getParameters().isEmpty());
    assertTrue(actualFlow.getParametersMap().isEmpty());
    assertTrue(actualFlow.isInitialized());
    assertSame(edgesList, actualFlow.getEdgesOrBuilderList());
    assertSame(actualFlow, actualFlow.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasJob()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasJob()}
   */
  @Test
  @DisplayName("Test hasJob()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasJob()"})
  void testHasJob() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasJob());
  }

  /**
   * Test {@link ObjectDefinition#getJob()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getJob()}
   */
  @Test
  @DisplayName("Test getJob()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition ObjectDefinition.getJob()"})
  void testGetJob() {
    // Arrange and Act
    JobDefinition actualJob = ObjectDefinition.getDefaultInstance().getJob();

    // Assert
    assertEquals("", actualJob.getInitializationErrorString());
    assertEquals(0, actualJob.getJobTypeValue());
    assertEquals(0, actualJob.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualJob.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualJob.getJobType());
    assertFalse(actualJob.hasExportData());
    assertFalse(actualJob.hasImportData());
    assertFalse(actualJob.hasImportModel());
    assertFalse(actualJob.hasJobGroup());
    assertFalse(actualJob.hasResultId());
    assertFalse(actualJob.hasRunFlow());
    assertFalse(actualJob.hasRunModel());
    assertTrue(actualJob.findInitializationErrors().isEmpty());
    assertTrue(actualJob.getAllFields().isEmpty());
    assertTrue(actualJob.isInitialized());
    assertSame(actualJob, actualJob.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasFile()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasFile()}
   */
  @Test
  @DisplayName("Test hasFile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasFile()"})
  void testHasFile() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasFile());
  }

  /**
   * Test {@link ObjectDefinition#getFile()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getFile()}
   */
  @Test
  @DisplayName("Test getFile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FileDefinition ObjectDefinition.getFile()"})
  void testGetFile() {
    // Arrange and Act
    FileDefinition actualFile = ObjectDefinition.getDefaultInstance().getFile();

    // Assert
    assertEquals("", actualFile.getInitializationErrorString());
    assertEquals("", actualFile.getDataItem());
    assertEquals("", actualFile.getExtension());
    assertEquals("", actualFile.getMimeType());
    assertEquals("", actualFile.getName());
    assertEquals(0, actualFile.getSerializedSize());
    assertEquals(0L, actualFile.getSize());
    assertFalse(actualFile.hasStorageId());
    assertTrue(actualFile.findInitializationErrors().isEmpty());
    assertTrue(actualFile.getAllFields().isEmpty());
    assertTrue(actualFile.isInitialized());
    assertSame(actualFile, actualFile.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasCustom()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasCustom()}
   */
  @Test
  @DisplayName("Test hasCustom()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasCustom()"})
  void testHasCustom() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasCustom());
  }

  /**
   * Test {@link ObjectDefinition#getCustom()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getCustom()}
   */
  @Test
  @DisplayName("Test getCustom()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomDefinition ObjectDefinition.getCustom()"})
  void testGetCustom() {
    // Arrange and Act
    CustomDefinition actualCustom = ObjectDefinition.getDefaultInstance().getCustom();

    // Assert
    assertEquals("", actualCustom.getInitializationErrorString());
    assertEquals("", actualCustom.getCustomSchemaType());
    assertEquals(0, actualCustom.getCustomSchemaVersion());
    assertEquals(0, actualCustom.getSerializedSize());
    assertTrue(actualCustom.findInitializationErrors().isEmpty());
    assertTrue(actualCustom.getAllFields().isEmpty());
    assertTrue(actualCustom.isInitialized());
    assertSame(actualCustom, actualCustom.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasStorage()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasStorage()}
   */
  @Test
  @DisplayName("Test hasStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasStorage()"})
  void testHasStorage() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasStorage());
  }

  /**
   * Test {@link ObjectDefinition#getStorage()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getStorage()}
   */
  @Test
  @DisplayName("Test getStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageDefinition ObjectDefinition.getStorage()"})
  void testGetStorage() {
    // Arrange and Act
    StorageDefinition actualStorage = ObjectDefinition.getDefaultInstance().getStorage();

    // Assert
    assertEquals("", actualStorage.getInitializationErrorString());
    assertEquals(0, actualStorage.getDataItemsCount());
    assertEquals(0, actualStorage.getSerializedSize());
    assertEquals(0, actualStorage.getStorageOptionsCount());
    assertTrue(actualStorage.findInitializationErrors().isEmpty());
    assertTrue(actualStorage.getAllFields().isEmpty());
    assertTrue(actualStorage.getDataItems().isEmpty());
    assertTrue(actualStorage.getDataItemsMap().isEmpty());
    assertTrue(actualStorage.getStorageOptions().isEmpty());
    assertTrue(actualStorage.getStorageOptionsMap().isEmpty());
    assertTrue(actualStorage.isInitialized());
    assertSame(actualStorage, actualStorage.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasSchema()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasSchema()}
   */
  @Test
  @DisplayName("Test hasSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasSchema()"})
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasSchema());
  }

  /**
   * Test {@link ObjectDefinition#getSchema()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ObjectDefinition.getSchema()"})
  void testGetSchema() {
    // Arrange and Act
    SchemaDefinition actualSchema = ObjectDefinition.getDefaultInstance().getSchema();

    // Assert
    assertEquals("", actualSchema.getInitializationErrorString());
    assertEquals(0, actualSchema.getPartTypeValue());
    assertEquals(0, actualSchema.getSchemaTypeValue());
    assertEquals(0, actualSchema.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualSchema.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualSchema.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualSchema.getSchemaType());
    assertFalse(actualSchema.hasStruct());
    assertFalse(actualSchema.hasTable());
    assertTrue(actualSchema.findInitializationErrors().isEmpty());
    assertTrue(actualSchema.getAllFields().isEmpty());
    assertTrue(actualSchema.isInitialized());
    assertSame(actualSchema, actualSchema.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#hasResult()}.
   * <p>
   * Method under test: {@link ObjectDefinition#hasResult()}
   */
  @Test
  @DisplayName("Test hasResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.hasResult()"})
  void testHasResult() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().hasResult());
  }

  /**
   * Test {@link ObjectDefinition#getResult()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getResult()}
   */
  @Test
  @DisplayName("Test getResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResultDefinition ObjectDefinition.getResult()"})
  void testGetResult() {
    // Arrange and Act
    ResultDefinition actualResult = ObjectDefinition.getDefaultInstance().getResult();

    // Assert
    assertEquals("", actualResult.getInitializationErrorString());
    assertEquals("", actualResult.getStatusMessage());
    assertEquals(0, actualResult.getSerializedSize());
    assertEquals(0, actualResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualResult.getStatusCode());
    assertFalse(actualResult.hasJobId());
    assertFalse(actualResult.hasLogFileId());
    assertTrue(actualResult.findInitializationErrors().isEmpty());
    assertTrue(actualResult.getAllFields().isEmpty());
    assertTrue(actualResult.isInitialized());
    assertSame(actualResult, actualResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#getObjectPropsCount()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectPropsCount()}
   */
  @Test
  @DisplayName("Test getObjectPropsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ObjectDefinition.getObjectPropsCount()"})
  void testGetObjectPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectDefinition.getDefaultInstance().getObjectPropsCount());
  }

  /**
   * Test {@link ObjectDefinition#containsObjectProps(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#containsObjectProps(String)}
   */
  @Test
  @DisplayName("Test containsObjectProps(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.containsObjectProps(String)"})
  void testContainsObjectProps_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ObjectDefinition.getDefaultInstance().containsObjectProps("Key"));
  }

  /**
   * Test {@link ObjectDefinition#getObjectProps()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectProps()}
   */
  @Test
  @DisplayName("Test getObjectProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ObjectDefinition.getObjectProps()"})
  void testGetObjectProps() {
    // Arrange, Act and Assert
    assertTrue(ObjectDefinition.getDefaultInstance().getObjectProps().isEmpty());
  }

  /**
   * Test {@link ObjectDefinition#getObjectPropsMap()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectPropsMap()}
   */
  @Test
  @DisplayName("Test getObjectPropsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ObjectDefinition.getObjectPropsMap()"})
  void testGetObjectPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ObjectDefinition.getDefaultInstance().getObjectPropsMap().isEmpty());
  }

  /**
   * Test {@link ObjectDefinition#getObjectPropsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectPropsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getObjectPropsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ObjectDefinition.getObjectPropsOrDefault(String, Value)"})
  void testGetObjectPropsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ObjectDefinition defaultInstance = ObjectDefinition.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getObjectPropsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ObjectDefinition#getObjectPropsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#getObjectPropsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getObjectPropsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ObjectDefinition.getObjectPropsOrThrow(String)"})
  void testGetObjectPropsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ObjectDefinition.getDefaultInstance().getObjectPropsOrThrow("Key"));
  }

  /**
   * Test {@link ObjectDefinition#isInitialized()}.
   * <p>
   * Method under test: {@link ObjectDefinition#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ObjectDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ObjectDefinition#getSerializedSize()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ObjectDefinition.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ObjectDefinition#equals(Object)}, and {@link ObjectDefinition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectDefinition#equals(Object)}
   *   <li>{@link ObjectDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.equals(Object)", "int ObjectDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ObjectDefinition defaultInstance = ObjectDefinition.getDefaultInstance();
    ObjectDefinition defaultInstance2 = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ObjectDefinition#equals(Object)}, and {@link ObjectDefinition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectDefinition#equals(Object)}
   *   <li>{@link ObjectDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.equals(Object)", "int ObjectDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectDefinition defaultInstance = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ObjectDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.equals(Object)", "int ObjectDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ObjectDefinition.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ObjectDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.equals(Object)", "int ObjectDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ObjectDefinition.getDefaultInstance(), null);
  }

  /**
   * Test {@link ObjectDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectDefinition.equals(Object)", "int ObjectDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ObjectDefinition.getDefaultInstance(), "Different type to ObjectDefinition");
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getObjectPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasCustom());
    assertFalse(actualParseFromResult.hasData());
    assertFalse(actualParseFromResult.hasFile());
    assertFalse(actualParseFromResult.hasFlow());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasModel());
    assertFalse(actualParseFromResult.hasResult());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getObjectPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasCustom());
    assertFalse(actualParseFromResult.hasData());
    assertFalse(actualParseFromResult.hasFile());
    assertFalse(actualParseFromResult.hasFlow());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasModel());
    assertFalse(actualParseFromResult.hasResult());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getObjectPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasCustom());
    assertFalse(actualParseFromResult.hasData());
    assertFalse(actualParseFromResult.hasFile());
    assertFalse(actualParseFromResult.hasFlow());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasModel());
    assertFalse(actualParseFromResult.hasResult());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getObjectPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasCustom());
    assertFalse(actualParseFromResult.hasData());
    assertFalse(actualParseFromResult.hasFile());
    assertFalse(actualParseFromResult.hasFlow());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasModel());
    assertFalse(actualParseFromResult.hasResult());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getObjectPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasCustom());
    assertFalse(actualParseFromResult.hasData());
    assertFalse(actualParseFromResult.hasFile());
    assertFalse(actualParseFromResult.hasFlow());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasModel());
    assertFalse(actualParseFromResult.hasResult());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ObjectDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ObjectDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ObjectDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ObjectDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ObjectDefinition actualParseFromResult = ObjectDefinition.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ObjectDefinition actualParseDelimitedFromResult = ObjectDefinition.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getObjectPropsCount());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseDelimitedFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertFalse(actualParseDelimitedFromResult.hasCustom());
    assertFalse(actualParseDelimitedFromResult.hasData());
    assertFalse(actualParseDelimitedFromResult.hasFile());
    assertFalse(actualParseDelimitedFromResult.hasFlow());
    assertFalse(actualParseDelimitedFromResult.hasJob());
    assertFalse(actualParseDelimitedFromResult.hasModel());
    assertFalse(actualParseDelimitedFromResult.hasResult());
    assertFalse(actualParseDelimitedFromResult.hasSchema());
    assertFalse(actualParseDelimitedFromResult.hasStorage());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ObjectDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ObjectDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ObjectDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ObjectDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ObjectDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ObjectDefinition actualParseDelimitedFromResult = ObjectDefinition.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getObjectPropsCount());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualParseDelimitedFromResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertFalse(actualParseDelimitedFromResult.hasCustom());
    assertFalse(actualParseDelimitedFromResult.hasData());
    assertFalse(actualParseDelimitedFromResult.hasFile());
    assertFalse(actualParseDelimitedFromResult.hasFlow());
    assertFalse(actualParseDelimitedFromResult.hasJob());
    assertFalse(actualParseDelimitedFromResult.hasModel());
    assertFalse(actualParseDelimitedFromResult.hasResult());
    assertFalse(actualParseDelimitedFromResult.hasSchema());
    assertFalse(actualParseDelimitedFromResult.hasStorage());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getObjectProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getObjectPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ObjectDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ObjectDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ObjectDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ObjectDefinition#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ObjectDefinition#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition ObjectDefinition.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ObjectDefinition defaultInstance = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

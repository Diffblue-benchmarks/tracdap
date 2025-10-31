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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RunFlowJobDiffblueTest {
  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunFlowJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when five; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFive_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when six; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenSix_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(6);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunFlowJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#hasFlow()}.
   * <p>
   * Method under test: {@link RunFlowJob#hasFlow()}
   */
  @Test
  @DisplayName("Test hasFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.hasFlow()"})
  void testHasFlow() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().hasFlow());
  }

  /**
   * Test {@link RunFlowJob#getFlow()}.
   * <p>
   * Method under test: {@link RunFlowJob#getFlow()}
   */
  @Test
  @DisplayName("Test getFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getFlow()"})
  void testGetFlow() {
    // Arrange and Act
    TagSelector actualFlow = RunFlowJob.getDefaultInstance().getFlow();

    // Assert
    assertEquals("", actualFlow.getInitializationErrorString());
    assertEquals("", actualFlow.getObjectId());
    assertEquals(0, actualFlow.getObjectTypeValue());
    assertEquals(0, actualFlow.getObjectVersion());
    assertEquals(0, actualFlow.getSerializedSize());
    assertEquals(0, actualFlow.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualFlow.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualFlow.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualFlow.getTagCriteriaCase());
    assertFalse(actualFlow.getLatestObject());
    assertFalse(actualFlow.getLatestTag());
    assertFalse(actualFlow.hasLatestObject());
    assertFalse(actualFlow.hasLatestTag());
    assertFalse(actualFlow.hasObjectAsOf());
    assertFalse(actualFlow.hasObjectVersion());
    assertFalse(actualFlow.hasTagAsOf());
    assertFalse(actualFlow.hasTagVersion());
    assertTrue(actualFlow.findInitializationErrors().isEmpty());
    assertTrue(actualFlow.getAllFields().isEmpty());
    assertTrue(actualFlow.isInitialized());
    assertSame(actualFlow, actualFlow.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunFlowJob#getParametersCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link RunFlowJob#containsParameters(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#containsParameters(String)}
   */
  @Test
  @DisplayName("Test containsParameters(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.containsParameters(String)"})
  void testContainsParameters_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Test {@link RunFlowJob#getParameters()}.
   * <p>
   * Method under test: {@link RunFlowJob#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getParameters()"})
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getParametersMap()}.
   * <p>
   * Method under test: {@link RunFlowJob#getParametersMap()}
   */
  @Test
  @DisplayName("Test getParametersMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getParametersMap()"})
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getParametersOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getParametersOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getParametersOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value RunFlowJob.getParametersOrDefault(String, Value)"})
  void testGetParametersOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunFlowJob#getParametersOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getParametersOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParametersOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value RunFlowJob.getParametersOrThrow(String)"})
  void testGetParametersOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Test {@link RunFlowJob#getInputsCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link RunFlowJob#containsInputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#containsInputs(String)}
   */
  @Test
  @DisplayName("Test containsInputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.containsInputs(String)"})
  void testContainsInputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Test {@link RunFlowJob#getInputs()}.
   * <p>
   * Method under test: {@link RunFlowJob#getInputs()}
   */
  @Test
  @DisplayName("Test getInputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getInputs()"})
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getInputsMap()}.
   * <p>
   * Method under test: {@link RunFlowJob#getInputsMap()}
   */
  @Test
  @DisplayName("Test getInputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getInputsMap()"})
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getInputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getInputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getInputsOrDefault(String, TagSelector)"})
  void testGetInputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunFlowJob#getInputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getInputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getInputsOrThrow(String)"})
  void testGetInputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Test {@link RunFlowJob#getOutputsCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link RunFlowJob#containsOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#containsOutputs(String)}
   */
  @Test
  @DisplayName("Test containsOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.containsOutputs(String)"})
  void testContainsOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Test {@link RunFlowJob#getOutputs()}.
   * <p>
   * Method under test: {@link RunFlowJob#getOutputs()}
   */
  @Test
  @DisplayName("Test getOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getOutputs()"})
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getOutputsMap()}.
   * <p>
   * Method under test: {@link RunFlowJob#getOutputsMap()}
   */
  @Test
  @DisplayName("Test getOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getOutputsMap()"})
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getOutputsOrDefault(String, TagSelector)"})
  void testGetOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunFlowJob#getOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getOutputsOrThrow(String)"})
  void testGetOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Test {@link RunFlowJob#getPriorOutputsCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getPriorOutputsCount()}
   */
  @Test
  @DisplayName("Test getPriorOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getPriorOutputsCount()"})
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Test {@link RunFlowJob#containsPriorOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#containsPriorOutputs(String)}
   */
  @Test
  @DisplayName("Test containsPriorOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.containsPriorOutputs(String)"})
  void testContainsPriorOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Test {@link RunFlowJob#getPriorOutputs()}.
   * <p>
   * Method under test: {@link RunFlowJob#getPriorOutputs()}
   */
  @Test
  @DisplayName("Test getPriorOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getPriorOutputs()"})
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getPriorOutputsMap()}.
   * <p>
   * Method under test: {@link RunFlowJob#getPriorOutputsMap()}
   */
  @Test
  @DisplayName("Test getPriorOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getPriorOutputsMap()"})
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getPriorOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getPriorOutputsOrDefault(String, TagSelector)"})
  void testGetPriorOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunFlowJob#getPriorOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getPriorOutputsOrThrow(String)"})
  void testGetPriorOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Test {@link RunFlowJob#getModelsCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getModelsCount()}
   */
  @Test
  @DisplayName("Test getModelsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getModelsCount()"})
  void testGetModelsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getModelsCount());
  }

  /**
   * Test {@link RunFlowJob#containsModels(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#containsModels(String)}
   */
  @Test
  @DisplayName("Test containsModels(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.containsModels(String)"})
  void testContainsModels_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsModels("Key"));
  }

  /**
   * Test {@link RunFlowJob#getModels()}.
   * <p>
   * Method under test: {@link RunFlowJob#getModels()}
   */
  @Test
  @DisplayName("Test getModels()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getModels()"})
  void testGetModels() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getModels().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getModelsMap()}.
   * <p>
   * Method under test: {@link RunFlowJob#getModelsMap()}
   */
  @Test
  @DisplayName("Test getModelsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunFlowJob.getModelsMap()"})
  void testGetModelsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getModelsMap().isEmpty());
  }

  /**
   * Test {@link RunFlowJob#getModelsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getModelsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getModelsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getModelsOrDefault(String, TagSelector)"})
  void testGetModelsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getModelsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunFlowJob#getModelsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#getModelsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getModelsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunFlowJob.getModelsOrThrow(String)"})
  void testGetModelsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getModelsOrThrow("Key"));
  }

  /**
   * Test {@link RunFlowJob#getOutputAttrsCount()}.
   * <p>
   * Method under test: {@link RunFlowJob#getOutputAttrsCount()}
   */
  @Test
  @DisplayName("Test getOutputAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getOutputAttrsCount()"})
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Test {@link RunFlowJob#isInitialized()}.
   * <p>
   * Method under test: {@link RunFlowJob#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RunFlowJob#getSerializedSize()}.
   * <p>
   * Method under test: {@link RunFlowJob#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunFlowJob.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RunFlowJob#equals(Object)}, and {@link RunFlowJob#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RunFlowJob#equals(Object)}
   *   <li>{@link RunFlowJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.equals(Object)", "int RunFlowJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    RunFlowJob defaultInstance2 = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RunFlowJob#equals(Object)}, and {@link RunFlowJob#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RunFlowJob#equals(Object)}
   *   <li>{@link RunFlowJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.equals(Object)", "int RunFlowJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RunFlowJob#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.equals(Object)", "int RunFlowJob.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RunFlowJob#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.equals(Object)", "int RunFlowJob.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), null);
  }

  /**
   * Test {@link RunFlowJob#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunFlowJob.equals(Object)", "int RunFlowJob.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), "Different type to RunFlowJob");
  }

  /**
   * Test {@link RunFlowJob#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasFlow());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getModels().isEmpty());
    assertTrue(actualParseFromResult.getModelsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputs().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasFlow());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getModels().isEmpty());
    assertTrue(actualParseFromResult.getModelsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputs().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasFlow());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getModels().isEmpty());
    assertTrue(actualParseFromResult.getModelsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputs().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasFlow());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getModels().isEmpty());
    assertTrue(actualParseFromResult.getModelsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputs().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasFlow());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getModels().isEmpty());
    assertTrue(actualParseFromResult.getModelsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputs().isEmpty());
    assertTrue(actualParseFromResult.getPriorOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunFlowJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunFlowJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector flow = actualParseFromResult.getFlow();
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(flow, actualParseFromResult.getFlowOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunFlowJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Flow UnknownFields is UnknownFields.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'; then return Flow UnknownFields is UnknownFields")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull_thenReturnFlowUnknownFieldsIsUnknownFields() throws IOException {
    // Arrange and Act
    RunFlowJob actualParseFromResult = RunFlowJob.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector flow = actualParseFromResult.getFlow();
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(flow, actualParseFromResult.getFlowOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RunFlowJob actualParseDelimitedFromResult = RunFlowJob.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(5, descriptorForType.getNestedTypes().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType.getFields().size());
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagSelector flow = actualParseDelimitedFromResult.getFlow();
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(flow, actualParseDelimitedFromResult.getFlowOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunFlowJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RunFlowJob.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RunFlowJob actualParseDelimitedFromResult = RunFlowJob.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(5, descriptorForType.getNestedTypes().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType.getFields().size());
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagSelector flow = actualParseDelimitedFromResult.getFlow();
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(flow, actualParseDelimitedFromResult.getFlowOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunFlowJob#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RunFlowJob#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob RunFlowJob.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

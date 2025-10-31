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

class RunModelJobDiffblueTest {
  /**
   * Test {@link RunModelJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunModelJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunModelJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link RunModelJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when five; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunModelJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFive_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunModelJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunModelJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RunModelJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#hasModel()}.
   * <p>
   * Method under test: {@link RunModelJob#hasModel()}
   */
  @Test
  @DisplayName("Test hasModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.hasModel()"})
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().hasModel());
  }

  /**
   * Test {@link RunModelJob#getModel()}.
   * <p>
   * Method under test: {@link RunModelJob#getModel()}
   */
  @Test
  @DisplayName("Test getModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getModel()"})
  void testGetModel() {
    // Arrange and Act
    TagSelector actualModel = RunModelJob.getDefaultInstance().getModel();

    // Assert
    assertEquals("", actualModel.getInitializationErrorString());
    assertEquals("", actualModel.getObjectId());
    assertEquals(0, actualModel.getObjectTypeValue());
    assertEquals(0, actualModel.getObjectVersion());
    assertEquals(0, actualModel.getSerializedSize());
    assertEquals(0, actualModel.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualModel.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualModel.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualModel.getTagCriteriaCase());
    assertFalse(actualModel.getLatestObject());
    assertFalse(actualModel.getLatestTag());
    assertFalse(actualModel.hasLatestObject());
    assertFalse(actualModel.hasLatestTag());
    assertFalse(actualModel.hasObjectAsOf());
    assertFalse(actualModel.hasObjectVersion());
    assertFalse(actualModel.hasTagAsOf());
    assertFalse(actualModel.hasTagVersion());
    assertTrue(actualModel.findInitializationErrors().isEmpty());
    assertTrue(actualModel.getAllFields().isEmpty());
    assertTrue(actualModel.isInitialized());
    assertSame(actualModel, actualModel.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunModelJob#getParametersCount()}.
   * <p>
   * Method under test: {@link RunModelJob#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link RunModelJob#containsParameters(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#containsParameters(String)}
   */
  @Test
  @DisplayName("Test containsParameters(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.containsParameters(String)"})
  void testContainsParameters_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Test {@link RunModelJob#getParameters()}.
   * <p>
   * Method under test: {@link RunModelJob#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getParameters()"})
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getParametersMap()}.
   * <p>
   * Method under test: {@link RunModelJob#getParametersMap()}
   */
  @Test
  @DisplayName("Test getParametersMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getParametersMap()"})
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getParametersOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getParametersOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getParametersOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value RunModelJob.getParametersOrDefault(String, Value)"})
  void testGetParametersOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunModelJob#getParametersOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getParametersOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParametersOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value RunModelJob.getParametersOrThrow(String)"})
  void testGetParametersOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Test {@link RunModelJob#getInputsCount()}.
   * <p>
   * Method under test: {@link RunModelJob#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link RunModelJob#containsInputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#containsInputs(String)}
   */
  @Test
  @DisplayName("Test containsInputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.containsInputs(String)"})
  void testContainsInputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Test {@link RunModelJob#getInputs()}.
   * <p>
   * Method under test: {@link RunModelJob#getInputs()}
   */
  @Test
  @DisplayName("Test getInputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getInputs()"})
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getInputsMap()}.
   * <p>
   * Method under test: {@link RunModelJob#getInputsMap()}
   */
  @Test
  @DisplayName("Test getInputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getInputsMap()"})
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getInputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getInputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getInputsOrDefault(String, TagSelector)"})
  void testGetInputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunModelJob#getInputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getInputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getInputsOrThrow(String)"})
  void testGetInputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Test {@link RunModelJob#getOutputsCount()}.
   * <p>
   * Method under test: {@link RunModelJob#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link RunModelJob#containsOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#containsOutputs(String)}
   */
  @Test
  @DisplayName("Test containsOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.containsOutputs(String)"})
  void testContainsOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Test {@link RunModelJob#getOutputs()}.
   * <p>
   * Method under test: {@link RunModelJob#getOutputs()}
   */
  @Test
  @DisplayName("Test getOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getOutputs()"})
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getOutputsMap()}.
   * <p>
   * Method under test: {@link RunModelJob#getOutputsMap()}
   */
  @Test
  @DisplayName("Test getOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getOutputsMap()"})
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getOutputsOrDefault(String, TagSelector)"})
  void testGetOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunModelJob#getOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getOutputsOrThrow(String)"})
  void testGetOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Test {@link RunModelJob#getPriorOutputsCount()}.
   * <p>
   * Method under test: {@link RunModelJob#getPriorOutputsCount()}
   */
  @Test
  @DisplayName("Test getPriorOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getPriorOutputsCount()"})
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Test {@link RunModelJob#containsPriorOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#containsPriorOutputs(String)}
   */
  @Test
  @DisplayName("Test containsPriorOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.containsPriorOutputs(String)"})
  void testContainsPriorOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Test {@link RunModelJob#getPriorOutputs()}.
   * <p>
   * Method under test: {@link RunModelJob#getPriorOutputs()}
   */
  @Test
  @DisplayName("Test getPriorOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getPriorOutputs()"})
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getPriorOutputsMap()}.
   * <p>
   * Method under test: {@link RunModelJob#getPriorOutputsMap()}
   */
  @Test
  @DisplayName("Test getPriorOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RunModelJob.getPriorOutputsMap()"})
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Test {@link RunModelJob#getPriorOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getPriorOutputsOrDefault(String, TagSelector)"})
  void testGetPriorOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RunModelJob#getPriorOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RunModelJob.getPriorOutputsOrThrow(String)"})
  void testGetPriorOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Test {@link RunModelJob#getOutputAttrsCount()}.
   * <p>
   * Method under test: {@link RunModelJob#getOutputAttrsCount()}
   */
  @Test
  @DisplayName("Test getOutputAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getOutputAttrsCount()"})
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Test {@link RunModelJob#isInitialized()}.
   * <p>
   * Method under test: {@link RunModelJob#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RunModelJob#getSerializedSize()}.
   * <p>
   * Method under test: {@link RunModelJob#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RunModelJob.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RunModelJob#equals(Object)}, and {@link RunModelJob#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RunModelJob#equals(Object)}
   *   <li>{@link RunModelJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.equals(Object)", "int RunModelJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    RunModelJob defaultInstance2 = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RunModelJob#equals(Object)}, and {@link RunModelJob#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RunModelJob#equals(Object)}
   *   <li>{@link RunModelJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.equals(Object)", "int RunModelJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RunModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.equals(Object)", "int RunModelJob.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RunModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.equals(Object)", "int RunModelJob.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), null);
  }

  /**
   * Test {@link RunModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RunModelJob.equals(Object)", "int RunModelJob.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), "Different type to RunModelJob");
  }

  /**
   * Test {@link RunModelJob#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
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
   * Test {@link RunModelJob#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
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
   * Test {@link RunModelJob#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
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
   * Test {@link RunModelJob#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
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
   * Test {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
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
   * Test {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RunModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector model = actualParseFromResult.getModel();
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(model, actualParseFromResult.getModelOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RunModelJob actualParseFromResult = RunModelJob.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector model = actualParseFromResult.getModel();
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(model, actualParseFromResult.getModelOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RunModelJob actualParseDelimitedFromResult = RunModelJob.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getNestedTypes().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagSelector model = actualParseDelimitedFromResult.getModel();
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(model, actualParseDelimitedFromResult.getModelOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunModelJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RunModelJob.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RunModelJob actualParseDelimitedFromResult = RunModelJob.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getNestedTypes().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagSelector model = actualParseDelimitedFromResult.getModel();
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(model, actualParseDelimitedFromResult.getModelOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RunModelJob#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RunModelJob#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob RunModelJob.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.ProtocolStringList;
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

class ExportDataJobDiffblueTest {
  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExportDataJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when five; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFive_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ExportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ExportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when seven; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenSeven_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ExportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(7);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ExportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ExportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ExportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#hasModel()}.
   * <p>
   * Method under test: {@link ExportDataJob#hasModel()}
   */
  @Test
  @DisplayName("Test hasModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.hasModel()"})
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().hasModel());
  }

  /**
   * Test {@link ExportDataJob#getModel()}.
   * <p>
   * Method under test: {@link ExportDataJob#getModel()}
   */
  @Test
  @DisplayName("Test getModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getModel()"})
  void testGetModel() {
    // Arrange and Act
    TagSelector actualModel = ExportDataJob.getDefaultInstance().getModel();

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
   * Test {@link ExportDataJob#getParametersCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link ExportDataJob#containsParameters(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#containsParameters(String)}
   */
  @Test
  @DisplayName("Test containsParameters(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.containsParameters(String)"})
  void testContainsParameters_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Test {@link ExportDataJob#getParameters()}.
   * <p>
   * Method under test: {@link ExportDataJob#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getParameters()"})
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getParametersMap()}.
   * <p>
   * Method under test: {@link ExportDataJob#getParametersMap()}
   */
  @Test
  @DisplayName("Test getParametersMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getParametersMap()"})
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getParametersOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getParametersOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getParametersOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ExportDataJob.getParametersOrDefault(String, Value)"})
  void testGetParametersOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ExportDataJob#getParametersOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getParametersOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParametersOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ExportDataJob.getParametersOrThrow(String)"})
  void testGetParametersOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ExportDataJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Test {@link ExportDataJob#getInputsCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link ExportDataJob#containsInputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#containsInputs(String)}
   */
  @Test
  @DisplayName("Test containsInputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.containsInputs(String)"})
  void testContainsInputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Test {@link ExportDataJob#getInputs()}.
   * <p>
   * Method under test: {@link ExportDataJob#getInputs()}
   */
  @Test
  @DisplayName("Test getInputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getInputs()"})
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getInputsMap()}.
   * <p>
   * Method under test: {@link ExportDataJob#getInputsMap()}
   */
  @Test
  @DisplayName("Test getInputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getInputsMap()"})
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getInputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getInputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getInputsOrDefault(String, TagSelector)"})
  void testGetInputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ExportDataJob#getInputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getInputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getInputsOrThrow(String)"})
  void testGetInputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ExportDataJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Test {@link ExportDataJob#getOutputsCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link ExportDataJob#containsOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#containsOutputs(String)}
   */
  @Test
  @DisplayName("Test containsOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.containsOutputs(String)"})
  void testContainsOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Test {@link ExportDataJob#getOutputs()}.
   * <p>
   * Method under test: {@link ExportDataJob#getOutputs()}
   */
  @Test
  @DisplayName("Test getOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getOutputs()"})
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getOutputsMap()}.
   * <p>
   * Method under test: {@link ExportDataJob#getOutputsMap()}
   */
  @Test
  @DisplayName("Test getOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getOutputsMap()"})
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getOutputsOrDefault(String, TagSelector)"})
  void testGetOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ExportDataJob#getOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getOutputsOrThrow(String)"})
  void testGetOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ExportDataJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Test {@link ExportDataJob#getPriorOutputsCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getPriorOutputsCount()}
   */
  @Test
  @DisplayName("Test getPriorOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getPriorOutputsCount()"})
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Test {@link ExportDataJob#containsPriorOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#containsPriorOutputs(String)}
   */
  @Test
  @DisplayName("Test containsPriorOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.containsPriorOutputs(String)"})
  void testContainsPriorOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Test {@link ExportDataJob#getPriorOutputs()}.
   * <p>
   * Method under test: {@link ExportDataJob#getPriorOutputs()}
   */
  @Test
  @DisplayName("Test getPriorOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getPriorOutputs()"})
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getPriorOutputsMap()}.
   * <p>
   * Method under test: {@link ExportDataJob#getPriorOutputsMap()}
   */
  @Test
  @DisplayName("Test getPriorOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getPriorOutputsMap()"})
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getPriorOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getPriorOutputsOrDefault(String, TagSelector)"})
  void testGetPriorOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ExportDataJob#getPriorOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getPriorOutputsOrThrow(String)"})
  void testGetPriorOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ExportDataJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Test {@link ExportDataJob#getStorageAccessList()}.
   * <p>
   * Method under test: {@link ExportDataJob#getStorageAccessList()}
   */
  @Test
  @DisplayName("Test getStorageAccessList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList ExportDataJob.getStorageAccessList()"})
  void testGetStorageAccessList() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();

    // Act
    ProtocolStringList actualStorageAccessList = defaultInstance.getStorageAccessList();

    // Assert
    assertTrue(actualStorageAccessList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualStorageAccessList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, actualStorageAccessList);
  }

  /**
   * Test {@link ExportDataJob#getStorageAccessCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getStorageAccessCount()}
   */
  @Test
  @DisplayName("Test getStorageAccessCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getStorageAccessCount()"})
  void testGetStorageAccessCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getStorageAccessCount());
  }

  /**
   * Test {@link ExportDataJob#getExportsCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getExportsCount()}
   */
  @Test
  @DisplayName("Test getExportsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getExportsCount()"})
  void testGetExportsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getExportsCount());
  }

  /**
   * Test {@link ExportDataJob#containsExports(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#containsExports(String)}
   */
  @Test
  @DisplayName("Test containsExports(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.containsExports(String)"})
  void testContainsExports_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExportDataJob.getDefaultInstance().containsExports("Key"));
  }

  /**
   * Test {@link ExportDataJob#getExports()}.
   * <p>
   * Method under test: {@link ExportDataJob#getExports()}
   */
  @Test
  @DisplayName("Test getExports()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getExports()"})
  void testGetExports() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getExports().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getExportsMap()}.
   * <p>
   * Method under test: {@link ExportDataJob#getExportsMap()}
   */
  @Test
  @DisplayName("Test getExportsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ExportDataJob.getExportsMap()"})
  void testGetExportsMap() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().getExportsMap().isEmpty());
  }

  /**
   * Test {@link ExportDataJob#getExportsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getExportsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getExportsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getExportsOrDefault(String, TagSelector)"})
  void testGetExportsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getExportsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ExportDataJob#getExportsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#getExportsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getExportsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ExportDataJob.getExportsOrThrow(String)"})
  void testGetExportsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ExportDataJob.getDefaultInstance().getExportsOrThrow("Key"));
  }

  /**
   * Test {@link ExportDataJob#getOutputAttrsCount()}.
   * <p>
   * Method under test: {@link ExportDataJob#getOutputAttrsCount()}
   */
  @Test
  @DisplayName("Test getOutputAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getOutputAttrsCount()"})
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Test {@link ExportDataJob#isInitialized()}.
   * <p>
   * Method under test: {@link ExportDataJob#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExportDataJob.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ExportDataJob#getSerializedSize()}.
   * <p>
   * Method under test: {@link ExportDataJob#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExportDataJob.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExportDataJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ExportDataJob#equals(Object)}, and {@link ExportDataJob#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExportDataJob#equals(Object)}
   *   <li>{@link ExportDataJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.equals(Object)", "int ExportDataJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();
    ExportDataJob defaultInstance2 = ExportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ExportDataJob#equals(Object)}, and {@link ExportDataJob#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExportDataJob#equals(Object)}
   *   <li>{@link ExportDataJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.equals(Object)", "int ExportDataJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ExportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.equals(Object)", "int ExportDataJob.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExportDataJob.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ExportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.equals(Object)", "int ExportDataJob.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExportDataJob.getDefaultInstance(), null);
  }

  /**
   * Test {@link ExportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExportDataJob.equals(Object)", "int ExportDataJob.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExportDataJob.getDefaultInstance(), "Different type to ExportDataJob");
  }

  /**
   * Test {@link ExportDataJob#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getExportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getExports().isEmpty());
    assertTrue(actualParseFromResult.getExportsMap().isEmpty());
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
   * Test {@link ExportDataJob#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getExportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getExports().isEmpty());
    assertTrue(actualParseFromResult.getExportsMap().isEmpty());
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
   * Test {@link ExportDataJob#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getExportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getExports().isEmpty());
    assertTrue(actualParseFromResult.getExportsMap().isEmpty());
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
   * Test {@link ExportDataJob#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getExportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getExports().isEmpty());
    assertTrue(actualParseFromResult.getExportsMap().isEmpty());
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
   * Test {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getExportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualParseFromResult.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getExports().isEmpty());
    assertTrue(actualParseFromResult.getExportsMap().isEmpty());
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
   * Test {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ExportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ExportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ExportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom(new ByteArrayInputStream(new byte[]{}));

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
   * Test {@link ExportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ExportDataJob actualParseFromResult = ExportDataJob.parseFrom((InputStream) null);

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
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExportDataJob actualParseDelimitedFromResult = ExportDataJob.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(5, descriptorForType.getNestedTypes().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(8, descriptorForType.getFields().size());
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
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        ExportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExportDataJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, ExportDataJob.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExportDataJob actualParseDelimitedFromResult = ExportDataJob.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(5, descriptorForType.getNestedTypes().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(8, descriptorForType.getFields().size());
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
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ExportDataJob#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ExportDataJob#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob ExportDataJob.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ExportDataJob defaultInstance = ExportDataJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

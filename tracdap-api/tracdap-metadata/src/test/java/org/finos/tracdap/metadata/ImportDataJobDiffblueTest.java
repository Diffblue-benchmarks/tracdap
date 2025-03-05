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

class ImportDataJobDiffblueTest {
  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ImportDataJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when five; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFive_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when seven; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenSeven_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(7);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ImportDataJob.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#hasModel()}.
   * <p>
   * Method under test: {@link ImportDataJob#hasModel()}
   */
  @Test
  @DisplayName("Test hasModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.hasModel()"})
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().hasModel());
  }

  /**
   * Test {@link ImportDataJob#getModel()}.
   * <p>
   * Method under test: {@link ImportDataJob#getModel()}
   */
  @Test
  @DisplayName("Test getModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getModel()"})
  void testGetModel() {
    // Arrange and Act
    TagSelector actualModel = ImportDataJob.getDefaultInstance().getModel();

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
   * Test {@link ImportDataJob#getParametersCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link ImportDataJob#containsParameters(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#containsParameters(String)}
   */
  @Test
  @DisplayName("Test containsParameters(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.containsParameters(String)"})
  void testContainsParameters_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Test {@link ImportDataJob#getParameters()}.
   * <p>
   * Method under test: {@link ImportDataJob#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getParameters()"})
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getParametersMap()}.
   * <p>
   * Method under test: {@link ImportDataJob#getParametersMap()}
   */
  @Test
  @DisplayName("Test getParametersMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getParametersMap()"})
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getParametersOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getParametersOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getParametersOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ImportDataJob.getParametersOrDefault(String, Value)"})
  void testGetParametersOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ImportDataJob#getParametersOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getParametersOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParametersOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ImportDataJob.getParametersOrThrow(String)"})
  void testGetParametersOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Test {@link ImportDataJob#getInputsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link ImportDataJob#containsInputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#containsInputs(String)}
   */
  @Test
  @DisplayName("Test containsInputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.containsInputs(String)"})
  void testContainsInputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Test {@link ImportDataJob#getInputs()}.
   * <p>
   * Method under test: {@link ImportDataJob#getInputs()}
   */
  @Test
  @DisplayName("Test getInputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getInputs()"})
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getInputsMap()}.
   * <p>
   * Method under test: {@link ImportDataJob#getInputsMap()}
   */
  @Test
  @DisplayName("Test getInputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getInputsMap()"})
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getInputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getInputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getInputsOrDefault(String, TagSelector)"})
  void testGetInputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ImportDataJob#getInputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getInputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getInputsOrThrow(String)"})
  void testGetInputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Test {@link ImportDataJob#getOutputsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link ImportDataJob#containsOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#containsOutputs(String)}
   */
  @Test
  @DisplayName("Test containsOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.containsOutputs(String)"})
  void testContainsOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Test {@link ImportDataJob#getOutputs()}.
   * <p>
   * Method under test: {@link ImportDataJob#getOutputs()}
   */
  @Test
  @DisplayName("Test getOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getOutputs()"})
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getOutputsMap()}.
   * <p>
   * Method under test: {@link ImportDataJob#getOutputsMap()}
   */
  @Test
  @DisplayName("Test getOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getOutputsMap()"})
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getOutputsOrDefault(String, TagSelector)"})
  void testGetOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ImportDataJob#getOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getOutputsOrThrow(String)"})
  void testGetOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Test {@link ImportDataJob#getPriorOutputsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getPriorOutputsCount()}
   */
  @Test
  @DisplayName("Test getPriorOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getPriorOutputsCount()"})
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Test {@link ImportDataJob#containsPriorOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#containsPriorOutputs(String)}
   */
  @Test
  @DisplayName("Test containsPriorOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.containsPriorOutputs(String)"})
  void testContainsPriorOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Test {@link ImportDataJob#getPriorOutputs()}.
   * <p>
   * Method under test: {@link ImportDataJob#getPriorOutputs()}
   */
  @Test
  @DisplayName("Test getPriorOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getPriorOutputs()"})
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getPriorOutputsMap()}.
   * <p>
   * Method under test: {@link ImportDataJob#getPriorOutputsMap()}
   */
  @Test
  @DisplayName("Test getPriorOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getPriorOutputsMap()"})
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getPriorOutputsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getPriorOutputsOrDefault(String, TagSelector)"})
  void testGetPriorOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ImportDataJob#getPriorOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPriorOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getPriorOutputsOrThrow(String)"})
  void testGetPriorOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ImportDataJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Test {@link ImportDataJob#getStorageAccessList()}.
   * <p>
   * Method under test: {@link ImportDataJob#getStorageAccessList()}
   */
  @Test
  @DisplayName("Test getStorageAccessList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList ImportDataJob.getStorageAccessList()"})
  void testGetStorageAccessList() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act
    ProtocolStringList actualStorageAccessList = defaultInstance.getStorageAccessList();

    // Assert
    assertTrue(actualStorageAccessList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualStorageAccessList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, actualStorageAccessList);
  }

  /**
   * Test {@link ImportDataJob#getStorageAccessCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getStorageAccessCount()}
   */
  @Test
  @DisplayName("Test getStorageAccessCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getStorageAccessCount()"})
  void testGetStorageAccessCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getStorageAccessCount());
  }

  /**
   * Test {@link ImportDataJob#getImportsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getImportsCount()}
   */
  @Test
  @DisplayName("Test getImportsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getImportsCount()"})
  void testGetImportsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getImportsCount());
  }

  /**
   * Test {@link ImportDataJob#containsImports(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#containsImports(String)}
   */
  @Test
  @DisplayName("Test containsImports(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.containsImports(String)"})
  void testContainsImports_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsImports("Key"));
  }

  /**
   * Test {@link ImportDataJob#getImports()}.
   * <p>
   * Method under test: {@link ImportDataJob#getImports()}
   */
  @Test
  @DisplayName("Test getImports()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getImports()"})
  void testGetImports() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getImports().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getImportsMap()}.
   * <p>
   * Method under test: {@link ImportDataJob#getImportsMap()}
   */
  @Test
  @DisplayName("Test getImportsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ImportDataJob.getImportsMap()"})
  void testGetImportsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getImportsMap().isEmpty());
  }

  /**
   * Test {@link ImportDataJob#getImportsOrDefault(String, TagSelector)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getImportsOrDefault(String, TagSelector)}
   */
  @Test
  @DisplayName("Test getImportsOrDefault(String, TagSelector); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getImportsOrDefault(String, TagSelector)"})
  void testGetImportsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getImportsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ImportDataJob#getImportsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#getImportsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getImportsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector ImportDataJob.getImportsOrThrow(String)"})
  void testGetImportsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getImportsOrThrow("Key"));
  }

  /**
   * Test {@link ImportDataJob#getOutputAttrsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getOutputAttrsCount()}
   */
  @Test
  @DisplayName("Test getOutputAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getOutputAttrsCount()"})
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Test {@link ImportDataJob#getImportAttrsCount()}.
   * <p>
   * Method under test: {@link ImportDataJob#getImportAttrsCount()}
   */
  @Test
  @DisplayName("Test getImportAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getImportAttrsCount()"})
  void testGetImportAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getImportAttrsCount());
  }

  /**
   * Test {@link ImportDataJob#isInitialized()}.
   * <p>
   * Method under test: {@link ImportDataJob#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ImportDataJob#getSerializedSize()}.
   * <p>
   * Method under test: {@link ImportDataJob#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportDataJob.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ImportDataJob#equals(Object)}, and {@link ImportDataJob#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportDataJob#equals(Object)}
   *   <li>{@link ImportDataJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.equals(Object)", "int ImportDataJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    ImportDataJob defaultInstance2 = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ImportDataJob#equals(Object)}, and {@link ImportDataJob#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportDataJob#equals(Object)}
   *   <li>{@link ImportDataJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.equals(Object)", "int ImportDataJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ImportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.equals(Object)", "int ImportDataJob.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ImportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.equals(Object)", "int ImportDataJob.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), null);
  }

  /**
   * Test {@link ImportDataJob#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportDataJob.equals(Object)", "int ImportDataJob.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), "Different type to ImportDataJob");
  }

  /**
   * Test {@link ImportDataJob#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getImportAttrsCount());
    assertEquals(0, actualParseFromResult.getImportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualParseFromResult.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getImports().isEmpty());
    assertTrue(actualParseFromResult.getImportsMap().isEmpty());
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
    assertSame(importAttrsList, actualParseFromResult.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportDataJob#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getImportAttrsCount());
    assertEquals(0, actualParseFromResult.getImportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualParseFromResult.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getImports().isEmpty());
    assertTrue(actualParseFromResult.getImportsMap().isEmpty());
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
    assertSame(importAttrsList, actualParseFromResult.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportDataJob#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getImportAttrsCount());
    assertEquals(0, actualParseFromResult.getImportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualParseFromResult.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getImports().isEmpty());
    assertTrue(actualParseFromResult.getImportsMap().isEmpty());
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
    assertSame(importAttrsList, actualParseFromResult.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportDataJob#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getImportAttrsCount());
    assertEquals(0, actualParseFromResult.getImportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualParseFromResult.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getImports().isEmpty());
    assertTrue(actualParseFromResult.getImportsMap().isEmpty());
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
    assertSame(importAttrsList, actualParseFromResult.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getImportAttrsCount());
    assertEquals(0, actualParseFromResult.getImportsCount());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputAttrsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getPriorOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageAccessCount());
    assertFalse(actualParseFromResult.hasModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualParseFromResult.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getStorageAccessList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getImports().isEmpty());
    assertTrue(actualParseFromResult.getImportsMap().isEmpty());
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
    assertSame(importAttrsList, actualParseFromResult.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsList());
    assertSame(importAttrsList, actualParseFromResult.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ImportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom(new ByteArrayInputStream(new byte[]{}));

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
   * Test {@link ImportDataJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ImportDataJob actualParseFromResult = ImportDataJob.parseFrom((InputStream) null);

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
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ImportDataJob actualParseDelimitedFromResult = ImportDataJob.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportDataJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, ImportDataJob.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ImportDataJob actualParseDelimitedFromResult = ImportDataJob.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportDataJob#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ImportDataJob#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob ImportDataJob.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

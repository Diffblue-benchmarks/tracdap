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
import com.google.protobuf.ByteString;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelDefinitionDiffblueTest {
  /**
   * Test {@link ModelDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER));
  }

  /**
   * Test {@link ModelDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when eight; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenEight_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(8);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link ModelDefinition#OUTPUTS_FIELD_NUMBER}.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when OUTPUTS_FIELD_NUMBER; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenOutputs_field_number_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.OUTPUTS_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when seven; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenSeven_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(7);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link ModelDefinition#STATICATTRIBUTES_FIELD_NUMBER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when STATICATTRIBUTES_FIELD_NUMBER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenStaticattributes_field_number() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getLanguage()}.
   * <p>
   * Method under test: {@link ModelDefinition#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getLanguage()"})
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getLanguage());
  }

  /**
   * Test {@link ModelDefinition#getLanguageBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getLanguageBytes()}
   */
  @Test
  @DisplayName("Test getLanguageBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getLanguageBytes()"})
  void testGetLanguageBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualLanguageBytes = defaultInstance.getLanguageBytes();

    // Assert
    ByteString byteString = actualLanguageBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, actualLanguageBytes);
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#getRepository()}.
   * <p>
   * Method under test: {@link ModelDefinition#getRepository()}
   */
  @Test
  @DisplayName("Test getRepository()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getRepository()"})
  void testGetRepository() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getRepository());
  }

  /**
   * Test {@link ModelDefinition#getRepositoryBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getRepositoryBytes()}
   */
  @Test
  @DisplayName("Test getRepositoryBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getRepositoryBytes()"})
  void testGetRepositoryBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualRepositoryBytes = defaultInstance.getRepositoryBytes();

    // Assert
    ByteString byteString = actualRepositoryBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, actualRepositoryBytes);
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#hasPackageGroup()}.
   * <p>
   * Method under test: {@link ModelDefinition#hasPackageGroup()}
   */
  @Test
  @DisplayName("Test hasPackageGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.hasPackageGroup()"})
  void testHasPackageGroup() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().hasPackageGroup());
  }

  /**
   * Test {@link ModelDefinition#getPackageGroup()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPackageGroup()}
   */
  @Test
  @DisplayName("Test getPackageGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getPackageGroup()"})
  void testGetPackageGroup() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPackageGroup());
  }

  /**
   * Test {@link ModelDefinition#getPackageGroupBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPackageGroupBytes()}
   */
  @Test
  @DisplayName("Test getPackageGroupBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getPackageGroupBytes()"})
  void testGetPackageGroupBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPackageGroupBytes = defaultInstance.getPackageGroupBytes();

    // Assert
    ByteString byteString = actualPackageGroupBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, actualPackageGroupBytes);
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#getPackage()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPackage()}
   */
  @Test
  @DisplayName("Test getPackage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getPackage()"})
  void testGetPackage() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPackage());
  }

  /**
   * Test {@link ModelDefinition#getPackageBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPackageBytes()}
   */
  @Test
  @DisplayName("Test getPackageBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getPackageBytes()"})
  void testGetPackageBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPackageBytes = defaultInstance.getPackageBytes();

    // Assert
    ByteString byteString = actualPackageBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, actualPackageBytes);
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#getVersion()}.
   * <p>
   * Method under test: {@link ModelDefinition#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getVersion()"})
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getVersion());
  }

  /**
   * Test {@link ModelDefinition#getVersionBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getVersionBytes()}
   */
  @Test
  @DisplayName("Test getVersionBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getVersionBytes()"})
  void testGetVersionBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, actualVersionBytes);
  }

  /**
   * Test {@link ModelDefinition#getEntryPoint()}.
   * <p>
   * Method under test: {@link ModelDefinition#getEntryPoint()}
   */
  @Test
  @DisplayName("Test getEntryPoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getEntryPoint()"})
  void testGetEntryPoint() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getEntryPoint());
  }

  /**
   * Test {@link ModelDefinition#getEntryPointBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getEntryPointBytes()}
   */
  @Test
  @DisplayName("Test getEntryPointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getEntryPointBytes()"})
  void testGetEntryPointBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualEntryPointBytes = defaultInstance.getEntryPointBytes();

    // Assert
    ByteString byteString = actualEntryPointBytes.EMPTY;
    assertEquals(byteString, actualEntryPointBytes);
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#hasPath()}.
   * <p>
   * Method under test: {@link ModelDefinition#hasPath()}
   */
  @Test
  @DisplayName("Test hasPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.hasPath()"})
  void testHasPath() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().hasPath());
  }

  /**
   * Test {@link ModelDefinition#getPath()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelDefinition.getPath()"})
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPath());
  }

  /**
   * Test {@link ModelDefinition#getPathBytes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getPathBytes()}
   */
  @Test
  @DisplayName("Test getPathBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelDefinition.getPathBytes()"})
  void testGetPathBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPathBytes = defaultInstance.getPathBytes();

    // Assert
    ByteString byteString = actualPathBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, actualPathBytes);
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ModelDefinition#getParametersCount()}.
   * <p>
   * Method under test: {@link ModelDefinition#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelDefinition.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link ModelDefinition#containsParameters(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#containsParameters(String)}
   */
  @Test
  @DisplayName("Test containsParameters(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.containsParameters(String)"})
  void testContainsParameters_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Test {@link ModelDefinition#getParameters()}.
   * <p>
   * Method under test: {@link ModelDefinition#getParameters()}
   */
  @Test
  @DisplayName("Test getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getParameters()"})
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getParametersMap()}.
   * <p>
   * Method under test: {@link ModelDefinition#getParametersMap()}
   */
  @Test
  @DisplayName("Test getParametersMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getParametersMap()"})
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getParametersOrDefault(String, ModelParameter)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getParametersOrDefault(String, ModelParameter)}
   */
  @Test
  @DisplayName("Test getParametersOrDefault(String, ModelParameter); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelDefinition.getParametersOrDefault(String, ModelParameter)"})
  void testGetParametersOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelParameter defaultValue = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelDefinition#getParametersOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getParametersOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParametersOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelDefinition.getParametersOrThrow(String)"})
  void testGetParametersOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelDefinition.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Test {@link ModelDefinition#getInputsCount()}.
   * <p>
   * Method under test: {@link ModelDefinition#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelDefinition.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link ModelDefinition#containsInputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#containsInputs(String)}
   */
  @Test
  @DisplayName("Test containsInputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.containsInputs(String)"})
  void testContainsInputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Test {@link ModelDefinition#getInputs()}.
   * <p>
   * Method under test: {@link ModelDefinition#getInputs()}
   */
  @Test
  @DisplayName("Test getInputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getInputs()"})
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getInputsMap()}.
   * <p>
   * Method under test: {@link ModelDefinition#getInputsMap()}
   */
  @Test
  @DisplayName("Test getInputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getInputsMap()"})
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getInputsOrDefault(String, ModelInputSchema)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getInputsOrDefault(String, ModelInputSchema)}
   */
  @Test
  @DisplayName("Test getInputsOrDefault(String, ModelInputSchema); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelDefinition.getInputsOrDefault(String, ModelInputSchema)"})
  void testGetInputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelInputSchema defaultValue = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelDefinition#getInputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getInputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelDefinition.getInputsOrThrow(String)"})
  void testGetInputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelDefinition.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Test {@link ModelDefinition#getOutputsCount()}.
   * <p>
   * Method under test: {@link ModelDefinition#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelDefinition.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link ModelDefinition#containsOutputs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#containsOutputs(String)}
   */
  @Test
  @DisplayName("Test containsOutputs(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.containsOutputs(String)"})
  void testContainsOutputs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Test {@link ModelDefinition#getOutputs()}.
   * <p>
   * Method under test: {@link ModelDefinition#getOutputs()}
   */
  @Test
  @DisplayName("Test getOutputs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getOutputs()"})
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getOutputsMap()}.
   * <p>
   * Method under test: {@link ModelDefinition#getOutputsMap()}
   */
  @Test
  @DisplayName("Test getOutputsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getOutputsMap()"})
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getOutputsOrDefault(String, ModelOutputSchema)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getOutputsOrDefault(String, ModelOutputSchema)}
   */
  @Test
  @DisplayName("Test getOutputsOrDefault(String, ModelOutputSchema); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelDefinition.getOutputsOrDefault(String, ModelOutputSchema)"})
  void testGetOutputsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelOutputSchema defaultValue = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelDefinition#getOutputsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getOutputsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelDefinition.getOutputsOrThrow(String)"})
  void testGetOutputsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelDefinition.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Test {@link ModelDefinition#getStaticAttributesCount()}.
   * <p>
   * Method under test: {@link ModelDefinition#getStaticAttributesCount()}
   */
  @Test
  @DisplayName("Test getStaticAttributesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelDefinition.getStaticAttributesCount()"})
  void testGetStaticAttributesCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getStaticAttributesCount());
  }

  /**
   * Test {@link ModelDefinition#containsStaticAttributes(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#containsStaticAttributes(String)}
   */
  @Test
  @DisplayName("Test containsStaticAttributes(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.containsStaticAttributes(String)"})
  void testContainsStaticAttributes_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsStaticAttributes("Key"));
  }

  /**
   * Test {@link ModelDefinition#getStaticAttributes()}.
   * <p>
   * Method under test: {@link ModelDefinition#getStaticAttributes()}
   */
  @Test
  @DisplayName("Test getStaticAttributes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getStaticAttributes()"})
  void testGetStaticAttributes() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getStaticAttributes().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getStaticAttributesMap()}.
   * <p>
   * Method under test: {@link ModelDefinition#getStaticAttributesMap()}
   */
  @Test
  @DisplayName("Test getStaticAttributesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelDefinition.getStaticAttributesMap()"})
  void testGetStaticAttributesMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getStaticAttributesMap().isEmpty());
  }

  /**
   * Test {@link ModelDefinition#getStaticAttributesOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getStaticAttributesOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getStaticAttributesOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelDefinition.getStaticAttributesOrDefault(String, Value)"})
  void testGetStaticAttributesOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getStaticAttributesOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelDefinition#getStaticAttributesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#getStaticAttributesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getStaticAttributesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelDefinition.getStaticAttributesOrThrow(String)"})
  void testGetStaticAttributesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelDefinition.getDefaultInstance().getStaticAttributesOrThrow("Key"));
  }

  /**
   * Test {@link ModelDefinition#getModelType()}.
   * <p>
   * Method under test: {@link ModelDefinition#getModelType()}
   */
  @Test
  @DisplayName("Test getModelType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelDefinition.getModelType()"})
  void testGetModelType() {
    // Arrange, Act and Assert
    assertEquals(ModelType.STANDARD_MODEL, ModelDefinition.getDefaultInstance().getModelType());
  }

  /**
   * Test {@link ModelDefinition#isInitialized()}.
   * <p>
   * Method under test: {@link ModelDefinition#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ModelDefinition#getSerializedSize()}.
   * <p>
   * Method under test: {@link ModelDefinition#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelDefinition.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ModelDefinition#equals(Object)}, and {@link ModelDefinition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelDefinition#equals(Object)}
   *   <li>{@link ModelDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.equals(Object)", "int ModelDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelDefinition defaultInstance2 = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ModelDefinition#equals(Object)}, and {@link ModelDefinition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelDefinition#equals(Object)}
   *   <li>{@link ModelDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.equals(Object)", "int ModelDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ModelDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.equals(Object)", "int ModelDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ModelDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.equals(Object)", "int ModelDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), null);
  }

  /**
   * Test {@link ModelDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelDefinition.equals(Object)", "int ModelDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), "Different type to ModelDefinition");
  }

  /**
   * Test {@link ModelDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualParseFromResult.getModelType());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertFalse(actualParseFromResult.hasPath());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualParseFromResult.getModelType());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertFalse(actualParseFromResult.hasPath());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualParseFromResult.getModelType());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertFalse(actualParseFromResult.hasPath());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualParseFromResult.getModelType());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertFalse(actualParseFromResult.hasPath());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getModelTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStaticAttributesCount());
    assertEquals(ModelType.STANDARD_MODEL, actualParseFromResult.getModelType());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertFalse(actualParseFromResult.hasPath());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputs().isEmpty());
    assertTrue(actualParseFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseFromResult.getOutputs().isEmpty());
    assertTrue(actualParseFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseFromResult.getParameters().isEmpty());
    assertTrue(actualParseFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ModelDefinition actualParseFromResult = ModelDefinition.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelDefinition actualParseDelimitedFromResult = ModelDefinition.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getEntryPoint());
    assertEquals("", actualParseDelimitedFromResult.getLanguage());
    assertEquals("", actualParseDelimitedFromResult.getPackage());
    assertEquals("", actualParseDelimitedFromResult.getPackageGroup());
    assertEquals("", actualParseDelimitedFromResult.getPath());
    assertEquals("", actualParseDelimitedFromResult.getRepository());
    assertEquals("", actualParseDelimitedFromResult.getVersion());
    assertEquals(0, actualParseDelimitedFromResult.getInputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getModelTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getOutputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStaticAttributesCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ModelType.STANDARD_MODEL, actualParseDelimitedFromResult.getModelType());
    assertFalse(actualParseDelimitedFromResult.hasPackageGroup());
    assertFalse(actualParseDelimitedFromResult.hasPath());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputs().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputs().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParameters().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelDefinition actualParseDelimitedFromResult = ModelDefinition.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getEntryPoint());
    assertEquals("", actualParseDelimitedFromResult.getLanguage());
    assertEquals("", actualParseDelimitedFromResult.getPackage());
    assertEquals("", actualParseDelimitedFromResult.getPackageGroup());
    assertEquals("", actualParseDelimitedFromResult.getPath());
    assertEquals("", actualParseDelimitedFromResult.getRepository());
    assertEquals("", actualParseDelimitedFromResult.getVersion());
    assertEquals(0, actualParseDelimitedFromResult.getInputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getModelTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getOutputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStaticAttributesCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ModelType.STANDARD_MODEL, actualParseDelimitedFromResult.getModelType());
    assertFalse(actualParseDelimitedFromResult.hasPackageGroup());
    assertFalse(actualParseDelimitedFromResult.hasPath());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputs().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputs().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParameters().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getStaticAttributes().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getStaticAttributesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelDefinition#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ModelDefinition#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelDefinition ModelDefinition.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

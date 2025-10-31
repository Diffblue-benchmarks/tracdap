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
import org.finos.tracdap.metadata.ModelInputSchema.RequirementCase;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelInputSchemaDiffblueTest {
  /**
   * Test {@link ModelInputSchema#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelInputSchema.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelInputSchema.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ModelInputSchema#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelInputSchema.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelInputSchema.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelInputSchema#getRequirementCase()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getRequirementCase()}
   */
  @Test
  @DisplayName("Test getRequirementCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase ModelInputSchema.getRequirementCase()"})
  void testGetRequirementCase() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, ModelInputSchema.getDefaultInstance().getRequirementCase());
  }

  /**
   * Test {@link ModelInputSchema#getObjectType()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getObjectType()}
   */
  @Test
  @DisplayName("Test getObjectType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ModelInputSchema.getObjectType()"})
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ModelInputSchema.getDefaultInstance().getObjectType());
  }

  /**
   * Test {@link ModelInputSchema#hasSchema()}.
   * <p>
   * Method under test: {@link ModelInputSchema#hasSchema()}
   */
  @Test
  @DisplayName("Test hasSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.hasSchema()"})
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasSchema());
  }

  /**
   * Test {@link ModelInputSchema#getSchema()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ModelInputSchema.getSchema()"})
  void testGetSchema() {
    // Arrange and Act
    SchemaDefinition actualSchema = ModelInputSchema.getDefaultInstance().getSchema();

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
   * Test {@link ModelInputSchema#hasFileType()}.
   * <p>
   * Method under test: {@link ModelInputSchema#hasFileType()}
   */
  @Test
  @DisplayName("Test hasFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.hasFileType()"})
  void testHasFileType() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasFileType());
  }

  /**
   * Test {@link ModelInputSchema#getFileType()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getFileType()}
   */
  @Test
  @DisplayName("Test getFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FileType ModelInputSchema.getFileType()"})
  void testGetFileType() {
    // Arrange and Act
    FileType actualFileType = ModelInputSchema.getDefaultInstance().getFileType();

    // Assert
    assertEquals("", actualFileType.getInitializationErrorString());
    assertEquals("", actualFileType.getExtension());
    assertEquals("", actualFileType.getMimeType());
    assertEquals(0, actualFileType.getSerializedSize());
    assertTrue(actualFileType.findInitializationErrors().isEmpty());
    assertTrue(actualFileType.getAllFields().isEmpty());
    assertTrue(actualFileType.isInitialized());
    assertSame(actualFileType, actualFileType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#hasLabel()}.
   * <p>
   * Method under test: {@link ModelInputSchema#hasLabel()}
   */
  @Test
  @DisplayName("Test hasLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.hasLabel()"})
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasLabel());
  }

  /**
   * Test {@link ModelInputSchema#getLabel()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelInputSchema.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", ModelInputSchema.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link ModelInputSchema#getLabelBytes()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelInputSchema.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    FileType fileType = defaultInstance.getFileType();
    assertEquals(byteString, fileType.getExtensionBytes());
    assertEquals(byteString, fileType.getMimeTypeBytes());
    assertEquals(byteString, actualLabelBytes);
  }

  /**
   * Test {@link ModelInputSchema#getInputPropsCount()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getInputPropsCount()}
   */
  @Test
  @DisplayName("Test getInputPropsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelInputSchema.getInputPropsCount()"})
  void testGetInputPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelInputSchema.getDefaultInstance().getInputPropsCount());
  }

  /**
   * Test {@link ModelInputSchema#containsInputProps(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#containsInputProps(String)}
   */
  @Test
  @DisplayName("Test containsInputProps(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.containsInputProps(String)"})
  void testContainsInputProps_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().containsInputProps("Key"));
  }

  /**
   * Test {@link ModelInputSchema#getInputProps()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getInputProps()}
   */
  @Test
  @DisplayName("Test getInputProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelInputSchema.getInputProps()"})
  void testGetInputProps() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().getInputProps().isEmpty());
  }

  /**
   * Test {@link ModelInputSchema#getInputPropsMap()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getInputPropsMap()}
   */
  @Test
  @DisplayName("Test getInputPropsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelInputSchema.getInputPropsMap()"})
  void testGetInputPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().getInputPropsMap().isEmpty());
  }

  /**
   * Test {@link ModelInputSchema#getInputPropsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#getInputPropsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getInputPropsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelInputSchema.getInputPropsOrDefault(String, Value)"})
  void testGetInputPropsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputPropsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelInputSchema#getInputPropsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#getInputPropsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getInputPropsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelInputSchema.getInputPropsOrThrow(String)"})
  void testGetInputPropsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelInputSchema.getDefaultInstance().getInputPropsOrThrow("Key"));
  }

  /**
   * Test {@link ModelInputSchema#isInitialized()}.
   * <p>
   * Method under test: {@link ModelInputSchema#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ModelInputSchema#getSerializedSize()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelInputSchema.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelInputSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ModelInputSchema#equals(Object)}, and {@link ModelInputSchema#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelInputSchema#equals(Object)}
   *   <li>{@link ModelInputSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.equals(Object)", "int ModelInputSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();
    ModelInputSchema defaultInstance2 = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ModelInputSchema#equals(Object)}, and {@link ModelInputSchema#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelInputSchema#equals(Object)}
   *   <li>{@link ModelInputSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.equals(Object)", "int ModelInputSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ModelInputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.equals(Object)", "int ModelInputSchema.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ModelInputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.equals(Object)", "int ModelInputSchema.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), null);
  }

  /**
   * Test {@link ModelInputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelInputSchema.equals(Object)", "int ModelInputSchema.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), "Different type to ModelInputSchema");
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.getDynamic());
    assertFalse(actualParseFromResult.getOptional());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasLabel());
    assertFalse(actualParseFromResult.hasSchema());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputProps().isEmpty());
    assertTrue(actualParseFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.getDynamic());
    assertFalse(actualParseFromResult.getOptional());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasLabel());
    assertFalse(actualParseFromResult.hasSchema());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputProps().isEmpty());
    assertTrue(actualParseFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.getDynamic());
    assertFalse(actualParseFromResult.getOptional());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasLabel());
    assertFalse(actualParseFromResult.hasSchema());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputProps().isEmpty());
    assertTrue(actualParseFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.getDynamic());
    assertFalse(actualParseFromResult.getOptional());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasLabel());
    assertFalse(actualParseFromResult.hasSchema());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputProps().isEmpty());
    assertTrue(actualParseFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputPropsCount());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.getDynamic());
    assertFalse(actualParseFromResult.getOptional());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasLabel());
    assertFalse(actualParseFromResult.hasSchema());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getInputProps().isEmpty());
    assertTrue(actualParseFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelInputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelInputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelInputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelInputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    FileType fileType = actualParseFromResult.getFileType();
    assertSame(unknownFields, fileType.getUnknownFields());
    SchemaDefinition schema = actualParseFromResult.getSchema();
    assertSame(unknownFields, schema.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(fileType, fileType.getDefaultInstanceForType());
    assertSame(fileType, actualParseFromResult.getFileTypeOrBuilder());
    assertSame(schema, actualParseFromResult.getSchemaOrBuilder());
    assertSame(schema, schema.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ModelInputSchema actualParseFromResult = ModelInputSchema.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    FileType fileType = actualParseFromResult.getFileType();
    assertSame(unknownFields, fileType.getUnknownFields());
    SchemaDefinition schema = actualParseFromResult.getSchema();
    assertSame(unknownFields, schema.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(fileType, fileType.getDefaultInstanceForType());
    assertSame(fileType, actualParseFromResult.getFileTypeOrBuilder());
    assertSame(schema, actualParseFromResult.getSchemaOrBuilder());
    assertSame(schema, schema.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelInputSchema actualParseDelimitedFromResult = ModelInputSchema.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getInputPropsCount());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseDelimitedFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertFalse(actualParseDelimitedFromResult.getDynamic());
    assertFalse(actualParseDelimitedFromResult.getOptional());
    assertFalse(actualParseDelimitedFromResult.hasFileType());
    assertFalse(actualParseDelimitedFromResult.hasLabel());
    assertFalse(actualParseDelimitedFromResult.hasSchema());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelInputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelInputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ModelInputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelInputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ModelInputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelInputSchema actualParseDelimitedFromResult = ModelInputSchema.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getInputPropsCount());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, actualParseDelimitedFromResult.getRequirementCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertFalse(actualParseDelimitedFromResult.getDynamic());
    assertFalse(actualParseDelimitedFromResult.getOptional());
    assertFalse(actualParseDelimitedFromResult.hasFileType());
    assertFalse(actualParseDelimitedFromResult.hasLabel());
    assertFalse(actualParseDelimitedFromResult.hasSchema());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getInputPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelInputSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelInputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ModelInputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelInputSchema#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ModelInputSchema#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelInputSchema ModelInputSchema.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequirementCase.forNumber(42));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when one; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenOne_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.SCHEMA, RequirementCase.forNumber(1));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code FILETYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when seven; then return 'FILETYPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenSeven_thenReturnFiletype() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.FILETYPE, RequirementCase.forNumber(7));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code REQUIREMENT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when zero; then return 'REQUIREMENT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenZero_thenReturnRequirementNotSet() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, RequirementCase.forNumber(0));
  }

  /**
   * Test RequirementCase {@link RequirementCase#getNumber()}.
   * <p>
   * Method under test: {@link RequirementCase#getNumber()}
   */
  @Test
  @DisplayName("Test RequirementCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RequirementCase.getNumber()"})
  void testRequirementCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, RequirementCase.valueOf("SCHEMA").getNumber());
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequirementCase.valueOf(42));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when one; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenOne_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.SCHEMA, RequirementCase.valueOf(1));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code FILETYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when seven; then return 'FILETYPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenSeven_thenReturnFiletype() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.FILETYPE, RequirementCase.valueOf(7));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code REQUIREMENT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when zero; then return 'REQUIREMENT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenZero_thenReturnRequirementNotSet() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, RequirementCase.valueOf(0));
  }
}

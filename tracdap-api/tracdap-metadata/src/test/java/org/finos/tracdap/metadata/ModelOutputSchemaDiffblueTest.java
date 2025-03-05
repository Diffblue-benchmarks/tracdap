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
import org.finos.tracdap.metadata.ModelOutputSchema.RequirementCase;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelOutputSchemaDiffblueTest {
  /**
   * Test {@link ModelOutputSchema#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelOutputSchema.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelOutputSchema.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ModelOutputSchema#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelOutputSchema.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelOutputSchema.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelOutputSchema#getRequirementCase()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getRequirementCase()}
   */
  @Test
  @DisplayName("Test getRequirementCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequirementCase ModelOutputSchema.getRequirementCase()"})
  void testGetRequirementCase() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, ModelOutputSchema.getDefaultInstance().getRequirementCase());
  }

  /**
   * Test {@link ModelOutputSchema#getObjectType()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getObjectType()}
   */
  @Test
  @DisplayName("Test getObjectType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ModelOutputSchema.getObjectType()"})
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ModelOutputSchema.getDefaultInstance().getObjectType());
  }

  /**
   * Test {@link ModelOutputSchema#hasSchema()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#hasSchema()}
   */
  @Test
  @DisplayName("Test hasSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.hasSchema()"})
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasSchema());
  }

  /**
   * Test {@link ModelOutputSchema#getSchema()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ModelOutputSchema.getSchema()"})
  void testGetSchema() {
    // Arrange and Act
    SchemaDefinition actualSchema = ModelOutputSchema.getDefaultInstance().getSchema();

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
   * Test {@link ModelOutputSchema#hasFileType()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#hasFileType()}
   */
  @Test
  @DisplayName("Test hasFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.hasFileType()"})
  void testHasFileType() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasFileType());
  }

  /**
   * Test {@link ModelOutputSchema#getFileType()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getFileType()}
   */
  @Test
  @DisplayName("Test getFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FileType ModelOutputSchema.getFileType()"})
  void testGetFileType() {
    // Arrange and Act
    FileType actualFileType = ModelOutputSchema.getDefaultInstance().getFileType();

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
   * Test {@link ModelOutputSchema#hasLabel()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#hasLabel()}
   */
  @Test
  @DisplayName("Test hasLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.hasLabel()"})
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasLabel());
  }

  /**
   * Test {@link ModelOutputSchema#getLabel()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelOutputSchema.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", ModelOutputSchema.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link ModelOutputSchema#getLabelBytes()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelOutputSchema.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

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
   * Test {@link ModelOutputSchema#getOutputPropsCount()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getOutputPropsCount()}
   */
  @Test
  @DisplayName("Test getOutputPropsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelOutputSchema.getOutputPropsCount()"})
  void testGetOutputPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelOutputSchema.getDefaultInstance().getOutputPropsCount());
  }

  /**
   * Test {@link ModelOutputSchema#containsOutputProps(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#containsOutputProps(String)}
   */
  @Test
  @DisplayName("Test containsOutputProps(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.containsOutputProps(String)"})
  void testContainsOutputProps_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().containsOutputProps("Key"));
  }

  /**
   * Test {@link ModelOutputSchema#getOutputProps()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getOutputProps()}
   */
  @Test
  @DisplayName("Test getOutputProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelOutputSchema.getOutputProps()"})
  void testGetOutputProps() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().getOutputProps().isEmpty());
  }

  /**
   * Test {@link ModelOutputSchema#getOutputPropsMap()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getOutputPropsMap()}
   */
  @Test
  @DisplayName("Test getOutputPropsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelOutputSchema.getOutputPropsMap()"})
  void testGetOutputPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().getOutputPropsMap().isEmpty());
  }

  /**
   * Test {@link ModelOutputSchema#getOutputPropsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#getOutputPropsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getOutputPropsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelOutputSchema.getOutputPropsOrDefault(String, Value)"})
  void testGetOutputPropsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputPropsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelOutputSchema#getOutputPropsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#getOutputPropsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getOutputPropsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelOutputSchema.getOutputPropsOrThrow(String)"})
  void testGetOutputPropsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelOutputSchema.getDefaultInstance().getOutputPropsOrThrow("Key"));
  }

  /**
   * Test {@link ModelOutputSchema#isInitialized()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ModelOutputSchema#getSerializedSize()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelOutputSchema.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelOutputSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ModelOutputSchema#equals(Object)}, and {@link ModelOutputSchema#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelOutputSchema#equals(Object)}
   *   <li>{@link ModelOutputSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.equals(Object)", "int ModelOutputSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();
    ModelOutputSchema defaultInstance2 = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ModelOutputSchema#equals(Object)}, and {@link ModelOutputSchema#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelOutputSchema#equals(Object)}
   *   <li>{@link ModelOutputSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.equals(Object)", "int ModelOutputSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ModelOutputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.equals(Object)", "int ModelOutputSchema.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ModelOutputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.equals(Object)", "int ModelOutputSchema.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), null);
  }

  /**
   * Test {@link ModelOutputSchema#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelOutputSchema.equals(Object)", "int ModelOutputSchema.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), "Different type to ModelOutputSchema");
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getOutputPropsCount());
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
    assertTrue(actualParseFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getOutputPropsCount());
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
    assertTrue(actualParseFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getOutputPropsCount());
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
    assertTrue(actualParseFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getOutputPropsCount());
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
    assertTrue(actualParseFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getOutputPropsCount());
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
    assertTrue(actualParseFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelOutputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelOutputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelOutputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelOutputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelOutputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom(new ByteArrayInputStream(new byte[]{}));

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
   * Test {@link ModelOutputSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ModelOutputSchema actualParseFromResult = ModelOutputSchema.parseFrom((InputStream) null);

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
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelOutputSchema actualParseDelimitedFromResult = ModelOutputSchema.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getOutputPropsCount());
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
    assertTrue(actualParseDelimitedFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ModelOutputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelOutputSchema actualParseDelimitedFromResult = ModelOutputSchema.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getOutputPropsCount());
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
    assertTrue(actualParseDelimitedFromResult.getOutputProps().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getOutputPropsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelOutputSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelOutputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ModelOutputSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelOutputSchema#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ModelOutputSchema#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelOutputSchema ModelOutputSchema.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

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

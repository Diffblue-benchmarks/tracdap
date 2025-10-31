package org.finos.tracdap.metadata;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelInputSchemaDiffblueTest {
  /**
   * Method under test:
   * {@link ModelInputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelInputSchema.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test:
   * {@link ModelInputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
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
   * Method under test: {@link ModelInputSchema#getRequirementCase()}
   */
  @Test
  void testGetRequirementCase() {
    // Arrange, Act and Assert
    assertEquals(ModelInputSchema.RequirementCase.REQUIREMENT_NOT_SET,
        ModelInputSchema.getDefaultInstance().getRequirementCase());
  }

  /**
   * Method under test: {@link ModelInputSchema#getObjectType()}
   */
  @Test
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ModelInputSchema.getDefaultInstance().getObjectType());
  }

  /**
   * Method under test: {@link ModelInputSchema#hasSchema()}
   */
  @Test
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasSchema());
  }

  /**
   * Method under test: {@link ModelInputSchema#hasFileType()}
   */
  @Test
  void testHasFileType() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasFileType());
  }

  /**
   * Method under test: {@link ModelInputSchema#hasLabel()}
   */
  @Test
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().hasLabel());
  }

  /**
   * Method under test: {@link ModelInputSchema#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", ModelInputSchema.getDefaultInstance().getLabel());
  }

  /**
   * Method under test: {@link ModelInputSchema#getLabelBytes()}
   */
  @Test
  void testGetLabelBytes() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(5).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualLabelBytes);
  }

  /**
   * Method under test: {@link ModelInputSchema#getInputPropsCount()}
   */
  @Test
  void testGetInputPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelInputSchema.getDefaultInstance().getInputPropsCount());
  }

  /**
   * Method under test: {@link ModelInputSchema#containsInputProps(String)}
   */
  @Test
  void testContainsInputProps() {
    // Arrange, Act and Assert
    assertFalse(ModelInputSchema.getDefaultInstance().containsInputProps("Key"));
  }

  /**
   * Method under test: {@link ModelInputSchema#getInputProps()}
   */
  @Test
  void testGetInputProps() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().getInputProps().isEmpty());
  }

  /**
   * Method under test: {@link ModelInputSchema#getInputPropsMap()}
   */
  @Test
  void testGetInputPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().getInputPropsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelInputSchema#getInputPropsOrDefault(String, Value)}
   */
  @Test
  void testGetInputPropsOrDefault() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputPropsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelInputSchema#getInputPropsOrThrow(String)}
   */
  @Test
  void testGetInputPropsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelInputSchema.getDefaultInstance().getInputPropsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelInputSchema#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelInputSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link ModelInputSchema#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelInputSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelInputSchema#equals(Object)}
   *   <li>{@link ModelInputSchema#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ModelInputSchema#equals(Object)}
   *   <li>{@link ModelInputSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelInputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ModelInputSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelInputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelInputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelInputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelInputSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link ModelInputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelInputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
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
   * Method under test:
   * {@link ModelInputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
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
   * Method under test: {@link ModelInputSchema#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelInputSchema defaultInstance = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ModelInputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelInputSchema.getDefaultInstance(), "Different type to ModelInputSchema");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelInputSchema#getDefaultInstance()}
   *   <li>{@link ModelInputSchema#getDescriptor()}
   *   <li>{@link ModelInputSchema#newBuilder()}
   *   <li>{@link ModelInputSchema#newBuilder(ModelInputSchema)}
   *   <li>{@link ModelInputSchema#newBuilderForType()}
   *   <li>{@link ModelInputSchema#toBuilder()}
   *   <li>{@link ModelInputSchema#getDynamic()}
   *   <li>{@link ModelInputSchema#getFileTypeOrBuilder()}
   *   <li>{@link ModelInputSchema#getObjectTypeValue()}
   *   <li>{@link ModelInputSchema#getOptional()}
   *   <li>{@link ModelInputSchema#getParserForType()}
   *   <li>{@link ModelInputSchema#getSchemaOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ModelInputSchema actualDefaultInstance = ModelInputSchema.getDefaultInstance();
    ModelInputSchema actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    ModelInputSchema prototype = ModelInputSchema.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    boolean actualDynamic = actualDefaultInstance.getDynamic();
    FileTypeOrBuilder actualFileTypeOrBuilder = actualDefaultInstance.getFileTypeOrBuilder();
    int actualObjectTypeValue = actualDefaultInstance.getObjectTypeValue();
    boolean actualOptional = actualDefaultInstance.getOptional();
    actualDefaultInstance.getParserForType();
    SchemaDefinitionOrBuilder actualSchemaOrBuilder = actualDefaultInstance.getSchemaOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualObjectTypeValue);
    assertFalse(actualDynamic);
    assertFalse(actualOptional);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getFileType(), actualFileTypeOrBuilder);
    assertSame(actualDefaultInstance.getSchema(), actualSchemaOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link ModelInputSchema.RequirementCase#forNumber(int)}
   */
  @Test
  void testRequirementCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(ModelInputSchema.RequirementCase.forNumber(42));
    assertEquals(ModelInputSchema.RequirementCase.REQUIREMENT_NOT_SET, ModelInputSchema.RequirementCase.forNumber(0));
    assertEquals(ModelInputSchema.RequirementCase.SCHEMA, ModelInputSchema.RequirementCase.forNumber(1));
    assertEquals(ModelInputSchema.RequirementCase.FILETYPE, ModelInputSchema.RequirementCase.forNumber(7));
  }

  /**
   * Method under test: {@link ModelInputSchema.RequirementCase#getNumber()}
   */
  @Test
  void testRequirementCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, ModelInputSchema.RequirementCase.valueOf("SCHEMA").getNumber());
  }

  /**
   * Method under test: {@link ModelInputSchema.RequirementCase#valueOf(int)}
   */
  @Test
  void testRequirementCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(ModelInputSchema.RequirementCase.valueOf(42));
    assertEquals(ModelInputSchema.RequirementCase.REQUIREMENT_NOT_SET, ModelInputSchema.RequirementCase.valueOf(0));
    assertEquals(ModelInputSchema.RequirementCase.SCHEMA, ModelInputSchema.RequirementCase.valueOf(1));
    assertEquals(ModelInputSchema.RequirementCase.FILETYPE, ModelInputSchema.RequirementCase.valueOf(7));
  }
}

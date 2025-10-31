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

class ModelOutputSchemaDiffblueTest {
  /**
   * Method under test:
   * {@link ModelOutputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelOutputSchema.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test:
   * {@link ModelOutputSchema#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
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
   * Method under test: {@link ModelOutputSchema#getRequirementCase()}
   */
  @Test
  void testGetRequirementCase() {
    // Arrange, Act and Assert
    assertEquals(ModelOutputSchema.RequirementCase.REQUIREMENT_NOT_SET,
        ModelOutputSchema.getDefaultInstance().getRequirementCase());
  }

  /**
   * Method under test: {@link ModelOutputSchema#getObjectType()}
   */
  @Test
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ModelOutputSchema.getDefaultInstance().getObjectType());
  }

  /**
   * Method under test: {@link ModelOutputSchema#hasSchema()}
   */
  @Test
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasSchema());
  }

  /**
   * Method under test: {@link ModelOutputSchema#hasFileType()}
   */
  @Test
  void testHasFileType() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasFileType());
  }

  /**
   * Method under test: {@link ModelOutputSchema#hasLabel()}
   */
  @Test
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().hasLabel());
  }

  /**
   * Method under test: {@link ModelOutputSchema#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", ModelOutputSchema.getDefaultInstance().getLabel());
  }

  /**
   * Method under test: {@link ModelOutputSchema#getLabelBytes()}
   */
  @Test
  void testGetLabelBytes() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

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
   * Method under test: {@link ModelOutputSchema#getOutputPropsCount()}
   */
  @Test
  void testGetOutputPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelOutputSchema.getDefaultInstance().getOutputPropsCount());
  }

  /**
   * Method under test: {@link ModelOutputSchema#containsOutputProps(String)}
   */
  @Test
  void testContainsOutputProps() {
    // Arrange, Act and Assert
    assertFalse(ModelOutputSchema.getDefaultInstance().containsOutputProps("Key"));
  }

  /**
   * Method under test: {@link ModelOutputSchema#getOutputProps()}
   */
  @Test
  void testGetOutputProps() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().getOutputProps().isEmpty());
  }

  /**
   * Method under test: {@link ModelOutputSchema#getOutputPropsMap()}
   */
  @Test
  void testGetOutputPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().getOutputPropsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelOutputSchema#getOutputPropsOrDefault(String, Value)}
   */
  @Test
  void testGetOutputPropsOrDefault() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputPropsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelOutputSchema#getOutputPropsOrThrow(String)}
   */
  @Test
  void testGetOutputPropsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelOutputSchema.getDefaultInstance().getOutputPropsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelOutputSchema#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelOutputSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link ModelOutputSchema#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelOutputSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelOutputSchema#equals(Object)}
   *   <li>{@link ModelOutputSchema#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ModelOutputSchema#equals(Object)}
   *   <li>{@link ModelOutputSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelOutputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ModelOutputSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelOutputSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelOutputSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelOutputSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelOutputSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link ModelOutputSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
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
   * Method under test:
   * {@link ModelOutputSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ModelOutputSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ModelOutputSchema#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelOutputSchema defaultInstance = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ModelOutputSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelOutputSchema.getDefaultInstance(), "Different type to ModelOutputSchema");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelOutputSchema#getDefaultInstance()}
   *   <li>{@link ModelOutputSchema#getDescriptor()}
   *   <li>{@link ModelOutputSchema#newBuilder()}
   *   <li>{@link ModelOutputSchema#newBuilder(ModelOutputSchema)}
   *   <li>{@link ModelOutputSchema#newBuilderForType()}
   *   <li>{@link ModelOutputSchema#toBuilder()}
   *   <li>{@link ModelOutputSchema#getDynamic()}
   *   <li>{@link ModelOutputSchema#getFileTypeOrBuilder()}
   *   <li>{@link ModelOutputSchema#getObjectTypeValue()}
   *   <li>{@link ModelOutputSchema#getOptional()}
   *   <li>{@link ModelOutputSchema#getParserForType()}
   *   <li>{@link ModelOutputSchema#getSchemaOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ModelOutputSchema actualDefaultInstance = ModelOutputSchema.getDefaultInstance();
    ModelOutputSchema actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    ModelOutputSchema prototype = ModelOutputSchema.getDefaultInstance();
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
   * Method under test: {@link ModelOutputSchema.RequirementCase#forNumber(int)}
   */
  @Test
  void testRequirementCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(ModelOutputSchema.RequirementCase.forNumber(42));
    assertEquals(ModelOutputSchema.RequirementCase.REQUIREMENT_NOT_SET, ModelOutputSchema.RequirementCase.forNumber(0));
    assertEquals(ModelOutputSchema.RequirementCase.SCHEMA, ModelOutputSchema.RequirementCase.forNumber(1));
    assertEquals(ModelOutputSchema.RequirementCase.FILETYPE, ModelOutputSchema.RequirementCase.forNumber(7));
  }

  /**
   * Method under test: {@link ModelOutputSchema.RequirementCase#getNumber()}
   */
  @Test
  void testRequirementCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, ModelOutputSchema.RequirementCase.valueOf("SCHEMA").getNumber());
  }

  /**
   * Method under test: {@link ModelOutputSchema.RequirementCase#valueOf(int)}
   */
  @Test
  void testRequirementCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(ModelOutputSchema.RequirementCase.valueOf(42));
    assertEquals(ModelOutputSchema.RequirementCase.REQUIREMENT_NOT_SET, ModelOutputSchema.RequirementCase.valueOf(0));
    assertEquals(ModelOutputSchema.RequirementCase.SCHEMA, ModelOutputSchema.RequirementCase.valueOf(1));
    assertEquals(ModelOutputSchema.RequirementCase.FILETYPE, ModelOutputSchema.RequirementCase.valueOf(7));
  }
}

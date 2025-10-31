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
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FieldSchemaDiffblueTest {
  /**
   * Method under test: {@link FieldSchema#getFieldName()}
   */
  @Test
  void testGetFieldName() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getFieldName());
  }

  /**
   * Method under test: {@link FieldSchema#getFieldNameBytes()}
   */
  @Test
  void testGetFieldNameBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualFieldNameBytes = defaultInstance.getFieldNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualFieldNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualFieldNameBytes);
  }

  /**
   * Method under test: {@link FieldSchema#getFieldType()}
   */
  @Test
  void testGetFieldType() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, FieldSchema.getDefaultInstance().getFieldType());
  }

  /**
   * Method under test: {@link FieldSchema#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getLabel());
  }

  /**
   * Method under test: {@link FieldSchema#getLabelBytes()}
   */
  @Test
  void testGetLabelBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualLabelBytes);
  }

  /**
   * Method under test: {@link FieldSchema#hasNotNull()}
   */
  @Test
  void testHasNotNull() {
    // Arrange, Act and Assert
    assertFalse(FieldSchema.getDefaultInstance().hasNotNull());
  }

  /**
   * Method under test: {@link FieldSchema#hasFormatCode()}
   */
  @Test
  void testHasFormatCode() {
    // Arrange, Act and Assert
    assertFalse(FieldSchema.getDefaultInstance().hasFormatCode());
  }

  /**
   * Method under test: {@link FieldSchema#getFormatCode()}
   */
  @Test
  void testGetFormatCode() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getFormatCode());
  }

  /**
   * Method under test: {@link FieldSchema#getFormatCodeBytes()}
   */
  @Test
  void testGetFormatCodeBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualFormatCodeBytes = defaultInstance.getFormatCodeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualFormatCodeBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualFormatCodeBytes);
  }

  /**
   * Method under test: {@link FieldSchema#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FieldSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link FieldSchema#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FieldSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldSchema#equals(Object)}
   *   <li>{@link FieldSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();
    FieldSchema defaultInstance2 = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldSchema#equals(Object)}
   *   <li>{@link FieldSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FieldSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FieldSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FieldSchema#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), "Different type to FieldSchema");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldSchema#getDefaultInstance()}
   *   <li>{@link FieldSchema#getDescriptor()}
   *   <li>{@link FieldSchema#newBuilder()}
   *   <li>{@link FieldSchema#newBuilder(FieldSchema)}
   *   <li>{@link FieldSchema#newBuilderForType()}
   *   <li>{@link FieldSchema#toBuilder()}
   *   <li>{@link FieldSchema#getBusinessKey()}
   *   <li>{@link FieldSchema#getCategorical()}
   *   <li>{@link FieldSchema#getFieldOrder()}
   *   <li>{@link FieldSchema#getFieldTypeValue()}
   *   <li>{@link FieldSchema#getNotNull()}
   *   <li>{@link FieldSchema#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FieldSchema actualDefaultInstance = FieldSchema.getDefaultInstance();
    FieldSchema actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    FieldSchema prototype = FieldSchema.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    boolean actualBusinessKey = actualDefaultInstance.getBusinessKey();
    boolean actualCategorical = actualDefaultInstance.getCategorical();
    int actualFieldOrder = actualDefaultInstance.getFieldOrder();
    int actualFieldTypeValue = actualDefaultInstance.getFieldTypeValue();
    boolean actualNotNull = actualDefaultInstance.getNotNull();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualFieldOrder);
    assertEquals(0, actualFieldTypeValue);
    assertFalse(actualBusinessKey);
    assertFalse(actualCategorical);
    assertFalse(actualNotNull);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

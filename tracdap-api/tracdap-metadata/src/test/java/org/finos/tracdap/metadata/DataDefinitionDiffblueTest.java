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

class DataDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Delta#equals(Object)}
   *   <li>{@link DataDefinition.Delta#hashCode()}
   * </ul>
   */
  @Test
  void testDeltaEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDefinition.Delta defaultInstance = DataDefinition.Delta.getDefaultInstance();
    DataDefinition.Delta defaultInstance2 = DataDefinition.Delta.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Delta#equals(Object)}
   *   <li>{@link DataDefinition.Delta#hashCode()}
   * </ul>
   */
  @Test
  void testDeltaEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDefinition.Delta defaultInstance = DataDefinition.Delta.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DataDefinition.Delta#equals(Object)}
   */
  @Test
  void testDeltaEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Delta.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DataDefinition.Delta#equals(Object)}
   */
  @Test
  void testDeltaEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Delta.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DataDefinition.Delta#equals(Object)}
   */
  @Test
  void testDeltaEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Delta.getDefaultInstance(), "Different type to Delta");
  }

  /**
   * Method under test: {@link DataDefinition.Delta#getDataItem()}
   */
  @Test
  void testDeltaGetDataItem() {
    // Arrange, Act and Assert
    assertEquals("", DataDefinition.Delta.getDefaultInstance().getDataItem());
  }

  /**
   * Method under test: {@link DataDefinition.Delta#getDataItemBytes()}
   */
  @Test
  void testDeltaGetDataItemBytes() {
    // Arrange
    DataDefinition.Delta defaultInstance = DataDefinition.Delta.getDefaultInstance();

    // Act
    ByteString actualDataItemBytes = defaultInstance.getDataItemBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDataItemBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
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
    assertEquals(byteString, actualDataItemBytes);
  }

  /**
   * Method under test: {@link DataDefinition.Delta#getDefaultInstanceForType()}
   */
  @Test
  void testDeltaGetDefaultInstanceForType() {
    // Arrange
    DataDefinition.Delta defaultInstance = DataDefinition.Delta.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DataDefinition.Delta#getSerializedSize()}
   */
  @Test
  void testDeltaGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.Delta.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Delta#getDefaultInstance()}
   *   <li>{@link DataDefinition.Delta#getDescriptor()}
   *   <li>{@link DataDefinition.Delta#newBuilder()}
   *   <li>{@link DataDefinition.Delta#newBuilder(DataDefinition.Delta)}
   *   <li>{@link DataDefinition.Delta#newBuilderForType()}
   *   <li>{@link DataDefinition.Delta#toBuilder()}
   *   <li>{@link DataDefinition.Delta#getDeltaIndex()}
   *   <li>{@link DataDefinition.Delta#getParserForType()}
   * </ul>
   */
  @Test
  void testDeltaGettersAndSetters() {
    // Arrange and Act
    DataDefinition.Delta actualDefaultInstance = DataDefinition.Delta.getDefaultInstance();
    DataDefinition.Delta actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    DataDefinition.Delta prototype = DataDefinition.Delta.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    int actualDeltaIndex = actualDefaultInstance.getDeltaIndex();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualDeltaIndex);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link DataDefinition.Delta#isInitialized()}
   */
  @Test
  void testDeltaIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.Delta.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDeltaParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Delta.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDeltaParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDeltaParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDeltaParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataDefinition.Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DataDefinition.Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition.Delta#parseFrom(InputStream)}
   */
  @Test
  void testDeltaParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Delta.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition.Delta#parseFrom(InputStream)}
   */
  @Test
  void testDeltaParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Delta.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Delta#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDeltaParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataDefinition.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link DataDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = DataDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link DataDefinition#getSchemaSpecifierCase()}
   */
  @Test
  void testGetSchemaSpecifierCase() {
    // Arrange, Act and Assert
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataDefinition.getDefaultInstance().getSchemaSpecifierCase());
  }

  /**
   * Method under test: {@link DataDefinition#hasSchemaId()}
   */
  @Test
  void testHasSchemaId() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasSchemaId());
  }

  /**
   * Method under test: {@link DataDefinition#hasSchema()}
   */
  @Test
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasSchema());
  }

  /**
   * Method under test: {@link DataDefinition#getPartsCount()}
   */
  @Test
  void testGetPartsCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.getDefaultInstance().getPartsCount());
  }

  /**
   * Method under test: {@link DataDefinition#containsParts(String)}
   */
  @Test
  void testContainsParts() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().containsParts("Key"));
  }

  /**
   * Method under test: {@link DataDefinition#getParts()}
   */
  @Test
  void testGetParts() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().getParts().isEmpty());
  }

  /**
   * Method under test: {@link DataDefinition#getPartsMap()}
   */
  @Test
  void testGetPartsMap() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().getPartsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link DataDefinition#getPartsOrDefault(String, DataDefinition.Part)}
   */
  @Test
  void testGetPartsOrDefault() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();
    DataDefinition.Part defaultValue = DataDefinition.Part.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPartsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link DataDefinition#getPartsOrThrow(String)}
   */
  @Test
  void testGetPartsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataDefinition.getDefaultInstance().getPartsOrThrow("Key"));
  }

  /**
   * Method under test: {@link DataDefinition#hasStorageId()}
   */
  @Test
  void testHasStorageId() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasStorageId());
  }

  /**
   * Method under test: {@link DataDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link DataDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition#equals(Object)}
   *   <li>{@link DataDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();
    DataDefinition defaultInstance2 = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition#equals(Object)}
   *   <li>{@link DataDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), "Different type to DataDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition#getDefaultInstance()}
   *   <li>{@link DataDefinition#getDescriptor()}
   *   <li>{@link DataDefinition#newBuilder()}
   *   <li>{@link DataDefinition#newBuilder(DataDefinition)}
   *   <li>{@link DataDefinition#newBuilderForType()}
   *   <li>{@link DataDefinition#toBuilder()}
   *   <li>{@link DataDefinition#getParserForType()}
   *   <li>{@link DataDefinition#getSchemaIdOrBuilder()}
   *   <li>{@link DataDefinition#getSchemaOrBuilder()}
   *   <li>{@link DataDefinition#getStorageIdOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DataDefinition actualDefaultInstance = DataDefinition.getDefaultInstance();
    DataDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    DataDefinition prototype = DataDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    TagSelectorOrBuilder actualSchemaIdOrBuilder = actualDefaultInstance.getSchemaIdOrBuilder();
    SchemaDefinitionOrBuilder actualSchemaOrBuilder = actualDefaultInstance.getSchemaOrBuilder();
    TagSelectorOrBuilder actualStorageIdOrBuilder = actualDefaultInstance.getStorageIdOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getSchema(), actualSchemaOrBuilder);
    TagSelector schemaId = actualDefaultInstance.getSchemaId();
    assertSame(schemaId, actualSchemaIdOrBuilder);
    assertSame(schemaId, actualStorageIdOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Part#equals(Object)}
   *   <li>{@link DataDefinition.Part#hashCode()}
   * </ul>
   */
  @Test
  void testPartEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDefinition.Part defaultInstance = DataDefinition.Part.getDefaultInstance();
    DataDefinition.Part defaultInstance2 = DataDefinition.Part.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Part#equals(Object)}
   *   <li>{@link DataDefinition.Part#hashCode()}
   * </ul>
   */
  @Test
  void testPartEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDefinition.Part defaultInstance = DataDefinition.Part.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DataDefinition.Part#equals(Object)}
   */
  @Test
  void testPartEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Part.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DataDefinition.Part#equals(Object)}
   */
  @Test
  void testPartEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Part.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DataDefinition.Part#equals(Object)}
   */
  @Test
  void testPartEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Part.getDefaultInstance(), "Different type to Part");
  }

  /**
   * Method under test: {@link DataDefinition.Part#getDefaultInstanceForType()}
   */
  @Test
  void testPartGetDefaultInstanceForType() {
    // Arrange
    DataDefinition.Part defaultInstance = DataDefinition.Part.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DataDefinition.Part#getSerializedSize()}
   */
  @Test
  void testPartGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.Part.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Part#getDefaultInstance()}
   *   <li>{@link DataDefinition.Part#getDescriptor()}
   *   <li>{@link DataDefinition.Part#newBuilder()}
   *   <li>{@link DataDefinition.Part#newBuilder(DataDefinition.Part)}
   *   <li>{@link DataDefinition.Part#newBuilderForType()}
   *   <li>{@link DataDefinition.Part#toBuilder()}
   *   <li>{@link DataDefinition.Part#getParserForType()}
   *   <li>{@link DataDefinition.Part#getPartKeyOrBuilder()}
   *   <li>{@link DataDefinition.Part#getSnapOrBuilder()}
   * </ul>
   */
  @Test
  void testPartGettersAndSetters() {
    // Arrange and Act
    DataDefinition.Part actualDefaultInstance = DataDefinition.Part.getDefaultInstance();
    DataDefinition.Part actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    DataDefinition.Part prototype = DataDefinition.Part.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    PartKeyOrBuilder actualPartKeyOrBuilder = actualDefaultInstance.getPartKeyOrBuilder();
    DataDefinition.SnapOrBuilder actualSnapOrBuilder = actualDefaultInstance.getSnapOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getPartKey(), actualPartKeyOrBuilder);
    assertSame(actualDefaultInstance.getSnap(), actualSnapOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link DataDefinition.Part#hasPartKey()}
   */
  @Test
  void testPartHasPartKey() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.Part.getDefaultInstance().hasPartKey());
  }

  /**
   * Method under test: {@link DataDefinition.Part#hasSnap()}
   */
  @Test
  void testPartHasSnap() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.Part.getDefaultInstance().hasSnap());
  }

  /**
   * Method under test: {@link DataDefinition.Part#isInitialized()}
   */
  @Test
  void testPartIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.Part.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPartParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Part.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPartParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Part.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPartParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Part.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPartParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPartParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPartParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition.Part#parseFrom(InputStream)}
   */
  @Test
  void testPartParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Part.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition.Part#parseFrom(InputStream)}
   */
  @Test
  void testPartParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Part.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPartParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Part#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPartParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition.SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  void testSchemaSpecifierCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(DataDefinition.SchemaSpecifierCase.forNumber(42));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataDefinition.SchemaSpecifierCase.forNumber(0));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMAID, DataDefinition.SchemaSpecifierCase.forNumber(1));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMA, DataDefinition.SchemaSpecifierCase.forNumber(2));
  }

  /**
   * Method under test: {@link DataDefinition.SchemaSpecifierCase#getNumber()}
   */
  @Test
  void testSchemaSpecifierCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, DataDefinition.SchemaSpecifierCase.valueOf("SCHEMAID").getNumber());
  }

  /**
   * Method under test: {@link DataDefinition.SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  void testSchemaSpecifierCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(DataDefinition.SchemaSpecifierCase.valueOf(42));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataDefinition.SchemaSpecifierCase.valueOf(0));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMAID, DataDefinition.SchemaSpecifierCase.valueOf(1));
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMA, DataDefinition.SchemaSpecifierCase.valueOf(2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Snap#equals(Object)}
   *   <li>{@link DataDefinition.Snap#hashCode()}
   * </ul>
   */
  @Test
  void testSnapEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDefinition.Snap defaultInstance = DataDefinition.Snap.getDefaultInstance();
    DataDefinition.Snap defaultInstance2 = DataDefinition.Snap.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Snap#equals(Object)}
   *   <li>{@link DataDefinition.Snap#hashCode()}
   * </ul>
   */
  @Test
  void testSnapEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDefinition.Snap defaultInstance = DataDefinition.Snap.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DataDefinition.Snap#equals(Object)}
   */
  @Test
  void testSnapEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Snap.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DataDefinition.Snap#equals(Object)}
   */
  @Test
  void testSnapEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Snap.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DataDefinition.Snap#equals(Object)}
   */
  @Test
  void testSnapEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.Snap.getDefaultInstance(), "Different type to Snap");
  }

  /**
   * Method under test: {@link DataDefinition.Snap#getDefaultInstanceForType()}
   */
  @Test
  void testSnapGetDefaultInstanceForType() {
    // Arrange
    DataDefinition.Snap defaultInstance = DataDefinition.Snap.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DataDefinition.Snap#getDeltasCount()}
   */
  @Test
  void testSnapGetDeltasCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.Snap.getDefaultInstance().getDeltasCount());
  }

  /**
   * Method under test: {@link DataDefinition.Snap#getSerializedSize()}
   */
  @Test
  void testSnapGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.Snap.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition.Snap#getDefaultInstance()}
   *   <li>{@link DataDefinition.Snap#getDescriptor()}
   *   <li>{@link DataDefinition.Snap#newBuilder()}
   *   <li>{@link DataDefinition.Snap#newBuilder(DataDefinition.Snap)}
   *   <li>{@link DataDefinition.Snap#newBuilderForType()}
   *   <li>{@link DataDefinition.Snap#toBuilder()}
   *   <li>{@link DataDefinition.Snap#getDeltasList()}
   *   <li>{@link DataDefinition.Snap#getDeltasOrBuilderList()}
   *   <li>{@link DataDefinition.Snap#getParserForType()}
   *   <li>{@link DataDefinition.Snap#getSnapIndex()}
   * </ul>
   */
  @Test
  void testSnapGettersAndSetters() {
    // Arrange and Act
    DataDefinition.Snap actualDefaultInstance = DataDefinition.Snap.getDefaultInstance();
    DataDefinition.Snap actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    DataDefinition.Snap prototype = DataDefinition.Snap.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<DataDefinition.Delta> actualDeltasList = actualDefaultInstance.getDeltasList();
    List<? extends DataDefinition.DeltaOrBuilder> actualDeltasOrBuilderList = actualDefaultInstance
        .getDeltasOrBuilderList();
    actualDefaultInstance.getParserForType();
    int actualSnapIndex = actualDefaultInstance.getSnapIndex();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualSnapIndex);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualDeltasList);
    assertSame(uninterpretedOptionList, actualDeltasOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link DataDefinition.Snap#isInitialized()}
   */
  @Test
  void testSnapIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.Snap.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testSnapParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Snap.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testSnapParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Snap.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testSnapParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Snap.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testSnapParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testSnapParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testSnapParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataDefinition.Snap#parseFrom(InputStream)}
   */
  @Test
  void testSnapParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.Snap.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataDefinition.Snap#parseFrom(InputStream)}
   */
  @Test
  void testSnapParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.Snap.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testSnapParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.Snap.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataDefinition.Snap#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testSnapParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.Snap.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}

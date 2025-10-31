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

class PartKeyDiffblueTest {
  /**
   * Method under test: {@link PartKey#getOpaqueKey()}
   */
  @Test
  void testGetOpaqueKey() {
    // Arrange, Act and Assert
    assertEquals("", PartKey.getDefaultInstance().getOpaqueKey());
  }

  /**
   * Method under test: {@link PartKey#getOpaqueKeyBytes()}
   */
  @Test
  void testGetOpaqueKeyBytes() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act
    ByteString actualOpaqueKeyBytes = defaultInstance.getOpaqueKeyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    ByteString byteString = actualOpaqueKeyBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(4).toProto();
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
    assertEquals(byteString, actualOpaqueKeyBytes);
  }

  /**
   * Method under test: {@link PartKey#getPartType()}
   */
  @Test
  void testGetPartType() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, PartKey.getDefaultInstance().getPartType());
  }

  /**
   * Method under test: {@link PartKey#getPartValuesCount()}
   */
  @Test
  void testGetPartValuesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PartKey.getDefaultInstance().getPartValuesCount());
  }

  /**
   * Method under test: {@link PartKey#hasPartRangeMin()}
   */
  @Test
  void testHasPartRangeMin() {
    // Arrange, Act and Assert
    assertFalse(PartKey.getDefaultInstance().hasPartRangeMin());
  }

  /**
   * Method under test: {@link PartKey#hasPartRangeMax()}
   */
  @Test
  void testHasPartRangeMax() {
    // Arrange, Act and Assert
    assertFalse(PartKey.getDefaultInstance().hasPartRangeMax());
  }

  /**
   * Method under test: {@link PartKey#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PartKey.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link PartKey#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PartKey.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartKey#equals(Object)}
   *   <li>{@link PartKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();
    PartKey defaultInstance2 = PartKey.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartKey#equals(Object)}
   *   <li>{@link PartKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PartKey.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PartKey.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PartKey.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link PartKey#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), "Different type to PartKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartKey#getDefaultInstance()}
   *   <li>{@link PartKey#getDescriptor()}
   *   <li>{@link PartKey#newBuilder()}
   *   <li>{@link PartKey#newBuilder(PartKey)}
   *   <li>{@link PartKey#newBuilderForType()}
   *   <li>{@link PartKey#toBuilder()}
   *   <li>{@link PartKey#getParserForType()}
   *   <li>{@link PartKey#getPartRangeMaxOrBuilder()}
   *   <li>{@link PartKey#getPartRangeMinOrBuilder()}
   *   <li>{@link PartKey#getPartTypeValue()}
   *   <li>{@link PartKey#getPartValuesList()}
   *   <li>{@link PartKey#getPartValuesOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PartKey actualDefaultInstance = PartKey.getDefaultInstance();
    PartKey actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    PartKey prototype = PartKey.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    ValueOrBuilder actualPartRangeMaxOrBuilder = actualDefaultInstance.getPartRangeMaxOrBuilder();
    ValueOrBuilder actualPartRangeMinOrBuilder = actualDefaultInstance.getPartRangeMinOrBuilder();
    int actualPartTypeValue = actualDefaultInstance.getPartTypeValue();
    List<Value> actualPartValuesList = actualDefaultInstance.getPartValuesList();
    List<? extends ValueOrBuilder> actualPartValuesOrBuilderList = actualDefaultInstance.getPartValuesOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualPartTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualPartValuesList);
    assertSame(uninterpretedOptionList, actualPartValuesOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    Value partRangeMax = actualDefaultInstance.getPartRangeMax();
    assertSame(partRangeMax, actualPartRangeMaxOrBuilder);
    assertSame(partRangeMax, actualPartRangeMinOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

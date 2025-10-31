package org.finos.tracdap.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class MetadataWriteBatchRequestDiffblueTest {
  /**
   * Method under test: {@link MetadataWriteBatchRequest#getTenant()}
   */
  @Test
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", MetadataWriteBatchRequest.getDefaultInstance().getTenant());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getTenantBytes()}
   */
  @Test
  void testGetTenantBytes() {
    // Arrange
    MetadataWriteBatchRequest defaultInstance = MetadataWriteBatchRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualTenantBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(4).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(5).toProto();
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
    assertEquals(byteString, actualTenantBytes);
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getCreateObjectsCount()}
   */
  @Test
  void testGetCreateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getCreateObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getUpdateObjectsCount()}
   */
  @Test
  void testGetUpdateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getUpdateObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getUpdateTagsCount()}
   */
  @Test
  void testGetUpdateTagsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getUpdateTagsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getPreallocateIdsCount()}
   */
  @Test
  void testGetPreallocateIdsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getPreallocateIdsCount());
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#getCreatePreallocatedObjectsCount()}
   */
  @Test
  void testGetCreatePreallocatedObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getCreatePreallocatedObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataWriteBatchRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchRequest#equals(Object)}
   *   <li>{@link MetadataWriteBatchRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchRequest defaultInstance = MetadataWriteBatchRequest.getDefaultInstance();
    MetadataWriteBatchRequest defaultInstance2 = MetadataWriteBatchRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchRequest#equals(Object)}
   *   <li>{@link MetadataWriteBatchRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchRequest defaultInstance = MetadataWriteBatchRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteBatchRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataWriteBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> MetadataWriteBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MetadataWriteBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataWriteBatchRequest defaultInstance = MetadataWriteBatchRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MetadataWriteBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchRequest.getDefaultInstance(), "Different type to MetadataWriteBatchRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchRequest#getDefaultInstance()}
   *   <li>{@link MetadataWriteBatchRequest#getDescriptor()}
   *   <li>{@link MetadataWriteBatchRequest#newBuilder()}
   *   <li>{@link MetadataWriteBatchRequest#newBuilder(MetadataWriteBatchRequest)}
   *   <li>{@link MetadataWriteBatchRequest#newBuilderForType()}
   *   <li>{@link MetadataWriteBatchRequest#toBuilder()}
   *   <li>{@link MetadataWriteBatchRequest#getCreateObjectsList()}
   *   <li>{@link MetadataWriteBatchRequest#getCreateObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchRequest#getCreatePreallocatedObjectsList()}
   *   <li>
   * {@link MetadataWriteBatchRequest#getCreatePreallocatedObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchRequest#getParserForType()}
   *   <li>{@link MetadataWriteBatchRequest#getPreallocateIdsList()}
   *   <li>{@link MetadataWriteBatchRequest#getPreallocateIdsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchRequest#getUpdateObjectsList()}
   *   <li>{@link MetadataWriteBatchRequest#getUpdateObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchRequest#getUpdateTagsList()}
   *   <li>{@link MetadataWriteBatchRequest#getUpdateTagsOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MetadataWriteBatchRequest actualDefaultInstance = MetadataWriteBatchRequest.getDefaultInstance();
    MetadataWriteBatchRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    MetadataWriteBatchRequest prototype = MetadataWriteBatchRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<MetadataWriteRequest> actualCreateObjectsList = actualDefaultInstance.getCreateObjectsList();
    List<? extends MetadataWriteRequestOrBuilder> actualCreateObjectsOrBuilderList = actualDefaultInstance
        .getCreateObjectsOrBuilderList();
    List<MetadataWriteRequest> actualCreatePreallocatedObjectsList = actualDefaultInstance
        .getCreatePreallocatedObjectsList();
    List<? extends MetadataWriteRequestOrBuilder> actualCreatePreallocatedObjectsOrBuilderList = actualDefaultInstance
        .getCreatePreallocatedObjectsOrBuilderList();
    actualDefaultInstance.getParserForType();
    List<MetadataWriteRequest> actualPreallocateIdsList = actualDefaultInstance.getPreallocateIdsList();
    List<? extends MetadataWriteRequestOrBuilder> actualPreallocateIdsOrBuilderList = actualDefaultInstance
        .getPreallocateIdsOrBuilderList();
    List<MetadataWriteRequest> actualUpdateObjectsList = actualDefaultInstance.getUpdateObjectsList();
    List<? extends MetadataWriteRequestOrBuilder> actualUpdateObjectsOrBuilderList = actualDefaultInstance
        .getUpdateObjectsOrBuilderList();
    List<MetadataWriteRequest> actualUpdateTagsList = actualDefaultInstance.getUpdateTagsList();
    List<? extends MetadataWriteRequestOrBuilder> actualUpdateTagsOrBuilderList = actualDefaultInstance
        .getUpdateTagsOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualCreateObjectsList);
    assertSame(uninterpretedOptionList, actualCreateObjectsOrBuilderList);
    assertSame(uninterpretedOptionList, actualCreatePreallocatedObjectsList);
    assertSame(uninterpretedOptionList, actualCreatePreallocatedObjectsOrBuilderList);
    assertSame(uninterpretedOptionList, actualPreallocateIdsList);
    assertSame(uninterpretedOptionList, actualPreallocateIdsOrBuilderList);
    assertSame(uninterpretedOptionList, actualUpdateObjectsList);
    assertSame(uninterpretedOptionList, actualUpdateObjectsOrBuilderList);
    assertSame(uninterpretedOptionList, actualUpdateTagsList);
    assertSame(uninterpretedOptionList, actualUpdateTagsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

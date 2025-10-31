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
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelectorOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataBatchRequestDiffblueTest {
  /**
   * Method under test: {@link MetadataBatchRequest#getTenant()}
   */
  @Test
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", MetadataBatchRequest.getDefaultInstance().getTenant());
  }

  /**
   * Method under test: {@link MetadataBatchRequest#getTenantBytes()}
   */
  @Test
  void testGetTenantBytes() {
    // Arrange
    MetadataBatchRequest defaultInstance = MetadataBatchRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualTenantBytes.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, getResult.getOptions().getFeatureSupport().getDeprecationWarningBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualTenantBytes);
  }

  /**
   * Method under test: {@link MetadataBatchRequest#getSelectorCount()}
   */
  @Test
  void testGetSelectorCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataBatchRequest.getDefaultInstance().getSelectorCount());
  }

  /**
   * Method under test: {@link MetadataBatchRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataBatchRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link MetadataBatchRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataBatchRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBatchRequest#equals(Object)}
   *   <li>{@link MetadataBatchRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetadataBatchRequest defaultInstance = MetadataBatchRequest.getDefaultInstance();
    MetadataBatchRequest defaultInstance2 = MetadataBatchRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBatchRequest#equals(Object)}
   *   <li>{@link MetadataBatchRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataBatchRequest defaultInstance = MetadataBatchRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MetadataBatchRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataBatchRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link MetadataBatchRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataBatchRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataBatchRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataBatchRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataBatchRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataBatchRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> MetadataBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataBatchRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MetadataBatchRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link MetadataBatchRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataBatchRequest defaultInstance = MetadataBatchRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MetadataBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataBatchRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MetadataBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataBatchRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MetadataBatchRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataBatchRequest.getDefaultInstance(), "Different type to MetadataBatchRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBatchRequest#getDefaultInstance()}
   *   <li>{@link MetadataBatchRequest#getDescriptor()}
   *   <li>{@link MetadataBatchRequest#newBuilder()}
   *   <li>{@link MetadataBatchRequest#newBuilder(MetadataBatchRequest)}
   *   <li>{@link MetadataBatchRequest#newBuilderForType()}
   *   <li>{@link MetadataBatchRequest#toBuilder()}
   *   <li>{@link MetadataBatchRequest#getParserForType()}
   *   <li>{@link MetadataBatchRequest#getSelectorList()}
   *   <li>{@link MetadataBatchRequest#getSelectorOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MetadataBatchRequest actualDefaultInstance = MetadataBatchRequest.getDefaultInstance();
    MetadataBatchRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    MetadataBatchRequest prototype = MetadataBatchRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    List<TagSelector> actualSelectorList = actualDefaultInstance.getSelectorList();
    List<? extends TagSelectorOrBuilder> actualSelectorOrBuilderList = actualDefaultInstance.getSelectorOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualSelectorList);
    assertSame(uninterpretedOptionList, actualSelectorOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

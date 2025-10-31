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
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagHeaderOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteBatchResponseDiffblueTest {
  /**
   * Method under test: {@link MetadataWriteBatchResponse#getCreateObjectsCount()}
   */
  @Test
  void testGetCreateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getCreateObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#getUpdateObjectsCount()}
   */
  @Test
  void testGetUpdateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getUpdateObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#getUpdateTagsCount()}
   */
  @Test
  void testGetUpdateTagsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getUpdateTagsCount());
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#getPreallocateIdsCount()}
   */
  @Test
  void testGetPreallocateIdsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getPreallocateIdsCount());
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#getCreatePreallocatedObjectsCount()}
   */
  @Test
  void testGetCreatePreallocatedObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getCreatePreallocatedObjectsCount());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataWriteBatchResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchResponse#equals(Object)}
   *   <li>{@link MetadataWriteBatchResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();
    MetadataWriteBatchResponse defaultInstance2 = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchResponse#equals(Object)}
   *   <li>{@link MetadataWriteBatchResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteBatchResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteBatchResponse#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), "Different type to MetadataWriteBatchResponse");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchResponse#getDefaultInstance()}
   *   <li>{@link MetadataWriteBatchResponse#getDescriptor()}
   *   <li>{@link MetadataWriteBatchResponse#newBuilder()}
   *   <li>{@link MetadataWriteBatchResponse#newBuilder(MetadataWriteBatchResponse)}
   *   <li>{@link MetadataWriteBatchResponse#newBuilderForType()}
   *   <li>{@link MetadataWriteBatchResponse#toBuilder()}
   *   <li>{@link MetadataWriteBatchResponse#getCreateObjectsList()}
   *   <li>{@link MetadataWriteBatchResponse#getCreateObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchResponse#getCreatePreallocatedObjectsList()}
   *   <li>
   * {@link MetadataWriteBatchResponse#getCreatePreallocatedObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchResponse#getParserForType()}
   *   <li>{@link MetadataWriteBatchResponse#getPreallocateIdsList()}
   *   <li>{@link MetadataWriteBatchResponse#getPreallocateIdsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchResponse#getUpdateObjectsList()}
   *   <li>{@link MetadataWriteBatchResponse#getUpdateObjectsOrBuilderList()}
   *   <li>{@link MetadataWriteBatchResponse#getUpdateTagsList()}
   *   <li>{@link MetadataWriteBatchResponse#getUpdateTagsOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MetadataWriteBatchResponse actualDefaultInstance = MetadataWriteBatchResponse.getDefaultInstance();
    MetadataWriteBatchResponse actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    MetadataWriteBatchResponse prototype = MetadataWriteBatchResponse.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<TagHeader> actualCreateObjectsList = actualDefaultInstance.getCreateObjectsList();
    List<? extends TagHeaderOrBuilder> actualCreateObjectsOrBuilderList = actualDefaultInstance
        .getCreateObjectsOrBuilderList();
    List<TagHeader> actualCreatePreallocatedObjectsList = actualDefaultInstance.getCreatePreallocatedObjectsList();
    List<? extends TagHeaderOrBuilder> actualCreatePreallocatedObjectsOrBuilderList = actualDefaultInstance
        .getCreatePreallocatedObjectsOrBuilderList();
    actualDefaultInstance.getParserForType();
    List<TagHeader> actualPreallocateIdsList = actualDefaultInstance.getPreallocateIdsList();
    List<? extends TagHeaderOrBuilder> actualPreallocateIdsOrBuilderList = actualDefaultInstance
        .getPreallocateIdsOrBuilderList();
    List<TagHeader> actualUpdateObjectsList = actualDefaultInstance.getUpdateObjectsList();
    List<? extends TagHeaderOrBuilder> actualUpdateObjectsOrBuilderList = actualDefaultInstance
        .getUpdateObjectsOrBuilderList();
    List<TagHeader> actualUpdateTagsList = actualDefaultInstance.getUpdateTagsList();
    List<? extends TagHeaderOrBuilder> actualUpdateTagsOrBuilderList = actualDefaultInstance
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

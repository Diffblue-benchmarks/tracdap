package org.finos.tracdap.api;

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
import org.finos.tracdap.metadata.TagSelectorOrBuilder;
import org.finos.tracdap.metadata.TagUpdate;
import org.finos.tracdap.metadata.TagUpdateOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileWriteRequestDiffblueTest {
  /**
   * Method under test: {@link FileWriteRequest#getTenant()}
   */
  @Test
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", FileWriteRequest.getDefaultInstance().getTenant());
  }

  /**
   * Method under test: {@link FileWriteRequest#getTenantBytes()}
   */
  @Test
  void testGetTenantBytes() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualTenantBytes.EMPTY;
    assertEquals(byteString, actualTenantBytes);
    assertSame(byteString, fields.get(6).getDefaultValue());
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Method under test: {@link FileWriteRequest#hasPriorVersion()}
   */
  @Test
  void testHasPriorVersion() {
    // Arrange, Act and Assert
    assertFalse(FileWriteRequest.getDefaultInstance().hasPriorVersion());
  }

  /**
   * Method under test: {@link FileWriteRequest#getTagUpdatesCount()}
   */
  @Test
  void testGetTagUpdatesCount() {
    // Arrange, Act and Assert
    assertEquals(0, FileWriteRequest.getDefaultInstance().getTagUpdatesCount());
  }

  /**
   * Method under test: {@link FileWriteRequest#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", FileWriteRequest.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link FileWriteRequest#getNameBytes()}
   */
  @Test
  void testGetNameBytes() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, actualNameBytes);
    assertSame(byteString, fields.get(6).getDefaultValue());
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Method under test: {@link FileWriteRequest#getMimeType()}
   */
  @Test
  void testGetMimeType() {
    // Arrange, Act and Assert
    assertEquals("", FileWriteRequest.getDefaultInstance().getMimeType());
  }

  /**
   * Method under test: {@link FileWriteRequest#getMimeTypeBytes()}
   */
  @Test
  void testGetMimeTypeBytes() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();

    // Act
    ByteString actualMimeTypeBytes = defaultInstance.getMimeTypeBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualMimeTypeBytes.EMPTY;
    assertEquals(byteString, actualMimeTypeBytes);
    assertSame(byteString, fields.get(6).getDefaultValue());
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Method under test: {@link FileWriteRequest#hasSize()}
   */
  @Test
  void testHasSize() {
    // Arrange, Act and Assert
    assertFalse(FileWriteRequest.getDefaultInstance().hasSize());
  }

  /**
   * Method under test: {@link FileWriteRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FileWriteRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link FileWriteRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FileWriteRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileWriteRequest#equals(Object)}
   *   <li>{@link FileWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();
    FileWriteRequest defaultInstance2 = FileWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileWriteRequest#equals(Object)}
   *   <li>{@link FileWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link FileWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FileWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FileWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FileWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FileWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FileWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FileWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FileWriteRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link FileWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FileWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FileWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FileWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FileWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FileWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FileWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FileWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> FileWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FileWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FileWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FileWriteRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    FileWriteRequest defaultInstance = FileWriteRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link FileWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileWriteRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link FileWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileWriteRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link FileWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileWriteRequest.getDefaultInstance(), "Different type to FileWriteRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileWriteRequest#getDefaultInstance()}
   *   <li>{@link FileWriteRequest#getDescriptor()}
   *   <li>{@link FileWriteRequest#newBuilder()}
   *   <li>{@link FileWriteRequest#newBuilder(FileWriteRequest)}
   *   <li>{@link FileWriteRequest#newBuilderForType()}
   *   <li>{@link FileWriteRequest#toBuilder()}
   *   <li>{@link FileWriteRequest#getContent()}
   *   <li>{@link FileWriteRequest#getParserForType()}
   *   <li>{@link FileWriteRequest#getPriorVersionOrBuilder()}
   *   <li>{@link FileWriteRequest#getSize()}
   *   <li>{@link FileWriteRequest#getTagUpdatesList()}
   *   <li>{@link FileWriteRequest#getTagUpdatesOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FileWriteRequest actualDefaultInstance = FileWriteRequest.getDefaultInstance();
    FileWriteRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    FileWriteRequest prototype = FileWriteRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    ByteString actualContent = actualDefaultInstance.getContent();
    actualDefaultInstance.getParserForType();
    TagSelectorOrBuilder actualPriorVersionOrBuilder = actualDefaultInstance.getPriorVersionOrBuilder();
    long actualSize = actualDefaultInstance.getSize();
    List<TagUpdate> actualTagUpdatesList = actualDefaultInstance.getTagUpdatesList();
    List<? extends TagUpdateOrBuilder> actualTagUpdatesOrBuilderList = actualDefaultInstance
        .getTagUpdatesOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0L, actualSize);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualTagUpdatesList);
    assertSame(uninterpretedOptionList, actualTagUpdatesOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(actualDefaultInstance.getPriorVersion(), actualPriorVersionOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
    assertSame(actualContent.EMPTY, actualContent);
  }
}

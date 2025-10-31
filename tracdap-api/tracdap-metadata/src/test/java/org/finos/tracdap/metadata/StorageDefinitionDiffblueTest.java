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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link StorageDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> StorageDefinition.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test:
   * {@link StorageDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = StorageDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link StorageDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = StorageDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link StorageDefinition#getDataItemsCount()}
   */
  @Test
  void testGetDataItemsCount() {
    // Arrange, Act and Assert
    assertEquals(0, StorageDefinition.getDefaultInstance().getDataItemsCount());
  }

  /**
   * Method under test: {@link StorageDefinition#containsDataItems(String)}
   */
  @Test
  void testContainsDataItems() {
    // Arrange, Act and Assert
    assertFalse(StorageDefinition.getDefaultInstance().containsDataItems("Key"));
  }

  /**
   * Method under test: {@link StorageDefinition#getDataItems()}
   */
  @Test
  void testGetDataItems() {
    // Arrange, Act and Assert
    assertTrue(StorageDefinition.getDefaultInstance().getDataItems().isEmpty());
  }

  /**
   * Method under test: {@link StorageDefinition#getDataItemsMap()}
   */
  @Test
  void testGetDataItemsMap() {
    // Arrange, Act and Assert
    assertTrue(StorageDefinition.getDefaultInstance().getDataItemsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link StorageDefinition#getDataItemsOrDefault(String, StorageItem)}
   */
  @Test
  void testGetDataItemsOrDefault() {
    // Arrange
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();
    StorageItem defaultValue = StorageItem.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getDataItemsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link StorageDefinition#getDataItemsOrThrow(String)}
   */
  @Test
  void testGetDataItemsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> StorageDefinition.getDefaultInstance().getDataItemsOrThrow("Key"));
  }

  /**
   * Method under test: {@link StorageDefinition#getStorageOptionsCount()}
   */
  @Test
  void testGetStorageOptionsCount() {
    // Arrange, Act and Assert
    assertEquals(0, StorageDefinition.getDefaultInstance().getStorageOptionsCount());
  }

  /**
   * Method under test: {@link StorageDefinition#containsStorageOptions(String)}
   */
  @Test
  void testContainsStorageOptions() {
    // Arrange, Act and Assert
    assertFalse(StorageDefinition.getDefaultInstance().containsStorageOptions("Key"));
  }

  /**
   * Method under test: {@link StorageDefinition#getStorageOptions()}
   */
  @Test
  void testGetStorageOptions() {
    // Arrange, Act and Assert
    assertTrue(StorageDefinition.getDefaultInstance().getStorageOptions().isEmpty());
  }

  /**
   * Method under test: {@link StorageDefinition#getStorageOptionsMap()}
   */
  @Test
  void testGetStorageOptionsMap() {
    // Arrange, Act and Assert
    assertTrue(StorageDefinition.getDefaultInstance().getStorageOptionsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link StorageDefinition#getStorageOptionsOrDefault(String, Value)}
   */
  @Test
  void testGetStorageOptionsOrDefault() {
    // Arrange
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getStorageOptionsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link StorageDefinition#getStorageOptionsOrThrow(String)}
   */
  @Test
  void testGetStorageOptionsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> StorageDefinition.getDefaultInstance().getStorageOptionsOrThrow("Key"));
  }

  /**
   * Method under test: {@link StorageDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link StorageDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageDefinition#equals(Object)}
   *   <li>{@link StorageDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();
    StorageDefinition defaultInstance2 = StorageDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageDefinition#equals(Object)}
   *   <li>{@link StorageDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link StorageDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link StorageDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link StorageDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link StorageDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StorageDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link StorageDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link StorageDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> StorageDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> StorageDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link StorageDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link StorageDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link StorageDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link StorageDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageDefinition.getDefaultInstance(), "Different type to StorageDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageDefinition#getDefaultInstance()}
   *   <li>{@link StorageDefinition#getDescriptor()}
   *   <li>{@link StorageDefinition#newBuilder()}
   *   <li>{@link StorageDefinition#newBuilder(StorageDefinition)}
   *   <li>{@link StorageDefinition#newBuilderForType()}
   *   <li>{@link StorageDefinition#toBuilder()}
   *   <li>{@link StorageDefinition#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StorageDefinition actualDefaultInstance = StorageDefinition.getDefaultInstance();
    StorageDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    StorageDefinition prototype = StorageDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

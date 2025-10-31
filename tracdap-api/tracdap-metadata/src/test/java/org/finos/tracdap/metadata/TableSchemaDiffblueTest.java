package org.finos.tracdap.metadata;

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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TableSchemaDiffblueTest {
  /**
   * Method under test: {@link TableSchema#getFieldsCount()}
   */
  @Test
  void testGetFieldsCount() {
    // Arrange, Act and Assert
    assertEquals(0, TableSchema.getDefaultInstance().getFieldsCount());
  }

  /**
   * Method under test: {@link TableSchema#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TableSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link TableSchema#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TableSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableSchema#equals(Object)}
   *   <li>{@link TableSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TableSchema defaultInstance = TableSchema.getDefaultInstance();
    TableSchema defaultInstance2 = TableSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableSchema#equals(Object)}
   *   <li>{@link TableSchema#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TableSchema defaultInstance = TableSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TableSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TableSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link TableSchema#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TableSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TableSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TableSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TableSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TableSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link TableSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TableSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link TableSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TableSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TableSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TableSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TableSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TableSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TableSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TableSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TableSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> TableSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TableSchema#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    TableSchema defaultInstance = TableSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TableSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TableSchema.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TableSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TableSchema.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TableSchema#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TableSchema.getDefaultInstance(), "Different type to TableSchema");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableSchema#getDefaultInstance()}
   *   <li>{@link TableSchema#getDescriptor()}
   *   <li>{@link TableSchema#newBuilder()}
   *   <li>{@link TableSchema#newBuilder(TableSchema)}
   *   <li>{@link TableSchema#newBuilderForType()}
   *   <li>{@link TableSchema#toBuilder()}
   *   <li>{@link TableSchema#getFieldsList()}
   *   <li>{@link TableSchema#getFieldsOrBuilderList()}
   *   <li>{@link TableSchema#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TableSchema actualDefaultInstance = TableSchema.getDefaultInstance();
    TableSchema actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    TableSchema prototype = TableSchema.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<FieldSchema> actualFieldsList = actualDefaultInstance.getFieldsList();
    List<? extends FieldSchemaOrBuilder> actualFieldsOrBuilderList = actualDefaultInstance.getFieldsOrBuilderList();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualFieldsList);
    assertSame(uninterpretedOptionList, actualFieldsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

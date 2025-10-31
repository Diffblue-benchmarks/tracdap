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
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaDefinitionDiffblueTest {
  /**
   * Method under test: {@link SchemaDefinition#getSchemaDetailsCase()}
   */
  @Test
  void testGetSchemaDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET,
        SchemaDefinition.getDefaultInstance().getSchemaDetailsCase());
  }

  /**
   * Method under test: {@link SchemaDefinition#getSchemaType()}
   */
  @Test
  void testGetSchemaType() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaDefinition.getDefaultInstance().getSchemaType());
  }

  /**
   * Method under test: {@link SchemaDefinition#getPartType()}
   */
  @Test
  void testGetPartType() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, SchemaDefinition.getDefaultInstance().getPartType());
  }

  /**
   * Method under test: {@link SchemaDefinition#hasTable()}
   */
  @Test
  void testHasTable() {
    // Arrange, Act and Assert
    assertFalse(SchemaDefinition.getDefaultInstance().hasTable());
  }

  /**
   * Method under test: {@link SchemaDefinition#hasStruct()}
   */
  @Test
  void testHasStruct() {
    // Arrange, Act and Assert
    assertFalse(SchemaDefinition.getDefaultInstance().hasStruct());
  }

  /**
   * Method under test: {@link SchemaDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SchemaDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link SchemaDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SchemaDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaDefinition#equals(Object)}
   *   <li>{@link SchemaDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();
    SchemaDefinition defaultInstance2 = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaDefinition#equals(Object)}
   *   <li>{@link SchemaDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SchemaDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SchemaDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SchemaDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SchemaDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SchemaDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SchemaDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SchemaDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SchemaDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SchemaDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> SchemaDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link SchemaDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), "Different type to SchemaDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaDefinition#getDefaultInstance()}
   *   <li>{@link SchemaDefinition#getDescriptor()}
   *   <li>{@link SchemaDefinition#newBuilder()}
   *   <li>{@link SchemaDefinition#newBuilder(SchemaDefinition)}
   *   <li>{@link SchemaDefinition#newBuilderForType()}
   *   <li>{@link SchemaDefinition#toBuilder()}
   *   <li>{@link SchemaDefinition#getParserForType()}
   *   <li>{@link SchemaDefinition#getPartTypeValue()}
   *   <li>{@link SchemaDefinition#getSchemaTypeValue()}
   *   <li>{@link SchemaDefinition#getStructOrBuilder()}
   *   <li>{@link SchemaDefinition#getTableOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SchemaDefinition actualDefaultInstance = SchemaDefinition.getDefaultInstance();
    SchemaDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    SchemaDefinition prototype = SchemaDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    int actualPartTypeValue = actualDefaultInstance.getPartTypeValue();
    int actualSchemaTypeValue = actualDefaultInstance.getSchemaTypeValue();
    StructSchemaOrBuilder actualStructOrBuilder = actualDefaultInstance.getStructOrBuilder();
    TableSchemaOrBuilder actualTableOrBuilder = actualDefaultInstance.getTableOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualPartTypeValue);
    assertEquals(0, actualSchemaTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getStruct(), actualStructOrBuilder);
    assertSame(actualDefaultInstance.getTable(), actualTableOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link SchemaDefinition.SchemaDetailsCase#forNumber(int)}
   */
  @Test
  void testSchemaDetailsCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SchemaDefinition.SchemaDetailsCase.forNumber(42));
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET,
        SchemaDefinition.SchemaDetailsCase.forNumber(0));
    assertEquals(SchemaDefinition.SchemaDetailsCase.TABLE, SchemaDefinition.SchemaDetailsCase.forNumber(3));
    assertEquals(SchemaDefinition.SchemaDetailsCase.STRUCT, SchemaDefinition.SchemaDetailsCase.forNumber(4));
  }

  /**
   * Method under test: {@link SchemaDefinition.SchemaDetailsCase#getNumber()}
   */
  @Test
  void testSchemaDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, SchemaDefinition.SchemaDetailsCase.valueOf("TABLE").getNumber());
  }

  /**
   * Method under test: {@link SchemaDefinition.SchemaDetailsCase#valueOf(int)}
   */
  @Test
  void testSchemaDetailsCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SchemaDefinition.SchemaDetailsCase.valueOf(42));
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET,
        SchemaDefinition.SchemaDetailsCase.valueOf(0));
    assertEquals(SchemaDefinition.SchemaDetailsCase.TABLE, SchemaDefinition.SchemaDetailsCase.valueOf(3));
    assertEquals(SchemaDefinition.SchemaDetailsCase.STRUCT, SchemaDefinition.SchemaDetailsCase.valueOf(4));
  }
}

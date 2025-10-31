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
import org.finos.tracdap.metadata.SchemaDefinitionOrBuilder;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelectorOrBuilder;
import org.finos.tracdap.metadata.TagUpdate;
import org.finos.tracdap.metadata.TagUpdateOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataWriteRequestDiffblueTest {
  /**
   * Method under test: {@link DataWriteRequest#getSchemaSpecifierCase()}
   */
  @Test
  void testGetSchemaSpecifierCase() {
    // Arrange, Act and Assert
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataWriteRequest.getDefaultInstance().getSchemaSpecifierCase());
  }

  /**
   * Method under test: {@link DataWriteRequest#getTenant()}
   */
  @Test
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", DataWriteRequest.getDefaultInstance().getTenant());
  }

  /**
   * Method under test: {@link DataWriteRequest#getTenantBytes()}
   */
  @Test
  void testGetTenantBytes() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

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
   * Method under test: {@link DataWriteRequest#hasPriorVersion()}
   */
  @Test
  void testHasPriorVersion() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasPriorVersion());
  }

  /**
   * Method under test: {@link DataWriteRequest#getTagUpdatesCount()}
   */
  @Test
  void testGetTagUpdatesCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataWriteRequest.getDefaultInstance().getTagUpdatesCount());
  }

  /**
   * Method under test: {@link DataWriteRequest#hasSchemaId()}
   */
  @Test
  void testHasSchemaId() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasSchemaId());
  }

  /**
   * Method under test: {@link DataWriteRequest#hasSchema()}
   */
  @Test
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasSchema());
  }

  /**
   * Method under test: {@link DataWriteRequest#getFormat()}
   */
  @Test
  void testGetFormat() {
    // Arrange, Act and Assert
    assertEquals("", DataWriteRequest.getDefaultInstance().getFormat());
  }

  /**
   * Method under test: {@link DataWriteRequest#getFormatBytes()}
   */
  @Test
  void testGetFormatBytes() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act
    ByteString actualFormatBytes = defaultInstance.getFormatBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualFormatBytes.EMPTY;
    assertEquals(byteString, actualFormatBytes);
    assertSame(byteString, fields.get(6).getDefaultValue());
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Method under test: {@link DataWriteRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataWriteRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link DataWriteRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataWriteRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataWriteRequest#equals(Object)}
   *   <li>{@link DataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();
    DataWriteRequest defaultInstance2 = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataWriteRequest#equals(Object)}
   *   <li>{@link DataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataWriteRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DataWriteRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), "Different type to DataWriteRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataWriteRequest#getDefaultInstance()}
   *   <li>{@link DataWriteRequest#getDescriptor()}
   *   <li>{@link DataWriteRequest#newBuilder()}
   *   <li>{@link DataWriteRequest#newBuilder(DataWriteRequest)}
   *   <li>{@link DataWriteRequest#newBuilderForType()}
   *   <li>{@link DataWriteRequest#toBuilder()}
   *   <li>{@link DataWriteRequest#getContent()}
   *   <li>{@link DataWriteRequest#getParserForType()}
   *   <li>{@link DataWriteRequest#getPriorVersionOrBuilder()}
   *   <li>{@link DataWriteRequest#getSchemaIdOrBuilder()}
   *   <li>{@link DataWriteRequest#getSchemaOrBuilder()}
   *   <li>{@link DataWriteRequest#getTagUpdatesList()}
   *   <li>{@link DataWriteRequest#getTagUpdatesOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DataWriteRequest actualDefaultInstance = DataWriteRequest.getDefaultInstance();
    DataWriteRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    DataWriteRequest prototype = DataWriteRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    ByteString actualContent = actualDefaultInstance.getContent();
    actualDefaultInstance.getParserForType();
    TagSelectorOrBuilder actualPriorVersionOrBuilder = actualDefaultInstance.getPriorVersionOrBuilder();
    TagSelectorOrBuilder actualSchemaIdOrBuilder = actualDefaultInstance.getSchemaIdOrBuilder();
    SchemaDefinitionOrBuilder actualSchemaOrBuilder = actualDefaultInstance.getSchemaOrBuilder();
    List<TagUpdate> actualTagUpdatesList = actualDefaultInstance.getTagUpdatesList();
    List<? extends TagUpdateOrBuilder> actualTagUpdatesOrBuilderList = actualDefaultInstance
        .getTagUpdatesOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualTagUpdatesList);
    assertSame(uninterpretedOptionList, actualTagUpdatesOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    TagSelector priorVersion = actualDefaultInstance.getPriorVersion();
    assertSame(priorVersion, actualPriorVersionOrBuilder);
    assertSame(priorVersion, actualSchemaIdOrBuilder);
    assertSame(actualDefaultInstance.getSchema(), actualSchemaOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
    assertSame(actualContent.EMPTY, actualContent);
  }

  /**
   * Method under test:
   * {@link DataWriteRequest.SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  void testSchemaSpecifierCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(DataWriteRequest.SchemaSpecifierCase.forNumber(42));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataWriteRequest.SchemaSpecifierCase.forNumber(0));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMAID, DataWriteRequest.SchemaSpecifierCase.forNumber(4));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMA, DataWriteRequest.SchemaSpecifierCase.forNumber(5));
  }

  /**
   * Method under test: {@link DataWriteRequest.SchemaSpecifierCase#getNumber()}
   */
  @Test
  void testSchemaSpecifierCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(4, DataWriteRequest.SchemaSpecifierCase.valueOf("SCHEMAID").getNumber());
  }

  /**
   * Method under test: {@link DataWriteRequest.SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  void testSchemaSpecifierCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(DataWriteRequest.SchemaSpecifierCase.valueOf(42));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataWriteRequest.SchemaSpecifierCase.valueOf(0));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMAID, DataWriteRequest.SchemaSpecifierCase.valueOf(4));
    assertEquals(DataWriteRequest.SchemaSpecifierCase.SCHEMA, DataWriteRequest.SchemaSpecifierCase.valueOf(5));
  }
}

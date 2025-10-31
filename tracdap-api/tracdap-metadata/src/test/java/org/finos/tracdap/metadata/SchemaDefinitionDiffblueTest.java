package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaDefinitionDiffblueTest {
  /**
   * Test {@link SchemaDefinition#getSchemaDetailsCase()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getSchemaDetailsCase()}
   */
  @Test
  @DisplayName("Test getSchemaDetailsCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDefinition.getSchemaDetailsCase()"})
  void testGetSchemaDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, SchemaDefinition.getDefaultInstance().getSchemaDetailsCase());
  }

  /**
   * Test {@link SchemaDefinition#getSchemaType()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getSchemaType()}
   */
  @Test
  @DisplayName("Test getSchemaType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaDefinition.getSchemaType()"})
  void testGetSchemaType() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaDefinition.getDefaultInstance().getSchemaType());
  }

  /**
   * Test {@link SchemaDefinition#getPartType()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getPartType()}
   */
  @Test
  @DisplayName("Test getPartType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType SchemaDefinition.getPartType()"})
  void testGetPartType() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, SchemaDefinition.getDefaultInstance().getPartType());
  }

  /**
   * Test {@link SchemaDefinition#hasTable()}.
   * <p>
   * Method under test: {@link SchemaDefinition#hasTable()}
   */
  @Test
  @DisplayName("Test hasTable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.hasTable()"})
  void testHasTable() {
    // Arrange, Act and Assert
    assertFalse(SchemaDefinition.getDefaultInstance().hasTable());
  }

  /**
   * Test {@link SchemaDefinition#getTable()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getTable()}
   */
  @Test
  @DisplayName("Test getTable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TableSchema SchemaDefinition.getTable()"})
  void testGetTable() {
    // Arrange and Act
    TableSchema actualTable = SchemaDefinition.getDefaultInstance().getTable();

    // Assert
    assertEquals("", actualTable.getInitializationErrorString());
    assertEquals(0, actualTable.getFieldsCount());
    assertEquals(0, actualTable.getSerializedSize());
    assertTrue(actualTable.findInitializationErrors().isEmpty());
    List<FieldSchema> fieldsList = actualTable.getFieldsList();
    assertTrue(fieldsList.isEmpty());
    assertTrue(actualTable.getAllFields().isEmpty());
    assertTrue(actualTable.isInitialized());
    assertSame(actualTable, actualTable.getDefaultInstanceForType());
    assertSame(fieldsList, actualTable.getFieldsOrBuilderList());
  }

  /**
   * Test {@link SchemaDefinition#hasStruct()}.
   * <p>
   * Method under test: {@link SchemaDefinition#hasStruct()}
   */
  @Test
  @DisplayName("Test hasStruct()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.hasStruct()"})
  void testHasStruct() {
    // Arrange, Act and Assert
    assertFalse(SchemaDefinition.getDefaultInstance().hasStruct());
  }

  /**
   * Test {@link SchemaDefinition#getStruct()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getStruct()}
   */
  @Test
  @DisplayName("Test getStruct()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructSchema SchemaDefinition.getStruct()"})
  void testGetStruct() {
    // Arrange and Act
    StructSchema actualStruct = SchemaDefinition.getDefaultInstance().getStruct();

    // Assert
    assertEquals("", actualStruct.getInitializationErrorString());
    assertEquals(0, actualStruct.getFieldsCount());
    assertEquals(0, actualStruct.getNamedTypesCount());
    assertEquals(0, actualStruct.getSerializedSize());
    assertTrue(actualStruct.findInitializationErrors().isEmpty());
    assertTrue(actualStruct.getAllFields().isEmpty());
    assertTrue(actualStruct.getFields().isEmpty());
    assertTrue(actualStruct.getFieldsMap().isEmpty());
    assertTrue(actualStruct.getNamedTypes().isEmpty());
    assertTrue(actualStruct.getNamedTypesMap().isEmpty());
    assertTrue(actualStruct.isInitialized());
    assertSame(actualStruct, actualStruct.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#isInitialized()}.
   * <p>
   * Method under test: {@link SchemaDefinition#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SchemaDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link SchemaDefinition#getSerializedSize()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SchemaDefinition.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SchemaDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link SchemaDefinition#equals(Object)}, and {@link SchemaDefinition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaDefinition#equals(Object)}
   *   <li>{@link SchemaDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.equals(Object)", "int SchemaDefinition.hashCode()"})
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
   * Test {@link SchemaDefinition#equals(Object)}, and {@link SchemaDefinition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaDefinition#equals(Object)}
   *   <li>{@link SchemaDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.equals(Object)", "int SchemaDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link SchemaDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.equals(Object)", "int SchemaDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), 1);
  }

  /**
   * Test {@link SchemaDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.equals(Object)", "int SchemaDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), null);
  }

  /**
   * Test {@link SchemaDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SchemaDefinition.equals(Object)", "int SchemaDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SchemaDefinition.getDefaultInstance(), "Different type to SchemaDefinition");
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseFromResult.getSchemaType());
    assertFalse(actualParseFromResult.hasStruct());
    assertFalse(actualParseFromResult.hasTable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SchemaDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SchemaDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SchemaDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    StructSchema struct = actualParseFromResult.getStruct();
    assertSame(unknownFields, struct.getUnknownFields());
    TableSchema table = actualParseFromResult.getTable();
    assertSame(unknownFields, table.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(struct, actualParseFromResult.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table, actualParseFromResult.getTableOrBuilder());
    assertSame(table, table.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SchemaDefinition actualParseFromResult = SchemaDefinition.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    StructSchema struct = actualParseFromResult.getStruct();
    assertSame(unknownFields, struct.getUnknownFields());
    TableSchema table = actualParseFromResult.getTable();
    assertSame(unknownFields, table.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(struct, actualParseFromResult.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table, actualParseFromResult.getTableOrBuilder());
    assertSame(table, table.getDefaultInstanceForType());
  }

  /**
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SchemaDefinition actualParseDelimitedFromResult = SchemaDefinition.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getPartTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(PartType.PART_ROOT, actualParseDelimitedFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseDelimitedFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseDelimitedFromResult.getSchemaType());
    assertFalse(actualParseDelimitedFromResult.hasStruct());
    assertFalse(actualParseDelimitedFromResult.hasTable());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SchemaDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SchemaDefinition actualParseDelimitedFromResult = SchemaDefinition.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getPartTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSchemaTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(PartType.PART_ROOT, actualParseDelimitedFromResult.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualParseDelimitedFromResult.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualParseDelimitedFromResult.getSchemaType());
    assertFalse(actualParseDelimitedFromResult.hasStruct());
    assertFalse(actualParseDelimitedFromResult.hasTable());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SchemaDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link SchemaDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
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
   * Test {@link SchemaDefinition#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SchemaDefinition#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition SchemaDefinition.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaDetailsCase.forNumber(42));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code STRUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when four; then return 'STRUCT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenFour_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.STRUCT, SchemaDetailsCase.forNumber(4));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code TABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when three; then return 'TABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenThree_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.TABLE, SchemaDetailsCase.forNumber(3));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMADETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when zero; then return 'SCHEMADETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenZero_thenReturnSchemadetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, SchemaDetailsCase.forNumber(0));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#getNumber()}.
   * <p>
   * Method under test: {@link SchemaDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SchemaDetailsCase.getNumber()"})
  void testSchemaDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, SchemaDetailsCase.valueOf("TABLE").getNumber());
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaDetailsCase.valueOf(42));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code STRUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when four; then return 'STRUCT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenFour_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.STRUCT, SchemaDetailsCase.valueOf(4));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code TABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when three; then return 'TABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenThree_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.TABLE, SchemaDetailsCase.valueOf(3));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMADETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when zero; then return 'SCHEMADETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenZero_thenReturnSchemadetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, SchemaDetailsCase.valueOf(0));
  }
}

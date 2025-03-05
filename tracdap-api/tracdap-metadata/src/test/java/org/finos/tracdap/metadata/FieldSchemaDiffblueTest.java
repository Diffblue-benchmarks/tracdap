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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FieldSchemaDiffblueTest {
  /**
   * Test {@link FieldSchema#getFieldName()}.
   * <p>
   * Method under test: {@link FieldSchema#getFieldName()}
   */
  @Test
  @DisplayName("Test getFieldName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String FieldSchema.getFieldName()"})
  void testGetFieldName() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getFieldName());
  }

  /**
   * Test {@link FieldSchema#getFieldNameBytes()}.
   * <p>
   * Method under test: {@link FieldSchema#getFieldNameBytes()}
   */
  @Test
  @DisplayName("Test getFieldNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString FieldSchema.getFieldNameBytes()"})
  void testGetFieldNameBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualFieldNameBytes = defaultInstance.getFieldNameBytes();

    // Assert
    ByteString byteString = actualFieldNameBytes.EMPTY;
    assertEquals(byteString, actualFieldNameBytes);
    assertEquals(byteString, defaultInstance.getFormatCodeBytes());
    assertEquals(byteString, defaultInstance.getLabelBytes());
  }

  /**
   * Test {@link FieldSchema#getFieldType()}.
   * <p>
   * Method under test: {@link FieldSchema#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType FieldSchema.getFieldType()"})
  void testGetFieldType() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, FieldSchema.getDefaultInstance().getFieldType());
  }

  /**
   * Test {@link FieldSchema#getLabel()}.
   * <p>
   * Method under test: {@link FieldSchema#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String FieldSchema.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link FieldSchema#getLabelBytes()}.
   * <p>
   * Method under test: {@link FieldSchema#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString FieldSchema.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getFieldNameBytes());
    assertEquals(byteString, defaultInstance.getFormatCodeBytes());
    assertEquals(byteString, actualLabelBytes);
  }

  /**
   * Test {@link FieldSchema#hasNotNull()}.
   * <p>
   * Method under test: {@link FieldSchema#hasNotNull()}
   */
  @Test
  @DisplayName("Test hasNotNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.hasNotNull()"})
  void testHasNotNull() {
    // Arrange, Act and Assert
    assertFalse(FieldSchema.getDefaultInstance().hasNotNull());
  }

  /**
   * Test {@link FieldSchema#hasFormatCode()}.
   * <p>
   * Method under test: {@link FieldSchema#hasFormatCode()}
   */
  @Test
  @DisplayName("Test hasFormatCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.hasFormatCode()"})
  void testHasFormatCode() {
    // Arrange, Act and Assert
    assertFalse(FieldSchema.getDefaultInstance().hasFormatCode());
  }

  /**
   * Test {@link FieldSchema#getFormatCode()}.
   * <p>
   * Method under test: {@link FieldSchema#getFormatCode()}
   */
  @Test
  @DisplayName("Test getFormatCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String FieldSchema.getFormatCode()"})
  void testGetFormatCode() {
    // Arrange, Act and Assert
    assertEquals("", FieldSchema.getDefaultInstance().getFormatCode());
  }

  /**
   * Test {@link FieldSchema#getFormatCodeBytes()}.
   * <p>
   * Method under test: {@link FieldSchema#getFormatCodeBytes()}
   */
  @Test
  @DisplayName("Test getFormatCodeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString FieldSchema.getFormatCodeBytes()"})
  void testGetFormatCodeBytes() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act
    ByteString actualFormatCodeBytes = defaultInstance.getFormatCodeBytes();

    // Assert
    ByteString byteString = actualFormatCodeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getFieldNameBytes());
    assertEquals(byteString, actualFormatCodeBytes);
    assertEquals(byteString, defaultInstance.getLabelBytes());
  }

  /**
   * Test {@link FieldSchema#isInitialized()}.
   * <p>
   * Method under test: {@link FieldSchema#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FieldSchema.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link FieldSchema#getSerializedSize()}.
   * <p>
   * Method under test: {@link FieldSchema#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FieldSchema.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FieldSchema.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link FieldSchema#equals(Object)}, and {@link FieldSchema#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldSchema#equals(Object)}
   *   <li>{@link FieldSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.equals(Object)", "int FieldSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();
    FieldSchema defaultInstance2 = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link FieldSchema#equals(Object)}, and {@link FieldSchema#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldSchema#equals(Object)}
   *   <li>{@link FieldSchema#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.equals(Object)", "int FieldSchema.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link FieldSchema#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.equals(Object)", "int FieldSchema.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), 1);
  }

  /**
   * Test {@link FieldSchema#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.equals(Object)", "int FieldSchema.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), null);
  }

  /**
   * Test {@link FieldSchema#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FieldSchema.equals(Object)", "int FieldSchema.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldSchema.getDefaultInstance(), "Different type to FieldSchema");
  }

  /**
   * Test {@link FieldSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFieldNameBytes());
    assertEquals(byteString, actualParseFromResult.getFormatCodeBytes());
    assertEquals(byteString, actualParseFromResult.getLabelBytes());
  }

  /**
   * Test {@link FieldSchema#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFieldNameBytes());
    assertEquals(byteString, actualParseFromResult.getFormatCodeBytes());
    assertEquals(byteString, actualParseFromResult.getLabelBytes());
  }

  /**
   * Test {@link FieldSchema#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFieldName());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getFieldOrder());
    assertEquals(0, actualParseFromResult.getFieldTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getFieldType());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FieldSchema.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    FieldSchema actualParseFromResult = FieldSchema.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FieldSchema actualParseDelimitedFromResult = FieldSchema.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFieldName());
    assertEquals("", actualParseDelimitedFromResult.getFormatCode());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getFieldOrder());
    assertEquals(0, actualParseDelimitedFromResult.getFieldTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseDelimitedFromResult.getFieldType());
    assertFalse(actualParseDelimitedFromResult.getBusinessKey());
    assertFalse(actualParseDelimitedFromResult.getCategorical());
    assertFalse(actualParseDelimitedFromResult.getNotNull());
    assertFalse(actualParseDelimitedFromResult.hasFormatCode());
    assertFalse(actualParseDelimitedFromResult.hasNotNull());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FieldSchema.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FieldSchema actualParseDelimitedFromResult = FieldSchema.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFieldName());
    assertEquals("", actualParseDelimitedFromResult.getFormatCode());
    assertEquals("", actualParseDelimitedFromResult.getLabel());
    assertEquals(0, actualParseDelimitedFromResult.getFieldOrder());
    assertEquals(0, actualParseDelimitedFromResult.getFieldTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseDelimitedFromResult.getFieldType());
    assertFalse(actualParseDelimitedFromResult.getBusinessKey());
    assertFalse(actualParseDelimitedFromResult.getCategorical());
    assertFalse(actualParseDelimitedFromResult.getNotNull());
    assertFalse(actualParseDelimitedFromResult.hasFormatCode());
    assertFalse(actualParseDelimitedFromResult.hasNotNull());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FieldSchema.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldSchema#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FieldSchema.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link FieldSchema#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link FieldSchema#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldSchema FieldSchema.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    FieldSchema defaultInstance = FieldSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

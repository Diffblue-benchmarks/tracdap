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
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.finos.tracdap.metadata.Value.ValueCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StructFieldDiffblueTest {
  /**
   * Test {@link StructField#hasFieldType()}.
   * <p>
   * Method under test: {@link StructField#hasFieldType()}
   */
  @Test
  @DisplayName("Test hasFieldType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.hasFieldType()"})
  void testHasFieldType() {
    // Arrange, Act and Assert
    assertFalse(StructField.getDefaultInstance().hasFieldType());
  }

  /**
   * Test {@link StructField#getFieldType()}.
   * <p>
   * Method under test: {@link StructField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor StructField.getFieldType()"})
  void testGetFieldType() {
    // Arrange and Act
    TypeDescriptor actualFieldType = StructField.getDefaultInstance().getFieldType();

    // Assert
    assertEquals("", actualFieldType.getInitializationErrorString());
    assertEquals(0, actualFieldType.getBasicTypeValue());
    assertEquals(0, actualFieldType.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualFieldType.getBasicType());
    assertFalse(actualFieldType.hasArrayType());
    assertFalse(actualFieldType.hasMapType());
    assertTrue(actualFieldType.findInitializationErrors().isEmpty());
    assertTrue(actualFieldType.getAllFields().isEmpty());
    assertTrue(actualFieldType.isInitialized());
    assertSame(actualFieldType, actualFieldType.getArrayType());
    assertSame(actualFieldType, actualFieldType.getArrayTypeOrBuilder());
    assertSame(actualFieldType, actualFieldType.getDefaultInstanceForType());
    assertSame(actualFieldType, actualFieldType.getMapType());
    assertSame(actualFieldType, actualFieldType.getMapTypeOrBuilder());
  }

  /**
   * Test {@link StructField#getLabel()}.
   * <p>
   * Method under test: {@link StructField#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StructField.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", StructField.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link StructField#getLabelBytes()}.
   * <p>
   * Method under test: {@link StructField#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StructField.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    Value defaultValue = defaultInstance.getDefaultValue();
    assertEquals(byteString, defaultValue.getDateValue().getIsoDateBytes());
    assertEquals(byteString, defaultValue.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, defaultValue.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, defaultInstance.getFormatCodeBytes());
    assertEquals(byteString, actualLabelBytes);
    assertEquals(byteString, defaultInstance.getStructTypeBytes());
    assertEquals(byteString, defaultValue.getStringValueBytes());
  }

  /**
   * Test {@link StructField#hasNotNull()}.
   * <p>
   * Method under test: {@link StructField#hasNotNull()}
   */
  @Test
  @DisplayName("Test hasNotNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.hasNotNull()"})
  void testHasNotNull() {
    // Arrange, Act and Assert
    assertFalse(StructField.getDefaultInstance().hasNotNull());
  }

  /**
   * Test {@link StructField#hasFormatCode()}.
   * <p>
   * Method under test: {@link StructField#hasFormatCode()}
   */
  @Test
  @DisplayName("Test hasFormatCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.hasFormatCode()"})
  void testHasFormatCode() {
    // Arrange, Act and Assert
    assertFalse(StructField.getDefaultInstance().hasFormatCode());
  }

  /**
   * Test {@link StructField#getFormatCode()}.
   * <p>
   * Method under test: {@link StructField#getFormatCode()}
   */
  @Test
  @DisplayName("Test getFormatCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StructField.getFormatCode()"})
  void testGetFormatCode() {
    // Arrange, Act and Assert
    assertEquals("", StructField.getDefaultInstance().getFormatCode());
  }

  /**
   * Test {@link StructField#getFormatCodeBytes()}.
   * <p>
   * Method under test: {@link StructField#getFormatCodeBytes()}
   */
  @Test
  @DisplayName("Test getFormatCodeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StructField.getFormatCodeBytes()"})
  void testGetFormatCodeBytes() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();

    // Act
    ByteString actualFormatCodeBytes = defaultInstance.getFormatCodeBytes();

    // Assert
    ByteString byteString = actualFormatCodeBytes.EMPTY;
    Value defaultValue = defaultInstance.getDefaultValue();
    assertEquals(byteString, defaultValue.getDateValue().getIsoDateBytes());
    assertEquals(byteString, defaultValue.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, defaultValue.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, actualFormatCodeBytes);
    assertEquals(byteString, defaultInstance.getLabelBytes());
    assertEquals(byteString, defaultInstance.getStructTypeBytes());
    assertEquals(byteString, defaultValue.getStringValueBytes());
  }

  /**
   * Test {@link StructField#hasDefaultValue()}.
   * <p>
   * Method under test: {@link StructField#hasDefaultValue()}
   */
  @Test
  @DisplayName("Test hasDefaultValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.hasDefaultValue()"})
  void testHasDefaultValue() {
    // Arrange, Act and Assert
    assertFalse(StructField.getDefaultInstance().hasDefaultValue());
  }

  /**
   * Test {@link StructField#getDefaultValue()}.
   * <p>
   * Method under test: {@link StructField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value StructField.getDefaultValue()"})
  void testGetDefaultValue() {
    // Arrange and Act
    Value actualDefaultValue = StructField.getDefaultInstance().getDefaultValue();

    // Assert
    assertEquals("", actualDefaultValue.getInitializationErrorString());
    assertEquals("", actualDefaultValue.getStringValue());
    assertEquals(0, actualDefaultValue.getSerializedSize());
    assertEquals(0.0d, actualDefaultValue.getFloatValue());
    assertEquals(0L, actualDefaultValue.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualDefaultValue.getValueCase());
    assertFalse(actualDefaultValue.getBooleanValue());
    assertFalse(actualDefaultValue.hasArrayValue());
    assertFalse(actualDefaultValue.hasBooleanValue());
    assertFalse(actualDefaultValue.hasDateValue());
    assertFalse(actualDefaultValue.hasDatetimeValue());
    assertFalse(actualDefaultValue.hasDecimalValue());
    assertFalse(actualDefaultValue.hasFloatValue());
    assertFalse(actualDefaultValue.hasIntegerValue());
    assertFalse(actualDefaultValue.hasMapValue());
    assertFalse(actualDefaultValue.hasStringValue());
    assertFalse(actualDefaultValue.hasType());
    assertTrue(actualDefaultValue.findInitializationErrors().isEmpty());
    assertTrue(actualDefaultValue.getAllFields().isEmpty());
    assertTrue(actualDefaultValue.isInitialized());
    assertSame(actualDefaultValue, actualDefaultValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#hasStructType()}.
   * <p>
   * Method under test: {@link StructField#hasStructType()}
   */
  @Test
  @DisplayName("Test hasStructType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.hasStructType()"})
  void testHasStructType() {
    // Arrange, Act and Assert
    assertFalse(StructField.getDefaultInstance().hasStructType());
  }

  /**
   * Test {@link StructField#getStructType()}.
   * <p>
   * Method under test: {@link StructField#getStructType()}
   */
  @Test
  @DisplayName("Test getStructType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StructField.getStructType()"})
  void testGetStructType() {
    // Arrange, Act and Assert
    assertEquals("", StructField.getDefaultInstance().getStructType());
  }

  /**
   * Test {@link StructField#getStructTypeBytes()}.
   * <p>
   * Method under test: {@link StructField#getStructTypeBytes()}
   */
  @Test
  @DisplayName("Test getStructTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StructField.getStructTypeBytes()"})
  void testGetStructTypeBytes() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();

    // Act
    ByteString actualStructTypeBytes = defaultInstance.getStructTypeBytes();

    // Assert
    ByteString byteString = actualStructTypeBytes.EMPTY;
    Value defaultValue = defaultInstance.getDefaultValue();
    assertEquals(byteString, defaultValue.getDateValue().getIsoDateBytes());
    assertEquals(byteString, defaultValue.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, defaultValue.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, defaultInstance.getFormatCodeBytes());
    assertEquals(byteString, defaultInstance.getLabelBytes());
    assertEquals(byteString, actualStructTypeBytes);
    assertEquals(byteString, defaultValue.getStringValueBytes());
  }

  /**
   * Test {@link StructField#isInitialized()}.
   * <p>
   * Method under test: {@link StructField#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StructField.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link StructField#getSerializedSize()}.
   * <p>
   * Method under test: {@link StructField#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StructField.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StructField.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link StructField#equals(Object)}, and {@link StructField#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructField#equals(Object)}
   *   <li>{@link StructField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.equals(Object)", "int StructField.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();
    StructField defaultInstance2 = StructField.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link StructField#equals(Object)}, and {@link StructField#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructField#equals(Object)}
   *   <li>{@link StructField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.equals(Object)", "int StructField.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link StructField#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.equals(Object)", "int StructField.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructField.getDefaultInstance(), 1);
  }

  /**
   * Test {@link StructField#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.equals(Object)", "int StructField.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructField.getDefaultInstance(), null);
  }

  /**
   * Test {@link StructField#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StructField.equals(Object)", "int StructField.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructField.getDefaultInstance(), "Different type to StructField");
  }

  /**
   * Test {@link StructField#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    StructField actualParseFromResult = StructField.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    StructField actualParseFromResult = StructField.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    StructField actualParseFromResult = StructField.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    StructField actualParseFromResult = StructField.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFormatCodeBytes());
    assertEquals(byteString, actualParseFromResult.getLabelBytes());
    assertEquals(byteString, actualParseFromResult.getStructTypeBytes());
  }

  /**
   * Test {@link StructField#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    StructField actualParseFromResult = StructField.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFormatCodeBytes());
    assertEquals(byteString, actualParseFromResult.getLabelBytes());
    assertEquals(byteString, actualParseFromResult.getStructTypeBytes());
  }

  /**
   * Test {@link StructField#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    StructField actualParseFromResult = StructField.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link StructField#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    StructField actualParseFromResult = StructField.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    StructField actualParseFromResult = StructField.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    StructField actualParseFromResult = StructField.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormatCode());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals("", actualParseFromResult.getStructType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getBusinessKey());
    assertFalse(actualParseFromResult.getCategorical());
    assertFalse(actualParseFromResult.getNotNull());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasFieldType());
    assertFalse(actualParseFromResult.hasFormatCode());
    assertFalse(actualParseFromResult.hasNotNull());
    assertFalse(actualParseFromResult.hasStructType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StructField.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StructField.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StructField#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StructField.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StructField#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StructField.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StructField#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    StructField actualParseFromResult = StructField.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    StructField actualParseFromResult = StructField.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StructField.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> StructField.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StructField.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        StructField.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StructField actualParseDelimitedFromResult = StructField.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StructField.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StructField.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StructField.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, StructField.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StructField actualParseDelimitedFromResult = StructField.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StructField.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructField#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StructField.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StructField#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link StructField#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructField StructField.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    StructField defaultInstance = StructField.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

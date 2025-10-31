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
import java.util.List;
import org.finos.tracdap.metadata.Value.ValueCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValueDiffblueTest {
  /**
   * Test {@link Value#getValueCase()}.
   * <p>
   * Method under test: {@link Value#getValueCase()}
   */
  @Test
  @DisplayName("Test getValueCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase Value.getValueCase()"})
  void testGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, Value.getDefaultInstance().getValueCase());
  }

  /**
   * Test {@link Value#hasType()}.
   * <p>
   * Method under test: {@link Value#hasType()}
   */
  @Test
  @DisplayName("Test hasType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasType()"})
  void testHasType() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasType());
  }

  /**
   * Test {@link Value#getType()}.
   * <p>
   * Method under test: {@link Value#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor Value.getType()"})
  void testGetType() {
    // Arrange and Act
    TypeDescriptor actualType = Value.getDefaultInstance().getType();

    // Assert
    assertEquals("", actualType.getInitializationErrorString());
    assertEquals(0, actualType.getBasicTypeValue());
    assertEquals(0, actualType.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualType.getBasicType());
    assertFalse(actualType.hasArrayType());
    assertFalse(actualType.hasMapType());
    assertTrue(actualType.findInitializationErrors().isEmpty());
    assertTrue(actualType.getAllFields().isEmpty());
    assertTrue(actualType.isInitialized());
    assertSame(actualType, actualType.getArrayType());
    assertSame(actualType, actualType.getArrayTypeOrBuilder());
    assertSame(actualType, actualType.getDefaultInstanceForType());
    assertSame(actualType, actualType.getMapType());
    assertSame(actualType, actualType.getMapTypeOrBuilder());
  }

  /**
   * Test {@link Value#hasBooleanValue()}.
   * <p>
   * Method under test: {@link Value#hasBooleanValue()}
   */
  @Test
  @DisplayName("Test hasBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasBooleanValue()"})
  void testHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Test {@link Value#getBooleanValue()}.
   * <p>
   * Method under test: {@link Value#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().getBooleanValue());
  }

  /**
   * Test {@link Value#hasIntegerValue()}.
   * <p>
   * Method under test: {@link Value#hasIntegerValue()}
   */
  @Test
  @DisplayName("Test hasIntegerValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasIntegerValue()"})
  void testHasIntegerValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasIntegerValue());
  }

  /**
   * Test {@link Value#getIntegerValue()}.
   * <p>
   * Method under test: {@link Value#getIntegerValue()}
   */
  @Test
  @DisplayName("Test getIntegerValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Value.getIntegerValue()"})
  void testGetIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0L, Value.getDefaultInstance().getIntegerValue());
  }

  /**
   * Test {@link Value#hasFloatValue()}.
   * <p>
   * Method under test: {@link Value#hasFloatValue()}
   */
  @Test
  @DisplayName("Test hasFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasFloatValue()"})
  void testHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasFloatValue());
  }

  /**
   * Test {@link Value#getFloatValue()}.
   * <p>
   * Method under test: {@link Value#getFloatValue()}
   */
  @Test
  @DisplayName("Test getFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Value.getFloatValue()"})
  void testGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Value.getDefaultInstance().getFloatValue());
  }

  /**
   * Test {@link Value#hasStringValue()}.
   * <p>
   * Method under test: {@link Value#hasStringValue()}
   */
  @Test
  @DisplayName("Test hasStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasStringValue()"})
  void testHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasStringValue());
  }

  /**
   * Test {@link Value#getStringValue()}.
   * <p>
   * Method under test: {@link Value#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Value.getStringValue()"})
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", Value.getDefaultInstance().getStringValue());
  }

  /**
   * Test {@link Value#getStringValueBytes()}.
   * <p>
   * Method under test: {@link Value#getStringValueBytes()}
   */
  @Test
  @DisplayName("Test getStringValueBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Value.getStringValueBytes()"})
  void testGetStringValueBytes() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDateValue().getIsoDateBytes());
    assertEquals(byteString, defaultInstance.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, defaultInstance.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, actualStringValueBytes);
  }

  /**
   * Test {@link Value#hasDecimalValue()}.
   * <p>
   * Method under test: {@link Value#hasDecimalValue()}
   */
  @Test
  @DisplayName("Test hasDecimalValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasDecimalValue()"})
  void testHasDecimalValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDecimalValue());
  }

  /**
   * Test {@link Value#getDecimalValue()}.
   * <p>
   * Method under test: {@link Value#getDecimalValue()}
   */
  @Test
  @DisplayName("Test getDecimalValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecimalValue Value.getDecimalValue()"})
  void testGetDecimalValue() {
    // Arrange and Act
    DecimalValue actualDecimalValue = Value.getDefaultInstance().getDecimalValue();

    // Assert
    assertEquals("", actualDecimalValue.getInitializationErrorString());
    assertEquals("", actualDecimalValue.getDecimal());
    assertEquals(0, actualDecimalValue.getSerializedSize());
    assertTrue(actualDecimalValue.findInitializationErrors().isEmpty());
    assertTrue(actualDecimalValue.getAllFields().isEmpty());
    assertTrue(actualDecimalValue.isInitialized());
    assertSame(actualDecimalValue, actualDecimalValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#hasDateValue()}.
   * <p>
   * Method under test: {@link Value#hasDateValue()}
   */
  @Test
  @DisplayName("Test hasDateValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasDateValue()"})
  void testHasDateValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDateValue());
  }

  /**
   * Test {@link Value#getDateValue()}.
   * <p>
   * Method under test: {@link Value#getDateValue()}
   */
  @Test
  @DisplayName("Test getDateValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DateValue Value.getDateValue()"})
  void testGetDateValue() {
    // Arrange and Act
    DateValue actualDateValue = Value.getDefaultInstance().getDateValue();

    // Assert
    assertEquals("", actualDateValue.getInitializationErrorString());
    assertEquals("", actualDateValue.getIsoDate());
    assertEquals(0, actualDateValue.getSerializedSize());
    assertTrue(actualDateValue.findInitializationErrors().isEmpty());
    assertTrue(actualDateValue.getAllFields().isEmpty());
    assertTrue(actualDateValue.isInitialized());
    assertSame(actualDateValue, actualDateValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#hasDatetimeValue()}.
   * <p>
   * Method under test: {@link Value#hasDatetimeValue()}
   */
  @Test
  @DisplayName("Test hasDatetimeValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasDatetimeValue()"})
  void testHasDatetimeValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDatetimeValue());
  }

  /**
   * Test {@link Value#getDatetimeValue()}.
   * <p>
   * Method under test: {@link Value#getDatetimeValue()}
   */
  @Test
  @DisplayName("Test getDatetimeValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DatetimeValue Value.getDatetimeValue()"})
  void testGetDatetimeValue() {
    // Arrange and Act
    DatetimeValue actualDatetimeValue = Value.getDefaultInstance().getDatetimeValue();

    // Assert
    assertEquals("", actualDatetimeValue.getInitializationErrorString());
    assertEquals("", actualDatetimeValue.getIsoDatetime());
    assertEquals(0, actualDatetimeValue.getSerializedSize());
    assertTrue(actualDatetimeValue.findInitializationErrors().isEmpty());
    assertTrue(actualDatetimeValue.getAllFields().isEmpty());
    assertTrue(actualDatetimeValue.isInitialized());
    assertSame(actualDatetimeValue, actualDatetimeValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#hasArrayValue()}.
   * <p>
   * Method under test: {@link Value#hasArrayValue()}
   */
  @Test
  @DisplayName("Test hasArrayValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasArrayValue()"})
  void testHasArrayValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasArrayValue());
  }

  /**
   * Test {@link Value#getArrayValue()}.
   * <p>
   * Method under test: {@link Value#getArrayValue()}
   */
  @Test
  @DisplayName("Test getArrayValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayValue Value.getArrayValue()"})
  void testGetArrayValue() {
    // Arrange and Act
    ArrayValue actualArrayValue = Value.getDefaultInstance().getArrayValue();

    // Assert
    assertEquals("", actualArrayValue.getInitializationErrorString());
    assertEquals(0, actualArrayValue.getItemsCount());
    assertEquals(0, actualArrayValue.getSerializedSize());
    assertTrue(actualArrayValue.findInitializationErrors().isEmpty());
    List<Value> itemsList = actualArrayValue.getItemsList();
    assertTrue(itemsList.isEmpty());
    assertTrue(actualArrayValue.getAllFields().isEmpty());
    assertTrue(actualArrayValue.isInitialized());
    assertSame(itemsList, actualArrayValue.getItemsOrBuilderList());
    assertSame(actualArrayValue, actualArrayValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#hasMapValue()}.
   * <p>
   * Method under test: {@link Value#hasMapValue()}
   */
  @Test
  @DisplayName("Test hasMapValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.hasMapValue()"})
  void testHasMapValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasMapValue());
  }

  /**
   * Test {@link Value#getMapValue()}.
   * <p>
   * Method under test: {@link Value#getMapValue()}
   */
  @Test
  @DisplayName("Test getMapValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapValue Value.getMapValue()"})
  void testGetMapValue() {
    // Arrange and Act
    MapValue actualMapValue = Value.getDefaultInstance().getMapValue();

    // Assert
    assertEquals("", actualMapValue.getInitializationErrorString());
    assertEquals(0, actualMapValue.getEntriesCount());
    assertEquals(0, actualMapValue.getSerializedSize());
    assertTrue(actualMapValue.findInitializationErrors().isEmpty());
    assertTrue(actualMapValue.getAllFields().isEmpty());
    assertTrue(actualMapValue.getEntries().isEmpty());
    assertTrue(actualMapValue.getEntriesMap().isEmpty());
    assertTrue(actualMapValue.isInitialized());
    assertSame(actualMapValue, actualMapValue.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#isInitialized()}.
   * <p>
   * Method under test: {@link Value#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Value.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link Value#getSerializedSize()}.
   * <p>
   * Method under test: {@link Value#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Value.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Value.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link Value#equals(Object)}, and {@link Value#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();
    Value defaultInstance2 = Value.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link Value#equals(Object)}, and {@link Value#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), 1);
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), null);
  }

  /**
   * Test {@link Value#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Value.equals(Object)", "int Value.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), "Different type to Value");
  }

  /**
   * Test {@link Value#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Value actualParseFromResult = Value.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Value actualParseFromResult = Value.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Value actualParseFromResult = Value.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Value actualParseFromResult = Value.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test {@link Value#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Value actualParseFromResult = Value.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test {@link Value#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    Value actualParseFromResult = Value.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Value#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Value actualParseFromResult = Value.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Value actualParseFromResult = Value.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Value actualParseFromResult = Value.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasArrayValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDateValue());
    assertFalse(actualParseFromResult.hasDatetimeValue());
    assertFalse(actualParseFromResult.hasDecimalValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntegerValue());
    assertFalse(actualParseFromResult.hasMapValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Value.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Value#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Value#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Value#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Value.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Value#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Value actualParseFromResult = Value.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Value actualParseFromResult = Value.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Value actualParseDelimitedFromResult = Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Value.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Value.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Value actualParseDelimitedFromResult = Value.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Value.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Value.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Value#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Value#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Value.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code MAPVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when CANCELLED_VALUE; then return 'MAPVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenCancelled_value_thenReturnMapvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.MAPVALUE, ValueCase.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code DATETIMEVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when eight; then return 'DATETIMEVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenEight_thenReturnDatetimevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATETIMEVALUE, ValueCase.forNumber(8));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code STRINGVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when five; then return 'STRINGVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFive_thenReturnStringvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRINGVALUE, ValueCase.forNumber(5));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.forNumber(42));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code FLOATVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when four; then return 'FLOATVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFour_thenReturnFloatvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOATVALUE, ValueCase.forNumber(4));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code ARRAYVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when MAP_VALUE; then return 'ARRAYVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenMap_value_thenReturnArrayvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.ARRAYVALUE, ValueCase.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code DATEVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when seven; then return 'DATEVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenSeven_thenReturnDatevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATEVALUE, ValueCase.forNumber(7));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DECIMALVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when six; then return 'DECIMALVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenSix_thenReturnDecimalvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DECIMALVALUE, ValueCase.forNumber(6));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code INTEGERVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when three; then return 'INTEGERVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenThree_thenReturnIntegervalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INTEGERVALUE, ValueCase.forNumber(3));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code BOOLEANVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when two; then return 'BOOLEANVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenTwo_thenReturnBooleanvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEANVALUE, ValueCase.forNumber(2));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.forNumber(0));
  }

  /**
   * Test ValueCase {@link ValueCase#getNumber()}.
   * <p>
   * Method under test: {@link ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test ValueCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ValueCase.getNumber()"})
  void testValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, ValueCase.valueOf("BOOLEANVALUE").getNumber());
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code MAPVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when CANCELLED_VALUE; then return 'MAPVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenCancelled_value_thenReturnMapvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.MAPVALUE, ValueCase.valueOf(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code DATETIMEVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when eight; then return 'DATETIMEVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenEight_thenReturnDatetimevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATETIMEVALUE, ValueCase.valueOf(8));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code STRINGVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when five; then return 'STRINGVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFive_thenReturnStringvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRINGVALUE, ValueCase.valueOf(5));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.valueOf(42));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code FLOATVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when four; then return 'FLOATVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFour_thenReturnFloatvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOATVALUE, ValueCase.valueOf(4));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code ARRAYVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when MAP_VALUE; then return 'ARRAYVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenMap_value_thenReturnArrayvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.ARRAYVALUE, ValueCase.valueOf(BasicType.MAP_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code DATEVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when seven; then return 'DATEVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenSeven_thenReturnDatevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATEVALUE, ValueCase.valueOf(7));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DECIMALVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when six; then return 'DECIMALVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenSix_thenReturnDecimalvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DECIMALVALUE, ValueCase.valueOf(6));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code INTEGERVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when three; then return 'INTEGERVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenThree_thenReturnIntegervalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INTEGERVALUE, ValueCase.valueOf(3));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code BOOLEANVALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when two; then return 'BOOLEANVALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenTwo_thenReturnBooleanvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEANVALUE, ValueCase.valueOf(2));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.valueOf(0));
  }
}

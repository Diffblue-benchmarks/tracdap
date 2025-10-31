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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValueDiffblueTest {
  /**
   * Method under test: {@link Value#getValueCase()}
   */
  @Test
  void testGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(Value.ValueCase.VALUE_NOT_SET, Value.getDefaultInstance().getValueCase());
  }

  /**
   * Method under test: {@link Value#hasType()}
   */
  @Test
  void testHasType() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasType());
  }

  /**
   * Method under test: {@link Value#hasBooleanValue()}
   */
  @Test
  void testHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Method under test: {@link Value#getBooleanValue()}
   */
  @Test
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().getBooleanValue());
  }

  /**
   * Method under test: {@link Value#hasIntegerValue()}
   */
  @Test
  void testHasIntegerValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasIntegerValue());
  }

  /**
   * Method under test: {@link Value#getIntegerValue()}
   */
  @Test
  void testGetIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0L, Value.getDefaultInstance().getIntegerValue());
  }

  /**
   * Method under test: {@link Value#hasFloatValue()}
   */
  @Test
  void testHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasFloatValue());
  }

  /**
   * Method under test: {@link Value#getFloatValue()}
   */
  @Test
  void testGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Value.getDefaultInstance().getFloatValue());
  }

  /**
   * Method under test: {@link Value#hasStringValue()}
   */
  @Test
  void testHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasStringValue());
  }

  /**
   * Method under test: {@link Value#getStringValue()}
   */
  @Test
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", Value.getDefaultInstance().getStringValue());
  }

  /**
   * Method under test: {@link Value#getStringValueBytes()}
   */
  @Test
  void testGetStringValueBytes() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDateValue().getIsoDateBytes());
    assertEquals(byteString, actualStringValueBytes);
  }

  /**
   * Method under test: {@link Value#hasDecimalValue()}
   */
  @Test
  void testHasDecimalValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDecimalValue());
  }

  /**
   * Method under test: {@link Value#hasDateValue()}
   */
  @Test
  void testHasDateValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDateValue());
  }

  /**
   * Method under test: {@link Value#hasDatetimeValue()}
   */
  @Test
  void testHasDatetimeValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasDatetimeValue());
  }

  /**
   * Method under test: {@link Value#hasArrayValue()}
   */
  @Test
  void testHasArrayValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasArrayValue());
  }

  /**
   * Method under test: {@link Value#hasMapValue()}
   */
  @Test
  void testHasMapValue() {
    // Arrange, Act and Assert
    assertFalse(Value.getDefaultInstance().hasMapValue());
  }

  /**
   * Method under test: {@link Value#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Value.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link Value#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Value.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link Value#equals(Object)}
   *   <li>{@link Value#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Value#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Value.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Value#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Value.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Value#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Value.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link Value#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> Value.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Value#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
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
   * Method under test: {@link Value#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    Value defaultInstance = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Value#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Value.getDefaultInstance(), "Different type to Value");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Value#getDefaultInstance()}
   *   <li>{@link Value#getDescriptor()}
   *   <li>{@link Value#newBuilder()}
   *   <li>{@link Value#newBuilder(Value)}
   *   <li>{@link Value#newBuilderForType()}
   *   <li>{@link Value#toBuilder()}
   *   <li>{@link Value#getArrayValueOrBuilder()}
   *   <li>{@link Value#getDateValueOrBuilder()}
   *   <li>{@link Value#getDatetimeValueOrBuilder()}
   *   <li>{@link Value#getDecimalValueOrBuilder()}
   *   <li>{@link Value#getMapValueOrBuilder()}
   *   <li>{@link Value#getParserForType()}
   *   <li>{@link Value#getTypeOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Value actualDefaultInstance = Value.getDefaultInstance();
    Value actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    Value prototype = Value.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    ArrayValueOrBuilder actualArrayValueOrBuilder = actualDefaultInstance.getArrayValueOrBuilder();
    DateValueOrBuilder actualDateValueOrBuilder = actualDefaultInstance.getDateValueOrBuilder();
    DatetimeValueOrBuilder actualDatetimeValueOrBuilder = actualDefaultInstance.getDatetimeValueOrBuilder();
    DecimalValueOrBuilder actualDecimalValueOrBuilder = actualDefaultInstance.getDecimalValueOrBuilder();
    MapValueOrBuilder actualMapValueOrBuilder = actualDefaultInstance.getMapValueOrBuilder();
    actualDefaultInstance.getParserForType();
    TypeDescriptorOrBuilder actualTypeOrBuilder = actualDefaultInstance.getTypeOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getArrayValue(), actualArrayValueOrBuilder);
    assertSame(actualDefaultInstance.getDateValue(), actualDateValueOrBuilder);
    assertSame(actualDefaultInstance.getDatetimeValue(), actualDatetimeValueOrBuilder);
    assertSame(actualDefaultInstance.getDecimalValue(), actualDecimalValueOrBuilder);
    assertSame(actualDefaultInstance.getMapValue(), actualMapValueOrBuilder);
    assertSame(actualDefaultInstance.getType(), actualTypeOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link Value.ValueCase#forNumber(int)}
   */
  @Test
  void testValueCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(Value.ValueCase.forNumber(42));
    assertEquals(Value.ValueCase.VALUE_NOT_SET, Value.ValueCase.forNumber(0));
    assertEquals(Value.ValueCase.BOOLEANVALUE, Value.ValueCase.forNumber(2));
    assertEquals(Value.ValueCase.INTEGERVALUE, Value.ValueCase.forNumber(3));
    assertEquals(Value.ValueCase.FLOATVALUE, Value.ValueCase.forNumber(4));
    assertEquals(Value.ValueCase.STRINGVALUE, Value.ValueCase.forNumber(5));
    assertEquals(Value.ValueCase.DECIMALVALUE, Value.ValueCase.forNumber(6));
    assertEquals(Value.ValueCase.DATEVALUE, Value.ValueCase.forNumber(7));
    assertEquals(Value.ValueCase.DATETIMEVALUE, Value.ValueCase.forNumber(8));
    assertEquals(Value.ValueCase.ARRAYVALUE, Value.ValueCase.forNumber(BasicType.MAP_VALUE));
    assertEquals(Value.ValueCase.MAPVALUE, Value.ValueCase.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link Value.ValueCase#getNumber()}
   */
  @Test
  void testValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, Value.ValueCase.valueOf("BOOLEANVALUE").getNumber());
  }

  /**
   * Method under test: {@link Value.ValueCase#valueOf(int)}
   */
  @Test
  void testValueCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(Value.ValueCase.valueOf(42));
    assertEquals(Value.ValueCase.VALUE_NOT_SET, Value.ValueCase.valueOf(0));
    assertEquals(Value.ValueCase.BOOLEANVALUE, Value.ValueCase.valueOf(2));
    assertEquals(Value.ValueCase.INTEGERVALUE, Value.ValueCase.valueOf(3));
    assertEquals(Value.ValueCase.FLOATVALUE, Value.ValueCase.valueOf(4));
    assertEquals(Value.ValueCase.STRINGVALUE, Value.ValueCase.valueOf(5));
    assertEquals(Value.ValueCase.DECIMALVALUE, Value.ValueCase.valueOf(6));
    assertEquals(Value.ValueCase.DATEVALUE, Value.ValueCase.valueOf(7));
    assertEquals(Value.ValueCase.DATETIMEVALUE, Value.ValueCase.valueOf(8));
    assertEquals(Value.ValueCase.ARRAYVALUE, Value.ValueCase.valueOf(BasicType.MAP_VALUE));
    assertEquals(Value.ValueCase.MAPVALUE, Value.ValueCase.valueOf(JobStatusCode.CANCELLED_VALUE));
  }
}

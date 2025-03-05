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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
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

class TypeDescriptorDiffblueTest {
  /**
   * Test {@link TypeDescriptor#getBasicType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#getBasicType()}
   */
  @Test
  @DisplayName("Test getBasicType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType TypeDescriptor.getBasicType()"})
  void testGetBasicType() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, TypeDescriptor.getDefaultInstance().getBasicType());
  }

  /**
   * Test {@link TypeDescriptor#hasArrayType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#hasArrayType()}
   */
  @Test
  @DisplayName("Test hasArrayType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.hasArrayType()"})
  void testHasArrayType() {
    // Arrange, Act and Assert
    assertFalse(TypeDescriptor.getDefaultInstance().hasArrayType());
  }

  /**
   * Test {@link TypeDescriptor#getArrayType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#getArrayType()}
   */
  @Test
  @DisplayName("Test getArrayType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.getArrayType()"})
  void testGetArrayType() {
    // Arrange
    TypeDescriptor defaultInstance = TypeDescriptor.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getArrayType());
  }

  /**
   * Test {@link TypeDescriptor#hasMapType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#hasMapType()}
   */
  @Test
  @DisplayName("Test hasMapType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.hasMapType()"})
  void testHasMapType() {
    // Arrange, Act and Assert
    assertFalse(TypeDescriptor.getDefaultInstance().hasMapType());
  }

  /**
   * Test {@link TypeDescriptor#getMapType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#getMapType()}
   */
  @Test
  @DisplayName("Test getMapType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.getMapType()"})
  void testGetMapType() {
    // Arrange
    TypeDescriptor defaultInstance = TypeDescriptor.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getMapType());
  }

  /**
   * Test {@link TypeDescriptor#isInitialized()}.
   * <p>
   * Method under test: {@link TypeDescriptor#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TypeDescriptor.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link TypeDescriptor#getSerializedSize()}.
   * <p>
   * Method under test: {@link TypeDescriptor#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TypeDescriptor.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TypeDescriptor.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link TypeDescriptor#equals(Object)}, and {@link TypeDescriptor#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeDescriptor#equals(Object)}
   *   <li>{@link TypeDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.equals(Object)", "int TypeDescriptor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeDescriptor defaultInstance = TypeDescriptor.getDefaultInstance();
    TypeDescriptor defaultInstance2 = TypeDescriptor.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link TypeDescriptor#equals(Object)}, and {@link TypeDescriptor#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeDescriptor#equals(Object)}
   *   <li>{@link TypeDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.equals(Object)", "int TypeDescriptor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeDescriptor defaultInstance = TypeDescriptor.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link TypeDescriptor#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.equals(Object)", "int TypeDescriptor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TypeDescriptor.getDefaultInstance(), 1);
  }

  /**
   * Test {@link TypeDescriptor#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.equals(Object)", "int TypeDescriptor.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TypeDescriptor.getDefaultInstance(), null);
  }

  /**
   * Test {@link TypeDescriptor#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeDescriptor.equals(Object)", "int TypeDescriptor.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TypeDescriptor.getDefaultInstance(), "Different type to TypeDescriptor");
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBasicTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParseFromResult.getBasicType());
    assertFalse(actualParseFromResult.hasArrayType());
    assertFalse(actualParseFromResult.hasMapType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TypeDescriptor.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TypeDescriptor.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TypeDescriptor.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TypeDescriptor.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TypeDescriptor actualParseFromResult = TypeDescriptor.parseFrom((InputStream) null);

    // Assert
    TypeDescriptor arrayType = actualParseFromResult.getArrayType();
    assertEquals(actualParseFromResult, arrayType);
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseFromResult.getMapType());
    assertSame(arrayType, actualParseFromResult.getMapTypeOrBuilder());
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TypeDescriptor actualParseDelimitedFromResult = TypeDescriptor.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(2, descriptorForType.getOneofs().size());
    assertEquals(3, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    TypeDescriptor arrayType = actualParseDelimitedFromResult.getArrayType();
    assertEquals(actualParseDelimitedFromResult, arrayType);
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(arrayType, actualParseDelimitedFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseDelimitedFromResult.getMapType());
    assertSame(arrayType, actualParseDelimitedFromResult.getMapTypeOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TypeDescriptor.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TypeDescriptor.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        TypeDescriptor.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TypeDescriptor.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TypeDescriptor.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TypeDescriptor.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, TypeDescriptor.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TypeDescriptor actualParseDelimitedFromResult = TypeDescriptor.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(2, descriptorForType.getOneofs().size());
    assertEquals(3, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    TypeDescriptor arrayType = actualParseDelimitedFromResult.getArrayType();
    assertEquals(actualParseDelimitedFromResult, arrayType);
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(arrayType, actualParseDelimitedFromResult.getArrayTypeOrBuilder());
    assertSame(arrayType, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(arrayType, actualParseDelimitedFromResult.getMapType());
    assertSame(arrayType, actualParseDelimitedFromResult.getMapTypeOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TypeDescriptor#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeDescriptor#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TypeDescriptor.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TypeDescriptor#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TypeDescriptor#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor TypeDescriptor.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    TypeDescriptor defaultInstance = TypeDescriptor.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

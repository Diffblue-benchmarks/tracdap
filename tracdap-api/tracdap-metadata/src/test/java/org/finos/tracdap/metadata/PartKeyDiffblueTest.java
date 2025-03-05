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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
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

class PartKeyDiffblueTest {
  /**
   * Test {@link PartKey#getOpaqueKey()}.
   * <p>
   * Method under test: {@link PartKey#getOpaqueKey()}
   */
  @Test
  @DisplayName("Test getOpaqueKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PartKey.getOpaqueKey()"})
  void testGetOpaqueKey() {
    // Arrange, Act and Assert
    assertEquals("", PartKey.getDefaultInstance().getOpaqueKey());
  }

  /**
   * Test {@link PartKey#getOpaqueKeyBytes()}.
   * <p>
   * Method under test: {@link PartKey#getOpaqueKeyBytes()}
   */
  @Test
  @DisplayName("Test getOpaqueKeyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString PartKey.getOpaqueKeyBytes()"})
  void testGetOpaqueKeyBytes() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act
    ByteString actualOpaqueKeyBytes = defaultInstance.getOpaqueKeyBytes();

    // Assert
    ByteString byteString = actualOpaqueKeyBytes.EMPTY;
    Value partRangeMax = defaultInstance.getPartRangeMax();
    assertEquals(byteString, partRangeMax.getDateValue().getIsoDateBytes());
    assertEquals(byteString, partRangeMax.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, partRangeMax.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, actualOpaqueKeyBytes);
    assertEquals(byteString, partRangeMax.getStringValueBytes());
  }

  /**
   * Test {@link PartKey#getPartType()}.
   * <p>
   * Method under test: {@link PartKey#getPartType()}
   */
  @Test
  @DisplayName("Test getPartType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartKey.getPartType()"})
  void testGetPartType() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, PartKey.getDefaultInstance().getPartType());
  }

  /**
   * Test {@link PartKey#getPartValuesCount()}.
   * <p>
   * Method under test: {@link PartKey#getPartValuesCount()}
   */
  @Test
  @DisplayName("Test getPartValuesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PartKey.getPartValuesCount()"})
  void testGetPartValuesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PartKey.getDefaultInstance().getPartValuesCount());
  }

  /**
   * Test {@link PartKey#hasPartRangeMin()}.
   * <p>
   * Method under test: {@link PartKey#hasPartRangeMin()}
   */
  @Test
  @DisplayName("Test hasPartRangeMin()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.hasPartRangeMin()"})
  void testHasPartRangeMin() {
    // Arrange, Act and Assert
    assertFalse(PartKey.getDefaultInstance().hasPartRangeMin());
  }

  /**
   * Test {@link PartKey#getPartRangeMin()}.
   * <p>
   * Method under test: {@link PartKey#getPartRangeMin()}
   */
  @Test
  @DisplayName("Test getPartRangeMin()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value PartKey.getPartRangeMin()"})
  void testGetPartRangeMin() {
    // Arrange and Act
    Value actualPartRangeMin = PartKey.getDefaultInstance().getPartRangeMin();

    // Assert
    assertEquals("", actualPartRangeMin.getInitializationErrorString());
    assertEquals("", actualPartRangeMin.getStringValue());
    assertEquals(0, actualPartRangeMin.getSerializedSize());
    assertEquals(0.0d, actualPartRangeMin.getFloatValue());
    assertEquals(0L, actualPartRangeMin.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualPartRangeMin.getValueCase());
    assertFalse(actualPartRangeMin.getBooleanValue());
    assertFalse(actualPartRangeMin.hasArrayValue());
    assertFalse(actualPartRangeMin.hasBooleanValue());
    assertFalse(actualPartRangeMin.hasDateValue());
    assertFalse(actualPartRangeMin.hasDatetimeValue());
    assertFalse(actualPartRangeMin.hasDecimalValue());
    assertFalse(actualPartRangeMin.hasFloatValue());
    assertFalse(actualPartRangeMin.hasIntegerValue());
    assertFalse(actualPartRangeMin.hasMapValue());
    assertFalse(actualPartRangeMin.hasStringValue());
    assertFalse(actualPartRangeMin.hasType());
    assertTrue(actualPartRangeMin.findInitializationErrors().isEmpty());
    assertTrue(actualPartRangeMin.getAllFields().isEmpty());
    assertTrue(actualPartRangeMin.isInitialized());
    assertSame(actualPartRangeMin, actualPartRangeMin.getDefaultInstanceForType());
  }

  /**
   * Test {@link PartKey#hasPartRangeMax()}.
   * <p>
   * Method under test: {@link PartKey#hasPartRangeMax()}
   */
  @Test
  @DisplayName("Test hasPartRangeMax()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.hasPartRangeMax()"})
  void testHasPartRangeMax() {
    // Arrange, Act and Assert
    assertFalse(PartKey.getDefaultInstance().hasPartRangeMax());
  }

  /**
   * Test {@link PartKey#getPartRangeMax()}.
   * <p>
   * Method under test: {@link PartKey#getPartRangeMax()}
   */
  @Test
  @DisplayName("Test getPartRangeMax()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value PartKey.getPartRangeMax()"})
  void testGetPartRangeMax() {
    // Arrange and Act
    Value actualPartRangeMax = PartKey.getDefaultInstance().getPartRangeMax();

    // Assert
    assertEquals("", actualPartRangeMax.getInitializationErrorString());
    assertEquals("", actualPartRangeMax.getStringValue());
    assertEquals(0, actualPartRangeMax.getSerializedSize());
    assertEquals(0.0d, actualPartRangeMax.getFloatValue());
    assertEquals(0L, actualPartRangeMax.getIntegerValue());
    assertEquals(ValueCase.VALUE_NOT_SET, actualPartRangeMax.getValueCase());
    assertFalse(actualPartRangeMax.getBooleanValue());
    assertFalse(actualPartRangeMax.hasArrayValue());
    assertFalse(actualPartRangeMax.hasBooleanValue());
    assertFalse(actualPartRangeMax.hasDateValue());
    assertFalse(actualPartRangeMax.hasDatetimeValue());
    assertFalse(actualPartRangeMax.hasDecimalValue());
    assertFalse(actualPartRangeMax.hasFloatValue());
    assertFalse(actualPartRangeMax.hasIntegerValue());
    assertFalse(actualPartRangeMax.hasMapValue());
    assertFalse(actualPartRangeMax.hasStringValue());
    assertFalse(actualPartRangeMax.hasType());
    assertTrue(actualPartRangeMax.findInitializationErrors().isEmpty());
    assertTrue(actualPartRangeMax.getAllFields().isEmpty());
    assertTrue(actualPartRangeMax.isInitialized());
    assertSame(actualPartRangeMax, actualPartRangeMax.getDefaultInstanceForType());
  }

  /**
   * Test {@link PartKey#isInitialized()}.
   * <p>
   * Method under test: {@link PartKey#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PartKey.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link PartKey#getSerializedSize()}.
   * <p>
   * Method under test: {@link PartKey#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PartKey.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PartKey.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link PartKey#equals(Object)}, and {@link PartKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PartKey#equals(Object)}
   *   <li>{@link PartKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.equals(Object)", "int PartKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();
    PartKey defaultInstance2 = PartKey.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link PartKey#equals(Object)}, and {@link PartKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PartKey#equals(Object)}
   *   <li>{@link PartKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.equals(Object)", "int PartKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link PartKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.equals(Object)", "int PartKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), 1);
  }

  /**
   * Test {@link PartKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.equals(Object)", "int PartKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), null);
  }

  /**
   * Test {@link PartKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PartKey.equals(Object)", "int PartKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PartKey.getDefaultInstance(), "Different type to PartKey");
  }

  /**
   * Test {@link PartKey#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PartKey#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PartKey actualParseFromResult = PartKey.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getOpaqueKey());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getPartValuesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertFalse(actualParseFromResult.hasPartRangeMax());
    assertFalse(actualParseFromResult.hasPartRangeMin());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualParseFromResult.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(partValuesList, actualParseFromResult.getPartValuesOrBuilderList());
  }

  /**
   * Test {@link PartKey#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    PartKey actualParseFromResult = PartKey.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getOpaqueKey());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getPartValuesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertFalse(actualParseFromResult.hasPartRangeMax());
    assertFalse(actualParseFromResult.hasPartRangeMin());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualParseFromResult.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(partValuesList, actualParseFromResult.getPartValuesOrBuilderList());
  }

  /**
   * Test {@link PartKey#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PartKey#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PartKey actualParseFromResult = PartKey.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getOpaqueKey());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getPartValuesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertFalse(actualParseFromResult.hasPartRangeMax());
    assertFalse(actualParseFromResult.hasPartRangeMin());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualParseFromResult.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(partValuesList, actualParseFromResult.getPartValuesOrBuilderList());
  }

  /**
   * Test {@link PartKey#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    PartKey actualParseFromResult = PartKey.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getOpaqueKey());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getPartValuesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertFalse(actualParseFromResult.hasPartRangeMax());
    assertFalse(actualParseFromResult.hasPartRangeMin());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualParseFromResult.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(partValuesList, actualParseFromResult.getPartValuesOrBuilderList());
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PartKey actualParseFromResult = PartKey.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getOpaqueKey());
    assertEquals(0, actualParseFromResult.getPartTypeValue());
    assertEquals(0, actualParseFromResult.getPartValuesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualParseFromResult.getPartType());
    assertFalse(actualParseFromResult.hasPartRangeMax());
    assertFalse(actualParseFromResult.hasPartRangeMin());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualParseFromResult.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(partValuesList, actualParseFromResult.getPartValuesOrBuilderList());
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PartKey.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PartKey.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    PartKey actualParseFromResult = PartKey.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Value partRangeMax = actualParseFromResult.getPartRangeMax();
    assertSame(unknownFields, partRangeMax.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMaxOrBuilder());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMin());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMinOrBuilder());
    assertSame(partRangeMax, partRangeMax.getDefaultInstanceForType());
  }

  /**
   * Test {@link PartKey#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PartKey actualParseFromResult = PartKey.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Value partRangeMax = actualParseFromResult.getPartRangeMax();
    assertSame(unknownFields, partRangeMax.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMaxOrBuilder());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMin());
    assertSame(partRangeMax, actualParseFromResult.getPartRangeMinOrBuilder());
    assertSame(partRangeMax, partRangeMax.getDefaultInstanceForType());
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PartKey actualParseDelimitedFromResult = PartKey.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PartKey.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, PartKey.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PartKey actualParseDelimitedFromResult = PartKey.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartKey#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PartKey.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PartKey#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PartKey#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey PartKey.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    PartKey defaultInstance = PartKey.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

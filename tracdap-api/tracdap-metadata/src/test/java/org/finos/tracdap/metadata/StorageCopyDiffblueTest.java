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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
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

class StorageCopyDiffblueTest {
  /**
   * Test {@link StorageCopy#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor StorageCopy.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> StorageCopy.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link StorageCopy#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when six; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor StorageCopy.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenSix_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = StorageCopy.getDefaultInstance()
        .internalGetMapFieldReflection(6);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link StorageCopy#getStorageKey()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageKey()}
   */
  @Test
  @DisplayName("Test getStorageKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StorageCopy.getStorageKey()"})
  void testGetStorageKey() {
    // Arrange, Act and Assert
    assertEquals("", StorageCopy.getDefaultInstance().getStorageKey());
  }

  /**
   * Test {@link StorageCopy#getStorageKeyBytes()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageKeyBytes()}
   */
  @Test
  @DisplayName("Test getStorageKeyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StorageCopy.getStorageKeyBytes()"})
  void testGetStorageKeyBytes() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();

    // Act
    ByteString actualStorageKeyBytes = defaultInstance.getStorageKeyBytes();

    // Assert
    ByteString byteString = actualStorageKeyBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getCopyTimestamp().getIsoDatetimeBytes());
    assertEquals(byteString, defaultInstance.getStorageFormatBytes());
    assertEquals(byteString, actualStorageKeyBytes);
    assertEquals(byteString, defaultInstance.getStoragePathBytes());
  }

  /**
   * Test {@link StorageCopy#getStoragePath()}.
   * <p>
   * Method under test: {@link StorageCopy#getStoragePath()}
   */
  @Test
  @DisplayName("Test getStoragePath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StorageCopy.getStoragePath()"})
  void testGetStoragePath() {
    // Arrange, Act and Assert
    assertEquals("", StorageCopy.getDefaultInstance().getStoragePath());
  }

  /**
   * Test {@link StorageCopy#getStoragePathBytes()}.
   * <p>
   * Method under test: {@link StorageCopy#getStoragePathBytes()}
   */
  @Test
  @DisplayName("Test getStoragePathBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StorageCopy.getStoragePathBytes()"})
  void testGetStoragePathBytes() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();

    // Act
    ByteString actualStoragePathBytes = defaultInstance.getStoragePathBytes();

    // Assert
    ByteString byteString = actualStoragePathBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getCopyTimestamp().getIsoDatetimeBytes());
    assertEquals(byteString, defaultInstance.getStorageFormatBytes());
    assertEquals(byteString, defaultInstance.getStorageKeyBytes());
    assertEquals(byteString, actualStoragePathBytes);
  }

  /**
   * Test {@link StorageCopy#getStorageFormat()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageFormat()}
   */
  @Test
  @DisplayName("Test getStorageFormat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StorageCopy.getStorageFormat()"})
  void testGetStorageFormat() {
    // Arrange, Act and Assert
    assertEquals("", StorageCopy.getDefaultInstance().getStorageFormat());
  }

  /**
   * Test {@link StorageCopy#getStorageFormatBytes()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageFormatBytes()}
   */
  @Test
  @DisplayName("Test getStorageFormatBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString StorageCopy.getStorageFormatBytes()"})
  void testGetStorageFormatBytes() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();

    // Act
    ByteString actualStorageFormatBytes = defaultInstance.getStorageFormatBytes();

    // Assert
    ByteString byteString = actualStorageFormatBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getCopyTimestamp().getIsoDatetimeBytes());
    assertEquals(byteString, actualStorageFormatBytes);
    assertEquals(byteString, defaultInstance.getStorageKeyBytes());
    assertEquals(byteString, defaultInstance.getStoragePathBytes());
  }

  /**
   * Test {@link StorageCopy#getCopyStatus()}.
   * <p>
   * Method under test: {@link StorageCopy#getCopyStatus()}
   */
  @Test
  @DisplayName("Test getCopyStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus StorageCopy.getCopyStatus()"})
  void testGetCopyStatus() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, StorageCopy.getDefaultInstance().getCopyStatus());
  }

  /**
   * Test {@link StorageCopy#hasCopyTimestamp()}.
   * <p>
   * Method under test: {@link StorageCopy#hasCopyTimestamp()}
   */
  @Test
  @DisplayName("Test hasCopyTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.hasCopyTimestamp()"})
  void testHasCopyTimestamp() {
    // Arrange, Act and Assert
    assertFalse(StorageCopy.getDefaultInstance().hasCopyTimestamp());
  }

  /**
   * Test {@link StorageCopy#getCopyTimestamp()}.
   * <p>
   * Method under test: {@link StorageCopy#getCopyTimestamp()}
   */
  @Test
  @DisplayName("Test getCopyTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DatetimeValue StorageCopy.getCopyTimestamp()"})
  void testGetCopyTimestamp() {
    // Arrange and Act
    DatetimeValue actualCopyTimestamp = StorageCopy.getDefaultInstance().getCopyTimestamp();

    // Assert
    assertEquals("", actualCopyTimestamp.getInitializationErrorString());
    assertEquals("", actualCopyTimestamp.getIsoDatetime());
    assertEquals(0, actualCopyTimestamp.getSerializedSize());
    assertTrue(actualCopyTimestamp.findInitializationErrors().isEmpty());
    assertTrue(actualCopyTimestamp.getAllFields().isEmpty());
    assertTrue(actualCopyTimestamp.isInitialized());
    assertSame(actualCopyTimestamp, actualCopyTimestamp.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#getStorageOptionsCount()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageOptionsCount()}
   */
  @Test
  @DisplayName("Test getStorageOptionsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StorageCopy.getStorageOptionsCount()"})
  void testGetStorageOptionsCount() {
    // Arrange, Act and Assert
    assertEquals(0, StorageCopy.getDefaultInstance().getStorageOptionsCount());
  }

  /**
   * Test {@link StorageCopy#containsStorageOptions(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#containsStorageOptions(String)}
   */
  @Test
  @DisplayName("Test containsStorageOptions(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.containsStorageOptions(String)"})
  void testContainsStorageOptions_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StorageCopy.getDefaultInstance().containsStorageOptions("Key"));
  }

  /**
   * Test {@link StorageCopy#getStorageOptions()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageOptions()}
   */
  @Test
  @DisplayName("Test getStorageOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map StorageCopy.getStorageOptions()"})
  void testGetStorageOptions() {
    // Arrange, Act and Assert
    assertTrue(StorageCopy.getDefaultInstance().getStorageOptions().isEmpty());
  }

  /**
   * Test {@link StorageCopy#getStorageOptionsMap()}.
   * <p>
   * Method under test: {@link StorageCopy#getStorageOptionsMap()}
   */
  @Test
  @DisplayName("Test getStorageOptionsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map StorageCopy.getStorageOptionsMap()"})
  void testGetStorageOptionsMap() {
    // Arrange, Act and Assert
    assertTrue(StorageCopy.getDefaultInstance().getStorageOptionsMap().isEmpty());
  }

  /**
   * Test {@link StorageCopy#getStorageOptionsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#getStorageOptionsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getStorageOptionsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value StorageCopy.getStorageOptionsOrDefault(String, Value)"})
  void testGetStorageOptionsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getStorageOptionsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link StorageCopy#getStorageOptionsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#getStorageOptionsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getStorageOptionsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value StorageCopy.getStorageOptionsOrThrow(String)"})
  void testGetStorageOptionsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> StorageCopy.getDefaultInstance().getStorageOptionsOrThrow("Key"));
  }

  /**
   * Test {@link StorageCopy#isInitialized()}.
   * <p>
   * Method under test: {@link StorageCopy#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageCopy.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link StorageCopy#getSerializedSize()}.
   * <p>
   * Method under test: {@link StorageCopy#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StorageCopy.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageCopy.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link StorageCopy#equals(Object)}, and {@link StorageCopy#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StorageCopy#equals(Object)}
   *   <li>{@link StorageCopy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.equals(Object)", "int StorageCopy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();
    StorageCopy defaultInstance2 = StorageCopy.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link StorageCopy#equals(Object)}, and {@link StorageCopy#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StorageCopy#equals(Object)}
   *   <li>{@link StorageCopy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.equals(Object)", "int StorageCopy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link StorageCopy#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.equals(Object)", "int StorageCopy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageCopy.getDefaultInstance(), 1);
  }

  /**
   * Test {@link StorageCopy#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.equals(Object)", "int StorageCopy.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageCopy.getDefaultInstance(), null);
  }

  /**
   * Test {@link StorageCopy#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageCopy.equals(Object)", "int StorageCopy.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageCopy.getDefaultInstance(), "Different type to StorageCopy");
  }

  /**
   * Test {@link StorageCopy#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStorageFormat());
    assertEquals("", actualParseFromResult.getStorageKey());
    assertEquals("", actualParseFromResult.getStoragePath());
    assertEquals(0, actualParseFromResult.getCopyStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageOptionsCount());
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualParseFromResult.getCopyStatus());
    assertFalse(actualParseFromResult.hasCopyTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptions().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptionsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStorageFormat());
    assertEquals("", actualParseFromResult.getStorageKey());
    assertEquals("", actualParseFromResult.getStoragePath());
    assertEquals(0, actualParseFromResult.getCopyStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageOptionsCount());
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualParseFromResult.getCopyStatus());
    assertFalse(actualParseFromResult.hasCopyTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptions().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptionsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStorageFormat());
    assertEquals("", actualParseFromResult.getStorageKey());
    assertEquals("", actualParseFromResult.getStoragePath());
    assertEquals(0, actualParseFromResult.getCopyStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageOptionsCount());
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualParseFromResult.getCopyStatus());
    assertFalse(actualParseFromResult.hasCopyTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptions().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptionsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStorageFormat());
    assertEquals("", actualParseFromResult.getStorageKey());
    assertEquals("", actualParseFromResult.getStoragePath());
    assertEquals(0, actualParseFromResult.getCopyStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageOptionsCount());
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualParseFromResult.getCopyStatus());
    assertFalse(actualParseFromResult.hasCopyTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptions().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptionsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStorageFormat());
    assertEquals("", actualParseFromResult.getStorageKey());
    assertEquals("", actualParseFromResult.getStoragePath());
    assertEquals(0, actualParseFromResult.getCopyStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStorageOptionsCount());
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualParseFromResult.getCopyStatus());
    assertFalse(actualParseFromResult.hasCopyTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptions().isEmpty());
    assertTrue(actualParseFromResult.getStorageOptionsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageCopy.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageCopy.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageCopy.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageCopy.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue copyTimestamp = actualParseFromResult.getCopyTimestamp();
    assertSame(unknownFields, copyTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(copyTimestamp, copyTimestamp.getDefaultInstanceForType());
    assertSame(copyTimestamp, actualParseFromResult.getCopyTimestampOrBuilder());
  }

  /**
   * Test {@link StorageCopy#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    StorageCopy actualParseFromResult = StorageCopy.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue copyTimestamp = actualParseFromResult.getCopyTimestamp();
    assertSame(unknownFields, copyTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(copyTimestamp, copyTimestamp.getDefaultInstanceForType());
    assertSame(copyTimestamp, actualParseFromResult.getCopyTimestampOrBuilder());
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageCopy actualParseDelimitedFromResult = StorageCopy.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DatetimeValue copyTimestamp = actualParseDelimitedFromResult.getCopyTimestamp();
    assertSame(unknownFields, copyTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(copyTimestamp, copyTimestamp.getDefaultInstanceForType());
    assertSame(copyTimestamp, actualParseDelimitedFromResult.getCopyTimestampOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageCopy.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageCopy.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        StorageCopy.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageCopy.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> StorageCopy.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageCopy.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageCopy.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, StorageCopy.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageCopy actualParseDelimitedFromResult = StorageCopy.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DatetimeValue copyTimestamp = actualParseDelimitedFromResult.getCopyTimestamp();
    assertSame(unknownFields, copyTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(copyTimestamp, copyTimestamp.getDefaultInstanceForType());
    assertSame(copyTimestamp, actualParseDelimitedFromResult.getCopyTimestampOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageCopy.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageCopy#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StorageCopy.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageCopy#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link StorageCopy#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageCopy StorageCopy.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    StorageCopy defaultInstance = StorageCopy.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

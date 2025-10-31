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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageIncarnationDiffblueTest {
  /**
   * Test {@link StorageIncarnation#getCopiesCount()}.
   * <p>
   * Method under test: {@link StorageIncarnation#getCopiesCount()}
   */
  @Test
  @DisplayName("Test getCopiesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StorageIncarnation.getCopiesCount()"})
  void testGetCopiesCount() {
    // Arrange, Act and Assert
    assertEquals(0, StorageIncarnation.getDefaultInstance().getCopiesCount());
  }

  /**
   * Test {@link StorageIncarnation#hasIncarnationTimestamp()}.
   * <p>
   * Method under test: {@link StorageIncarnation#hasIncarnationTimestamp()}
   */
  @Test
  @DisplayName("Test hasIncarnationTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.hasIncarnationTimestamp()"})
  void testHasIncarnationTimestamp() {
    // Arrange, Act and Assert
    assertFalse(StorageIncarnation.getDefaultInstance().hasIncarnationTimestamp());
  }

  /**
   * Test {@link StorageIncarnation#getIncarnationTimestamp()}.
   * <p>
   * Method under test: {@link StorageIncarnation#getIncarnationTimestamp()}
   */
  @Test
  @DisplayName("Test getIncarnationTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DatetimeValue StorageIncarnation.getIncarnationTimestamp()"})
  void testGetIncarnationTimestamp() {
    // Arrange and Act
    DatetimeValue actualIncarnationTimestamp = StorageIncarnation.getDefaultInstance().getIncarnationTimestamp();

    // Assert
    assertEquals("", actualIncarnationTimestamp.getInitializationErrorString());
    assertEquals("", actualIncarnationTimestamp.getIsoDatetime());
    assertEquals(0, actualIncarnationTimestamp.getSerializedSize());
    assertTrue(actualIncarnationTimestamp.findInitializationErrors().isEmpty());
    assertTrue(actualIncarnationTimestamp.getAllFields().isEmpty());
    assertTrue(actualIncarnationTimestamp.isInitialized());
    assertSame(actualIncarnationTimestamp, actualIncarnationTimestamp.getDefaultInstanceForType());
  }

  /**
   * Test {@link StorageIncarnation#getIncarnationStatus()}.
   * <p>
   * Method under test: {@link StorageIncarnation#getIncarnationStatus()}
   */
  @Test
  @DisplayName("Test getIncarnationStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus StorageIncarnation.getIncarnationStatus()"})
  void testGetIncarnationStatus() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET,
        StorageIncarnation.getDefaultInstance().getIncarnationStatus());
  }

  /**
   * Test {@link StorageIncarnation#isInitialized()}.
   * <p>
   * Method under test: {@link StorageIncarnation#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageIncarnation.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link StorageIncarnation#getSerializedSize()}.
   * <p>
   * Method under test: {@link StorageIncarnation#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StorageIncarnation.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageIncarnation.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link StorageIncarnation#equals(Object)}, and {@link StorageIncarnation#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StorageIncarnation#equals(Object)}
   *   <li>{@link StorageIncarnation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.equals(Object)", "int StorageIncarnation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageIncarnation defaultInstance = StorageIncarnation.getDefaultInstance();
    StorageIncarnation defaultInstance2 = StorageIncarnation.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link StorageIncarnation#equals(Object)}, and {@link StorageIncarnation#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StorageIncarnation#equals(Object)}
   *   <li>{@link StorageIncarnation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.equals(Object)", "int StorageIncarnation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageIncarnation defaultInstance = StorageIncarnation.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link StorageIncarnation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.equals(Object)", "int StorageIncarnation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageIncarnation.getDefaultInstance(), 1);
  }

  /**
   * Test {@link StorageIncarnation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.equals(Object)", "int StorageIncarnation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageIncarnation.getDefaultInstance(), null);
  }

  /**
   * Test {@link StorageIncarnation#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StorageIncarnation.equals(Object)", "int StorageIncarnation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageIncarnation.getDefaultInstance(), "Different type to StorageIncarnation");
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCopiesCount());
    assertEquals(0, actualParseFromResult.getIncarnationIndex());
    assertEquals(0, actualParseFromResult.getIncarnationStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualParseFromResult.getIncarnationStatus());
    assertFalse(actualParseFromResult.hasIncarnationTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<StorageCopy> copiesList = actualParseFromResult.getCopiesList();
    assertTrue(copiesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(copiesList, actualParseFromResult.getCopiesOrBuilderList());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCopiesCount());
    assertEquals(0, actualParseFromResult.getIncarnationIndex());
    assertEquals(0, actualParseFromResult.getIncarnationStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualParseFromResult.getIncarnationStatus());
    assertFalse(actualParseFromResult.hasIncarnationTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<StorageCopy> copiesList = actualParseFromResult.getCopiesList();
    assertTrue(copiesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(copiesList, actualParseFromResult.getCopiesOrBuilderList());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCopiesCount());
    assertEquals(0, actualParseFromResult.getIncarnationIndex());
    assertEquals(0, actualParseFromResult.getIncarnationStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualParseFromResult.getIncarnationStatus());
    assertFalse(actualParseFromResult.hasIncarnationTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<StorageCopy> copiesList = actualParseFromResult.getCopiesList();
    assertTrue(copiesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(copiesList, actualParseFromResult.getCopiesOrBuilderList());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCopiesCount());
    assertEquals(0, actualParseFromResult.getIncarnationIndex());
    assertEquals(0, actualParseFromResult.getIncarnationStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualParseFromResult.getIncarnationStatus());
    assertFalse(actualParseFromResult.hasIncarnationTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<StorageCopy> copiesList = actualParseFromResult.getCopiesList();
    assertTrue(copiesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(copiesList, actualParseFromResult.getCopiesOrBuilderList());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCopiesCount());
    assertEquals(0, actualParseFromResult.getIncarnationIndex());
    assertEquals(0, actualParseFromResult.getIncarnationStatusValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualParseFromResult.getIncarnationStatus());
    assertFalse(actualParseFromResult.hasIncarnationTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<StorageCopy> copiesList = actualParseFromResult.getCopiesList();
    assertTrue(copiesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(copiesList, actualParseFromResult.getCopiesOrBuilderList());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageIncarnation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageIncarnation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageIncarnation.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageIncarnation.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue incarnationTimestamp = actualParseFromResult.getIncarnationTimestamp();
    assertSame(unknownFields, incarnationTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, actualParseFromResult.getIncarnationTimestampOrBuilder());
  }

  /**
   * Test {@link StorageIncarnation#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    StorageIncarnation actualParseFromResult = StorageIncarnation.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue incarnationTimestamp = actualParseFromResult.getIncarnationTimestamp();
    assertSame(unknownFields, incarnationTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, actualParseFromResult.getIncarnationTimestampOrBuilder());
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageIncarnation actualParseDelimitedFromResult = StorageIncarnation.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    StorageIncarnation defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DatetimeValue incarnationTimestamp = actualParseDelimitedFromResult.getIncarnationTimestamp();
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, defaultInstanceForType.getIncarnationTimestamp());
    assertSame(incarnationTimestamp, defaultInstanceForType.getIncarnationTimestampOrBuilder());
    assertSame(incarnationTimestamp, actualParseDelimitedFromResult.getIncarnationTimestampOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageIncarnation actualParseDelimitedFromResult = StorageIncarnation.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DatetimeValue incarnationTimestamp = actualParseDelimitedFromResult.getIncarnationTimestamp();
    assertSame(unknownFields, incarnationTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, actualParseDelimitedFromResult.getIncarnationTimestampOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageIncarnation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageIncarnation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageIncarnation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageIncarnation.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageIncarnation.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageIncarnation actualParseDelimitedFromResult = StorageIncarnation.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    StorageIncarnation defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DatetimeValue incarnationTimestamp = actualParseDelimitedFromResult.getIncarnationTimestamp();
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, defaultInstanceForType.getIncarnationTimestamp());
    assertSame(incarnationTimestamp, defaultInstanceForType.getIncarnationTimestampOrBuilder());
    assertSame(incarnationTimestamp, actualParseDelimitedFromResult.getIncarnationTimestampOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    StorageIncarnation actualParseDelimitedFromResult = StorageIncarnation.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DatetimeValue incarnationTimestamp = actualParseDelimitedFromResult.getIncarnationTimestamp();
    assertSame(unknownFields, incarnationTimestamp.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, incarnationTimestamp.getDefaultInstanceForType());
    assertSame(incarnationTimestamp, actualParseDelimitedFromResult.getIncarnationTimestampOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StorageIncarnation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIncarnation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageIncarnation.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link StorageIncarnation#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link StorageIncarnation#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageIncarnation StorageIncarnation.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    StorageIncarnation defaultInstance = StorageIncarnation.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

package org.finos.tracdap.api;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteBatchResponseDiffblueTest {
  /**
   * Test {@link MetadataWriteBatchResponse#getCreateObjectsCount()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getCreateObjectsCount()}
   */
  @Test
  @DisplayName("Test getCreateObjectsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getCreateObjectsCount()"})
  void testGetCreateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getCreateObjectsCount());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getUpdateObjectsCount()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getUpdateObjectsCount()}
   */
  @Test
  @DisplayName("Test getUpdateObjectsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getUpdateObjectsCount()"})
  void testGetUpdateObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getUpdateObjectsCount());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getUpdateTagsCount()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getUpdateTagsCount()}
   */
  @Test
  @DisplayName("Test getUpdateTagsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getUpdateTagsCount()"})
  void testGetUpdateTagsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getUpdateTagsCount());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getPreallocateIdsCount()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getPreallocateIdsCount()}
   */
  @Test
  @DisplayName("Test getPreallocateIdsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getPreallocateIdsCount()"})
  void testGetPreallocateIdsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getPreallocateIdsCount());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getCreatePreallocatedObjectsCount()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getCreatePreallocatedObjectsCount()}
   */
  @Test
  @DisplayName("Test getCreatePreallocatedObjectsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getCreatePreallocatedObjectsCount()"})
  void testGetCreatePreallocatedObjectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getCreatePreallocatedObjectsCount());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#isInitialized()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataWriteBatchResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteBatchResponse.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteBatchResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#equals(Object)}, and {@link MetadataWriteBatchResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchResponse#equals(Object)}
   *   <li>{@link MetadataWriteBatchResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.equals(Object)", "int MetadataWriteBatchResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();
    MetadataWriteBatchResponse defaultInstance2 = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#equals(Object)}, and {@link MetadataWriteBatchResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteBatchResponse#equals(Object)}
   *   <li>{@link MetadataWriteBatchResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.equals(Object)", "int MetadataWriteBatchResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.equals(Object)", "int MetadataWriteBatchResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), 1);
  }

  /**
   * Test {@link MetadataWriteBatchResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.equals(Object)", "int MetadataWriteBatchResponse.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), null);
  }

  /**
   * Test {@link MetadataWriteBatchResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteBatchResponse.equals(Object)", "int MetadataWriteBatchResponse.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteBatchResponse.getDefaultInstance(), "Different type to MetadataWriteBatchResponse");
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseFromResult.getUpdateTagsCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseFromResult.getUpdateTagsCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseFromResult.getUpdateTagsCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseFromResult.getUpdateTagsCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseFromResult.getUpdateTagsCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseFromResult.getUpdateTagsOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteBatchResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MetadataWriteBatchResponse actualParseFromResult = MetadataWriteBatchResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetadataWriteBatchResponse actualParseDelimitedFromResult = MetadataWriteBatchResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getUpdateTagsCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseDelimitedFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateTagsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteBatchResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteBatchResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetadataWriteBatchResponse actualParseDelimitedFromResult = MetadataWriteBatchResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCreateObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getPreallocateIdsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getUpdateObjectsCount());
    assertEquals(0, actualParseDelimitedFromResult.getUpdateTagsCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualParseDelimitedFromResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreatePreallocatedObjectsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getPreallocateIdsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getPreallocateIdsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateObjectsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateObjectsOrBuilderList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateTagsList());
    assertSame(createObjectsList, actualParseDelimitedFromResult.getUpdateTagsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteBatchResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteBatchResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link MetadataWriteBatchResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MetadataWriteBatchResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteBatchResponse MetadataWriteBatchResponse.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataWriteBatchResponse defaultInstance = MetadataWriteBatchResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

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
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagDiffblueTest {
  /**
   * Test {@link Tag#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor Tag.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> Tag.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link Tag#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor Tag.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = Tag.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link Tag#hasHeader()}.
   * <p>
   * Method under test: {@link Tag#hasHeader()}
   */
  @Test
  @DisplayName("Test hasHeader()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.hasHeader()"})
  void testHasHeader() {
    // Arrange, Act and Assert
    assertFalse(Tag.getDefaultInstance().hasHeader());
  }

  /**
   * Test {@link Tag#getHeader()}.
   * <p>
   * Method under test: {@link Tag#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader Tag.getHeader()"})
  void testGetHeader() {
    // Arrange and Act
    TagHeader actualHeader = Tag.getDefaultInstance().getHeader();

    // Assert
    assertEquals("", actualHeader.getInitializationErrorString());
    assertEquals("", actualHeader.getObjectId());
    assertEquals(0, actualHeader.getObjectTypeValue());
    assertEquals(0, actualHeader.getObjectVersion());
    assertEquals(0, actualHeader.getSerializedSize());
    assertEquals(0, actualHeader.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualHeader.getObjectType());
    assertFalse(actualHeader.getIsLatestObject());
    assertFalse(actualHeader.getIsLatestTag());
    assertFalse(actualHeader.hasObjectTimestamp());
    assertFalse(actualHeader.hasTagTimestamp());
    assertTrue(actualHeader.findInitializationErrors().isEmpty());
    assertTrue(actualHeader.getAllFields().isEmpty());
    assertTrue(actualHeader.isInitialized());
    assertSame(actualHeader, actualHeader.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#getAttrsCount()}.
   * <p>
   * Method under test: {@link Tag#getAttrsCount()}
   */
  @Test
  @DisplayName("Test getAttrsCount()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Tag.getAttrsCount()"})
  void testGetAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Tag.getDefaultInstance().getAttrsCount());
  }

  /**
   * Test {@link Tag#containsAttrs(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#containsAttrs(String)}
   */
  @Test
  @DisplayName("Test containsAttrs(String); when 'Key'; then return 'false'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.containsAttrs(String)"})
  void testContainsAttrs_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Tag.getDefaultInstance().containsAttrs("Key"));
  }

  /**
   * Test {@link Tag#getAttrs()}.
   * <p>
   * Method under test: {@link Tag#getAttrs()}
   */
  @Test
  @DisplayName("Test getAttrs()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map Tag.getAttrs()"})
  void testGetAttrs() {
    // Arrange, Act and Assert
    assertTrue(Tag.getDefaultInstance().getAttrs().isEmpty());
  }

  /**
   * Test {@link Tag#getAttrsMap()}.
   * <p>
   * Method under test: {@link Tag#getAttrsMap()}
   */
  @Test
  @DisplayName("Test getAttrsMap()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map Tag.getAttrsMap()"})
  void testGetAttrsMap() {
    // Arrange, Act and Assert
    assertTrue(Tag.getDefaultInstance().getAttrsMap().isEmpty());
  }

  /**
   * Test {@link Tag#getAttrsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getAttrsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getAttrsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Tag.getAttrsOrDefault(String, Value)"})
  void testGetAttrsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    Tag defaultInstance = Tag.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getAttrsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link Tag#getAttrsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getAttrsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getAttrsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value Tag.getAttrsOrThrow(String)"})
  void testGetAttrsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Tag.getDefaultInstance().getAttrsOrThrow("Key"));
  }

  /**
   * Test {@link Tag#hasDefinition()}.
   * <p>
   * Method under test: {@link Tag#hasDefinition()}
   */
  @Test
  @DisplayName("Test hasDefinition()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.hasDefinition()"})
  void testHasDefinition() {
    // Arrange, Act and Assert
    assertFalse(Tag.getDefaultInstance().hasDefinition());
  }

  /**
   * Test {@link Tag#getDefinition()}.
   * <p>
   * Method under test: {@link Tag#getDefinition()}
   */
  @Test
  @DisplayName("Test getDefinition()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition Tag.getDefinition()"})
  void testGetDefinition() {
    // Arrange and Act
    ObjectDefinition actualDefinition = Tag.getDefaultInstance().getDefinition();

    // Assert
    assertEquals("", actualDefinition.getInitializationErrorString());
    assertEquals(0, actualDefinition.getObjectPropsCount());
    assertEquals(0, actualDefinition.getObjectTypeValue());
    assertEquals(0, actualDefinition.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualDefinition.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualDefinition.getObjectType());
    assertFalse(actualDefinition.hasCustom());
    assertFalse(actualDefinition.hasData());
    assertFalse(actualDefinition.hasFile());
    assertFalse(actualDefinition.hasFlow());
    assertFalse(actualDefinition.hasJob());
    assertFalse(actualDefinition.hasModel());
    assertFalse(actualDefinition.hasResult());
    assertFalse(actualDefinition.hasSchema());
    assertFalse(actualDefinition.hasStorage());
    assertTrue(actualDefinition.findInitializationErrors().isEmpty());
    assertTrue(actualDefinition.getAllFields().isEmpty());
    assertTrue(actualDefinition.getObjectProps().isEmpty());
    assertTrue(actualDefinition.getObjectPropsMap().isEmpty());
    assertTrue(actualDefinition.isInitialized());
    assertSame(actualDefinition, actualDefinition.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#isInitialized()}.
   * <p>
   * Method under test: {@link Tag#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Tag.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link Tag#getSerializedSize()}.
   * <p>
   * Method under test: {@link Tag#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Tag.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Tag.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link Tag#equals(Object)}, and {@link Tag#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tag#equals(Object)}
   *   <li>{@link Tag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.equals(Object)", "int Tag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Tag defaultInstance = Tag.getDefaultInstance();
    Tag defaultInstance2 = Tag.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link Tag#equals(Object)}, and {@link Tag#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tag#equals(Object)}
   *   <li>{@link Tag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.equals(Object)", "int Tag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Tag defaultInstance = Tag.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link Tag#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.equals(Object)", "int Tag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Tag.getDefaultInstance(), 1);
  }

  /**
   * Test {@link Tag#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.equals(Object)", "int Tag.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Tag.getDefaultInstance(), null);
  }

  /**
   * Test {@link Tag#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tag.equals(Object)", "int Tag.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Tag.getDefaultInstance(), "Different type to Tag");
  }

  /**
   * Test {@link Tag#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Tag#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Tag actualParseFromResult = Tag.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasHeader());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getAttrs().isEmpty());
    assertTrue(actualParseFromResult.getAttrsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Tag actualParseFromResult = Tag.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasHeader());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getAttrs().isEmpty());
    assertTrue(actualParseFromResult.getAttrsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Tag#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Tag actualParseFromResult = Tag.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasHeader());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getAttrs().isEmpty());
    assertTrue(actualParseFromResult.getAttrsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    Tag actualParseFromResult = Tag.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasHeader());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getAttrs().isEmpty());
    assertTrue(actualParseFromResult.getAttrsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Tag actualParseFromResult = Tag.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasHeader());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getAttrs().isEmpty());
    assertTrue(actualParseFromResult.getAttrsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Tag.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Tag.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Tag#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Tag.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Tag#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Tag.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link Tag#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Tag actualParseFromResult = Tag.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Tag actualParseFromResult = Tag.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Tag actualParseDelimitedFromResult = Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Tag.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Tag.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Tag.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Tag.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Tag actualParseDelimitedFromResult = Tag.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Tag.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Tag.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link Tag#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Tag#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag Tag.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    Tag defaultInstance = Tag.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

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
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
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

class ModelParameterDiffblueTest {
  /**
   * Test {@link ModelParameter#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelParameter.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelParameter.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ModelParameter#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor ModelParameter.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelParameter.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link ModelParameter#hasParamType()}.
   * <p>
   * Method under test: {@link ModelParameter#hasParamType()}
   */
  @Test
  @DisplayName("Test hasParamType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.hasParamType()"})
  void testHasParamType() {
    // Arrange, Act and Assert
    assertFalse(ModelParameter.getDefaultInstance().hasParamType());
  }

  /**
   * Test {@link ModelParameter#getParamType()}.
   * <p>
   * Method under test: {@link ModelParameter#getParamType()}
   */
  @Test
  @DisplayName("Test getParamType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDescriptor ModelParameter.getParamType()"})
  void testGetParamType() {
    // Arrange and Act
    TypeDescriptor actualParamType = ModelParameter.getDefaultInstance().getParamType();

    // Assert
    assertEquals("", actualParamType.getInitializationErrorString());
    assertEquals(0, actualParamType.getBasicTypeValue());
    assertEquals(0, actualParamType.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualParamType.getBasicType());
    assertFalse(actualParamType.hasArrayType());
    assertFalse(actualParamType.hasMapType());
    assertTrue(actualParamType.findInitializationErrors().isEmpty());
    assertTrue(actualParamType.getAllFields().isEmpty());
    assertTrue(actualParamType.isInitialized());
    assertSame(actualParamType, actualParamType.getArrayType());
    assertSame(actualParamType, actualParamType.getArrayTypeOrBuilder());
    assertSame(actualParamType, actualParamType.getDefaultInstanceForType());
    assertSame(actualParamType, actualParamType.getMapType());
    assertSame(actualParamType, actualParamType.getMapTypeOrBuilder());
  }

  /**
   * Test {@link ModelParameter#getLabel()}.
   * <p>
   * Method under test: {@link ModelParameter#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ModelParameter.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", ModelParameter.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link ModelParameter#getLabelBytes()}.
   * <p>
   * Method under test: {@link ModelParameter#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ModelParameter.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    ModelParameter defaultInstance = ModelParameter.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    Value defaultValue = defaultInstance.getDefaultValue();
    assertEquals(byteString, defaultValue.getDateValue().getIsoDateBytes());
    assertEquals(byteString, defaultValue.getDatetimeValue().getIsoDatetimeBytes());
    assertEquals(byteString, defaultValue.getDecimalValue().getDecimalBytes());
    assertEquals(byteString, actualLabelBytes);
    assertEquals(byteString, defaultValue.getStringValueBytes());
  }

  /**
   * Test {@link ModelParameter#hasDefaultValue()}.
   * <p>
   * Method under test: {@link ModelParameter#hasDefaultValue()}
   */
  @Test
  @DisplayName("Test hasDefaultValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.hasDefaultValue()"})
  void testHasDefaultValue() {
    // Arrange, Act and Assert
    assertFalse(ModelParameter.getDefaultInstance().hasDefaultValue());
  }

  /**
   * Test {@link ModelParameter#getDefaultValue()}.
   * <p>
   * Method under test: {@link ModelParameter#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelParameter.getDefaultValue()"})
  void testGetDefaultValue() {
    // Arrange and Act
    Value actualDefaultValue = ModelParameter.getDefaultInstance().getDefaultValue();

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
   * Test {@link ModelParameter#getParamPropsCount()}.
   * <p>
   * Method under test: {@link ModelParameter#getParamPropsCount()}
   */
  @Test
  @DisplayName("Test getParamPropsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelParameter.getParamPropsCount()"})
  void testGetParamPropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelParameter.getDefaultInstance().getParamPropsCount());
  }

  /**
   * Test {@link ModelParameter#containsParamProps(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#containsParamProps(String)}
   */
  @Test
  @DisplayName("Test containsParamProps(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.containsParamProps(String)"})
  void testContainsParamProps_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModelParameter.getDefaultInstance().containsParamProps("Key"));
  }

  /**
   * Test {@link ModelParameter#getParamProps()}.
   * <p>
   * Method under test: {@link ModelParameter#getParamProps()}
   */
  @Test
  @DisplayName("Test getParamProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelParameter.getParamProps()"})
  void testGetParamProps() {
    // Arrange, Act and Assert
    assertTrue(ModelParameter.getDefaultInstance().getParamProps().isEmpty());
  }

  /**
   * Test {@link ModelParameter#getParamPropsMap()}.
   * <p>
   * Method under test: {@link ModelParameter#getParamPropsMap()}
   */
  @Test
  @DisplayName("Test getParamPropsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map ModelParameter.getParamPropsMap()"})
  void testGetParamPropsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelParameter.getDefaultInstance().getParamPropsMap().isEmpty());
  }

  /**
   * Test {@link ModelParameter#getParamPropsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#getParamPropsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getParamPropsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelParameter.getParamPropsOrDefault(String, Value)"})
  void testGetParamPropsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    ModelParameter defaultInstance = ModelParameter.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParamPropsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link ModelParameter#getParamPropsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#getParamPropsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getParamPropsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value ModelParameter.getParamPropsOrThrow(String)"})
  void testGetParamPropsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelParameter.getDefaultInstance().getParamPropsOrThrow("Key"));
  }

  /**
   * Test {@link ModelParameter#isInitialized()}.
   * <p>
   * Method under test: {@link ModelParameter#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelParameter.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ModelParameter#getSerializedSize()}.
   * <p>
   * Method under test: {@link ModelParameter#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelParameter.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelParameter.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ModelParameter#equals(Object)}, and {@link ModelParameter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelParameter#equals(Object)}
   *   <li>{@link ModelParameter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.equals(Object)", "int ModelParameter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelParameter defaultInstance = ModelParameter.getDefaultInstance();
    ModelParameter defaultInstance2 = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ModelParameter#equals(Object)}, and {@link ModelParameter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModelParameter#equals(Object)}
   *   <li>{@link ModelParameter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.equals(Object)", "int ModelParameter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelParameter defaultInstance = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ModelParameter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.equals(Object)", "int ModelParameter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelParameter.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ModelParameter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.equals(Object)", "int ModelParameter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelParameter.getDefaultInstance(), null);
  }

  /**
   * Test {@link ModelParameter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ModelParameter.equals(Object)", "int ModelParameter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelParameter.getDefaultInstance(), "Different type to ModelParameter");
  }

  /**
   * Test {@link ModelParameter#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getParamPropsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasParamType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParamProps().isEmpty());
    assertTrue(actualParseFromResult.getParamPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getParamPropsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasParamType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParamProps().isEmpty());
    assertTrue(actualParseFromResult.getParamPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getParamPropsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasParamType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParamProps().isEmpty());
    assertTrue(actualParseFromResult.getParamPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getParamPropsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasParamType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParamProps().isEmpty());
    assertTrue(actualParseFromResult.getParamPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getParamPropsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasDefaultValue());
    assertFalse(actualParseFromResult.hasParamType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParamProps().isEmpty());
    assertTrue(actualParseFromResult.getParamPropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelParameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelParameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelParameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelParameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ModelParameter actualParseFromResult = ModelParameter.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelParameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelParameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        ModelParameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelParameter actualParseDelimitedFromResult = ModelParameter.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ModelParameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelParameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ModelParameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelParameter.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, ModelParameter.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ModelParameter actualParseDelimitedFromResult = ModelParameter.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelParameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelParameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ModelParameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ModelParameter#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ModelParameter#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelParameter ModelParameter.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelParameter defaultInstance = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

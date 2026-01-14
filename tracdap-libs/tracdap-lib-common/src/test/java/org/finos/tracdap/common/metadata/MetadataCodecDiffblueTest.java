package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.grpc.RequestMetadata;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.DateValue;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.finos.tracdap.metadata.Value.ValueCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataCodecDiffblueTest {
  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; then return SerializedSize is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_thenReturnSerializedSizeIsEighteen() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    Class<LocalDate> clazz = LocalDate.class;

    // Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject(ofResult, clazz);

    // Assert
    assertEquals(18, actualEncodeNativeObjectResult.getSerializedSize());
    assertEquals(ValueCase.DATEVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasDateValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; then return SerializedSize is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_thenReturnSerializedSizeIsEleven() {
    // Arrange
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Class<BigDecimal> clazz = BigDecimal.class;

    // Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject(bigDecimal, clazz);

    // Assert
    assertEquals(11, actualEncodeNativeObjectResult.getSerializedSize());
    assertEquals(ValueCase.DECIMALVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasDecimalValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>Then return StringValue is {@code java.lang.Long}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; then return StringValue is 'java.lang.Long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_thenReturnStringValueIsJavaLangLong() {
    // Arrange
    Class<String> clazz = String.class;

    // Act
    Value actualEncodeNativeObjectResult =
        MetadataCodec.encodeNativeObject("java.lang.Long", clazz);

    // Assert
    assertEquals("java.lang.Long", actualEncodeNativeObjectResult.getStringValue());
    assertEquals(20, actualEncodeNativeObjectResult.getSerializedSize());
    assertEquals(ValueCase.STRINGVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasStringValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> MetadataCodec.encodeNativeObject("Value", clazz));
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return ValueCase is {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; when 'true'; then return ValueCase is 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_whenTrue_thenReturnValueCaseIsBooleanvalue() {
    // Arrange
    Class<Boolean> clazz = Boolean.class;

    // Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject(true, clazz);

    // Assert
    assertEquals(ValueCase.BOOLEANVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.getBooleanValue());
    assertTrue(actualEncodeNativeObjectResult.hasBooleanValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object)} with {@code value}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object) with 'value'; then return SerializedSize is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object)"})
  void testEncodeNativeObjectWithValue_thenReturnSerializedSizeIsEighteen() {
    // Arrange and Act
    Value actualEncodeNativeObjectResult =
        MetadataCodec.encodeNativeObject(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(18, actualEncodeNativeObjectResult.getSerializedSize());
    assertEquals(ValueCase.DATEVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasDateValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object)} with {@code value}.
   *
   * <ul>
   *   <li>Then return ValueCase is {@code DATETIMEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object) with 'value'; then return ValueCase is 'DATETIMEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object)"})
  void testEncodeNativeObjectWithValue_thenReturnValueCaseIsDatetimevalue() {
    // Arrange and Act
    Value actualEncodeNativeObjectResult =
        MetadataCodec.encodeNativeObject(RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP);

    // Assert
    assertEquals(ValueCase.DATETIMEVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasDatetimeValue());
    assertEquals(Integer.SIZE, actualEncodeNativeObjectResult.getSerializedSize());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object)} with {@code value}.
   *
   * <ul>
   *   <li>Then return ValueCase is {@code DECIMALVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object) with 'value'; then return ValueCase is 'DECIMALVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object)"})
  void testEncodeNativeObjectWithValue_thenReturnValueCaseIsDecimalvalue() {
    // Arrange and Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject(new BigDecimal("2.3"));

    // Assert
    assertEquals(ValueCase.DECIMALVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasDecimalValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return ValueCase is {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object) with 'value'; when 'true'; then return ValueCase is 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object)"})
  void testEncodeNativeObjectWithValue_whenTrue_thenReturnValueCaseIsBooleanvalue() {
    // Arrange and Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject(true);

    // Assert
    assertEquals(ValueCase.BOOLEANVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.getBooleanValue());
    assertTrue(actualEncodeNativeObjectResult.hasBooleanValue());
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return StringValue is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object) with 'value'; when 'Value'; then return StringValue is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object)"})
  void testEncodeNativeObjectWithValue_whenValue_thenReturnStringValueIsValue() {
    // Arrange and Act
    Value actualEncodeNativeObjectResult = MetadataCodec.encodeNativeObject("Value");

    // Assert
    assertEquals("Value", actualEncodeNativeObjectResult.getStringValue());
    assertEquals(ValueCase.STRINGVALUE, actualEncodeNativeObjectResult.getValueCase());
    assertTrue(actualEncodeNativeObjectResult.hasStringValue());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(BigDecimal)} with {@code BigDecimal}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(BigDecimal) with 'BigDecimal'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(BigDecimal)"})
  void testEncodeValueWithBigDecimal_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(new BigDecimal("2.3"));

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(11, actualEncodeValueResult.getSerializedSize());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(ValueCase.DECIMALVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasDecimalValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(boolean)}
   */
  @Test
  @DisplayName("Test encodeValue(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(boolean)"})
  void testEncodeValueWithBoolean() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(true);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(6, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.BOOLEANVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.getBooleanValue());
    assertTrue(actualEncodeValueResult.hasBooleanValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(double)} with {@code double}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(double)}
   */
  @Test
  @DisplayName("Test encodeValue(double) with 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(double)"})
  void testEncodeValueWithDouble() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(10.0d);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(10.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(13, actualEncodeValueResult.getSerializedSize());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(ValueCase.FLOATVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasFloatValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(float)} with {@code float}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(float)}
   */
  @Test
  @DisplayName("Test encodeValue(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(float)"})
  void testEncodeValueWithFloat() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(10.0f);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(10.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(13, actualEncodeValueResult.getSerializedSize());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(ValueCase.FLOATVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasFloatValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(int)} with {@code int}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(int)}
   */
  @Test
  @DisplayName("Test encodeValue(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(int)"})
  void testEncodeValueWithInt() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(42);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(42L, actualEncodeValueResult.getIntegerValue());
    assertEquals(6, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.INTEGERVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasIntegerValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(LocalDate)} with {@code LocalDate}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(LocalDate) with 'LocalDate'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(LocalDate)"})
  void testEncodeValueWithLocalDate_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(18, actualEncodeValueResult.getSerializedSize());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(ValueCase.DATEVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasDateValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(long)} with {@code long}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(long)}
   */
  @Test
  @DisplayName("Test encodeValue(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(long)"})
  void testEncodeValueWithLong() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(42L);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(42L, actualEncodeValueResult.getIntegerValue());
    assertEquals(6, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.INTEGERVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasIntegerValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, BasicType)} with {@code Object}, {@code
   * BasicType}.
   *
   * <ul>
   *   <li>Then return StringValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, BasicType) with 'Object', 'BasicType'; then return StringValue is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, BasicType)"})
  void testEncodeValueWithObjectBasicType_thenReturnStringValueIsEmptyString() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(42, BasicType.INTEGER);

    // Assert
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(42L, actualEncodeValueResult.getIntegerValue());
    assertEquals(6, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.INTEGERVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.hasIntegerValue());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, BasicType)} with {@code Object}, {@code
   * BasicType}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return StringValue is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, BasicType) with 'Object', 'BasicType'; when 'STRING'; then return StringValue is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, BasicType)"})
  void testEncodeValueWithObjectBasicType_whenString_thenReturnStringValueIsValue() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue("Value", BasicType.STRING);

    // Assert
    assertEquals("Value", actualEncodeValueResult.getStringValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(11, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.STRINGVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertTrue(actualEncodeValueResult.hasStringValue());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, BasicType)} with {@code Object}, {@code
   * BasicType}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, BasicType) with 'Object', 'BasicType'; when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, BasicType)"})
  void testEncodeValueWithObjectBasicType_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> MetadataCodec.encodeValue("Value", BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Test {@link MetadataCodec#encodeValue(OffsetDateTime)} with {@code OffsetDateTime}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(OffsetDateTime)}
   */
  @Test
  @DisplayName("Test encodeValue(OffsetDateTime) with 'OffsetDateTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(OffsetDateTime)"})
  void testEncodeValueWithOffsetDateTime() {
    // Arrange and Act
    Value actualEncodeValueResult =
        MetadataCodec.encodeValue(RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP);

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(ValueCase.DATETIMEVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertFalse(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasDatetimeValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
    assertEquals(Integer.SIZE, actualEncodeValueResult.getSerializedSize());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(String)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(String) with 'String'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(String)"})
  void testEncodeValueWithString_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue("42");

    // Assert
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("42", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
    assertEquals(8, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.STRINGVALUE, actualEncodeValueResult.getValueCase());
    assertFalse(actualEncodeValueResult.getBooleanValue());
    assertFalse(actualEncodeValueResult.hasArrayValue());
    assertFalse(actualEncodeValueResult.hasBooleanValue());
    assertFalse(actualEncodeValueResult.hasDateValue());
    assertFalse(actualEncodeValueResult.hasDatetimeValue());
    assertFalse(actualEncodeValueResult.hasDecimalValue());
    assertFalse(actualEncodeValueResult.hasFloatValue());
    assertFalse(actualEncodeValueResult.hasIntegerValue());
    assertFalse(actualEncodeValueResult.hasMapValue());
    assertTrue(actualEncodeValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeValueResult.hasStringValue());
    assertTrue(actualEncodeValueResult.hasType());
    assertTrue(actualEncodeValueResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeDate(LocalDate)}, and {@link
   * MetadataCodec#decodeDate(DateValue)}.
   *
   * <ul>
   *   <li>Then return decodeDate is {@link LocalDate} with {@code 1970} and one and one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MetadataCodec#encodeDate(LocalDate)}
   *   <li>{@link MetadataCodec#decodeDate(DateValue)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeDate(LocalDate), and decodeDate(DateValue); then return decodeDate is LocalDate with '1970' and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DateValue MetadataCodec.encodeDate(LocalDate)",
    "LocalDate MetadataCodec.decodeDate(DateValue)"
  })
  void testEncodeDateAndDecodeDate_thenReturnDecodeDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    LocalDate date = LocalDate.of(1970, 1, 1);

    // Act and Assert
    assertEquals(date, MetadataCodec.decodeDate(MetadataCodec.encodeDate(date)));
  }

  /**
   * Test {@link MetadataCodec#encodeDatetime(OffsetDateTime)}, and {@link
   * MetadataCodec#decodeDatetime(DatetimeValue)}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MetadataCodec#encodeDatetime(OffsetDateTime)}
   *   <li>{@link MetadataCodec#decodeDatetime(DatetimeValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeDatetime(OffsetDateTime), and decodeDatetime(DatetimeValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatetimeValue MetadataCodec.encodeDatetime(OffsetDateTime)",
    "OffsetDateTime MetadataCodec.decodeDatetime(DatetimeValue)"
  })
  void testEncodeDatetimeAndDecodeDatetime() {
    // Arrange
    OffsetDateTime datetime = RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP;

    // Act and Assert
    assertEquals(datetime, MetadataCodec.decodeDatetime(MetadataCodec.encodeDatetime(datetime)));
  }

  /**
   * Test {@link MetadataCodec#encodeDatetime(Instant)} with {@code Instant}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeDatetime(Instant)}
   */
  @Test
  @DisplayName("Test encodeDatetime(Instant) with 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DatetimeValue MetadataCodec.encodeDatetime(Instant)"})
  void testEncodeDatetimeWithInstant() {
    // Arrange and Act
    DatetimeValue actualEncodeDatetimeResult =
        MetadataCodec.encodeDatetime(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("", actualEncodeDatetimeResult.getInitializationErrorString());
    assertEquals("1970-01-01T00:00:00.000Z", actualEncodeDatetimeResult.getIsoDatetime());
    assertEquals(1, actualEncodeDatetimeResult.getAllFields().size());
    assertEquals(26, actualEncodeDatetimeResult.getSerializedSize());
    assertTrue(actualEncodeDatetimeResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeDatetimeResult.isInitialized());
  }

  /**
   * Test {@link MetadataCodec#encodeArrayValue(List, TypeDescriptor)} with {@code arrayValue},
   * {@code arrayType}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeArrayValue(List, TypeDescriptor)}
   */
  @Test
  @DisplayName("Test encodeArrayValue(List, TypeDescriptor) with 'arrayValue', 'arrayType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeArrayValue(List, TypeDescriptor)"})
  void testEncodeArrayValueWithArrayValueArrayType() {
    // Arrange and Act
    Value actualEncodeArrayValueResult =
        MetadataCodec.encodeArrayValue(new ArrayList<>(), TypeDescriptor.getDefaultInstance());

    // Assert
    assertEquals("", actualEncodeArrayValueResult.getInitializationErrorString());
    assertEquals("", actualEncodeArrayValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeArrayValueResult.getFloatValue());
    assertEquals(0L, actualEncodeArrayValueResult.getIntegerValue());
    assertEquals(2, actualEncodeArrayValueResult.getAllFields().size());
    assertEquals(8, actualEncodeArrayValueResult.getSerializedSize());
    assertEquals(ValueCase.ARRAYVALUE, actualEncodeArrayValueResult.getValueCase());
    assertFalse(actualEncodeArrayValueResult.getBooleanValue());
    assertFalse(actualEncodeArrayValueResult.hasBooleanValue());
    assertFalse(actualEncodeArrayValueResult.hasDateValue());
    assertFalse(actualEncodeArrayValueResult.hasDatetimeValue());
    assertFalse(actualEncodeArrayValueResult.hasDecimalValue());
    assertFalse(actualEncodeArrayValueResult.hasFloatValue());
    assertFalse(actualEncodeArrayValueResult.hasIntegerValue());
    assertFalse(actualEncodeArrayValueResult.hasMapValue());
    assertFalse(actualEncodeArrayValueResult.hasStringValue());
    assertTrue(actualEncodeArrayValueResult.findInitializationErrors().isEmpty());
    assertTrue(actualEncodeArrayValueResult.hasArrayValue());
    assertTrue(actualEncodeArrayValueResult.hasType());
    assertTrue(actualEncodeArrayValueResult.isInitialized());
  }
}

package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   *   <li>Then return StringValue is {@code Integer}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; then return StringValue is 'java.lang.Integer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_thenReturnStringValueIsJavaLangInteger() {
    // Arrange
    Class<String> clazz = String.class;

    // Act
    Value actualEncodeNativeObjectResult =
        MetadataCodec.encodeNativeObject("java.lang.Integer", clazz);

    // Assert
    assertEquals("java.lang.Integer", actualEncodeNativeObjectResult.getStringValue());
    assertEquals(23, actualEncodeNativeObjectResult.getSerializedSize());
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
   *   <li>When forty-two.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; when forty-two; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_whenFortyTwo_thenDoesNotThrow() {
    // Arrange
    Class<Integer> clazz = Integer.class;

    // Act
    assertDoesNotThrow(() -> MetadataCodec.encodeNativeObject(42, clazz));
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Long}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; when 'java.lang.Long'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_whenJavaLangLong_thenDoesNotThrow() {
    // Arrange
    Class<Long> clazz = Long.class;

    // Act
    assertDoesNotThrow(() -> MetadataCodec.encodeNativeObject(42L, clazz));
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; when ten; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_whenTen_thenDoesNotThrow() {
    // Arrange
    Class<Double> clazz = Double.class;

    // Act
    assertDoesNotThrow(() -> MetadataCodec.encodeNativeObject(10.0d, clazz));
  }

  /**
   * Test {@link MetadataCodec#encodeNativeObject(Object, Class)} with {@code value}, {@code clazz}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test encodeNativeObject(Object, Class) with 'value', 'clazz'; when ten; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeNativeObject(Object, Class)"})
  void testEncodeNativeObjectWithValueClazz_whenTen_thenDoesNotThrow2() {
    // Arrange
    Class<Float> clazz = Float.class;

    // Act
    assertDoesNotThrow(() -> MetadataCodec.encodeNativeObject(10.0f, clazz));
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
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, BasicType)} with {@code Object}, {@code
   * BasicType}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return IntegerValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, BasicType) with 'Object', 'BasicType'; when forty-two; then return IntegerValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, BasicType)"})
  void testEncodeValueWithObjectBasicType_whenFortyTwo_thenReturnIntegerValueIsFortyTwo() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(42, BasicType.INTEGER);

    // Assert
    assertEquals(42L, actualEncodeValueResult.getIntegerValue());
    assertEquals(ValueCase.INTEGERVALUE, actualEncodeValueResult.getValueCase());
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
    assertEquals(11, actualEncodeValueResult.getSerializedSize());
    assertEquals(ValueCase.STRINGVALUE, actualEncodeValueResult.getValueCase());
    assertTrue(actualEncodeValueResult.hasStringValue());
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, BasicType)} with {@code Object}, {@code
   * BasicType}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return ValueCase is {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, BasicType) with 'Object', 'BasicType'; when 'true'; then return ValueCase is 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, BasicType)"})
  void testEncodeValueWithObjectBasicType_whenTrue_thenReturnValueCaseIsBooleanvalue() {
    // Arrange and Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue(true, BasicType.BOOLEAN);

    // Assert
    assertEquals(ValueCase.BOOLEANVALUE, actualEncodeValueResult.getValueCase());
    assertTrue(actualEncodeValueResult.getBooleanValue());
    assertTrue(actualEncodeValueResult.hasBooleanValue());
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
   * Test {@link MetadataCodec#encodeValue(Object, TypeDescriptor)} with {@code Object}, {@code
   * TypeDescriptor}.
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, TypeDescriptor)}
   */
  @Test
  @DisplayName("Test encodeValue(Object, TypeDescriptor) with 'Object', 'TypeDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, TypeDescriptor)"})
  void testEncodeValueWithObjectTypeDescriptor() {
    // Arrange
    TypeDescriptor descriptor = mock(TypeDescriptor.class);
    when(descriptor.getBasicType()).thenReturn(BasicType.STRING);

    // Act
    Value actualEncodeValueResult = MetadataCodec.encodeValue("Value", descriptor);

    // Assert
    verify(descriptor).getBasicType();
    assertEquals("", actualEncodeValueResult.getInitializationErrorString());
    assertEquals("Value", actualEncodeValueResult.getStringValue());
    assertEquals(0.0d, actualEncodeValueResult.getFloatValue());
    assertEquals(0L, actualEncodeValueResult.getIntegerValue());
    assertEquals(11, actualEncodeValueResult.getSerializedSize());
    assertEquals(2, actualEncodeValueResult.getAllFields().size());
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
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, TypeDescriptor)} with {@code Object}, {@code
   * TypeDescriptor}.
   *
   * <ul>
   *   <li>Given {@link BasicType#ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, TypeDescriptor) with 'Object', 'TypeDescriptor'; given ARRAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, TypeDescriptor)"})
  void testEncodeValueWithObjectTypeDescriptor_givenArray() {
    // Arrange
    TypeDescriptor descriptor = mock(TypeDescriptor.class);
    when(descriptor.getBasicType()).thenReturn(BasicType.ARRAY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> MetadataCodec.encodeValue("Value", descriptor));
    verify(descriptor).getBasicType();
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, TypeDescriptor)} with {@code Object}, {@code
   * TypeDescriptor}.
   *
   * <ul>
   *   <li>Given {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, TypeDescriptor) with 'Object', 'TypeDescriptor'; given 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, TypeDescriptor)"})
  void testEncodeValueWithObjectTypeDescriptor_givenBoolean() {
    // Arrange
    TypeDescriptor descriptor = mock(TypeDescriptor.class);
    when(descriptor.getBasicType()).thenReturn(BasicType.BOOLEAN);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> MetadataCodec.encodeValue("Value", descriptor));
    verify(descriptor).getBasicType();
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, TypeDescriptor)} with {@code Object}, {@code
   * TypeDescriptor}.
   *
   * <ul>
   *   <li>Given {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, TypeDescriptor) with 'Object', 'TypeDescriptor'; given 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, TypeDescriptor)"})
  void testEncodeValueWithObjectTypeDescriptor_givenMap() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    TypeDescriptor descriptor = mock(TypeDescriptor.class);
    when(descriptor.getBasicType()).thenReturn(BasicType.MAP);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> MetadataCodec.encodeValue(objectList, descriptor));
    verify(descriptor).getBasicType();
  }

  /**
   * Test {@link MetadataCodec#encodeValue(Object, TypeDescriptor)} with {@code Object}, {@code
   * TypeDescriptor}.
   *
   * <ul>
   *   <li>Then calls {@link TypeDescriptor#getArrayType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#encodeValue(Object, TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test encodeValue(Object, TypeDescriptor) with 'Object', 'TypeDescriptor'; then calls getArrayType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MetadataCodec.encodeValue(Object, TypeDescriptor)"})
  void testEncodeValueWithObjectTypeDescriptor_thenCallsGetArrayType() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    TypeDescriptor descriptor = mock(TypeDescriptor.class);
    when(descriptor.getArrayType()).thenThrow(new IllegalArgumentException());
    when(descriptor.getBasicType()).thenReturn(BasicType.ARRAY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> MetadataCodec.encodeValue(objectList, descriptor));
    verify(descriptor).getArrayType();
    verify(descriptor).getBasicType();
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
  }

  /**
   * Test {@link MetadataCodec#decodeValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Value} {@link Value#getBooleanValue()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeValue(Value); given 'false'; when Value getBooleanValue() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetadataCodec.decodeValue(Value)"})
  void testDecodeValue_givenFalse_whenValueGetBooleanValueReturnFalse_thenReturnFalse() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenReturn(false);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act
    Object actualDecodeValueResult = MetadataCodec.decodeValue(value);

    // Assert
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertFalse((Boolean) actualDecodeValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Value} {@link Value#getBooleanValue()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeValue(Value); given 'true'; when Value getBooleanValue() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetadataCodec.decodeValue(Value)"})
  void testDecodeValue_givenTrue_whenValueGetBooleanValueReturnTrue_thenReturnTrue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenReturn(true);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act
    Object actualDecodeValueResult = MetadataCodec.decodeValue(value);

    // Assert
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertTrue((Boolean) actualDecodeValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getBooleanValue()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeValue(Value); when Value getBooleanValue() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetadataCodec.decodeValue(Value)"})
  void testDecodeValue_whenValueGetBooleanValueThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeValue(value));
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeValue(Value); when Value getType() throw IllegalArgumentException(); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetadataCodec.decodeValue(Value)"})
  void testDecodeValue_whenValueGetTypeThrowIllegalArgumentException_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#hasType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeValue(Value)}
   */
  @Test
  @DisplayName("Test decodeValue(Value); when Value hasType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetadataCodec.decodeValue(Value)"})
  void testDecodeValue_whenValueHasTypeThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeValue(value));
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code INTEGERVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code INTEGERVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeBooleanValue(Value); given 'INTEGERVALUE'; when Value getValueCase() return 'INTEGERVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_givenIntegervalue_whenValueGetValueCaseReturnIntegervalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.INTEGERVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeBooleanValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName("Test decodeBooleanValue(Value); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeBooleanValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getBooleanValue()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeBooleanValue(Value); when Value getBooleanValue() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_whenValueGetBooleanValueReturnFalse_thenReturnFalse() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenReturn(false);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act
    boolean actualDecodeBooleanValueResult = MetadataCodec.decodeBooleanValue(value);

    // Assert
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertFalse(actualDecodeBooleanValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getBooleanValue()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeBooleanValue(Value); when Value getBooleanValue() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_whenValueGetBooleanValueReturnTrue_thenReturnTrue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenReturn(true);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act
    boolean actualDecodeBooleanValueResult = MetadataCodec.decodeBooleanValue(value);

    // Assert
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertTrue(actualDecodeBooleanValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getBooleanValue()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeBooleanValue(Value); when Value getBooleanValue() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_whenValueGetBooleanValueThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getBooleanValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeBooleanValue(value));
    verify(value).getBooleanValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeBooleanValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#hasType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeBooleanValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeBooleanValue(Value); when Value hasType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataCodec.decodeBooleanValue(Value)"})
  void testDecodeBooleanValue_whenValueHasTypeThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeBooleanValue(value));
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeIntegerValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeIntegerValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeIntegerValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataCodec.decodeIntegerValue(Value)"})
  void testDecodeIntegerValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeIntegerValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeIntegerValue(Value)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeIntegerValue(Value)}
   */
  @Test
  @DisplayName("Test decodeIntegerValue(Value); given forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataCodec.decodeIntegerValue(Value)"})
  void testDecodeIntegerValue_givenFortyTwo_thenReturnFortyTwo() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getIntegerValue()).thenReturn(42L);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.INTEGERVALUE);

    // Act
    long actualDecodeIntegerValueResult = MetadataCodec.decodeIntegerValue(value);

    // Assert
    verify(value).getIntegerValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertEquals(42L, actualDecodeIntegerValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeIntegerValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeIntegerValue(Value)}
   */
  @Test
  @DisplayName("Test decodeIntegerValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataCodec.decodeIntegerValue(Value)"})
  void testDecodeIntegerValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeIntegerValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeIntegerValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getIntegerValue()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeIntegerValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeIntegerValue(Value); when Value getIntegerValue() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataCodec.decodeIntegerValue(Value)"})
  void testDecodeIntegerValue_whenValueGetIntegerValueThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getIntegerValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.INTEGERVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeIntegerValue(value));
    verify(value).getIntegerValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeFloatValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeFloatValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeFloatValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataCodec.decodeFloatValue(Value)"})
  void testDecodeFloatValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeFloatValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeFloatValue(Value)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link Value} {@link Value#getFloatValue()} return ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeFloatValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeFloatValue(Value); given ten; when Value getFloatValue() return ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataCodec.decodeFloatValue(Value)"})
  void testDecodeFloatValue_givenTen_whenValueGetFloatValueReturnTen_thenReturnTen() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getFloatValue()).thenReturn(10.0d);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.FLOATVALUE);

    // Act
    double actualDecodeFloatValueResult = MetadataCodec.decodeFloatValue(value);

    // Assert
    verify(value).getFloatValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertEquals(10.0d, actualDecodeFloatValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeFloatValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeFloatValue(Value)}
   */
  @Test
  @DisplayName("Test decodeFloatValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataCodec.decodeFloatValue(Value)"})
  void testDecodeFloatValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeFloatValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeFloatValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getFloatValue()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeFloatValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeFloatValue(Value); when Value getFloatValue() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataCodec.decodeFloatValue(Value)"})
  void testDecodeFloatValue_whenValueGetFloatValueThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getFloatValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.FLOATVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeFloatValue(value));
    verify(value).getFloatValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeStringValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Value} {@link Value#getStringValue()} return {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeStringValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeStringValue(Value); given '42'; when Value getStringValue() return '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetadataCodec.decodeStringValue(Value)"})
  void testDecodeStringValue_given42_whenValueGetStringValueReturn42_thenReturn42() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getStringValue()).thenReturn("42");
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.STRINGVALUE);

    // Act
    String actualDecodeStringValueResult = MetadataCodec.decodeStringValue(value);

    // Assert
    verify(value).getStringValue();
    verify(value).getValueCase();
    verify(value).hasType();
    assertEquals("42", actualDecodeStringValueResult);
  }

  /**
   * Test {@link MetadataCodec#decodeStringValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeStringValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeStringValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetadataCodec.decodeStringValue(Value)"})
  void testDecodeStringValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeStringValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeStringValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeStringValue(Value)}
   */
  @Test
  @DisplayName("Test decodeStringValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetadataCodec.decodeStringValue(Value)"})
  void testDecodeStringValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeStringValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeStringValue(Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#getStringValue()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeStringValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeStringValue(Value); when Value getStringValue() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetadataCodec.decodeStringValue(Value)"})
  void testDecodeStringValue_whenValueGetStringValueThrowIllegalArgumentException() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getStringValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.STRINGVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeStringValue(value));
    verify(value).getStringValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDecimalValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDecimalValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeDecimalValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal MetadataCodec.decodeDecimalValue(Value)"})
  void testDecodeDecimalValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDecimalValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDecimalValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code DECIMALVALUE}.
   *   <li>Then calls {@link Value#getDecimalValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDecimalValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDecimalValue(Value); given 'DECIMALVALUE'; then calls getDecimalValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal MetadataCodec.decodeDecimalValue(Value)"})
  void testDecodeDecimalValue_givenDecimalvalue_thenCallsGetDecimalValue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getDecimalValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.DECIMALVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDecimalValue(value));
    verify(value).getDecimalValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDecimalValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDecimalValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDecimalValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal MetadataCodec.decodeDecimalValue(Value)"})
  void testDecodeDecimalValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDecimalValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeDateValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate MetadataCodec.decodeDateValue(Value)"})
  void testDecodeDateValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code DATEVALUE}.
   *   <li>Then calls {@link Value#getDateValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDateValue(Value); given 'DATEVALUE'; then calls getDateValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate MetadataCodec.decodeDateValue(Value)"})
  void testDecodeDateValue_givenDatevalue_thenCallsGetDateValue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getDateValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.DATEVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateValue(value));
    verify(value).getDateValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDateValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate MetadataCodec.decodeDateValue(Value)"})
  void testDecodeDateValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateTimeValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateTimeValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDateTimeValue(Value); given 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OffsetDateTime MetadataCodec.decodeDateTimeValue(Value)"})
  void testDecodeDateTimeValue_givenBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateTimeValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateTimeValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code DATETIMEVALUE}.
   *   <li>Then calls {@link Value#getDatetimeValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateTimeValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeDateTimeValue(Value); given 'DATETIMEVALUE'; then calls getDatetimeValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OffsetDateTime MetadataCodec.decodeDateTimeValue(Value)"})
  void testDecodeDateTimeValue_givenDatetimevalue_thenCallsGetDatetimeValue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getDatetimeValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.DATETIMEVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateTimeValue(value));
    verify(value).getDatetimeValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeDateTimeValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeDateTimeValue(Value)}
   */
  @Test
  @DisplayName("Test decodeDateTimeValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OffsetDateTime MetadataCodec.decodeDateTimeValue(Value)"})
  void testDecodeDateTimeValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeDateTimeValue(value));
    verify(value).getType();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeArrayValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code ARRAYVALUE}.
   *   <li>Then calls {@link Value#getArrayValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeArrayValue(Value)}
   */
  @Test
  @DisplayName("Test decodeArrayValue(Value); given 'ARRAYVALUE'; then calls getArrayValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MetadataCodec.decodeArrayValue(Value)"})
  void testDecodeArrayValue_givenArrayvalue_thenCallsGetArrayValue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getArrayValue()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.ARRAYVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeArrayValue(value));
    verify(value).getArrayValue();
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeArrayValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEANVALUE}.
   *   <li>When {@link Value} {@link Value#getValueCase()} return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeArrayValue(Value)}
   */
  @Test
  @DisplayName(
      "Test decodeArrayValue(Value); given 'BOOLEANVALUE'; when Value getValueCase() return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MetadataCodec.decodeArrayValue(Value)"})
  void testDecodeArrayValue_givenBooleanvalue_whenValueGetValueCaseReturnBooleanvalue() {
    // Arrange
    Value value = mock(Value.class);
    when(value.hasType()).thenReturn(false);
    when(value.getValueCase()).thenReturn(ValueCase.BOOLEANVALUE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeArrayValue(value));
    verify(value).getValueCase();
    verify(value).hasType();
  }

  /**
   * Test {@link MetadataCodec#decodeArrayValue(Value)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link Value#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataCodec#decodeArrayValue(Value)}
   */
  @Test
  @DisplayName("Test decodeArrayValue(Value); given 'true'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MetadataCodec.decodeArrayValue(Value)"})
  void testDecodeArrayValue_givenTrue_thenCallsGetType() {
    // Arrange
    Value value = mock(Value.class);
    when(value.getType()).thenThrow(new IllegalArgumentException());
    when(value.hasType()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.decodeArrayValue(value));
    verify(value).getType();
    verify(value).hasType();
  }
}

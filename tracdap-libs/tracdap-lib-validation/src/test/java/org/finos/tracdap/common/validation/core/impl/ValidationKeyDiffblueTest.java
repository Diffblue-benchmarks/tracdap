package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationKeyDiffblueTest {
  /**
   * Test {@link ValidationKey#forObject(Descriptor)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then return displayName is {@code Any STATIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#forObject(Descriptor)}
   */
  @Test
  @DisplayName("Test forObject(Descriptor); when Descriptor; then return displayName is 'Any STATIC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationKey ValidationKey.forObject(Descriptor)"})
  void testForObject_whenDescriptor_thenReturnDisplayNameIsAnyStatic() {
    // Arrange and Act
    ValidationKey actualForObjectResult = ValidationKey.forObject(Any.getDescriptor());

    // Assert
    assertEquals("Any STATIC", actualForObjectResult.displayName());
    assertEquals("Any", actualForObjectResult.shortName());
    assertEquals(ValidationType.STATIC, actualForObjectResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forMethod(Descriptor, MethodDescriptor)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then return displayName is {@code Any STATIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#forMethod(Descriptor, MethodDescriptor)}
   */
  @Test
  @DisplayName("Test forMethod(Descriptor, MethodDescriptor); when Descriptor; then return displayName is 'Any STATIC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationKey ValidationKey.forMethod(Descriptor, MethodDescriptor)"})
  void testForMethod_whenDescriptor_thenReturnDisplayNameIsAnyStatic() {
    // Arrange and Act
    ValidationKey actualForMethodResult = ValidationKey.forMethod(Any.getDescriptor(), null);

    // Assert
    assertEquals("Any STATIC", actualForMethodResult.displayName());
    assertEquals("Any", actualForMethodResult.shortName());
    assertEquals(ValidationType.STATIC, actualForMethodResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forVersion(Descriptor)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then return displayName is {@code Any VERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#forVersion(Descriptor)}
   */
  @Test
  @DisplayName("Test forVersion(Descriptor); when Descriptor; then return displayName is 'Any VERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationKey ValidationKey.forVersion(Descriptor)"})
  void testForVersion_whenDescriptor_thenReturnDisplayNameIsAnyVersion() {
    // Arrange and Act
    ValidationKey actualForVersionResult = ValidationKey.forVersion(Any.getDescriptor());

    // Assert
    assertEquals("Any VERSION", actualForVersionResult.displayName());
    assertEquals("Any", actualForVersionResult.shortName());
    assertEquals(ValidationType.VERSION, actualForVersionResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forConsistency(Descriptor)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then return displayName is {@code Any CONSISTENCY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#forConsistency(Descriptor)}
   */
  @Test
  @DisplayName("Test forConsistency(Descriptor); when Descriptor; then return displayName is 'Any CONSISTENCY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationKey ValidationKey.forConsistency(Descriptor)"})
  void testForConsistency_whenDescriptor_thenReturnDisplayNameIsAnyConsistency() {
    // Arrange and Act
    ValidationKey actualForConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Assert
    assertEquals("Any CONSISTENCY", actualForConsistencyResult.displayName());
    assertEquals("Any", actualForConsistencyResult.shortName());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
  }

  /**
   * Test {@link ValidationKey#ValidationKey(ValidationType, Descriptor)}.
   * <ul>
   *   <li>When {@code STATIC}.</li>
   *   <li>Then return displayName is {@code Any STATIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#ValidationKey(ValidationType, Descriptor)}
   */
  @Test
  @DisplayName("Test new ValidationKey(ValidationType, Descriptor); when 'STATIC'; then return displayName is 'Any STATIC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationKey.<init>(ValidationType, Descriptor)"})
  void testNewValidationKey_whenStatic_thenReturnDisplayNameIsAnyStatic() {
    // Arrange and Act
    ValidationKey actualValidationKey = new ValidationKey(ValidationType.STATIC, Any.getDescriptor());

    // Assert
    assertEquals("Any STATIC", actualValidationKey.displayName());
    assertEquals("Any", actualValidationKey.shortName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }

  /**
   * Test {@link ValidationKey#ValidationKey(ValidationType, Descriptor, MethodDescriptor)}.
   * <ul>
   *   <li>When {@code STATIC}.</li>
   *   <li>Then return displayName is {@code Any STATIC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#ValidationKey(ValidationType, Descriptor, MethodDescriptor)}
   */
  @Test
  @DisplayName("Test new ValidationKey(ValidationType, Descriptor, MethodDescriptor); when 'STATIC'; then return displayName is 'Any STATIC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationKey.<init>(ValidationType, Descriptor, MethodDescriptor)"})
  void testNewValidationKey_whenStatic_thenReturnDisplayNameIsAnyStatic2() {
    // Arrange and Act
    ValidationKey actualValidationKey = new ValidationKey(ValidationType.STATIC, Any.getDescriptor(), null);

    // Assert
    assertEquals("Any STATIC", actualValidationKey.displayName());
    assertEquals("Any", actualValidationKey.shortName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }

  /**
   * Test {@link ValidationKey#compareTo(ValidationKey)} with {@code ValidationKey}.
   * <ul>
   *   <li>When forConsistency Descriptor.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#compareTo(ValidationKey)}
   */
  @Test
  @DisplayName("Test compareTo(ValidationKey) with 'ValidationKey'; when forConsistency Descriptor; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ValidationKey.compareTo(ValidationKey)"})
  void testCompareToWithValidationKey_whenForConsistencyDescriptor_thenReturnZero() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Act and Assert
    assertEquals(0, forConsistencyResult.compareTo(ValidationKey.forConsistency(Any.getDescriptor())));
  }

  /**
   * Test {@link ValidationKey#equals(Object)}, and {@link ValidationKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());
    ValidationKey forConsistencyResult2 = ValidationKey.forConsistency(Any.getDescriptor());

    // Act and Assert
    assertEquals(forConsistencyResult, forConsistencyResult2);
    int expectedHashCodeResult = forConsistencyResult.hashCode();
    assertEquals(expectedHashCodeResult, forConsistencyResult2.hashCode());
  }

  /**
   * Test {@link ValidationKey#equals(Object)}, and {@link ValidationKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Act and Assert
    assertEquals(forConsistencyResult, forConsistencyResult);
    int expectedHashCodeResult = forConsistencyResult.hashCode();
    assertEquals(expectedHashCodeResult, forConsistencyResult.hashCode());
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Api.getDescriptor());

    // Act and Assert
    assertNotEquals(forConsistencyResult, ValidationKey.forConsistency(Any.getDescriptor()));
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValidationKey.forConsistency(Any.getDescriptor()), null);
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValidationKey.forConsistency(Any.getDescriptor()), "Different type to ValidationKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#displayName()}
   *   <li>{@link ValidationKey#shortName()}
   *   <li>{@link ValidationKey#validationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationKey.displayName()", "String ValidationKey.shortName()",
      "ValidationType ValidationKey.validationType()"})
  void testGettersAndSetters() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Act
    String actualDisplayNameResult = forConsistencyResult.displayName();
    String actualShortNameResult = forConsistencyResult.shortName();

    // Assert
    assertEquals("Any CONSISTENCY", actualDisplayNameResult);
    assertEquals("Any", actualShortNameResult);
    assertEquals(ValidationType.CONSISTENCY, forConsistencyResult.validationType());
  }
}

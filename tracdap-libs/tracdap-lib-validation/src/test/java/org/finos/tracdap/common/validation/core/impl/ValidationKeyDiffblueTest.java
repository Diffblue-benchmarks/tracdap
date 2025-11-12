package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.finos.tracdap.metadata.ArrayValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationKeyDiffblueTest {
  /**
   * Test {@link ValidationKey#forObject(Descriptor)}.
   *
   * <ul>
   *   <li>When Descriptor.
   *   <li>Then return displayName is {@code ArrayValue STATIC}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#forObject(Descriptor)}
   */
  @Test
  @DisplayName(
      "Test forObject(Descriptor); when Descriptor; then return displayName is 'ArrayValue STATIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationKey ValidationKey.forObject(Descriptor)"})
  void testForObject_whenDescriptor_thenReturnDisplayNameIsArrayValueStatic() {
    // Arrange and Act
    ValidationKey actualForObjectResult = ValidationKey.forObject(ArrayValue.getDescriptor());

    // Assert
    assertEquals("ArrayValue STATIC", actualForObjectResult.displayName());
    assertEquals("ArrayValue", actualForObjectResult.shortName());
    assertEquals(ValidationType.STATIC, actualForObjectResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forMethod(Descriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When Descriptor.
   *   <li>Then return shortName is {@code Name()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#forMethod(Descriptor, MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test forMethod(Descriptor, MethodDescriptor); when Descriptor; then return shortName is 'Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationKey ValidationKey.forMethod(Descriptor, MethodDescriptor)"})
  void testForMethod_whenDescriptor_thenReturnShortNameIsName() {
    // Arrange
    Descriptor messageType = ArrayValue.getDescriptor();

    MethodDescriptor method = mock(MethodDescriptor.class);
    when(method.getFullName()).thenReturn("Dr Jane Doe");
    when(method.getName()).thenReturn("Name");

    // Act
    ValidationKey actualForMethodResult = ValidationKey.forMethod(messageType, method);

    // Assert
    verify(method).getFullName();
    verify(method, atLeast(1)).getName();
    assertEquals("Name()", actualForMethodResult.shortName());
    assertEquals("Name, ArrayValue STATIC", actualForMethodResult.displayName());
    assertEquals(ValidationType.STATIC, actualForMethodResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forVersion(Descriptor)}.
   *
   * <ul>
   *   <li>When Descriptor.
   *   <li>Then return displayName is {@code ArrayValue VERSION}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#forVersion(Descriptor)}
   */
  @Test
  @DisplayName(
      "Test forVersion(Descriptor); when Descriptor; then return displayName is 'ArrayValue VERSION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationKey ValidationKey.forVersion(Descriptor)"})
  void testForVersion_whenDescriptor_thenReturnDisplayNameIsArrayValueVersion() {
    // Arrange and Act
    ValidationKey actualForVersionResult = ValidationKey.forVersion(ArrayValue.getDescriptor());

    // Assert
    assertEquals("ArrayValue VERSION", actualForVersionResult.displayName());
    assertEquals("ArrayValue", actualForVersionResult.shortName());
    assertEquals(ValidationType.VERSION, actualForVersionResult.validationType());
  }

  /**
   * Test {@link ValidationKey#forConsistency(Descriptor)}.
   *
   * <ul>
   *   <li>When Descriptor.
   *   <li>Then return displayName is {@code ArrayValue CONSISTENCY}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#forConsistency(Descriptor)}
   */
  @Test
  @DisplayName(
      "Test forConsistency(Descriptor); when Descriptor; then return displayName is 'ArrayValue CONSISTENCY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationKey ValidationKey.forConsistency(Descriptor)"})
  void testForConsistency_whenDescriptor_thenReturnDisplayNameIsArrayValueConsistency() {
    // Arrange and Act
    ValidationKey actualForConsistencyResult =
        ValidationKey.forConsistency(ArrayValue.getDescriptor());

    // Assert
    assertEquals("ArrayValue CONSISTENCY", actualForConsistencyResult.displayName());
    assertEquals("ArrayValue", actualForConsistencyResult.shortName());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
  }

  /**
   * Test {@link ValidationKey#ValidationKey(ValidationType, Descriptor)}.
   *
   * <ul>
   *   <li>When {@code STATIC}.
   *   <li>Then return displayName is {@code ArrayValue STATIC}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#ValidationKey(ValidationType, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test new ValidationKey(ValidationType, Descriptor); when 'STATIC'; then return displayName is 'ArrayValue STATIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationKey.<init>(ValidationType, Descriptor)"})
  void testNewValidationKey_whenStatic_thenReturnDisplayNameIsArrayValueStatic() {
    // Arrange and Act
    ValidationKey actualValidationKey =
        new ValidationKey(ValidationType.STATIC, ArrayValue.getDescriptor());

    // Assert
    assertEquals("ArrayValue STATIC", actualValidationKey.displayName());
    assertEquals("ArrayValue", actualValidationKey.shortName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }

  /**
   * Test {@link ValidationKey#ValidationKey(ValidationType, Descriptor, MethodDescriptor)}.
   *
   * <ul>
   *   <li>When {@code STATIC}.
   *   <li>Then return shortName is {@code Name()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#ValidationKey(ValidationType, Descriptor,
   * MethodDescriptor)}
   */
  @Test
  @DisplayName(
      "Test new ValidationKey(ValidationType, Descriptor, MethodDescriptor); when 'STATIC'; then return shortName is 'Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationKey.<init>(ValidationType, Descriptor, MethodDescriptor)"})
  void testNewValidationKey_whenStatic_thenReturnShortNameIsName() {
    // Arrange
    Descriptor messageType = ArrayValue.getDescriptor();

    MethodDescriptor method = mock(MethodDescriptor.class);
    when(method.getFullName()).thenReturn("Dr Jane Doe");
    when(method.getName()).thenReturn("Name");

    // Act
    ValidationKey actualValidationKey =
        new ValidationKey(ValidationType.STATIC, messageType, method);

    // Assert
    verify(method).getFullName();
    verify(method, atLeast(1)).getName();
    assertEquals("Name()", actualValidationKey.shortName());
    assertEquals("Name, ArrayValue STATIC", actualValidationKey.displayName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }

  /**
   * Test {@link ValidationKey#compareTo(ValidationKey)} with {@code ValidationKey}.
   *
   * <ul>
   *   <li>When forConsistency Descriptor.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#compareTo(ValidationKey)}
   */
  @Test
  @DisplayName(
      "Test compareTo(ValidationKey) with 'ValidationKey'; when forConsistency Descriptor; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ValidationKey.compareTo(ValidationKey)"})
  void testCompareToWithValidationKey_whenForConsistencyDescriptor_thenReturnZero() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(ArrayValue.getDescriptor());

    // Act and Assert
    assertEquals(
        0,
        forConsistencyResult.compareTo(ValidationKey.forConsistency(ArrayValue.getDescriptor())));
  }

  /**
   * Test {@link ValidationKey#equals(Object)}, and {@link ValidationKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(ArrayValue.getDescriptor());
    ValidationKey forConsistencyResult2 = ValidationKey.forConsistency(ArrayValue.getDescriptor());

    // Act and Assert
    assertEquals(forConsistencyResult, forConsistencyResult2);
    assertEquals(forConsistencyResult.hashCode(), forConsistencyResult2.hashCode());
  }

  /**
   * Test {@link ValidationKey#equals(Object)}, and {@link ValidationKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(ArrayValue.getDescriptor());

    // Act and Assert
    assertEquals(forConsistencyResult, forConsistencyResult);
    int expectedHashCodeResult = forConsistencyResult.hashCode();
    assertEquals(expectedHashCodeResult, forConsistencyResult.hashCode());
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ValidationKey forObjectResult = ValidationKey.forObject(ArrayValue.getDescriptor());

    // Act and Assert
    assertNotEquals(forObjectResult, ValidationKey.forConsistency(ArrayValue.getDescriptor()));
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValidationKey.forConsistency(ArrayValue.getDescriptor()), null);
  }

  /**
   * Test {@link ValidationKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationKey.equals(Object)", "int ValidationKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ValidationKey.forConsistency(ArrayValue.getDescriptor()),
        "Different type to ValidationKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationKey#displayName()}
   *   <li>{@link ValidationKey#shortName()}
   *   <li>{@link ValidationKey#validationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ValidationKey.displayName()",
    "String ValidationKey.shortName()",
    "ValidationType ValidationKey.validationType()"
  })
  void testGettersAndSetters() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(ArrayValue.getDescriptor());

    // Act
    String actualDisplayNameResult = forConsistencyResult.displayName();
    String actualShortNameResult = forConsistencyResult.shortName();

    // Assert
    assertEquals("ArrayValue CONSISTENCY", actualDisplayNameResult);
    assertEquals("ArrayValue", actualShortNameResult);
    assertEquals(ValidationType.CONSISTENCY, forConsistencyResult.validationType());
  }
}

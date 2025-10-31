package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.junit.jupiter.api.Test;

class ValidationKeyDiffblueTest {
  /**
   * Method under test: {@link ValidationKey#forObject(Descriptors.Descriptor)}
   */
  @Test
  void testForObject() {
    // Arrange and Act
    ValidationKey actualForObjectResult = ValidationKey.forObject(Any.getDescriptor());

    // Assert
    assertEquals("Any STATIC", actualForObjectResult.displayName());
    assertEquals("Any", actualForObjectResult.shortName());
    assertEquals(ValidationType.STATIC, actualForObjectResult.validationType());
  }

  /**
   * Method under test:
   * {@link ValidationKey#forMethod(Descriptors.Descriptor, Descriptors.MethodDescriptor)}
   */
  @Test
  void testForMethod() {
    // Arrange and Act
    ValidationKey actualForMethodResult = ValidationKey.forMethod(Any.getDescriptor(), null);

    // Assert
    assertEquals("Any STATIC", actualForMethodResult.displayName());
    assertEquals("Any", actualForMethodResult.shortName());
    assertEquals(ValidationType.STATIC, actualForMethodResult.validationType());
  }

  /**
   * Method under test: {@link ValidationKey#forVersion(Descriptors.Descriptor)}
   */
  @Test
  void testForVersion() {
    // Arrange and Act
    ValidationKey actualForVersionResult = ValidationKey.forVersion(Any.getDescriptor());

    // Assert
    assertEquals("Any VERSION", actualForVersionResult.displayName());
    assertEquals("Any", actualForVersionResult.shortName());
    assertEquals(ValidationType.VERSION, actualForVersionResult.validationType());
  }

  /**
   * Method under test:
   * {@link ValidationKey#forConsistency(Descriptors.Descriptor)}
   */
  @Test
  void testForConsistency() {
    // Arrange and Act
    ValidationKey actualForConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Assert
    assertEquals("Any CONSISTENCY", actualForConsistencyResult.displayName());
    assertEquals("Any", actualForConsistencyResult.shortName());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
  }

  /**
   * Method under test: {@link ValidationKey#compareTo(ValidationKey)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Act and Assert
    assertEquals(0, forConsistencyResult.compareTo(ValidationKey.forConsistency(Any.getDescriptor())));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#equals(Object)}
   *   <li>{@link ValidationKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Any.getDescriptor());

    // Act and Assert
    assertEquals(forConsistencyResult, forConsistencyResult);
    int expectedHashCodeResult = forConsistencyResult.hashCode();
    assertEquals(expectedHashCodeResult, forConsistencyResult.hashCode());
  }

  /**
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ValidationKey forConsistencyResult = ValidationKey.forConsistency(Api.getDescriptor());

    // Act and Assert
    assertNotEquals(forConsistencyResult, ValidationKey.forConsistency(Any.getDescriptor()));
  }

  /**
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValidationKey.forConsistency(Any.getDescriptor()), null);
  }

  /**
   * Method under test: {@link ValidationKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValidationKey.forConsistency(Any.getDescriptor()), "Different type to ValidationKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationKey#displayName()}
   *   <li>{@link ValidationKey#shortName()}
   *   <li>{@link ValidationKey#validationType()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test:
   * {@link ValidationKey#ValidationKey(ValidationType, Descriptors.Descriptor)}
   */
  @Test
  void testNewValidationKey() {
    // Arrange and Act
    ValidationKey actualValidationKey = new ValidationKey(ValidationType.STATIC, Any.getDescriptor());

    // Assert
    assertEquals("Any STATIC", actualValidationKey.displayName());
    assertEquals("Any", actualValidationKey.shortName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }

  /**
   * Method under test:
   * {@link ValidationKey#ValidationKey(ValidationType, Descriptors.Descriptor, Descriptors.MethodDescriptor)}
   */
  @Test
  void testNewValidationKey2() {
    // Arrange and Act
    ValidationKey actualValidationKey = new ValidationKey(ValidationType.STATIC, Any.getDescriptor(), null);

    // Assert
    assertEquals("Any STATIC", actualValidationKey.displayName());
    assertEquals("Any", actualValidationKey.shortName());
    assertEquals(ValidationType.STATIC, actualValidationKey.validationType());
  }
}

package org.finos.tracdap.common.validation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class ValidationFunctionDiffblueTest {
  /**
   * Method under test:
   * {@link ValidationFunction#makeTyped(ValidationFunction.Typed, Class)}
   */
  @Test
  void testMakeTyped() {
    // Arrange
    ValidationFunction.Typed<Object> func = mock(ValidationFunction.Typed.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualMakeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Assert
    assertNull(actualMakeTypedResult.basic());
    assertNull(actualMakeTypedResult.version());
    assertFalse(actualMakeTypedResult.isBasic());
    assertFalse(actualMakeTypedResult.isVersion());
    assertTrue(actualMakeTypedResult.isTyped());
    Class<Object> expectedTargetClassResult = Object.class;
    Class<Object> targetClassResult = actualMakeTypedResult.targetClass();
    assertEquals(expectedTargetClassResult, targetClassResult);
    assertSame(targetClass, targetClassResult);
    assertSame(func, actualMakeTypedResult.typed());
  }

  /**
   * Method under test:
   * {@link ValidationFunction#makeVersion(ValidationFunction.Version, Class)}
   */
  @Test
  void testMakeVersion() {
    // Arrange
    ValidationFunction.Version<Object> func = mock(ValidationFunction.Version.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualMakeVersionResult = ValidationFunction.makeVersion(func, targetClass);

    // Assert
    assertNull(actualMakeVersionResult.basic());
    assertNull(actualMakeVersionResult.typed());
    assertFalse(actualMakeVersionResult.isBasic());
    assertFalse(actualMakeVersionResult.isTyped());
    assertTrue(actualMakeVersionResult.isVersion());
    Class<Object> expectedTargetClassResult = Object.class;
    Class<Object> targetClassResult = actualMakeVersionResult.targetClass();
    assertEquals(expectedTargetClassResult, targetClassResult);
    assertSame(targetClass, targetClassResult);
    assertSame(func, actualMakeVersionResult.version());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationFunction#ValidationFunction(ValidationFunction.Basic, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ValidationFunction.Basic validator = mock(ValidationFunction.Basic.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction = new ValidationFunction<>(validator, targetClass);
    ValidationFunction.Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    ValidationFunction.Typed<Object> actualTypedResult = actualValidationFunction.typed();

    // Assert
    assertNull(actualTypedResult);
    assertNull(actualValidationFunction.version());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualBasicResult);
  }

  /**
   * Method under test: {@link ValidationFunction#isBasic()}
   */
  @Test
  void testIsBasic() {
    // Arrange
    ValidationFunction.Typed<Object> func = mock(ValidationFunction.Typed.class);
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertFalse(makeTypedResult.isBasic());
  }

  /**
   * Method under test: {@link ValidationFunction#isBasic()}
   */
  @Test
  void testIsBasic2() {
    // Arrange
    ValidationFunction.Basic validator = mock(ValidationFunction.Basic.class);
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> validationFunction = new ValidationFunction<>(validator, targetClass);

    // Act and Assert
    assertTrue(validationFunction.isBasic());
  }

  /**
   * Method under test: {@link ValidationFunction#isTyped()}
   */
  @Test
  void testIsTyped() {
    // Arrange
    ValidationFunction.Typed<Object> func = mock(ValidationFunction.Typed.class);
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertTrue(makeTypedResult.isTyped());
  }

  /**
   * Method under test: {@link ValidationFunction#isTyped()}
   */
  @Test
  void testIsTyped2() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped((ValidationFunction.Typed<Object>) null,
        targetClass);

    // Act and Assert
    assertFalse(makeTypedResult.isTyped());
  }

  /**
   * Method under test: {@link ValidationFunction#isVersion()}
   */
  @Test
  void testIsVersion() {
    // Arrange
    ValidationFunction.Typed<Object> func = mock(ValidationFunction.Typed.class);
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertFalse(makeTypedResult.isVersion());
  }

  /**
   * Method under test: {@link ValidationFunction#isVersion()}
   */
  @Test
  void testIsVersion2() {
    // Arrange
    ValidationFunction.Version<Object> func = mock(ValidationFunction.Version.class);
    Class<Object> targetClass = Object.class;
    ValidationFunction<Object> makeVersionResult = ValidationFunction.makeVersion(func, targetClass);

    // Act and Assert
    assertTrue(makeVersionResult.isVersion());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationFunction#ValidationFunction(ValidationFunction.Typed, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    ValidationFunction.Typed<Object> validator = mock(ValidationFunction.Typed.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction = new ValidationFunction<>(validator, targetClass);
    ValidationFunction.Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    ValidationFunction.Typed<Object> actualTypedResult = actualValidationFunction.typed();

    // Assert
    assertNull(actualBasicResult);
    assertNull(actualValidationFunction.version());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualTypedResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationFunction#ValidationFunction(ValidationFunction.Version, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    ValidationFunction.Version<Object> validator = mock(ValidationFunction.Version.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction = new ValidationFunction<>(validator, targetClass);
    ValidationFunction.Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    ValidationFunction.Typed<Object> actualTypedResult = actualValidationFunction.typed();
    ValidationFunction.Version<Object> actualVersionResult = actualValidationFunction.version();

    // Assert
    assertNull(actualBasicResult);
    assertNull(actualTypedResult);
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualVersionResult);
  }
}

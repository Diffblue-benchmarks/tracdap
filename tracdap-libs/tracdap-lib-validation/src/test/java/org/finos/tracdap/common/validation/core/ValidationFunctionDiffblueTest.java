package org.finos.tracdap.common.validation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationFunctionDiffblueTest {
  /**
   * Test {@link ValidationFunction#makeTyped(Typed, Class)} with {@code func}, {@code targetClass}.
   *
   * <p>Method under test: {@link ValidationFunction#makeTyped(Typed, Class)}
   */
  @Test
  @DisplayName("Test makeTyped(Typed, Class) with 'func', 'targetClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationFunction ValidationFunction.makeTyped(Typed, Class)"})
  void testMakeTypedWithFuncTargetClass() {
    // Arrange
    Typed<Object> func = mock(Typed.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualMakeTypedResult =
        ValidationFunction.makeTyped(func, targetClass);

    // Assert
    assertNull(actualMakeTypedResult.basic());
    assertNull(actualMakeTypedResult.version());
    assertFalse(actualMakeTypedResult.isBasic());
    assertFalse(actualMakeTypedResult.isVersion());
    assertTrue(actualMakeTypedResult.isTyped());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualMakeTypedResult.targetClass());
    assertSame(func, actualMakeTypedResult.typed());
  }

  /**
   * Test {@link ValidationFunction#makeVersion(Version, Class)} with {@code func}, {@code
   * targetClass}.
   *
   * <p>Method under test: {@link ValidationFunction#makeVersion(Version, Class)}
   */
  @Test
  @DisplayName("Test makeVersion(Version, Class) with 'func', 'targetClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationFunction ValidationFunction.makeVersion(Version, Class)"})
  void testMakeVersionWithFuncTargetClass() {
    // Arrange
    Version<Object> func = mock(Version.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualMakeVersionResult =
        ValidationFunction.makeVersion(func, targetClass);

    // Assert
    assertNull(actualMakeVersionResult.basic());
    assertNull(actualMakeVersionResult.typed());
    assertFalse(actualMakeVersionResult.isBasic());
    assertFalse(actualMakeVersionResult.isTyped());
    assertTrue(actualMakeVersionResult.isVersion());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualMakeVersionResult.targetClass());
    assertSame(func, actualMakeVersionResult.version());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Basic}.
   *   <li>Then return {@link Basic}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFunction#ValidationFunction(Basic, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Basic; then return Basic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFunction.<init>(Basic, Class)",
    "void ValidationFunction.<init>(Typed, Class)",
    "void ValidationFunction.<init>(Version, Class)",
    "Basic ValidationFunction.basic()",
    "Class ValidationFunction.targetClass()",
    "Typed ValidationFunction.typed()",
    "Version ValidationFunction.version()"
  })
  void testGettersAndSetters_whenBasic_thenReturnBasic() {
    // Arrange
    Basic validator = mock(Basic.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction =
        new ValidationFunction<>(validator, targetClass);
    Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    Typed<Object> actualTypedResult = actualValidationFunction.typed();

    // Assert
    assertNull(actualTypedResult);
    assertNull(actualValidationFunction.version());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualBasicResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Typed}.
   *   <li>Then return {@link Typed}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFunction#ValidationFunction(Typed, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Typed; then return Typed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFunction.<init>(Basic, Class)",
    "void ValidationFunction.<init>(Typed, Class)",
    "void ValidationFunction.<init>(Version, Class)",
    "Basic ValidationFunction.basic()",
    "Class ValidationFunction.targetClass()",
    "Typed ValidationFunction.typed()",
    "Version ValidationFunction.version()"
  })
  void testGettersAndSetters_whenTyped_thenReturnTyped() {
    // Arrange
    Typed<Object> validator = mock(Typed.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction =
        new ValidationFunction<>(validator, targetClass);
    Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    Typed<Object> actualTypedResult = actualValidationFunction.typed();

    // Assert
    assertNull(actualBasicResult);
    assertNull(actualValidationFunction.version());
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualTypedResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Version}.
   *   <li>Then return {@link Version}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFunction#ValidationFunction(Version, Class)}
   *   <li>{@link ValidationFunction#basic()}
   *   <li>{@link ValidationFunction#targetClass()}
   *   <li>{@link ValidationFunction#typed()}
   *   <li>{@link ValidationFunction#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Version; then return Version")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFunction.<init>(Basic, Class)",
    "void ValidationFunction.<init>(Typed, Class)",
    "void ValidationFunction.<init>(Version, Class)",
    "Basic ValidationFunction.basic()",
    "Class ValidationFunction.targetClass()",
    "Typed ValidationFunction.typed()",
    "Version ValidationFunction.version()"
  })
  void testGettersAndSetters_whenVersion_thenReturnVersion() {
    // Arrange
    Version<Object> validator = mock(Version.class);
    Class<Object> targetClass = Object.class;

    // Act
    ValidationFunction<Object> actualValidationFunction =
        new ValidationFunction<>(validator, targetClass);
    Basic actualBasicResult = actualValidationFunction.basic();
    Class<Object> actualTargetClassResult = actualValidationFunction.targetClass();
    Typed<Object> actualTypedResult = actualValidationFunction.typed();
    Version<Object> actualVersionResult = actualValidationFunction.version();

    // Assert
    assertNull(actualBasicResult);
    assertNull(actualTypedResult);
    Class<Object> expectedTargetClassResult = Object.class;
    assertEquals(expectedTargetClassResult, actualTargetClassResult);
    assertSame(targetClass, actualTargetClassResult);
    assertSame(validator, actualVersionResult);
  }

  /**
   * Test {@link ValidationFunction#isBasic()}.
   *
   * <ul>
   *   <li>Given makeTyped {@link Typed} and {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); given makeTyped Typed and Object; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isBasic()"})
  void testIsBasic_givenMakeTypedTypedAndObject_thenReturnFalse() {
    // Arrange
    Typed<Object> func = mock(Typed.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertFalse(makeTypedResult.isBasic());
  }

  /**
   * Test {@link ValidationFunction#isBasic()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isBasic()"})
  void testIsBasic_thenReturnTrue() {
    // Arrange
    Basic validator = mock(Basic.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> validationFunction =
        new ValidationFunction<>(validator, targetClass);

    // Act and Assert
    assertTrue(validationFunction.isBasic());
  }

  /**
   * Test {@link ValidationFunction#isTyped()}.
   *
   * <ul>
   *   <li>Given makeTyped {@link Typed} and {@link Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isTyped()}
   */
  @Test
  @DisplayName("Test isTyped(); given makeTyped Typed and Object; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isTyped()"})
  void testIsTyped_givenMakeTypedTypedAndObject_thenReturnTrue() {
    // Arrange
    Typed<Object> func = mock(Typed.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertTrue(makeTypedResult.isTyped());
  }

  /**
   * Test {@link ValidationFunction#isTyped()}.
   *
   * <ul>
   *   <li>Given makeVersion {@link Version} and {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isTyped()}
   */
  @Test
  @DisplayName("Test isTyped(); given makeVersion Version and Object; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isTyped()"})
  void testIsTyped_givenMakeVersionVersionAndObject_thenReturnFalse() {
    // Arrange
    Version<Object> func = mock(Version.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> makeVersionResult =
        ValidationFunction.makeVersion(func, targetClass);

    // Act and Assert
    assertFalse(makeVersionResult.isTyped());
  }

  /**
   * Test {@link ValidationFunction#isVersion()}.
   *
   * <ul>
   *   <li>Given makeTyped {@link Typed} and {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isVersion()}
   */
  @Test
  @DisplayName("Test isVersion(); given makeTyped Typed and Object; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isVersion()"})
  void testIsVersion_givenMakeTypedTypedAndObject_thenReturnFalse() {
    // Arrange
    Typed<Object> func = mock(Typed.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> makeTypedResult = ValidationFunction.makeTyped(func, targetClass);

    // Act and Assert
    assertFalse(makeTypedResult.isVersion());
  }

  /**
   * Test {@link ValidationFunction#isVersion()}.
   *
   * <ul>
   *   <li>Given makeVersion {@link Version} and {@link Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFunction#isVersion()}
   */
  @Test
  @DisplayName("Test isVersion(); given makeVersion Version and Object; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationFunction.isVersion()"})
  void testIsVersion_givenMakeVersionVersionAndObject_thenReturnTrue() {
    // Arrange
    Version<Object> func = mock(Version.class);
    Class<Object> targetClass = Object.class;

    ValidationFunction<Object> makeVersionResult =
        ValidationFunction.makeVersion(func, targetClass);

    // Act and Assert
    assertTrue(makeVersionResult.isVersion());
  }
}

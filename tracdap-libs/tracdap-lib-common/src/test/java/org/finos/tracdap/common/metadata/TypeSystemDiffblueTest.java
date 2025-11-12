package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeSystemDiffblueTest {
  /**
   * Test {@link TypeSystem#basicType(Class)} with {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#basicType(Class)}
   */
  @Test
  @DisplayName(
      "Test basicType(Class) with 'clazz'; when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.basicType(Class)"})
  void testBasicTypeWithClazz_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.basicType(clazz));
  }

  /**
   * Test {@link TypeSystem#basicType(TypeDescriptor)} with {@code descriptor}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#basicType(TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test basicType(TypeDescriptor) with 'descriptor'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.basicType(TypeDescriptor)"})
  void testBasicTypeWithDescriptor_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TypeSystem.basicType(TypeDescriptor.getDefaultInstance()));
  }

  /**
   * Test {@link TypeSystem#basicType(Object)} with {@code object}.
   *
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#basicType(Object)}
   */
  @Test
  @DisplayName(
      "Test basicType(Object) with 'object'; when 'BASIC_TYPE_NOT_SET'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.basicType(Object)"})
  void testBasicTypeWithObject_whenBasicTypeNotSet_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.basicType(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Test {@link TypeSystem#basicType(Object)} with {@code object}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#basicType(Object)}
   */
  @Test
  @DisplayName("Test basicType(Object) with 'object'; when 'Object'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.basicType(Object)"})
  void testBasicTypeWithObject_whenObject_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(BasicType.STRING, TypeSystem.basicType("Object"));
  }

  /**
   * Test {@link TypeSystem#basicType(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#basicType(Value)}
   */
  @Test
  @DisplayName(
      "Test basicType(Value) with 'value'; when DefaultInstance; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.basicType(Value)"})
  void testBasicTypeWithValue_whenDefaultInstance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.basicType(Value.getDefaultInstance()));
  }

  /**
   * Test {@link TypeSystem#descriptor(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  @DisplayName(
      "Test descriptor(BasicType) with 'basicType'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(BasicType)"})
  void testDescriptorWithBasicType_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TypeDescriptor actualDescriptorResult = TypeSystem.descriptor(BasicType.BOOLEAN);

    // Assert
    assertEquals("", actualDescriptorResult.getInitializationErrorString());
    assertEquals(1, actualDescriptorResult.getAllFields().size());
    assertEquals(1, actualDescriptorResult.getBasicTypeValue());
    assertEquals(2, actualDescriptorResult.getSerializedSize());
    assertEquals(BasicType.BOOLEAN, actualDescriptorResult.getBasicType());
    assertFalse(actualDescriptorResult.hasArrayType());
    assertFalse(actualDescriptorResult.hasMapType());
    assertTrue(actualDescriptorResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link TypeSystem#descriptor(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>When {@code ARRAY}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  @DisplayName(
      "Test descriptor(BasicType) with 'basicType'; when 'ARRAY'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(BasicType)"})
  void testDescriptorWithBasicType_whenArray_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.ARRAY));
  }

  /**
   * Test {@link TypeSystem#descriptor(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  @DisplayName("Test descriptor(BasicType) with 'basicType'; when 'BASIC_TYPE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(BasicType)"})
  void testDescriptorWithBasicType_whenBasicTypeNotSet() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Test {@link TypeSystem#descriptor(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>When {@link BasicType#UNRECOGNIZED}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  @DisplayName(
      "Test descriptor(BasicType) with 'basicType'; when UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(BasicType)"})
  void testDescriptorWithBasicType_whenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.UNRECOGNIZED));
  }

  /**
   * Test {@link TypeSystem#descriptor(Class)} with {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(Class)}
   */
  @Test
  @DisplayName(
      "Test descriptor(Class) with 'clazz'; when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(Class)"})
  void testDescriptorWithClazz_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(clazz));
  }

  /**
   * Test {@link TypeSystem#descriptor(Object)} with {@code object}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(Object)}
   */
  @Test
  @DisplayName(
      "Test descriptor(Object) with 'object'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(Object)"})
  void testDescriptorWithObject_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TypeDescriptor actualDescriptorResult = TypeSystem.descriptor("Object");

    // Assert
    assertEquals("", actualDescriptorResult.getInitializationErrorString());
    assertEquals(1, actualDescriptorResult.getAllFields().size());
    assertEquals(2, actualDescriptorResult.getSerializedSize());
    assertEquals(4, actualDescriptorResult.getBasicTypeValue());
    assertEquals(BasicType.STRING, actualDescriptorResult.getBasicType());
    assertFalse(actualDescriptorResult.hasArrayType());
    assertFalse(actualDescriptorResult.hasMapType());
    assertTrue(actualDescriptorResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link TypeSystem#descriptor(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#descriptor(Value)}
   */
  @Test
  @DisplayName(
      "Test descriptor(Value) with 'value'; when DefaultInstance; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDescriptor TypeSystem.descriptor(Value)"})
  void testDescriptorWithValue_whenDefaultInstance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.descriptor(Value.getDefaultInstance()));
  }

  /**
   * Test {@link TypeSystem#isPrimitive(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#isPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test isPrimitive(BasicType) with 'basicType'; when 'BASIC_TYPE_NOT_SET'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSystem.isPrimitive(BasicType)"})
  void testIsPrimitiveWithBasicType_whenBasicTypeNotSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TypeSystem.isPrimitive(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Test {@link TypeSystem#isPrimitive(BasicType)} with {@code basicType}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#isPrimitive(BasicType)}
   */
  @Test
  @DisplayName("Test isPrimitive(BasicType) with 'basicType'; when 'BOOLEAN'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSystem.isPrimitive(BasicType)"})
  void testIsPrimitiveWithBasicType_whenBoolean_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TypeSystem.isPrimitive(BasicType.BOOLEAN));
  }

  /**
   * Test {@link TypeSystem#isPrimitive(TypeDescriptor)} with {@code descriptor}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#isPrimitive(TypeDescriptor)}
   */
  @Test
  @DisplayName(
      "Test isPrimitive(TypeDescriptor) with 'descriptor'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSystem.isPrimitive(TypeDescriptor)"})
  void testIsPrimitiveWithDescriptor_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TypeSystem.isPrimitive(TypeDescriptor.getDefaultInstance()));
  }

  /**
   * Test {@link TypeSystem#isPrimitive(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#isPrimitive(Value)}
   */
  @Test
  @DisplayName(
      "Test isPrimitive(Value) with 'value'; when DefaultInstance; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSystem.isPrimitive(Value)"})
  void testIsPrimitiveWithValue_whenDefaultInstance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TypeSystem.isPrimitive(Value.getDefaultInstance()));
  }

  /**
   * Test {@link TypeSystem#valueCaseType(Value)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code UNRECOGNIZED}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSystem#valueCaseType(Value)}
   */
  @Test
  @DisplayName("Test valueCaseType(Value); when DefaultInstance; then return 'UNRECOGNIZED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicType TypeSystem.valueCaseType(Value)"})
  void testValueCaseType_whenDefaultInstance_thenReturnUnrecognized() {
    // Arrange, Act and Assert
    assertEquals(BasicType.UNRECOGNIZED, TypeSystem.valueCaseType(Value.getDefaultInstance()));
  }
}

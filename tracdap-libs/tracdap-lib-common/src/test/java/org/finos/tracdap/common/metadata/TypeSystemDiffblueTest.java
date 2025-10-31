package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;

class TypeSystemDiffblueTest {
  /**
   * Method under test: {@link TypeSystem#basicType(Class)}
   */
  @Test
  void testBasicType() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.basicType(clazz));
  }

  /**
   * Method under test: {@link TypeSystem#basicType(Object)}
   */
  @Test
  void testBasicType2() {
    // Arrange, Act and Assert
    assertEquals(BasicType.STRING, TypeSystem.basicType("Object"));
  }

  /**
   * Method under test: {@link TypeSystem#basicType(Object)}
   */
  @Test
  void testBasicType3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.basicType(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Method under test: {@link TypeSystem#basicType(TypeDescriptor)}
   */
  @Test
  void testBasicType4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.basicType(TypeDescriptor.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TypeSystem#basicType(Value)}
   */
  @Test
  void testBasicType5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.basicType(Value.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(Class)}
   */
  @Test
  void testDescriptor() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(clazz));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(Object)}
   */
  @Test
  void testDescriptor2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor((Object) BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  void testDescriptor3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  void testDescriptor4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.UNRECOGNIZED));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(BasicType)}
   */
  @Test
  void testDescriptor5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(BasicType.ARRAY));
  }

  /**
   * Method under test: {@link TypeSystem#descriptor(Value)}
   */
  @Test
  void testDescriptor6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.descriptor(Value.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TypeSystem#isPrimitive(BasicType)}
   */
  @Test
  void testIsPrimitive() {
    // Arrange, Act and Assert
    assertFalse(TypeSystem.isPrimitive(BasicType.BASIC_TYPE_NOT_SET));
    assertTrue(TypeSystem.isPrimitive(BasicType.BOOLEAN));
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.isPrimitive(TypeDescriptor.getDefaultInstance()));
    assertThrows(IllegalArgumentException.class, () -> TypeSystem.isPrimitive(Value.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TypeSystem#valueCaseType(Value)}
   */
  @Test
  void testValueCaseType() {
    // Arrange, Act and Assert
    assertEquals(BasicType.UNRECOGNIZED, TypeSystem.valueCaseType(Value.getDefaultInstance()));
  }
}

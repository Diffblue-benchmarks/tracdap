package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogicalOperatorDiffblueTest {
  /**
   * Test {@link LogicalOperator#getNumber()}.
   * <ul>
   *   <li>Given {@code LOGICAL_OPERATOR_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'LOGICAL_OPERATOR_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LogicalOperator.getNumber()"})
  void testGetNumber_givenLogicalOperatorNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, LogicalOperator.LOGICAL_OPERATOR_NOT_SET.getNumber());
  }

  /**
   * Test {@link LogicalOperator#getNumber()}.
   * <ul>
   *   <li>Given {@link LogicalOperator#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LogicalOperator.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LogicalOperator.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link LogicalOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LogicalOperator.valueOf(42));
  }

  /**
   * Test {@link LogicalOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'AND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnAnd() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.AND, LogicalOperator.valueOf(1));
  }

  /**
   * Test {@link LogicalOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'NOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnNot() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.NOT, LogicalOperator.valueOf(3));
  }

  /**
   * Test {@link LogicalOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'OR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnOr() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.OR, LogicalOperator.valueOf(2));
  }

  /**
   * Test {@link LogicalOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LOGICAL_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'LOGICAL_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnLogicalOperatorNotSet() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, LogicalOperator.valueOf(0));
  }

  /**
   * Test {@link LogicalOperator#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LogicalOperator.forNumber(42));
  }

  /**
   * Test {@link LogicalOperator#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'AND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.forNumber(int)"})
  void testForNumber_whenOne_thenReturnAnd() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.AND, LogicalOperator.forNumber(1));
  }

  /**
   * Test {@link LogicalOperator#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'NOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.forNumber(int)"})
  void testForNumber_whenThree_thenReturnNot() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.NOT, LogicalOperator.forNumber(3));
  }

  /**
   * Test {@link LogicalOperator#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'OR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnOr() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.OR, LogicalOperator.forNumber(2));
  }

  /**
   * Test {@link LogicalOperator#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LOGICAL_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'LOGICAL_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalOperator LogicalOperator.forNumber(int)"})
  void testForNumber_whenZero_thenReturnLogicalOperatorNotSet() {
    // Arrange, Act and Assert
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, LogicalOperator.forNumber(0));
  }

  /**
   * Test {@link LogicalOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicalOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link LogicalOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'AND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicalOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsAnd() {
    // Arrange and Act
    EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.AND, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link LogicalOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code NOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'NOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicalOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsNot() {
    // Arrange and Act
    EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.NOT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link LogicalOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'OR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicalOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsOr() {
    // Arrange and Act
    EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.OR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link LogicalOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code LOGICAL_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'LOGICAL_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicalOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsLogicalOperatorNotSet() {
    // Arrange and Act
    EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link LogicalOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link LogicalOperator#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor LogicalOperator.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> LogicalOperator.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link LogicalOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code LOGICAL_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'LOGICAL_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor LogicalOperator.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsLogicalOperatorNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = LogicalOperator.LOGICAL_OPERATOR_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("LOGICAL_OPERATOR_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.LogicalOperator.LOGICAL_OPERATOR_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link LogicalOperator#getDescriptorForType()}.
   * <p>
   * Method under test: {@link LogicalOperator#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor LogicalOperator.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = LogicalOperator.LOGICAL_OPERATOR_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("LogicalOperator", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.LogicalOperator", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(4, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link LogicalOperator#getDescriptor()}.
   * <p>
   * Method under test: {@link LogicalOperator#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor LogicalOperator.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = LogicalOperator.getDescriptor();

    // Assert
    assertEquals("LogicalOperator", actualDescriptor.getName());
    assertEquals("tracdap.metadata.LogicalOperator", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

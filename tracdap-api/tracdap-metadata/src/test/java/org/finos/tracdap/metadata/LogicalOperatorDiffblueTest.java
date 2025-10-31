package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class LogicalOperatorDiffblueTest {
  /**
   * Method under test: {@link LogicalOperator#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(LogicalOperator.forNumber(42));
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, LogicalOperator.forNumber(0));
    assertEquals(LogicalOperator.AND, LogicalOperator.forNumber(1));
    assertEquals(LogicalOperator.OR, LogicalOperator.forNumber(2));
    assertEquals(LogicalOperator.NOT, LogicalOperator.forNumber(3));
  }

  /**
   * Method under test: {@link LogicalOperator#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, LogicalOperator.LOGICAL_OPERATOR_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> LogicalOperator.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link LogicalOperator#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> LogicalOperator.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.AND, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.OR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.NOT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link LogicalOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<LogicalOperator> actualInternalGetValueMapResult = LogicalOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link LogicalOperator#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(LogicalOperator.valueOf(42));
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, LogicalOperator.valueOf(0));
    assertEquals(LogicalOperator.AND, LogicalOperator.valueOf(1));
    assertEquals(LogicalOperator.OR, LogicalOperator.valueOf(2));
    assertEquals(LogicalOperator.NOT, LogicalOperator.valueOf(3));
  }
}

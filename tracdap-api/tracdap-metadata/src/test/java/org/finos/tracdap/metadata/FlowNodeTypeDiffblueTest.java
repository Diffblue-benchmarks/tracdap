package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class FlowNodeTypeDiffblueTest {
  /**
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(FlowNodeType.forNumber(42));
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNodeType.forNumber(0));
    assertEquals(FlowNodeType.INPUT_NODE, FlowNodeType.forNumber(1));
    assertEquals(FlowNodeType.OUTPUT_NODE, FlowNodeType.forNumber(2));
    assertEquals(FlowNodeType.MODEL_NODE, FlowNodeType.forNumber(3));
    assertEquals(FlowNodeType.PARAMETER_NODE, FlowNodeType.forNumber(4));
  }

  /**
   * Method under test: {@link FlowNodeType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNodeType.NODE_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> FlowNodeType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link FlowNodeType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> FlowNodeType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.INPUT_NODE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.OUTPUT_NODE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.MODEL_NODE, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.PARAMETER_NODE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(FlowNodeType.valueOf(42));
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNodeType.valueOf(0));
    assertEquals(FlowNodeType.INPUT_NODE, FlowNodeType.valueOf(1));
    assertEquals(FlowNodeType.OUTPUT_NODE, FlowNodeType.valueOf(2));
    assertEquals(FlowNodeType.MODEL_NODE, FlowNodeType.valueOf(3));
    assertEquals(FlowNodeType.PARAMETER_NODE, FlowNodeType.valueOf(4));
  }
}

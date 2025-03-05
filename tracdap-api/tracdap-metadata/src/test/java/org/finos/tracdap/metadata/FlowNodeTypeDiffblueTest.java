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

class FlowNodeTypeDiffblueTest {
  /**
   * Test {@link FlowNodeType#getNumber()}.
   * <ul>
   *   <li>Given {@code NODE_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'NODE_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNodeType.getNumber()"})
  void testGetNumber_givenNodeTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNodeType.NODE_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link FlowNodeType#getNumber()}.
   * <ul>
   *   <li>Given {@link FlowNodeType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNodeType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowNodeType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(FlowNodeType.valueOf(42));
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code PARAMETER_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'PARAMETER_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnParameterNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.PARAMETER_NODE, FlowNodeType.valueOf(4));
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'INPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnInputNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.INPUT_NODE, FlowNodeType.valueOf(1));
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code MODEL_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'MODEL_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnModelNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.MODEL_NODE, FlowNodeType.valueOf(3));
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code OUTPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'OUTPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnOutputNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.OUTPUT_NODE, FlowNodeType.valueOf(2));
  }

  /**
   * Test {@link FlowNodeType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code NODE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'NODE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnNodeTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNodeType.valueOf(0));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(FlowNodeType.forNumber(42));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code PARAMETER_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'PARAMETER_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenFour_thenReturnParameterNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.PARAMETER_NODE, FlowNodeType.forNumber(4));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'INPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnInputNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.INPUT_NODE, FlowNodeType.forNumber(1));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code MODEL_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'MODEL_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenThree_thenReturnModelNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.MODEL_NODE, FlowNodeType.forNumber(3));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code OUTPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'OUTPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnOutputNode() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.OUTPUT_NODE, FlowNodeType.forNumber(2));
  }

  /**
   * Test {@link FlowNodeType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code NODE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'NODE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNodeType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnNodeTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNodeType.forNumber(0));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code PARAMETER_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'PARAMETER_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsParameterNode() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.PARAMETER_NODE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code INPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'INPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsInputNode() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.INPUT_NODE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code MODEL_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'MODEL_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsModelNode() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.MODEL_NODE, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code OUTPUT_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'OUTPUT_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsOutputNode() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.OUTPUT_NODE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link FlowNodeType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code NODE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'NODE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap FlowNodeType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsNodeTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<FlowNodeType> actualInternalGetValueMapResult = FlowNodeType.internalGetValueMap();

    // Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link FlowNodeType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code NODE_TYPE_NOT_SET}.</li>
   *   <li>Then return Name is {@code NODE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'NODE_TYPE_NOT_SET'; then return Name is 'NODE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor FlowNodeType.getValueDescriptor()"})
  void testGetValueDescriptor_givenNodeTypeNotSet_thenReturnNameIsNodeTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = FlowNodeType.NODE_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("NODE_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.FlowNodeType.NODE_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link FlowNodeType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link FlowNodeType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNodeType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor FlowNodeType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> FlowNodeType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link FlowNodeType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link FlowNodeType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor FlowNodeType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = FlowNodeType.NODE_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("FlowNodeType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.FlowNodeType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(5, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link FlowNodeType#getDescriptor()}.
   * <p>
   * Method under test: {@link FlowNodeType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor FlowNodeType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = FlowNodeType.getDescriptor();

    // Assert
    assertEquals("FlowNodeType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.FlowNodeType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

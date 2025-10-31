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

class PartTypeDiffblueTest {
  /**
   * Test {@link PartType#getNumber()}.
   * <ul>
   *   <li>Given {@code PART_ROOT}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'PART_ROOT'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PartType.getNumber()"})
  void testGetNumber_givenPartRoot_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PartType.PART_ROOT.getNumber());
  }

  /**
   * Test {@link PartType#getNumber()}.
   * <ul>
   *   <li>Given {@link PartType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PartType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PartType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link PartType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartType.valueOf(42));
  }

  /**
   * Test {@link PartType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PART_BY_RANGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'PART_BY_RANGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnPartByRange() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_BY_RANGE, PartType.valueOf(1));
  }

  /**
   * Test {@link PartType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code PART_BY_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'PART_BY_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnPartByValue() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_BY_VALUE, PartType.valueOf(2));
  }

  /**
   * Test {@link PartType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code PART_ROOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'PART_ROOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnPartRoot() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, PartType.valueOf(0));
  }

  /**
   * Test {@link PartType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PartType.forNumber(42));
  }

  /**
   * Test {@link PartType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PART_BY_RANGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'PART_BY_RANGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnPartByRange() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_BY_RANGE, PartType.forNumber(1));
  }

  /**
   * Test {@link PartType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code PART_BY_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'PART_BY_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnPartByValue() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_BY_VALUE, PartType.forNumber(2));
  }

  /**
   * Test {@link PartType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code PART_ROOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'PART_ROOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartType PartType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnPartRoot() {
    // Arrange, Act and Assert
    assertEquals(PartType.PART_ROOT, PartType.forNumber(0));
  }

  /**
   * Test {@link PartType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap PartType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link PartType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code PART_BY_RANGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'PART_BY_RANGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap PartType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsPartByRange() {
    // Arrange and Act
    EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_BY_RANGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link PartType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code PART_BY_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'PART_BY_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap PartType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsPartByValue() {
    // Arrange and Act
    EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_BY_VALUE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link PartType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code PART_ROOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'PART_ROOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap PartType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsPartRoot() {
    // Arrange and Act
    EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_ROOT, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link PartType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code PART_ROOT}.</li>
   *   <li>Then return Name is {@code PART_ROOT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'PART_ROOT'; then return Name is 'PART_ROOT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor PartType.getValueDescriptor()"})
  void testGetValueDescriptor_givenPartRoot_thenReturnNameIsPartRoot() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = PartType.PART_ROOT.getValueDescriptor();

    // Assert
    assertEquals("PART_ROOT", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.PartType.PART_ROOT", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link PartType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link PartType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor PartType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> PartType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link PartType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link PartType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor PartType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = PartType.PART_ROOT.getDescriptorForType();

    // Assert
    assertEquals("PartType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.PartType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link PartType#getDescriptor()}.
   * <p>
   * Method under test: {@link PartType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor PartType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = PartType.getDescriptor();

    // Assert
    assertEquals("PartType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.PartType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

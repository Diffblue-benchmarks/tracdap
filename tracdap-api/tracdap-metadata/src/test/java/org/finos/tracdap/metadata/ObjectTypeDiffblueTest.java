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

class ObjectTypeDiffblueTest {
  /**
   * Test {@link ObjectType#getNumber()}.
   * <ul>
   *   <li>Given {@code OBJECT_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'OBJECT_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ObjectType.getNumber()"})
  void testGetNumber_givenObjectTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectType.OBJECT_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link ObjectType#getNumber()}.
   * <ul>
   *   <li>Given {@link ObjectType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ObjectType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ObjectType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when eight; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenEight_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.SCHEMA, ObjectType.valueOf(8));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code FILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'FILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FILE, ObjectType.valueOf(5));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectType.valueOf(42));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code JOB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'JOB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.JOB, ObjectType.valueOf(4));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.DATA, ObjectType.valueOf(1));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ObjectType#RESULT_VALUE}.</li>
   *   <li>Then return {@code RESULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when RESULT_VALUE; then return 'RESULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenResult_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.RESULT, ObjectType.valueOf(ObjectType.RESULT_VALUE));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when seven; then return 'STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenSeven_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.STORAGE, ObjectType.valueOf(7));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.CUSTOM, ObjectType.valueOf(6));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FLOW, ObjectType.valueOf(3));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.MODEL, ObjectType.valueOf(2));
  }

  /**
   * Test {@link ObjectType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code OBJECT_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'OBJECT_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnObjectTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ObjectType.valueOf(0));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when eight; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenEight_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.SCHEMA, ObjectType.forNumber(8));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code FILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'FILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenFive_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FILE, ObjectType.forNumber(5));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectType.forNumber(42));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code JOB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'JOB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenFour_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.JOB, ObjectType.forNumber(4));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.DATA, ObjectType.forNumber(1));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When {@link ObjectType#RESULT_VALUE}.</li>
   *   <li>Then return {@code RESULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when RESULT_VALUE; then return 'RESULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenResult_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.RESULT, ObjectType.forNumber(ObjectType.RESULT_VALUE));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when seven; then return 'STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenSeven_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.STORAGE, ObjectType.forNumber(7));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenSix_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.CUSTOM, ObjectType.forNumber(6));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenThree_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FLOW, ObjectType.forNumber(3));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.MODEL, ObjectType.forNumber(2));
  }

  /**
   * Test {@link ObjectType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code OBJECT_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'OBJECT_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType ObjectType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnObjectTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ObjectType.forNumber(0));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber eight is {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber eight is 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberEightIsSchema() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.SCHEMA, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code FILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'FILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsFile() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.FILE, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code JOB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'JOB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsJob() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.JOB, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsData() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.DATA, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link ObjectType#RESULT_VALUE} is {@code RESULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber RESULT_VALUE is 'RESULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberResult_valueIsResult() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.RESULT, actualInternalGetValueMapResult.findValueByNumber(ObjectType.RESULT_VALUE));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber seven is {@code STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber seven is 'STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSevenIsStorage() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.STORAGE, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsCustom() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.CUSTOM, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsFlow() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.FLOW, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsModel() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.MODEL, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link ObjectType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code OBJECT_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'OBJECT_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ObjectType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsObjectTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link ObjectType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code OBJECT_TYPE_NOT_SET}.</li>
   *   <li>Then return Name is {@code OBJECT_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'OBJECT_TYPE_NOT_SET'; then return Name is 'OBJECT_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ObjectType.getValueDescriptor()"})
  void testGetValueDescriptor_givenObjectTypeNotSet_thenReturnNameIsObjectTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = ObjectType.OBJECT_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("OBJECT_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.ObjectType.OBJECT_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link ObjectType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link ObjectType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ObjectType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ObjectType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link ObjectType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ObjectType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ObjectType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = ObjectType.OBJECT_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("ObjectType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.ObjectType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertFalse(actualDescriptorForType.isClosed());
    assertEquals(JobStatusCode.CANCELLED_VALUE, actualDescriptorForType.getValues().size());
  }

  /**
   * Test {@link ObjectType#getDescriptor()}.
   * <p>
   * Method under test: {@link ObjectType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ObjectType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = ObjectType.getDescriptor();

    // Assert
    assertEquals("ObjectType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.ObjectType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isClosed());
    assertEquals(JobStatusCode.CANCELLED_VALUE, actualDescriptor.getValues().size());
  }
}

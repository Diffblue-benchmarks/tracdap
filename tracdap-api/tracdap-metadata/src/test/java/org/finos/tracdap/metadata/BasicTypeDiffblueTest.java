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

class BasicTypeDiffblueTest {
  /**
   * Test {@link BasicType#getNumber()}.
   * <ul>
   *   <li>Given {@code BASIC_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'BASIC_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicType.getNumber()"})
  void testGetNumber_givenBasicTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, BasicType.BASIC_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link BasicType#getNumber()}.
   * <ul>
   *   <li>Given {@link BasicType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> BasicType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when eight; then return 'ARRAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenEight_thenReturnArray() {
    // Arrange, Act and Assert
    assertEquals(BasicType.ARRAY, BasicType.valueOf(8));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'DECIMAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnDecimal() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DECIMAL, BasicType.valueOf(5));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BasicType.valueOf(42));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(BasicType.STRING, BasicType.valueOf(4));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code MAP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when MAP_VALUE; then return 'MAP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenMap_value_thenReturnMap() {
    // Arrange, Act and Assert
    assertEquals(BasicType.MAP, BasicType.valueOf(BasicType.MAP_VALUE));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BOOLEAN, BasicType.valueOf(1));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code DATETIME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when seven; then return 'DATETIME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenSeven_thenReturnDatetime() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DATETIME, BasicType.valueOf(7));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'DATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnDate() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DATE, BasicType.valueOf(6));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code FLOAT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'FLOAT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(BasicType.FLOAT, BasicType.valueOf(3));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(BasicType.INTEGER, BasicType.valueOf(2));
  }

  /**
   * Test {@link BasicType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code BASIC_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'BASIC_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnBasicTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, BasicType.valueOf(0));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when eight; then return 'ARRAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenEight_thenReturnArray() {
    // Arrange, Act and Assert
    assertEquals(BasicType.ARRAY, BasicType.forNumber(8));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'DECIMAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenFive_thenReturnDecimal() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DECIMAL, BasicType.forNumber(5));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BasicType.forNumber(42));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenFour_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(BasicType.STRING, BasicType.forNumber(4));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.</li>
   *   <li>Then return {@code MAP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when MAP_VALUE; then return 'MAP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenMap_value_thenReturnMap() {
    // Arrange, Act and Assert
    assertEquals(BasicType.MAP, BasicType.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BOOLEAN, BasicType.forNumber(1));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code DATETIME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when seven; then return 'DATETIME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenSeven_thenReturnDatetime() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DATETIME, BasicType.forNumber(7));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'DATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenSix_thenReturnDate() {
    // Arrange, Act and Assert
    assertEquals(BasicType.DATE, BasicType.forNumber(6));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code FLOAT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'FLOAT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenThree_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(BasicType.FLOAT, BasicType.forNumber(3));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(BasicType.INTEGER, BasicType.forNumber(2));
  }

  /**
   * Test {@link BasicType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code BASIC_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'BASIC_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType BasicType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnBasicTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, BasicType.forNumber(0));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber eight is {@code ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber eight is 'ARRAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberEightIsArray() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.ARRAY, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'DECIMAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsDecimal() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DECIMAL, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsString() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.STRING, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link BasicType#MAP_VALUE} is {@code MAP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber MAP_VALUE is 'MAP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberMap_valueIsMap() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.MAP, actualInternalGetValueMapResult.findValueByNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsBoolean() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.BOOLEAN, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber seven is {@code DATETIME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber seven is 'DATETIME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSevenIsDatetime() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DATETIME, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code DATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'DATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsDate() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DATE, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code FLOAT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'FLOAT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsFloat() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.FLOAT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code INTEGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsInteger() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.INTEGER, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link BasicType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code BASIC_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'BASIC_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BasicType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsBasicTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link BasicType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code BASIC_TYPE_NOT_SET}.</li>
   *   <li>Then return Name is {@code BASIC_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'BASIC_TYPE_NOT_SET'; then return Name is 'BASIC_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor BasicType.getValueDescriptor()"})
  void testGetValueDescriptor_givenBasicTypeNotSet_thenReturnNameIsBasicTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = BasicType.BASIC_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("BASIC_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.BasicType.BASIC_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link BasicType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link BasicType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor BasicType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> BasicType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link BasicType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link BasicType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor BasicType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = BasicType.BASIC_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("BasicType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.BasicType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertFalse(actualDescriptorForType.isClosed());
    assertEquals(JobStatusCode.CANCELLED_VALUE, actualDescriptorForType.getValues().size());
  }

  /**
   * Test {@link BasicType#getDescriptor()}.
   * <p>
   * Method under test: {@link BasicType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor BasicType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = BasicType.getDescriptor();

    // Assert
    assertEquals("BasicType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.BasicType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isClosed());
    assertEquals(JobStatusCode.CANCELLED_VALUE, actualDescriptor.getValues().size());
  }
}

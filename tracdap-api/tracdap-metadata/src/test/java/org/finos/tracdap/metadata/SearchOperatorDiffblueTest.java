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

class SearchOperatorDiffblueTest {
  /**
   * Test {@link SearchOperator#getNumber()}.
   * <ul>
   *   <li>Given {@code SEARCH_OPERATOR_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'SEARCH_OPERATOR_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SearchOperator.getNumber()"})
  void testGetNumber_givenSearchOperatorNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, SearchOperator.SEARCH_OPERATOR_NOT_SET.getNumber());
  }

  /**
   * Test {@link SearchOperator#getNumber()}.
   * <ul>
   *   <li>Given {@link SearchOperator#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SearchOperator.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SearchOperator.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code EXISTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when eight; then return 'EXISTS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenEight_thenReturnExists() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.EXISTS, SearchOperator.valueOf(8));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code GT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'GT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnGt() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.GT, SearchOperator.valueOf(5));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SearchOperator.valueOf(42));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code LE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'LE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnLe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.LE, SearchOperator.valueOf(4));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code EQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'EQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnEq() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.EQ, SearchOperator.valueOf(1));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code IN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when seven; then return 'IN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenSeven_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.IN, SearchOperator.valueOf(7));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code GE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'GE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnGe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.GE, SearchOperator.valueOf(6));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code LT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'LT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnLt() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.LT, SearchOperator.valueOf(3));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code NE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'NE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnNe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.NE, SearchOperator.valueOf(2));
  }

  /**
   * Test {@link SearchOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SEARCH_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'SEARCH_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnSearchOperatorNotSet() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, SearchOperator.valueOf(0));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code EXISTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when eight; then return 'EXISTS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenEight_thenReturnExists() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.EXISTS, SearchOperator.forNumber(8));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code GT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'GT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenFive_thenReturnGt() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.GT, SearchOperator.forNumber(5));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SearchOperator.forNumber(42));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code LE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'LE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenFour_thenReturnLe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.LE, SearchOperator.forNumber(4));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code EQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'EQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenOne_thenReturnEq() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.EQ, SearchOperator.forNumber(1));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code IN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when seven; then return 'IN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenSeven_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.IN, SearchOperator.forNumber(7));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code GE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'GE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenSix_thenReturnGe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.GE, SearchOperator.forNumber(6));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code LT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'LT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenThree_thenReturnLt() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.LT, SearchOperator.forNumber(3));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code NE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'NE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnNe() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.NE, SearchOperator.forNumber(2));
  }

  /**
   * Test {@link SearchOperator#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SEARCH_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'SEARCH_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchOperator SearchOperator.forNumber(int)"})
  void testForNumber_whenZero_thenReturnSearchOperatorNotSet() {
    // Arrange, Act and Assert
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, SearchOperator.forNumber(0));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber eight is {@code EXISTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber eight is 'EXISTS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberEightIsExists() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.EXISTS, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code GT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'GT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsGt() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.GT, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code LE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'LE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsLe() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.LE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code EQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'EQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsEq() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.EQ, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber seven is {@code IN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber seven is 'IN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSevenIsIn() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.IN, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code GE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'GE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsGe() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.GE, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code LT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'LT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsLt() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.LT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code NE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'NE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsNe() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.NE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link SearchOperator#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code SEARCH_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'SEARCH_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SearchOperator.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsSearchOperatorNotSet() {
    // Arrange and Act
    EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link SearchOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link SearchOperator#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor SearchOperator.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> SearchOperator.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link SearchOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code SEARCH_OPERATOR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'SEARCH_OPERATOR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor SearchOperator.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsSearchOperatorNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = SearchOperator.SEARCH_OPERATOR_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("SEARCH_OPERATOR_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.SearchOperator.SEARCH_OPERATOR_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link SearchOperator#getDescriptorForType()}.
   * <p>
   * Method under test: {@link SearchOperator#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor SearchOperator.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = SearchOperator.SEARCH_OPERATOR_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("SearchOperator", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.SearchOperator", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertFalse(actualDescriptorForType.isClosed());
    assertEquals(BasicType.MAP_VALUE, actualDescriptorForType.getValues().size());
  }

  /**
   * Test {@link SearchOperator#getDescriptor()}.
   * <p>
   * Method under test: {@link SearchOperator#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor SearchOperator.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = SearchOperator.getDescriptor();

    // Assert
    assertEquals("SearchOperator", actualDescriptor.getName());
    assertEquals("tracdap.metadata.SearchOperator", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isClosed());
    assertEquals(BasicType.MAP_VALUE, actualDescriptor.getValues().size());
  }
}

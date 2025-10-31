package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class SearchOperatorDiffblueTest {
  /**
   * Method under test: {@link SearchOperator#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(SearchOperator.forNumber(42));
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, SearchOperator.forNumber(0));
    assertEquals(SearchOperator.EQ, SearchOperator.forNumber(1));
    assertEquals(SearchOperator.NE, SearchOperator.forNumber(2));
    assertEquals(SearchOperator.LT, SearchOperator.forNumber(3));
    assertEquals(SearchOperator.LE, SearchOperator.forNumber(4));
    assertEquals(SearchOperator.GT, SearchOperator.forNumber(5));
    assertEquals(SearchOperator.GE, SearchOperator.forNumber(6));
    assertEquals(SearchOperator.IN, SearchOperator.forNumber(7));
    assertEquals(SearchOperator.EXISTS, SearchOperator.forNumber(8));
  }

  /**
   * Method under test: {@link SearchOperator#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, SearchOperator.SEARCH_OPERATOR_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> SearchOperator.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link SearchOperator#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> SearchOperator.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.EQ, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.NE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.LT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.LE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.GT, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.GE, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.IN, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Method under test: {@link SearchOperator#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<SearchOperator> actualInternalGetValueMapResult = SearchOperator.internalGetValueMap();

    // Assert
    assertEquals(SearchOperator.EXISTS, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Method under test: {@link SearchOperator#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(SearchOperator.valueOf(42));
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, SearchOperator.valueOf(0));
    assertEquals(SearchOperator.EQ, SearchOperator.valueOf(1));
    assertEquals(SearchOperator.NE, SearchOperator.valueOf(2));
    assertEquals(SearchOperator.LT, SearchOperator.valueOf(3));
    assertEquals(SearchOperator.LE, SearchOperator.valueOf(4));
    assertEquals(SearchOperator.GT, SearchOperator.valueOf(5));
    assertEquals(SearchOperator.GE, SearchOperator.valueOf(6));
    assertEquals(SearchOperator.IN, SearchOperator.valueOf(7));
    assertEquals(SearchOperator.EXISTS, SearchOperator.valueOf(8));
  }
}

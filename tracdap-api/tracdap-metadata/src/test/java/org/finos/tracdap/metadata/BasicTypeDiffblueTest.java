package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class BasicTypeDiffblueTest {
  /**
   * Method under test: {@link BasicType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(BasicType.forNumber(42));
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, BasicType.forNumber(0));
    assertEquals(BasicType.BOOLEAN, BasicType.forNumber(1));
    assertEquals(BasicType.INTEGER, BasicType.forNumber(2));
    assertEquals(BasicType.FLOAT, BasicType.forNumber(3));
    assertEquals(BasicType.STRING, BasicType.forNumber(4));
    assertEquals(BasicType.DECIMAL, BasicType.forNumber(5));
    assertEquals(BasicType.DATE, BasicType.forNumber(6));
    assertEquals(BasicType.DATETIME, BasicType.forNumber(7));
    assertEquals(BasicType.ARRAY, BasicType.forNumber(8));
    assertEquals(BasicType.MAP, BasicType.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Method under test: {@link BasicType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, BasicType.BASIC_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> BasicType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link BasicType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> BasicType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.BOOLEAN, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.INTEGER, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.FLOAT, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.STRING, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DECIMAL, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DATE, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.DATETIME, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.ARRAY, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Method under test: {@link BasicType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap11() {
    // Arrange and Act
    Internal.EnumLiteMap<BasicType> actualInternalGetValueMapResult = BasicType.internalGetValueMap();

    // Assert
    assertEquals(BasicType.MAP, actualInternalGetValueMapResult.findValueByNumber(BasicType.MAP_VALUE));
  }

  /**
   * Method under test: {@link BasicType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(BasicType.valueOf(42));
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, BasicType.valueOf(0));
    assertEquals(BasicType.BOOLEAN, BasicType.valueOf(1));
    assertEquals(BasicType.INTEGER, BasicType.valueOf(2));
    assertEquals(BasicType.FLOAT, BasicType.valueOf(3));
    assertEquals(BasicType.STRING, BasicType.valueOf(4));
    assertEquals(BasicType.DECIMAL, BasicType.valueOf(5));
    assertEquals(BasicType.DATE, BasicType.valueOf(6));
    assertEquals(BasicType.DATETIME, BasicType.valueOf(7));
    assertEquals(BasicType.ARRAY, BasicType.valueOf(8));
    assertEquals(BasicType.MAP, BasicType.valueOf(BasicType.MAP_VALUE));
  }
}

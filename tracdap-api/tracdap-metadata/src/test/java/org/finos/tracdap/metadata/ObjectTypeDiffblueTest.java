package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class ObjectTypeDiffblueTest {
  /**
   * Method under test: {@link ObjectType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(ObjectType.forNumber(42));
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ObjectType.forNumber(0));
    assertEquals(ObjectType.DATA, ObjectType.forNumber(1));
    assertEquals(ObjectType.MODEL, ObjectType.forNumber(2));
    assertEquals(ObjectType.FLOW, ObjectType.forNumber(3));
    assertEquals(ObjectType.JOB, ObjectType.forNumber(4));
    assertEquals(ObjectType.FILE, ObjectType.forNumber(5));
    assertEquals(ObjectType.CUSTOM, ObjectType.forNumber(6));
    assertEquals(ObjectType.STORAGE, ObjectType.forNumber(7));
    assertEquals(ObjectType.SCHEMA, ObjectType.forNumber(8));
    assertEquals(ObjectType.RESULT, ObjectType.forNumber(ObjectType.RESULT_VALUE));
  }

  /**
   * Method under test: {@link ObjectType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, ObjectType.OBJECT_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> ObjectType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link ObjectType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ObjectType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.DATA, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.MODEL, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.FLOW, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.JOB, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.FILE, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.CUSTOM, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.STORAGE, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.SCHEMA, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Method under test: {@link ObjectType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap11() {
    // Arrange and Act
    Internal.EnumLiteMap<ObjectType> actualInternalGetValueMapResult = ObjectType.internalGetValueMap();

    // Assert
    assertEquals(ObjectType.RESULT, actualInternalGetValueMapResult.findValueByNumber(ObjectType.RESULT_VALUE));
  }

  /**
   * Method under test: {@link ObjectType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(ObjectType.valueOf(42));
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, ObjectType.valueOf(0));
    assertEquals(ObjectType.DATA, ObjectType.valueOf(1));
    assertEquals(ObjectType.MODEL, ObjectType.valueOf(2));
    assertEquals(ObjectType.FLOW, ObjectType.valueOf(3));
    assertEquals(ObjectType.JOB, ObjectType.valueOf(4));
    assertEquals(ObjectType.FILE, ObjectType.valueOf(5));
    assertEquals(ObjectType.CUSTOM, ObjectType.valueOf(6));
    assertEquals(ObjectType.STORAGE, ObjectType.valueOf(7));
    assertEquals(ObjectType.SCHEMA, ObjectType.valueOf(8));
    assertEquals(ObjectType.RESULT, ObjectType.valueOf(ObjectType.RESULT_VALUE));
  }
}

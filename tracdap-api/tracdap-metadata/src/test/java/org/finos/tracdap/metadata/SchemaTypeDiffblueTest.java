package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class SchemaTypeDiffblueTest {
  /**
   * Method under test: {@link SchemaType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(SchemaType.forNumber(42));
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaType.forNumber(0));
    assertEquals(SchemaType.TABLE, SchemaType.forNumber(1));
    assertEquals(SchemaType.STRUCT, SchemaType.forNumber(2));
  }

  /**
   * Method under test: {@link SchemaType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, SchemaType.SCHEMA_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> SchemaType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link SchemaType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> SchemaType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.TABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.STRUCT, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link SchemaType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(SchemaType.valueOf(42));
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaType.valueOf(0));
    assertEquals(SchemaType.TABLE, SchemaType.valueOf(1));
    assertEquals(SchemaType.STRUCT, SchemaType.valueOf(2));
  }
}

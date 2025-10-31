package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class TagOperationDiffblueTest {
  /**
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(TagOperation.forNumber(42));
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, TagOperation.forNumber(0));
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, TagOperation.forNumber(1));
    assertEquals(TagOperation.CREATE_ATTR, TagOperation.forNumber(2));
    assertEquals(TagOperation.REPLACE_ATTR, TagOperation.forNumber(3));
    assertEquals(TagOperation.APPEND_ATTR, TagOperation.forNumber(4));
    assertEquals(TagOperation.DELETE_ATTR, TagOperation.forNumber(5));
    assertEquals(TagOperation.CLEAR_ALL_ATTR, TagOperation.forNumber(6));
  }

  /**
   * Method under test: {@link TagOperation#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, TagOperation.CREATE_OR_REPLACE_ATTR.getNumber());
    assertThrows(IllegalArgumentException.class, () -> TagOperation.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link TagOperation#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TagOperation.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_ATTR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.REPLACE_ATTR, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.APPEND_ATTR, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.DELETE_ATTR, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CLEAR_ALL_ATTR, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(TagOperation.valueOf(42));
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, TagOperation.valueOf(0));
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, TagOperation.valueOf(1));
    assertEquals(TagOperation.CREATE_ATTR, TagOperation.valueOf(2));
    assertEquals(TagOperation.REPLACE_ATTR, TagOperation.valueOf(3));
    assertEquals(TagOperation.APPEND_ATTR, TagOperation.valueOf(4));
    assertEquals(TagOperation.DELETE_ATTR, TagOperation.valueOf(5));
    assertEquals(TagOperation.CLEAR_ALL_ATTR, TagOperation.valueOf(6));
  }
}

package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class PartTypeDiffblueTest {
  /**
   * Method under test: {@link PartType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(PartType.forNumber(42));
    assertEquals(PartType.PART_ROOT, PartType.forNumber(0));
    assertEquals(PartType.PART_BY_RANGE, PartType.forNumber(1));
    assertEquals(PartType.PART_BY_VALUE, PartType.forNumber(2));
  }

  /**
   * Method under test: {@link PartType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, PartType.PART_ROOT.getNumber());
    assertThrows(IllegalArgumentException.class, () -> PartType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link PartType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> PartType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_BY_RANGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_BY_VALUE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link PartType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<PartType> actualInternalGetValueMapResult = PartType.internalGetValueMap();

    // Assert
    assertEquals(PartType.PART_ROOT, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link PartType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(PartType.valueOf(42));
    assertEquals(PartType.PART_ROOT, PartType.valueOf(0));
    assertEquals(PartType.PART_BY_RANGE, PartType.valueOf(1));
    assertEquals(PartType.PART_BY_VALUE, PartType.valueOf(2));
  }
}

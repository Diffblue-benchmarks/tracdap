package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class IncarnationStatusDiffblueTest {
  /**
   * Method under test: {@link IncarnationStatus#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(IncarnationStatus.forNumber(42));
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, IncarnationStatus.forNumber(0));
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, IncarnationStatus.forNumber(1));
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, IncarnationStatus.forNumber(2));
  }

  /**
   * Method under test: {@link IncarnationStatus#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, IncarnationStatus.INCARNATION_STATUS_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> IncarnationStatus.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link IncarnationStatus#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> IncarnationStatus.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link IncarnationStatus#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(IncarnationStatus.valueOf(42));
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, IncarnationStatus.valueOf(0));
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, IncarnationStatus.valueOf(1));
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, IncarnationStatus.valueOf(2));
  }
}

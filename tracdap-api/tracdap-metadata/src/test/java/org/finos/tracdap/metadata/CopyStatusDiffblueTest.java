package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class CopyStatusDiffblueTest {
  /**
   * Method under test: {@link CopyStatus#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(CopyStatus.forNumber(42));
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, CopyStatus.forNumber(0));
    assertEquals(CopyStatus.COPY_AVAILABLE, CopyStatus.forNumber(1));
    assertEquals(CopyStatus.COPY_EXPUNGED, CopyStatus.forNumber(2));
  }

  /**
   * Method under test: {@link CopyStatus#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, CopyStatus.COPY_STATUS_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> CopyStatus.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link CopyStatus#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> CopyStatus.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_AVAILABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_EXPUNGED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link CopyStatus#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(CopyStatus.valueOf(42));
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, CopyStatus.valueOf(0));
    assertEquals(CopyStatus.COPY_AVAILABLE, CopyStatus.valueOf(1));
    assertEquals(CopyStatus.COPY_EXPUNGED, CopyStatus.valueOf(2));
  }
}

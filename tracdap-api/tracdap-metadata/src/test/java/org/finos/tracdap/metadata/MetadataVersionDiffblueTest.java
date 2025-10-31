package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class MetadataVersionDiffblueTest {
  /**
   * Method under test: {@link MetadataVersion#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(MetadataVersion.forNumber(42));
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, MetadataVersion.forNumber(0));
    assertEquals(MetadataVersion.V1, MetadataVersion.forNumber(1));
  }

  /**
   * Method under test: {@link MetadataVersion#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataVersion.METADATA_VERSION_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> MetadataVersion.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link MetadataVersion#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MetadataVersion.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertEquals(MetadataVersion.V1, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link MetadataVersion#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(MetadataVersion.valueOf(42));
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, MetadataVersion.valueOf(0));
    assertEquals(MetadataVersion.V1, MetadataVersion.valueOf(1));
  }
}

package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class MetadataFormatDiffblueTest {
  /**
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(MetadataFormat.forNumber(42));
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, MetadataFormat.forNumber(0));
    assertEquals(MetadataFormat.PROTO, MetadataFormat.forNumber(1));
    assertEquals(MetadataFormat.JSON, MetadataFormat.forNumber(2));
    assertEquals(MetadataFormat.YAML, MetadataFormat.forNumber(3));
  }

  /**
   * Method under test: {@link MetadataFormat#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataFormat.METADATA_FORMAT_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> MetadataFormat.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link MetadataFormat#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MetadataFormat.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.PROTO, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.JSON, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.YAML, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(MetadataFormat.valueOf(42));
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, MetadataFormat.valueOf(0));
    assertEquals(MetadataFormat.PROTO, MetadataFormat.valueOf(1));
    assertEquals(MetadataFormat.JSON, MetadataFormat.valueOf(2));
    assertEquals(MetadataFormat.YAML, MetadataFormat.valueOf(3));
  }
}

package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class ResourceTypeDiffblueTest {
  /**
   * Method under test: {@link ResourceType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(ResourceType.forNumber(42));
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, ResourceType.forNumber(0));
    assertEquals(ResourceType.MODEL_REPOSITORY, ResourceType.forNumber(1));
    assertEquals(ResourceType.INTERNAL_STORAGE, ResourceType.forNumber(2));
  }

  /**
   * Method under test: {@link ResourceType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, ResourceType.RESOURCE_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> ResourceType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link ResourceType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ResourceType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.MODEL_REPOSITORY, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.INTERNAL_STORAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link ResourceType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(ResourceType.valueOf(42));
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, ResourceType.valueOf(0));
    assertEquals(ResourceType.MODEL_REPOSITORY, ResourceType.valueOf(1));
    assertEquals(ResourceType.INTERNAL_STORAGE, ResourceType.valueOf(2));
  }
}

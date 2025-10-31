package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class ModelTypeDiffblueTest {
  /**
   * Method under test: {@link ModelType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(ModelType.forNumber(42));
    assertEquals(ModelType.STANDARD_MODEL, ModelType.forNumber(0));
    assertEquals(ModelType.DATA_IMPORT_MODEL, ModelType.forNumber(1));
    assertEquals(ModelType.DATA_EXPORT_MODEL, ModelType.forNumber(2));
  }

  /**
   * Method under test: {@link ModelType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, ModelType.STANDARD_MODEL.getNumber());
    assertThrows(IllegalArgumentException.class, () -> ModelType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link ModelType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ModelType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.DATA_IMPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.DATA_EXPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.STANDARD_MODEL, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link ModelType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(ModelType.valueOf(42));
    assertEquals(ModelType.STANDARD_MODEL, ModelType.valueOf(0));
    assertEquals(ModelType.DATA_IMPORT_MODEL, ModelType.valueOf(1));
    assertEquals(ModelType.DATA_EXPORT_MODEL, ModelType.valueOf(2));
  }
}

package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class DeploymentLayoutDiffblueTest {
  /**
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(DeploymentLayout.forNumber(42));
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, DeploymentLayout.forNumber(0));
    assertEquals(DeploymentLayout.SANDBOX, DeploymentLayout.forNumber(1));
    assertEquals(DeploymentLayout.HOSTED, DeploymentLayout.forNumber(2));
    assertEquals(DeploymentLayout.CUSTOM, DeploymentLayout.forNumber(3));
  }

  /**
   * Method under test: {@link DeploymentLayout#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, DeploymentLayout.LAYOUT_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> DeploymentLayout.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link DeploymentLayout#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> DeploymentLayout.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.SANDBOX, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.HOSTED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.CUSTOM, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(DeploymentLayout.valueOf(42));
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, DeploymentLayout.valueOf(0));
    assertEquals(DeploymentLayout.SANDBOX, DeploymentLayout.valueOf(1));
    assertEquals(DeploymentLayout.HOSTED, DeploymentLayout.valueOf(2));
    assertEquals(DeploymentLayout.CUSTOM, DeploymentLayout.valueOf(3));
  }
}

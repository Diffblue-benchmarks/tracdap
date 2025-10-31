package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class RoutingProtocolDiffblueTest {
  /**
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(RoutingProtocol.forNumber(42));
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, RoutingProtocol.forNumber(0));
    assertEquals(RoutingProtocol.HTTP, RoutingProtocol.forNumber(1));
    assertEquals(RoutingProtocol.GRPC, RoutingProtocol.forNumber(2));
    assertEquals(RoutingProtocol.GRPC_WEB, RoutingProtocol.forNumber(3));
    assertEquals(RoutingProtocol.REST, RoutingProtocol.forNumber(4));
  }

  /**
   * Method under test: {@link RoutingProtocol#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, RoutingProtocol.PROTOCOL_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> RoutingProtocol.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link RoutingProtocol#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RoutingProtocol.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.HTTP, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.GRPC, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.GRPC_WEB, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.REST, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(RoutingProtocol.valueOf(42));
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, RoutingProtocol.valueOf(0));
    assertEquals(RoutingProtocol.HTTP, RoutingProtocol.valueOf(1));
    assertEquals(RoutingProtocol.GRPC, RoutingProtocol.valueOf(2));
    assertEquals(RoutingProtocol.GRPC_WEB, RoutingProtocol.valueOf(3));
    assertEquals(RoutingProtocol.REST, RoutingProtocol.valueOf(4));
  }
}

package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoutingProtocolDiffblueTest {
  /**
   * Test {@link RoutingProtocol#getNumber()}.
   * <ul>
   *   <li>Given {@code PROTOCOL_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'PROTOCOL_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RoutingProtocol.getNumber()"})
  void testGetNumber_givenProtocolNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RoutingProtocol.PROTOCOL_NOT_SET.getNumber());
  }

  /**
   * Test {@link RoutingProtocol#getNumber()}.
   * <ul>
   *   <li>Given {@link RoutingProtocol#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RoutingProtocol.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RoutingProtocol.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RoutingProtocol.valueOf(42));
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code REST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'REST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnRest() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.REST, RoutingProtocol.valueOf(4));
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code HTTP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'HTTP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.HTTP, RoutingProtocol.valueOf(1));
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code GRPC_WEB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'GRPC_WEB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnGrpcWeb() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.GRPC_WEB, RoutingProtocol.valueOf(3));
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code GRPC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'GRPC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnGrpc() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.GRPC, RoutingProtocol.valueOf(2));
  }

  /**
   * Test {@link RoutingProtocol#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code PROTOCOL_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'PROTOCOL_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnProtocolNotSet() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, RoutingProtocol.valueOf(0));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RoutingProtocol.forNumber(42));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code REST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'REST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenFour_thenReturnRest() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.REST, RoutingProtocol.forNumber(4));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code HTTP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'HTTP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenOne_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.HTTP, RoutingProtocol.forNumber(1));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code GRPC_WEB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'GRPC_WEB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenThree_thenReturnGrpcWeb() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.GRPC_WEB, RoutingProtocol.forNumber(3));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code GRPC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'GRPC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnGrpc() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.GRPC, RoutingProtocol.forNumber(2));
  }

  /**
   * Test {@link RoutingProtocol#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code PROTOCOL_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'PROTOCOL_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RoutingProtocol.forNumber(int)"})
  void testForNumber_whenZero_thenReturnProtocolNotSet() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, RoutingProtocol.forNumber(0));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code REST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'REST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsRest() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.REST, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code HTTP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'HTTP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsHttp() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.HTTP, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link PlatformConfig#TENANTS_FIELD_NUMBER} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber TENANTS_FIELD_NUMBER is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTenants_field_numberIsNull() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code GRPC_WEB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'GRPC_WEB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsGrpcWeb() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.GRPC_WEB, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code GRPC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'GRPC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsGrpc() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.GRPC, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link RoutingProtocol#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code PROTOCOL_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'PROTOCOL_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap RoutingProtocol.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsProtocolNotSet() {
    // Arrange and Act
    EnumLiteMap<RoutingProtocol> actualInternalGetValueMapResult = RoutingProtocol.internalGetValueMap();

    // Assert
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link RoutingProtocol#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code PROTOCOL_NOT_SET}.</li>
   *   <li>Then return Name is {@code PROTOCOL_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'PROTOCOL_NOT_SET'; then return Name is 'PROTOCOL_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor RoutingProtocol.getValueDescriptor()"})
  void testGetValueDescriptor_givenProtocolNotSet_thenReturnNameIsProtocolNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = RoutingProtocol.PROTOCOL_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("PROTOCOL_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.config.RoutingProtocol.PROTOCOL_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link RoutingProtocol#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link RoutingProtocol#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoutingProtocol#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor RoutingProtocol.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RoutingProtocol.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link RoutingProtocol#getDescriptorForType()}.
   * <p>
   * Method under test: {@link RoutingProtocol#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor RoutingProtocol.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = RoutingProtocol.PROTOCOL_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("RoutingProtocol", actualDescriptorForType.getName());
    assertEquals("tracdap.config.RoutingProtocol", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(5, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link RoutingProtocol#getDescriptor()}.
   * <p>
   * Method under test: {@link RoutingProtocol#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor RoutingProtocol.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = RoutingProtocol.getDescriptor();

    // Assert
    assertEquals("RoutingProtocol", actualDescriptor.getName());
    assertEquals("tracdap.config.RoutingProtocol", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RouteConfigDiffblueTest {
  /**
   * Test {@link RouteConfig#getRouteName()}.
   * <p>
   * Method under test: {@link RouteConfig#getRouteName()}
   */
  @Test
  @DisplayName("Test getRouteName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RouteConfig.getRouteName()"})
  void testGetRouteName() {
    // Arrange, Act and Assert
    assertEquals("", RouteConfig.getDefaultInstance().getRouteName());
  }

  /**
   * Test {@link RouteConfig#getRouteNameBytes()}.
   * <p>
   * Method under test: {@link RouteConfig#getRouteNameBytes()}
   */
  @Test
  @DisplayName("Test getRouteNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString RouteConfig.getRouteNameBytes()"})
  void testGetRouteNameBytes() {
    // Arrange
    RouteConfig defaultInstance = RouteConfig.getDefaultInstance();

    // Act
    ByteString actualRouteNameBytes = defaultInstance.getRouteNameBytes();

    // Assert
    ByteString byteString = actualRouteNameBytes.EMPTY;
    assertEquals(byteString, actualRouteNameBytes);
    RoutingMatch match = defaultInstance.getMatch();
    assertEquals(byteString, match.getHostBytes());
    assertEquals(byteString, match.getPathBytes());
    RoutingTarget target = defaultInstance.getTarget();
    assertEquals(byteString, target.getHostAliasBytes());
    assertEquals(byteString, target.getHostBytes());
    assertEquals(byteString, target.getPathBytes());
    assertEquals(byteString, target.getSchemeBytes());
  }

  /**
   * Test {@link RouteConfig#getRouteType()}.
   * <p>
   * Method under test: {@link RouteConfig#getRouteType()}
   */
  @Test
  @DisplayName("Test getRouteType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingProtocol RouteConfig.getRouteType()"})
  void testGetRouteType() {
    // Arrange, Act and Assert
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, RouteConfig.getDefaultInstance().getRouteType());
  }

  /**
   * Test {@link RouteConfig#getProtocolsList()}.
   * <p>
   * Method under test: {@link RouteConfig#getProtocolsList()}
   */
  @Test
  @DisplayName("Test getProtocolsList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RouteConfig.getProtocolsList()"})
  void testGetProtocolsList() {
    // Arrange, Act and Assert
    assertTrue(RouteConfig.getDefaultInstance().getProtocolsList().isEmpty());
  }

  /**
   * Test {@link RouteConfig#getProtocolsCount()}.
   * <p>
   * Method under test: {@link RouteConfig#getProtocolsCount()}
   */
  @Test
  @DisplayName("Test getProtocolsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RouteConfig.getProtocolsCount()"})
  void testGetProtocolsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RouteConfig.getDefaultInstance().getProtocolsCount());
  }

  /**
   * Test {@link RouteConfig#hasMatch()}.
   * <p>
   * Method under test: {@link RouteConfig#hasMatch()}
   */
  @Test
  @DisplayName("Test hasMatch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.hasMatch()"})
  void testHasMatch() {
    // Arrange, Act and Assert
    assertFalse(RouteConfig.getDefaultInstance().hasMatch());
  }

  /**
   * Test {@link RouteConfig#getMatch()}.
   * <p>
   * Method under test: {@link RouteConfig#getMatch()}
   */
  @Test
  @DisplayName("Test getMatch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingMatch RouteConfig.getMatch()"})
  void testGetMatch() {
    // Arrange and Act
    RoutingMatch actualMatch = RouteConfig.getDefaultInstance().getMatch();

    // Assert
    assertEquals("", actualMatch.getInitializationErrorString());
    assertEquals("", actualMatch.getHost());
    assertEquals("", actualMatch.getPath());
    assertEquals(0, actualMatch.getSerializedSize());
    assertTrue(actualMatch.findInitializationErrors().isEmpty());
    assertTrue(actualMatch.getAllFields().isEmpty());
    assertTrue(actualMatch.isInitialized());
    assertSame(actualMatch, actualMatch.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#hasTarget()}.
   * <p>
   * Method under test: {@link RouteConfig#hasTarget()}
   */
  @Test
  @DisplayName("Test hasTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.hasTarget()"})
  void testHasTarget() {
    // Arrange, Act and Assert
    assertFalse(RouteConfig.getDefaultInstance().hasTarget());
  }

  /**
   * Test {@link RouteConfig#getTarget()}.
   * <p>
   * Method under test: {@link RouteConfig#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoutingTarget RouteConfig.getTarget()"})
  void testGetTarget() {
    // Arrange and Act
    RoutingTarget actualTarget = RouteConfig.getDefaultInstance().getTarget();

    // Assert
    assertEquals("", actualTarget.getInitializationErrorString());
    assertEquals("", actualTarget.getHost());
    assertEquals("", actualTarget.getHostAlias());
    assertEquals("", actualTarget.getPath());
    assertEquals("", actualTarget.getScheme());
    assertEquals(0, actualTarget.getPort());
    assertEquals(0, actualTarget.getSerializedSize());
    assertFalse(actualTarget.hasHostAlias());
    assertTrue(actualTarget.findInitializationErrors().isEmpty());
    assertTrue(actualTarget.getAllFields().isEmpty());
    assertTrue(actualTarget.isInitialized());
    assertSame(actualTarget, actualTarget.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#isInitialized()}.
   * <p>
   * Method under test: {@link RouteConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RouteConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RouteConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link RouteConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RouteConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RouteConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RouteConfig#equals(Object)}, and {@link RouteConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RouteConfig#equals(Object)}
   *   <li>{@link RouteConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.equals(Object)", "int RouteConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RouteConfig defaultInstance = RouteConfig.getDefaultInstance();
    RouteConfig defaultInstance2 = RouteConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RouteConfig#equals(Object)}, and {@link RouteConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RouteConfig#equals(Object)}
   *   <li>{@link RouteConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.equals(Object)", "int RouteConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RouteConfig defaultInstance = RouteConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RouteConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.equals(Object)", "int RouteConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RouteConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RouteConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.equals(Object)", "int RouteConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RouteConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link RouteConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RouteConfig.equals(Object)", "int RouteConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RouteConfig.getDefaultInstance(), "Different type to RouteConfig");
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRouteNameBytes = data.EMPTY;
    assertEquals(expectedRouteNameBytes, actualParseFromResult.getRouteNameBytes());
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRouteNameBytes = data.EMPTY;
    assertEquals(expectedRouteNameBytes, actualParseFromResult.getRouteNameBytes());
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRouteNameBytes = data.EMPTY;
    assertEquals(expectedRouteNameBytes, actualParseFromResult.getRouteNameBytes());
  }

  /**
   * Test {@link RouteConfig#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRouteNameBytes = data.EMPTY;
    assertEquals(expectedRouteNameBytes, actualParseFromResult.getRouteNameBytes());
  }

  /**
   * Test {@link RouteConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; when CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_whenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getRouteName());
    assertEquals(0, actualParseFromResult.getProtocolsCount());
    assertEquals(0, actualParseFromResult.getRouteTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(RoutingProtocol.PROTOCOL_NOT_SET, actualParseFromResult.getRouteType());
    assertFalse(actualParseFromResult.hasMatch());
    assertFalse(actualParseFromResult.hasTarget());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsList().isEmpty());
    assertTrue(actualParseFromResult.getProtocolsValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RouteConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RouteConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RouteConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RouteConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    RoutingMatch match = actualParseFromResult.getMatch();
    assertSame(unknownFields, match.getUnknownFields());
    RoutingTarget target = actualParseFromResult.getTarget();
    assertSame(unknownFields, target.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(match, actualParseFromResult.getMatchOrBuilder());
    assertSame(match, match.getDefaultInstanceForType());
    assertSame(target, actualParseFromResult.getTargetOrBuilder());
    assertSame(target, target.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RouteConfig actualParseFromResult = RouteConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    RoutingMatch match = actualParseFromResult.getMatch();
    assertSame(unknownFields, match.getUnknownFields());
    RoutingTarget target = actualParseFromResult.getTarget();
    assertSame(unknownFields, target.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(match, actualParseFromResult.getMatchOrBuilder());
    assertSame(match, match.getDefaultInstanceForType());
    assertSame(target, actualParseFromResult.getTargetOrBuilder());
    assertSame(target, target.getDefaultInstanceForType());
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RouteConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RouteConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RouteConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        RouteConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RouteConfig actualParseDelimitedFromResult = RouteConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RouteConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RouteConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RouteConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RouteConfig.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RouteConfig actualParseDelimitedFromResult = RouteConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RouteConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RouteConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RouteConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RouteConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RouteConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RouteConfig RouteConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RouteConfig defaultInstance = RouteConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

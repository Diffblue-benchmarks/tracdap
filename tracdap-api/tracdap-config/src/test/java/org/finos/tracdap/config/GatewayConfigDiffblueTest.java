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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GatewayConfigDiffblueTest {
  /**
   * Test {@link GatewayConfig#getRoutesCount()}.
   * <p>
   * Method under test: {@link GatewayConfig#getRoutesCount()}
   */
  @Test
  @DisplayName("Test getRoutesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayConfig.getRoutesCount()"})
  void testGetRoutesCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getRoutesCount());
  }

  /**
   * Test {@link GatewayConfig#getRedirectsCount()}.
   * <p>
   * Method under test: {@link GatewayConfig#getRedirectsCount()}
   */
  @Test
  @DisplayName("Test getRedirectsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayConfig.getRedirectsCount()"})
  void testGetRedirectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getRedirectsCount());
  }

  /**
   * Test {@link GatewayConfig#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link GatewayConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link GatewayConfig#equals(Object)}, and {@link GatewayConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayConfig#equals(Object)}
   *   <li>{@link GatewayConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.equals(Object)", "int GatewayConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayConfig defaultInstance = GatewayConfig.getDefaultInstance();
    GatewayConfig defaultInstance2 = GatewayConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link GatewayConfig#equals(Object)}, and {@link GatewayConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayConfig#equals(Object)}
   *   <li>{@link GatewayConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.equals(Object)", "int GatewayConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayConfig defaultInstance = GatewayConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link GatewayConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.equals(Object)", "int GatewayConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link GatewayConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.equals(Object)", "int GatewayConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link GatewayConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayConfig.equals(Object)", "int GatewayConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), "Different type to GatewayConfig");
  }

  /**
   * Test {@link GatewayConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRedirectsCount());
    assertEquals(0, actualParseFromResult.getRoutesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualParseFromResult.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(redirectsList, actualParseFromResult.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualParseFromResult.getRoutesList());
    assertSame(redirectsList, actualParseFromResult.getRoutesOrBuilderList());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRedirectsCount());
    assertEquals(0, actualParseFromResult.getRoutesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualParseFromResult.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(redirectsList, actualParseFromResult.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualParseFromResult.getRoutesList());
    assertSame(redirectsList, actualParseFromResult.getRoutesOrBuilderList());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRedirectsCount());
    assertEquals(0, actualParseFromResult.getRoutesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualParseFromResult.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(redirectsList, actualParseFromResult.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualParseFromResult.getRoutesList());
    assertSame(redirectsList, actualParseFromResult.getRoutesOrBuilderList());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRedirectsCount());
    assertEquals(0, actualParseFromResult.getRoutesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualParseFromResult.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(redirectsList, actualParseFromResult.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualParseFromResult.getRoutesList());
    assertSame(redirectsList, actualParseFromResult.getRoutesOrBuilderList());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRedirectsCount());
    assertEquals(0, actualParseFromResult.getRoutesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualParseFromResult.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(redirectsList, actualParseFromResult.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualParseFromResult.getRoutesList());
    assertSame(redirectsList, actualParseFromResult.getRoutesOrBuilderList());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link GatewayConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayConfig actualParseFromResult = GatewayConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayConfig actualParseDelimitedFromResult = GatewayConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayConfig actualParseDelimitedFromResult = GatewayConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayConfig actualParseDelimitedFromResult = GatewayConfig.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayConfig actualParseDelimitedFromResult = GatewayConfig.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GatewayConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link GatewayConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig GatewayConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    GatewayConfig defaultInstance = GatewayConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

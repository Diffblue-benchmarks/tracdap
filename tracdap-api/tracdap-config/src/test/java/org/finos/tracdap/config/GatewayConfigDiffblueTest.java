package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GatewayConfigDiffblueTest {
  /**
   * Method under test: {@link GatewayConfig#getRoutesCount()}
   */
  @Test
  void testGetRoutesCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getRoutesCount());
  }

  /**
   * Method under test: {@link GatewayConfig#getRedirectsCount()}
   */
  @Test
  void testGetRedirectsCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getRedirectsCount());
  }

  /**
   * Method under test: {@link GatewayConfig#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link GatewayConfig#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayConfig#equals(Object)}
   *   <li>{@link GatewayConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayConfig#equals(Object)}
   *   <li>{@link GatewayConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayConfig defaultInstance = GatewayConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link GatewayConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link GatewayConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link GatewayConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test:
   * {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
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
   * Method under test:
   * {@link GatewayConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test: {@link GatewayConfig#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    GatewayConfig defaultInstance = GatewayConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link GatewayConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayConfig.getDefaultInstance(), "Different type to GatewayConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayConfig#getDefaultInstance()}
   *   <li>{@link GatewayConfig#getDescriptor()}
   *   <li>{@link GatewayConfig#newBuilder()}
   *   <li>{@link GatewayConfig#newBuilder(GatewayConfig)}
   *   <li>{@link GatewayConfig#newBuilderForType()}
   *   <li>{@link GatewayConfig#toBuilder()}
   *   <li>{@link GatewayConfig#getParserForType()}
   *   <li>{@link GatewayConfig#getRedirectsList()}
   *   <li>{@link GatewayConfig#getRedirectsOrBuilderList()}
   *   <li>{@link GatewayConfig#getRoutesList()}
   *   <li>{@link GatewayConfig#getRoutesOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GatewayConfig actualDefaultInstance = GatewayConfig.getDefaultInstance();
    GatewayConfig actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    GatewayConfig prototype = GatewayConfig.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    List<GatewayRedirect> actualRedirectsList = actualDefaultInstance.getRedirectsList();
    List<? extends GatewayRedirectOrBuilder> actualRedirectsOrBuilderList = actualDefaultInstance
        .getRedirectsOrBuilderList();
    List<RouteConfig> actualRoutesList = actualDefaultInstance.getRoutesList();
    List<? extends RouteConfigOrBuilder> actualRoutesOrBuilderList = actualDefaultInstance.getRoutesOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualRedirectsList);
    assertSame(uninterpretedOptionList, actualRedirectsOrBuilderList);
    assertSame(uninterpretedOptionList, actualRoutesList);
    assertSame(uninterpretedOptionList, actualRoutesOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

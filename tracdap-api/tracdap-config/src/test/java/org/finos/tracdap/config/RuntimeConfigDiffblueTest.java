package org.finos.tracdap.config;

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
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RuntimeConfigDiffblueTest {
  /**
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RuntimeConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RuntimeConfig.getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RuntimeConfig.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeConfig#getConfigCount()}
   */
  @Test
  void testGetConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getConfigCount());
  }

  /**
   * Method under test: {@link RuntimeConfig#containsConfig(String)}
   */
  @Test
  void testContainsConfig() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().containsConfig("Key"));
  }

  /**
   * Method under test: {@link RuntimeConfig#getConfig()}
   */
  @Test
  void testGetConfig() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getConfig().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeConfig#getConfigMap()}
   */
  @Test
  void testGetConfigMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getConfigMap().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeConfig#getConfigOrDefault(String, String)}
   */
  @Test
  void testGetConfigOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", RuntimeConfig.getDefaultInstance().getConfigOrDefault("Key", "42"));
  }

  /**
   * Method under test: {@link RuntimeConfig#getConfigOrThrow(String)}
   */
  @Test
  void testGetConfigOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeConfig.getDefaultInstance().getConfigOrThrow("Key"));
  }

  /**
   * Method under test: {@link RuntimeConfig#hasStorage()}
   */
  @Test
  void testHasStorage() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasStorage());
  }

  /**
   * Method under test: {@link RuntimeConfig#getRepositoriesCount()}
   */
  @Test
  void testGetRepositoriesCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getRepositoriesCount());
  }

  /**
   * Method under test: {@link RuntimeConfig#containsRepositories(String)}
   */
  @Test
  void testContainsRepositories() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().containsRepositories("Key"));
  }

  /**
   * Method under test: {@link RuntimeConfig#getRepositories()}
   */
  @Test
  void testGetRepositories() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getRepositories().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeConfig#getRepositoriesMap()}
   */
  @Test
  void testGetRepositoriesMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getRepositoriesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#getRepositoriesOrDefault(String, PluginConfig)}
   */
  @Test
  void testGetRepositoriesOrDefault() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();
    PluginConfig defaultValue = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getRepositoriesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RuntimeConfig#getRepositoriesOrThrow(String)}
   */
  @Test
  void testGetRepositoriesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RuntimeConfig.getDefaultInstance().getRepositoriesOrThrow("Key"));
  }

  /**
   * Method under test: {@link RuntimeConfig#hasSparkSettings()}
   */
  @Test
  void testHasSparkSettings() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasSparkSettings());
  }

  /**
   * Method under test: {@link RuntimeConfig#hasRuntimeApi()}
   */
  @Test
  void testHasRuntimeApi() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasRuntimeApi());
  }

  /**
   * Method under test: {@link RuntimeConfig#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link RuntimeConfig#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeConfig#equals(Object)}
   *   <li>{@link RuntimeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();
    RuntimeConfig defaultInstance2 = RuntimeConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeConfig#equals(Object)}
   *   <li>{@link RuntimeConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RuntimeConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeConfig#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), "Different type to RuntimeConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeConfig#getDefaultInstance()}
   *   <li>{@link RuntimeConfig#getDescriptor()}
   *   <li>{@link RuntimeConfig#newBuilder()}
   *   <li>{@link RuntimeConfig#newBuilder(RuntimeConfig)}
   *   <li>{@link RuntimeConfig#newBuilderForType()}
   *   <li>{@link RuntimeConfig#toBuilder()}
   *   <li>{@link RuntimeConfig#getParserForType()}
   *   <li>{@link RuntimeConfig#getRuntimeApiOrBuilder()}
   *   <li>{@link RuntimeConfig#getSparkSettingsOrBuilder()}
   *   <li>{@link RuntimeConfig#getStorageOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuntimeConfig actualDefaultInstance = RuntimeConfig.getDefaultInstance();
    RuntimeConfig actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    RuntimeConfig prototype = RuntimeConfig.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();
    ServiceConfigOrBuilder actualRuntimeApiOrBuilder = actualDefaultInstance.getRuntimeApiOrBuilder();
    SparkSettingsOrBuilder actualSparkSettingsOrBuilder = actualDefaultInstance.getSparkSettingsOrBuilder();
    StorageConfigOrBuilder actualStorageOrBuilder = actualDefaultInstance.getStorageOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getRuntimeApi(), actualRuntimeApiOrBuilder);
    assertSame(actualDefaultInstance.getSparkSettings(), actualSparkSettingsOrBuilder);
    assertSame(actualDefaultInstance.getStorage(), actualStorageOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

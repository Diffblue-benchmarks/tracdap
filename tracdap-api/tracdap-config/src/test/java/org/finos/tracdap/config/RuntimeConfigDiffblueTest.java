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
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
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

class RuntimeConfigDiffblueTest {
  /**
   * Test {@link RuntimeConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RuntimeConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RuntimeConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Test {@link RuntimeConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when one; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RuntimeConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenOne_thenReturnMapField() {
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
   * Test {@link RuntimeConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RuntimeConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
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
   * Test {@link RuntimeConfig#getConfigCount()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getConfigCount()}
   */
  @Test
  @DisplayName("Test getConfigCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeConfig.getConfigCount()"})
  void testGetConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getConfigCount());
  }

  /**
   * Test {@link RuntimeConfig#containsConfig(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#containsConfig(String)}
   */
  @Test
  @DisplayName("Test containsConfig(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.containsConfig(String)"})
  void testContainsConfig_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().containsConfig("Key"));
  }

  /**
   * Test {@link RuntimeConfig#getConfig()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeConfig.getConfig()"})
  void testGetConfig() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getConfig().isEmpty());
  }

  /**
   * Test {@link RuntimeConfig#getConfigMap()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getConfigMap()}
   */
  @Test
  @DisplayName("Test getConfigMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeConfig.getConfigMap()"})
  void testGetConfigMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getConfigMap().isEmpty());
  }

  /**
   * Test {@link RuntimeConfig#getConfigOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#getConfigOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test getConfigOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuntimeConfig.getConfigOrDefault(String, String)"})
  void testGetConfigOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", RuntimeConfig.getDefaultInstance().getConfigOrDefault("Key", "42"));
  }

  /**
   * Test {@link RuntimeConfig#getConfigOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#getConfigOrThrow(String)}
   */
  @Test
  @DisplayName("Test getConfigOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuntimeConfig.getConfigOrThrow(String)"})
  void testGetConfigOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeConfig.getDefaultInstance().getConfigOrThrow("Key"));
  }

  /**
   * Test {@link RuntimeConfig#hasStorage()}.
   * <p>
   * Method under test: {@link RuntimeConfig#hasStorage()}
   */
  @Test
  @DisplayName("Test hasStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.hasStorage()"})
  void testHasStorage() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasStorage());
  }

  /**
   * Test {@link RuntimeConfig#getStorage()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getStorage()}
   */
  @Test
  @DisplayName("Test getStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageConfig RuntimeConfig.getStorage()"})
  void testGetStorage() {
    // Arrange and Act
    StorageConfig actualStorage = RuntimeConfig.getDefaultInstance().getStorage();

    // Assert
    assertEquals("", actualStorage.getInitializationErrorString());
    assertEquals("", actualStorage.getDefaultBucket());
    assertEquals("", actualStorage.getDefaultFormat());
    assertEquals(0, actualStorage.getBucketsCount());
    assertEquals(0, actualStorage.getExternalCount());
    assertEquals(0, actualStorage.getSerializedSize());
    assertTrue(actualStorage.findInitializationErrors().isEmpty());
    assertTrue(actualStorage.getAllFields().isEmpty());
    assertTrue(actualStorage.getBuckets().isEmpty());
    assertTrue(actualStorage.getBucketsMap().isEmpty());
    assertTrue(actualStorage.getExternal().isEmpty());
    assertTrue(actualStorage.getExternalMap().isEmpty());
    assertTrue(actualStorage.isInitialized());
    assertSame(actualStorage, actualStorage.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#getRepositoriesCount()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getRepositoriesCount()}
   */
  @Test
  @DisplayName("Test getRepositoriesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeConfig.getRepositoriesCount()"})
  void testGetRepositoriesCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getRepositoriesCount());
  }

  /**
   * Test {@link RuntimeConfig#containsRepositories(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#containsRepositories(String)}
   */
  @Test
  @DisplayName("Test containsRepositories(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.containsRepositories(String)"})
  void testContainsRepositories_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().containsRepositories("Key"));
  }

  /**
   * Test {@link RuntimeConfig#getRepositories()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getRepositories()}
   */
  @Test
  @DisplayName("Test getRepositories()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeConfig.getRepositories()"})
  void testGetRepositories() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getRepositories().isEmpty());
  }

  /**
   * Test {@link RuntimeConfig#getRepositoriesMap()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getRepositoriesMap()}
   */
  @Test
  @DisplayName("Test getRepositoriesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeConfig.getRepositoriesMap()"})
  void testGetRepositoriesMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().getRepositoriesMap().isEmpty());
  }

  /**
   * Test {@link RuntimeConfig#getRepositoriesOrDefault(String, PluginConfig)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#getRepositoriesOrDefault(String, PluginConfig)}
   */
  @Test
  @DisplayName("Test getRepositoriesOrDefault(String, PluginConfig); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig RuntimeConfig.getRepositoriesOrDefault(String, PluginConfig)"})
  void testGetRepositoriesOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();
    PluginConfig defaultValue = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getRepositoriesOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RuntimeConfig#getRepositoriesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#getRepositoriesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getRepositoriesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig RuntimeConfig.getRepositoriesOrThrow(String)"})
  void testGetRepositoriesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RuntimeConfig.getDefaultInstance().getRepositoriesOrThrow("Key"));
  }

  /**
   * Test {@link RuntimeConfig#hasSparkSettings()}.
   * <p>
   * Method under test: {@link RuntimeConfig#hasSparkSettings()}
   */
  @Test
  @DisplayName("Test hasSparkSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.hasSparkSettings()"})
  void testHasSparkSettings() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasSparkSettings());
  }

  /**
   * Test {@link RuntimeConfig#getSparkSettings()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getSparkSettings()}
   */
  @Test
  @DisplayName("Test getSparkSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkSettings RuntimeConfig.getSparkSettings()"})
  void testGetSparkSettings() {
    // Arrange and Act
    SparkSettings actualSparkSettings = RuntimeConfig.getDefaultInstance().getSparkSettings();

    // Assert
    assertEquals("", actualSparkSettings.getInitializationErrorString());
    assertEquals(0, actualSparkSettings.getSerializedSize());
    assertEquals(0, actualSparkSettings.getSparkPropsCount());
    assertTrue(actualSparkSettings.findInitializationErrors().isEmpty());
    assertTrue(actualSparkSettings.getAllFields().isEmpty());
    assertTrue(actualSparkSettings.getSparkProps().isEmpty());
    assertTrue(actualSparkSettings.getSparkPropsMap().isEmpty());
    assertTrue(actualSparkSettings.isInitialized());
    assertSame(actualSparkSettings, actualSparkSettings.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#hasRuntimeApi()}.
   * <p>
   * Method under test: {@link RuntimeConfig#hasRuntimeApi()}
   */
  @Test
  @DisplayName("Test hasRuntimeApi()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.hasRuntimeApi()"})
  void testHasRuntimeApi() {
    // Arrange, Act and Assert
    assertFalse(RuntimeConfig.getDefaultInstance().hasRuntimeApi());
  }

  /**
   * Test {@link RuntimeConfig#getRuntimeApi()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getRuntimeApi()}
   */
  @Test
  @DisplayName("Test getRuntimeApi()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceConfig RuntimeConfig.getRuntimeApi()"})
  void testGetRuntimeApi() {
    // Arrange and Act
    ServiceConfig actualRuntimeApi = RuntimeConfig.getDefaultInstance().getRuntimeApi();

    // Assert
    assertEquals("", actualRuntimeApi.getInitializationErrorString());
    assertEquals("", actualRuntimeApi.getAlias());
    assertEquals(0, actualRuntimeApi.getPort());
    assertEquals(0, actualRuntimeApi.getPropertiesCount());
    assertEquals(0, actualRuntimeApi.getSerializedSize());
    assertFalse(actualRuntimeApi.getEnabled());
    assertFalse(actualRuntimeApi.hasEnabled());
    assertTrue(actualRuntimeApi.findInitializationErrors().isEmpty());
    assertTrue(actualRuntimeApi.getAllFields().isEmpty());
    assertTrue(actualRuntimeApi.getProperties().isEmpty());
    assertTrue(actualRuntimeApi.getPropertiesMap().isEmpty());
    assertTrue(actualRuntimeApi.isInitialized());
    assertSame(actualRuntimeApi, actualRuntimeApi.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#isInitialized()}.
   * <p>
   * Method under test: {@link RuntimeConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RuntimeConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RuntimeConfig#equals(Object)}, and {@link RuntimeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeConfig#equals(Object)}
   *   <li>{@link RuntimeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.equals(Object)", "int RuntimeConfig.hashCode()"})
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
   * Test {@link RuntimeConfig#equals(Object)}, and {@link RuntimeConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeConfig#equals(Object)}
   *   <li>{@link RuntimeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.equals(Object)", "int RuntimeConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RuntimeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.equals(Object)", "int RuntimeConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RuntimeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.equals(Object)", "int RuntimeConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link RuntimeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeConfig.equals(Object)", "int RuntimeConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeConfig.getDefaultInstance(), "Different type to RuntimeConfig");
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRuntimeApi());
    assertFalse(actualParseFromResult.hasSparkSettings());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRuntimeApi());
    assertFalse(actualParseFromResult.hasSparkSettings());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRuntimeApi());
    assertFalse(actualParseFromResult.hasSparkSettings());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRuntimeApi());
    assertFalse(actualParseFromResult.hasSparkSettings());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRuntimeApi());
    assertFalse(actualParseFromResult.hasSparkSettings());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ServiceConfig runtimeApi = actualParseFromResult.getRuntimeApi();
    assertSame(unknownFields, runtimeApi.getUnknownFields());
    SparkSettings sparkSettings = actualParseFromResult.getSparkSettings();
    assertSame(unknownFields, sparkSettings.getUnknownFields());
    StorageConfig storage = actualParseFromResult.getStorage();
    assertSame(unknownFields, storage.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(runtimeApi, actualParseFromResult.getRuntimeApiOrBuilder());
    assertSame(runtimeApi, runtimeApi.getDefaultInstanceForType());
    assertSame(sparkSettings, actualParseFromResult.getSparkSettingsOrBuilder());
    assertSame(sparkSettings, sparkSettings.getDefaultInstanceForType());
    assertSame(storage, actualParseFromResult.getStorageOrBuilder());
    assertSame(storage, storage.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RuntimeConfig actualParseFromResult = RuntimeConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ServiceConfig runtimeApi = actualParseFromResult.getRuntimeApi();
    assertSame(unknownFields, runtimeApi.getUnknownFields());
    SparkSettings sparkSettings = actualParseFromResult.getSparkSettings();
    assertSame(unknownFields, sparkSettings.getUnknownFields());
    StorageConfig storage = actualParseFromResult.getStorage();
    assertSame(unknownFields, storage.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(runtimeApi, actualParseFromResult.getRuntimeApiOrBuilder());
    assertSame(runtimeApi, runtimeApi.getDefaultInstanceForType());
    assertSame(sparkSettings, actualParseFromResult.getSparkSettingsOrBuilder());
    assertSame(sparkSettings, sparkSettings.getDefaultInstanceForType());
    assertSame(storage, actualParseFromResult.getStorageOrBuilder());
    assertSame(storage, storage.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        RuntimeConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeConfig actualParseDelimitedFromResult = RuntimeConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
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
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RuntimeConfig.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeConfig actualParseDelimitedFromResult = RuntimeConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
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
   * Test {@link RuntimeConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
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
   * Test {@link RuntimeConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RuntimeConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeConfig RuntimeConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeConfig defaultInstance = RuntimeConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

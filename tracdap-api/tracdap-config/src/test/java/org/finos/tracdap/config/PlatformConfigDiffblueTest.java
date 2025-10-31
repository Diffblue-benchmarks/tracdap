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
import com.google.protobuf.Any;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.MetadataFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlatformConfigDiffblueTest {
  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when eight; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenEight_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PlatformConfig.getDefaultInstance()
        .internalGetMapFieldReflection(8);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link PlatformConfig#EXTENSIONS_FIELD_NUMBER}.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when EXTENSIONS_FIELD_NUMBER; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenExtensions_field_number_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PlatformConfig.getDefaultInstance()
        .internalGetMapFieldReflection(PlatformConfig.EXTENSIONS_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PlatformConfig.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when one; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenOne_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PlatformConfig.getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link PlatformConfig#TENANTS_FIELD_NUMBER}.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when TENANTS_FIELD_NUMBER; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTenants_field_number_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PlatformConfig.getDefaultInstance()
        .internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PlatformConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PlatformConfig.getDefaultInstance().internalGetMapFieldReflection(2));
  }

  /**
   * Test {@link PlatformConfig#getConfigCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getConfigCount()}
   */
  @Test
  @DisplayName("Test getConfigCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getConfigCount()"})
  void testGetConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getConfigCount());
  }

  /**
   * Test {@link PlatformConfig#containsConfig(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsConfig(String)}
   */
  @Test
  @DisplayName("Test containsConfig(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsConfig(String)"})
  void testContainsConfig_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsConfig("Key"));
  }

  /**
   * Test {@link PlatformConfig#getConfig()}.
   * <p>
   * Method under test: {@link PlatformConfig#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getConfig()"})
  void testGetConfig() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getConfig().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getConfigMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getConfigMap()}
   */
  @Test
  @DisplayName("Test getConfigMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getConfigMap()"})
  void testGetConfigMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getConfigMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getConfigOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getConfigOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test getConfigOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PlatformConfig.getConfigOrDefault(String, String)"})
  void testGetConfigOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", PlatformConfig.getDefaultInstance().getConfigOrDefault("Key", "42"));
  }

  /**
   * Test {@link PlatformConfig#getConfigOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getConfigOrThrow(String)}
   */
  @Test
  @DisplayName("Test getConfigOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PlatformConfig.getConfigOrThrow(String)"})
  void testGetConfigOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getConfigOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#hasPlatformInfo()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasPlatformInfo()}
   */
  @Test
  @DisplayName("Test hasPlatformInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasPlatformInfo()"})
  void testHasPlatformInfo() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasPlatformInfo());
  }

  /**
   * Test {@link PlatformConfig#getPlatformInfo()}.
   * <p>
   * Method under test: {@link PlatformConfig#getPlatformInfo()}
   */
  @Test
  @DisplayName("Test getPlatformInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformInfo PlatformConfig.getPlatformInfo()"})
  void testGetPlatformInfo() {
    // Arrange and Act
    PlatformInfo actualPlatformInfo = PlatformConfig.getDefaultInstance().getPlatformInfo();

    // Assert
    assertEquals("", actualPlatformInfo.getInitializationErrorString());
    assertEquals("", actualPlatformInfo.getEnvironment());
    assertEquals(0, actualPlatformInfo.getDeploymentInfoCount());
    assertEquals(0, actualPlatformInfo.getSerializedSize());
    assertFalse(actualPlatformInfo.getProduction());
    assertTrue(actualPlatformInfo.findInitializationErrors().isEmpty());
    assertTrue(actualPlatformInfo.getAllFields().isEmpty());
    assertTrue(actualPlatformInfo.getDeploymentInfo().isEmpty());
    assertTrue(actualPlatformInfo.getDeploymentInfoMap().isEmpty());
    assertTrue(actualPlatformInfo.isInitialized());
    assertSame(actualPlatformInfo, actualPlatformInfo.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#hasMetadata()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasMetadata()}
   */
  @Test
  @DisplayName("Test hasMetadata()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasMetadata()"})
  void testHasMetadata() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasMetadata());
  }

  /**
   * Test {@link PlatformConfig#getMetadata()}.
   * <p>
   * Method under test: {@link PlatformConfig#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataConfig PlatformConfig.getMetadata()"})
  void testGetMetadata() {
    // Arrange and Act
    MetadataConfig actualMetadata = PlatformConfig.getDefaultInstance().getMetadata();

    // Assert
    assertEquals("", actualMetadata.getInitializationErrorString());
    assertEquals(0, actualMetadata.getFormatValue());
    assertEquals(0, actualMetadata.getSerializedSize());
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, actualMetadata.getFormat());
    assertFalse(actualMetadata.hasDatabase());
    assertTrue(actualMetadata.findInitializationErrors().isEmpty());
    assertTrue(actualMetadata.getAllFields().isEmpty());
    assertTrue(actualMetadata.isInitialized());
    assertSame(actualMetadata, actualMetadata.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#hasStorage()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasStorage()}
   */
  @Test
  @DisplayName("Test hasStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasStorage()"})
  void testHasStorage() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasStorage());
  }

  /**
   * Test {@link PlatformConfig#getStorage()}.
   * <p>
   * Method under test: {@link PlatformConfig#getStorage()}
   */
  @Test
  @DisplayName("Test getStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StorageConfig PlatformConfig.getStorage()"})
  void testGetStorage() {
    // Arrange and Act
    StorageConfig actualStorage = PlatformConfig.getDefaultInstance().getStorage();

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
   * Test {@link PlatformConfig#getRepositoriesCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getRepositoriesCount()}
   */
  @Test
  @DisplayName("Test getRepositoriesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getRepositoriesCount()"})
  void testGetRepositoriesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getRepositoriesCount());
  }

  /**
   * Test {@link PlatformConfig#containsRepositories(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsRepositories(String)}
   */
  @Test
  @DisplayName("Test containsRepositories(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsRepositories(String)"})
  void testContainsRepositories_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsRepositories("Key"));
  }

  /**
   * Test {@link PlatformConfig#getRepositories()}.
   * <p>
   * Method under test: {@link PlatformConfig#getRepositories()}
   */
  @Test
  @DisplayName("Test getRepositories()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getRepositories()"})
  void testGetRepositories() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getRepositories().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getRepositoriesMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getRepositoriesMap()}
   */
  @Test
  @DisplayName("Test getRepositoriesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getRepositoriesMap()"})
  void testGetRepositoriesMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getRepositoriesMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getRepositoriesOrDefault(String, PluginConfig)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getRepositoriesOrDefault(String, PluginConfig)}
   */
  @Test
  @DisplayName("Test getRepositoriesOrDefault(String, PluginConfig); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PlatformConfig.getRepositoriesOrDefault(String, PluginConfig)"})
  void testGetRepositoriesOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    PluginConfig defaultValue = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getRepositoriesOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link PlatformConfig#getRepositoriesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getRepositoriesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getRepositoriesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PlatformConfig.getRepositoriesOrThrow(String)"})
  void testGetRepositoriesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PlatformConfig.getDefaultInstance().getRepositoriesOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#hasExecutor()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasExecutor()}
   */
  @Test
  @DisplayName("Test hasExecutor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasExecutor()"})
  void testHasExecutor() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasExecutor());
  }

  /**
   * Test {@link PlatformConfig#getExecutor()}.
   * <p>
   * Method under test: {@link PlatformConfig#getExecutor()}
   */
  @Test
  @DisplayName("Test getExecutor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PlatformConfig.getExecutor()"})
  void testGetExecutor() {
    // Arrange and Act
    PluginConfig actualExecutor = PlatformConfig.getDefaultInstance().getExecutor();

    // Assert
    assertEquals("", actualExecutor.getInitializationErrorString());
    assertEquals("", actualExecutor.getProtocol());
    assertEquals(0, actualExecutor.getPropertiesCount());
    assertEquals(0, actualExecutor.getPublicPropertiesCount());
    assertEquals(0, actualExecutor.getSecretsCount());
    assertEquals(0, actualExecutor.getSerializedSize());
    assertTrue(actualExecutor.findInitializationErrors().isEmpty());
    assertTrue(actualExecutor.getAllFields().isEmpty());
    assertTrue(actualExecutor.getProperties().isEmpty());
    assertTrue(actualExecutor.getPropertiesMap().isEmpty());
    assertTrue(actualExecutor.getPublicProperties().isEmpty());
    assertTrue(actualExecutor.getPublicPropertiesMap().isEmpty());
    assertTrue(actualExecutor.getSecrets().isEmpty());
    assertTrue(actualExecutor.getSecretsMap().isEmpty());
    assertTrue(actualExecutor.isInitialized());
    assertSame(actualExecutor, actualExecutor.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#hasJobCache()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasJobCache()}
   */
  @Test
  @DisplayName("Test hasJobCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasJobCache()"})
  void testHasJobCache() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasJobCache());
  }

  /**
   * Test {@link PlatformConfig#getJobCache()}.
   * <p>
   * Method under test: {@link PlatformConfig#getJobCache()}
   */
  @Test
  @DisplayName("Test getJobCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PlatformConfig.getJobCache()"})
  void testGetJobCache() {
    // Arrange and Act
    PluginConfig actualJobCache = PlatformConfig.getDefaultInstance().getJobCache();

    // Assert
    assertEquals("", actualJobCache.getInitializationErrorString());
    assertEquals("", actualJobCache.getProtocol());
    assertEquals(0, actualJobCache.getPropertiesCount());
    assertEquals(0, actualJobCache.getPublicPropertiesCount());
    assertEquals(0, actualJobCache.getSecretsCount());
    assertEquals(0, actualJobCache.getSerializedSize());
    assertTrue(actualJobCache.findInitializationErrors().isEmpty());
    assertTrue(actualJobCache.getAllFields().isEmpty());
    assertTrue(actualJobCache.getProperties().isEmpty());
    assertTrue(actualJobCache.getPropertiesMap().isEmpty());
    assertTrue(actualJobCache.getPublicProperties().isEmpty());
    assertTrue(actualJobCache.getPublicPropertiesMap().isEmpty());
    assertTrue(actualJobCache.getSecrets().isEmpty());
    assertTrue(actualJobCache.getSecretsMap().isEmpty());
    assertTrue(actualJobCache.isInitialized());
    assertSame(actualJobCache, actualJobCache.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#getTenantsCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getTenantsCount()}
   */
  @Test
  @DisplayName("Test getTenantsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getTenantsCount()"})
  void testGetTenantsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getTenantsCount());
  }

  /**
   * Test {@link PlatformConfig#containsTenants(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsTenants(String)}
   */
  @Test
  @DisplayName("Test containsTenants(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsTenants(String)"})
  void testContainsTenants_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsTenants("Key"));
  }

  /**
   * Test {@link PlatformConfig#getTenants()}.
   * <p>
   * Method under test: {@link PlatformConfig#getTenants()}
   */
  @Test
  @DisplayName("Test getTenants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getTenants()"})
  void testGetTenants() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getTenants().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getTenantsMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getTenantsMap()}
   */
  @Test
  @DisplayName("Test getTenantsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getTenantsMap()"})
  void testGetTenantsMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getTenantsMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getTenantsOrDefault(String, TenantConfig)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getTenantsOrDefault(String, TenantConfig)}
   */
  @Test
  @DisplayName("Test getTenantsOrDefault(String, TenantConfig); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantConfig PlatformConfig.getTenantsOrDefault(String, TenantConfig)"})
  void testGetTenantsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    TenantConfig defaultValue = TenantConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getTenantsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link PlatformConfig#getTenantsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getTenantsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getTenantsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantConfig PlatformConfig.getTenantsOrThrow(String)"})
  void testGetTenantsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getTenantsOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#hasGateway()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasGateway()}
   */
  @Test
  @DisplayName("Test hasGateway()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasGateway()"})
  void testHasGateway() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasGateway());
  }

  /**
   * Test {@link PlatformConfig#getGateway()}.
   * <p>
   * Method under test: {@link PlatformConfig#getGateway()}
   */
  @Test
  @DisplayName("Test getGateway()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayConfig PlatformConfig.getGateway()"})
  void testGetGateway() {
    // Arrange and Act
    GatewayConfig actualGateway = PlatformConfig.getDefaultInstance().getGateway();

    // Assert
    assertEquals("", actualGateway.getInitializationErrorString());
    assertEquals(0, actualGateway.getRedirectsCount());
    assertEquals(0, actualGateway.getRoutesCount());
    assertEquals(0, actualGateway.getSerializedSize());
    assertTrue(actualGateway.findInitializationErrors().isEmpty());
    List<GatewayRedirect> redirectsList = actualGateway.getRedirectsList();
    assertTrue(redirectsList.isEmpty());
    assertTrue(actualGateway.getAllFields().isEmpty());
    assertTrue(actualGateway.isInitialized());
    assertSame(redirectsList, actualGateway.getRedirectsOrBuilderList());
    assertSame(redirectsList, actualGateway.getRoutesList());
    assertSame(redirectsList, actualGateway.getRoutesOrBuilderList());
    assertSame(actualGateway, actualGateway.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#getServicesCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getServicesCount()}
   */
  @Test
  @DisplayName("Test getServicesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getServicesCount()"})
  void testGetServicesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getServicesCount());
  }

  /**
   * Test {@link PlatformConfig#containsServices(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsServices(String)}
   */
  @Test
  @DisplayName("Test containsServices(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsServices(String)"})
  void testContainsServices_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsServices("Key"));
  }

  /**
   * Test {@link PlatformConfig#getServices()}.
   * <p>
   * Method under test: {@link PlatformConfig#getServices()}
   */
  @Test
  @DisplayName("Test getServices()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getServices()"})
  void testGetServices() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getServices().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getServicesMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getServicesMap()}
   */
  @Test
  @DisplayName("Test getServicesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getServicesMap()"})
  void testGetServicesMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getServicesMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getServicesOrDefault(String, ServiceConfig)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getServicesOrDefault(String, ServiceConfig)}
   */
  @Test
  @DisplayName("Test getServicesOrDefault(String, ServiceConfig); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceConfig PlatformConfig.getServicesOrDefault(String, ServiceConfig)"})
  void testGetServicesOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    ServiceConfig defaultValue = ServiceConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getServicesOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link PlatformConfig#getServicesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getServicesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getServicesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceConfig PlatformConfig.getServicesOrThrow(String)"})
  void testGetServicesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getServicesOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#hasDeployment()}.
   * <p>
   * Method under test: {@link PlatformConfig#hasDeployment()}
   */
  @Test
  @DisplayName("Test hasDeployment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.hasDeployment()"})
  void testHasDeployment() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasDeployment());
  }

  /**
   * Test {@link PlatformConfig#getDeployment()}.
   * <p>
   * Method under test: {@link PlatformConfig#getDeployment()}
   */
  @Test
  @DisplayName("Test getDeployment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentConfig PlatformConfig.getDeployment()"})
  void testGetDeployment() {
    // Arrange and Act
    DeploymentConfig actualDeployment = PlatformConfig.getDefaultInstance().getDeployment();

    // Assert
    assertEquals("", actualDeployment.getInitializationErrorString());
    assertEquals(0, actualDeployment.getLayoutValue());
    assertEquals(0, actualDeployment.getSerializedSize());
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, actualDeployment.getLayout());
    assertTrue(actualDeployment.findInitializationErrors().isEmpty());
    assertTrue(actualDeployment.getAllFields().isEmpty());
    assertTrue(actualDeployment.isInitialized());
    assertSame(actualDeployment, actualDeployment.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#getClientConfigCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getClientConfigCount()}
   */
  @Test
  @DisplayName("Test getClientConfigCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getClientConfigCount()"})
  void testGetClientConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getClientConfigCount());
  }

  /**
   * Test {@link PlatformConfig#containsClientConfig(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsClientConfig(String)}
   */
  @Test
  @DisplayName("Test containsClientConfig(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsClientConfig(String)"})
  void testContainsClientConfig_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsClientConfig("Key"));
  }

  /**
   * Test {@link PlatformConfig#getClientConfig()}.
   * <p>
   * Method under test: {@link PlatformConfig#getClientConfig()}
   */
  @Test
  @DisplayName("Test getClientConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getClientConfig()"})
  void testGetClientConfig() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getClientConfig().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getClientConfigMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getClientConfigMap()}
   */
  @Test
  @DisplayName("Test getClientConfigMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getClientConfigMap()"})
  void testGetClientConfigMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getClientConfigMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getClientConfigOrDefault(String, ClientConfig)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getClientConfigOrDefault(String, ClientConfig)}
   */
  @Test
  @DisplayName("Test getClientConfigOrDefault(String, ClientConfig); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientConfig PlatformConfig.getClientConfigOrDefault(String, ClientConfig)"})
  void testGetClientConfigOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    ClientConfig defaultValue = ClientConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getClientConfigOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link PlatformConfig#getClientConfigOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getClientConfigOrThrow(String)}
   */
  @Test
  @DisplayName("Test getClientConfigOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientConfig PlatformConfig.getClientConfigOrThrow(String)"})
  void testGetClientConfigOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PlatformConfig.getDefaultInstance().getClientConfigOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#getExtensionsCount()}.
   * <p>
   * Method under test: {@link PlatformConfig#getExtensionsCount()}
   */
  @Test
  @DisplayName("Test getExtensionsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getExtensionsCount()"})
  void testGetExtensionsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getExtensionsCount());
  }

  /**
   * Test {@link PlatformConfig#containsExtensions(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#containsExtensions(String)}
   */
  @Test
  @DisplayName("Test containsExtensions(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.containsExtensions(String)"})
  void testContainsExtensions_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsExtensions("Key"));
  }

  /**
   * Test {@link PlatformConfig#getExtensions()}.
   * <p>
   * Method under test: {@link PlatformConfig#getExtensions()}
   */
  @Test
  @DisplayName("Test getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getExtensions()"})
  void testGetExtensions() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getExtensions().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getExtensionsMap()}.
   * <p>
   * Method under test: {@link PlatformConfig#getExtensionsMap()}
   */
  @Test
  @DisplayName("Test getExtensionsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PlatformConfig.getExtensionsMap()"})
  void testGetExtensionsMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getExtensionsMap().isEmpty());
  }

  /**
   * Test {@link PlatformConfig#getExtensionsOrDefault(String, Any)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getExtensionsOrDefault(String, Any)}
   */
  @Test
  @DisplayName("Test getExtensionsOrDefault(String, Any); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any PlatformConfig.getExtensionsOrDefault(String, Any)"})
  void testGetExtensionsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    Any defaultValue = Any.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getExtensionsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link PlatformConfig#getExtensionsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#getExtensionsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getExtensionsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any PlatformConfig.getExtensionsOrThrow(String)"})
  void testGetExtensionsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getExtensionsOrThrow("Key"));
  }

  /**
   * Test {@link PlatformConfig#isInitialized()}.
   * <p>
   * Method under test: {@link PlatformConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link PlatformConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link PlatformConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PlatformConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link PlatformConfig#equals(Object)}, and {@link PlatformConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformConfig#equals(Object)}
   *   <li>{@link PlatformConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.equals(Object)", "int PlatformConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    PlatformConfig defaultInstance2 = PlatformConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link PlatformConfig#equals(Object)}, and {@link PlatformConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformConfig#equals(Object)}
   *   <li>{@link PlatformConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.equals(Object)", "int PlatformConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link PlatformConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.equals(Object)", "int PlatformConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link PlatformConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.equals(Object)", "int PlatformConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link PlatformConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformConfig.equals(Object)", "int PlatformConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), "Different type to PlatformConfig");
  }

  /**
   * Test {@link PlatformConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getClientConfigCount());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getExtensionsCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getServicesCount());
    assertEquals(0, actualParseFromResult.getTenantsCount());
    assertFalse(actualParseFromResult.hasDeployment());
    assertFalse(actualParseFromResult.hasExecutor());
    assertFalse(actualParseFromResult.hasGateway());
    assertFalse(actualParseFromResult.hasJobCache());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasPlatformInfo());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getClientConfig().isEmpty());
    assertTrue(actualParseFromResult.getClientConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getExtensions().isEmpty());
    assertTrue(actualParseFromResult.getExtensionsMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.getServices().isEmpty());
    assertTrue(actualParseFromResult.getServicesMap().isEmpty());
    assertTrue(actualParseFromResult.getTenants().isEmpty());
    assertTrue(actualParseFromResult.getTenantsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getClientConfigCount());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getExtensionsCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getServicesCount());
    assertEquals(0, actualParseFromResult.getTenantsCount());
    assertFalse(actualParseFromResult.hasDeployment());
    assertFalse(actualParseFromResult.hasExecutor());
    assertFalse(actualParseFromResult.hasGateway());
    assertFalse(actualParseFromResult.hasJobCache());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasPlatformInfo());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getClientConfig().isEmpty());
    assertTrue(actualParseFromResult.getClientConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getExtensions().isEmpty());
    assertTrue(actualParseFromResult.getExtensionsMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.getServices().isEmpty());
    assertTrue(actualParseFromResult.getServicesMap().isEmpty());
    assertTrue(actualParseFromResult.getTenants().isEmpty());
    assertTrue(actualParseFromResult.getTenantsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getClientConfigCount());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getExtensionsCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getServicesCount());
    assertEquals(0, actualParseFromResult.getTenantsCount());
    assertFalse(actualParseFromResult.hasDeployment());
    assertFalse(actualParseFromResult.hasExecutor());
    assertFalse(actualParseFromResult.hasGateway());
    assertFalse(actualParseFromResult.hasJobCache());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasPlatformInfo());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getClientConfig().isEmpty());
    assertTrue(actualParseFromResult.getClientConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getExtensions().isEmpty());
    assertTrue(actualParseFromResult.getExtensionsMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.getServices().isEmpty());
    assertTrue(actualParseFromResult.getServicesMap().isEmpty());
    assertTrue(actualParseFromResult.getTenants().isEmpty());
    assertTrue(actualParseFromResult.getTenantsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getClientConfigCount());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getExtensionsCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getServicesCount());
    assertEquals(0, actualParseFromResult.getTenantsCount());
    assertFalse(actualParseFromResult.hasDeployment());
    assertFalse(actualParseFromResult.hasExecutor());
    assertFalse(actualParseFromResult.hasGateway());
    assertFalse(actualParseFromResult.hasJobCache());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasPlatformInfo());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getClientConfig().isEmpty());
    assertTrue(actualParseFromResult.getClientConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getExtensions().isEmpty());
    assertTrue(actualParseFromResult.getExtensionsMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.getServices().isEmpty());
    assertTrue(actualParseFromResult.getServicesMap().isEmpty());
    assertTrue(actualParseFromResult.getTenants().isEmpty());
    assertTrue(actualParseFromResult.getTenantsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getClientConfigCount());
    assertEquals(0, actualParseFromResult.getConfigCount());
    assertEquals(0, actualParseFromResult.getExtensionsCount());
    assertEquals(0, actualParseFromResult.getRepositoriesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getServicesCount());
    assertEquals(0, actualParseFromResult.getTenantsCount());
    assertFalse(actualParseFromResult.hasDeployment());
    assertFalse(actualParseFromResult.hasExecutor());
    assertFalse(actualParseFromResult.hasGateway());
    assertFalse(actualParseFromResult.hasJobCache());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasPlatformInfo());
    assertFalse(actualParseFromResult.hasStorage());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getClientConfig().isEmpty());
    assertTrue(actualParseFromResult.getClientConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getConfig().isEmpty());
    assertTrue(actualParseFromResult.getConfigMap().isEmpty());
    assertTrue(actualParseFromResult.getExtensions().isEmpty());
    assertTrue(actualParseFromResult.getExtensionsMap().isEmpty());
    assertTrue(actualParseFromResult.getRepositories().isEmpty());
    assertTrue(actualParseFromResult.getRepositoriesMap().isEmpty());
    assertTrue(actualParseFromResult.getServices().isEmpty());
    assertTrue(actualParseFromResult.getServicesMap().isEmpty());
    assertTrue(actualParseFromResult.getTenants().isEmpty());
    assertTrue(actualParseFromResult.getTenantsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PlatformConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PlatformConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PlatformConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PlatformConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PlatformConfig actualParseFromResult = PlatformConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PlatformConfig actualParseDelimitedFromResult = PlatformConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PlatformConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PlatformConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, PlatformConfig.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PlatformConfig actualParseDelimitedFromResult = PlatformConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PlatformConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> PlatformConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PlatformConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PlatformConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformConfig PlatformConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

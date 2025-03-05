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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
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

class PluginConfigDiffblueTest {
  /**
   * Test {@link PluginConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PluginConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> PluginConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Test {@link PluginConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PluginConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PluginConfig.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PluginConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PluginConfig.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when two; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor PluginConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTwo_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = PluginConfig.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getProtocol()}.
   * <p>
   * Method under test: {@link PluginConfig#getProtocol()}
   */
  @Test
  @DisplayName("Test getProtocol()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getProtocol()"})
  void testGetProtocol() {
    // Arrange, Act and Assert
    assertEquals("", PluginConfig.getDefaultInstance().getProtocol());
  }

  /**
   * Test {@link PluginConfig#getProtocolBytes()}.
   * <p>
   * Method under test: {@link PluginConfig#getProtocolBytes()}
   */
  @Test
  @DisplayName("Test getProtocolBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString PluginConfig.getProtocolBytes()"})
  void testGetProtocolBytes() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act
    ByteString actualProtocolBytes = defaultInstance.getProtocolBytes();

    // Assert
    ByteString byteString = actualProtocolBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualProtocolBytes);
  }

  /**
   * Test {@link PluginConfig#getPublicPropertiesCount()}.
   * <p>
   * Method under test: {@link PluginConfig#getPublicPropertiesCount()}
   */
  @Test
  @DisplayName("Test getPublicPropertiesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PluginConfig.getPublicPropertiesCount()"})
  void testGetPublicPropertiesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getPublicPropertiesCount());
  }

  /**
   * Test {@link PluginConfig#containsPublicProperties(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#containsPublicProperties(String)}
   */
  @Test
  @DisplayName("Test containsPublicProperties(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.containsPublicProperties(String)"})
  void testContainsPublicProperties_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsPublicProperties("Key"));
  }

  /**
   * Test {@link PluginConfig#getPublicProperties()}.
   * <p>
   * Method under test: {@link PluginConfig#getPublicProperties()}
   */
  @Test
  @DisplayName("Test getPublicProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getPublicProperties()"})
  void testGetPublicProperties() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPublicProperties().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getPublicPropertiesMap()}.
   * <p>
   * Method under test: {@link PluginConfig#getPublicPropertiesMap()}
   */
  @Test
  @DisplayName("Test getPublicPropertiesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getPublicPropertiesMap()"})
  void testGetPublicPropertiesMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPublicPropertiesMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getPublicPropertiesOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getPublicPropertiesOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test getPublicPropertiesOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getPublicPropertiesOrDefault(String, String)"})
  void testGetPublicPropertiesOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getPublicPropertiesOrDefault("Key", "42"));
  }

  /**
   * Test {@link PluginConfig#getPublicPropertiesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getPublicPropertiesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPublicPropertiesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getPublicPropertiesOrThrow(String)"})
  void testGetPublicPropertiesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PluginConfig.getDefaultInstance().getPublicPropertiesOrThrow("Key"));
  }

  /**
   * Test {@link PluginConfig#getPropertiesCount()}.
   * <p>
   * Method under test: {@link PluginConfig#getPropertiesCount()}
   */
  @Test
  @DisplayName("Test getPropertiesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PluginConfig.getPropertiesCount()"})
  void testGetPropertiesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getPropertiesCount());
  }

  /**
   * Test {@link PluginConfig#containsProperties(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#containsProperties(String)}
   */
  @Test
  @DisplayName("Test containsProperties(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.containsProperties(String)"})
  void testContainsProperties_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsProperties("Key"));
  }

  /**
   * Test {@link PluginConfig#getProperties()}.
   * <p>
   * Method under test: {@link PluginConfig#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getProperties().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getPropertiesMap()}.
   * <p>
   * Method under test: {@link PluginConfig#getPropertiesMap()}
   */
  @Test
  @DisplayName("Test getPropertiesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getPropertiesMap()"})
  void testGetPropertiesMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPropertiesMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getPropertiesOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getPropertiesOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test getPropertiesOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getPropertiesOrDefault(String, String)"})
  void testGetPropertiesOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getPropertiesOrDefault("Key", "42"));
  }

  /**
   * Test {@link PluginConfig#getPropertiesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getPropertiesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPropertiesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getPropertiesOrThrow(String)"})
  void testGetPropertiesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PluginConfig.getDefaultInstance().getPropertiesOrThrow("Key"));
  }

  /**
   * Test {@link PluginConfig#getSecretsCount()}.
   * <p>
   * Method under test: {@link PluginConfig#getSecretsCount()}
   */
  @Test
  @DisplayName("Test getSecretsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PluginConfig.getSecretsCount()"})
  void testGetSecretsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getSecretsCount());
  }

  /**
   * Test {@link PluginConfig#containsSecrets(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#containsSecrets(String)}
   */
  @Test
  @DisplayName("Test containsSecrets(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.containsSecrets(String)"})
  void testContainsSecrets_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsSecrets("Key"));
  }

  /**
   * Test {@link PluginConfig#getSecrets()}.
   * <p>
   * Method under test: {@link PluginConfig#getSecrets()}
   */
  @Test
  @DisplayName("Test getSecrets()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getSecrets()"})
  void testGetSecrets() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getSecrets().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getSecretsMap()}.
   * <p>
   * Method under test: {@link PluginConfig#getSecretsMap()}
   */
  @Test
  @DisplayName("Test getSecretsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PluginConfig.getSecretsMap()"})
  void testGetSecretsMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getSecretsMap().isEmpty());
  }

  /**
   * Test {@link PluginConfig#getSecretsOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getSecretsOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test getSecretsOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getSecretsOrDefault(String, String)"})
  void testGetSecretsOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getSecretsOrDefault("Key", "42"));
  }

  /**
   * Test {@link PluginConfig#getSecretsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#getSecretsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getSecretsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginConfig.getSecretsOrThrow(String)"})
  void testGetSecretsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PluginConfig.getDefaultInstance().getSecretsOrThrow("Key"));
  }

  /**
   * Test {@link PluginConfig#isInitialized()}.
   * <p>
   * Method under test: {@link PluginConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link PluginConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link PluginConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PluginConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link PluginConfig#equals(Object)}, and {@link PluginConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PluginConfig#equals(Object)}
   *   <li>{@link PluginConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.equals(Object)", "int PluginConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();
    PluginConfig defaultInstance2 = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link PluginConfig#equals(Object)}, and {@link PluginConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PluginConfig#equals(Object)}
   *   <li>{@link PluginConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.equals(Object)", "int PluginConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link PluginConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.equals(Object)", "int PluginConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link PluginConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.equals(Object)", "int PluginConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link PluginConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginConfig.equals(Object)", "int PluginConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), "Different type to PluginConfig");
  }

  /**
   * Test {@link PluginConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getProtocol());
    assertEquals(0, actualParseFromResult.getPropertiesCount());
    assertEquals(0, actualParseFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseFromResult.getSecretsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getProperties().isEmpty());
    assertTrue(actualParseFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getSecrets().isEmpty());
    assertTrue(actualParseFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getProtocol());
    assertEquals(0, actualParseFromResult.getPropertiesCount());
    assertEquals(0, actualParseFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseFromResult.getSecretsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getProperties().isEmpty());
    assertTrue(actualParseFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getSecrets().isEmpty());
    assertTrue(actualParseFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getProtocol());
    assertEquals(0, actualParseFromResult.getPropertiesCount());
    assertEquals(0, actualParseFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseFromResult.getSecretsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getProperties().isEmpty());
    assertTrue(actualParseFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getSecrets().isEmpty());
    assertTrue(actualParseFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getProtocol());
    assertEquals(0, actualParseFromResult.getPropertiesCount());
    assertEquals(0, actualParseFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseFromResult.getSecretsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getProperties().isEmpty());
    assertTrue(actualParseFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getSecrets().isEmpty());
    assertTrue(actualParseFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getProtocol());
    assertEquals(0, actualParseFromResult.getPropertiesCount());
    assertEquals(0, actualParseFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseFromResult.getSecretsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getProperties().isEmpty());
    assertTrue(actualParseFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseFromResult.getSecrets().isEmpty());
    assertTrue(actualParseFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PluginConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PluginConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PluginConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PluginConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(3, descriptorForType.getNestedTypes().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PluginConfig actualParseFromResult = PluginConfig.parseFrom((InputStream) null);

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(3, descriptorForType.getNestedTypes().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PluginConfig actualParseDelimitedFromResult = PluginConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getProtocol());
    assertEquals(0, actualParseDelimitedFromResult.getPropertiesCount());
    assertEquals(0, actualParseDelimitedFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseDelimitedFromResult.getSecretsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getProperties().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSecrets().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PluginConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PluginConfig actualParseDelimitedFromResult = PluginConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getProtocol());
    assertEquals(0, actualParseDelimitedFromResult.getPropertiesCount());
    assertEquals(0, actualParseDelimitedFromResult.getPublicPropertiesCount());
    assertEquals(0, actualParseDelimitedFromResult.getSecretsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getProperties().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPropertiesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPublicProperties().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPublicPropertiesMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSecrets().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSecretsMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PluginConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PluginConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> PluginConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link PluginConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PluginConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginConfig PluginConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

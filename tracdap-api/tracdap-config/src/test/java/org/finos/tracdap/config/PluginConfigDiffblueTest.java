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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
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
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PluginConfigDiffblueTest {
  /**
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> PluginConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
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
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
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
   * Method under test: {@link PluginConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
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
   * Method under test: {@link PluginConfig#getProtocol()}
   */
  @Test
  void testGetProtocol() {
    // Arrange, Act and Assert
    assertEquals("", PluginConfig.getDefaultInstance().getProtocol());
  }

  /**
   * Method under test: {@link PluginConfig#getProtocolBytes()}
   */
  @Test
  void testGetProtocolBytes() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act
    ByteString actualProtocolBytes = defaultInstance.getProtocolBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualProtocolBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualProtocolBytes);
  }

  /**
   * Method under test: {@link PluginConfig#getPublicPropertiesCount()}
   */
  @Test
  void testGetPublicPropertiesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getPublicPropertiesCount());
  }

  /**
   * Method under test: {@link PluginConfig#containsPublicProperties(String)}
   */
  @Test
  void testContainsPublicProperties() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsPublicProperties("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#getPublicProperties()}
   */
  @Test
  void testGetPublicProperties() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPublicProperties().isEmpty());
  }

  /**
   * Method under test: {@link PluginConfig#getPublicPropertiesMap()}
   */
  @Test
  void testGetPublicPropertiesMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPublicPropertiesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PluginConfig#getPublicPropertiesOrDefault(String, String)}
   */
  @Test
  void testGetPublicPropertiesOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getPublicPropertiesOrDefault("Key", "42"));
  }

  /**
   * Method under test: {@link PluginConfig#getPublicPropertiesOrThrow(String)}
   */
  @Test
  void testGetPublicPropertiesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PluginConfig.getDefaultInstance().getPublicPropertiesOrThrow("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#getPropertiesCount()}
   */
  @Test
  void testGetPropertiesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getPropertiesCount());
  }

  /**
   * Method under test: {@link PluginConfig#containsProperties(String)}
   */
  @Test
  void testContainsProperties() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsProperties("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getProperties().isEmpty());
  }

  /**
   * Method under test: {@link PluginConfig#getPropertiesMap()}
   */
  @Test
  void testGetPropertiesMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getPropertiesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PluginConfig#getPropertiesOrDefault(String, String)}
   */
  @Test
  void testGetPropertiesOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getPropertiesOrDefault("Key", "42"));
  }

  /**
   * Method under test: {@link PluginConfig#getPropertiesOrThrow(String)}
   */
  @Test
  void testGetPropertiesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PluginConfig.getDefaultInstance().getPropertiesOrThrow("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#getSecretsCount()}
   */
  @Test
  void testGetSecretsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getSecretsCount());
  }

  /**
   * Method under test: {@link PluginConfig#containsSecrets(String)}
   */
  @Test
  void testContainsSecrets() {
    // Arrange, Act and Assert
    assertFalse(PluginConfig.getDefaultInstance().containsSecrets("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#getSecrets()}
   */
  @Test
  void testGetSecrets() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getSecrets().isEmpty());
  }

  /**
   * Method under test: {@link PluginConfig#getSecretsMap()}
   */
  @Test
  void testGetSecretsMap() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().getSecretsMap().isEmpty());
  }

  /**
   * Method under test: {@link PluginConfig#getSecretsOrDefault(String, String)}
   */
  @Test
  void testGetSecretsOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", PluginConfig.getDefaultInstance().getSecretsOrDefault("Key", "42"));
  }

  /**
   * Method under test: {@link PluginConfig#getSecretsOrThrow(String)}
   */
  @Test
  void testGetSecretsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PluginConfig.getDefaultInstance().getSecretsOrThrow("Key"));
  }

  /**
   * Method under test: {@link PluginConfig#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PluginConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link PluginConfig#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PluginConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginConfig#equals(Object)}
   *   <li>{@link PluginConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link PluginConfig#equals(Object)}
   *   <li>{@link PluginConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PluginConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link PluginConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PluginConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PluginConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PluginConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PluginConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link PluginConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
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
   * Method under test:
   * {@link PluginConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> PluginConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link PluginConfig#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    PluginConfig defaultInstance = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link PluginConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PluginConfig.getDefaultInstance(), "Different type to PluginConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginConfig#getDefaultInstance()}
   *   <li>{@link PluginConfig#getDescriptor()}
   *   <li>{@link PluginConfig#newBuilder()}
   *   <li>{@link PluginConfig#newBuilder(PluginConfig)}
   *   <li>{@link PluginConfig#newBuilderForType()}
   *   <li>{@link PluginConfig#toBuilder()}
   *   <li>{@link PluginConfig#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PluginConfig actualDefaultInstance = PluginConfig.getDefaultInstance();
    PluginConfig actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    PluginConfig prototype = PluginConfig.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

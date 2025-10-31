package org.finos.tracdap.metadata;

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

class ModelDefinitionDiffblueTest {
  /**
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(7);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(8);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.OUTPUTS_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ModelDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#getLanguage()}
   */
  @Test
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getLanguage());
  }

  /**
   * Method under test: {@link ModelDefinition#getLanguageBytes()}
   */
  @Test
  void testGetLanguageBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualLanguageBytes = defaultInstance.getLanguageBytes();

    // Assert
    ByteString byteString = actualLanguageBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualLanguageBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#getRepository()}
   */
  @Test
  void testGetRepository() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getRepository());
  }

  /**
   * Method under test: {@link ModelDefinition#getRepositoryBytes()}
   */
  @Test
  void testGetRepositoryBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualRepositoryBytes = defaultInstance.getRepositoryBytes();

    // Assert
    ByteString byteString = actualRepositoryBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualRepositoryBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#hasPackageGroup()}
   */
  @Test
  void testHasPackageGroup() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().hasPackageGroup());
  }

  /**
   * Method under test: {@link ModelDefinition#getPackageGroup()}
   */
  @Test
  void testGetPackageGroup() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPackageGroup());
  }

  /**
   * Method under test: {@link ModelDefinition#getPackageGroupBytes()}
   */
  @Test
  void testGetPackageGroupBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPackageGroupBytes = defaultInstance.getPackageGroupBytes();

    // Assert
    ByteString byteString = actualPackageGroupBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualPackageGroupBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#getPackage()}
   */
  @Test
  void testGetPackage() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPackage());
  }

  /**
   * Method under test: {@link ModelDefinition#getPackageBytes()}
   */
  @Test
  void testGetPackageBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPackageBytes = defaultInstance.getPackageBytes();

    // Assert
    ByteString byteString = actualPackageBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualPackageBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getVersion());
  }

  /**
   * Method under test: {@link ModelDefinition#getVersionBytes()}
   */
  @Test
  void testGetVersionBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualVersionBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#getEntryPoint()}
   */
  @Test
  void testGetEntryPoint() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getEntryPoint());
  }

  /**
   * Method under test: {@link ModelDefinition#getEntryPointBytes()}
   */
  @Test
  void testGetEntryPointBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualEntryPointBytes = defaultInstance.getEntryPointBytes();

    // Assert
    ByteString byteString = actualEntryPointBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualEntryPointBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#hasPath()}
   */
  @Test
  void testHasPath() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().hasPath());
  }

  /**
   * Method under test: {@link ModelDefinition#getPath()}
   */
  @Test
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("", ModelDefinition.getDefaultInstance().getPath());
  }

  /**
   * Method under test: {@link ModelDefinition#getPathBytes()}
   */
  @Test
  void testGetPathBytes() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act
    ByteString actualPathBytes = defaultInstance.getPathBytes();

    // Assert
    ByteString byteString = actualPathBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ModelDefinition.STATICATTRIBUTES_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(ModelDefinition.PACKAGEGROUP_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(ModelDefinition.PACKAGE_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
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
    assertEquals(byteString, actualPathBytes);
  }

  /**
   * Method under test: {@link ModelDefinition#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link ModelDefinition#containsParameters(String)}
   */
  @Test
  void testContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#getParametersMap()}
   */
  @Test
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelDefinition#getParametersOrDefault(String, ModelParameter)}
   */
  @Test
  void testGetParametersOrDefault() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelParameter defaultValue = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelDefinition#getParametersOrThrow(String)}
   */
  @Test
  void testGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelDefinition.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link ModelDefinition#containsInputs(String)}
   */
  @Test
  void testContainsInputs() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getInputs()}
   */
  @Test
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#getInputsMap()}
   */
  @Test
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelDefinition#getInputsOrDefault(String, ModelInputSchema)}
   */
  @Test
  void testGetInputsOrDefault() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelInputSchema defaultValue = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelDefinition#getInputsOrThrow(String)}
   */
  @Test
  void testGetInputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelDefinition.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link ModelDefinition#containsOutputs(String)}
   */
  @Test
  void testContainsOutputs() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getOutputs()}
   */
  @Test
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#getOutputsMap()}
   */
  @Test
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelDefinition#getOutputsOrDefault(String, ModelOutputSchema)}
   */
  @Test
  void testGetOutputsOrDefault() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelOutputSchema defaultValue = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelDefinition#getOutputsOrThrow(String)}
   */
  @Test
  void testGetOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelDefinition.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getStaticAttributesCount()}
   */
  @Test
  void testGetStaticAttributesCount() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getStaticAttributesCount());
  }

  /**
   * Method under test: {@link ModelDefinition#containsStaticAttributes(String)}
   */
  @Test
  void testContainsStaticAttributes() {
    // Arrange, Act and Assert
    assertFalse(ModelDefinition.getDefaultInstance().containsStaticAttributes("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getStaticAttributes()}
   */
  @Test
  void testGetStaticAttributes() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getStaticAttributes().isEmpty());
  }

  /**
   * Method under test: {@link ModelDefinition#getStaticAttributesMap()}
   */
  @Test
  void testGetStaticAttributesMap() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().getStaticAttributesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ModelDefinition#getStaticAttributesOrDefault(String, Value)}
   */
  @Test
  void testGetStaticAttributesOrDefault() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getStaticAttributesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ModelDefinition#getStaticAttributesOrThrow(String)}
   */
  @Test
  void testGetStaticAttributesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ModelDefinition.getDefaultInstance().getStaticAttributesOrThrow("Key"));
  }

  /**
   * Method under test: {@link ModelDefinition#getModelType()}
   */
  @Test
  void testGetModelType() {
    // Arrange, Act and Assert
    assertEquals(ModelType.STANDARD_MODEL, ModelDefinition.getDefaultInstance().getModelType());
  }

  /**
   * Method under test: {@link ModelDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ModelDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link ModelDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ModelDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelDefinition#equals(Object)}
   *   <li>{@link ModelDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();
    ModelDefinition defaultInstance2 = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelDefinition#equals(Object)}
   *   <li>{@link ModelDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ModelDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ModelDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ModelDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ModelDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ModelDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ModelDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ModelDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    ModelDefinition defaultInstance = ModelDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ModelDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModelDefinition.getDefaultInstance(), "Different type to ModelDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModelDefinition#getDefaultInstance()}
   *   <li>{@link ModelDefinition#getDescriptor()}
   *   <li>{@link ModelDefinition#newBuilder()}
   *   <li>{@link ModelDefinition#newBuilder(ModelDefinition)}
   *   <li>{@link ModelDefinition#newBuilderForType()}
   *   <li>{@link ModelDefinition#toBuilder()}
   *   <li>{@link ModelDefinition#getModelTypeValue()}
   *   <li>{@link ModelDefinition#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ModelDefinition actualDefaultInstance = ModelDefinition.getDefaultInstance();
    ModelDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    ModelDefinition prototype = ModelDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    int actualModelTypeValue = actualDefaultInstance.getModelTypeValue();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualModelTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

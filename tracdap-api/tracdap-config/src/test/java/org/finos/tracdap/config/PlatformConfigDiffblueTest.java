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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlatformConfigDiffblueTest {
  /**
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
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
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
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
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PlatformConfig.getDefaultInstance().internalGetMapFieldReflection(2));
  }

  /**
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
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
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
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
   * Method under test: {@link PlatformConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection6() {
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
   * Method under test: {@link PlatformConfig#getConfigCount()}
   */
  @Test
  void testGetConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getConfigCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsConfig(String)}
   */
  @Test
  void testContainsConfig() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsConfig("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getConfig()}
   */
  @Test
  void testGetConfig() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getConfig().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getConfigMap()}
   */
  @Test
  void testGetConfigMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getConfigMap().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getConfigOrDefault(String, String)}
   */
  @Test
  void testGetConfigOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", PlatformConfig.getDefaultInstance().getConfigOrDefault("Key", "42"));
  }

  /**
   * Method under test: {@link PlatformConfig#getConfigOrThrow(String)}
   */
  @Test
  void testGetConfigOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getConfigOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#hasPlatformInfo()}
   */
  @Test
  void testHasPlatformInfo() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasPlatformInfo());
  }

  /**
   * Method under test: {@link PlatformConfig#hasMetadata()}
   */
  @Test
  void testHasMetadata() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasMetadata());
  }

  /**
   * Method under test: {@link PlatformConfig#hasStorage()}
   */
  @Test
  void testHasStorage() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasStorage());
  }

  /**
   * Method under test: {@link PlatformConfig#getRepositoriesCount()}
   */
  @Test
  void testGetRepositoriesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getRepositoriesCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsRepositories(String)}
   */
  @Test
  void testContainsRepositories() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsRepositories("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getRepositories()}
   */
  @Test
  void testGetRepositories() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getRepositories().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getRepositoriesMap()}
   */
  @Test
  void testGetRepositoriesMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getRepositoriesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PlatformConfig#getRepositoriesOrDefault(String, PluginConfig)}
   */
  @Test
  void testGetRepositoriesOrDefault() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    PluginConfig defaultValue = PluginConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getRepositoriesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link PlatformConfig#getRepositoriesOrThrow(String)}
   */
  @Test
  void testGetRepositoriesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PlatformConfig.getDefaultInstance().getRepositoriesOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#hasExecutor()}
   */
  @Test
  void testHasExecutor() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasExecutor());
  }

  /**
   * Method under test: {@link PlatformConfig#hasJobCache()}
   */
  @Test
  void testHasJobCache() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasJobCache());
  }

  /**
   * Method under test: {@link PlatformConfig#getTenantsCount()}
   */
  @Test
  void testGetTenantsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getTenantsCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsTenants(String)}
   */
  @Test
  void testContainsTenants() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsTenants("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getTenants()}
   */
  @Test
  void testGetTenants() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getTenants().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getTenantsMap()}
   */
  @Test
  void testGetTenantsMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getTenantsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PlatformConfig#getTenantsOrDefault(String, TenantConfig)}
   */
  @Test
  void testGetTenantsOrDefault() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    TenantConfig defaultValue = TenantConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getTenantsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link PlatformConfig#getTenantsOrThrow(String)}
   */
  @Test
  void testGetTenantsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getTenantsOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#hasGateway()}
   */
  @Test
  void testHasGateway() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasGateway());
  }

  /**
   * Method under test: {@link PlatformConfig#getServicesCount()}
   */
  @Test
  void testGetServicesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getServicesCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsServices(String)}
   */
  @Test
  void testContainsServices() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsServices("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getServices()}
   */
  @Test
  void testGetServices() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getServices().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getServicesMap()}
   */
  @Test
  void testGetServicesMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getServicesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PlatformConfig#getServicesOrDefault(String, ServiceConfig)}
   */
  @Test
  void testGetServicesOrDefault() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    ServiceConfig defaultValue = ServiceConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getServicesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link PlatformConfig#getServicesOrThrow(String)}
   */
  @Test
  void testGetServicesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getServicesOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#hasDeployment()}
   */
  @Test
  void testHasDeployment() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().hasDeployment());
  }

  /**
   * Method under test: {@link PlatformConfig#getDeployment()}
   */
  @Test
  void testGetDeployment() {
    // Arrange and Act
    DeploymentConfig actualDeployment = PlatformConfig.getDefaultInstance().getDeployment();

    // Assert
    Descriptors.Descriptor descriptorForType = actualDeployment.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    Object defaultValue = getResult.getDefaultValue();
    assertTrue(defaultValue instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    DescriptorProtos.FieldOptions.FeatureSupport featureSupport = options.getFeatureSupport();
    assertEquals("", featureSupport.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options3 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options3.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options3.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    DescriptorProtos.EnumOptions options4 = enumType.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.EnumDescriptorProto toProtoResult6 = enumType.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualDeployment.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options2.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", featureSupport.getDeprecationWarning());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options2.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", options2.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options2.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options2.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options2.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options2.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options2.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options2.getSwiftPrefix());
    assertEquals(".tracdap.config.DeploymentLayout", toProtoResult2.getTypeName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(PlatformConfig.EXECUTOR_FIELD_NUMBER);
    assertEquals("ClientConfig", getResult2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("DeploymentConfig", nameBytes.toStringUtf8());
    assertEquals("DeploymentConfig", toProtoResult.getName());
    assertEquals("DeploymentConfig", descriptorForType.getName());
    assertEquals("DeploymentLayout", toProtoResult6.getName());
    assertEquals("DeploymentLayout", enumType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options2.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("LAYOUT_NOT_SET", ((Descriptors.EnumValueDescriptor) defaultValue).getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals("MetadataConfig", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertEquals("PlatformConfig", getResult4.getName());
    ByteString javaOuterClassnameBytes = options2.getJavaOuterClassnameBytes();
    assertEquals("PlatformConfigProto", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("PlatformConfigProto", options2.getJavaOuterClassname());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(2, enumTypes.size());
    Descriptors.EnumDescriptor getResult5 = enumTypes.get(0);
    assertEquals("RoutingProtocol", getResult5.getName());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("google.protobuf", file2.getPackage());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    Descriptors.FileDescriptor getResult6 = dependencies.get(2);
    assertEquals("google.protobuf", getResult6.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/any.proto", getResult6.getFullName());
    assertEquals("google/protobuf/any.proto", getResult6.getName());
    ProtocolStringList dependencyList = toProtoResult3.getDependencyList();
    assertEquals(3, dependencyList.size());
    assertEquals("google/protobuf/any.proto", dependencyList.get(2));
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("layout", nameBytes2.toStringUtf8());
    assertEquals("layout", toProtoResult2.getName());
    assertEquals("layout", getResult.getJsonName());
    assertEquals("layout", getResult.getName());
    ByteString javaPackageBytes = options2.getJavaPackageBytes();
    assertEquals("org.finos.tracdap.config", javaPackageBytes.toStringUtf8());
    assertEquals("org.finos.tracdap.config", options2.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("tracdap.config", packageBytes.toStringUtf8());
    assertEquals("tracdap.config", toProtoResult3.getPackage());
    assertEquals("tracdap.config", file.getPackage());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals("tracdap.config", getResult7.getPackage());
    assertEquals("tracdap.config.ClientConfig", getResult2.getFullName());
    assertEquals("tracdap.config.DeploymentConfig", descriptorForType.getFullName());
    assertEquals("tracdap.config.DeploymentConfig.layout", getResult.getFullName());
    assertEquals("tracdap.config.DeploymentLayout", enumType.getFullName());
    assertEquals("tracdap.config.DeploymentLayout.LAYOUT_NOT_SET",
        ((Descriptors.EnumValueDescriptor) defaultValue).getFullName());
    assertEquals("tracdap.config.MetadataConfig", getResult3.getFullName());
    assertEquals("tracdap.config.PlatformConfig", getResult4.getFullName());
    assertEquals("tracdap.config.RoutingProtocol", getResult5.getFullName());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals("tracdap.metadata", getResult8.getPackage());
    assertEquals("tracdap/config/common.proto", getResult7.getFullName());
    assertEquals("tracdap/config/common.proto", getResult7.getName());
    assertEquals("tracdap/config/common.proto", dependencyList.get(1));
    ByteString nameBytes3 = toProtoResult3.getNameBytes();
    assertEquals("tracdap/config/platform.proto", nameBytes3.toStringUtf8());
    assertEquals("tracdap/config/platform.proto", toProtoResult3.getName());
    assertEquals("tracdap/config/platform.proto", file.getFullName());
    assertEquals("tracdap/config/platform.proto", file.getName());
    assertEquals("tracdap/metadata/common.proto", getResult8.getFullName());
    assertEquals("tracdap/metadata/common.proto", getResult8.getName());
    assertEquals("tracdap/metadata/common.proto", dependencyList.get(0));
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, options4.getSerializedSize());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options.getEditionDefaultsCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getTargetsCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, featureSupport.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult4.getIndex());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, ((Descriptors.EnumValueDescriptor) defaultValue).getIndex());
    assertEquals(0, ((Descriptors.EnumValueDescriptor) defaultValue).getNumber());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualDeployment.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualDeployment.getLayoutValue());
    assertEquals(0, actualDeployment.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, enumType.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult3.getEnumTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult3.getEnumTypeList();
    assertEquals(2, enumTypeList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2581, toProtoResult3.getSerializedSize());
    assertEquals(3, toProtoResult3.getDependencyCount());
    assertEquals(3, options2.getAllFields().size());
    assertEquals(3, options2.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult6.getValueCount());
    assertEquals(4, descriptorForType5.getIndex());
    List<Descriptors.EnumValueDescriptor> values = enumType.getValues();
    assertEquals(4, values.size());
    assertEquals(48, toProtoResult2.getSerializedSize());
    assertEquals(49, options2.getSerializedSize());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(68, toProtoResult.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, toProtoResult3.getAllFields().size());
    assertEquals(75, toProtoResult6.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, featureSupport.getEditionDeprecated());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, featureSupport.getEditionIntroduced());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, featureSupport.getEditionRemoved());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options2.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, actualDeployment.getLayout());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(options4.getAllowAlias());
    assertFalse(options4.getDeprecated());
    assertFalse(options4.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options4.hasAllowAlias());
    assertFalse(options4.hasDeprecated());
    assertFalse(options4.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options4.hasFeatures());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(options.getDebugRedact());
    assertFalse(options.getDeprecated());
    assertFalse(options.getLazy());
    assertFalse(options.getPacked());
    assertFalse(options.getUnverifiedLazy());
    assertFalse(options.getWeak());
    assertFalse(options.hasCtype());
    assertFalse(options.hasDebugRedact());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasFeatureSupport());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasJstype());
    assertFalse(options.hasLazy());
    assertFalse(options.hasPacked());
    assertFalse(options.hasRetention());
    assertFalse(options.hasUnverifiedLazy());
    assertFalse(options.hasWeak());
    assertFalse(featureSupport.hasDeprecationWarning());
    assertFalse(featureSupport.hasEditionDeprecated());
    assertFalse(featureSupport.hasEditionIntroduced());
    assertFalse(featureSupport.hasEditionRemoved());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options2.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options2.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options2.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options2.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options2.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options2.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options2.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options2.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options2.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options2.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options2.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(options2.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options2.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options2.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options2.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options2.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options2.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options2.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options2.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options2.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options2.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options2.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options2.hasSwiftPrefix());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.getMapEntry());
    assertFalse(options3.getMessageSetWireFormat());
    assertFalse(options3.getNoStandardDescriptorAccessor());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasMapEntry());
    assertFalse(options3.hasMessageSetWireFormat());
    assertFalse(options3.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult2.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult5.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult2.hasTypeName());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(featureSupport.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options2.getCcEnableArenas());
    assertTrue(options2.getJavaMultipleFiles());
    assertTrue(options2.hasJavaMultipleFiles());
    assertTrue(options2.hasJavaOuterClassname());
    assertTrue(options2.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes3.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualDeployment.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options3.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualDeployment.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(actualDeployment.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, featureSupport.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult3.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult2.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult3.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult3.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult2.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult2.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult8.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult8.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult8.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult8.getServices());
    assertEquals(findInitializationErrorsResult, getResult7.getServices());
    assertEquals(findInitializationErrorsResult, getResult6.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, featureSupport.getDeprecationWarningBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, featureSupport.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, options4.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFieldsRaw());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(allFields, options4.getAllFieldsRaw());
    assertEquals(PlatformConfig.EXECUTOR_FIELD_NUMBER, getResult2.getIndex());
    assertEquals(PlatformConfig.JOBCACHE_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, toProtoResult3.getMessageTypeCount());
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, descriptorForType8.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, messageTypeList.size());
    assertEquals(PlatformConfig.TENANTS_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals('D', iteratorResult.next().byteValue());
    assertEquals('P', iteratorResult6.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('t', iteratorResult3.next().byteValue());
    assertEquals('t', iteratorResult4.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(featureSupport, options.getFeatureSupportOrBuilder());
    assertSame(featureSupport, featureSupport.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, enumType.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, ((Descriptors.EnumValueDescriptor) defaultValue).getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult4.getOptions());
    assertSame(options5, toProtoResult5.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult4.getOptionsOrBuilder());
    assertSame(options5, toProtoResult5.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, descriptorForType8.getOptions());
    assertSame(options5, descriptorForType7.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult2.getOptions());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(toProtoResult6, enumTypeList.get(1));
    assertSame(enumType, ((Descriptors.EnumValueDescriptor) defaultValue).getType());
    assertSame(enumType, enumTypes.get(1));
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(8));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, featureSupport.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDeployment, actualDeployment.getDefaultInstanceForType());
    assertSame(defaultValue, values.get(0));
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
  }

  /**
   * Method under test: {@link PlatformConfig#getClientConfigCount()}
   */
  @Test
  void testGetClientConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getClientConfigCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsClientConfig(String)}
   */
  @Test
  void testContainsClientConfig() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsClientConfig("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getClientConfig()}
   */
  @Test
  void testGetClientConfig() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getClientConfig().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getClientConfigMap()}
   */
  @Test
  void testGetClientConfigMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getClientConfigMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link PlatformConfig#getClientConfigOrDefault(String, ClientConfig)}
   */
  @Test
  void testGetClientConfigOrDefault() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    ClientConfig defaultValue = ClientConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getClientConfigOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link PlatformConfig#getClientConfigOrThrow(String)}
   */
  @Test
  void testGetClientConfigOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PlatformConfig.getDefaultInstance().getClientConfigOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getExtensionsCount()}
   */
  @Test
  void testGetExtensionsCount() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getExtensionsCount());
  }

  /**
   * Method under test: {@link PlatformConfig#containsExtensions(String)}
   */
  @Test
  void testContainsExtensions() {
    // Arrange, Act and Assert
    assertFalse(PlatformConfig.getDefaultInstance().containsExtensions("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#getExtensions()}
   */
  @Test
  void testGetExtensions() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getExtensions().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getExtensionsMap()}
   */
  @Test
  void testGetExtensionsMap() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().getExtensionsMap().isEmpty());
  }

  /**
   * Method under test: {@link PlatformConfig#getExtensionsOrDefault(String, Any)}
   */
  @Test
  void testGetExtensionsOrDefault() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();
    Any defaultValue = Any.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getExtensionsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link PlatformConfig#getExtensionsOrThrow(String)}
   */
  @Test
  void testGetExtensionsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PlatformConfig.getDefaultInstance().getExtensionsOrThrow("Key"));
  }

  /**
   * Method under test: {@link PlatformConfig#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PlatformConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link PlatformConfig#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PlatformConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformConfig#equals(Object)}
   *   <li>{@link PlatformConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformConfig#equals(Object)}
   *   <li>{@link PlatformConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PlatformConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link PlatformConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PlatformConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PlatformConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link PlatformConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PlatformConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link PlatformConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
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
   * Method under test:
   * {@link PlatformConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> PlatformConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link PlatformConfig#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    PlatformConfig defaultInstance = PlatformConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link PlatformConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PlatformConfig.getDefaultInstance(), "Different type to PlatformConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformConfig#getDefaultInstance()}
   *   <li>{@link PlatformConfig#getDescriptor()}
   *   <li>{@link PlatformConfig#newBuilder()}
   *   <li>{@link PlatformConfig#newBuilder(PlatformConfig)}
   *   <li>{@link PlatformConfig#newBuilderForType()}
   *   <li>{@link PlatformConfig#toBuilder()}
   *   <li>{@link PlatformConfig#getDeploymentOrBuilder()}
   *   <li>{@link PlatformConfig#getExecutorOrBuilder()}
   *   <li>{@link PlatformConfig#getGatewayOrBuilder()}
   *   <li>{@link PlatformConfig#getJobCacheOrBuilder()}
   *   <li>{@link PlatformConfig#getMetadataOrBuilder()}
   *   <li>{@link PlatformConfig#getParserForType()}
   *   <li>{@link PlatformConfig#getPlatformInfoOrBuilder()}
   *   <li>{@link PlatformConfig#getStorageOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PlatformConfig actualDefaultInstance = PlatformConfig.getDefaultInstance();
    PlatformConfig actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    PlatformConfig prototype = PlatformConfig.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    DeploymentConfigOrBuilder actualDeploymentOrBuilder = actualDefaultInstance.getDeploymentOrBuilder();
    PluginConfigOrBuilder actualExecutorOrBuilder = actualDefaultInstance.getExecutorOrBuilder();
    GatewayConfigOrBuilder actualGatewayOrBuilder = actualDefaultInstance.getGatewayOrBuilder();
    PluginConfigOrBuilder actualJobCacheOrBuilder = actualDefaultInstance.getJobCacheOrBuilder();
    MetadataConfigOrBuilder actualMetadataOrBuilder = actualDefaultInstance.getMetadataOrBuilder();
    actualDefaultInstance.getParserForType();
    PlatformInfoOrBuilder actualPlatformInfoOrBuilder = actualDefaultInstance.getPlatformInfoOrBuilder();
    StorageConfigOrBuilder actualStorageOrBuilder = actualDefaultInstance.getStorageOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getDeployment(), actualDeploymentOrBuilder);
    PluginConfig executor = actualDefaultInstance.getExecutor();
    assertSame(executor, actualExecutorOrBuilder);
    assertSame(executor, actualJobCacheOrBuilder);
    assertSame(actualDefaultInstance.getGateway(), actualGatewayOrBuilder);
    assertSame(actualDefaultInstance.getMetadata(), actualMetadataOrBuilder);
    assertSame(actualDefaultInstance.getPlatformInfo(), actualPlatformInfoOrBuilder);
    assertSame(actualDefaultInstance.getStorage(), actualStorageOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

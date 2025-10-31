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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ImportDataJobDiffblueTest {
  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ImportDataJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection6() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ImportDataJob.getDefaultInstance()
        .internalGetMapFieldReflection(7);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#hasModel()}
   */
  @Test
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().hasModel());
  }

  /**
   * Method under test: {@link ImportDataJob#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link ImportDataJob#containsParameters(String)}
   */
  @Test
  void testContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#getParametersMap()}
   */
  @Test
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportDataJob#getParametersOrDefault(String, Value)}
   */
  @Test
  void testGetParametersOrDefault() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ImportDataJob#getParametersOrThrow(String)}
   */
  @Test
  void testGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#containsInputs(String)}
   */
  @Test
  void testContainsInputs() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getInputs()}
   */
  @Test
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#getInputsMap()}
   */
  @Test
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportDataJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetInputsOrDefault() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ImportDataJob#getInputsOrThrow(String)}
   */
  @Test
  void testGetInputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#containsOutputs(String)}
   */
  @Test
  void testContainsOutputs() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getOutputs()}
   */
  @Test
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#getOutputsMap()}
   */
  @Test
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportDataJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetOutputsOrDefault() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ImportDataJob#getOutputsOrThrow(String)}
   */
  @Test
  void testGetOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getPriorOutputsCount()}
   */
  @Test
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#containsPriorOutputs(String)}
   */
  @Test
  void testContainsPriorOutputs() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getPriorOutputs()}
   */
  @Test
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#getPriorOutputsMap()}
   */
  @Test
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportDataJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetPriorOutputsOrDefault() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ImportDataJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  void testGetPriorOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ImportDataJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getStorageAccessList()}
   */
  @Test
  void testGetStorageAccessList() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act
    ProtocolStringList actualStorageAccessList = defaultInstance.getStorageAccessList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(5, nestedTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    TagSelector model = defaultInstance.getModel();
    assertTrue(model.findInitializationErrors().isEmpty());
    DatetimeValue objectAsOf = model.getObjectAsOf();
    assertTrue(objectAsOf.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    Descriptors.Descriptor descriptorForType2 = model.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstance.getImportAttrsList().isEmpty());
    assertTrue(actualStorageAccessList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualStorageAccessList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ImportDataJob.IMPORTATTRS_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(7);
    assertEquals(lazyStringList, getResult2.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(8).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    assertEquals(lazyStringList, toProtoResult3.getPublicDependencyList());
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertEquals(lazyStringList, messageType.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = objectAsOf.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult3 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = nestedTypes.get(1);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = nestedTypes.get(3);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = nestedTypes.get(4);
    assertEquals(lazyStringList, getResult6.getEnumTypes());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(JobStatusCode.CANCELLED_VALUE, messageTypes.size());
    Descriptors.Descriptor getResult7 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult7.getEnumTypes());
    Descriptors.Descriptor getResult8 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult8.getEnumTypes());
    Descriptors.Descriptor getResult9 = messageTypes.get(8);
    assertEquals(lazyStringList, getResult9.getEnumTypes());
    Descriptors.Descriptor getResult10 = messageTypes.get(ImportDataJob.IMPORTATTRS_FIELD_NUMBER);
    assertEquals(lazyStringList, getResult10.getEnumTypes());
    assertEquals(lazyStringList, messageType.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    assertEquals(lazyStringList, getResult7.getExtensions());
    assertEquals(lazyStringList, getResult8.getExtensions());
    assertEquals(lazyStringList, getResult9.getExtensions());
    assertEquals(lazyStringList, getResult10.getExtensions());
    assertEquals(lazyStringList, messageType.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, getResult5.getNestedTypes());
    assertEquals(lazyStringList, getResult6.getNestedTypes());
    assertEquals(lazyStringList, getResult7.getNestedTypes());
    assertEquals(lazyStringList, getResult8.getNestedTypes());
    assertEquals(lazyStringList, getResult9.getNestedTypes());
    assertEquals(lazyStringList, getResult10.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, getResult5.getOneofs());
    assertEquals(lazyStringList, getResult6.getOneofs());
    assertEquals(lazyStringList, getResult8.getOneofs());
    assertEquals(lazyStringList, getResult9.getOneofs());
    assertEquals(lazyStringList, getResult10.getOneofs());
    assertEquals(lazyStringList, messageType.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    assertEquals(lazyStringList, getResult6.getRealOneofs());
    assertEquals(lazyStringList, getResult8.getRealOneofs());
    assertEquals(lazyStringList, getResult9.getRealOneofs());
    assertEquals(lazyStringList, getResult10.getRealOneofs());
    Descriptors.FileDescriptor getResult11 = dependencies.get(0);
    assertEquals(lazyStringList, getResult11.getDependencies());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult11.getExtensions());
    Descriptors.FileDescriptor getResult12 = dependencies.get(2);
    assertEquals(lazyStringList, getResult12.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult11.getPublicDependencies());
    assertEquals(lazyStringList, getResult12.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult11.getServices());
    assertEquals(lazyStringList, getResult12.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, actualStorageAccessList);
  }

  /**
   * Method under test: {@link ImportDataJob#getStorageAccessCount()}
   */
  @Test
  void testGetStorageAccessCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getStorageAccessCount());
  }

  /**
   * Method under test: {@link ImportDataJob#getImportsCount()}
   */
  @Test
  void testGetImportsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getImportsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#containsImports(String)}
   */
  @Test
  void testContainsImports() {
    // Arrange, Act and Assert
    assertFalse(ImportDataJob.getDefaultInstance().containsImports("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getImports()}
   */
  @Test
  void testGetImports() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getImports().isEmpty());
  }

  /**
   * Method under test: {@link ImportDataJob#getImportsMap()}
   */
  @Test
  void testGetImportsMap() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().getImportsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImportDataJob#getImportsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetImportsOrDefault() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getImportsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link ImportDataJob#getImportsOrThrow(String)}
   */
  @Test
  void testGetImportsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportDataJob.getDefaultInstance().getImportsOrThrow("Key"));
  }

  /**
   * Method under test: {@link ImportDataJob#getOutputAttrsCount()}
   */
  @Test
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#getImportAttrsCount()}
   */
  @Test
  void testGetImportAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getImportAttrsCount());
  }

  /**
   * Method under test: {@link ImportDataJob#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ImportDataJob.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link ImportDataJob#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ImportDataJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImportDataJob#equals(Object)}
   *   <li>{@link ImportDataJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();
    ImportDataJob defaultInstance2 = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImportDataJob#equals(Object)}
   *   <li>{@link ImportDataJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ImportDataJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportDataJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ImportDataJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportDataJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ImportDataJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportDataJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ImportDataJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ImportDataJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ImportDataJob#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    ImportDataJob defaultInstance = ImportDataJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ImportDataJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportDataJob.getDefaultInstance(), "Different type to ImportDataJob");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImportDataJob#getDefaultInstance()}
   *   <li>{@link ImportDataJob#getDescriptor()}
   *   <li>{@link ImportDataJob#newBuilder()}
   *   <li>{@link ImportDataJob#newBuilder(ImportDataJob)}
   *   <li>{@link ImportDataJob#newBuilderForType()}
   *   <li>{@link ImportDataJob#toBuilder()}
   *   <li>{@link ImportDataJob#getImportAttrsList()}
   *   <li>{@link ImportDataJob#getImportAttrsOrBuilderList()}
   *   <li>{@link ImportDataJob#getModelOrBuilder()}
   *   <li>{@link ImportDataJob#getOutputAttrsList()}
   *   <li>{@link ImportDataJob#getOutputAttrsOrBuilderList()}
   *   <li>{@link ImportDataJob#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ImportDataJob actualDefaultInstance = ImportDataJob.getDefaultInstance();
    ImportDataJob actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    ImportDataJob prototype = ImportDataJob.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<TagUpdate> actualImportAttrsList = actualDefaultInstance.getImportAttrsList();
    List<? extends TagUpdateOrBuilder> actualImportAttrsOrBuilderList = actualDefaultInstance
        .getImportAttrsOrBuilderList();
    TagSelectorOrBuilder actualModelOrBuilder = actualDefaultInstance.getModelOrBuilder();
    List<TagUpdate> actualOutputAttrsList = actualDefaultInstance.getOutputAttrsList();
    List<? extends TagUpdateOrBuilder> actualOutputAttrsOrBuilderList = actualDefaultInstance
        .getOutputAttrsOrBuilderList();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualImportAttrsList);
    assertSame(uninterpretedOptionList, actualImportAttrsOrBuilderList);
    assertSame(uninterpretedOptionList, actualOutputAttrsList);
    assertSame(uninterpretedOptionList, actualOutputAttrsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(actualDefaultInstance.getModel(), actualModelOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

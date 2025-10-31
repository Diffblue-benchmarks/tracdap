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

class FlowNodeDiffblueTest {
  /**
   * Method under test: {@link FlowNode#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> FlowNode.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link FlowNode#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = FlowNode.getDefaultInstance()
        .internalGetMapFieldReflection(8);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowNode#getNodeType()}
   */
  @Test
  void testGetNodeType() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNode.getDefaultInstance().getNodeType());
  }

  /**
   * Method under test: {@link FlowNode#getParametersList()}
   */
  @Test
  void testGetParametersList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualParametersList = defaultInstance.getParametersList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(4, dependencies.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    SearchExpression nodeSearch = defaultInstance.getNodeSearch();
    assertTrue(nodeSearch.findInitializationErrors().isEmpty());
    LogicalExpression logical = nodeSearch.getLogical();
    assertTrue(logical.findInitializationErrors().isEmpty());
    SearchTerm term = nodeSearch.getTerm();
    assertTrue(term.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    Descriptors.Descriptor descriptorForType2 = nodeSearch.getDescriptorForType();
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
    assertTrue(defaultInstance.getNodeAttrsList().isEmpty());
    assertTrue(actualParametersList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualParametersList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(6).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(7).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    assertEquals(lazyStringList, term.getSearchValue().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    assertEquals(lazyStringList, toProtoResult3.getPublicDependencyList());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = logical.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = term.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor getResult2 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(2);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(3);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, descriptorForType6.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType6.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType6.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, getResult5.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType6.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(lazyStringList, getResult6.getDependencies());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(lazyStringList, getResult7.getExtensions());
    Descriptors.FileDescriptor getResult8 = dependencies.get(3);
    assertEquals(lazyStringList, getResult8.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult6.getPublicDependencies());
    assertEquals(lazyStringList, getResult7.getPublicDependencies());
    assertEquals(lazyStringList, getResult8.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult6.getServices());
    assertEquals(lazyStringList, getResult7.getServices());
    assertEquals(lazyStringList, getResult8.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, defaultInstance.getInputsList());
    assertSame(lazyStringList, defaultInstance.getOutputsList());
    assertSame(lazyStringList, actualParametersList);
  }

  /**
   * Method under test: {@link FlowNode#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link FlowNode#getInputsList()}
   */
  @Test
  void testGetInputsList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualInputsList = defaultInstance.getInputsList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(4, dependencies.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    SearchExpression nodeSearch = defaultInstance.getNodeSearch();
    assertTrue(nodeSearch.findInitializationErrors().isEmpty());
    LogicalExpression logical = nodeSearch.getLogical();
    assertTrue(logical.findInitializationErrors().isEmpty());
    SearchTerm term = nodeSearch.getTerm();
    assertTrue(term.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    Descriptors.Descriptor descriptorForType2 = nodeSearch.getDescriptorForType();
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
    assertTrue(actualInputsList.isEmpty());
    assertTrue(defaultInstance.getNodeAttrsList().isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualInputsList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(6).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(7).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    assertEquals(lazyStringList, term.getSearchValue().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    assertEquals(lazyStringList, toProtoResult3.getPublicDependencyList());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = logical.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = term.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor getResult2 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(2);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(3);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, descriptorForType6.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType6.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType6.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, getResult5.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType6.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(lazyStringList, getResult6.getDependencies());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(lazyStringList, getResult7.getExtensions());
    Descriptors.FileDescriptor getResult8 = dependencies.get(3);
    assertEquals(lazyStringList, getResult8.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult6.getPublicDependencies());
    assertEquals(lazyStringList, getResult7.getPublicDependencies());
    assertEquals(lazyStringList, getResult8.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult6.getServices());
    assertEquals(lazyStringList, getResult7.getServices());
    assertEquals(lazyStringList, getResult8.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, actualInputsList);
    assertSame(lazyStringList, defaultInstance.getOutputsList());
    assertSame(lazyStringList, defaultInstance.getParametersList());
  }

  /**
   * Method under test: {@link FlowNode#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link FlowNode#getOutputsList()}
   */
  @Test
  void testGetOutputsList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualOutputsList = defaultInstance.getOutputsList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(4, dependencies.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    SearchExpression nodeSearch = defaultInstance.getNodeSearch();
    assertTrue(nodeSearch.findInitializationErrors().isEmpty());
    LogicalExpression logical = nodeSearch.getLogical();
    assertTrue(logical.findInitializationErrors().isEmpty());
    SearchTerm term = nodeSearch.getTerm();
    assertTrue(term.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    Descriptors.Descriptor descriptorForType2 = nodeSearch.getDescriptorForType();
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
    assertTrue(defaultInstance.getNodeAttrsList().isEmpty());
    assertTrue(actualOutputsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualOutputsList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(6).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(7).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    assertEquals(lazyStringList, term.getSearchValue().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    assertEquals(lazyStringList, toProtoResult3.getPublicDependencyList());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = logical.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = term.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor getResult2 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(2);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(3);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, descriptorForType6.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType6.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType6.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, getResult5.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType6.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(lazyStringList, getResult6.getDependencies());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(lazyStringList, getResult7.getExtensions());
    Descriptors.FileDescriptor getResult8 = dependencies.get(3);
    assertEquals(lazyStringList, getResult8.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult6.getPublicDependencies());
    assertEquals(lazyStringList, getResult7.getPublicDependencies());
    assertEquals(lazyStringList, getResult8.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult6.getServices());
    assertEquals(lazyStringList, getResult7.getServices());
    assertEquals(lazyStringList, getResult8.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, defaultInstance.getInputsList());
    assertSame(lazyStringList, actualOutputsList);
    assertSame(lazyStringList, defaultInstance.getParametersList());
  }

  /**
   * Method under test: {@link FlowNode#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link FlowNode#hasNodeSearch()}
   */
  @Test
  void testHasNodeSearch() {
    // Arrange, Act and Assert
    assertFalse(FlowNode.getDefaultInstance().hasNodeSearch());
  }

  /**
   * Method under test: {@link FlowNode#getNodeAttrsCount()}
   */
  @Test
  void testGetNodeAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getNodeAttrsCount());
  }

  /**
   * Method under test: {@link FlowNode#getNodePropsCount()}
   */
  @Test
  void testGetNodePropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getNodePropsCount());
  }

  /**
   * Method under test: {@link FlowNode#containsNodeProps(String)}
   */
  @Test
  void testContainsNodeProps() {
    // Arrange, Act and Assert
    assertFalse(FlowNode.getDefaultInstance().containsNodeProps("Key"));
  }

  /**
   * Method under test: {@link FlowNode#getNodeProps()}
   */
  @Test
  void testGetNodeProps() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().getNodeProps().isEmpty());
  }

  /**
   * Method under test: {@link FlowNode#getNodePropsMap()}
   */
  @Test
  void testGetNodePropsMap() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().getNodePropsMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowNode#getNodePropsOrDefault(String, Value)}
   */
  @Test
  void testGetNodePropsOrDefault() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getNodePropsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link FlowNode#getNodePropsOrThrow(String)}
   */
  @Test
  void testGetNodePropsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowNode.getDefaultInstance().getNodePropsOrThrow("Key"));
  }

  /**
   * Method under test: {@link FlowNode#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", FlowNode.getDefaultInstance().getLabel());
  }

  /**
   * Method under test: {@link FlowNode#getLabelBytes()}
   */
  @Test
  void testGetLabelBytes() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualLabelBytes);
    assertEquals(byteString, defaultInstance.getNodeSearch().getTerm().getSearchValue().getStringValueBytes());
  }

  /**
   * Method under test: {@link FlowNode#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link FlowNode#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowNode#equals(Object)}
   *   <li>{@link FlowNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();
    FlowNode defaultInstance2 = FlowNode.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowNode#equals(Object)}
   *   <li>{@link FlowNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FlowNode.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FlowNode.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowNode.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> FlowNode.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FlowNode.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowNode.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> FlowNode.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> FlowNode.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowNode#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), "Different type to FlowNode");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowNode#getDefaultInstance()}
   *   <li>{@link FlowNode#getDescriptor()}
   *   <li>{@link FlowNode#newBuilder()}
   *   <li>{@link FlowNode#newBuilder(FlowNode)}
   *   <li>{@link FlowNode#newBuilderForType()}
   *   <li>{@link FlowNode#toBuilder()}
   *   <li>{@link FlowNode#getNodeAttrsList()}
   *   <li>{@link FlowNode#getNodeAttrsOrBuilderList()}
   *   <li>{@link FlowNode#getNodeSearchOrBuilder()}
   *   <li>{@link FlowNode#getNodeTypeValue()}
   *   <li>{@link FlowNode#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FlowNode actualDefaultInstance = FlowNode.getDefaultInstance();
    FlowNode actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    FlowNode prototype = FlowNode.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<TagUpdate> actualNodeAttrsList = actualDefaultInstance.getNodeAttrsList();
    List<? extends TagUpdateOrBuilder> actualNodeAttrsOrBuilderList = actualDefaultInstance.getNodeAttrsOrBuilderList();
    SearchExpressionOrBuilder actualNodeSearchOrBuilder = actualDefaultInstance.getNodeSearchOrBuilder();
    int actualNodeTypeValue = actualDefaultInstance.getNodeTypeValue();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualNodeTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType = actualDefaultInstance.getDescriptorForType();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = descriptorForType.getOptions()
        .getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, actualNodeAttrsList);
    assertSame(uninterpretedOptionList, actualNodeAttrsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(actualDefaultInstance.getNodeSearch(), actualNodeSearchOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
    assertSame(actualDefaultInstance.getInputsList(), actualDefaultInstance.getOutputsList());
    assertSame(actualDefaultInstance.getInputsList(), actualDefaultInstance.getParametersList());
  }
}

package org.finos.tracdap.metadata;

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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
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
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.SearchExpression.ExprCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowNodeDiffblueTest {
  /**
   * Test {@link FlowNode#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor FlowNode.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> FlowNode.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link FlowNode#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when eight; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor FlowNode.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenEight_thenReturnMapField() {
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
   * Test {@link FlowNode#getNodeType()}.
   * <p>
   * Method under test: {@link FlowNode#getNodeType()}
   */
  @Test
  @DisplayName("Test getNodeType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNodeType FlowNode.getNodeType()"})
  void testGetNodeType() {
    // Arrange, Act and Assert
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, FlowNode.getDefaultInstance().getNodeType());
  }

  /**
   * Test {@link FlowNode#getParametersList()}.
   * <p>
   * Method under test: {@link FlowNode#getParametersList()}
   */
  @Test
  @DisplayName("Test getParametersList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList FlowNode.getParametersList()"})
  void testGetParametersList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualParametersList = defaultInstance.getParametersList();

    // Assert
    assertTrue(actualParametersList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualParametersList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, defaultInstance.getInputsList());
    assertSame(lazyStringList, defaultInstance.getOutputsList());
    assertSame(lazyStringList, actualParametersList);
  }

  /**
   * Test {@link FlowNode#getParametersCount()}.
   * <p>
   * Method under test: {@link FlowNode#getParametersCount()}
   */
  @Test
  @DisplayName("Test getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getParametersCount()"})
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getParametersCount());
  }

  /**
   * Test {@link FlowNode#getInputsList()}.
   * <p>
   * Method under test: {@link FlowNode#getInputsList()}
   */
  @Test
  @DisplayName("Test getInputsList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList FlowNode.getInputsList()"})
  void testGetInputsList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualInputsList = defaultInstance.getInputsList();

    // Assert
    assertTrue(actualInputsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualInputsList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, actualInputsList);
    assertSame(lazyStringList, defaultInstance.getOutputsList());
    assertSame(lazyStringList, defaultInstance.getParametersList());
  }

  /**
   * Test {@link FlowNode#getInputsCount()}.
   * <p>
   * Method under test: {@link FlowNode#getInputsCount()}
   */
  @Test
  @DisplayName("Test getInputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getInputsCount()"})
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getInputsCount());
  }

  /**
   * Test {@link FlowNode#getOutputsList()}.
   * <p>
   * Method under test: {@link FlowNode#getOutputsList()}
   */
  @Test
  @DisplayName("Test getOutputsList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList FlowNode.getOutputsList()"})
  void testGetOutputsList() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ProtocolStringList actualOutputsList = defaultInstance.getOutputsList();

    // Assert
    assertTrue(actualOutputsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualOutputsList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, defaultInstance.getInputsList());
    assertSame(lazyStringList, actualOutputsList);
    assertSame(lazyStringList, defaultInstance.getParametersList());
  }

  /**
   * Test {@link FlowNode#getOutputsCount()}.
   * <p>
   * Method under test: {@link FlowNode#getOutputsCount()}
   */
  @Test
  @DisplayName("Test getOutputsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getOutputsCount()"})
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test {@link FlowNode#hasNodeSearch()}.
   * <p>
   * Method under test: {@link FlowNode#hasNodeSearch()}
   */
  @Test
  @DisplayName("Test hasNodeSearch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.hasNodeSearch()"})
  void testHasNodeSearch() {
    // Arrange, Act and Assert
    assertFalse(FlowNode.getDefaultInstance().hasNodeSearch());
  }

  /**
   * Test {@link FlowNode#getNodeSearch()}.
   * <p>
   * Method under test: {@link FlowNode#getNodeSearch()}
   */
  @Test
  @DisplayName("Test getNodeSearch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression FlowNode.getNodeSearch()"})
  void testGetNodeSearch() {
    // Arrange and Act
    SearchExpression actualNodeSearch = FlowNode.getDefaultInstance().getNodeSearch();

    // Assert
    assertEquals("", actualNodeSearch.getInitializationErrorString());
    assertEquals(0, actualNodeSearch.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualNodeSearch.getExprCase());
    assertFalse(actualNodeSearch.hasLogical());
    assertFalse(actualNodeSearch.hasTerm());
    assertTrue(actualNodeSearch.findInitializationErrors().isEmpty());
    assertTrue(actualNodeSearch.getAllFields().isEmpty());
    assertTrue(actualNodeSearch.isInitialized());
    assertSame(actualNodeSearch, actualNodeSearch.getDefaultInstanceForType());
  }

  /**
   * Test {@link FlowNode#getNodeAttrsCount()}.
   * <p>
   * Method under test: {@link FlowNode#getNodeAttrsCount()}
   */
  @Test
  @DisplayName("Test getNodeAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getNodeAttrsCount()"})
  void testGetNodeAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getNodeAttrsCount());
  }

  /**
   * Test {@link FlowNode#getNodePropsCount()}.
   * <p>
   * Method under test: {@link FlowNode#getNodePropsCount()}
   */
  @Test
  @DisplayName("Test getNodePropsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getNodePropsCount()"})
  void testGetNodePropsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getNodePropsCount());
  }

  /**
   * Test {@link FlowNode#containsNodeProps(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#containsNodeProps(String)}
   */
  @Test
  @DisplayName("Test containsNodeProps(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.containsNodeProps(String)"})
  void testContainsNodeProps_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlowNode.getDefaultInstance().containsNodeProps("Key"));
  }

  /**
   * Test {@link FlowNode#getNodeProps()}.
   * <p>
   * Method under test: {@link FlowNode#getNodeProps()}
   */
  @Test
  @DisplayName("Test getNodeProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map FlowNode.getNodeProps()"})
  void testGetNodeProps() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().getNodeProps().isEmpty());
  }

  /**
   * Test {@link FlowNode#getNodePropsMap()}.
   * <p>
   * Method under test: {@link FlowNode#getNodePropsMap()}
   */
  @Test
  @DisplayName("Test getNodePropsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map FlowNode.getNodePropsMap()"})
  void testGetNodePropsMap() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().getNodePropsMap().isEmpty());
  }

  /**
   * Test {@link FlowNode#getNodePropsOrDefault(String, Value)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#getNodePropsOrDefault(String, Value)}
   */
  @Test
  @DisplayName("Test getNodePropsOrDefault(String, Value); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value FlowNode.getNodePropsOrDefault(String, Value)"})
  void testGetNodePropsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getNodePropsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link FlowNode#getNodePropsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#getNodePropsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getNodePropsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value FlowNode.getNodePropsOrThrow(String)"})
  void testGetNodePropsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowNode.getDefaultInstance().getNodePropsOrThrow("Key"));
  }

  /**
   * Test {@link FlowNode#getLabel()}.
   * <p>
   * Method under test: {@link FlowNode#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FlowNode.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", FlowNode.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link FlowNode#getLabelBytes()}.
   * <p>
   * Method under test: {@link FlowNode#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString FlowNode.getLabelBytes()"})
  void testGetLabelBytes() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualLabelBytes);
    SearchTerm term = defaultInstance.getNodeSearch().getTerm();
    assertEquals(byteString, term.getAttrNameBytes());
    assertEquals(byteString, term.getSearchValue().getStringValueBytes());
  }

  /**
   * Test {@link FlowNode#isInitialized()}.
   * <p>
   * Method under test: {@link FlowNode#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FlowNode.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link FlowNode#getSerializedSize()}.
   * <p>
   * Method under test: {@link FlowNode#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlowNode.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FlowNode.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link FlowNode#equals(Object)}, and {@link FlowNode#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FlowNode#equals(Object)}
   *   <li>{@link FlowNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.equals(Object)", "int FlowNode.hashCode()"})
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
   * Test {@link FlowNode#equals(Object)}, and {@link FlowNode#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FlowNode#equals(Object)}
   *   <li>{@link FlowNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.equals(Object)", "int FlowNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link FlowNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.equals(Object)", "int FlowNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), 1);
  }

  /**
   * Test {@link FlowNode#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.equals(Object)", "int FlowNode.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), null);
  }

  /**
   * Test {@link FlowNode#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlowNode.equals(Object)", "int FlowNode.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowNode.getDefaultInstance(), "Different type to FlowNode");
  }

  /**
   * Test {@link FlowNode#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedLabelBytes = data.EMPTY;
    assertEquals(expectedLabelBytes, actualParseFromResult.getLabelBytes());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedLabelBytes = data.EMPTY;
    assertEquals(expectedLabelBytes, actualParseFromResult.getLabelBytes());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getLabel());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getNodeAttrsCount());
    assertEquals(0, actualParseFromResult.getNodePropsCount());
    assertEquals(0, actualParseFromResult.getNodeTypeValue());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(FlowNodeType.NODE_TYPE_NOT_SET, actualParseFromResult.getNodeType());
    assertFalse(actualParseFromResult.hasNodeSearch());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    List<TagUpdate> nodeAttrsList = actualParseFromResult.getNodeAttrsList();
    assertTrue(nodeAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getNodeProps().isEmpty());
    assertTrue(actualParseFromResult.getNodePropsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(nodeAttrsList, actualParseFromResult.getNodeAttrsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowNode.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FlowNode.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    FlowNode actualParseFromResult = FlowNode.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    SearchExpression nodeSearch = actualParseFromResult.getNodeSearch();
    assertSame(unknownFields, nodeSearch.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
    assertSame(nodeSearch, actualParseFromResult.getNodeSearchOrBuilder());
    assertSame(nodeSearch, nodeSearch.getDefaultInstanceForType());
  }

  /**
   * Test {@link FlowNode#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    FlowNode actualParseFromResult = FlowNode.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    SearchExpression nodeSearch = actualParseFromResult.getNodeSearch();
    assertSame(unknownFields, nodeSearch.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList inputsList = actualParseFromResult.getInputsList();
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getParametersList());
    assertSame(nodeSearch, actualParseFromResult.getNodeSearchOrBuilder());
    assertSame(nodeSearch, nodeSearch.getDefaultInstanceForType());
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowNode.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FlowNode actualParseDelimitedFromResult = FlowNode.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ProtocolStringList inputsList = actualParseDelimitedFromResult.getInputsList();
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getParametersList());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FlowNode actualParseDelimitedFromResult = FlowNode.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ProtocolStringList inputsList = actualParseDelimitedFromResult.getInputsList();
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getParametersList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
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
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowNode.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FlowNode actualParseDelimitedFromResult = FlowNode.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ProtocolStringList inputsList = actualParseDelimitedFromResult.getInputsList();
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getParametersList());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FlowNode actualParseDelimitedFromResult = FlowNode.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ProtocolStringList inputsList = actualParseDelimitedFromResult.getInputsList();
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getParametersList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
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
   * Test {@link FlowNode#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowNode#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
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
   * Test {@link FlowNode#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link FlowNode#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowNode FlowNode.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    FlowNode defaultInstance = FlowNode.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

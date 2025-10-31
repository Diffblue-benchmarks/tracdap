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

class FlowDefinitionDiffblueTest {
  /**
   * Method under test: {@link FlowDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> FlowDefinition.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link FlowDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = FlowDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = FlowDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = FlowDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = FlowDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getNodesCount()}
   */
  @Test
  void testGetNodesCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getNodesCount());
  }

  /**
   * Method under test: {@link FlowDefinition#containsNodes(String)}
   */
  @Test
  void testContainsNodes() {
    // Arrange, Act and Assert
    assertFalse(FlowDefinition.getDefaultInstance().containsNodes("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getNodes()}
   */
  @Test
  void testGetNodes() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getNodes().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getNodesMap()}
   */
  @Test
  void testGetNodesMap() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getNodesMap().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getNodesOrDefault(String, FlowNode)}
   */
  @Test
  void testGetNodesOrDefault() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();
    FlowNode defaultValue = FlowNode.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getNodesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link FlowDefinition#getNodesOrThrow(String)}
   */
  @Test
  void testGetNodesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowDefinition.getDefaultInstance().getNodesOrThrow("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getEdgesCount()}
   */
  @Test
  void testGetEdgesCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getEdgesCount());
  }

  /**
   * Method under test: {@link FlowDefinition#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link FlowDefinition#containsParameters(String)}
   */
  @Test
  void testContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(FlowDefinition.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getParametersMap()}
   */
  @Test
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowDefinition#getParametersOrDefault(String, ModelParameter)}
   */
  @Test
  void testGetParametersOrDefault() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();
    ModelParameter defaultValue = ModelParameter.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link FlowDefinition#getParametersOrThrow(String)}
   */
  @Test
  void testGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowDefinition.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link FlowDefinition#containsInputs(String)}
   */
  @Test
  void testContainsInputs() {
    // Arrange, Act and Assert
    assertFalse(FlowDefinition.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getInputs()}
   */
  @Test
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getInputsMap()}
   */
  @Test
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowDefinition#getInputsOrDefault(String, ModelInputSchema)}
   */
  @Test
  void testGetInputsOrDefault() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();
    ModelInputSchema defaultValue = ModelInputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link FlowDefinition#getInputsOrThrow(String)}
   */
  @Test
  void testGetInputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowDefinition.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link FlowDefinition#containsOutputs(String)}
   */
  @Test
  void testContainsOutputs() {
    // Arrange, Act and Assert
    assertFalse(FlowDefinition.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#getOutputs()}
   */
  @Test
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Method under test: {@link FlowDefinition#getOutputsMap()}
   */
  @Test
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowDefinition#getOutputsOrDefault(String, ModelOutputSchema)}
   */
  @Test
  void testGetOutputsOrDefault() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();
    ModelOutputSchema defaultValue = ModelOutputSchema.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link FlowDefinition#getOutputsOrThrow(String)}
   */
  @Test
  void testGetOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FlowDefinition.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link FlowDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FlowDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link FlowDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FlowDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowDefinition#equals(Object)}
   *   <li>{@link FlowDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();
    FlowDefinition defaultInstance2 = FlowDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowDefinition#equals(Object)}
   *   <li>{@link FlowDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link FlowDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FlowDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FlowDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FlowDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FlowDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link FlowDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link FlowDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> FlowDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FlowDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FlowDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FlowDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> FlowDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FlowDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link FlowDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> FlowDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link FlowDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    FlowDefinition defaultInstance = FlowDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link FlowDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link FlowDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link FlowDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FlowDefinition.getDefaultInstance(), "Different type to FlowDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlowDefinition#getDefaultInstance()}
   *   <li>{@link FlowDefinition#getDescriptor()}
   *   <li>{@link FlowDefinition#newBuilder()}
   *   <li>{@link FlowDefinition#newBuilder(FlowDefinition)}
   *   <li>{@link FlowDefinition#newBuilderForType()}
   *   <li>{@link FlowDefinition#toBuilder()}
   *   <li>{@link FlowDefinition#getEdgesList()}
   *   <li>{@link FlowDefinition#getEdgesOrBuilderList()}
   *   <li>{@link FlowDefinition#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FlowDefinition actualDefaultInstance = FlowDefinition.getDefaultInstance();
    FlowDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    FlowDefinition prototype = FlowDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    List<FlowEdge> actualEdgesList = actualDefaultInstance.getEdgesList();
    List<? extends FlowEdgeOrBuilder> actualEdgesOrBuilderList = actualDefaultInstance.getEdgesOrBuilderList();
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
    assertSame(uninterpretedOptionList, actualEdgesList);
    assertSame(uninterpretedOptionList, actualEdgesOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(prototype, actualDefaultInstance2);
  }
}

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

class RunFlowJobDiffblueTest {
  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunFlowJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection6() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunFlowJob.getDefaultInstance()
        .internalGetMapFieldReflection(6);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#hasFlow()}
   */
  @Test
  void testHasFlow() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().hasFlow());
  }

  /**
   * Method under test: {@link RunFlowJob#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link RunFlowJob#containsParameters(String)}
   */
  @Test
  void testContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getParametersMap()}
   */
  @Test
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getParametersOrDefault(String, Value)}
   */
  @Test
  void testGetParametersOrDefault() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunFlowJob#getParametersOrThrow(String)}
   */
  @Test
  void testGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link RunFlowJob#containsInputs(String)}
   */
  @Test
  void testContainsInputs() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getInputs()}
   */
  @Test
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getInputsMap()}
   */
  @Test
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetInputsOrDefault() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunFlowJob#getInputsOrThrow(String)}
   */
  @Test
  void testGetInputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link RunFlowJob#containsOutputs(String)}
   */
  @Test
  void testContainsOutputs() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getOutputs()}
   */
  @Test
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getOutputsMap()}
   */
  @Test
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RunFlowJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetOutputsOrDefault() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunFlowJob#getOutputsOrThrow(String)}
   */
  @Test
  void testGetOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getPriorOutputsCount()}
   */
  @Test
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Method under test: {@link RunFlowJob#containsPriorOutputs(String)}
   */
  @Test
  void testContainsPriorOutputs() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getPriorOutputs()}
   */
  @Test
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getPriorOutputsMap()}
   */
  @Test
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RunFlowJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetPriorOutputsOrDefault() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunFlowJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  void testGetPriorOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getModelsCount()}
   */
  @Test
  void testGetModelsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getModelsCount());
  }

  /**
   * Method under test: {@link RunFlowJob#containsModels(String)}
   */
  @Test
  void testContainsModels() {
    // Arrange, Act and Assert
    assertFalse(RunFlowJob.getDefaultInstance().containsModels("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getModels()}
   */
  @Test
  void testGetModels() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getModels().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getModelsMap()}
   */
  @Test
  void testGetModelsMap() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().getModelsMap().isEmpty());
  }

  /**
   * Method under test: {@link RunFlowJob#getModelsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetModelsOrDefault() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getModelsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunFlowJob#getModelsOrThrow(String)}
   */
  @Test
  void testGetModelsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunFlowJob.getDefaultInstance().getModelsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunFlowJob#getOutputAttrsCount()}
   */
  @Test
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Method under test: {@link RunFlowJob#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RunFlowJob.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link RunFlowJob#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RunFlowJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunFlowJob#equals(Object)}
   *   <li>{@link RunFlowJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();
    RunFlowJob defaultInstance2 = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunFlowJob#equals(Object)}
   *   <li>{@link RunFlowJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RunFlowJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunFlowJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunFlowJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunFlowJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunFlowJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunFlowJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunFlowJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RunFlowJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunFlowJob#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    RunFlowJob defaultInstance = RunFlowJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link RunFlowJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunFlowJob.getDefaultInstance(), "Different type to RunFlowJob");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunFlowJob#getDefaultInstance()}
   *   <li>{@link RunFlowJob#getDescriptor()}
   *   <li>{@link RunFlowJob#newBuilder()}
   *   <li>{@link RunFlowJob#newBuilder(RunFlowJob)}
   *   <li>{@link RunFlowJob#newBuilderForType()}
   *   <li>{@link RunFlowJob#toBuilder()}
   *   <li>{@link RunFlowJob#getFlowOrBuilder()}
   *   <li>{@link RunFlowJob#getOutputAttrsList()}
   *   <li>{@link RunFlowJob#getOutputAttrsOrBuilderList()}
   *   <li>{@link RunFlowJob#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RunFlowJob actualDefaultInstance = RunFlowJob.getDefaultInstance();
    RunFlowJob actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    RunFlowJob prototype = RunFlowJob.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    TagSelectorOrBuilder actualFlowOrBuilder = actualDefaultInstance.getFlowOrBuilder();
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
    assertSame(uninterpretedOptionList, actualOutputAttrsList);
    assertSame(uninterpretedOptionList, actualOutputAttrsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(actualDefaultInstance.getFlow(), actualFlowOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

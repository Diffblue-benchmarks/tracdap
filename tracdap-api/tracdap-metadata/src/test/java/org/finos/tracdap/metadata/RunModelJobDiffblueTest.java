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

class RunModelJobDiffblueTest {
  /**
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunModelJob.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection5() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RunModelJob.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#hasModel()}
   */
  @Test
  void testHasModel() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().hasModel());
  }

  /**
   * Method under test: {@link RunModelJob#getParametersCount()}
   */
  @Test
  void testGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test: {@link RunModelJob#containsParameters(String)}
   */
  @Test
  void testContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsParameters("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getParameters()}
   */
  @Test
  void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#getParametersMap()}
   */
  @Test
  void testGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#getParametersOrDefault(String, Value)}
   */
  @Test
  void testGetParametersOrDefault() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    Value defaultValue = Value.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getParametersOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunModelJob#getParametersOrThrow(String)}
   */
  @Test
  void testGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getParametersOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getInputsCount()}
   */
  @Test
  void testGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getInputsCount());
  }

  /**
   * Method under test: {@link RunModelJob#containsInputs(String)}
   */
  @Test
  void testContainsInputs() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsInputs("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getInputs()}
   */
  @Test
  void testGetInputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getInputs().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#getInputsMap()}
   */
  @Test
  void testGetInputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getInputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelJob#getInputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetInputsOrDefault() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getInputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunModelJob#getInputsOrThrow(String)}
   */
  @Test
  void testGetInputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getInputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getOutputsCount()}
   */
  @Test
  void testGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getOutputsCount());
  }

  /**
   * Method under test: {@link RunModelJob#containsOutputs(String)}
   */
  @Test
  void testContainsOutputs() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsOutputs("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getOutputs()}
   */
  @Test
  void testGetOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getOutputs().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#getOutputsMap()}
   */
  @Test
  void testGetOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelJob#getOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetOutputsOrDefault() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunModelJob#getOutputsOrThrow(String)}
   */
  @Test
  void testGetOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getPriorOutputsCount()}
   */
  @Test
  void testGetPriorOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getPriorOutputsCount());
  }

  /**
   * Method under test: {@link RunModelJob#containsPriorOutputs(String)}
   */
  @Test
  void testContainsPriorOutputs() {
    // Arrange, Act and Assert
    assertFalse(RunModelJob.getDefaultInstance().containsPriorOutputs("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getPriorOutputs()}
   */
  @Test
  void testGetPriorOutputs() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getPriorOutputs().isEmpty());
  }

  /**
   * Method under test: {@link RunModelJob#getPriorOutputsMap()}
   */
  @Test
  void testGetPriorOutputsMap() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().getPriorOutputsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RunModelJob#getPriorOutputsOrDefault(String, TagSelector)}
   */
  @Test
  void testGetPriorOutputsOrDefault() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    TagSelector defaultValue = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPriorOutputsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RunModelJob#getPriorOutputsOrThrow(String)}
   */
  @Test
  void testGetPriorOutputsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RunModelJob.getDefaultInstance().getPriorOutputsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RunModelJob#getOutputAttrsCount()}
   */
  @Test
  void testGetOutputAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getOutputAttrsCount());
  }

  /**
   * Method under test: {@link RunModelJob#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RunModelJob.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link RunModelJob#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RunModelJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunModelJob#equals(Object)}
   *   <li>{@link RunModelJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();
    RunModelJob defaultInstance2 = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunModelJob#equals(Object)}
   *   <li>{@link RunModelJob#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RunModelJob#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RunModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunModelJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RunModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RunModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RunModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RunModelJob#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    RunModelJob defaultInstance = RunModelJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link RunModelJob#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RunModelJob.getDefaultInstance(), "Different type to RunModelJob");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RunModelJob#getDefaultInstance()}
   *   <li>{@link RunModelJob#getDescriptor()}
   *   <li>{@link RunModelJob#newBuilder()}
   *   <li>{@link RunModelJob#newBuilder(RunModelJob)}
   *   <li>{@link RunModelJob#newBuilderForType()}
   *   <li>{@link RunModelJob#toBuilder()}
   *   <li>{@link RunModelJob#getModelOrBuilder()}
   *   <li>{@link RunModelJob#getOutputAttrsList()}
   *   <li>{@link RunModelJob#getOutputAttrsOrBuilderList()}
   *   <li>{@link RunModelJob#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RunModelJob actualDefaultInstance = RunModelJob.getDefaultInstance();
    RunModelJob actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    RunModelJob prototype = RunModelJob.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
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
    assertSame(uninterpretedOptionList, actualOutputAttrsList);
    assertSame(uninterpretedOptionList, actualOutputAttrsOrBuilderList);
    assertSame(descriptorForType, actualDescriptor);
    assertSame(actualDefaultInstance.getModel(), actualModelOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

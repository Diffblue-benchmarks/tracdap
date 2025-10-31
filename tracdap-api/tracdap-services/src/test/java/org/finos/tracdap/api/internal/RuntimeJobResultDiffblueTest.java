package org.finos.tracdap.api.internal;

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
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeaderOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RuntimeJobResultDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeJobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RuntimeJobResult.getDefaultInstance().internalGetMapFieldReflection(10));
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RuntimeJobResult.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeJobResult#hasJobId()}
   */
  @Test
  void testHasJobId() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobResult.getDefaultInstance().hasJobId());
  }

  /**
   * Method under test: {@link RuntimeJobResult#getStatusCode()}
   */
  @Test
  void testGetStatusCode() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, RuntimeJobResult.getDefaultInstance().getStatusCode());
  }

  /**
   * Method under test: {@link RuntimeJobResult#getStatusMessage()}
   */
  @Test
  void testGetStatusMessage() {
    // Arrange, Act and Assert
    assertEquals("", RuntimeJobResult.getDefaultInstance().getStatusMessage());
  }

  /**
   * Method under test: {@link RuntimeJobResult#getStatusMessageBytes()}
   */
  @Test
  void testGetStatusMessageBytes() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act
    ByteString actualStatusMessageBytes = defaultInstance.getStatusMessageBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualStatusMessageBytes.EMPTY;
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    DescriptorProtos.FileOptions defaultInstanceForType = descriptorForType.getFile()
        .getOptions()
        .getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, actualStatusMessageBytes);
  }

  /**
   * Method under test: {@link RuntimeJobResult#getResultsCount()}
   */
  @Test
  void testGetResultsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobResult.getDefaultInstance().getResultsCount());
  }

  /**
   * Method under test: {@link RuntimeJobResult#containsResults(String)}
   */
  @Test
  void testContainsResults() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobResult.getDefaultInstance().containsResults("Key"));
  }

  /**
   * Method under test: {@link RuntimeJobResult#getResults()}
   */
  @Test
  void testGetResults() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().getResults().isEmpty());
  }

  /**
   * Method under test: {@link RuntimeJobResult#getResultsMap()}
   */
  @Test
  void testGetResultsMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().getResultsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#getResultsOrDefault(String, ObjectDefinition)}
   */
  @Test
  void testGetResultsOrDefault() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();
    ObjectDefinition defaultValue = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResultsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link RuntimeJobResult#getResultsOrThrow(String)}
   */
  @Test
  void testGetResultsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeJobResult.getDefaultInstance().getResultsOrThrow("Key"));
  }

  /**
   * Method under test: {@link RuntimeJobResult#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link RuntimeJobResult#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobResult.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobResult#equals(Object)}
   *   <li>{@link RuntimeJobResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();
    RuntimeJobResult defaultInstance2 = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobResult#equals(Object)}
   *   <li>{@link RuntimeJobResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobResult.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeJobResult#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), "Different type to RuntimeJobResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobResult#getDefaultInstance()}
   *   <li>{@link RuntimeJobResult#getDescriptor()}
   *   <li>{@link RuntimeJobResult#newBuilder()}
   *   <li>{@link RuntimeJobResult#newBuilder(RuntimeJobResult)}
   *   <li>{@link RuntimeJobResult#newBuilderForType()}
   *   <li>{@link RuntimeJobResult#toBuilder()}
   *   <li>{@link RuntimeJobResult#getJobIdOrBuilder()}
   *   <li>{@link RuntimeJobResult#getParserForType()}
   *   <li>{@link RuntimeJobResult#getStatusCodeValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuntimeJobResult actualDefaultInstance = RuntimeJobResult.getDefaultInstance();
    RuntimeJobResult actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    RuntimeJobResult prototype = RuntimeJobResult.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    TagHeaderOrBuilder actualJobIdOrBuilder = actualDefaultInstance.getJobIdOrBuilder();
    actualDefaultInstance.getParserForType();
    int actualStatusCodeValue = actualDefaultInstance.getStatusCodeValue();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualStatusCodeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getJobId(), actualJobIdOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

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
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeaderOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobResultDiffblueTest {
  /**
   * Method under test: {@link JobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> JobResult.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link JobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = JobResult.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link JobResult#hasJobId()}
   */
  @Test
  void testHasJobId() {
    // Arrange, Act and Assert
    assertFalse(JobResult.getDefaultInstance().hasJobId());
  }

  /**
   * Method under test: {@link JobResult#getStatusCode()}
   */
  @Test
  void testGetStatusCode() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, JobResult.getDefaultInstance().getStatusCode());
  }

  /**
   * Method under test: {@link JobResult#getStatusMessage()}
   */
  @Test
  void testGetStatusMessage() {
    // Arrange, Act and Assert
    assertEquals("", JobResult.getDefaultInstance().getStatusMessage());
  }

  /**
   * Method under test: {@link JobResult#getStatusMessageBytes()}
   */
  @Test
  void testGetStatusMessageBytes() {
    // Arrange
    JobResult defaultInstance = JobResult.getDefaultInstance();

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
    assertEquals(byteString, actualStatusMessageBytes);
  }

  /**
   * Method under test: {@link JobResult#getResultsCount()}
   */
  @Test
  void testGetResultsCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobResult.getDefaultInstance().getResultsCount());
  }

  /**
   * Method under test: {@link JobResult#containsResults(String)}
   */
  @Test
  void testContainsResults() {
    // Arrange, Act and Assert
    assertFalse(JobResult.getDefaultInstance().containsResults("Key"));
  }

  /**
   * Method under test: {@link JobResult#getResults()}
   */
  @Test
  void testGetResults() {
    // Arrange, Act and Assert
    assertTrue(JobResult.getDefaultInstance().getResults().isEmpty());
  }

  /**
   * Method under test: {@link JobResult#getResultsMap()}
   */
  @Test
  void testGetResultsMap() {
    // Arrange, Act and Assert
    assertTrue(JobResult.getDefaultInstance().getResultsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link JobResult#getResultsOrDefault(String, ObjectDefinition)}
   */
  @Test
  void testGetResultsOrDefault() {
    // Arrange
    JobResult defaultInstance = JobResult.getDefaultInstance();
    ObjectDefinition defaultValue = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResultsOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link JobResult#getResultsOrThrow(String)}
   */
  @Test
  void testGetResultsOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobResult.getDefaultInstance().getResultsOrThrow("Key"));
  }

  /**
   * Method under test: {@link JobResult#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobResult.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link JobResult#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobResult.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobResult#equals(Object)}
   *   <li>{@link JobResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JobResult defaultInstance = JobResult.getDefaultInstance();
    JobResult defaultInstance2 = JobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobResult#equals(Object)}
   *   <li>{@link JobResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobResult defaultInstance = JobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JobResult#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobResult#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobResult.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link JobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> JobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobResult#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    JobResult defaultInstance = JobResult.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobResult.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobResult.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JobResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobResult.getDefaultInstance(), "Different type to JobResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobResult#getDefaultInstance()}
   *   <li>{@link JobResult#getDescriptor()}
   *   <li>{@link JobResult#newBuilder()}
   *   <li>{@link JobResult#newBuilder(JobResult)}
   *   <li>{@link JobResult#newBuilderForType()}
   *   <li>{@link JobResult#toBuilder()}
   *   <li>{@link JobResult#getJobIdOrBuilder()}
   *   <li>{@link JobResult#getParserForType()}
   *   <li>{@link JobResult#getStatusCodeValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JobResult actualDefaultInstance = JobResult.getDefaultInstance();
    JobResult actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    JobResult prototype = JobResult.getDefaultInstance();
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

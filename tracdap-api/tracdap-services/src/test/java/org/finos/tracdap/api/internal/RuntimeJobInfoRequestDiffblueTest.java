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
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.finos.tracdap.metadata.TagSelectorOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RuntimeJobInfoRequestDiffblueTest {
  /**
   * Method under test: {@link RuntimeJobInfoRequest#getJobCase()}
   */
  @Test
  void testGetJobCase() {
    // Arrange, Act and Assert
    assertEquals(RuntimeJobInfoRequest.JobCase.JOB_NOT_SET, RuntimeJobInfoRequest.getDefaultInstance().getJobCase());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#hasJobSelector()}
   */
  @Test
  void testHasJobSelector() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobInfoRequest.getDefaultInstance().hasJobSelector());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#hasJobKey()}
   */
  @Test
  void testHasJobKey() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobInfoRequest.getDefaultInstance().hasJobKey());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#getJobKey()}
   */
  @Test
  void testGetJobKey() {
    // Arrange, Act and Assert
    assertEquals("", RuntimeJobInfoRequest.getDefaultInstance().getJobKey());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#getJobKeyBytes()}
   */
  @Test
  void testGetJobKeyBytes() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act
    ByteString actualJobKeyBytes = defaultInstance.getJobKeyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualJobKeyBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
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
    assertEquals(byteString, actualJobKeyBytes);
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobInfoRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobInfoRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobInfoRequest#equals(Object)}
   *   <li>{@link RuntimeJobInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();
    RuntimeJobInfoRequest defaultInstance2 = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobInfoRequest#equals(Object)}
   *   <li>{@link RuntimeJobInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest.JobCase#forNumber(int)}
   */
  @Test
  void testJobCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(RuntimeJobInfoRequest.JobCase.forNumber(42));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOB_NOT_SET, RuntimeJobInfoRequest.JobCase.forNumber(0));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOBSELECTOR, RuntimeJobInfoRequest.JobCase.forNumber(1));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOBKEY, RuntimeJobInfoRequest.JobCase.forNumber(2));
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest.JobCase#getNumber()}
   */
  @Test
  void testJobCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, RuntimeJobInfoRequest.JobCase.valueOf("JOBSELECTOR").getNumber());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest.JobCase#valueOf(int)}
   */
  @Test
  void testJobCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(RuntimeJobInfoRequest.JobCase.valueOf(42));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOB_NOT_SET, RuntimeJobInfoRequest.JobCase.valueOf(0));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOBSELECTOR, RuntimeJobInfoRequest.JobCase.valueOf(1));
    assertEquals(RuntimeJobInfoRequest.JobCase.JOBKEY, RuntimeJobInfoRequest.JobCase.valueOf(2));
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobInfoRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobInfoRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobInfoRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobInfoRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobInfoRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), "Different type to RuntimeJobInfoRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobInfoRequest#getDefaultInstance()}
   *   <li>{@link RuntimeJobInfoRequest#getDescriptor()}
   *   <li>{@link RuntimeJobInfoRequest#newBuilder()}
   *   <li>{@link RuntimeJobInfoRequest#newBuilder(RuntimeJobInfoRequest)}
   *   <li>{@link RuntimeJobInfoRequest#newBuilderForType()}
   *   <li>{@link RuntimeJobInfoRequest#toBuilder()}
   *   <li>{@link RuntimeJobInfoRequest#getJobSelectorOrBuilder()}
   *   <li>{@link RuntimeJobInfoRequest#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuntimeJobInfoRequest actualDefaultInstance = RuntimeJobInfoRequest.getDefaultInstance();
    RuntimeJobInfoRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    RuntimeJobInfoRequest prototype = RuntimeJobInfoRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    TagSelectorOrBuilder actualJobSelectorOrBuilder = actualDefaultInstance.getJobSelectorOrBuilder();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getJobSelector(), actualJobSelectorOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

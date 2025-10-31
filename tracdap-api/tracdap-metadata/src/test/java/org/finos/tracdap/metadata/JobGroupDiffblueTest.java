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
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobGroupDiffblueTest {
  /**
   * Method under test: {@link JobGroup#getJobGroupDetailsCase()}
   */
  @Test
  void testGetJobGroupDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET,
        JobGroup.getDefaultInstance().getJobGroupDetailsCase());
  }

  /**
   * Method under test: {@link JobGroup#getJobGroupType()}
   */
  @Test
  void testGetJobGroupType() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroup.getDefaultInstance().getJobGroupType());
  }

  /**
   * Method under test: {@link JobGroup#hasSequential()}
   */
  @Test
  void testHasSequential() {
    // Arrange, Act and Assert
    assertFalse(JobGroup.getDefaultInstance().hasSequential());
  }

  /**
   * Method under test: {@link JobGroup#hasParallel()}
   */
  @Test
  void testHasParallel() {
    // Arrange, Act and Assert
    assertFalse(JobGroup.getDefaultInstance().hasParallel());
  }

  /**
   * Method under test: {@link JobGroup#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobGroup.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link JobGroup#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobGroup.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobGroup#equals(Object)}
   *   <li>{@link JobGroup#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JobGroup defaultInstance = JobGroup.getDefaultInstance();
    JobGroup defaultInstance2 = JobGroup.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobGroup#equals(Object)}
   *   <li>{@link JobGroup#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobGroup defaultInstance = JobGroup.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JobGroup.JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  void testJobGroupDetailsCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(JobGroup.JobGroupDetailsCase.forNumber(42));
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroup.JobGroupDetailsCase.forNumber(0));
    assertEquals(JobGroup.JobGroupDetailsCase.SEQUENTIAL, JobGroup.JobGroupDetailsCase.forNumber(2));
    assertEquals(JobGroup.JobGroupDetailsCase.PARALLEL, JobGroup.JobGroupDetailsCase.forNumber(3));
  }

  /**
   * Method under test: {@link JobGroup.JobGroupDetailsCase#getNumber()}
   */
  @Test
  void testJobGroupDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobGroup.JobGroupDetailsCase.valueOf("SEQUENTIAL").getNumber());
  }

  /**
   * Method under test: {@link JobGroup.JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  void testJobGroupDetailsCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(JobGroup.JobGroupDetailsCase.valueOf(42));
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroup.JobGroupDetailsCase.valueOf(0));
    assertEquals(JobGroup.JobGroupDetailsCase.SEQUENTIAL, JobGroup.JobGroupDetailsCase.valueOf(2));
    assertEquals(JobGroup.JobGroupDetailsCase.PARALLEL, JobGroup.JobGroupDetailsCase.valueOf(3));
  }

  /**
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobGroup.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobGroup.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobGroup.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobGroup.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobGroup.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobGroup.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobGroup#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    JobGroup defaultInstance = JobGroup.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), "Different type to JobGroup");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobGroup#getDefaultInstance()}
   *   <li>{@link JobGroup#getDescriptor()}
   *   <li>{@link JobGroup#newBuilder()}
   *   <li>{@link JobGroup#newBuilder(JobGroup)}
   *   <li>{@link JobGroup#newBuilderForType()}
   *   <li>{@link JobGroup#toBuilder()}
   *   <li>{@link JobGroup#getJobGroupTypeValue()}
   *   <li>{@link JobGroup#getParallelOrBuilder()}
   *   <li>{@link JobGroup#getParserForType()}
   *   <li>{@link JobGroup#getSequentialOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JobGroup actualDefaultInstance = JobGroup.getDefaultInstance();
    JobGroup actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    JobGroup prototype = JobGroup.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    int actualJobGroupTypeValue = actualDefaultInstance.getJobGroupTypeValue();
    ParallelJobGroupOrBuilder actualParallelOrBuilder = actualDefaultInstance.getParallelOrBuilder();
    actualDefaultInstance.getParserForType();
    SequentialJobGroupOrBuilder actualSequentialOrBuilder = actualDefaultInstance.getSequentialOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualJobGroupTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getParallel(), actualParallelOrBuilder);
    assertSame(actualDefaultInstance.getSequential(), actualSequentialOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

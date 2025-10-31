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

class JobDefinitionDiffblueTest {
  /**
   * Method under test: {@link JobDefinition#getJobDetailsCase()}
   */
  @Test
  void testGetJobDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET,
        JobDefinition.getDefaultInstance().getJobDetailsCase());
  }

  /**
   * Method under test: {@link JobDefinition#getJobType()}
   */
  @Test
  void testGetJobType() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobDefinition.getDefaultInstance().getJobType());
  }

  /**
   * Method under test: {@link JobDefinition#hasRunModel()}
   */
  @Test
  void testHasRunModel() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasRunModel());
  }

  /**
   * Method under test: {@link JobDefinition#hasRunFlow()}
   */
  @Test
  void testHasRunFlow() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasRunFlow());
  }

  /**
   * Method under test: {@link JobDefinition#hasImportModel()}
   */
  @Test
  void testHasImportModel() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasImportModel());
  }

  /**
   * Method under test: {@link JobDefinition#hasImportData()}
   */
  @Test
  void testHasImportData() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasImportData());
  }

  /**
   * Method under test: {@link JobDefinition#hasExportData()}
   */
  @Test
  void testHasExportData() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasExportData());
  }

  /**
   * Method under test: {@link JobDefinition#hasJobGroup()}
   */
  @Test
  void testHasJobGroup() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasJobGroup());
  }

  /**
   * Method under test: {@link JobDefinition#hasResultId()}
   */
  @Test
  void testHasResultId() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasResultId());
  }

  /**
   * Method under test: {@link JobDefinition#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link JobDefinition#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobDefinition#equals(Object)}
   *   <li>{@link JobDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();
    JobDefinition defaultInstance2 = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobDefinition#equals(Object)}
   *   <li>{@link JobDefinition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JobDefinition.JobDetailsCase#forNumber(int)}
   */
  @Test
  void testJobDetailsCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(JobDefinition.JobDetailsCase.forNumber(42));
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET, JobDefinition.JobDetailsCase.forNumber(0));
    assertEquals(JobDefinition.JobDetailsCase.RUNMODEL, JobDefinition.JobDetailsCase.forNumber(2));
    assertEquals(JobDefinition.JobDetailsCase.RUNFLOW, JobDefinition.JobDetailsCase.forNumber(3));
    assertEquals(JobDefinition.JobDetailsCase.IMPORTMODEL, JobDefinition.JobDetailsCase.forNumber(4));
    assertEquals(JobDefinition.JobDetailsCase.IMPORTDATA, JobDefinition.JobDetailsCase.forNumber(5));
    assertEquals(JobDefinition.JobDetailsCase.EXPORTDATA, JobDefinition.JobDetailsCase.forNumber(6));
    assertEquals(JobDefinition.JobDetailsCase.JOBGROUP, JobDefinition.JobDetailsCase.forNumber(7));
  }

  /**
   * Method under test: {@link JobDefinition.JobDetailsCase#getNumber()}
   */
  @Test
  void testJobDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobDefinition.JobDetailsCase.valueOf("RUNMODEL").getNumber());
  }

  /**
   * Method under test: {@link JobDefinition.JobDetailsCase#valueOf(int)}
   */
  @Test
  void testJobDetailsCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(JobDefinition.JobDetailsCase.valueOf(42));
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET, JobDefinition.JobDetailsCase.valueOf(0));
    assertEquals(JobDefinition.JobDetailsCase.RUNMODEL, JobDefinition.JobDetailsCase.valueOf(2));
    assertEquals(JobDefinition.JobDetailsCase.RUNFLOW, JobDefinition.JobDetailsCase.valueOf(3));
    assertEquals(JobDefinition.JobDetailsCase.IMPORTMODEL, JobDefinition.JobDetailsCase.valueOf(4));
    assertEquals(JobDefinition.JobDetailsCase.IMPORTDATA, JobDefinition.JobDetailsCase.valueOf(5));
    assertEquals(JobDefinition.JobDetailsCase.EXPORTDATA, JobDefinition.JobDetailsCase.valueOf(6));
    assertEquals(JobDefinition.JobDetailsCase.JOBGROUP, JobDefinition.JobDetailsCase.valueOf(7));
  }

  /**
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link JobDefinition#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), "Different type to JobDefinition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobDefinition#getDefaultInstance()}
   *   <li>{@link JobDefinition#getDescriptor()}
   *   <li>{@link JobDefinition#newBuilder()}
   *   <li>{@link JobDefinition#newBuilder(JobDefinition)}
   *   <li>{@link JobDefinition#newBuilderForType()}
   *   <li>{@link JobDefinition#toBuilder()}
   *   <li>{@link JobDefinition#getExportDataOrBuilder()}
   *   <li>{@link JobDefinition#getImportDataOrBuilder()}
   *   <li>{@link JobDefinition#getImportModelOrBuilder()}
   *   <li>{@link JobDefinition#getJobGroupOrBuilder()}
   *   <li>{@link JobDefinition#getJobTypeValue()}
   *   <li>{@link JobDefinition#getParserForType()}
   *   <li>{@link JobDefinition#getResultIdOrBuilder()}
   *   <li>{@link JobDefinition#getRunFlowOrBuilder()}
   *   <li>{@link JobDefinition#getRunModelOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JobDefinition actualDefaultInstance = JobDefinition.getDefaultInstance();
    JobDefinition actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    JobDefinition prototype = JobDefinition.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    ExportDataJobOrBuilder actualExportDataOrBuilder = actualDefaultInstance.getExportDataOrBuilder();
    ImportDataJobOrBuilder actualImportDataOrBuilder = actualDefaultInstance.getImportDataOrBuilder();
    ImportModelJobOrBuilder actualImportModelOrBuilder = actualDefaultInstance.getImportModelOrBuilder();
    JobGroupOrBuilder actualJobGroupOrBuilder = actualDefaultInstance.getJobGroupOrBuilder();
    int actualJobTypeValue = actualDefaultInstance.getJobTypeValue();
    actualDefaultInstance.getParserForType();
    TagSelectorOrBuilder actualResultIdOrBuilder = actualDefaultInstance.getResultIdOrBuilder();
    RunFlowJobOrBuilder actualRunFlowOrBuilder = actualDefaultInstance.getRunFlowOrBuilder();
    RunModelJobOrBuilder actualRunModelOrBuilder = actualDefaultInstance.getRunModelOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualJobTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getExportData(), actualExportDataOrBuilder);
    assertSame(actualDefaultInstance.getImportData(), actualImportDataOrBuilder);
    assertSame(actualDefaultInstance.getImportModel(), actualImportModelOrBuilder);
    assertSame(actualDefaultInstance.getJobGroup(), actualJobGroupOrBuilder);
    assertSame(actualDefaultInstance.getResultId(), actualResultIdOrBuilder);
    assertSame(actualDefaultInstance.getRunFlow(), actualRunFlowOrBuilder);
    assertSame(actualDefaultInstance.getRunModel(), actualRunModelOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}

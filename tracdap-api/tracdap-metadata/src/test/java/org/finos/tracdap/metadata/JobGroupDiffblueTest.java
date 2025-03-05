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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.JobGroup.JobGroupDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobGroupDiffblueTest {
  /**
   * Test {@link JobGroup#getJobGroupDetailsCase()}.
   * <p>
   * Method under test: {@link JobGroup#getJobGroupDetailsCase()}
   */
  @Test
  @DisplayName("Test getJobGroupDetailsCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroup.getJobGroupDetailsCase()"})
  void testGetJobGroupDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroup.getDefaultInstance().getJobGroupDetailsCase());
  }

  /**
   * Test {@link JobGroup#getJobGroupType()}.
   * <p>
   * Method under test: {@link JobGroup#getJobGroupType()}
   */
  @Test
  @DisplayName("Test getJobGroupType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroup.getJobGroupType()"})
  void testGetJobGroupType() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroup.getDefaultInstance().getJobGroupType());
  }

  /**
   * Test {@link JobGroup#hasSequential()}.
   * <p>
   * Method under test: {@link JobGroup#hasSequential()}
   */
  @Test
  @DisplayName("Test hasSequential()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.hasSequential()"})
  void testHasSequential() {
    // Arrange, Act and Assert
    assertFalse(JobGroup.getDefaultInstance().hasSequential());
  }

  /**
   * Test {@link JobGroup#getSequential()}.
   * <p>
   * Method under test: {@link JobGroup#getSequential()}
   */
  @Test
  @DisplayName("Test getSequential()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SequentialJobGroup JobGroup.getSequential()"})
  void testGetSequential() {
    // Arrange and Act
    SequentialJobGroup actualSequential = JobGroup.getDefaultInstance().getSequential();

    // Assert
    assertEquals("", actualSequential.getInitializationErrorString());
    assertEquals(0, actualSequential.getJobsCount());
    assertEquals(0, actualSequential.getSerializedSize());
    assertTrue(actualSequential.findInitializationErrors().isEmpty());
    List<JobDefinition> jobsList = actualSequential.getJobsList();
    assertTrue(jobsList.isEmpty());
    assertTrue(actualSequential.getAllFields().isEmpty());
    assertTrue(actualSequential.isInitialized());
    assertSame(actualSequential, actualSequential.getDefaultInstanceForType());
    assertSame(jobsList, actualSequential.getJobsOrBuilderList());
  }

  /**
   * Test {@link JobGroup#hasParallel()}.
   * <p>
   * Method under test: {@link JobGroup#hasParallel()}
   */
  @Test
  @DisplayName("Test hasParallel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.hasParallel()"})
  void testHasParallel() {
    // Arrange, Act and Assert
    assertFalse(JobGroup.getDefaultInstance().hasParallel());
  }

  /**
   * Test {@link JobGroup#getParallel()}.
   * <p>
   * Method under test: {@link JobGroup#getParallel()}
   */
  @Test
  @DisplayName("Test getParallel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParallelJobGroup JobGroup.getParallel()"})
  void testGetParallel() {
    // Arrange and Act
    ParallelJobGroup actualParallel = JobGroup.getDefaultInstance().getParallel();

    // Assert
    assertEquals("", actualParallel.getInitializationErrorString());
    assertEquals(0, actualParallel.getJobsCount());
    assertEquals(0, actualParallel.getSerializedSize());
    assertTrue(actualParallel.findInitializationErrors().isEmpty());
    List<JobDefinition> jobsList = actualParallel.getJobsList();
    assertTrue(jobsList.isEmpty());
    assertTrue(actualParallel.getAllFields().isEmpty());
    assertTrue(actualParallel.isInitialized());
    assertSame(actualParallel, actualParallel.getDefaultInstanceForType());
    assertSame(jobsList, actualParallel.getJobsOrBuilderList());
  }

  /**
   * Test {@link JobGroup#isInitialized()}.
   * <p>
   * Method under test: {@link JobGroup#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobGroup.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link JobGroup#getSerializedSize()}.
   * <p>
   * Method under test: {@link JobGroup#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobGroup.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobGroup.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link JobGroup#equals(Object)}, and {@link JobGroup#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobGroup#equals(Object)}
   *   <li>{@link JobGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.equals(Object)", "int JobGroup.hashCode()"})
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
   * Test {@link JobGroup#equals(Object)}, and {@link JobGroup#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobGroup#equals(Object)}
   *   <li>{@link JobGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.equals(Object)", "int JobGroup.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobGroup defaultInstance = JobGroup.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link JobGroup#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.equals(Object)", "int JobGroup.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), 1);
  }

  /**
   * Test {@link JobGroup#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.equals(Object)", "int JobGroup.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), null);
  }

  /**
   * Test {@link JobGroup#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobGroup.equals(Object)", "int JobGroup.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobGroup.getDefaultInstance(), "Different type to JobGroup");
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupDetailsCase.forNumber(42));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code PARALLEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when three; then return 'PARALLEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenThree_thenReturnParallel() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.PARALLEL, JobGroupDetailsCase.forNumber(3));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SEQUENTIAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when two; then return 'SEQUENTIAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenTwo_thenReturnSequential() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.SEQUENTIAL, JobGroupDetailsCase.forNumber(2));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOBGROUPDETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when zero; then return 'JOBGROUPDETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenZero_thenReturnJobgroupdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroupDetailsCase.forNumber(0));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#getNumber()}.
   * <p>
   * Method under test: {@link JobGroupDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobGroupDetailsCase.getNumber()"})
  void testJobGroupDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobGroupDetailsCase.valueOf("SEQUENTIAL").getNumber());
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupDetailsCase.valueOf(42));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code PARALLEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase valueOf(int) with 'value'; when three; then return 'PARALLEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenThree_thenReturnParallel() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.PARALLEL, JobGroupDetailsCase.valueOf(3));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SEQUENTIAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase valueOf(int) with 'value'; when two; then return 'SEQUENTIAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenTwo_thenReturnSequential() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.SEQUENTIAL, JobGroupDetailsCase.valueOf(2));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOBGROUPDETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase valueOf(int) with 'value'; when zero; then return 'JOBGROUPDETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenZero_thenReturnJobgroupdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroupDetailsCase.valueOf(0));
  }

  /**
   * Test {@link JobGroup#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseFromResult.getJobGroupType());
    assertFalse(actualParseFromResult.hasParallel());
    assertFalse(actualParseFromResult.hasSequential());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobGroup.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobGroup.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    JobGroup actualParseFromResult = JobGroup.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ParallelJobGroup parallel = actualParseFromResult.getParallel();
    assertSame(unknownFields, parallel.getUnknownFields());
    SequentialJobGroup sequential = actualParseFromResult.getSequential();
    assertSame(unknownFields, sequential.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(parallel, actualParseFromResult.getParallelOrBuilder());
    assertSame(parallel, parallel.getDefaultInstanceForType());
    assertSame(sequential, actualParseFromResult.getSequentialOrBuilder());
    assertSame(sequential, sequential.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JobGroup actualParseFromResult = JobGroup.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ParallelJobGroup parallel = actualParseFromResult.getParallel();
    assertSame(unknownFields, parallel.getUnknownFields());
    SequentialJobGroup sequential = actualParseFromResult.getSequential();
    assertSame(unknownFields, sequential.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(parallel, actualParseFromResult.getParallelOrBuilder());
    assertSame(parallel, parallel.getDefaultInstanceForType());
    assertSame(sequential, actualParseFromResult.getSequentialOrBuilder());
    assertSame(sequential, sequential.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobGroup actualParseDelimitedFromResult = JobGroup.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseDelimitedFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseDelimitedFromResult.getJobGroupType());
    assertFalse(actualParseDelimitedFromResult.hasParallel());
    assertFalse(actualParseDelimitedFromResult.hasSequential());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobGroup.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test {@link JobGroup#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link JobGroup#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobGroup actualParseDelimitedFromResult = JobGroup.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getJobGroupTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualParseDelimitedFromResult.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualParseDelimitedFromResult.getJobGroupType());
    assertFalse(actualParseDelimitedFromResult.hasParallel());
    assertFalse(actualParseDelimitedFromResult.hasSequential());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobGroup#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobGroup.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobGroup#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroup#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
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
   * Test {@link JobGroup#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JobGroup#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobGroup.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    JobGroup defaultInstance = JobGroup.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}

package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobGroupTypeDiffblueTest {
  /**
   * Test {@link JobGroupType#getNumber()}.
   * <ul>
   *   <li>Given {@code JOB_GROUP_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'JOB_GROUP_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobGroupType.getNumber()"})
  void testGetNumber_givenJobGroupTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JobGroupType.JOB_GROUP_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link JobGroupType#getNumber()}.
   * <ul>
   *   <li>Given {@link JobGroupType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobGroupType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobGroupType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link JobGroupType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupType.valueOf(42));
  }

  /**
   * Test {@link JobGroupType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SEQUENTIAL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'SEQUENTIAL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnSequentialJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, JobGroupType.valueOf(1));
  }

  /**
   * Test {@link JobGroupType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code PARALLEL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'PARALLEL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnParallelJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, JobGroupType.valueOf(2));
  }

  /**
   * Test {@link JobGroupType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_GROUP_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'JOB_GROUP_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnJobGroupTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroupType.valueOf(0));
  }

  /**
   * Test {@link JobGroupType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupType.forNumber(42));
  }

  /**
   * Test {@link JobGroupType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SEQUENTIAL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'SEQUENTIAL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnSequentialJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, JobGroupType.forNumber(1));
  }

  /**
   * Test {@link JobGroupType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code PARALLEL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'PARALLEL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnParallelJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, JobGroupType.forNumber(2));
  }

  /**
   * Test {@link JobGroupType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_GROUP_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'JOB_GROUP_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroupType JobGroupType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnJobGroupTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroupType.forNumber(0));
  }

  /**
   * Test {@link JobGroupType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobGroupType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link JobGroupType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code SEQUENTIAL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'SEQUENTIAL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobGroupType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsSequentialJobGroup() {
    // Arrange and Act
    EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link JobGroupType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code PARALLEL_JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'PARALLEL_JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobGroupType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsParallelJobGroup() {
    // Arrange and Act
    EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link JobGroupType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code JOB_GROUP_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'JOB_GROUP_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobGroupType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsJobGroupTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link JobGroupType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link JobGroupType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobGroupType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobGroupType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link JobGroupType#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code JOB_GROUP_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobGroupType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'JOB_GROUP_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobGroupType.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsJobGroupTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = JobGroupType.JOB_GROUP_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("JOB_GROUP_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.JobGroupType.JOB_GROUP_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link JobGroupType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link JobGroupType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobGroupType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = JobGroupType.JOB_GROUP_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("JobGroupType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.JobGroupType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(2, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link JobGroupType#getDescriptor()}.
   * <p>
   * Method under test: {@link JobGroupType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobGroupType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = JobGroupType.getDescriptor();

    // Assert
    assertEquals("JobGroupType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.JobGroupType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

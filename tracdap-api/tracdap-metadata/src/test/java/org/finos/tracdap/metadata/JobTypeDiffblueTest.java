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

class JobTypeDiffblueTest {
  /**
   * Test {@link JobType#getNumber()}.
   * <ul>
   *   <li>Given {@code JOB_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'JOB_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobType.getNumber()"})
  void testGetNumber_givenJobTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JobType.JOB_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link JobType#getNumber()}.
   * <ul>
   *   <li>Given {@link JobType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code EXPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'EXPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnExportData() {
    // Arrange, Act and Assert
    assertEquals(JobType.EXPORT_DATA, JobType.valueOf(5));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobType.valueOf(42));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code IMPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'IMPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnImportData() {
    // Arrange, Act and Assert
    assertEquals(JobType.IMPORT_DATA, JobType.valueOf(4));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUN_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'RUN_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnRunModel() {
    // Arrange, Act and Assert
    assertEquals(JobType.RUN_MODEL, JobType.valueOf(1));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_GROUP, JobType.valueOf(6));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnImportModel() {
    // Arrange, Act and Assert
    assertEquals(JobType.IMPORT_MODEL, JobType.valueOf(3));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code RUN_FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'RUN_FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnRunFlow() {
    // Arrange, Act and Assert
    assertEquals(JobType.RUN_FLOW, JobType.valueOf(2));
  }

  /**
   * Test {@link JobType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'JOB_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnJobTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobType.valueOf(0));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code EXPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'EXPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenFive_thenReturnExportData() {
    // Arrange, Act and Assert
    assertEquals(JobType.EXPORT_DATA, JobType.forNumber(5));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobType.forNumber(42));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code IMPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'IMPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenFour_thenReturnImportData() {
    // Arrange, Act and Assert
    assertEquals(JobType.IMPORT_DATA, JobType.forNumber(4));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUN_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'RUN_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnRunModel() {
    // Arrange, Act and Assert
    assertEquals(JobType.RUN_MODEL, JobType.forNumber(1));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenSix_thenReturnJobGroup() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_GROUP, JobType.forNumber(6));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenThree_thenReturnImportModel() {
    // Arrange, Act and Assert
    assertEquals(JobType.IMPORT_MODEL, JobType.forNumber(3));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code RUN_FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'RUN_FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnRunFlow() {
    // Arrange, Act and Assert
    assertEquals(JobType.RUN_FLOW, JobType.forNumber(2));
  }

  /**
   * Test {@link JobType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'JOB_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnJobTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobType.forNumber(0));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code EXPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'EXPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsExportData() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.EXPORT_DATA, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code IMPORT_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'IMPORT_DATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsImportData() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.IMPORT_DATA, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code RUN_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'RUN_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsRunModel() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.RUN_MODEL, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code JOB_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'JOB_GROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsJobGroup() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsImportModel() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.IMPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code RUN_FLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'RUN_FLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsRunFlow() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.RUN_FLOW, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link JobType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code JOB_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'JOB_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsJobTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link JobType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code JOB_TYPE_NOT_SET}.</li>
   *   <li>Then return Name is {@code JOB_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'JOB_TYPE_NOT_SET'; then return Name is 'JOB_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobType.getValueDescriptor()"})
  void testGetValueDescriptor_givenJobTypeNotSet_thenReturnNameIsJobTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = JobType.JOB_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("JOB_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.JobType.JOB_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link JobType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link JobType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link JobType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link JobType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = JobType.JOB_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("JobType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.JobType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(7, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link JobType#getDescriptor()}.
   * <p>
   * Method under test: {@link JobType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = JobType.getDescriptor();

    // Assert
    assertEquals("JobType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.JobType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(7, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}

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

class JobStatusCodeDiffblueTest {
  /**
   * Test {@link JobStatusCode#getNumber()}.
   * <ul>
   *   <li>Given {@code JOB_STATUS_CODE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'JOB_STATUS_CODE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobStatusCode.getNumber()"})
  void testGetNumber_givenJobStatusCodeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JobStatusCode.JOB_STATUS_CODE_NOT_SET.getNumber());
  }

  /**
   * Test {@link JobStatusCode#getNumber()}.
   * <ul>
   *   <li>Given {@link JobStatusCode#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobStatusCode.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobStatusCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when CANCELLED_VALUE; then return 'CANCELLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenCancelled_value_thenReturnCancelled() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.CANCELLED, JobStatusCode.valueOf(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code SUCCEEDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when eight; then return 'SUCCEEDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenEight_thenReturnSucceeded() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.SUCCEEDED, JobStatusCode.valueOf(8));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link JobStatusCode#FAILED_VALUE}.</li>
   *   <li>Then return {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when FAILED_VALUE; then return 'FAILED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenFailed_value_thenReturnFailed() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.FAILED, JobStatusCode.valueOf(JobStatusCode.FAILED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'SUBMITTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnSubmitted() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.SUBMITTED, JobStatusCode.valueOf(5));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobStatusCode.valueOf(42));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code QUEUED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'QUEUED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnQueued() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.QUEUED, JobStatusCode.valueOf(4));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PREPARING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'PREPARING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnPreparing() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.PREPARING, JobStatusCode.valueOf(1));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code FINISHING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when seven; then return 'FINISHING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenSeven_thenReturnFinishing() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.FINISHING, JobStatusCode.valueOf(7));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code RUNNING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'RUNNING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnRunning() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.RUNNING, JobStatusCode.valueOf(6));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'PENDING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnPending() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.PENDING, JobStatusCode.valueOf(3));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code VALIDATED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'VALIDATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnValidated() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.VALIDATED, JobStatusCode.valueOf(2));
  }

  /**
   * Test {@link JobStatusCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_STATUS_CODE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'JOB_STATUS_CODE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnJobStatusCodeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, JobStatusCode.valueOf(0));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then return {@code CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when CANCELLED_VALUE; then return 'CANCELLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenCancelled_value_thenReturnCancelled() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.CANCELLED, JobStatusCode.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code SUCCEEDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when eight; then return 'SUCCEEDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenEight_thenReturnSucceeded() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.SUCCEEDED, JobStatusCode.forNumber(8));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#FAILED_VALUE}.</li>
   *   <li>Then return {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when FAILED_VALUE; then return 'FAILED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenFailed_value_thenReturnFailed() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.FAILED, JobStatusCode.forNumber(JobStatusCode.FAILED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'SUBMITTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenFive_thenReturnSubmitted() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.SUBMITTED, JobStatusCode.forNumber(5));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobStatusCode.forNumber(42));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code QUEUED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'QUEUED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenFour_thenReturnQueued() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.QUEUED, JobStatusCode.forNumber(4));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PREPARING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'PREPARING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenOne_thenReturnPreparing() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.PREPARING, JobStatusCode.forNumber(1));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code FINISHING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when seven; then return 'FINISHING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenSeven_thenReturnFinishing() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.FINISHING, JobStatusCode.forNumber(7));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code RUNNING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'RUNNING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenSix_thenReturnRunning() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.RUNNING, JobStatusCode.forNumber(6));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'PENDING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenThree_thenReturnPending() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.PENDING, JobStatusCode.forNumber(3));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code VALIDATED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'VALIDATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnValidated() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.VALIDATED, JobStatusCode.forNumber(2));
  }

  /**
   * Test {@link JobStatusCode#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_STATUS_CODE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'JOB_STATUS_CODE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode JobStatusCode.forNumber(int)"})
  void testForNumber_whenZero_thenReturnJobStatusCodeNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, JobStatusCode.forNumber(0));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'CANCELLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsCancelled() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.CANCELLED,
        actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber eight is {@code SUCCEEDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber eight is 'SUCCEEDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberEightIsSucceeded() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.SUCCEEDED, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#FAILED_VALUE} is {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber FAILED_VALUE is 'FAILED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFailed_valueIsFailed() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.FAILED, actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.FAILED_VALUE));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'SUBMITTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsSubmitted() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.SUBMITTED, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code QUEUED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'QUEUED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsQueued() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.QUEUED, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber minus one is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber minus one is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberMinusOneIsNull() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(-1));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code PREPARING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'PREPARING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsPreparing() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.PREPARING, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber seven is {@code FINISHING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber seven is 'FINISHING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSevenIsFinishing() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.FINISHING, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code RUNNING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'RUNNING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsRunning() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.RUNNING, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'PENDING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsPending() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.PENDING, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code VALIDATED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'VALIDATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsValidated() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.VALIDATED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link JobStatusCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code JOB_STATUS_CODE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'JOB_STATUS_CODE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JobStatusCode.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsJobStatusCodeNotSet() {
    // Arrange and Act
    EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link JobStatusCode#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link JobStatusCode#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobStatusCode.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobStatusCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link JobStatusCode#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code JOB_STATUS_CODE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobStatusCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'JOB_STATUS_CODE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JobStatusCode.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsJobStatusCodeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = JobStatusCode.JOB_STATUS_CODE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("JOB_STATUS_CODE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.JobStatusCode.JOB_STATUS_CODE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link JobStatusCode#getDescriptorForType()}.
   * <p>
   * Method under test: {@link JobStatusCode#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobStatusCode.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = JobStatusCode.JOB_STATUS_CODE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("JobStatusCode", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.JobStatusCode", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertFalse(actualDescriptorForType.isClosed());
    assertEquals(ModelDefinition.PACKAGE_FIELD_NUMBER, actualDescriptorForType.getValues().size());
  }

  /**
   * Test {@link JobStatusCode#getDescriptor()}.
   * <p>
   * Method under test: {@link JobStatusCode#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor JobStatusCode.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = JobStatusCode.getDescriptor();

    // Assert
    assertEquals("JobStatusCode", actualDescriptor.getName());
    assertEquals("tracdap.metadata.JobStatusCode", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isClosed());
    assertEquals(ModelDefinition.PACKAGE_FIELD_NUMBER, actualDescriptor.getValues().size());
  }
}

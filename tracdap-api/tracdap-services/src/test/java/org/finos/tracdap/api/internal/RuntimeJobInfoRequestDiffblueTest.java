package org.finos.tracdap.api.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.api.internal.RuntimeJobInfoRequest.JobCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuntimeJobInfoRequestDiffblueTest {
  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobCase.forNumber(42));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code JOBSELECTOR}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when one; then return 'JOBSELECTOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenOne_thenReturnJobselector() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBSELECTOR, JobCase.forNumber(1));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code JOBKEY}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when two; then return 'JOBKEY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenTwo_thenReturnJobkey() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBKEY, JobCase.forNumber(2));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOB_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when zero; then return 'JOB_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenZero_thenReturnJobNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOB_NOT_SET, JobCase.forNumber(0));
  }

  /**
   * Test JobCase {@link JobCase#getNumber()}.
   *
   * <p>Method under test: {@link JobCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JobCase.getNumber()"})
  void testJobCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, JobCase.valueOf("JOBSELECTOR").getNumber());
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobCase.valueOf(42));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code JOBSELECTOR}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when one; then return 'JOBSELECTOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenOne_thenReturnJobselector() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBSELECTOR, JobCase.valueOf(1));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code JOBKEY}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when two; then return 'JOBKEY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenTwo_thenReturnJobkey() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBKEY, JobCase.valueOf(2));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOB_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when zero; then return 'JOB_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenZero_thenReturnJobNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOB_NOT_SET, JobCase.valueOf(0));
  }
}

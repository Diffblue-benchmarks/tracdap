package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.JobGroup.JobGroupDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobGroupDiffblueTest {
  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupDetailsCase.forNumber(42));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code PARALLEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when three; then return 'PARALLEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenThree_thenReturnParallel() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.PARALLEL, JobGroupDetailsCase.forNumber(3));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code SEQUENTIAL}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase forNumber(int); when two; then return 'SEQUENTIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenTwo_thenReturnSequential() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.SEQUENTIAL, JobGroupDetailsCase.forNumber(2));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOBGROUPDETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test JobGroupDetailsCase forNumber(int); when zero; then return 'JOBGROUPDETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.forNumber(int)"})
  void testJobGroupDetailsCaseForNumber_whenZero_thenReturnJobgroupdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroupDetailsCase.forNumber(0));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#getNumber()}.
   *
   * <p>Method under test: {@link JobGroupDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobGroupDetailsCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JobGroupDetailsCase.getNumber()"})
  void testJobGroupDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobGroupDetailsCase.valueOf("SEQUENTIAL").getNumber());
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobGroupDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobGroupDetailsCase.valueOf(42));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code PARALLEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobGroupDetailsCase valueOf(int) with 'value'; when three; then return 'PARALLEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenThree_thenReturnParallel() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.PARALLEL, JobGroupDetailsCase.valueOf(3));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code SEQUENTIAL}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobGroupDetailsCase valueOf(int) with 'value'; when two; then return 'SEQUENTIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenTwo_thenReturnSequential() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.SEQUENTIAL, JobGroupDetailsCase.valueOf(2));
  }

  /**
   * Test JobGroupDetailsCase {@link JobGroupDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOBGROUPDETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobGroupDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobGroupDetailsCase valueOf(int) with 'value'; when zero; then return 'JOBGROUPDETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobGroupDetailsCase JobGroupDetailsCase.valueOf(int)"})
  void testJobGroupDetailsCaseValueOfWithValue_whenZero_thenReturnJobgroupdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, JobGroupDetailsCase.valueOf(0));
  }
}

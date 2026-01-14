package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.JobDefinition.JobDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JobDefinitionDiffblueTest {
  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code IMPORTDATA}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when five; then return 'IMPORTDATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFive_thenReturnImportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTDATA, JobDetailsCase.forNumber(5));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobDetailsCase.forNumber(42));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code IMPORTMODEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when four; then return 'IMPORTMODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFour_thenReturnImportmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTMODEL, JobDetailsCase.forNumber(4));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code JOBGROUP}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when seven; then return 'JOBGROUP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenSeven_thenReturnJobgroup() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBGROUP, JobDetailsCase.forNumber(7));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code EXPORTDATA}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when six; then return 'EXPORTDATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenSix_thenReturnExportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.EXPORTDATA, JobDetailsCase.forNumber(6));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code RUNFLOW}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when three; then return 'RUNFLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenThree_thenReturnRunflow() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNFLOW, JobDetailsCase.forNumber(3));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code RUNMODEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when two; then return 'RUNMODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenTwo_thenReturnRunmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNMODEL, JobDetailsCase.forNumber(2));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOBDETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when zero; then return 'JOBDETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenZero_thenReturnJobdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, JobDetailsCase.forNumber(0));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#getNumber()}.
   *
   * <p>Method under test: {@link JobDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobDetailsCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JobDetailsCase.getNumber()"})
  void testJobDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobDetailsCase.valueOf("RUNMODEL").getNumber());
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code IMPORTDATA}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when five; then return 'IMPORTDATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFive_thenReturnImportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTDATA, JobDetailsCase.valueOf(5));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobDetailsCase.valueOf(42));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code IMPORTMODEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobDetailsCase valueOf(int) with 'value'; when four; then return 'IMPORTMODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFour_thenReturnImportmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTMODEL, JobDetailsCase.valueOf(4));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code JOBGROUP}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when seven; then return 'JOBGROUP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenSeven_thenReturnJobgroup() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBGROUP, JobDetailsCase.valueOf(7));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code EXPORTDATA}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when six; then return 'EXPORTDATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenSix_thenReturnExportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.EXPORTDATA, JobDetailsCase.valueOf(6));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code RUNFLOW}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when three; then return 'RUNFLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenThree_thenReturnRunflow() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNFLOW, JobDetailsCase.valueOf(3));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code RUNMODEL}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when two; then return 'RUNMODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenTwo_thenReturnRunmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNMODEL, JobDetailsCase.valueOf(2));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code JOBDETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test JobDetailsCase valueOf(int) with 'value'; when zero; then return 'JOBDETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenZero_thenReturnJobdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, JobDetailsCase.valueOf(0));
  }
}

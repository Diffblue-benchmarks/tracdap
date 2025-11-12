package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectDefinitionDiffblueTest {
  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.
   *   <li>Then return {@code RESULT}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when CANCELLED_VALUE; then return 'RESULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenCancelled_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.RESULT, DefinitionCase.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code STORAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when eight; then return 'STORAGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenEight_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.STORAGE, DefinitionCase.forNumber(8));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code JOB}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when five; then return 'JOB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFive_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.JOB, DefinitionCase.forNumber(5));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefinitionCase.forNumber(42));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when four; then return 'FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenFour_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FLOW, DefinitionCase.forNumber(4));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when MAP_VALUE; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenMap_value_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.SCHEMA, DefinitionCase.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code CUSTOM}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when seven; then return 'CUSTOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenSeven_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.CUSTOM, DefinitionCase.forNumber(7));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code FILE}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when six; then return 'FILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenSix_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FILE, DefinitionCase.forNumber(6));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code MODEL}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when three; then return 'MODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenThree_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.MODEL, DefinitionCase.forNumber(3));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when two; then return 'DATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenTwo_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DATA, DefinitionCase.forNumber(2));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code DEFINITION_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase forNumber(int); when zero; then return 'DEFINITION_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.forNumber(int)"})
  void testDefinitionCaseForNumber_whenZero_thenReturnDefinitionNotSet() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, DefinitionCase.forNumber(0));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#getNumber()}.
   *
   * <p>Method under test: {@link DefinitionCase#getNumber()}
   */
  @Test
  @DisplayName("Test DefinitionCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefinitionCase.getNumber()"})
  void testDefinitionCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, DefinitionCase.valueOf("DATA").getNumber());
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.
   *   <li>Then return {@code RESULT}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test DefinitionCase valueOf(int) with 'value'; when CANCELLED_VALUE; then return 'RESULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenCancelled_value_thenReturnResult() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.RESULT, DefinitionCase.valueOf(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code STORAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when eight; then return 'STORAGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenEight_thenReturnStorage() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.STORAGE, DefinitionCase.valueOf(8));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code JOB}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when five; then return 'JOB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFive_thenReturnJob() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.JOB, DefinitionCase.valueOf(5));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefinitionCase.valueOf(42));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when four; then return 'FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenFour_thenReturnFlow() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FLOW, DefinitionCase.valueOf(4));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test DefinitionCase valueOf(int) with 'value'; when MAP_VALUE; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenMap_value_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.SCHEMA, DefinitionCase.valueOf(BasicType.MAP_VALUE));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code CUSTOM}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when seven; then return 'CUSTOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenSeven_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.CUSTOM, DefinitionCase.valueOf(7));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code FILE}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when six; then return 'FILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenSix_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.FILE, DefinitionCase.valueOf(6));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code MODEL}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when three; then return 'MODEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenThree_thenReturnModel() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.MODEL, DefinitionCase.valueOf(3));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test DefinitionCase valueOf(int) with 'value'; when two; then return 'DATA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenTwo_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DATA, DefinitionCase.valueOf(2));
  }

  /**
   * Test DefinitionCase {@link DefinitionCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code DEFINITION_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link DefinitionCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test DefinitionCase valueOf(int) with 'value'; when zero; then return 'DEFINITION_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefinitionCase DefinitionCase.valueOf(int)"})
  void testDefinitionCaseValueOfWithValue_whenZero_thenReturnDefinitionNotSet() {
    // Arrange, Act and Assert
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, DefinitionCase.valueOf(0));
  }
}

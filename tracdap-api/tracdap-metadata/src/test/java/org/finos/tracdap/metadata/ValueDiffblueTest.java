package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.Value.ValueCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValueDiffblueTest {
  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.
   *   <li>Then return {@code MAPVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when CANCELLED_VALUE; then return 'MAPVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenCancelled_value_thenReturnMapvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.MAPVALUE, ValueCase.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code DATETIMEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when eight; then return 'DATETIMEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenEight_thenReturnDatetimevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATETIMEVALUE, ValueCase.forNumber(8));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code STRINGVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when five; then return 'STRINGVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFive_thenReturnStringvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRINGVALUE, ValueCase.forNumber(5));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.forNumber(42));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code FLOATVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when four; then return 'FLOATVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenFour_thenReturnFloatvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOATVALUE, ValueCase.forNumber(4));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.
   *   <li>Then return {@code ARRAYVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when MAP_VALUE; then return 'ARRAYVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenMap_value_thenReturnArrayvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.ARRAYVALUE, ValueCase.forNumber(BasicType.MAP_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code DATEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when seven; then return 'DATEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenSeven_thenReturnDatevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATEVALUE, ValueCase.forNumber(7));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code DECIMALVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when six; then return 'DECIMALVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenSix_thenReturnDecimalvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DECIMALVALUE, ValueCase.forNumber(6));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INTEGERVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when three; then return 'INTEGERVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenThree_thenReturnIntegervalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INTEGERVALUE, ValueCase.forNumber(3));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when two; then return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenTwo_thenReturnBooleanvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEANVALUE, ValueCase.forNumber(2));
  }

  /**
   * Test ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.forNumber(0));
  }

  /**
   * Test ValueCase {@link ValueCase#getNumber()}.
   *
   * <p>Method under test: {@link ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test ValueCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ValueCase.getNumber()"})
  void testValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, ValueCase.valueOf("BOOLEANVALUE").getNumber());
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.
   *   <li>Then return {@code MAPVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ValueCase valueOf(int) with 'value'; when CANCELLED_VALUE; then return 'MAPVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenCancelled_value_thenReturnMapvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.MAPVALUE, ValueCase.valueOf(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code DATETIMEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when eight; then return 'DATETIMEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenEight_thenReturnDatetimevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATETIMEVALUE, ValueCase.valueOf(8));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code STRINGVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when five; then return 'STRINGVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFive_thenReturnStringvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRINGVALUE, ValueCase.valueOf(5));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.valueOf(42));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code FLOATVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when four; then return 'FLOATVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenFour_thenReturnFloatvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOATVALUE, ValueCase.valueOf(4));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BasicType#MAP_VALUE}.
   *   <li>Then return {@code ARRAYVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when MAP_VALUE; then return 'ARRAYVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenMap_value_thenReturnArrayvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.ARRAYVALUE, ValueCase.valueOf(BasicType.MAP_VALUE));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code DATEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when seven; then return 'DATEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenSeven_thenReturnDatevalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATEVALUE, ValueCase.valueOf(7));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code DECIMALVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when six; then return 'DECIMALVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenSix_thenReturnDecimalvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DECIMALVALUE, ValueCase.valueOf(6));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INTEGERVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when three; then return 'INTEGERVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenThree_thenReturnIntegervalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INTEGERVALUE, ValueCase.valueOf(3));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code BOOLEANVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when two; then return 'BOOLEANVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenTwo_thenReturnBooleanvalue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEANVALUE, ValueCase.valueOf(2));
  }

  /**
   * Test ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ValueCase valueOf(int) with 'value'; when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testValueCaseValueOfWithValue_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.valueOf(0));
  }
}

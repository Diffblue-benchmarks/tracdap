package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.SearchExpression.ExprCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SearchExpressionDiffblueTest {
  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ExprCase.forNumber(42));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code TERM}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when one; then return 'TERM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenOne_thenReturnTerm() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.TERM, ExprCase.forNumber(1));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code LOGICAL}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when two; then return 'LOGICAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenTwo_thenReturnLogical() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.LOGICAL, ExprCase.forNumber(2));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code EXPR_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when zero; then return 'EXPR_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenZero_thenReturnExprNotSet() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.EXPR_NOT_SET, ExprCase.forNumber(0));
  }

  /**
   * Test ExprCase {@link ExprCase#getNumber()}.
   *
   * <p>Method under test: {@link ExprCase#getNumber()}
   */
  @Test
  @DisplayName("Test ExprCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExprCase.getNumber()"})
  void testExprCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, ExprCase.valueOf("TERM").getNumber());
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ExprCase.valueOf(42));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code TERM}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when one; then return 'TERM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenOne_thenReturnTerm() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.TERM, ExprCase.valueOf(1));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code LOGICAL}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when two; then return 'LOGICAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenTwo_thenReturnLogical() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.LOGICAL, ExprCase.valueOf(2));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code EXPR_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when zero; then return 'EXPR_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenZero_thenReturnExprNotSet() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.EXPR_NOT_SET, ExprCase.valueOf(0));
  }
}

package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.ModelOutputSchema.RequirementCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ModelOutputSchemaDiffblueTest {
  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequirementCase.forNumber(42));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when one; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenOne_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.SCHEMA, RequirementCase.forNumber(1));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code FILETYPE}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when seven; then return 'FILETYPE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenSeven_thenReturnFiletype() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.FILETYPE, RequirementCase.forNumber(7));
  }

  /**
   * Test RequirementCase {@link RequirementCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code REQUIREMENT_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test RequirementCase forNumber(int); when zero; then return 'REQUIREMENT_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.forNumber(int)"})
  void testRequirementCaseForNumber_whenZero_thenReturnRequirementNotSet() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, RequirementCase.forNumber(0));
  }

  /**
   * Test RequirementCase {@link RequirementCase#getNumber()}.
   *
   * <p>Method under test: {@link RequirementCase#getNumber()}
   */
  @Test
  @DisplayName("Test RequirementCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RequirementCase.getNumber()"})
  void testRequirementCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, RequirementCase.valueOf("SCHEMA").getNumber());
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequirementCase.valueOf(42));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when one; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenOne_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.SCHEMA, RequirementCase.valueOf(1));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code FILETYPE}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test RequirementCase valueOf(int) with 'value'; when seven; then return 'FILETYPE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenSeven_thenReturnFiletype() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.FILETYPE, RequirementCase.valueOf(7));
  }

  /**
   * Test RequirementCase {@link RequirementCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code REQUIREMENT_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link RequirementCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test RequirementCase valueOf(int) with 'value'; when zero; then return 'REQUIREMENT_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequirementCase RequirementCase.valueOf(int)"})
  void testRequirementCaseValueOfWithValue_whenZero_thenReturnRequirementNotSet() {
    // Arrange, Act and Assert
    assertEquals(RequirementCase.REQUIREMENT_NOT_SET, RequirementCase.valueOf(0));
  }
}

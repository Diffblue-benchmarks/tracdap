package org.finos.tracdap.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.api.DataWriteRequest.SchemaSpecifierCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWriteRequestDiffblueTest {
  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when five; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFive_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.forNumber(5));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaSpecifierCase.forNumber(42));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code SCHEMAID}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when four; then return 'SCHEMAID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFour_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.forNumber(4));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code SCHEMASPECIFIER_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaSpecifierCase forNumber(int); when zero; then return 'SCHEMASPECIFIER_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenZero_thenReturnSchemaspecifierNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, SchemaSpecifierCase.forNumber(0));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#getNumber()}.
   *
   * <p>Method under test: {@link SchemaSpecifierCase#getNumber()}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SchemaSpecifierCase.getNumber()"})
  void testSchemaSpecifierCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(4, SchemaSpecifierCase.valueOf("SCHEMAID").getNumber());
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code SCHEMA}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaSpecifierCase valueOf(int) with 'value'; when five; then return 'SCHEMA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFive_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.valueOf(5));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaSpecifierCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaSpecifierCase.valueOf(42));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code SCHEMAID}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaSpecifierCase valueOf(int) with 'value'; when four; then return 'SCHEMAID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFour_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.valueOf(4));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code SCHEMASPECIFIER_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaSpecifierCase valueOf(int) with 'value'; when zero; then return 'SCHEMASPECIFIER_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenZero_thenReturnSchemaspecifierNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, SchemaSpecifierCase.valueOf(0));
  }
}

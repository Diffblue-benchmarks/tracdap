package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SchemaDefinitionDiffblueTest {
  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaDetailsCase.forNumber(42));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code STRUCT}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when four; then return 'STRUCT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenFour_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.STRUCT, SchemaDetailsCase.forNumber(4));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase forNumber(int); when three; then return 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenThree_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.TABLE, SchemaDetailsCase.forNumber(3));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code SCHEMADETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaDetailsCase forNumber(int); when zero; then return 'SCHEMADETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.forNumber(int)"})
  void testSchemaDetailsCaseForNumber_whenZero_thenReturnSchemadetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, SchemaDetailsCase.forNumber(0));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#getNumber()}.
   *
   * <p>Method under test: {@link SchemaDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SchemaDetailsCase.getNumber()"})
  void testSchemaDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, SchemaDetailsCase.valueOf("TABLE").getNumber());
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaDetailsCase.valueOf(42));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code STRUCT}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when four; then return 'STRUCT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenFour_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.STRUCT, SchemaDetailsCase.valueOf(4));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaDetailsCase valueOf(int) with 'value'; when three; then return 'TABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenThree_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.TABLE, SchemaDetailsCase.valueOf(3));
  }

  /**
   * Test SchemaDetailsCase {@link SchemaDetailsCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code SCHEMADETAILS_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test SchemaDetailsCase valueOf(int) with 'value'; when zero; then return 'SCHEMADETAILS_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDetailsCase SchemaDetailsCase.valueOf(int)"})
  void testSchemaDetailsCaseValueOfWithValue_whenZero_thenReturnSchemadetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, SchemaDetailsCase.valueOf(0));
  }
}

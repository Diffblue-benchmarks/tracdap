package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagSelectorDiffblueTest {
  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code OBJECTASOF}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when five; then return 'OBJECTASOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFive_thenReturnObjectasof() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTASOF, ObjectCriteriaCase.forNumber(5));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectCriteriaCase.forNumber(42));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code OBJECTVERSION}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when four; then return 'OBJECTVERSION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFour_thenReturnObjectversion() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, ObjectCriteriaCase.forNumber(4));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code LATESTOBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when three; then return 'LATESTOBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenThree_thenReturnLatestobject() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.LATESTOBJECT, ObjectCriteriaCase.forNumber(3));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code OBJECTCRITERIA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase forNumber(int); when zero; then return 'OBJECTCRITERIA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenZero_thenReturnObjectcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, ObjectCriteriaCase.forNumber(0));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#getNumber()}.
   *
   * <p>Method under test: {@link ObjectCriteriaCase#getNumber()}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ObjectCriteriaCase.getNumber()"})
  void testObjectCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, ObjectCriteriaCase.valueOf("LATESTOBJECT").getNumber());
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code OBJECTASOF}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase valueOf(int) with 'value'; when five; then return 'OBJECTASOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFive_thenReturnObjectasof() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTASOF, ObjectCriteriaCase.valueOf(5));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectCriteriaCase.valueOf(42));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code OBJECTVERSION}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase valueOf(int) with 'value'; when four; then return 'OBJECTVERSION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFour_thenReturnObjectversion() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, ObjectCriteriaCase.valueOf(4));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code LATESTOBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase valueOf(int) with 'value'; when three; then return 'LATESTOBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenThree_thenReturnLatestobject() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.LATESTOBJECT, ObjectCriteriaCase.valueOf(3));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code OBJECTCRITERIA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test ObjectCriteriaCase valueOf(int) with 'value'; when zero; then return 'OBJECTCRITERIA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenZero_thenReturnObjectcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, ObjectCriteriaCase.valueOf(0));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code TAGASOF}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when eight; then return 'TAGASOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenEight_thenReturnTagasof() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGASOF, TagCriteriaCase.forNumber(8));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagCriteriaCase.forNumber(42));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code TAGVERSION}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when seven; then return 'TAGVERSION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenSeven_thenReturnTagversion() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGVERSION, TagCriteriaCase.forNumber(7));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code LATESTTAG}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when six; then return 'LATESTTAG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenSix_thenReturnLatesttag() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.LATESTTAG, TagCriteriaCase.forNumber(6));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code TAGCRITERIA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when zero; then return 'TAGCRITERIA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenZero_thenReturnTagcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, TagCriteriaCase.forNumber(0));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#getNumber()}.
   *
   * <p>Method under test: {@link TagCriteriaCase#getNumber()}
   */
  @Test
  @DisplayName("Test TagCriteriaCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TagCriteriaCase.getNumber()"})
  void testTagCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(6, TagCriteriaCase.valueOf("LATESTTAG").getNumber());
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code TAGASOF}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when eight; then return 'TAGASOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenEight_thenReturnTagasof() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGASOF, TagCriteriaCase.valueOf(8));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagCriteriaCase.valueOf(42));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code TAGVERSION}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test TagCriteriaCase valueOf(int) with 'value'; when seven; then return 'TAGVERSION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenSeven_thenReturnTagversion() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGVERSION, TagCriteriaCase.valueOf(7));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code LATESTTAG}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when six; then return 'LATESTTAG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenSix_thenReturnLatesttag() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.LATESTTAG, TagCriteriaCase.valueOf(6));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code TAGCRITERIA_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test TagCriteriaCase valueOf(int) with 'value'; when zero; then return 'TAGCRITERIA_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenZero_thenReturnTagcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, TagCriteriaCase.valueOf(0));
  }
}

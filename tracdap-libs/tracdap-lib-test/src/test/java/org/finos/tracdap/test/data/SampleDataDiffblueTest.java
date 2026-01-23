package org.finos.tracdap.test.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDateTime;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.BasicType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SampleDataDiffblueTest {
  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'BASIC_TYPE_NOT_SET'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenBasicTypeNotSet_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> SampleData.generateJavaValues(BasicType.BASIC_TYPE_NOT_SET, 1));
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'BOOLEAN'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenBoolean_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.BOOLEAN, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return first.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'BOOLEAN'; then return first")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenBoolean_thenReturnFirst() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.BOOLEAN, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    assertTrue((Boolean) actualGenerateJavaValuesResult.get(0));
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return not second.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'BOOLEAN'; then return not second")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenBoolean_thenReturnNotSecond() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.BOOLEAN, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    assertFalse((Boolean) actualGenerateJavaValuesResult.get(1));
    assertTrue((Boolean) actualGenerateJavaValuesResult.get(0));
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'DATE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDate_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.DATE, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return first toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'DATE'; then return first toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDate_thenReturnFirstToStringIs19700101() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.DATE, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    assertEquals("1970-01-01", actualGenerateJavaValuesResult.get(0).toString());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return second toString is {@code 1970-01-02}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'DATE'; then return second toString is '1970-01-02'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDate_thenReturnSecondToStringIs19700102() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.DATE, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    assertEquals("1970-01-01", actualGenerateJavaValuesResult.get(0).toString());
    assertEquals("1970-01-02", actualGenerateJavaValuesResult.get(1).toString());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATETIME}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'DATETIME'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDatetime_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DATETIME, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATETIME}.
   *   <li>Then return first toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'DATETIME'; then return first toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDatetime_thenReturnFirstToLocalTimeToStringIs0000() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DATETIME, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    Object getResult = actualGenerateJavaValuesResult.get(0);
    assertEquals("00:00", ((LocalDateTime) getResult).toLocalTime().toString());
    assertEquals("1970-01-01", ((LocalDateTime) getResult).toLocalDate().toString());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DATETIME}.
   *   <li>Then return second toLocalTime toString is {@code 00:00:01}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'DATETIME'; then return second toLocalTime toString is '00:00:01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDatetime_thenReturnSecondToLocalTimeToStringIs000001() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DATETIME, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    Object getResult = actualGenerateJavaValuesResult.get(0);
    assertEquals("00:00", ((LocalDateTime) getResult).toLocalTime().toString());
    Object getResult2 = actualGenerateJavaValuesResult.get(1);
    assertEquals("00:00:01", ((LocalDateTime) getResult2).toLocalTime().toString());
    assertEquals("1970-01-01", ((LocalDateTime) getResult).toLocalDate().toString());
    assertEquals("1970-01-01", ((LocalDateTime) getResult2).toLocalDate().toString());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'DECIMAL'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDecimal_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DECIMAL, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'DECIMAL'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDecimal_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DECIMAL, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'DECIMAL'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenDecimal_thenReturnSizeIsTwo() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.DECIMAL, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'FLOAT'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenFloat_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.FLOAT, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return first doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'FLOAT'; then return first doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenFloat_thenReturnFirstDoubleValueIsZero() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.FLOAT, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    assertEquals(0.0d, ((Double) actualGenerateJavaValuesResult.get(0)).doubleValue());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return second doubleValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'FLOAT'; then return second doubleValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenFloat_thenReturnSecondDoubleValueIsOne() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult = SampleData.generateJavaValues(BasicType.FLOAT, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    assertEquals(0.0d, ((Double) actualGenerateJavaValuesResult.get(0)).doubleValue());
    assertEquals(1.0d, ((Double) actualGenerateJavaValuesResult.get(1)).doubleValue());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'INTEGER'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenInteger_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.INTEGER, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return first longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'INTEGER'; then return first longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenInteger_thenReturnFirstLongValueIsZero() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.INTEGER, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    assertEquals(0L, ((Long) actualGenerateJavaValuesResult.get(0)).longValue());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return second longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'INTEGER'; then return second longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenInteger_thenReturnSecondLongValueIsOne() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.INTEGER, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    assertEquals(0L, ((Long) actualGenerateJavaValuesResult.get(0)).longValue());
    assertEquals(1L, ((Long) actualGenerateJavaValuesResult.get(1)).longValue());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName("Test generateJavaValues(BasicType, int); when 'STRING'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenString_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.STRING, 0);

    // Assert
    assertTrue(actualGenerateJavaValuesResult.isEmpty());
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return first is {@code Hello world 0}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'STRING'; then return first is 'Hello world 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenString_thenReturnFirstIsHelloWorld0() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.STRING, 1);

    // Assert
    assertEquals(1, actualGenerateJavaValuesResult.size());
    assertEquals("Hello world 0", actualGenerateJavaValuesResult.get(0));
  }

  /**
   * Test {@link SampleData#generateJavaValues(BasicType, int)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return second is {@code Hello world 1}.
   * </ul>
   *
   * <p>Method under test: {@link SampleData#generateJavaValues(BasicType, int)}
   */
  @Test
  @DisplayName(
      "Test generateJavaValues(BasicType, int); when 'STRING'; then return second is 'Hello world 1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleData.generateJavaValues(BasicType, int)"})
  void testGenerateJavaValues_whenString_thenReturnSecondIsHelloWorld1() {
    // Arrange and Act
    List<Object> actualGenerateJavaValuesResult =
        SampleData.generateJavaValues(BasicType.STRING, 2);

    // Assert
    assertEquals(2, actualGenerateJavaValuesResult.size());
    assertEquals("Hello world 0", actualGenerateJavaValuesResult.get(0));
    assertEquals("Hello world 1", actualGenerateJavaValuesResult.get(1));
  }
}

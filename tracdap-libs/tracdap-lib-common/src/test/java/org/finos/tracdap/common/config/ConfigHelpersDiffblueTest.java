package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigHelpersDiffblueTest {
  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code
   * context}, {@code properties}, {@code key}, {@code required}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_givenEmptyString() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "");

    // Act and Assert
    assertThrows(
        EStartup.class, () -> ConfigHelpers.readString("Context", properties, "Key", true));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code
   * context}, {@code properties}, {@code key}, {@code required}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; given 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_givenValue_thenReturnValue() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "Value");

    // Act
    String actualReadStringResult = ConfigHelpers.readString("Context", properties, "Key", true);

    // Assert
    assertEquals("Value", actualReadStringResult);
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code
   * context}, {@code properties}, {@code key}, {@code required}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; when 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_whenFalse_thenReturnNull() {
    // Arrange and Act
    String actualReadStringResult =
        ConfigHelpers.readString("Context", new Properties(), "Key", false);

    // Assert
    assertNull(actualReadStringResult);
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code
   * context}, {@code properties}, {@code key}, {@code required}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; when Properties(); then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_whenProperties_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(
        EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key", true));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String)} with {@code context}, {@code
   * properties}, {@code key}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String) with 'context', 'properties', 'key'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String)"})
  void testReadStringWithContextPropertiesKey_givenEmptyString() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "");

    // Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", properties, "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String)} with {@code context}, {@code
   * properties}, {@code key}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String) with 'context', 'properties', 'key'; given 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String)"})
  void testReadStringWithContextPropertiesKey_givenValue_thenReturnValue() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "Value");

    // Act
    String actualReadStringResult = ConfigHelpers.readString("Context", properties, "Key");

    // Assert
    assertEquals("Value", actualReadStringResult);
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String)} with {@code context}, {@code
   * properties}, {@code key}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Properties, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Properties, String) with 'context', 'properties', 'key'; when Properties(); then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String)"})
  void testReadStringWithContextPropertiesKey_whenProperties_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(
        EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code
   * propertiesMap}, {@code key}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_givenEmptyString() {
    // Arrange
    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("Key", "");
    propertiesMap.putAll(new HashMap<>());

    // Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", propertiesMap, "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code
   * propertiesMap}, {@code key}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; when HashMap() 'Key' is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_whenHashMapKeyIs42_thenReturn42() {
    // Arrange
    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("Key", "42");
    propertiesMap.putAll(new HashMap<>());

    // Act
    String actualReadStringResult = ConfigHelpers.readString("Context", propertiesMap, "Key");

    // Assert
    assertEquals("42", actualReadStringResult);
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code
   * propertiesMap}, {@code key}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName(
      "Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; when HashMap(); then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_whenHashMap_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new HashMap<>(), "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link Properties#Properties()} {@code Key} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readStringOrDefault(String, Properties, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test readStringOrDefault(String, Properties, String, String); given empty string; when Properties() 'Key' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ConfigHelpers.readStringOrDefault(String, Properties, String, String)"
  })
  void testReadStringOrDefault_givenEmptyString_whenPropertiesKeyIsEmptyString() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "");

    // Act
    String actualReadStringOrDefaultResult =
        ConfigHelpers.readStringOrDefault("Context", properties, "Key", "42");

    // Assert
    assertEquals("42", actualReadStringOrDefaultResult);
  }

  /**
   * Test {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link Properties#Properties()} {@code Key} is {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readStringOrDefault(String, Properties, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test readStringOrDefault(String, Properties, String, String); given 'Value'; when Properties() 'Key' is 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ConfigHelpers.readStringOrDefault(String, Properties, String, String)"
  })
  void testReadStringOrDefault_givenValue_whenPropertiesKeyIsValue_thenReturnValue() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "Value");

    // Act
    String actualReadStringOrDefaultResult =
        ConfigHelpers.readStringOrDefault("Context", properties, "Key", "42");

    // Assert
    assertEquals("Value", actualReadStringOrDefaultResult);
  }

  /**
   * Test {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readStringOrDefault(String, Properties, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test readStringOrDefault(String, Properties, String, String); when Properties(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ConfigHelpers.readStringOrDefault(String, Properties, String, String)"
  })
  void testReadStringOrDefault_whenProperties_thenReturn42() {
    // Arrange and Act
    String actualReadStringOrDefaultResult =
        ConfigHelpers.readStringOrDefault("Context", new Properties(), "Key", "42");

    // Assert
    assertEquals("42", actualReadStringOrDefaultResult);
  }

  /**
   * Test {@link ConfigHelpers#readInt(String, Properties, String, int)} with {@code context},
   * {@code properties}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Properties#Properties()} {@code Key} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  @DisplayName(
      "Test readInt(String, Properties, String, int) with 'context', 'properties', 'key', 'defaultValue'; given '42'; when Properties() 'Key' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readInt(String, Properties, String, int)"})
  void testReadIntWithContextPropertiesKeyDefaultValue_given42_whenPropertiesKeyIs42() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "42");

    // Act
    int actualReadIntResult = ConfigHelpers.readInt("Context", properties, "Key", 42);

    // Assert
    assertEquals(42, actualReadIntResult);
  }

  /**
   * Test {@link ConfigHelpers#readInt(String, Properties, String, int)} with {@code context},
   * {@code properties}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  @DisplayName(
      "Test readInt(String, Properties, String, int) with 'context', 'properties', 'key', 'defaultValue'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readInt(String, Properties, String, int)"})
  void testReadIntWithContextPropertiesKeyDefaultValue_givenEmptyString() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "");

    // Act
    int actualReadIntResult = ConfigHelpers.readInt("Context", properties, "Key", 42);

    // Assert
    assertEquals(42, actualReadIntResult);
  }

  /**
   * Test {@link ConfigHelpers#readInt(String, Properties, String, int)} with {@code context},
   * {@code properties}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  @DisplayName(
      "Test readInt(String, Properties, String, int) with 'context', 'properties', 'key', 'defaultValue'; given 'Value'; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readInt(String, Properties, String, int)"})
  void testReadIntWithContextPropertiesKeyDefaultValue_givenValue_thenThrowEStartup() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "Value");

    // Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readInt("Context", properties, "Key", 42));
  }

  /**
   * Test {@link ConfigHelpers#readInt(String, Properties, String, int)} with {@code context},
   * {@code properties}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  @DisplayName(
      "Test readInt(String, Properties, String, int) with 'context', 'properties', 'key', 'defaultValue'; when Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readInt(String, Properties, String, int)"})
  void testReadIntWithContextPropertiesKeyDefaultValue_whenProperties() {
    // Arrange and Act
    int actualReadIntResult = ConfigHelpers.readInt("Context", new Properties(), "Key", 42);

    // Assert
    assertEquals(42, actualReadIntResult);
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link Properties#Properties()} {@code Key} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test optionalBoolean(String, Properties, String, boolean); given empty string; when Properties() 'Key' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_givenEmptyString_whenPropertiesKeyIsEmptyString() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "");

    // Act
    boolean actualOptionalBooleanResult =
        ConfigHelpers.optionalBoolean("Context", properties, "Key", true);

    // Assert
    assertTrue(actualOptionalBooleanResult);
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link Properties#Properties()} {@code Key} is {@code Value}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test optionalBoolean(String, Properties, String, boolean); given 'Value'; when Properties() 'Key' is 'Value'; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_givenValue_whenPropertiesKeyIsValue_thenThrowEStartup() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Key", "Value");

    // Act and Assert
    assertThrows(
        EStartup.class, () -> ConfigHelpers.optionalBoolean("Context", properties, "Key", true));
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test optionalBoolean(String, Properties, String, boolean); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_whenFalse_thenReturnFalse() {
    // Arrange and Act
    boolean actualOptionalBooleanResult =
        ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", false);

    // Assert
    assertFalse(actualOptionalBooleanResult);
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test optionalBoolean(String, Properties, String, boolean); when Properties(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_whenProperties_thenReturnTrue() {
    // Arrange and Act
    boolean actualOptionalBooleanResult =
        ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", true);

    // Assert
    assertTrue(actualOptionalBooleanResult);
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName(
      "Test readOrDefault(int, int) with 'int', 'int'; when forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readOrDefault(42, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ConfigHelpers.readOrDefault(1, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, ConfigHelpers.readOrDefault(3, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when zero; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenZero_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readOrDefault(0, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_when42() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault("42", "42"));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_whenNull() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault(null, "42"));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_whenSpace() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault(" ", "42"));
  }
}

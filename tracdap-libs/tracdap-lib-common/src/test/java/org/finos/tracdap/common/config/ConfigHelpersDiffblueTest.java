package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code context}, {@code properties}, {@code key}, {@code required}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName("Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; when 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ConfigHelpers.readString("Context", new Properties(), "Key", false));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String, boolean)} with {@code context}, {@code properties}, {@code key}, {@code required}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName("Test readString(String, Properties, String, boolean) with 'context', 'properties', 'key', 'required'; when 'Key'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String, boolean)"})
  void testReadStringWithContextPropertiesKeyRequired_whenKey_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key", true));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Properties, String)} with {@code context}, {@code properties}, {@code key}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Properties, String)}
   */
  @Test
  @DisplayName("Test readString(String, Properties, String) with 'context', 'properties', 'key'; when 'Key'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Properties, String)"})
  void testReadStringWithContextPropertiesKey_whenKey_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code propertiesMap}, {@code key}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName("Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; given '42'; when HashMap() '42' is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_given42_whenHashMap42Is42_thenReturn42() {
    // Arrange
    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("42", "42");

    // Act and Assert
    assertEquals("42", ConfigHelpers.readString("Context", propertiesMap, "42"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code propertiesMap}, {@code key}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName("Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_givenEmptyString() {
    // Arrange
    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("42", "");

    // Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", propertiesMap, "42"));
  }

  /**
   * Test {@link ConfigHelpers#readString(String, Map, String)} with {@code context}, {@code propertiesMap}, {@code key}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  @DisplayName("Test readString(String, Map, String) with 'context', 'propertiesMap', 'key'; when 'Key'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readString(String, Map, String)"})
  void testReadStringWithContextPropertiesMapKey_whenKey_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new HashMap<>(), "Key"));
  }

  /**
   * Test {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}
   */
  @Test
  @DisplayName("Test readStringOrDefault(String, Properties, String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readStringOrDefault(String, Properties, String, String)"})
  void testReadStringOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readStringOrDefault("Context", new Properties(), "Key", "42"));
  }

  /**
   * Test {@link ConfigHelpers#readInt(String, Properties, String, int)} with {@code context}, {@code properties}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  @DisplayName("Test readInt(String, Properties, String, int) with 'context', 'properties', 'key', 'defaultValue'; when 'Key'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConfigHelpers.readInt(String, Properties, String, int)"})
  void testReadIntWithContextPropertiesKeyDefaultValue_whenKey_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readInt("Context", new Properties(), "Key", 42));
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName("Test optionalBoolean(String, Properties, String, boolean); when 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", false));
  }

  /**
   * Test {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}
   */
  @Test
  @DisplayName("Test optionalBoolean(String, Properties, String, boolean); when 'Key'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConfigHelpers.optionalBoolean(String, Properties, String, boolean)"})
  void testOptionalBoolean_whenKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", true));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when forty-two; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readOrDefault(42, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ConfigHelpers.readOrDefault(1, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, ConfigHelpers.readOrDefault(3, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  @DisplayName("Test readOrDefault(int, int) with 'int', 'int'; when zero; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConfigHelpers.readOrDefault(int, int)"})
  void testReadOrDefaultWithIntInt_whenZero_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readOrDefault(0, 42));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_when42() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault("42", "42"));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault("", "42"));
  }

  /**
   * Test {@link ConfigHelpers#readOrDefault(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigHelpers#readOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test readOrDefault(String, String) with 'String', 'String'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ConfigHelpers.readOrDefault(String, String)"})
  void testReadOrDefaultWithStringString_whenNull() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readOrDefault(null, "42"));
  }
}

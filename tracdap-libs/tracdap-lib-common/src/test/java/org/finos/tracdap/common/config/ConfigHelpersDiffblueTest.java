package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConfigHelpersDiffblueTest {
  /**
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  void testReadString() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new HashMap<>(), "Key"));
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key"));
    assertThrows(EStartup.class, () -> ConfigHelpers.readString("Context", new Properties(), "Key", true));
    assertNull(ConfigHelpers.readString("Context", new Properties(), "Key", false));
  }

  /**
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  void testReadString2() {
    // Arrange
    BiFunction<String, String, String> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Apply");

    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("Missing required property [%s] for [%s]", "Missing required property [%s] for [%s]");
    propertiesMap.computeIfPresent("Missing required property [%s] for [%s]", biFunction);

    // Act
    String actualReadStringResult = ConfigHelpers.readString("Context", propertiesMap,
        "Missing required property [%s] for [%s]");

    // Assert
    verify(biFunction).apply(eq("Missing required property [%s] for [%s]"),
        eq("Missing required property [%s] for [%s]"));
    assertEquals("Apply", actualReadStringResult);
  }

  /**
   * Method under test: {@link ConfigHelpers#readString(String, Map, String)}
   */
  @Test
  void testReadString3() {
    // Arrange
    BiFunction<String, String, String> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<String>any())).thenReturn("");

    HashMap<String, String> propertiesMap = new HashMap<>();
    propertiesMap.put("Missing required property [%s] for [%s]", "Missing required property [%s] for [%s]");
    propertiesMap.computeIfPresent("Missing required property [%s] for [%s]", biFunction);

    // Act and Assert
    assertThrows(EStartup.class,
        () -> ConfigHelpers.readString("Context", propertiesMap, "Missing required property [%s] for [%s]"));
    verify(biFunction).apply(eq("Missing required property [%s] for [%s]"),
        eq("Missing required property [%s] for [%s]"));
  }

  /**
   * Method under test:
   * {@link ConfigHelpers#readStringOrDefault(String, Properties, String, String)}
   */
  @Test
  void testReadStringOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", ConfigHelpers.readStringOrDefault("Context", new Properties(), "Key", "42"));
  }

  /**
   * Method under test:
   * {@link ConfigHelpers#readInt(String, Properties, String, int)}
   */
  @Test
  void testReadInt() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readInt("Context", new Properties(), "Key", 42));
  }

  /**
   * Method under test:
   * {@link ConfigHelpers#optionalBoolean(String, Properties, String, boolean)}
   */
  @Test
  void testOptionalBoolean() {
    // Arrange, Act and Assert
    assertTrue(ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", true));
    assertFalse(ConfigHelpers.optionalBoolean("Context", new Properties(), "Key", false));
  }

  /**
   * Method under test: {@link ConfigHelpers#readOrDefault(int, int)}
   */
  @Test
  void testReadOrDefault() {
    // Arrange, Act and Assert
    assertEquals(42, ConfigHelpers.readOrDefault(42, 42));
    assertEquals(42, ConfigHelpers.readOrDefault(0, 42));
    assertEquals(3, ConfigHelpers.readOrDefault(3, 42));
    assertEquals(1, ConfigHelpers.readOrDefault(1, 42));
    assertEquals("42", ConfigHelpers.readOrDefault("42", "42"));
    assertEquals("42", ConfigHelpers.readOrDefault(null, "42"));
    assertEquals("42", ConfigHelpers.readOrDefault("", "42"));
  }
}

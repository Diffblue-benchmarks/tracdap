package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.MissingResourceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceHelpersDiffblueTest {
  /**
   * Test {@link ResourceHelpers#loadResourceAsByteString(String, Class)} with {@code resourcePath},
   * {@code clazz}.
   *
   * <p>Method under test: {@link ResourceHelpers#loadResourceAsByteString(String, Class)}
   */
  @Test
  @DisplayName("Test loadResourceAsByteString(String, Class) with 'resourcePath', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ResourceHelpers.loadResourceAsByteString(String, Class)"})
  void testLoadResourceAsByteStringWithResourcePathClazz() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        MissingResourceException.class,
        () -> ResourceHelpers.loadResourceAsByteString("Resource Path", clazz));
  }

  /**
   * Test {@link ResourceHelpers#loadResourceAsByteString(String)} with {@code resourcePath}.
   *
   * <ul>
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceHelpers#loadResourceAsByteString(String)}
   */
  @Test
  @DisplayName(
      "Test loadResourceAsByteString(String) with 'resourcePath'; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ResourceHelpers.loadResourceAsByteString(String)"})
  void testLoadResourceAsByteStringWithResourcePath_thenThrowMissingResourceException() {
    // Arrange, Act and Assert
    assertThrows(
        MissingResourceException.class,
        () -> ResourceHelpers.loadResourceAsByteString("Resource Path"));
  }

  /**
   * Test {@link ResourceHelpers#loadResourceAsString(String, Class)}.
   *
   * <p>Method under test: {@link ResourceHelpers#loadResourceAsString(String, Class)}
   */
  @Test
  @DisplayName("Test loadResourceAsString(String, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceHelpers.loadResourceAsString(String, Class)"})
  void testLoadResourceAsString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        MissingResourceException.class,
        () -> ResourceHelpers.loadResourceAsString("Resource Path", clazz));
  }

  /**
   * Test {@link ResourceHelpers#loadResourceAsBytes(String, Class)} with {@code resourcePath},
   * {@code clazz}.
   *
   * <ul>
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceHelpers#loadResourceAsBytes(String, Class)}
   */
  @Test
  @DisplayName(
      "Test loadResourceAsBytes(String, Class) with 'resourcePath', 'clazz'; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceHelpers.loadResourceAsBytes(String, Class)"})
  void testLoadResourceAsBytesWithResourcePathClazz_thenThrowMissingResourceException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        MissingResourceException.class,
        () -> ResourceHelpers.loadResourceAsBytes("Resource Path", clazz));
  }

  /**
   * Test {@link ResourceHelpers#loadResourceAsBytes(String)} with {@code resourcePath}.
   *
   * <ul>
   *   <li>Then throw {@link MissingResourceException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceHelpers#loadResourceAsBytes(String)}
   */
  @Test
  @DisplayName(
      "Test loadResourceAsBytes(String) with 'resourcePath'; then throw MissingResourceException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResourceHelpers.loadResourceAsBytes(String)"})
  void testLoadResourceAsBytesWithResourcePath_thenThrowMissingResourceException() {
    // Arrange, Act and Assert
    assertThrows(
        MissingResourceException.class, () -> ResourceHelpers.loadResourceAsBytes("Resource Path"));
  }
}

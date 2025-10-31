package org.finos.tracdap.common.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.MissingResourceException;
import org.junit.jupiter.api.Test;

class ResourceHelpersDiffblueTest {
  /**
   * Method under test: {@link ResourceHelpers#loadResourceAsByteString(String)}
   */
  @Test
  void testLoadResourceAsByteString() {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> ResourceHelpers.loadResourceAsByteString("Resource Path"));
  }

  /**
   * Method under test:
   * {@link ResourceHelpers#loadResourceAsByteString(String, Class)}
   */
  @Test
  void testLoadResourceAsByteString2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(MissingResourceException.class,
        () -> ResourceHelpers.loadResourceAsByteString("Resource Path", clazz));
  }

  /**
   * Method under test:
   * {@link ResourceHelpers#loadResourceAsString(String, Class)}
   */
  @Test
  void testLoadResourceAsString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(MissingResourceException.class, () -> ResourceHelpers.loadResourceAsString("Resource Path", clazz));
  }

  /**
   * Method under test: {@link ResourceHelpers#loadResourceAsBytes(String)}
   */
  @Test
  void testLoadResourceAsBytes() {
    // Arrange, Act and Assert
    assertThrows(MissingResourceException.class, () -> ResourceHelpers.loadResourceAsBytes("Resource Path"));
  }

  /**
   * Method under test: {@link ResourceHelpers#loadResourceAsBytes(String, Class)}
   */
  @Test
  void testLoadResourceAsBytes2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(MissingResourceException.class, () -> ResourceHelpers.loadResourceAsBytes("Resource Path", clazz));
  }
}

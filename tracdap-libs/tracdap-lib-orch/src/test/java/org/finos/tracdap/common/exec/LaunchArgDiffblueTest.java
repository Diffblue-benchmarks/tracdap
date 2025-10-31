package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;

class LaunchArgDiffblueTest {
  /**
   * Method under test: {@link LaunchArg#path(String, String)}
   */
  @Test
  void testPath() {
    // Arrange and Act
    LaunchArg actualPathResult = LaunchArg.path("Volume", "Path");

    // Assert
    assertEquals("Path", actualPathResult.getPathArg());
    assertEquals("Volume", actualPathResult.getPathVolume());
    assertEquals(LaunchArgType.PATH, actualPathResult.getArgType());
  }

  /**
   * Method under test: {@link LaunchArg#string(String)}
   */
  @Test
  void testString() {
    // Arrange and Act
    LaunchArg actualStringResult = LaunchArg.string("Arg");

    // Assert
    assertEquals("Arg", actualStringResult.getStringArg());
    assertEquals(LaunchArgType.STRING, actualStringResult.getArgType());
  }

  /**
   * Method under test: {@link LaunchArg#getArgType()}
   */
  @Test
  void testGetArgType() {
    // Arrange, Act and Assert
    assertEquals(LaunchArgType.STRING, LaunchArg.string("Arg").getArgType());
  }

  /**
   * Method under test: {@link LaunchArg#getStringArg()}
   */
  @Test
  void testGetStringArg() {
    // Arrange, Act and Assert
    assertEquals("Arg", LaunchArg.string("Arg").getStringArg());
    assertThrows(EUnexpected.class, () -> LaunchArg.path("Volume", "Path").getStringArg());
  }

  /**
   * Method under test: {@link LaunchArg#getPathVolume()}
   */
  @Test
  void testGetPathVolume() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> LaunchArg.string("Arg").getPathVolume());
    assertEquals("Unexpected internal error (this is a bug)",
        LaunchArg.path("Unexpected internal error (this is a bug)", "Unexpected internal error (this is a bug)")
            .getPathVolume());
  }

  /**
   * Method under test: {@link LaunchArg#getPathArg()}
   */
  @Test
  void testGetPathArg() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> LaunchArg.string("Arg").getPathArg());
    assertEquals("Unexpected internal error (this is a bug)",
        LaunchArg.path("Unexpected internal error (this is a bug)", "Unexpected internal error (this is a bug)")
            .getPathArg());
  }
}

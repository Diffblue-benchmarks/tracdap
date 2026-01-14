package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LaunchArgDiffblueTest {
  /**
   * Test {@link LaunchArg#path(String, String)}.
   *
   * <p>Method under test: {@link LaunchArg#path(String, String)}
   */
  @Test
  @DisplayName("Test path(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchArg LaunchArg.path(String, String)"})
  void testPath() {
    // Arrange and Act
    LaunchArg actualPathResult = LaunchArg.path("Volume", "Path");

    // Assert
    assertEquals("Path", actualPathResult.getPathArg());
    assertEquals("Volume", actualPathResult.getPathVolume());
    assertEquals(LaunchArgType.PATH, actualPathResult.getArgType());
  }

  /**
   * Test {@link LaunchArg#string(String)}.
   *
   * <p>Method under test: {@link LaunchArg#string(String)}
   */
  @Test
  @DisplayName("Test string(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchArg LaunchArg.string(String)"})
  void testString() {
    // Arrange and Act
    LaunchArg actualStringResult = LaunchArg.string("Arg");

    // Assert
    assertEquals("Arg", actualStringResult.getStringArg());
    assertEquals(LaunchArgType.STRING, actualStringResult.getArgType());
  }

  /**
   * Test {@link LaunchArg#getArgType()}.
   *
   * <p>Method under test: {@link LaunchArg#getArgType()}
   */
  @Test
  @DisplayName("Test getArgType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LaunchArgType LaunchArg.getArgType()"})
  void testGetArgType() {
    // Arrange, Act and Assert
    assertEquals(LaunchArgType.STRING, LaunchArg.string("Arg").getArgType());
  }

  /**
   * Test {@link LaunchArg#getStringArg()}.
   *
   * <ul>
   *   <li>Given path {@code Volume} and {@code Path}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getStringArg()}
   */
  @Test
  @DisplayName("Test getStringArg(); given path 'Volume' and 'Path'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getStringArg()"})
  void testGetStringArg_givenPathVolumeAndPath_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> LaunchArg.path("Volume", "Path").getStringArg());
  }

  /**
   * Test {@link LaunchArg#getStringArg()}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then return {@code Arg}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getStringArg()}
   */
  @Test
  @DisplayName("Test getStringArg(); given string 'Arg'; then return 'Arg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getStringArg()"})
  void testGetStringArg_givenStringArg_thenReturnArg() {
    // Arrange, Act and Assert
    assertEquals("Arg", LaunchArg.string("Arg").getStringArg());
  }

  /**
   * Test {@link LaunchArg#getPathVolume()}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getPathVolume()}
   */
  @Test
  @DisplayName("Test getPathVolume(); given string 'Arg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getPathVolume()"})
  void testGetPathVolume_givenStringArg_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> LaunchArg.string("Arg").getPathVolume());
  }

  /**
   * Test {@link LaunchArg#getPathVolume()}.
   *
   * <ul>
   *   <li>Then return {@code Unexpected internal error (this is a bug)}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getPathVolume()}
   */
  @Test
  @DisplayName("Test getPathVolume(); then return 'Unexpected internal error (this is a bug)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getPathVolume()"})
  void testGetPathVolume_thenReturnUnexpectedInternalErrorThisIsABug() {
    // Arrange, Act and Assert
    assertEquals(
        "Unexpected internal error (this is a bug)",
        LaunchArg.path(
                "Unexpected internal error (this is a bug)",
                "Unexpected internal error (this is a bug)")
            .getPathVolume());
  }

  /**
   * Test {@link LaunchArg#getPathArg()}.
   *
   * <ul>
   *   <li>Given string {@code Arg}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getPathArg()}
   */
  @Test
  @DisplayName("Test getPathArg(); given string 'Arg'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getPathArg()"})
  void testGetPathArg_givenStringArg_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> LaunchArg.string("Arg").getPathArg());
  }

  /**
   * Test {@link LaunchArg#getPathArg()}.
   *
   * <ul>
   *   <li>Then return {@code Unexpected internal error (this is a bug)}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchArg#getPathArg()}
   */
  @Test
  @DisplayName("Test getPathArg(); then return 'Unexpected internal error (this is a bug)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LaunchArg.getPathArg()"})
  void testGetPathArg_thenReturnUnexpectedInternalErrorThisIsABug() {
    // Arrange, Act and Assert
    assertEquals(
        "Unexpected internal error (this is a bug)",
        LaunchArg.path(
                "Unexpected internal error (this is a bug)",
                "Unexpected internal error (this is a bug)")
            .getPathArg());
  }
}

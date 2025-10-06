package org.finos.tracdap.test.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class ConfigHelpersDiffblueTest {
  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createDirectory(Path, FileAttribute[])} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files createDirectory(Path, FileAttribute[]) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesCreateDirectoryThrowIOException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createDirectory(Path, FileAttribute[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files createDirectory(Path, FileAttribute[]) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesCreateDirectoryThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#exists(Path, LinkOption[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files exists(Path, LinkOption[]) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesExistsThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenThrow(new RuntimeException());

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code false}.
   *   <li>Then calls {@link Files#copy(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files isDirectory(Path, LinkOption[]) return 'false'; then calls copy(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesIsDirectoryReturnFalse_thenCallsCopy() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult =
          ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(2, actualPrepareConfigResult.size());
      String expectedToStringResult =
          String.join(
              "",
              "file:",
              Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                  .toString()
                  .concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(0).toString());
      Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo");
      String expectedToStringResult2 = String.join("", "file:", getResult.toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(1).toString());
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code false}.
   *   <li>Then calls {@link Files#copy(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files isDirectory(Path, LinkOption[]) return 'false'; then calls copy(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesIsDirectoryReturnFalse_thenCallsCopy2() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult =
          ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
          atLeast(1));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(2, actualPrepareConfigResult.size());
      String expectedToStringResult =
          String.join(
              "",
              "file:",
              Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                  .toString()
                  .concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(0).toString());
      Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo");
      String expectedToStringResult2 = String.join("", "file:", getResult.toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(1).toString());
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files isDirectory(Path, LinkOption[]) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesIsDirectoryThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#readString(Path)} return {@code String}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files readString(Path) return 'String'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesReadStringReturnString_thenReturnSizeIsTwo() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult =
          ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(2, actualPrepareConfigResult.size());
      String expectedToStringResult =
          String.join(
              "",
              "file:",
              Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                  .toString()
                  .concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(0).toString());
      Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo");
      String expectedToStringResult2 = String.join("", "file:", getResult.toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(1).toString());
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#readString(Path)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given Files readString(Path) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFilesReadStringThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given 'foo'; when ArrayList() add 'foo'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFoo_whenArrayListAddFoo_thenThrowRuntimeException() throws Exception {
    // Arrange
    ArrayList<String> rootConfigFiles = new ArrayList<>();
    rootConfigFiles.add("foo");
    Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given 'foo'; when ArrayList() add 'foo'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenFoo_whenArrayListAddFoo_thenThrowRuntimeException2()
      throws Exception {
    // Arrange
    ArrayList<String> rootConfigFiles = new ArrayList<>();
    rootConfigFiles.add("foo");
    rootConfigFiles.add("foo");
    Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code /}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given '/'; when ArrayList() add '/'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenSlash_whenArrayListAddSlash_thenReturnSizeIsThree() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult =
          ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(3, actualPrepareConfigResult.size());
      assertEquals("file:/", actualPrepareConfigResult.get(0).toString());
      String expectedToStringResult =
          String.join(
              "",
              "file:",
              Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                  .toString()
                  .concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(1).toString());
      Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo");
      String expectedToStringResult2 = String.join("", "file:", getResult.toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(2).toString());
    }
  }

  /**
   * Test {@link ConfigHelpers#prepareConfig(List, Path, Map)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link HashMap#HashMap()} {@code /} is {@code /}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  @DisplayName(
      "Test prepareConfig(List, Path, Map); given '/'; when HashMap() '/' is '/'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConfigHelpers.prepareConfig(List, Path, Map)"})
  void testPrepareConfig_givenSlash_whenHashMapSlashIsSlash_thenReturnSizeIsTwo() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(),
                      Mockito.<Class<BasicFileAttributes>>any(),
                      isA(LinkOption[].class)))
          .thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      HashMap<String, String> substitutions = new HashMap<>();
      substitutions.put("/", "/");

      // Act
      List<URL> actualPrepareConfigResult =
          ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, substitutions);

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(2, actualPrepareConfigResult.size());
      String expectedToStringResult =
          String.join(
              "",
              "file:",
              Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
                  .toString()
                  .concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(0).toString());
      Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo");
      String expectedToStringResult2 = String.join("", "file:", getResult.toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(1).toString());
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createDirectory(Path, FileAttribute[])} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); given Files createDirectory(Path, FileAttribute[]) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_givenFilesCreateDirectoryThrowIOException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              ConfigHelpers.copyConfigDir(
                  Paths.get(System.getProperty("java.io.tmpdir"), ""),
                  Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createDirectory(Path, FileAttribute[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); given Files createDirectory(Path, FileAttribute[]) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_givenFilesCreateDirectoryThrowRuntimeException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              ConfigHelpers.copyConfigDir(
                  Paths.get(System.getProperty("java.io.tmpdir"), ""),
                  Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code false}.
   *   <li>Then calls {@link Files#copy(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); given Files isDirectory(Path, LinkOption[]) return 'false'; then calls copy(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_givenFilesIsDirectoryReturnFalse_thenCallsCopy() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act
      ConfigHelpers.copyConfigDir(
          Paths.get(System.getProperty("java.io.tmpdir"), ""),
          Paths.get(System.getProperty("java.io.tmpdir"), ""));

      // Assert
      mockFiles.verify(
          () -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); given Files isDirectory(Path, LinkOption[]) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_givenFilesIsDirectoryThrowRuntimeException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new RuntimeException());
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              ConfigHelpers.copyConfigDir(
                  Paths.get(System.getProperty("java.io.tmpdir"), ""),
                  Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#walk(Path, FileVisitOption[])} return {@link
   *       ArrayList#ArrayList()} stream.
   *   <li>Then calls {@link Files#walk(Path, FileVisitOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); given Files walk(Path, FileVisitOption[]) return ArrayList() stream; then calls walk(Path, FileVisitOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_givenFilesWalkReturnArrayListStream_thenCallsWalk() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act
      ConfigHelpers.copyConfigDir(
          Paths.get(System.getProperty("java.io.tmpdir"), ""),
          Paths.get(System.getProperty("java.io.tmpdir"), ""));

      // Assert
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link ConfigHelpers#copyConfigDir(Path, Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test copyConfigDir(Path, Path); when Property is 'java.io.tmpdir' is 'test.txt'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigHelpers.copyConfigDir(Path, Path)"})
  void testCopyConfigDir_whenPropertyIsJavaIoTmpdirIsTestTxt_thenThrowRuntimeException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ConfigHelpers.copyConfigDir(
                Paths.get(System.getProperty("java.io.tmpdir"), ""),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }
}

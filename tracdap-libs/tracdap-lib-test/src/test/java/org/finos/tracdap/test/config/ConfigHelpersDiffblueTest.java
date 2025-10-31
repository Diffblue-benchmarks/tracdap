package org.finos.tracdap.test.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mockStatic;
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
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class ConfigHelpersDiffblueTest {
  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig() throws Exception {
    // Arrange
    ArrayList<String> rootConfigFiles = new ArrayList<>();
    rootConfigFiles.add("Root Config Files");
    Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig2() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult = ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles
          .verify(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)));
      assertEquals(1, actualPrepareConfigResult.size());
      assertEquals("file:/", actualPrepareConfigResult.get(0).toString());
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig3() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenThrow(new IOException("/"));
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException("/"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenThrow(new IOException("/"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)))
          .thenThrow(new IOException("/"));
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(IOException.class, () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig4() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new RuntimeException("/"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig5() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException("/"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig6() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult = ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles
          .verify(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)));
      assertEquals(1, actualPrepareConfigResult.size());
      assertEquals("file:/", actualPrepareConfigResult.get(0).toString());
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig7() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("/");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      // Act
      List<URL> actualPrepareConfigResult = ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles
          .verify(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)));
      assertEquals(1, actualPrepareConfigResult.size());
      assertEquals("file:/", actualPrepareConfigResult.get(0).toString());
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig8() throws Exception {
    // Arrange
    ArrayList<String> rootConfigFiles = new ArrayList<>();
    rootConfigFiles.add("42");
    rootConfigFiles.add("foo");
    Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, new HashMap<>()));
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig9() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.readAttributes(Mockito.<Path>any(), Mockito.<Class<BasicFileAttributes>>any(),
          isA(LinkOption[].class))).thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      HashMap<String, String> substitutions = new HashMap<>();
      substitutions.put("42", "42");

      // Act
      List<URL> actualPrepareConfigResult = ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, substitutions);

      // Assert
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles.verify(
          () -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)),
          atLeast(1));
      assertEquals(2, actualPrepareConfigResult.size());
      String expectedToStringResult = String.join("", "file:",
          Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString().concat(File.separator));
      assertEquals(expectedToStringResult, actualPrepareConfigResult.get(0).toString());
      String expectedToStringResult2 = String.join("", "file:",
          Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "foo").toString());
      assertEquals(expectedToStringResult2, actualPrepareConfigResult.get(1).toString());
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#prepareConfig(List, Path, Map)}
   */
  @Test
  void testPrepareConfig10() throws Exception {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      mockFiles.when(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenThrow(new RuntimeException("/"));
      mockFiles.when(() -> Files.readString(Mockito.<Path>any())).thenReturn("String");
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.readAttributes(Mockito.<Path>any(), Mockito.<Class<BasicFileAttributes>>any(),
          isA(LinkOption[].class))).thenReturn(null);

      ArrayList<String> rootConfigFiles = new ArrayList<>();
      rootConfigFiles.add("");
      rootConfigFiles.add("foo");
      Path targetDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

      HashMap<String, String> substitutions = new HashMap<>();
      substitutions.put("42", "42");

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> ConfigHelpers.prepareConfig(rootConfigFiles, targetDir, substitutions));
      mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readString(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
      mockFiles
          .verify(() -> Files.writeString(Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  void testCopyConfigDir() throws IOException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ConfigHelpers.copyConfigDir(Paths.get(System.getProperty("java.io.tmpdir"), ""),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  void testCopyConfigDir2() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);

      // Act
      ConfigHelpers.copyConfigDir(Paths.get(System.getProperty("java.io.tmpdir"), ""),
          Paths.get(System.getProperty("java.io.tmpdir"), ""));

      // Assert that nothing has changed
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  void testCopyConfigDir3() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new RuntimeException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> ConfigHelpers.copyConfigDir(Paths.get(System.getProperty("java.io.tmpdir"), ""),
              Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  void testCopyConfigDir4() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> ConfigHelpers.copyConfigDir(Paths.get(System.getProperty("java.io.tmpdir"), ""),
              Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Method under test: {@link ConfigHelpers#copyConfigDir(Path, Path)}
   */
  @Test
  void testCopyConfigDir5() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      // Arrange
      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Stream<Path> streamResult = pathList.stream();
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);
      mockFiles.when(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class))).thenReturn(streamResult);

      // Act
      ConfigHelpers.copyConfigDir(Paths.get(System.getProperty("java.io.tmpdir"), ""),
          Paths.get(System.getProperty("java.io.tmpdir"), ""));

      // Assert that nothing has changed
      mockFiles.verify(() -> Files.copy(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.walk(Mockito.<Path>any(), isA(FileVisitOption[].class)));
    }
  }
}

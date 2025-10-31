package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStorageConfig;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StorageManagerDiffblueTest {
  /**
   * Test {@link StorageManager#getDataStorage(String)}.
   * <p>
   * Method under test: {@link StorageManager#getDataStorage(String)}
   */
  @Test
  @DisplayName("Test getDataStorage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.storage.IDataStorage StorageManager.getDataStorage(String)"})
  void testGetDataStorage() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStorageConfig.class,
        () -> (new StorageManager(plugins,
            new ConfigManager("https://example.org/example", workingDir, new PluginManager())))
            .getDataStorage("Storage Key"));
  }

  /**
   * Test {@link StorageManager#getFileStorage(String)}.
   * <p>
   * Method under test: {@link StorageManager#getFileStorage(String)}
   */
  @Test
  @DisplayName("Test getFileStorage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.storage.IFileStorage StorageManager.getFileStorage(String)"})
  void testGetFileStorage() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(EStorageConfig.class,
        () -> (new StorageManager(plugins,
            new ConfigManager("https://example.org/example", workingDir, new PluginManager())))
            .getFileStorage("Storage Key"));
  }
}

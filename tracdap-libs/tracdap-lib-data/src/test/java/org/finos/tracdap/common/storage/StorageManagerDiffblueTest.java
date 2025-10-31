package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStorageConfig;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.Test;

class StorageManagerDiffblueTest {
  /**
   * Method under test: {@link StorageManager#getDataStorage(String)}
   */
  @Test
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
   * Method under test: {@link StorageManager#getFileStorage(String)}
   */
  @Test
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

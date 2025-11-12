package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import org.finos.tracdap.common.codec.ICodecManager;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStorageConfig;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.StorageConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StorageManagerDiffblueTest {
  /**
   * Test {@link StorageManager#initStorage(StorageConfig, ICodecManager, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link StorageConfig#getBucketsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link StorageManager#initStorage(StorageConfig, ICodecManager,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test initStorage(StorageConfig, ICodecManager, EventLoopGroup); given HashMap(); then calls getBucketsMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StorageManager.initStorage(StorageConfig, ICodecManager, EventLoopGroup)"
  })
  void testInitStorage_givenHashMap_thenCallsGetBucketsMap() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    StorageManager storageManager = new StorageManager(plugins, configManager);

    StorageConfig storageConfig = mock(StorageConfig.class);
    when(storageConfig.getBucketsMap()).thenReturn(new HashMap<>());
    ICodecManager formats = mock(ICodecManager.class);

    // Act
    storageManager.initStorage(storageConfig, formats, new DefaultEventLoop());

    // Assert
    verify(storageConfig).getBucketsMap();
  }

  /**
   * Test {@link StorageManager#getDataStorage(String)}.
   *
   * <p>Method under test: {@link StorageManager#getDataStorage(String)}
   */
  @Test
  @DisplayName("Test getDataStorage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.storage.IDataStorage StorageManager.getDataStorage(String)"
  })
  void testGetDataStorage() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    StorageManager storageManager = new StorageManager(plugins, configManager);

    // Act and Assert
    assertThrows(EStorageConfig.class, () -> storageManager.getDataStorage("Storage Key"));
  }

  /**
   * Test {@link StorageManager#getFileStorage(String)}.
   *
   * <p>Method under test: {@link StorageManager#getFileStorage(String)}
   */
  @Test
  @DisplayName("Test getFileStorage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.storage.IFileStorage StorageManager.getFileStorage(String)"
  })
  void testGetFileStorage() {
    // Arrange
    PluginManager plugins = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    StorageManager storageManager = new StorageManager(plugins, configManager);

    // Act and Assert
    assertThrows(EStorageConfig.class, () -> storageManager.getFileStorage("Storage Key"));
  }
}

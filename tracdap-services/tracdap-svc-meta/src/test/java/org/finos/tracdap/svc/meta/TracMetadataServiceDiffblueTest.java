package org.finos.tracdap.svc.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.IConfigLoader;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TracMetadataServiceDiffblueTest {
  /**
   * Test {@link TracMetadataService#doStartup(Duration)}.
   * <ul>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracMetadataService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration); then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracMetadataService.doStartup(Duration)"})
  void testDoStartup_thenThrowEStartup() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createConfigService(Mockito.<Class<IConfigLoader>>any(), Mockito.<String>any(),
        Mockito.<Properties>any())).thenThrow(EStartup.quietShutdown(1));
    when(plugins.isServiceAvailable(Mockito.<Class<Object>>any(), Mockito.<String>any())).thenReturn(true);
    when(plugins.getExtensions()).thenReturn(new ArrayList<>());
    ConfigManager configManager = new ConfigManager("https://example.org/example",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), plugins);

    // Act and Assert
    assertThrows(EStartup.class, () -> (new TracMetadataService(new PluginManager(), configManager)).doStartup(null));
    verify(plugins).createConfigService(isA(Class.class), eq("https"), isA(Properties.class));
    verify(plugins).getExtensions();
    verify(plugins).isServiceAvailable(isA(Class.class), eq("https"));
  }

  /**
   * Test {@link TracMetadataService#createPrimaryExecutor(Properties)}.
   * <p>
   * Method under test: {@link TracMetadataService#createPrimaryExecutor(Properties)}
   */
  @Test
  @DisplayName("Test createPrimaryExecutor(Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExecutorService TracMetadataService.createPrimaryExecutor(Properties)"})
  void testCreatePrimaryExecutor() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    TracMetadataService tracMetadataService = new TracMetadataService(pluginManager,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Act
    ExecutorService actualCreatePrimaryExecutorResult = tracMetadataService.createPrimaryExecutor(new Properties());

    // Assert
    assertTrue(actualCreatePrimaryExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getActiveCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getTaskCount());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getCorePoolSize());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getLargestPoolSize());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getQueue().isEmpty());
  }
}

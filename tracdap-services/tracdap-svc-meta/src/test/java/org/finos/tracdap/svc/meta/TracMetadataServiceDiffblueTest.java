package org.finos.tracdap.svc.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EStartup;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracMetadataServiceDiffblueTest {
  @Mock private ConfigManager configManager;

  @InjectMocks private TracMetadataService tracMetadataService;

  /**
   * Test {@link TracMetadataService#doStartup(Duration)}.
   *
   * <p>Method under test: {@link TracMetadataService#doStartup(Duration)}
   */
  @Test
  @DisplayName("Test doStartup(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracMetadataService.doStartup(Duration)"})
  void testDoStartup() {
    // Arrange
    when(configManager.loadRootConfigObject(PlatformConfig.class))
        .thenThrow(EStartup.quietShutdown(1));

    // Act and Assert
    assertThrows(EStartup.class, () -> tracMetadataService.doStartup(Duration.ofSeconds(1L)));
    verify(configManager).loadRootConfigObject(isA(Class.class));
  }

  /**
   * Test {@link TracMetadataService#createPrimaryExecutor(Properties)}.
   *
   * <p>Method under test: {@link TracMetadataService#createPrimaryExecutor(Properties)}
   */
  @Test
  @DisplayName("Test createPrimaryExecutor(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutorService TracMetadataService.createPrimaryExecutor(Properties)"})
  void testCreatePrimaryExecutor() {
    // Arrange
    PluginManager pluginManager = new PluginManager();
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    TracMetadataService tracMetadataService = new TracMetadataService(pluginManager, configManager);

    // Act
    ExecutorService actualCreatePrimaryExecutorResult =
        tracMetadataService.createPrimaryExecutor(new Properties());

    // Assert
    assertTrue(actualCreatePrimaryExecutorResult instanceof ThreadPoolExecutor);
    assertEquals(
        0L, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getCompletedTaskCount());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getCorePoolSize());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getLargestPoolSize());
    assertEquals(20, ((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualCreatePrimaryExecutorResult).getQueue().isEmpty());
  }
}

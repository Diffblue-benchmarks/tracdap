package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.tracdap.common.codec.arrow.ArrowFileCodec;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.exception.EPluginNotAvailable;
import org.finos.tracdap.common.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CodecManagerDiffblueTest {
  /**
   * Test {@link CodecManager#getCodec(String)}.
   *
   * <p>Method under test: {@link CodecManager#getCodec(String)}
   */
  @Test
  @DisplayName("Test getCodec(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICodec CodecManager.getCodec(String)"})
  void testGetCodec() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    when(plugins.createService(
            eq(ICodec.class), Mockito.<String>any(), Mockito.<ConfigManager>any()))
        .thenThrow(new EPluginNotAvailable("Not all who wander are lost"));
    when(plugins.isServiceAvailable(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(true);
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    CodecManager codecManager = new CodecManager(plugins, configManager);

    // Act and Assert
    assertThrows(EPluginNotAvailable.class, () -> codecManager.getCodec("Format"));
    verify(plugins).createService(isA(Class.class), eq("Format"), isA(ConfigManager.class));
    verify(plugins).isServiceAvailable(isA(Class.class), eq("Format"));
  }

  /**
   * Test {@link CodecManager#getCodec(String)}.
   *
   * <ul>
   *   <li>Then return {@link ArrowFileCodec} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CodecManager#getCodec(String)}
   */
  @Test
  @DisplayName("Test getCodec(String); then return ArrowFileCodec (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICodec CodecManager.getCodec(String)"})
  void testGetCodec_thenReturnArrowFileCodec() {
    // Arrange
    PluginManager plugins = mock(PluginManager.class);
    ArrowFileCodec arrowFileCodec = new ArrowFileCodec();
    when(plugins.createService(
            eq(ICodec.class), Mockito.<String>any(), Mockito.<ConfigManager>any()))
        .thenReturn(arrowFileCodec);
    when(plugins.isServiceAvailable(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(true);
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    CodecManager codecManager = new CodecManager(plugins, configManager);

    // Act
    ICodec actualCodec = codecManager.getCodec("Format");

    // Assert
    verify(plugins).createService(isA(Class.class), eq("Format"), isA(ConfigManager.class));
    verify(plugins).isServiceAvailable(isA(Class.class), eq("Format"));
    assertSame(arrowFileCodec, actualCodec);
  }
}

package org.finos.tracdap.common.storage;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.codec.ICodecManager;
import org.finos.tracdap.config.PluginConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonDataStorageDiffblueTest {
  /**
   * Test {@link CommonDataStorage#CommonDataStorage(PluginConfig, IFileStorage, ICodecManager)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link PluginConfig#getPropertiesOrDefault(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonDataStorage#CommonDataStorage(PluginConfig, IFileStorage,
   * ICodecManager)}
   */
  @Test
  @DisplayName(
      "Test new CommonDataStorage(PluginConfig, IFileStorage, ICodecManager); given '42'; then calls getPropertiesOrDefault(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommonDataStorage.<init>(PluginConfig, IFileStorage, ICodecManager)"})
  void testNewCommonDataStorage_given42_thenCallsGetPropertiesOrDefault() {
    // Arrange
    PluginConfig bucketConfig = mock(PluginConfig.class);
    when(bucketConfig.getPropertiesOrDefault(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("42");

    // Act
    new CommonDataStorage(bucketConfig, null, mock(ICodecManager.class));

    // Assert
    verify(bucketConfig).getPropertiesOrDefault("downloadSizeLimit", "1073741824");
  }
}

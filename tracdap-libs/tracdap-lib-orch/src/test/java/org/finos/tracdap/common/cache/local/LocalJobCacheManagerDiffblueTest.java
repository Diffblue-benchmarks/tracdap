package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import org.finos.tracdap.common.cache.IJobCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalJobCacheManagerDiffblueTest {
  /**
   * Test {@link LocalJobCacheManager#getCache(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Cache Name}.
   *   <li>Then return {@link LocalJobCache}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCacheManager#getCache(String, Class)}
   */
  @Test
  @DisplayName("Test getCache(String, Class); when 'Cache Name'; then return LocalJobCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IJobCache LocalJobCacheManager.getCache(String, Class)"})
  void testGetCache_whenCacheName_thenReturnLocalJobCache() {
    // Arrange
    LocalJobCacheManager localJobCacheManager = new LocalJobCacheManager();
    Class<Serializable> cacheType = Serializable.class;

    // Act
    IJobCache<Serializable> actualCache = localJobCacheManager.getCache("Cache Name", cacheType);

    // Assert
    assertTrue(actualCache instanceof LocalJobCache);
    assertFalse(actualCache.queryKey("Key").isPresent());
    assertTrue(actualCache.queryStatus(null).isEmpty());
  }
}

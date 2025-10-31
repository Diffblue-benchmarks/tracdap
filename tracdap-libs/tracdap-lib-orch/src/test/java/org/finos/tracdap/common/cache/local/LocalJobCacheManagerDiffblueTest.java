package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.Serializable;
import org.finos.tracdap.common.cache.IJobCache;
import org.junit.jupiter.api.Test;

class LocalJobCacheManagerDiffblueTest {
  /**
   * Method under test: {@link LocalJobCacheManager#getCache(String, Class)}
   */
  @Test
  void testGetCache() {
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

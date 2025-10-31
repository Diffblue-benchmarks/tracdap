package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class LocalJobCacheEntryDiffblueTest {
  /**
   * Method under test: {@link LocalJobCacheEntry#clone()}
   */
  @Test
  void testClone() {
    // Arrange and Act
    LocalJobCacheEntry actualCloneResult = (new LocalJobCacheEntry()).clone();

    // Assert
    assertNull(actualCloneResult.encodedValue);
    assertNull(actualCloneResult.status);
    assertNull(actualCloneResult.lastActivity);
    assertNull(actualCloneResult.ticket);
    assertEquals(0, actualCloneResult.revision);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LocalJobCacheEntry}
   */
  @Test
  void testNewLocalJobCacheEntry() {
    // Arrange and Act
    LocalJobCacheEntry actualLocalJobCacheEntry = new LocalJobCacheEntry();

    // Assert
    assertNull(actualLocalJobCacheEntry.encodedValue);
    assertNull(actualLocalJobCacheEntry.status);
    assertNull(actualLocalJobCacheEntry.lastActivity);
    assertNull(actualLocalJobCacheEntry.ticket);
    assertEquals(0, actualLocalJobCacheEntry.revision);
  }
}

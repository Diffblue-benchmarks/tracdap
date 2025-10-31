package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalJobCacheEntryDiffblueTest {
  /**
   * Test {@link LocalJobCacheEntry#clone()}.
   * <p>
   * Method under test: {@link LocalJobCacheEntry#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalJobCacheEntry LocalJobCacheEntry.clone()"})
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
   * Test new {@link LocalJobCacheEntry} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LocalJobCacheEntry}
   */
  @Test
  @DisplayName("Test new LocalJobCacheEntry (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalJobCacheEntry.<init>()"})
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

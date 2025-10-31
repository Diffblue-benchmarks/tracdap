package org.finos.tracdap.common.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.tracdap.common.exception.ECache;
import org.junit.jupiter.api.Test;

class CacheEntryDiffblueTest {
  /**
   * Method under test: {@link CacheEntry#forValue(String, int, String, Object)}
   */
  @Test
  void testForValue() {
    // Arrange and Act
    CacheEntry<Object> actualForValueResult = CacheEntry.forValue("Key", 1, "Status", "Value");

    // Assert
    assertEquals("Key", actualForValueResult.key());
    assertEquals("Status", actualForValueResult.status());
    assertEquals("Value", actualForValueResult.value());
    assertNull(actualForValueResult.cacheError());
    assertEquals(1, actualForValueResult.revision());
  }

  /**
   * Method under test: {@link CacheEntry#error(String, int, String, ECache)}
   */
  @Test
  void testError() {
    // Arrange
    ECache cacheError = new ECache("Not all who wander are lost");

    // Act
    CacheEntry<Object> actualErrorResult = CacheEntry.error("Key", 1, "Status", cacheError);

    // Assert
    assertEquals("Key", actualErrorResult.key());
    assertEquals("Status", actualErrorResult.status());
    assertEquals(1, actualErrorResult.revision());
    assertSame(cacheError, actualErrorResult.cacheError());
  }

  /**
   * Method under test: {@link CacheEntry#value()}
   */
  @Test
  void testValue() {
    // Arrange
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", null);

    // Act and Assert
    assertNull(errorResult.value());
  }

  /**
   * Method under test: {@link CacheEntry#cacheOk()}
   */
  @Test
  void testCacheOk() {
    // Arrange
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", new ECache("Not all who wander are lost"));

    // Act and Assert
    assertFalse(errorResult.cacheOk());
  }

  /**
   * Method under test: {@link CacheEntry#cacheOk()}
   */
  @Test
  void testCacheOk2() {
    // Arrange
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", null);

    // Act and Assert
    assertTrue(errorResult.cacheOk());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheEntry#cacheError()}
   *   <li>{@link CacheEntry#key()}
   *   <li>{@link CacheEntry#revision()}
   *   <li>{@link CacheEntry#status()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ECache cacheError = new ECache("Not all who wander are lost");
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", cacheError);

    // Act
    ECache actualCacheErrorResult = errorResult.cacheError();
    String actualKeyResult = errorResult.key();
    int actualRevisionResult = errorResult.revision();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals("Status", errorResult.status());
    assertEquals(1, actualRevisionResult);
    assertSame(cacheError, actualCacheErrorResult);
  }
}

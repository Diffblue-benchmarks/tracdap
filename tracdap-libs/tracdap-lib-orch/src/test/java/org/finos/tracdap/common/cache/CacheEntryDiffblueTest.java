package org.finos.tracdap.common.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.ECache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheEntryDiffblueTest {
  /**
   * Test {@link CacheEntry#forValue(String, int, String, Object)}.
   *
   * <p>Method under test: {@link CacheEntry#forValue(String, int, String, Object)}
   */
  @Test
  @DisplayName("Test forValue(String, int, String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheEntry CacheEntry.forValue(String, int, String, Object)"})
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
   * Test {@link CacheEntry#error(String, int, String, ECache)}.
   *
   * <p>Method under test: {@link CacheEntry#error(String, int, String, ECache)}
   */
  @Test
  @DisplayName("Test error(String, int, String, ECache)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheEntry CacheEntry.error(String, int, String, ECache)"})
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
   * Test {@link CacheEntry#value()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CacheEntry#value()}
   */
  @Test
  @DisplayName("Test value(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CacheEntry.value()"})
  void testValue_thenReturnNull() {
    // Arrange
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", null);

    // Act and Assert
    assertNull(errorResult.value());
  }

  /**
   * Test {@link CacheEntry#cacheOk()}.
   *
   * <ul>
   *   <li>Given {@link ECache#ECache(String)} with message is {@code Not all who wander are lost}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CacheEntry#cacheOk()}
   */
  @Test
  @DisplayName(
      "Test cacheOk(); given ECache(String) with message is 'Not all who wander are lost'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheEntry.cacheOk()"})
  void testCacheOk_givenECacheWithMessageIsNotAllWhoWanderAreLost_thenReturnFalse() {
    // Arrange
    CacheEntry<Object> errorResult =
        CacheEntry.error("Key", 1, "Status", new ECache("Not all who wander are lost"));

    // Act and Assert
    assertFalse(errorResult.cacheOk());
  }

  /**
   * Test {@link CacheEntry#cacheOk()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CacheEntry#cacheOk()}
   */
  @Test
  @DisplayName("Test cacheOk(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheEntry.cacheOk()"})
  void testCacheOk_thenReturnTrue() {
    // Arrange
    CacheEntry<Object> errorResult = CacheEntry.error("Key", 1, "Status", null);

    // Act and Assert
    assertTrue(errorResult.cacheOk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheEntry#cacheError()}
   *   <li>{@link CacheEntry#key()}
   *   <li>{@link CacheEntry#revision()}
   *   <li>{@link CacheEntry#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ECache CacheEntry.cacheError()",
    "String CacheEntry.key()",
    "int CacheEntry.revision()",
    "String CacheEntry.status()"
  })
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

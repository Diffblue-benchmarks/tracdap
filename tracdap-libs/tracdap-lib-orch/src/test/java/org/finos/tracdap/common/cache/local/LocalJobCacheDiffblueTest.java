package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.cache.CacheTicket;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalJobCacheDiffblueTest {
  /**
   * Test {@link LocalJobCache#LocalJobCache()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link LocalJobCache}
   */
  @Test
  @DisplayName("Test new LocalJobCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalJobCache.<init>()"})
  void testNewLocalJobCache() {
    // Arrange and Act
    LocalJobCache<Serializable> actualLocalJobCache = new LocalJobCache<>();

    // Assert
    assertFalse(actualLocalJobCache.queryKey("Key").isPresent());
    assertTrue(actualLocalJobCache.queryStatus(null).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName("Test openNewTicket(String, Duration); when 'Key'; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenKey_thenReturnKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act
    CacheTicket actualOpenNewTicketResult = localJobCache.openNewTicket("Key", LocalJobCache.DEFAULT_TICKET_DURATION);

    // Assert
    assertEquals("Key", actualOpenNewTicketResult.key());
    assertEquals(0, actualOpenNewTicketResult.revision());
    assertFalse(actualOpenNewTicketResult.missing());
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   * <ul>
   *   <li>When {@code LocalJobCacheEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName("Test openNewTicket(String, Duration); when 'org.finos.tracdap.common.cache.local.LocalJobCacheEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOrgFinosTracdapCommonCacheLocalLocalJobCacheEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("org.finos.tracdap.common.cache.local.LocalJobCacheEntry",
            LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   * <ul>
   *   <li>When {@code trac-U}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName("Test openNewTicket(String, Duration); when 'trac-U'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenTracU_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("trac-U", LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName("Test openTicket(String, int, Duration); when 'Key'; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenKey_thenReturnKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act
    CacheTicket actualOpenTicketResult = localJobCache.openTicket("Key", 1, LocalJobCache.DEFAULT_TICKET_DURATION);

    // Assert
    assertEquals("Key", actualOpenTicketResult.key());
    assertEquals(1, actualOpenTicketResult.revision());
    Instant expiryResult = actualOpenTicketResult.expiry();
    assertEquals(31556889864403199L, expiryResult.getEpochSecond());
    assertEquals(999999999, expiryResult.getNano());
    assertFalse(actualOpenTicketResult.superseded());
    assertTrue(actualOpenTicketResult.missing());
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName("Test openTicket(String, int, Duration); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localJobCache.openTicket("Key", -1, null));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   * <ul>
   *   <li>When {@code LocalJobCacheEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName("Test openTicket(String, int, Duration); when 'org.finos.tracdap.common.cache.local.LocalJobCacheEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOrgFinosTracdapCommonCacheLocalLocalJobCacheEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openTicket("org.finos.tracdap.common.cache.local.LocalJobCacheEntry", 1,
            LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   * <ul>
   *   <li>When {@code trac-U}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName("Test openTicket(String, int, Duration); when 'trac-U'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenTracU_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openTicket("trac-U", 1, LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   * <p>
   * Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test createEntry(CacheTicket, String, Serializable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> localJobCache.createEntry(null, "Status", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   * <p>
   * Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test updateEntry(CacheTicket, String, Serializable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> localJobCache.updateEntry(null, "Status", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   * <p>
   * Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test deleteEntry(CacheTicket)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.deleteEntry(null));
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   * <p>
   * Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test readEntry(CacheTicket)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"})
  void testReadEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.readEntry(null));
  }

  /**
   * Test {@link LocalJobCache#queryKey(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryKey(String)}
   */
  @Test
  @DisplayName("Test queryKey(String); when 'Key'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional LocalJobCache.queryKey(String)"})
  void testQueryKey_whenKey_thenReturnNotPresent() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertFalse(localJobCache.queryKey("Key").isPresent());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code includeOpenTickets}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName("Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List, boolean)"})
  void testQueryStatusWithStatusesIncludeOpenTickets_given42_whenArrayListAdd42() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("42");
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses, true).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code includeOpenTickets}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName("Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List, boolean)"})
  void testQueryStatusWithStatusesIncludeOpenTickets_givenFoo_whenArrayListAddFoo() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses, true).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code includeOpenTickets}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName("Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List, boolean)"})
  void testQueryStatusWithStatusesIncludeOpenTickets_whenArrayList() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List)"})
  void testQueryStatusWithStatuses_given42_whenArrayListAdd42() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("42");
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List)"})
  void testQueryStatusWithStatuses_givenFoo_whenArrayListAddFoo() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List)} with {@code statuses}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List)"})
  void testQueryStatusWithStatuses_whenArrayList() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>()).isEmpty());
  }
}

package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.cache.CacheTicket;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class LocalJobCacheDiffblueTest {
  /**
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  void testOpenNewTicket() {
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
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  void testOpenNewTicket2() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("trac-U", LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  void testOpenNewTicket3() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("org.finos.tracdap.common.cache.local.LocalJobCacheEntry",
            LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  void testOpenTicket() {
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
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  void testOpenTicket2() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localJobCache.openTicket("Key", -1, null));
  }

  /**
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  void testOpenTicket3() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openTicket("trac-U", 1, LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  void testOpenTicket4() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> localJobCache.openTicket("org.finos.tracdap.common.cache.local.LocalJobCacheEntry", 1,
            LocalJobCache.DEFAULT_TICKET_DURATION));
  }

  /**
   * Method under test:
   * {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  void testCreateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> localJobCache.createEntry(null, "Status", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  void testUpdateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> localJobCache.updateEntry(null, "Status", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  void testDeleteEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.deleteEntry(null));
  }

  /**
   * Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  void testReadEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.readEntry(null));
  }

  /**
   * Method under test: {@link LocalJobCache#queryKey(String)}
   */
  @Test
  void testQueryKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertFalse(localJobCache.queryKey("Key").isPresent());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  void testQueryStatus() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  void testQueryStatus2() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses).isEmpty());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  void testQueryStatus3() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("42");
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses).isEmpty());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  void testQueryStatus4() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  void testQueryStatus5() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses, true).isEmpty());
  }

  /**
   * Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  void testQueryStatus6() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    ArrayList<String> statuses = new ArrayList<>();
    statuses.add("42");
    statuses.add("foo");

    // Act and Assert
    assertTrue(localJobCache.queryStatus(statuses, true).isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LocalJobCache}
   */
  @Test
  void testNewLocalJobCache() {
    // Arrange and Act
    LocalJobCache<Serializable> actualLocalJobCache = new LocalJobCache<>();

    // Assert
    assertFalse(actualLocalJobCache.queryKey("Key").isPresent());
    assertTrue(actualLocalJobCache.queryStatus(null).isEmpty());
  }
}

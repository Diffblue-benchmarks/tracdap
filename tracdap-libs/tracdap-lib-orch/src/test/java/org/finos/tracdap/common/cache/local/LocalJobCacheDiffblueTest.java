package org.finos.tracdap.common.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.cache.CacheTicket;
import org.finos.tracdap.common.exception.ECacheNotFound;
import org.finos.tracdap.common.exception.ECacheTicket;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalJobCacheDiffblueTest {
  /**
   * Test {@link LocalJobCache#LocalJobCache()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link LocalJobCache}
   */
  @Test
  @DisplayName("Test new LocalJobCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When ofSeconds {@link Long#MAX_VALUE}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName(
      "Test openNewTicket(String, Duration); when ofSeconds MAX_VALUE; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOfSecondsMax_value_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.openNewTicket("Key", Duration.ofSeconds(Long.MAX_VALUE)));
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName(
      "Test openNewTicket(String, Duration); when ofSeconds minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOfSecondsMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("Key", Duration.ofSeconds(-1L)));
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds one.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName("Test openNewTicket(String, Duration); when ofSeconds one; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOfSecondsOne_thenReturnKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act
    CacheTicket actualOpenNewTicketResult =
        localJobCache.openNewTicket("Key", Duration.ofSeconds(1L));

    // Assert
    assertEquals("Key", actualOpenNewTicketResult.key());
    assertEquals(0, actualOpenNewTicketResult.revision());
    assertFalse(actualOpenNewTicketResult.missing());
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName(
      "Test openNewTicket(String, Duration); when ofSeconds zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOfSecondsZero_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("Key", Duration.ofSeconds(0L)));
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   *
   * <ul>
   *   <li>When {@code LocalJobCacheEntry}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName(
      "Test openNewTicket(String, Duration); when 'org.finos.tracdap.common.cache.local.LocalJobCacheEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenOrgFinosTracdapCommonCacheLocalLocalJobCacheEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            localJobCache.openNewTicket(
                "org.finos.tracdap.common.cache.local.LocalJobCacheEntry", Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link LocalJobCache#openNewTicket(String, Duration)}.
   *
   * <ul>
   *   <li>When {@code trac-U}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openNewTicket(String, Duration)}
   */
  @Test
  @DisplayName(
      "Test openNewTicket(String, Duration); when 'trac-U'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openNewTicket(String, Duration)"})
  void testOpenNewTicket_whenTracU_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openNewTicket("trac-U", Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> localJobCache.openTicket("Key", -1, null));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds {@link Long#MAX_VALUE}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when ofSeconds MAX_VALUE; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOfSecondsMax_value_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.openTicket("Key", 1, Duration.ofSeconds(Long.MAX_VALUE)));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when ofSeconds minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOfSecondsMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openTicket("Key", 1, Duration.ofSeconds(-1L)));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds one.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName("Test openTicket(String, int, Duration); when ofSeconds one; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOfSecondsOne_thenReturnKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act
    CacheTicket actualOpenTicketResult = localJobCache.openTicket("Key", 1, Duration.ofSeconds(1L));

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
   *
   * <ul>
   *   <li>When ofSeconds zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when ofSeconds zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOfSecondsZero_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openTicket("Key", 1, Duration.ofSeconds(0L)));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When {@code LocalJobCacheEntry}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when 'org.finos.tracdap.common.cache.local.LocalJobCacheEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenOrgFinosTracdapCommonCacheLocalLocalJobCacheEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            localJobCache.openTicket(
                "org.finos.tracdap.common.cache.local.LocalJobCacheEntry",
                1,
                Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link LocalJobCache#openTicket(String, int, Duration)}.
   *
   * <ul>
   *   <li>When {@code trac-U}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#openTicket(String, int, Duration)}
   */
  @Test
  @DisplayName(
      "Test openTicket(String, int, Duration); when 'trac-U'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket LocalJobCache.openTicket(String, int, Duration)"})
  void testOpenTicket_whenTracU_thenThrowIllegalArgumentException() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> localJobCache.openTicket("trac-U", 1, Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link LocalJobCache#closeTicket(CacheTicket)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#key()} return {@code Key}.
   *   <li>Then calls {@link CacheTicket#key()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#closeTicket(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test closeTicket(CacheTicket); given 'Key'; when CacheTicket key() return 'Key'; then calls key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.closeTicket(CacheTicket)"})
  void testCloseTicket_givenKey_whenCacheTicketKeyReturnKey_thenCallsKey() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");

    // Act
    localJobCache.closeTicket(ticket);

    // Assert
    verify(ticket).key();
  }

  /**
   * Test {@link LocalJobCache#closeTicket(CacheTicket)}.
   *
   * <ul>
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#closeTicket(CacheTicket)}
   */
  @Test
  @DisplayName("Test closeTicket(CacheTicket); then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.closeTicket(CacheTicket)"})
  void testCloseTicket_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.closeTicket(ticket));
    verify(ticket).key();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test createEntry(CacheTicket, String, Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.missing()).thenThrow(new ECacheNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test createEntry(CacheTicket, String, Serializable); given 'Key'; when CacheTicket missing() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_givenKey_whenCacheTicketMissingReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheTicket#expiry()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test createEntry(CacheTicket, String, Serializable); then calls expiry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_thenCallsExpiry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(false);
    when(ticket.expiry())
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).expiry();
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test createEntry(CacheTicket, String, Serializable); when CacheTicket missing() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_whenCacheTicketMissingReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test createEntry(CacheTicket, String, Serializable); when CacheTicket superseded() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test createEntry(CacheTicket, String, Serializable); when CacheTicket superseded() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.createEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#createEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test createEntry(CacheTicket, String, Serializable); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.createEntry(CacheTicket, String, Serializable)"})
  void testCreateEntry_whenNull_thenThrowETracInternal() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.createEntry(null, null, null));
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test updateEntry(CacheTicket, String, Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.missing()).thenThrow(new ECacheNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test updateEntry(CacheTicket, String, Serializable); given 'Key'; when CacheTicket missing() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_givenKey_whenCacheTicketMissingReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheTicket#expiry()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName("Test updateEntry(CacheTicket, String, Serializable); then calls expiry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_thenCallsExpiry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(false);
    when(ticket.expiry())
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).expiry();
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test updateEntry(CacheTicket, String, Serializable); when CacheTicket missing() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_whenCacheTicketMissingReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test updateEntry(CacheTicket, String, Serializable); when CacheTicket superseded() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheNotFound.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test updateEntry(CacheTicket, String, Serializable); when CacheTicket superseded() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ECacheTicket.class,
        () -> localJobCache.updateEntry(ticket, "Status", new SimpleDateFormat("yyyy/mm/dd")));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#updateEntry(CacheTicket, String, Serializable)}
   */
  @Test
  @DisplayName(
      "Test updateEntry(CacheTicket, String, Serializable); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LocalJobCache.updateEntry(CacheTicket, String, Serializable)"})
  void testUpdateEntry_whenNull_thenThrowETracInternal() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.updateEntry(null, null, null));
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test deleteEntry(CacheTicket)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.missing()).thenThrow(new ECacheNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test deleteEntry(CacheTicket); given 'Key'; when CacheTicket missing() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_givenKey_whenCacheTicketMissingReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheTicket.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheTicket#expiry()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test deleteEntry(CacheTicket); then calls expiry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_thenCallsExpiry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(false);
    when(ticket.expiry())
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).expiry();
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test deleteEntry(CacheTicket); when CacheTicket missing() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_whenCacheTicketMissingReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test deleteEntry(CacheTicket); when CacheTicket superseded() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test deleteEntry(CacheTicket); when CacheTicket superseded() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheTicket.class, () -> localJobCache.deleteEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#deleteEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#deleteEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test deleteEntry(CacheTicket); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalJobCache.deleteEntry(CacheTicket)"})
  void testDeleteEntry_whenNull_thenThrowETracInternal() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.deleteEntry(null));
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test readEntry(CacheTicket)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.missing()).thenThrow(new ECacheNotFound("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test readEntry(CacheTicket); given 'Key'; when CacheTicket missing() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_givenKey_whenCacheTicketMissingReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheTicket.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheTicket}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test readEntry(CacheTicket); given 'Key'; when CacheTicket superseded() return 'true'; then throw ECacheTicket")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_givenKey_whenCacheTicketSupersededReturnTrue_thenThrowECacheTicket() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenReturn("Key");
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheTicket.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheTicket#expiry()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test readEntry(CacheTicket); then calls expiry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_thenCallsExpiry() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(false);
    when(ticket.expiry())
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).expiry();
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#missing()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test readEntry(CacheTicket); when CacheTicket missing() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_whenCacheTicketMissingReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@link CacheTicket} {@link CacheTicket#superseded()} return {@code true}.
   *   <li>Then throw {@link ECacheNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName(
      "Test readEntry(CacheTicket); when CacheTicket superseded() return 'true'; then throw ECacheNotFound")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_whenCacheTicketSupersededReturnTrue_thenThrowECacheNotFound() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    CacheTicket ticket = mock(CacheTicket.class);
    when(ticket.key()).thenThrow(new ECacheNotFound("Not all who wander are lost"));
    when(ticket.missing()).thenReturn(false);
    when(ticket.superseded()).thenReturn(true);

    // Act and Assert
    assertThrows(ECacheNotFound.class, () -> localJobCache.readEntry(ticket));
    verify(ticket).key();
    verify(ticket).missing();
    verify(ticket).superseded();
  }

  /**
   * Test {@link LocalJobCache#readEntry(CacheTicket)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#readEntry(CacheTicket)}
   */
  @Test
  @DisplayName("Test readEntry(CacheTicket); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.common.cache.CacheEntry LocalJobCache.readEntry(CacheTicket)"
  })
  void testReadEntry_whenNull_thenThrowETracInternal() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertThrows(ETracInternal.class, () -> localJobCache.readEntry(null));
  }

  /**
   * Test {@link LocalJobCache#queryKey(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryKey(String)}
   */
  @Test
  @DisplayName("Test queryKey(String); when 'Key'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional LocalJobCache.queryKey(String)"})
  void testQueryKey_whenKey_thenReturnNotPresent() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertFalse(localJobCache.queryKey("Key").isPresent());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code
   * includeOpenTickets}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code
   * includeOpenTickets}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link LocalJobCache#queryStatus(List, boolean)} with {@code statuses}, {@code
   * includeOpenTickets}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test queryStatus(List, boolean) with 'statuses', 'includeOpenTickets'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List, boolean)"})
  void testQueryStatusWithStatusesIncludeOpenTickets_whenArrayList() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link LocalJobCache#queryStatus(List)} with {@code statuses}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalJobCache#queryStatus(List)}
   */
  @Test
  @DisplayName("Test queryStatus(List) with 'statuses'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LocalJobCache.queryStatus(List)"})
  void testQueryStatusWithStatuses_whenArrayList() {
    // Arrange
    LocalJobCache<Serializable> localJobCache = new LocalJobCache<>();

    // Act and Assert
    assertTrue(localJobCache.queryStatus(new ArrayList<>()).isEmpty());
  }
}

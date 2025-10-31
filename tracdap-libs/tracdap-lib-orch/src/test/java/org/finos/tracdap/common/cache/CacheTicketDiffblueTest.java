package org.finos.tracdap.common.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.finos.tracdap.common.cache.local.LocalJobCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CacheTicketDiffblueTest {
  /**
   * Method under test:
   * {@link CacheTicket#missingEntryTicket(String, int, Instant)}
   */
  @Test
  void testMissingEntryTicket() {
    // Arrange
    Instant grantTime = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    CacheTicket actualMissingEntryTicketResult = CacheTicket.missingEntryTicket("Key", 1, grantTime);

    // Assert
    assertEquals("Key", actualMissingEntryTicketResult.key());
    assertEquals(1, actualMissingEntryTicketResult.revision());
    assertFalse(actualMissingEntryTicketResult.superseded());
    assertTrue(actualMissingEntryTicketResult.missing());
    Instant expectedGrantTimeResult = grantTime.EPOCH;
    assertSame(expectedGrantTimeResult, actualMissingEntryTicketResult.grantTime());
    Instant expectedExpiryResult = grantTime.MAX;
    assertSame(expectedExpiryResult, actualMissingEntryTicketResult.expiry());
  }

  /**
   * Method under test: {@link CacheTicket#supersededTicket(String, int, Instant)}
   */
  @Test
  void testSupersededTicket() {
    // Arrange
    Instant grantTime = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    CacheTicket actualSupersededTicketResult = CacheTicket.supersededTicket("Key", 1, grantTime);

    // Assert
    assertEquals("Key", actualSupersededTicketResult.key());
    assertEquals(1, actualSupersededTicketResult.revision());
    assertFalse(actualSupersededTicketResult.missing());
    assertTrue(actualSupersededTicketResult.superseded());
    Instant expectedGrantTimeResult = grantTime.EPOCH;
    assertSame(expectedGrantTimeResult, actualSupersededTicketResult.grantTime());
    Instant expectedExpiryResult = grantTime.MAX;
    assertSame(expectedExpiryResult, actualSupersededTicketResult.expiry());
  }

  /**
   * Method under test:
   * {@link CacheTicket#forDuration(IJobCache, String, int, Instant, Duration)}
   */
  @Test
  void testForDuration() {
    // Arrange
    IJobCache<Serializable> cache = mock(IJobCache.class);
    Instant grantTime = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    CacheTicket actualForDurationResult = CacheTicket.forDuration(cache, "Key", 1, grantTime,
        LocalJobCache.DEFAULT_TICKET_DURATION);

    // Assert
    assertEquals("Key", actualForDurationResult.key());
    Instant expiryResult = actualForDurationResult.expiry();
    assertEquals(0, expiryResult.getNano());
    assertEquals(1, actualForDurationResult.revision());
    assertEquals(30L, expiryResult.getEpochSecond());
    assertFalse(actualForDurationResult.missing());
    Instant expectedGrantTimeResult = grantTime.EPOCH;
    assertSame(expectedGrantTimeResult, actualForDurationResult.grantTime());
  }

  /**
   * Method under test: {@link CacheTicket#superseded()}
   */
  @Test
  void testSuperseded() {
    // Arrange, Act and Assert
    assertFalse(CacheTicket
        .missingEntryTicket("Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .superseded());
    assertTrue(CacheTicket
        .supersededTicket("Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .superseded());
  }

  /**
   * Method under test: {@link CacheTicket#close()}
   */
  @Test
  void testClose() {
    // Arrange
    IJobCache<Serializable> cache = mock(IJobCache.class);
    doNothing().when(cache).closeTicket(Mockito.<CacheTicket>any());

    // Act
    CacheTicket
        .forDuration(cache, "Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            LocalJobCache.DEFAULT_TICKET_DURATION)
        .close();

    // Assert
    verify(cache).closeTicket(isA(CacheTicket.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheTicket#expiry()}
   *   <li>{@link CacheTicket#grantTime()}
   *   <li>{@link CacheTicket#key()}
   *   <li>{@link CacheTicket#missing()}
   *   <li>{@link CacheTicket#revision()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CacheTicket missingEntryTicketResult = CacheTicket.missingEntryTicket("Key", 1,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualExpiryResult = missingEntryTicketResult.expiry();
    Instant actualGrantTimeResult = missingEntryTicketResult.grantTime();
    String actualKeyResult = missingEntryTicketResult.key();
    boolean actualMissingResult = missingEntryTicketResult.missing();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals(1, missingEntryTicketResult.revision());
    assertTrue(actualMissingResult);
    assertSame(actualGrantTimeResult.EPOCH, actualGrantTimeResult);
    assertSame(actualGrantTimeResult.MAX, actualExpiryResult);
  }
}

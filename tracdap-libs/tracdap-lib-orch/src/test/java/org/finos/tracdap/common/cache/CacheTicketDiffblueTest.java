package org.finos.tracdap.common.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.finos.tracdap.common.cache.local.LocalJobCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CacheTicketDiffblueTest {
  /**
   * Test {@link CacheTicket#missingEntryTicket(String, int, Instant)}.
   * <p>
   * Method under test: {@link CacheTicket#missingEntryTicket(String, int, Instant)}
   */
  @Test
  @DisplayName("Test missingEntryTicket(String, int, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket CacheTicket.missingEntryTicket(String, int, Instant)"})
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
   * Test {@link CacheTicket#supersededTicket(String, int, Instant)}.
   * <p>
   * Method under test: {@link CacheTicket#supersededTicket(String, int, Instant)}
   */
  @Test
  @DisplayName("Test supersededTicket(String, int, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket CacheTicket.supersededTicket(String, int, Instant)"})
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
   * Test {@link CacheTicket#forDuration(IJobCache, String, int, Instant, Duration)}.
   * <ul>
   *   <li>When {@link LocalJobCache#DEFAULT_TICKET_DURATION}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheTicket#forDuration(IJobCache, String, int, Instant, Duration)}
   */
  @Test
  @DisplayName("Test forDuration(IJobCache, String, int, Instant, Duration); when DEFAULT_TICKET_DURATION; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CacheTicket CacheTicket.forDuration(IJobCache, String, int, Instant, Duration)"})
  void testForDuration_whenDefault_ticket_duration_thenReturnKey() {
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant CacheTicket.expiry()", "Instant CacheTicket.grantTime()", "String CacheTicket.key()",
      "boolean CacheTicket.missing()", "int CacheTicket.revision()"})
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

  /**
   * Test {@link CacheTicket#superseded()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheTicket#superseded()}
   */
  @Test
  @DisplayName("Test superseded(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CacheTicket.superseded()"})
  void testSuperseded_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CacheTicket
        .missingEntryTicket("Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .superseded());
  }

  /**
   * Test {@link CacheTicket#superseded()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheTicket#superseded()}
   */
  @Test
  @DisplayName("Test superseded(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CacheTicket.superseded()"})
  void testSuperseded_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CacheTicket
        .supersededTicket("Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .superseded());
  }

  /**
   * Test {@link CacheTicket#close()}.
   * <ul>
   *   <li>Given {@link IJobCache} {@link IJobCache#closeTicket(CacheTicket)} does nothing.</li>
   *   <li>Then calls {@link IJobCache#closeTicket(CacheTicket)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheTicket#close()}
   */
  @Test
  @DisplayName("Test close(); given IJobCache closeTicket(CacheTicket) does nothing; then calls closeTicket(CacheTicket)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheTicket.close()"})
  void testClose_givenIJobCacheCloseTicketDoesNothing_thenCallsCloseTicket() {
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
}

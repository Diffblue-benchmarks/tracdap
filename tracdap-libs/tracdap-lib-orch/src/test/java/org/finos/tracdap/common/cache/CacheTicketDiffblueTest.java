package org.finos.tracdap.common.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheTicketDiffblueTest {
  /**
   * Test {@link CacheTicket#missingEntryTicket(String, int, Instant)}.
   *
   * <p>Method under test: {@link CacheTicket#missingEntryTicket(String, int, Instant)}
   */
  @Test
  @DisplayName("Test missingEntryTicket(String, int, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket CacheTicket.missingEntryTicket(String, int, Instant)"})
  void testMissingEntryTicket() {
    // Arrange and Act
    CacheTicket actualMissingEntryTicketResult =
        CacheTicket.missingEntryTicket(
            "Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("Key", actualMissingEntryTicketResult.key());
    assertEquals(1, actualMissingEntryTicketResult.revision());
    assertFalse(actualMissingEntryTicketResult.superseded());
    assertTrue(actualMissingEntryTicketResult.missing());
    assertSame(Instant.EPOCH, actualMissingEntryTicketResult.grantTime());
    assertSame(Instant.MAX, actualMissingEntryTicketResult.expiry());
  }

  /**
   * Test {@link CacheTicket#supersededTicket(String, int, Instant)}.
   *
   * <p>Method under test: {@link CacheTicket#supersededTicket(String, int, Instant)}
   */
  @Test
  @DisplayName("Test supersededTicket(String, int, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheTicket CacheTicket.supersededTicket(String, int, Instant)"})
  void testSupersededTicket() {
    // Arrange and Act
    CacheTicket actualSupersededTicketResult =
        CacheTicket.supersededTicket(
            "Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("Key", actualSupersededTicketResult.key());
    assertEquals(1, actualSupersededTicketResult.revision());
    assertFalse(actualSupersededTicketResult.missing());
    assertTrue(actualSupersededTicketResult.superseded());
    assertSame(Instant.EPOCH, actualSupersededTicketResult.grantTime());
    assertSame(Instant.MAX, actualSupersededTicketResult.expiry());
  }

  /**
   * Test {@link CacheTicket#forDuration(IJobCache, String, int, Instant, Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds one.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link CacheTicket#forDuration(IJobCache, String, int, Instant,
   * Duration)}
   */
  @Test
  @DisplayName(
      "Test forDuration(IJobCache, String, int, Instant, Duration); when ofSeconds one; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CacheTicket CacheTicket.forDuration(IJobCache, String, int, Instant, Duration)"
  })
  void testForDuration_whenOfSecondsOne_thenReturnKey() {
    // Arrange and Act
    CacheTicket actualForDurationResult =
        CacheTicket.forDuration(
            mock(IJobCache.class),
            "Key",
            1,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            Duration.ofSeconds(1L));

    // Assert
    assertEquals("Key", actualForDurationResult.key());
    Instant expiryResult = actualForDurationResult.expiry();
    assertEquals(0, expiryResult.getNano());
    assertEquals(1, actualForDurationResult.revision());
    assertEquals(1L, expiryResult.getEpochSecond());
    assertFalse(actualForDurationResult.missing());
    assertSame(Instant.EPOCH, actualForDurationResult.grantTime());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Instant CacheTicket.expiry()",
    "Instant CacheTicket.grantTime()",
    "String CacheTicket.key()",
    "boolean CacheTicket.missing()",
    "int CacheTicket.revision()"
  })
  void testGettersAndSetters() {
    // Arrange
    CacheTicket missingEntryTicketResult =
        CacheTicket.missingEntryTicket(
            "Key", 1, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualExpiryResult = missingEntryTicketResult.expiry();
    Instant actualGrantTimeResult = missingEntryTicketResult.grantTime();
    String actualKeyResult = missingEntryTicketResult.key();
    boolean actualMissingResult = missingEntryTicketResult.missing();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals(1, missingEntryTicketResult.revision());
    assertTrue(actualMissingResult);
    assertSame(Instant.EPOCH, actualGrantTimeResult);
    assertSame(Instant.MAX, actualExpiryResult);
  }

  /**
   * Test {@link CacheTicket#superseded()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CacheTicket#superseded()}
   */
  @Test
  @DisplayName("Test superseded(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheTicket.superseded()"})
  void testSuperseded_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        CacheTicket.missingEntryTicket(
                "Key",
                1,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .superseded());
  }

  /**
   * Test {@link CacheTicket#superseded()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CacheTicket#superseded()}
   */
  @Test
  @DisplayName("Test superseded(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheTicket.superseded()"})
  void testSuperseded_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        CacheTicket.supersededTicket(
                "Key",
                1,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .superseded());
  }
}

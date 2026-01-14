package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileStatDiffblueTest {
  /**
   * Test {@link FileStat#FileStat(String, String, FileType, long, Instant, Instant)}.
   *
   * <p>Method under test: {@link FileStat#FileStat(String, String, FileType, long, Instant,
   * Instant)}
   */
  @Test
  @DisplayName("Test new FileStat(String, String, FileType, long, Instant, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStat.<init>(String, String, FileType, long, Instant, Instant)"})
  void testNewFileStat() {
    // Arrange and Act
    FileStat actualFileStat =
        new FileStat(
            "Storage Path",
            "foo.txt",
            FileType.FILE,
            3L,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("Storage Path", actualFileStat.storagePath);
    assertEquals("foo.txt", actualFileStat.fileName);
    Instant instant = actualFileStat.atime;
    assertEquals(0, instant.getNano());
    Instant instant2 = actualFileStat.mtime;
    assertEquals(0, instant2.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(0L, instant2.getEpochSecond());
    assertEquals(3L, actualFileStat.size);
    assertEquals(FileType.FILE, actualFileStat.fileType);
  }
}

package org.finos.tracdap.common.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class FileStatDiffblueTest {
  /**
   * Method under test:
   * {@link FileStat#FileStat(String, String, FileType, long, Instant, Instant)}
   */
  @Test
  void testNewFileStat() {
    // Arrange
    Instant mtime = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    FileStat actualFileStat = new FileStat("Storage Path", "foo.txt", FileType.FILE, 3L, mtime,
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

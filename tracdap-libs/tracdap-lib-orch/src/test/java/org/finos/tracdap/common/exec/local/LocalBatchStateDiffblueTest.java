package org.finos.tracdap.common.exec.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalBatchStateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LocalBatchState#LocalBatchState(String, List, long)}
   *   <li>{@link LocalBatchState#getBatchDir()}
   *   <li>{@link LocalBatchState#getPid()}
   *   <li>{@link LocalBatchState#getVolumes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalBatchState.<init>(String, List, long)", "String LocalBatchState.getBatchDir()",
      "long LocalBatchState.getPid()", "List LocalBatchState.getVolumes()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> volumes = new ArrayList<>();

    // Act
    LocalBatchState actualLocalBatchState = new LocalBatchState("Batch Dir", volumes, 1L);
    String actualBatchDir = actualLocalBatchState.getBatchDir();
    long actualPid = actualLocalBatchState.getPid();
    List<String> actualVolumes = actualLocalBatchState.getVolumes();

    // Assert
    assertEquals("Batch Dir", actualBatchDir);
    assertEquals(1L, actualPid);
    assertTrue(actualVolumes.isEmpty());
    assertSame(volumes, actualVolumes);
  }

  /**
   * Test {@link LocalBatchState#LocalBatchState(String)}.
   * <p>
   * Method under test: {@link LocalBatchState#LocalBatchState(String)}
   */
  @Test
  @DisplayName("Test new LocalBatchState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LocalBatchState.<init>(String)"})
  void testNewLocalBatchState() {
    // Arrange and Act
    LocalBatchState actualLocalBatchState = new LocalBatchState("Batch Dir");

    // Assert
    assertEquals("Batch Dir", actualLocalBatchState.getBatchDir());
    assertEquals(0L, actualLocalBatchState.getPid());
    assertTrue(actualLocalBatchState.getVolumes().isEmpty());
  }

  /**
   * Test {@link LocalBatchState#withVolume(String)}.
   * <p>
   * Method under test: {@link LocalBatchState#withVolume(String)}
   */
  @Test
  @DisplayName("Test withVolume(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalBatchState LocalBatchState.withVolume(String)"})
  void testWithVolume() {
    // Arrange and Act
    LocalBatchState actualWithVolumeResult = (new LocalBatchState("Batch Dir")).withVolume("New Volume");

    // Assert
    assertEquals("Batch Dir", actualWithVolumeResult.getBatchDir());
    List<String> volumes = actualWithVolumeResult.getVolumes();
    assertEquals(1, volumes.size());
    assertEquals("New Volume", volumes.get(0));
    assertEquals(0L, actualWithVolumeResult.getPid());
  }

  /**
   * Test {@link LocalBatchState#withPid(long)}.
   * <p>
   * Method under test: {@link LocalBatchState#withPid(long)}
   */
  @Test
  @DisplayName("Test withPid(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalBatchState LocalBatchState.withPid(long)"})
  void testWithPid() {
    // Arrange and Act
    LocalBatchState actualWithPidResult = (new LocalBatchState("Batch Dir")).withPid(1L);

    // Assert
    assertEquals("Batch Dir", actualWithPidResult.getBatchDir());
    assertEquals(1L, actualWithPidResult.getPid());
    assertTrue(actualWithPidResult.getVolumes().isEmpty());
  }
}

package org.finos.tracdap.common.exec.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LocalBatchStateDiffblueTest {
  /**
   * Method under test: {@link LocalBatchState#withVolume(String)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link LocalBatchState#LocalBatchState(String, List, long)}
   *   <li>{@link LocalBatchState#getBatchDir()}
   *   <li>{@link LocalBatchState#getPid()}
   *   <li>{@link LocalBatchState#getVolumes()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link LocalBatchState#withPid(long)}
   */
  @Test
  void testWithPid() {
    // Arrange and Act
    LocalBatchState actualWithPidResult = (new LocalBatchState("Batch Dir")).withPid(1L);

    // Assert
    assertEquals("Batch Dir", actualWithPidResult.getBatchDir());
    assertEquals(1L, actualWithPidResult.getPid());
    assertTrue(actualWithPidResult.getVolumes().isEmpty());
  }

  /**
   * Method under test: {@link LocalBatchState#LocalBatchState(String)}
   */
  @Test
  void testNewLocalBatchState() {
    // Arrange and Act
    LocalBatchState actualLocalBatchState = new LocalBatchState("Batch Dir");

    // Assert
    assertEquals("Batch Dir", actualLocalBatchState.getBatchDir());
    assertEquals(0L, actualLocalBatchState.getPid());
    assertTrue(actualLocalBatchState.getVolumes().isEmpty());
  }
}

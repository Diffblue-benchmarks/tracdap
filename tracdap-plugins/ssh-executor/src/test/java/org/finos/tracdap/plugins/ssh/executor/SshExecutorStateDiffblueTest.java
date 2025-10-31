package org.finos.tracdap.plugins.ssh.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SshExecutorStateDiffblueTest {
  /**
   * Test {@link SshExecutorState#SshExecutorState(String, int, String, String)}.
   * <p>
   * Method under test: {@link SshExecutorState#SshExecutorState(String, int, String, String)}
   */
  @Test
  @DisplayName("Test new SshExecutorState(String, int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SshExecutorState.<init>(String, int, String, String)"})
  void testNewSshExecutorState() {
    // Arrange and Act
    SshExecutorState actualSshExecutorState = new SshExecutorState("0123456789ABCDEF", 8080, "0123456789ABCDEF",
        "0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualSshExecutorState.getBatchDir());
    assertEquals("0123456789ABCDEF", actualSshExecutorState.getBatchUser());
    assertEquals("0123456789ABCDEF", actualSshExecutorState.getRemoteHost());
    assertEquals(0L, actualSshExecutorState.getPid());
    assertEquals(8080, actualSshExecutorState.getRemotePort());
    assertTrue(actualSshExecutorState.getVolumes().isEmpty());
  }

  /**
   * Test {@link SshExecutorState#withVolume(String)}.
   * <p>
   * Method under test: {@link SshExecutorState#withVolume(String)}
   */
  @Test
  @DisplayName("Test withVolume(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SshExecutorState SshExecutorState.withVolume(String)"})
  void testWithVolume() {
    // Arrange and Act
    SshExecutorState actualWithVolumeResult = (new SshExecutorState("0123456789ABCDEF", 8080, "0123456789ABCDEF",
        "0123456789ABCDEF")).withVolume("0123456789ABCDEF");

    // Assert
    List<String> volumes = actualWithVolumeResult.getVolumes();
    assertEquals(1, volumes.size());
    assertEquals("0123456789ABCDEF", volumes.get(0));
    assertEquals("0123456789ABCDEF", actualWithVolumeResult.getBatchDir());
    assertEquals("0123456789ABCDEF", actualWithVolumeResult.getBatchUser());
    assertEquals("0123456789ABCDEF", actualWithVolumeResult.getRemoteHost());
    assertEquals(0L, actualWithVolumeResult.getPid());
    assertEquals(8080, actualWithVolumeResult.getRemotePort());
  }

  /**
   * Test {@link SshExecutorState#withPid(long)}.
   * <p>
   * Method under test: {@link SshExecutorState#withPid(long)}
   */
  @Test
  @DisplayName("Test withPid(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SshExecutorState SshExecutorState.withPid(long)"})
  void testWithPid() {
    // Arrange and Act
    SshExecutorState actualWithPidResult = (new SshExecutorState("0123456789ABCDEF", 8080, "0123456789ABCDEF",
        "0123456789ABCDEF")).withPid(1L);

    // Assert
    assertEquals("0123456789ABCDEF", actualWithPidResult.getBatchDir());
    assertEquals("0123456789ABCDEF", actualWithPidResult.getBatchUser());
    assertEquals("0123456789ABCDEF", actualWithPidResult.getRemoteHost());
    assertEquals(1L, actualWithPidResult.getPid());
    assertEquals(8080, actualWithPidResult.getRemotePort());
    assertTrue(actualWithPidResult.getVolumes().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SshExecutorState#getBatchDir()}
   *   <li>{@link SshExecutorState#getBatchUser()}
   *   <li>{@link SshExecutorState#getPid()}
   *   <li>{@link SshExecutorState#getRemoteHost()}
   *   <li>{@link SshExecutorState#getRemotePort()}
   *   <li>{@link SshExecutorState#getVolumes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SshExecutorState.getBatchDir()", "String SshExecutorState.getBatchUser()",
      "long SshExecutorState.getPid()", "String SshExecutorState.getRemoteHost()",
      "int SshExecutorState.getRemotePort()", "List SshExecutorState.getVolumes()"})
  void testGettersAndSetters() {
    // Arrange
    SshExecutorState sshExecutorState = new SshExecutorState("0123456789ABCDEF", 8080, "0123456789ABCDEF",
        "0123456789ABCDEF");

    // Act
    String actualBatchDir = sshExecutorState.getBatchDir();
    String actualBatchUser = sshExecutorState.getBatchUser();
    long actualPid = sshExecutorState.getPid();
    String actualRemoteHost = sshExecutorState.getRemoteHost();
    int actualRemotePort = sshExecutorState.getRemotePort();

    // Assert
    assertEquals("0123456789ABCDEF", actualBatchDir);
    assertEquals("0123456789ABCDEF", actualBatchUser);
    assertEquals("0123456789ABCDEF", actualRemoteHost);
    assertEquals(0L, actualPid);
    assertEquals(8080, actualRemotePort);
    assertTrue(sshExecutorState.getVolumes().isEmpty());
  }
}

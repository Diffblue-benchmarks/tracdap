package org.finos.tracdap.plugins.ssh.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SshExecutorPluginDiffblueTest {
  /**
   * Test {@link SshExecutorPlugin#pluginName()}.
   *
   * <p>Method under test: {@link SshExecutorPlugin#pluginName()}
   */
  @Test
  @DisplayName("Test pluginName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SshExecutorPlugin.pluginName()"})
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("SSH_EXECUTOR", new SshExecutorPlugin().pluginName());
  }

  /**
   * Test {@link SshExecutorPlugin#serviceInfo()}.
   *
   * <p>Method under test: {@link SshExecutorPlugin#serviceInfo()}
   */
  @Test
  @DisplayName("Test serviceInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SshExecutorPlugin.serviceInfo()"})
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = new SshExecutorPlugin().serviceInfo();

    // Assert
    assertEquals(1, actualServiceInfoResult.size());
    PluginServiceInfo getResult = actualServiceInfoResult.get(0);
    assertEquals("SSH_EXECUTOR", getResult.serviceName());
    List<String> protocolsResult = getResult.protocols();
    assertEquals(1, protocolsResult.size());
    assertEquals("ssh", protocolsResult.get(0));
    Class<IBatchExecutor> expectedServiceClassResult = IBatchExecutor.class;
    assertEquals(expectedServiceClassResult, getResult.serviceClass());
  }
}

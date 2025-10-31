package org.finos.tracdap.plugins.ssh.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.finos.tracdap.common.exec.IBatchExecutor;
import org.finos.tracdap.common.plugin.PluginServiceInfo;
import org.junit.jupiter.api.Test;

class SshExecutorPluginDiffblueTest {
  /**
   * Method under test: {@link SshExecutorPlugin#pluginName()}
   */
  @Test
  void testPluginName() {
    // Arrange, Act and Assert
    assertEquals("SSH_EXECUTOR", (new SshExecutorPlugin()).pluginName());
  }

  /**
   * Method under test: {@link SshExecutorPlugin#serviceInfo()}
   */
  @Test
  void testServiceInfo() {
    // Arrange and Act
    List<PluginServiceInfo> actualServiceInfoResult = (new SshExecutorPlugin()).serviceInfo();

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

package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PluginServiceInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginServiceInfo#PluginServiceInfo(Class, String, List)}
   *   <li>{@link PluginServiceInfo#protocols()}
   *   <li>{@link PluginServiceInfo#serviceClass()}
   *   <li>{@link PluginServiceInfo#serviceName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Class<Object> serviceClass = Object.class;
    ArrayList<String> protocols = new ArrayList<>();

    // Act
    PluginServiceInfo actualPluginServiceInfo = new PluginServiceInfo(serviceClass, "Service Name", protocols);
    List<String> actualProtocolsResult = actualPluginServiceInfo.protocols();
    Class<?> actualServiceClassResult = actualPluginServiceInfo.serviceClass();

    // Assert
    assertEquals("Service Name", actualPluginServiceInfo.serviceName());
    assertTrue(actualProtocolsResult.isEmpty());
    Class<Object> expectedServiceClassResult = Object.class;
    assertEquals(expectedServiceClassResult, actualServiceClassResult);
    assertSame(protocols, actualProtocolsResult);
    assertSame(serviceClass, actualServiceClassResult);
  }
}

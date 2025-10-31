package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PluginTypeDiffblueTest {
  /**
   * Method under test: {@link PluginType#forClass(Class, String)}
   */
  @Test
  void testForClass() {
    // Arrange
    Class<Object> pluginClass = Object.class;

    // Act
    PluginType actualForClassResult = PluginType.forClass(pluginClass, "Service Type");

    // Assert
    assertEquals("Service Type", actualForClassResult.serviceType());
    assertEquals("java.lang.Object", actualForClassResult.serviceClassName());
    assertFalse(actualForClassResult.isConfigPlugin());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginType#PluginType(String, String, boolean)}
   *   <li>{@link PluginType#isConfigPlugin()}
   *   <li>{@link PluginType#serviceClassName()}
   *   <li>{@link PluginType#serviceType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PluginType actualPluginType = new PluginType("Service Class Name", "Service Type", true);
    boolean actualIsConfigPluginResult = actualPluginType.isConfigPlugin();
    String actualServiceClassNameResult = actualPluginType.serviceClassName();

    // Assert
    assertEquals("Service Class Name", actualServiceClassNameResult);
    assertEquals("Service Type", actualPluginType.serviceType());
    assertTrue(actualIsConfigPluginResult);
  }
}

package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginTypeDiffblueTest {
  /**
   * Test {@link PluginType#forClass(Class, String)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Service Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginType#forClass(Class, String)}
   */
  @Test
  @DisplayName("Test forClass(Class, String); when 'java.lang.Object'; then return 'Service Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PluginType PluginType.forClass(Class, String)"})
  void testForClass_whenJavaLangObject_thenReturnServiceType() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PluginType#PluginType(String, String, boolean)}
   *   <li>{@link PluginType#isConfigPlugin()}
   *   <li>{@link PluginType#serviceClassName()}
   *   <li>{@link PluginType#serviceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PluginType.<init>(String, String, boolean)", "boolean PluginType.isConfigPlugin()",
      "String PluginType.serviceClassName()", "String PluginType.serviceType()"})
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

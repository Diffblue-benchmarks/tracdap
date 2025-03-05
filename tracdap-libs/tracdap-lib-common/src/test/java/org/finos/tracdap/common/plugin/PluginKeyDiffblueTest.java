package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginKeyDiffblueTest {
  /**
   * Test {@link PluginKey#PluginKey(Class, String)}.
   * <p>
   * Method under test: {@link PluginKey#PluginKey(Class, String)}
   */
  @Test
  @DisplayName("Test new PluginKey(Class, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PluginKey.<init>(Class, String)"})
  void testNewPluginKey() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertEquals("protocol", (new PluginKey(service, "Protocol")).protocol());
  }

  /**
   * Test {@link PluginKey#serviceClass()}.
   * <p>
   * Method under test: {@link PluginKey#serviceClass()}
   */
  @Test
  @DisplayName("Test serviceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class PluginKey.serviceClass()"})
  void testServiceClass() {
    // Arrange
    Class<Object> service = Object.class;

    // Act
    Class<?> actualServiceClassResult = (new PluginKey(service, "Protocol")).serviceClass();

    // Assert
    Class<Object> expectedServiceClassResult = Object.class;
    assertEquals(expectedServiceClassResult, actualServiceClassResult);
  }

  /**
   * Test {@link PluginKey#protocol()}.
   * <p>
   * Method under test: {@link PluginKey#protocol()}
   */
  @Test
  @DisplayName("Test protocol()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PluginKey.protocol()"})
  void testProtocol() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertEquals("protocol", (new PluginKey(service, "Protocol")).protocol());
  }
}

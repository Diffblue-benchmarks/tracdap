package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class PluginKeyDiffblueTest {
  /**
   * Method under test: {@link PluginKey#serviceClass()}
   */
  @Test
  void testServiceClass() {
    // Arrange
    Class<Object> service = Object.class;

    // Act
    Class<?> actualServiceClassResult = (new PluginKey(service, "Protocol")).serviceClass();

    // Assert
    Class<Object> expectedServiceClassResult = Object.class;
    assertEquals(expectedServiceClassResult, actualServiceClassResult);
    assertSame(service, actualServiceClassResult);
  }

  /**
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<PluginKey> service = PluginKey.class;
    PluginKey pluginKey = new PluginKey(service, "Protocol");
    Class<Object> service2 = Object.class;

    // Act and Assert
    assertNotEquals(pluginKey, new PluginKey(service2, "Protocol"));
  }

  /**
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Class<Object> service = Object.class;
    PluginKey pluginKey = new PluginKey(service, "org.finos.tracdap.common.plugin.PluginKey");
    Class<Object> service2 = Object.class;

    // Act and Assert
    assertNotEquals(pluginKey, new PluginKey(service2, "Protocol"));
  }

  /**
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertNotEquals(new PluginKey(service, "Protocol"), null);
  }

  /**
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertNotEquals(new PluginKey(service, "Protocol"), "Different type to PluginKey");
  }

  /**
   * Method under test: {@link PluginKey#PluginKey(Class, String)}
   */
  @Test
  void testNewPluginKey() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertEquals("protocol", (new PluginKey(service, "Protocol")).protocol());
  }

  /**
   * Method under test: {@link PluginKey#protocol()}
   */
  @Test
  void testProtocol() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertEquals("protocol", (new PluginKey(service, "Protocol")).protocol());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginKey#equals(Object)}
   *   <li>{@link PluginKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Class<Object> service = Object.class;
    PluginKey pluginKey = new PluginKey(service, "Protocol");
    Class<Object> service2 = Object.class;
    PluginKey pluginKey2 = new PluginKey(service2, "Protocol");

    // Act and Assert
    assertEquals(pluginKey, pluginKey2);
    int expectedHashCodeResult = pluginKey.hashCode();
    assertEquals(expectedHashCodeResult, pluginKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PluginKey#equals(Object)}
   *   <li>{@link PluginKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Class<Object> service = Object.class;
    PluginKey pluginKey = new PluginKey(service, "Protocol");

    // Act and Assert
    assertEquals(pluginKey, pluginKey);
    int expectedHashCodeResult = pluginKey.hashCode();
    assertEquals(expectedHashCodeResult, pluginKey.hashCode());
  }
}

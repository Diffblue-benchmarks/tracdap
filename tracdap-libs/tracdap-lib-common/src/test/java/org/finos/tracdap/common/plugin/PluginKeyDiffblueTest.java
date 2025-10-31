package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

  /**
   * Test {@link PluginKey#equals(Object)}, and {@link PluginKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PluginKey#equals(Object)}
   *   <li>{@link PluginKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
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
   * Test {@link PluginKey#equals(Object)}, and {@link PluginKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PluginKey#equals(Object)}
   *   <li>{@link PluginKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Class<Object> service = Object.class;
    PluginKey pluginKey = new PluginKey(service, "Protocol");

    // Act and Assert
    assertEquals(pluginKey, pluginKey);
    int expectedHashCodeResult = pluginKey.hashCode();
    assertEquals(expectedHashCodeResult, pluginKey.hashCode());
  }

  /**
   * Test {@link PluginKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<PluginKey> service = PluginKey.class;
    PluginKey pluginKey = new PluginKey(service, "Protocol");
    Class<Object> service2 = Object.class;

    // Act and Assert
    assertNotEquals(pluginKey, new PluginKey(service2, "Protocol"));
  }

  /**
   * Test {@link PluginKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Class<Object> service = Object.class;
    PluginKey pluginKey = new PluginKey(service, "org.finos.tracdap.common.plugin.PluginKey");
    Class<Object> service2 = Object.class;

    // Act and Assert
    assertNotEquals(pluginKey, new PluginKey(service2, "Protocol"));
  }

  /**
   * Test {@link PluginKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertNotEquals(new PluginKey(service, "Protocol"), null);
  }

  /**
   * Test {@link PluginKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PluginKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PluginKey.equals(Object)", "int PluginKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> service = Object.class;

    // Act and Assert
    assertNotEquals(new PluginKey(service, "Protocol"), "Different type to PluginKey");
  }
}
